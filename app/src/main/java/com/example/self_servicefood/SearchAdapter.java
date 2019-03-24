package com.example.self_servicefood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import model.Business;

public class SearchAdapter extends RecyclerView.Adapter<SearchHolder> {

    private OnItemClick onItemClick;
    private Context context;
    private List<Business> objects;
    private int resource;

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new SearchHolder(LayoutInflater.from(context).inflate(resource, parent, false), onItemClick);

    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {

            Business business = objects.get(position);
            holder.textView.setText(business.getId());
    }


    public Business getItemint(int i) {
        return objects.get(i);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


}
