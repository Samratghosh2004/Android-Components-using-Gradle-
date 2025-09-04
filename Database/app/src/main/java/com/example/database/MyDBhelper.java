package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MyDBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Contact";

    private static final int DB_VERSION =1;


//Table variables
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";

    public MyDBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_CONTACT + " ( " + KEY_ID + " integer primary key autoincrement,"+ KEY_NAME +" text not null ," + KEY_PHONE +" text"+")");

        // SQLiteDatabase data = this.getReadableDatabase();
        //SQLiteDatabase data = this.getWritableDatabase();
        // data.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists "+ TABLE_CONTACT);

        onCreate(db);
    }


    public void addContact(String name, String phone) {
        SQLiteDatabase data = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(KEY_NAME,name);
        v.put(KEY_PHONE,phone);
        data.insert(TABLE_CONTACT,null,v);
        data.close();
    }


    public ArrayList<ContactModel> showData(){
        SQLiteDatabase data = this.getReadableDatabase();
        Cursor cursor = data.rawQuery(" select * from " + TABLE_CONTACT,null );
        ArrayList<ContactModel> array = new ArrayList<>();
        while(cursor.moveToNext()) {



                ContactModel model = new ContactModel();
                model.id = cursor.getInt(0);
                model.name = cursor.getString(1);
                model.phone = cursor.getString(2);

                array.add(model);


        }
        return array;
    }


    public void updateContact(ContactModel contactModel) {

        SQLiteDatabase data = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_PHONE,contactModel.phone);
        data.update(TABLE_CONTACT, cValues,KEY_ID+" = "+ contactModel.id,null);
    }


    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, KEY_ID +" = ? ", new String[]{String.valueOf(id)} );
    }
}

