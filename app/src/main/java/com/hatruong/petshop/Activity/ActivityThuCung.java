package com.hatruong.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.hatruong.petshop.Adapter.AdapterLoaiThuCung;
import com.hatruong.petshop.Adapter.AdapterThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.DAO.ThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;
import com.hatruong.petshop.Model.ThuCung;
import com.hatruong.petshop.R;
import com.hatruong.petshop.ThemLoaiThuCung;
import com.hatruong.petshop.ThemThuCung;

import java.util.ArrayList;
import java.util.List;

public class ActivityThuCung extends AppCompatActivity {
    public static List<ThuCung> dsThuCung = new ArrayList<>();
    ListView lvThuCung;
    AdapterThuCung adapter = null;
    ThuCungDAO thuCungDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_cung);
        setTitle("Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvThuCung = findViewById(R.id.lvThuCung);
        registerForContextMenu(lvThuCung);
        thuCungDAO = new ThuCungDAO(ActivityThuCung.this);
        dsThuCung = thuCungDAO.getAllThuCung();
        adapter = new AdapterThuCung(this, dsThuCung);
        lvThuCung.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_thu_cung, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, ThemThuCung.class);
                startActivity(intent);
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
