package com.moten.DemoA.Adapeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moten.DemoA.R;
import com.moten.DemoA.type.Orders;

import java.util.List;

public class ordsAdapeter extends RecyclerView.Adapter<ordsAdapeter.ViewHolder> {
    Context context;
    List<Orders> list;

    public ordsAdapeter(Context context,List<Orders> list){
        this.context=context;
        this.list =list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_order,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Orders o = list.get(position);
        holder.order_id.setText(o.getOrderId());
        holder.order_type.setText(o.getOrderType());
        holder.order_date.setText(o.getOrderDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView order_id,order_type,order_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_id = itemView.findViewById(R.id.order_id);
            order_type = itemView.findViewById(R.id.order_type);
            order_date = itemView.findViewById(R.id.order_date);
        }
    }
}
