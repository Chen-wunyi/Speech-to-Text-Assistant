package com.example.speechre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

    public class DBOpenHelper extends SQLiteOpenHelper {

        private final static int DBVersion = 1; //<-- 版本
        private final static String DBName = "db";  //<-- db name


        public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version,String TableName) {
            super(context, DBName, null, DBVersion);
        }

        // public DBOpenHelper(Context context) {
        // super();
        //  }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.e("DBOpenHelper", "DBOpenHelperDBOpenHelperDBOpenHelperDBOpenHelper");
            db.execSQL("CREATE TABLE IF NOT EXISTS SplitTable (_id integer primary key autoincrement , split varchar(10) not null)");
            db.execSQL("CREATE TABLE IF NOT EXISTS CommonTable (_id integer primary key autoincrement ,common varchar(50) not null)");
            db.execSQL("CREATE TABLE IF NOT EXISTS EmojiTable (_id integer primary key autoincrement ,emojikey varchar(10) not null, emoji varchar(10) not null)");
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e("DBOpenHelper", "onUpgradeonUpgradeonUpgradeonUpgrade");
            db.execSQL("DROP TABLE IF EXISTS SplitTable");
            db.execSQL("DROP TABLE IF EXISTS CommonTable");
            db.execSQL("DROP TABLE IF EXISTS EmojiTable");

            onCreate(db);

        }
    }


