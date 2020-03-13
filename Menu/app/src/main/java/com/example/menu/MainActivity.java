package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_view = (ImageView) findViewById(R.id.imageView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_img:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 2);
                break;
            case R.id.del_img:
                image_view.setImageResource(android.R.color.transparent);
                Toast.makeText(MainActivity.this, "delete image selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.reset:
                image_view.setImageResource(android.R.color.transparent);
                Toast.makeText(MainActivity.this, "reset selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensa:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://ensak.usms.ac.ma/ensak/"));
                startActivity(intent);
                break;
            case R.id.home:
                intent=new Intent(Intent.ACTION_MAIN);
                startActivity(intent);
                break;
            case R.id.mail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"oouklich@student.1337.ma"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                intent.putExtra(Intent.EXTRA_TEXT   , "body of email");
                startActivity(Intent.createChooser(intent, null));
                break;
            case R.id.sms:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("smsto:"));try {
                startActivity(sendIntent);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            break;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK);
            switch (requestCode) {
                case 2:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        image_view.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

    }
}

