package com.example.projectkelompokv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class InputdataActivity extends AppCompatActivity {
    EditText edtnomor,edtnama,edttanggal,edtjenkel,edtalamat;
    Button btnsubmit;
    Context context;
    Data updated;
    String aksi,nomor = "Submit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata);
        context = this;

        aksi = getIntent().getStringExtra("UPDATE_ACTION");
        updated = getIntent().getParcelableExtra("UPDATE_INTENT");
        if(aksi == null){
            aksi = "Submit";
        }else{
            nomor = String.valueOf(updated.getNo());
        }

        edtnomor = findViewById(R.id.edtnomor);
        edtnama = findViewById(R.id.edtnama);
        edttanggal = findViewById(R.id.edttanggal);
        edtjenkel = findViewById(R.id.edtjenkel);
        edtalamat = findViewById(R.id.edtalamat);

        btnsubmit = findViewById(R.id.btnsubmit);
    if (aksi.equals("Update")){
        btnsubmit.setText("Update");
        edtnomor.setText(nomor);
        edtnomor.setFocusable(false);
        edtnama.setText(updated.getNama());
        edttanggal.setText(updated.getTgl());
        edtjenkel.setText(updated.getJenkel());
        edtalamat.setText(updated.getAlamat());

        Log.d("test",updated.getNama());
    }
    btnsubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatabaseHelper db = new DatabaseHelper(context);
            Data data = new Data();
            String label = btnsubmit.getText().toString();
            if (label.equals("Simpan")){
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
