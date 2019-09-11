package com.example.projectkelompokv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class InputdataActivity extends AppCompatActivity {
    EditText edtnomor,edtnama,edttanggal,edtjenkel,edtalamat;
    ImageButton btnsubmit;
    TextView simpan;
    Context context;
    Data data;
    Integer nomor;
    String aksi = "Submit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata);
        context = this;

        aksi = getIntent().getStringExtra("UPDATE");
        data = getIntent().getParcelableExtra("UPDATE_INTENT");
        if(aksi == null){
            aksi = "Submit";
        }else{
            nomor = data.getNo();
        }

        edtnomor = findViewById(R.id.edtnomor);
        edtnama = findViewById(R.id.edtnama);
        edttanggal = findViewById(R.id.edttanggal);
        edtjenkel = findViewById(R.id.edtjenkel);
        edtalamat = findViewById(R.id.edtalamat);
        simpan = findViewById(R.id.simpan);

        btnsubmit = findViewById(R.id.btnsubmit);
    if (aksi.equals("Update")){
        simpan.setText("Update");
        edtnomor.setText(nomor);
        edtnomor.setFocusable(false);
        edtnama.setText(data.getNama());
        edttanggal.setText(data.getTgl());
        edtjenkel.setText(data.getJenkel());
        edtalamat.setText(data.getAlamat());
    }
    btnsubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatabaseHelper db = new DatabaseHelper(context);
            Data data = new Data();
            String label = String.valueOf(simpan.getText());
            if (label.equals("SIMPAN")){
                data.setNo(Integer.parseInt(edtnomor.getText().toString()));
                data.setNama(edtnama.getText().toString());
                data.setTgl(edttanggal.getText().toString());
                data.setJenkel(edtjenkel.getText().toString());
                data.setAlamat(edtalamat.getText().toString());
                db.insert(data);
                Intent move = new Intent(context,MainActivity.class);
                context.startActivity(move);
            }
            if (label.equals("Update")){
                data.setNo(Integer.parseInt(edtnomor.getText().toString()));
                data.setNama(edtnama.getText().toString());
                data.setTgl(edttanggal.getText().toString());
                data.setJenkel(edtjenkel.getText().toString());
                data.setAlamat(edtalamat.getText().toString());
                db.update(data);
                Intent move = new Intent(context,MainActivity.class);
                context.startActivity(move);
            }
        }
    });
    }
}
