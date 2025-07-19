package com.cuspal.interlinks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DBClass_Horary extends SQLiteOpenHelper {
    private static final String Horno = "Horno";
    private static final String databasename = "Clientinfo";
    private static final String day = "day";
    private static final String hh = "hh";
    private static final String id = "ID";
    private static final String latNS = "latNS";
    private static final String latdd = "latdd";
    private static final String latmm = "latmm";
    private static final String lonEW = "lonEW";
    private static final String londd = "londd";
    private static final String lonmm = "lonmm";
    private static final String mm = "mm";
    private static final String month = "month";
    private static final String name = "name";
    private static final String place = "place";
    private static final String ss = "ss";
    private static final String tablename = "clientdataHora";
    private static final String tcPM = "tcPM";
    private static final String tchh = "tchh";
    private static final String tcmm = "tcmm";
    private static final String tzPM = "tzPM";
    private static final String tzhh = "tzhh";
    private static final String tzmm = "tzmm";
    private static final int versioncode = 4;
    private static final String year = "year";

    public DBClass_Horary(Context context) {
        super(context, databasename, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE IF NOT EXISTS clientdataHora(ID integer primary key, name text, Horno text, day text, month text, year text, hh text, mm text, ss text, place text, latdd text, latmm text, latNS text, londd text, lonmm text, lonEW text, tzPM text, tzhh text, tzmm text, tcPM text, tchh text, tcmm text)");
    }

    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        database.execSQL("DROP TABLE IF EXISTS clientdataHora");
        onCreate(database);
    }

    public void addClients(Client client) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name, client.name);
        values.put(Horno, client.Hno);
        values.put(day, client.iDay);
        values.put(month, client.iMonth);
        values.put(year, client.iYear);
        values.put(hh, client.ihour);
        values.put(mm, client.iMinute);
        values.put(ss, client.iSecond);
        values.put(latdd, client.latdd);
        values.put(latmm, client.latmm);
        values.put(latNS, client.latNS);
        values.put(londd, client.londd);
        values.put(lonmm, client.lonmm);
        values.put(lonEW, client.lonEW);
        values.put(tzPM, client.tzpm);
        values.put(tzhh, client.tzhh);
        values.put(tzmm, client.tzmm);
        values.put(tcPM, client.tcpm);
        values.put(tchh, client.tchh);
        values.put(tcmm, client.tcmm);
        db.insertWithOnConflict(tablename, (String) null, values, 4);
    }

    public ArrayList<HashMap<String, String>> getAllPlace() {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM clientdataHora", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put(name, cursor.getString(1));
                map.put(Horno, cursor.getString(2));
                map.put(day, cursor.getString(3));
                map.put(month, cursor.getString(4));
                map.put(year, cursor.getString(5));
                map.put(hh, cursor.getString(6));
                map.put(mm, cursor.getString(7));
                map.put(ss, cursor.getString(8));
                map.put(place, cursor.getString(9));
                map.put(latdd, cursor.getString(10));
                map.put(latmm, cursor.getString(11));
                map.put(latNS, cursor.getString(12));
                map.put(londd, cursor.getString(13));
                map.put(lonmm, cursor.getString(14));
                map.put(lonEW, cursor.getString(15));
                map.put("tzpm", cursor.getString(16));
                map.put(tzhh, cursor.getString(17));
                map.put(tzmm, cursor.getString(18));
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
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> selectAllIds() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.DBClass_Horary.selectAllIds():java.util.ArrayList");
    }
}
