package swisseph;

import java.io.Serializable;
import java.lang.reflect.Array;

class SwephMosh implements Serializable {
    private static final int FICT_GEO = 1;
    private static final double TIMESCALE = 3652500.0d;
    private static final double[] freqs = {5.38101628688982E10d, 2.10664136433548E10d, 1.29597742283429E10d, 6.8905077493988E9d, 1.0925660377991E9d, 4.399609855372E8d, 1.542481193933E8d, 7.86550320744E7d, 5.22722451795E7d};
    private static final double[] phases = {908103.259872d, 655127.28306d, 361679.244588d, 1279558.798488d, 123665.46746400002d, 180278.79948000002d, 1130598.0183960001d, 1095655.195728d, 860492.1546d};
    static final String[] plan_fict_nam = {"Cupido", "Hades", "Zeus", "Kronos", "Apollon", "Admetos", "Vulkanus", "Poseidon", "Isis-Transpluto", "Nibiru", "Harrington", "Leverrier", "Adams", "Lowell", "Pickering"};
    private static final double[][] plan_oscu_elem = {new double[]{2415020.0d, 2415020.0d, 163.7409d, 40.99837d, 0.0046d, 171.4333d, 129.8325d, 1.0833d}, new double[]{2415020.0d, 2415020.0d, 27.6496d, 50.66744d, 0.00245d, 148.1796d, 161.3339d, 1.05d}, new double[]{2415020.0d, 2415020.0d, 165.1232d, 59.21436d, 0.0012d, 299.044d, 0.0d, 0.0d}, new double[]{2415020.0d, 2415020.0d, 169.0193d, 64.8196d, 0.00305d, 208.8801d, 0.0d, 0.0d}, new double[]{2415020.0d, 2415020.0d, 138.0533d, 70.29949d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2415020.0d, 2415020.0d, 351.335d, 73.62765d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2415020.0d, 2415020.0d, 55.8983d, 77.25568d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2415020.0d, 2415020.0d, 165.5163d, 83.66907d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2368547.66d, 2431456.5d, 0.0d, 77.775d, 0.3d, 0.7d, 0.0d, 0.0d}, new double[]{1856113.380954d, 1856113.380954d, 0.0d, 234.8921d, 0.981092d, 103.966d, -44.567d, 158.708d}, new double[]{2374696.5d, 2451545.0d, 0.0d, 101.2d, 0.411d, 208.5d, 275.4d, 32.4d}, new double[]{2395662.5d, 2395662.5d, 34.05d, 36.15d, 0.10761d, 284.75d, 0.0d, 0.0d}, new double[]{2395662.5d, 2395662.5d, 24.28d, 37.25d, 0.12062d, 299.11d, 0.0d, 0.0d}, new double[]{2425977.5d, 2425977.5d, 281.0d, 43.0d, 0.202d, 204.9d, 0.0d, 0.0d}, new double[]{2425977.5d, 2425977.5d, 48.95d, 55.1d, 0.31d, 280.1d, 100.0d, 15.0d}};
    private static final int[] pnoint2msh = {2, 2, 0, 1, 3, 4, 5, 6, 7, 8};
    double[][] cc;
    private Plantbl[] planets;
    SweDate sd = null;
    SwissLib sl = null;
    Swemmoon sm = null;
    double[][] ss;
    SwissEph sw = null;
    SwissData swed = null;

    SwephMosh(SwissLib swissLib, SwissEph swissEph, SwissData swissData) {
        Class<double> cls = double.class;
        this.ss = (double[][]) Array.newInstance(cls, new int[]{9, 24});
        this.cc = (double[][]) Array.newInstance(cls, new int[]{9, 24});
        this.planets = new Plantbl[]{SwemptabMer.mer404, SwemptabVen.ven404, SwemptabEar.ear404, SwemptabMar.mar404, SwemptabJup.jup404, SwemptabSat.sat404, SwemptabUra.ura404, SwemptabNep.nep404, SwemptabPlu.plu404};
        this.sl = swissLib;
        this.sw = swissEph;
        this.swed = swissData;
        this.sm = new Swemmoon();
        if (this.sl == null) {
            this.sl = new SwissLib();
        }
        if (this.sw == null) {
            this.sw = new SwissEph();
        }
        if (this.swed == null) {
            this.swed = new SwissData();
        }
    }

