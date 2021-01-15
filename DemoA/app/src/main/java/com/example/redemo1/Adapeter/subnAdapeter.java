package com.example.redemo1.Adapeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redemo1.R;
import com.example.redemo1.type.One_subway;

import java.util.List;

public class subnAdapeter extends RecyclerView.Adapter<subnAdapeter.ViewHolder> {
    public Context context;
    public List<One_subway> list;
    public subnAdapeter(Context context, List<One_subway> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context==null){
            context=parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_onesub,null);
        subnAdapeter.ViewHolder holder=new subnAdapeter.ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"你点击了"+holder.textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        One_subway app=list.get(position);
        holder.textView.setText(app.getThisName());
        holder.imageView.setImageResource(app.getThisimg());
        holder.poin1.setBackgroundResource(app.getLastimg());
        holder.poin2.setBackgroundResource(app.getNextimg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View poin1,poin2;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poin1=itemView.findViewById(R.id.poin1);
            poin2=itemView.findViewById(R.id.poin2);
            imageView=itemView.findViewById(R.id.subp);
            textView=itemView.findViewById(R.id.subn);
        }
    }
}
