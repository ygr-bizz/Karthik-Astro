package com.cuspal.interlinks;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.cuspal.interlinks.TestDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

public class Main_input extends AppCompatActivity implements TestDialog.EditNameDialogListener {
    DBClass_All controller = new DBClass_All(this);
    Context ct;
    String dataPath;
    public Global_Log mGlobals;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main_input);
        SetRPDate();
        Context applicationContext = getApplicationContext();
        this.ct = applicationContext;
        this.dataPath = getFilePath(applicationContext);
        this.mGlobals = new Global_Log((Context) null, this.dataPath + "/log/");
        save_global();
        this.mGlobals.AppendLog("Main_Input : Global Data Saved");
        final EditText nicknameText = (EditText) findViewById(R.id.edit_name);
        nicknameText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != 0 || keyCode != 66) {
                    return false;
                }
                String obj = nicknameText.getText().toString();
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_run)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Main_input.this.mGlobals.AppendLog("Main_Input : Start Pick Date now");
                    Main_input.this.save_global();
                    Global.ishorary = false;
                    Main_input.this.startActivity(new Intent(Main_input.this, Main_details_tab.class));
                    Global.isrun = true;
                    Main_input.this.onPause();
                    Main_input.this.mGlobals.AppendLog("Main_Input : End Pick Date now");
                } catch (Exception es) {
                    Main_input.this.WriteTrace(es.toString());
                }
            }
        });
        ((Button) findViewById(R.id.btn_help)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input.this.mGlobals.AppendLog("Main_Input : Start Help Screen");
                Main_input.this.startActivity(new Intent(Main_input.this, help.class));
                Main_input.this.onPause();
                Main_input.this.mGlobals.AppendLog("Main_Input : End Help Screen");
            }
        });
        ((Button) findViewById(R.id.btn_RP)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input.this.SetRPDate();
            }
        });
        ((Button) findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Main_input.this.mGlobals.AppendLog("Main_Input : Start Client Screen");
                    Main_input.this.startActivity(new Intent(Main_input.this, ClientList.class));
                    Main_input.this.onPause();
                    Main_input.this.mGlobals.AppendLog("Main_Input : End Client Screen");
                } catch (Exception es) {
                    PrintStream printStream = System.out;
                    printStream.println("Stacktrace " + es.toString());
                    Main_input.this.WriteTrace(es.toString());
                }
            }
        });
        ((Button) findViewById(R.id.btn_place)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Main_input.this.mGlobals.AppendLog("Main_Input : Start Place Screen");
                    Main_input.this.onPause();
                    Main_input.this.mGlobals.AppendLog("Main_Input : End Place Screen");
                    FragmentManager fragmentManager = Main_input.this.getFragmentManager();
                    new TestDialog().show(Main_input.this.getSupportFragmentManager().beginTransaction(), "fragment_name");
                } catch (Exception es) {
                    PrintStream printStream = System.out;
                    printStream.println("Stacktrace " + es.toString());
                    Main_input.this.WriteTrace(es.toString());
                }
            }
        });
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main_input.this.mGlobals.AppendLog("Main_Input : Start Save Client");
                EditText name = (EditText) Main_input.this.findViewById(R.id.edit_name);
                EditText dd = (EditText) Main_input.this.findViewById(R.id.Day);
                EditText mm = (EditText) Main_input.this.findViewById(R.id.Mon);
                EditText yy = (EditText) Main_input.this.findViewById(R.id.Year);
                EditText hh = (EditText) Main_input.this.findViewById(R.id.bHH);
                EditText mi = (EditText) Main_input.this.findViewById(R.id.bMM);
                EditText ss = (EditText) Main_input.this.findViewById(R.id.bSS);
                EditText place = (EditText) Main_input.this.findViewById(R.id.editText1);
                EditText latdd = (EditText) Main_input.this.findViewById(R.id.latDD);
                EditText londd = (EditText) Main_input.this.findViewById(R.id.lonDD);
                EditText tzPM = (EditText) Main_input.this.findViewById(R.id.TzPM);
                EditText tcPM = (EditText) Main_input.this.findViewById(R.id.TcPM);
                Global.isrun = false;
                try {
                    Main_input.this.controller = new DBClass_All(Main_input.this.getApplicationContext());
                    SQLiteDatabase db = Main_input.this.controller.getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    EditText editText = name;
                    try {
                        cv.put("name", name.getText().toString());
                        cv.put("day", dd.getText().toString());
                        cv.put("month", mm.getText().toString());
                        cv.put("year", yy.getText().toString());
                        cv.put("hh", hh.getText().toString());
                        cv.put("mm", mi.getText().toString());
                        cv.put("ss", ss.getText().toString());
                        cv.put("place", place.getText().toString());
                        cv.put("latdd", latdd.getText().toString());
                        cv.put("londd", londd.getText().toString());
                        cv.put("tzPM", tzPM.getText().toString());
                        cv.put("tcPM", tcPM.getText().toString());
                        EditText editText2 = dd;
                    } catch (Exception e) {
                        ex = e;
                        EditText editText3 = dd;
                        Toast.Toasty(Main_input.this.getApplicationContext(), ex.getMessage(), 0);
                        Main_input.this.mGlobals.AppendLog("Main_Input : End Save Client");
                    }
                    try {
                        int result = (int) db.insert("clientdata", (String) null, cv);
                        db.close();
                        if (result < 0) {
                            int i = result;
                            Toast.Toasty(Main_input.this.getApplicationContext(), "ERROR Saving", 0);
                        } else {
                            Toast.Toasty(Main_input.this.getApplicationContext(), "Details added Successfully", 1);
                        }
                    } catch (Exception e2) {
                        ex = e2;
                        Toast.Toasty(Main_input.this.getApplicationContext(), ex.getMessage(), 0);
                        Main_input.this.mGlobals.AppendLog("Main_Input : End Save Client");
                    }
                } catch (Exception e3) {
                    ex = e3;
                    EditText editText4 = name;
                    EditText editText5 = dd;
                    Toast.Toasty(Main_input.this.getApplicationContext(), ex.getMessage(), 0);
                    Main_input.this.mGlobals.AppendLog("Main_Input : End Save Client");
                }
                Main_input.this.mGlobals.AppendLog("Main_Input : End Save Client");
            }
        });
        ((Button) findViewById(R.id.btn_now)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText dd = (EditText) Main_input.this.findViewById(R.id.Day);
                EditText mm = (EditText) Main_input.this.findViewById(R.id.Mon);
                Calendar cal = Calendar.getInstance();
                Date date = cal.getTime();
                String stringDay = (String) DateFormat.format("dd", date);
                Calendar calendar = cal;
                String stringMonth = (String) DateFormat.format("MM", date);
                String stringyear = (String) DateFormat.format("yyyy", date);
                EditText RPss = (EditText) Main_input.this.findViewById(R.id.RP_bSS);
                String stringhour = (String) DateFormat.format("HH", date);
                EditText RPmi = (EditText) Main_input.this.findViewById(R.id.RP_bMM);
                String stringmintue = (String) DateFormat.format("mm", date);
                EditText RPhh = (EditText) Main_input.this.findViewById(R.id.RP_bHH);
                String stringsecond = (String) DateFormat.format("ss", date);
                ((EditText) Main_input.this.findViewById(R.id.RP_Day)).setText(stringDay);
                ((EditText) Main_input.this.findViewById(R.id.RP_Mon)).setText(stringMonth);
                ((EditText) Main_input.this.findViewById(R.id.RP_Year)).setText(stringyear);
                dd.setText(stringDay);
                mm.setText(stringMonth);
                ((EditText) Main_input.this.findViewById(R.id.Year)).setText(stringyear);
                ((EditText) Main_input.this.findViewById(R.id.bHH)).setText(stringhour);
                ((EditText) Main_input.this.findViewById(R.id.bMM)).setText(stringmintue);
                ((EditText) Main_input.this.findViewById(R.id.bSS)).setText(stringsecond);
                String str = stringyear;
                RPhh.setText(stringhour);
                RPmi.setText(stringmintue);
                EditText RPss2 = RPss;
                RPss2.setText(stringsecond);
                Global.rp = true;
                EditText editText = RPss2;
                EditText editText2 = dd;
                EditText editText3 = mm;
                Toast.Toasty(Main_input.this.getApplicationContext(), "Current Time Changed!", 2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void SetRPDate() {
        Date date = Calendar.getInstance().getTime();
        ((EditText) findViewById(R.id.RP_Day)).setText((String) DateFormat.format("dd", date));
        ((EditText) findViewById(R.id.RP_Mon)).setText((String) DateFormat.format("MM", date));
        ((EditText) findViewById(R.id.RP_Year)).setText((String) DateFormat.format("yyyy", date));
        ((EditText) findViewById(R.id.RP_bHH)).setText((String) DateFormat.format("HH", date));
        ((EditText) findViewById(R.id.RP_bMM)).setText((String) DateFormat.format("mm", date));
        ((EditText) findViewById(R.id.RP_bSS)).setText((String) DateFormat.format("ss", date));
    }

    public void onResume() {
        super.onResume();
        if (Global.isrun) {
            EditText latdd = (EditText) findViewById(R.id.latDD);
            ((EditText) findViewById(R.id.Day)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.dd)}));
            ((EditText) findViewById(R.id.Mon)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.mm)}));
            ((EditText) findViewById(R.id.Year)).setText(String.format("%04d", new Object[]{Integer.valueOf(Global.yy)}));
            ((EditText) findViewById(R.id.bHH)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.hh)}));
            ((EditText) findViewById(R.id.bMM)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.min)}));
            ((EditText) findViewById(R.id.bSS)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.ss)}));
            ((EditText) findViewById(R.id.editText1)).setText(Global.Loc);
            latdd.setText(String.format("%03d:%02d:%s", new Object[]{Integer.valueOf(Global.latdd), Integer.valueOf(Global.latmm), Global.latNS}));
            EditText editText = latdd;
            ((EditText) findViewById(R.id.lonDD)).setText(String.format("%03d:%02d:%s", new Object[]{Integer.valueOf(Global.londd), Integer.valueOf(Global.lonmm), Global.lonEW}));
            ((EditText) findViewById(R.id.TzPM)).setText(String.format("%s:%02d:%02d", new Object[]{Global.TzPM, Integer.valueOf(Global.TzHH), Integer.valueOf(Global.TzMM)}));
            ((EditText) findViewById(R.id.TcPM)).setText(String.format("%s:%02d:%02d", new Object[]{Global.TcPM, Integer.valueOf(Global.TcHH), Integer.valueOf(Global.TcMM)}));
            ((EditText) findViewById(R.id.edit_name)).setText(Global.Name);
        }
        if (Global.p_select) {
            ((EditText) findViewById(R.id.editText1)).setText(Global.Loc);
            ((EditText) findViewById(R.id.latDD)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.latdd)}));
            ((EditText) findViewById(R.id.lonDD)).setText(String.format("%02d", new Object[]{Integer.valueOf(Global.londd)}));
            ((EditText) findViewById(R.id.TzPM)).setText(String.format("%s:%02d:%02d", new Object[]{Global.TzPM, Integer.valueOf(Global.TzHH), Integer.valueOf(Global.TzMM)}));
            ((EditText) findViewById(R.id.TcPM)).setText(String.format("%s:%02d:%02d", new Object[]{Global.TcPM, Integer.valueOf(Global.TcHH), Integer.valueOf(Global.TcMM)}));
            return;
        }
    }

    /* access modifiers changed from: private */
    public void save_global() {
        EditText et = (EditText) findViewById(R.id.Day);
        EditText et1 = (EditText) findViewById(R.id.Mon);
        EditText etRPDay = (EditText) findViewById(R.id.RP_Day);
        EditText et15 = (EditText) findViewById(R.id.TcPM);
        EditText etRPHH = (EditText) findViewById(R.id.RP_bHH);
        EditText et12 = (EditText) findViewById(R.id.TzPM);
        EditText et11 = (EditText) findViewById(R.id.editText1);
        String sTextRPDay = etRPDay.getText().toString();
        EditText editText = etRPDay;
        int rpbday = new Integer(sTextRPDay).intValue();
        Global.rpdd = rpbday;
        String str = sTextRPDay;
        String sTextRPMon = ((EditText) findViewById(R.id.RP_Mon)).getText().toString();
        int i = rpbday;
        int rpbMon = new Integer(sTextRPMon).intValue();
        Global.rpmm = rpbMon;
        String str2 = sTextRPMon;
        String sTextRPYear = ((EditText) findViewById(R.id.RP_Year)).getText().toString();
        int i2 = rpbMon;
        Global.rpyy = new Integer(sTextRPYear).intValue();
        String str3 = sTextRPYear;
        String sTextRPHH = etRPHH.getText().toString();
        EditText editText2 = etRPHH;
        int rpbHH = new Integer(sTextRPHH).intValue();
        Global.rphh = rpbHH;
        String str4 = sTextRPHH;
        String sTextRPMM = ((EditText) findViewById(R.id.RP_bMM)).getText().toString();
        int i3 = rpbHH;
        int rpbMM = new Integer(sTextRPMM).intValue();
        Global.rpmin = rpbMM;
        String str5 = sTextRPMM;
        String sTextRPSS = ((EditText) findViewById(R.id.RP_bSS)).getText().toString();
        int i4 = rpbMM;
        Global.rpss = new Integer(sTextRPSS).intValue();
        String str6 = sTextRPSS;
        String sTextRPSS2 = et.getText().toString();
        EditText editText3 = et;
        int bday = new Integer(sTextRPSS2).intValue();
        Global.dd = bday;
        String str7 = sTextRPSS2;
        String sTextFromET = et1.getText().toString();
        int i5 = bday;
        int bmonth = new Integer(sTextFromET).intValue();
        Global.mm = bmonth;
        String str8 = sTextFromET;
        String sTextFromET1 = ((EditText) findViewById(R.id.Year)).getText().toString();
        int i6 = bmonth;
        int byear = new Integer(sTextFromET1).intValue();
        Global.yy = byear;
        String str9 = sTextFromET1;
        int i7 = byear;
        String blatDD = ((EditText) findViewById(R.id.latDD)).getText().toString();
        String[] strArray = blatDD.split(":");
        Global.latdd = Integer.parseInt(strArray[0]);
        Global.latmm = Integer.parseInt(strArray[1]);
        Global.latNS = strArray[2];
        String str10 = blatDD;
        String blatDD2 = ((EditText) findViewById(R.id.lonDD)).getText().toString();
        String[] strArray2 = blatDD2.split(":");
        Global.londd = Integer.parseInt(strArray2[0]);
        Global.lonmm = Integer.parseInt(strArray2[1]);
        Global.lonEW = strArray2[2];
        String str11 = blatDD2;
        String sTextFromET7 = ((EditText) findViewById(R.id.bHH)).getText().toString();
        EditText editText4 = et1;
        int bhh = new Integer(sTextFromET7).intValue();
        Global.hh = bhh;
        String str12 = sTextFromET7;
        String sTextFromET72 = ((EditText) findViewById(R.id.bMM)).getText().toString();
        int i8 = bhh;
        int bmm = new Integer(sTextFromET72).intValue();
        Global.min = bmm;
        String str13 = sTextFromET72;
        String sTextFromET8 = ((EditText) findViewById(R.id.bSS)).getText().toString();
        int i9 = bmm;
        Global.ss = new Integer(sTextFromET8).intValue();
        Global.Name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
        Global.Loc = et11.getText().toString();
        String str14 = sTextFromET8;
        String Tzpm = et12.getText().toString();
        String[] strArray3 = Tzpm.split(":");
        Global.TzPM = strArray3[0];
        Global.TzHH = Integer.parseInt(strArray3[1]);
        Global.TzMM = Integer.parseInt(strArray3[2]);
        String str15 = Tzpm;
        String[] strArray4 = et15.getText().toString().split(":");
        Global.TcPM = strArray4[0];
        Global.TcHH = Integer.parseInt(strArray4[1]);
        Global.TcMM = Integer.parseInt(strArray4[2]);
    }

    public String getFilePath(Context ct2) {
        return ct2.getFilesDir() + "/";
    }

    public void onFinishEditDialog(Boolean isrun, String PlaceText, String LatitudeText, String LongitudeText, String TzoneText) {
        if (isrun.booleanValue()) {
            ((EditText) findViewById(R.id.editText1)).setText(PlaceText);
            ((EditText) findViewById(R.id.latDD)).setText(LatitudeText);
            ((EditText) findViewById(R.id.lonDD)).setText(LongitudeText);
            ((EditText) findViewById(R.id.TzPM)).setText(TzoneText);
        }
    }

    public void WriteTrace(String tStr) {
        try {
            File file = new File("/data/user/0/com.cuspal.interlinks/databases/trace.txt");
            FileOutputStream fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            fop.write(tStr.getBytes());
            fop.flush();
            fop.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
