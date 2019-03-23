package com.example.self_servicefood;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private OnItemClick onItemClick;
    public TextView textView,descView;
    public ImageView add,delete;


    public ItemHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;

        textView = itemView.findViewById(R.id.each_item_name);
        descView = itemView.findViewById(R.id.each_item_desc);
        add = itemView.findViewById(R.id.each_item_add);
        delete = itemView.findViewById(R.id.each_item_delete);


        add.setOnClickListener(this);
        delete.setOnClickListener(this);


        add.setOnLongClickListener(this);
        delete.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick.itemClick(view, getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View view) {
        return onItemClick.itemLongClick(view, getAdapterPosition());
    }
}