package com.example.self_servicefood;

import android.view.View;

public interface OnItemClick {
    void itemClick(View view, int position);
    boolean itemLongClick(View view, int position);
}
