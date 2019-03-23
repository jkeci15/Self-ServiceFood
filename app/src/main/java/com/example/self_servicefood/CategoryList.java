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
import model.Category;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryList extends AppCompatActivity implements OnItemClick, Callback<List<Category>> {

    public RecyclerView categoryLayout;
    public CategoryAdapter nAdapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        categoryLayout = findViewById(R.id.categorylist);
        categoryLayout.setLayoutManager(new LinearLayoutManager(this));
        categoryLayout.setItemAnimator(new DefaultItemAnimator());
        categoryLayout.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        if (Utilities.isOnline(this)) {

        }
        else {
            Toast.makeText(CategoryList.this,"Network isn't available!", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void itemClick(View view, int position) {
        switch (view.getId())
        {
            case R.id.each_catergory_text:
                Category category = nAdapter.getItem(position);
                Intent intent = new Intent(this,ItemList.class);
                intent.putExtra("id",category);
                startActivity(intent);
                finish();
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
    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

    }

    @Override
    public void onFailure(Call<List<Category>> call, Throwable t) {

    }
}
