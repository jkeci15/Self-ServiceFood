//package com.example.self_servicefood;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import java.util.List;
//import java.util.concurrent.Callable;
//
//import controller.Utilities;
//import model.Category;
//
//
//public class MenuList extends Activity implements OnItemClick, Callable<List<Category>> {
//    public RecyclerView menuLayout;
//    public CategoryAdapter nAdapter;
//
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_eachcategory);
//        menuLayout.setLayoutManager(new LinearLayoutManager(this));
//        menuLayout.setItemAnimator(new DefaultItemAnimator());
//        menuLayout.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
//        if (Utilities.isOnline(this)){
//
////            Request all orders made by this user
//        }
//        else {
////            SMTH::
//        }
//    }
//
//
//    @Override
//    public void itemClick(View view, int position) {
//        switch (view.getId())
//        {
//            case R.id.each_order_text:
//
//                Category category = nAdapter.getItem(position);
//                Intent intent = new Intent(this, CategoriesActivity.class);
//                intent.putExtra("id", category);
//                startActivity(intent);
//                finish();
//        }
//    }
//
//    @Override
//    public boolean itemLongClick(View view, int position) {
//        return false;
//    }
//
//    @Override
//    public List<Category> call() throws Exception {
//        return null;
//    }
//}
