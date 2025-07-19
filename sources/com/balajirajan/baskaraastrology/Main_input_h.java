package com.cuspal.interlinks;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main_input_h extends AppCompatActivity {
    public static final String Language = "Lang";
    public static final String LatitueDD = "LatDD";
    public static final String LatitueMM = "LatMM";
    public static final String LatitueNS = "LatNS";
    public static final String LongitudeDD = "LonDD";
    public static final String LongitudeEW = "LonEW";
    public static final String LongitudeMM = "LonMM";
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String NativePlace = "Place";
    public static final String TimecHH = "TcHH";
    public static final String TimecMM = "TcMM";
    public static final String TimecPM = "TcPM";
    public static final String TimezHH = "TzHH";
    public static final String TimezMM = "TzMM";
    public static final String TimezPM = "TzPM";
    EditText Lang;
    EditText Place;
    EditText TcHH;
    EditText TcMM;
    EditText TcPM;
    EditText TzHH;
    EditText TzMM;
    EditText TzPM;
    DBClass_All con;
    DBClass_Horary controller;
    Context ct;
    String dataPath;
    EditText latNS;
    EditText latdd;
    EditText latmm;
    EditText lonEW;
    EditText londd;
    EditText lonmm;
    public Global_Log mGlobals;
    SharedPreferences sharedpreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main_input_hora);
        Context applicationContext = getApplicationContext();
        this.ct = applicationContext;
        this.dataPath = getFilePath(applicationContext);
        Global_Log global_Log = new Global_Log((Context) null, this.dataPath + "/log/");
        this.mGlobals = global_Log;
        global_Log.AppendLog("Main_Input : Global Data Saved");
        this.Place = (EditText) findViewById(R.id.editText1);
        this.latdd = (EditText) findViewById(R.id.latDD);
        this.latmm = (EditText) findViewById(R.id.latMM);
        this.latNS = (EditText) findViewById(R.id.latNS);
        this.londd = (EditText) findViewById(R.id.lonDD);
        this.lonmm = (EditText) findViewById(R.id.lonMM);
        this.lonEW = (EditText) findViewById(R.id.latEW);
        this.TzHH = (EditText) findViewById(R.id.TzHH);
        this.TzMM = (EditText) findViewById(R.id.TzMM);
        this.TzPM = (EditText) findViewById(R.id.TzPM);
        this.TcHH = (EditText) findViewById(R.id.TcHH);
        this.TcMM = (EditText) findViewById(R.id.TcMM);
        this.TcPM = (EditText) findViewById(R.id.TcPM);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", 0);
        this.sharedpreferences = sharedPreferences;
        this.Place.setText(sharedPreferences.getString("Place", (String) null));
        this.latdd.setText(this.sharedpreferences.getString("LatDD", (String) null));
        this.latmm.setText(this.sharedpreferences.getString("LatMM", (String) null));
        this.latNS.setText(this.sharedpreferences.getString("LatNS", (String) null));
        this.londd.setText(this.sharedpreferences.getString("LonDD", (String) null));
        this.lonmm.setText(this.sharedpreferences.getString("LonMM", (String) null));
        this.lonEW.setText(this.sharedpreferences.getString("LonEW", (String) null));
        this.TcHH.setText(this.sharedpreferences.getString("TcHH", (String) null));
        this.TcMM.setText(this.sharedpreferences.getString("TcMM", (String) null));
        this.TcPM.setText(this.sharedpreferences.getString("TcPM", (String) null));
        this.TzHH.setText(this.sharedpreferences.getString("TzHH", (String) null));
        this.TzMM.setText(this.sharedpreferences.getString("TzMM", (String) null));
        this.TzPM.setText(this.sharedpreferences.getString("TzPM", (String) null));
        EditText editText = (EditText) findViewById(R.id.edit_name);
        ((EditText) findViewById(R.id.HoNo)).setText(String.valueOf(new Random(System.currentTimeMillis()).nextInt((249 - 1) + 1) + 1));
        ((Button) findViewById(R.id.btn_run)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText et = (EditText) Main_input_h.this.findViewById(R.id.Day);
                String sTextFromET = et.getText().toString();
                int bday = new Integer(sTextFromET).intValue();
                Global.dd = bday;
                Global.mm = new Integer(((EditText) Main_input_h.this.findViewById(R.id.Mon)).getText().toString()).intValue();
                Global.yy = new Integer(((EditText) Main_input_h.this.findViewById(R.id.Year)).getText().toString()).intValue();
                Global.latdd = new Integer(((EditText) Main_input_h.this.findViewById(R.id.latDD)).getText().toString()).intValue();
                Global.latmm = new Integer(((EditText) Main_input_h.this.findViewById(R.id.latMM)).getText().toString()).intValue();
                EditText editText = et;
                String str = sTextFromET;
                EditText etLatNS = (EditText) Main_input_h.this.findViewById(R.id.latNS);
                String sTextLatNS = etLatNS.getText().toString();
                Global.latNS = sTextLatNS;
                EditText editText2 = etLatNS;
                String str2 = sTextLatNS;
                EditText et5 = (EditText) Main_input_h.this.findViewById(R.id.lonDD);
                String sTextFromET5 = et5.getText().toString();
                EditText editText3 = et5;
                int blondd = new Integer(sTextFromET5).intValue();
                Global.londd = blondd;
                int i = blondd;
                String str3 = sTextFromET5;
                EditText et6 = (EditText) Main_input_h.this.findViewById(R.id.lonMM);
                String sTextFromET6 = et6.getText().toString();
                EditText editText4 = et6;
                int blonmm = new Integer(sTextFromET6).intValue();
                Global.lonmm = blonmm;
                int i2 = blonmm;
                String str4 = sTextFromET6;
                EditText etLonEW = (EditText) Main_input_h.this.findViewById(R.id.latEW);
                String sTextLonEW = etLonEW.getText().toString();
                Global.lonEW = sTextLonEW;
                EditText editText5 = etLonEW;
                String str5 = sTextLonEW;
                EditText et7 = (EditText) Main_input_h.this.findViewById(R.id.bHH);
                String sTextFromET7 = et7.getText().toString();
                EditText editText6 = et7;
                int bhh = new Integer(sTextFromET7).intValue();
                Global.hh = bhh;
                int i3 = bhh;
                String str6 = sTextFromET7;
                EditText et8 = (EditText) Main_input_h.this.findViewById(R.id.bMM);
                String sTextFromET8 = et8.getText().toString();
                EditText editText7 = et8;
                int bmm = new Integer(sTextFromET8).intValue();
                Global.min = bmm;
                int i4 = bmm;
                String str7 = sTextFromET8;
                EditText et9 = (EditText) Main_input_h.this.findViewById(R.id.bSS);
                String sTextFromET9 = et9.getText().toString();
                EditText editText8 = et9;
                int bss = new Integer(sTextFromET9).intValue();
                Global.ss = bss;
                int i5 = bss;
                String str8 = sTextFromET9;
                EditText et10 = (EditText) Main_input_h.this.findViewById(R.id.edit_name);
                String sTextFromET10 = et10.getText().toString();
                String Name = sTextFromET10;
                EditText editText9 = et10;
                String str9 = sTextFromET10;
                EditText et11 = (EditText) Main_input_h.this.findViewById(R.id.HoNo);
                String sTextFromET11 = et11.getText().toString();
                EditText editText10 = et11;
                int Hno = new Integer(sTextFromET11).intValue();
                String str10 = sTextFromET11;
                int i6 = bday;
                EditText et12 = (EditText) Main_input_h.this.findViewById(R.id.TzPM);
                String sTextFromET12 = et12.getText().toString();
                Global.TzPM = sTextFromET12;
                EditText editText11 = et12;
                String str11 = sTextFromET12;
                EditText et13 = (EditText) Main_input_h.this.findViewById(R.id.TzHH);
                String sTextFromET13 = et13.getText().toString();
                EditText editText12 = et13;
                int Tzhh = new Integer(sTextFromET13).intValue();
                Global.TzHH = Tzhh;
                int i7 = Tzhh;
                String str12 = sTextFromET13;
                EditText et14 = (EditText) Main_input_h.this.findViewById(R.id.TzMM);
                String sTextFromET14 = et14.getText().toString();
                EditText editText13 = et14;
                int Tzmm = new Integer(sTextFromET14).intValue();
                Global.TzMM = Tzmm;
                Global.Hno = Hno;
                int i8 = Tzmm;
                StringBuilder sb = new StringBuilder();
                String str13 = sTextFromET14;
                sb.append(Name);
                sb.append(" (");
                sb.append(Hno);
                sb.append(")");
                Global.Name = sb.toString();
                Global.ishorary = true;
                int i9 = Hno;
                Main_input_h.this.startActivity(new Intent(Main_input_h.this, Main_details_tab.class));
                Main_input_h.this.onPause();
            }
        });
        ((Button) findViewById(R.id.btn_help)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input_h.this.save_global();
                Main_input_h.this.startActivity(new Intent(Main_input_h.this, help.class));
                Main_input_h.this.onPause();
            }
        });
        ((Button) findViewById(R.id.btn_now)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText dd = (EditText) Main_input_h.this.findViewById(R.id.Day);
                Date date = Calendar.getInstance().getTime();
                dd.setText((String) DateFormat.format("dd", date));
                ((EditText) Main_input_h.this.findViewById(R.id.Mon)).setText((String) DateFormat.format("MM", date));
                ((EditText) Main_input_h.this.findViewById(R.id.Year)).setText((String) DateFormat.format("yyyy", date));
                ((EditText) Main_input_h.this.findViewById(R.id.bHH)).setText((String) DateFormat.format("HH", date));
                ((EditText) Main_input_h.this.findViewById(R.id.bMM)).setText((String) DateFormat.format("mm", date));
                ((EditText) Main_input_h.this.findViewById(R.id.bSS)).setText((String) DateFormat.format("ss", date));
                EditText editText = dd;
                Toast.makeText(Main_input_h.this, "Current Time Changed!", 0).show();
            }
        });
        ((Button) findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input_h.this.save_global();
                Main_input_h.this.mGlobals.AppendLog("Main_Input : Start Client Screen");
                Main_input_h.this.startActivity(new Intent(Main_input_h.this, Client_hora.class));
                Main_input_h.this.onPause();
                Main_input_h.this.mGlobals.AppendLog("Main_Input : End Client Screen");
            }
        });
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input_h.this.mGlobals.AppendLog("Main_Input : Start Save Horary Details");
                EditText name = (EditText) Main_input_h.this.findViewById(R.id.edit_name);
                EditText hno = (EditText) Main_input_h.this.findViewById(R.id.HoNo);
                EditText dd = (EditText) Main_input_h.this.findViewById(R.id.Day);
                EditText mm = (EditText) Main_input_h.this.findViewById(R.id.Mon);
                EditText yy = (EditText) Main_input_h.this.findViewById(R.id.Year);
                EditText hh = (EditText) Main_input_h.this.findViewById(R.id.bHH);
                EditText mi = (EditText) Main_input_h.this.findViewById(R.id.bMM);
                EditText ss = (EditText) Main_input_h.this.findViewById(R.id.bSS);
                EditText place = (EditText) Main_input_h.this.findViewById(R.id.editText1);
                EditText latdd = (EditText) Main_input_h.this.findViewById(R.id.latDD);
                EditText latmm = (EditText) Main_input_h.this.findViewById(R.id.latMM);
                EditText latNS = (EditText) Main_input_h.this.findViewById(R.id.latNS);
                EditText londd = (EditText) Main_input_h.this.findViewById(R.id.lonDD);
                EditText editText = (EditText) Main_input_h.this.findViewById(R.id.lonMM);
                EditText editText2 = (EditText) Main_input_h.this.findViewById(R.id.latEW);
                EditText tzhh = (EditText) Main_input_h.this.findViewById(R.id.TzHH);
                EditText tzmm = (EditText) Main_input_h.this.findViewById(R.id.TzMM);
                EditText tzpm = (EditText) Main_input_h.this.findViewById(R.id.TzPM);
                EditText tchh = (EditText) Main_input_h.this.findViewById(R.id.TcHH);
                EditText tcmm = (EditText) Main_input_h.this.findViewById(R.id.TcMM);
                EditText tcpm = (EditText) Main_input_h.this.findViewById(R.id.TcPM);
                Global.isrun = false;
                try {
                    EditText londd2 = londd;
                    try {
                        Main_input_h.this.con = new DBClass_All(Main_input_h.this.getApplicationContext());
                        SQLiteDatabase db = Main_input_h.this.con.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        EditText editText3 = name;
                        try {
                            cv.put("name", name.getText().toString());
                            cv.put("Horno", hno.getText().toString());
                            cv.put("day", dd.getText().toString());
                            cv.put("month", mm.getText().toString());
                            cv.put("year", yy.getText().toString());
                            cv.put("hh", hh.getText().toString());
                            cv.put("mm", mi.getText().toString());
                            cv.put("ss", ss.getText().toString());
                            cv.put("place", place.getText().toString());
                            cv.put("latdd", latdd.getText().toString());
                            cv.put("latmm", latmm.getText().toString());
                            cv.put("latNS", latNS.getText().toString());
                            cv.put("londd", londd2.getText().toString());
                            cv.put("lonmm", londd2.getText().toString());
                            cv.put("lonEW", londd2.getText().toString());
                            cv.put("tzPM", tzpm.getText().toString());
                            cv.put("tzhh", tzhh.getText().toString());
                            cv.put("tzmm", tzmm.getText().toString());
                            cv.put("tcPM", tcpm.getText().toString());
                            cv.put("tchh", tchh.getText().toString());
                            cv.put("tcmm", tcmm.getText().toString());
                            EditText editText4 = hno;
                            try {
                                int result = (int) db.insert("clientdataHora", (String) null, cv);
                                db.close();
                                if (result < 0) {
                                    int i = result;
                                    Toast.Toasty(Main_input_h.this.getApplicationContext(), "ERROR Saving", 0);
                                } else {
                                    Toast.Toasty(Main_input_h.this.getApplicationContext(), "Details added Successfully", 1);
                                }
                            } catch (Exception e) {
                                ex = e;
                                Toast.Toasty(Main_input_h.this.getApplicationContext(), ex.getMessage(), 0);
                                Main_input_h.this.mGlobals.AppendLog("Main_Input : End Save Client");
                            }
                        } catch (Exception e2) {
                            ex = e2;
                            EditText editText5 = hno;
                            Toast.Toasty(Main_input_h.this.getApplicationContext(), ex.getMessage(), 0);
                            Main_input_h.this.mGlobals.AppendLog("Main_Input : End Save Client");
                        }
                    } catch (Exception e3) {
                        ex = e3;
                        EditText editText6 = name;
                        EditText editText7 = hno;
                        Toast.Toasty(Main_input_h.this.getApplicationContext(), ex.getMessage(), 0);
                        Main_input_h.this.mGlobals.AppendLog("Main_Input : End Save Client");
                    }
                } catch (Exception e4) {
                    ex = e4;
                    EditText editText8 = name;
                    EditText editText9 = hno;
                    EditText editText10 = londd;
                    Toast.Toasty(Main_input_h.this.getApplicationContext(), ex.getMessage(), 0);
                    Main_input_h.this.mGlobals.AppendLog("Main_Input : End Save Client");
                }
                Main_input_h.this.mGlobals.AppendLog("Main_Input : End Save Client");
            }
        });
    }

    /* access modifiers changed from: private */
    public void save_global() {
        EditText et7 = (EditText) findViewById(R.id.bHH);
        EditText et8 = (EditText) findViewById(R.id.bMM);
        EditText et9 = (EditText) findViewById(R.id.bSS);
        Global.Hno = new Integer(((EditText) findViewById(R.id.HoNo)).getText().toString()).intValue();
        Global.hh = new Integer(et7.getText().toString()).intValue();
        Global.min = new Integer(et8.getText().toString()).intValue();
        Global.ss = new Integer(et9.getText().toString()).intValue();
        Global.Name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
        EditText editText = et7;
        EditText EdtTxtBirthDay = (EditText) findViewById(R.id.Day);
        EditText editText2 = et8;
        EditText editText3 = et9;
        String SaveBirthDay = EdtTxtBirthDay.getText().toString();
        EditText editText4 = EdtTxtBirthDay;
        int SavebdayInt = new Integer(SaveBirthDay).intValue();
        Global.dd = SavebdayInt;
        String str = SaveBirthDay;
        String SaveBirthMonth = ((EditText) findViewById(R.id.Mon)).getText().toString();
        int i = SavebdayInt;
        int SavebMonthInt = new Integer(SaveBirthMonth).intValue();
        Global.mm = SavebMonthInt;
        String str2 = SaveBirthMonth;
        int i2 = SavebMonthInt;
        Global.yy = new Integer(((EditText) findViewById(R.id.Year)).getText().toString()).intValue();
    }

    public String getFilePath(Context ct2) {
        return ct2.getFilesDir() + "/";
    }

    public void onResume() {
        EditText hno;
        super.onResume();
        if (Global.isrun) {
            EditText name = (EditText) findViewById(R.id.edit_name);
            EditText hno2 = (EditText) findViewById(R.id.HoNo);
            EditText hh = (EditText) findViewById(R.id.bHH);
            EditText mi = (EditText) findViewById(R.id.bMM);
            EditText ss = (EditText) findViewById(R.id.bSS);
            ((EditText) findViewById(R.id.Day)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.dd)}));
            ((EditText) findViewById(R.id.Mon)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.mm)}));
            ((EditText) findViewById(R.id.Year)).setText(String.format("%04d", new Object[]{Integer.valueOf(Global.yy)}));
            if (new Integer(Global.Hno).intValue() <= 0) {
                EditText editText = (EditText) findViewById(R.id.HoNo);
                hno = hno2;
                Global.Hno = new Random(System.currentTimeMillis()).nextInt((249 - 1) + 1) + 1;
            } else {
                hno = hno2;
            }
            hno.setText(String.valueOf(Global.Hno));
            hh.setText(String.format("%02d", new Object[]{Integer.valueOf(Global.hh)}));
            mi.setText(String.format("%02d", new Object[]{Integer.valueOf(Global.min)}));
            ss.setText(String.format("%02d", new Object[]{Integer.valueOf(Global.ss)}));
            name.setText(Global.Name);
        }
        if (Global.p_select) {
            ((EditText) findViewById(R.id.editText1)).setText(Global.Loc);
            ((EditText) findViewById(R.id.HoNo)).setText(Global.Hno);
        }
    }
}
