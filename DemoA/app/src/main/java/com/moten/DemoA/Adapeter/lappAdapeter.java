package com.moten.DemoA.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;

import java.util.List;

public class lappAdapeter extends RecyclerView.Adapter<lappAdapeter.ViewHolder> {
    // 应用服务的适配器
    List <TAFJ.Rows>list;
    Context context;

    public lappAdapeter(Context context,List<TAFJ.Rows> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_lapps,null);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity.class);
                TAFJ.Rows app=list.get(holder.getAdapterPosition());
                intent.putExtra("type","littleApp");
                intent.putExtra("icon",app.getImgUrl());
                intent.putExtra("title",app.getServiceName());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TAFJ.Rows app=list.get(position);
        holder.textView.setText(app.getServiceName());
        if(!app.getServiceName().equals("更多服务")){
            Glide.with(context)
                    .load(new HttpHelp().getHearUri()+app.getImgUrl())
                    .into(holder.imageView);
        }else{
            holder.imageView.setImageResource(Integer.valueOf(app.getImgUrl()));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView) itemView;
            imageView=cardView.findViewById(R.id.lappicon);
            textView=cardView.findViewById(R.id.lapptitle);
        }
    }
}
