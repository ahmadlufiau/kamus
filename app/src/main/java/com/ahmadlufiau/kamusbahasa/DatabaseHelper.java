package com.ahmadlufiau.kamusbahasa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmad Lufi A U on 17/12/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_kamusbahasa";
    public static String TABLE_NAME_ID_ENG = "table_id_eng";
    public static String TABLE_NAME_ENG_ID = "table_eng_id";
    public static String FIELD_ID = "id";
    public static String FIELD_NAME = "nama";
    public static String FIELD_DESCRIPTION = "description";

    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE_ID_ENG = "create table " +TABLE_NAME_ID_ENG + " (" + FIELD_ID + " integer primary key autoincrement, "+
            FIELD_NAME + " text not null, "+
            FIELD_DESCRIPTION + " text not null);";

    public static String CREATE_TABLE_ENG_ID = "create table " +TABLE_NAME_ENG_ID + " (" + FIELD_ID + " integer primary key autoincrement, "+
            FIELD_NAME + " text not null, "+
            FIELD_DESCRIPTION + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ID_ENG);
        sqLiteDatabase.execSQL(CREATE_TABLE_ENG_ID);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_ID_ENG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_ENG_ID);
        onCreate(sqLiteDatabase);
    }
}