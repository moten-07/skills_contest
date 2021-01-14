package com.example.redemo1.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.redemo1.MainActivity;
import com.example.redemo1.R;
import com.example.redemo1.type.Subway;

import java.util.List;

public class subwAdapeter extends BaseAdapter {
    Context context;
    List<Subway> list;
    public subwAdapeter(Context context, List<Subway> list){
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
        if(convertView == null){
            holder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_subway,null);
            holder.subwayTitle=convertView.findViewById(R.id.subway_title);
            holder.the_subway=convertView.findViewById(R.id.the_subway);
            holder.subway_next=convertView.findViewById(R.id.subway_next);
            holder.subway_time=convertView.findViewById(R.id.subway_time);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Subway subway=list.get(position);
        holder.subwayTitle.setText(subway.subwayTitle);
        holder.the_subway.setText(subway.the_subway);
        holder.subway_next.setText(subway.subway_next);
        holder.subway_time.setText(subway.subway_time);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","subway");
                intent.putExtra("title",holder.subwayTitle.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder{
        TextView subwayTitle;
        TextView the_subway;
        TextView subway_next;
        TextView subway_time;      // 到达时间
    }
}
