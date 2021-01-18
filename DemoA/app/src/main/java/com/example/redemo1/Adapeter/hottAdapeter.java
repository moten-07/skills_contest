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

public class hottAdapeter extends RecyclerView.Adapter<hottAdapeter.ViewHolder> {
    // 热门主题适配器
    List<Hot_theme> list;
    Context context;

    public hottAdapeter(Context context,List<Hot_theme> list){
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hott,null);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","news");
                intent.putExtra("where",holder.textView.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Hot_theme theme=list.get(position);
            holder.textView.setText(theme.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            textView=cardView.findViewById(R.id.hott_title);
        }
    }
}
