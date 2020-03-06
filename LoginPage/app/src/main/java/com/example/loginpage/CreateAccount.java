package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {

    EditText LoginText;
    EditText PasswordText1;
    EditText PasswordText2;
    Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        SignUp = findViewById(R.id.signup);
        LoginText = findViewById(R.id.login);
        PasswordText1 = findViewById(R.id.pwd1);
        PasswordText2 = findViewById(R.id.pwd2);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = LoginText.getText().toString();
                String pwd = PasswordText1.getText().toString();
                String pwd2 = PasswordText1.getText().toString();
                if (login.length() > 2 && pwd.equals(pwd2) && pwd.length() > 5) {
                    Intent intent = new Intent();
                    intent.putExtra("LOGIN", login);
                    intent.putExtra("PASSWORD", pwd);
                    setResult(2, intent);
                    finish();
                }
            }
        });
    }

}
