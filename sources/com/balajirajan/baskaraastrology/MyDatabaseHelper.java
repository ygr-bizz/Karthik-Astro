package com.cuspal.interlinks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String COLUMN_CLIENT_DAY = "Client_DAY";
    private static final String COLUMN_CLIENT_HH = "Client_HH";
    private static final String COLUMN_CLIENT_ID = "Client_Id";
    private static final String COLUMN_CLIENT_LATDD = "Client_LATDD";
    private static final String COLUMN_CLIENT_LATMM = "Client_LATMM";
    private static final String COLUMN_CLIENT_LATNS = "Client_LATNS";
    private static final String COLUMN_CLIENT_LOCATION = "Client_Location";
    private static final String COLUMN_CLIENT_LONDD = "Client_LONDD";
    private static final String COLUMN_CLIENT_LONEW = "Client_LONEW";
    private static final String COLUMN_CLIENT_LONMM = "Client_LONMM";
    private static final String COLUMN_CLIENT_MM = "Client_MM";
    private static final String COLUMN_CLIENT_MONTH = "Client_MONTH";
    private static final String COLUMN_CLIENT_NAME = "Client_Name";
    private static final String COLUMN_CLIENT_SS = "Client_SS";
    private static final String COLUMN_CLIENT_TCHH = "Client_TCHH";
    private static final String COLUMN_CLIENT_TCMM = "Client_TCMM";
    private static final String COLUMN_CLIENT_TCPM = "Client_TCPM";
    private static final String COLUMN_CLIENT_TZHH = "Client_TZHH";
    private static final String COLUMN_CLIENT_TZMM = "Client_TZMM";
    private static final String COLUMN_CLIENT_TZPM = "Client_TZPM";
    private static final String COLUMN_CLIENT_YEAR = "Client_YEAR";
    private static final String DATABASE_NAME = "Client_Manager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CLIENT = "Client";
    private static final String TAG = "SQLite";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        db.execSQL("CREATE TABLE Client(Client_Id INTEGER PRIMARY KEY,Client_Name TEXT,Client_Location TEXT,Client_DAY TEXT,Client_DAY TEXT,Client_DAY TEXT,Client_HH TEXT,Client_MM TEXT,Client_SS TEXT,Client_LATDD TEXT,Client_LATMM TEXT,Client_LATNS TEXT,Client_LONDD TEXT,Client_LONMM TEXT,Client_LONEW TEXT,Client_TZHH TEXT,Client_TZMM TEXT,Client_TZPM TEXT,Client_TCHH TEXT,Client_TCMM TEXT,Client_TCPM TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        db.execSQL("DROP TABLE IF EXISTS Client");
        onCreate(db);
    }

    public void addNote(Global note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CLIENT_NAME, Global.Name);
        values.put(COLUMN_CLIENT_LOCATION, Global.Loc);
        db.insert(TABLE_CLIENT, (String) null, values);
        db.close();
    }

    public Global getNote(int id) {
        Cursor cursor = getReadableDatabase().query(TABLE_CLIENT, new String[]{COLUMN_CLIENT_ID, COLUMN_CLIENT_NAME, COLUMN_CLIENT_LOCATION}, "Client_Id=?", new String[]{String.valueOf(id)}, (String) null, (String) null, (String) null, (String) null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Global.Name = cursor.getString(0);
        Global.Loc = cursor.getString(1);
        return null;
    }
}
