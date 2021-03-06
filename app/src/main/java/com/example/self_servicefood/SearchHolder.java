package com.example.self_servicefood;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SearchHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private OnItemClick onItemClick;
    public TextView textView;

    public SearchHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        textView = itemView.findViewById(R.id.each_business_name);

        textView.setOnClickListener(this);

        textView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick.itemClick(view,getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View view) {
        return onItemClick.itemLongClick(view,getAdapterPosition());
    }
}