    private int swi_moshplan2(double d, int i, double[] dArr) {
        double d2;
        double[] dArr2;
        double[] dArr3;
        byte b;
        int i2;
        Plantbl plantbl = this.planets[i];
        double d3 = (d - 2451545.0d) / TIMESCALE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            d2 = 4.84813681109536E-6d;
            if (i4 >= 9) {
                break;
            }
            short s = plantbl.max_harmonic[i4];
            if (s > 0) {
                sscc(i4, (this.sm.mods3600(freqs[i4] * d3) + phases[i4]) * 4.84813681109536E-6d, s);
            }
            i4++;
        }
        byte[] bArr = plantbl.arg_tbl;
        double[] dArr4 = plantbl.lon_tbl;
        double[] dArr5 = plantbl.lat_tbl;
        double[] dArr6 = plantbl.rad_tbl;
        int i5 = 0;
        int i6 = 0;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i5 + 1;
            byte b2 = bArr[i5];
            if (b2 < 0) {
                dArr[i3] = d4 * d2;
                dArr[1] = d5 * d2;
                dArr[2] = (plantbl.distance * d2 * d6) + plantbl.distance;
                return i3;
            } else if (b2 == 0) {
                i5 = i9 + 1;
                byte b3 = bArr[i9];
                double d7 = dArr4[i6];
                i6++;
                double d8 = d7;
                int i10 = 0;
                while (i10 < b3) {
                    d8 = (d8 * d3) + dArr4[i6];
                    i10++;
                    i6++;
                }
                d4 += this.sm.mods3600(d8);
                double d9 = dArr5[i7];
                i7++;
                int i11 = 0;
                while (i11 < b3) {
                    d9 = (d9 * d3) + dArr5[i7];
                    i11++;
                    i7++;
                }
                d5 += d9;
                double d10 = dArr6[i8];
                i8++;
                int i12 = 0;
                while (i12 < b3) {
                    d10 = (d10 * d3) + dArr6[i8];
                    i12++;
                    i8++;
                }
                d6 += d10;
                i3 = 0;
                d2 = 4.84813681109536E-6d;
            } else {
                int i13 = 0;
                double d11 = 0.0d;
                double d12 = 0.0d;
                boolean z = false;
                while (i13 < b2) {
                    int i14 = i9 + 1;
                    Plantbl plantbl2 = plantbl;
                    byte b4 = bArr[i9];
                    i9 = i14 + 1;
                    int i15 = bArr[i14] - 1;
                    if (b4 != 0) {
                        if (b4 < 0) {
                            b = b2;
                            i2 = -b4;
                        } else {
                            b = b2;
                            i2 = b4;
                        }
                        int i16 = i2 - 1;
                        dArr3 = dArr6;
                        dArr2 = dArr5;
                        double d13 = this.ss[i15][i16];
                        if (b4 < 0) {
                            d13 = -d13;
                        }
                        double d14 = this.cc[i15][i16];
                        if (!z) {
                            d11 = d13;
                            d12 = d14;
                            z = true;
                        } else {
                            d12 = (d14 * d12) - (d13 * d11);
                            d11 = (d13 * d12) + (d14 * d11);
                        }
                    } else {
                        dArr2 = dArr5;
                        dArr3 = dArr6;
                        b = b2;
                    }
                    i13++;
                    plantbl = plantbl2;
                    b2 = b;
                    dArr6 = dArr3;
                    dArr5 = dArr2;
                }
                Plantbl plantbl3 = plantbl;
                double[] dArr7 = dArr5;
                double[] dArr8 = dArr6;
                i5 = i9 + 1;
                byte b5 = bArr[i9];
                int i17 = i6 + 1;
                double d15 = dArr4[i6];
                int i18 = i17 + 1;
                double d16 = dArr4[i17];
                for (int i19 = 0; i19 < b5; i19++) {
                    int i20 = i6 + 1;
                    d15 = (d15 * d3) + dArr4[i6];
                    i18 = i20 + 1;
                    d16 = (d16 * d3) + dArr4[i20];
                }
                d4 += (d15 * d12) + (d16 * d11);
                int i21 = i7 + 1;
                double d17 = dArr7[i7];
                int i22 = i21 + 1;
                double d18 = dArr7[i21];
                for (int i23 = 0; i23 < b5; i23++) {
                    int i24 = i7 + 1;
                    d17 = (d17 * d3) + dArr7[i7];
                    i22 = i24 + 1;
                    d18 = (d18 * d3) + dArr7[i24];
                }
                d5 += (d17 * d12) + (d18 * d11);
                int i25 = i8 + 1;
                double d19 = dArr8[i8];
                int i26 = i25 + 1;
                double d20 = dArr8[i25];
                for (int i27 = 0; i27 < b5; i27++) {
                    int i28 = i8 + 1;
                    d19 = (d19 * d3) + dArr8[i8];
                    i26 = i28 + 1;
                    d20 = (d20 * d3) + dArr8[i28];
                }
                d6 += (d19 * d12) + (d20 * d11);
                plantbl = plantbl3;
                dArr6 = dArr8;
                dArr5 = dArr7;
                i3 = 0;
                d2 = 4.84813681109536E-6d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int swi_moshplan(double d, int i, boolean z, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        double[] dArr3;
        boolean z2;
        int i2;
        double[] dArr4;
        double d2;
        int i3;
        PlanData planData;
        double[] dArr5;
        double d3;
        double[] dArr6;
        double[] dArr7;
        double d4 = d;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr8 = new double[3];
        double[] dArr9 = new double[6];
        int[] iArr = pnoint2msh;
        int i4 = iArr[i];
        PlanData planData2 = this.swed.pldat[i];
        PlanData planData3 = this.swed.pldat[0];
        double d5 = this.swed.oec2000.seps;
        double[] dArr10 = new double[3];
        double[] dArr11 = new double[6];
        double d6 = this.swed.oec2000.ceps;
        if (z) {
            dArr3 = planData2.x;
            dArr9 = planData3.x;
        } else {
            dArr3 = dArr11;
        }
        if (z || i == 0 || dArr2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (d4 < 625000.2d) {
            i2 = 0;
        } else if (d4 > 2818000.8d) {
            i2 = 0;
        } else {
            if (z2) {
                double[] dArr12 = dArr8;
                if (d4 == planData3.teval && planData3.iephe == 4) {
                    dArr7 = planData3.x;
                    d2 = d6;
                    dArr4 = dArr3;
                    i3 = i4;
                    planData = planData2;
                    dArr5 = dArr12;
                    d3 = d5;
                } else {
                    swi_moshplan2(d4, iArr[0], dArr9);
                    this.sl.swi_polcart(dArr9, dArr9);
                    int i5 = i4;
                    planData = planData2;
                    double d7 = -d5;
                    this.sl.swi_coortrf2(dArr9, dArr9, d7, d6);
                    embofs_mosh(d4, dArr9);
                    if (z) {
                        planData3.teval = d4;
                        planData3.xflgs = -1;
                        planData3.iephe = 4;
                    }
                    i3 = i5;
                    double d8 = d4 - 1.0E-4d;
                    double[] dArr13 = dArr12;
                    swi_moshplan2(d8, iArr[0], dArr13);
                    this.sl.swi_polcart(dArr13, dArr13);
                    d2 = d6;
                    double[] dArr14 = dArr9;
                    double[] dArr15 = dArr13;
                    double[] dArr16 = dArr13;
                    dArr5 = dArr13;
                    dArr4 = dArr3;
                    double d9 = d7;
                    d3 = d5;
                    this.sl.swi_coortrf2(dArr15, dArr16, d9, d2);
                    embofs_mosh(d8, dArr5);
                    for (int i6 = 0; i6 <= 2; i6++) {
                        dArr10[i6] = (dArr14[i6] - dArr5[i6]) / 1.0E-4d;
                    }
                    for (int i7 = 0; i7 <= 2; i7++) {
                        dArr14[i7 + 3] = dArr10[i7];
                    }
                    dArr7 = dArr14;
                }
                if (dArr2 != null) {
                    for (int i8 = 0; i8 <= 5; i8++) {
                        dArr2[i8] = dArr7[i8];
                    }
                }
            } else {
                dArr5 = dArr8;
                d2 = d6;
                dArr4 = dArr3;
                i3 = i4;
                planData = planData2;
                d3 = d5;
            }
            if (i == 0) {
                return 0;
            }
            PlanData planData4 = planData;
            if (d4 == planData4.teval && planData4.iephe == 4) {
                dArr6 = planData4.x;
            } else {
                int i9 = i3;
                double[] dArr17 = dArr4;
                swi_moshplan2(d4, i9, dArr17);
                this.sl.swi_polcart(dArr17, dArr17);
                double d10 = -d3;
                this.sl.swi_coortrf2(dArr17, dArr17, d10, d2);
                if (z) {
                    planData4.teval = d4;
                    planData4.xflgs = -1;
                    planData4.iephe = 4;
                }
                swi_moshplan2(d4 - 1.0E-4d, i9, dArr5);
                this.sl.swi_polcart(dArr5, dArr5);
                this.sl.swi_coortrf2(dArr5, dArr5, d10, d2);
                for (int i10 = 0; i10 <= 2; i10++) {
                    dArr10[i10] = (dArr17[i10] - dArr5[i10]) / 1.0E-4d;
                }
                for (int i11 = 0; i11 <= 2; i11++) {
                    dArr17[i11 + 3] = dArr10[i11];
                }
                dArr6 = dArr17;
            }
            if (dArr == null) {
                return 0;
            }
            for (int i12 = 0; i12 <= 5; i12++) {
                dArr[i12] = dArr6[i12];
            }
            return 0;
        }
        if (stringBuffer2 == null) {
            return -1;
        }
        stringBuffer2.setLength(i2);
        String str = "jd " + d4 + " outside Moshier planet range " + 625000.5d + " .. " + 2818000.5d + " ";
        if (stringBuffer.length() + str.length() >= 256) {
            return -1;
        }
        stringBuffer2.append(str);
        return -1;
    }

    private void sscc(int i, double d, int i2) {
        double sin = SMath.sin(d);
        double cos = SMath.cos(d);
        double[][] dArr = this.ss;
        dArr[i][0] = sin;
        double[][] dArr2 = this.cc;
        dArr2[i][0] = cos;
        double d2 = 2.0d * sin * cos;
        double d3 = (cos * cos) - (sin * sin);
        dArr[i][1] = d2;
        dArr2[i][1] = d3;
        int i3 = 2;
        while (i3 < i2) {
            double d4 = (sin * d3) + (cos * d2);
            d3 = (d3 * cos) - (d2 * sin);
            this.ss[i][i3] = d4;
            this.cc[i][i3] = d3;
            i3++;
            d2 = d4;
        }
    }

    private void embofs_mosh(double d, double[] dArr) {
        double[] dArr2 = new double[6];
        double d2 = this.swed.oec.seps;
        double d3 = this.swed.oec.ceps;
        double d4 = (d - 2415020.0d) / 36525.0d;
        double swe_degnorm = this.sl.swe_degnorm((((((1.44E-5d * d4) + 0.009192d) * d4) + 477198.8491d) * d4) + 296.104608d) * 0.0174532925199433d;
        double sin = SMath.sin(swe_degnorm);
        double cos = SMath.cos(swe_degnorm);
        double d5 = (cos * cos) - (sin * sin);
        double d6 = 1.9E-6d * d4;
        double swe_degnorm2 = this.sl.swe_degnorm(((((d6 - 0.001436d) * d4) + 445267.1142d) * d4) + 350.737486d) * 0.0349065850398866d;
        double sin2 = SMath.sin(swe_degnorm2);
        double cos2 = SMath.cos(swe_degnorm2);
        double swe_degnorm3 = this.sl.swe_degnorm((((((-3.0E-7d * d4) - 0.003211d) * d4) + 483202.0251d) * d4) + 11.250889d) * 0.0174532925199433d;
        double sin3 = SMath.sin(swe_degnorm3);
        double cos3 = SMath.cos(swe_degnorm3);
        double d7 = (cos2 * cos) + (sin2 * sin);
        double sin4 = ((((((((((d6 - 0.001133d) * d4) + 481267.8831d) * d4) + 270.434164d) + (6.28875d * sin)) + (((sin2 * cos) - (cos2 * sin)) * 1.274018d)) + (0.658309d * sin2)) + (((sin * 2.0d) * cos) * 0.213616d)) - (SMath.sin(this.sl.swe_degnorm((((((-3.3E-6d * d4) - 1.5E-4d) * d4) + 35999.0498d) * d4) + 358.475833d) * 0.0174532925199433d) * 0.185596d)) - (((2.0d * sin3) * cos3) * 0.114336d);
        double d8 = sin * cos3;
        double d9 = cos * sin3;
        dArr2[0] = this.sl.swe_degnorm(sin4) * 0.0174532925199433d;
        dArr2[1] = ((5.128189d * sin3) + ((d8 + d9) * 0.280606d) + ((d8 - d9) * 0.277693d) + (((sin2 * cos3) - (sin3 * cos2)) * 0.173238d)) * 0.0174532925199433d;
        dArr2[2] = 4.263523E-5d / SMath.sin((((((cos * 0.051818d) + 0.950724d) + (d7 * 0.009531d)) + (cos2 * 0.007843d)) + (d5 * 0.002824d)) * 0.0174532925199433d);
        this.sl.swi_polcart(dArr2, dArr2);
        double d10 = -d2;
        double[] dArr3 = dArr2;
        this.sl.swi_coortrf2(dArr3, dArr2, d10, d3);
        this.sl.swi_precess(dArr3, d, 0, 1);
        for (int i = 0; i <= 2; i++) {
            dArr[i] = dArr[i] - (dArr2[i] / 82.30055985272827d);
        }
    }

    /* access modifiers changed from: package-private */
    public String swi_get_fict_name(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer(str == null ? "" : str);
        StringBuffer stringBuffer2 = stringBuffer;
        if (read_elements_file(i, 0.0d, (DblObj) null, (DblObj) null, (DblObj) null, (DblObj) null, (DblObj) null, (DblObj) null, (DblObj) null, (DblObj) null, stringBuffer, (IntObj) null, (StringBuffer) null) == -1) {
            return "name not found";
        }
        return stringBuffer2.toString();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swi_osc_el_plan(double r40, double[] r42, int r43, int r44, double[] r45, double[] r46, java.lang.StringBuffer r47) {
        /*
            r39 = this;
            r15 = r39
            r13 = r40
            r12 = r42
            r0 = 9
            double[] r11 = new double[r0]
            r10 = 6
            double[] r9 = new double[r10]
            swisseph.DblObj r8 = new swisseph.DblObj
            r8.<init>()
            swisseph.DblObj r7 = new swisseph.DblObj
            r7.<init>()
            swisseph.DblObj r6 = new swisseph.DblObj
            r6.<init>()
            swisseph.DblObj r5 = new swisseph.DblObj
            r5.<init>()
            swisseph.DblObj r4 = new swisseph.DblObj
            r4.<init>()
            swisseph.DblObj r2 = new swisseph.DblObj
            r2.<init>()
            swisseph.DblObj r3 = new swisseph.DblObj
            r3.<init>()
            swisseph.DblObj r1 = new swisseph.DblObj
            r1.<init>()
            swisseph.SwissData r0 = r15.swed
            swisseph.PlanData[] r0 = r0.pldat
            r12 = 0
            r0 = r0[r12]
            swisseph.SwissData r10 = r15.swed
            swisseph.PlanData[] r10 = r10.pldat
            r10 = r10[r44]
            swisseph.IntObj r15 = new swisseph.IntObj
            r15.<init>()
            r15.val = r12
            r17 = 0
            r18 = r0
            r0 = r39
            r44 = r1
            r1 = r43
            r43 = r2
            r19 = r3
            r2 = r40
            r20 = r4
            r4 = r8
            r21 = r5
            r5 = r7
            r22 = r6
            r23 = r7
            r7 = r21
            r24 = r8
            r8 = r20
            r25 = r9
            r9 = r43
            r26 = r10
            r16 = 6
            r10 = r19
            r27 = r11
            r11 = r44
            r12 = r17
            r13 = r15
            r14 = r47
            int r0 = r0.read_elements_file(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = -1
            if (r0 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r0 = 4580615388859374235(0x3f919d6d51a69a9b, double:0.017202098949975136)
            r2 = r21
            double r3 = r2.val
            double r0 = r0 / r3
            double r3 = r2.val
            double r3 = swisseph.SMath.sqrt(r3)
            double r0 = r0 / r3
            int r3 = r15.val
            r7 = 1
            r3 = r3 & r7
            if (r3 == 0) goto L_0x00a5
            r3 = 4689463582065021346(0x41145248341dd1a2, double:332946.050895)
            double r3 = swisseph.SMath.sqrt(r3)
            double r0 = r0 / r3
        L_0x00a5:
            r3 = r19
            double r4 = r3.val
            double r4 = swisseph.SMath.cos(r4)
            double r8 = r3.val
            double r8 = swisseph.SMath.sin(r8)
            r3 = r44
            double r10 = r3.val
            double r10 = swisseph.SMath.cos(r10)
            double r12 = r3.val
            double r12 = swisseph.SMath.sin(r12)
            r3 = r43
            r28 = r8
            double r7 = r3.val
            double r6 = swisseph.SMath.cos(r7)
            double r8 = r3.val
            double r8 = swisseph.SMath.sin(r8)
            double r30 = r6 * r4
            double r32 = r8 * r10
            double r34 = r32 * r28
            double r30 = r30 - r34
            r14 = 0
            r27[r14] = r30
            r44 = r15
            double r14 = -r8
            double r30 = r14 * r4
            double r34 = r6 * r10
            double r36 = r34 * r28
            double r30 = r30 - r36
            r3 = 1
            r27[r3] = r30
            double r30 = r12 * r28
            r3 = 2
            r27[r3] = r30
            double r30 = r6 * r28
            double r32 = r32 * r4
            double r30 = r30 + r32
            r17 = 3
            r27[r17] = r30
            double r14 = r14 * r28
            double r34 = r34 * r4
            double r14 = r14 + r34
            r19 = 4
            r27[r19] = r14
            double r14 = -r12
            double r14 = r14 * r4
            r5 = 5
            r27[r5] = r14
            double r8 = r8 * r12
            r27[r16] = r8
            double r6 = r6 * r12
            r4 = 7
            r27[r4] = r6
            r6 = 8
            r27[r6] = r10
            r7 = r39
            r8 = r44
            swisseph.SwissLib r6 = r7.sl
            r9 = r22
            double r9 = r9.val
            r11 = r24
            double r11 = r11.val
            r13 = r40
            double r11 = r13 - r11
            double r11 = r11 * r0
            double r9 = r9 + r11
            double r31 = r6.swi_mod2PI(r9)
            r0 = r20
            double r9 = r0.val
            r11 = 4606957238818648883(0x3fef333333333333, double:0.975)
            r20 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x01e7
            r9 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r9 = r9 * r31
            r11 = 4639481672377565184(0x4062c00000000000, double:150.0)
            r28 = 4640537203540230144(0x4066800000000000, double:180.0)
            r5 = 0
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0161
            r11 = 4641592734702895104(0x406a400000000000, double:210.0)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0161
            double r9 = r9 - r28
            goto L_0x0163
        L_0x0161:
            r28 = r5
        L_0x0163:
            r11 = 4644513037586268160(0x4074a00000000000, double:330.0)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0172
            r11 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r9 = r9 - r11
        L_0x0172:
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x017a
            double r9 = -r9
            r11 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            goto L_0x017c
        L_0x017a:
            r11 = r20
        L_0x017c:
            r33 = 4629137466983448576(0x403e000000000000, double:30.0)
            int r1 = (r9 > r33 ? 1 : (r9 == r33 ? 0 : -1))
            if (r1 >= 0) goto L_0x01e5
            r33 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r9 = r9 * r33
            double r3 = r0.val
            double r3 = r20 - r3
            r15 = r2
            double r1 = r0.val
            r33 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r1 = r1 * r33
            r35 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r1 = r1 + r35
            double r3 = r3 / r1
            r1 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r5 = r0.val
            double r5 = r5 * r1
            double r5 = r5 + r20
            double r1 = r9 / r5
            double r5 = r1 * r1
            double r37 = r3 * r3
            double r5 = r5 + r37
            double r5 = swisseph.SMath.sqrt(r5)
            double r1 = r1 + r5
            r5 = 0
            double r1 = swisseph.SMath.pow(r1, r5)
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = r3 / r5
            double r1 = r1 - r3
            r3 = 4590284912998123307(0x3fb3f7ced916872b, double:0.078)
            double r3 = r3 * r1
            double r3 = r3 * r1
            double r3 = r3 * r1
            double r3 = r3 * r1
            double r3 = r3 * r1
            double r5 = r0.val
            double r5 = r5 + r20
            double r3 = r3 / r5
            double r1 = r1 - r3
            double r3 = r0.val
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r5 = r5 * r1
            double r33 = r33 * r1
            double r33 = r33 * r1
            double r33 = r33 * r1
            double r5 = r5 - r33
            double r3 = r3 * r5
            double r9 = r9 + r3
            double r11 = r11 * r9
            double r11 = r11 + r28
            r29 = r11
            goto L_0x01ea
        L_0x01e5:
            r15 = r2
            goto L_0x01e8
        L_0x01e7:
            r15 = r2
        L_0x01e8:
            r29 = r31
        L_0x01ea:
            swisseph.SwissLib r1 = r7.sl
            double r2 = r0.val
            r28 = r1
            r33 = r2
            double r1 = r28.swi_kepler(r29, r31, r33)
            int r3 = r8.val
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x020a
            r3 = 4539420243938603126(0x3eff42a9362d7076, double:2.98122353216E-5)
            r5 = r15
            double r9 = r5.val
            double r9 = swisseph.SMath.sqrt(r9)
            double r3 = r3 / r9
            goto L_0x0217
        L_0x020a:
            r5 = r15
            r3 = 4580615388859381402(0x3f919d6d51a6b69a, double:0.01720209895)
            double r9 = r5.val
            double r9 = swisseph.SMath.sqrt(r9)
            double r3 = r3 / r9
        L_0x0217:
            double r9 = swisseph.SMath.cos(r1)
            double r1 = swisseph.SMath.sin(r1)
            double r11 = r0.val
            double r11 = r20 - r11
            double r13 = r0.val
            double r13 = r13 + r20
            double r11 = r11 * r13
            double r11 = swisseph.SMath.sqrt(r11)
            double r13 = r0.val
            double r13 = r13 * r9
            double r20 = r20 - r13
            double r13 = r5.val
            double r6 = r0.val
            double r6 = r9 - r6
            double r13 = r13 * r6
            r0 = 0
            r25[r0] = r13
            double r5 = r5.val
            double r5 = r5 * r11
            double r5 = r5 * r1
            r0 = 1
            r25[r0] = r5
            double r5 = -r3
            double r5 = r5 * r1
            double r5 = r5 / r20
            r25[r17] = r5
            double r3 = r3 * r11
            double r3 = r3 * r9
            double r3 = r3 / r20
            r25[r19] = r3
            r0 = 0
            r1 = r27[r0]
            r3 = r25[r0]
            double r1 = r1 * r3
            r3 = 1
            r4 = r27[r3]
            r6 = r25[r3]
            double r4 = r4 * r6
            double r1 = r1 + r4
            r7 = r42
            r7[r0] = r1
            r1 = r27[r17]
            r4 = r25[r0]
            double r1 = r1 * r4
            r4 = r27[r19]
            r9 = r25[r3]
            double r4 = r4 * r9
            double r1 = r1 + r4
            r7[r3] = r1
            r1 = r27[r16]
            r4 = r25[r0]
            double r4 = r4 * r1
            r1 = 7
            r9 = r27[r1]
            r11 = r25[r3]
            double r9 = r9 * r11
            double r4 = r4 + r9
            r2 = 2
            r7[r2] = r4
            r4 = r27[r0]
            r9 = r25[r17]
            double r4 = r4 * r9
            r9 = r27[r3]
            r2 = r25[r19]
            double r9 = r9 * r2
            double r4 = r4 + r9
            r7[r17] = r4
            r2 = r27[r17]
            r4 = r25[r17]
            double r2 = r2 * r4
            r4 = r27[r19]
            r9 = r25[r19]
            double r4 = r4 * r9
            double r2 = r2 + r4
            r7[r19] = r2
            r2 = r27[r16]
            r4 = r25[r17]
            double r2 = r2 * r4
            r0 = 7
            r0 = r27[r0]
            r4 = r25[r19]
            double r0 = r0 * r4
            double r2 = r2 + r0
            r5 = 5
            r7[r5] = r2
            r9 = r39
            swisseph.SwissLib r0 = r9.sl
            r10 = r23
            double r1 = r10.val
            r3 = 0
            double r0 = r0.swi_epsiln(r1, r3)
            swisseph.SwissLib r2 = r9.sl
            double r11 = -r0
            r2.swi_coortrf(r7, r7, r11)
            swisseph.SwissLib r0 = r9.sl
            r2 = 3
            r4 = 3
            r1 = r42
            r3 = r42
            r13 = 5
            r5 = r11
            r0.swi_coortrf(r1, r2, r3, r4, r5)
            double r0 = r10.val
            r2 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x02f8
            swisseph.SwissLib r0 = r9.sl
            double r2 = r10.val
            r4 = 0
            r5 = 1
            r1 = r42
            r0.swi_precess(r1, r2, r4, r5)
            swisseph.SwissLib r0 = r9.sl
            r2 = 3
            double r3 = r10.val
            r5 = 0
            r6 = 1
            r0.swi_precess(r1, r2, r3, r5, r6)
        L_0x02f8:
            int r0 = r8.val
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L_0x030b
            r12 = 0
        L_0x02ff:
            if (r12 > r13) goto L_0x0318
            r0 = r7[r12]
            r2 = r45[r12]
            double r0 = r0 + r2
            r7[r12] = r0
            int r12 = r12 + 1
            goto L_0x02ff
        L_0x030b:
            r12 = 0
        L_0x030c:
            if (r12 > r13) goto L_0x0318
            r0 = r7[r12]
            r2 = r46[r12]
            double r0 = r0 + r2
            r7[r12] = r0
            int r12 = r12 + 1
            goto L_0x030c
        L_0x0318:
            r0 = r26
            double[] r1 = r0.x
            if (r1 != r7) goto L_0x0328
            r1 = r40
            r0.teval = r1
            r1 = r18
            int r1 = r1.iephe
            r0.iephe = r1
        L_0x0328:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwephMosh.swi_osc_el_plan(double, double[], int, int, double[], double[], java.lang.StringBuffer):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x024d, code lost:
        r5 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0251, code lost:
        r36 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0253, code lost:
        if (r7 == null) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0257, code lost:
        r5 = r39;
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r1 = r5.check_t_terms(r11, r0[2], r7);
        r7.val = r5.sl.swe_degnorm(r7.val);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x026a, code lost:
        if (r1 != -1) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x026c, code lost:
        if (r14 == null) goto L_0x0276;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x026e, code lost:
        r14.append(r15);
        r14.append(" mean anomaly value invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0276, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x027a, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x027c, code lost:
        if (r1 != 1) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x027e, code lost:
        r43.val = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0282, code lost:
        r7.val *= 0.0174532925199433d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0289, code lost:
        r5 = r39;
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x028d, code lost:
        r8 = r46;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028f, code lost:
        if (r8 == null) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0291, code lost:
        r1 = r5.check_t_terms(r11, r0[3], r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x029b, code lost:
        if (r8.val <= 0.0d) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x029e, code lost:
        if (r1 != -1) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a0, code lost:
        if (r14 == null) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a2, code lost:
        r14.append(r15);
        r14.append(" semi-axis value invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02aa, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ae, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02af, code lost:
        r9 = r47;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02b1, code lost:
        if (r9 == null) goto L_0x02dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02b3, code lost:
        r1 = r5.check_t_terms(r11, r0[4], r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02bf, code lost:
        if (r9.val >= 1.0d) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02c5, code lost:
        if (r9.val < 0.0d) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02c8, code lost:
        if (r1 != -1) goto L_0x02dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02ca, code lost:
        if (r14 == null) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02cc, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" eccentricity invalid (no parabolic or hyperbolic or bits allowed)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02d8, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02dc, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02dd, code lost:
        r10 = r48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02df, code lost:
        if (r10 == null) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02e1, code lost:
        r1 = r5.check_t_terms(r11, r0[5], r10);
        r10.val = r5.sl.swe_degnorm(r10.val);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f3, code lost:
        if (r1 != -1) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f5, code lost:
        if (r14 == null) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02f7, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" perihelion argument value invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0303, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0307, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0308, code lost:
        r10.val *= 0.0174532925199433d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x030e, code lost:
        r1 = r49;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0310, code lost:
        if (r1 == null) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0312, code lost:
        r3 = r5.check_t_terms(r11, r0[6], r1);
        r1.val = r5.sl.swe_degnorm(r1.val);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0323, code lost:
        if (r3 != -1) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0325, code lost:
        if (r14 == null) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0327, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" node value invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0333, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0337, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0338, code lost:
        r1.val *= 0.0174532925199433d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x033e, code lost:
        r1 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0340, code lost:
        if (r1 == null) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0342, code lost:
        r3 = r5.check_t_terms(r11, r0[7], r1);
        r1.val = r5.sl.swe_degnorm(r1.val);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0353, code lost:
        if (r3 != -1) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0355, code lost:
        if (r14 == null) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0357, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" inclination value invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0363, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0367, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0368, code lost:
        r1.val *= 0.0174532925199433d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x036e, code lost:
        r11 = r51;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0370, code lost:
        if (r11 == null) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0372, code lost:
        r1 = r0[8];
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x037d, code lost:
        if (r1.charAt(r2) == ' ') goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0385, code lost:
        if (r1.charAt(r2) != 9) goto L_0x0388;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0388, code lost:
        r1 = r1.substring(r2).trim();
        r11.setLength(0);
        r11.append(r1);
        r26 = r2;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x039b, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x039e, code lost:
        r12 = r0;
        r0 = r52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03a1, code lost:
        if (r0 == null) goto L_0x03e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03a7, code lost:
        if (r29 <= 9) goto L_0x03e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03a9, code lost:
        r1 = new java.lang.StringBuilder();
        r6 = r26 + 9;
        r1.append(r2.substring(0, swisseph.SMath.min(r2.length(), r6)));
        r1.append(r2.substring(swisseph.SMath.min(r2.length(), r6)).toLowerCase());
        r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03e0, code lost:
        if (r12[9].indexOf("geo") < 0) goto L_0x03e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03e2, code lost:
        r0.val |= 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03e8, code lost:
        r0 = r15;
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
        r21 = r12;
        r29 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e2, code lost:
        if (r5 == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r11 = r0[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ed, code lost:
        if (r11.length() > 5) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
        r2 = r11.toLowerCase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f4, code lost:
        r2 = r11.substring(0, 5).toLowerCase() + r11.substring(5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0115, code lost:
        if (r2.startsWith("j2000") == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
        r5.val = 2451545.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0123, code lost:
        if (r2.startsWith("b1950") == false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0125, code lost:
        r5.val = 2433282.42345905d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0131, code lost:
        if (r2.startsWith("j1900") == false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0133, code lost:
        r5.val = 2415020.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0142, code lost:
        if (r2.charAt(0) == 'j') goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x014a, code lost:
        if (r2.charAt(0) != 'b') goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014d, code lost:
        r5.val = swisseph.SwissLib.atof(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0153, code lost:
        r11 = r3 - r5.val;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0158, code lost:
        if (r14 == null) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x015a, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" invalid epoch");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0166, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0169, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016c, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016f, code lost:
        r2 = r28;
        r11 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0173, code lost:
        if (r6 == null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r8 = r0[1];
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017f, code lost:
        if (r8.charAt(r2) == ' ') goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0187, code lost:
        if (r8.charAt(r2) != 9) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0189, code lost:
        r36 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019c, code lost:
        r5 = r8.substring(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a5, code lost:
        if (r5.length() >= 5) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a7, code lost:
        r1 = r5.toLowerCase();
        r36 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ae, code lost:
        r1 = new java.lang.StringBuilder();
        r36 = r11;
        r1.append(r5.substring(0, 5).toLowerCase());
        r1.append(r5.substring(5));
        r1 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d1, code lost:
        if (r1.startsWith("j2000") == false) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01d3, code lost:
        r6.val = 2451545.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01df, code lost:
        if (r1.startsWith("b1950") == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e1, code lost:
        r6.val = 2433282.42345905d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ed, code lost:
        if (r1.startsWith("j1900") == false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ef, code lost:
        r6.val = 2415020.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01fd, code lost:
        if (r1.startsWith("jdate") == false) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ff, code lost:
        r6.val = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0209, code lost:
        if (r1.charAt(0) == 'j') goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0211, code lost:
        if (r1.charAt(0) != 'b') goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0214, code lost:
        r6.val = swisseph.SwissLib.atof(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x021a, code lost:
        r26 = r2;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021e, code lost:
        if (r14 == null) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0220, code lost:
        r14.setLength(0);
        r14.append(r15);
        r14.append(" invalid equinox");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022c, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0230, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0231, code lost:
        r36 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0242, code lost:
        r2 = r2 + 1;
        r1 = r39;
        r5 = r43;
        r11 = r36;
     */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x043f A[SYNTHETIC, Splitter:B:199:0x043f] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int read_elements_file(int r40, double r41, swisseph.DblObj r43, swisseph.DblObj r44, swisseph.DblObj r45, swisseph.DblObj r46, swisseph.DblObj r47, swisseph.DblObj r48, swisseph.DblObj r49, swisseph.DblObj r50, java.lang.StringBuffer r51, swisseph.IntObj r52, java.lang.StringBuffer r53) {
        /*
            r39 = this;
            r1 = r39
            r2 = r40
            r3 = r41
            r5 = r43
            r6 = r44
            r7 = r45
            r8 = r46
            r9 = r47
            r10 = r48
            r11 = r49
            r12 = r50
            r13 = r51
            r0 = r52
            r14 = r53
            r15 = 20
            java.lang.String[] r0 = new java.lang.String[r15]
            r16 = 7
            r17 = 6
            r18 = 4
            r19 = 3
            r20 = 2
            r22 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            swisseph.SwissEph r15 = r1.sw     // Catch:{ SwissephException -> 0x045c }
            java.lang.String r13 = "seorbel.txt"
            swisseph.SwissData r12 = r1.swed     // Catch:{ SwissephException -> 0x044f }
            java.lang.String r12 = r12.ephepath     // Catch:{ SwissephException -> 0x044f }
            r11 = -1
            swisseph.FilePtr r12 = r15.swi_fopen(r11, r13, r12, r14)     // Catch:{ SwissephException -> 0x0446 }
            java.lang.String r11 = ""
            r15 = r11
            r13 = -1
        L_0x0045:
            java.lang.String r26 = r12.readLine()     // Catch:{ IOException -> 0x0439 }
            if (r26 == 0) goto L_0x040f
            r27 = r11
            java.lang.String r11 = r26.trim()     // Catch:{ IOException -> 0x0439 }
            r26 = r15
            r15 = 0
            char r10 = r11.charAt(r15)     // Catch:{ IOException -> 0x0439 }
            r15 = 35
            if (r10 == r15) goto L_0x03eb
            r15 = 13
            if (r10 == r15) goto L_0x03eb
            r15 = 10
            if (r10 == r15) goto L_0x03eb
            if (r10 != 0) goto L_0x007e
            r10 = r48
            r2 = r49
            r15 = r50
            r11 = r51
            r21 = r12
            r28 = 20
            r12 = r0
            r0 = r52
            r38 = r5
            r5 = r1
            r1 = r38
            goto L_0x03ff
        L_0x007e:
            r10 = 0
            r15 = 35
            int r26 = r11.indexOf(r15)     // Catch:{ IOException -> 0x0439 }
            if (r26 < 0) goto L_0x0092
            int r10 = r11.indexOf(r15)     // Catch:{ IOException -> 0x0439 }
            r15 = 0
            java.lang.String r11 = r11.substring(r15, r10)     // Catch:{ IOException -> 0x0439 }
            r10 = r27
        L_0x0092:
            swisseph.SwissLib r15 = r1.sl     // Catch:{ IOException -> 0x0439 }
            r28 = r10
            java.lang.String r10 = ","
            r9 = 20
            int r10 = r15.swi_cutstr(r11, r10, r0, r9)     // Catch:{ IOException -> 0x0439 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0439 }
            r11.<init>()     // Catch:{ IOException -> 0x0439 }
            java.lang.String r15 = "error in file seorbel.txt, line "
            r11.append(r15)     // Catch:{ IOException -> 0x0439 }
            r15 = 0
            r11.append(r15)     // Catch:{ IOException -> 0x0439 }
            java.lang.String r15 = ":"
            r11.append(r15)     // Catch:{ IOException -> 0x0439 }
            java.lang.String r15 = r11.toString()     // Catch:{ IOException -> 0x0439 }
            r11 = 9
            if (r10 >= r11) goto L_0x00c9
            if (r14 == 0) goto L_0x00c7
            r2 = 0
            r14.setLength(r2)     // Catch:{ IOException -> 0x0439 }
            r14.append(r15)     // Catch:{ IOException -> 0x0439 }
            java.lang.String r0 = " nine elements required"
            r14.append(r0)     // Catch:{ IOException -> 0x0439 }
        L_0x00c7:
            r2 = -1
            return r2
        L_0x00c9:
            int r13 = r13 + 1
            if (r13 == r2) goto L_0x00d5
            r9 = r47
            r10 = r48
            r11 = r27
            goto L_0x0045
        L_0x00d5:
            r21 = r12
            r29 = r10
            java.lang.String r13 = "j1900"
            java.lang.String r9 = "b1950"
            java.lang.String r10 = "j2000"
            r34 = 0
            if (r5 == 0) goto L_0x016f
            r25 = 0
            r11 = r0[r25]     // Catch:{ IOException -> 0x016b }
            int r12 = r11.length()     // Catch:{ IOException -> 0x016b }
            r2 = 5
            if (r12 > r2) goto L_0x00f4
            java.lang.String r2 = r11.toLowerCase()     // Catch:{ IOException -> 0x016b }
            goto L_0x0111
        L_0x00f4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x016b }
            r2.<init>()     // Catch:{ IOException -> 0x016b }
            r8 = 0
            r12 = 5
            java.lang.String r24 = r11.substring(r8, r12)     // Catch:{ IOException -> 0x016b }
            java.lang.String r8 = r24.toLowerCase()     // Catch:{ IOException -> 0x016b }
            r2.append(r8)     // Catch:{ IOException -> 0x016b }
            java.lang.String r8 = r11.substring(r12)     // Catch:{ IOException -> 0x016b }
            r2.append(r8)     // Catch:{ IOException -> 0x016b }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x016b }
        L_0x0111:
            boolean r8 = r2.startsWith(r10)     // Catch:{ IOException -> 0x016b }
            if (r8 == 0) goto L_0x011f
            r11 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r5.val = r11     // Catch:{ IOException -> 0x016b }
            goto L_0x0153
        L_0x011f:
            boolean r8 = r2.startsWith(r9)     // Catch:{ IOException -> 0x016b }
            if (r8 == 0) goto L_0x012d
            r11 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r5.val = r11     // Catch:{ IOException -> 0x016b }
            goto L_0x0153
        L_0x012d:
            boolean r8 = r2.startsWith(r13)     // Catch:{ IOException -> 0x016b }
            if (r8 == 0) goto L_0x013b
            r11 = 4702440627307020288(0x41426cd600000000, double:2415020.0)
            r5.val = r11     // Catch:{ IOException -> 0x016b }
            goto L_0x0153
        L_0x013b:
            r8 = 0
            char r11 = r2.charAt(r8)     // Catch:{ IOException -> 0x016b }
            r12 = 106(0x6a, float:1.49E-43)
            if (r11 == r12) goto L_0x0158
            char r11 = r2.charAt(r8)     // Catch:{ IOException -> 0x016b }
            r8 = 98
            if (r11 != r8) goto L_0x014d
            goto L_0x0158
        L_0x014d:
            double r11 = swisseph.SwissLib.atof(r2)     // Catch:{ IOException -> 0x016b }
            r5.val = r11     // Catch:{ IOException -> 0x016b }
        L_0x0153:
            double r11 = r5.val     // Catch:{ IOException -> 0x016b }
            double r11 = r3 - r11
            goto L_0x0173
        L_0x0158:
            if (r14 == 0) goto L_0x0166
            r2 = 0
            r14.setLength(r2)     // Catch:{ IOException -> 0x016b }
            r14.append(r15)     // Catch:{ IOException -> 0x016b }
            java.lang.String r0 = " invalid epoch"
            r14.append(r0)     // Catch:{ IOException -> 0x016b }
        L_0x0166:
            r21.close()     // Catch:{ IOException -> 0x016b }
            r2 = -1
            return r2
        L_0x016b:
            r0 = move-exception
            r5 = r1
            goto L_0x043d
        L_0x016f:
            r2 = r28
            r11 = r34
        L_0x0173:
            if (r6 == 0) goto L_0x0251
            r2 = 1
            r8 = r0[r2]     // Catch:{ IOException -> 0x024c }
            r2 = 0
        L_0x0179:
            char r5 = r8.charAt(r2)     // Catch:{ IOException -> 0x024c }
            r1 = 32
            if (r5 == r1) goto L_0x0231
            char r1 = r8.charAt(r2)     // Catch:{ IOException -> 0x024c }
            r5 = 9
            if (r1 != r5) goto L_0x019c
            r36 = r11
            r11 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r30 = 4702440627307020288(0x41426cd600000000, double:2415020.0)
            r32 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            goto L_0x0242
        L_0x019c:
            java.lang.String r5 = r8.substring(r2)     // Catch:{ IOException -> 0x024c }
            int r8 = r5.length()     // Catch:{ IOException -> 0x024c }
            r1 = 5
            if (r8 >= r1) goto L_0x01ae
            java.lang.String r1 = r5.toLowerCase()     // Catch:{ IOException -> 0x024c }
            r36 = r11
            goto L_0x01cd
        L_0x01ae:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x024c }
            r1.<init>()     // Catch:{ IOException -> 0x024c }
            r36 = r11
            r8 = 5
            r11 = 0
            java.lang.String r12 = r5.substring(r11, r8)     // Catch:{ IOException -> 0x024c }
            java.lang.String r11 = r12.toLowerCase()     // Catch:{ IOException -> 0x024c }
            r1.append(r11)     // Catch:{ IOException -> 0x024c }
            java.lang.String r5 = r5.substring(r8)     // Catch:{ IOException -> 0x024c }
            r1.append(r5)     // Catch:{ IOException -> 0x024c }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x024c }
        L_0x01cd:
            boolean r5 = r1.startsWith(r10)     // Catch:{ IOException -> 0x024c }
            if (r5 == 0) goto L_0x01db
            r11 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r6.val = r11     // Catch:{ IOException -> 0x024c }
            goto L_0x021a
        L_0x01db:
            boolean r5 = r1.startsWith(r9)     // Catch:{ IOException -> 0x024c }
            if (r5 == 0) goto L_0x01e9
            r8 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
            r6.val = r8     // Catch:{ IOException -> 0x024c }
            goto L_0x021a
        L_0x01e9:
            boolean r5 = r1.startsWith(r13)     // Catch:{ IOException -> 0x024c }
            if (r5 == 0) goto L_0x01f7
            r8 = 4702440627307020288(0x41426cd600000000, double:2415020.0)
            r6.val = r8     // Catch:{ IOException -> 0x024c }
            goto L_0x021a
        L_0x01f7:
            java.lang.String r5 = "jdate"
            boolean r5 = r1.startsWith(r5)     // Catch:{ IOException -> 0x024c }
            if (r5 == 0) goto L_0x0202
            r6.val = r3     // Catch:{ IOException -> 0x024c }
            goto L_0x021a
        L_0x0202:
            r5 = 0
            char r8 = r1.charAt(r5)     // Catch:{ IOException -> 0x024c }
            r9 = 106(0x6a, float:1.49E-43)
            if (r8 == r9) goto L_0x021e
            char r8 = r1.charAt(r5)     // Catch:{ IOException -> 0x024c }
            r5 = 98
            if (r8 != r5) goto L_0x0214
            goto L_0x021e
        L_0x0214:
            double r8 = swisseph.SwissLib.atof(r1)     // Catch:{ IOException -> 0x024c }
            r6.val = r8     // Catch:{ IOException -> 0x024c }
        L_0x021a:
            r26 = r2
            r2 = r1
            goto L_0x0253
        L_0x021e:
            if (r14 == 0) goto L_0x022c
            r1 = 0
            r14.setLength(r1)     // Catch:{ IOException -> 0x024c }
            r14.append(r15)     // Catch:{ IOException -> 0x024c }
            java.lang.String r0 = " invalid equinox"
            r14.append(r0)     // Catch:{ IOException -> 0x024c }
        L_0x022c:
            r21.close()     // Catch:{ IOException -> 0x024c }
            r1 = -1
            return r1
        L_0x0231:
            r36 = r11
            r11 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            r30 = 4702440627307020288(0x41426cd600000000, double:2415020.0)
            r32 = 4702479845562771449(0x414290813633e7f9, double:2433282.42345905)
        L_0x0242:
            int r2 = r2 + 1
            r1 = r39
            r5 = r43
            r11 = r36
            goto L_0x0179
        L_0x024c:
            r0 = move-exception
            r5 = r39
            goto L_0x043d
        L_0x0251:
            r36 = r11
        L_0x0253:
            if (r7 == 0) goto L_0x0289
            r1 = r0[r20]     // Catch:{ IOException -> 0x024c }
            r5 = r39
            r11 = r36
            int r1 = r5.check_t_terms(r11, r1, r7)     // Catch:{ IOException -> 0x0437 }
            swisseph.SwissLib r6 = r5.sl     // Catch:{ IOException -> 0x0437 }
            double r8 = r7.val     // Catch:{ IOException -> 0x0437 }
            double r8 = r6.swe_degnorm(r8)     // Catch:{ IOException -> 0x0437 }
            r7.val = r8     // Catch:{ IOException -> 0x0437 }
            r6 = -1
            if (r1 != r6) goto L_0x027b
            if (r14 == 0) goto L_0x0276
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " mean anomaly value invalid"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x0276:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x027b:
            r6 = 1
            if (r1 != r6) goto L_0x0282
            r1 = r43
            r1.val = r3     // Catch:{ IOException -> 0x0437 }
        L_0x0282:
            double r3 = r7.val     // Catch:{ IOException -> 0x0437 }
            double r3 = r3 * r22
            r7.val = r3     // Catch:{ IOException -> 0x0437 }
            goto L_0x028d
        L_0x0289:
            r5 = r39
            r11 = r36
        L_0x028d:
            r8 = r46
            if (r8 == 0) goto L_0x02af
            r1 = r0[r19]     // Catch:{ IOException -> 0x0437 }
            int r1 = r5.check_t_terms(r11, r1, r8)     // Catch:{ IOException -> 0x0437 }
            double r3 = r8.val     // Catch:{ IOException -> 0x0437 }
            int r6 = (r3 > r34 ? 1 : (r3 == r34 ? 0 : -1))
            if (r6 <= 0) goto L_0x02a0
            r3 = -1
            if (r1 != r3) goto L_0x02af
        L_0x02a0:
            if (r14 == 0) goto L_0x02aa
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " semi-axis value invalid"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x02aa:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x02af:
            r9 = r47
            if (r9 == 0) goto L_0x02dd
            r1 = r0[r18]     // Catch:{ IOException -> 0x0437 }
            int r1 = r5.check_t_terms(r11, r1, r9)     // Catch:{ IOException -> 0x0437 }
            double r3 = r9.val     // Catch:{ IOException -> 0x0437 }
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x02ca
            double r3 = r9.val     // Catch:{ IOException -> 0x0437 }
            int r6 = (r3 > r34 ? 1 : (r3 == r34 ? 0 : -1))
            if (r6 < 0) goto L_0x02ca
            r3 = -1
            if (r1 != r3) goto L_0x02dd
        L_0x02ca:
            if (r14 == 0) goto L_0x02d8
            r1 = 0
            r14.setLength(r1)     // Catch:{ IOException -> 0x0437 }
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " eccentricity invalid (no parabolic or hyperbolic or bits allowed)"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x02d8:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x02dd:
            r10 = r48
            if (r10 == 0) goto L_0x030e
            r1 = 5
            r1 = r0[r1]     // Catch:{ IOException -> 0x0437 }
            int r1 = r5.check_t_terms(r11, r1, r10)     // Catch:{ IOException -> 0x0437 }
            swisseph.SwissLib r3 = r5.sl     // Catch:{ IOException -> 0x0437 }
            double r6 = r10.val     // Catch:{ IOException -> 0x0437 }
            double r3 = r3.swe_degnorm(r6)     // Catch:{ IOException -> 0x0437 }
            r10.val = r3     // Catch:{ IOException -> 0x0437 }
            r3 = -1
            if (r1 != r3) goto L_0x0308
            if (r14 == 0) goto L_0x0303
            r1 = 0
            r14.setLength(r1)     // Catch:{ IOException -> 0x0437 }
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " perihelion argument value invalid"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x0303:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x0308:
            double r3 = r10.val     // Catch:{ IOException -> 0x0437 }
            double r3 = r3 * r22
            r10.val = r3     // Catch:{ IOException -> 0x0437 }
        L_0x030e:
            r1 = r49
            if (r1 == 0) goto L_0x033e
            r3 = r0[r17]     // Catch:{ IOException -> 0x0437 }
            int r3 = r5.check_t_terms(r11, r3, r1)     // Catch:{ IOException -> 0x0437 }
            swisseph.SwissLib r4 = r5.sl     // Catch:{ IOException -> 0x0437 }
            double r6 = r1.val     // Catch:{ IOException -> 0x0437 }
            double r6 = r4.swe_degnorm(r6)     // Catch:{ IOException -> 0x0437 }
            r1.val = r6     // Catch:{ IOException -> 0x0437 }
            r4 = -1
            if (r3 != r4) goto L_0x0338
            if (r14 == 0) goto L_0x0333
            r1 = 0
            r14.setLength(r1)     // Catch:{ IOException -> 0x0437 }
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " node value invalid"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x0333:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x0338:
            double r3 = r1.val     // Catch:{ IOException -> 0x0437 }
            double r3 = r3 * r22
            r1.val = r3     // Catch:{ IOException -> 0x0437 }
        L_0x033e:
            r1 = r50
            if (r1 == 0) goto L_0x036e
            r3 = r0[r16]     // Catch:{ IOException -> 0x0437 }
            int r3 = r5.check_t_terms(r11, r3, r1)     // Catch:{ IOException -> 0x0437 }
            swisseph.SwissLib r4 = r5.sl     // Catch:{ IOException -> 0x0437 }
            double r6 = r1.val     // Catch:{ IOException -> 0x0437 }
            double r6 = r4.swe_degnorm(r6)     // Catch:{ IOException -> 0x0437 }
            r1.val = r6     // Catch:{ IOException -> 0x0437 }
            r4 = -1
            if (r3 != r4) goto L_0x0368
            if (r14 == 0) goto L_0x0363
            r1 = 0
            r14.setLength(r1)     // Catch:{ IOException -> 0x0437 }
            r14.append(r15)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " inclination value invalid"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x0363:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x0368:
            double r3 = r1.val     // Catch:{ IOException -> 0x0437 }
            double r3 = r3 * r22
            r1.val = r3     // Catch:{ IOException -> 0x0437 }
        L_0x036e:
            r11 = r51
            if (r11 == 0) goto L_0x039e
            r1 = 8
            r1 = r0[r1]     // Catch:{ IOException -> 0x0437 }
            r2 = 0
        L_0x0377:
            char r3 = r1.charAt(r2)     // Catch:{ IOException -> 0x0437 }
            r4 = 32
            if (r3 == r4) goto L_0x039b
            char r3 = r1.charAt(r2)     // Catch:{ IOException -> 0x0437 }
            r6 = 9
            if (r3 != r6) goto L_0x0388
            goto L_0x039b
        L_0x0388:
            java.lang.String r1 = r1.substring(r2)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException -> 0x0437 }
            r3 = 0
            r11.setLength(r3)     // Catch:{ IOException -> 0x0437 }
            r11.append(r1)     // Catch:{ IOException -> 0x0437 }
            r26 = r2
            r2 = r1
            goto L_0x039e
        L_0x039b:
            int r2 = r2 + 1
            goto L_0x0377
        L_0x039e:
            r12 = r0
            r0 = r52
            if (r0 == 0) goto L_0x03e8
            r1 = r29
            r3 = 9
            if (r1 <= r3) goto L_0x03e8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0437 }
            r1.<init>()     // Catch:{ IOException -> 0x0437 }
            int r4 = r2.length()     // Catch:{ IOException -> 0x0437 }
            int r6 = r26 + 9
            int r3 = swisseph.SMath.min((int) r4, (int) r6)     // Catch:{ IOException -> 0x0437 }
            r4 = 0
            java.lang.String r3 = r2.substring(r4, r3)     // Catch:{ IOException -> 0x0437 }
            r1.append(r3)     // Catch:{ IOException -> 0x0437 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x0437 }
            int r3 = swisseph.SMath.min((int) r3, (int) r6)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r2 = r2.substring(r3)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ IOException -> 0x0437 }
            r1.append(r2)     // Catch:{ IOException -> 0x0437 }
            r1.toString()     // Catch:{ IOException -> 0x0437 }
            r1 = 9
            r1 = r12[r1]     // Catch:{ IOException -> 0x0437 }
            java.lang.String r2 = "geo"
            int r1 = r1.indexOf(r2)     // Catch:{ IOException -> 0x0437 }
            if (r1 < 0) goto L_0x03e8
            int r1 = r0.val     // Catch:{ IOException -> 0x0437 }
            r2 = 1
            r1 = r1 | r2
            r0.val = r1     // Catch:{ IOException -> 0x0437 }
        L_0x03e8:
            r0 = r15
            r15 = 1
            goto L_0x0417
        L_0x03eb:
            r10 = r48
            r2 = r49
            r15 = r50
            r11 = r51
            r21 = r12
            r28 = 20
            r12 = r0
            r0 = r52
            r38 = r5
            r5 = r1
            r1 = r38
        L_0x03ff:
            r2 = r40
            r0 = r12
            r12 = r21
            r15 = r26
            r11 = r27
            r38 = r5
            r5 = r1
            r1 = r38
            goto L_0x0045
        L_0x040f:
            r5 = r1
            r21 = r12
            r26 = r15
            r0 = r26
            r15 = 0
        L_0x0417:
            if (r15 != 0) goto L_0x0432
            if (r14 == 0) goto L_0x042d
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " elements for planet "
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
            r3 = r40
            r14.append(r3)     // Catch:{ IOException -> 0x0437 }
            java.lang.String r0 = " not found"
            r14.append(r0)     // Catch:{ IOException -> 0x0437 }
        L_0x042d:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = -1
            return r1
        L_0x0432:
            r21.close()     // Catch:{ IOException -> 0x0437 }
            r1 = 0
            return r1
        L_0x0437:
            r0 = move-exception
            goto L_0x043d
        L_0x0439:
            r0 = move-exception
            r5 = r1
            r21 = r12
        L_0x043d:
            if (r21 == 0) goto L_0x0444
            r21.close()     // Catch:{ IOException -> 0x0443 }
            goto L_0x0444
        L_0x0443:
            r0 = move-exception
        L_0x0444:
            r1 = -1
            return r1
        L_0x0446:
            r0 = move-exception
            r15 = r50
            r11 = r51
            r3 = r2
            r2 = r49
            goto L_0x0461
        L_0x044f:
            r0 = move-exception
            r15 = r50
            r3 = r2
            r2 = r11
            goto L_0x0459
        L_0x0455:
            r0 = move-exception
            r3 = r2
            r2 = r11
            r15 = r12
        L_0x0459:
            r11 = r51
            goto L_0x0461
        L_0x045c:
            r0 = move-exception
            r3 = r2
            r2 = r11
            r15 = r12
            r11 = r13
        L_0x0461:
            r38 = r5
            r5 = r1
            r1 = r38
            r0 = 15
            if (r3 < r0) goto L_0x047a
            if (r14 == 0) goto L_0x0478
            r1 = 0
            r14.setLength(r1)
            java.lang.String r0 = "error no elements for fictitious body no "
            r14.append(r0)
            r14.append(r3)
        L_0x0478:
            r1 = -1
            return r1
        L_0x047a:
            if (r1 == 0) goto L_0x0485
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r4 = 0
            r12 = r0[r4]
            r1.val = r12
        L_0x0485:
            if (r6 == 0) goto L_0x0490
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r1 = 1
            r12 = r0[r1]
            r6.val = r12
        L_0x0490:
            if (r7 == 0) goto L_0x049c
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r12 = r0[r20]
            double r12 = r12 * r22
            r7.val = r12
        L_0x049c:
            if (r8 == 0) goto L_0x04a6
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r6 = r0[r19]
            r8.val = r6
        L_0x04a6:
            if (r9 == 0) goto L_0x04b0
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r6 = r0[r18]
            r9.val = r6
        L_0x04b0:
            if (r10 == 0) goto L_0x04bd
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r1 = 5
            r6 = r0[r1]
            double r6 = r6 * r22
            r10.val = r6
        L_0x04bd:
            if (r2 == 0) goto L_0x04c9
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r6 = r0[r17]
            double r6 = r6 * r22
            r2.val = r6
        L_0x04c9:
            if (r15 == 0) goto L_0x04d5
            double[][] r0 = plan_oscu_elem
            r0 = r0[r3]
            r1 = r0[r16]
            double r1 = r1 * r22
            r15.val = r1
        L_0x04d5:
            if (r11 == 0) goto L_0x04e3
            r1 = 0
            r11.setLength(r1)
            java.lang.String[] r0 = plan_fict_nam
            r0 = r0[r3]
            r11.append(r0)
            goto L_0x04e4
        L_0x04e3:
            r1 = 0
        L_0x04e4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwephMosh.read_elements_file(int, double, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, swisseph.DblObj, java.lang.StringBuffer, swisseph.IntObj, java.lang.StringBuffer):int");
    }

    private int check_t_terms(double d, String str, DblObj dblObj) {
        int i;
        long j;
        int i2;
        long j2;
        String str2 = str;
        DblObj dblObj2 = dblObj;
        double[] dArr = new double[5];
        dArr[0] = d / 36525.0d;
        dArr[1] = dArr[0];
        dArr[2] = dArr[1] * dArr[1];
        dArr[3] = dArr[2] * dArr[1];
        dArr[4] = dArr[3] * dArr[1];
        char c = '+';
        if (str2.indexOf(43) + str2.indexOf(45) > -2) {
            i = 1;
        } else {
            i = 0;
        }
        dblObj2.val = 0.0d;
        double d2 = 1.0d;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= str.length() || !(str2.charAt(i3) == ' ' || str2.charAt(i3) == 9)) {
                if (i3 == str.length() || str2.charAt(i3) == c) {
                    j2 = 0;
                } else if (str2.charAt(i3) == '-') {
                    j2 = 0;
                } else {
                    while (i3 < str.length() && (str2.charAt(i3) == '*' || str2.charAt(i3) == ' ' || str2.charAt(i3) == 9)) {
                        i3++;
                    }
                    if (i3 >= str.length() || !(str2.charAt(i3) == 't' || str2.charAt(i3) == 'T')) {
                        double atof = SwissLib.atof(str2.substring(i3));
                        j = 0;
                        if (atof != 0.0d || str2.charAt(i3) == '0') {
                            d2 *= atof;
                        }
                    } else {
                        i3++;
                        if (i3 >= str.length() || !(str2.charAt(i3) == c || str2.charAt(i3) == '-')) {
                            int atoi = SwissLib.atoi(str2.substring(SMath.min(str.length(), i3)));
                            if (atoi > 4 || atoi < 0) {
                                j = 0;
                            } else {
                                d2 *= dArr[atoi];
                                j = 0;
                            }
                        } else {
                            d2 *= dArr[0];
                            j = 0;
                        }
                    }
                    while (i3 < str.length() && (Character.isDigit(str2.charAt(i3)) || str2.charAt(i3) == '.')) {
                        i3++;
                    }
                    i4++;
                    long j3 = j;
                    c = '+';
                }
                if (i4 > 0) {
                    dblObj2.val += d2;
                }
                if (i3 == str.length() || str2.charAt(i3) != '-') {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
                double d3 = (double) (i2 * 1);
                if (i3 == str.length()) {
                    return i;
                }
                i3++;
                d2 = d3;
                i4++;
                long j32 = j;
                c = '+';
            } else {
                i3++;
            }
        }
    }
}
