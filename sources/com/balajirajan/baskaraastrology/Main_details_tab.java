package com.cuspal.interlinks;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.cuspal.interlinks.VimsottariDasa;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import swisseph.SweDate;
import swisseph.SwissEph;
import swisseph.TCPlanet;

public class Main_details_tab extends AppCompatActivity {
    public static final String DEST = "/quick_brown_fox_PDFUA.pdf";
    public static final String LatitueDD = "LatDD";
    public static final String LatitueMM = "LatMM";
    public static final String LatitueNS = "LatNS";
    public static final String LongitudeDD = "LonDD";
    public static final String LongitudeEW = "LonEW";
    public static final String LongitudeMM = "LonMM";
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String TimezHH = "TzHH";
    public static final String TimezMM = "TzMM";
    public static final String TimezPM = "TzPM";
    static double[] cusps = new double[13];
    static double[] dasaYears = {7.0d, 20.0d, 6.0d, 10.0d, 7.0d, 18.0d, 16.0d, 19.0d, 17.0d};
    static double newKPAyan;
    public static String[] pNames;
    static double[] pPos = new double[13];
    public static String[] pRasiNames;
    public static String[] pStarNames;
    public static String[] planetName1Tr;
    public static String[] planetName1TrR;
    public static String[] planetName2Tr;
    public static String[] sGraha;
    int ArudhaShift;
    double[] Nak_Table;
    byte P_JU = 4;
    byte P_KE = 8;
    byte P_MA = 2;
    byte P_ME = 3;
    byte P_MO = 1;
    byte P_RA = 7;
    byte P_SA = 6;
    byte P_SU = 0;
    byte P_VE = 5;
    float Size = 0.0f;
    double[][][] aDas;
    int[][][] aDasL;
    double[] acsc = new double[10];
    byte antpos;
    double[][] bDas;
    int[][] bDasL;
    byte butpos;
    String[] conSig0 = new String[12];
    String[] conSig1 = new String[12];
    String[] conSig11 = new String[12];
    String[] conSig2 = new String[12];
    Context ct;
    double dasaRemain;
    int dasaSeqStart;
    byte daslev;
    byte daspos;
    int day;
    double daysPerYear;
    int gdnPlanets;
    int gdnSigns;
    private final double[] hCuspI = new double[13];
    double hour;
    private final int[] incHouse = new int[14];
    int isTablet;
    double latitude;
    double longitude;
    double[] mDas;
    int[] mDasL = new int[10];
    int month;
    double moonDasaLeft;
    int nArudhas;
    int nDasa;
    int nDasas;
    int nLevel;
    int nLevels;
    int nSplLagnaShift;
    double[] nak_dur;
    int[] nak_int;
    double[] nak_pos;
    private final String[] ownBhava = new String[9];
    ArrayList<VimsottariDasa.sDasaData> pCurAntarDasaData;
    ArrayList<VimsottariDasa.sDasaData> pDasaData;
    ArrayList<VimsottariDasa.sDasaData> pDasaData_day;
    int[] pIdToDasaSeq;
    int[] pIdToDaySeq;
    double pMoonPos;
    double paramAyus;
    double passedPeriod;
    final int[] planet2Int = {8, 5, 0, 1, 2, 7, 4, 6, 3};
    double[] planetPrd;
    private final int[] posBhava = new int[9];
    double[][][][] sDas;
    int[][][][] sDasL;
    private final int[] sbLords = new int[9];
    private final String[] sbLordsOwn = new String[9];
    private final int[] sbLordsPos = new int[9];
    SharedPreferences sharedpreferences;
    byte soopos;
    double[] ssb_dur;
    double[] ssb_table;
    private final int[] stLords = new int[9];
    private final String[] stLordsOwn = new String[9];
    private final int[] stLordsPos = new int[9];
    private final int[] stSbLords = new int[9];
    private final String[] stSbLordsOwn = new String[9];
    private final int[] stSbLordsPos = new int[9];
    int startId;
    int[] sub1LordInt;
    double[] sub_dur;
    double[] sub_table;
    double tc;
    double totalAyus;
    double totalPeriod;
    double tz;
    int year;

