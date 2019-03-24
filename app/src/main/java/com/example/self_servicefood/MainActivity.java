package com.example.self_servicefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controller.UserSharedPrefs;
import controller.Utilities;
import model.DbConnect;
import model.User;

public class MainActivity extends AppCompatActivity {

    public Button signinbutton, signup;
    public EditText enterEmail, enterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if (UserSharedPrefs.getUser(this) == null){

        signinbutton = findViewById(R.id.login_button);
        enterEmail = findViewById(R.id.email_signin);
        enterPassword = findViewById(R.id.password_signin);
        signup = findViewById(R.id.register_button);
        DbConnect dbConnect = DbConnect.getDbCon();

//
        User user = dbConnect.authenticateUser(enterEmail.getText().toString(), enterPassword.getText().toString());
        signinbutton.setOnClickListener(v -> {
//                if (Utilities.isOnline(MainActivity.this)) {
//
////                        Request Data
//                  change to SearchActivity
            if (user != null) {

                UserSharedPrefs.saveUser(this, user);
                if (user.getType() == 3) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);
                    finish();
                } else if (user.getType() == 2) {
                    Intent intent = new Intent(MainActivity.this, orderStaff.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                Toast.makeText(MainActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }

        });
//
//                }
//                else Toast.makeText(MainActivity.this,"Network isn't available!", Toast.LENGTH_LONG).show();
//            });
        signup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
