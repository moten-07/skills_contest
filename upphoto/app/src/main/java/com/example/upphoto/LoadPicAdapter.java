package com.example.upphoto;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoadPicAdapter extends RecyclerView .Adapter<LoadPicAdapter.ViewHolder>{
    Context context;
    List<LoadFileVo> fileList = null;
    View view;
    int picNum = 8;         // 列表图片个数最大值

    public LoadPicAdapter(Context context,List<LoadFileVo> fileList){
        this.context = context;
        this.fileList = fileList;
    }
    public LoadPicAdapter(Context context,List<LoadFileVo> fileList,int picNum){
        this.context = context;
        this.fileList = fileList;
        this.picNum = picNum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.load_item_pic,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0 && fileList.get(position).getBitmap()==null){
            holder.ivPic.setImageResource(R.mipmap.add);
            holder.ivPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.click(v,position);
                }
            });
            holder.ivDel.setVisibility(View.INVISIBLE);
            holder.bg_progressbar.setVisibility(View.GONE);
        }else{
//            Uri uri = Uri.parse(fileList.get(position).getFile().getPath());
//            holder.ivPic.setImageURI(uri);

            holder.ivPic.setImageBitmap(fileList.get(position).getBitmap());
            // 使用压缩后的图片进行填充到页面上
            holder.ivDel.setVisibility(View.VISIBLE);
            holder.bg_progressbar.setVisibility(View.VISIBLE);
            holder.bg_progressbar.setProgress(fileList.get(position).pg);
        }
        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileList.get(position).isUpload()){
                    Toast.makeText(context,"该图片已上传！",Toast.LENGTH_SHORT).show();
                }else{
                    fileList.remove(position);
                    if(fileList.size() == picNum-1 && fileList.get(0).getBitmap()!=null){
                        fileList.add(0,new LoadFileVo());
                    }// 如果数量达到最大数时，前面的加号去掉，再减去时，则添加前面的加号
                    notifyDataSetChanged();
                    if (listener!=null){
                        listener.del(v);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPic,ivDel;
        ProgressBar bg_progressbar;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ivPic = itemView.findViewById(R.id.ivPic);
            ivDel = itemView.findViewById(R.id.ivDel);
            bg_progressbar = itemView.findViewById(R.id.bg_progressbar);
        }
    }

    public interface OnItemClickListener{
        void click(View view,int positon);
        void del(View view);
    }
    OnItemClickListener listener;
    public void setListener(OnItemClickListener listener){
        this.listener=listener;
    }

}
