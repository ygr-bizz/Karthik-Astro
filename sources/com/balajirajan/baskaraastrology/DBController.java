package com.cuspal.interlinks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    private static final String databasename = "Clientinfo";
    private static final String day = "day";
    private static final String hh = "hh";
    private static final String id = "ID";
    private static final String latdd = "latdd";
    private static final String londd = "londd";
    private static final String mm = "mm";
    private static final String month = "month";
    private static final String name = "name";
    private static final String place = "place";
    private static final String ss = "ss";
    private static final String tablename = "clientdata";
    private static final String tcPM = "tcPM";
    private static final String tzPM = "tzPM";
    private static final int versioncode = 4;
    private static final String year = "year";

    public DBController(Context context) {
        super(context, databasename, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE IF NOT EXISTS clientdata(ID integer primary key, name text, day text, month text, year text, hh text, mm text, ss text, place text, latdd text,londd text, tzPM text,tcPM text )");
    }

    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        database.execSQL("DROP TABLE IF EXISTS clientdata");
        onCreate(database);
    }

    public ArrayList<HashMap<String, String>> getAllPlace() {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM clientdata", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put(name, cursor.getString(1));
                map.put(day, cursor.getString(2));
                map.put(month, cursor.getString(3));
                map.put(year, cursor.getString(4));
                map.put(hh, cursor.getString(5));
                map.put(mm, cursor.getString(6));
                map.put(ss, cursor.getString(7));
                map.put(place, cursor.getString(8));
                map.put(latdd, cursor.getString(9));
                map.put(londd, cursor.getString(10));
                map.put("tzpm", cursor.getString(11));
                map.put("tcpm", cursor.getString(12));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00af A[Catch:{ Exception -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> selectAllIds() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.DBController.selectAllIds():java.util.ArrayList");
    }
}
