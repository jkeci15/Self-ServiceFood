//package com.example.self_servicefood;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import java.util.List;
//import controller.UserSharedPrefs;
//import controller.Utilities;
//import model.Item;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class ItemList extends AppCompatActivity implements OnItemClick, Callback<List<Item>> {
//
//    public RecyclerView itemLayout;
//    public ItemAdapter nAdapter;
//    public Button proceed;
//
//    protected void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(R.layout.activity_categories);
//        itemLayout = findViewById(R.id.itemlist);
//        proceed = findViewById(R.id.proceedButton);
//        itemLayout.setLayoutManager(new LinearLayoutManager(this));
//        itemLayout.setItemAnimator(new DefaultItemAnimator());
//        itemLayout.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//
//        if (Utilities.isOnline(this)) {
//
//
//        } else {
//            Toast.makeText(ItemList.this,"Network not available",Toast.LENGTH_SHORT).show();
//
//
//        }
//
//        proceed.setOnClickListener(v->{
//            Intent intent = new Intent(ItemList.this,ConfirmOrderActivity.class);
//            startActivity(intent);
//            finish();
//
//        });
//    }
//
//    @Override
//    public void itemClick(View view, int position) {
//        switch (view.getId())
//        {
//            case R.id.each_item_add:
////                Add the item to order
//
//                Item item = nAdapter.getItem(position);
////                Intent intent = new Intent(this,);
////                intent.putExtra("id", item);
////                startActivity(intent);
////                finish();
//
//            case R.id.each_item_delete:
////                Delete item from the order
//
//        }
//    }
//
//    @Override
//    public boolean itemLongClick(View view, int position) {
//        return false;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    //signing out
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == R.id.action_sign_out) {
//
//            UserSharedPrefs.clear(this);
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//
//    }
//
//    @Override
//    public void onFailure(Call<List<Item>> call, Throwable t) {
//
//    }
//}
