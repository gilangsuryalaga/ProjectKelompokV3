package com.example.projectkelompokv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetaildataActivity extends AppCompatActivity {
    EditText edtnomor,edtnama,edttanggal,edtjenkel,edtalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildata);
        edtnomor = findViewById(R.id.edtnomor);
        edtnama = findViewById(R.id.edtnama);
        edttanggal = findViewById(R.id.edttanggal);
        edtjenkel = findViewById(R.id.edtjenkel);
        edtalamat = findViewById(R.id.edtalamat);

        edtnomor.setFocusable(false);
        edtnama.setFocusable(false);
        edttanggal.setFocusable(false);
        edtjenkel.setFocusable(false);
        edtalamat.setFocusable(false);

        Data data = getIntent().getParcelableExtra("DETAIL_INTENT");
        edtnomor.setText(String.valueOf(data.getNo()));
        edtnama.setText(data.getNama());
        edttanggal.setText(data.getTgl());
        edtjenkel.setText(data.getJenkel());
        edtalamat.setText(data.getAlamat());
    }
}
