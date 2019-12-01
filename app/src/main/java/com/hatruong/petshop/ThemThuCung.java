package com.hatruong.petshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hatruong.petshop.Activity.ActivityThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.DAO.ThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;
import com.hatruong.petshop.Model.ThuCung;

import java.util.ArrayList;
import java.util.List;

public class ThemThuCung extends AppCompatActivity {
    private Spinner spnMaLoaiThuCung;
    private EditText edtMaThuCung;
    private EditText edtTenThuCung;
    private EditText edtGia;
    private EditText edtSoLuong;
    private FloatingActionButton btnAdd;
    ThuCungDAO thuCungDAO;
    LoaiThuCungDAO loaiThuCungDAO;
    String maLoaiThuCung = "";
    List<LoaiThuCung> listLoaiThuCung = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_thu_cung);
        setTitle("Thêm Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        getLoaiThuCung();
    }

    private void getLoaiThuCung() {
        loaiThuCungDAO = new LoaiThuCungDAO(ThemThuCung.this);
        listLoaiThuCung = loaiThuCungDAO.getAllLoaiThuCung();
        ArrayAdapter<LoaiThuCung> arrayAdapter = new ArrayAdapter<LoaiThuCung>(this, R.layout.support_simple_spinner_dropdown_item, listLoaiThuCung);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnMaLoaiThuCung.setAdapter(arrayAdapter);
    }

    private void initView() {
        spnMaLoaiThuCung = (Spinner) findViewById(R.id.spnMaLoaiThuCung);
        edtMaThuCung = (EditText) findViewById(R.id.edtMaThuCung);
        edtTenThuCung = (EditText) findViewById(R.id.edtTenThuCung);
        edtGia = (EditText) findViewById(R.id.edtGia);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);

        spnMaLoaiThuCung.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maLoaiThuCung = listLoaiThuCung.get(spnMaLoaiThuCung.getSelectedItemPosition()).getMaLoaiThuCung();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void themThuCung(View view) {
        thuCungDAO = new ThuCungDAO(ThemThuCung.this);
        ThuCung thuCung = new ThuCung(
                maLoaiThuCung,
                edtMaThuCung.getText().toString(),
                edtTenThuCung.getText().toString(),
                Double.parseDouble(edtGia.getText().toString()),
                Integer.parseInt(edtSoLuong.getText().toString())
        );
        if (thuCungDAO.inserThuCung(thuCung) > 0) {
            Toast.makeText(getApplicationContext(), "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), ActivityThuCung.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public int checkPositionTheLoai(String strTheLoai) {
        for (int i = 0; i < listLoaiThuCung.size(); i++) {
            if (strTheLoai.equals(listLoaiThuCung.get(i).getMaLoaiThuCung())) {
                return i;
            }
        }
        return 0;
    }


}
