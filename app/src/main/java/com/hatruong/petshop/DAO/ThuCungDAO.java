package com.hatruong.petshop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hatruong.petshop.Database.DBHelper;
import com.hatruong.petshop.Model.ThuCung;

import java.util.ArrayList;
import java.util.List;

public class ThuCungDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public static final String TABLE_NAME = "ThuCung";
    public static final String SQL_THU_CUNG = "CREATE TABLE ThuCung (maThuCung text primary key, maLoaiThuCung text, tenThuCung text, gia double, soLuong number);";
    public static final String TAG = "ThuCungDAO";

    public ThuCungDAO(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserThuCung(ThuCung thuCung) {
        ContentValues values = new ContentValues();
        values.put("maThuCung", thuCung.getMaThuCung());
        values.put("maLoaiThuCung", thuCung.getMaLoaiThuCung());
        values.put("tenThuCung", thuCung.getTenThuCung());
        values.put("gia", thuCung.getGia());
        values.put("soLuong", thuCung.getSoLuong());
        if (checkPrimaryKey(thuCung.getMaThuCung())) {
            int result = db.update(TABLE_NAME, values, "maThuCung=?", new
                    String[]{thuCung.getMaThuCung()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
        return 1;
    }

    //getAll
    public List<ThuCung> getAllThuCung() {
        List<ThuCung> dsThuCung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            ThuCung thuCung = new ThuCung();
            thuCung.setMaThuCung(c.getString(0));
            thuCung.setMaLoaiThuCung(c.getString(1));
            thuCung.setTenThuCung(c.getString(2));
            thuCung.setGia(c.getDouble(3));
            thuCung.setSoLuong(c.getInt(4));
            dsThuCung.add(thuCung);
            Log.d("//=====", thuCung.toString());
            c.moveToNext();
        }
        c.close();
        return dsThuCung;
    }

    //update
    public int updateThuCung(String maThuCung, String a, String b, double c, int d) {
        ContentValues values = new ContentValues();
        values.put("maThuCung", a);
        values.put("tenThuCung", b);
        values.put("gia", c);
        values.put("soLuong", d);
        int result = db.update(TABLE_NAME, values, "maThuCung=?", new
                String[]{maThuCung});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoThuCung(ThuCung thuCung) {
        ContentValues values = new ContentValues();
        values.put("maThuCung", thuCung.getMaThuCung());
        values.put("tenThuCung", thuCung.getMaThuCung());
        values.put("gia", thuCung.getGia());
        values.put("soLuong", thuCung.getSoLuong());
        int result = db.update(TABLE_NAME, values, "maLoaiThuCung=?", new String[]{thuCung.getMaThuCung()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteThuCung(String maThuCung) {
        int result = db.delete(TABLE_NAME, "maThuCung=?", new String[]{maThuCung});
        if (result == 0)
            return -1;
        return 1;
    }

    private boolean checkPrimaryKey(String strPrimaryKey) {
        //SELECT
        String[] columns = {"masach"};
        //WHERE clause
        String selection = "masach=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null,
                    null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
