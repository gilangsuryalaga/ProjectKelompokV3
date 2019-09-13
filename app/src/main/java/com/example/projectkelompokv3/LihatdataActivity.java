package com.example.projectkelompokv3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class LihatdataActivity extends AppCompatActivity implements RecycleAdapter.OnUserActionListener{
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
    public void onUserAction(final Data data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pilihan")
                .setPositiveButton("Lihat Detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent detaildata = new Intent(context, DetaildataActivity.class);
                        detaildata.putExtra("DETAIL_INTENT",data);
                        context.startActivity(detaildata);
                    }
                })
                .setNegativeButton("Ubah Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent updateData = new Intent(context,InputdataActivity.class);
                        updateData.putExtra("UPDATE_INTENT", data);
                        updateData.putExtra("UPDATE_ACTION", "Update");
                        context.startActivity(updateData);
                    }
                })
                .setNeutralButton("Hapus Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseHelper db = new DatabaseHelper(context);
                        db.delete(data.getNo());
                        setupRecyclerview();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        Intent move = new Intent(this,MainActivity.class);
        startActivity(move);
    }
}

