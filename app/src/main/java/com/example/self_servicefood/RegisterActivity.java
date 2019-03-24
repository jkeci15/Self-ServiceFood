package com.example.self_servicefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import controller.UserSharedPrefs;
import model.DbConnect;
import model.User;


public class RegisterActivity extends AppCompatActivity {
    public EditText signupEmail,signupPassword,signupConfirmPassword,name,surname;
    public Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupEmail = findViewById(R.id.sign_up_email);
        signupPassword = findViewById(R.id.sign_up_password);
        signupConfirmPassword = findViewById(R.id.confirm);
        name = findViewById(R.id.signup_name);
        surname = findViewById(R.id.signup_surname);
        DbConnect dbConnect = DbConnect.getDbCon();

        signupButton.setOnClickListener(v->{

//          create the new User and go to Search Activity
            User newUser = dbConnect.createUser(name.getText().toString(),surname.getText().toString(),
                    signupEmail.getText().toString(),signupPassword.getText().toString(),3,0);
            UserSharedPrefs.saveUser(this,newUser);
            Intent intent = new Intent(RegisterActivity.this,SearchActivity.class);
            startActivity(intent);
            finish();
//            }
        });
    }
}
