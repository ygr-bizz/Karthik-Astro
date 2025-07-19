package com.cuspal.interlinks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DBClass_All extends SQLiteOpenHelper {
    private static final String DATABASENAME = "ClientData";
    private static final String DAY = "day";
    private static final String HORNO = "Horno";
    private static final String HOUR = "hh";
    private static final String ID = "ID";
    private static final String LATDD = "latdd";
    private static final String LATMM = "latmm";
    private static final String LATNS = "latNS";
    private static final String LONDD = "londd";
    private static final String LONEW = "lonEW";
    private static final String LONMM = "lonmm";
    private static final String MINUTE = "mm";
    private static final String MONTH = "month";
    private static final String NAME = "name";
    private static final String PLACE = "place";
    private static final String SECOND = "ss";
    private static final String TABLENAME_BIRTH = "clientdata";
    private static final String TABLENAME_HORA = "clientdataHora";
    private static final String TCHH = "tchh";
    private static final String TCMM = "tcmm";
    private static final String TCPM = "tcPM";
    private static final String TZHH = "tzhh";
    private static final String TZMM = "tzmm";
    private static final String TZPM = "tzPM";
    private static final int VERSION = 1;
    private static final String YEAR = "year";

    public DBClass_All(Context context) {
        super(context, DATABASENAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS clientdata(ID integer primary key, name text, day text, month text, year text, hh text, mm text, ss text, place text, latdd text,londd text, tzPM text,tcPM text )");
        db.execSQL("CREATE TABLE IF NOT EXISTS clientdataHora(ID integer primary key, name text, Horno text, day text, month text, year text, hh text, mm text, ss text, place text, latdd text, latmm text, latNS text, londd text, lonmm text, lonEW text, tzPM text, tzhh text, tzmm text, tcPM text, tchh text, tcmm text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS clientdata");
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllPlace_Hora() {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM clientdataHora", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put(NAME, cursor.getString(1));
                map.put(HORNO, cursor.getString(2));
                map.put(DAY, cursor.getString(3));
                map.put(MONTH, cursor.getString(4));
                map.put(YEAR, cursor.getString(5));
                map.put(HOUR, cursor.getString(6));
                map.put(MINUTE, cursor.getString(7));
                map.put(SECOND, cursor.getString(8));
                map.put(PLACE, cursor.getString(9));
                map.put(LATDD, cursor.getString(10));
                map.put(LATMM, cursor.getString(11));
                map.put(LATNS, cursor.getString(12));
                map.put(LONDD, cursor.getString(13));
                map.put(LONMM, cursor.getString(14));
                map.put(LONEW, cursor.getString(15));
                map.put("tzpm", cursor.getString(16));
                map.put(TZHH, cursor.getString(17));
                map.put(TZMM, cursor.getString(18));
                map.put("tcpm", cursor.getString(19));
                map.put("tcpm", cursor.getString(20));
                map.put("tcpm", cursor.getString(21));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0112 A[Catch:{ Exception -> 0x0119 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> selectAllIds_Hora() {
        /*
            r8 = this;
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0119 }
            r1.<init>()     // Catch:{ Exception -> 0x0119 }
            android.database.sqlite.SQLiteDatabase r2 = r8.getReadableDatabase()     // Catch:{ Exception -> 0x0119 }
            java.lang.String r3 = "SELECT * FROM clientdataHora"
            android.database.Cursor r4 = r2.rawQuery(r3, r0)     // Catch:{ Exception -> 0x0119 }
            if (r4 == 0) goto L_0x0110
            boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x0119 }
            if (r5 == 0) goto L_0x0110
        L_0x0018:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x0119 }
            r5.<init>()     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "id"
            r7 = 0
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "name"
            r7 = 1
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "Horno"
            r7 = 2
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "day"
            r7 = 3
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "month"
            r7 = 4
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "year"
            r7 = 5
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "hh"
            r7 = 6
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "mm"
            r7 = 7
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "ss"
            r7 = 8
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "place"
            r7 = 9
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "latdd"
            r7 = 10
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "latmm"
            r7 = 11
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "latNS"
            r7 = 12
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "londd"
            r7 = 13
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "lonmm"
            r7 = 14
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "lonEW"
            r7 = 15
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tzpm"
            r7 = 16
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tzhh"
            r7 = 17
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tzmm"
            r7 = 18
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tcpm"
            r7 = 19
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tchh"
            r7 = 20
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "tcmm"
            r7 = 21
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0119 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0119 }
            r1.add(r5)     // Catch:{ Exception -> 0x0119 }
            boolean r6 = r4.moveToNext()     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x0018
        L_0x0110:
            if (r4 == 0) goto L_0x0115
            r4.close()     // Catch:{ Exception -> 0x0119 }
        L_0x0115:
            r2.close()     // Catch:{ Exception -> 0x0119 }
            return r1
        L_0x0119:
            r1 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.DBClass_All.selectAllIds_Hora():java.util.ArrayList");
    }

    public ArrayList<HashMap<String, String>> getAllPlace_Birth() {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM clientdata", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put(NAME, cursor.getString(1));
                map.put(DAY, cursor.getString(2));
                map.put(MONTH, cursor.getString(3));
                map.put(YEAR, cursor.getString(4));
                map.put(HOUR, cursor.getString(5));
                map.put(MINUTE, cursor.getString(6));
                map.put(SECOND, cursor.getString(7));
                map.put(PLACE, cursor.getString(8));
                map.put(LATDD, cursor.getString(9));
                map.put(LONDD, cursor.getString(10));
                map.put("tzpm", cursor.getString(11));
                map.put("tcpm", cursor.getString(12));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00af A[Catch:{ Exception -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> selectAllIds_Birth() {
        /*
            r8 = this;
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b6 }
            r1.<init>()     // Catch:{ Exception -> 0x00b6 }
            android.database.sqlite.SQLiteDatabase r2 = r8.getReadableDatabase()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = "SELECT * FROM clientdata"
            android.database.Cursor r4 = r2.rawQuery(r3, r0)     // Catch:{ Exception -> 0x00b6 }
            if (r4 == 0) goto L_0x00ad
            boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x00b6 }
            if (r5 == 0) goto L_0x00ad
        L_0x0018:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00b6 }
            r5.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "id"
            r7 = 0
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "name"
            r7 = 1
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "day"
            r7 = 2
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "month"
            r7 = 3
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "year"
            r7 = 4
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "hh"
            r7 = 5
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "mm"
            r7 = 6
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "ss"
            r7 = 7
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "place"
            r7 = 8
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "latdd"
            r7 = 9
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "londd"
            r7 = 10
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "tzpm"
            r7 = 11
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "tcpm"
            r7 = 12
            java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x00b6 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b6 }
            r1.add(r5)     // Catch:{ Exception -> 0x00b6 }
            boolean r6 = r4.moveToNext()     // Catch:{ Exception -> 0x00b6 }
            if (r6 != 0) goto L_0x0018
        L_0x00ad:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ Exception -> 0x00b6 }
        L_0x00b2:
            r2.close()     // Catch:{ Exception -> 0x00b6 }
            return r1
        L_0x00b6:
            r1 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.DBClass_All.selectAllIds_Birth():java.util.ArrayList");
    }
}