    public Main_details_tab() {
        Class<double> cls = double.class;
        Class<int> cls2 = int.class;
        this.bDasL = (int[][]) Array.newInstance(cls2, new int[]{10, 10});
        this.aDasL = (int[][][]) Array.newInstance(cls2, new int[]{10, 10, 10});
        this.sDasL = (int[][][][]) Array.newInstance(cls2, new int[]{10, 10, 10, 10});
        this.mDas = new double[10];
        this.bDas = (double[][]) Array.newInstance(cls, new int[]{10, 10});
        this.aDas = (double[][][]) Array.newInstance(cls, new int[]{10, 10, 10});
        this.sDas = (double[][][][]) Array.newInstance(cls, new int[]{10, 10, 10, 10});
        this.nak_dur = new double[9];
        this.nak_int = new int[9];
        this.nak_pos = new double[9];
        this.sub_dur = new double[9];
        this.ssb_dur = new double[9];
        this.Nak_Table = new double[28];
        this.gdnSigns = 12;
        int i = 12 + 2;
        this.nArudhas = i;
        this.gdnPlanets = 9;
        int i2 = 9 + 1;
        this.ArudhaShift = i2;
        this.nSplLagnaShift = i2 + i;
        this.sub1LordInt = new int[9];
        this.pCurAntarDasaData = new ArrayList<>();
        this.pIdToDasaSeq = new int[]{2, 3, 4, 8, 6, 1, 7, 5, 0};
        this.dasaSeqStart = 0;
        this.totalPeriod = 120.0d;
        this.planetPrd = new double[]{7.0d, 20.0d, 6.0d, 10.0d, 7.0d, 18.0d, 16.0d, 19.0d, 17.0d};
        this.paramAyus = 120.0d;
        this.nLevels = 5;
        this.daysPerYear = 365.25d;
        this.totalAyus = 120.0d;
        this.nDasas = 9;
        this.pIdToDaySeq = new int[]{this.P_KE, this.P_VE, this.P_SU, this.P_MO, this.P_MA, this.P_RA, this.P_JU, this.P_SA, this.P_ME};
        this.pDasaData = new ArrayList<>();
        this.pDasaData_day = new ArrayList<>();
        this.sub_table = new double[10];
        this.ssb_table = new double[10];
        this.daspos = 0;
        this.daslev = 0;
        this.butpos = 0;
        this.antpos = 0;
        this.soopos = 0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main_details_tab);
        Initilization_Localization();
        Initialization_Screen();
        Initiization_Global();
        Initilization_Tabhost();
        calculate_all();
        Initilization_Tab_Datas();
        CalculateMahaDasa(pPos[this.P_MO], new SweDate(this.year, this.month, this.day, this.hour).getJulDay());
        GetMahaDasaString();
        Get_nak_data_Array((TableLayout) findViewById(R.id.TableLayout_LD));
        ((TextView) findViewById(R.id.thirukural)).setText("அன்பும் அறனும் உடைத்தாயின் இல்வாழ்க்கை\nபண்பும் பயனும் அது");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        if (r3.equals("Tamil") == false) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Initilization_Localization() {
        /*
            r10 = this;
            java.lang.String r0 = "MyPrefs"
            java.lang.String r1 = "Lang"
            r2 = 0
            android.content.SharedPreferences r3 = r10.getSharedPreferences(r0, r2)
            r10.sharedpreferences = r3
            r4 = 0
            java.lang.String r3 = r3.getString(r1, r4)
            java.lang.String r4 = "ta"
            if (r3 != 0) goto L_0x0040
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r4)
            android.content.Context r4 = r10.getBaseContext()
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            r4.locale = r2
            android.content.Context r5 = r10.getBaseContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.Context r6 = r10.getBaseContext()
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            r5.updateConfiguration(r4, r6)
            goto L_0x0102
        L_0x0040:
            r5 = -1
            int r6 = r3.hashCode()
            r7 = 60895824(0x3a13250, float:9.474281E-37)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L_0x006a
            r7 = 69730482(0x42800b2, float:1.9748624E-36)
            if (r6 == r7) goto L_0x0060
            r7 = 80573603(0x4cd74a3, float:4.8302382E-36)
            if (r6 == r7) goto L_0x0057
        L_0x0056:
            goto L_0x0074
        L_0x0057:
            java.lang.String r6 = "Tamil"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x0056
            goto L_0x0075
        L_0x0060:
            java.lang.String r2 = "Hindi"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0056
            r2 = 2
            goto L_0x0075
        L_0x006a:
            java.lang.String r2 = "English"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0056
            r2 = 1
            goto L_0x0075
        L_0x0074:
            r2 = -1
        L_0x0075:
            if (r2 == 0) goto L_0x00d7
            if (r2 == r9) goto L_0x00aa
            if (r2 == r8) goto L_0x007d
            goto L_0x0102
        L_0x007d:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r4 = "hi"
            r2.<init>(r4)
            android.content.Context r4 = r10.getBaseContext()
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            r4.locale = r2
            android.content.Context r5 = r10.getBaseContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.Context r6 = r10.getBaseContext()
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            r5.updateConfiguration(r4, r6)
            goto L_0x0102
        L_0x00aa:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r4 = "en"
            r2.<init>(r4)
            android.content.Context r4 = r10.getBaseContext()
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            r4.locale = r2
            android.content.Context r5 = r10.getBaseContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.Context r6 = r10.getBaseContext()
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            r5.updateConfiguration(r4, r6)
            goto L_0x0102
        L_0x00d7:
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r4)
            android.content.Context r4 = r10.getBaseContext()
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            r4.locale = r2
            android.content.Context r5 = r10.getBaseContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.Context r6 = r10.getBaseContext()
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            r5.updateConfiguration(r4, r6)
        L_0x0102:
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903044(0x7f030004, float:1.7412895E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            planetName1Tr = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903045(0x7f030005, float:1.7412897E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            planetName1TrR = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903041(0x7f030001, float:1.7412889E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            pNames = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903046(0x7f030006, float:1.7412899E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            planetName2Tr = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903042(0x7f030002, float:1.741289E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            pRasiNames = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903043(0x7f030003, float:1.7412893E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            pStarNames = r2
            android.content.res.Resources r2 = r10.getResources()
            r4 = 2130903047(0x7f030007, float:1.74129E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            sGraha = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.Main_details_tab.Initilization_Localization():void");
    }

    /* access modifiers changed from: protected */
    public void DrawStringinRect(String msg, int x, int y, int x1, int y1, int textsize, Canvas canvas) {
        Paint myPaint = new Paint();
        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect((float) x, (float) y, (float) x1, (float) y1, myPaint);
        DrawMultiline(msg, x + 10, y + 5, canvas);
    }

    public void DrawRectangle(int x, int x1, int y, int y1, Canvas canvas) {
        Paint myPaint = new Paint();
        myPaint.setColor(Color.rgb(0, 0, 0));
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(1.0f);
        canvas.drawRect(100.0f, 100.0f, 200.0f, 200.0f, myPaint);
    }

    public void DrawMultiline(String str, int x, int y, Canvas canvas) {
        Paint myPaint = new Paint();
        myPaint.setTextAlign(Paint.Align.CENTER);
        for (String line : str.split("\n")) {
            canvas.drawText(line, (float) x, (float) y, myPaint);
            y = (int) (((float) y) + (-myPaint.ascent()) + myPaint.descent());
        }
    }

    public void DrawMultiline_12p(String str, int x, int y, Canvas canvas) {
        Paint myPaint = new Paint();
        myPaint.setTextSize(12.0f);
        for (String line : str.split("\n")) {
            canvas.drawText(line, (float) x, (float) y, myPaint);
            y = (int) (((float) y) + (-myPaint.ascent()) + myPaint.descent());
        }
    }

    public void Drawrectangle(int x, int y, int x1, int y1, Canvas convas) {
        Paint paint = new Paint();
        paint.setARGB(255, 0, 0, 0);
        convas.drawRect(new RectF((float) x, (float) y, (float) x1, (float) y1), paint);
    }

    public void DrawTextCanvas(String Text, int X, int Y, Canvas canvas, Typeface font, int Size2) {
        Paint paint = new Paint();
        paint.setARGB(255, 0, 0, 0);
        paint.setTypeface(font);
        paint.setTextSize((float) Size2);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(Text, (float) X, (float) Y, paint);
    }

    public void Initilization_Tab_Datas() {
        TableLayout CuspalTable = (TableLayout) findViewById(R.id.TableLayout_Cuspal);
        TableLayout AspectTable = (TableLayout) findViewById(R.id.TableLayout_Aspect_Conj);
        TableLayout allScoresTable = (TableLayout) findViewById(R.id.TableLayout_AllScores);
        TableLayout allScoresTable_01 = (TableLayout) findViewById(R.id.TableLayout_AllScores_01);
        TableLayout allScoresTable_02 = (TableLayout) findViewById(R.id.TableLayout_AllScores_02);
        TableLayout friendScoresTable = (TableLayout) findViewById(R.id.TableLayout_FriendScores);
        TableLayout dataTable = (TableLayout) findViewById(R.id.TableLayout_data);
        TableLayout RPtable = (TableLayout) findViewById(R.id.TableLayout_RP);
        CuspalTable.setLayoutMode(0);
        AspectTable.setLayoutMode(0);
        allScoresTable.setLayoutMode(0);
        allScoresTable_01.setLayoutMode(0);
        allScoresTable_02.setLayoutMode(0);
        friendScoresTable.setLayoutMode(0);
        dataTable.setLayoutMode(0);
        RPtable.setLayoutMode(0);
        Initilization_Rasi_Chart();
        Initilization_Navamsa_chart();
        initializeHeaderRow_aspect(AspectTable);
        initializeHeaderRow_kb(CuspalTable, AspectTable);
        initializeHeaderRow_P(allScoresTable);
        initializeHeaderRow_Significator(allScoresTable_01);
        initializeHeaderRow_Significator_cusp(allScoresTable_02);
        initializeHeaderRow_D01(friendScoresTable);
        initializeHeaderRow_Dt(dataTable);
        String[] sCurDasa = AstroCalc.kp_DasaShesha(pPos[1]);
        ((TextView) findViewById(R.id.txt_dasa)).setText(sCurDasa[0] + "\n" + sCurDasa[1]);
        initializeHeaderRow_RP(RPtable);
    }

    public void Initilization_Rasi_Chart() {
        PlotView plot_view = new PlotView(this);
        plot_view.setBackgroundColor(-1);
        ((LinearLayout) findViewById(R.id.scroll_layout)).addView(plot_view);
    }

    public void Initilization_Navamsa_chart() {
        PlotView_nava plot_view_nava = new PlotView_nava(this);
        plot_view_nava.setBackgroundColor(-1);
        ((LinearLayout) findViewById(R.id.Navamsa)).addView(plot_view_nava);
    }

    public float set_font_size(double device) {
        if (device > 2.0d) {
            return 18.0f;
        }
        return 11.5f;
    }

    public void Initiization_Global() {
        Integer tmp;
        Integer tmp2;
        Global.isrun = true;
        this.year = Global.yy;
        this.month = Global.mm;
        this.day = Global.dd;
        if (Global.latNS.contains("N")) {
            tmp = 1;
        } else {
            tmp = -1;
        }
        this.latitude = ((double) (Global.latdd * tmp.intValue())) + (((double) Global.latmm) / 60.0d);
        if (Global.lonEW.contains("E")) {
            tmp2 = 1;
        } else {
            tmp2 = -1;
        }
        this.longitude = ((double) (Global.londd * tmp2.intValue())) + (((double) Global.lonmm) / 60.0d);
        this.tz = ((double) Global.TzHH) + (((double) Global.TzMM) / 60.0d);
        this.tc = ((double) Global.TcHH) + (((double) Global.TcMM) / 60.0d);
        if (Global.TzPM.equals("+")) {
            this.hour = ((((double) Global.hh) + (((double) Global.min) / 60.0d)) + (((double) Global.ss) / 3600.0d)) - this.tz;
        } else {
            this.hour = ((double) Global.hh) + (((double) Global.min) / 60.0d) + (((double) Global.ss) / 3600.0d) + this.tz;
        }
        Log.e("BHour:", String.valueOf(this.hour));
    }

    public void Initialization_Screen() {
        int checkIsTablet = device_util.checkIsTablet(this);
        this.isTablet = checkIsTablet;
        this.Size = set_font_size((double) checkIsTablet);
    }

    public void Initilization_Tabhost() {
        TabHost host = (TabHost) findViewById(R.id.TabHost1);
        host.setup();
        Resources res = getResources();
        Drawable drawable1 = res.getDrawable(R.drawable.ic_event_black_24dp, getTheme());
        Drawable drawable2 = res.getDrawable(R.drawable.ic_grid_on_black_24dp, getTheme());
        Drawable drawable3 = res.getDrawable(R.drawable.ic_format_align_justify_black_24dp, getTheme());
        Drawable drawable4 = res.getDrawable(R.drawable.ic_insert_link_black_24dp, getTheme());
        Drawable drawable5 = res.getDrawable(R.drawable.ic_timeline_black_24dp, getTheme());
        Drawable drawable6 = res.getDrawable(R.drawable.ic_brightness_4_black_24dp, getTheme());
        Drawable drawable7 = res.getDrawable(R.drawable.ic_low_priority_black_24dp, getTheme());
        TabHost.TabSpec dataTab = host.newTabSpec("datatab");
        dataTab.setIndicator("", drawable1);
        dataTab.setContent(R.id.scrollviewdata);
        host.addTab(dataTab);
        TabHost.TabSpec rasiTab = host.newTabSpec("RasiTab");
        rasiTab.setIndicator("", drawable2);
        rasiTab.setContent(R.id.ScrollViewLagnadasa);
        host.addTab(rasiTab);
        TabHost.TabSpec CuspTab = host.newTabSpec("Cusptab");
        CuspTab.setIndicator("", drawable3);
        CuspTab.setContent(R.id.scrollviewCuspal);
        host.addTab(CuspTab);
        TabHost.TabSpec allScoresTab = host.newTabSpec("allTab");
        allScoresTab.setIndicator("", drawable4);
        allScoresTab.setContent(R.id.ScrollViewAllScores);
        host.addTab(allScoresTab);
        TabHost.TabSpec friendScoresTab = host.newTabSpec("friendsTab");
        friendScoresTab.setIndicator("", drawable5);
        Resources resources = res;
        friendScoresTab.setContent(R.id.ScrollViewFriendScores);
        host.addTab(friendScoresTab);
        TabHost.TabSpec Lagnadas_Tab = host.newTabSpec("LagnaTab");
        Lagnadas_Tab.setIndicator("", drawable6);
        TabHost.TabSpec tabSpec = friendScoresTab;
        Lagnadas_Tab.setContent(R.id.ScrollLdasa);
        host.addTab(Lagnadas_Tab);
        TabHost.TabSpec TransitChart_Tab = host.newTabSpec("Transit");
        TransitChart_Tab.setIndicator("", drawable7);
        TransitChart_Tab.setContent(R.id.ScrollTransitChart);
        host.addTab(TransitChart_Tab);
        host.setCurrentTabByTag("datatab");
    }

    public void UpdateNakshatraTable() {
        for (int i1 = 0; i1 <= 27; i1++) {
            this.Nak_Table[i1] = ((double) i1) * 13.333333333333334d;
        }
    }

    public double Search_Pos(double posVal) {
        for (int i2 = 0; i2 <= 26; i2++) {
            double[] dArr = this.Nak_Table;
            if (dArr[i2] <= posVal && posVal < dArr[i2 + 1]) {
                return dArr[i2];
            }
        }
        return 0.0d;
    }

    public void Get_nak_data_Array(TableLayout scoreTable) {
        String Str;
        TextView getCatno1;
        TableRow r;
        View view;
        TableLayout tableLayout = scoreTable;
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"DAS", "BHU", "AND", "YEAR", "S.DATE", "DMS", "SGN", "STL", "SBL"}, getResources().getColor(R.color.text_title));
        tableLayout.addView(headerRow);
        UpdateNakshatraTable();
        double a = new SweDate(this.year, this.month, this.day, 0.0d).getJulDay();
        newKPAyan = AstroCalc.get_ayan(a);
        int i = 1;
        double pos = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a, 1) - newKPAyan);
        int nakshatra_int = AstroCalc.kp_StarInt(Search_Pos(pos));
        double[] nakLookup = new double[9];
        double[] nakLookupTime = new double[9];
        int i2 = 0;
        double a2 = a;
        double d = pos;
        for (int i3 = 9; i2 < i3; i3 = 9) {
            nakLookup[i2] = this.Nak_Table[(nakshatra_int + i2) % 27] + 0.02d;
            double[] nakLookupTime2 = nakLookupTime;
            int i4 = i2;
            nakLookupTime2[i4] = GetNakshatraLogRangeInterPolution(a2, 1, nakLookup[i2]) + 7.0E-4d;
            this.nak_dur[i4] = nakLookupTime2[i4];
            this.nak_int[i4] = AstroCalc.kp_StarInt(nakLookupTime2[i4]);
            double cusp = AstroCalc.hp_Rnd0To360v(ComputeLagnaPos(this.nak_dur[i4]) - newKPAyan);
            double pos2 = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(this.nak_dur[i4], 1) - newKPAyan);
            this.nak_pos[i4] = pos2;
            LoadNakshatraData(cusp, pos2, this.nak_dur[i4], scoreTable);
            a2 += 1.0d;
            i2 = i4 + 1;
            nakLookupTime = nakLookupTime2;
            nakLookup = nakLookup;
        }
        int i5 = i2;
        double[] dArr = nakLookup;
        int j = 0;
        while (j < 10) {
            View view2 = tableLayout.getChildAt(j);
            TableRow r2 = (TableRow) view2;
            TextView getCatno12 = (TextView) r2.getChildAt(i);
            String Str2 = getCatno12.getText().toString();
            String charSequence = ((TextView) r2.getChildAt(2)).getText().toString();
            int k = 0;
            while (k < 9) {
                if (planetName2Tr[this.mDasL[k]].equals(Str2)) {
                    view = view2;
                    r = r2;
                    getCatno1 = getCatno12;
                    Str = Str2;
                    ((TextView) r2.getChildAt(3)).setText(kp_RevJday(this.mDas[k]));
                } else {
                    view = view2;
                    r = r2;
                    getCatno1 = getCatno12;
                    Str = Str2;
                }
                k++;
                view2 = view;
                r2 = r;
                getCatno12 = getCatno1;
                Str2 = Str;
            }
            TableRow tableRow = r2;
            TextView textView = getCatno12;
            String str = Str2;
            j++;
            i = 1;
        }
    }

    public void get_nak_data(TableLayout scoreTable) {
        int i;
        TableRow r;
        double a;
        View view;
        TableLayout tableLayout = scoreTable;
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"DAS", "BHU", "AND", "YEAR", "S.DATE", "DMS", "SGN", "STL", "SBL"}, getResources().getColor(R.color.text_title));
        tableLayout.addView(headerRow);
        UpdateNakshatraTable();
        double a2 = new SweDate(this.year, this.month, this.day, 0.0d).getJulDay();
        newKPAyan = AstroCalc.get_ayan(a2);
        int i2 = 0;
        while (true) {
            i = 9;
            if (i2 >= 9) {
                break;
            }
            double pos = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 1) - newKPAyan);
            double posTommorrow = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2 - 1.0d, 1) - newKPAyan);
            int nakshatra_int = AstroCalc.kp_StarInt(Search_Pos(pos));
            int YesterdayNakshatraInt = AstroCalc.kp_StarInt(posTommorrow);
            boolean isSkipped = false;
            int TodayNakshatraInt = AstroCalc.kp_StarInt(pos);
            if (TodayNakshatraInt == YesterdayNakshatraInt) {
                isSkipped = true;
            }
            int i3 = TodayNakshatraInt;
            boolean isSkipped2 = isSkipped;
            if (isSkipped2) {
                nakshatra_int++;
                a2 += 1.0d;
            }
            double a3 = a2;
            int nakshatra_int2 = nakshatra_int;
            boolean z = isSkipped2;
            double d = pos;
            double nakshStart = GetNakshatraLogRangeInterPolution(a3, 1, (((double) nakshatra_int2) * 360.0d) / 27.0d);
            double[] dArr = this.nak_dur;
            dArr[i2] = nakshStart + 7.0E-4d;
            this.nak_int[i2] = nakshatra_int2;
            double cusp = AstroCalc.hp_Rnd0To360v(ComputeLagnaPos(dArr[i2]) - newKPAyan);
            double pos2 = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(this.nak_dur[i2], 1) - newKPAyan);
            this.nak_pos[i2] = pos2;
            int i4 = YesterdayNakshatraInt;
            LoadNakshatraData(cusp, pos2, this.nak_dur[i2], scoreTable);
            a2 = a3 + 1.0d;
            i2++;
        }
        int j = 0;
        while (j < 10) {
            View view2 = tableLayout.getChildAt(j);
            TableRow r2 = (TableRow) view2;
            String Str = ((TextView) r2.getChildAt(1)).getText().toString();
            String charSequence = ((TextView) r2.getChildAt(2)).getText().toString();
            int k = 0;
            while (k < i) {
                if (planetName2Tr[this.mDasL[k]].equals(Str)) {
                    a = a2;
                    view = view2;
                    r = r2;
                    ((TextView) r2.getChildAt(3)).setText(kp_RevJday(this.mDas[k]));
                } else {
                    a = a2;
                    view = view2;
                    r = r2;
                }
                k++;
                view2 = view;
                a2 = a;
                r2 = r;
                i = 9;
            }
            View view3 = view2;
            TableRow tableRow = r2;
            j++;
            i = 9;
        }
    }

    public void LoadNakshatraData(double cusp, double pos, double StartDate, TableLayout scoreTable) {
        insertScoreRow_Ldasa_sub(scoreTable, new String[]{pStarNames[AstroCalc.GetStarLord(pos)], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(pos, false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(pos, true)), 0.0d), "", toDateString(StartDate, 5.5d), AstroCalc.toDM(cusp), pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(cusp))], pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(cusp))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusp), false)), 0.0d)});
    }

    static class Data {
        double x;
        double y;

        public Data(double x2, double y2) {
            this.x = x2;
            this.y = y2;
        }
    }

    public double GetNakshatraLogRangeInterPolution(double JulianDay, int Planet, double xValue) {
        double Ayanamsa = AstroCalc.get_ayan(JulianDay);
        return interpolate(new Data[]{new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay, Planet) - Ayanamsa), JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.125d, Planet) - Ayanamsa), 0.125d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.25d, Planet) - Ayanamsa), 0.25d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.375d, Planet) - Ayanamsa), 0.375d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.5d, Planet) - Ayanamsa), 0.5d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.625d, Planet) - Ayanamsa), 0.625d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.75d, Planet) - Ayanamsa), 0.75d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 0.875d, Planet) - Ayanamsa), 0.875d + JulianDay), new Data(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(JulianDay + 1.0d, Planet) - Ayanamsa), 1.0d + JulianDay)}, xValue, 4);
    }

    static double interpolate(Data[] f, double xi, int n) {
        double result = 0.0d;
        for (int i = 0; i < n; i++) {
            double term = f[i].y;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = ((xi - f[j].x) * term) / (f[i].x - f[j].x);
                }
            }
            result += term;
        }
        return result;
    }

    public double[] get_sub_ssb(double posVal) {
        byte b;
        double d = posVal;
        double[] nakBorders = new double[28];
        for (int i1 = 0; i1 <= 27; i1++) {
            nakBorders[i1] = (((double) i1) / 27.0d) * 360.0d;
        }
        double selVal1 = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 <= 26) {
                if (nakBorders[i2] <= d && d < nakBorders[i2 + 1]) {
                    selVal1 = nakBorders[i2];
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        int selNakLord = AstroCalc.kp_StarLordInt(d, true);
        double[] sub1LordDur = new double[9];
        int[] sub1LordInt2 = new int[9];
        byte j1 = 0;
        while (true) {
            if (j1 > 8) {
                break;
            }
            sub1LordDur[j1] = (dasaYears[AstroCalc.hp_Rnd0To8v((double) (selNakLord + j1))] / 120.0d) * 13.3333333333333d;
            j1 = (byte) (j1 + 1);
        }
        for (byte j2 = 0; j2 <= 8; j2 = (byte) (j2 + 1)) {
            sub1LordInt2[j2] = AstroCalc.hp_Rnd0To8v((double) (selNakLord + j2));
        }
        double[] sub1Bor = new double[10];
        sub1Bor[0] = selVal1;
        for (byte j3 = 0; j3 <= 8; j3 = (byte) (j3 + 1)) {
            sub1Bor[j3 + 1] = sub1Bor[j3] + sub1LordDur[j3];
        }
        double selVal2 = 0.0d;
        double sub1Duration = 0.0d;
        int sub1Lord = 0;
        byte i3 = 0;
        while (true) {
            if (i3 <= 8) {
                if (sub1Bor[i3] <= d && d < sub1Bor[i3 + 1]) {
                    selVal2 = sub1Bor[i3];
                    sub1Duration = sub1Bor[i3 + 1] - sub1Bor[i3];
                    sub1Lord = sub1LordInt2[i3];
                    break;
                }
                i3 = (byte) (i3 + 1);
            } else {
                break;
            }
        }
        double[] sub2LordDur = new double[9];
        int[] sub2LordInt = new int[9];
        byte j4 = 0;
        for (b = 8; j4 <= b; b = 8) {
            sub2LordDur[j4] = (dasaYears[AstroCalc.hp_Rnd0To8v((double) (sub1Lord + j4))] / 120.0d) * sub1Duration;
            j4 = (byte) (j4 + 1);
            double d2 = posVal;
        }
        for (byte j5 = 0; j5 <= 8; j5 = (byte) (j5 + 1)) {
            sub2LordInt[j5] = AstroCalc.hp_Rnd0To8v((double) (sub1Lord + j5));
        }
        double[] sub2Bor = new double[10];
        sub2Bor[0] = selVal2;
        for (byte j6 = 0; j6 <= 8; j6 = (byte) (j6 + 1)) {
            sub2Bor[j6 + 1] = sub2Bor[j6] + sub2LordDur[j6];
        }
        return sub2Bor;
    }

    public double[] get_star_sub(double mopos) {
        double d = mopos;
        double[] nakBorders = new double[28];
        for (byte i1 = 0; i1 <= 27; i1 = (byte) (i1 + 1)) {
            nakBorders[i1] = (((double) i1) / 27.0d) * 360.0d;
        }
        double selVal1 = 0.0d;
        byte i2 = 0;
        while (true) {
            if (i2 <= 26) {
                if (nakBorders[i2] <= d && d < nakBorders[i2 + 1]) {
                    selVal1 = nakBorders[i2];
                    break;
                }
                i2 = (byte) (i2 + 1);
            } else {
                break;
            }
        }
        double[] sub1LordDur = new double[9];
        double[] sub_lord = new double[10];
        sub_lord[0] = d;
        int selNakLord = AstroCalc.kp_StarLordInt(d, true);
        for (byte j1 = 0; j1 <= 8; j1 = (byte) (j1 + 1)) {
            sub1LordDur[j1] = (dasaYears[AstroCalc.hp_Rnd0To8v((double) (selNakLord + j1))] / 120.0d) * 13.3333333333333d;
            sub_lord[j1 + 1] = sub_lord[j1] + sub1LordDur[j1];
        }
        int j2 = 0;
        while (j2 <= 8) {
            this.sub1LordInt[j2] = AstroCalc.hp_Rnd0To8v((double) (selNakLord + j2));
            j2++;
            selNakLord = selNakLord;
        }
        int i = selNakLord;
        double[] sub1Bor = new double[10];
        sub1Bor[0] = selVal1;
        for (byte j3 = 0; j3 <= 8; j3 = (byte) (j3 + 1)) {
            sub1Bor[j3 + 1] = sub1Bor[j3] + sub1LordDur[j3];
        }
        return sub_lord;
    }

    /* access modifiers changed from: package-private */
    public double getNextNakshatraStart(double juld, int nakshatra, boolean topoctr) {
        int flags;
        SwissEph sw = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe");
        double[] geopos = {this.longitude, this.latitude, 0.0d};
        SwissEph swissEph = sw;
        swissEph.swe_set_sid_mode(1, 0.0d, 0.0d);
        swissEph.swe_set_topo(geopos[0], geopos[1], 0.0d);
        if (topoctr) {
            flags = 196610 | 32768;
        } else {
            flags = 196610;
        }
        return sw.getTransitUT(new TCPlanet(sw, 1, flags, ((double) nakshatra) * 13.333333333333334d), juld, false);
    }

    /* access modifiers changed from: package-private */
    public double getNextNakshatraStart_dbl(double juld, double value, boolean topoctr) {
        int flags;
        SwissEph sw = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe");
        double[] geopos = {this.longitude, this.latitude, 0.0d};
        SwissEph swissEph = sw;
        swissEph.swe_set_sid_mode(1, 0.0d, 0.0d);
        swissEph.swe_set_topo(geopos[0], geopos[1], 0.0d);
        if (topoctr) {
            flags = 196610 | 32768;
        } else {
            flags = 196610;
        }
        double d = juld;
        return sw.getTransitUT(new TCPlanet(sw, 1, flags, value), juld, false);
    }

    /* access modifiers changed from: package-private */
    public String toDateString(double d, double tzHours) {
        SweDate sd = new SweDate((tzHours / 24.0d) + d + 5.787037037037037E-6d);
        double hour2 = sd.getHour();
        return String.format(Locale.US, "%02d/%02d/%4d, %02d:%02d", new Object[]{Integer.valueOf(sd.getDay()), Integer.valueOf(sd.getMonth()), Integer.valueOf(sd.getYear()), Integer.valueOf((int) hour2), Integer.valueOf((int) ((hour2 - ((double) ((int) hour2))) * 60.0d))});
    }

    public void GetMahaDasaString() {
        Calendar curDate;
        TableLayout current_dasa_table;
        int i;
        int TodayDay;
        int j;
        VimsottariDasa.sDasaData pData;
        Calendar curDate2;
        int TodayDay2;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        Calendar curDate3 = Calendar.getInstance();
        int TodayDay3 = curDate3.get(5);
        char c = 2;
        char c2 = 1;
        double curJulDay = new SweDate(curDate3.get(1), curDate3.get(2) + 1, TodayDay3, 0.0d).getJulDay();
        TableLayout current_dasa_table2 = (TableLayout) findViewById(R.id.TableLayout_current_dasa);
        initializeHeaderRow_Dasa_with_End(current_dasa_table2);
        String tStr = "";
        int i2 = 0;
        while (i2 < this.pDasaData.size()) {
            VimsottariDasa.sDasaData pData2 = this.pDasaData.get(i2);
            if (curJulDay < pData2.startDate || curJulDay > pData2.endDate) {
                i = i2;
                current_dasa_table = current_dasa_table2;
                curDate = curDate3;
                TodayDay = TodayDay3;
            } else {
                String tStr2 = tStr + planetName1Tr[pData2.id] + "=>";
                SweDate sd_1 = new SweDate(pData2.startDate);
                SweDate sd_2 = new SweDate(pData2.endDate);
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(sd_1.getDay());
                objArr[c2] = Integer.valueOf(sd_1.getMonth());
                objArr[c] = Integer.valueOf(sd_1.getYear());
                String Stdt = String.format("%02d-%02d-%4d", objArr);
                Object[] objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(sd_2.getDay());
                objArr2[c2] = Integer.valueOf(sd_2.getMonth());
                objArr2[c] = Integer.valueOf(sd_2.getYear());
                String Endt = String.format("%02d-%02d-%4d", objArr2);
                String str2 = "%02d-%02d-%4d";
                String str3 = "=>";
                VimsottariDasa.sDasaData pData3 = pData2;
                i = i2;
                insertScoreRow_dasa_end(current_dasa_table2, "Dasa", planetName1Tr[pData2.id], Stdt, Endt);
                current_dasa_table = current_dasa_table2;
                ComputeGetAntarDasa(1, pData3.id, pData3.dPrd, pData3.startDate);
                int j2 = 0;
                tStr = tStr2;
                while (j2 < this.pCurAntarDasaData.size()) {
                    VimsottariDasa.sDasaData p1Data = this.pCurAntarDasaData.get(j2);
                    if (curJulDay < p1Data.startDate || curJulDay > p1Data.endDate) {
                        j = j2;
                        curDate2 = curDate3;
                        pData = pData3;
                        str = str2;
                        VimsottariDasa.sDasaData pData4 = p1Data;
                        TodayDay2 = TodayDay3;
                    } else {
                        String tStr3 = tStr + planetName1Tr[p1Data.id] + str3;
                        SweDate sd_11 = new SweDate(p1Data.startDate);
                        SweDate sd_12 = new SweDate(p1Data.endDate);
                        String str4 = str2;
                        String Stdt2 = String.format(str4, new Object[]{Integer.valueOf(sd_11.getDay()), Integer.valueOf(sd_11.getMonth()), Integer.valueOf(sd_11.getYear())});
                        String Endt2 = String.format(str4, new Object[]{Integer.valueOf(sd_12.getDay()), Integer.valueOf(sd_12.getMonth()), Integer.valueOf(sd_12.getYear())});
                        curDate2 = curDate3;
                        str = str4;
                        TodayDay2 = TodayDay3;
                        String tStr4 = tStr3;
                        pData = pData3;
                        VimsottariDasa.sDasaData p1Data2 = p1Data;
                        insertScoreRow_dasa_end(current_dasa_table, "Bhut", planetName1Tr[p1Data.id], Stdt2, Endt2);
                        j = j2;
                        ComputeGetAntarDasa(2, p1Data2.id, p1Data2.dPrd, p1Data2.startDate);
                        int k = 0;
                        while (k < this.pCurAntarDasaData.size()) {
                            VimsottariDasa.sDasaData p2Data = this.pCurAntarDasaData.get(k);
                            if (curJulDay < p2Data.startDate || curJulDay > p2Data.endDate) {
                                k++;
                            } else {
                                arrayList.add(tStr4 + planetName1Tr[p2Data.id]);
                                SweDate sd1 = new SweDate(p2Data.startDate);
                                SweDate sd2 = new SweDate(p2Data.endDate);
                                arrayList.add(String.format("%4d-%02d-%02d", new Object[]{Integer.valueOf(sd1.getYear()), Integer.valueOf(sd1.getMonth()), Integer.valueOf(sd1.getDay())}));
                                String tStr5 = String.format("%4d-%02d-%02d", new Object[]{Integer.valueOf(sd2.getYear()), Integer.valueOf(sd2.getMonth()), Integer.valueOf(sd2.getDay())});
                                arrayList.add(tStr5);
                                String str5 = tStr5;
                                VimsottariDasa.sDasaData sdasadata = p2Data;
                                insertScoreRow_dasa_end(current_dasa_table, "Ant", planetName1Tr[p2Data.id], String.format(str, new Object[]{Integer.valueOf(sd1.getDay()), Integer.valueOf(sd1.getMonth()), Integer.valueOf(sd1.getYear())}), String.format(str, new Object[]{Integer.valueOf(sd2.getDay()), Integer.valueOf(sd2.getMonth()), Integer.valueOf(sd2.getYear())}));
                                return;
                            }
                        }
                        tStr = tStr4;
                    }
                    j2 = j + 1;
                    TodayDay3 = TodayDay2;
                    pData3 = pData;
                    str2 = str;
                    curDate3 = curDate2;
                }
                int i3 = j2;
                curDate = curDate3;
                TodayDay = TodayDay3;
                VimsottariDasa.sDasaData sdasadata2 = pData3;
            }
            i2 = i + 1;
            TodayDay3 = TodayDay;
            current_dasa_table2 = current_dasa_table;
            curDate3 = curDate;
            c = 2;
            c2 = 1;
        }
    }

    public void ComputeGetAntarDasa(int level, int stId, double prd, double startDate) {
        double startPeriod = startDate;
        int level2 = level + 1;
        ArrayList<VimsottariDasa.sDasaData> arrayList = new ArrayList<>();
        this.pCurAntarDasaData = arrayList;
        arrayList.clear();
        int stId2 = this.pIdToDasaSeq[stId] + this.dasaSeqStart;
        int i = stId2;
        while (true) {
            int i2 = this.nDasas;
            if (i < stId2 + i2) {
                int i1 = i % i2;
                double[] dArr = this.planetPrd;
                double d = dArr[i1] * prd * this.paramAyus;
                double d2 = this.totalPeriod;
                double endPrd = startPeriod + ((d / d2) * this.daysPerYear);
                VimsottariDasa.sDasaData pData = new VimsottariDasa.sDasaData(level2, this.pIdToDaySeq[i1], (prd * dArr[i1]) / d2, startPeriod, endPrd);
                startPeriod = endPrd;
                this.pCurAntarDasaData.add(pData);
                i++;
            } else {
                return;
            }
        }
    }

    private void initializeHeaderRow_Dasa_with_End(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text_title);
        float textSize = getResources().getDisplayMetrics().density * 16.0f;
        addTextToRowWithValues(headerRow, "Partcular", textColor, textSize);
        addTextToRowWithValues(headerRow, "Plant", textColor, textSize);
        addTextToRowWithValues(headerRow, "Start Dt", textColor, textSize);
        addTextToRowWithValues(headerRow, "End Dt", textColor, textSize);
        scoreTable.addView(headerRow);
    }

    private void insertScoreRow_dasa_end(TableLayout scoreTable, String partValue, String csValue, String dmsValue, String sgnValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, partValue, textColor, textSize);
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        addTextToRowWithValues(newRow, sgnValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    public void CalculateMahaDasa(double tMoon, double birthJulDay) {
        double d = tMoon;
        this.pMoonPos = d;
        double d2 = this.totalPeriod;
        double temp = d / d2;
        double d3 = (temp - ((double) ((int) temp))) * 9.0d;
        this.moonDasaLeft = d3;
        int i = (int) d3;
        this.startId = i;
        double[] dArr = this.planetPrd;
        double d4 = (d3 - ((double) i)) * ((dArr[i] * this.paramAyus) / d2);
        this.passedPeriod = d4;
        this.dasaRemain = dArr[i] - d4;
        this.nDasa = 0;
        this.nLevel = this.nLevels;
        double d5 = this.daysPerYear;
        double startPeriod = birthJulDay - (d4 * d5);
        double endAyus = birthJulDay + (this.totalAyus * d5);
        this.pDasaData.clear();
        int i2 = this.startId;
        while (startPeriod < endAyus) {
            int i1 = i2 % this.nDasas;
            double[] dArr2 = this.planetPrd;
            double d6 = dArr2[i1] * this.paramAyus;
            double d7 = this.totalPeriod;
            double endPrd = startPeriod + ((d6 / d7) * this.daysPerYear);
            VimsottariDasa.sDasaData pData = new VimsottariDasa.sDasaData(0, this.pIdToDaySeq[i1], dArr2[i1] / d7, startPeriod, endPrd);
            startPeriod = endPrd;
            this.pDasaData.add(pData);
            this.nDasa++;
            i2++;
        }
    }

    public static ArrayList<Integer> GetObjectsInSign(int iSign) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.clear();
        for (int p = 0; p < 12; p++) {
            if (((int) (pPos[p] / 30.0d)) == iSign) {
                temp.add(Integer.valueOf(p));
            }
        }
        return temp;
    }

    public static ArrayList<Integer> GetObjectsInSign_rasi(int iSign) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.clear();
        for (int p = 0; p < 12; p++) {
            if (((int) (cusps[p] / 30.0d)) == iSign) {
                temp.add(Integer.valueOf(p + 12));
            }
        }
        return temp;
    }

    public static ArrayList<Integer> GetD9ObjectsInSign(int iSign) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.clear();
        for (int p = 0; p < 12; p++) {
            if (GetD9Sign(pPos[p]) == iSign) {
                temp.add(Integer.valueOf(p));
            }
        }
        return temp;
    }

    public static int GetD9LagnaSign() {
        return navamsa_from_long(cusps[0] - newKPAyan);
    }

    static int navamsa_from_long(double longitude2) {
        return (int) (12.0d * ((longitude2 / (3.3333333333333335d * 12.0d)) % 1.0d));
    }

    static int GetD9Sign(double d) {
        double d2 = d + 1.3888888888888889E-8d;
        int d1Sign = (int) (d2 / 30.0d);
        return (new int[]{0, 9, 6, 3, 0, 9, 6, 3, 0, 9, 6, 3}[d1Sign] + ((int) (((d2 - ((double) (d1Sign * 30))) * 9.0d) / 30.0d))) % 12;
    }

    public void lagna_dasa(TableLayout scoreTable) {
        Main_details_tab main_details_tab = this;
        int s = 0;
        int i = 0;
        while (i < 24) {
            int j = 0;
            int s2 = s;
            while (j < 60) {
                double a = new SweDate(main_details_tab.year, main_details_tab.month, main_details_tab.day, ((double) i) + (((double) j) / 60.0d)).getJulDay();
                newKPAyan = AstroCalc.get_ayan(a);
                double cusp = AstroCalc.hp_Rnd0To360v(main_details_tab.ComputeLagnaPos(a) - newKPAyan);
                double pos = AstroCalc.hp_Rnd0To360v(main_details_tab.ComputePlanetPos(a, 1) - newKPAyan);
                if (s2 != AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), true))) {
                    String sgnValue = pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(pos))];
                    double d = a;
                    insertScoreRow_Ldasa(scoreTable, AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), false)), 0.0d), sgnValue, AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), true)), 0.0d), main_details_tab.kp_RevJday(a + 0.22916666666666666d) + " " + AstroCalc.kp_RevJtime(0.22916666666666666d + a), AstroCalc.toDM(cusp), pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(cusp))], pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(cusp))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusp), false)), 0.0d));
                    s2 = AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), true));
                }
                j++;
                main_details_tab = this;
                double d2 = cusp;
                double d3 = pos;
            }
            i++;
            main_details_tab = this;
            int i2 = j;
            s = s2;
        }
    }

    private void insertScoreRow_Ldasa(TableLayout scoreTable, String scoreValue, String scoreUserName, String scoreUser, String scoredata, String dmsdata, String sgndata, String stldata, String sbldata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        addTextToRowWithValues(newRow, scoreUserName, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoreValue, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoreUser, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoredata, textColor, 10.0f);
        addTextToRowWithValues(newRow, dmsdata, textColor, 10.0f);
        addTextToRowWithValues(newRow, sgndata, textColor, 10.0f);
        addTextToRowWithValues(newRow, stldata, textColor, 10.0f);
        addTextToRowWithValues(newRow, sbldata, textColor, 10.0f);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_Ldasa_sub(final TableLayout scoreTable, String[] Data2) {
        TableRow newRow = new TableRow(this);
        addTextToRowWithValues_array(newRow, Data2, getResources().getColor(R.color.text));
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int index = scoreTable.indexOfChild((TableRow) view);
                Main_details_tab main_details_tab = Main_details_tab.this;
                main_details_tab.sub_table = main_details_tab.get_star_sub(main_details_tab.nak_pos[index - 1]);
                TableLayout Ldasa = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_LD_sub);
                Ldasa.removeAllViews();
                ((TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Transit)).removeAllViews();
                Main_details_tab.this.insertScoreRow_Ldasa_sub_header(Ldasa);
                for (int i = 0; i < 9; i++) {
                    Main_details_tab.newKPAyan = AstroCalc.get_ayan(Main_details_tab.this.nak_dur[index - 1]);
                    Main_details_tab main_details_tab2 = Main_details_tab.this;
                    double nakshStart = main_details_tab2.GetNakshatraLogRangeInterPolution(main_details_tab2.nak_dur[index - 1], 1, Main_details_tab.this.sub_table[i]);
                    Main_details_tab.this.sub_dur[i] = nakshStart;
                    double cusp = AstroCalc.hp_Rnd0To360v(Main_details_tab.this.ComputeLagnaPos(nakshStart) - Main_details_tab.newKPAyan);
                    double pos = AstroCalc.hp_Rnd0To360v(Main_details_tab.this.ComputePlanetPos(nakshStart, 1) - Main_details_tab.newKPAyan);
                    double d = nakshStart;
                    Main_details_tab.this.insertScoreRow_Ldasa_sub_data(Ldasa, AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), false)), 0.0d), Main_details_tab.pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(pos))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), true)), 0.0d), "", Main_details_tab.this.toDateString(nakshStart, 5.5d), AstroCalc.toDM(cusp), Main_details_tab.pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(cusp))], Main_details_tab.pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(cusp))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusp), false)), 0.0d));
                }
                ((TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_LD_ssb)).removeAllViews();
                Main_details_tab.this.fill_sub_year();
            }
        });
    }

    /* access modifiers changed from: private */
    public void fill_ssb_year() {
        TableRow r;
        View view;
        TableLayout Ldasa = (TableLayout) findViewById(R.id.TableLayout_LD_ssb);
        for (int i = 0; i < 10; i++) {
            View view2 = Ldasa.getChildAt(i);
            TableRow r2 = (TableRow) view2;
            int j = 0;
            while (true) {
                int i2 = 9;
                if (j >= 9) {
                    break;
                }
                if (((TextView) r2.getChildAt(0)).getText().toString().equals(planetName2Tr[this.mDasL[j]])) {
                    int k = 0;
                    while (k < i2) {
                        if (((TextView) r2.getChildAt(1)).getText().toString().equals(planetName2Tr[this.bDasL[j][k]])) {
                            int l = 0;
                            while (l < i2) {
                                if (((TextView) r2.getChildAt(2)).getText().toString().equals(planetName2Tr[this.aDasL[j][k][l]])) {
                                    view = view2;
                                    r = r2;
                                    ((TextView) r2.getChildAt(3)).setText(kp_RevJday(this.aDas[j][k][l]));
                                } else {
                                    view = view2;
                                    r = r2;
                                }
                                l++;
                                view2 = view;
                                r2 = r;
                                i2 = 9;
                            }
                        }
                        k++;
                        view2 = view2;
                        r2 = r2;
                        i2 = 9;
                    }
                }
                j++;
                view2 = view2;
                r2 = r2;
            }
            TableRow tableRow = r2;
        }
    }

    private void fill_Asp_year() {
        TableRow r;
        View view;
        TableLayout Ldasa = (TableLayout) findViewById(R.id.TableLayout_Aspect_Conj);
        for (int i = 0; i < 22; i++) {
            View view2 = Ldasa.getChildAt(i);
            TableRow r2 = (TableRow) view2;
            int j = 0;
            while (true) {
                int i2 = 9;
                if (j >= 9) {
                    break;
                }
                if (((TextView) r2.getChildAt(3)).getText().toString().equals(planetName2Tr[this.mDasL[j]])) {
                    int k = 0;
                    while (k < i2) {
                        if (((TextView) r2.getChildAt(4)).getText().toString().equals(planetName2Tr[this.bDasL[j][k]])) {
                            int l = 0;
                            while (l < i2) {
                                if (((TextView) r2.getChildAt(5)).getText().toString().equals(planetName2Tr[this.aDasL[j][k][l]])) {
                                    view = view2;
                                    r = r2;
                                    ((TextView) r2.getChildAt(6)).setText(kp_RevJday(this.aDas[j][k][l]));
                                } else {
                                    view = view2;
                                    r = r2;
                                }
                                l++;
                                view2 = view;
                                r2 = r;
                                i2 = 9;
                            }
                        }
                        k++;
                        view2 = view2;
                        r2 = r2;
                        i2 = 9;
                    }
                }
                j++;
                view2 = view2;
                r2 = r2;
            }
            TableRow tableRow = r2;
        }
    }

    /* access modifiers changed from: private */
    public void fill_sub_year() {
        TableLayout Ldasa = (TableLayout) findViewById(R.id.TableLayout_LD_sub);
        for (int i = 0; i < 10; i++) {
            TableRow r = (TableRow) Ldasa.getChildAt(i);
            for (int j = 0; j < 9; j++) {
                if (((TextView) r.getChildAt(0)).getText().toString().equals(planetName2Tr[this.mDasL[j]])) {
                    for (int k = 0; k < 9; k++) {
                        if (((TextView) r.getChildAt(1)).getText().toString().equals(planetName2Tr[this.bDasL[j][k]])) {
                            ((TextView) r.getChildAt(3)).setText(kp_RevJday(this.bDas[j][k]));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void insertScoreRow_Ldasa_sub_data(final TableLayout scoreTable, String scoreValue, String scoreUserName, String scoreUser, String scoredata, String scoreyear, String dmsdata, String sgndata, String stldata, String sbldata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        addTextToRowWithValues(newRow, scoreUserName, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoreValue, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoreUser, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoredata, textColor, 10.0f);
        addTextToRowWithValues(newRow, scoreyear, textColor, 10.0f);
        addTextToRowWithValues(newRow, dmsdata, textColor, 10.0f);
        addTextToRowWithValues(newRow, sgndata, textColor, 10.0f);
        addTextToRowWithValues(newRow, stldata, textColor, 10.0f);
        addTextToRowWithValues(newRow, sbldata, textColor, 10.0f);
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int index = scoreTable.indexOfChild((TableRow) view);
                String[] strArr = new String[9];
                Main_details_tab main_details_tab = Main_details_tab.this;
                main_details_tab.ssb_table = AstroCalc.kp_SubLord02(main_details_tab.sub_table[index - 1], true);
                TableLayout Ldasa = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_LD_ssb);
                Ldasa.removeAllViews();
                ((TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Transit)).removeAllViews();
                Main_details_tab.this.insertScoreRow_Ldasa_sub_header(Ldasa);
                for (int i = 0; i < 9; i++) {
                    Main_details_tab.newKPAyan = AstroCalc.get_ayan(Main_details_tab.this.sub_dur[i]);
                    Main_details_tab.this.insert_SSB_Data(index, i, Ldasa);
                }
                Main_details_tab.this.fill_ssb_year();
            }
        });
    }

    /* access modifiers changed from: private */
    public void insert_SSB_Data(int index, int i, TableLayout Ldasa) {
        double ssb_intit = AstroCalc.hp_Rnd0To360v(this.ssb_table[i]);
        double nakshStart = GetNakshatraLogRangeInterPolution(this.sub_dur[index - 1] - 0.005d, 1, this.ssb_table[i]);
        double ssb_present = 0.0d;
        while (true) {
            if (ssb_present <= ssb_intit || ssb_present >= 0.16d + ssb_intit) {
                nakshStart += 3.0E-4d;
                ssb_present = AstroCalc.hp_Rnd0To360v(AstroCalc.hp_Rnd0To360v(ComputePlanetPos(nakshStart, 1) - newKPAyan));
            } else {
                this.ssb_dur[i] = nakshStart;
                double cusp = AstroCalc.hp_Rnd0To360v(ComputeLagnaPos(nakshStart) - newKPAyan);
                double pos = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(nakshStart, 1) - newKPAyan);
                insertScoreRow_Ldasa_ssb_data(Ldasa, AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), false)), 0.0d), pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(pos))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos), true)), 0.0d), toDateString(nakshStart, 5.5d), "", AstroCalc.toDM(cusp), pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(cusp))], pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(cusp))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusp), false)), 0.0d));
                return;
            }
        }
    }

    private void insertScoreRow_Ldasa_ssb_data(final TableLayout scoreTable, String scoreValue, String scoreUserName, String scoreUser, String scoredata, String scoreyear, String dmsdata, String sgndata, String stldata, String sbldata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoreValue, textColor, textSize);
        addTextToRowWithValues(newRow, scoreUser, textColor, textSize);
        addTextToRowWithValues(newRow, scoreyear, textColor, textSize);
        addTextToRowWithValues(newRow, scoredata, textColor, textSize);
        addTextToRowWithValues(newRow, dmsdata, textColor, textSize);
        addTextToRowWithValues(newRow, sgndata, textColor, textSize);
        addTextToRowWithValues(newRow, stldata, textColor, textSize);
        addTextToRowWithValues(newRow, sbldata, textColor, textSize);
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                double JD = Main_details_tab.this.ssb_dur[scoreTable.indexOfChild((TableRow) view) - 1];
                TableLayout Ldasa = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Transit);
                Ldasa.removeAllViews();
                Main_details_tab.this.insertScoreRow_Transit_header(Ldasa);
                int[] pntID = {0, 1, 4, 2, 5, 3, 6, 11, 11};
                for (int i = 0; i < 9; i++) {
                    Main_details_tab.newKPAyan = AstroCalc.get_ayan(Main_details_tab.this.sub_dur[i]);
                    double pos = AstroCalc.hp_Rnd0To360v(Main_details_tab.this.ComputePlanetPos(JD, pntID[i]) - Main_details_tab.newKPAyan);
                    if (i == 8) {
                        pos = AstroCalc.hp_Rnd0To360v(180.0d + pos);
                    }
                    double pos2 = pos;
                    Main_details_tab.this.insertScoreRow_Ldasa_Transit(Ldasa, AstroCalc.kp_PlanetName(i, 0.0d), AstroCalc.toDM(pos2), Main_details_tab.pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(pos2))], Main_details_tab.pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(pos2))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos2), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pos2), true)), 0.0d), "");
                }
                Main_details_tab.this.fill_Transit_year();
                TableLayout TransitChart = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Transit_chart);
                TransitChart.removeAllViews();
                Main_details_tab.this.initializeHeaderRow_Transit_chart(TransitChart, JD);
            }
        });
    }

    /* access modifiers changed from: private */
    public void fill_Transit_year() {
        TableRow r;
        View view;
        TableLayout Ldasa = (TableLayout) findViewById(R.id.TableLayout_Transit);
        for (int i = 0; i < 10; i++) {
            View view2 = Ldasa.getChildAt(i);
            TableRow r2 = (TableRow) view2;
            int j = 0;
            while (true) {
                int i2 = 9;
                if (j >= 9) {
                    break;
                }
                if (((TextView) r2.getChildAt(3)).getText().toString().equals(planetName2Tr[this.mDasL[j]])) {
                    int k = 0;
                    while (k < i2) {
                        if (((TextView) r2.getChildAt(4)).getText().toString().equals(planetName2Tr[this.bDasL[j][k]])) {
                            int l = 0;
                            while (l < i2) {
                                if (((TextView) r2.getChildAt(5)).getText().toString().equals(planetName2Tr[this.aDasL[j][k][l]])) {
                                    view = view2;
                                    r = r2;
                                    ((TextView) r2.getChildAt(6)).setText(kp_RevJday(this.aDas[j][k][l]));
                                } else {
                                    view = view2;
                                    r = r2;
                                }
                                l++;
                                view2 = view;
                                r2 = r;
                                i2 = 9;
                            }
                        }
                        k++;
                        view2 = view2;
                        r2 = r2;
                        i2 = 9;
                    }
                }
                j++;
                view2 = view2;
                r2 = r2;
            }
            TableRow tableRow = r2;
        }
    }

    /* access modifiers changed from: private */
    public void insertScoreRow_Ldasa_Transit(TableLayout scoreTable, String scoreUserName, String scoreValue, String strValue, String scoreUser, String scoreyear, String AntValue, String Date) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoreValue, textColor, textSize);
        addTextToRowWithValues(newRow, strValue, textColor, textSize);
        addTextToRowWithValues(newRow, scoreUser, textColor, textSize);
        addTextToRowWithValues(newRow, scoreyear, textColor, textSize);
        addTextToRowWithValues(newRow, AntValue, textColor, textSize);
        addTextToRowWithValues(newRow, Date, textColor, textSize);
        scoreTable.addView(newRow);
    }

    /* access modifiers changed from: private */
    public void insertScoreRow_Transit_header(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Pln", "DMS", "SGN", "STL", "SBL", "SSL", "Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
    }

    /* access modifiers changed from: private */
    public void insertScoreRow_Ldasa_sub_header(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"DAS", "BHU", "AND", "YEAR", "S.DATE", "DMS", "SGN", "STL", "SBL"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
    }

    public void kb_AspectPrint(double data, int idInt, TableLayout scoreTable) {
        int i = idInt;
        if (i <= 11) {
            insertScoreRow_Aspec(scoreTable, AstroCalc.aNames[i], AstroCalc.toDMS01(AstroCalc.hp_Rnd0To360v(data)), pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(data))], pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(data))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), true)), 0.0d), "");
            return;
        }
        insertScoreRow_Aspec(scoreTable, pNames[i - 12], AstroCalc.toDMS01(data), pRasiNames[AstroCalc.GetLagnaSign(data)], pStarNames[AstroCalc.GetStarLord(data)], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), true)), 0.0d), "");
    }

    public void kb_ChartPrint(double data, int idInt, TableLayout scoreTable) {
        int i = idInt;
        if (i <= 11) {
            insertScoreRow_kb(scoreTable, AstroCalc.aNames[i], pRasiNames[AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(data))], pStarNames[AstroCalc.GetStarLord(AstroCalc.hp_Rnd0To360v(data))], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), true)), 0.0d), AstroCalc.toDMS01(AstroCalc.hp_Rnd0To360v(data)), "", "", "", "");
            return;
        }
        String plValue = pNames[i - 12];
        insertScoreRow_kb(scoreTable, "", "", "", "", "", AstroCalc.toDMS01(data), plValue, pStarNames[AstroCalc.GetStarLord(data)], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(data), true)), 0.0d));
    }

    private void initializeHeaderRow_aspect(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"CS/Pl", "DMS", "SGN", "STL", "BHU", "AND", "Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
    }

    private void initializeHeaderRow_kb(TableLayout scoreTable, TableLayout AspectTable) {
        TableLayout tableLayout = scoreTable;
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"CS", "SGN", "STL", "BHU", "AND", "DMS", "PLN", "STL", "SBL", "SSL"}, getResources().getColor(R.color.text_title));
        tableLayout.addView(headerRow);
        double[] allPos = new double[21];
        double[] allPos2 = new double[21];
        double[] allPos_Aligned = new double[21];
        for (int i = 0; i <= 11; i++) {
            allPos[i] = AstroCalc.hp_Rnd0To360v(cusps[i] - newKPAyan);
            allPos2[i] = AstroCalc.hp_Rnd0To360v(cusps[i] - newKPAyan);
        }
        for (int j = 0; j < 9; j++) {
            double[] dArr = pPos;
            allPos[j + 12] = dArr[j];
            allPos2[j + 12] = dArr[j];
        }
        AstroCalc.posSort(allPos, 0, 20);
        int[] idAr = new int[21];
        for (int j1 = 0; j1 <= 20; j1++) {
            for (int j2 = 0; j2 <= 20; j2++) {
                if (Math.abs(allPos[j1] - allPos2[j2]) < 1.0E-30d) {
                    idAr[j1] = j2;
                }
            }
        }
        int[] idAr_aligned = new int[21];
        int j12 = 0;
        while (true) {
            if (j12 > 21) {
                break;
            } else if (idAr[j12] == 0) {
                for (int tmp = 0; tmp < 21; tmp++) {
                    allPos_Aligned[tmp] = allPos[(tmp + j12) % 21];
                    idAr_aligned[tmp] = idAr[(tmp + j12) % 21];
                }
            } else {
                j12++;
            }
        }
        for (byte j3 = 0; j3 <= 20; j3 = (byte) (j3 + 1)) {
            kb_ChartPrint(allPos_Aligned[j3], idAr_aligned[j3], tableLayout);
            kb_AspectPrint(allPos_Aligned[j3], idAr_aligned[j3], AspectTable);
        }
        TableLayout tableLayout2 = AspectTable;
        fill_Asp_year();
    }

    private void initializeHeaderRow_Dt(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Particulars", "Details"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        String[][] strArr = (String[][]) Array.newInstance(String.class, new int[]{13, 2});
        String[][] data = Set_Data_Table();
        for (int j = 0; j < 9; j++) {
            insertScoreRow_dt(scoreTable, data[j][0], data[j][1]);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r28v3, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r28v4, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r28v6, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r28v8, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r28v9, types: [byte] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[][] Set_Data_Table() {
        /*
            r69 = this;
            r0 = r69
            r1 = 2
            int[] r2 = new int[r1]
            r2 = {13, 2} // fill-array
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r3, r2)
            java.lang.String[][] r2 = (java.lang.String[][]) r2
            r3 = 0
            r4 = r2[r3]
            java.lang.String r5 = "Name"
            r4[r3] = r5
            r4 = r2[r3]
            java.lang.String r5 = com.cuspal.interlinks.Global.Name
            r6 = 1
            r4[r6] = r5
            r4 = r2[r6]
            java.lang.String r5 = "Date"
            r4[r3] = r5
            r4 = r2[r6]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]
            int r9 = com.cuspal.interlinks.Global.dd
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8[r3] = r9
            int r9 = com.cuspal.interlinks.Global.mm
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8[r6] = r9
            int r9 = com.cuspal.interlinks.Global.yy
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8[r1] = r9
            java.lang.String r9 = "%02d-%02d-%4d"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r5.append(r8)
            java.lang.String r8 = " "
            r5.append(r8)
            java.lang.Object[] r9 = new java.lang.Object[r7]
            int r10 = com.cuspal.interlinks.Global.hh
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9[r3] = r10
            int r10 = com.cuspal.interlinks.Global.min
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9[r6] = r10
            int r10 = com.cuspal.interlinks.Global.ss
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9[r1] = r10
            java.lang.String r10 = "%02d:%02d:%02d"
            java.lang.String r9 = java.lang.String.format(r10, r9)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r4[r6] = r5
            r4 = r2[r1]
            java.lang.String r5 = "Ayanamsa"
            r4[r3] = r5
            r4 = r2[r1]
            double r9 = com.cuspal.interlinks.Global.ayan
            java.lang.String r5 = com.cuspal.interlinks.AstroCalc.toDMS(r9)
            r4[r6] = r5
            double[] r4 = pPos
            byte r5 = r0.P_MO
            r9 = r4[r5]
            int r4 = com.cuspal.interlinks.AstroCalc.get_StarID(r9)
            double[] r5 = pPos
            byte r9 = r0.P_MO
            r9 = r5[r9]
            int r5 = com.cuspal.interlinks.AstroCalc.get_Star_pada(r9)
            java.lang.String r9 = com.cuspal.interlinks.AstroCalc.get_Star_Name(r4)
            java.lang.String r10 = com.cuspal.interlinks.AstroCalc.get_Star_Lord(r4)
            r11 = r2[r7]
            java.lang.String r12 = "Natchatram"
            r11[r3] = r12
            r11 = r2[r7]
            java.lang.Object[] r12 = new java.lang.Object[r7]
            r12[r3] = r9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            r12[r6] = r13
            r12[r1] = r10
            java.lang.String r13 = "%-9.9s-%01d %-2s"
            java.lang.String r12 = java.lang.String.format(r13, r12)
            r11[r6] = r12
            r11 = 30
            byte[] r11 = new byte[r11]
            byte r12 = r0.P_SU
            r11[r3] = r12
            byte r13 = r0.P_MO
            r11[r6] = r13
            byte r14 = r0.P_MA
            r11[r1] = r14
            byte r15 = r0.P_ME
            r11[r7] = r15
            byte r7 = r0.P_JU
            r1 = 4
            r11[r1] = r7
            byte r6 = r0.P_VE
            r19 = 5
            r11[r19] = r6
            byte r3 = r0.P_SA
            r21 = 6
            r11[r21] = r3
            byte r1 = r0.P_RA
            r23 = r4
            r4 = 7
            r11[r4] = r1
            r24 = 8
            r11[r24] = r12
            r25 = 9
            r11[r25] = r13
            r25 = 10
            r11[r25] = r14
            r25 = 11
            r11[r25] = r15
            r4 = 12
            r11[r4] = r7
            r26 = 13
            r11[r26] = r6
            r26 = 14
            r11[r26] = r3
            r26 = 15
            r11[r26] = r12
            r26 = 16
            r11[r26] = r13
            r26 = 17
            r11[r26] = r14
            r26 = 18
            r11[r26] = r15
            r26 = 19
            r11[r26] = r7
            r26 = 20
            r11[r26] = r6
            r26 = 21
            r11[r26] = r3
            r3 = 22
            r11[r3] = r1
            r3 = 23
            r11[r3] = r12
            r3 = 24
            r11[r3] = r13
            r3 = 25
            r11[r3] = r14
            r3 = 26
            r11[r3] = r15
            r3 = 27
            r11[r3] = r7
            r7 = 28
            r11[r7] = r6
            r6 = 29
            r11[r6] = r1
            r1 = r11
            double[] r6 = pPos
            r13 = r6[r13]
            r11 = r6[r12]
            int r6 = com.cuspal.interlinks.AstroCalc.get_tithiID(r11, r13)
            double r3 = com.cuspal.interlinks.AstroCalc.get_tithi_left(r6, r11, r13)
            java.lang.String r26 = com.cuspal.interlinks.AstroCalc.get_tithi_lord(r6)
            java.lang.String r27 = com.cuspal.interlinks.AstroCalc.get_tithi_Name(r6)
            r7 = 4
            r22 = r2[r7]
            java.lang.String r29 = "Tithi/Karana"
            r20 = 0
            r22[r20] = r29
            java.lang.Object[] r15 = new java.lang.Object[r7]
            r15[r20] = r27
            int r7 = (int) r3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r18 = 1
            r15[r18] = r7
            java.lang.String r7 = "%"
            r17 = 2
            r15[r17] = r7
            r7 = 3
            r15[r7] = r26
            java.lang.String r7 = "%s (%d%1s)(%2s)"
            java.lang.String r15 = java.lang.String.format(r7, r15)
            r30 = 4618441417868443648(0x4018000000000000, double:6.0)
            r32 = r3
            r7 = 7
            byte[] r3 = new byte[r7]
            byte r4 = r0.P_SU
            r7 = 0
            r3[r7] = r4
            byte r7 = r0.P_MO
            r18 = 1
            r3[r18] = r7
            r34 = r5
            byte r5 = r0.P_MA
            r17 = 2
            r3[r17] = r5
            byte r5 = r0.P_ME
            r16 = 3
            r3[r16] = r5
            byte r5 = r0.P_JU
            r16 = 4
            r3[r16] = r5
            byte r5 = r0.P_VE
            r3[r19] = r5
            byte r5 = r0.P_SA
            r3[r21] = r5
            java.lang.String r35 = "Bava"
            java.lang.String r36 = "Balava"
            java.lang.String r37 = "Kaulava"
            java.lang.String r38 = "Taitula"
            java.lang.String r39 = "Garija"
            java.lang.String r40 = "Vanija"
            java.lang.String r41 = "vishti"
            java.lang.String r42 = "Shakuna"
            java.lang.String r43 = "Catushpad"
            java.lang.String r44 = "Naga"
            java.lang.String r45 = "Kimstugna"
            java.lang.String[] r5 = new java.lang.String[]{r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45}
            double[] r16 = pPos
            r13 = r16[r7]
            r11 = r16[r4]
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x01de
            r35 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r13 = r13 + r35
        L_0x01de:
            double r35 = r13 - r11
            r4 = r6
            double r6 = r35 / r30
            r16 = 0
            r35 = 0
            r36 = 0
            r37 = r4
            int r4 = (int) r6
            int r4 = r4 % 60
            r38 = r6
            r6 = 12
            byte[] r7 = new byte[r6]
            r7 = {2, 5, 3, 1, 0, 3, 5, 2, 4, 6, 6, 4} // fill-array
            double[] r16 = cusps
            r18 = 1
            r40 = r16[r18]
            r42 = 4629137466983448576(0x403e000000000000, double:30.0)
            r16 = r7
            double r6 = r40 / r42
            int r6 = (int) r6
            if (r4 == 0) goto L_0x022c
            switch(r4) {
                case 57: goto L_0x0228;
                case 58: goto L_0x021d;
                case 59: goto L_0x0212;
                default: goto L_0x0209;
            }
        L_0x0209:
            int r7 = r4 + -1
            r25 = 7
            int r7 = r7 % 7
            byte r28 = r3[r7]
            goto L_0x0237
        L_0x0212:
            int r7 = r6 + 7
            r28 = 12
            int r7 = r7 % 12
            byte r28 = r16[r7]
            r7 = 9
            goto L_0x0237
        L_0x021d:
            r28 = 12
            int r7 = r6 + 4
            int r7 = r7 % 12
            byte r28 = r16[r7]
            r7 = 8
            goto L_0x0237
        L_0x0228:
            byte r28 = r16[r6]
            r7 = 7
            goto L_0x0237
        L_0x022c:
            int r28 = r6 + 10
            r7 = 12
            int r28 = r28 % 12
            byte r28 = r16[r28]
            r7 = 10
        L_0x0237:
            r22 = 4
            r22 = r2[r22]
            r35 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r15)
            r36 = r4
            java.lang.String r4 = " / "
            r3.append(r4)
            r40 = r6
            r41 = r9
            r6 = 2
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r6 = r5[r7]
            r20 = 0
            r9[r20] = r6
            java.lang.String[] r6 = pNames
            r6 = r6[r28]
            r18 = 1
            r9[r18] = r6
            java.lang.String r6 = "%s (%2s)"
            java.lang.String r9 = java.lang.String.format(r6, r9)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r22[r18] = r3
            r3 = r2[r19]
            java.lang.String r9 = "Yoga"
            r20 = 0
            r3[r20] = r9
            double[] r3 = pPos
            byte r9 = r0.P_MO
            r42 = r3[r9]
            byte r9 = r0.P_SU
            r44 = r3[r9]
            double r42 = r42 + r44
            r44 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r42 = r42 * r44
            r44 = 4650248090236747776(0x4089000000000000, double:800.0)
            r3 = r10
            double r9 = r42 / r44
            int r0 = (int) r9
            r22 = 27
            int r0 = r0 % 27
            byte r22 = r1[r0]
            java.lang.String r42 = "Vishkumbha"
            java.lang.String r43 = "Priti"
            java.lang.String r44 = "Ayushman"
            java.lang.String r45 = "Saubhagya"
            java.lang.String r46 = "Shobhan"
            java.lang.String r47 = "Atiganda"
            java.lang.String r48 = "Sukarma"
            java.lang.String r49 = "Dhriti"
            java.lang.String r50 = "Shula"
            java.lang.String r51 = "Ganda"
            java.lang.String r52 = "Vridhi"
            java.lang.String r53 = "Dhruv"
            java.lang.String r54 = "Vyaghata"
            java.lang.String r55 = "Harshan"
            java.lang.String r56 = "Vraj"
            java.lang.String r57 = "Sidhi"
            java.lang.String r58 = "Vyatipata"
            java.lang.String r59 = "Variyana"
            java.lang.String r60 = "Parigha"
            java.lang.String r61 = "Shiva"
            java.lang.String r62 = "Shidha"
            java.lang.String r63 = "Sadhya"
            java.lang.String r64 = "Shubha"
            java.lang.String r65 = "Shukla"
            java.lang.String r66 = "Bhramha"
            java.lang.String r67 = "Indra"
            java.lang.String r68 = "Vraidhiti"
            java.lang.String[] r29 = new java.lang.String[]{r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68}
            r19 = r2[r19]
            r42 = r1
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r17 = r29[r0]
            r20 = 0
            r1[r20] = r17
            java.lang.String[] r17 = pNames
            r17 = r17[r22]
            r18 = 1
            r1[r18] = r17
            java.lang.String r1 = java.lang.String.format(r6, r1)
            r19[r18] = r1
            r1 = r2[r21]
            java.lang.String r6 = "Place"
            r1[r20] = r6
            r1 = r2[r21]
            java.lang.String r6 = com.cuspal.interlinks.Global.Loc
            r1[r18] = r6
            r1 = 7
            r6 = r2[r1]
            java.lang.String r17 = "Lat/Lon"
            r6[r20] = r17
            r1 = r2[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r17 = r0
            int r0 = com.cuspal.interlinks.Global.latdd
            r6.append(r0)
            java.lang.String r0 = ":"
            r6.append(r0)
            r19 = r3
            java.lang.String r3 = com.cuspal.interlinks.Global.latNS
            r6.append(r3)
            r6.append(r0)
            int r3 = com.cuspal.interlinks.Global.latmm
            r6.append(r3)
            r6.append(r4)
            int r3 = com.cuspal.interlinks.Global.londd
            r6.append(r3)
            r6.append(r0)
            java.lang.String r3 = com.cuspal.interlinks.Global.lonEW
            r6.append(r3)
            r6.append(r0)
            int r3 = com.cuspal.interlinks.Global.lonmm
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r6 = 1
            r1[r6] = r3
            r1 = r2[r24]
            java.lang.String r3 = "Time zone/Cor"
            r6 = 0
            r1[r6] = r3
            r1 = r2[r24]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = com.cuspal.interlinks.Global.TzPM
            r3.append(r6)
            r3.append(r8)
            int r6 = com.cuspal.interlinks.Global.TzHH
            r3.append(r6)
            r3.append(r0)
            int r6 = com.cuspal.interlinks.Global.TzMM
            r3.append(r6)
            r3.append(r4)
            java.lang.String r4 = com.cuspal.interlinks.Global.TcPM
            r3.append(r4)
            r3.append(r8)
            int r4 = com.cuspal.interlinks.Global.TcHH
            r3.append(r4)
            r3.append(r0)
            int r0 = com.cuspal.interlinks.Global.TcMM
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 1
            r1[r3] = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.Main_details_tab.Set_Data_Table():java.lang.String[][]");
    }

    private void calculate_all() {
        int i;
        int i2;
        SwissEph sw = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe");
        SweDate sd = new SweDate(this.year, this.month, this.day, this.hour);
        this.latitude = AstroCalc.kp_GeoCorr(Double.valueOf(this.latitude));
        double newKPAyan_ = AstroCalc.get_ayan(sd.getJulDay());
        Global.ayan = newKPAyan_;
        double[] cusps_ = new double[13];
        if (!Global.ishorary) {
            sw.swe_houses(sd.getJulDay(), 256, this.latitude, this.longitude, 80, cusps_, this.acsc);
            SwissEph swissEph = sw;
            i2 = 12;
            i = 6;
        } else {
            double fCusNir = AstroCalc.kp_Sub249Hor(Global.Hno - 1);
            double[] dArr = new double[12];
            double[] xx = new double[6];
            SwissEph swissEph2 = sw;
            swissEph2.swe_calc_ut(sd.getJulDay(), -1, 0, xx, new StringBuffer());
            double[] dArr2 = xx;
            SwissEph swissEph3 = sw;
            i2 = 12;
            double[] dArr3 = cusps_;
            i = 6;
            cusps_ = kp_Horar(sd.getJulDay(), fCusNir, this.latitude, newKPAyan_);
        }
        newKPAyan = newKPAyan_;
        Log.e("BAyan:", String.valueOf(newKPAyan_));
        Log.e("Bjul:", String.valueOf(sd.getJulDay()));
        Log.e("", "----------------------------------------------------------");
        for (int i3 = 0; i3 < i2; i3++) {
            cusps[i3] = cusps_[i3 + 1];
            Log.e("Cusp : ", AstroCalc.toDMS(cusps_[i3]));
            this.hCuspI[i3] = AstroCalc.hp_Rnd0To360v(cusps_[i3 + 1] - newKPAyan);
        }
        Log.e("", "----------------------------------------------------------");
        pPos[0] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 0) - newKPAyan);
        pPos[1] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 1) - newKPAyan);
        pPos[2] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 4) - newKPAyan);
        pPos[3] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 2) - newKPAyan);
        pPos[4] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 5) - newKPAyan);
        pPos[5] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 3) - newKPAyan);
        pPos[i] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), i) - newKPAyan);
        pPos[7] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 11) - newKPAyan);
        double[] dArr4 = pPos;
        dArr4[8] = AstroCalc.hp_Rnd0To360v(dArr4[7] + 180.0d);
        pPos[9] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 7) - newKPAyan);
        pPos[10] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 8) - newKPAyan);
        int[] incHouse_ = new int[i2];
        for (int i4 = 0; i4 < 11; i4++) {
            incHouse_[i4] = kp_includehouse02(pPos[i4]);
            this.incHouse[i4] = incHouse_[i4];
        }
        calcDasa(pPos[1], sd.getJulDay());
    }

    private void initializeHeaderRow_P(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Pln", "DMS", "SGN", "STL", "SBL", "SSL"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        new TableRow(this);
        for (int i = 0; i < 11; i++) {
            insertScoreRow_C(scoreTable, pNames[i], AstroCalc.toDMS(pPos[i]), pRasiNames[AstroCalc.GetLagnaSign(pPos[i])], pStarNames[AstroCalc.GetStarLord(pPos[i])], AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pPos[i]), false)), 0.0d), AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pPos[i]), true)), 0.0d));
        }
    }

    private void A07_calc4StepSig() {
        byte b;
        int a1 = 0;
        while (true) {
            b = 9;
            if (a1 >= 9) {
                break;
            }
            for (byte a2 = 0; a2 < 12; a2 = (byte) (a2 + 1)) {
                if (a1 == ((byte) AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusps[a2] - newKPAyan), false))) {
                    String[] strArr = this.ownBhava;
                    if (strArr[a1] == null) {
                        strArr[a1] = (a2 + 1) + ",";
                    } else {
                        strArr[a1] = this.ownBhava[a1] + (a2 + 1) + ",";
                    }
                }
            }
            a1 = (byte) (a1 + 1);
        }
        int a3 = 0;
        while (a3 < 9) {
            this.posBhava[a3] = kp_includehouse02(pPos[this.planet2Int[a3]]) + 1;
            a3 = (byte) (a3 + 1);
        }
        for (byte a4 = 0; a4 < 9; a4 = (byte) (a4 + 1)) {
            this.stLords[a4] = AstroCalc.kp_StarLordInt(pPos[this.planet2Int[a4]], true);
        }
        for (byte a5 = 0; a5 < 9; a5 = (byte) (a5 + 1)) {
            this.stLordsOwn[a5] = this.ownBhava[this.stLords[a5]];
        }
        for (byte a6 = 0; a6 < 9; a6 = (byte) (a6 + 1)) {
            this.stLordsPos[a6] = this.posBhava[this.stLords[a6]];
        }
        for (byte a7 = 0; a7 < 9; a7 = (byte) (a7 + 1)) {
            this.sbLords[a7] = AstroCalc.kp_SubLord01(pPos[this.planet2Int[a7]], false);
        }
        byte a8 = 0;
        while (a8 < 9) {
            this.sbLordsOwn[a8] = this.ownBhava[this.sbLords[a8]];
            a8 = (byte) (a8 + 1);
        }
        for (byte a9 = 0; a9 < 9; a9 = (byte) (a9 + 1)) {
            this.sbLordsPos[a9] = this.posBhava[this.sbLords[a9]];
        }
        for (byte b1 = 0; b1 < 9; b1 = (byte) (b1 + 1)) {
            this.stSbLords[b1] = this.stLords[this.sbLords[b1]];
        }
        for (byte b2 = 0; b2 < 9; b2 = (byte) (b2 + 1)) {
            this.stSbLordsOwn[b2] = this.ownBhava[this.stSbLords[b2]];
        }
        for (byte b3 = 0; b3 < 9; b3 = (byte) (b3 + 1)) {
            this.stSbLordsPos[b3] = this.posBhava[this.stSbLords[b3]];
        }
        String emptyBhava = "";
        byte b4 = 0;
        while (b4 < b) {
            int a12 = a1;
            int tmp = 0;
            byte tmp2 = a8;
            byte b5 = 0;
            while (b5 < b) {
                if (b4 == this.posBhava[b5]) {
                    tmp++;
                }
                b5 = (byte) (b5 + 1);
                b = 9;
            }
            if (tmp < 1) {
                emptyBhava = emptyBhava + b4 + " ";
            }
            b4 = (byte) (b4 + 1);
            a8 = tmp2;
            a1 = a12;
            b = 9;
        }
        byte b6 = a8;
        String noPInStar = "";
        byte b62 = 0;
        while (true) {
            if (b62 >= 9) {
                break;
            }
            int a32 = a3;
            int tmp1 = 0;
            String emptyBhava2 = emptyBhava;
            byte b7 = 0;
            for (byte b8 = 9; b7 < b8; b8 = 9) {
                if (b62 == this.stLords[b7]) {
                    tmp1++;
                }
                b7 = (byte) (b7 + 1);
            }
            if (tmp1 < 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(noPInStar);
                String str = noPInStar;
                sb.append(planetName2Tr[b62]);
                sb.append(" ");
                noPInStar = sb.toString();
            } else {
                String str2 = noPInStar;
            }
            b62 = (byte) (b62 + 1);
            emptyBhava = emptyBhava2;
            a3 = a32;
        }
        String str3 = noPInStar;
        int i = a3;
        String str4 = emptyBhava;
        String selfCons = "";
        for (byte b82 = 0; b82 < 9; b82 = (byte) (b82 + 1)) {
            if (b82 == this.stLords[b82]) {
                selfCons = selfCons + planetName2Tr[b82] + " ";
            }
        }
    }

    private void initializeHeaderRow_Significator(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text_title);
        float f = this.Size;
        addTextToRowWithValues_array(headerRow, new String[]{"PLN", "SIG", "OC", "STL", "SIG", "OC", "SBL", "SIG", "OC"}, textColor);
        scoreTable.addView(headerRow);
        A07_calc4StepSig();
        int i = 0;
        while (i < 9) {
            insertScoreRow_D(scoreTable, AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(i), 0.0d), this.ownBhava[i], AstroCalc.hp_4StepFil(this.posBhava[i]), planetName2Tr[this.stLords[i]], this.stLordsOwn[i], AstroCalc.hp_4StepFil(this.stLordsPos[i]), planetName2Tr[this.sbLords[i]], this.sbLordsOwn[i], AstroCalc.hp_4StepFil(this.sbLordsPos[i]));
            i++;
            TableLayout tableLayout = scoreTable;
        }
    }

    private void initializeHeaderRow_Significator_cusp(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"#", "1st", "2nd", "3rd", "4th"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        A06_calcSig();
        for (int i = 0; i < 12; i++) {
            insertScoreRow_sig_cus(scoreTable, AstroCalc.aNames[i], this.conSig0[i], this.conSig1[i], this.conSig11[i], this.conSig2[i]);
        }
    }

    public void A06_calcSig() {
        int[] bhavaLord;
        byte a1;
        String[] bhavaLordStr = new String[12];
        int[] bhavaLord2 = new int[12];
        byte a12 = 0;
        while (a12 < 12) {
            bhavaLord2[a12] = AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusps[a12] - newKPAyan), false));
            bhavaLordStr[a12] = AstroCalc.kp_PlanetName(AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(cusps[a12] - newKPAyan), false)), 0.0d);
            a12 = (byte) (a12 + 1);
        }
        for (byte n1 = 0; n1 < 12; n1 = (byte) (n1 + 1)) {
            this.conSig0[n1] = bhavaLordStr[n1];
        }
        String[] planetsInBhavaLordStr = new String[12];
        int[] starLordOfPlanet = new int[9];
        for (byte a4 = 0; a4 < 9; a4 = (byte) (a4 + 1)) {
            starLordOfPlanet[a4] = AstroCalc.kp_StarLordInt(pPos[a4], false);
            String kp_PlanetName = AstroCalc.kp_PlanetName(AstroCalc.kp_StarLordInt(pPos[a4], false), 0.0d);
        }
        for (byte a2 = 0; a2 < 12; a2 = (byte) (a2 + 1)) {
            for (byte a3 = 0; a3 < 9; a3 = (byte) (a3 + 1)) {
                if (bhavaLord2[a2] == starLordOfPlanet[a3]) {
                    if (planetsInBhavaLordStr[a2] == null) {
                        planetsInBhavaLordStr[a2] = planetName1Tr[a3] + " ";
                    } else {
                        planetsInBhavaLordStr[a2] = planetsInBhavaLordStr[a2] + planetName1Tr[a3] + " ";
                    }
                }
            }
        }
        for (byte n2 = 0; n2 < 12; n2 = (byte) (n2 + 1)) {
            this.conSig1[n2] = planetsInBhavaLordStr[n2];
        }
        String[] planetsInBhavaLordStr1 = new String[12];
        int[] starLordOfPlanet1 = new int[9];
        byte a42 = 0;
        for (byte b = 9; a42 < b; b = 9) {
            starLordOfPlanet1[a42] = AstroCalc.kp_PID2N(AstroCalc.kp_SubLord01(AstroCalc.hp_Rnd0To360v(pPos[a42]), false));
            a42 = (byte) (a42 + 1);
            starLordOfPlanet = starLordOfPlanet;
        }
        for (byte a22 = 0; a22 < 10; a22 = (byte) (a22 + 1)) {
            planetsInBhavaLordStr1[a22] = "";
        }
        for (byte a23 = 0; a23 < 12; a23 = (byte) (a23 + 1)) {
            for (byte a32 = 0; a32 < 9; a32 = (byte) (a32 + 1)) {
                if (bhavaLord2[a23] == starLordOfPlanet1[a32]) {
                    if (planetsInBhavaLordStr1[a23] == null) {
                        planetsInBhavaLordStr1[a23] = planetName1Tr[a32] + " ";
                    } else {
                        planetsInBhavaLordStr1[a23] = planetsInBhavaLordStr1[a23] + planetName1Tr[a32] + " ";
                    }
                }
            }
        }
        for (byte n22 = 0; n22 < 12; n22 = (byte) (n22 + 1)) {
            this.conSig11[n22] = planetsInBhavaLordStr1[n22];
        }
        String[] positedPlanets = new String[12];
        int[] incBhav = new int[12];
        byte a5 = 0;
        for (byte b2 = 12; a5 < b2; b2 = 12) {
            incBhav[a5] = this.incHouse[a5];
            a5 = (byte) (a5 + 1);
        }
        byte a6 = 0;
        while (true) {
            String[] bhavaLordStr2 = bhavaLordStr;
            if (a6 >= 12) {
                break;
            }
            byte a7 = 0;
            while (true) {
                bhavaLord = bhavaLord2;
                if (a7 >= 9) {
                    break;
                }
                if (incBhav[a7] != a6) {
                    a1 = a12;
                } else if (positedPlanets[a6] == null) {
                    StringBuilder sb = new StringBuilder();
                    a1 = a12;
                    sb.append(planetName1Tr[a7]);
                    sb.append(" ");
                    positedPlanets[a6] = sb.toString();
                } else {
                    a1 = a12;
                    positedPlanets[a6] = positedPlanets[a6] + planetName1Tr[a7] + " ";
                }
                a7 = (byte) (a7 + 1);
                bhavaLord2 = bhavaLord;
                a12 = a1;
            }
            a6 = (byte) (a6 + 1);
            bhavaLordStr = bhavaLordStr2;
            bhavaLord2 = bhavaLord;
        }
        byte b3 = a12;
        for (byte n3 = 0; n3 < 12; n3 = (byte) (n3 + 1)) {
            this.conSig2[n3] = positedPlanets[n3];
        }
    }

    private void initializeHeaderRow_RP(TableLayout scoreTable) {
        int iss;
        int iminute;
        int ihh;
        int iday;
        int imonth;
        int iyear;
        int iday2;
        int imonth2;
        int iyear2;
        int iminute2;
        int iss2;
        int ihh2;
        String TzMM;
        String TzDD;
        String LonMM;
        String LonDD;
        String LatMM;
        String LonDD2;
        String LatNS;
        String LatMM2;
        String LatDD;
        Integer tmpvalue;
        Integer tmpvalue2;
        double ihour;
        TableRow headerRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text_title);
        String[] Header_Text = {"CS", "SGN", "DAS", "BHU", "AND", "DMS", "PLN", "STL", "SBL", "SSL"};
        addTextToRowWithValues_array(headerRow, Header_Text, textColor);
        scoreTable.addView(headerRow);
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        if (Global.rp) {
            iyear = this.year;
            imonth = this.month;
            iday = this.day;
            ihh = Global.hh;
            iminute = Global.min;
            iss = Global.ss;
        } else {
            iyear = Global.rpyy;
            imonth = Global.rpmm;
            iday = Global.rpdd;
            ihh = Global.rphh;
            iminute = Global.rpmin;
            iss = Global.rpss;
        }
        if (Global.ishorary) {
            int iyear3 = this.year;
            int imonth3 = this.month;
            int iday3 = this.day;
            int ihh3 = Global.hh;
            iyear2 = iyear3;
            imonth2 = imonth3;
            iday2 = iday3;
            iminute2 = Global.min;
            iss2 = ihh3;
            ihh2 = Global.ss;
        } else {
            iyear2 = iyear;
            imonth2 = imonth;
            iday2 = iday;
            iminute2 = iminute;
            int i = iss;
            iss2 = ihh;
            ihh2 = i;
        }
        TextView tv = (TextView) findViewById(R.id.txtrpdata);
        tv.setText(String.format("Date / Time :%02d-%02d-%04d / %02d:%02d:%02d", new Object[]{Integer.valueOf(iday2), Integer.valueOf(imonth2), Integer.valueOf(iyear2), Integer.valueOf(iss2), Integer.valueOf(iminute2), Integer.valueOf(ihh2)}));
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", 0);
        this.sharedpreferences = sharedPreferences;
        String CheckIsLatitude = sharedPreferences.getString("LatDD", (String) null);
        String CheckIsLongitude = this.sharedpreferences.getString("LonDD", (String) null);
        if (Global.rp) {
            String LatDD2 = String.valueOf(Global.latdd);
            String LatMM3 = String.valueOf(Global.latmm);
            String LatNS2 = Global.latNS;
            String LonDD3 = String.valueOf(Global.londd);
            String LonMM2 = String.valueOf(Global.lonmm);
            String LonEW = Global.lonEW;
            String TzDD2 = String.valueOf(Global.TzHH);
            String TzMM2 = String.valueOf(Global.TzMM);
            String TzPM = Global.TzPM;
            Global.rp = false;
            LatMM = LatMM3;
            LatMM2 = LatNS2;
            LonDD = LonDD3;
            LonMM = LonMM2;
            LatNS = LonEW;
            TzDD = TzDD2;
            TzMM = TzMM2;
            LonDD2 = LatDD2;
            LatDD = TzPM;
        } else if (CheckIsLatitude == null || CheckIsLongitude == null) {
            LatMM = "59";
            LatMM2 = "N";
            LonDD = "79";
            LonMM = "59";
            LatNS = "E";
            TzDD = "05";
            TzMM = "30";
            LonDD2 = "11";
            LatDD = "+";
        } else {
            String LatDD3 = this.sharedpreferences.getString("LatDD", (String) null);
            String LatMM4 = this.sharedpreferences.getString("LatMM", (String) null);
            String LatDD4 = LatDD3;
            String LatNS3 = this.sharedpreferences.getString("LatNS", (String) null);
            String LonDD4 = this.sharedpreferences.getString("LonDD", (String) null);
            String LatNS4 = LatNS3;
            String LonMM3 = this.sharedpreferences.getString("LonMM", (String) null);
            String LonEW2 = this.sharedpreferences.getString("LonEW", (String) null);
            String TzDD3 = this.sharedpreferences.getString("TzHH", (String) null);
            String TzMM3 = this.sharedpreferences.getString("TzMM", (String) null);
            LatDD = this.sharedpreferences.getString("TzPM", (String) null);
            LatMM2 = LatNS4;
            LonMM = LonMM3;
            TzDD = TzDD3;
            TzMM = TzMM3;
            LatMM = LatMM4;
            LonDD = LonDD4;
            LonDD2 = LatDD4;
            LatNS = LonEW2;
        }
        if (LatMM2.contains("N")) {
            tmpvalue = 1;
        } else {
            tmpvalue = -1;
        }
        TableRow tableRow = headerRow;
        int i2 = textColor;
        String[] strArr = Header_Text;
        Calendar calendar = cal;
        double Latitude = AstroCalc.kp_GeoCorr(Double.valueOf(((double) (Integer.parseInt(LonDD2) * tmpvalue.intValue())) + (((double) Integer.parseInt(LatMM)) / 60.0d)));
        if (LatNS.contains("E")) {
            tmpvalue2 = 1;
        } else {
            tmpvalue2 = -1;
        }
        String LatNS5 = LatMM2;
        String LonEW3 = LatNS;
        Integer num = tmpvalue2;
        double Longitude = (((double) Integer.parseInt(LonMM)) / 60.0d) + ((double) (Integer.parseInt(LonDD) * tmpvalue2.intValue()));
        Date date2 = date;
        String str = LonDD2;
        double TZone = (((double) Integer.parseInt(TzMM)) / 60.0d) + ((double) Integer.parseInt(TzDD));
        if (LatDD.equals("+")) {
            ihour = ((((double) iss2) + (((double) iminute2) / 60.0d)) + (((double) ihh2) / 3600.0d)) - TZone;
        } else {
            ihour = ((double) iss2) + (((double) iminute2) / 60.0d) + (((double) ihh2) / 3600.0d) + TZone;
        }
        SweDate sd = new SweDate(iyear2, imonth2, iday2, ihour);
        double a = sd.getJulDay();
        double newKPAyan_ = AstroCalc.get_ayan(a);
        double d = ihour;
        double[] cusp = new double[12];
        double[] dArr = new double[12];
        String str2 = LatDD;
        String str3 = LatNS5;
        String LatNS6 = LonEW3;
        double[] pos = new double[12];
        int i3 = ihh2;
        TextView textView = tv;
        int i4 = iss2;
        int i5 = iminute2;
        double[] cusp_ = ComputeLagnaPosArray(a, Latitude, Longitude);
        Log.e("", "-------------------RP Details-------------------------");
        Log.e("RP JD", String.valueOf(a));
        Log.e("RP Aya:", String.valueOf(newKPAyan_));
        Log.e("RP Lat:", String.valueOf(Latitude));
        Log.e("RP Lon:", String.valueOf(Longitude));
        Log.e("RP Tz:", String.valueOf(TZone));
        for (int i6 = 0; i6 <= 11; i6++) {
            cusp[i6] = AstroCalc.hp_Rnd0To360v(cusp_[i6 + 1] - newKPAyan_);
            Log.e("RP Cusp : ", String.valueOf(cusp[i6]));
        }
        Log.e("", "----------------*---END RP Details---*----------------------");
        pos[0] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 0) - newKPAyan_);
        pos[1] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 1) - newKPAyan_);
        pos[2] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 4) - newKPAyan_);
        pos[3] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 2) - newKPAyan_);
        pos[4] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 5) - newKPAyan_);
        pos[5] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 3) - newKPAyan_);
        pos[6] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 6) - newKPAyan_);
        pos[7] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 11) - newKPAyan_);
        pos[8] = AstroCalc.hp_Rnd0To360v(pos[7] + 180.0d);
        pos[9] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 7) - newKPAyan_);
        double d2 = Latitude;
        pos[10] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(sd.getJulDay(), 8) - newKPAyan_);
        int[] incHouse_ = new int[12];
        int[] incHouse_tmp = new int[12];
        int i7 = 0;
        for (int i8 = 12; i7 < i8; i8 = 12) {
            incHouse_[i7] = kp_includehouse04(pos[i7], cusp);
            incHouse_tmp[i7] = incHouse_[i7];
            i7++;
        }
        double[] allPos = new double[21];
        double[] allPos2 = new double[21];
        double[] allPos_Aligned = new double[21];
        for (int i9 = 0; i9 <= 11; i9++) {
            allPos[i9] = cusp[i9];
            allPos2[i9] = cusp[i9];
        }
        for (int j = 0; j < 9; j++) {
            allPos[j + 12] = pos[j];
            allPos2[j + 12] = pos[j];
        }
        AstroCalc.posSort(allPos, 0, 20);
        int[] idAr = new int[21];
        int j1 = 0;
        while (true) {
            double[] cusp_2 = cusp_;
            if (j1 > 20) {
                break;
            }
            int[] incHouse_2 = incHouse_;
            int j2 = 0;
            for (int i10 = 20; j2 <= i10; i10 = 20) {
                if (Math.abs(allPos[j1] - allPos2[j2]) < 1.0E-30d) {
                    idAr[j1] = j2;
                }
                j2++;
            }
            j1++;
            cusp_ = cusp_2;
            incHouse_ = incHouse_2;
        }
        int[] idAr_aligned = new int[21];
        int j12 = 0;
        while (true) {
            if (j12 > 21) {
                break;
            } else if (idAr[j12] == 0) {
                double[] dArr2 = cusp;
                for (int tmp = 0; tmp < 21; tmp++) {
                    allPos_Aligned[tmp] = allPos[(tmp + j12) % 21];
                    idAr_aligned[tmp] = idAr[(tmp + j12) % 21];
                }
            } else {
                j12++;
            }
        }
        byte j3 = 0;
        while (j3 <= 20) {
            kb_ChartPrint(allPos_Aligned[j3], idAr_aligned[j3], scoreTable);
            j3 = (byte) (j3 + 1);
            idAr = idAr;
            allPos = allPos;
        }
    }

    /* access modifiers changed from: private */
    public void initializeHeaderRow_Transit_chart(TableLayout scoreTable, double JD) {
        double ihour;
        TableLayout tableLayout = scoreTable;
        TableRow headerRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text_title);
        String[] Header_Text = {"CS", "SGN", "DAS", "BHU", "AND", "DMS", "PLN", "STL", "SBL", "SSL"};
        addTextToRowWithValues_array(headerRow, Header_Text, textColor);
        tableLayout.addView(headerRow);
        int iyear = Global.yy;
        int imonth = Global.mm;
        int iday = Global.dd;
        int ihh = Global.hh;
        int iminute = Global.min;
        int iss = Global.ss;
        if (Global.TzPM.equals("+")) {
            TableRow tableRow = headerRow;
            int i = textColor;
            ihour = ((((double) ihh) + (((double) iminute) / 60.0d)) + (((double) iss) / 3600.0d)) - this.tz;
        } else {
            int i2 = textColor;
            ihour = ((double) ihh) + (((double) iminute) / 60.0d) + (((double) iss) / 3600.0d) + this.tz;
        }
        double a = JD;
        int i3 = iss;
        SweDate sd = new SweDate(iyear, imonth, iday, ihour);
        double newKPAyan_Pos = AstroCalc.get_ayan(a);
        double newKPAyan_Cusp = AstroCalc.get_ayan(sd.getJulDay());
        double d = ihour;
        double[] cusp = new double[12];
        double[] dArr = new double[12];
        double[] pos = new double[12];
        int i4 = iyear;
        double[] cusp_ = ComputeLagnaPosArray(sd.getJulDay());
        int i5 = 0;
        while (true) {
            String[] Header_Text2 = Header_Text;
            if (i5 > 11) {
                break;
            }
            cusp[i5] = AstroCalc.hp_Rnd0To360v(cusp_[i5 + 1] - newKPAyan_Pos);
            Log.e("RP Cusp : ", String.valueOf(cusp[i5]));
            i5++;
            Header_Text = Header_Text2;
            sd = sd;
        }
        Log.e("", "----------------*---END RP Details---*----------------------");
        double d2 = newKPAyan_Cusp;
        double a2 = a;
        pos[0] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 0) - newKPAyan_Pos);
        pos[1] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 1) - newKPAyan_Pos);
        pos[2] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 4) - newKPAyan_Pos);
        pos[3] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 2) - newKPAyan_Pos);
        pos[4] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 5) - newKPAyan_Pos);
        pos[5] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 3) - newKPAyan_Pos);
        pos[6] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 6) - newKPAyan_Pos);
        pos[7] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 11) - newKPAyan_Pos);
        pos[8] = AstroCalc.hp_Rnd0To360v(pos[7] + 180.0d);
        pos[9] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 7) - newKPAyan_Pos);
        pos[10] = AstroCalc.hp_Rnd0To360v(ComputePlanetPos(a2, 8) - newKPAyan_Pos);
        int[] incHouse_ = new int[12];
        int[] incHouse_tmp = new int[12];
        double d3 = newKPAyan_Pos;
        int i6 = 0;
        while (i6 < 12) {
            incHouse_[i6] = kp_includehouse04(pos[i6], cusp);
            incHouse_tmp[i6] = incHouse_[i6];
            i6++;
            a2 = a2;
        }
        double[] allPos = new double[21];
        double[] allPos2 = new double[21];
        double[] allPos_Aligned = new double[21];
        int i7 = 0;
        while (i7 <= 11) {
            allPos[i7] = cusp[i7];
            allPos2[i7] = cusp[i7];
            i7++;
        }
        int j = 0;
        while (true) {
            double[] cusp2 = cusp;
            if (j >= 9) {
                break;
            }
            allPos[j + 12] = pos[j];
            allPos2[j + 12] = pos[j];
            j++;
            cusp = cusp2;
        }
        AstroCalc.posSort(allPos, 0, 20);
        int[] idAr = new int[21];
        int j1 = 0;
        while (true) {
            double[] pos2 = pos;
            if (j1 > 20) {
                break;
            }
            int[] incHouse_2 = incHouse_;
            int j2 = 0;
            for (int i8 = 20; j2 <= i8; i8 = 20) {
                if (Math.abs(allPos[j1] - allPos2[j2]) < 1.0E-30d) {
                    idAr[j1] = j2;
                }
                j2++;
            }
            j1++;
            pos = pos2;
            incHouse_ = incHouse_2;
        }
        int[] idAr_aligned = new int[21];
        int j12 = 0;
        while (true) {
            if (j12 > 21) {
                break;
            } else if (idAr[j12] == 0) {
                int i9 = i7;
                for (int tmp = 0; tmp < 21; tmp++) {
                    allPos_Aligned[tmp] = allPos[(tmp + j12) % 21];
                    idAr_aligned[tmp] = idAr[(tmp + j12) % 21];
                }
            } else {
                j12++;
            }
        }
        byte j3 = 0;
        while (j3 <= 20) {
            kb_ChartPrint(allPos_Aligned[j3], idAr_aligned[j3], tableLayout);
            j3 = (byte) (j3 + 1);
            idAr = idAr;
        }
    }

    private void initializeHeaderRow_D01(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"DASA", "S.Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        for (int i = 0; i < 9; i++) {
            insertScoreRow_dasa_01(scoreTable, planetName2Tr[this.mDasL[i]], kp_RevJday(this.mDas[i]));
        }
    }

    /* access modifiers changed from: private */
    public void initializeHeaderRow_D02(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Bhuti", "S.Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        for (int i = 0; i < 9; i++) {
            String[] strArr = planetName2Tr;
            int[][] iArr = this.bDasL;
            byte b = this.daspos;
            insertScoreRow_dasa_02(scoreTable, strArr[iArr[b][i]], kp_RevJday(this.bDas[b][i]));
        }
    }

    /* access modifiers changed from: private */
    public void initializeHeaderRow_D03(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Ant", "S.Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        for (int i = 0; i < 9; i++) {
            String[] strArr = planetName2Tr;
            int[][][] iArr = this.aDasL;
            byte b = this.daspos;
            int[][] iArr2 = iArr[b];
            byte b2 = this.butpos;
            insertScoreRow_dasa_03(scoreTable, strArr[iArr2[b2][i]], kp_RevJday(this.aDas[b][b2][i]));
        }
    }

    /* access modifiers changed from: private */
    public void initializeHeaderRow_D04(TableLayout scoreTable) {
        TableRow headerRow = new TableRow(this);
        addTextToRowWithValues_array(headerRow, new String[]{"Soo", "S.Date"}, getResources().getColor(R.color.text_title));
        scoreTable.addView(headerRow);
        for (int i = 0; i < 9; i++) {
            String[] strArr = planetName2Tr;
            int[][][][] iArr = this.sDasL;
            byte b = this.daspos;
            int[][][] iArr2 = iArr[b];
            byte b2 = this.butpos;
            int[][] iArr3 = iArr2[b2];
            byte b3 = this.antpos;
            insertScoreRow_dasa_04(scoreTable, strArr[iArr3[b3][i]], kp_RevJday(this.sDas[b][b2][b3][i]));
        }
    }

    private void insertScoreRow_dasa_01(TableLayout scoreTable, String scoreUserName, String scoredata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoredata, textColor, textSize);
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View view2 = (View) view.getParent();
                String result = ((TextView) ((TableRow) view).getChildAt(0)).getText().toString();
                for (byte i = 0; i < 9; i = (byte) (i + 1)) {
                    if (result.equals(Main_details_tab.planetName2Tr[Main_details_tab.this.mDasL[i]])) {
                        Main_details_tab.this.daspos = i;
                        TableLayout table = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Bhuti);
                        table.removeAllViews();
                        ((TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Ant)).removeAllViews();
                        Main_details_tab.this.initializeHeaderRow_D02(table);
                    }
                }
            }
        });
    }

    private void insertScoreRow_dasa_02(TableLayout scoreTable, String scoreUserName, String scoredata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoredata, textColor, textSize);
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View view2 = (View) view.getParent();
                String result = ((TextView) ((TableRow) view).getChildAt(0)).getText().toString();
                for (byte i = 0; i < 9; i = (byte) (i + 1)) {
                    if (result.equals(Main_details_tab.planetName2Tr[Main_details_tab.this.bDasL[Main_details_tab.this.daspos][i]])) {
                        Main_details_tab.this.butpos = i;
                        TableLayout table = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Ant);
                        table.removeAllViews();
                        Main_details_tab.this.initializeHeaderRow_D03(table);
                    }
                }
            }
        });
    }

    private void insertScoreRow_dasa_04(TableLayout scoreTable, String scoreUserName, String scoredata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoredata, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_dasa_03(TableLayout scoreTable, String scoreUserName, String scoredata) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoredata, textColor, textSize);
        scoreTable.addView(newRow);
        newRow.setClickable(true);
        newRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View view2 = (View) view.getParent();
                String result = ((TextView) ((TableRow) view).getChildAt(0)).getText().toString();
                for (byte i = 0; i < 9; i = (byte) (i + 1)) {
                    if (result.equals(Main_details_tab.planetName2Tr[Main_details_tab.this.aDasL[Main_details_tab.this.daspos][Main_details_tab.this.butpos][i]])) {
                        Main_details_tab.this.antpos = i;
                        TableLayout table = (TableLayout) Main_details_tab.this.findViewById(R.id.TableLayout_Soo);
                        table.removeAllViews();
                        Main_details_tab.this.initializeHeaderRow_D04(table);
                    }
                }
            }
        });
    }

    private void insertScoreRow_sig_cus(TableLayout scoreTable, String scoreValue, String scoreRank, String scoreUserName, String scorevalue1, String scorevalue2) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, scoreValue, textColor, textSize);
        addTextToRowWithValues(newRow, scoreRank, textColor, textSize);
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scorevalue1, textColor, textSize);
        addTextToRowWithValues(newRow, scorevalue2, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_C(TableLayout scoreTable, String csValue, String dmsValue, String sgnValue, String dasValue, String bhuValue, String andValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        addTextToRowWithValues(newRow, sgnValue, textColor, textSize);
        addTextToRowWithValues(newRow, dasValue, textColor, textSize);
        addTextToRowWithValues(newRow, bhuValue, textColor, textSize);
        addTextToRowWithValues(newRow, andValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_D(TableLayout scoreTable, String PlnValue, String plSigValue, String plocValue, String strValue, String strsigValue, String strocValue, String subValue, String subsigValue, String subocValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, PlnValue, textColor, textSize);
        addTextToRowWithValues(newRow, plSigValue, textColor, textSize);
        addTextToRowWithValues(newRow, plocValue, textColor, textSize);
        addTextToRowWithValues(newRow, strValue, textColor, textSize);
        addTextToRowWithValues(newRow, strsigValue, textColor, textSize);
        addTextToRowWithValues(newRow, strocValue, textColor, textSize);
        addTextToRowWithValues(newRow, subValue, textColor, textSize);
        addTextToRowWithValues(newRow, subsigValue, textColor, textSize);
        addTextToRowWithValues(newRow, subocValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_kb(TableLayout scoreTable, String csValue, String sgnValue, String dasValue, String bhuValue, String andValue, String dmsValue, String plValue, String stlValue, String sblValue, String sslValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        int textbhu = getResources().getColor(R.color.INFO);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, sgnValue, textColor, textSize);
        addTextToRowWithValues(newRow, dasValue, textColor, textSize);
        addTextToRowWithValues(newRow, bhuValue, textbhu, textSize);
        addTextToRowWithValues(newRow, andValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        addTextToRowWithValues(newRow, plValue, textColor, textSize);
        addTextToRowWithValues(newRow, stlValue, textColor, textSize);
        addTextToRowWithValues(newRow, sblValue, textColor, textSize);
        addTextToRowWithValues(newRow, sslValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_Aspec(TableLayout scoreTable, String csValue, String dmsValue, String sgnValue, String dasValue, String bhuValue, String andValue, String EmptyValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        addTextToRowWithValues(newRow, sgnValue, textColor, textSize);
        addTextToRowWithValues(newRow, dasValue, textColor, textSize);
        addTextToRowWithValues(newRow, bhuValue, textColor, textSize);
        addTextToRowWithValues(newRow, andValue, textColor, textSize);
        addTextToRowWithValues(newRow, EmptyValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_kb_rp(TableLayout scoreTable, String csValue, String sgnValue, String dasValue, String bhuValue, String andValue, String dmsValue, String plValue, String stlValue, String sblValue, String sslValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, sgnValue, textColor, textSize);
        addTextToRowWithValues(newRow, dasValue, textColor, textSize);
        addTextToRowWithValues(newRow, bhuValue, textColor, textSize);
        addTextToRowWithValues(newRow, andValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        addTextToRowWithValues(newRow, plValue, textColor, textSize);
        addTextToRowWithValues(newRow, stlValue, textColor, textSize);
        addTextToRowWithValues(newRow, sblValue, textColor, textSize);
        addTextToRowWithValues(newRow, sslValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void insertScoreRow_dt(TableLayout scoreTable, String csValue, String dmsValue) {
        TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.text);
        float textSize = this.Size;
        addTextToRowWithValues(newRow, csValue, textColor, textSize);
        addTextToRowWithValues(newRow, dmsValue, textColor, textSize);
        scoreTable.addView(newRow);
    }

    private void addTextToRowWithValues(TableRow tableRow, String text, int textColor, float textSize) {
        ShapeDrawable border = new ShapeDrawable(new RectShape());
        border.getPaint().setStyle(Paint.Style.STROKE);
        border.getPaint().setColor(ViewCompat.MEASURED_STATE_MASK);
        TextView textView = new TextView(this);
        textView.setTextSize(this.Size);
        textView.setTextColor(textColor);
        textView.setGravity(17);
        textView.setBackground(border);
        textView.setText(text);
        tableRow.addView(textView);
    }

    private void addTextToRowWithValues_array(TableRow tableRow, String[] Arg, int textColor) {
        for (String text : Arg) {
            ShapeDrawable border = new ShapeDrawable(new RectShape());
            border.getPaint().setStyle(Paint.Style.STROKE);
            border.getPaint().setColor(ViewCompat.MEASURED_STATE_MASK);
            TextView textView = new TextView(this);
            textView.setTextSize(this.Size);
            textView.setTextColor(textColor);
            textView.setGravity(17);
            textView.setBackground(border);
            textView.setText(text);
            tableRow.addView(textView);
        }
    }

    public int GetsubLord(double pPos2, boolean isSubSub) {
        int i;
        double d = pPos2;
        double[] nakBorders = new double[28];
        for (int i1 = 0; i1 < 27; i1++) {
            nakBorders[i1] = ((double) (i1 * 360)) / 27.0d;
        }
        double selVal1 = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 < 26) {
                if (nakBorders[i2] <= d && d < nakBorders[i2 + 1]) {
                    selVal1 = nakBorders[i2];
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        int selNakLord = AstroCalc.kp_StarLordInt(d, true);
        double[] sub1LordDur = new double[9];
        int[] sub1LordInt2 = new int[9];
        int j1 = 0;
        while (true) {
            if (j1 >= 8) {
                break;
            }
            double[] sub1LordDur2 = sub1LordDur;
            sub1LordDur2[j1] = (dasaYears[AstroCalc.hp_Rnd0To8v((double) (selNakLord + j1))] / 120.0d) * 13.3333333333333d;
            j1++;
            sub1LordDur = sub1LordDur2;
        }
        double[] sub1LordDur3 = sub1LordDur;
        for (int j2 = 0; j2 < 9; j2++) {
            sub1LordInt2[j2] = AstroCalc.hp_Rnd0To8v((double) (selNakLord + j2));
        }
        double[] sub1Bor = new double[9];
        sub1Bor[0] = selVal1;
        for (int j3 = 0; j3 < 8; j3++) {
            sub1Bor[j3 + 1] = sub1Bor[j3] + sub1LordDur3[j3];
        }
        double selVal2 = 0.0d;
        double sub1Duration = 0.0d;
        int sub1Lord = 0;
        int i3 = 0;
        while (true) {
            if (i3 < 8) {
                if (sub1Bor[i3] <= d && d < sub1Bor[i3 + 1]) {
                    selVal2 = sub1Bor[i3];
                    sub1Duration = sub1Bor[i3 + 1] - sub1Bor[i3];
                    sub1Lord = sub1LordInt2[i3];
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        double[] sub2LordDur = new double[9];
        int[] sub2LordInt = new int[9];
        int j4 = 0;
        for (i = 8; j4 < i; i = 8) {
            sub2LordDur[j4] = (dasaYears[AstroCalc.hp_Rnd0To8v((double) (sub1Lord + j4))] / 120.0d) * sub1Duration;
            j4++;
            nakBorders = nakBorders;
            selVal1 = selVal1;
        }
        double d2 = selVal1;
        for (int j5 = 0; j5 < 8; j5++) {
            sub2LordInt[j5] = AstroCalc.hp_Rnd0To8v((double) (sub1Lord + j5));
        }
        double[] sub2Bor = new double[9];
        sub2Bor[0] = selVal2;
        for (int j6 = 0; j6 < 8; j6++) {
            sub2Bor[j6 + 1] = sub2Bor[j6] + sub2LordDur[j6];
        }
        int sub2Lord = 0;
        int i4 = 0;
        while (true) {
            if (i4 < 8) {
                if (sub2Bor[i4] <= d && d < sub2Bor[i4 + 1]) {
                    double d3 = sub2Bor[i4];
                    double d4 = sub2Bor[i4 + 1] - sub2Bor[i4];
                    sub2Lord = sub2LordInt[i4];
                    break;
                }
                i4++;
            } else {
                break;
            }
        }
        if (!isSubSub) {
            return sub1Lord;
        }
        return sub2Lord;
    }

    public double ComputePlanetPos(double julDay, int planetId) {
        double[] xp = new double[6];
        StringBuffer serr = new StringBuffer();
        int swe_calc_ut = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe").swe_calc_ut(julDay, planetId, 256, xp, serr);
        return xp[0];
    }

    public double[] ComputePlanetPos_speed(double julDay, int planetId) {
        double[] xp = new double[6];
        StringBuffer serr = new StringBuffer();
        int swe_calc_ut = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe").swe_calc_ut(julDay, planetId, 256, xp, serr);
        return xp;
    }

    public double ComputeLagnaPos(double julDay) {
        double[] dArr = new double[6];
        new StringBuffer();
        double[] cusps_ = new double[13];
        int swe_houses = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe").swe_houses(julDay, 256, this.latitude, this.longitude, 80, cusps_, this.acsc);
        return cusps_[1];
    }

    public double[] ComputeLagnaPosArray(double julDay) {
        double[] dArr = new double[6];
        new StringBuffer();
        double[] cusps_ = new double[13];
        int swe_houses = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe").swe_houses(julDay, 256, this.latitude, this.longitude, 80, cusps_, this.acsc);
        return cusps_;
    }

    public double[] ComputeLagnaPosArray(double julDay, double Latitude, double Longitude) {
        double[] dArr = new double[6];
        new StringBuffer();
        double[] cusps_ = new double[13];
        int swe_houses = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe").swe_houses(julDay, 256, Latitude, Longitude, 80, cusps_, this.acsc);
        return cusps_;
    }

    public void calcDasa(double pPos2, double julDateLocal) {
        double lBor;
        Class<int> cls = int.class;
        Class<double> cls2 = double.class;
        double mPos = pPos2;
        double bJulDate = julDateLocal;
        double daysPerYear2 = 365.25d;
        double[][] bDasaYears = (double[][]) Array.newInstance(cls2, new int[]{9, 9});
        byte k1 = 0;
        while (true) {
            if (k1 >= 9) {
                break;
            }
            byte k2 = 0;
            for (byte b = 9; k2 < b; b = 9) {
                double[] dArr = bDasaYears[k1];
                int hp_Rnd0To8v = AstroCalc.hp_Rnd0To8v((double) (k1 + k2));
                double[] dArr2 = dasaYears;
                dArr[hp_Rnd0To8v] = (dArr2[k1] * dArr2[AstroCalc.hp_Rnd0To8v((double) (k1 + k2))]) / 120.0d;
                k2 = (byte) (k2 + 1);
            }
            byte b2 = k2;
            k1 = (byte) (k1 + 1);
        }
        double[][][] aDasaYears = (double[][][]) Array.newInstance(cls2, new int[]{9, 9, 9});
        byte k3 = 0;
        while (true) {
            byte b3 = 9;
            if (k3 >= 9) {
                break;
            }
            byte k4 = 0;
            while (k4 < b3) {
                byte k5 = 0;
                while (k5 < b3) {
                    aDasaYears[k3][k4][AstroCalc.hp_Rnd0To8v((double) (k4 + k5))] = bDasaYears[k3][k4] * (dasaYears[AstroCalc.hp_Rnd0To8v((double) (k4 + k5))] / 120.0d);
                    k5 = (byte) (k5 + 1);
                    k1 = k1;
                    bDasaYears = bDasaYears;
                    bJulDate = bJulDate;
                    b3 = 9;
                }
                double[][] dArr3 = bDasaYears;
                byte b4 = k1;
                k4 = (byte) (k4 + 1);
                bJulDate = bJulDate;
                b3 = 9;
            }
            double[][] dArr4 = bDasaYears;
            byte b5 = k1;
            k3 = (byte) (k3 + 1);
            bJulDate = bJulDate;
        }
        double bJulDate2 = bJulDate;
        double[][] bDasaYears2 = bDasaYears;
        byte b6 = k1;
        double[][][][] sDasaYears = (double[][][][]) Array.newInstance(cls2, new int[]{9, 9, 9, 9});
        byte k6 = 0;
        while (true) {
            byte b7 = 9;
            if (k6 >= 9) {
                break;
            }
            byte k7 = 0;
            while (k7 < b7) {
                byte k8 = 0;
                while (k8 < b7) {
                    byte k9 = 0;
                    while (k9 < b7) {
                        sDasaYears[k6][k7][k8][AstroCalc.hp_Rnd0To8v((double) (k8 + k9))] = aDasaYears[k6][k7][k8] * (dasaYears[AstroCalc.hp_Rnd0To8v((double) (k8 + k9))] / 120.0d);
                        k9 = (byte) (k9 + 1);
                        sDasaYears = sDasaYears;
                        k3 = k3;
                        aDasaYears = aDasaYears;
                        b7 = 9;
                    }
                    double[][][] dArr5 = aDasaYears;
                    byte b8 = k3;
                    k8 = (byte) (k8 + 1);
                    b7 = 9;
                }
                double[][][] dArr6 = aDasaYears;
                byte b9 = k3;
                k7 = (byte) (k7 + 1);
                b7 = 9;
            }
            double[][][] dArr7 = aDasaYears;
            byte b10 = k3;
            k6 = (byte) (k6 + 1);
        }
        double[][][][] sDasaYears2 = sDasaYears;
        double[][][] aDasaYears2 = aDasaYears;
        byte b11 = k3;
        double[] midVal = new double[28];
        byte i1 = 0;
        while (i1 < 28) {
            midVal[i1] = (((double) i1) / 27.0d) * 360.0d;
            i1 = (byte) (i1 + 1);
        }
        double uBor = 0.0d;
        double lBor2 = 0.0d;
        byte i2 = 0;
        while (true) {
            if (i2 < 27) {
                if (midVal[i2] < mPos && mPos < midVal[i2 + 1]) {
                    lBor2 = midVal[i2];
                    uBor = midVal[i2 + 1];
                    break;
                }
                i2 = (byte) (i2 + 1);
            } else {
                break;
            }
        }
        int nakLordInt = AstroCalc.kp_StarLordInt(mPos, true);
        byte b12 = i2;
        double[] dArr8 = midVal;
        int[] mDasaLordInt = new int[9];
        byte b13 = k6;
        byte i3 = 0;
        for (byte i22 = 9; i3 < i22; i22 = 9) {
            mDasaLordInt[i3] = AstroCalc.hp_Rnd0To8v((double) (nakLordInt + i3));
            i3 = (byte) (i3 + 1);
            i1 = i1;
            uBor = uBor;
        }
        double d = uBor;
        int[][] bDasaLordInt = (int[][]) Array.newInstance(cls, new int[]{9, 9});
        byte i4 = 0;
        while (true) {
            if (i4 >= 9) {
                break;
            }
            byte i5 = 0;
            for (byte b14 = 9; i5 < b14; b14 = 9) {
                bDasaLordInt[i4][i5] = AstroCalc.hp_Rnd0To8v((double) (mDasaLordInt[i4] + i5));
                i5 = (byte) (i5 + 1);
                i3 = i3;
                daysPerYear2 = daysPerYear2;
            }
            byte b15 = i3;
            i4 = (byte) (i4 + 1);
            daysPerYear2 = daysPerYear2;
        }
        double daysPerYear3 = daysPerYear2;
        byte b16 = i3;
        int[][][] aDasaLordInt = (int[][][]) Array.newInstance(cls, new int[]{10, 10, 10});
        byte i6 = 0;
        while (true) {
            byte b17 = 9;
            if (i6 >= 9) {
                break;
            }
            byte i7 = 0;
            while (i7 < b17) {
                byte i8 = 0;
                while (i8 < b17) {
                    aDasaLordInt[i6][i7][i8] = AstroCalc.hp_Rnd0To8v((double) (bDasaLordInt[i6][i7] + i8));
                    i8 = (byte) (i8 + 1);
                    cls2 = cls2;
                    i4 = i4;
                    mPos = mPos;
                    b17 = 9;
                }
                double d2 = mPos;
                byte b18 = i4;
                i7 = (byte) (i7 + 1);
                cls2 = cls2;
                b17 = 9;
            }
            double d3 = mPos;
            byte b19 = i4;
            i6 = (byte) (i6 + 1);
            cls2 = cls2;
        }
        Class<double> cls3 = cls2;
        double mPos2 = mPos;
        byte b20 = i4;
        int[][][][] sDasaLordInt = (int[][][][]) Array.newInstance(cls, new int[]{10, 10, 10, 10});
        byte i9 = 0;
        while (true) {
            byte b21 = 9;
            if (i9 >= 9) {
                break;
            }
            byte i10 = 0;
            while (i10 < b21) {
                byte i11 = 0;
                while (i11 < b21) {
                    byte i12 = 0;
                    while (i12 < b21) {
                        sDasaLordInt[i9][i10][i11][i12] = AstroCalc.hp_Rnd0To8v((double) (aDasaLordInt[i9][i10][i11] + i12));
                        i12 = (byte) (i12 + 1);
                        b21 = 9;
                    }
                    i11 = (byte) (i11 + 1);
                    b21 = 9;
                }
                i10 = (byte) (i10 + 1);
                b21 = 9;
            }
            i9 = (byte) (i9 + 1);
        }
        byte p0 = 0;
        while (p0 < 9) {
            this.mDasL[p0] = mDasaLordInt[p0];
            p0 = (byte) (p0 + 1);
        }
        byte p1 = 0;
        while (true) {
            if (p1 >= 9) {
                break;
            }
            byte p2 = 0;
            for (byte b22 = 9; p2 < b22; b22 = 9) {
                this.bDasL[p1][p2] = bDasaLordInt[p1][p2];
                p2 = (byte) (p2 + 1);
            }
            p1 = (byte) (p1 + 1);
        }
        byte p3 = 0;
        while (true) {
            byte b23 = 9;
            if (p3 >= 9) {
                break;
            }
            byte p4 = 0;
            while (p4 < b23) {
                byte p5 = 0;
                while (p5 < b23) {
                    this.aDasL[p3][p4][p5] = aDasaLordInt[p3][p4][p5];
                    p5 = (byte) (p5 + 1);
                    b23 = 9;
                }
                p4 = (byte) (p4 + 1);
                b23 = 9;
            }
            p3 = (byte) (p3 + 1);
        }
        byte p6 = 0;
        while (true) {
            byte b24 = 9;
            if (p6 >= 9) {
                break;
            }
            byte p7 = 0;
            while (p7 < b24) {
                byte i92 = i9;
                byte p8 = 0;
                while (p8 < b24) {
                    byte p02 = p0;
                    byte p9 = 0;
                    while (p9 < b24) {
                        this.sDasL[p6][p7][p8][p9] = sDasaLordInt[p6][p7][p8][p9];
                        p9 = (byte) (p9 + 1);
                        b24 = 9;
                    }
                    p8 = (byte) (p8 + 1);
                    p0 = p02;
                    b24 = 9;
                }
                p7 = (byte) (p7 + 1);
                i9 = i92;
                p0 = p0;
                b24 = 9;
            }
            byte b25 = p0;
            p6 = (byte) (p6 + 1);
            i9 = i9;
        }
        byte b26 = p0;
        double spndDasa = ((mPos2 - lBor2) / 13.3333333333333d) * dasaYears[nakLordInt] * daysPerYear3;
        double mDasBor = bJulDate2 - spndDasa;
        double d4 = spndDasa;
        double[] mDasaBor = new double[9];
        mDasaBor[0] = mDasBor;
        byte b27 = p1;
        byte j1 = 1;
        for (byte b28 = 9; j1 < b28; b28 = 9) {
            mDasaBor[j1] = mDasaBor[j1 - 1] + (dasaYears[mDasaLordInt[j1 - 1]] * daysPerYear3);
            j1 = (byte) (j1 + 1);
        }
        byte b29 = j1;
        Class<double> cls4 = cls3;
        double[][] bDasaBor = (double[][]) Array.newInstance(cls4, new int[]{9, 9});
        byte b30 = i6;
        byte j2 = 0;
        while (true) {
            byte p32 = p3;
            if (j2 >= 9) {
                break;
            }
            bDasaBor[j2][0] = mDasaBor[j2];
            byte p62 = p6;
            byte j3 = 1;
            for (byte p33 = 9; j3 < p33; p33 = 9) {
                bDasaBor[j2][j3] = bDasaBor[j2][j3 - 1] + (bDasaYears2[mDasaLordInt[j2]][bDasaLordInt[j2][j3 - 1]] * daysPerYear3);
                j3 = (byte) (j3 + 1);
            }
            j2 = (byte) (j2 + 1);
            p3 = p32;
            p6 = p62;
        }
        double[][][] aDasaBor = (double[][][]) Array.newInstance(cls4, new int[]{9, 9, 9});
        byte j4 = 0;
        while (true) {
            byte j22 = j2;
            byte j23 = 9;
            if (j4 >= 9) {
                break;
            }
            double mDasBor2 = mDasBor;
            byte j5 = 0;
            while (j5 < j23) {
                aDasaBor[j4][j5][0] = bDasaBor[j4][j5];
                byte j6 = 1;
                while (j6 < j23) {
                    aDasaBor[j4][j5][j6] = aDasaBor[j4][j5][j6 - 1] + (aDasaYears2[mDasaLordInt[j4]][bDasaLordInt[j4][j5]][aDasaLordInt[j4][j5][j6 - 1]] * daysPerYear3);
                    j6 = (byte) (j6 + 1);
                    j23 = 9;
                }
                j5 = (byte) (j5 + 1);
                j23 = 9;
            }
            j4 = (byte) (j4 + 1);
            j2 = j22;
            mDasBor = mDasBor2;
        }
        double[][][][] sDasaBor = (double[][][][]) Array.newInstance(cls4, new int[]{10, 10, 10, 10});
        byte j7 = 0;
        while (true) {
            byte j10 = 9;
            if (j7 >= 9) {
                break;
            }
            byte j8 = 0;
            while (j8 < j10) {
                byte j42 = j4;
                byte j9 = 0;
                while (j9 < j10) {
                    sDasaBor[j7][j8][j9][0] = aDasaBor[j7][j8][j9];
                    byte j102 = 1;
                    while (true) {
                        lBor = lBor2;
                        if (j102 >= 9) {
                            break;
                        }
                        sDasaBor[j7][j8][j9][j102] = sDasaBor[j7][j8][j9][j102 - 1] + (sDasaYears2[mDasaLordInt[j7]][bDasaLordInt[j7][j8]][aDasaLordInt[j7][j8][j9]][sDasaLordInt[j7][j8][j9][j102 - 1]] * daysPerYear3);
                        j102 = (byte) (j102 + 1);
                        lBor2 = lBor;
                    }
                    j9 = (byte) (j9 + 1);
                    lBor2 = lBor;
                    j10 = 9;
                }
                j8 = (byte) (j8 + 1);
                j4 = j42;
                j10 = 9;
            }
            double d5 = lBor2;
            j7 = (byte) (j7 + 1);
            j4 = j4;
        }
        double d6 = lBor2;
        for (byte m0 = 0; m0 < 9; m0 = (byte) (m0 + 1)) {
            this.mDas[m0] = mDasaBor[m0];
        }
        byte m1 = 0;
        while (true) {
            if (m1 >= 9) {
                break;
            }
            byte m2 = 0;
            for (byte b31 = 9; m2 < b31; b31 = 9) {
                this.bDas[m1][m2] = bDasaBor[m1][m2];
                m2 = (byte) (m2 + 1);
            }
            m1 = (byte) (m1 + 1);
        }
        byte m3 = 0;
        while (true) {
            byte b32 = 9;
            if (m3 >= 9) {
                break;
            }
            byte m4 = 0;
            while (m4 < b32) {
                int[][][][] sDasaLordInt2 = sDasaLordInt;
                byte m5 = 0;
                while (m5 < b32) {
                    this.aDas[m3][m4][m5] = aDasaBor[m3][m4][m5];
                    m5 = (byte) (m5 + 1);
                    b32 = 9;
                }
                m4 = (byte) (m4 + 1);
                sDasaLordInt = sDasaLordInt2;
                b32 = 9;
            }
            m3 = (byte) (m3 + 1);
            sDasaLordInt = sDasaLordInt;
        }
        byte m6 = 0;
        while (true) {
            byte b33 = 9;
            if (m6 < 9) {
                byte m7 = 0;
                while (m7 < b33) {
                    double[][] bDasaBor2 = bDasaBor;
                    byte m8 = 0;
                    while (m8 < b33) {
                        double[] mDasaBor2 = mDasaBor;
                        byte m9 = 0;
                        while (m9 < b33) {
                            this.sDas[m6][m7][m8][m9] = sDasaBor[m6][m7][m8][m9];
                            m9 = (byte) (m9 + 1);
                            b33 = 9;
                        }
                        m8 = (byte) (m8 + 1);
                        mDasaBor = mDasaBor2;
                        b33 = 9;
                    }
                    m7 = (byte) (m7 + 1);
                    bDasaBor = bDasaBor2;
                    mDasaBor = mDasaBor;
                    b33 = 9;
                }
                double[] dArr9 = mDasaBor;
                m6 = (byte) (m6 + 1);
                bDasaBor = bDasaBor;
            } else {
                return;
            }
        }
    }

    public String kp_RevJday(double dblDate) {
        SweDate sd = new SweDate(dblDate);
        sd.getJulDay();
        return String.format("%02d-%02d-%4d", new Object[]{Integer.valueOf(sd.getDay()), Integer.valueOf(sd.getMonth()), Integer.valueOf(sd.getYear())});
    }

    public String kp_RevJdaywithtime(double dblDate) {
        SweDate sd = new SweDate(dblDate);
        sd.getJulDay();
        double h1 = (double) ((int) sd.getHour());
        return String.format("%02d:%02d", new Object[]{Double.valueOf(h1), Integer.valueOf((int) ((sd.getHour() - h1) * 60.0d))});
    }

    private int kp_includehouse02(double planetPos) {
        int kp_IncludedHouse = 0;
        for (int i = 0; i < 11; i++) {
            double[] dArr = this.hCuspI;
            if (dArr[i] < dArr[i + 1] && dArr[i] <= planetPos && planetPos < dArr[i + 1]) {
                kp_IncludedHouse = i;
            }
        }
        double[] dArr2 = this.hCuspI;
        if (dArr2[11] < dArr2[0] && dArr2[11] <= planetPos && planetPos < dArr2[0]) {
            kp_IncludedHouse = 11;
        }
        for (int j = 0; j < 11; j++) {
            double[] dArr3 = this.hCuspI;
            if (dArr3[j] > dArr3[j + 1] && ((dArr3[j] <= planetPos && planetPos < 360.0d) || (0.0d <= planetPos && planetPos < dArr3[j + 1]))) {
                kp_IncludedHouse = j;
            }
        }
        double[] dArr4 = this.hCuspI;
        if (dArr4[11] <= dArr4[0]) {
            return kp_IncludedHouse;
        }
        if ((dArr4[11] > planetPos || planetPos >= 360.0d) && (0.0d > planetPos || planetPos >= dArr4[0])) {
            return kp_IncludedHouse;
        }
        return 11;
    }

    private int kp_includehouse04(double planetPos, double[] cuspJ) {
        int kp_IncludedHouse = 0;
        int i = 0;
        while (true) {
            if (i < 11) {
                if (cuspJ[i] < cuspJ[i + 1] && cuspJ[i] <= planetPos && planetPos < cuspJ[i + 1]) {
                    kp_IncludedHouse = i;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (cuspJ[11] < cuspJ[0] && cuspJ[11] <= planetPos && planetPos < cuspJ[0]) {
            kp_IncludedHouse = 11;
        }
        int j = 0;
        while (true) {
            if (j < 11) {
                if (cuspJ[j] > cuspJ[j + 1] && cuspJ[j] <= planetPos && ((planetPos < 360.0d || 0.0d <= planetPos) && planetPos < cuspJ[j + 1])) {
                    kp_IncludedHouse = j;
                    break;
                }
                j++;
            } else {
                break;
            }
        }
        if (cuspJ[11] <= cuspJ[0] || cuspJ[11] > planetPos) {
            return kp_IncludedHouse;
        }
        if ((planetPos < 360.0d || 0.0d <= planetPos) && planetPos < cuspJ[0]) {
            return 11;
        }
        return kp_IncludedHouse;
    }

    private final double[] kp_Horar(double jDay, double firstCusNir, double curLat, double kpAyanHor) {
        double[] alltCus;
        double sayanaCusp;
        SwissEph sw;
        int a6;
        double[] ascMC__;
        double[] cusVal_;
        double[] ascMC_;
        SwissEph sw2 = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "ephe");
        SweDate sd = new SweDate(this.year, this.month, this.day, this.hour);
        double[] nutPDetails = new double[6];
        StringBuffer nutErrReturn = new StringBuffer();
        long nutPReVal = (long) sw2.swe_calc_ut(jDay, -1, 0, nutPDetails, nutErrReturn);
        double sayanaCusp2 = AstroCalc.hp_Rnd0To360v(firstCusNir + kpAyanHor) + 1.0E-9d;
        if (sayanaCusp2 < 1.0E-9d) {
            sayanaCusp2 += 1.0E-9d;
        }
        double[] ascmc = new double[11];
        double[] cusVal = new double[13];
        double[] allfCus = new double[361];
        int a1 = 0;
        while (a1 <= 359) {
            double[] cusVal2 = cusVal;
            double[] allfCus2 = allfCus;
            int a12 = a1;
            double[] cusVal3 = cusVal2;
            double[] ascmc2 = ascmc;
            long swe_houses_armc = (long) sw2.swe_houses_armc((double) a1, curLat, nutPDetails[0], 112, cusVal2, ascmc2);
            allfCus2[a12] = cusVal3[1];
            a1 = a12 + 1;
            allfCus = allfCus2;
            cusVal = cusVal3;
            ascmc = ascmc2;
        }
        double[] allfCus3 = allfCus;
        int i = a1;
        double[] dArr = cusVal;
        double[] dArr2 = ascmc;
        allfCus3[360] = allfCus3[0];
        int lBnd = 269;
        int a2 = 0;
        while (a2 <= 269) {
            if (allfCus3[a2] <= sayanaCusp2 && allfCus3[a2 + 1] > sayanaCusp2) {
                lBnd = a2;
            }
            a2++;
        }
        for (int a3 = 270; a3 <= 359; a3++) {
            if (allfCus3[a3] <= sayanaCusp2 && allfCus3[a3 + 1] > sayanaCusp2) {
                lBnd = a3;
            }
        }
        double lBnd2 = 0.0d;
        double finalARMC = 0.0d;
        double[] allsCus = new double[(PointerIconCompat.TYPE_CONTEXT_MENU + 1)];
        double[] alltCus2 = new double[(PointerIconCompat.TYPE_CONTEXT_MENU + 1)];
        if (lBnd != 269) {
            long j = nutPReVal;
            double[] ascMC_2 = new double[11];
            double[] cusVal_2 = new double[13];
            int a4 = 0;
            while (a4 <= 1001) {
                int a22 = a2;
                long swe_houses_armc2 = (long) sw2.swe_houses_armc(((double) lBnd) + ((((double) a4) / 1000.0d) * 1.0d), curLat, nutPDetails[0], 80, cusVal_2, ascMC_2);
                allsCus[a4] = cusVal_2[1];
                a4++;
                sd = sd;
                nutErrReturn = nutErrReturn;
                a2 = a22;
                alltCus2 = alltCus2;
            }
            SweDate sweDate = sd;
            int i2 = a2;
            alltCus = alltCus2;
            int a5 = 0;
            while (a5 <= 999) {
                if (allsCus[a5] > sayanaCusp2 || allsCus[a5 + 1] <= sayanaCusp2) {
                    ascMC_ = ascMC_2;
                    cusVal_ = cusVal_2;
                } else {
                    ascMC_ = ascMC_2;
                    cusVal_ = cusVal_2;
                    lBnd2 = ((double) lBnd) + ((((double) a5) / 1000.0d) * 1.0d);
                }
                a5++;
                ascMC_2 = ascMC_;
                cusVal_2 = cusVal_;
            }
            double[] ascMC_3 = ascMC_2;
            double[] dArr3 = cusVal_2;
            double[] ascMC__2 = new double[11];
            double[] cusVal__ = new double[13];
            int a62 = 0;
            while (a62 <= 1001) {
                int a52 = a5;
                long swe_houses_armc3 = (long) sw2.swe_houses_armc(lBnd2 + ((((double) a62) / 1000.0d) * 0.001d), curLat, nutPDetails[0], 80, cusVal__, ascMC__2);
                alltCus[a62] = cusVal__[1];
                a62++;
                ascMC_3 = ascMC_3;
                a5 = a52;
            }
            double[] dArr4 = ascMC_3;
            int a7 = 0;
            while (a7 <= PointerIconCompat.TYPE_CONTEXT_MENU - 1) {
                if (alltCus[a7] > sayanaCusp2 || alltCus[a7 + 1] <= sayanaCusp2) {
                    a6 = a62;
                    ascMC__ = ascMC__2;
                } else {
                    a6 = a62;
                    ascMC__ = ascMC__2;
                    finalARMC = lBnd2 + (((((double) a7) + 1.0d) * 0.001d) / 1000.0d);
                }
                a7++;
                ascMC__2 = ascMC__;
                a62 = a6;
            }
            double[] dArr5 = ascMC__2;
        } else {
            StringBuffer stringBuffer = nutErrReturn;
            SweDate sweDate2 = sd;
            int i3 = a2;
            alltCus = alltCus2;
        }
        if (lBnd == 269) {
            double[] ascMC2_ = new double[10];
            double[] cusVal2_ = new double[12];
            int a8 = 0;
            while (a8 <= 1001) {
                double[] ascMC2_2 = ascMC2_;
                long swe_houses_armc4 = (long) sw2.swe_houses_armc(((double) lBnd) + ((((double) a8) / 1000.0d) * 1.0d), curLat, nutPDetails[0], 80, cusVal2_, ascMC2_2);
                allsCus[a8] = cusVal2_[1];
                a8++;
                ascMC2_ = ascMC2_2;
            }
            int a9 = 0;
            while (a9 <= PointerIconCompat.TYPE_CONTEXT_MENU - 1) {
                if (allsCus[a9] > sayanaCusp2 || allsCus[a9 + 1] <= sayanaCusp2) {
                    sw = sw2;
                } else {
                    sw = sw2;
                    lBnd2 = ((double) lBnd) + ((((double) a9) / 1000.0d) * 1.0d);
                }
                a9++;
                sw2 = sw;
            }
            SwissEph sw3 = sw2;
            double[] ascMC2__ = new double[10];
            double[] cusVal2__ = new double[12];
            int b1 = 0;
            while (b1 <= 1001) {
                int a92 = a9;
                SwissEph sw4 = sw3;
                long swe_houses_armc5 = (long) sw4.swe_houses_armc(lBnd2 + ((((double) b1) / 1000.0d) * 0.001d), curLat, nutPDetails[0], 80, cusVal2__, ascMC2__);
                alltCus[b1] = cusVal2__[1];
                b1++;
                sw3 = sw4;
                a9 = a92;
            }
            sw2 = sw3;
            int b2 = 0;
            while (b2 <= PointerIconCompat.TYPE_CONTEXT_MENU - 1) {
                if (alltCus[b2] > sayanaCusp2 || alltCus[b2 + 1] <= sayanaCusp2) {
                    sayanaCusp = sayanaCusp2;
                } else {
                    sayanaCusp = sayanaCusp2;
                    finalARMC = lBnd2 + ((((double) (b2 + 1)) / 1000.0d) * 0.001d);
                }
                b2++;
                sayanaCusp2 = sayanaCusp;
            }
        }
        double[] cusValf = new double[13];
        long swe_houses_armc6 = (long) sw2.swe_houses_armc(finalARMC, curLat, nutPDetails[0], 80, cusValf, new double[11]);
        double[] saCusps = new double[13];
        saCusps[0] = 0.0d;
        for (int b3 = 1; b3 <= 12; b3++) {
            saCusps[b3] = cusValf[b3];
        }
        return saCusps;
    }
}
