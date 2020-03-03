package com.example.switchpics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
        image = (ImageView) findViewById(R.id.my);
        image.setImageResource(R.drawable.android);
        }catch (Exception ex) {
            Log.e("SwitchPics", "exception", ex);
        }
        button2 = (Button) findViewById(R.id.button2);
        button = (Button) findViewById(R.id.button);
        button.setVisibility(View.GONE);
    }

    public void onNextClicked(View view) {
        button2.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
        try {
            image.setImageResource(R.drawable.demo1);
        }catch (Exception ex) {
            Log.e("SwitchPics", "exception", ex);
        }
    }

    public void onPreviousClicked(View view) {
        button.setVisibility(View.GONE);
        button2.setVisibility(View.VISIBLE);
        try {
            image.setImageResource(R.drawable.android);
        }catch (Exception ex) {
            Log.e("SwitchPics", "exception", ex);
        }
    }
}
