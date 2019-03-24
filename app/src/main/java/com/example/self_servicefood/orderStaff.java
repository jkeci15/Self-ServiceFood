package com.example.self_servicefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import controller.UserSharedPrefs;
import controller.Utilities;
import model.Order;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class orderStaff extends AppCompatActivity implements OnItemClick, Callback<List<Order>> {

    public RecyclerView orderLayout;
    public OrderAdapter nAdapter;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_order);
        orderLayout = findViewById(R.id.orderlistCust);
        orderLayout.setLayoutManager(new LinearLayoutManager(this));
        orderLayout.setItemAnimator(new DefaultItemAnimator());
        orderLayout.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        if (Utilities.isOnline(this)){

//            fill adapter with orders from customers
//            depends on the adapter as well to fill with two buttons or one
        }
        else {
            Toast.makeText(orderStaff.this,"Network not available",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        return true;
    }

    //signing out
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_sign_out) {

            UserSharedPrefs.clear(this);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {

    }

    @Override
    public void onFailure(Call<List<Order>> call, Throwable t) {

    }

    @Override
    public void itemClick(View view, int position) {
        switch (view.getId()){
            case R.id.each_order_staff_confirm:
//                change status of order and color of the order
            case R.id.each_order_staff_cancel:
//                change status and notify customer
            case R.id.each_order_staff_done:
//                notify customer
        }
    }

    @Override
    public boolean itemLongClick(View view, int position) {
        return false;
    }
}
