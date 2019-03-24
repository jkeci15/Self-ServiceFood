package com.example.self_servicefood;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderHolder> {

    private OnItemClick onItemClick;
    private Context context;
    private List<Order> objects;
    private int resource;

    public OrderAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Order> objects, OnItemClick onItemClick) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
        this.onItemClick = onItemClick;
    }
    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new OrderHolder(LayoutInflater.from(context).inflate(resource, parent, false), onItemClick);
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {

           Order notes = objects.get(position);
           holder.textView.setText(notes.getId());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public Order getItem(int position)
    {
        return objects.get(position);
    }

    public void remove(Order notes)
    {
        objects.remove(notes);
        notifyDataSetChanged();
    }

}
