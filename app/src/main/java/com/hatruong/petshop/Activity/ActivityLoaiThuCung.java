package com.hatruong.petshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hatruong.petshop.Adapter.AdapterLoaiThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;
import com.hatruong.petshop.R;
import com.hatruong.petshop.SuaLoaiThuCung;
import com.hatruong.petshop.ThemLoaiThuCung;

import java.util.ArrayList;
import java.util.List;

public class ActivityLoaiThuCung extends AppCompatActivity {
    public static List<LoaiThuCung> dsLoaiThuCung = new ArrayList<>();
    ListView lvLoaiThuCung;
    AdapterLoaiThuCung adapter = null;
    LoaiThuCungDAO loaiThuCungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_thu_cung);
        setTitle("Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvLoaiThuCung = findViewById(R.id.lvLoaiThuCung);
        registerForContextMenu(lvLoaiThuCung);
        loaiThuCungDAO = new LoaiThuCungDAO(ActivityLoaiThuCung.this);
        dsLoaiThuCung = loaiThuCungDAO.getAllLoaiThuCung();
        adapter = new AdapterLoaiThuCung(this, dsLoaiThuCung);
        lvLoaiThuCung.setAdapter(adapter);
        lvLoaiThuCung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityLoaiThuCung.this, SuaLoaiThuCung.class);
                Bundle bundle = new Bundle();
                bundle.putString("MALOAITHUCUNG", dsLoaiThuCung.get(i).getMaLoaiThuCung());
                bundle.putString("TENLOAITHUCUNG", dsLoaiThuCung.get(i).getTenLoaiThuCung());
                bundle.putString("MOTA", dsLoaiThuCung.get(i).getMoTa());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_loai_thu_cung, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, ThemLoaiThuCung.class);
                startActivity(intent);
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
