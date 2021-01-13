package com.example.redemo1.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.redemo1.MainActivity;
import com.example.redemo1.R;
import com.example.redemo1.type.Hot_theme;

import java.util.List;

public class ThemeAdapeter extends RecyclerView.Adapter<ThemeAdapeter.ViewHolder> {
    // 热门主题的适配器
    List<Hot_theme> list;
    Context context;
    public ThemeAdapeter(List<Hot_theme> list,Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ThemeAdapeter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.item_hottheme,null);
        ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity.class);
                int position=holder.getAdapterPosition();
                Hot_theme theme=list.get(position);
                intent.putExtra("type","littleApp");
                intent.putExtra("title",theme.getTitle());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeAdapeter.ViewHolder holder, int position) {
        Hot_theme theme=list.get(position);
        holder.title.setText(theme.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            title = cardView.findViewById(R.id.hottheme_title);
        }
    }
}
