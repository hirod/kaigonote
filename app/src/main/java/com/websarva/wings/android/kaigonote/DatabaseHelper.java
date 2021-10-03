package com.websarva.wings.android.kaigonote;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Kaigo.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    public void onCreate(SQLiteDatabase db) {
       String cmd = "create table Kaigomemo" + "('日付' DATE,'番号' INTEGER,'名前' CHAR,'排泄' CHAR,'入浴' CHAR,'食事・飲水' INTEGER,'配薬' CHAR,'口腔' CHAR,'記録'VARCHER,'アクシデント' VARCHER,'記録一覧'VARCHER)";
       db.execSQL(cmd);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

