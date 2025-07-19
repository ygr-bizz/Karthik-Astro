package com.cuspal.interlinks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

public class PlotView extends View {
    Rect centerRectLower = new Rect(1, 1, 1, 1);
    Rect centerRectUpper = new Rect(1, 1, 1, 1);
    int hardwareType = 2;
    int mHeight = 400;
    int mWidth = 400;
    int oX = 0;
    int oY = 0;
    Paint paint = new Paint();
    String[] selArr = new String[13];
    String[] selArrtmp = new String[13];
    Rect[] signRects = new Rect[12];
    int textSize;

    public PlotView(Context context) {
        super(context);
        this.paint.setColor(SupportMenu.CATEGORY_MASK);
        this.hardwareType = device_util.checkIsTablet(context);
        int checkIsTablet = device_util.checkIsTablet(context);
        this.hardwareType = checkIsTablet;
        this.textSize = (int) set_font_size((double) checkIsTablet);
    }

    public void onDraw(Canvas canvas) {
        this.oX = 0;
        this.oY = 0;
        this.mWidth = canvas.getWidth();
        this.mHeight = canvas.getHeight();
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
        canvas.drawPaint(paint2);
        DrawChartLines(canvas, paint2);
        DrawSouthIndianChart(canvas, paint2);
    }

