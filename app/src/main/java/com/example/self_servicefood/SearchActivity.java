package com.example.self_servicefood;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.List;

import controller.UserSharedPrefs;
import controller.Utilities;
import model.Business;
import model.DbConnect;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements OnItemClick, Callback<List<Business>> {
    public RecyclerView orderLayout;
    public SearchAdapter nAdapter;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        orderLayout = findViewById(R.id.businesslist);
        orderLayout.setLayoutManager(new LinearLayoutManager(this));
        orderLayout.setItemAnimator(new DefaultItemAnimator());
        orderLayout.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        DbConnect dbConnect = DbConnect.getDbCon();

////            Conduct the Search here
//      Fill adapter with business items
        List<Business> businessList = dbConnect.getBusinesses();
        nAdapter = new SearchAdapter(SearchActivity.this, R.layout.activity_each_business, businessList, this);
// Get the intent, verify the action and get the query
//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            doMySearch(query);
//        }
//    }
//
//
//    private void doMySearch(String query) {
////        Get businesses
////        Filter them
//
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        ComponentName componentName = new ComponentName(this, SearchActivity.class);
        assert searchManager != null;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        return true;
    }

    @Override
    public void itemClick(View view, int position) {
        switch (view.getId()){

            case R.id.each_business_name:

                UserSharedPrefs.saveBusiness(this,nAdapter.getItemint(position));
                Intent intent = new Intent(SearchActivity.this,CategoryList.class);
                startActivity(intent);
                finish();


        }

    }

    @Override
    public boolean itemLongClick(View view, int position) {
        return false;
    }

    @Override
    public void onResponse(Call<List<Business>> call, Response<List<Business>> response) {

    }

    @Override
    public void onFailure(Call<List<Business>> call, Throwable t) {

    }
}
