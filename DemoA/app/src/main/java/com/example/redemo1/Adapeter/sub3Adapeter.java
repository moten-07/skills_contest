package com.example.redemo1.Adapeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.redemo1.R;

public class sub3Adapeter extends BaseAdapter {
    // 地铁总览适配器（地铁好烦）
    String []list;
    Context context;

    public sub3Adapeter(String []list,Context context){
        this.list=list;
        this.context=context;
    }
    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_subs,null);
        }
        TextView textView = convertView.findViewById(R.id.textview3);
        textView.setText(list[position]);
        return convertView;
    }
}
