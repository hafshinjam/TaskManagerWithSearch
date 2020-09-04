package com.example.taskmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

import java.util.UUID;

import static com.example.taskmanager.database.UserDBSchema.UserTable.*;

public class UserBaseHelper extends SQLiteOpenHelper {

    public UserBaseHelper(@Nullable Context context) {
        super(context, UserDBSchema.NAME, null, UserDBSchema.VERSION);
    }

    /** creating table , constraints and ... of users database with all parameters
     * that been told on schema
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAME + "(" +
                COLS.ID + " integer primary key autoincrement," +
                COLS.UUID + " text," +
                COLS.USERNAME + " text," +
                COLS.PASSWORD + " text" +
                ");");
        ContentValues contentValues= new ContentValues();
        contentValues.put(COLS.ID,1);
        contentValues.put(COLS.UUID, UUID.randomUUID().toString());
        contentValues.put(COLS.USERNAME,"Admin");
        contentValues.put(COLS.PASSWORD,"12345");
        db.insert(NAME,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
