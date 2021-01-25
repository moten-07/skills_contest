package com.moten.DemoA.aboutIntent;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Indexe extends RecyclerView.ItemDecoration{
    // 设置图标的间隔
    int space;
    public Indexe(int space){
        this.space=space;
    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=space;
        outRect.left=space;
        outRect.right=space;
        outRect.top=space;
    }
}
