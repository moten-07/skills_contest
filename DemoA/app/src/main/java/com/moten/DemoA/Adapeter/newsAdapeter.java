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

import com.bumptech.glide.Glide;
import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.func.TNLJ;

import java.util.List;

public class newsAdapeter extends RecyclerView.Adapter<newsAdapeter.ViewHolder>{
    // 新闻适配器
    List<TNLJ.Rows>list;
    Context context;
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
        TNLJ.Rows news = list.get(position);
        Glide.with(context)
                .load(new HttpHelp().getHearUri()+news.getImgUrl())
                .into( holder.news_icon);
        StringBuilder builder = new StringBuilder(news.getTitle());
        holder.news_title.setText(/*(builder.length()>15) ? builder.replace(15,builder.length(),"......") :*/ news.getTitle());
        StringBuilder builder1 = new StringBuilder(news.getContent());
        holder.news_content.setText(builder1/*.replace(20,builder1.length(),"......")*/);
        holder.news_views_number.setText(news.getViewsNumber()+"");
        holder.news_like_number.setText(news.getLikeNumber()+"");
        holder.news_date.setText(news.getUpdateTime());
        holder.news_date.setText(news.getUpdateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView news_icon;
        TextView news_title,news_content,news_views_number,news_like_number,news_date,news_type;

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
