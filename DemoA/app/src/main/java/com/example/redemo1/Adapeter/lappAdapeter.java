package com.example.redemo1.Adapeter;

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

import com.example.redemo1.type.LittleApp;
import com.example.redemo1.MainActivity;
import com.example.redemo1.R;

import java.util.List;

public class lappAdapeter extends RecyclerView.Adapter<lappAdapeter.ViewHolder> {
    // 应用服务的适配器
    List <LittleApp>list;
    Context context;

    public lappAdapeter(Context context,List<LittleApp> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view=LayoutInflater.from(context).inflate(R.layout.item_lapps,null);
        ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity.class);
                int position=holder.getAdapterPosition();
                LittleApp app=list.get(position);
                intent.putExtra("type","littleApp");
                intent.putExtra("icon",app.getImage());
                intent.putExtra("title",app.getTitle());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LittleApp app=list.get(position);
        holder.textView.setText(app.getTitle());
        holder.imageView.setImageResource(app.getImage());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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
