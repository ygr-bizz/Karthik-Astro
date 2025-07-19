package com.cuspal.interlinks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

public class PlotView_nava extends View {
    int Size;
    Rect centerRectLower = new Rect(1, 1, 1, 1);
    Rect centerRectUpper = new Rect(1, 1, 1, 1);
    int hardwareType = 2;
    int mHeight = 400;
    int mWidth = 400;
    int oX = 0;
    int oY = 0;
    Paint paint = new Paint();
    Rect[] signRects = new Rect[12];

    public PlotView_nava(Context context) {
        super(context);
        this.paint.setColor(SupportMenu.CATEGORY_MASK);
        int checkIsTablet = device_util.checkIsTablet(context);
        this.hardwareType = checkIsTablet;
        this.Size = (int) set_font_size((double) checkIsTablet);
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
    }

    private void DrawSouthIndianChart(Canvas canvas, Paint paint2) {
        int i;
        Canvas canvas2 = canvas;
        Paint paint3 = paint2;
        int lagnaSign = AstroCalc.GetLagnaSign(AstroCalc.hp_Rnd0To360v(Main_details_tab.cusps[0] - Main_details_tab.newKPAyan));
        int textSize = this.Size;
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        paint3.setColor(-16776961);
        this.oX = this.signRects[0].left + 30;
        int i2 = 10;
        this.oY = this.signRects[10].top + 150;
        paint3.setTextSize(50.0f);
        paint3.setStyle(Paint.Style.FILL);
        canvas2.drawText("NAVA CHART", (float) this.oX, (float) this.oY, paint3);
        String[] kp_DasaShesha = AstroCalc.kp_DasaShesha(Main_details_tab.pPos[1]);
        if (this.hardwareType < 2) {
            textSize = this.Size;
        }
        paint3.setColor(Color.rgb(255, 255, 125));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(SupportMenu.CATEGORY_MASK);
        ArrayList<ArrayList<Integer>> signObjsD9 = new ArrayList<>();
        int D9LagnaSign = Main_details_tab.GetD9LagnaSign();
        int i3 = 0;
        while (true) {
            if (i3 >= 12) {
                break;
            }
            signObjsD9.add(Main_details_tab.GetD9ObjectsInSign(i3));
            i3++;
        }
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        paint3.setTextSize((float) textSize);
        for (int i4 = 0; i4 < 12; i4++) {
            ArrayList<Integer> temp = signObjsD9.get(i4);
            if (temp.size() % 2 == 1) {
                temp.add(9);
            }
        }
        paint3.setTextSize((float) this.Size);
        int i5 = 0;
        for (i = 12; i5 < i; i = 12) {
            paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
            ArrayList<Integer> temp2 = signObjsD9.get(i5);
            if (temp2.size() > 0) {
                int oX2 = this.signRects[i5].left + i2;
                int oY2 = this.signRects[i5].top + 30 + 40;
                int j = 0;
                while (j < temp2.size()) {
                    int lagnaSign2 = lagnaSign;
                    String tStr = String.format("%2s", new Object[]{Main_details_tab.sGraha[Math.abs(temp2.get(j).intValue())]});
                    if (temp2.get(j).intValue() < 0) {
                        tStr = tStr + "'";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(tStr);
                    String str = tStr;
                    int textSize2 = textSize;
                    sb.append(String.format(" %2s", new Object[]{Main_details_tab.sGraha[Math.abs(temp2.get(j + 1).intValue())]}));
                    String tStr2 = sb.toString();
                    if (temp2.get(j + 1).intValue() < 0) {
                        tStr2 = tStr2 + "'";
                    }
                    canvas2.drawText(tStr2, (float) oX2, (float) oY2, paint3);
                    oY2 += 40;
                    j += 2;
                    textSize = textSize2;
                    lagnaSign = lagnaSign2;
                }
            }
            i5++;
            textSize = textSize;
            lagnaSign = lagnaSign;
            i2 = 10;
        }
        int i6 = textSize;
        for (int i7 = 0; i7 < 12; i7++) {
            paint3.setColor(-16776961);
            int oX3 = this.signRects[i7].left + 10;
            int oY3 = this.signRects[i7].top + 0 + 40;
            if (D9LagnaSign == i7) {
                canvas2.drawText("Asc", (float) oX3, (float) oY3, paint3);
            }
            int oY4 = oY3 + 40;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels - 40;
        setMeasuredDimension(width, width - 200);
    }

    public float set_font_size(double device) {
        if (device > 2.0d) {
            return 60.0f;
        }
        return 30.0f;
    }
}
