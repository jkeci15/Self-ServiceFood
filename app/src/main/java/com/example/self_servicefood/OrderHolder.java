package com.example.self_servicefood;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

private OnItemClick onItemClick;
public TextView textView;
private Button start,cancel,done;


    public OrderHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;

        start = itemView.findViewById(R.id.each_order_staff_confirm);
        cancel = itemView.findViewById(R.id.each_order_staff_cancel);
        done = itemView.findViewById(R.id.each_order_staff_done);

        start.setOnClickListener(this);
        cancel.setOnClickListener(this);
        done.setOnClickListener(this);

//        textView.setOnLongClickListener(this);
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
