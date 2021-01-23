package com.moten.DemoA.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.type.news;

import java.util.List;

public class newsAdapeter extends RecyclerView.Adapter<newsAdapeter.ViewHolder>{
    // 新闻适配器
    List<news>list;
    Context context;
    public newsAdapeter(Context context,List<news>list){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_newone,null);
        holder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","news");
                intent.putExtra("where",holder.news_title.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        news news = list.get(position);
        holder.news_icon.setImageResource(news.getNews_icon());
        holder.news_title.setText(news.getNews_title());
        holder.news_content.setText(news.getNews_content());
        holder.news_number.setText(news.getNews_number());
        holder.news_date.setText(news.news_date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView news_icon;
        TextView news_title,news_content,news_number,news_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_icon = itemView.findViewById(R.id.news_icon);
            news_title = itemView.findViewById(R.id.news_title);
            news_content = itemView.findViewById(R.id.news_content);
            news_number = itemView.findViewById(R.id.news_number);
            news_date = itemView.findViewById(R.id.news_date);
        }
    }

}
