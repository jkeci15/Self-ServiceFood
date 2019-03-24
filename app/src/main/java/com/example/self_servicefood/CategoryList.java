package com.example.self_servicefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.UserSharedPrefs;
import controller.Utilities;
import model.Category;
import model.DbConnect;
import model.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryList extends AppCompatActivity implements OnItemClick, Callback<List<Item>> {

    public ExpandableListView categoryLayout;
    public ExpandableListAdapter listAdapter;
    public ItemAdapter nAdapter;
    public List<String> listHeader;
    public List<Item> items;
    public HashMap<String,List<Item>> listHashMap;
    public Button proceedButton;
    DbConnect dbConnect = DbConnect.getDbCon();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuitems);
        categoryLayout = (ExpandableListView) findViewById(R.id.optionsList);

        listAdapter = new ExpandableListAdapter(this,listHeader,listHashMap);
        categoryLayout.setAdapter(listAdapter);

        proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(v->{

            Intent intent = new Intent(CategoryList.this,ConfirmOrderActivity.class);
            startActivity(intent);
            finish();
        });
//        categoryLayout.setLayoutManager(new LinearLayoutManager(this));
//        categoryLayout.setItemAnimator(new DefaultItemAnimator());
//        categoryLayout.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


//            TODO: Show items divided into categories and clickable + -
            initData();

    }

    private void initData() {

        listHashMap = dbConnect.getMenuByBusinessId(UserSharedPrefs.getBusiness(CategoryList.this).getId());
//        add Categories of food
        for (Map.Entry<String, List<Item>> entry : listHashMap.entrySet()) {
            listHeader.add(entry.getKey());
            nAdapter = new ItemAdapter(this,CategoryList.this,entry.getValue(),R.id.each_item_name);
        }
    }

    @Override
    public void itemClick(View view, int position) {
        switch (view.getId())
        {
//            case R.id.each_catergory_text:
//                Item item = nAdapter.getItem(position);
//                Intent intent = new Intent(this,ItemList.class);
//                intent.putExtra("id",item);
//                startActivity(intent);
//                finish();
            case R.id.each_item_add:
//                Add the item to order
                Item item = nAdapter.getItem(position);

            case R.id.each_item_delete:
//                Remove item from the order
                Item item1 = nAdapter.getItem(position);
        }
    }

    @Override
    public boolean itemLongClick(View view, int position) {
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        return true;
    }

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
    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

    }

    @Override
    public void onFailure(Call<List<Item>> call, Throwable t) {

    }
}
