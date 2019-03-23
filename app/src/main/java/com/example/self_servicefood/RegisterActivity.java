package com.example.self_servicefood;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends Activity {
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

        signupEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                requestGetEmails("130.",)
//                check whether the email is already taken or not
            }
        });

        signupButton.setOnClickListener(v->{
//            if (signupPassword.getText().toString().equals(signupConfirmPassword.getText().toString())) {
////                create the new User and go to Search Activity
//            }
        });
    }
}
