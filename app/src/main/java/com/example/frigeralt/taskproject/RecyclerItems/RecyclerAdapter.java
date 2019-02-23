package com.example.frigeralt.taskproject.RecyclerItems;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frigeralt.taskproject.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Article> articles = new ArrayList<>();

    public RecyclerAdapter() {
    }

    public RecyclerAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.image.setImageResource(article.getImageID());
        holder.titleView.setText(article.getTitle());
        holder.descView.setText(article.getDescription());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView titleView, descView;


        MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image_view);
            titleView = itemView.findViewById(R.id.item_title_view);
            descView = itemView.findViewById(R.id.item_description_view);
        }
    }
}
