package com.example.self_servicefood;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import model.Category;
import model.Item;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> list;
    private HashMap<String, List<Item>> hashMap;

    public ExpandableListAdapter(Context context, List<String> list, HashMap<String, List<Item>> hashMap) {
        this.context = context;
        this.list = list;
        this.hashMap = hashMap;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashMap.get(list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return hashMap.get(list.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String header = (String) getGroup(i);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_categories, null);
        }
        TextView listHeader = (TextView) view.findViewById(R.id.categorylist);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(header);
        return view;

    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String txt = (String)getChild(i,i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_menu, null);
        }
        TextView txtList = (TextView) view.findViewById(R.id.itemlist);
        txtList.setText(txt);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
