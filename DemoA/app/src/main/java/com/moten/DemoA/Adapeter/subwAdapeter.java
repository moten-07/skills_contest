package com.moten.DemoA.Adapeter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.type.Subway;

import java.util.List;

public class subwAdapeter extends RecyclerView.Adapter<subwAdapeter.ViewHolder> {
    // 地铁概览适配器
    Context context;
    List<Subway> list;
    public subwAdapeter(Context context, List<Subway> list){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_subway,null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","subway");
                intent.putExtra("title",holder.subwayTitle.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subway subway = list.get(position);
        holder.subwayTitle.setText(subway.getSubwayTitle());
        holder.the_subway.setText(subway.the_subway);
        holder.subway_next.setText("下一站："+subway.subway_next);
        holder.subway_time.setText("预计到达时间："+subway.subway_time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView subwayTitle,the_subway,subway_next, subway_time;      // 到达时间

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subwayTitle = itemView.findViewById(R.id.subway_title);
            the_subway = itemView.findViewById(R.id.the_subway);
            subway_next= itemView.findViewById(R.id.subway_next);
            subway_time = itemView.findViewById(R.id.subway_time);
        }
    }
}
