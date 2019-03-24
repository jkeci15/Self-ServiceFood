package com.example.self_servicefood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import model.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    private OnItemClick onItemClick;
    private Context context;
    private List<Item> objects;
    private int resource;

    public ItemAdapter(OnItemClick onItemClick, Context context, List<Item> objects, int resource) {
        this.onItemClick = onItemClick;
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ItemHolder(LayoutInflater.from(context).inflate(resource, parent, false), onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        Item item = objects.get(position);
        holder.textView.setText(item.getId());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public Item getItem(int position)
    {
        return objects.get(position);
    }

    public void remove(Item notes)
    {
        objects.remove(notes);
        notifyDataSetChanged();
    }

}
