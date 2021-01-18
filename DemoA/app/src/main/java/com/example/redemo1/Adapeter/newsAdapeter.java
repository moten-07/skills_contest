package com.example.redemo1.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redemo1.MainActivity;
import com.example.redemo1.R;
import com.example.redemo1.type.news;

import java.util.List;

public class newsAdapeter extends BaseAdapter {
    // 新闻适配器
    List<news>list;
    Context context;
    public newsAdapeter(Context context,List<news>list){
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news,null);
            holder.news_icon = convertView.findViewById(R.id.news_icon);
            holder.news_title = convertView.findViewById(R.id.news_title);
            holder.news_content = convertView.findViewById(R.id.news_content);
            holder.news_number = convertView.findViewById(R.id.news_number);
            holder.news_date = convertView.findViewById(R.id.news_date);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        news news=list.get(position);
        holder.news_icon.setImageResource(news.getNews_icon());
        holder.news_title.setText(news.getNews_title());
        holder.news_content.setText(news.getNews_content());
        holder.news_number.setText(news.getNews_number());
        holder.news_date.setText(news.getNews_date());

        convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","news");
                intent.putExtra("where",holder.news_title.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView news_icon;
        TextView news_title,news_content,news_number,news_date;
    }

}
