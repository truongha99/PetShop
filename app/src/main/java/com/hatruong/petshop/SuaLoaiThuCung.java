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

public class SuaLoaiThuCung extends AppCompatActivity {
    private EditText edtMaLoaiThuCung;
    private EditText edtTenLoaiThuCung;
    private EditText edtMoTa;
    private FloatingActionButton btnUpdate;
    LoaiThuCungDAO loaiThuCungDAO;
    String maLoaiThuCung, tenLoaiThuCung, moTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_loai_thu_cung);
        setTitle("Sửa Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        maLoaiThuCung = bundle.getString("MALOAITHUCUNG");
        tenLoaiThuCung = bundle.getString("TENLOAITHUCUNG");
        moTa = bundle.getString("MOTA");
        edtMaLoaiThuCung.setText(maLoaiThuCung);
        edtTenLoaiThuCung.setText(tenLoaiThuCung);
        edtMoTa.setText(moTa);
    }

    private void initView() {
        edtMaLoaiThuCung = (EditText) findViewById(R.id.edtMaLoaiThuCung);
        edtTenLoaiThuCung = (EditText) findViewById(R.id.edtTenLoaiThuCung);
        edtMoTa = (EditText) findViewById(R.id.edtMoTa);
        btnUpdate = (FloatingActionButton) findViewById(R.id.btnUpdate);
        loaiThuCungDAO = new LoaiThuCungDAO(this);
    }

    public void updateThuCung(View view) {
        loaiThuCungDAO = new LoaiThuCungDAO(SuaLoaiThuCung.this);
        LoaiThuCung loaiThuCung = new LoaiThuCung(
                edtMaLoaiThuCung.getText().toString(),
                edtTenLoaiThuCung.getText().toString(),
                edtMoTa.getText().toString()
        );
        if (loaiThuCungDAO.updateLoaiThuCung(loaiThuCung) == 1) {
            Toast.makeText(getApplicationContext(), "Cap nhat thanh cong", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), ActivityLoaiThuCung.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Cap nhat That Bai", Toast.LENGTH_LONG).show();
        }
    }
}
