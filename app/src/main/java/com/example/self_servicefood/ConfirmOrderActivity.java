package com.example.self_servicefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import controller.UserSharedPrefs;
import controller.Utilities;
import model.Order;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmOrderActivity extends AppCompatActivity  {
    public Button pay,edit;
    public RecyclerView orderLayout;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_confirm);
        if (Utilities.isOnline(this)){

//            Show order that expects to be confirmed.

        }
        else {
            Toast.makeText(ConfirmOrderActivity.this,"Network is not available",Toast.LENGTH_SHORT).show();
        }

        pay = findViewById(R.id.confirm_button);
        edit = findViewById(R.id.editorder_button);

        pay.setOnClickListener(v->{

            Intent intent = new Intent(ConfirmOrderActivity.this,OrderList.class);
            startActivity(intent);
            finish();
        });

//        TODO: Keep the items previously selected with the amounts
        edit.setOnClickListener(v->{
            Intent intent = new Intent(ConfirmOrderActivity.this,CategoryList.class);
            startActivity(intent);
            finish();
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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


}
