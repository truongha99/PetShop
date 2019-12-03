package com.hatruong.petshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hatruong.petshop.Activity.ActivityLoaiThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.DAO.ThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;
import com.hatruong.petshop.Model.ThuCung;

public class SuaThuCung extends AppCompatActivity {
    private TextView tvMaLoaThuCung;
    private EditText edtMaThuCung;
    private EditText edtTenThuCung;
    private EditText edtGia;
    private EditText edtSoLuong;
    private FloatingActionButton btnAdd;
    ThuCungDAO thuCungDAO;
    String maThuCung, tenThuCung, maLoaiThuCung, gia, soLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_thu_cung);
        setTitle("Sửa Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        maLoaiThuCung = bundle.getString("MALOAITHUCUNG");
        maThuCung = bundle.getString("MATHUCUNG");
        tenThuCung = bundle.getString("TENTHUCUNG");
        gia = bundle.getString("GIA");
        soLuong = bundle.getString("SOLUONG");
        tvMaLoaThuCung.setText(maLoaiThuCung);
        edtMaThuCung.setText(maThuCung);
        edtTenThuCung.setText(tenThuCung);
        edtGia.setText(gia);
        edtSoLuong.setText(soLuong);
    }

    private void initView() {
        tvMaLoaThuCung = (TextView) findViewById(R.id.tvMaLoaThuCung);
        edtMaThuCung = (EditText) findViewById(R.id.edtMaThuCung);
        edtTenThuCung = (EditText) findViewById(R.id.edtTenThuCung);
        edtGia = (EditText) findViewById(R.id.edtGia);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
        thuCungDAO = new ThuCungDAO(this);

    }

    public void updateThuCung(View view) {
        thuCungDAO = new ThuCungDAO(SuaThuCung.this);
        ThuCung thuCung = new ThuCung(
                maLoaiThuCung,
                edtMaThuCung.getText().toString(),
                edtTenThuCung.getText().toString(),
                Double.parseDouble(edtGia.getText().toString()),
                Integer.parseInt(edtSoLuong.getText().toString())
        );
        if (thuCungDAO.updateInfoThuCung(thuCung) ==1 ) {
            Toast.makeText(getApplicationContext(), "Cap nhat thanh cong", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), ActivityLoaiThuCung.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Cap nhat That Bai", Toast.LENGTH_LONG).show();
        }
    }
}
