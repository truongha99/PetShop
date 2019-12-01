package com.hatruong.petshop.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.DAO.ThuCungDAO;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PetShop.db";
    public static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoaiThuCungDAO.SQL_LOAI_THU_CUNG);
        db.execSQL(ThuCungDAO.SQL_THU_CUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists " + LoaiThuCungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + ThuCungDAO.TABLE_NAME);
        onCreate(db);
    }
}
