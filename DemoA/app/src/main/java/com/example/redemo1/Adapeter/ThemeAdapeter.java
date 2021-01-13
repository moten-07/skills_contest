package com.example.redemo1.Adapeter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.redemo1.R;
import com.example.redemo1.type.Hot_theme;

import java.util.List;

public class ThemeAdapeter extends RecyclerView.Adapter<ThemeAdapeter.ViewHolder> {
    // 热门主题的适配器
    List<Hot_theme> list;
    Context context;
    @NonNull
    @Override
    public ThemeAdapeter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeAdapeter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
