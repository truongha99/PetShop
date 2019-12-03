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

import com.hatruong.petshop.Adapter.AdapterThuCung;
import com.hatruong.petshop.DAO.ThuCungDAO;
import com.hatruong.petshop.Model.ThuCung;
import com.hatruong.petshop.R;
import com.hatruong.petshop.SuaThuCung;
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
        lvThuCung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityThuCung.this,SuaThuCung.class);
                Bundle bundle = new Bundle();

                bundle.putString("MALOAITHUCUNG",String.valueOf(dsThuCung.get(i).getMaLoaiThuCung()));
                bundle.putString("MATHUCUNG", dsThuCung.get(i).getMaThuCung());
                bundle.putString("TENTHUCUNG", dsThuCung.get(i).getTenThuCung());
                bundle.putString("GIA", String.valueOf(dsThuCung.get(i).getGia()));
                bundle.putString("SOLUONG", String.valueOf(dsThuCung.get(i).getSoLuong()));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
