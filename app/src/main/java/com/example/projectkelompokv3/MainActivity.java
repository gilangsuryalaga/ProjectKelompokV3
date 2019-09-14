package com.example.projectkelompokv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inputdata(View view) {
        Intent i = new Intent(MainActivity.this,InputdataActivity.class);
        startActivity(i);
    }

    public void lihatdata(View view) {
        Intent i = new Intent(MainActivity.this,LihatdataActivity.class);
        startActivity(i);
    }

    public void informasi(View view) {
        Intent i = new Intent(MainActivity.this,InfoActivity.class);
        startActivity(i);
    }
}
