package com.example.projectkelompokv3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int DB_VERSION=1;
    private static final String DB_NAME="UserInfo";
    private static final String TABLE_NAME="tbl_user";
    private static final String KEY_NAME="nama";
    private static final String KEY_NOMOR="nomor";
    private static final String KEY_TANGGAL="tgl";
    private static final String KEY_JENKEL="jenkel";
    private static final String KEY_ALAMAT="alamat";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable="Create Table "+TABLE_NAME+"("+KEY_NOMOR+" INTEGER PRIMARY KEY,"+KEY_NAME+" STRING, "+KEY_TANGGAL+" STRING,"+KEY_JENKEL+" STRING,"+KEY_ALAMAT+" STRING"+")";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);

    }
    public List<Data> selectUserData(){
        ArrayList<Data> userList=new ArrayList<Data>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns={KEY_NOMOR, KEY_NAME,KEY_TANGGAL,KEY_TANGGAL,KEY_JENKEL,KEY_ALAMAT};

        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while(c.moveToNext()){
            String name = c.getString(0);
            int nomor = c.getInt(1);
            String tgl = c.getString(0);
            String jenkel = c.getString(0);
            String alamat = c.getString(0);

            Data personBean=new Data();
            personBean.setNo(nomor);
            personBean.setNama(name);
            personBean.setTgl(tgl);
            personBean.setJenkel(jenkel);
            personBean.setAlamat(alamat);
            userList.add(personBean);
        }
        return userList;
    }
    public void delete(int nomor){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause=KEY_NOMOR+"='"+nomor+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }
    public void update(Data personBean){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,personBean.getNama());
        values.put(KEY_TANGGAL,personBean.getTgl());
        values.put(KEY_JENKEL,personBean.getJenkel());
        values.put(KEY_ALAMAT,personBean.getAlamat());
        String whereClause=KEY_NOMOR+"='"+personBean.getNo()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
    public void insert(Data personBean){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR,personBean.getNo());
        values.put(KEY_NAME,personBean.getNama());
        values.put(KEY_TANGGAL,personBean.getTgl());
        values.put(KEY_JENKEL,personBean.getJenkel());
        values.put(KEY_ALAMAT,personBean.getAlamat());

        db.insert(TABLE_NAME,null,values);
    }

}

