package com.example.loginpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.ViewStructure;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.editText2);
        pwd = findViewById(R.id.editText);
    }
    public void onCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivityForResult(intent, 2);
    }
    public void onSignIn(View view) {
        if (login.length() == 0)
            ;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String Login = data.getStringExtra("LOGIN");
            String Pwd = data.getStringExtra("PASSWORD");
            login.setText(Login);
            pwd.setText(Pwd);
            pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}
