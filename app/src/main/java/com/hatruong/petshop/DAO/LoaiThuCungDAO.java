package com.hatruong.petshop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hatruong.petshop.Database.DBHelper;
import com.hatruong.petshop.Model.LoaiThuCung;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuCungDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public static final String TABLE_NAME = "LoaiThuCung";
    public static final String SQL_LOAI_THU_CUNG = "CREATE TABLE LoaiThuCung (maLoaiThuCung text primary key, tenLoaiThuCung text, moTa text);";
    public static final String TAG = "LoaiThuCungDAO";

    public LoaiThuCungDAO(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserLoaiThuCung(LoaiThuCung loaiThuCung) {
        ContentValues values = new ContentValues();
        values.put("maLoaiThuCung", loaiThuCung.getMaLoaiThuCung());
        values.put("tenLoaiThuCung", loaiThuCung.getTenLoaiThuCung());
        values.put("moTa", loaiThuCung.getMoTa());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //update
    public int updateLoaiThuCung(LoaiThuCung loaiThuCung) {
        ContentValues values = new ContentValues();
        values.put("maLoaiThuCung", loaiThuCung.getMaLoaiThuCung());
        values.put("tenLoaiThuCung", loaiThuCung.getTenLoaiThuCung());
        values.put("moTa", loaiThuCung.getMoTa());
        int result = db.update(TABLE_NAME, values, "maLoaiThuCung=?", new String[]{loaiThuCung.getMaLoaiThuCung()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoLoaThuCung(String maLoaiThuCung, String s, String s1, String s2, String s3) {
        ContentValues values = new ContentValues();
        values.put("maLoaiThuCung", s);
        values.put("tenLoaiThuCung", s1);
        values.put("moTa", s2);
        int result = db.update(TABLE_NAME, values, "maLoaiThuCung=?", new
                String[]{maLoaiThuCung});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteLoaiThuCung(String maLoaiThuCung) {
        int result = db.delete(TABLE_NAME, "maLoaiThuCung=?", new String[]{maLoaiThuCung});
        if (result == 0)
            return -1;
        return 1;
    }

    //getAllTheLoai
    public List<LoaiThuCung> getAllLoaiThuCung() {
        List<LoaiThuCung> dsLoaiThuCung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            LoaiThuCung loaiThuCung = new LoaiThuCung();
            loaiThuCung.setMaLoaiThuCung(c.getString(0));
            loaiThuCung.setTenLoaiThuCung(c.getString(1));
            loaiThuCung.setMoTa(c.getString(2));
            dsLoaiThuCung.add(loaiThuCung);
            Log.d("//=====", loaiThuCung.toString());
            c.moveToNext();
        }
        c.close();
        return dsLoaiThuCung;
    }

}
