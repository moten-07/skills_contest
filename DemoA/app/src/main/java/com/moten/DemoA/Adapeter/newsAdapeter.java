package com.moten.DemoA.Adapeter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moten.DemoA.ActivityHome;
import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.func.NewActivity;
import com.moten.DemoA.func.TNLJ;

import java.util.List;

public class newsAdapeter extends RecyclerView.Adapter<newsAdapeter.ViewHolder>{
    // 新闻适配器
    List<TNLJ.Rows>list;
    Context context;
    Integer newsId;
    public newsAdapeter(Context context,List<TNLJ.Rows>list){
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
                Intent intent=new Intent(v.getContext(), NewActivity.class);
                intent.putExtra("title",holder.news_title.getText().toString());
                intent.putExtra("newsId",holder.newsId);
                intent.putExtra("news_content",holder.news_content.getText().toString());
                intent.putExtra("news_views_number",holder.news_views_number.getText().toString());
                intent.putExtra("news_date",holder.news_date.getText().toString());
                intent.putExtra("news_imgUrl",holder.imgUrl);
                intent.putExtra("news_like_number",holder.news_like_number.getText().toString());
                ((Activity)context).finish();
                v.getContext().startActivity(new Intent(v.getContext(), ActivityHome.class));
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TNLJ.Rows news = list.get(position);
        Glide.with(context)
                .load(new HttpHelp().getHearUri()+news.getImgUrl())
                .into( holder.news_icon);
        holder.news_title.setText( news.getTitle());
        holder.news_content.setText(news.getContent());
        holder.news_views_number.setText(news.getViewsNumber()+"");
        holder.news_like_number.setText(news.getLikeNumber()+"");
        holder.news_date.setText(news.getUpdateTime());
        holder.newsId = news.getId();
        holder.imgUrl = new HttpHelp().getHearUri()+news.getImgUrl();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView news_icon;
        TextView news_title,news_content,news_views_number,news_like_number,news_date;
        int newsId;
        String imgUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_icon = itemView.findViewById(R.id.news_icon);
            news_title = itemView.findViewById(R.id.news_title);
            news_content = itemView.findViewById(R.id.news_content);
            news_views_number = itemView.findViewById(R.id.news_views_number);
            news_like_number = itemView.findViewById(R.id.news_like_number);
            news_date = itemView.findViewById(R.id.news_date);
        }
    }

}
