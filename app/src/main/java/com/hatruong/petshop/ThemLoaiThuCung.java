package com.hatruong.petshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hatruong.petshop.Activity.ActivityLoaiThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;

public class ThemLoaiThuCung extends AppCompatActivity {
    private EditText edtMaLoaiThuCung;
    private EditText edtTenLoaiThuCung;
    private EditText edtMoTa;
    private FloatingActionButton btnAdd;
    LoaiThuCungDAO loaiThuCungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_loai_thu_cung);
        setTitle("Thêm Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        edtMaLoaiThuCung = (EditText) findViewById(R.id.edtMaLoaiThuCung);
        edtTenLoaiThuCung = (EditText) findViewById(R.id.edtTenLoaiThuCung);
        edtMoTa = (EditText) findViewById(R.id.edtMoTa);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
    }

    public void themLoaiThuCung(View view) {
        loaiThuCungDAO = new LoaiThuCungDAO(ThemLoaiThuCung.this);
        LoaiThuCung loaiThuCung = new LoaiThuCung(
                edtMaLoaiThuCung.getText().toString(),
                edtTenLoaiThuCung.getText().toString(),
                edtMoTa.getText().toString());
        if (loaiThuCungDAO.inserLoaiThuCung(loaiThuCung) > 0) {
            Toast.makeText(getApplicationContext(), "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), ActivityLoaiThuCung.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
