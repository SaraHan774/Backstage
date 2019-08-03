package com.gahee.backstage.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.gahee.backstage.R;
import com.gahee.backstage.data.models.ItemInfo;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{

    private ArrayList<ItemInfo> mItemInfoArrayList;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, ArrayList<ItemInfo> itemInfoArrayList){
        this.mContext = context;
        this.mItemInfoArrayList = itemInfoArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_holder_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.linearLayout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.in_from_right));

        ItemInfo itemInfo = mItemInfoArrayList.get(position);

        holder.tv_title.setText(itemInfo.getmItemTitle());
        holder.tv_pubDate.setText(itemInfo.getmItemPubDate());
        holder.tv_summary.setText(itemInfo.getmItemSummary());
        holder.tv_author.setText(itemInfo.getmItemAuthor());

        String itemLink = itemInfo.getmItemLink() != null ? itemInfo.getmItemLink() : "";
        String audioLink = itemInfo.getmEnclosure() != null ? itemInfo.getmEnclosure().getAudioUrl() : "";
        String thumbnailUrl = itemInfo.getmThumbnail() != null ? itemInfo.getmThumbnail().getThumbnailUrl() : "";

        Glide.with(mContext).load(thumbnailUrl)
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(itemLink));
            mContext.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return mItemInfoArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView tv_title;
        TextView tv_author;
        TextView tv_pubDate;
        TextView tv_summary;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.view_holder_container);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_pubDate = itemView.findViewById(R.id.tv_pubdate);
            tv_summary = itemView.findViewById(R.id.tv_summary);
            imageView = itemView.findViewById(R.id.img_main_image);
        }
    }

}
