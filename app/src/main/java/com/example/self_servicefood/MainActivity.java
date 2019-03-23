package com.example.self_servicefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.UserSharedPrefs;
import controller.Utilities;

public class MainActivity extends AppCompatActivity {

    public Button signinbutton, signup;
    public EditText enterEmail, enterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (UserSharedPrefs.getUser(this) == null){
            setContentView(R.layout.activity_login);
            signinbutton = findViewById(R.id.login_button);
            enterEmail = findViewById(R.id.email_signin);
            enterPassword = findViewById(R.id.password_signin);

            signinbutton.setOnClickListener(v -> {
                if (Utilities.isOnline(MainActivity.this)) {

//                        Request Data

                }
                else Toast.makeText(MainActivity.this,"Network isn't available!", Toast.LENGTH_LONG).show();
            });
            signup = findViewById(R.id.register_button);
            signup.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            });

        }
        else {
//            TODO: Have to be careful where to link
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);
            finish();
        }

//        depending on user type set the Content View either activity_main or activity_order
        setContentView(R.layout.activity_main);


    }
}
