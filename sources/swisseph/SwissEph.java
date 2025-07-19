package swisseph;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class SwissEph implements Serializable {
    static final MeffEle[] eff_arr = {new MeffEle(1.0d, 1.0d), new MeffEle(0.99d, 0.999979d), new MeffEle(0.98d, 0.99994d), new MeffEle(0.97d, 0.999881d), new MeffEle(0.96d, 0.999811d), new MeffEle(0.95d, 0.999724d), new MeffEle(0.94d, 0.999622d), new MeffEle(0.93d, 0.999497d), new MeffEle(0.92d, 0.999354d), new MeffEle(0.91d, 0.999192d), new MeffEle(0.9d, 0.999d), new MeffEle(0.89d, 0.998786d), new MeffEle(0.88d, 0.998535d), new MeffEle(0.87d, 0.998242d), new MeffEle(0.86d, 0.997919d), new MeffEle(0.85d, 0.997571d), new MeffEle(0.84d, 0.997198d), new MeffEle(0.83d, 0.996792d), new MeffEle(0.82d, 0.996316d), new MeffEle(0.81d, 0.995791d), new MeffEle(0.8d, 0.995226d), new MeffEle(0.79d, 0.994625d), new MeffEle(0.78d, 0.993991d), new MeffEle(0.77d, 0.993326d), new MeffEle(0.76d, 0.992598d), new MeffEle(0.75d, 0.99177d), new MeffEle(0.74d, 0.990873d), new MeffEle(0.73d, 0.989919d), new MeffEle(0.72d, 0.988912d), new MeffEle(0.71d, 0.987856d), new MeffEle(0.7d, 0.986755d), new MeffEle(0.69d, 0.98561d), new MeffEle(0.68d, 0.984398d), new MeffEle(0.67d, 0.982986d), new MeffEle(0.66d, 0.981437d), new MeffEle(0.65d, 0.979779d), new MeffEle(0.64d, 0.978024d), new MeffEle(0.63d, 0.976182d), new MeffEle(0.62d, 0.974256d), new MeffEle(0.61d, 0.972253d), new MeffEle(0.6d, 0.970174d), new MeffEle(0.59d, 0.968024d), new MeffEle(0.58d, 0.965594d), new MeffEle(0.57d, 0.962797d), new MeffEle(0.56d, 0.959758d), new MeffEle(0.55d, 0.956515d), new MeffEle(0.54d, 0.953088d), new MeffEle(0.53d, 0.949495d), new MeffEle(0.52d, 0.945741d), new MeffEle(0.51d, 0.941838d), new MeffEle(0.5d, 0.93779d), new MeffEle(0.49d, 0.933563d), new MeffEle(0.48d, 0.928668d), new MeffEle(0.47d, 0.923288d), new MeffEle(0.46d, 0.917527d), new MeffEle(0.45d, 0.911432d), new MeffEle(0.44d, 0.905035d), new MeffEle(0.43d, 0.898353d), new MeffEle(0.42d, 0.891022d), new MeffEle(0.41d, 0.88294d), new MeffEle(0.4d, 0.874312d), new MeffEle(0.39d, 0.865206d), new MeffEle(0.38d, 0.855423d), new MeffEle(0.37d, 0.844619d), new MeffEle(0.36d, 0.833074d), new MeffEle(0.35d, 0.820876d), new MeffEle(0.34d, 0.808031d), new MeffEle(0.33d, 0.793962d), new MeffEle(0.32d, 0.778931d), new MeffEle(0.31d, 0.763021d), new MeffEle(0.3d, 0.745815d), new MeffEle(0.29d, 0.727557d), new MeffEle(0.28d, 0.708234d), new MeffEle(0.27d, 0.687583d), new MeffEle(0.26d, 0.665741d), new MeffEle(0.25d, 0.642597d), new MeffEle(0.24d, 0.618252d), new MeffEle(0.23d, 0.592586d), new MeffEle(0.22d, 0.565747d), new MeffEle(0.21d, 0.537697d), new MeffEle(0.2d, 0.508554d), new MeffEle(0.19d, 0.47842d), new MeffEle(0.18d, 0.447322d), new MeffEle(0.17d, 0.415454d), new MeffEle(0.16d, 0.382892d), new MeffEle(0.15d, 0.349955d), new MeffEle(0.14d, 0.316691d), new MeffEle(0.13d, 0.283565d), new MeffEle(0.12d, 0.250431d), new MeffEle(0.11d, 0.218327d), new MeffEle(0.1d, 0.186794d), new MeffEle(0.09d, 0.156287d), new MeffEle(0.08d, 0.128421d), new MeffEle(0.07d, 0.102237d), new MeffEle(0.06d, 0.077393d), new MeffEle(0.05d, 0.054833d), new MeffEle(0.04d, 0.036361d), new MeffEle(0.03d, 0.020953d), new MeffEle(0.02d, 0.009645d), new MeffEle(0.01d, 0.002767d), new MeffEle(0.0d, 0.0d)};
    int chck_nut_nutflag;
    Extensions ext;
    private int httpBufSize;
    int lastHSys;
    double lastLat;
    double lastLong;
    Swecl sc;
    SweHouse sh;
    SwissLib sl;
    String slast_stardata;
    String slast_starname;
    Swemmoon sm;
    SwephMosh smosh;
    private int swe_calc_epheflag_sv;
    SwissData swed;

    public SwissEph() {
        this((String) null);
    }

    public SwissEph(String str) {
        this.sc = null;
        this.sh = null;
        this.ext = null;
        this.lastLat = 0.0d;
        this.lastLong = 0.0d;
        this.lastHSys = -1;
        this.httpBufSize = 300;
        this.swe_calc_epheflag_sv = 0;
        this.chck_nut_nutflag = 0;
        if (this.swed == null) {
            this.swed = new SwissData();
        }
        this.sl = new SwissLib(this.swed);
        this.sm = new Swemmoon(this.swed, this.sl);
        this.smosh = new SwephMosh(this.sl, this, this.swed);
        this.swed.ephe_path_is_set = false;
        this.swed.fixfp = null;
        this.swed.ephepath = SweConst.SE_EPHE_PATH;
        this.swed.geopos_is_set = false;
        this.swed.ayana_is_set = false;
        swe_set_ephe_path(str);
    }

    public void setHttpBufSize(int i) {
        this.httpBufSize = i;
        if (i < 100) {
            this.httpBufSize = 100;
        }
        swe_close();
    }

    public String swe_version() {
        return "2.00.00";
    }

    public String swe_java_version() {
        return "2.00.00_01";
    }

    public int swe_calc_ut(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        return swe_calc(d + SweDate.getDeltaT(d), i, i2, dArr, stringBuffer);
    }

    public int swe_calc(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        try {
            return _calc(d, i, i2, dArr, stringBuffer);
        } catch (SwissephException e) {
            if (stringBuffer != null) {
                stringBuffer.setLength(0);
                stringBuffer.append(e.getMessage());
            }
            return -1;
        }
    }

    public int calc(double d, int i, int i2, double[] dArr) throws SwissephException {
        return _calc(d, i, i2, dArr, new StringBuffer());
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ad A[LOOP:6: B:115:0x01ab->B:116:0x01ad, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0153 A[LOOP:0: B:89:0x0151->B:90:0x0153, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0160 A[LOOP:1: B:91:0x015d->B:93:0x0160, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int _calc(double r23, int r25, int r26, double[] r27, java.lang.StringBuffer r28) throws swisseph.SwissephException {
        /*
            r22 = this;
            r8 = r22
            r9 = r23
            r0 = r26
            r11 = r27
            r12 = 6
            double[] r13 = new double[r12]
            r1 = 24
            double[] r14 = new double[r1]
            double[] r15 = new double[r1]
            r1 = 144340(0x233d4, float:2.02263E-40)
            r2 = r25
            if (r2 != r1) goto L_0x001d
            r1 = 9
            r7 = 9
            goto L_0x001e
        L_0x001d:
            r7 = r2
        L_0x001e:
            r16 = r0 & 7
            r1 = r16 & 2
            r17 = 0
            if (r1 == 0) goto L_0x0028
            r1 = 0
            goto L_0x002a
        L_0x0028:
            r1 = r16
        L_0x002a:
            int r2 = r8.swe_calc_epheflag_sv
            r6 = -1
            if (r2 == r1) goto L_0x0036
            if (r7 == r6) goto L_0x0036
            r22.swe_close()
            r8.swe_calc_epheflag_sv = r1
        L_0x0036:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0040
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0040
            r0 = r0 & -129(0xffffffffffffff7f, float:NaN)
        L_0x0040:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x004a
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x004a
            r0 = r0 & -8193(0xffffffffffffdfff, float:NaN)
        L_0x004a:
            r1 = 23
            if (r7 >= r1) goto L_0x0058
            if (r7 < 0) goto L_0x0058
            swisseph.SwissData r1 = r8.swed
            swisseph.SavePositions[] r1 = r1.savedat
            r1 = r1[r7]
            r5 = r1
            goto L_0x005f
        L_0x0058:
            swisseph.SwissData r2 = r8.swed
            swisseph.SavePositions[] r2 = r2.savedat
            r1 = r2[r1]
            r5 = r1
        L_0x005f:
            double r1 = r5.tsave     // Catch:{ SwissephException -> 0x01c0 }
            r18 = 0
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x007e
            int r1 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r1 == 0) goto L_0x007e
            int r1 = r5.ipl     // Catch:{ SwissephException -> 0x01c0 }
            if (r7 != r1) goto L_0x007e
            int r1 = r5.iflgsave     // Catch:{ SwissephException -> 0x01c0 }
            r1 = r1 & -14337(0xffffffffffffc7ff, float:NaN)
            r2 = r0 & -14337(0xffffffffffffc7ff, float:NaN)
            if (r1 == r2) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            r12 = r5
            r26 = r7
            goto L_0x0134
        L_0x007e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00aa
            r5.tsave = r9     // Catch:{ SwissephException -> 0x01c0 }
            r5.ipl = r7     // Catch:{ SwissephException -> 0x01c0 }
            double[] r14 = r5.xsaves     // Catch:{ SwissephException -> 0x01c0 }
            r1 = r22
            r2 = r23
            r4 = r7
            r9 = r5
            r5 = r0
            r10 = -1
            r6 = r14
            r14 = r7
            r7 = r28
            int r1 = r1.swecalc(r2, r4, r5, r6, r7)     // Catch:{ SwissephException -> 0x00a6 }
            r9.iflgsave = r1     // Catch:{ SwissephException -> 0x00a6 }
            if (r1 != r10) goto L_0x00a1
            int r0 = r8.swe_calc_error(r11)     // Catch:{ SwissephException -> 0x00a6 }
            return r0
        L_0x00a1:
            r12 = r9
            r26 = r14
            goto L_0x0134
        L_0x00a6:
            r0 = move-exception
            r12 = r9
            goto L_0x01c2
        L_0x00aa:
            r6 = r5
            r5 = -1
            r6.tsave = r9     // Catch:{ SwissephException -> 0x01bd }
            r6.ipl = r7     // Catch:{ SwissephException -> 0x01bd }
            r1 = 1
            if (r7 == r1) goto L_0x00cb
            r1 = 11
            if (r7 == r1) goto L_0x00c3
            r1 = 13
            if (r7 == r1) goto L_0x00c3
            r1 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            r20 = r1
            goto L_0x00d2
        L_0x00c3:
            r1 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            r20 = r1
            goto L_0x00d2
        L_0x00cb:
            r1 = 4542503522391573293(0x3f0a36e2eb1c432d, double:5.0E-5)
            r20 = r1
        L_0x00d2:
            double r2 = r9 - r20
            r1 = r22
            r4 = r7
            r12 = -1
            r5 = r0
            r12 = r6
            r6 = r14
            r26 = r7
            r7 = r28
            int r1 = r1.swecalc(r2, r4, r5, r6, r7)     // Catch:{ SwissephException -> 0x01bb }
            r12.iflgsave = r1     // Catch:{ SwissephException -> 0x01bb }
            int r1 = r12.iflgsave     // Catch:{ SwissephException -> 0x01bb }
            r2 = -1
            if (r1 != r2) goto L_0x00ef
            int r0 = r8.swe_calc_error(r11)     // Catch:{ SwissephException -> 0x01bb }
            return r0
        L_0x00ef:
            double r2 = r9 + r20
            r1 = r22
            r4 = r26
            r5 = r0
            r6 = r15
            r7 = r28
            int r1 = r1.swecalc(r2, r4, r5, r6, r7)     // Catch:{ SwissephException -> 0x01bb }
            r12.iflgsave = r1     // Catch:{ SwissephException -> 0x01bb }
            int r1 = r12.iflgsave     // Catch:{ SwissephException -> 0x01bb }
            r2 = -1
            if (r1 != r2) goto L_0x0109
            int r0 = r8.swe_calc_error(r11)     // Catch:{ SwissephException -> 0x01bb }
            return r0
        L_0x0109:
            double[] r6 = r12.xsaves     // Catch:{ SwissephException -> 0x01bb }
            r1 = r22
            r2 = r23
            r4 = r26
            r5 = r0
            r7 = r28
            int r1 = r1.swecalc(r2, r4, r5, r6, r7)     // Catch:{ SwissephException -> 0x01bb }
            r12.iflgsave = r1     // Catch:{ SwissephException -> 0x01bb }
            int r1 = r12.iflgsave     // Catch:{ SwissephException -> 0x01bb }
            r2 = -1
            if (r1 != r2) goto L_0x0124
            int r0 = r8.swe_calc_error(r11)     // Catch:{ SwissephException -> 0x01bb }
            return r0
        L_0x0124:
            double[] r1 = r12.xsaves     // Catch:{ SwissephException -> 0x01bb }
            r8.denormalize_positions(r14, r1, r15)     // Catch:{ SwissephException -> 0x01bb }
            double[] r3 = r12.xsaves     // Catch:{ SwissephException -> 0x01bb }
            r1 = r22
            r2 = r14
            r4 = r15
            r5 = r20
            r1.calc_speed(r2, r3, r4, r5)     // Catch:{ SwissephException -> 0x01bb }
        L_0x0134:
            double[] r1 = r12.xsaves
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x013f
            r2 = 12
            goto L_0x0140
        L_0x013f:
            r2 = 0
        L_0x0140:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0146
            int r2 = r2 + 6
        L_0x0146:
            r3 = 4
            r4 = 3
            r5 = r26
            r6 = -1
            if (r5 != r6) goto L_0x014f
            r6 = 4
            goto L_0x0150
        L_0x014f:
            r6 = 3
        L_0x0150:
            r7 = 0
        L_0x0151:
            if (r7 >= r6) goto L_0x015c
            int r9 = r7 + r2
            r9 = r1[r9]
            r13[r7] = r9
            int r7 = r7 + 1
            goto L_0x0151
        L_0x015c:
        L_0x015d:
            r7 = 6
            if (r6 >= r7) goto L_0x0165
            r13[r6] = r18
            int r6 = r6 + 1
            goto L_0x015d
        L_0x0165:
            r6 = r0 & 384(0x180, float:5.38E-43)
            if (r6 == 0) goto L_0x0176
            r7 = 3
        L_0x016a:
            r9 = 6
            if (r7 >= r9) goto L_0x0176
            int r10 = r7 + r2
            r14 = r1[r10]
            r13[r7] = r14
            int r7 = r7 + 1
            goto L_0x016a
        L_0x0176:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            r1 = 5
            if (r0 == 0) goto L_0x01aa
            r9 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            r2 = -1
            if (r5 != r2) goto L_0x018f
            r0 = 0
        L_0x0184:
            if (r0 >= r3) goto L_0x01aa
            r4 = r13[r0]
            double r4 = r4 * r9
            r13[r0] = r4
            int r0 = r0 + 1
            goto L_0x0184
        L_0x018f:
            r0 = 0
        L_0x0190:
            r2 = 2
            if (r0 >= r2) goto L_0x019c
            r2 = r13[r0]
            double r2 = r2 * r9
            r13[r0] = r2
            int r0 = r0 + 1
            goto L_0x0190
        L_0x019c:
            if (r6 == 0) goto L_0x01aa
        L_0x019f:
            if (r4 >= r1) goto L_0x01aa
            r2 = r13[r4]
            double r2 = r2 * r9
            r13[r4] = r2
            int r4 = r4 + 1
            goto L_0x019f
        L_0x01aa:
            r0 = 0
        L_0x01ab:
            if (r0 > r1) goto L_0x01b4
            r2 = r13[r0]
            r11[r0] = r2
            int r0 = r0 + 1
            goto L_0x01ab
        L_0x01b4:
            int r0 = r12.iflgsave
            if (r16 != 0) goto L_0x01ba
            r0 = r0 & -3
        L_0x01ba:
            return r0
        L_0x01bb:
            r0 = move-exception
            goto L_0x01c2
        L_0x01bd:
            r0 = move-exception
            r12 = r6
            goto L_0x01c2
        L_0x01c0:
            r0 = move-exception
            r12 = r5
        L_0x01c2:
            r1 = -1
            r12.iflgsave = r1
            r8.swe_calc_error(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph._calc(double, int, int, double[], java.lang.StringBuffer):int");
    }

    public void swe_close() {
        int i = 0;
        while (i < 7) {
            try {
                this.swed.fidat[i].clearData();
                i++;
            } catch (IOException e) {
                return;
            }
        }
        for (int i2 = 0; i2 < 18; i2++) {
            this.swed.pldat[i2].clearData();
        }
        for (int i3 = 0; i3 <= 23; i3++) {
            this.swed.savedat[i3].clearData();
        }
        for (int i4 = 0; i4 < 6; i4++) {
            this.swed.nddat[i4].clearData();
        }
        this.swed.oec.clearData();
        this.swed.oec2000.clearData();
        this.swed.nut.clearData();
        this.swed.nut2000.clearData();
        this.swed.nutv.clearData();
        if (this.swed.fixfp != null) {
            this.swed.fixfp.close();
            this.swed.fixfp = null;
        }
    }

    public void swe_set_ephe_path(String str) {
        double[] dArr = new double[6];
        this.swed.ephe_path_is_set = true;
        swe_close();
        if (str == null || str.length() == 0) {
            str = SweConst.SE_EPHE_PATH;
        } else if (str.length() > 242) {
            str = SweConst.SE_EPHE_PATH;
        }
        this.swed.ephepath = str;
        swe_calc(2451545.0d, 1, 131122, dArr, (StringBuffer) null);
        if (this.swed.fidat[1].fptr != null) {
            SweDate.setGlobalTidalAcc((double) this.swed.fidat[1].sweph_denum);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        r1.swed.eop_tjd_end = ((double) r6) + 2400000.5d;
        r1.swed.eop_dpsi_loaded = 1;
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3 = swi_fopen(-1, swisseph.SwissLib.DPSI_DEPS_IAU1980_FILE_FINALS, r1.swed.ephepath, (java.lang.StringBuffer) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0 = r3.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a1, code lost:
        if (r0 == null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a3, code lost:
        r2 = swisseph.SwissLib.atoi(r0.substring(7));
        r4 = ((double) r2) + 2400000.5d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        if (r4 > r1.swed.eop_tjd_end) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (r7 <= 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
        if ((r2 - r7) == 1) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r1.swed.eop_dpsi_loaded = -3;
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        r6 = swisseph.SwissLib.atof(r0 + 168);
        r9 = swisseph.SwissLib.atof(r0 + 178);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f4, code lost:
        if (r6 != 0.0d) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f6, code lost:
        r6 = swisseph.SwissLib.atof(r0 + 99);
        r9 = swisseph.SwissLib.atof(r0 + 118);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0122, code lost:
        if (r6 != 0.0d) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0124, code lost:
        r1.swed.eop_dpsi_loaded = 2;
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012d, code lost:
        r1.swed.eop_tjd_end = r4;
        r1.swed.dpsi[r8] = r6 / 1000.0d;
        r1.swed.deps[r8] = r9 / 1000.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0144, code lost:
        r8 = r8 + 1;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x014b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load_dpsi_deps() {
        /*
            r17 = this;
            r1 = r17
            r0 = 20
            java.lang.String[] r0 = new java.lang.String[r0]
            swisseph.SwissData r2 = r1.swed
            int r2 = r2.eop_dpsi_loaded
            if (r2 <= 0) goto L_0x000f
            return
        L_0x000f:
            r2 = -1
            java.lang.String r3 = "eop_1962_today.txt"
            swisseph.SwissData r4 = r1.swed     // Catch:{ SwissephException -> 0x0158 }
            java.lang.String r4 = r4.ephepath     // Catch:{ SwissephException -> 0x0158 }
            r5 = 0
            swisseph.FilePtr r3 = r1.swi_fopen(r2, r3, r4, r5)     // Catch:{ SwissephException -> 0x0158 }
            swisseph.SwissData r4 = r1.swed
            r6 = 4702489298950160384(0x4142991a40000000, double:2437684.5)
            r4.eop_tjd_beg_horizons = r6
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0029:
            java.lang.String r10 = r3.readLine()     // Catch:{ IOException -> 0x014c }
            r11 = 1
            r12 = 4702408373176369152(0x41424f8040000000, double:2400000.5)
            if (r10 == 0) goto L_0x0085
            swisseph.SwissLib r14 = r1.sl     // Catch:{ IOException -> 0x014c }
            java.lang.String r15 = " "
            r9 = 16
            r14.swi_cutstr(r10, r15, r0, r9)     // Catch:{ IOException -> 0x014c }
            r9 = r0[r4]     // Catch:{ IOException -> 0x014c }
            int r9 = swisseph.SwissLib.atoi(r9)     // Catch:{ IOException -> 0x014c }
            if (r9 != 0) goto L_0x0047
            goto L_0x0029
        L_0x0047:
            r6 = 3
            r6 = r0[r6]     // Catch:{ IOException -> 0x014c }
            int r6 = swisseph.SwissLib.atoi(r6)     // Catch:{ IOException -> 0x014c }
            if (r7 <= 0) goto L_0x005d
            int r7 = r6 - r7
            if (r7 == r11) goto L_0x005d
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            r2 = -2
            r0.eop_dpsi_loaded = r2     // Catch:{ IOException -> 0x014c }
            r3.close()     // Catch:{ IOException -> 0x014c }
            return
        L_0x005d:
            if (r8 != 0) goto L_0x0065
            swisseph.SwissData r7 = r1.swed     // Catch:{ IOException -> 0x014c }
            double r9 = (double) r6     // Catch:{ IOException -> 0x014c }
            double r9 = r9 + r12
            r7.eop_tjd_beg = r9     // Catch:{ IOException -> 0x014c }
        L_0x0065:
            swisseph.SwissData r7 = r1.swed     // Catch:{ IOException -> 0x014c }
            double[] r7 = r7.dpsi     // Catch:{ IOException -> 0x014c }
            r9 = 8
            r9 = r0[r9]     // Catch:{ IOException -> 0x014c }
            double r9 = swisseph.SwissLib.atof(r9)     // Catch:{ IOException -> 0x014c }
            r7[r8] = r9     // Catch:{ IOException -> 0x014c }
            swisseph.SwissData r7 = r1.swed     // Catch:{ IOException -> 0x014c }
            double[] r7 = r7.deps     // Catch:{ IOException -> 0x014c }
            r9 = 9
            r9 = r0[r9]     // Catch:{ IOException -> 0x014c }
            double r9 = swisseph.SwissLib.atof(r9)     // Catch:{ IOException -> 0x014c }
            r7[r8] = r9     // Catch:{ IOException -> 0x014c }
            int r8 = r8 + 1
            r7 = r6
            goto L_0x0029
        L_0x0085:
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            double r9 = (double) r6     // Catch:{ IOException -> 0x014c }
            double r9 = r9 + r12
            r0.eop_tjd_end = r9     // Catch:{ IOException -> 0x014c }
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            r0.eop_dpsi_loaded = r11     // Catch:{ IOException -> 0x014c }
            r3.close()     // Catch:{ IOException -> 0x014c }
            java.lang.String r0 = "eop_finals.txt"
            swisseph.SwissData r4 = r1.swed     // Catch:{ SwissephException -> 0x014a }
            java.lang.String r4 = r4.ephepath     // Catch:{ SwissephException -> 0x014a }
            swisseph.FilePtr r3 = r1.swi_fopen(r2, r0, r4, r5)     // Catch:{ SwissephException -> 0x014a }
        L_0x009d:
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x014c }
            if (r0 == 0) goto L_0x0149
            r2 = 7
            java.lang.String r2 = r0.substring(r2)     // Catch:{ IOException -> 0x014c }
            int r2 = swisseph.SwissLib.atoi(r2)     // Catch:{ IOException -> 0x014c }
            double r4 = (double) r2     // Catch:{ IOException -> 0x014c }
            double r4 = r4 + r12
            swisseph.SwissData r6 = r1.swed     // Catch:{ IOException -> 0x014c }
            double r9 = r6.eop_tjd_end     // Catch:{ IOException -> 0x014c }
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x00b7
            goto L_0x009d
        L_0x00b7:
            if (r7 <= 0) goto L_0x00c6
            int r6 = r2 - r7
            if (r6 == r11) goto L_0x00c6
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            r2 = -3
            r0.eop_dpsi_loaded = r2     // Catch:{ IOException -> 0x014c }
            r3.close()     // Catch:{ IOException -> 0x014c }
            return
        L_0x00c6:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c }
            r6.<init>()     // Catch:{ IOException -> 0x014c }
            r6.append(r0)     // Catch:{ IOException -> 0x014c }
            r7 = 168(0xa8, float:2.35E-43)
            r6.append(r7)     // Catch:{ IOException -> 0x014c }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x014c }
            double r6 = swisseph.SwissLib.atof(r6)     // Catch:{ IOException -> 0x014c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c }
            r9.<init>()     // Catch:{ IOException -> 0x014c }
            r9.append(r0)     // Catch:{ IOException -> 0x014c }
            r10 = 178(0xb2, float:2.5E-43)
            r9.append(r10)     // Catch:{ IOException -> 0x014c }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x014c }
            double r9 = swisseph.SwissLib.atof(r9)     // Catch:{ IOException -> 0x014c }
            r14 = 0
            int r16 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x0120
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c }
            r6.<init>()     // Catch:{ IOException -> 0x014c }
            r6.append(r0)     // Catch:{ IOException -> 0x014c }
            r7 = 99
            r6.append(r7)     // Catch:{ IOException -> 0x014c }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x014c }
            double r6 = swisseph.SwissLib.atof(r6)     // Catch:{ IOException -> 0x014c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c }
            r9.<init>()     // Catch:{ IOException -> 0x014c }
            r9.append(r0)     // Catch:{ IOException -> 0x014c }
            r0 = 118(0x76, float:1.65E-43)
            r9.append(r0)     // Catch:{ IOException -> 0x014c }
            java.lang.String r0 = r9.toString()     // Catch:{ IOException -> 0x014c }
            double r9 = swisseph.SwissLib.atof(r0)     // Catch:{ IOException -> 0x014c }
        L_0x0120:
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x012d
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            r2 = 2
            r0.eop_dpsi_loaded = r2     // Catch:{ IOException -> 0x014c }
            r3.close()     // Catch:{ IOException -> 0x014c }
            return
        L_0x012d:
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            r0.eop_tjd_end = r4     // Catch:{ IOException -> 0x014c }
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            double[] r0 = r0.dpsi     // Catch:{ IOException -> 0x014c }
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r6 = r6 / r4
            r0[r8] = r6     // Catch:{ IOException -> 0x014c }
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x014c }
            double[] r0 = r0.deps     // Catch:{ IOException -> 0x014c }
            double r9 = r9 / r4
            r0[r8] = r9     // Catch:{ IOException -> 0x014c }
            int r8 = r8 + 1
            r7 = r2
            goto L_0x009d
        L_0x0149:
            goto L_0x014d
        L_0x014a:
            r0 = move-exception
            return
        L_0x014c:
            r0 = move-exception
        L_0x014d:
            swisseph.SwissData r0 = r1.swed
            r2 = 2
            r0.eop_dpsi_loaded = r2
            r3.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0157
        L_0x0156:
            r0 = move-exception
        L_0x0157:
            return
        L_0x0158:
            r0 = move-exception
            swisseph.SwissData r0 = r1.swed
            r0.eop_dpsi_loaded = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.load_dpsi_deps():void");
    }

    public void swe_set_sid_mode(int i) {
        swe_set_sid_mode(i, 0.0d, 0.0d);
    }

    public void swe_set_sid_mode(int i, double d, double d2) {
        int i2 = 0;
        if (i < 0) {
            i = 0;
        }
        SidData sidData = this.swed.sidd;
        sidData.sid_mode = i;
        if (i >= 256) {
            i %= 256;
        }
        if (i == 18 || i == 19 || i == 20) {
            sidData.sid_mode &= -513;
            sidData.sid_mode = 256 | sidData.sid_mode;
        }
        if (!((sidData.sid_mode & 27) == 0 && (sidData.sid_mode & 28) == 0)) {
            sidData.sid_mode &= -769;
        }
        if (i < 29 || i == 255) {
            i2 = i;
        } else {
            sidData.sid_mode = 0;
        }
        this.swed.ayana_is_set = true;
        if (i2 == 255) {
            sidData.t0 = d;
            sidData.ayan_t0 = d2;
        } else {
            sidData.t0 = SwephData.ayanamsa[i2].t0;
            sidData.ayan_t0 = SwephData.ayanamsa[i2].ayan_t0;
        }
        swi_force_app_pos_etc();
    }

    public double swe_get_ayanamsa(double d) {
        double[] dArr = new double[6];
        SidData sidData = this.swed.sidd;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (!this.swed.ayana_is_set) {
            swe_set_sid_mode(0, 0.0d, 0.0d);
        }
        if (sidData.sid_mode == 27) {
            stringBuffer.append("Spica");
            swe_fixstar(stringBuffer, d, 64, dArr, (StringBuffer) null);
            return this.sl.swe_degnorm(dArr[0] - 180.0d);
        } else if (sidData.sid_mode == 28) {
            stringBuffer.append(",zePsc");
            swe_fixstar(stringBuffer, d, 64, dArr, (StringBuffer) null);
            return this.sl.swe_degnorm(dArr[0]);
        } else {
            dArr[0] = 1.0d;
            dArr[2] = 0.0d;
            dArr[1] = 0.0d;
            if (d != 2451545.0d) {
                this.sl.swi_precess(dArr, d, 0, 1);
            }
            this.sl.swi_precess(dArr, sidData.t0, 0, -1);
            this.sl.swi_coortrf(dArr, dArr, this.sl.swi_epsiln(sidData.t0, 0));
            this.sl.swi_cartpol(dArr, dArr);
            dArr[0] = (dArr[0] * 57.2957795130823d) - sidData.ayan_t0;
            return this.sl.swe_degnorm(-dArr[0]);
        }
    }

    public double swe_get_ayanamsa_ut(double d) {
        return swe_get_ayanamsa(d + SweDate.getDeltaT(d));
    }

    public int swe_fixstar(StringBuffer stringBuffer, double d, int i, double[] dArr, StringBuffer stringBuffer2) {
        double d2 = d;
        StringBuffer stringBuffer3 = stringBuffer2;
        int i2 = i | 256;
        if (stringBuffer3 != null) {
            stringBuffer3.setLength(0);
        }
        int plaus_iflag = plaus_iflag(i2, -1, d, stringBuffer2);
        if ((65536 & plaus_iflag) != 0 && !this.swed.ayana_is_set) {
            swe_set_sid_mode(0, 0.0d, 0.0d);
        }
        int i3 = plaus_iflag & 7;
        swi_check_ecliptic(d2, plaus_iflag);
        swi_check_nutation(d2, plaus_iflag);
        StringBuffer stringBuffer4 = stringBuffer;
        String[] readFixstarParameters = readFixstarParameters(stringBuffer, stringBuffer3);
        if (readFixstarParameters == null) {
            return swe_fixstar_error(dArr, -1);
        }
        return swe_fixstar_found(stringBuffer2, readFixstarParameters[1], stringBuffer, Integer.parseInt(readFixstarParameters[0]), d, plaus_iflag, i2, i3, dArr);
    }

    /* access modifiers changed from: protected */
    public String[] readFixstarParameters(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        boolean z;
        int i;
        String str;
        boolean z2;
        int i2;
        StringBuffer stringBuffer3 = stringBuffer2;
        String substring = stringBuffer.toString().substring(0, SMath.min(stringBuffer.length(), 256));
        if (substring.length() > 0) {
            if (substring.charAt(0) == ',') {
                i2 = 0;
                z2 = true;
            } else if (Character.isDigit(substring.charAt(0))) {
                i2 = Integer.parseInt(substring);
                z2 = false;
            } else {
                if (substring.indexOf(44) >= 0) {
                    substring = substring.substring(0, substring.indexOf(44));
                }
                substring = substring.toLowerCase();
                i2 = 0;
                z2 = false;
            }
            z = z2;
            i = i2;
            str = substring.trim();
        } else {
            str = substring;
            i = 0;
            z = false;
        }
        if (str.length() == 0) {
            if (stringBuffer3 != null) {
                stringBuffer3.setLength(0);
                stringBuffer3.append("swe_fixstar(): star name empty");
            }
            return null;
        } else if (this.slast_stardata == null || !this.slast_starname.equals(str)) {
            if (this.swed.fixfp == null) {
                try {
                    SwissData swissData = this.swed;
                    swissData.fixfp = swi_fopen(4, "sefstars.txt", swissData.ephepath, stringBuffer3);
                } catch (SwissephException e) {
                    this.swed.is_old_starfile = true;
                    try {
                        SwissData swissData2 = this.swed;
                        swissData2.fixfp = swi_fopen(4, "fixstars.cat", swissData2.ephepath, (StringBuffer) null);
                    } catch (SwissephException e2) {
                        this.swed.is_old_starfile = false;
                        if (stringBuffer.toString().startsWith("Spica")) {
                            return new String[]{"-1", "Spica,alVir,ICRS,13,25,11.5793,-11,09,40.759,-42.50,-31.73,1.0,12.44,1.04,-10,3672"};
                        }
                        return null;
                    }
                }
                if (this.swed.fixfp == null) {
                    return null;
                }
            }
            this.swed.fixfp.seek(0);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                try {
                    String readLine = this.swed.fixfp.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i3++;
                    if (!readLine.startsWith("#")) {
                        i4++;
                        if (i > 0) {
                            if (i == i4) {
                                this.slast_stardata = readLine;
                                this.slast_starname = str;
                                return new String[]{"" + i3, readLine};
                            }
                        } else if (!z && readLine.toLowerCase().startsWith(str)) {
                            this.slast_stardata = readLine;
                            this.slast_starname = str;
                            return new String[]{"" + i3, readLine};
                        } else if (z && readLine.substring(readLine.indexOf(44)).trim().startsWith(str)) {
                            this.slast_stardata = readLine;
                            this.slast_starname = str;
                            return new String[]{"" + i3, readLine};
                        }
                    }
                } catch (IOException e3) {
                }
            }
            if (stringBuffer3 != null && stringBuffer.length() < 236) {
                stringBuffer3.setLength(0);
                stringBuffer3.append("star  not found");
                if (stringBuffer2.length() + stringBuffer.length() < 256) {
                    stringBuffer3.setLength(0);
                    stringBuffer3.append("star " + stringBuffer + " not found");
                }
            }
            return null;
        } else {
            String str2 = this.slast_stardata;
            return new String[]{"" + 0, str2};
        }
    }

    public int swe_fixstar_ut(StringBuffer stringBuffer, double d, int i, double[] dArr, StringBuffer stringBuffer2) {
        return swe_fixstar(stringBuffer, d + SweDate.getDeltaT(d), i, dArr, stringBuffer2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010d, code lost:
        r0 = "Vesta";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        r0 = "Juno";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        r0 = "Pallas";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0119, code lost:
        r0 = "Ceres";
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String swe_get_planet_name(int r15) {
        /*
            r14 = this;
            r0 = 6
            double[] r9 = new double[r0]
            r0 = 144340(0x233d4, float:2.02263E-40)
            if (r15 != r0) goto L_0x000b
            r15 = 9
        L_0x000b:
            if (r15 == 0) goto L_0x0018
            swisseph.SwissData r0 = r14.swed
            int r0 = r0.i_saved_planet_name
            if (r15 != r0) goto L_0x0018
            swisseph.SwissData r15 = r14.swed
            java.lang.String r15 = r15.saved_planet_name
            return r15
        L_0x0018:
            r0 = 12060(0x2f1c, float:1.69E-41)
            if (r15 == r0) goto L_0x015d
            r0 = 15145(0x3b29, float:2.1223E-41)
            if (r15 == r0) goto L_0x0159
            switch(r15) {
                case 0: goto L_0x0155;
                case 1: goto L_0x0151;
                case 2: goto L_0x014d;
                case 3: goto L_0x0149;
                case 4: goto L_0x0145;
                case 5: goto L_0x0141;
                case 6: goto L_0x013d;
                case 7: goto L_0x0139;
                case 8: goto L_0x0135;
                case 9: goto L_0x0131;
                case 10: goto L_0x012d;
                case 11: goto L_0x0129;
                case 12: goto L_0x0125;
                case 13: goto L_0x0121;
                case 14: goto L_0x011d;
                case 15: goto L_0x015d;
                case 16: goto L_0x0159;
                case 17: goto L_0x0119;
                case 18: goto L_0x0115;
                case 19: goto L_0x0111;
                case 20: goto L_0x010d;
                case 21: goto L_0x0109;
                case 22: goto L_0x0104;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r15) {
                case 10001: goto L_0x0119;
                case 10002: goto L_0x0115;
                case 10003: goto L_0x0111;
                case 10004: goto L_0x010d;
                default: goto L_0x0026;
            }
        L_0x0026:
            r0 = 40
            java.lang.String r1 = ""
            if (r15 < r0) goto L_0x0038
            r2 = 999(0x3e7, float:1.4E-42)
            if (r15 > r2) goto L_0x0038
            swisseph.SwephMosh r2 = r14.smosh
            int r15 = r15 - r0
            java.lang.String r15 = r2.swi_get_fict_name(r15, r1)
            return r15
        L_0x0038:
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r15 <= r0) goto L_0x00f2
            swisseph.SwissData r0 = r14.swed
            swisseph.FileData[] r0 = r0.fidat
            r11 = 3
            r0 = r0[r11]
            int[] r0 = r0.ipl
            r12 = 0
            r0 = r0[r12]
            r13 = -1
            if (r15 != r0) goto L_0x0054
            swisseph.SwissData r0 = r14.swed
            swisseph.FileData[] r0 = r0.fidat
            r0 = r0[r11]
            java.lang.String r0 = r0.astnam
            goto L_0x0085
        L_0x0054:
            r2 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r5 = 3
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r1 = r14
            r4 = r15
            int r0 = r1.sweph(r2, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == r13) goto L_0x0072
            r1 = -2
            if (r0 == r1) goto L_0x0072
            swisseph.SwissData r0 = r14.swed
            swisseph.FileData[] r0 = r0.fidat
            r0 = r0[r11]
            java.lang.String r0 = r0.astnam
            goto L_0x0085
        L_0x0072:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r15 + -10000
            r0.append(r1)
            java.lang.String r1 = ": not found"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0085:
            char r1 = r0.charAt(r12)
            r2 = 63
            if (r1 == r2) goto L_0x0098
            r1 = 1
            char r1 = r0.charAt(r1)
            boolean r1 = java.lang.Character.isDigit(r1)
            if (r1 == 0) goto L_0x0160
        L_0x0098:
            int r1 = r15 + -10000
            r2 = 0
            java.lang.String r3 = "seasnam.txt"
            swisseph.SwissData r4 = r14.swed     // Catch:{ SwissephException -> 0x00a7 }
            java.lang.String r4 = r4.ephepath     // Catch:{ SwissephException -> 0x00a7 }
            swisseph.FilePtr r2 = r14.swi_fopen(r13, r3, r4, r2)     // Catch:{ SwissephException -> 0x00a7 }
            goto L_0x00a8
        L_0x00a7:
            r3 = move-exception
        L_0x00a8:
            if (r2 == 0) goto L_0x00f0
            r3 = 0
        L_0x00ab:
            if (r1 == r3) goto L_0x00f0
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            if (r4 != 0) goto L_0x00b4
            goto L_0x00f0
        L_0x00b4:
            java.util.StringTokenizer r5 = new java.util.StringTokenizer     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            java.lang.String r6 = " \t([{"
            r5.<init>(r4, r6)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            java.lang.String r4 = r5.nextToken()     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            java.lang.String r6 = "#"
            boolean r6 = r4.startsWith(r6)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            if (r6 != 0) goto L_0x00eb
            char r6 = r4.charAt(r12)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            boolean r6 = java.lang.Character.isWhitespace(r6)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            if (r6 == 0) goto L_0x00d2
            goto L_0x00eb
        L_0x00d2:
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            int r3 = r4.intValue()     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            if (r1 == r3) goto L_0x00dd
            goto L_0x00ab
        L_0x00dd:
            java.lang.String r4 = "#\r\n"
            java.lang.String r4 = r5.nextToken(r4)     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            java.lang.String r0 = r4.trim()     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            r2.close()     // Catch:{ IOException -> 0x00ee, NoSuchElementException -> 0x00ec }
            goto L_0x00ef
        L_0x00eb:
            goto L_0x00ab
        L_0x00ec:
            r4 = move-exception
            goto L_0x00ab
        L_0x00ee:
            r4 = move-exception
        L_0x00ef:
            goto L_0x00ab
        L_0x00f0:
            goto L_0x0160
        L_0x00f2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            goto L_0x0160
        L_0x0104:
            java.lang.String r0 = "intp. Perigee"
            goto L_0x0160
        L_0x0109:
            java.lang.String r0 = "intp. Apogee"
            goto L_0x0160
        L_0x010d:
            java.lang.String r0 = "Vesta"
            goto L_0x0160
        L_0x0111:
            java.lang.String r0 = "Juno"
            goto L_0x0160
        L_0x0115:
            java.lang.String r0 = "Pallas"
            goto L_0x0160
        L_0x0119:
            java.lang.String r0 = "Ceres"
            goto L_0x0160
        L_0x011d:
            java.lang.String r0 = "Earth"
            goto L_0x0160
        L_0x0121:
            java.lang.String r0 = "osc. Apogee"
            goto L_0x0160
        L_0x0125:
            java.lang.String r0 = "mean Apogee"
            goto L_0x0160
        L_0x0129:
            java.lang.String r0 = "true Node"
            goto L_0x0160
        L_0x012d:
            java.lang.String r0 = "mean Node"
            goto L_0x0160
        L_0x0131:
            java.lang.String r0 = "Pluto"
            goto L_0x0160
        L_0x0135:
            java.lang.String r0 = "Neptune"
            goto L_0x0160
        L_0x0139:
            java.lang.String r0 = "Uranus"
            goto L_0x0160
        L_0x013d:
            java.lang.String r0 = "Saturn"
            goto L_0x0160
        L_0x0141:
            java.lang.String r0 = "Jupiter"
            goto L_0x0160
        L_0x0145:
            java.lang.String r0 = "Mars"
            goto L_0x0160
        L_0x0149:
            java.lang.String r0 = "Venus"
            goto L_0x0160
        L_0x014d:
            java.lang.String r0 = "Mercury"
            goto L_0x0160
        L_0x0151:
            java.lang.String r0 = "Moon"
            goto L_0x0160
        L_0x0155:
            java.lang.String r0 = "Sun"
            goto L_0x0160
        L_0x0159:
            java.lang.String r0 = "Pholus"
            goto L_0x0160
        L_0x015d:
            java.lang.String r0 = "Chiron"
        L_0x0160:
            int r1 = r0.length()
            r2 = 80
            if (r1 >= r2) goto L_0x0170
            swisseph.SwissData r1 = r14.swed
            r1.i_saved_planet_name = r15
            swisseph.SwissData r15 = r14.swed
            r15.saved_planet_name = r0
        L_0x0170:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.swe_get_planet_name(int):java.lang.String");
    }

    public String swe_get_ayanamsa_name(int i) {
        if (i < 29) {
            return SwissData.ayanamsa_name[i];
        }
        return null;
    }

    public void swe_set_topo(double d, double d2, double d3) {
        this.swed.topd.geolon = d;
        this.swed.topd.geolat = d2;
        this.swed.topd.geoalt = d3;
        this.swed.geopos_is_set = true;
        this.swed.topd.teval = 0.0d;
        swi_force_app_pos_etc();
    }

    public void swe_azalt(double d, int i, double[] dArr, double d2, double d3, double[] dArr2, double[] dArr3) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        this.sc.swe_azalt(d, i, dArr, d2, d3, dArr2, dArr3);
    }

    public void swe_azalt_rev(double d, int i, double[] dArr, double[] dArr2, double[] dArr3) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        this.sc.swe_azalt_rev(d, i, dArr, dArr2, dArr3);
    }

    public int swe_lun_eclipse_how(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_eclipse_how(d, i, dArr, dArr2, stringBuffer);
    }

    public int swe_lun_eclipse_when(double d, int i, int i2, double[] dArr, int i3, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_eclipse_when(d, i, i2, dArr, i3, stringBuffer);
    }

    public int swe_nod_aps(double d, int i, int i2, int i3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_nod_aps(d, i, i2, i3, dArr, dArr2, dArr3, dArr4, stringBuffer);
    }

    public int swe_nod_aps_ut(double d, int i, int i2, int i3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_nod_aps_ut(d, i, i2, i3, dArr, dArr2, dArr3, dArr4, stringBuffer);
    }

    public int swe_pheno(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_pheno(d, i, i2, dArr, stringBuffer);
    }

    public int swe_pheno_ut(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_pheno_ut(d, i, i2, dArr, stringBuffer);
    }

    public double swe_refrac(double d, double d2, double d3, int i) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_refrac(d, d2, d3, i);
    }

    public int swe_rise_trans(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, double d2, double d3, DblObj dblObj, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_rise_trans(d, i, stringBuffer, i2, i3, dArr, d2, d3, dblObj, stringBuffer2);
    }

    public int swe_rise_trans_true_hor(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, double d2, double d3, double d4, DblObj dblObj, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_rise_trans_true_hor(d, i, stringBuffer, i2, i3, dArr, d2, d3, d4, dblObj, stringBuffer2);
    }

    public int swe_sol_eclipse_how(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_sol_eclipse_how(d, i, dArr, dArr2, stringBuffer);
    }

    public int swe_sol_eclipse_when_glob(double d, int i, int i2, double[] dArr, int i3, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_sol_eclipse_when_glob(d, i, i2, dArr, i3, stringBuffer);
    }

    public int swe_sol_eclipse_when_loc(double d, int i, double[] dArr, double[] dArr2, double[] dArr3, int i2, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_sol_eclipse_when_loc(d, i, dArr, dArr2, dArr3, i2, stringBuffer);
    }

    public int swe_sol_eclipse_where(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_sol_eclipse_where(d, i, dArr, dArr2, stringBuffer);
    }

    public int swe_lun_occult_when_loc(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, double[] dArr2, double[] dArr3, int i3, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_occult_when_loc(d, i, stringBuffer, i2, dArr, dArr2, dArr3, i3, stringBuffer2);
    }

    public int swe_lun_eclipse_when_loc(double d, int i, double[] dArr, double[] dArr2, double[] dArr3, int i2, StringBuffer stringBuffer) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_eclipse_when_loc(d, i, dArr, dArr2, dArr3, i2, stringBuffer);
    }

    public int swe_lun_occult_where(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, double[] dArr2, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_occult_where(d, i, stringBuffer, i2, dArr, dArr2, stringBuffer2);
    }

    public int swe_lun_occult_when_glob(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, int i4, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_lun_occult_when_glob(d, i, stringBuffer, i2, i3, dArr, i4, stringBuffer2);
    }

    public int swe_gauquelin_sector(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, double d2, double d3, DblObj dblObj, StringBuffer stringBuffer2) {
        if (this.sc == null) {
            this.sc = new Swecl(this, this.sl, this.sm, this.swed);
        }
        return this.sc.swe_gauquelin_sector(d, i, stringBuffer, i2, i3, dArr, d2, d3, dblObj, stringBuffer2);
    }

    public String swe_house_name(char c) {
        if (this.sh == null) {
            this.sh = new SweHouse(this.sl, this, this.swed);
        }
        return this.sh.swe_house_name(c);
    }

    public double swe_house_pos(double d, double d2, double d3, int i, double[] dArr, StringBuffer stringBuffer) {
        double[] dArr2;
        double[] dArr3 = dArr;
        if (this.sh == null) {
            this.sh = new SweHouse(this.sl, this, this.swed);
        }
        if (dArr3.length != 6) {
            dArr2 = new double[]{dArr3[0], dArr3[1], 0.0d, 0.0d, 0.0d, 0.0d};
        } else {
            dArr2 = dArr3;
        }
        return this.sh.swe_house_pos(d, d2, d3, i, dArr2, stringBuffer);
    }

    public int swe_houses_armc(double d, double d2, double d3, int i, double[] dArr, double[] dArr2) {
        if (this.sh == null) {
            this.sh = new SweHouse(this.sl, this, this.swed);
        }
        return this.sh.swe_houses_armc(d, d2, d3, i, dArr, dArr2, 0);
    }

    public int swe_houses(double d, int i, double d2, double d3, int i2, double[] dArr, double[] dArr2) {
        return swe_houses(d, i, d2, d3, i2, dArr, dArr2, 0);
    }

    public int swe_houses(double d, int i, double d2, double d3, int i2, double[] dArr, double[] dArr2, int i3) {
        if (this.sh == null) {
            this.sh = new SweHouse(this.sl, this, this.swed);
        }
        return this.sh.swe_houses(d, i, d2, d3, i2, dArr, dArr2, i3);
    }

    public double getTransitET(TransitCalculator transitCalculator, double d, boolean z) throws IllegalArgumentException, SwissephException {
        return getTransitET(transitCalculator, d, z, z ? -1.7976931348623157E308d : Double.MAX_VALUE);
    }

    public double getTransitET(TransitCalculator transitCalculator, double d, boolean z, double d2) throws IllegalArgumentException, SwissephException {
        if (this.ext == null) {
            this.ext = new Extensions(this);
        }
        boolean z2 = transitCalculator instanceof TCHouses;
        double d3 = 0.0d;
        double transit = this.ext.getTransit(transitCalculator, d - (z2 ? SweDate.getDeltaT(d) : 0.0d), z, d2);
        if (z2) {
            d3 = SweDate.getDeltaT(d);
        }
        return transit + d3;
    }

    public double getTransitUT(TransitCalculator transitCalculator, double d, boolean z) throws IllegalArgumentException, SwissephException {
        if (this.ext == null) {
            this.ext = new Extensions(this);
        }
        boolean z2 = transitCalculator instanceof TCHouses;
        double d2 = 0.0d;
        double transit = this.ext.getTransit(transitCalculator, d + (z2 ? 0.0d : SweDate.getDeltaT(d)), z, z ? -1.7976931348623157E308d : Double.MAX_VALUE);
        if (!z2) {
            d2 = SweDate.getDeltaT(transit);
        }
        return transit - d2;
    }

    public double getTransitUT(TransitCalculator transitCalculator, double d, boolean z, double d2) throws IllegalArgumentException, SwissephException {
        if (this.ext == null) {
            this.ext = new Extensions(this);
        }
        double transit = this.ext.getTransit(transitCalculator, d + SweDate.getDeltaT(d), z, d2 + SweDate.getDeltaT(d2));
        return transit - SweDate.getDeltaT(transit);
    }

    private int swe_calc_error(double[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = 0.0d;
        }
        return -1;
    }

    private int swecalc(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) throws SwissephException {
        int i3;
        int i4;
        int i5;
        PlanData planData;
        int i6;
        int i7;
        int i8;
        double[] dArr2;
        int i9;
        int i10;
        int i11;
        int i12;
        PlanData planData2;
        int i13;
        int i14;
        int i15;
        String str;
        double d2 = d;
        int i16 = i;
        double[] dArr3 = dArr;
        StringBuffer stringBuffer2 = stringBuffer;
        PlanData planData3 = this.swed.pldat[0];
        PlanData planData4 = this.swed.pldat[10];
        if (stringBuffer2 != null) {
            stringBuffer2.setLength(0);
        }
        int plaus_iflag = plaus_iflag(i2, i, d, stringBuffer);
        int i17 = plaus_iflag & 4;
        if (i17 != 0) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        if ((plaus_iflag & 2) != 0) {
            i4 = 2;
        } else {
            i4 = i3;
        }
        int i18 = plaus_iflag & 16384;
        if (i18 == 0 || i17 == 0) {
            if (i4 != 4 && !this.swed.ephe_path_is_set) {
                swe_set_ephe_path((String) null);
            }
            int i19 = plaus_iflag & 65536;
            if (i19 == 0 || this.swed.ayana_is_set) {
                i5 = i18;
                i8 = i4;
                i6 = plaus_iflag;
                planData = planData4;
                i7 = 2;
            } else {
                i5 = i18;
                i8 = i4;
                i6 = plaus_iflag;
                planData = planData4;
                i7 = 2;
                swe_set_sid_mode(0, 0.0d, 0.0d);
            }
            swi_check_ecliptic(d2, i6);
            swi_check_nutation(d2, i6);
            if (i16 == -1) {
                dArr3[0] = this.swed.oec.eps + this.swed.nut.nutlo[1];
                dArr3[1] = this.swed.oec.eps;
                dArr3[i7] = this.swed.nut.nutlo[0];
                dArr3[3] = this.swed.nut.nutlo[1];
                for (int i20 = 0; i20 <= 3; i20++) {
                    dArr3[i20] = dArr3[i20] * 57.2957795130823d;
                }
                return i6;
            }
            if (i16 == 1) {
                double[] dArr4 = this.swed.pldat[1].xreturn;
                if (i8 != i7) {
                    if (i8 == 4) {
                        if (moshier_moon(d, true, (double[]) null, stringBuffer) == -1) {
                            return swecalc_error(dArr3);
                        }
                    }
                } else if (sweph_moon(d, 1, i6, stringBuffer) == -1) {
                    return swecalc_error(dArr3);
                }
                if (app_pos_etc_moon(i6, stringBuffer2) != 0) {
                    return swecalc_error(dArr3);
                }
                dArr2 = dArr4;
                i10 = i6;
                i9 = 24;
            } else if (i16 != 0 || i5 == 0) {
                if (i16 == 0 || i16 == i7 || i16 == 3 || i16 == 4 || i16 == 5 || i16 == 6 || i16 == 7 || i16 == 8 || i16 == 9) {
                    i12 = 0;
                    i11 = -1;
                } else if (i16 == 14) {
                    i12 = 0;
                    i11 = -1;
                } else if (i16 != 10) {
                    PlanData planData5 = planData3;
                    int i21 = 3;
                    if (i16 == 12) {
                        if ((i6 & 8) == 0 && i5 == 0) {
                            PlanData planData6 = this.swed.nddat[i7];
                            double[] dArr5 = planData6.xreturn;
                            double[] dArr6 = planData6.x;
                            if (this.sm.swi_mean_apog(d2, dArr6, stringBuffer2) == -1) {
                                return swecalc_error(dArr3);
                            }
                            dArr2 = dArr5;
                            if (this.sm.swi_mean_apog(d2 - 0.001d, dArr6, 3, stringBuffer) == -1) {
                                return swecalc_error(dArr3);
                            }
                            for (int i22 = 0; i22 <= 1; i22++) {
                                int i23 = i22 + 3;
                                dArr6[i23] = this.sl.swe_difrad2n(dArr6[i22], dArr6[i23]) / 0.001d;
                            }
                            dArr6[5] = 0.0d;
                            planData6.teval = d2;
                            planData6.xflgs = -1;
                            int app_pos_etc_mean = app_pos_etc_mean(2, i6, stringBuffer2);
                            if (app_pos_etc_mean != 0) {
                                return swecalc_error(dArr3);
                            }
                            planData6.xreturn[5] = 0.0d;
                            if (app_pos_etc_mean == -1) {
                                return swecalc_error(dArr3);
                            }
                            i10 = i6;
                            i9 = 24;
                        } else {
                            for (int i24 = 0; i24 < 24; i24++) {
                                dArr3[i24] = 0.0d;
                            }
                            return i6;
                        }
                    } else if (i16 == 11) {
                        if ((i6 & 8) == 0 && i5 == 0) {
                            PlanData planData7 = this.swed.nddat[1];
                            double[] dArr7 = planData7.xreturn;
                            int lunar_osc_elem = lunar_osc_elem(d, 1, i6, stringBuffer);
                            i10 = planData7.xflgs;
                            if ((i10 & 65536) == 0 && (i10 & 32) == 0) {
                                planData7.xreturn[1] = 0.0d;
                                planData7.xreturn[4] = 0.0d;
                                planData7.xreturn[8] = 0.0d;
                                planData7.xreturn[11] = 0.0d;
                            }
                            if (lunar_osc_elem == -1) {
                                return swecalc_error(dArr3);
                            }
                            dArr2 = dArr7;
                            i9 = 24;
                        } else {
                            for (int i25 = 0; i25 < 24; i25++) {
                                dArr3[i25] = 0.0d;
                            }
                            return i6;
                        }
                    } else if (i16 == 13) {
                        if ((i6 & 8) == 0 && i5 == 0) {
                            PlanData planData8 = this.swed.nddat[3];
                            double[] dArr8 = planData8.xreturn;
                            int lunar_osc_elem2 = lunar_osc_elem(d, 3, i6, stringBuffer);
                            i10 = planData8.xflgs;
                            if (lunar_osc_elem2 == -1) {
                                return swecalc_error(dArr3);
                            }
                            dArr2 = dArr8;
                            i9 = 24;
                        } else {
                            for (int i26 = 0; i26 < 24; i26++) {
                                dArr3[i26] = 0.0d;
                            }
                            return i6;
                        }
                    } else if (i16 == 21) {
                        if ((i6 & 8) == 0 && i5 == 0) {
                            PlanData planData9 = this.swed.nddat[4];
                            double[] dArr9 = planData9.xreturn;
                            int intp_apsides = intp_apsides(d, 4, i6, stringBuffer);
                            i10 = planData9.xflgs;
                            if (intp_apsides == -1) {
                                return swecalc_error(dArr3);
                            }
                            dArr2 = dArr9;
                            i9 = 24;
                        } else {
                            for (int i27 = 0; i27 < 24; i27++) {
                                dArr3[i27] = 0.0d;
                            }
                            return i6;
                        }
                    } else if (i16 != 22) {
                        if (i16 != 15 && i16 != 16 && i16 != 17 && i16 != 18 && i16 != 19 && i16 != 20) {
                            if (i16 <= 10000) {
                                if (i16 >= 40 && i16 <= 999) {
                                    PlanData planData10 = this.swed.pldat[11];
                                    double[] dArr10 = planData10.xreturn;
                                    int i28 = i6;
                                    int i29 = i8;
                                    int i30 = i28;
                                    while (true) {
                                        double[] dArr11 = dArr10;
                                        PlanData planData11 = planData10;
                                        PlanData planData12 = planData5;
                                        int main_planet = main_planet(d, 0, i29, i30, stringBuffer);
                                        int i31 = this.swed.pldat[0].xflgs;
                                        PlanData planData13 = planData;
                                        int i32 = i31;
                                        int i33 = main_planet;
                                        PlanData planData14 = planData13;
                                        PlanData planData15 = planData12;
                                        PlanData planData16 = planData11;
                                        if (this.smosh.swi_osc_el_plan(d, planData11.x, i16 - 40, 11, planData12.x, planData13.x, stringBuffer) == 0) {
                                            if (i33 != -1) {
                                                int app_pos_etc_plan_osc = app_pos_etc_plan_osc(i16, 11, i32, stringBuffer2);
                                                if (app_pos_etc_plan_osc != -1) {
                                                    if (app_pos_etc_plan_osc != -2 && app_pos_etc_plan_osc != -3) {
                                                        i10 = i32;
                                                        dArr2 = dArr11;
                                                        i9 = 24;
                                                        break;
                                                    } else if (i29 == 4) {
                                                        return swecalc_error(dArr3);
                                                    } else {
                                                        i30 = (i32 & -8) | 4;
                                                        if (stringBuffer2 != null && stringBuffer.length() + 30 < 256) {
                                                            stringBuffer2.append("\nusing Moshier eph.; ");
                                                        }
                                                        double d3 = d;
                                                        planData5 = planData15;
                                                        dArr10 = dArr11;
                                                        planData10 = planData16;
                                                        planData = planData14;
                                                        i29 = 4;
                                                    }
                                                } else {
                                                    return swecalc_error(dArr3);
                                                }
                                            } else {
                                                return swecalc_error(dArr3);
                                            }
                                        } else {
                                            return swecalc_error(dArr3);
                                        }
                                    }
                                } else {
                                    if (stringBuffer2 != null) {
                                        stringBuffer2.setLength(0);
                                        stringBuffer2.append("illegal planet number " + i16 + ".");
                                    }
                                    return swecalc_error(dArr3);
                                }
                            } else {
                                planData2 = planData;
                                i13 = -1;
                            }
                        } else {
                            planData2 = planData;
                            i13 = -1;
                        }
                        if (i16 < 23) {
                            i14 = SwissData.pnoext2int[i16];
                        } else if (i16 <= 10004) {
                            i14 = ((i16 + 14) - SweConst.SE_AST_OFFSET) - 1;
                            i16 = ((i16 + 17) - SweConst.SE_AST_OFFSET) - 1;
                        } else {
                            i14 = 11;
                        }
                        if (i14 == 11) {
                            i15 = i16;
                        } else {
                            i15 = i14;
                        }
                        double[] dArr12 = this.swed.pldat[i14].xreturn;
                        if (i15 <= 10000) {
                            i21 = 2;
                        }
                        if (i14 == 12 && (d < 1958470.5d || d > 3419437.5d)) {
                            if (stringBuffer2 != null) {
                                stringBuffer2.setLength(0);
                                stringBuffer2.append("Chiron's ephemeris is restricted to JD 1958470.5 - JD 3419437.5");
                            }
                            return i13;
                        } else if (i14 != 13 || d >= 314845.5d) {
                            String str2 = "";
                            int i34 = i6;
                            for (int i35 = i8; main_planet(d, 0, i35, i34, stringBuffer) != i13; i35 = 4) {
                                int i36 = this.swed.pldat[0].xflgs;
                                if (stringBuffer2 != null) {
                                    String stringBuffer3 = stringBuffer.toString();
                                    stringBuffer2.setLength(0);
                                    str2 = stringBuffer3;
                                }
                                PlanData planData17 = planData2;
                                PlanData planData18 = planData17;
                                int i37 = i36;
                                String str3 = str2;
                                dArr2 = dArr12;
                                int sweph = sweph(d, i15, i21, i36, planData17.x, true, (double[]) null, stringBuffer);
                                if (sweph == i13 || sweph == -2) {
                                    return swecalc_error(dArr3);
                                }
                                int i38 = i37;
                                int app_pos_etc_plan = app_pos_etc_plan(i15, i38, stringBuffer2);
                                if (app_pos_etc_plan == i13) {
                                    return swecalc_error(dArr3);
                                }
                                if (app_pos_etc_plan == -2) {
                                    str = str3;
                                } else if (app_pos_etc_plan == -3) {
                                    str = str3;
                                } else {
                                    if (stringBuffer2 != null && stringBuffer.length() == 0 && str3.length() != 0) {
                                        stringBuffer2.setLength(0);
                                        stringBuffer2.append("sun: " + str3.substring(0, SMath.min(str3.length(), 251)));
                                    }
                                    i10 = i38;
                                    i9 = 24;
                                }
                                if (i35 == 4) {
                                    return swecalc_error(dArr3);
                                }
                                i34 = (i38 & -8) | 4;
                                if (stringBuffer2 != null && stringBuffer.length() + 30 < 256) {
                                    stringBuffer2.append("\nusing Moshier eph.; ");
                                }
                                str2 = str;
                                dArr12 = dArr2;
                                planData2 = planData18;
                            }
                            return swecalc_error(dArr3);
                        } else {
                            if (stringBuffer2 != null) {
                                stringBuffer2.setLength(0);
                                stringBuffer2.append("Pholus's ephemeris is restricted to the time after JD 314845.5");
                            }
                            return i13;
                        }
                    } else if ((i6 & 8) == 0 && i5 == 0) {
                        PlanData planData19 = this.swed.nddat[5];
                        double[] dArr13 = planData19.xreturn;
                        int intp_apsides2 = intp_apsides(d, 5, i6, stringBuffer);
                        i10 = planData19.xflgs;
                        if (intp_apsides2 == -1) {
                            return swecalc_error(dArr3);
                        }
                        dArr2 = dArr13;
                        i9 = 24;
                    } else {
                        for (int i39 = 0; i39 < 24; i39++) {
                            dArr3[i39] = 0.0d;
                        }
                        return i6;
                    }
                } else if ((i6 & 8) == 0 && i5 == 0) {
                    PlanData planData20 = this.swed.nddat[0];
                    double[] dArr14 = planData20.xreturn;
                    double[] dArr15 = planData20.x;
                    if (this.sm.swi_mean_node(d2, dArr15, stringBuffer2) == -1) {
                        return swecalc_error(dArr3);
                    }
                    dArr2 = dArr14;
                    if (this.sm.swi_mean_node(d2 - 0.001d, dArr15, 3, stringBuffer) == -1) {
                        return swecalc_error(dArr3);
                    }
                    dArr15[3] = this.sl.swe_difrad2n(dArr15[0], dArr15[3]) / 0.001d;
                    dArr15[5] = 0.0d;
                    dArr15[4] = 0.0d;
                    planData20.teval = d2;
                    planData20.xflgs = -1;
                    int app_pos_etc_mean2 = app_pos_etc_mean(0, i6, stringBuffer2);
                    if (app_pos_etc_mean2 != 0) {
                        return swecalc_error(dArr3);
                    }
                    if (i19 == 0 && (i6 & 32) == 0) {
                        planData20.xreturn[1] = 0.0d;
                        planData20.xreturn[4] = 0.0d;
                        planData20.xreturn[5] = 0.0d;
                        planData20.xreturn[8] = 0.0d;
                        planData20.xreturn[11] = 0.0d;
                    }
                    if (app_pos_etc_mean2 == -1) {
                        return swecalc_error(dArr3);
                    }
                    i10 = i6;
                    i9 = 24;
                } else {
                    for (int i40 = 0; i40 < 24; i40++) {
                        dArr3[i40] = 0.0d;
                    }
                    return i6;
                }
                if ((i6 & 8) == 0) {
                    i9 = 24;
                    if (i5 == 0 && i16 == 14) {
                        while (i12 < 24) {
                            dArr3[i12] = 0.0d;
                            i12++;
                        }
                        return i6;
                    }
                } else if (i16 == 0) {
                    while (i12 < 24) {
                        dArr3[i12] = 0.0d;
                        i12++;
                    }
                    return i6;
                } else {
                    i9 = 24;
                }
                int i41 = SwissData.pnoext2int[i16];
                PlanData planData21 = this.swed.pldat[i41];
                double[] dArr16 = planData21.xreturn;
                if (main_planet(d, i41, i8, i6, stringBuffer) == i11) {
                    return swecalc_error(dArr3);
                }
                i10 = planData21.xflgs;
                dArr2 = dArr16;
            } else {
                double[] dArr17 = planData3.xreturn;
                if (i8 != i7) {
                    return -1;
                }
                if (sweph_sbar(d, i6, planData, planData3, stringBuffer) == -1) {
                    return swecalc_error(dArr3);
                }
                if (app_pos_etc_sbar(i6, stringBuffer2) != 0) {
                    return swecalc_error(dArr3);
                }
                i10 = planData3.xflgs;
                planData3.xflgs = -1;
                dArr2 = dArr17;
                i9 = 24;
            }
            for (int i42 = 0; i42 < i9; i42++) {
                dArr3[i42] = dArr2[i42];
            }
            return i10;
        }
        if (stringBuffer2 != null) {
            stringBuffer2.append("barycentric Moshier positions are not supported.");
        }
        throw new SwissephException(d, (int) SwissephException.INVALID_PARAMETER_COMBINATION, -1, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int moshier_moon(double d, boolean z, double[] dArr, StringBuffer stringBuffer) {
        if (this.sm.swi_moshmoon(d, z, (double[]) null, stringBuffer) == -1 || this.smosh.swi_moshplan(d, 0, z, (double[]) null, (double[]) null, stringBuffer) == -1) {
            return -1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swecalc_error(double[] dArr) {
        for (int i = 0; i < 24; i++) {
            dArr[i] = 0.0d;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int sweph_sbar(double d, int i, PlanData planData, PlanData planData2, StringBuffer stringBuffer) {
        int sweplan = sweplan(d, 0, 0, i, true, (double[]) null, (double[]) null, (double[]) null, (double[]) null, stringBuffer);
        if (sweplan == -1 || sweplan == -2) {
            return -1;
        }
        planData.teval = d;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int sweph_moon(double d, int i, int i2, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = stringBuffer;
        int sweplan = sweplan(d, i, 1, i2, true, (double[]) null, (double[]) null, (double[]) null, (double[]) null, stringBuffer);
        if (sweplan == -1) {
            return -1;
        }
        if (sweplan != -2) {
            return 0;
        }
        if (d <= 625000.5d || d >= 2818000.5d) {
            return -1;
        }
        if (stringBuffer2 != null && stringBuffer.length() + 30 < 256) {
            stringBuffer2.append(" \nusing Moshier eph.; ");
        }
        if (moshier_moon(d, true, (double[]) null, stringBuffer) == -1) {
            return -1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void calc_epsilon(double d, int i, Epsilon epsilon) {
        epsilon.teps = d;
        epsilon.eps = this.sl.swi_epsiln(d, i);
        epsilon.seps = SMath.sin(epsilon.eps);
        epsilon.ceps = SMath.cos(epsilon.eps);
    }

    private int main_planet(double d, int i, int i2, int i3, StringBuffer stringBuffer) throws SwissephException {
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9 = i;
        StringBuffer stringBuffer2 = stringBuffer;
        boolean z2 = true;
        if (i2 != 2) {
            i4 = i3;
            i5 = -1;
            z2 = false;
        } else {
            int sweplan = sweplan(d, i, 0, i3, true, (double[]) null, (double[]) null, (double[]) null, (double[]) null, stringBuffer);
            i5 = -1;
            if (sweplan == -1) {
                return -1;
            }
            if (sweplan != -2) {
                i7 = i3;
                z = false;
            } else if (d <= 625000.5d || d >= 2818000.5d) {
                return -1;
            } else {
                i7 = (i3 & -3) | 4;
                if (stringBuffer2 != null && stringBuffer.length() + 30 < 256) {
                    stringBuffer2.append(" \nusing Moshier eph.; ");
                }
                z = true;
            }
            if (!z) {
                if (i9 == 0) {
                    i8 = app_pos_etc_sun(i7, stringBuffer2);
                } else {
                    i8 = app_pos_etc_plan(i9, i7, stringBuffer2);
                }
                if (i8 == -1) {
                    return -1;
                }
                if (i8 == -2) {
                    if (d <= 625000.5d || d >= 2818000.5d) {
                        return -1;
                    }
                    int i10 = (i7 & -3) | 4;
                    if (stringBuffer2 != null && stringBuffer.length() + 30 < 256) {
                        stringBuffer2.append(" \nusing Moshier eph.; ");
                    }
                    i4 = i10;
                }
            }
            z2 = z;
            i4 = i7;
        }
        if (i2 == 4 || z2) {
            if (this.smosh.swi_moshplan(d, i, true, (double[]) null, (double[]) null, stringBuffer) == i5) {
                return i5;
            }
            if (i9 == 0) {
                i6 = app_pos_etc_sun(i4, stringBuffer2);
            } else {
                i6 = app_pos_etc_plan(i9, i4, stringBuffer2);
            }
            if (i6 == i5) {
                return i5;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int main_planet_bary(double d, int i, int i2, int i3, boolean z, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, StringBuffer stringBuffer) {
        int i4 = i2;
        if (i4 == 2) {
            int sweplan = sweplan(d, i, 0, i3, z, dArr, dArr2, dArr3, dArr4, stringBuffer);
            if (sweplan != -1) {
                if (sweplan == -2) {
                }
            }
            return sweplan;
        }
        if (i4 == 4) {
            if (this.smosh.swi_moshplan(d, i, z, dArr, dArr2, stringBuffer) == -1) {
                return -1;
            }
            for (int i5 = 0; i5 <= 5; i5++) {
                dArr3[i5] = 0.0d;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swemoon(double d, int i, boolean z, double[] dArr, StringBuffer stringBuffer) {
        double[] dArr2;
        double d2 = d;
        PlanData planData = this.swed.pldat[1];
        double[] dArr3 = new double[6];
        if (z) {
            dArr2 = planData.x;
        } else {
            dArr2 = dArr3;
        }
        int i2 = planData.xflgs & 256;
        int i3 = i & 256;
        if (d2 == planData.teval && planData.iephe == 2 && (i3 == 0 || i2 != 0)) {
            dArr2 = planData.x;
        } else {
            int sweph = sweph(d, 1, 1, i, (double[]) null, z, dArr2, stringBuffer);
            if (sweph != 0) {
                return sweph;
            }
            if (z) {
                planData.teval = d2;
                planData.xflgs = -1;
                planData.iephe = 2;
            }
        }
        if (dArr != null) {
            for (int i4 = 0; i4 <= 5; i4++) {
                dArr[i4] = dArr2[i4];
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int sweplan(double r29, int r31, int r32, int r33, boolean r34, double[] r35, double[] r36, double[] r37, double[] r38, java.lang.StringBuffer r39) {
        /*
            r28 = this;
            r10 = r28
            r11 = r31
            r12 = r33
            r13 = r39
            swisseph.SwissData r0 = r10.swed
            swisseph.PlanData[] r0 = r0.pldat
            r14 = r0[r11]
            swisseph.SwissData r0 = r10.swed
            swisseph.PlanData[] r0 = r0.pldat
            r15 = 0
            r9 = r0[r15]
            swisseph.SwissData r0 = r10.swed
            swisseph.PlanData[] r0 = r0.pldat
            r1 = 10
            r0 = r0[r1]
            swisseph.SwissData r2 = r10.swed
            swisseph.PlanData[] r2 = r2.pldat
            r8 = 1
            r7 = r2[r8]
            r2 = 6
            double[] r3 = new double[r2]
            double[] r4 = new double[r2]
            double[] r5 = new double[r2]
            double[] r2 = new double[r2]
            if (r34 != 0) goto L_0x003f
            if (r11 == r1) goto L_0x003f
            int r1 = r14.iflg
            r1 = r1 & r8
            if (r1 != 0) goto L_0x003f
            if (r37 != 0) goto L_0x003f
            r1 = r12 & 8
            if (r1 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r1 = 0
            goto L_0x0040
        L_0x003f:
            r1 = 1
        L_0x0040:
            if (r34 != 0) goto L_0x0049
            if (r11 == 0) goto L_0x0049
            if (r36 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r6 = 0
            goto L_0x004a
        L_0x0049:
            r6 = 1
        L_0x004a:
            if (r11 != r8) goto L_0x0051
            r1 = 1
            r16 = 1
            goto L_0x0053
        L_0x0051:
            r16 = r6
        L_0x0053:
            if (r34 != 0) goto L_0x0061
            if (r11 == r8) goto L_0x0061
            if (r11 == 0) goto L_0x0061
            if (r36 != 0) goto L_0x0061
            if (r38 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r17 = 0
            goto L_0x0063
        L_0x0061:
            r17 = 1
        L_0x0063:
            if (r34 == 0) goto L_0x0074
            double[] r3 = r14.x
            double[] r2 = r9.x
            double[] r5 = r0.x
            double[] r4 = r7.x
            r6 = r2
            r18 = r3
            r19 = r5
            r5 = r4
            goto L_0x007d
        L_0x0074:
            r6 = r2
            r18 = r3
            r19 = r5
            r5 = r4
        L_0x007d:
            r4 = r12 & 256(0x100, float:3.59E-43)
            r3 = 2
            r2 = 256(0x100, float:3.59E-43)
            r15 = 5
            if (r1 == 0) goto L_0x00e3
            int r1 = r0.xflgs
            r1 = r1 & r2
            r20 = r9
            double r8 = r0.teval
            int r21 = (r29 > r8 ? 1 : (r29 == r8 ? 0 : -1))
            if (r21 != 0) goto L_0x00af
            int r8 = r0.iephe
            if (r8 != r3) goto L_0x00af
            if (r4 == 0) goto L_0x0098
            if (r1 == 0) goto L_0x00af
        L_0x0098:
            r1 = 0
        L_0x0099:
            if (r1 > r15) goto L_0x00a4
            double[] r8 = r0.x
            r21 = r8[r1]
            r19[r1] = r21
            int r1 = r1 + 1
            goto L_0x0099
        L_0x00a4:
            r22 = r4
            r26 = r5
            r24 = r6
            r23 = r7
            r25 = r20
            goto L_0x00d7
        L_0x00af:
            r8 = 10
            r9 = 0
            r21 = 0
            r0 = r28
            r1 = r29
            r3 = r8
            r22 = r4
            r4 = r9
            r9 = r5
            r5 = r33
            r8 = r6
            r6 = r21
            r23 = r7
            r7 = r34
            r24 = r8
            r8 = r19
            r26 = r9
            r25 = r20
            r9 = r39
            int r0 = r0.sweph(r1, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x00d7
            return r0
        L_0x00d7:
            if (r37 == 0) goto L_0x00ed
            r0 = 0
        L_0x00da:
            if (r0 > r15) goto L_0x00ed
            r1 = r19[r0]
            r37[r0] = r1
            int r0 = r0 + 1
            goto L_0x00da
        L_0x00e3:
            r22 = r4
            r26 = r5
            r24 = r6
            r23 = r7
            r25 = r9
        L_0x00ed:
            if (r17 == 0) goto L_0x017e
            r0 = r23
            int r1 = r0.xflgs
            r9 = 256(0x100, float:3.59E-43)
            r1 = r1 & r9
            double r2 = r0.teval
            int r4 = (r29 > r2 ? 1 : (r29 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0120
            int r2 = r0.iephe
            r8 = 2
            if (r2 != r8) goto L_0x011d
            if (r22 == 0) goto L_0x0109
            if (r1 == 0) goto L_0x0106
            goto L_0x0109
        L_0x0106:
            r7 = r26
            goto L_0x0123
        L_0x0109:
            r1 = 0
        L_0x010a:
            if (r1 > r15) goto L_0x0117
            double[] r2 = r0.x
            r3 = r2[r1]
            r7 = r26
            r7[r1] = r3
            int r1 = r1 + 1
            goto L_0x010a
        L_0x0117:
            r7 = r26
            r9 = 1
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x0169
        L_0x011d:
            r7 = r26
            goto L_0x0123
        L_0x0120:
            r7 = r26
            r8 = 2
        L_0x0123:
            r3 = 1
            r4 = 1
            r6 = 0
            r0 = r28
            r1 = r29
            r5 = r33
            r26 = r7
            r7 = r34
            r8 = r26
            r15 = 256(0x100, float:3.59E-43)
            r9 = r39
            int r0 = r0.sweph(r1, r3, r4, r5, r6, r7, r8, r9)
            r1 = -1
            if (r0 != r1) goto L_0x013e
            return r0
        L_0x013e:
            swisseph.SwissData r0 = r10.swed
            swisseph.FileData[] r0 = r0.fidat
            r9 = 1
            r0 = r0[r9]
            swisseph.FilePtr r0 = r0.fptr
            if (r0 != 0) goto L_0x0169
            if (r13 == 0) goto L_0x0158
            int r0 = r39.length()
            int r0 = r0 + 35
            if (r0 >= r15) goto L_0x0158
            java.lang.String r0 = " \nusing Moshier eph. for moon; "
            r13.append(r0)
        L_0x0158:
            swisseph.Swemmoon r0 = r10.sm
            r1 = r29
            r3 = r34
            r4 = r26
            r5 = r39
            int r0 = r0.swi_moshmoon(r1, r3, r4, r5)
            if (r0 == 0) goto L_0x0169
            return r0
        L_0x0169:
            if (r38 == 0) goto L_0x017b
            r0 = 0
        L_0x016c:
            r1 = 5
            if (r0 > r1) goto L_0x0178
            r8 = r26
            r1 = r8[r0]
            r38[r0] = r1
            int r0 = r0 + 1
            goto L_0x016c
        L_0x0178:
            r8 = r26
            goto L_0x0183
        L_0x017b:
            r8 = r26
            goto L_0x0183
        L_0x017e:
            r8 = r26
            r9 = 1
            r15 = 256(0x100, float:3.59E-43)
        L_0x0183:
            r7 = 3
            if (r16 == 0) goto L_0x01fe
            r6 = r25
            int r0 = r6.xflgs
            r0 = r0 & r15
            double r1 = r6.teval
            int r3 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01b7
            int r1 = r6.iephe
            r5 = 2
            if (r1 != r5) goto L_0x01b4
            if (r22 == 0) goto L_0x019e
            if (r0 == 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            r4 = r24
            goto L_0x01ba
        L_0x019e:
            r0 = 0
        L_0x019f:
            r1 = 5
            if (r0 > r1) goto L_0x01ad
            double[] r1 = r6.x
            r2 = r1[r0]
            r4 = r24
            r4[r0] = r2
            int r0 = r0 + 1
            goto L_0x019f
        L_0x01ad:
            r4 = r24
            r2 = r4
            r4 = r8
            r12 = 1
            r15 = 3
            goto L_0x01f1
        L_0x01b4:
            r4 = r24
            goto L_0x01ba
        L_0x01b7:
            r4 = r24
            r5 = 2
        L_0x01ba:
            r3 = 0
            r16 = 0
            r20 = 0
            r0 = r28
            r1 = r29
            r24 = r4
            r4 = r16
            r5 = r33
            r15 = r6
            r6 = r20
            r7 = r34
            r27 = r8
            r8 = r24
            r12 = 1
            r9 = r39
            int r0 = r0.sweph(r1, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x01dc
            return r0
        L_0x01dc:
            r2 = r24
            r4 = r27
            r0 = 0
            r10.embofs(r2, r0, r4, r0)
            double[] r0 = r15.x
            if (r2 == r0) goto L_0x01ed
            if (r22 == 0) goto L_0x01eb
            goto L_0x01ed
        L_0x01eb:
            r15 = 3
            goto L_0x01f1
        L_0x01ed:
            r15 = 3
            r10.embofs(r2, r15, r4, r15)
        L_0x01f1:
            if (r36 == 0) goto L_0x0203
            r0 = 0
        L_0x01f4:
            r1 = 5
            if (r0 > r1) goto L_0x0203
            r5 = r2[r0]
            r36[r0] = r5
            int r0 = r0 + 1
            goto L_0x01f4
        L_0x01fe:
            r4 = r8
            r2 = r24
            r12 = 1
            r15 = 3
        L_0x0203:
            if (r11 != r12) goto L_0x0210
            r0 = 0
        L_0x0206:
            r1 = 5
            if (r0 > r1) goto L_0x028b
            r1 = r4[r0]
            r18[r0] = r1
            int r0 = r0 + 1
            goto L_0x0206
        L_0x0210:
            if (r11 != 0) goto L_0x021d
            r0 = 0
        L_0x0213:
            r1 = 5
            if (r0 > r1) goto L_0x028b
            r3 = r2[r0]
            r18[r0] = r3
            int r0 = r0 + 1
            goto L_0x0213
        L_0x021d:
            if (r11 != 0) goto L_0x022a
            r0 = 0
        L_0x0220:
            r1 = 5
            if (r0 > r1) goto L_0x028b
            r1 = r19[r0]
            r18[r0] = r1
            int r0 = r0 + 1
            goto L_0x0220
        L_0x022a:
            int r0 = r14.xflgs
            r1 = 256(0x100, float:3.59E-43)
            r0 = r0 & r1
            double r1 = r14.teval
            int r3 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x024d
            int r1 = r14.iephe
            r9 = 2
            if (r1 != r9) goto L_0x024e
            if (r22 == 0) goto L_0x023e
            if (r0 == 0) goto L_0x024e
        L_0x023e:
            r0 = 0
        L_0x023f:
            r1 = 5
            if (r0 > r1) goto L_0x024b
            double[] r1 = r14.x
            r2 = r1[r0]
            r18[r0] = r2
            int r0 = r0 + 1
            goto L_0x023f
        L_0x024b:
            r0 = 0
            return r0
        L_0x024d:
            r9 = 2
        L_0x024e:
            r6 = 0
            r0 = r28
            r1 = r29
            r3 = r31
            r4 = r32
            r5 = r33
            r7 = r34
            r8 = r18
            r11 = 2
            r9 = r39
            int r0 = r0.sweph(r1, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0267
            return r0
        L_0x0267:
            int r0 = r14.iflg
            r0 = r0 & r12
            if (r0 == 0) goto L_0x028b
            r0 = 0
        L_0x026d:
            if (r0 > r11) goto L_0x0279
            r1 = r18[r0]
            r3 = r19[r0]
            double r1 = r1 + r3
            r18[r0] = r1
            int r0 = r0 + 1
            goto L_0x026d
        L_0x0279:
            if (r34 != 0) goto L_0x027d
            if (r22 == 0) goto L_0x028b
        L_0x027d:
            r7 = 3
        L_0x027e:
            r0 = 5
            if (r7 > r0) goto L_0x028b
            r0 = r18[r7]
            r2 = r19[r7]
            double r0 = r0 + r2
            r18[r7] = r0
            int r7 = r7 + 1
            goto L_0x027e
        L_0x028b:
            if (r35 == 0) goto L_0x0298
            r0 = 0
        L_0x028e:
            r1 = 5
            if (r0 > r1) goto L_0x0298
            r2 = r18[r0]
            r35[r0] = r2
            int r0 = r0 + 1
            goto L_0x028e
        L_0x0298:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.sweplan(double, int, int, int, boolean, double[], double[], double[], double[], java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r1 != r6.ibdy) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int sweph(double r40, int r42, int r43, int r44, double[] r45, boolean r46, double[] r47, java.lang.StringBuffer r48) {
        /*
            r39 = this;
            r11 = r39
            r12 = r40
            r1 = r42
            r14 = r43
            r15 = r44
            r10 = r48
            r0 = 6
            double[] r9 = new double[r0]
            double[] r0 = new double[r0]
            swisseph.SwissData r2 = r11.swed
            swisseph.PlanData[] r2 = r2.pldat
            r8 = 0
            r7 = r2[r8]
            swisseph.SwissData r2 = r11.swed
            swisseph.PlanData[] r2 = r2.pldat
            r6 = 10
            r5 = r2[r6]
            swisseph.SwissData r2 = r11.swed
            swisseph.FileData[] r2 = r2.fidat
            r2 = r2[r14]
            r3 = 10000(0x2710, float:1.4013E-41)
            if (r1 <= r3) goto L_0x002e
            r3 = 11
            goto L_0x002f
        L_0x002e:
            r3 = r1
        L_0x002f:
            swisseph.SwissData r6 = r11.swed
            swisseph.PlanData[] r6 = r6.pldat
            r6 = r6[r3]
            if (r46 == 0) goto L_0x003c
            double[] r0 = r6.x
            r18 = r0
            goto L_0x003e
        L_0x003c:
            r18 = r0
        L_0x003e:
            int r0 = r6.xflgs
            r8 = 256(0x100, float:3.59E-43)
            r0 = r0 & r8
            r8 = r15 & 256(0x100, float:3.59E-43)
            r21 = r5
            double r4 = r6.teval
            r22 = r9
            r9 = 2
            int r23 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r23 != 0) goto L_0x0070
            int r4 = r6.iephe
            if (r4 != r9) goto L_0x0070
            if (r8 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r5 = 5
            goto L_0x0071
        L_0x005b:
            r4 = 11
            if (r3 >= r4) goto L_0x0070
            if (r47 == 0) goto L_0x006e
            r0 = 0
        L_0x0062:
            r5 = 5
            if (r0 > r5) goto L_0x006e
            double[] r1 = r6.x
            r2 = r1[r0]
            r47[r0] = r2
            int r0 = r0 + 1
            goto L_0x0062
        L_0x006e:
            r1 = 0
            return r1
        L_0x0070:
            r5 = 5
        L_0x0071:
            swisseph.FilePtr r0 = r2.fptr
            if (r0 == 0) goto L_0x00a3
            double r9 = r2.tfstart
            int r0 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x008a
            double r9 = r2.tfend
            int r0 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x008a
            r4 = 11
            if (r3 != r4) goto L_0x00a5
            int r0 = r6.ibdy
            if (r1 == r0) goto L_0x00a5
            goto L_0x008c
        L_0x008a:
            r4 = 11
        L_0x008c:
            swisseph.FilePtr r0 = r2.fptr     // Catch:{ IOException -> 0x0092 }
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0093
        L_0x0092:
            r0 = move-exception
        L_0x0093:
            r0 = 0
            r2.fptr = r0
            double[] r9 = r6.refep
            if (r9 == 0) goto L_0x009c
            r6.refep = r0
        L_0x009c:
            double[] r9 = r6.segp
            if (r9 == 0) goto L_0x00a5
            r6.segp = r0
            goto L_0x00a5
        L_0x00a3:
            r4 = 11
        L_0x00a5:
            swisseph.FilePtr r0 = r2.fptr
            if (r0 != 0) goto L_0x019e
            swisseph.SwissLib r0 = r11.sl
            swisseph.SweDate r4 = new swisseph.SweDate
            r4.<init>(r12)
            java.lang.String r0 = r0.swi_gen_filename(r4, r1)
            swisseph.SwissData r4 = r11.swed
            java.lang.String r4 = r4.DIR_GLUE
            int r4 = r0.lastIndexOf(r4)
            if (r4 <= 0) goto L_0x00d1
            swisseph.SwissData r4 = r11.swed
            java.lang.String r4 = r4.DIR_GLUE
            int r4 = r0.indexOf(r4)
            r5 = 0
            java.lang.String r4 = r0.substring(r5, r4)
            int r5 = r4.length()
            goto L_0x00d3
        L_0x00d1:
            r4 = r0
            r5 = 0
        L_0x00d3:
            r9 = r0
        L_0x00d4:
            swisseph.FilePtr r0 = r2.fptr
            if (r0 != 0) goto L_0x017f
            swisseph.SwissData r0 = r11.swed     // Catch:{ SwissephException -> 0x00e7 }
            java.lang.String r0 = r0.ephepath     // Catch:{ SwissephException -> 0x00e7 }
            r10 = r48
            swisseph.FilePtr r0 = r11.swi_fopen(r14, r9, r0, r10)     // Catch:{ SwissephException -> 0x00e5 }
            r2.fptr = r0     // Catch:{ SwissephException -> 0x00e5 }
            goto L_0x00ea
        L_0x00e5:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            r10 = r48
        L_0x00ea:
            swisseph.FilePtr r0 = r2.fptr
            if (r0 == 0) goto L_0x00fe
            swisseph.FilePtr r0 = r2.fptr
            if (r0 == 0) goto L_0x00d4
            swisseph.FilePtr r0 = r2.fptr
            java.io.RandomAccessFile r0 = r0.fp
            if (r0 != 0) goto L_0x00d4
            swisseph.FilePtr r0 = r2.fptr
            java.net.Socket r0 = r0.sk
            if (r0 != 0) goto L_0x00d4
        L_0x00fe:
            r25 = r3
            r3 = 10000(0x2710, float:1.4013E-41)
            if (r1 <= r3) goto L_0x017d
            java.lang.String r0 = "s."
            int r16 = r9.indexOf(r0)
            if (r16 > 0) goto L_0x0134
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "."
            int r1 = r9.indexOf(r1)
            r26 = r7
            r7 = 0
            java.lang.String r1 = r9.substring(r7, r1)
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = "se1"
            r3.append(r0)
            java.lang.String r9 = r3.toString()
            r1 = r42
            r3 = r25
            r7 = r26
            goto L_0x00d4
        L_0x0134:
            r26 = r7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r3 = r9.indexOf(r0)
            r7 = 0
            java.lang.String r3 = r9.substring(r7, r3)
            r1.append(r3)
            int r0 = r9.indexOf(r0)
            r24 = 1
            int r0 = r0 + 1
            java.lang.String r0 = r9.substring(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            if (r5 <= 0) goto L_0x017d
            int r1 = r4.length()
            int r1 = swisseph.SMath.min((int) r1, (int) r5)
            r3 = 0
            java.lang.String r1 = r4.substring(r3, r1)
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x017d
            int r1 = r5 + 1
            java.lang.String r9 = r0.substring(r1)
            r1 = r42
            r3 = r25
            r7 = r26
            goto L_0x00d4
        L_0x017d:
            r1 = -2
            return r1
        L_0x017f:
            r10 = r48
            r25 = r3
            r26 = r7
            r24 = 1
            if (r10 == 0) goto L_0x018e
            r9 = 0
            r10.setLength(r9)
            goto L_0x018f
        L_0x018e:
            r9 = 0
        L_0x018f:
            swisseph.SwissData r0 = r11.swed
            swisseph.FileData[] r0 = r0.fidat
            r0 = r0[r14]
            swisseph.SwissData r1 = r11.swed
            int r0 = r0.read_const(r14, r10, r1)
            if (r0 == 0) goto L_0x01a7
            return r0
        L_0x019e:
            r10 = r48
            r25 = r3
            r26 = r7
            r9 = 0
            r24 = 1
        L_0x01a7:
            double r0 = r2.tfstart
            int r3 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x0320
            double r0 = r2.tfend
            int r3 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x01b5
            goto L_0x0320
        L_0x01b5:
            double[] r0 = r6.segp
            if (r0 == 0) goto L_0x01d0
            double r0 = r6.tseg0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x01d0
            double r0 = r6.tseg1
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x01c6
            goto L_0x01d0
        L_0x01c6:
            r14 = r6
            r27 = r21
            r9 = r25
            r28 = r26
            r16 = 5
            goto L_0x0204
        L_0x01d0:
            swisseph.SwissData r0 = r11.swed
            swisseph.FileData[] r0 = r0.fidat
            r1 = r0[r14]
            swisseph.SwissData r2 = r11.swed
            r7 = r25
            r5 = 11
            r3 = r40
            r27 = r21
            r14 = 11
            r16 = 5
            r5 = r7
            r14 = r6
            r9 = 10
            r6 = r43
            r9 = r7
            r28 = r26
            r7 = r48
            int r0 = r1.get_new_segment(r2, r3, r5, r6, r7)
            if (r0 == 0) goto L_0x01f6
            return r0
        L_0x01f6:
            int r0 = r14.iflg
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0200
            r11.rot_back(r9)
            goto L_0x0204
        L_0x0200:
            int r0 = r14.ncoe
            r14.neval = r0
        L_0x0204:
            double r0 = r14.tseg0
            double r0 = r12 - r0
            double r2 = r14.dseg
            double r0 = r0 / r2
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 * r2
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r0 = r0 - r4
            if (r46 != 0) goto L_0x021a
            if (r8 == 0) goto L_0x0217
            goto L_0x021a
        L_0x0217:
            r20 = 0
            goto L_0x021c
        L_0x021a:
            r20 = 1
        L_0x021c:
            r4 = 0
        L_0x021d:
            r8 = 2
            if (r4 > r8) goto L_0x0269
            swisseph.SwissLib r7 = r11.sl
            double[] r8 = r14.segp
            int r5 = r14.ncoe
            int r33 = r4 * r5
            int r5 = r14.neval
            r29 = r7
            r30 = r0
            r32 = r8
            r34 = r5
            double r5 = r29.swi_echeb(r30, r32, r33, r34)
            r18[r4] = r5
            if (r20 == 0) goto L_0x025c
            int r5 = r4 + 3
            swisseph.SwissLib r6 = r11.sl
            double[] r7 = r14.segp
            int r8 = r14.ncoe
            int r33 = r4 * r8
            int r8 = r14.neval
            r29 = r6
            r30 = r0
            r32 = r7
            r34 = r8
            double r6 = r29.swi_edcheb(r30, r32, r33, r34)
            r25 = r0
            double r0 = r14.dseg
            double r6 = r6 / r0
            double r6 = r6 * r2
            r18[r5] = r6
            goto L_0x0264
        L_0x025c:
            r25 = r0
            int r0 = r4 + 3
            r5 = 0
            r18[r0] = r5
        L_0x0264:
            int r4 = r4 + 1
            r0 = r25
            goto L_0x021d
        L_0x0269:
            r0 = 3
            r1 = 10
            if (r9 != r1) goto L_0x02cf
            int r1 = r14.iflg
            r1 = r1 & 8
            if (r1 == 0) goto L_0x02cf
            r8 = r28
            double r6 = r8.teval
            r1 = 0
            r8.teval = r1
            r4 = 0
            r5 = r15 | 256(0x100, float:3.59E-43)
            r17 = 0
            r21 = 0
            r1 = r39
            r2 = r40
            r23 = r5
            r5 = r43
            r35 = r6
            r6 = r23
            r7 = r17
            r37 = r8
            r17 = 0
            r19 = 2
            r8 = r21
            r38 = r9
            r16 = r22
            r9 = r16
            r11 = 1
            r10 = r48
            int r1 = r1.sweph(r2, r4, r5, r6, r7, r8, r9, r10)
            if (r1 == 0) goto L_0x02a9
            return r1
        L_0x02a9:
            r2 = r35
            r1 = r37
            r1.teval = r2
            r8 = 0
        L_0x02b0:
            r1 = 2
            if (r8 > r1) goto L_0x02bd
            r2 = r16[r8]
            r4 = r18[r8]
            double r2 = r2 - r4
            r18[r8] = r2
            int r8 = r8 + 1
            goto L_0x02b0
        L_0x02bd:
            if (r20 == 0) goto L_0x02cd
            r2 = 3
        L_0x02c0:
            r3 = 5
            if (r2 > r3) goto L_0x02d6
            r4 = r16[r2]
            r6 = r18[r2]
            double r4 = r4 - r6
            r18[r2] = r4
            int r2 = r2 + 1
            goto L_0x02c0
        L_0x02cd:
            r3 = 5
            goto L_0x02d6
        L_0x02cf:
            r38 = r9
            r1 = 2
            r3 = 5
            r11 = 1
            r17 = 0
        L_0x02d6:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x02fc
            r4 = r38
            r2 = 11
            if (r4 < r2) goto L_0x02fc
            r8 = 0
        L_0x02e1:
            if (r8 > r1) goto L_0x02ed
            r4 = r18[r8]
            r6 = r45[r8]
            double r4 = r4 + r6
            r18[r8] = r4
            int r8 = r8 + 1
            goto L_0x02e1
        L_0x02ed:
            if (r20 == 0) goto L_0x02fc
        L_0x02f0:
            if (r0 > r3) goto L_0x02fc
            r4 = r18[r0]
            r6 = r45[r0]
            double r4 = r4 + r6
            r18[r0] = r4
            int r0 = r0 + 1
            goto L_0x02f0
        L_0x02fc:
            if (r46 == 0) goto L_0x0313
            r14.teval = r12
            r0 = -1
            r14.xflgs = r0
            r2 = r43
            if (r2 == 0) goto L_0x0311
            if (r2 != r11) goto L_0x030a
            goto L_0x0311
        L_0x030a:
            r1 = r27
            int r0 = r1.iephe
            r14.iephe = r0
            goto L_0x0313
        L_0x0311:
            r14.iephe = r1
        L_0x0313:
            if (r47 == 0) goto L_0x031f
            r8 = 0
        L_0x0316:
            if (r8 > r3) goto L_0x031f
            r0 = r18[r8]
            r47[r8] = r0
            int r8 = r8 + 1
            goto L_0x0316
        L_0x031f:
            return r17
        L_0x0320:
            if (r10 == 0) goto L_0x0375
            double r0 = r2.tfstart
            java.lang.String r3 = ";"
            java.lang.String r4 = "jd "
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x0349
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r12)
            java.lang.String r1 = " < Swiss Eph. lower limit "
            r0.append(r1)
            double r1 = r2.tfstart
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            goto L_0x0365
        L_0x0349:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r12)
            java.lang.String r1 = " > Swiss Eph. upper limit "
            r0.append(r1)
            double r1 = r2.tfend
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
        L_0x0365:
            int r1 = r48.length()
            int r2 = r0.length()
            int r1 = r1 + r2
            r2 = 256(0x100, float:3.59E-43)
            if (r1 >= r2) goto L_0x0375
            r10.append(r0)
        L_0x0375:
            r1 = -2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.sweph(double, int, int, int, double[], boolean, double[], java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public swisseph.FilePtr swi_fopen(int r21, java.lang.String r22, java.lang.String r23, java.lang.StringBuffer r24) throws swisseph.SwissephException {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            r7 = r24
            java.lang.String r4 = "/"
            r5 = 20
            java.lang.String[] r6 = new java.lang.String[r5]
            swisseph.SwissLib r0 = r1.sl
            java.lang.String r8 = ";:"
            r9 = r23
            int r8 = r0.swi_cutstr(r9, r8, r6, r5)
            r9 = 0
            r10 = 0
        L_0x001b:
            java.lang.String r0 = ""
            if (r10 >= r8) goto L_0x00f2
            r11 = r6[r10]
            java.lang.String r12 = "."
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x002a
            goto L_0x004f
        L_0x002a:
            swisseph.SwissData r12 = r1.swed
            java.lang.String r12 = r12.DIR_GLUE
            boolean r12 = r11.endsWith(r12)
            if (r12 != 0) goto L_0x004e
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x004e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            swisseph.SwissData r11 = r1.swed
            java.lang.String r11 = r11.DIR_GLUE
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            goto L_0x004f
        L_0x004e:
            r0 = r11
        L_0x004f:
            int r11 = r0.length()
            int r12 = r22.length()
            int r11 = r11 + r12
            r12 = 256(0x100, float:3.59E-43)
            if (r11 >= r12) goto L_0x006d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r3)
            java.lang.String r0 = r11.toString()
            r15 = r0
            goto L_0x0070
        L_0x006d:
            if (r7 != 0) goto L_0x00dd
            r15 = r0
        L_0x0070:
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            java.lang.String r0 = "r"
            r12.<init>(r15, r0)     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            if (r2 < 0) goto L_0x0082
            swisseph.SwissData r0 = r1.swed     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            swisseph.FileData[] r0 = r0.fidat     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            r0 = r0[r2]     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            r0.fnam = r15     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
        L_0x0082:
            swisseph.FilePtr r0 = new swisseph.FilePtr     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = -1
            int r11 = r1.httpBufSize     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x009f }
            r19 = r11
            r11 = r0
            r23 = r15
            r15 = r16
            r16 = r23
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)     // Catch:{ IOException -> 0x009b, SecurityException -> 0x0099 }
            return r0
        L_0x0099:
            r0 = move-exception
            goto L_0x00a2
        L_0x009b:
            r0 = move-exception
            r11 = r23
            goto L_0x00bf
        L_0x009f:
            r0 = move-exception
            r23 = r15
        L_0x00a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r11 = r23
            r0.append(r11)
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            swisseph.FilePtr r0 = r1.tryFileAsURL(r0, r2)
            if (r0 == 0) goto L_0x00d9
            return r0
        L_0x00bd:
            r0 = move-exception
            r11 = r15
        L_0x00bf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            swisseph.FilePtr r0 = r1.tryFileAsURL(r0, r2)
            if (r0 == 0) goto L_0x00d8
            return r0
        L_0x00d8:
        L_0x00d9:
            int r10 = r10 + 1
            goto L_0x001b
        L_0x00dd:
            r7.setLength(r9)
            java.lang.String r0 = "error: file path and name must be shorter than 256."
            r7.append(r0)
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r3 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r5 = 5
            r6 = -1
            r2 = r0
            r7 = r24
            r2.<init>((double) r3, (int) r5, (int) r6, (java.lang.StringBuffer) r7)
            throw r0
        L_0x00f2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "SwissEph file '"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = "' not found in the paths of: "
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
        L_0x0109:
            if (r3 >= r5) goto L_0x0135
            r4 = r6[r3]
            if (r4 == 0) goto L_0x0132
            r4 = r6[r3]
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0132
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = "'"
            r4.append(r2)
            r2 = r6[r3]
            r4.append(r2)
            java.lang.String r2 = "', "
            r4.append(r2)
            java.lang.String r2 = r4.toString()
        L_0x0132:
            int r3 = r3 + 1
            goto L_0x0109
        L_0x0135:
            if (r7 == 0) goto L_0x013d
            r7.setLength(r9)
            r7.append(r2)
        L_0x013d:
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r3 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r5 = 9
            r6 = -2
            r2 = r0
            r7 = r24
            r2.<init>((double) r3, (int) r5, (int) r6, (java.lang.StringBuffer) r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.swi_fopen(int, java.lang.String, java.lang.String, java.lang.StringBuffer):swisseph.FilePtr");
    }

    private FilePtr tryFileAsURL(String str, int i) {
        Socket socket;
        if (!str.startsWith("http://")) {
            return null;
        }
        try {
            URL url = new URL(str);
            int i2 = 80;
            socket = new Socket(url.getHost(), url.getPort() < 0 ? 80 : url.getPort());
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("HEAD ");
                sb.append(str);
                sb.append(" HTTP/1.1\r\n");
                sb.append("User-Agent: ");
                sb.append(FilePtr.useragent);
                sb.append("\r\n");
                sb.append("Host: ");
                sb.append(url.getHost());
                sb.append(":");
                if (url.getPort() >= 0) {
                    i2 = url.getPort();
                }
                sb.append(i2);
                sb.append("\r\n\r\n");
                String sb2 = sb.toString();
                socket.setSoTimeout(5000);
                InputStream inputStream = socket.getInputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                for (int i3 = 0; i3 < sb2.length(); i3++) {
                    bufferedOutputStream.write((byte) sb2.charAt(i3));
                }
                bufferedOutputStream.flush();
                String str2 = "" + ((char) inputStream.read());
                while (inputStream.available() > 0) {
                    str2 = str2 + ((char) inputStream.read());
                }
                int indexOf = str2.indexOf("Content-Length:");
                if (indexOf < 0) {
                    socket.close();
                    return null;
                } else if (str2.indexOf("Accept-Ranges: none") >= 0) {
                    System.err.println("Server does not accept HTTP range requests. Aborting!");
                    socket.close();
                    return null;
                } else {
                    String substring = str2.substring(indexOf + "Content-Length:".length());
                    long parseLong = Long.parseLong(substring.substring(0, substring.indexOf("\n")).trim());
                    if (i >= 0) {
                        this.swed.fidat[i].fnam = str;
                    }
                    return new FilePtr((RandomAccessFile) null, socket, inputStream, bufferedOutputStream, str, parseLong, this.httpBufSize);
                }
            } catch (IOException | NumberFormatException | SecurityException | MalformedURLException e) {
                try {
                    socket.close();
                } catch (IOException | NullPointerException e2) {
                }
                return null;
            }
        } catch (MalformedURLException e3) {
            socket = null;
            socket.close();
            return null;
        } catch (IOException e4) {
            socket = null;
            socket.close();
            return null;
        } catch (NumberFormatException e5) {
            socket = null;
            socket.close();
            return null;
        } catch (SecurityException e6) {
            socket = null;
            socket.close();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int app_pos_etc_plan(int i, int i2, StringBuffer stringBuffer) {
        char c;
        int i3;
        PlanData planData;
        PlanData planData2;
        double[] dArr;
        double[] dArr2;
        double[] dArr3;
        double[] dArr4;
        int i4;
        double[] dArr5;
        double[] dArr6;
        double d;
        PlanData planData3;
        int i5;
        double d2;
        double[] dArr7;
        Epsilon epsilon;
        int i6;
        double[] dArr8;
        int i7;
        int i8;
        PlanData planData4;
        int i9;
        PlanData planData5;
        int i10 = i;
        int i11 = i2;
        double[] dArr9 = new double[6];
        double[] dArr10 = new double[3];
        double[] dArr11 = new double[6];
        double[] dArr12 = new double[6];
        double[] dArr13 = new double[6];
        double[] dArr14 = new double[6];
        double[] dArr15 = new double[6];
        double[] dArr16 = new double[6];
        PlanData planData6 = this.swed.pldat[0];
        Epsilon epsilon2 = this.swed.oec2000;
        int i12 = i11 & 7;
        if (i10 > 10000) {
            planData = this.swed.pldat[11];
            i3 = 3;
            c = 2;
        } else if (i10 == 12 || i10 == 13 || i10 == 14 || i10 == 15 || i10 == 16 || i10 == 17) {
            planData = this.swed.pldat[i10];
            i3 = 2;
            c = 3;
        } else {
            planData = this.swed.pldat[i10];
            i3 = 0;
            c = 0;
        }
        if ((i11 & -2049 & -4097) == (planData.xflgs & -2049 & -4097)) {
            planData.xflgs = i11;
            planData.iephe = i12;
            return 0;
        }
        for (int i13 = 0; i13 <= 5; i13++) {
            dArr9[i13] = planData.x[i13];
        }
        int i14 = i11 & 8;
        if (i14 != 0 && planData.iephe == 2) {
            for (int i15 = 0; i15 <= 5; i15++) {
                dArr9[i15] = dArr9[i15] - this.swed.pldat[10].x[i15];
            }
        }
        int i16 = i11 & 32768;
        if (i16 != 0) {
            PlanData planData7 = planData;
            i4 = i12;
            double[] dArr17 = dArr16;
            double[] dArr18 = dArr15;
            if (this.swed.topd.teval != planData6.teval || planData6.teval == 0.0d) {
                dArr4 = dArr12;
                planData5 = planData6;
                dArr2 = dArr17;
                planData2 = planData7;
                dArr = dArr18;
                dArr3 = dArr14;
                if (swi_get_observer(planData6.teval, i2, true, dArr11, stringBuffer) != 0) {
                    return -1;
                }
            } else {
                for (int i17 = 0; i17 <= 5; i17++) {
                    dArr11[i17] = this.swed.topd.xobs[i17];
                }
                dArr4 = dArr12;
                planData2 = planData7;
                dArr = dArr18;
                dArr2 = dArr17;
                planData5 = planData6;
                dArr3 = dArr14;
            }
            for (int i18 = 0; i18 <= 5; i18++) {
                dArr11[i18] = dArr11[i18] + planData5.x[i18];
            }
        } else {
            planData2 = planData;
            i4 = i12;
            dArr2 = dArr16;
            dArr = dArr15;
            dArr3 = dArr14;
            dArr4 = dArr12;
            PlanData planData8 = planData6;
            for (int i19 = 0; i19 <= 5; i19++) {
                dArr11[i19] = planData8.x[i19];
            }
        }
        int i20 = i11 & 16;
        if (i20 == 0) {
            PlanData planData9 = planData2;
            int i21 = 2;
            if (planData9.iephe == 2) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            int i22 = i11 & 256;
            double d3 = 2.99792458E8d;
            if (i22 != 0) {
                for (int i23 = 0; i23 <= 2; i23++) {
                    double d4 = dArr9[i23] - dArr9[i23 + 3];
                    dArr[i23] = d4;
                    dArr2[i23] = d4;
                }
                int i24 = 0;
                while (i24 <= i6) {
                    int i25 = 0;
                    while (i25 <= i21) {
                        dArr10[i25] = dArr[i25];
                        if (i14 == 0 && (i11 & 16384) == 0) {
                            dArr10[i25] = dArr10[i25] - (dArr11[i25] - dArr11[i25 + 3]);
                        }
                        i25++;
                        i21 = 2;
                    }
                    double sqrt = ((SMath.sqrt(this.sl.square_sum(dArr10)) * 1.4959787066E11d) / 2.99792458E8d) / 86400.0d;
                    for (int i26 = 0; i26 <= 2; i26++) {
                        dArr[i26] = dArr2[i26] - (planData9.x[i26 + 3] * sqrt);
                    }
                    i24++;
                    i21 = 2;
                }
                for (int i27 = 0; i27 <= 2; i27++) {
                    dArr[i27] = dArr2[i27] - dArr[i27];
                }
            }
            d = 0.0d;
            double d5 = 0.0d;
            int i28 = 0;
            while (i28 <= i6) {
                for (int i29 = 0; i29 <= 2; i29++) {
                    dArr10[i29] = dArr9[i29];
                    if (i14 == 0 && (i11 & 16384) == 0) {
                        dArr10[i29] = dArr10[i29] - dArr11[i29];
                    }
                }
                d5 = ((SMath.sqrt(this.sl.square_sum(dArr10)) * 1.4959787066E11d) / d3) / 86400.0d;
                d = planData9.teval - d5;
                for (int i30 = 0; i30 <= 2; i30++) {
                    dArr9[i30] = planData9.x[i30] - (planData9.x[i30 + 3] * d5);
                }
                i28++;
                d3 = 2.99792458E8d;
            }
            if (i22 != 0) {
                for (int i31 = 0; i31 <= 2; i31++) {
                    dArr[i31] = (planData9.x[i31] - dArr9[i31]) - dArr[i31];
                }
            }
            if (i4 == 2) {
                i7 = i22;
                dArr8 = dArr13;
                PlanData planData10 = planData9;
                dArr6 = dArr4;
                if (c == 0) {
                    dArr5 = dArr11;
                    i8 = sweplan(d, i, i3, i2, false, dArr9, dArr8, dArr3, (double[]) null, stringBuffer);
                    planData4 = planData10;
                } else {
                    dArr5 = dArr11;
                    planData4 = planData10;
                    i8 = sweplan(d, 0, 0, i2, false, dArr8, (double[]) null, dArr3, (double[]) null, stringBuffer);
                    if (i8 == 0) {
                        i8 = sweph(d, i, i3, i2, dArr3, false, dArr9, stringBuffer);
                    }
                }
                if (i8 != 0) {
                    return i8;
                }
            } else if (i22 == 0 || (i11 & 16392) != 0) {
                i7 = i22;
                dArr8 = dArr13;
                planData3 = planData9;
                dArr6 = dArr4;
                dArr5 = dArr11;
            } else {
                if (c == 0) {
                    i7 = i22;
                    i9 = this.smosh.swi_moshplan(d, i, false, dArr2, dArr13, stringBuffer);
                    dArr8 = dArr13;
                    planData3 = planData9;
                    dArr6 = dArr4;
                } else {
                    i7 = i22;
                    dArr8 = dArr13;
                    planData3 = planData9;
                    dArr6 = dArr4;
                    i9 = sweph(d, i, i3, i2, (double[]) null, false, dArr2, stringBuffer);
                    if (i9 == 0) {
                        i9 = this.smosh.swi_moshplan(d, 0, false, dArr8, dArr8, stringBuffer);
                    }
                }
                if (i9 != 0) {
                    return i9;
                }
                for (int i32 = 3; i32 <= 5; i32++) {
                    dArr9[i32] = dArr2[i32];
                }
                dArr5 = dArr11;
            }
            if (i14 == 0) {
                i5 = 5;
            } else if (planData3.iephe == 2) {
                int i33 = 0;
                while (true) {
                    i5 = 5;
                    if (i33 > 5) {
                        break;
                    }
                    dArr9[i33] = dArr9[i33] - this.swed.pldat[10].x[i33];
                    i33++;
                }
            } else {
                i5 = 5;
            }
            if (i7 != 0) {
                if (i16 == 0) {
                    for (int i34 = 0; i34 <= i5; i34++) {
                        dArr6[i34] = dArr8[i34];
                    }
                } else if (swi_get_observer(d, i2, false, dArr6, stringBuffer) != 0) {
                    return -1;
                } else {
                    for (int i35 = 0; i35 <= i5; i35++) {
                        dArr6[i35] = dArr6[i35] + dArr8[i35];
                    }
                }
            }
            d2 = d5;
        } else {
            dArr5 = dArr11;
            dArr6 = dArr4;
            planData3 = planData2;
            i5 = 5;
            d2 = 0.0d;
            d = 0.0d;
        }
        if (i14 == 0 && (i11 & 16384) == 0) {
            for (int i36 = 0; i36 <= i5; i36++) {
                dArr9[i36] = dArr9[i36] - dArr5[i36];
            }
            dArr7 = dArr5;
            if (i20 == 0 && (i11 & 256) != 0) {
                for (int i37 = 3; i37 <= i5; i37++) {
                    dArr9[i37] = dArr9[i37] - dArr[i37 - 3];
                }
            }
        } else {
            dArr7 = dArr5;
        }
        int i38 = i11 & 256;
        if (i38 == 0) {
            for (int i39 = 3; i39 <= i5; i39++) {
                dArr9[i39] = 0.0d;
            }
        }
        if (i20 == 0 && (i11 & 512) == 0) {
            swi_deflect_light(dArr9, 0, d2, i2);
        }
        if (i20 == 0 && (i11 & 1024) == 0) {
            swi_aberr_light(dArr9, dArr7, i11);
            if (i38 != 0) {
                for (int i40 = 3; i40 <= i5; i40++) {
                    dArr9[i40] = dArr9[i40] + (dArr7[i40] - dArr6[i40]);
                }
            }
        }
        if (i38 == 0) {
            for (int i41 = 3; i41 <= i5; i41++) {
                dArr9[i41] = 0.0d;
            }
        }
        if ((131072 & i11) == 0 && this.swed.jpldenum >= 403) {
            this.sl.swi_bias(dArr9, d, i2, false);
        }
        for (int i42 = 0; i42 <= i5; i42++) {
            dArr2[i42] = dArr9[i42];
        }
        if ((i11 & 32) == 0) {
            this.sl.swi_precess(dArr9, planData3.teval, i2, -1);
            if (i38 != 0) {
                swi_precess_speed(dArr9, planData3.teval, i2, -1);
            }
            epsilon = this.swed.oec;
        } else {
            epsilon = this.swed.oec2000;
        }
        return app_pos_rest(planData3, i2, dArr9, dArr2, epsilon, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int app_pos_rest(PlanData planData, int i, double[] dArr, double[] dArr2, Epsilon epsilon, StringBuffer stringBuffer) {
        int i2;
        int i3;
        PlanData planData2 = planData;
        int i4 = i;
        double[] dArr3 = dArr;
        Epsilon epsilon2 = epsilon;
        int i5 = i4 & 64;
        if (i5 == 0) {
            swi_nutate(dArr3, 0, i4, false);
        }
        for (int i6 = 0; i6 <= 5; i6++) {
            planData2.xreturn[i6 + 18] = dArr3[i6];
        }
        this.sl.swi_coortrf2(dArr, dArr, epsilon2.seps, epsilon2.ceps);
        int i7 = i4 & 256;
        if (i7 != 0) {
            this.sl.swi_coortrf2(dArr, 3, dArr, 3, epsilon2.seps, epsilon2.ceps);
        }
        if (i5 == 0) {
            SwissLib swissLib = this.sl;
            double d = this.swed.nut.snut;
            double d2 = d;
            int i8 = i7;
            swissLib.swi_coortrf2(dArr, dArr, d2, this.swed.nut.cnut);
            if (i8 != 0) {
                i2 = 5;
                this.sl.swi_coortrf2(dArr, 3, dArr, 3, this.swed.nut.snut, this.swed.nut.cnut);
            } else {
                i2 = 5;
            }
        } else {
            i2 = 5;
        }
        for (int i9 = 0; i9 <= i2; i9++) {
            planData2.xreturn[i9 + 6] = dArr3[i9];
        }
        if ((65536 & i4) == 0) {
            i3 = 0;
        } else if ((this.swed.sidd.sid_mode & 256) != 0) {
            i3 = 0;
            if (swi_trop_ra2sid_lon(dArr2, planData2.xreturn, 6, planData2.xreturn, 18, i, stringBuffer) != 0) {
                return -1;
            }
        } else {
            i3 = 0;
            if ((this.swed.sidd.sid_mode & 512) != 0) {
                if (swi_trop_ra2sid_lon_sosy(dArr2, planData2.xreturn, 6, planData2.xreturn, 18, i, stringBuffer) != 0) {
                    return -1;
                }
            } else {
                this.sl.swi_cartpol_sp(planData2.xreturn, 6, planData2.xreturn, 0);
                double[] dArr4 = planData2.xreturn;
                dArr4[0] = dArr4[0] - (swe_get_ayanamsa(planData2.teval) * 0.0174532925199433d);
                this.sl.swi_polcart_sp(planData2.xreturn, 0, planData2.xreturn, 6);
            }
        }
        this.sl.swi_cartpol_sp(planData2.xreturn, 18, planData2.xreturn, 12);
        this.sl.swi_cartpol_sp(planData2.xreturn, 6, planData2.xreturn, i3);
        for (int i10 = 0; i10 < 2; i10++) {
            double[] dArr5 = planData2.xreturn;
            dArr5[i10] = dArr5[i10] * 57.2957795130823d;
            double[] dArr6 = planData2.xreturn;
            int i11 = i10 + 3;
            dArr6[i11] = dArr6[i11] * 57.2957795130823d;
            double[] dArr7 = planData2.xreturn;
            int i12 = i10 + 12;
            dArr7[i12] = dArr7[i12] * 57.2957795130823d;
            double[] dArr8 = planData2.xreturn;
            int i13 = i10 + 15;
            dArr8[i13] = dArr8[i13] * 57.2957795130823d;
        }
        planData2.xflgs = i4;
        planData2.iephe = i4 & 7;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int swi_trop_ra2sid_lon(double[] dArr, double[] dArr2, double[] dArr3, int i, StringBuffer stringBuffer) {
        return swi_trop_ra2sid_lon(dArr, dArr2, 0, dArr3, 0, i, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int swi_trop_ra2sid_lon(double[] dArr, double[] dArr2, int i, double[] dArr3, int i2, int i3, StringBuffer stringBuffer) {
        int i4 = i3;
        double[] dArr4 = new double[6];
        SidData sidData = this.swed.sidd;
        Epsilon epsilon = new Epsilon();
        for (int i5 = 0; i5 <= 5; i5++) {
            dArr4[i5] = dArr[i5];
        }
        if (sidData.t0 != 2451545.0d) {
            double[] dArr5 = dArr4;
            this.sl.swi_precess(dArr5, sidData.t0, 0, -1);
            this.sl.swi_precess(dArr5, 3, sidData.t0, 0, -1);
        }
        for (int i6 = 0; i6 <= 5; i6++) {
            dArr3[i6 + i2] = dArr4[i6];
        }
        calc_epsilon(this.swed.sidd.t0, i4, epsilon);
        this.sl.swi_coortrf2(dArr4, dArr4, epsilon.seps, epsilon.ceps);
        if ((i4 & 256) != 0) {
            this.sl.swi_coortrf2(dArr4, 3, dArr4, 3, epsilon.seps, epsilon.ceps);
        }
        this.sl.swi_cartpol_sp(dArr4, dArr4);
        dArr4[0] = dArr4[0] - (sidData.ayan_t0 * 0.0174532925199433d);
        this.sl.swi_polcart_sp(dArr4, 0, dArr2, i);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swi_trop_ra2sid_lon_sosy(double[] dArr, double[] dArr2, double[] dArr3, int i, StringBuffer stringBuffer) {
        return swi_trop_ra2sid_lon_sosy(dArr, dArr2, 0, dArr3, 0, i, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int swi_trop_ra2sid_lon_sosy(double[] dArr, double[] dArr2, int i, double[] dArr3, int i2, int i3, StringBuffer stringBuffer) {
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        SidData sidData = this.swed.sidd;
        Epsilon epsilon = this.swed.oec2000;
        for (int i4 = 0; i4 <= 5; i4++) {
            dArr4[i4] = dArr[i4];
        }
        this.sl.swi_coortrf2(dArr4, dArr4, epsilon.seps, epsilon.ceps);
        if ((i3 & 256) != 0) {
            this.sl.swi_coortrf2(dArr4, 3, dArr4, 3, epsilon.seps, epsilon.ceps);
        }
        this.sl.swi_cartpol_sp(dArr4, dArr4);
        dArr4[0] = dArr4[0] - 1.877670046803984d;
        this.sl.swi_polcart_sp(dArr4, dArr4);
        this.sl.swi_coortrf(dArr4, dArr4, 0.027553530354527005d);
        this.sl.swi_coortrf(dArr4, 3, dArr4, 3, 0.027553530354527005d);
        this.sl.swi_cartpol_sp(dArr4, dArr4);
        dArr5[0] = 1.0d;
        dArr5[2] = 0.0d;
        dArr5[1] = 0.0d;
        if (sidData.t0 != 2451545.0d) {
            this.sl.swi_precess(dArr5, sidData.t0, 0, 1);
        }
        this.sl.swi_coortrf2(dArr5, dArr5, epsilon.seps, epsilon.ceps);
        this.sl.swi_cartpol(dArr5, dArr5);
        dArr5[0] = dArr5[0] - 1.877670046803984d;
        this.sl.swi_polcart(dArr5, dArr5);
        this.sl.swi_coortrf(dArr5, dArr5, 0.027553530354527005d);
        this.sl.swi_cartpol(dArr5, dArr5);
        dArr4[0] = dArr4[0] - dArr5[0];
        dArr4[0] = dArr4[0] * 57.2957795130823d;
        dArr4[0] = dArr4[0] - sidData.ayan_t0;
        dArr4[0] = this.sl.swe_degnorm(dArr4[0]) * 0.0174532925199433d;
        this.sl.swi_polcart_sp(dArr4, 0, dArr2, i);
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2 A[LOOP:2: B:28:0x00c0->B:29:0x00c2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int app_pos_etc_plan_osc(int r40, int r41, int r42, java.lang.StringBuffer r43) {
        /*
            r39 = this;
            r12 = r39
            r13 = r42
            r0 = 6
            double[] r14 = new double[r0]
            r15 = 3
            double[] r7 = new double[r15]
            double[] r11 = new double[r0]
            double[] r10 = new double[r0]
            double[] r9 = new double[r0]
            double[] r8 = new double[r0]
            double[] r6 = new double[r15]
            r6 = {0, 0, 0} // fill-array
            double[] r5 = new double[r0]
            double[] r4 = new double[r0]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r3 = r0[r41]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r16 = 0
            r1 = r0[r16]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r2 = 10
            r0 = r0[r2]
            swisseph.SwissData r2 = r12.swed
            swisseph.Epsilon r2 = r2.oec2000
            r2 = r13 & 4
            if (r2 == 0) goto L_0x003e
            r17 = 4
            goto L_0x0047
        L_0x003e:
            r17 = r13 & 2
            if (r17 == 0) goto L_0x0045
            r17 = 2
            goto L_0x0047
        L_0x0045:
            r17 = 2
        L_0x0047:
            r15 = 0
        L_0x0048:
            r19 = r4
            r4 = 5
            if (r15 > r4) goto L_0x0058
            double[] r4 = r3.x
            r20 = r4[r15]
            r14[r15] = r20
            int r15 = r15 + 1
            r4 = r19
            goto L_0x0048
        L_0x0058:
            r15 = 32768(0x8000, float:4.5918E-41)
            r15 = r15 & r13
            r20 = -1
            r21 = 0
            if (r15 == 0) goto L_0x00d8
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            r23 = r5
            double r4 = r0.teval
            r25 = r3
            double r2 = r1.teval
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x009d
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            double r2 = r0.teval
            int r0 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x007e
            r4 = 5
            goto L_0x009e
        L_0x007e:
            r0 = 0
        L_0x007f:
            r4 = 5
            if (r0 > r4) goto L_0x008f
            swisseph.SwissData r2 = r12.swed
            swisseph.TopoData r2 = r2.topd
            double[] r2 = r2.xobs
            r26 = r2[r0]
            r23[r0] = r26
            int r0 = r0 + 1
            goto L_0x007f
        L_0x008f:
            r28 = r1
            r24 = r15
            r26 = r23
            r15 = r25
            r23 = r6
            r25 = r9
            r9 = 5
            goto L_0x00bf
        L_0x009d:
            r4 = 5
        L_0x009e:
            double r2 = r1.teval
            r5 = 1
            r0 = r39
            r28 = r1
            r1 = r2
            r24 = r15
            r15 = r25
            r3 = r42
            r25 = r9
            r9 = 5
            r4 = r5
            r26 = r23
            r5 = r26
            r23 = r6
            r6 = r43
            int r0 = r0.swi_get_observer(r1, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x00bf
            return r20
        L_0x00bf:
            r0 = 0
        L_0x00c0:
            if (r0 > r9) goto L_0x00d5
            r6 = r26
            r1 = r6[r0]
            r3 = r28
            double[] r4 = r3.x
            r26 = r4[r0]
            double r1 = r1 + r26
            r6[r0] = r1
            int r0 = r0 + 1
            r26 = r6
            goto L_0x00c0
        L_0x00d5:
            r6 = r26
            goto L_0x0114
        L_0x00d8:
            r23 = r6
            r25 = r9
            r24 = r15
            r9 = 5
            r15 = r3
            r6 = r5
            r3 = r1
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x00ee
            r0 = 0
        L_0x00e7:
            if (r0 > r9) goto L_0x0114
            r6[r0] = r21
            int r0 = r0 + 1
            goto L_0x00e7
        L_0x00ee:
            r1 = r13 & 8
            if (r1 == 0) goto L_0x0108
            if (r2 == 0) goto L_0x00fc
            r0 = 0
        L_0x00f5:
            if (r0 > r9) goto L_0x0114
            r6[r0] = r21
            int r0 = r0 + 1
            goto L_0x00f5
        L_0x00fc:
            r1 = 0
        L_0x00fd:
            if (r1 > r9) goto L_0x0114
            double[] r2 = r0.x
            r3 = r2[r1]
            r6[r1] = r3
            int r1 = r1 + 1
            goto L_0x00fd
        L_0x0108:
            r0 = 0
        L_0x0109:
            if (r0 > r9) goto L_0x0114
            double[] r1 = r3.x
            r4 = r1[r0]
            r6[r0] = r4
            int r0 = r0 + 1
            goto L_0x0109
        L_0x0114:
            r26 = r13 & 16
            if (r26 != 0) goto L_0x0281
            r0 = r13 & 256(0x100, float:3.59E-43)
            r3 = 4733809291562057728(0x41b1de784a000000, double:2.99792458E8)
            r27 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            r5 = 1
            if (r0 == 0) goto L_0x019d
            r9 = 0
        L_0x0129:
            r1 = 2
            if (r9 > r1) goto L_0x013b
            r1 = r14[r9]
            int r31 = r9 + 3
            r31 = r14[r31]
            double r1 = r1 - r31
            r23[r9] = r1
            r8[r9] = r1
            int r9 = r9 + 1
            goto L_0x0129
        L_0x013b:
            r31 = r21
            r1 = 0
        L_0x013e:
            if (r1 > r5) goto L_0x018e
            r2 = 0
        L_0x0141:
            r9 = 2
            if (r2 > r9) goto L_0x0161
            r31 = r23[r2]
            r7[r2] = r31
            r9 = r13 & 8
            if (r9 != 0) goto L_0x015e
            r9 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r9 != 0) goto L_0x015e
            r31 = r7[r2]
            r33 = r6[r2]
            int r9 = r2 + 3
            r35 = r6[r9]
            double r33 = r33 - r35
            double r31 = r31 - r33
            r7[r2] = r31
        L_0x015e:
            int r2 = r2 + 1
            goto L_0x0141
        L_0x0161:
            swisseph.SwissLib r2 = r12.sl
            double r31 = r2.square_sum(r7)
            double r31 = swisseph.SMath.sqrt(r31)
            double r31 = r31 * r27
            double r31 = r31 / r3
            r29 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r31 = r31 / r29
            r2 = 0
        L_0x0177:
            r9 = 2
            if (r2 > r9) goto L_0x018b
            r33 = r8[r2]
            double[] r9 = r15.x
            int r35 = r2 + 3
            r35 = r9[r35]
            double r35 = r35 * r31
            double r33 = r33 - r35
            r23[r2] = r33
            int r2 = r2 + 1
            goto L_0x0177
        L_0x018b:
            int r1 = r1 + 1
            goto L_0x013e
        L_0x018e:
            r1 = 0
        L_0x018f:
            r2 = 2
            if (r1 > r2) goto L_0x019f
            r33 = r8[r1]
            r35 = r23[r1]
            double r33 = r33 - r35
            r23[r1] = r33
            int r1 = r1 + 1
            goto L_0x018f
        L_0x019d:
            r31 = r21
        L_0x019f:
            r33 = r21
            r1 = 0
        L_0x01a2:
            if (r1 > r5) goto L_0x01f7
            r2 = 0
        L_0x01a5:
            r9 = 2
            if (r2 > r9) goto L_0x01bf
            r31 = r14[r2]
            r7[r2] = r31
            r9 = r13 & 8
            if (r9 != 0) goto L_0x01bc
            r9 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r9 != 0) goto L_0x01bc
            r31 = r7[r2]
            r33 = r6[r2]
            double r31 = r31 - r33
            r7[r2] = r31
        L_0x01bc:
            int r2 = r2 + 1
            goto L_0x01a5
        L_0x01bf:
            swisseph.SwissLib r2 = r12.sl
            double r31 = r2.square_sum(r7)
            double r31 = swisseph.SMath.sqrt(r31)
            double r31 = r31 * r27
            double r31 = r31 / r3
            r29 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r33 = r31 / r29
            r2 = 0
        L_0x01d6:
            r9 = 2
            if (r2 > r9) goto L_0x01f2
            double[] r9 = r15.x
            r31 = r9[r2]
            double[] r9 = r15.x
            int r35 = r2 + 3
            r36 = r9[r35]
            double r36 = r36 * r33
            double r31 = r31 - r36
            r14[r2] = r31
            double[] r9 = r15.x
            r31 = r9[r35]
            r14[r35] = r31
            int r2 = r2 + 1
            goto L_0x01d6
        L_0x01f2:
            int r1 = r1 + 1
            r31 = r33
            goto L_0x01a2
        L_0x01f7:
            if (r0 == 0) goto L_0x0279
            r0 = 0
        L_0x01fa:
            r1 = 2
            if (r0 > r1) goto L_0x020e
            double[] r2 = r15.x
            r3 = r2[r0]
            r27 = r14[r0]
            double r3 = r3 - r27
            r27 = r23[r0]
            double r3 = r3 - r27
            r23[r0] = r3
            int r0 = r0 + 1
            goto L_0x01fa
        L_0x020e:
            double r0 = r15.teval
            double r27 = r0 - r31
            r3 = 0
            r7 = 0
            r0 = r39
            r1 = r27
            r4 = r17
            r5 = r42
            r9 = r6
            r6 = r7
            r7 = r11
            r17 = r8
            r8 = r11
            r38 = r9
            r18 = r25
            r9 = r10
            r25 = r10
            r10 = r18
            r18 = r11
            r11 = r43
            int r0 = r0.main_planet_bary(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            swisseph.SwephMosh r1 = r12.smosh
            int r5 = r40 + -40
            r2 = r27
            r4 = r14
            r6 = r41
            r7 = r18
            r8 = r25
            r9 = r43
            int r1 = r1.swi_osc_el_plan(r2, r4, r5, r6, r7, r8, r9)
            if (r1 == 0) goto L_0x0249
            return r20
        L_0x0249:
            if (r0 == 0) goto L_0x024c
            return r0
        L_0x024c:
            if (r24 == 0) goto L_0x026e
            r4 = 0
            r0 = r39
            r1 = r27
            r3 = r42
            r5 = r19
            r6 = r43
            int r0 = r0.swi_get_observer(r1, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0260
            return r20
        L_0x0260:
            r0 = 0
        L_0x0261:
            r6 = 5
            if (r0 > r6) goto L_0x027e
            r1 = r19[r0]
            r3 = r18[r0]
            double r1 = r1 + r3
            r19[r0] = r1
            int r0 = r0 + 1
            goto L_0x0261
        L_0x026e:
            r6 = 5
            r0 = 0
        L_0x0270:
            if (r0 > r6) goto L_0x027e
            r1 = r18[r0]
            r19[r0] = r1
            int r0 = r0 + 1
            goto L_0x0270
        L_0x0279:
            r38 = r6
            r17 = r8
            r6 = 5
        L_0x027e:
            r3 = r33
            goto L_0x0288
        L_0x0281:
            r38 = r6
            r17 = r8
            r6 = 5
            r3 = r21
        L_0x0288:
            r0 = 0
        L_0x0289:
            if (r0 > r6) goto L_0x0297
            r1 = r14[r0]
            r7 = r38
            r8 = r7[r0]
            double r1 = r1 - r8
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x0289
        L_0x0297:
            r7 = r38
            if (r26 != 0) goto L_0x02ae
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x02ae
            r0 = 3
        L_0x02a0:
            if (r0 > r6) goto L_0x02ae
            r1 = r14[r0]
            int r5 = r0 + -3
            r8 = r23[r5]
            double r1 = r1 - r8
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x02a0
        L_0x02ae:
            r8 = r13 & 256(0x100, float:3.59E-43)
            if (r8 != 0) goto L_0x02ba
            r0 = 3
        L_0x02b3:
            if (r0 > r6) goto L_0x02ba
            r14[r0] = r21
            int r0 = r0 + 1
            goto L_0x02b3
        L_0x02ba:
            if (r26 != 0) goto L_0x02c9
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x02c9
            r2 = 0
            r0 = r39
            r1 = r14
            r5 = r42
            r0.swi_deflect_light(r1, r2, r3, r5)
        L_0x02c9:
            if (r26 != 0) goto L_0x02e4
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x02e4
            r12.swi_aberr_light(r14, r7, r13)
            if (r8 == 0) goto L_0x02e4
            r0 = 3
        L_0x02d5:
            if (r0 > r6) goto L_0x02e4
            r1 = r14[r0]
            r3 = r7[r0]
            r9 = r19[r0]
            double r3 = r3 - r9
            double r1 = r1 + r3
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x02d5
        L_0x02e4:
            r0 = 0
        L_0x02e5:
            if (r0 > r6) goto L_0x02ee
            r1 = r14[r0]
            r17[r0] = r1
            int r0 = r0 + 1
            goto L_0x02e5
        L_0x02ee:
            r0 = r13 & 32
            if (r0 != 0) goto L_0x0310
            swisseph.SwissLib r0 = r12.sl
            double r2 = r15.teval
            r5 = -1
            r1 = r14
            r4 = r42
            r0.swi_precess(r1, r2, r4, r5)
            if (r8 == 0) goto L_0x030a
            double r2 = r15.teval
            r5 = -1
            r0 = r39
            r1 = r14
            r4 = r42
            r0.swi_precess_speed(r1, r2, r4, r5)
        L_0x030a:
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec
            r5 = r0
            goto L_0x0315
        L_0x0310:
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec2000
            r5 = r0
        L_0x0315:
            r0 = r39
            r1 = r15
            r2 = r42
            r3 = r14
            r4 = r17
            r6 = r43
            int r0 = r0.app_pos_rest(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.app_pos_etc_plan_osc(int, int, int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public void swi_precess_speed(double[] dArr, double d, int i, int i2) {
        swi_precess_speed(dArr, 0, d, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void swi_precess_speed(double[] dArr, int i, double d, int i2, int i3) {
        double d2;
        Epsilon epsilon;
        double[] dArr2 = dArr;
        int i4 = i;
        double d3 = d;
        double[] dArr3 = new double[1];
        double[] dArr4 = new double[1];
        if (i3 == -1) {
            epsilon = this.swed.oec;
            d2 = 1.0d;
        } else {
            d2 = -1.0d;
            epsilon = this.swed.oec2000;
        }
        int i5 = i4 + 3;
        double[] dArr5 = dArr;
        this.sl.swi_precess(dArr5, i5, d, i2, i3);
        double[] dArr6 = dArr;
        double[] dArr7 = dArr4;
        Epsilon epsilon2 = epsilon;
        this.sl.swi_coortrf2(dArr5, i, dArr6, i, epsilon.seps, epsilon.ceps);
        this.sl.swi_coortrf2(dArr5, i5, dArr6, i5, epsilon2.seps, epsilon2.ceps);
        this.sl.swi_cartpol_sp(dArr2, i4, dArr2, i4);
        this.sl.swi_ldp_peps(d3, dArr3, (double[]) null);
        double[] dArr8 = dArr7;
        this.sl.swi_ldp_peps(d3 + 1.0d, dArr8, (double[]) null);
        dArr2[3] = dArr2[3] + ((dArr8[0] - dArr3[0]) * d2);
        this.sl.swi_polcart_sp(dArr2, i4, dArr2, i4);
        double[] dArr9 = dArr;
        this.sl.swi_coortrf2(dArr, i, dArr9, i, -epsilon2.seps, epsilon2.ceps);
        this.sl.swi_coortrf2(dArr, i5, dArr9, i5, -epsilon2.seps, epsilon2.ceps);
    }

    /* access modifiers changed from: package-private */
    public void swi_nutate(double[] dArr, int i, int i2, boolean z) {
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        for (int i3 = 0; i3 <= 2; i3++) {
            if (z) {
                dArr2[i3] = (dArr[i + 0] * this.swed.nut.matrix[i3][0]) + (dArr[i + 1] * this.swed.nut.matrix[i3][1]) + (dArr[i + 2] * this.swed.nut.matrix[i3][2]);
            } else {
                dArr2[i3] = (dArr[i + 0] * this.swed.nut.matrix[0][i3]) + (dArr[i + 1] * this.swed.nut.matrix[1][i3]) + (dArr[i + 2] * this.swed.nut.matrix[2][i3]);
            }
        }
        if ((i2 & 256) != 0) {
            for (int i4 = 0; i4 <= 2; i4++) {
                if (z) {
                    dArr2[i4 + 3] = (dArr[i + 3] * this.swed.nut.matrix[i4][0]) + (dArr[i + 4] * this.swed.nut.matrix[i4][1]) + (dArr[i + 5] * this.swed.nut.matrix[i4][2]);
                } else {
                    dArr2[i4 + 3] = (dArr[i + 3] * this.swed.nut.matrix[0][i4]) + (dArr[i + 4] * this.swed.nut.matrix[1][i4]) + (dArr[i + 5] * this.swed.nut.matrix[2][i4]);
                }
            }
            for (int i5 = 0; i5 <= 2; i5++) {
                if (z) {
                    dArr3[i5] = (dArr[i + 0] * this.swed.nutv.matrix[i5][0]) + (dArr[i + 1] * this.swed.nutv.matrix[i5][1]) + (dArr[i + 2] * this.swed.nutv.matrix[i5][2]);
                } else {
                    dArr3[i5] = (dArr[i + 0] * this.swed.nutv.matrix[0][i5]) + (dArr[i + 1] * this.swed.nutv.matrix[1][i5]) + (dArr[i + 2] * this.swed.nutv.matrix[2][i5]);
                }
                int i6 = i5 + 3;
                dArr[i6 + i] = dArr2[i6] + ((dArr2[i5] - dArr3[i5]) / 1.0E-4d);
            }
        }
        for (int i7 = 0; i7 <= 2; i7++) {
            dArr[i7 + i] = dArr2[i7];
        }
    }

    /* access modifiers changed from: package-private */
    public void swi_aberr_light(double[] dArr, double[] dArr2, int i) {
        swi_aberr_light(dArr, 0, dArr2, i);
    }

    /* access modifiers changed from: package-private */
    public void swi_aberr_light(double[] dArr, int i, double[] dArr2, int i2) {
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        for (int i3 = 0; i3 <= 5; i3++) {
            double d = dArr[i3 + i];
            dArr3[i3] = d;
            dArr5[i3] = d;
        }
        double sqrt = SMath.sqrt(this.sl.square_sum(dArr5));
        for (int i4 = 0; i4 <= 2; i4++) {
            dArr4[i4] = (((dArr2[i4 + 3] / 24.0d) / 3600.0d) / 2.99792458E8d) * 1.4959787066E11d;
        }
        double sqrt2 = SMath.sqrt(1.0d - this.sl.square_sum(dArr4));
        double dot_prod = dot_prod(dArr5, dArr4) / sqrt;
        double d2 = sqrt2 + 1.0d;
        double d3 = (dot_prod / d2) + 1.0d;
        for (int i5 = 0; i5 <= 2; i5++) {
            int i6 = i5 + i;
            dArr[i6] = ((dArr[i6] * sqrt2) + ((d3 * sqrt) * dArr4[i5])) / (dot_prod + 1.0d);
        }
        if ((i2 & 256) != 0) {
            for (int i7 = 0; i7 <= 2; i7++) {
                dArr5[i7] = dArr3[i7] - (1.0E-4d * dArr3[i7 + 3]);
            }
            double sqrt3 = SMath.sqrt(this.sl.square_sum(dArr5));
            double dot_prod2 = dot_prod(dArr5, dArr4) / sqrt3;
            double d4 = (dot_prod2 / d2) + 1.0d;
            for (int i8 = 0; i8 <= 2; i8++) {
                dArr6[i8] = ((dArr5[i8] * sqrt2) + ((d4 * sqrt3) * dArr4[i8])) / (dot_prod2 + 1.0d);
            }
            for (int i9 = 0; i9 <= 2; i9++) {
                int i10 = i9 + 3 + i;
                dArr[i10] = dArr[i10] + (((dArr[i9 + i] - dArr3[i9]) - (dArr6[i9] - dArr5[i9])) / 1.0E-4d);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void swi_deflect_light(double[] dArr, int i, double d, int i2) {
        double[] dArr2;
        double[] dArr3;
        double d2;
        double[] dArr4;
        double d3;
        int i3 = i2;
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        double[] dArr8 = new double[6];
        double[] dArr9 = new double[6];
        double[] dArr10 = new double[6];
        double[] dArr11 = new double[6];
        PlanData planData = this.swed.pldat[0];
        PlanData planData2 = this.swed.pldat[10];
        int i4 = planData.iephe;
        for (int i5 = 0; i5 <= 5; i5++) {
            dArr11[i5] = planData.x[i5];
        }
        if ((32768 & i3) != 0) {
            for (int i6 = 0; i6 <= 5; i6++) {
                dArr11[i6] = dArr11[i6] + this.swed.topd.xobs[i6];
            }
        }
        for (int i7 = 0; i7 <= 2; i7++) {
            dArr6[i7] = dArr[i7 + i];
        }
        if (i4 == 2) {
            for (int i8 = 0; i8 <= 2; i8++) {
                dArr7[i8] = dArr11[i8] - planData2.x[i8];
            }
        } else {
            for (int i9 = 0; i9 <= 2; i9++) {
                dArr7[i9] = dArr11[i9];
            }
        }
        if (i4 == 2) {
            for (int i10 = 0; i10 <= 2; i10++) {
                dArr10[i10] = planData2.x[i10] - (planData2.x[i10 + 3] * d);
            }
            for (int i11 = 3; i11 <= 5; i11++) {
                dArr10[i11] = planData2.x[i11];
            }
        } else {
            for (int i12 = 0; i12 <= 5; i12++) {
                dArr10[i12] = planData2.x[i12];
            }
        }
        for (int i13 = 0; i13 <= 2; i13++) {
            dArr8[i13] = (dArr[i13 + i] + dArr11[i13]) - dArr10[i13];
        }
        double sqrt = SMath.sqrt(this.sl.square_sum(dArr6));
        double sqrt2 = SMath.sqrt(this.sl.square_sum(dArr8));
        double sqrt3 = SMath.sqrt(this.sl.square_sum(dArr7));
        int i14 = 0;
        while (true) {
            dArr2 = dArr9;
            if (i14 > 2) {
                break;
            }
            dArr6[i14] = dArr6[i14] / sqrt;
            dArr8[i14] = dArr8[i14] / sqrt2;
            dArr7[i14] = dArr7[i14] / sqrt3;
            i14++;
            dArr9 = dArr2;
        }
        double dot_prod = dot_prod(dArr6, dArr8);
        double dot_prod2 = dot_prod(dArr6, dArr7);
        double dot_prod3 = dot_prod(dArr8, dArr7);
        double sqrt4 = SMath.sqrt(1.0d - (dot_prod2 * dot_prod2));
        double d4 = 0.004652417528031441d / sqrt3;
        if (sqrt4 < d4) {
            dArr3 = dArr10;
            d2 = meff(sqrt4 / d4);
        } else {
            dArr3 = dArr10;
            d2 = 1.0d;
        }
        double d5 = ((((d2 * 2.65424880035974E20d) / 2.99792458E8d) / 2.99792458E8d) / 1.4959787066E11d) / sqrt3;
        double d6 = dot_prod3 + 1.0d;
        int i15 = 0;
        while (true) {
            dArr4 = dArr3;
            if (i15 > 2) {
                break;
            }
            dArr5[i15] = (dArr6[i15] + ((d5 / d6) * ((dArr7[i15] * dot_prod) - (dArr8[i15] * dot_prod2)))) * sqrt;
            i15++;
            dArr3 = dArr4;
        }
        if ((i3 & 256) != 0) {
            for (int i16 = 0; i16 <= 2; i16++) {
                dArr6[i16] = dArr[i16 + i] - (dArr[(i16 + 3) + i] * -5.0E-7d);
            }
            if (i4 == 2) {
                int i17 = 0;
                for (int i18 = 2; i17 <= i18; i18 = 2) {
                    int i19 = i17 + 3;
                    dArr7[i17] = (dArr11[i17] - planData2.x[i17]) - ((dArr11[i19] - planData2.x[i19]) * -5.0E-7d);
                    i17++;
                }
            } else {
                for (int i20 = 0; i20 <= 2; i20++) {
                    dArr7[i20] = dArr11[i20] - (dArr11[i20 + 3] * -5.0E-7d);
                }
            }
            for (int i21 = 0; i21 <= 2; i21++) {
                int i22 = i21 + 3;
                dArr8[i21] = ((dArr6[i21] + dArr11[i21]) - dArr4[i21]) - ((dArr11[i22] - dArr4[i22]) * -5.0E-7d);
            }
            double sqrt5 = SMath.sqrt(this.sl.square_sum(dArr6));
            double sqrt6 = SMath.sqrt(this.sl.square_sum(dArr8));
            double sqrt7 = SMath.sqrt(this.sl.square_sum(dArr7));
            for (int i23 = 0; i23 <= 2; i23++) {
                dArr6[i23] = dArr6[i23] / sqrt5;
                dArr8[i23] = dArr8[i23] / sqrt6;
                dArr7[i23] = dArr7[i23] / sqrt7;
            }
            double dot_prod4 = dot_prod(dArr6, dArr8);
            double dot_prod5 = dot_prod(dArr6, dArr7);
            double dot_prod6 = dot_prod(dArr8, dArr7);
            double sqrt8 = SMath.sqrt(1.0d - (dot_prod5 * dot_prod5));
            double d7 = 0.004652417528031441d / sqrt7;
            if (sqrt8 < d7) {
                d3 = meff(sqrt8 / d7);
            } else {
                d3 = 1.0d;
            }
            double d8 = ((((d3 * 2.65424880035974E20d) / 2.99792458E8d) / 2.99792458E8d) / 1.4959787066E11d) / sqrt7;
            double d9 = dot_prod6 + 1.0d;
            for (int i24 = 0; i24 <= 2; i24++) {
                dArr2[i24] = (dArr6[i24] + ((d8 / d9) * ((dArr7[i24] * dot_prod4) - (dArr8[i24] * dot_prod5)))) * sqrt5;
            }
            for (int i25 = 0; i25 <= 2; i25++) {
                int i26 = i25 + 3 + i;
                dArr[i26] = dArr[i26] + (((dArr5[i25] - dArr[i25 + i]) - (dArr2[i25] - (dArr6[i25] * sqrt5))) / -5.0E-7d);
            }
        }
        for (int i27 = 0; i27 <= 2; i27++) {
            dArr[i27 + i] = dArr5[i27];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0252 A[LOOP:10: B:100:0x0250->B:101:0x0252, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0288 A[LOOP:12: B:116:0x0286->B:117:0x0288, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int app_pos_etc_sun(int r34, java.lang.StringBuffer r35) {
        /*
            r33 = this;
            r12 = r33
            r13 = r34
            r0 = 6
            double[] r14 = new double[r0]
            double[] r15 = new double[r0]
            r11 = 3
            double[] r10 = new double[r11]
            double[] r9 = new double[r0]
            double[] r8 = new double[r0]
            double[] r7 = new double[r0]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r16 = 0
            r6 = r0[r16]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r1 = 10
            r5 = r0[r1]
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec2000
            r0 = r13 & -2049(0xfffffffffffff7ff, float:NaN)
            r0 = r0 & -4097(0xffffffffffffefff, float:NaN)
            int r1 = r6.xflgs
            r1 = r1 & -2049(0xfffffffffffff7ff, float:NaN)
            r1 = r1 & -4097(0xffffffffffffefff, float:NaN)
            if (r0 != r1) goto L_0x0039
            r6.xflgs = r13
            r0 = r13 & 7
            r6.iephe = r0
            return r16
        L_0x0039:
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r13
            r17 = -1
            r18 = 0
            r4 = 5
            if (r0 == 0) goto L_0x00a0
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            double r0 = r0.teval
            double r2 = r6.teval
            int r20 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r20 != 0) goto L_0x0072
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            double r0 = r0.teval
            int r2 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x005b
            goto L_0x0072
        L_0x005b:
            r0 = 0
        L_0x005c:
            if (r0 > r4) goto L_0x006b
            swisseph.SwissData r1 = r12.swed
            swisseph.TopoData r1 = r1.topd
            double[] r1 = r1.xobs
            r2 = r1[r0]
            r7[r0] = r2
            int r0 = r0 + 1
            goto L_0x005c
        L_0x006b:
            r11 = r5
            r22 = r6
            r21 = r15
            r15 = 5
            goto L_0x008c
        L_0x0072:
            double r1 = r6.teval
            r20 = 1
            r0 = r33
            r3 = r34
            r21 = r15
            r15 = 5
            r4 = r20
            r11 = r5
            r5 = r7
            r22 = r6
            r6 = r35
            int r0 = r0.swi_get_observer(r1, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x008c
            return r17
        L_0x008c:
            r0 = 0
        L_0x008d:
            if (r0 > r15) goto L_0x009d
            r1 = r7[r0]
            r6 = r22
            double[] r3 = r6.x
            r4 = r3[r0]
            double r1 = r1 + r4
            r7[r0] = r1
            int r0 = r0 + 1
            goto L_0x008d
        L_0x009d:
            r6 = r22
            goto L_0x00b0
        L_0x00a0:
            r11 = r5
            r21 = r15
            r15 = 5
            r0 = 0
        L_0x00a5:
            if (r0 > r15) goto L_0x00b0
            double[] r1 = r6.x
            r2 = r1[r0]
            r7[r0] = r2
            int r0 = r0 + 1
            goto L_0x00a5
        L_0x00b0:
            int r0 = r6.iephe
            r5 = 4
            if (r0 == r5) goto L_0x00ca
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00ba
            goto L_0x00ca
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            if (r0 > r15) goto L_0x00d4
            r1 = r7[r0]
            double[] r3 = r11.x
            r22 = r3[r0]
            double r1 = r1 - r22
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x00bb
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            if (r0 > r15) goto L_0x00d4
            r1 = r7[r0]
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x00cb
        L_0x00d4:
            r22 = r13 & 16
            if (r22 != 0) goto L_0x0233
            int r0 = r6.iephe
            r4 = 2
            if (r0 == r4) goto L_0x00ee
            r0 = r13 & 8
            if (r0 != 0) goto L_0x00ee
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00e6
            goto L_0x00ee
        L_0x00e6:
            r29 = r6
            r28 = r7
            r20 = 3
            goto L_0x0239
        L_0x00ee:
            r0 = 0
        L_0x00ef:
            if (r0 > r15) goto L_0x0105
            r1 = r7[r0]
            r9[r0] = r1
            int r1 = r6.iephe
            if (r1 != r5) goto L_0x00fc
            r8[r0] = r18
            goto L_0x0102
        L_0x00fc:
            double[] r1 = r11.x
            r2 = r1[r0]
            r8[r0] = r2
        L_0x0102:
            int r0 = r0 + 1
            goto L_0x00ef
        L_0x0105:
            r0 = r18
            r2 = 0
            r11 = 0
        L_0x010a:
            r3 = 1
            if (r11 > r3) goto L_0x0212
            r0 = 0
        L_0x010e:
            if (r0 > r4) goto L_0x0123
            r23 = r9[r0]
            r10[r0] = r23
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 != 0) goto L_0x0120
            r23 = r10[r0]
            r25 = r8[r0]
            double r23 = r23 - r25
            r10[r0] = r23
        L_0x0120:
            int r0 = r0 + 1
            goto L_0x010e
        L_0x0123:
            swisseph.SwissLib r0 = r12.sl
            double r0 = r0.square_sum(r10)
            double r0 = swisseph.SMath.sqrt(r0)
            r23 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            double r0 = r0 * r23
            r23 = 4733809291562057728(0x41b1de784a000000, double:2.99792458E8)
            double r0 = r0 / r23
            r23 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r0 = r0 / r23
            double r4 = r6.teval
            double r25 = r4 - r0
            int r0 = r6.iephe
            r4 = 2
            if (r0 == r4) goto L_0x01a6
            r5 = 4
            if (r0 == r5) goto L_0x0163
            r29 = r6
            r28 = r7
            r23 = r8
            r30 = r9
            r32 = r10
            r31 = r11
            r2 = -1
            r20 = 3
            r24 = 2
            r27 = 4
            goto L_0x01fd
        L_0x0163:
            r0 = r13 & 8
            if (r0 != 0) goto L_0x0180
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x016c
            goto L_0x0180
        L_0x016c:
            r29 = r6
            r28 = r7
            r23 = r8
            r30 = r9
            r32 = r10
            r31 = r11
            r20 = 3
            r24 = 2
            r27 = 4
            goto L_0x01fd
        L_0x0180:
            swisseph.SwephMosh r1 = r12.smosh
            r0 = 0
            r23 = 0
            r2 = r25
            r24 = 2
            r4 = r0
            r27 = 4
            r5 = r23
            r0 = r6
            r6 = r9
            r28 = r7
            r7 = r9
            r23 = r8
            r8 = r35
            int r2 = r1.swi_moshplan(r2, r4, r5, r6, r7, r8)
            r29 = r0
            r30 = r9
            r32 = r10
            r31 = r11
            r20 = 3
            goto L_0x01fd
        L_0x01a6:
            r0 = r6
            r28 = r7
            r23 = r8
            r24 = 2
            r27 = 4
            r1 = r13 & 8
            if (r1 != 0) goto L_0x01db
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x01bc
            r29 = r0
            r30 = r9
            goto L_0x01df
        L_0x01bc:
            r3 = 10
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = r0
            r0 = r33
            r1 = r25
            r5 = r34
            r29 = r8
            r8 = r23
            r30 = r9
            r9 = r35
            int r2 = r0.sweph(r1, r3, r4, r5, r6, r7, r8, r9)
            r32 = r10
            r31 = r11
            r20 = 3
            goto L_0x01fd
        L_0x01db:
            r29 = r0
            r30 = r9
        L_0x01df:
            r3 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r31 = 0
            r0 = r33
            r1 = r25
            r5 = r34
            r7 = r30
            r9 = r23
            r32 = r10
            r10 = r31
            r31 = r11
            r20 = 3
            r11 = r35
            int r2 = r0.sweplan(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x01fd:
            if (r2 == 0) goto L_0x0200
            return r2
        L_0x0200:
            int r11 = r31 + 1
            r8 = r23
            r0 = r25
            r7 = r28
            r6 = r29
            r9 = r30
            r10 = r32
            r4 = 2
            r5 = 4
            goto L_0x010a
        L_0x0212:
            r29 = r6
            r28 = r7
            r23 = r8
            r30 = r9
            r20 = 3
            r2 = 0
        L_0x021d:
            if (r2 > r15) goto L_0x0231
            r3 = r30[r2]
            r14[r2] = r3
            r3 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r3 != 0) goto L_0x022e
            r3 = r14[r2]
            r5 = r23[r2]
            double r3 = r3 - r5
            r14[r2] = r3
        L_0x022e:
            int r2 = r2 + 1
            goto L_0x021d
        L_0x0231:
            r2 = r0
            goto L_0x023b
        L_0x0233:
            r29 = r6
            r28 = r7
            r20 = 3
        L_0x0239:
            r2 = r18
        L_0x023b:
            r6 = r13 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x0247
            r11 = 3
        L_0x0240:
            if (r11 > r15) goto L_0x0247
            r14[r11] = r18
            int r11 = r11 + 1
            goto L_0x0240
        L_0x0247:
            r0 = r13 & 8
            if (r0 != 0) goto L_0x025a
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x025a
            r0 = 0
        L_0x0250:
            if (r0 > r15) goto L_0x025a
            r4 = r14[r0]
            double r4 = -r4
            r14[r0] = r4
            int r0 = r0 + 1
            goto L_0x0250
        L_0x025a:
            if (r22 != 0) goto L_0x0265
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0265
            r0 = r28
            r12.swi_aberr_light(r14, r0, r13)
        L_0x0265:
            if (r6 != 0) goto L_0x026f
            r11 = 3
        L_0x0268:
            if (r11 > r15) goto L_0x026f
            r14[r11] = r18
            int r11 = r11 + 1
            goto L_0x0268
        L_0x026f:
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0285
            swisseph.SwissData r0 = r12.swed
            int r0 = r0.jpldenum
            r1 = 403(0x193, float:5.65E-43)
            if (r0 < r1) goto L_0x0285
            swisseph.SwissLib r0 = r12.sl
            r5 = 0
            r1 = r14
            r4 = r34
            r0.swi_bias(r1, r2, r4, r5)
        L_0x0285:
            r0 = 0
        L_0x0286:
            if (r0 > r15) goto L_0x028f
            r1 = r14[r0]
            r21[r0] = r1
            int r0 = r0 + 1
            goto L_0x0286
        L_0x028f:
            r0 = r13 & 32
            if (r0 != 0) goto L_0x02b3
            swisseph.SwissLib r0 = r12.sl
            r7 = r29
            double r2 = r7.teval
            r5 = -1
            r1 = r14
            r4 = r34
            r0.swi_precess(r1, r2, r4, r5)
            if (r6 == 0) goto L_0x02ad
            double r2 = r7.teval
            r5 = -1
            r0 = r33
            r1 = r14
            r4 = r34
            r0.swi_precess_speed(r1, r2, r4, r5)
        L_0x02ad:
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec
            r5 = r0
            goto L_0x02ba
        L_0x02b3:
            r7 = r29
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec2000
            r5 = r0
        L_0x02ba:
            r0 = r33
            r1 = r7
            r2 = r34
            r3 = r14
            r4 = r21
            r6 = r35
            int r0 = r0.app_pos_rest(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.app_pos_etc_sun(int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[LOOP:3: B:28:0x00bb->B:30:0x00be, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cb A[LOOP:4: B:32:0x00c9->B:33:0x00cb, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int app_pos_etc_moon(int r32, java.lang.StringBuffer r33) {
        /*
            r31 = this;
            r12 = r31
            r13 = r32
            r0 = 6
            double[] r14 = new double[r0]
            double[] r15 = new double[r0]
            double[] r11 = new double[r0]
            double[] r7 = new double[r0]
            double[] r10 = new double[r0]
            double[] r9 = new double[r0]
            double[] r8 = new double[r0]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r16 = 0
            r6 = r0[r16]
            swisseph.SwissData r0 = r12.swed
            swisseph.PlanData[] r0 = r0.pldat
            r1 = 10
            r0 = r0[r1]
            swisseph.SwissData r1 = r12.swed
            swisseph.PlanData[] r1 = r1.pldat
            r2 = 1
            r5 = r1[r2]
            swisseph.SwissData r1 = r12.swed
            swisseph.Epsilon r1 = r1.oec
            r1 = r13 & -2049(0xfffffffffffff7ff, float:NaN)
            r1 = r1 & -4097(0xffffffffffffefff, float:NaN)
            int r2 = r5.xflgs
            r2 = r2 & -2049(0xfffffffffffff7ff, float:NaN)
            r2 = r2 & -4097(0xffffffffffffefff, float:NaN)
            if (r1 != r2) goto L_0x0042
            r5.xflgs = r13
            r0 = r13 & 7
            r5.iephe = r0
            return r16
        L_0x0042:
            r1 = 0
        L_0x0043:
            r4 = 5
            if (r1 > r4) goto L_0x0053
            double[] r2 = r5.x
            r3 = r2[r1]
            r14[r1] = r3
            r2 = r14[r1]
            r7[r1] = r2
            int r1 = r1 + 1
            goto L_0x0043
        L_0x0053:
            r1 = 0
        L_0x0054:
            if (r1 > r4) goto L_0x0064
            r2 = r14[r1]
            double[] r4 = r6.x
            r18 = r4[r1]
            double r2 = r2 + r18
            r14[r1] = r2
            int r1 = r1 + 1
            r4 = 5
            goto L_0x0054
        L_0x0064:
            r1 = 32768(0x8000, float:4.5918E-41)
            r18 = r13 & r1
            r19 = -1
            r20 = 0
            if (r18 == 0) goto L_0x00d7
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            double r0 = r0.teval
            double r2 = r5.teval
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x009e
            swisseph.SwissData r0 = r12.swed
            swisseph.TopoData r0 = r0.topd
            double r0 = r0.teval
            int r2 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r2 != 0) goto L_0x0087
            r4 = 5
            goto L_0x009f
        L_0x0087:
            r0 = 0
        L_0x0088:
            r4 = 5
            if (r0 > r4) goto L_0x0098
            swisseph.SwissData r1 = r12.swed
            swisseph.TopoData r1 = r1.topd
            double[] r1 = r1.xobs
            r2 = r1[r0]
            r11[r0] = r2
            int r0 = r0 + 1
            goto L_0x0088
        L_0x0098:
            r24 = r5
            r17 = r8
            r8 = r6
            goto L_0x00ba
        L_0x009e:
            r4 = 5
        L_0x009f:
            double r1 = r5.teval
            r17 = 1
            r22 = 0
            r0 = r31
            r3 = r32
            r4 = r17
            r24 = r5
            r5 = r11
            r17 = r8
            r8 = r6
            r6 = r22
            int r0 = r0.swi_get_observer(r1, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x00ba
            return r19
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            r6 = 5
            if (r0 > r6) goto L_0x00c8
            r1 = r7[r0]
            r3 = r11[r0]
            double r1 = r1 - r3
            r7[r0] = r1
            int r0 = r0 + 1
            goto L_0x00bb
        L_0x00c8:
            r0 = 0
        L_0x00c9:
            if (r0 > r6) goto L_0x012a
            r1 = r11[r0]
            double[] r3 = r8.x
            r4 = r3[r0]
            double r1 = r1 + r4
            r11[r0] = r1
            int r0 = r0 + 1
            goto L_0x00c9
        L_0x00d7:
            r24 = r5
            r17 = r8
            r8 = r6
            r6 = 5
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x00f8
            r0 = 0
        L_0x00e2:
            if (r0 > r6) goto L_0x00e9
            r11[r0] = r20
            int r0 = r0 + 1
            goto L_0x00e2
        L_0x00e9:
            r0 = 0
        L_0x00ea:
            if (r0 > r6) goto L_0x012a
            r1 = r7[r0]
            double[] r3 = r8.x
            r4 = r3[r0]
            double r1 = r1 + r4
            r7[r0] = r1
            int r0 = r0 + 1
            goto L_0x00ea
        L_0x00f8:
            r1 = r13 & 8
            if (r1 == 0) goto L_0x011e
            r1 = 0
        L_0x00fd:
            if (r1 > r6) goto L_0x0108
            double[] r2 = r0.x
            r3 = r2[r1]
            r11[r1] = r3
            int r1 = r1 + 1
            goto L_0x00fd
        L_0x0108:
            r1 = 0
        L_0x0109:
            if (r1 > r6) goto L_0x012a
            r2 = r7[r1]
            double[] r4 = r8.x
            r22 = r4[r1]
            double[] r4 = r0.x
            r25 = r4[r1]
            double r22 = r22 - r25
            double r2 = r2 + r22
            r7[r1] = r2
            int r1 = r1 + 1
            goto L_0x0109
        L_0x011e:
            r0 = 0
        L_0x011f:
            if (r0 > r6) goto L_0x012a
            double[] r1 = r8.x
            r2 = r1[r0]
            r11[r0] = r2
            int r0 = r0 + 1
            goto L_0x011f
        L_0x012a:
            r22 = r13 & 16
            if (r22 != 0) goto L_0x0213
            swisseph.SwissLib r0 = r12.sl
            double r0 = r0.square_sum(r7)
            double r0 = swisseph.SMath.sqrt(r0)
            r2 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            double r0 = r0 * r2
            r2 = 4733809291562057728(0x41b1de784a000000, double:2.99792458E8)
            double r0 = r0 / r2
            r2 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r0 = r0 / r2
            r7 = r24
            double r2 = r7.teval
            double r23 = r2 - r0
            int r2 = r7.iephe
            r3 = 2
            if (r2 == r3) goto L_0x019a
            r4 = 4
            if (r2 == r4) goto L_0x0165
            r30 = r7
            r26 = r9
            r27 = r10
            r25 = r15
            r7 = 5
            r15 = r11
            goto L_0x01cc
        L_0x0165:
            r2 = 0
        L_0x0166:
            if (r2 > r3) goto L_0x018f
            r4 = r14[r2]
            int r25 = r2 + 3
            r26 = r14[r25]
            double r26 = r26 * r0
            double r4 = r4 - r26
            r14[r2] = r4
            double[] r4 = r8.x
            r26 = r4[r2]
            double[] r4 = r8.x
            r28 = r4[r25]
            double r28 = r28 * r0
            double r26 = r26 - r28
            r9[r2] = r26
            double[] r4 = r8.x
            r26 = r4[r25]
            r9[r25] = r26
            r10[r2] = r20
            r10[r25] = r20
            int r2 = r2 + 1
            goto L_0x0166
        L_0x018f:
            r30 = r7
            r26 = r9
            r27 = r10
            r25 = r15
            r7 = 5
            r15 = r11
            goto L_0x01cc
        L_0x019a:
            r3 = 1
            r4 = 1
            r8 = 0
            r25 = 0
            r0 = r31
            r1 = r23
            r5 = r32
            r6 = r8
            r8 = r7
            r7 = r14
            r30 = r8
            r8 = r9
            r26 = r9
            r9 = r10
            r27 = r10
            r10 = r25
            r25 = r15
            r15 = r11
            r11 = r33
            int r0 = r0.sweplan(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r0 == 0) goto L_0x01be
            return r0
        L_0x01be:
            r0 = 0
        L_0x01bf:
            r7 = 5
            if (r0 > r7) goto L_0x01cc
            r1 = r14[r0]
            r3 = r26[r0]
            double r1 = r1 + r3
            r14[r0] = r1
            int r0 = r0 + 1
            goto L_0x01bf
        L_0x01cc:
            if (r18 == 0) goto L_0x01ec
            r4 = 0
            r6 = 0
            r0 = r31
            r1 = r23
            r3 = r32
            r5 = r17
            int r0 = r0.swi_get_observer(r1, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x01df
            return r19
        L_0x01df:
            r0 = 0
        L_0x01e0:
            if (r0 > r7) goto L_0x0210
            r1 = r17[r0]
            r3 = r26[r0]
            double r1 = r1 + r3
            r17[r0] = r1
            int r0 = r0 + 1
            goto L_0x01e0
        L_0x01ec:
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01f8
            r0 = 0
        L_0x01f1:
            if (r0 > r7) goto L_0x0210
            r17[r0] = r20
            int r0 = r0 + 1
            goto L_0x01f1
        L_0x01f8:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0206
            r0 = 0
        L_0x01fd:
            if (r0 > r7) goto L_0x0210
            r1 = r27[r0]
            r17[r0] = r1
            int r0 = r0 + 1
            goto L_0x01fd
        L_0x0206:
            r0 = 0
        L_0x0207:
            if (r0 > r7) goto L_0x0210
            r1 = r26[r0]
            r17[r0] = r1
            int r0 = r0 + 1
            goto L_0x0207
        L_0x0210:
            r2 = r23
            goto L_0x021b
        L_0x0213:
            r25 = r15
            r30 = r24
            r7 = 5
            r15 = r11
            r2 = r20
        L_0x021b:
            r0 = 0
        L_0x021c:
            if (r0 > r7) goto L_0x0228
            r4 = r14[r0]
            r8 = r15[r0]
            double r4 = r4 - r8
            r14[r0] = r4
            int r0 = r0 + 1
            goto L_0x021c
        L_0x0228:
            r0 = 3
            if (r22 != 0) goto L_0x0246
            r1 = r13 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0246
            r12.swi_aberr_light(r14, r15, r13)
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0246
            r1 = 3
        L_0x0237:
            if (r1 > r7) goto L_0x0246
            r4 = r14[r1]
            r8 = r15[r1]
            r10 = r17[r1]
            double r8 = r8 - r10
            double r4 = r4 + r8
            r14[r1] = r4
            int r1 = r1 + 1
            goto L_0x0237
        L_0x0246:
            r6 = r13 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x0252
        L_0x024b:
            if (r0 > r7) goto L_0x0252
            r14[r0] = r20
            int r0 = r0 + 1
            goto L_0x024b
        L_0x0252:
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0268
            swisseph.SwissData r0 = r12.swed
            int r0 = r0.jpldenum
            r1 = 403(0x193, float:5.65E-43)
            if (r0 < r1) goto L_0x0268
            swisseph.SwissLib r0 = r12.sl
            r5 = 0
            r1 = r14
            r4 = r32
            r0.swi_bias(r1, r2, r4, r5)
        L_0x0268:
            r0 = 0
        L_0x0269:
            if (r0 > r7) goto L_0x0272
            r1 = r14[r0]
            r25[r0] = r1
            int r0 = r0 + 1
            goto L_0x0269
        L_0x0272:
            r0 = r13 & 32
            if (r0 != 0) goto L_0x0296
            swisseph.SwissLib r0 = r12.sl
            r7 = r30
            double r2 = r7.teval
            r5 = -1
            r1 = r14
            r4 = r32
            r0.swi_precess(r1, r2, r4, r5)
            if (r6 == 0) goto L_0x0290
            double r2 = r7.teval
            r5 = -1
            r0 = r31
            r1 = r14
            r4 = r32
            r0.swi_precess_speed(r1, r2, r4, r5)
        L_0x0290:
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec
            r5 = r0
            goto L_0x029d
        L_0x0296:
            r7 = r30
            swisseph.SwissData r0 = r12.swed
            swisseph.Epsilon r0 = r0.oec2000
            r5 = r0
        L_0x029d:
            r0 = r31
            r1 = r7
            r2 = r32
            r3 = r14
            r4 = r25
            r6 = r33
            int r0 = r0.app_pos_rest(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.app_pos_etc_moon(int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public int app_pos_etc_sbar(int i, StringBuffer stringBuffer) {
        Epsilon epsilon;
        int i2 = i;
        double[] dArr = new double[6];
        double[] dArr2 = new double[6];
        PlanData planData = this.swed.pldat[0];
        PlanData planData2 = this.swed.pldat[10];
        Epsilon epsilon2 = this.swed.oec;
        for (int i3 = 0; i3 <= 5; i3++) {
            dArr[i3] = planData2.x[i3];
        }
        if ((i2 & 16) == 0) {
            double sqrt = ((SMath.sqrt(this.sl.square_sum(dArr)) * 1.4959787066E11d) / 2.99792458E8d) / 86400.0d;
            for (int i4 = 0; i4 <= 2; i4++) {
                dArr[i4] = dArr[i4] - (dArr[i4 + 3] * sqrt);
            }
        }
        int i5 = i2 & 256;
        if (i5 == 0) {
            for (int i6 = 3; i6 <= 5; i6++) {
                dArr[i6] = 0.0d;
            }
        }
        if ((131072 & i2) == 0 && this.swed.jpldenum >= 403) {
            this.sl.swi_bias(dArr, planData.teval, i, false);
        }
        for (int i7 = 0; i7 <= 5; i7++) {
            dArr2[i7] = dArr[i7];
        }
        if ((i2 & 32) == 0) {
            this.sl.swi_precess(dArr, planData2.teval, i, -1);
            if (i5 != 0) {
                swi_precess_speed(dArr, planData2.teval, i, -1);
            }
            epsilon = this.swed.oec;
        } else {
            epsilon = this.swed.oec2000;
        }
        return app_pos_rest(planData, i, dArr, dArr2, epsilon, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int app_pos_etc_mean(int i, int i2, StringBuffer stringBuffer) {
        double[] dArr;
        double[] dArr2;
        PlanData planData;
        Epsilon epsilon;
        int i3 = i2;
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        PlanData planData2 = this.swed.nddat[i];
        if ((i3 & -2049 & -4097) == (planData2.xflgs & -2049 & -4097)) {
            planData2.xflgs = i3;
            planData2.iephe = i3 & 7;
            return 0;
        }
        for (int i4 = 0; i4 <= 5; i4++) {
            dArr3[i4] = planData2.x[i4];
        }
        this.sl.swi_polcart_sp(dArr3, dArr3);
        double[] dArr5 = dArr3;
        this.sl.swi_coortrf2(dArr5, dArr3, -this.swed.oec.seps, this.swed.oec.ceps);
        double[] dArr6 = dArr4;
        this.sl.swi_coortrf2(dArr5, 3, dArr3, 3, -this.swed.oec.seps, this.swed.oec.ceps);
        int i5 = i3 & 256;
        if (i5 == 0) {
            for (int i6 = 3; i6 <= 5; i6++) {
                dArr3[i6] = 0.0d;
            }
        }
        if (((65536 & i3) == 0 || (this.swed.sidd.sid_mode & 256) == 0) && (this.swed.sidd.sid_mode & 512) == 0) {
            planData = planData2;
            dArr = dArr3;
            dArr2 = dArr6;
        } else {
            for (int i7 = 0; i7 <= 5; i7++) {
                dArr6[i7] = dArr3[i7];
            }
            if (planData2.teval != 2451545.0d) {
                planData = planData2;
                dArr2 = dArr6;
                dArr = dArr3;
                this.sl.swi_precess(dArr6, planData2.teval, i2, 1);
                if (i5 != 0) {
                    swi_precess_speed(dArr2, planData.teval, i2, 1);
                }
            } else {
                planData = planData2;
                dArr = dArr3;
                dArr2 = dArr6;
            }
        }
        if ((i3 & 32) != 0) {
            this.sl.swi_precess(dArr, planData.teval, i2, 1);
            if (i5 != 0) {
                swi_precess_speed(dArr, planData.teval, i2, 1);
            }
            epsilon = this.swed.oec2000;
        } else {
            epsilon = this.swed.oec;
        }
        return app_pos_rest(planData, i2, dArr, dArr2, epsilon, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public void rot_back(int i) {
        double d;
        double d2;
        double d3;
        double[] dArr;
        double[] dArr2;
        int i2 = i;
        double[] dArr3 = new double[3];
        double[] dArr4 = new double[3];
        double[] dArr5 = new double[3];
        double d4 = this.swed.oec2000.seps;
        double d5 = this.swed.oec2000.ceps;
        PlanData planData = this.swed.pldat[i2];
        int i3 = planData.ncoe;
        double[][] dArr6 = (double[][]) Array.newInstance(double.class, new int[]{41, 3});
        double d6 = planData.tseg0 + (planData.dseg / 2.0d);
        double[] dArr7 = planData.segp;
        int i4 = i3 * 2;
        double d7 = d4;
        double d8 = (d6 - planData.telem) / 365250.0d;
        if (i2 == 1) {
            d = d5;
            double d9 = planData.prot + (planData.dprot * d8);
            double d10 = d9 - (((double) ((int) (d9 / 6.283185307179586d))) * 6.283185307179586d);
            d2 = (planData.qrot + (planData.dqrot * d8)) * SMath.sin(d10);
            d3 = (planData.qrot + (planData.dqrot * d8)) * SMath.cos(d10);
        } else {
            d = d5;
            d3 = planData.qrot + (planData.dqrot * d8);
            d2 = (planData.dprot * d8) + planData.prot;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            dArr6[i5][0] = dArr7[i5];
            dArr6[i5][1] = dArr7[i5 + i3];
            dArr6[i5][2] = dArr7[i5 + i4];
        }
        if ((planData.iflg & 4) != 0) {
            double[] dArr8 = planData.refep;
            dArr2 = dArr3;
            dArr = dArr4;
            double d11 = planData.peri + (d8 * planData.dperi);
            double d12 = d11 - (((double) ((int) (d11 / 6.283185307179586d))) * 6.283185307179586d);
            double cos = SMath.cos(d12);
            double sin = SMath.sin(d12);
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 + i3;
                dArr6[i6][0] = (dArr7[i6] + (dArr8[i6] * cos)) - (dArr8[i7] * sin);
                dArr6[i6][1] = dArr7[i7] + (dArr8[i7] * cos) + (dArr8[i6] * sin);
            }
        } else {
            dArr2 = dArr3;
            dArr = dArr4;
        }
        double d13 = d3 * d3;
        double d14 = d13 + 1.0d;
        double d15 = d2 * d2;
        double d16 = 1.0d / (d14 + d15);
        dArr5[0] = d2 * 2.0d * d16;
        dArr5[1] = d3 * -2.0d * d16;
        double d17 = 1.0d - d13;
        dArr5[2] = (d17 - d15) * d16;
        dArr2[0] = (d14 - d15) * d16;
        double d18 = d3 * 2.0d;
        double d19 = d18 * d2 * d16;
        dArr2[1] = d19;
        dArr2[2] = d2 * -2.0d * d16;
        dArr[0] = d19;
        dArr[1] = (d17 + d15) * d16;
        dArr[2] = d18 * d16;
        for (int i8 = 0; i8 < i3; i8++) {
            double d20 = (dArr6[i8][0] * dArr2[0]) + (dArr6[i8][1] * dArr[0]) + (dArr6[i8][2] * dArr5[0]);
            double d21 = (dArr6[i8][0] * dArr2[1]) + (dArr6[i8][1] * dArr[1]) + (dArr6[i8][2] * dArr5[1]);
            double d22 = (dArr6[i8][0] * dArr2[2]) + (dArr6[i8][1] * dArr[2]) + (dArr6[i8][2] * dArr5[2]);
            if (SMath.abs(d20) + SMath.abs(d21) + SMath.abs(d22) >= 1.0E-14d) {
                planData.neval = i8;
            }
            dArr6[i8][0] = d20;
            dArr6[i8][1] = d21;
            dArr6[i8][2] = d22;
            if (i == 1) {
                dArr6[i8][1] = (d * d21) - (d7 * d22);
                dArr6[i8][2] = (d7 * d21) + (d * d22);
            }
        }
        for (int i9 = 0; i9 < i3; i9++) {
            dArr7[i9] = dArr6[i9][0];
            dArr7[i9 + i3] = dArr6[i9][1];
            dArr7[i9 + i4] = dArr6[i9][2];
        }
    }

    /* access modifiers changed from: package-private */
    public void embofs(double[] dArr, int i, double[] dArr2, int i2) {
        for (int i3 = 0; i3 <= 2; i3++) {
            int i4 = i3 + i;
            dArr[i4] = dArr[i4] - (dArr2[i3 + i2] / 82.30055985272827d);
        }
    }

    /* access modifiers changed from: package-private */
    public void nut_matrix(Nut nut, Epsilon epsilon) {
        Nut nut2 = nut;
        Epsilon epsilon2 = epsilon;
        double d = nut2.nutlo[0];
        double d2 = epsilon2.eps + nut2.nutlo[1];
        double sin = SMath.sin(d);
        double cos = SMath.cos(d);
        double d3 = epsilon2.seps;
        double d4 = epsilon2.ceps;
        double sin2 = SMath.sin(d2);
        double cos2 = SMath.cos(d2);
        nut2.matrix[0][0] = cos;
        nut2.matrix[0][1] = sin * cos2;
        nut2.matrix[0][2] = sin * sin2;
        double d5 = -sin;
        nut2.matrix[1][0] = d5 * d4;
        double d6 = cos * cos2;
        nut2.matrix[1][1] = (d6 * d4) + (sin2 * d3);
        double d7 = cos * sin2;
        nut2.matrix[1][2] = (d7 * d4) - (cos2 * d3);
        nut2.matrix[2][0] = d5 * d3;
        nut2.matrix[2][1] = (d6 * d3) - (sin2 * d4);
        nut2.matrix[2][2] = (d7 * d3) + (cos2 * d4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v44, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v78, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v50, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v52, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: double[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int lunar_osc_elem(double r56, int r58, int r59, java.lang.StringBuffer r60) {
        /*
            r55 = this;
            r8 = r55
            r9 = r56
            r0 = r59
            r7 = r60
            java.lang.Class<double> r1 = double.class
            r11 = 2
            int[] r2 = new int[r11]
            r2 = {3, 6} // fill-array
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r1, r2)
            r12 = r2
            double[][] r12 = (double[][]) r12
            int[] r2 = new int[r11]
            r2 = {3, 6} // fill-array
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r1, r2)
            r13 = r2
            double[][] r13 = (double[][]) r13
            int[] r2 = new int[r11]
            r2 = {3, 6} // fill-array
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            r14 = r1
            double[][] r14 = (double[][]) r14
            r15 = 6
            double[] r6 = new double[r15]
            double[] r5 = new double[r15]
            swisseph.SwissData r1 = r8.swed
            swisseph.Epsilon r4 = r1.oec
            swisseph.SwissData r1 = r8.swed
            swisseph.PlanData[] r1 = r1.nddat
            r1 = r1[r58]
            r2 = r0 & -2049(0xfffffffffffff7ff, float:NaN)
            r2 = r2 & -4097(0xffffffffffffefff, float:NaN)
            int r3 = r1.xflgs
            r3 = r3 & -2049(0xfffffffffffff7ff, float:NaN)
            r3 = r3 & -4097(0xffffffffffffefff, float:NaN)
            int r15 = r1.xflgs
            r11 = 256(0x100, float:3.59E-43)
            r15 = r15 & r11
            r11 = r0 & 256(0x100, float:3.59E-43)
            r18 = r4
            r17 = r5
            double r4 = r1.teval
            r19 = r13
            r20 = r14
            r13 = 0
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x0073
            r4 = 0
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0073
            if (r2 != r3) goto L_0x0073
            if (r11 == 0) goto L_0x006c
            if (r15 == 0) goto L_0x0073
        L_0x006c:
            r1.xflgs = r0
            r0 = r0 & 7
            r1.iephe = r0
            return r13
        L_0x0073:
            r1 = r0 & 4
            r14 = 4
            if (r1 == 0) goto L_0x007a
            r1 = 4
            goto L_0x0081
        L_0x007a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0080
            r1 = 2
            goto L_0x0081
        L_0x0080:
            r1 = 2
        L_0x0081:
            swisseph.SwissData r2 = r8.swed
            swisseph.PlanData[] r2 = r2.pldat
            r15 = 1
            r2 = r2[r15]
            r3 = 0
            r2.teval = r3
            if (r11 == 0) goto L_0x0090
            r11 = 0
            goto L_0x0091
        L_0x0090:
            r11 = 2
        L_0x0091:
            if (r7 == 0) goto L_0x0096
            r7.setLength(r13)
        L_0x0096:
            r23 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            r4 = r0
            r3 = r1
            r1 = r23
            r0 = -1
        L_0x00a0:
            r5 = 2
            if (r3 == r5) goto L_0x0106
            if (r3 == r14) goto L_0x00b1
            r28 = r1
            r14 = r3
            r27 = r6
            r34 = r18
            r2 = 4
            r13 = -1
            r6 = r4
            goto L_0x01c6
        L_0x00b1:
            r27 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            r1 = r11
        L_0x00b7:
            if (r1 > r5) goto L_0x00f6
            if (r1 != 0) goto L_0x00be
            double r29 = r9 - r27
            goto L_0x00c5
        L_0x00be:
            if (r1 != r15) goto L_0x00c3
            double r29 = r9 + r27
            goto L_0x00c5
        L_0x00c3:
            r29 = r9
        L_0x00c5:
            swisseph.Swemmoon r0 = r8.sm
            r5 = 0
            r31 = r12[r1]
            r32 = r1
            r1 = r29
            r33 = r3
            r3 = r5
            r14 = r4
            r5 = r18
            r4 = r31
            r34 = r5
            r13 = -1
            r5 = r60
            int r0 = r0.swi_moshmoon(r1, r3, r4, r5)
            if (r0 != r13) goto L_0x00e2
            return r0
        L_0x00e2:
            r0 = r14 | 256(0x100, float:3.59E-43)
            r1 = r12[r32]
            r2 = r29
            int r0 = r8.swi_plan_for_osc_elem(r0, r2, r1)
            int r1 = r32 + 1
            r4 = r14
            r3 = r33
            r18 = r34
            r5 = 2
            r14 = 4
            goto L_0x00b7
        L_0x00f6:
            r33 = r3
            r14 = r4
            r34 = r18
            r13 = -1
            r28 = r27
            r2 = 4
            r27 = r6
            r6 = r14
            r14 = r33
            goto L_0x01c6
        L_0x0106:
            r33 = r3
            r14 = r4
            r34 = r18
            r13 = -1
            r5 = r11
        L_0x010d:
            r1 = 2
            if (r5 > r1) goto L_0x01be
            if (r5 != 0) goto L_0x0116
            double r0 = r9 - r23
            r3 = r0
            goto L_0x011d
        L_0x0116:
            if (r5 != r15) goto L_0x011c
            double r0 = r9 + r23
            r3 = r0
            goto L_0x011d
        L_0x011c:
            r3 = r9
        L_0x011d:
            r1 = r14 | 256(0x100, float:3.59E-43)
            r26 = 0
            r27 = r12[r5]
            r0 = r55
            r28 = r1
            r1 = r3
            r35 = r3
            r3 = r28
            r4 = r26
            r26 = r5
            r5 = r27
            r27 = r6
            r6 = r60
            int r0 = r0.swemoon(r1, r3, r4, r5, r6)
            if (r0 != r13) goto L_0x013d
            return r13
        L_0x013d:
            r1 = r14 & 16
            if (r1 != 0) goto L_0x017a
            if (r0 < 0) goto L_0x017a
            swisseph.SwissLib r0 = r8.sl
            r1 = r12[r26]
            double r0 = r0.square_sum(r1)
            double r0 = swisseph.SMath.sqrt(r0)
            r2 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            double r0 = r0 * r2
            r2 = 4733809291562057728(0x41b1de784a000000, double:2.99792458E8)
            double r0 = r0 / r2
            r2 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r0 = r0 / r2
            r5 = r35
            double r1 = r5 - r0
            r4 = 0
            r29 = r12[r26]
            r0 = r55
            r3 = r28
            r37 = r5
            r5 = r29
            r6 = r60
            int r0 = r0.swemoon(r1, r3, r4, r5, r6)
            if (r0 != r13) goto L_0x017c
            return r13
        L_0x017a:
            r37 = r35
        L_0x017c:
            r1 = -2
            if (r0 != r1) goto L_0x01ad
            r1 = 4693615925507653632(0x412312d100000000, double:625000.5)
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x01ac
            r1 = 4703306021341233152(0x41457fe840000000, double:2818000.5)
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x01ac
            r1 = r14 & -3
            r2 = 4
            r1 = r1 | r2
            if (r7 == 0) goto L_0x01a7
            int r3 = r60.length()
            int r3 = r3 + 30
            r4 = 256(0x100, float:3.59E-43)
            if (r3 >= r4) goto L_0x01a7
            java.lang.String r3 = " \nusing Moshier eph.; "
            r7.append(r3)
        L_0x01a7:
            r6 = r1
            r28 = r23
            r14 = 4
            goto L_0x01c6
        L_0x01ac:
            return r13
        L_0x01ad:
            r2 = 4
            r0 = r12[r26]
            r1 = r28
            r3 = r37
            int r0 = r8.swi_plan_for_osc_elem(r1, r3, r0)
            int r5 = r26 + 1
            r6 = r27
            goto L_0x010d
        L_0x01be:
            r27 = r6
            r2 = 4
            r6 = r14
            r28 = r23
            r14 = r33
        L_0x01c6:
            r1 = -2
            if (r0 == r1) goto L_0x0767
            r1 = -3
            if (r0 == r1) goto L_0x0767
            swisseph.SwissData r0 = r8.swed
            swisseph.PlanData[] r0 = r0.nddat
            r7 = r0[r15]
            r0 = r11
        L_0x01d3:
            r13 = 5
            r1 = 2
            if (r0 > r1) goto L_0x0228
            r1 = r12[r0]
            r2 = r1[r13]
            double r1 = swisseph.SMath.abs((double) r2)
            r3 = 4382569440205035030(0x3cd203af9ee75616, double:1.0E-15)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x01f1
            r1 = r12[r0]
            r2 = 4382569440205035030(0x3cd203af9ee75616, double:1.0E-15)
            r1[r13] = r2
        L_0x01f1:
            r1 = r12[r0]
            r2 = 2
            r3 = r1[r2]
            r1 = r12[r0]
            r23 = r1[r13]
            double r3 = r3 / r23
            r1 = r12[r0]
            r23 = r1[r13]
            r1 = r12[r0]
            r30 = r1[r13]
            double r1 = swisseph.SMath.abs((double) r30)
            double r23 = r23 / r1
            r1 = 0
        L_0x020b:
            r2 = 2
            if (r1 > r2) goto L_0x0225
            r2 = r19[r0]
            r5 = r12[r0]
            r30 = r5[r1]
            r5 = r12[r0]
            int r13 = r1 + 3
            r32 = r5[r13]
            double r32 = r32 * r3
            double r30 = r30 - r32
            double r30 = r30 * r23
            r2[r1] = r30
            int r1 = r1 + 1
            goto L_0x020b
        L_0x0225:
            int r0 = r0 + 1
            goto L_0x01d3
        L_0x0228:
            r0 = 0
        L_0x0229:
            r23 = 4611686018427387904(0x4000000000000000, double:2.0)
            r1 = 2
            if (r0 > r1) goto L_0x0276
            double[] r2 = r7.x
            r3 = r19[r1]
            r4 = r3[r0]
            r2[r0] = r4
            r1 = r6 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0267
            r1 = r19[r15]
            r2 = r1[r0]
            r1 = 0
            r4 = r19[r1]
            r25 = r4[r0]
            double r2 = r2 - r25
            double r2 = r2 / r23
            r4 = r19[r15]
            r30 = r4[r0]
            r4 = r19[r1]
            r32 = r4[r0]
            double r30 = r30 + r32
            double r30 = r30 / r23
            r1 = 2
            r4 = r19[r1]
            r32 = r4[r0]
            double r30 = r30 - r32
            double[] r1 = r7.x
            int r4 = r0 + 3
            double r30 = r30 * r23
            double r30 = r30 + r2
            double r30 = r30 / r28
            r1[r4] = r30
            goto L_0x026f
        L_0x0267:
            double[] r1 = r7.x
            int r2 = r0 + 3
            r3 = 0
            r1[r2] = r3
        L_0x026f:
            r7.teval = r9
            r7.iephe = r14
            int r0 = r0 + 1
            goto L_0x0229
        L_0x0276:
            swisseph.SwissData r0 = r8.swed
            swisseph.PlanData[] r0 = r0.nddat
            r5 = 3
            r4 = r0[r5]
            r30 = 4471768606512584721(0x3e0ee9daeced1811, double:8.997011693402468E-10)
        L_0x0283:
            r0 = 2
            if (r11 > r0) goto L_0x042c
            r0 = r19[r11]
            r1 = 0
            r2 = r0[r1]
            r0 = r19[r11]
            r25 = r0[r1]
            double r2 = r2 * r25
            r0 = r19[r11]
            r25 = r0[r15]
            r0 = r19[r11]
            r32 = r0[r15]
            double r25 = r25 * r32
            double r2 = r2 + r25
            double r2 = swisseph.SMath.sqrt(r2)
            r0 = r19[r11]
            r32 = r0[r1]
            double r0 = r32 / r2
            r18 = r19[r11]
            r32 = r18[r15]
            double r2 = r32 / r2
            swisseph.SwissLib r5 = r8.sl
            r18 = r12[r11]
            r26 = 0
            r32 = r12[r11]
            r33 = 3
            r35 = 0
            r36 = r14
            r13 = r0
            r0 = r5
            r1 = r18
            r39 = r2
            r2 = r26
            r3 = r32
            r5 = r4
            r4 = r33
            r41 = r5
            r5 = r27
            r43 = r6
            r6 = r35
            r0.swi_cross_prod(r1, r2, r3, r4, r5, r6)
            r0 = 0
            r1 = r27[r0]
            r3 = r27[r0]
            double r1 = r1 * r3
            r3 = r27[r15]
            r5 = r27[r15]
            double r3 = r3 * r5
            double r1 = r1 + r3
            r0 = 2
            r3 = r27[r0]
            r5 = r27[r0]
            double r3 = r3 * r5
            double r3 = r3 + r1
            double r5 = swisseph.SMath.sqrt(r3)
            double r0 = swisseph.SMath.sqrt(r1)
            double r0 = r0 / r5
            double r5 = r0 * r0
            r32 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = r32 - r5
            double r49 = swisseph.SMath.sqrt(r5)
            r2 = r12[r11]
            r5 = 0
            r37 = r2[r5]
            double r37 = r37 * r13
            r2 = r12[r11]
            r5 = r2[r15]
            r9 = r39
            double r5 = r5 * r9
            double r5 = r37 + r5
            r2 = r12[r11]
            r16 = 2
            r37 = r2[r16]
            double r9 = r37 / r0
            double r5 = swisseph.SMath.atan2(r9, r5)
            swisseph.SwissLib r2 = r8.sl
            r9 = r12[r11]
            double r9 = r2.square_sum(r9)
            double r9 = swisseph.SMath.sqrt(r9)
            swisseph.SwissLib r2 = r8.sl
            r15 = r12[r11]
            r59 = r7
            r7 = 3
            double r37 = r2.square_sum(r15, r7)
            double r44 = r23 / r9
            double r37 = r37 / r30
            double r44 = r44 - r37
            double r37 = r32 / r44
            double r3 = r3 / r30
            double r3 = r3 / r37
            double r2 = r32 - r3
            double r2 = swisseph.SMath.sqrt(r2)
            double r44 = r32 / r2
            double r9 = r9 / r37
            double r9 = r32 - r9
            double r9 = r9 * r44
            double r46 = r37 * r30
            double r46 = swisseph.SMath.sqrt(r46)
            double r44 = r44 / r46
            r4 = r12[r11]
            r15 = r12[r11]
            double r46 = r8.dot_prod(r4, r15, r7)
            double r44 = r44 * r46
            double r46 = r2 + r32
            double r51 = r32 - r2
            double r51 = r46 / r51
            double r53 = swisseph.SMath.sqrt(r51)
            double r53 = r53 * r44
            double r9 = r9 + r32
            double r53 = r53 / r9
            double r9 = swisseph.SMath.atan(r53)
            double r9 = r9 * r23
            r4 = r20[r11]
            swisseph.SwissLib r15 = r8.sl
            double r44 = r5 - r9
            r53 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r7 = r44 + r53
            double r7 = r15.swi_mod2PI(r7)
            r15 = 0
            r4[r15] = r7
            r4 = r20[r11]
            r7 = 0
            r15 = 1
            r4[r15] = r7
            r4 = r20[r11]
            double r46 = r46 * r37
            r7 = 2
            r4[r7] = r46
            r8 = r55
            swisseph.SwissLib r4 = r8.sl
            r7 = r20[r11]
            r15 = r20[r11]
            r4.swi_polcart(r7, r15)
            swisseph.SwissLib r4 = r8.sl
            r45 = r20[r11]
            r46 = r20[r11]
            double r0 = -r0
            r44 = r4
            r47 = r0
            r44.swi_coortrf2(r45, r46, r47, r49)
            swisseph.SwissLib r0 = r8.sl
            r1 = r20[r11]
            r4 = r20[r11]
            r0.swi_cartpol(r1, r4)
            r0 = r20[r11]
            r1 = 0
            r25 = r0[r1]
            r44 = r2
            r1 = r39
            double r1 = swisseph.SMath.atan2(r1, r13)
            double r25 = r25 + r1
            r1 = 0
            r0[r1] = r25
            swisseph.SwissLib r0 = r8.sl
            r1 = r20[r11]
            r2 = r20[r11]
            r0.swi_polcart(r1, r2)
            swisseph.SwissLib r0 = r8.sl
            double r9 = r9 - r5
            double r0 = r0.swi_mod2PI(r9)
            double r0 = r0 / r23
            double r0 = swisseph.SMath.tan(r0)
            double r2 = swisseph.SMath.sqrt(r51)
            double r0 = r0 / r2
            double r0 = swisseph.SMath.atan(r0)
            double r0 = r0 * r23
            double r0 = swisseph.SMath.cos(r0)
            double r2 = r44 * r0
            double r32 = r32 - r2
            double r37 = r37 * r32
            r0 = 0
            r17[r0] = r37
            swisseph.SwissLib r0 = r8.sl
            r1 = r19[r11]
            double r0 = r0.square_sum(r1)
            double r0 = swisseph.SMath.sqrt(r0)
            r2 = 1
            r17[r2] = r0
            r0 = 0
        L_0x0406:
            r1 = 2
            if (r0 > r1) goto L_0x041b
            r1 = r19[r11]
            r3 = r1[r0]
            r5 = 0
            r6 = r17[r5]
            r9 = r17[r2]
            double r6 = r6 / r9
            double r3 = r3 * r6
            r1[r0] = r3
            int r0 = r0 + 1
            r2 = 1
            goto L_0x0406
        L_0x041b:
            int r11 = r11 + 1
            r9 = r56
            r7 = r59
            r14 = r36
            r4 = r41
            r6 = r43
            r5 = 3
            r13 = 5
            r15 = 1
            goto L_0x0283
        L_0x042c:
            r41 = r4
            r43 = r6
            r59 = r7
            r36 = r14
            r0 = 0
        L_0x0435:
            r1 = 2
            if (r0 > r1) goto L_0x04a4
            r2 = r41
            double[] r3 = r2.x
            r4 = r20[r1]
            r5 = r4[r0]
            r3[r0] = r5
            r14 = r43
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x045e
            double[] r3 = r2.x
            int r4 = r0 + 3
            r5 = 1
            r6 = r20[r5]
            r5 = r6[r0]
            r7 = 0
            r9 = r20[r7]
            r10 = r9[r0]
            double r5 = r5 - r10
            double r5 = r5 / r28
            double r5 = r5 / r23
            r3[r4] = r5
            goto L_0x0466
        L_0x045e:
            double[] r3 = r2.x
            int r4 = r0 + 3
            r5 = 0
            r3[r4] = r5
        L_0x0466:
            r9 = r56
            r2.teval = r9
            r3 = r36
            r2.iephe = r3
            r4 = r59
            double[] r5 = r4.x
            r6 = 2
            r7 = r19[r6]
            r6 = r7[r0]
            r5[r0] = r6
            if (r1 == 0) goto L_0x0491
            double[] r1 = r4.x
            int r5 = r0 + 3
            r6 = 1
            r7 = r19[r6]
            r6 = r7[r0]
            r11 = 0
            r12 = r19[r11]
            r11 = r12[r0]
            double r6 = r6 - r11
            double r6 = r6 / r28
            double r6 = r6 / r23
            r1[r5] = r6
            goto L_0x0499
        L_0x0491:
            double[] r1 = r4.x
            int r5 = r0 + 3
            r6 = 0
            r1[r5] = r6
        L_0x0499:
            int r0 = r0 + 1
            r41 = r2
            r36 = r3
            r59 = r4
            r43 = r14
            goto L_0x0435
        L_0x04a4:
            r9 = r56
            r14 = r43
            r0 = 6
            double[] r11 = new double[r0]
            r12 = 0
        L_0x04ac:
            r0 = 1
            if (r12 > r0) goto L_0x0765
            if (r12 != 0) goto L_0x04ba
            swisseph.SwissData r1 = r8.swed
            swisseph.PlanData[] r1 = r1.nddat
            r1 = r1[r0]
            r13 = r1
            r7 = 3
            goto L_0x04c2
        L_0x04ba:
            swisseph.SwissData r0 = r8.swed
            swisseph.PlanData[] r0 = r0.nddat
            r7 = 3
            r1 = r0[r7]
            r13 = r1
        L_0x04c2:
            r0 = 0
        L_0x04c3:
            double[] r1 = r13.xreturn
            int r1 = r1.length
            if (r0 >= r1) goto L_0x04d1
            double[] r1 = r13.xreturn
            r21 = 0
            r1[r0] = r21
            int r0 = r0 + 1
            goto L_0x04c3
        L_0x04d1:
            r21 = 0
            r0 = 0
        L_0x04d4:
            r1 = 5
            if (r0 > r1) goto L_0x04e4
            double[] r1 = r13.xreturn
            int r2 = r0 + 6
            double[] r3 = r13.x
            r4 = r3[r0]
            r1[r2] = r4
            int r0 = r0 + 1
            goto L_0x04d4
        L_0x04e4:
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            double[] r2 = r13.xreturn
            r3 = 6
            r4 = 0
            r0.swi_cartpol_sp(r1, r3, r2, r4)
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            r37 = 6
            double[] r2 = r13.xreturn
            r39 = 18
            r15 = r34
            double r3 = r15.seps
            double r3 = -r3
            double r5 = r15.ceps
            r35 = r0
            r36 = r1
            r38 = r2
            r40 = r3
            r42 = r5
            r35.swi_coortrf2(r36, r37, r38, r39, r40, r42)
            r6 = r14 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x052d
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            r28 = 9
            double[] r2 = r13.xreturn
            r30 = 21
            double r3 = r15.seps
            double r3 = -r3
            double r7 = r15.ceps
            r26 = r0
            r27 = r1
            r29 = r2
            r31 = r3
            r33 = r7
            r26.swi_coortrf2(r27, r28, r29, r30, r31, r33)
        L_0x052d:
            r0 = r14 & 64
            if (r0 != 0) goto L_0x057e
            r8 = r55
            swisseph.SwissLib r1 = r8.sl
            double[] r2 = r13.xreturn
            r28 = 18
            double[] r3 = r13.xreturn
            r30 = 18
            swisseph.SwissData r4 = r8.swed
            swisseph.Nut r4 = r4.nut
            double r4 = r4.snut
            double r4 = -r4
            swisseph.SwissData r7 = r8.swed
            swisseph.Nut r7 = r7.nut
            double r9 = r7.cnut
            r26 = r1
            r27 = r2
            r29 = r3
            r31 = r4
            r33 = r9
            r26.swi_coortrf2(r27, r28, r29, r30, r31, r33)
            if (r6 == 0) goto L_0x0580
            swisseph.SwissLib r1 = r8.sl
            double[] r2 = r13.xreturn
            r33 = 21
            double[] r3 = r13.xreturn
            r35 = 21
            swisseph.SwissData r4 = r8.swed
            swisseph.Nut r4 = r4.nut
            double r4 = r4.snut
            double r4 = -r4
            swisseph.SwissData r7 = r8.swed
            swisseph.Nut r7 = r7.nut
            double r9 = r7.cnut
            r31 = r1
            r32 = r2
            r34 = r3
            r36 = r4
            r38 = r9
            r31.swi_coortrf2(r32, r33, r34, r35, r36, r38)
            goto L_0x0580
        L_0x057e:
            r8 = r55
        L_0x0580:
            swisseph.SwissLib r1 = r8.sl
            double[] r2 = r13.xreturn
            double[] r3 = r13.xreturn
            r9 = 18
            r10 = 12
            r1.swi_cartpol_sp(r2, r9, r3, r10)
            r13.xflgs = r14
            r1 = r14 & 7
            r13.iephe = r1
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r14
            if (r1 == 0) goto L_0x066c
            swisseph.SwissData r1 = r8.swed
            swisseph.SidData r1 = r1.sidd
            int r1 = r1.sid_mode
            r2 = 256(0x100, float:3.59E-43)
            r1 = r1 & r2
            if (r1 != 0) goto L_0x05e2
            swisseph.SwissData r1 = r8.swed
            swisseph.SidData r1 = r1.sidd
            int r1 = r1.sid_mode
            r1 = r1 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x05ae
            goto L_0x05e2
        L_0x05ae:
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            double[] r2 = r13.xreturn
            r3 = 6
            r4 = 0
            r0.swi_cartpol_sp(r1, r3, r2, r4)
            double[] r0 = r13.xreturn
            r1 = r0[r4]
            double r5 = r13.teval
            double r5 = r8.swe_get_ayanamsa(r5)
            r19 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r5 = r5 * r19
            double r1 = r1 - r5
            r0[r4] = r1
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            double[] r2 = r13.xreturn
            r3 = 6
            r0.swi_polcart_sp(r1, r4, r2, r3)
            r9 = r11
            r1 = 5
            r4 = 6
            r18 = 256(0x100, float:3.59E-43)
            r19 = 3
            r26 = 1
            goto L_0x070b
        L_0x05e2:
            r1 = 0
        L_0x05e3:
            r2 = 5
            if (r1 > r2) goto L_0x05f1
            double[] r2 = r13.xreturn
            int r3 = r1 + 18
            r3 = r2[r3]
            r11[r1] = r3
            int r1 = r1 + 1
            goto L_0x05e3
        L_0x05f1:
            if (r0 != 0) goto L_0x05f9
            r0 = 0
            r7 = 1
            r8.swi_nutate(r11, r0, r14, r7)
            goto L_0x05fa
        L_0x05f9:
            r7 = 1
        L_0x05fa:
            swisseph.SwissLib r0 = r8.sl
            r5 = 1
            r1 = r11
            r2 = r56
            r4 = r14
            r0.swi_precess(r1, r2, r4, r5)
            if (r6 == 0) goto L_0x0610
            r5 = 1
            r0 = r55
            r1 = r11
            r2 = r56
            r4 = r14
            r0.swi_precess_speed(r1, r2, r4, r5)
        L_0x0610:
            swisseph.SwissData r0 = r8.swed
            swisseph.SidData r0 = r0.sidd
            int r0 = r0.sid_mode
            r6 = 256(0x100, float:3.59E-43)
            r0 = r0 & r6
            if (r0 == 0) goto L_0x0634
            double[] r2 = r13.xreturn
            r3 = 6
            double[] r4 = r13.xreturn
            r5 = 18
            r17 = 0
            r0 = r55
            r1 = r11
            r18 = 256(0x100, float:3.59E-43)
            r6 = r14
            r19 = 3
            r26 = 1
            r7 = r17
            r0.swi_trop_ra2sid_lon(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0653
        L_0x0634:
            r18 = 256(0x100, float:3.59E-43)
            r19 = 3
            r26 = 1
            swisseph.SwissData r0 = r8.swed
            swisseph.SidData r0 = r0.sidd
            int r0 = r0.sid_mode
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0653
            double[] r2 = r13.xreturn
            r3 = 6
            double[] r4 = r13.xreturn
            r5 = 18
            r7 = 0
            r0 = r55
            r1 = r11
            r6 = r14
            r0.swi_trop_ra2sid_lon_sosy(r1, r2, r3, r4, r5, r6, r7)
        L_0x0653:
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            double[] r2 = r13.xreturn
            r3 = 6
            r4 = 0
            r0.swi_cartpol_sp(r1, r3, r2, r4)
            swisseph.SwissLib r0 = r8.sl
            double[] r1 = r13.xreturn
            double[] r2 = r13.xreturn
            r0.swi_cartpol_sp(r1, r9, r2, r10)
            r9 = r11
            r1 = 5
            r4 = 6
            goto L_0x070b
        L_0x066c:
            r18 = 256(0x100, float:3.59E-43)
            r19 = 3
            r26 = 1
            r0 = r14 & 32
            if (r0 == 0) goto L_0x0708
            r0 = 0
        L_0x0677:
            r1 = 5
            if (r0 > r1) goto L_0x0685
            double[] r1 = r13.xreturn
            int r2 = r0 + 18
            r2 = r1[r2]
            r11[r0] = r2
            int r0 = r0 + 1
            goto L_0x0677
        L_0x0685:
            swisseph.SwissLib r0 = r8.sl
            r5 = 1
            r1 = r11
            r2 = r56
            r4 = r14
            r0.swi_precess(r1, r2, r4, r5)
            if (r6 == 0) goto L_0x069b
            r5 = 1
            r0 = r55
            r1 = r11
            r2 = r56
            r4 = r14
            r0.swi_precess_speed(r1, r2, r4, r5)
        L_0x069b:
            r0 = 0
        L_0x069c:
            r1 = 5
            if (r0 > r1) goto L_0x06aa
            double[] r2 = r13.xreturn
            int r3 = r0 + 18
            r4 = r11[r0]
            r2[r3] = r4
            int r0 = r0 + 1
            goto L_0x069c
        L_0x06aa:
            swisseph.SwissLib r0 = r8.sl
            double[] r2 = r13.xreturn
            double[] r3 = r13.xreturn
            r0.swi_cartpol_sp(r2, r9, r3, r10)
            swisseph.SwissLib r0 = r8.sl
            double[] r2 = r13.xreturn
            r29 = 18
            double[] r3 = r13.xreturn
            r31 = 6
            swisseph.SwissData r4 = r8.swed
            swisseph.Epsilon r4 = r4.oec2000
            double r4 = r4.seps
            swisseph.SwissData r7 = r8.swed
            swisseph.Epsilon r7 = r7.oec2000
            r9 = r11
            double r10 = r7.ceps
            r27 = r0
            r28 = r2
            r30 = r3
            r32 = r4
            r34 = r10
            r27.swi_coortrf2(r28, r29, r30, r31, r32, r34)
            if (r6 == 0) goto L_0x06fc
            swisseph.SwissLib r0 = r8.sl
            double[] r2 = r13.xreturn
            r34 = 21
            double[] r3 = r13.xreturn
            r36 = 9
            swisseph.SwissData r4 = r8.swed
            swisseph.Epsilon r4 = r4.oec2000
            double r4 = r4.seps
            swisseph.SwissData r6 = r8.swed
            swisseph.Epsilon r6 = r6.oec2000
            double r6 = r6.ceps
            r32 = r0
            r33 = r2
            r35 = r3
            r37 = r4
            r39 = r6
            r32.swi_coortrf2(r33, r34, r35, r36, r37, r39)
        L_0x06fc:
            swisseph.SwissLib r0 = r8.sl
            double[] r2 = r13.xreturn
            double[] r3 = r13.xreturn
            r4 = 6
            r5 = 0
            r0.swi_cartpol_sp(r2, r4, r3, r5)
            goto L_0x070b
        L_0x0708:
            r9 = r11
            r1 = 5
            r4 = 6
        L_0x070b:
            r0 = 0
        L_0x070c:
            r5 = 2
            if (r0 >= r5) goto L_0x073d
            double[] r2 = r13.xreturn
            r6 = r2[r0]
            r10 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r6 = r6 * r10
            r2[r0] = r6
            double[] r2 = r13.xreturn
            int r3 = r0 + 3
            r6 = r2[r3]
            double r6 = r6 * r10
            r2[r3] = r6
            double[] r2 = r13.xreturn
            int r3 = r0 + 12
            r6 = r2[r3]
            double r6 = r6 * r10
            r2[r3] = r6
            double[] r2 = r13.xreturn
            int r3 = r0 + 15
            r6 = r2[r3]
            double r6 = r6 * r10
            r2[r3] = r6
            int r0 = r0 + 1
            goto L_0x070c
        L_0x073d:
            double[] r0 = r13.xreturn
            swisseph.SwissLib r2 = r8.sl
            double[] r3 = r13.xreturn
            r6 = 0
            r10 = r3[r6]
            double r2 = r2.swe_degnorm(r10)
            r0[r6] = r2
            double[] r0 = r13.xreturn
            swisseph.SwissLib r2 = r8.sl
            double[] r3 = r13.xreturn
            r6 = 12
            r10 = r3[r6]
            double r2 = r2.swe_degnorm(r10)
            r0[r6] = r2
            int r12 = r12 + 1
            r11 = r9
            r34 = r15
            r9 = r56
            goto L_0x04ac
        L_0x0765:
            r1 = 0
            return r1
        L_0x0767:
            r3 = r14
            r15 = r34
            r1 = 0
            r4 = 6
            r5 = 2
            r18 = 256(0x100, float:3.59E-43)
            r21 = 0
            r26 = 1
            r14 = r6
            r9 = r56
            r4 = r14
            r18 = r15
            r6 = r27
            r1 = r28
            r13 = 0
            r14 = 4
            r15 = 1
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.lunar_osc_elem(double, int, int, java.lang.StringBuffer):int");
    }

    private int intp_apsides(double d, int i, int i2, StringBuffer stringBuffer) {
        double[] dArr;
        int i3;
        int i4;
        int i5;
        double d2 = d;
        int i6 = i;
        int i7 = i2;
        StringBuffer stringBuffer2 = stringBuffer;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, new int[]{3, 6});
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        if (d2 >= 625000.5d && d2 <= 2818000.5d) {
            Epsilon epsilon = this.swed.oec;
            Nut nut = this.swed.nut;
            PlanData planData = this.swed.nddat[i6];
            int i8 = i7 & -2049 & -4097;
            int i9 = planData.xflgs & -2049 & -4097;
            int i10 = i7 & 256;
            int i11 = planData.xflgs & 256;
            Nut nut2 = nut;
            if (d2 != planData.teval || d2 == 0.0d || i8 != i9 || (i10 != 0 && i11 == 0)) {
                double d3 = d2 - 0.1d;
                for (int i12 = 0; i12 < 3; i12++) {
                    if (i10 != 0 || i12 == 1) {
                        this.sm.swi_intp_apsides(d3, dArr2[i12], i6);
                    }
                    d3 += 0.1d;
                }
                for (int i13 = 0; i13 < 3; i13++) {
                    dArr3[i13] = dArr2[1][i13];
                    dArr3[i13 + 3] = 0.0d;
                }
                if (i10 != 0) {
                    i3 = i10;
                    dArr = dArr4;
                    dArr3[3] = (this.sl.swe_difrad2n(dArr2[2][0], dArr2[0][0]) / 0.1d) / 2.0d;
                    i4 = 1;
                    dArr3[4] = ((dArr2[2][1] - dArr2[0][1]) / 0.1d) / 2.0d;
                    dArr3[5] = ((dArr2[2][2] - dArr2[0][2]) / 0.1d) / 2.0d;
                } else {
                    dArr = dArr4;
                    i3 = i10;
                    i4 = 1;
                }
                for (int i14 = 0; i14 < 24; i14++) {
                    planData.xreturn[i14] = 0.0d;
                }
                this.sl.swi_polcart_sp(dArr3, dArr3);
                if ((i7 & 16) == 0) {
                    double sqrt = ((SMath.sqrt(this.sl.square_sum(dArr3)) * 1.4959787066E11d) / 2.99792458E8d) / 86400.0d;
                    while (i4 < 3) {
                        dArr3[i4] = dArr3[i4] - (dArr3[i4 + 3] * sqrt);
                        i4++;
                    }
                }
                for (int i15 = 0; i15 <= 5; i15++) {
                    planData.xreturn[i15 + 6] = dArr3[i15];
                }
                this.sl.swi_coortrf2(planData.xreturn, 6, planData.xreturn, 18, -epsilon.seps, epsilon.ceps);
                if (i3 != 0) {
                    this.sl.swi_coortrf2(planData.xreturn, 9, planData.xreturn, 21, -epsilon.seps, epsilon.ceps);
                }
                planData.teval = d2;
                planData.xflgs = i7;
                planData.iephe = i7 & 7;
                if ((65536 & i7) != 0) {
                    if ((this.swed.sidd.sid_mode & 256) == 0) {
                        if ((this.swed.sidd.sid_mode & 512) == 0) {
                            this.sl.swi_cartpol_sp(planData.xreturn, 6, planData.xreturn, 0);
                            double[] dArr5 = planData.xreturn;
                            dArr5[0] = dArr5[0] - (swe_get_ayanamsa(planData.teval) * 0.0174532925199433d);
                            this.sl.swi_polcart_sp(planData.xreturn, 0, planData.xreturn, 6);
                            this.sl.swi_cartpol_sp(planData.xreturn, 18, planData.xreturn, 12);
                            i5 = 0;
                        }
                    }
                    for (int i16 = 0; i16 <= 5; i16++) {
                        dArr[i16] = planData.xreturn[i16 + 18];
                    }
                    i5 = 0;
                    this.sl.swi_precess(dArr, d, i2, 1);
                    if (i3 != 0) {
                        swi_precess_speed(dArr, d, i2, 1);
                    }
                    if ((this.swed.sidd.sid_mode & 256) != 0) {
                        swi_trop_ra2sid_lon(dArr, planData.xreturn, 6, planData.xreturn, 18, i2, (StringBuffer) null);
                    } else if ((this.swed.sidd.sid_mode & 512) != 0) {
                        swi_trop_ra2sid_lon_sosy(dArr, planData.xreturn, 6, planData.xreturn, 18, i2, (StringBuffer) null);
                    }
                    this.sl.swi_cartpol_sp(planData.xreturn, 6, planData.xreturn, 0);
                    this.sl.swi_cartpol_sp(planData.xreturn, 18, planData.xreturn, 12);
                } else {
                    i5 = 0;
                    if ((i7 & 32) != 0) {
                        for (int i17 = 0; i17 <= 5; i17++) {
                            dArr[i17] = planData.xreturn[i17 + 18];
                        }
                        this.sl.swi_precess(dArr, d, i2, 1);
                        if (i3 != 0) {
                            swi_precess_speed(dArr, d, i2, 1);
                        }
                        for (int i18 = 0; i18 <= 5; i18++) {
                            planData.xreturn[i18 + 18] = dArr[i18];
                        }
                        this.sl.swi_cartpol_sp(planData.xreturn, 18, planData.xreturn, 12);
                        this.sl.swi_coortrf2(planData.xreturn, 18, planData.xreturn, 6, this.swed.oec2000.seps, this.swed.oec2000.ceps);
                        if (i3 != 0) {
                            this.sl.swi_coortrf2(planData.xreturn, 21, planData.xreturn, 9, this.swed.oec2000.seps, this.swed.oec2000.ceps);
                        }
                        this.sl.swi_cartpol_sp(planData.xreturn, 6, planData.xreturn, 0);
                    } else {
                        int i19 = i7 & 64;
                        if (i19 == 0) {
                            swi_nutate(planData.xreturn, 18, i7, false);
                        }
                        this.sl.swi_cartpol_sp(planData.xreturn, 18, planData.xreturn, 12);
                        this.sl.swi_coortrf2(planData.xreturn, 18, planData.xreturn, 6, epsilon.seps, epsilon.ceps);
                        if (i3 != 0) {
                            this.sl.swi_coortrf2(planData.xreturn, 21, planData.xreturn, 9, epsilon.seps, epsilon.ceps);
                        }
                        if (i19 == 0) {
                            Nut nut3 = nut2;
                            this.sl.swi_coortrf2(planData.xreturn, 6, planData.xreturn, 6, nut3.snut, nut3.cnut);
                            if (i3 != 0) {
                                this.sl.swi_coortrf2(planData.xreturn, 9, planData.xreturn, 9, nut3.snut, nut3.cnut);
                            }
                        }
                        this.sl.swi_cartpol_sp(planData.xreturn, 6, planData.xreturn, 0);
                    }
                }
                for (int i20 = 0; i20 < 2; i20++) {
                    double[] dArr6 = planData.xreturn;
                    dArr6[i20] = dArr6[i20] * 57.2957795130823d;
                    double[] dArr7 = planData.xreturn;
                    int i21 = i20 + 3;
                    dArr7[i21] = dArr7[i21] * 57.2957795130823d;
                    double[] dArr8 = planData.xreturn;
                    int i22 = i20 + 12;
                    dArr8[i22] = dArr8[i22] * 57.2957795130823d;
                    double[] dArr9 = planData.xreturn;
                    int i23 = i20 + 15;
                    dArr9[i23] = dArr9[i23] * 57.2957795130823d;
                }
                planData.xreturn[i5] = this.sl.swe_degnorm(planData.xreturn[i5]);
                planData.xreturn[12] = this.sl.swe_degnorm(planData.xreturn[12]);
                return i5;
            }
            planData.xflgs = i7;
            planData.iephe = i7 & 4;
            return 0;
        } else if (stringBuffer2 == null) {
            return -1;
        } else {
            String str = "jd " + d2 + " outside Moshier's Moon range " + 625000.5d + " .. " + 2818000.5d + " ";
            if (stringBuffer.length() + str.length() >= 256) {
                return -1;
            }
            stringBuffer2.append(str);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int swi_plan_for_osc_elem(int i, double d, double[] dArr) {
        int i2 = i;
        double d2 = d;
        double[] dArr2 = new double[6];
        Nut nut = new Nut();
        Epsilon epsilon = this.swed.oec;
        Epsilon epsilon2 = new Epsilon();
        if ((131072 & i2) == 0 && this.swed.jpldenum >= 403) {
            this.sl.swi_bias(dArr, d, i, false);
        }
        double[] dArr3 = dArr;
        this.sl.swi_precess(dArr3, d, i, -1);
        this.sl.swi_precess(dArr3, 3, d, i, -1);
        if (d2 == this.swed.oec.teps) {
            epsilon2 = this.swed.oec;
        } else if (d2 == 2451545.0d) {
            epsilon2 = this.swed.oec2000;
        } else {
            calc_epsilon(d2, i2, epsilon2);
        }
        int i3 = i2 & 64;
        if (i3 == 0) {
            if (d2 == this.swed.nut.tnut) {
                nut = this.swed.nut;
            } else if (d2 == 2451545.0d) {
                nut = this.swed.nut2000;
            } else if (d2 == this.swed.nutv.tnut) {
                nut = this.swed.nutv;
            } else {
                this.sl.swi_nutation(d2, i2, nut.nutlo);
                nut.tnut = d2;
                nut.snut = SMath.sin(nut.nutlo[1]);
                nut.cnut = SMath.cos(nut.nutlo[1]);
                nut_matrix(nut, epsilon2);
            }
            for (int i4 = 0; i4 <= 2; i4++) {
                dArr2[i4] = (dArr[0] * nut.matrix[0][i4]) + (dArr[1] * nut.matrix[1][i4]) + (dArr[2] * nut.matrix[2][i4]);
            }
            for (int i5 = 0; i5 <= 2; i5++) {
                dArr2[i5 + 3] = (dArr[3] * nut.matrix[0][i5]) + (dArr[4] * nut.matrix[1][i5]) + (dArr[5] * nut.matrix[2][i5]);
            }
            for (int i6 = 0; i6 <= 5; i6++) {
                dArr[i6] = dArr2[i6];
            }
        }
        double[] dArr4 = dArr;
        this.sl.swi_coortrf2(dArr4, dArr, epsilon2.seps, epsilon2.ceps);
        this.sl.swi_coortrf2(dArr4, 3, dArr, 3, epsilon2.seps, epsilon2.ceps);
        if (i3 == 0) {
            double[] dArr5 = dArr;
            this.sl.swi_coortrf2(dArr5, dArr, nut.snut, nut.cnut);
            this.sl.swi_coortrf2(dArr5, 3, dArr, 3, nut.snut, nut.cnut);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public double meff(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int i = 0;
        while (true) {
            MeffEle[] meffEleArr = eff_arr;
            if (meffEleArr[i].r > d) {
                i++;
            } else {
                int i2 = i - 1;
                return meffEleArr[i2].m + (((d - meffEleArr[i2].r) / (meffEleArr[i].r - meffEleArr[i2].r)) * (meffEleArr[i].m - meffEleArr[i2].m));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void denormalize_positions(double[] dArr, double[] dArr2, double[] dArr3) {
        for (int i = 0; i <= 12; i += 12) {
            if (dArr2[i] - dArr[i] < -180.0d) {
                dArr[i] = dArr[i] - 360.0d;
            }
            if (dArr2[i] - dArr[i] > 180.0d) {
                dArr[i] = dArr[i] + 360.0d;
            }
            if (dArr2[i] - dArr3[i] < -180.0d) {
                dArr3[i] = dArr3[i] - 360.0d;
            }
            if (dArr2[i] - dArr3[i] > 180.0d) {
                dArr3[i] = dArr3[i] + 360.0d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void calc_speed(double[] dArr, double[] dArr2, double[] dArr3, double d) {
        for (int i = 0; i <= 18; i += 6) {
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = i + i2;
                dArr2[i3 + 3] = (((((dArr3[i3] + dArr[i3]) / 2.0d) - dArr2[i3]) * 2.0d) + ((dArr3[i3] - dArr[i3]) / 2.0d)) / d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void swi_check_ecliptic(double d, int i) {
        if (this.swed.oec2000.teps != 2451545.0d) {
            calc_epsilon(2451545.0d, i, this.swed.oec2000);
        }
        if (d == 2451545.0d) {
            this.swed.oec.teps = this.swed.oec2000.teps;
            this.swed.oec.eps = this.swed.oec2000.eps;
            this.swed.oec.seps = this.swed.oec2000.seps;
            this.swed.oec.ceps = this.swed.oec2000.ceps;
        } else if (this.swed.oec.teps != d || d == 0.0d) {
            calc_epsilon(d, i, this.swed.oec);
        }
    }

    /* access modifiers changed from: package-private */
    public void swi_check_nutation(double d, int i) {
        int i2 = this.chck_nut_nutflag & 256;
        int i3 = i & 256;
        if ((i & 64) != 0) {
            return;
        }
        if (d != this.swed.nut.tnut || d == 0.0d || (i2 == 0 && i3 != 0)) {
            this.sl.swi_nutation(d, i, this.swed.nut.nutlo);
            this.swed.nut.tnut = d;
            this.swed.nut.snut = SMath.sin(this.swed.nut.nutlo[1]);
            this.swed.nut.cnut = SMath.cos(this.swed.nut.nutlo[1]);
            this.chck_nut_nutflag = i;
            nut_matrix(this.swed.nut, this.swed.oec);
            if (i3 != 0) {
                double d2 = d - 1.0E-4d;
                this.sl.swi_nutation(d2, i, this.swed.nutv.nutlo);
                this.swed.nutv.tnut = d2;
                this.swed.nutv.snut = SMath.sin(this.swed.nutv.nutlo[1]);
                this.swed.nutv.cnut = SMath.cos(this.swed.nutv.nutlo[1]);
                nut_matrix(this.swed.nutv, this.swed.oec);
            }
        }
    }

    private int plaus_iflag(int i, int i2, double d, StringBuffer stringBuffer) {
        int i3;
        if ((i & 262144) != 0) {
            i &= -524289;
        }
        if ((32768 & i) != 0) {
            i = i & -16393 & -786433;
        }
        if ((i & 8) != 0) {
            i |= 1536;
        }
        if ((i & 16384) != 0) {
            i |= 1536;
        }
        if ((i & 32) != 0) {
            i |= 64;
        }
        if ((i & 16) != 0) {
            i |= 1536;
        }
        if ((65536 & i) != 0) {
            i = (i | 64) & -786433;
        }
        if ((i & 4) != 0) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        int i4 = 2;
        if ((i & 2) != 0) {
            i3 = 2;
        }
        if (i3 != 0) {
            i4 = i3;
        }
        int i5 = (i & -8) | i4;
        if (i2 == 13 || i2 == 11 || i2 == 12 || i2 == 10 || i2 == 21 || i2 == 22) {
            i5 &= -786433;
        }
        if (i2 >= 40 && i2 <= 999) {
            i5 &= -786433;
        }
        if ((i5 & 262144) != 0) {
            if (this.swed.eop_dpsi_loaded <= 0) {
                if (stringBuffer != null) {
                    int i6 = this.swed.eop_dpsi_loaded;
                    if (i6 == -3) {
                        stringBuffer.setLength(0);
                        stringBuffer.append("file eop_finals.txt corrupt; default to SEFLG_JPLHOR_APPROX");
                    } else if (i6 == -2) {
                        stringBuffer.setLength(0);
                        stringBuffer.append("file eop_1962_today.txt corrupt; default to SEFLG_JPLHOR_APPROX");
                    } else if (i6 == -1) {
                        stringBuffer.setLength(0);
                        stringBuffer.append("file eop_1962_today.txt not found; default to SEFLG_JPLHOR_APPROX");
                    } else if (i6 == 0) {
                        stringBuffer.setLength(0);
                        stringBuffer.append("you did not call swe_set_jpl_file(); default to SEFLG_JPLHOR_APPROX");
                    }
                }
                i5 = (i5 & -262145) | 524288;
            } else if (d >= this.swed.eop_tjd_beg) {
                int i7 = (d > this.swed.eop_tjd_end ? 1 : (d == this.swed.eop_tjd_end ? 0 : -1));
            }
        }
        if ((i5 & 262144) != 0) {
            return i5 | 131072;
        }
        return i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: double[]} */
    /* JADX WARNING: type inference failed for: r11v14, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_fixstar_found(java.lang.StringBuffer r45, java.lang.String r46, java.lang.StringBuffer r47, int r48, double r49, int r51, int r52, int r53, double[] r54) {
        /*
            r44 = this;
            r8 = r44
            r9 = r45
            r1 = r47
            r10 = r49
            r12 = r51
            r13 = r54
            r2 = 6
            double[] r7 = new double[r2]
            double[] r6 = new double[r2]
            double[] r5 = new double[r2]
            swisseph.SwissData r0 = r8.swed
            swisseph.PlanData[] r0 = r0.pldat
            r4 = 0
            r3 = r0[r4]
            swisseph.SwissData r0 = r8.swed
            swisseph.PlanData[] r0 = r0.pldat
            r14 = 10
            r15 = r0[r14]
            swisseph.SwissData r0 = r8.swed
            swisseph.Epsilon r0 = r0.oec2000
            r0 = 20
            java.lang.String[] r14 = new java.lang.String[r0]
            java.util.StringTokenizer r2 = new java.util.StringTokenizer
            java.lang.String r4 = ","
            r0 = r46
            r2.<init>(r0, r4)
            int r0 = r2.countTokens()
            r10 = -1
            r11 = 2
            if (r0 >= r11) goto L_0x005c
            if (r9 == 0) goto L_0x0057
            r1 = 0
            r9.setLength(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "star file sefstars.txt damaged at line "
            r0.append(r1)
            r1 = r48
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.append(r0)
        L_0x0057:
            int r0 = r8.swe_fixstar_error(r13, r10)
            return r0
        L_0x005c:
            r11 = 0
        L_0x005d:
            boolean r19 = r2.hasMoreTokens()
            if (r19 == 0) goto L_0x0073
            r10 = 20
            if (r11 >= r10) goto L_0x0073
            int r18 = r11 + 1
            java.lang.String r19 = r2.nextToken()
            r14[r11] = r19
            r11 = r18
            r10 = -1
            goto L_0x005d
        L_0x0073:
            r2 = 0
            r10 = r14[r2]
            java.lang.String r10 = r10.trim()
            r14[r2] = r10
            r2 = 1
            r10 = r14[r2]
            java.lang.String r10 = r10.trim()
            r14[r2] = r10
            r10 = 13
            if (r0 >= r10) goto L_0x00b8
            if (r9 == 0) goto L_0x00b2
            r1 = 0
            r9.setLength(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "data of star '"
            r0.append(r3)
            r1 = r14[r1]
            r0.append(r1)
            r0.append(r4)
            r1 = r14[r2]
            r0.append(r1)
            java.lang.String r1 = "' incomplete"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.append(r0)
        L_0x00b2:
            r1 = -1
            int r0 = r8.swe_fixstar_error(r13, r1)
            return r0
        L_0x00b8:
            r10 = 2
            r0 = r14[r10]
            int r0 = r0.length()
            r11 = r0
        L_0x00c0:
            r23 = 0
            r0 = r14[r10]     // Catch:{ NumberFormatException -> 0x00d2 }
            r10 = 0
            java.lang.String r0 = r0.substring(r10, r11)     // Catch:{ NumberFormatException -> 0x00d2 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00d2 }
            double r10 = r0.doubleValue()     // Catch:{ NumberFormatException -> 0x00d2 }
            goto L_0x00d9
        L_0x00d2:
            r0 = move-exception
            int r11 = r11 + -1
            if (r11 != 0) goto L_0x05db
            r10 = r23
        L_0x00d9:
            java.lang.Double r0 = new java.lang.Double
            r22 = 3
            r2 = r14[r22]
            r0.<init>(r2)
            double r18 = r0.doubleValue()
            java.lang.Double r0 = new java.lang.Double
            r2 = 4
            r25 = r3
            r3 = r14[r2]
            r0.<init>(r3)
            double r26 = r0.doubleValue()
            java.lang.Double r0 = new java.lang.Double
            r3 = 5
            r2 = r14[r3]
            r0.<init>(r2)
            double r28 = r0.doubleValue()
            java.lang.Double r0 = new java.lang.Double
            r2 = 6
            r3 = r14[r2]
            r0.<init>(r3)
            double r30 = r0.doubleValue()
            r0 = r14[r2]
            java.lang.Double r2 = new java.lang.Double
            r32 = 7
            r3 = r14[r32]
            r2.<init>(r3)
            double r2 = r2.doubleValue()
            r33 = r5
            java.lang.Double r5 = new java.lang.Double
            r17 = 8
            r34 = r6
            r6 = r14[r17]
            r5.<init>(r6)
            double r5 = r5.doubleValue()
            java.lang.Double r9 = new java.lang.Double
            r17 = 9
            r35 = r15
            r15 = r14[r17]
            r9.<init>(r15)
            double r36 = r9.doubleValue()
            java.lang.Double r9 = new java.lang.Double
            r15 = 10
            r15 = r14[r15]
            r9.<init>(r15)
            double r15 = r9.doubleValue()
            java.lang.Double r9 = new java.lang.Double
            r17 = 11
            r13 = r14[r17]
            r9.<init>(r13)
            double r38 = r9.doubleValue()
            java.lang.Double r9 = new java.lang.Double
            r13 = 12
            r13 = r14[r13]
            r9.<init>(r13)
            double r40 = r9.doubleValue()
            r9 = 0
            r13 = r14[r9]
            int r13 = r13.length()
            r9 = 256(0x100, float:3.59E-43)
            if (r13 <= r9) goto L_0x0177
            r13 = 0
            r12 = r14[r13]
            java.lang.String r12 = r12.substring(r13, r9)
            r14[r13] = r12
            goto L_0x0178
        L_0x0177:
            r13 = 0
        L_0x0178:
            r12 = 1
            r17 = r14[r12]
            int r9 = r17.length()
            r13 = 255(0xff, float:3.57E-43)
            if (r9 <= r13) goto L_0x018f
            r9 = r14[r12]
            r42 = r10
            r10 = 0
            java.lang.String r9 = r9.substring(r10, r13)
            r14[r12] = r9
            goto L_0x0192
        L_0x018f:
            r42 = r10
            r10 = 0
        L_0x0192:
            r1.setLength(r10)
            r9 = r14[r10]
            r1.append(r9)
            r9 = r14[r10]
            int r9 = r9.length()
            r10 = 1
            r11 = r14[r10]
            int r11 = r11.length()
            int r9 = r9 + r11
            int r9 = r9 + r10
            if (r9 >= r13) goto L_0x01bf
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            r4 = r14[r10]
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r1.append(r4)
        L_0x01bf:
            r9 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r28 = r28 / r9
            r11 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r26 = r26 / r11
            double r28 = r28 + r26
            double r28 = r28 + r18
            r13 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r28 = r28 * r13
            r1 = 45
            int r0 = r0.indexOf(r1)
            if (r0 >= 0) goto L_0x01e0
            double r5 = r5 / r9
            double r2 = r2 / r11
            double r5 = r5 + r2
            double r5 = r5 + r30
            goto L_0x01e6
        L_0x01e0:
            double r0 = -r5
            double r0 = r0 / r9
            double r2 = r2 / r11
            double r0 = r0 - r2
            double r5 = r0 + r30
        L_0x01e6:
            swisseph.SwissData r0 = r8.swed
            boolean r0 = r0.is_old_starfile
            if (r0 == 0) goto L_0x01f4
            r0 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r36 = r36 * r0
            double r36 = r36 / r9
            double r15 = r15 / r9
            goto L_0x0203
        L_0x01f4:
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r36 = r36 / r0
            double r36 = r36 / r9
            double r15 = r15 / r0
            double r15 = r15 / r9
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r40 = r40 / r0
        L_0x0203:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r40 > r0 ? 1 : (r40 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x020d
            double r2 = r0 / r40
            double r2 = r2 / r9
            goto L_0x020f
        L_0x020d:
            double r2 = r40 / r9
        L_0x020f:
            r9 = 4626630932315840184(0x40351851eb851eb8, double:21.095)
            double r38 = r38 * r9
            r9 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r28 = r28 * r9
            double r5 = r5 * r9
            double r36 = r36 * r9
            double r15 = r15 * r9
            double r11 = swisseph.SMath.cos(r5)
            double r11 = r36 / r11
            double r26 = r2 * r9
            r4 = 0
            r7[r4] = r28
            r2 = 1
            r7[r2] = r5
            r2 = 2
            r7[r2] = r0
            swisseph.SwissLib r0 = r8.sl
            r0.swi_polcart(r7, r7)
            double r0 = swisseph.SMath.cos(r28)
            double r2 = swisseph.SMath.cos(r5)
            double r13 = swisseph.SMath.sin(r28)
            double r5 = swisseph.SMath.sin(r5)
            double r9 = -r11
            double r9 = r9 * r2
            double r9 = r9 * r13
            double r17 = r15 * r5
            double r30 = r17 * r0
            double r9 = r9 - r30
            double r38 = r38 * r26
            double r30 = r38 * r2
            double r36 = r30 * r0
            double r9 = r9 + r36
            r7[r22] = r9
            double r11 = r11 * r2
            double r11 = r11 * r0
            double r17 = r17 * r13
            double r11 = r11 - r17
            double r30 = r30 * r13
            double r11 = r11 + r30
            r0 = 4
            r7[r0] = r11
            double r15 = r15 * r2
            double r38 = r38 * r5
            double r15 = r15 + r38
            r0 = 5
            r7[r0] = r15
            r1 = r7[r22]
            r5 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r1 = r1 / r5
            r7[r22] = r1
            r1 = 4
            r2 = r7[r1]
            double r2 = r2 / r5
            r7[r1] = r2
            r1 = r7[r0]
            double r1 = r1 / r5
            r7[r0] = r1
            r1 = 4656291006143004672(0x409e780000000000, double:1950.0)
            int r9 = (r42 > r1 ? 1 : (r42 == r1 ? 0 : -1))
            if (r9 != 0) goto L_0x02c0
            swisseph.SwissLib r1 = r8.sl
            r2 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r1.swi_FK4_FK5(r7, r2)
            swisseph.SwissLib r14 = r8.sl
            r16 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r18 = 0
            r19 = 1
            r10 = r35
            r15 = r7
            r14.swi_precess(r15, r16, r18, r19)
            swisseph.SwissLib r14 = r8.sl
            r16 = 3
            r17 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r19 = 0
            r20 = 1
            r14.swi_precess(r15, r16, r17, r19, r20)
            goto L_0x02c2
        L_0x02c0:
            r10 = r35
        L_0x02c2:
            int r1 = (r42 > r23 ? 1 : (r42 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x02e6
            swisseph.SwissLib r1 = r8.sl
            r12 = r51
            r3 = 1
            r1.swi_icrs2fk5(r7, r12, r3)
            swisseph.SwissData r1 = r8.swed
            int r1 = r1.jpldenum
            r2 = 403(0x193, float:5.65E-43)
            if (r1 >= r2) goto L_0x02e8
            swisseph.SwissLib r14 = r8.sl
            r16 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r18 = 256(0x100, float:3.59E-43)
            r19 = 0
            r15 = r7
            r14.swi_bias(r15, r16, r18, r19)
            goto L_0x02e8
        L_0x02e6:
            r12 = r51
        L_0x02e8:
            r1 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r1 != 0) goto L_0x032a
            r1 = r12 & 8
            if (r1 == 0) goto L_0x02fe
            r1 = r12 & 4
            if (r1 != 0) goto L_0x02f5
            goto L_0x02fe
        L_0x02f5:
            r14 = r7
            r13 = r25
            r16 = r33
            r15 = r34
            r11 = 0
            goto L_0x0332
        L_0x02fe:
            r5 = 0
            r1 = r44
            r13 = r25
            r2 = r49
            r11 = 0
            r4 = r5
            r16 = r33
            r5 = r53
            r15 = r34
            r6 = r51
            r14 = r7
            r7 = r45
            int r1 = r1.main_planet(r2, r4, r5, r6, r7)
            if (r1 == 0) goto L_0x0320
            r1 = -32777(0xffffffffffff7ff7, float:NaN)
            r1 = r1 & r12
            r1 = r1 | 16912(0x4210, float:2.3699E-41)
            r12 = r1
            goto L_0x0332
        L_0x0320:
            swisseph.SwissData r1 = r8.swed
            swisseph.PlanData[] r1 = r1.pldat
            r1 = r1[r11]
            int r1 = r1.xflgs
            r12 = r1
            goto L_0x0332
        L_0x032a:
            r14 = r7
            r13 = r25
            r16 = r33
            r15 = r34
            r11 = 0
        L_0x0332:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0383
            swisseph.SwissData r1 = r8.swed
            swisseph.TopoData r1 = r1.topd
            double r1 = r1.teval
            double r3 = r13.teval
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0361
            swisseph.SwissData r1 = r8.swed
            swisseph.TopoData r1 = r1.topd
            double r1 = r1.teval
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 != 0) goto L_0x034f
            goto L_0x0361
        L_0x034f:
            r4 = 0
        L_0x0350:
            if (r4 > r0) goto L_0x035f
            swisseph.SwissData r1 = r8.swed
            swisseph.TopoData r1 = r1.topd
            double[] r1 = r1.xobs
            r2 = r1[r4]
            r16[r4] = r2
            int r4 = r4 + 1
            goto L_0x0350
        L_0x035f:
            r1 = -1
            goto L_0x0374
        L_0x0361:
            double r2 = r13.teval
            r5 = 1
            r1 = r44
            r4 = r12
            r6 = r16
            r7 = r45
            int r1 = r1.swi_get_observer(r2, r4, r5, r6, r7)
            if (r1 == 0) goto L_0x0373
            r1 = -1
            return r1
        L_0x0373:
            r1 = -1
        L_0x0374:
            r4 = 0
        L_0x0375:
            if (r4 > r0) goto L_0x039c
            r2 = r16[r4]
            double[] r5 = r13.x
            r6 = r5[r4]
            double r2 = r2 + r6
            r16[r4] = r2
            int r4 = r4 + 1
            goto L_0x0375
        L_0x0383:
            r1 = -1
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 != 0) goto L_0x039c
            r2 = r12 & 8
            if (r2 == 0) goto L_0x0390
            r2 = r12 & 4
            if (r2 != 0) goto L_0x039c
        L_0x0390:
            r4 = 0
        L_0x0391:
            if (r4 > r0) goto L_0x039c
            double[] r2 = r13.x
            r5 = r2[r4]
            r16[r4] = r5
            int r4 = r4 + 1
            goto L_0x0391
        L_0x039c:
            if (r9 != 0) goto L_0x03a9
            r2 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r6 = r49
            r9 = -1
            double r1 = r6 - r2
            goto L_0x03b3
        L_0x03a9:
            r6 = r49
            r9 = -1
            r1 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            double r1 = r6 - r1
        L_0x03b3:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x03be
            r4 = r12 & 4
            if (r4 == 0) goto L_0x03be
            r5 = 0
            r10 = r5
            goto L_0x03cd
        L_0x03be:
            if (r3 == 0) goto L_0x03c4
            double[] r5 = r10.x
            r10 = r5
            goto L_0x03cd
        L_0x03c4:
            r3 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x03cb
            r5 = 0
            r10 = r5
            goto L_0x03cd
        L_0x03cb:
            r10 = r16
        L_0x03cd:
            if (r10 != 0) goto L_0x03e2
            r4 = 0
        L_0x03d0:
            r3 = 2
            if (r4 > r3) goto L_0x0405
            r16 = r14[r4]
            int r3 = r4 + 3
            r18 = r14[r3]
            double r18 = r18 * r1
            double r16 = r16 + r18
            r14[r4] = r16
            int r4 = r4 + 1
            goto L_0x03d0
        L_0x03e2:
            r4 = 0
        L_0x03e3:
            r3 = 2
            if (r4 > r3) goto L_0x0405
            r16 = r14[r4]
            int r3 = r4 + 3
            r18 = r14[r3]
            double r18 = r18 * r1
            r20 = r10[r4]
            double r20 = r20 * r26
            double r18 = r18 - r20
            double r16 = r16 + r18
            r14[r4] = r16
            r16 = r14[r3]
            r18 = r10[r3]
            double r18 = r18 * r26
            double r16 = r16 - r18
            r14[r3] = r16
            int r4 = r4 + 1
            goto L_0x03e3
        L_0x0405:
            r4 = 0
        L_0x0406:
            if (r4 > r0) goto L_0x0416
            r1 = r14[r4]
            r16 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            double r1 = r1 * r16
            r14[r4] = r1
            int r4 = r4 + 1
            goto L_0x0406
        L_0x0416:
            r13 = r12 & 16
            if (r13 != 0) goto L_0x042d
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x042d
            r3 = 0
            r4 = 0
            r2 = r12 & 256(0x100, float:3.59E-43)
            r1 = r44
            r16 = r2
            r2 = r14
            r6 = r16
            r1.swi_deflect_light(r2, r3, r4, r6)
        L_0x042d:
            if (r13 != 0) goto L_0x0438
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0438
            r1 = r12 & 256(0x100, float:3.59E-43)
            r8.swi_aberr_light(r14, r10, r1)
        L_0x0438:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r12
            if (r1 != 0) goto L_0x0453
            swisseph.SwissData r1 = r8.swed
            int r1 = r1.jpldenum
            r2 = 403(0x193, float:5.65E-43)
            if (r1 >= r2) goto L_0x0449
            r1 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0453
        L_0x0449:
            swisseph.SwissLib r1 = r8.sl
            r6 = 0
            r2 = r14
            r3 = r49
            r5 = r12
            r1.swi_bias(r2, r3, r5, r6)
        L_0x0453:
            r4 = 0
        L_0x0454:
            if (r4 > r0) goto L_0x045d
            r1 = r14[r4]
            r15[r4] = r1
            int r4 = r4 + 1
            goto L_0x0454
        L_0x045d:
            r1 = r12 & 32
            if (r1 != 0) goto L_0x047e
            swisseph.SwissLib r1 = r8.sl
            r6 = -1
            r2 = r14
            r3 = r49
            r5 = r12
            r1.swi_precess(r2, r3, r5, r6)
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0479
            r6 = -1
            r1 = r44
            r2 = r14
            r3 = r49
            r5 = r12
            r1.swi_precess_speed(r2, r3, r5, r6)
        L_0x0479:
            swisseph.SwissData r1 = r8.swed
            swisseph.Epsilon r1 = r1.oec
            goto L_0x0482
        L_0x047e:
            swisseph.SwissData r1 = r8.swed
            swisseph.Epsilon r1 = r1.oec2000
        L_0x0482:
            r2 = r12 & 64
            if (r2 != 0) goto L_0x0489
            r8.swi_nutate(r14, r11, r11, r11)
        L_0x0489:
            swisseph.SwissLib r3 = r8.sl
            double r3 = r3.square_sum(r14)
            double r3 = swisseph.SMath.sqrt(r3)
            r5 = 0
        L_0x0494:
            if (r5 > r0) goto L_0x049e
            r6 = r14[r5]
            double r6 = r6 / r3
            r14[r5] = r6
            int r5 = r5 + 1
            goto L_0x0494
        L_0x049e:
            swisseph.SwissLib r3 = r8.sl
            double r3 = r3.square_sum(r15)
            double r3 = swisseph.SMath.sqrt(r3)
            r5 = 0
        L_0x04a9:
            if (r5 > r0) goto L_0x04b3
            r6 = r15[r5]
            double r6 = r6 / r3
            r15[r5] = r6
            int r5 = r5 + 1
            goto L_0x04a9
        L_0x04b3:
            r3 = 3
        L_0x04b4:
            if (r3 > r0) goto L_0x04bd
            r15[r3] = r23
            r14[r3] = r23
            int r3 = r3 + 1
            goto L_0x04b4
        L_0x04bd:
            r3 = r12 & 2048(0x800, float:2.87E-42)
            if (r3 != 0) goto L_0x0526
            swisseph.SwissLib r4 = r8.sl
            double r5 = r1.seps
            double r9 = r1.ceps
            r13 = r14
            r14 = r4
            r23 = r15
            r15 = r13
            r16 = r13
            r17 = r5
            r19 = r9
            r14.swi_coortrf2(r15, r16, r17, r19)
            r4 = r12 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x04ed
            swisseph.SwissLib r14 = r8.sl
            r16 = 3
            r18 = 3
            double r5 = r1.seps
            double r9 = r1.ceps
            r15 = r13
            r17 = r13
            r19 = r5
            r21 = r9
            r14.swi_coortrf2(r15, r16, r17, r18, r19, r21)
        L_0x04ed:
            if (r2 != 0) goto L_0x0529
            swisseph.SwissLib r14 = r8.sl
            swisseph.SwissData r1 = r8.swed
            swisseph.Nut r1 = r1.nut
            double r1 = r1.snut
            swisseph.SwissData r5 = r8.swed
            swisseph.Nut r5 = r5.nut
            double r5 = r5.cnut
            r15 = r13
            r16 = r13
            r17 = r1
            r19 = r5
            r14.swi_coortrf2(r15, r16, r17, r19)
            if (r4 == 0) goto L_0x0529
            swisseph.SwissLib r14 = r8.sl
            r16 = 3
            r18 = 3
            swisseph.SwissData r1 = r8.swed
            swisseph.Nut r1 = r1.nut
            double r1 = r1.snut
            swisseph.SwissData r4 = r8.swed
            swisseph.Nut r4 = r4.nut
            double r4 = r4.cnut
            r15 = r13
            r17 = r13
            r19 = r1
            r21 = r4
            r14.swi_coortrf2(r15, r16, r17, r18, r19, r21)
            goto L_0x0529
        L_0x0526:
            r13 = r14
            r23 = r15
        L_0x0529:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x059f
            swisseph.SwissData r1 = r8.swed
            swisseph.SidData r1 = r1.sidd
            int r1 = r1.sid_mode
            r2 = 256(0x100, float:3.59E-43)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0559
            r46 = r44
            r47 = r23
            r48 = r13
            r49 = r23
            r50 = r12
            r51 = r45
            int r1 = r46.swi_trop_ra2sid_lon(r47, r48, r49, r50, r51)
            if (r1 == 0) goto L_0x054d
            r1 = -1
            return r1
        L_0x054d:
            if (r3 == 0) goto L_0x059f
            r4 = 0
        L_0x0550:
            if (r4 > r0) goto L_0x059f
            r1 = r23[r4]
            r13[r4] = r1
            int r4 = r4 + 1
            goto L_0x0550
        L_0x0559:
            swisseph.SwissData r1 = r8.swed
            swisseph.SidData r1 = r1.sidd
            int r1 = r1.sid_mode
            r1 = r1 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0583
            r46 = r44
            r47 = r23
            r48 = r13
            r49 = r23
            r50 = r12
            r51 = r45
            int r1 = r46.swi_trop_ra2sid_lon_sosy(r47, r48, r49, r50, r51)
            if (r1 == 0) goto L_0x0577
            r5 = -1
            return r5
        L_0x0577:
            if (r3 == 0) goto L_0x059f
            r4 = 0
        L_0x057a:
            if (r4 > r0) goto L_0x059f
            r1 = r23[r4]
            r13[r4] = r1
            int r4 = r4 + 1
            goto L_0x057a
        L_0x0583:
            swisseph.SwissLib r1 = r8.sl
            r1.swi_cartpol_sp(r13, r13)
            r1 = r13[r11]
            r6 = r49
            double r3 = r8.swe_get_ayanamsa(r6)
            r5 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r3 = r3 * r5
            double r1 = r1 - r3
            r13[r11] = r1
            swisseph.SwissLib r1 = r8.sl
            r1.swi_polcart_sp(r13, r13)
        L_0x059f:
            r1 = r12 & 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x05a8
            swisseph.SwissLib r2 = r8.sl
            r2.swi_cartpol_sp(r13, r13)
        L_0x05a8:
            r2 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r2 != 0) goto L_0x05c8
            if (r1 != 0) goto L_0x05c8
            r4 = 0
        L_0x05af:
            r9 = 2
            if (r4 >= r9) goto L_0x05c8
            r1 = r13[r4]
            r5 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r1 = r1 * r5
            r13[r4] = r1
            int r1 = r4 + 3
            r2 = r13[r1]
            double r2 = r2 * r5
            r13[r1] = r2
            int r4 = r4 + 1
            goto L_0x05af
        L_0x05c8:
            r4 = 0
        L_0x05c9:
            if (r4 > r0) goto L_0x05d2
            r1 = r13[r4]
            r54[r4] = r1
            int r4 = r4 + 1
            goto L_0x05c9
        L_0x05d2:
            r0 = r52 & 7
            if (r0 != 0) goto L_0x05d8
            r12 = r12 & -3
        L_0x05d8:
            r0 = r12 & -257(0xfffffffffffffeff, float:NaN)
            return r0
        L_0x05db:
            r13 = r3
            r16 = r5
            r23 = r6
            r17 = r7
            r10 = r15
            r2 = 6
            r3 = 1
            r5 = -1
            r9 = 2
            r15 = 10
            r18 = 0
            r6 = r49
            r9 = r45
            r15 = r10
            r3 = r13
            r5 = r16
            r7 = r17
            r6 = r23
            r2 = 1
            r10 = 2
            r13 = r54
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.swe_fixstar_found(java.lang.StringBuffer, java.lang.String, java.lang.StringBuffer, int, double, int, int, int, double[]):int");
    }

    /* access modifiers changed from: package-private */
    public int swe_fixstar_error(double[] dArr, int i) {
        for (int i2 = 0; i2 <= 5; i2++) {
            dArr[i2] = 0.0d;
        }
        return i;
    }

    public double getFixstarMagnitude(String str) throws SwissephException {
        return getFixstarMagnitude(new StringBuffer(str));
    }

    public double getFixstarMagnitude(StringBuffer stringBuffer) throws SwissephException {
        double[] dArr = new double[1];
        try {
            swe_fixstar_mag(stringBuffer, dArr, new StringBuffer());
            return dArr[0];
        } catch (SwissephException e) {
            dArr[0] = 0.0d;
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_fixstar_mag(java.lang.StringBuffer r25, double[] r26, java.lang.StringBuffer r27) throws swisseph.SwissephException {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r0 = r27
            java.lang.String r3 = "star file sefstars.txt damaged at line "
            r4 = 20
            java.lang.String[] r5 = new java.lang.String[r4]
            r6 = 0
            r7 = 0
            r26[r6] = r7
            if (r0 == 0) goto L_0x001b
            r0.setLength(r6)
        L_0x001b:
            swisseph.SwissData r9 = r1.swed
            swisseph.FilePtr r9 = r9.fixfp
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x0050
            r9 = 4
            swisseph.SwissData r12 = r1.swed     // Catch:{ SwissephException -> 0x0031 }
            java.lang.String r13 = "sefstars.txt"
            java.lang.String r14 = r12.ephepath     // Catch:{ SwissephException -> 0x0031 }
            swisseph.FilePtr r0 = r1.swi_fopen(r9, r13, r14, r0)     // Catch:{ SwissephException -> 0x0031 }
            r12.fixfp = r0     // Catch:{ SwissephException -> 0x0031 }
            goto L_0x0050
        L_0x0031:
            r0 = move-exception
            swisseph.SwissData r0 = r1.swed
            r0.is_old_starfile = r11
            swisseph.SwissData r0 = r1.swed     // Catch:{ SwissephException -> 0x0043 }
            java.lang.String r12 = "fixstars.cat"
            java.lang.String r13 = r0.ephepath     // Catch:{ SwissephException -> 0x0043 }
            swisseph.FilePtr r9 = r1.swi_fopen(r9, r12, r13, r10)     // Catch:{ SwissephException -> 0x0043 }
            r0.fixfp = r9     // Catch:{ SwissephException -> 0x0043 }
            goto L_0x0048
        L_0x0043:
            r0 = move-exception
            swisseph.SwissData r0 = r1.swed
            r0.fixfp = r10
        L_0x0048:
            swisseph.SwissData r0 = r1.swed
            swisseph.FilePtr r0 = r0.fixfp
            if (r0 != 0) goto L_0x0050
            r0 = -1
            return r0
        L_0x0050:
            swisseph.SwissData r0 = r1.swed
            swisseph.FilePtr r0 = r0.fixfp
            r12 = 0
            r0.seek(r12)
            java.lang.String r0 = r25.toString()
            int r9 = r25.length()
            r12 = 256(0x100, float:3.59E-43)
            int r9 = swisseph.SMath.min((int) r9, (int) r12)
            java.lang.String r0 = r0.substring(r6, r9)
            int r9 = r0.length()
            r13 = 44
            if (r9 <= 0) goto L_0x00a5
            char r9 = r0.charAt(r6)
            if (r9 != r13) goto L_0x007c
            r9 = 0
            r14 = 1
            goto L_0x00a0
        L_0x007c:
            char r9 = r0.charAt(r6)
            boolean r9 = java.lang.Character.isDigit(r9)
            if (r9 == 0) goto L_0x008c
            int r9 = java.lang.Integer.parseInt(r0)
            r14 = 0
            goto L_0x00a0
        L_0x008c:
            int r9 = r0.indexOf(r13)
            if (r9 < 0) goto L_0x009a
            int r9 = r0.indexOf(r13)
            java.lang.String r0 = r0.substring(r6, r9)
        L_0x009a:
            java.lang.String r0 = r0.toLowerCase()
            r9 = 0
            r14 = 0
        L_0x00a0:
            java.lang.String r0 = r0.trim()
            goto L_0x00a7
        L_0x00a5:
            r9 = 0
            r14 = 0
        L_0x00a7:
            int r15 = r0.length()
            if (r15 == 0) goto L_0x0252
            r16 = 0
            r17 = 0
        L_0x00b1:
            swisseph.SwissData r10 = r1.swed     // Catch:{ IOException -> 0x016f }
            swisseph.FilePtr r10 = r10.fixfp     // Catch:{ IOException -> 0x016f }
            java.lang.String r10 = r10.readLine()     // Catch:{ IOException -> 0x016f }
            if (r10 == 0) goto L_0x016c
            int r7 = r16 + 1
            java.lang.String r8 = "#"
            boolean r8 = r10.startsWith(r8)     // Catch:{ IOException -> 0x0168 }
            if (r8 == 0) goto L_0x00cb
            r16 = r7
            r7 = 0
            r10 = 0
            goto L_0x00b1
        L_0x00cb:
            int r8 = r17 + 1
            if (r9 != r8) goto L_0x00d0
            goto L_0x013c
        L_0x00d0:
            if (r9 <= 0) goto L_0x00d3
            goto L_0x013f
        L_0x00d3:
            int r16 = r10.indexOf(r13)     // Catch:{ IOException -> 0x0168 }
            if (r16 < 0) goto L_0x014b
            int r11 = r10.indexOf(r13)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r11 = r10.substring(r11)     // Catch:{ IOException -> 0x0168 }
            if (r14 == 0) goto L_0x0102
            int r13 = r11.length()     // Catch:{ IOException -> 0x0168 }
            int r13 = swisseph.SMath.min((int) r13, (int) r15)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r11 = r11.substring(r6, r13)     // Catch:{ IOException -> 0x0168 }
            int r13 = r0.length()     // Catch:{ IOException -> 0x0168 }
            int r13 = swisseph.SMath.min((int) r13, (int) r15)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r13 = r0.substring(r6, r13)     // Catch:{ IOException -> 0x0168 }
            boolean r11 = r11.equals(r13)     // Catch:{ IOException -> 0x0168 }
            if (r11 == 0) goto L_0x013f
            goto L_0x013c
        L_0x0102:
            int r11 = r10.length()     // Catch:{ IOException -> 0x0168 }
            int r11 = swisseph.SMath.min((int) r11, (int) r12)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r11 = r10.substring(r6, r11)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r11 = r11.trim()     // Catch:{ IOException -> 0x0168 }
            int r13 = r11.length()     // Catch:{ IOException -> 0x0168 }
            if (r13 >= r15) goto L_0x0119
            goto L_0x013f
        L_0x0119:
            java.lang.String r11 = r11.toLowerCase()     // Catch:{ IOException -> 0x0168 }
            int r13 = r11.length()     // Catch:{ IOException -> 0x0168 }
            int r13 = swisseph.SMath.min((int) r13, (int) r15)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r11 = r11.substring(r6, r13)     // Catch:{ IOException -> 0x0168 }
            int r13 = r0.length()     // Catch:{ IOException -> 0x0168 }
            int r13 = swisseph.SMath.min((int) r13, (int) r15)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r13 = r0.substring(r6, r13)     // Catch:{ IOException -> 0x0168 }
            boolean r11 = r11.equals(r13)     // Catch:{ IOException -> 0x0168 }
            if (r11 == 0) goto L_0x013f
        L_0x013c:
            r16 = r7
            goto L_0x016c
        L_0x013f:
            r16 = r7
            r17 = r8
            r7 = 0
            r10 = 0
            r11 = 1
            r13 = 44
            goto L_0x00b1
        L_0x014b:
            swisseph.SwissephException r0 = new swisseph.SwissephException     // Catch:{ IOException -> 0x0168 }
            r19 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r21 = 65
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0168 }
            r8.<init>()     // Catch:{ IOException -> 0x0168 }
            r8.append(r3)     // Catch:{ IOException -> 0x0168 }
            r8.append(r7)     // Catch:{ IOException -> 0x0168 }
            java.lang.String r23 = r8.toString()     // Catch:{ IOException -> 0x0168 }
            r22 = -1
            r18 = r0
            r18.<init>((double) r19, (int) r21, (int) r22, (java.lang.String) r23)     // Catch:{ IOException -> 0x0168 }
            throw r0     // Catch:{ IOException -> 0x0168 }
        L_0x0168:
            r0 = move-exception
            r16 = r7
            goto L_0x0170
        L_0x016c:
            r7 = r16
            goto L_0x0173
        L_0x016f:
            r0 = move-exception
        L_0x0170:
            r7 = r16
            r10 = 0
        L_0x0173:
            if (r10 == 0) goto L_0x022c
            swisseph.SwissLib r0 = r1.sl
            java.lang.String r8 = ","
            int r0 = r0.swi_cutstr(r10, r8, r5, r4)
            r4 = r5[r6]
            java.lang.String r4 = r4.trim()
            r5[r6] = r4
            r4 = 1
            r9 = r5[r4]
            java.lang.String r9 = r9.trim()
            r5[r4] = r9
            r4 = 13
            if (r0 < r4) goto L_0x01ff
            r0 = r5[r4]     // Catch:{ NumberFormatException -> 0x01de }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x01de }
            double r9 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x01de }
            r26[r6] = r9     // Catch:{ NumberFormatException -> 0x01de }
            r0 = r5[r6]
            int r0 = r0.length()
            if (r0 <= r12) goto L_0x01af
            r0 = r5[r6]
            java.lang.String r0 = r0.substring(r6, r12)
            r5[r6] = r0
        L_0x01af:
            r3 = 1
            r0 = r5[r3]
            int r0 = r0.length()
            if (r0 <= r12) goto L_0x01c0
            r0 = r5[r3]
            java.lang.String r0 = r0.substring(r6, r12)
            r5[r3] = r0
        L_0x01c0:
            r2.setLength(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3 = r5[r6]
            r0.append(r3)
            r0.append(r8)
            r3 = 1
            r3 = r5[r3]
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            return r6
        L_0x01de:
            r0 = move-exception
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r8 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r10 = 65
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = ": field 13 is not a double"
            r2.append(r3)
            java.lang.String r12 = r2.toString()
            r11 = -1
            r7 = r0
            r7.<init>((double) r8, (int) r10, (int) r11, (java.lang.String) r12)
            throw r0
        L_0x01ff:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "data of star '"
            r0.append(r2)
            r2 = r5[r6]
            r0.append(r2)
            r0.append(r8)
            r2 = 1
            r2 = r5[r2]
            r0.append(r2)
            java.lang.String r2 = "' incomplete"
            r0.append(r2)
            java.lang.String r8 = r0.toString()
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r4 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r6 = 65
            r7 = -1
            r3 = r0
            r3.<init>((double) r4, (int) r6, (int) r7, (java.lang.String) r8)
            throw r0
        L_0x022c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "star "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r2 = " not found"
            r0.append(r2)
            java.lang.String r12 = r0.toString()
            r2 = 0
            r26[r6] = r2
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r8 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r10 = 5120(0x1400, float:7.175E-42)
            r11 = -1
            r7 = r0
            r7.<init>((double) r8, (int) r10, (int) r11, (java.lang.String) r12)
            throw r0
        L_0x0252:
            swisseph.SwissephException r0 = new swisseph.SwissephException
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r5 = 5120(0x1400, float:7.175E-42)
            r6 = -1
            java.lang.String r7 = "swe_fixstar_mag(): star name empty"
            r2 = r0
            r2.<init>((double) r3, (int) r5, (int) r6, (java.lang.String) r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissEph.swe_fixstar_mag(java.lang.StringBuffer, double[], java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public void swi_force_app_pos_etc() {
        for (int i = 0; i < 18; i++) {
            this.swed.pldat[i].xflgs = -1;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            this.swed.nddat[i2].xflgs = -1;
        }
        for (int i3 = 0; i3 < 23; i3++) {
            this.swed.savedat[i3].tsave = 0.0d;
            this.swed.savedat[i3].iflgsave = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int swi_get_observer(double d, int i, boolean z, double[] dArr, StringBuffer stringBuffer) {
        double d2;
        double d3;
        double d4;
        double d5;
        SwissEph swissEph = this;
        double d6 = d;
        int i2 = i;
        double[] dArr2 = dArr;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr3 = new double[2];
        if (swissEph.swed.geopos_is_set) {
            double deltaT = d6 - SweDate.getDeltaT(d);
            if (swissEph.swed.oec.teps == d6 && swissEph.swed.nut.tnut == d6) {
                d2 = swissEph.swed.oec.eps;
                dArr3[1] = swissEph.swed.nut.nutlo[1];
                dArr3[0] = swissEph.swed.nut.nutlo[0];
            } else {
                d2 = swissEph.sl.swi_epsiln(d6, i2);
                if ((i2 & 64) == 0) {
                    swissEph.sl.swi_nutation(d6, i2, dArr3);
                }
            }
            int i3 = i2 & 64;
            if (i3 != 0) {
                d4 = d2;
                d3 = 0.0d;
            } else {
                double d7 = d2 + dArr3[1];
                d3 = dArr3[0];
                d4 = d7;
            }
            double swe_sidtime0 = swissEph.sl.swe_sidtime0(deltaT, d4, d3) * 15.0d;
            double cos = SMath.cos(swissEph.swed.topd.geolat * 0.0174532925199433d);
            double sin = SMath.sin(swissEph.swed.topd.geolat * 0.0174532925199433d);
            double sqrt = 1.0d / SMath.sqrt((cos * cos) + ((0.9933056020041341d * sin) * sin));
            double d8 = 0.9933056020041341d * sqrt;
            double cos2 = SMath.cos((swissEph.swed.topd.geolon + swe_sidtime0) * 0.0174532925199433d);
            double d9 = deltaT;
            double sin2 = SMath.sin((swissEph.swed.topd.geolon + swe_sidtime0) * 0.0174532925199433d);
            double d10 = swissEph.swed.topd.geoalt;
            double d11 = ((sqrt * 6378136.6d) + d10) * cos;
            double[] dArr4 = dArr;
            dArr4[0] = cos2 * d11;
            dArr4[1] = d11 * sin2;
            dArr4[2] = ((d8 * 6378136.6d) + d10) * sin;
            swissEph.sl.swi_cartpol(dArr4, dArr4);
            dArr4[3] = 6.300387486748799d;
            dArr4[5] = 0.0d;
            dArr4[4] = 0.0d;
            swissEph.sl.swi_polcart_sp(dArr4, dArr4);
            for (int i4 = 0; i4 <= 5; i4++) {
                dArr4[i4] = dArr4[i4] / 1.4959787066E11d;
            }
            if (i3 == 0) {
                d5 = d9;
                swissEph.sl.swi_coortrf2(dArr, dArr, -swissEph.swed.nut.snut, swissEph.swed.nut.cnut);
                if ((i2 & 256) != 0) {
                    swissEph.sl.swi_coortrf2(dArr, 3, dArr, 3, -swissEph.swed.nut.snut, swissEph.swed.nut.cnut);
                }
                swissEph = this;
                swissEph.swi_nutate(dArr4, 0, i2, true);
            } else {
                d5 = d9;
            }
            double d12 = d5;
            swissEph.sl.swi_precess(dArr, d, i, 1);
            if ((i2 & 256) != 0) {
                swi_precess_speed(dArr, d, i, 1);
            }
            if (z) {
                for (int i5 = 0; i5 <= 5; i5++) {
                    swissEph.swed.topd.xobs[i5] = dArr[i5];
                }
                swissEph.swed.topd.teval = d6;
                swissEph.swed.topd.tjd_ut = d12;
            }
            return 0;
        } else if (stringBuffer2 == null) {
            return -1;
        } else {
            stringBuffer2.setLength(0);
            stringBuffer2.append("geographic position has not been set");
            return -1;
        }
    }

    public int swe_time_equ(double d, double[] dArr, StringBuffer stringBuffer) {
        double[] dArr2 = new double[6];
        double d2 = 0.5d + d;
        double swe_sidtime = (this.sl.swe_sidtime(d) - ((d2 - SMath.floor(d2)) * 24.0d)) * 15.0d;
        if (swe_calc_ut(d, 0, 2048, dArr2, stringBuffer) == -1) {
            return -1;
        }
        double swe_degnorm = this.sl.swe_degnorm((swe_sidtime - dArr2[0]) - 180.0d);
        if (swe_degnorm > 180.0d) {
            swe_degnorm -= 360.0d;
        }
        dArr[0] = (swe_degnorm * 4.0d) / 1440.0d;
        return 0;
    }

    public int swe_lmt_to_lat(double d, double d2, double[] dArr, StringBuffer stringBuffer) {
        double[] dArr2 = new double[1];
        int swe_time_equ = swe_time_equ(d - (d2 / 360.0d), dArr2, stringBuffer);
        dArr[0] = d + dArr2[0];
        return swe_time_equ;
    }

    public int swe_lat_to_lmt(double d, double d2, double[] dArr, StringBuffer stringBuffer) {
        double[] dArr2 = new double[1];
        double d3 = d - (d2 / 360.0d);
        swe_time_equ(d3, dArr2, stringBuffer);
        swe_time_equ(d3 - dArr2[0], dArr2, stringBuffer);
        int swe_time_equ = swe_time_equ(d3 - dArr2[0], dArr2, stringBuffer);
        dArr[0] = d - dArr2[0];
        return swe_time_equ;
    }

    /* access modifiers changed from: package-private */
    public double dot_prod(double[] dArr, double[] dArr2) {
        return (dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1]) + (dArr[2] * dArr2[2]);
    }

    /* access modifiers changed from: package-private */
    public double dot_prod(double[] dArr, double[] dArr2, int i) {
        return (dArr[0] * dArr2[i]) + (dArr[1] * dArr2[i + 1]) + (dArr[2] * dArr2[i + 2]);
    }
}