    private void DrawChartLines(Canvas canvas, Paint paint2) {
        Paint paint3 = paint2;
        paint3.setAntiAlias(false);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(6.0f);
        paint3.setColor(-7829368);
        int iSign = 0;
        int bWid = this.mWidth / 4;
        int bHgt = this.mHeight / 4;
        int sX = this.oX;
        int sY = this.oY;
        Rect[] tRects = new Rect[20];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Rect r = new Rect();
                r.left = sX;
                r.top = sY;
                r.right = sX + bWid;
                r.bottom = sY + bHgt;
                tRects[iSign] = r;
                sX += bWid;
                iSign++;
            }
            sX = this.oX;
            sY += bHgt;
        }
        int[] iSigns = {1, 2, 3, 7, 11, 15, 14, 13, 12, 8, 4, 0};
        for (int i2 = 0; i2 < 12; i2++) {
            Rect[] rectArr = this.signRects;
            rectArr[i2] = tRects[iSigns[i2]];
            canvas.drawRect(rectArr[i2], paint3);
        }
        Canvas canvas2 = canvas;
        this.centerRectUpper.left = this.signRects[0].left;
        this.centerRectUpper.right = this.signRects[1].right;
        this.centerRectUpper.top = this.signRects[10].top;
        this.centerRectUpper.bottom = this.signRects[10].top + ((this.signRects[6].top - this.signRects[10].top) / 2);
        this.centerRectLower.left = this.signRects[0].left;
        this.centerRectLower.right = this.signRects[1].right;
        this.centerRectLower.top = this.signRects[10].top + ((this.signRects[6].top - this.signRects[10].top) / 2);
        this.centerRectLower.bottom = this.signRects[6].top;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.atrijyotish);
    }

    private void DrawSouthIndianChart(Canvas canvas, Paint paint2) {
        Paint paint3 = paint2;
        paint3.setColor(SupportMenu.CATEGORY_MASK);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.oX = this.signRects[0].left + 30;
        this.oY = this.signRects[10].top + 150;
        paint3.setTextSize(50.0f);
        paint3.setStyle(Paint.Style.FILL);
        canvas.drawText("RASI CHART", (float) this.oX, (float) this.oY, paint3);
        String[] kp_DasaShesha = AstroCalc.kp_DasaShesha(Main_details_tab.pPos[1]);
        paint3.setColor(Color.rgb(255, 255, 125));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(SupportMenu.CATEGORY_MASK);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 12; i++) {
            ArrayList<Integer> temp = Main_details_tab.GetObjectsInSign(i);
            arrayList2.add(Main_details_tab.GetObjectsInSign_rasi(i));
            arrayList.add(temp);
        }
        paint3.setTextSize((float) this.textSize);
        for (int i2 = 0; i2 < 12; i2++) {
            ArrayList<Integer> temp2 = (ArrayList) arrayList.get(i2);
            if (temp2.size() % 2 == 1) {
                temp2.add(9);
            }
        }
        paint3.setTextSize((float) this.textSize);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        DrawBhavaChart();
        for (int i3 = 0; i3 < 12; i3++) {
            paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
            String temp1 = this.selArrtmp[i3];
            int oX2 = this.signRects[i3].left;
            int oY2 = this.signRects[i3].top + 0;
            int i4 = oX2;
            drawTextMultiLineSpace(temp1, oX2, oY2, paint2, canvas);
            int oY3 = oY2 + 40;
        }
    }

    public void drawTextMultiLineSpace(String text, int x, int y, Paint paint2, Canvas canvas) {
        int lineY = y;
        String[] tokens = text.split(",");
        for (int i = 0; i <= tokens.length - 1; i += 2) {
            if (i >= tokens.length - 1) {
                lineY = (int) (((float) lineY) + (paint2.descent() - paint2.ascent()));
                canvas.drawText(tokens[i], (float) x, (float) lineY, paint2);
            } else {
                lineY = (int) (((float) lineY) + (paint2.descent() - paint2.ascent()));
                canvas.drawText(tokens[i] + " " + tokens[i + 1], (float) x, (float) lineY, paint2);
            }
        }
    }

    public void drawTextMultiLineNewLine(String text, int x, int y, Paint paint2, Canvas canvas) {
        int lineY = y;
        for (String line : text.split("\n")) {
            lineY = (int) (((float) lineY) + (paint2.descent() - paint2.ascent()));
            canvas.drawText(line, (float) x, (float) lineY, paint2);
        }
    }

    public void DrawBhavaChart() {
        double[] allPos = new double[21];
        double[] allPos2 = new double[21];
        for (int i = 0; i <= 11; i++) {
            allPos[i] = AstroCalc.hp_Rnd0To360v(Main_details_tab.cusps[i] - Main_details_tab.newKPAyan);
            allPos2[i] = AstroCalc.hp_Rnd0To360v(Main_details_tab.cusps[i] - Main_details_tab.newKPAyan);
        }
        for (int j = 0; j < 9; j++) {
            allPos[j + 12] = Main_details_tab.pPos[j];
            allPos2[j + 12] = Main_details_tab.pPos[j];
        }
        byte b = 20;
        AstroCalc.posSort(allPos, 0, 20);
        int[] idAr = new int[21];
        for (int j1 = 0; j1 <= 20; j1++) {
            for (int j2 = 0; j2 <= 20; j2++) {
                if (Math.abs(allPos[j1] - allPos2[j2]) < 1.0E-30d) {
                    idAr[j1] = j2;
                }
            }
        }
        String[] prPos = new String[23];
        for (byte j3 = 0; j3 <= 20; j3 = (byte) (j3 + 1)) {
            prPos[j3] = kp_ChartPrint(allPos[j3], idAr[j3]);
        }
        double[] mVal = new double[14];
        for (byte j4 = 0; j4 <= 12; j4 = (byte) (j4 + 1)) {
            mVal[j4] = (Double.valueOf((double) j4).doubleValue() / 12.0d) * 360.0d;
        }
        for (int i2 = 0; i2 <= 12; i2++) {
            this.selArr[i2] = "";
        }
        byte n1 = 0;
        while (n1 <= 11) {
            byte n2 = 0;
            while (n2 <= b) {
                if (mVal[n1] <= allPos[n2] && allPos[n2] < mVal[n1 + 1]) {
                    String[] strArr = this.selArr;
                    strArr[n1] = this.selArr[n1] + prPos[n2] + ",";
                }
                n2 = (byte) (n2 + 1);
                b = 20;
            }
            n1 = (byte) (n1 + 1);
            b = 20;
        }
        String[] arrS0 = this.selArr[0].split(",");
        String[] arrS1 = this.selArr[1].split(",");
        String[] arrS2 = this.selArr[2].split(",");
        String[] arrS3 = this.selArr[3].split(",");
        String[] arrS4 = this.selArr[4].split(",");
        String[] arrS5 = this.selArr[5].split(",");
        String[] arrS6 = this.selArr[6].split(",");
        int[] iArr = idAr;
        String[] arrS7 = this.selArr[7].split(",");
        double[] dArr = allPos;
        String[] arrS8 = this.selArr[8].split(",");
        double[] dArr2 = allPos2;
        String[] arrS9 = this.selArr[9].split(",");
        String[] strArr2 = prPos;
        String[] arrS10 = this.selArr[10].split(",");
        double[] dArr3 = mVal;
        String[] arrS11 = this.selArr[11].split(",");
        this.selArrtmp[0] = StringConvertNormal(arrS0);
        this.selArrtmp[1] = StringConvertNormal(arrS1);
        this.selArrtmp[2] = StringConvertNormal(arrS2);
        this.selArrtmp[3] = StringConvertNormal(arrS3);
        this.selArrtmp[4] = StringConvertNormal(arrS4);
        this.selArrtmp[5] = StringConvertNormal(arrS5);
        this.selArrtmp[6] = StringConvertReverse(arrS6);
        this.selArrtmp[7] = StringConvertReverse(arrS7);
        this.selArrtmp[8] = StringConvertReverse(arrS8);
        this.selArrtmp[9] = StringConvertReverse(arrS9);
        this.selArrtmp[10] = StringConvertReverse(arrS10);
        this.selArrtmp[11] = StringConvertReverse(arrS11);
    }

    public String StringConvertReverse(String[] word) {
        String str = "";
        for (int i = word.length - 1; i >= 0; i--) {
            str = str + word[i] + ",";
        }
        return str;
    }

    public String StringConvertNormal(String[] word) {
        String str = "";
        for (int i = 0; i <= word.length - 1; i++) {
            str = str + word[i] + ",";
        }
        return str;
    }

    public String kp_ChartPrint(double posVal, int idInt) {
        String[] arToRom = {"I ", "II ", "III ", "IV ", "V ", "VI ", "VII ", "VIII ", "IX ", "X ", "XI ", "XII "};
        if (idInt > 11) {
            return "" + AstroCalc.kp_PlanetName(idInt - 12, 0.0d) + " ";
        } else if (idInt == 0) {
            return "#ASC#";
        } else {
            return " " + arToRom[idInt];
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        int i = metrics.heightPixels;
        int width = metrics.widthPixels - 40;
        setMeasuredDimension(width, width - 200);
    }

    public float set_font_size(double device) {
        if (device > 2.0d) {
            return 60.0f;
        }
        return 30.0f;
    }

    public void SetFrameSize(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
    }
}
