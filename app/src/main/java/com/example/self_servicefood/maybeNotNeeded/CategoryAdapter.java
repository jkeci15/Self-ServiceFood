//package com.example.self_servicefood;
//
//import android.content.Context;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import java.util.List;
//
//import model.Category;
//
//
//class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
//
//    private OnItemClick onItemClick;
//    private Context context;
//    private List<Category> objects;
//    private int resource;
//
//    public CategoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Category> objects, OnItemClick onItemClick) {
//        this.context = context;
//        this.objects = objects;
//        this.resource = resource;
//        this.onItemClick = onItemClick;
//    }
//    @Override
//    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        return new CategoryHolder(LayoutInflater.from(context).inflate(resource, parent, false), onItemClick);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
//        Category notes = objects.get(position);
//        holder.textView.setText(notes.getId());
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return objects.size();
//    }
//
//
//    public Category getItem(int position)
//    {
//        return objects.get(position);
//    }
//
//    public void remove(Category notes)
//    {
//        objects.remove(notes);
//        notifyDataSetChanged();
//    }
//}
