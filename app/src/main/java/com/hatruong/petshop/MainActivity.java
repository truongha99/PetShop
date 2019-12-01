package com.hatruong.petshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hatruong.petshop.Activity.ActivityLoaiThuCung;
import com.hatruong.petshop.Activity.ActivityThuCung;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pet Shop");
    }

    public void ShowThuCung(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityThuCung.class);
        startActivity(intent);
    }

    public void ShowLoaiThuCung(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityLoaiThuCung.class);
        startActivity(intent);
    }

    public void ShowHoaDon(View view) {
    }

    public void ShowBanChay(View view) {
    }

    public void ShowThongKe(View view) {
    }
}
