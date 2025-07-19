package com.cuspal.interlinks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBController_place extends SQLiteOpenHelper {
    private static final String databasename = "OpenSourceAtlas.db";
    private static final String tablename = "place";
    private static final int versioncode = 2;

    public DBController_place(Context context) {
        super(context, databasename, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase database) {
    }

    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
    }

    public ArrayList<HashMap<String, String>> getAllPlace(String arg, String arg1) {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM place a INNER JOIN country b ON a.country=b.id WHERE b.name = ? AND a.name LIKE '%" + arg1 + "%' COLLATE NOCASE", new String[]{String.valueOf(arg)});
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("name", cursor.getString(1));
                map.put("country", cursor.getString(2));
                map.put("state", cursor.getString(3));
                map.put("latDeg", cursor.getString(4));
                map.put("latMnt", cursor.getString(5));
                map.put("latSec", cursor.getString(6));
                map.put("latDir", cursor.getString(7));
                map.put("longDeg", cursor.getString(8));
                map.put("lonMnt", cursor.getString(9));
                map.put("lonSec", cursor.getString(10));
                map.put("lonDir", cursor.getString(11));
                map.put("elevation", cursor.getString(12));
                map.put("timeZone", cursor.getString(13));
                map.put(NotificationCompat.CATEGORY_STATUS, cursor.getString(14));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        return wordList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x00ca A[Catch:{ Exception -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> selectAllIds(java.lang.String r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00d1 }
            r0.<init>()     // Catch:{ Exception -> 0x00d1 }
            android.database.sqlite.SQLiteDatabase r1 = r9.getReadableDatabase()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r2 = "SELECT * FROM place a LEFT JOIN state b ON a.state=b.id LEFT JOIN country c ON a.country=c.id LEFT JOIN timezone d ON a.timezone=d.id WHERE a.name = ? COLLATE NOCASE"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00d1 }
            r5 = 0
            r4[r5] = r10     // Catch:{ Exception -> 0x00d1 }
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch:{ Exception -> 0x00d1 }
            if (r4 == 0) goto L_0x00c8
            boolean r6 = r4.moveToFirst()     // Catch:{ Exception -> 0x00d1 }
            if (r6 == 0) goto L_0x00c8
        L_0x001d:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00d1 }
            r6.<init>()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "id"
            java.lang.String r8 = r4.getString(r5)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "place"
            java.lang.String r8 = r4.getString(r3)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "state"
            r8 = 16
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "country"
            r8 = 19
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "latDeg"
            r8 = 4
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "latMnt"
            r8 = 5
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "latSec"
            r8 = 6
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "latDir"
            r8 = 7
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "longDeg"
            r8 = 8
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "longMnt"
            r8 = 9
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "longSec"
            r8 = 10
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "longDir"
            r8 = 11
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "tzPM"
            r8 = 24
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "tzHH"
            r8 = 22
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "tzMM"
            r8 = 23
            java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x00d1 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00d1 }
            r0.add(r6)     // Catch:{ Exception -> 0x00d1 }
            boolean r7 = r4.moveToNext()     // Catch:{ Exception -> 0x00d1 }
            if (r7 != 0) goto L_0x001d
        L_0x00c8:
            if (r4 == 0) goto L_0x00cd
            r4.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00cd:
            r1.close()     // Catch:{ Exception -> 0x00d1 }
            return r0
        L_0x00d1:
            r0 = move-exception
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.DBController_place.selectAllIds(java.lang.String):java.util.ArrayList");
    }

    public List<String> getAllLabels() {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + "country" + " ORDER BY name", (String[]) null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
