package com.example.projectkelompokv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class LihatdataActivity extends AppCompatActivity implements RecycleAdapter.OnUserClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Data> listDataInfo;
    Context context;

    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatdata);
        context = this;

        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        setupRecyclerview();
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(context,InputdataActivity.class);
                startActivity(move);
            }
        });
    }


public void setupRecyclerview(){
    DatabaseHelper db = new DatabaseHelper(this);
    listDataInfo = db.selectUserData();
    RecycleAdapter adapter = new RecycleAdapter(this,listDataInfo,this);

    recyclerView.setAdapter(adapter);
    adapter.notifyDataSetChanged();
}

    @Override
    public void onUserClick(Data currentPerson, String action) {

    }
}

