package com.moten.DemoA.Adapeter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TCJ;

import java.util.List;

public class commAdapeter extends RecyclerView.Adapter<commAdapeter.ViewHolder> {
    Context context;
    List<TCJ.Rows>list;
    public commAdapeter(Context context,List<TCJ.Rows>list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public commAdapeter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (context==null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment,null);
        holder = new ViewHolder(view);
        holder.user_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询用户信息，弹个窗
                Log.d("id",holder.userId+"");
//                UserOkhttp userOkhttp = new UserOkhttp();
//                userOkhttp.getUserInfo2(holder.userId,"",null);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull commAdapeter.ViewHolder holder, int position) {
        TCJ.Rows tr = list.get(position);
//        Log.d("tr",tr.toString());
        if (tr.userId!=null){
            holder.userId = tr.userId;
        }
        holder.user_name.setText((tr.nickName != null) ? tr.nickName : "");
        holder.user_comment.setText(tr.content);
        holder.comment_date.setText(tr.createTime);
        Glide.with(context)
                .load(new HttpHelp().getHearUri()+tr.avatar)
                .placeholder(R.mipmap.kls)
                .into(holder.user_icon);
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView user_icon;
        TextView user_name,user_comment,comment_date;
        int userId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_icon = itemView.findViewById(R.id.user_icon_c);
            user_name = itemView.findViewById(R.id.user_name_c);
            user_comment = itemView.findViewById(R.id.user_comment_c);
            comment_date = itemView.findViewById(R.id.comment_date_c);
        }
    }
}
