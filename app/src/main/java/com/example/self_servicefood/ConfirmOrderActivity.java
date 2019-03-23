package com.example.self_servicefood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;
import controller.Utilities;

public class ConfirmOrderActivity extends AppCompatActivity {
    public Button pay,edit;
    public RecyclerView orderLayout;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
//        setContentView(R.layout.activity_);
        if (Utilities.isOnline(this)){

//            Show order that expects to be confirmed.

        }
        else {
            Toast.makeText(ConfirmOrderActivity.this,"Network is not available",Toast.LENGTH_SHORT).show();
        }
    }
}
