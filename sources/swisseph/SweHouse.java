package swisseph;

import java.io.Serializable;

class SweHouse implements Serializable {
    static final double MILLIARCSEC = 2.7777777777777776E-7d;
    static final double VERY_SMALL = 1.0E-10d;
    SwissLib sl;
    SwissEph sw;
    SwissData swed;

    SweHouse() {
        this.sl = null;
        this.sw = null;
        this.swed = null;
        this.sl = new SwissLib();
        this.sw = new SwissEph();
        this.swed = new SwissData();
    }

    SweHouse(SwissLib swissLib, SwissEph swissEph, SwissData swissData) {
        this.sl = null;
        this.sw = null;
        this.swed = null;
        this.sl = swissLib;
        this.sw = swissEph;
        this.swed = swissData;
        if (swissLib == null) {
            this.sl = new SwissLib();
        }
        if (this.sw == null) {
            this.sw = new SwissEph();
        }
        if (this.swed == null) {
            this.swed = new SwissData();
        }
    }

    private double sind(double d) {
        return SMath.sin(d * 0.0174532925199433d);
    }

    private double cosd(double d) {
        return SMath.cos(d * 0.0174532925199433d);
    }

    private double tand(double d) {
        return SMath.tan(d * 0.0174532925199433d);
    }

    private double asind(double d) {
        return SMath.asin(d) * 57.2957795130823d;
    }

    private double atand(double d) {
        return SMath.atan(d) * 57.2957795130823d;
    }

    /* access modifiers changed from: package-private */
    public int swe_houses(double d, int i, double d2, double d3, int i2, double[] dArr, double[] dArr2) {
        return swe_houses(d, i, d2, d3, i2, dArr, dArr2, 0);
    }

    /* access modifiers changed from: package-private */
    public int swe_houses(double d, int i, double d2, double d3, int i2, double[] dArr, double[] dArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        double[] dArr3 = new double[2];
        double deltaT = d + SweDate.getDeltaT(d);
        SidData sidData = this.swed.sidd;
        if (Character.toUpperCase((char) i2) == 'G') {
            i4 = 36;
        } else {
            i4 = 12;
        }
        int i9 = 65536 & i8;
        if (i9 != 0 && !this.swed.ayana_is_set) {
            this.sw.swe_set_sid_mode(0, 0.0d, 0.0d);
        }
        double swi_epsiln = this.sl.swi_epsiln(deltaT, 0) * 57.2957795130823d;
        this.sl.swi_nutation(deltaT, 0, dArr3);
        for (int i10 = 0; i10 < 2; i10++) {
            dArr3[i10] = dArr3[i10] * 57.2957795130823d;
        }
        SwissLib swissLib = this.sl;
        double swe_degnorm = swissLib.swe_degnorm((swissLib.swe_sidtime0(d, swi_epsiln + dArr3[1], dArr3[0]) * 15.0d) + d3);
        if (i9 == 0) {
            i5 = i4;
            i6 = i8;
            i7 = swe_houses_armc(swe_degnorm, d2, swi_epsiln + dArr3[1], i2, dArr, dArr2, i3);
        } else if ((sidData.sid_mode & 256) != 0) {
            i7 = sidereal_houses_ecl_t0(deltaT, swe_degnorm, swi_epsiln + dArr3[1], dArr3, d2, i2, dArr, dArr2, i3);
            i5 = i4;
            i6 = i8;
        } else {
            int i11 = i4;
            if ((sidData.sid_mode & 512) != 0) {
                i7 = sidereal_houses_ssypl(deltaT, swe_degnorm, swi_epsiln + dArr3[1], dArr3, d2, i2, dArr, dArr2, i3);
                i5 = i11;
                i6 = i8;
            } else {
                i5 = i11;
                i6 = i8;
                i7 = sidereal_houses_trad(deltaT, swe_degnorm, swi_epsiln + dArr3[1], dArr3[0], d2, i2, dArr, dArr2, i3);
            }
        }
        if ((i6 & 8192) != 0) {
            int i12 = 1;
            while (true) {
                int i13 = i5;
                if (i12 > i13) {
                    break;
                }
                dArr[i12] = dArr[i12] * 0.0174532925199433d;
                i12++;
                i5 = i13;
            }
            for (int i14 = 0; i14 < 8; i14++) {
                int i15 = i14 + i3;
                dArr2[i15] = dArr2[i15] * 0.0174532925199433d;
            }
        }
        return i7;
    }

    private int sidereal_houses_ecl_t0(double d, double d2, double d3, double[] dArr, double d4, int i, double[] dArr2, double[] dArr3, int i2) {
        int i3;
        double d5 = d3;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        SidData sidData = this.swed.sidd;
        if (Character.toUpperCase((char) i) == 'G') {
            i3 = 36;
        } else {
            i3 = 12;
        }
        double swi_epsiln = this.sl.swi_epsiln(sidData.t0, 0);
        dArr4[4] = 1.0d;
        dArr4[0] = 1.0d;
        dArr4[5] = 0.0d;
        dArr4[3] = 0.0d;
        dArr4[2] = 0.0d;
        dArr4[1] = 0.0d;
        double d6 = -swi_epsiln;
        this.sl.swi_coortrf(dArr4, dArr4, d6);
        double[] dArr8 = dArr4;
        int i4 = i3;
        this.sl.swi_coortrf(dArr8, 3, dArr4, 3, d6);
        this.sl.swi_precess(dArr8, sidData.t0, 0, 1);
        this.sl.swi_precess(dArr8, d, 0, -1);
        this.sl.swi_precess(dArr8, 3, sidData.t0, 0, 1);
        this.sl.swi_precess(dArr8, 3, d, 0, -1);
        this.sl.swi_coortrf(dArr4, dArr4, (d5 - dArr[1]) * 0.0174532925199433d);
        this.sl.swi_coortrf(dArr4, 3, dArr4, 3, (d5 - dArr[1]) * 0.0174532925199433d);
        this.sl.swi_cartpol_sp(dArr4, 0, dArr4, 0);
        dArr4[0] = dArr4[0] + (dArr[0] * 0.0174532925199433d);
        this.sl.swi_polcart_sp(dArr4, dArr4);
        double d7 = (-d5) * 0.0174532925199433d;
        this.sl.swi_coortrf(dArr4, dArr4, d7);
        double[] dArr9 = dArr4;
        double[] dArr10 = dArr4;
        this.sl.swi_coortrf(dArr9, 3, dArr10, 3, d7);
        this.sl.swi_cross_prod(dArr9, 0, dArr10, 3, dArr7, 0);
        double d8 = (dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]);
        double asin = SMath.asin(SMath.sqrt(d8) / SMath.sqrt((dArr7[2] * dArr7[2]) + d8)) * 57.2957795130823d;
        if (SMath.abs(dArr4[5]) < 1.0E-15d) {
            dArr4[5] = 1.0E-15d;
        }
        double d9 = dArr4[2] / dArr4[5];
        double abs = dArr4[5] / SMath.abs(dArr4[5]);
        for (int i5 = 0; i5 <= 2; i5++) {
            dArr5[i5] = (dArr4[i5] - (dArr4[i5 + 3] * d9)) * abs;
        }
        this.sl.swi_cartpol(dArr5, dArr6);
        int swe_houses_armc = swe_houses_armc(this.sl.swe_degnorm(d2 - (dArr6[0] * 57.2957795130823d)), d4, asin, i, dArr2, dArr3, i2);
        double acos = SMath.acos(this.sl.swi_dot_prod_unit(dArr4, dArr5)) * 57.2957795130823d;
        if (d < sidData.t0) {
            acos = -acos;
        }
        int i6 = 1;
        while (true) {
            int i7 = i4;
            if (i6 > i7) {
                break;
            }
            dArr2[i6] = this.sl.swe_degnorm((dArr2[i6] - acos) - sidData.ayan_t0);
            i6++;
            i4 = i7;
        }
        for (int i8 = 0; i8 <= 8; i8++) {
            int i9 = i2 + i8;
            dArr3[i9] = this.sl.swe_degnorm((dArr3[i9] - acos) - sidData.ayan_t0);
        }
        return swe_houses_armc;
    }

    private int sidereal_houses_ssypl(double d, double d2, double d3, double[] dArr, double d4, int i, double[] dArr2, double[] dArr3, int i2) {
        int i3;
        double d5 = d3;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        double[] dArr8 = new double[6];
        SidData sidData = this.swed.sidd;
        if (Character.toUpperCase((char) i) == 'G') {
            i3 = 36;
        } else {
            i3 = 12;
        }
        double swi_epsiln = this.sl.swi_epsiln(2451545.0d, 0);
        dArr4[4] = 1.0d;
        dArr4[0] = 1.0d;
        dArr4[5] = 0.0d;
        dArr4[3] = 0.0d;
        dArr4[2] = 0.0d;
        dArr4[1] = 0.0d;
        this.sl.swi_coortrf(dArr4, dArr4, -0.027553530354527005d);
        int i4 = i3;
        SidData sidData2 = sidData;
        this.sl.swi_coortrf(dArr4, 3, dArr4, 3, -0.027553530354527005d);
        this.sl.swi_cartpol_sp(dArr4, 0, dArr4, 0);
        dArr4[0] = dArr4[0] + 1.877670046803984d;
        this.sl.swi_polcart_sp(dArr4, dArr4);
        double d6 = swi_epsiln;
        double d7 = -d6;
        this.sl.swi_coortrf(dArr4, dArr4, d7);
        double d8 = d7;
        double[] dArr9 = dArr4;
        double d9 = d6;
        this.sl.swi_coortrf(dArr9, 3, dArr4, 3, d8);
        this.sl.swi_precess(dArr9, d, 0, -1);
        this.sl.swi_precess(dArr9, 3, d, 0, -1);
        this.sl.swi_coortrf(dArr4, dArr4, (d5 - dArr[1]) * 0.0174532925199433d);
        this.sl.swi_coortrf(dArr4, 3, dArr4, 3, (d5 - dArr[1]) * 0.0174532925199433d);
        this.sl.swi_cartpol_sp(dArr4, 0, dArr4, 0);
        dArr4[0] = dArr4[0] + (dArr[0] * 0.0174532925199433d);
        this.sl.swi_polcart_sp(dArr4, dArr4);
        double d10 = (-d5) * 0.0174532925199433d;
        this.sl.swi_coortrf(dArr4, dArr4, d10);
        double[] dArr10 = dArr4;
        double[] dArr11 = dArr4;
        this.sl.swi_coortrf(dArr10, 3, dArr11, 3, d10);
        this.sl.swi_cross_prod(dArr10, 0, dArr11, 3, dArr8, 0);
        double d11 = (dArr8[0] * dArr8[0]) + (dArr8[1] * dArr8[1]);
        double asin = SMath.asin(SMath.sqrt(d11) / SMath.sqrt((dArr8[2] * dArr8[2]) + d11)) * 57.2957795130823d;
        if (SMath.abs(dArr4[5]) < 1.0E-15d) {
            dArr4[5] = 1.0E-15d;
        }
        double d12 = dArr4[2] / dArr4[5];
        double abs = dArr4[5] / SMath.abs(dArr4[5]);
        int i5 = 0;
        for (int i6 = 2; i5 <= i6; i6 = 2) {
            dArr6[i5] = (dArr4[i5] - (dArr4[i5 + 3] * d12)) * abs;
            i5++;
        }
        this.sl.swi_cartpol(dArr6, dArr7);
        int swe_houses_armc = swe_houses_armc(this.sl.swe_degnorm(d2 - (dArr7[0] * 57.2957795130823d)), d4, asin, i, dArr2, dArr3, i2);
        double acos = (SMath.acos(this.sl.swi_dot_prod_unit(dArr4, dArr6)) * 57.2957795130823d) - 107.58883387999998d;
        dArr5[0] = 1.0d;
        dArr5[2] = 0.0d;
        dArr5[1] = 0.0d;
        SidData sidData3 = sidData2;
        if (sidData3.t0 != 2451545.0d) {
            this.sl.swi_precess(dArr5, sidData3.t0, 0, 1);
        }
        this.sl.swi_coortrf(dArr5, dArr5, d9);
        this.sl.swi_cartpol(dArr5, dArr5);
        dArr5[0] = dArr5[0] - 1.877670046803984d;
        this.sl.swi_polcart(dArr5, dArr5);
        this.sl.swi_coortrf(dArr5, dArr5, 0.027553530354527005d);
        this.sl.swi_cartpol(dArr5, dArr5);
        dArr5[0] = dArr5[0] + 1.8777793895872261d;
        double d13 = dArr5[0] * 57.2957795130823d;
        int i7 = 1;
        while (true) {
            int i8 = i4;
            if (i7 > i8) {
                break;
            }
            dArr2[i7] = this.sl.swe_degnorm(((dArr2[i7] - acos) - sidData3.ayan_t0) - d13);
            i7++;
            i4 = i8;
        }
        for (int i9 = 0; i9 <= 8; i9++) {
            int i10 = i2 + i9;
            dArr3[i10] = this.sl.swe_degnorm(((dArr3[i10] - acos) - sidData3.ayan_t0) - d13);
        }
        return swe_houses_armc;
    }

    private int sidereal_houses_trad(double d, double d2, double d3, double d4, double d5, int i, double[] dArr, double[] dArr2, int i2) {
        int i3;
        char c;
        char upperCase = Character.toUpperCase((char) i);
        double swe_get_ayanamsa = this.sw.swe_get_ayanamsa(d);
        if (upperCase == 'G') {
            i3 = 36;
        } else {
            i3 = 12;
        }
        if (upperCase == 'W') {
            c = 'E';
        } else {
            c = upperCase;
        }
        char c2 = upperCase;
        int swe_houses_armc = swe_houses_armc(d2, d5, d3, c, dArr, dArr2, i2);
        int i4 = 1;
        while (i4 <= i3) {
            dArr[i4] = this.sl.swe_degnorm((dArr[i4] - swe_get_ayanamsa) - d4);
            i4++;
        }
        if (c2 == 'W') {
            dArr[i4] = dArr[i4] - (dArr[i4] % 30.0d);
        }
        for (int i5 = 0; i5 < 8; i5++) {
            if (i5 != 2) {
                int i6 = i2 + i5;
                dArr2[i6] = this.sl.swe_degnorm((dArr2[i6] - swe_get_ayanamsa) - d4);
            }
        }
        return swe_houses_armc;
    }

    /* access modifiers changed from: package-private */
    public int swe_houses_armc(double d, double d2, double d3, int i, double[] dArr, double[] dArr2, int i2) {
        int i3;
        Houses houses = new Houses();
        char c = (char) i;
        if (Character.toUpperCase(c) == 'G') {
            i3 = 36;
        } else {
            i3 = 12;
        }
        double swe_degnorm = this.sl.swe_degnorm(d);
        int CalcH = CalcH(swe_degnorm, d2, d3, c, 2, houses);
        dArr[0] = 0.0d;
        for (int i4 = 1; i4 <= i3; i4++) {
            dArr[i4] = houses.cusp[i4];
        }
        dArr2[i2 + 0] = houses.ac;
        dArr2[i2 + 1] = houses.mc;
        dArr2[i2 + 2] = swe_degnorm;
        dArr2[i2 + 3] = houses.vertex;
        dArr2[i2 + 4] = houses.equasc;
        dArr2[i2 + 5] = houses.coasc1;
        dArr2[i2 + 6] = houses.coasc2;
        dArr2[i2 + 7] = houses.polasc;
        for (int i5 = 8; i5 < 10; i5++) {
            dArr2[i2 + i5] = 0.0d;
        }
        return CalcH;
    }

    private double apc_sector(int i, double d, double d2, double d3) {
        int i2;
        double d4;
        int i3 = i;
        double atan = SMath.atan(((SMath.tan(d) * SMath.tan(d2)) * SMath.cos(d3)) / (((SMath.tan(d) * SMath.tan(d2)) * SMath.sin(d3)) + 1.0d));
        double atan2 = SMath.atan(SMath.sin(atan) / SMath.tan(d));
        boolean z = true;
        if (i3 < 8) {
            i2 = i3 - 1;
        } else {
            i2 = i3 - 13;
            z = false;
        }
        if (z) {
            d4 = atan + d3 + 1.5707963267948966d + ((((double) i2) * (1.5707963267948966d - atan)) / 3.0d);
        } else {
            d4 = atan + d3 + 1.5707963267948966d + ((((double) i2) * (atan + 1.5707963267948966d)) / 3.0d);
        }
        double swe_radnorm = this.sl.swe_radnorm(d4);
        return this.sl.swe_degnorm(SMath.atan2((SMath.tan(atan2) * SMath.tan(d) * SMath.sin(d3)) + SMath.sin(swe_radnorm), (SMath.cos(d2) * ((SMath.tan(atan2) * SMath.tan(d) * SMath.cos(d3)) + SMath.cos(swe_radnorm))) + (SMath.sin(d2) * SMath.tan(d) * SMath.sin(d3 - swe_radnorm))) * 57.2957795130823d);
    }

    /* access modifiers changed from: package-private */
    public String swe_house_name(int i) {
        switch (Character.toUpperCase((char) i)) {
            case 'A':
                return "equal";
            case 'B':
                return "Alcabitius";
            case 'C':
                return "Campanus";
            case 'E':
                return "equal";
            case 'G':
                return "Gauquelin sectors";
            case 'H':
                return "horizon/azimut";
            case 'K':
                return "Koch";
            case 'M':
                return "Morinus";
            case 'O':
                return "Porphyry";
            case 'R':
                return "Regiomontanus";
            case 'T':
                return "Polich/Page";
            case 'U':
                return "Krusinski-Pisa-Goelzer";
            case 'V':
                return "equal/Vehlow";
            case 'W':
                return "equal/ whole sign";
            case 'X':
                return "axial rotation system/Meridian houses";
            case 'Y':
                return "APC houses";
            default:
                return "Placidus";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int CalcH(double r54, double r56, double r58, char r60, int r61, swisseph.Houses r62) {
        /*
            r53 = this;
            r9 = r53
            r10 = r58
            r12 = r61
            r13 = r62
            r14 = 3
            double[] r15 = new double[r14]
            double r16 = r9.cosd(r10)
            double r18 = r9.sind(r10)
            double r20 = r9.tand(r10)
            double r0 = swisseph.SMath.abs((double) r56)
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r0 = r0 - r7
            double r0 = swisseph.SMath.abs((double) r0)
            r22 = 4457293557087583675(0x3ddb7cdfd9d7bdbb, double:1.0E-10)
            r24 = 0
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 >= 0) goto L_0x0042
            int r0 = (r56 > r24 ? 1 : (r56 == r24 ? 0 : -1))
            if (r0 >= 0) goto L_0x003b
            r0 = -4587338432941923197(0xc0567fffffffe483, double:-89.9999999999)
            r5 = r0
            goto L_0x0044
        L_0x003b:
            r0 = 4636033603912852611(0x40567fffffffe483, double:89.9999999999)
            r5 = r0
            goto L_0x0044
        L_0x0042:
            r5 = r56
        L_0x0044:
            double r3 = r9.tand(r5)
            double r26 = r54 - r7
            double r0 = swisseph.SMath.abs((double) r26)
            r28 = r15
            r14 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r29 = 4640537203540230144(0x4066800000000000, double:180.0)
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x0089
            double r0 = r54 - r14
            double r0 = swisseph.SMath.abs((double) r0)
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x0089
            double r0 = r53.tand(r54)
            double r0 = r0 / r16
            double r0 = r9.atand(r0)
            r13.mc = r0
            int r0 = (r54 > r7 ? 1 : (r54 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0096
            int r0 = (r54 > r14 ? 1 : (r54 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0096
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            goto L_0x0096
        L_0x0089:
            double r0 = swisseph.SMath.abs((double) r26)
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 > 0) goto L_0x0094
            r13.mc = r7
            goto L_0x0096
        L_0x0094:
            r13.mc = r14
        L_0x0096:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            double r1 = r54 + r7
            r0 = r53
            r31 = r3
            r3 = r5
            r14 = r5
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r13.ac = r0
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r35 = 1
            r0[r35] = r1
            double[] r0 = r13.cusp
            double r1 = r13.mc
            r36 = 10
            r0[r36] = r1
            char r8 = java.lang.Character.toUpperCase(r60)
            r37 = 4639481672377565184(0x4062c00000000000, double:150.0)
            r39 = 4638144666238189568(0x405e000000000000, double:120.0)
            r41 = 4633641066610819072(0x404e000000000000, double:60.0)
            r6 = -4587338432941916160(0xc056800000000000, double:-90.0)
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r43 = 4611686018427387904(0x4000000000000000, double:2.0)
            r4 = 4629137466983448576(0x403e000000000000, double:30.0)
            r45 = 11
            r46 = 4613937818241073152(0x4008000000000000, double:3.0)
            r48 = 2
            r49 = 0
            r2 = 12
            switch(r8) {
                case 65: goto L_0x0b8a;
                case 66: goto L_0x0ad9;
                case 67: goto L_0x0913;
                case 68: goto L_0x00e7;
                case 69: goto L_0x0b8a;
                case 70: goto L_0x00e7;
                case 71: goto L_0x06e9;
                case 72: goto L_0x0913;
                case 73: goto L_0x00e7;
                case 74: goto L_0x00e7;
                case 75: goto L_0x0638;
                case 76: goto L_0x00e7;
                case 77: goto L_0x05cd;
                case 78: goto L_0x00e7;
                case 79: goto L_0x05b9;
                case 80: goto L_0x00e7;
                case 81: goto L_0x00e7;
                case 82: goto L_0x04f2;
                case 83: goto L_0x00e7;
                case 84: goto L_0x042e;
                case 85: goto L_0x032b;
                case 86: goto L_0x02d3;
                case 87: goto L_0x027e;
                case 88: goto L_0x01bb;
                case 89: goto L_0x010c;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            r26 = r4
            r50 = r6
            r11 = r8
            r5 = r31
            r10 = 12
            r0 = 80
            if (r11 == r0) goto L_0x0bcc
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "swe_houses: make Placidus, unknown key "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            goto L_0x0bcc
        L_0x010c:
            r12 = 1
        L_0x010d:
            if (r12 > r2) goto L_0x013f
            double[] r4 = r13.cusp
            r0 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r20 = r14 * r0
            double r26 = r10 * r0
            double r31 = r54 * r0
            r0 = r53
            r1 = r12
            r5 = 12
            r2 = r20
            r20 = r4
            r60 = r8
            r8 = 12
            r4 = r26
            r6 = r31
            double r0 = r0.apc_sector(r1, r2, r4, r6)
            r20[r12] = r0
            int r12 = r12 + 1
            r8 = r60
            r2 = 12
            r6 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x010d
        L_0x013f:
            r60 = r8
            r8 = 12
            double[] r0 = r13.cusp
            r1 = r0[r35]
            r13.ac = r1
            double[] r0 = r13.cusp
            r1 = r0[r36]
            r13.mc = r1
            double r0 = swisseph.SMath.abs((double) r14)
            r6 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r2 = r6 - r10
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x01b0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x01a5
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            r0 = 1
        L_0x0185:
            if (r0 > r8) goto L_0x019a
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r0]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0185
        L_0x019a:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x01a5:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x01b0:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x01bb:
            r60 = r8
            r6 = 4636033603912859648(0x4056800000000000, double:90.0)
            r8 = 12
            r1 = r54
            r0 = 1
        L_0x01c7:
            if (r0 > r8) goto L_0x024e
            int r3 = r0 + 10
            if (r3 <= r8) goto L_0x01cf
            int r3 = r3 + -12
        L_0x01cf:
            swisseph.SwissLib r12 = r9.sl
            double r1 = r1 + r4
            double r1 = r12.swe_degnorm(r1)
            double r20 = r1 - r6
            double r26 = swisseph.SMath.abs((double) r20)
            int r12 = (r26 > r22 ? 1 : (r26 == r22 ? 0 : -1))
            if (r12 <= 0) goto L_0x021b
            r26 = 4643457506423603200(0x4070e00000000000, double:270.0)
            double r31 = r1 - r26
            double r26 = swisseph.SMath.abs((double) r31)
            int r12 = (r26 > r22 ? 1 : (r26 == r22 ? 0 : -1))
            if (r12 <= 0) goto L_0x021b
            double r20 = r9.tand(r1)
            double[] r12 = r13.cusp
            double r4 = r20 / r16
            double r4 = r9.atand(r4)
            r12[r3] = r4
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0231
            r4 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r12 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r12 > 0) goto L_0x0231
            double[] r4 = r13.cusp
            swisseph.SwissLib r5 = r9.sl
            double[] r12 = r13.cusp
            r20 = r12[r3]
            double r8 = r20 + r29
            double r8 = r5.swe_degnorm(r8)
            r4[r3] = r8
            goto L_0x0231
        L_0x021b:
            double r4 = swisseph.SMath.abs((double) r20)
            int r8 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r8 > 0) goto L_0x0228
            double[] r4 = r13.cusp
            r4[r3] = r6
            goto L_0x0231
        L_0x0228:
            double[] r4 = r13.cusp
            r8 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r4[r3] = r8
        L_0x0231:
            double[] r4 = r13.cusp
            r9 = r53
            swisseph.SwissLib r5 = r9.sl
            double[] r8 = r13.cusp
            r6 = r8[r3]
            double r5 = r5.swe_degnorm(r6)
            r4[r3] = r5
            int r0 = r0 + 1
            r4 = 4629137466983448576(0x403e000000000000, double:30.0)
            r6 = 4636033603912859648(0x4056800000000000, double:90.0)
            r8 = 12
            goto L_0x01c7
        L_0x024e:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0273
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x0273:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x027e:
            r60 = r8
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x02a0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r0[r35] = r1
        L_0x02a0:
            double[] r0 = r13.cusp
            double r1 = r13.ac
            double r3 = r13.ac
            r5 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r3 = r3 % r5
            double r1 = r1 - r3
            r0[r35] = r1
            r0 = 2
        L_0x02ad:
            r1 = 12
            if (r0 > r1) goto L_0x02c8
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r35]
            int r3 = r0 + -1
            int r3 = r3 * 30
            double r6 = (double) r3
            double r4 = r4 + r6
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x02ad
        L_0x02c8:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x02d3:
            r60 = r8
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x02f5
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r0[r35] = r1
        L_0x02f5:
            double[] r0 = r13.cusp
            swisseph.SwissLib r1 = r9.sl
            double r2 = r13.ac
            r4 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r2 = r2 - r4
            double r1 = r1.swe_degnorm(r2)
            r0[r35] = r1
            r0 = 2
        L_0x0305:
            r7 = 12
            if (r0 > r7) goto L_0x0320
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r35]
            int r3 = r0 + -1
            int r3 = r3 * 30
            double r7 = (double) r3
            double r4 = r4 + r7
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0305
        L_0x0320:
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x032b:
            r60 = r8
            swisseph.SwissLib r2 = r9.sl
            double r3 = r13.ac
            double r5 = r13.mc
            double r2 = r2.swe_difdeg2n(r3, r5)
            int r4 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r4 >= 0) goto L_0x0347
            swisseph.SwissLib r2 = r9.sl
            double r3 = r13.ac
            double r3 = r3 + r29
            double r2 = r2.swe_degnorm(r3)
            r13.ac = r2
        L_0x0347:
            double r2 = r13.ac
            r28[r49] = r2
            r28[r35] = r24
            r28[r48] = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = -r10
            r3 = r28
            r0.swe_cotrans(r3, r3, r1)
            r0 = r3[r49]
            double r0 = r0 - r26
            r3[r49] = r0
            swisseph.SwissLib r0 = r9.sl
            r1 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r1 - r14
            double r1 = -r7
            r0.swe_cotrans(r3, r3, r1)
            r0 = r3[r49]
            r4 = r3[r49]
            r31 = r3[r49]
            double r4 = r4 - r31
            r3[r49] = r4
            swisseph.SwissLib r2 = r9.sl
            r5 = -4587338432941916160(0xc056800000000000, double:-90.0)
            r2.swe_cotrans(r3, r3, r5)
            r2 = 0
        L_0x037f:
            r4 = 6
            if (r2 >= r4) goto L_0x041e
            double r5 = (double) r2
            r31 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r5 = r5 * r31
            r3[r49] = r5
            r3[r35] = r24
            swisseph.SwissLib r4 = r9.sl
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            r4.swe_cotrans(r3, r3, r5)
            r4 = r3[r49]
            double r4 = r4 + r0
            r3[r49] = r4
            swisseph.SwissLib r4 = r9.sl
            r4.swe_cotrans(r3, r3, r7)
            swisseph.SwissLib r4 = r9.sl
            r5 = r3[r49]
            double r5 = r5 + r26
            double r4 = r4.swe_degnorm(r5)
            r3[r49] = r4
            double[] r4 = r13.cusp
            int r5 = r2 + 1
            r12 = r3[r49]
            double r12 = r9.tand(r12)
            double r31 = r9.cosd(r10)
            double r12 = r12 / r31
            double r12 = r9.atand(r12)
            r4[r5] = r12
            r12 = r3[r49]
            r20 = 4636033603912859648(0x4056800000000000, double:90.0)
            int r4 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x03ec
            r12 = r3[r49]
            r31 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r4 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r4 > 0) goto L_0x03ec
            r13 = r62
            double[] r4 = r13.cusp
            swisseph.SwissLib r6 = r9.sl
            double[] r12 = r13.cusp
            r31 = r12[r5]
            r37 = r0
            double r0 = r31 + r29
            double r0 = r6.swe_degnorm(r0)
            r4[r5] = r0
            goto L_0x03f0
        L_0x03ec:
            r13 = r62
            r37 = r0
        L_0x03f0:
            double[] r0 = r13.cusp
            swisseph.SwissLib r1 = r9.sl
            double[] r4 = r13.cusp
            r28 = r3
            r3 = r4[r5]
            double r3 = r1.swe_degnorm(r3)
            r0[r5] = r3
            double[] r0 = r13.cusp
            int r2 = r2 + 7
            swisseph.SwissLib r1 = r9.sl
            double[] r3 = r13.cusp
            r31 = r3[r5]
            double r3 = r31 + r29
            double r3 = r1.swe_degnorm(r3)
            r0[r2] = r3
            r2 = r5
            r3 = r28
            r0 = r37
            r5 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x037f
        L_0x041e:
            r20 = 4636033603912859648(0x4056800000000000, double:90.0)
            r11 = r60
            r10 = 12
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            goto L_0x0e8e
        L_0x042e:
            r60 = r8
            r20 = 4636033603912859648(0x4056800000000000, double:90.0)
            r7 = r31
            double r3 = r7 / r46
            double r26 = r9.atand(r3)
            double r3 = r7 * r43
            double r3 = r3 / r46
            double r31 = r9.atand(r3)
            double[] r12 = r13.cusp
            r0 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r1 = r54 + r0
            r0 = r53
            r3 = r26
            r7 = r20
            r50 = -4587338432941916160(0xc056800000000000, double:-90.0)
            r5 = r18
            r52 = r60
            r9 = 12
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r12[r45] = r0
            double[] r12 = r13.cusp
            double r1 = r54 + r41
            r0 = r53
            r3 = r31
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r12[r9] = r0
            double[] r12 = r13.cusp
            double r1 = r54 + r39
            r0 = r53
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r12[r48] = r0
            double[] r12 = r13.cusp
            double r1 = r54 + r37
            r0 = r53
            r3 = r26
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r12[r2] = r0
            double r0 = swisseph.SMath.abs((double) r14)
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r5 - r10
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x04e8
            r12 = 12
            r9 = r53
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x04e2
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            r0 = 1
        L_0x04c7:
            if (r0 > r12) goto L_0x04dc
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r7 = r3[r0]
            double r7 = r7 + r29
            double r2 = r2.swe_degnorm(r7)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x04c7
        L_0x04dc:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x04e2:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x04e8:
            r12 = 12
            r9 = r53
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x04f2:
            r50 = r6
            r52 = r8
            r7 = r31
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            r12 = 12
            r0 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r3 = r7 * r0
            double r20 = r9.atand(r3)
            r0 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r2 = r9.cosd(r0)
            double r3 = r7 * r2
            double r26 = r9.atand(r3)
            double[] r7 = r13.cusp
            double r1 = r54 + r0
            r0 = r53
            r3 = r20
            r5 = r18
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r45] = r0
            double[] r7 = r13.cusp
            double r1 = r54 + r41
            r0 = r53
            r3 = r26
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r12] = r0
            double[] r7 = r13.cusp
            double r1 = r54 + r39
            r0 = r53
            r26 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r26[r48] = r0
            double[] r7 = r13.cusp
            double r1 = r54 + r37
            r0 = r53
            r3 = r20
            r20 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r20[r2] = r0
            double r0 = swisseph.SMath.abs((double) r14)
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r2 = r7 - r10
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x05b3
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x05ad
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            r0 = 1
        L_0x0592:
            if (r0 > r12) goto L_0x05a7
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r0]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0592
        L_0x05a7:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x05ad:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x05b3:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x05b9:
            r50 = r6
            r52 = r8
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            r12 = 12
            r9.makePorphyry(r13)
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x05cd:
            r50 = r6
            r52 = r8
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            r12 = 12
            r0 = 3
            double[] r5 = new double[r0]
            r0 = r54
            r6 = 1
        L_0x05de:
            if (r6 > r12) goto L_0x0612
            int r2 = r6 + 10
            if (r2 <= r12) goto L_0x05e6
            int r2 = r2 + -12
        L_0x05e6:
            r20 = r2
            swisseph.SwissLib r2 = r9.sl
            r26 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r0 = r0 + r26
            double r31 = r2.swe_degnorm(r0)
            r5[r49] = r31
            r5[r35] = r24
            swisseph.SwissLib r0 = r9.sl
            r2 = 0
            r4 = 0
            r1 = r5
            r3 = r5
            r21 = r5
            r28 = r6
            r5 = r58
            r0.swe_cotrans(r1, r2, r3, r4, r5)
            double[] r0 = r13.cusp
            r1 = r21[r49]
            r0[r20] = r1
            int r6 = r28 + 1
            r5 = r21
            r0 = r31
            goto L_0x05de
        L_0x0612:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0632
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x0632:
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x0638:
            r26 = r4
            r50 = r6
            r52 = r8
            r7 = r31
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            r12 = 12
            double r2 = swisseph.SMath.abs((double) r14)
            double r20 = r5 - r10
            int r4 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r4 < 0) goto L_0x0660
            r49 = -1
            r9.makePorphyry(r13)
            r20 = r14
            r11 = r52
            r10 = 12
            r14 = r54
            goto L_0x0e92
        L_0x0660:
            double r2 = r13.mc
            double r2 = r9.sind(r2)
            double r2 = r2 * r18
            double r20 = r9.cosd(r14)
            double r2 = r2 / r20
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0673
            r2 = r0
        L_0x0673:
            r20 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r4 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r4 >= 0) goto L_0x067b
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x067b:
            double r20 = r2 * r2
            double r0 = r0 - r20
            double r0 = swisseph.SMath.sqrt(r0)
            double r0 = r7 / r0
            double r0 = r9.atand(r0)
            double r0 = r9.sind(r0)
            double r0 = r0 * r2
            double r0 = r9.asind(r0)
            double r20 = r0 / r46
            double[] r7 = r13.cusp
            double r0 = r54 + r26
            double r43 = r43 * r20
            double r1 = r0 - r43
            r0 = r53
            r3 = r14
            r5 = r18
            r26 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r26[r45] = r0
            double[] r7 = r13.cusp
            double r0 = r54 + r41
            double r1 = r0 - r20
            r0 = r53
            r26 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r26[r12] = r0
            double[] r7 = r13.cusp
            double r0 = r54 + r39
            double r1 = r0 + r20
            r0 = r53
            r20 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r20[r48] = r0
            double[] r7 = r13.cusp
            double r0 = r54 + r37
            double r1 = r0 + r43
            r0 = r53
            r20 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r20[r2] = r0
            r11 = r52
            r10 = 12
            goto L_0x0e8e
        L_0x06e9:
            r50 = r6
            r52 = r8
            r7 = r31
            r5 = 12
            r0 = 1
        L_0x06f2:
            r1 = 36
            if (r0 > r1) goto L_0x06fd
            double[] r1 = r13.cusp
            r1[r0] = r24
            int r0 = r0 + 1
            goto L_0x06f2
        L_0x06fd:
            double r0 = swisseph.SMath.abs((double) r14)
            r3 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r26 = r3 - r10
            int r2 = (r0 > r26 ? 1 : (r0 == r26 ? 0 : -1))
            if (r2 < 0) goto L_0x0711
            r49 = -1
            r9.makePorphyry(r13)
        L_0x0711:
            double r0 = r9.tand(r14)
            double r0 = r0 * r20
            double r26 = r9.asind(r0)
            r6 = 2
        L_0x071c:
            r0 = 9
            r31 = 4621256167635550208(0x4022000000000000, double:9.0)
            if (r6 > r0) goto L_0x0801
            int r0 = 10 - r6
            double r1 = (double) r0
            double r33 = r26 * r1
            double r3 = r33 / r31
            double r3 = r9.sind(r3)
            double r3 = r3 / r20
            double r3 = r9.atand(r3)
            swisseph.SwissLib r5 = r9.sl
            int r0 = r0 * 10
            r33 = r1
            double r0 = (double) r0
            double r0 = r0 + r54
            double r37 = r5.swe_degnorm(r0)
            r0 = r53
            r1 = r37
            r10 = 4636033603912859648(0x4056800000000000, double:90.0)
            r28 = r6
            r5 = r18
            r10 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0770
            double[] r0 = r13.cusp
            r0[r28] = r37
            goto L_0x07e1
        L_0x0770:
            double r3 = r10 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 * r33
            double r2 = r2 / r31
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r37
            r5 = r18
            r39 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r39[r28] = r0
            r7 = 1
        L_0x0796:
            if (r7 > r12) goto L_0x07e1
            double[] r0 = r13.cusp
            r1 = r0[r28]
            double r0 = r9.sind(r1)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x07b7
            double[] r0 = r13.cusp
            r0[r28] = r37
            goto L_0x07e1
        L_0x07b7:
            double r3 = r10 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 * r33
            double r2 = r2 / r31
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r37
            r5 = r18
            r39 = r7
            r40 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r40[r28] = r0
            int r7 = r39 + 1
            goto L_0x0796
        L_0x07e1:
            double[] r0 = r13.cusp
            int r6 = r28 + 18
            swisseph.SwissLib r1 = r9.sl
            double[] r2 = r13.cusp
            r3 = r2[r28]
            double r3 = r3 + r29
            double r1 = r1.swe_degnorm(r3)
            r0[r6] = r1
            int r6 = r28 + 1
            r7 = r10
            r3 = 4636033603912859648(0x4056800000000000, double:90.0)
            r5 = 12
            r10 = r58
            goto L_0x071c
        L_0x0801:
            r10 = r7
            r0 = 29
            r7 = 29
        L_0x0806:
            r0 = 36
            if (r7 > r0) goto L_0x08dd
            int r0 = r7 + -28
            double r5 = (double) r0
            double r1 = r26 * r5
            double r1 = r1 / r31
            double r1 = r9.sind(r1)
            double r1 = r1 / r20
            double r3 = r9.atand(r1)
            swisseph.SwissLib r1 = r9.sl
            int r0 = r0 * 90
            int r0 = r0 / 9
            int r0 = 180 - r0
            r33 = r5
            double r5 = (double) r0
            double r5 = r5 + r54
            double r37 = r1.swe_degnorm(r5)
            r0 = r53
            r1 = r37
            r5 = r18
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0856
            double[] r0 = r13.cusp
            r0[r28] = r37
            goto L_0x08c7
        L_0x0856:
            double r3 = r10 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 * r33
            double r2 = r2 / r31
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r37
            r5 = r18
            r39 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r39[r28] = r0
            r7 = 1
        L_0x087c:
            if (r7 > r12) goto L_0x08c7
            double[] r0 = r13.cusp
            r1 = r0[r28]
            double r0 = r9.sind(r1)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x089d
            double[] r0 = r13.cusp
            r0[r28] = r37
            goto L_0x08c7
        L_0x089d:
            double r3 = r10 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 * r33
            double r2 = r2 / r31
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r37
            r5 = r18
            r39 = r7
            r40 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r40[r28] = r0
            int r7 = r39 + 1
            goto L_0x087c
        L_0x08c7:
            double[] r0 = r13.cusp
            int r7 = r28 + -18
            swisseph.SwissLib r1 = r9.sl
            double[] r2 = r13.cusp
            r3 = r2[r28]
            double r3 = r3 + r29
            double r1 = r1.swe_degnorm(r3)
            r0[r7] = r1
            int r7 = r28 + 1
            goto L_0x0806
        L_0x08dd:
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r0[r35] = r1
            double[] r0 = r13.cusp
            double r1 = r13.mc
            r0[r36] = r1
            double[] r0 = r13.cusp
            r1 = 19
            swisseph.SwissLib r2 = r9.sl
            double r3 = r13.ac
            double r3 = r3 + r29
            double r2 = r2.swe_degnorm(r3)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 28
            swisseph.SwissLib r2 = r9.sl
            double r3 = r13.mc
            double r3 = r3 + r29
            double r2 = r2.swe_degnorm(r3)
            r0[r1] = r2
            r20 = r14
            r11 = r52
            r10 = 12
            r14 = r54
            goto L_0x0e92
        L_0x0913:
            r50 = r6
            r52 = r8
            r2 = 72
            r12 = r52
            if (r12 != r2) goto L_0x095b
            int r2 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x0929
            r2 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r2 - r14
            goto L_0x0930
        L_0x0929:
            r2 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r50 - r14
        L_0x0930:
            double r4 = swisseph.SMath.abs((double) r7)
            double r4 = r4 - r2
            double r2 = swisseph.SMath.abs((double) r4)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x094f
            int r2 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0948
            r2 = -4587338432941923197(0xc0567fffffffe483, double:-89.9999999999)
            r5 = r2
            goto L_0x0950
        L_0x0948:
            r2 = 4636033603912852611(0x40567fffffffe483, double:89.9999999999)
            r5 = r2
            goto L_0x0950
        L_0x094f:
            r5 = r7
        L_0x0950:
            swisseph.SwissLib r2 = r9.sl
            double r3 = r54 + r29
            double r2 = r2.swe_degnorm(r3)
            r10 = r2
            r14 = r5
            goto L_0x095d
        L_0x095b:
            r10 = r54
        L_0x095d:
            double r2 = r9.sind(r14)
            double r2 = r2 / r43
            double r20 = r9.asind(r2)
            double r2 = swisseph.SMath.sqrt(r46)
            double r2 = r2 / r43
            double r4 = r9.sind(r14)
            double r2 = r2 * r4
            double r26 = r9.asind(r2)
            double r2 = r9.cosd(r14)
            double r4 = swisseph.SMath.abs((double) r2)
            int r6 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r6 != 0) goto L_0x099d
            int r0 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r0 <= 0) goto L_0x0992
            r31 = 4636033603912859648(0x4056800000000000, double:90.0)
            r33 = 4636033603912859648(0x4056800000000000, double:90.0)
            goto L_0x09b4
        L_0x0992:
            r31 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r33 = 4643457506423603200(0x4070e00000000000, double:270.0)
            goto L_0x09b4
        L_0x099d:
            double r4 = swisseph.SMath.sqrt(r46)
            double r4 = r4 / r2
            double r7 = r9.atand(r4)
            double r4 = swisseph.SMath.sqrt(r46)
            double r0 = r0 / r4
            double r0 = r0 / r2
            double r0 = r9.atand(r0)
            r33 = r0
            r31 = r7
        L_0x09b4:
            double[] r7 = r13.cusp
            r37 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r39 = r10 + r37
            double r1 = r39 - r31
            r0 = r53
            r3 = r20
            r5 = r18
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r45] = r0
            double[] r7 = r13.cusp
            double r1 = r39 - r33
            r0 = r53
            r3 = r26
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r7 = 12
            r28[r7] = r0
            r0 = 72
            if (r12 != r0) goto L_0x09ff
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r39
            r3 = r14
            r5 = r18
            r28 = r8
            r54 = r10
            r10 = 12
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r35] = r0
            goto L_0x0a03
        L_0x09ff:
            r54 = r10
            r10 = 12
        L_0x0a03:
            double[] r11 = r13.cusp
            double r1 = r39 + r33
            r0 = r53
            r3 = r26
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r11[r48] = r0
            double[] r11 = r13.cusp
            double r1 = r39 + r31
            r0 = r53
            r3 = r20
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r11[r2] = r0
            double r0 = swisseph.SMath.abs((double) r14)
            r7 = r37
            double r2 = r7 - r58
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0a6c
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0a6c
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.mc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.mc = r0
            r0 = 1
        L_0x0a57:
            if (r0 > r10) goto L_0x0a6c
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r0]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0a57
        L_0x0a6c:
            r0 = 72
            if (r12 != r0) goto L_0x0ad1
            r0 = 1
        L_0x0a71:
            r1 = 3
            if (r0 > r1) goto L_0x0a87
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r0]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0a71
        L_0x0a87:
            r0 = 11
        L_0x0a89:
            if (r0 > r10) goto L_0x0a9e
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r0]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0a89
        L_0x0a9e:
            int r0 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r0 <= 0) goto L_0x0aa5
            double r0 = r7 - r14
            goto L_0x0aa7
        L_0x0aa5:
            double r0 = r50 - r14
        L_0x0aa7:
            swisseph.SwissLib r2 = r9.sl
            r3 = r54
            double r3 = r3 + r29
            double r2 = r2.swe_degnorm(r3)
            swisseph.SwissLib r4 = r9.sl
            double r5 = r13.ac
            double r14 = r13.mc
            double r4 = r4.swe_difdeg2n(r5, r14)
            int r6 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r6 >= 0) goto L_0x0acb
            swisseph.SwissLib r4 = r9.sl
            double r5 = r13.ac
            double r5 = r5 + r29
            double r4 = r4.swe_degnorm(r5)
            r13.ac = r4
        L_0x0acb:
            r20 = r0
            r14 = r2
            r11 = r12
            goto L_0x0e92
        L_0x0ad1:
            r3 = r54
            r11 = r12
            r20 = r14
            r14 = r3
            goto L_0x0e92
        L_0x0ad9:
            r50 = r6
            r12 = r8
            r5 = r31
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            r10 = 12
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0b0e
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r0[r35] = r1
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            r0.swe_difdeg2n(r1, r3)
        L_0x0b0e:
            double r0 = r13.ac
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r2 = -r5
            double r0 = r9.tand(r0)
            double r2 = r2 * r0
            double r0 = swisseph.SMath.acos(r2)
            r2 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r0 = r0 * r2
            double r2 = r29 - r0
            double r20 = r0 / r46
            double r26 = r2 / r46
            swisseph.SwissLib r0 = r9.sl
            double r1 = r54 + r20
            double r1 = r0.swe_degnorm(r1)
            double[] r11 = r13.cusp
            r3 = 0
            r0 = r53
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r11[r45] = r0
            swisseph.SwissLib r0 = r9.sl
            double r20 = r20 * r43
            double r1 = r54 + r20
            double r1 = r0.swe_degnorm(r1)
            double[] r11 = r13.cusp
            r0 = r53
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r11[r10] = r0
            swisseph.SwissLib r0 = r9.sl
            double r20 = r54 + r29
            double r43 = r43 * r26
            double r1 = r20 - r43
            double r1 = r0.swe_degnorm(r1)
            double[] r11 = r13.cusp
            r0 = r53
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r11[r48] = r0
            swisseph.SwissLib r0 = r9.sl
            double r1 = r20 - r26
            double r1 = r0.swe_degnorm(r1)
            double[] r11 = r13.cusp
            r0 = r53
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r11[r2] = r0
            r11 = r12
            goto L_0x0e8e
        L_0x0b8a:
            r50 = r6
            r12 = r8
            r10 = 12
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x0baf
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.ac
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.ac = r0
            double[] r0 = r13.cusp
            double r1 = r13.ac
            r0[r35] = r1
        L_0x0baf:
            r0 = 2
        L_0x0bb0:
            if (r0 > r10) goto L_0x0bc9
            double[] r1 = r13.cusp
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r35]
            int r3 = r0 + -1
            int r3 = r3 * 30
            double r6 = (double) r3
            double r4 = r4 + r6
            double r2 = r2.swe_degnorm(r4)
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0bb0
        L_0x0bc9:
            r11 = r12
            goto L_0x0e8e
        L_0x0bcc:
            double r0 = swisseph.SMath.abs((double) r14)
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r2 = r7 - r58
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0be6
            r49 = -1
            r9.makePorphyry(r13)
            r20 = r14
            r14 = r54
            goto L_0x0e92
        L_0x0be6:
            double r0 = r9.tand(r14)
            double r0 = r0 * r20
            double r0 = r9.asind(r0)
            double r2 = r0 / r46
            double r2 = r9.sind(r2)
            double r2 = r2 / r20
            double r31 = r9.atand(r2)
            double r0 = r0 * r43
            double r0 = r0 / r46
            double r0 = r9.sind(r0)
            double r0 = r0 / r20
            double r20 = r9.atand(r0)
            swisseph.SwissLib r0 = r9.sl
            double r1 = r54 + r26
            double r26 = r0.swe_degnorm(r1)
            r0 = r53
            r1 = r26
            r3 = r31
            r33 = r5
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0c3e
            double[] r0 = r13.cusp
            r0[r45] = r26
            goto L_0x0cab
        L_0x0c3e:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r46
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r45] = r0
            r7 = 1
        L_0x0c62:
            if (r7 > r12) goto L_0x0cab
            double[] r0 = r13.cusp
            r1 = r0[r45]
            double r0 = r9.sind(r1)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0c83
            double[] r0 = r13.cusp
            r0[r45] = r26
            goto L_0x0cab
        L_0x0c83:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r46
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r28 = r7
            r43 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r43[r45] = r0
            int r7 = r28 + 1
            goto L_0x0c62
        L_0x0cab:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r54 + r41
            double r26 = r0.swe_degnorm(r1)
            r0 = r53
            r1 = r26
            r3 = r20
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            r41 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0cdf
            double[] r0 = r13.cusp
            r0[r10] = r26
            goto L_0x0d4c
        L_0x0cdf:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r41
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r28 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r28[r10] = r0
            r7 = 1
        L_0x0d03:
            if (r7 > r12) goto L_0x0d4c
            double[] r0 = r13.cusp
            r1 = r0[r10]
            double r0 = r9.sind(r1)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0d24
            double[] r0 = r13.cusp
            r0[r10] = r26
            goto L_0x0d4c
        L_0x0d24:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r41
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r28 = r7
            r43 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r43[r10] = r0
            int r7 = r28 + 1
            goto L_0x0d03
        L_0x0d4c:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r54 + r39
            double r26 = r0.swe_degnorm(r1)
            r0 = r53
            r1 = r26
            r3 = r20
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0d7e
            double[] r0 = r13.cusp
            r0[r48] = r26
            goto L_0x0deb
        L_0x0d7e:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r41
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r20 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r20[r48] = r0
            r7 = 1
        L_0x0da2:
            if (r7 > r12) goto L_0x0deb
            double[] r0 = r13.cusp
            r1 = r0[r48]
            double r0 = r9.sind(r1)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0dc3
            double[] r0 = r13.cusp
            r0[r48] = r26
            goto L_0x0deb
        L_0x0dc3:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r41
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r26
            r5 = r18
            r20 = r7
            r21 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r21[r48] = r0
            int r7 = r20 + 1
            goto L_0x0da2
        L_0x0deb:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r54 + r37
            double r20 = r0.swe_degnorm(r1)
            r0 = r53
            r1 = r20
            r3 = r31
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r9.sind(r0)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r2 = swisseph.SMath.abs((double) r0)
            int r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0e1e
            double[] r0 = r13.cusp
            r1 = 3
            r0[r1] = r20
            goto L_0x0e8e
        L_0x0e1e:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r46
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r7 = r13.cusp
            r0 = r53
            r1 = r20
            r5 = r18
            r26 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r26[r2] = r0
            r7 = 1
        L_0x0e43:
            if (r7 > r12) goto L_0x0e8e
            double[] r0 = r13.cusp
            r3 = r0[r2]
            double r0 = r9.sind(r3)
            double r0 = r0 * r18
            double r0 = r9.asind(r0)
            double r0 = r9.tand(r0)
            double r3 = swisseph.SMath.abs((double) r0)
            int r5 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r5 >= 0) goto L_0x0e64
            double[] r0 = r13.cusp
            r0[r2] = r20
            goto L_0x0e8e
        L_0x0e64:
            double r3 = r33 * r0
            double r2 = r9.asind(r3)
            double r2 = r2 / r46
            double r2 = r9.sind(r2)
            double r2 = r2 / r0
            double r3 = r9.atand(r2)
            double[] r8 = r13.cusp
            r0 = r53
            r1 = r20
            r5 = r18
            r26 = r7
            r27 = r8
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r2 = 3
            r27[r2] = r0
            int r7 = r26 + 1
            r2 = 3
            goto L_0x0e43
        L_0x0e8e:
            r20 = r14
            r14 = r54
        L_0x0e92:
            r0 = 71
            if (r11 == r0) goto L_0x0f03
            r0 = 89
            if (r11 == r0) goto L_0x0f03
            double[] r0 = r13.cusp
            r1 = 4
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r36]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 5
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r45]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 6
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r10]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 7
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r35]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 8
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = r3[r48]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
            double[] r0 = r13.cusp
            r1 = 9
            swisseph.SwissLib r2 = r9.sl
            double[] r3 = r13.cusp
            r4 = 3
            r4 = r3[r4]
            double r4 = r4 + r29
            double r2 = r2.swe_degnorm(r4)
            r0[r1] = r2
        L_0x0f03:
            int r10 = (r20 > r24 ? 1 : (r20 == r24 ? 0 : -1))
            if (r10 < 0) goto L_0x0f10
            r11 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r11 - r20
            r3 = r7
            goto L_0x0f18
        L_0x0f10:
            r11 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r6 = r50 - r20
            r3 = r6
        L_0x0f18:
            double r26 = r14 - r11
            r0 = r53
            r1 = r26
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r13.vertex = r0
            double r0 = swisseph.SMath.abs((double) r20)
            int r2 = (r0 > r58 ? 1 : (r0 == r58 ? 0 : -1))
            if (r2 > 0) goto L_0x0f4a
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.vertex
            double r3 = r13.mc
            double r0 = r0.swe_difdeg2n(r1, r3)
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x0f4a
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.vertex
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.vertex = r0
        L_0x0f4a:
            swisseph.SwissLib r0 = r9.sl
            double r14 = r14 + r11
            double r0 = r0.swe_degnorm(r14)
            double r2 = r0 - r11
            double r4 = swisseph.SMath.abs((double) r2)
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x0f90
            r4 = 4643457506423603200(0x4070e00000000000, double:270.0)
            double r6 = r0 - r4
            double r4 = swisseph.SMath.abs((double) r6)
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x0f90
            double r2 = r9.tand(r0)
            double r2 = r2 / r16
            double r2 = r9.atand(r2)
            r13.equasc = r2
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0fa2
            r2 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0fa2
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.equasc
            double r1 = r1 + r29
            double r0 = r0.swe_degnorm(r1)
            r13.equasc = r0
            goto L_0x0fa2
        L_0x0f90:
            double r0 = swisseph.SMath.abs((double) r2)
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 > 0) goto L_0x0f9b
            r13.equasc = r11
            goto L_0x0fa2
        L_0x0f9b:
            r0 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r13.equasc = r0
        L_0x0fa2:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r13.equasc
            double r0 = r0.swe_degnorm(r1)
            r13.equasc = r0
            swisseph.SwissLib r7 = r9.sl
            r0 = r53
            r1 = r26
            r3 = r20
            r5 = r18
            r11 = r7
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r0 = r0 + r29
            double r0 = r11.swe_degnorm(r0)
            r13.coasc1 = r0
            if (r10 < 0) goto L_0x0fdc
            r0 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r3 = r0 - r20
            r0 = r53
            r1 = r14
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r13.coasc2 = r0
            goto L_0x0feb
        L_0x0fdc:
            double r3 = r50 - r20
            r0 = r53
            r1 = r14
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r13.coasc2 = r0
        L_0x0feb:
            r0 = r53
            r1 = r26
            r3 = r20
            r5 = r18
            r7 = r16
            double r0 = r0.Asc1(r1, r3, r5, r7)
            r13.polasc = r0
            return r49
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHouse.CalcH(double, double, double, char, int, swisseph.Houses):int");
    }

    private void makePorphyry(Houses houses) {
        double swe_difdeg2n = this.sl.swe_difdeg2n(houses.ac, houses.mc);
        if (swe_difdeg2n < 0.0d) {
            houses.ac = this.sl.swe_degnorm(houses.ac + 180.0d);
            houses.cusp[1] = houses.ac;
            swe_difdeg2n = this.sl.swe_difdeg2n(houses.ac, houses.mc);
        }
        double d = (180.0d - swe_difdeg2n) / 3.0d;
        houses.cusp[2] = this.sl.swe_degnorm(houses.ac + d);
        houses.cusp[3] = this.sl.swe_degnorm(houses.ac + (d * 2.0d));
        double d2 = swe_difdeg2n / 3.0d;
        houses.cusp[11] = this.sl.swe_degnorm(houses.mc + d2);
        houses.cusp[12] = this.sl.swe_degnorm(houses.mc + (d2 * 2.0d));
    }

    private double Asc1(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d2;
        double swe_degnorm = this.sl.swe_degnorm(d);
        double d7 = 90.0d;
        int i = (int) ((swe_degnorm / 90.0d) + 1.0d);
        double d8 = 180.0d;
        if (i == 1) {
            d5 = Asc2(swe_degnorm, d2, d3, d4);
        } else if (i == 2) {
            d5 = 180.0d - Asc2(180.0d - swe_degnorm, -d6, d3, d4);
        } else if (i == 3) {
            d5 = Asc2(swe_degnorm - 180.0d, -d6, d3, d4) + 180.0d;
        } else {
            d5 = 360.0d - Asc2(360.0d - swe_degnorm, d2, d3, d4);
        }
        double swe_degnorm2 = this.sl.swe_degnorm(d5);
        if (SMath.abs(swe_degnorm2 - 90.0d) >= VERY_SMALL) {
            d7 = swe_degnorm2;
        }
        if (SMath.abs(d7 - 180.0d) >= VERY_SMALL) {
            d8 = d7;
        }
        if (SMath.abs(d8 - 270.0d) < VERY_SMALL) {
            d8 = 270.0d;
        }
        if (SMath.abs(d8 - 360.0d) < VERY_SMALL) {
            return 0.0d;
        }
        return d8;
    }

    private double Asc2(double d, double d2, double d3, double d4) {
        double cosd = ((-tand(d2)) * d3) + (d4 * cosd(d));
        double abs = SMath.abs(cosd);
        double d5 = VERY_SMALL;
        if (abs < VERY_SMALL) {
            cosd = 0.0d;
        }
        double sind = sind(d);
        if (SMath.abs(sind) < VERY_SMALL) {
            sind = 0.0d;
        }
        if (sind == 0.0d) {
            if (cosd < 0.0d) {
                d5 = -1.0E-10d;
            }
        } else if (cosd != 0.0d) {
            d5 = atand(sind / cosd);
        } else if (sind < 0.0d) {
            d5 = -90.0d;
        } else {
            d5 = 90.0d;
        }
        if (d5 < 0.0d) {
            return d5 + 180.0d;
        }
        return d5;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04c5, code lost:
        if (r5 >= 0.0d) goto L_0x04f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x04ed, code lost:
        if (r5 >= 0.0d) goto L_0x04f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0504  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double swe_house_pos(double r59, double r61, double r63, int r65, double[] r66, java.lang.StringBuffer r67) {
        /*
            r58 = this;
            r9 = r58
            r10 = r61
            r12 = r63
            r7 = r67
            r0 = 6
            double[] r14 = new double[r0]
            double[] r15 = new double[r0]
            r0 = 3
            double[] r8 = new double[r0]
            double[] r5 = new double[r0]
            double r16 = r9.sind(r12)
            double r18 = r9.cosd(r12)
            r6 = 0
            if (r7 == 0) goto L_0x0023
            r7.setLength(r6)
        L_0x0023:
            r0 = r65
            char r0 = (char) r0
            char r4 = java.lang.Character.toUpperCase(r0)
            r0 = r66[r6]
            r15[r6] = r0
            r20 = 1
            r0 = r66[r20]
            r15[r20] = r0
            r21 = 2
            r22 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r15[r21] = r22
            swisseph.SwissLib r0 = r9.sl
            r2 = 0
            r24 = 0
            r65 = r4
            r25 = r5
            double r4 = -r12
            r1 = r66
            r3 = r15
            r26 = r4
            r5 = r65
            r4 = r24
            r29 = r5
            r24 = r14
            r28 = r25
            r14 = 0
            r5 = r26
            r0.swe_cotrans(r1, r2, r3, r4, r5)
            r0 = r15[r14]
            r2 = r15[r20]
            swisseph.SwissLib r4 = r9.sl
            double r5 = r0 - r59
            double r4 = r4.swe_degnorm(r5)
            swisseph.SwissLib r6 = r9.sl
            r30 = 4640537203540230144(0x4066800000000000, double:180.0)
            r25 = r15
            double r14 = r4 + r30
            double r14 = r6.swe_degnorm(r14)
            r32 = 4645040803167600640(0x4076800000000000, double:360.0)
            int r6 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r6 < 0) goto L_0x0081
            double r4 = r4 - r32
            r5 = r4
            goto L_0x0082
        L_0x0081:
            r5 = r4
        L_0x0082:
            int r4 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r4 < 0) goto L_0x0088
            double r14 = r14 - r32
        L_0x0088:
            r34 = 4613937818241073152(0x4008000000000000, double:3.0)
            r36 = -4587338432941923197(0xc0567fffffffe483, double:-89.9999999999)
            r38 = 4636033603912852611(0x40567fffffffe483, double:89.9999999999)
            r40 = -4587338432941916160(0xc056800000000000, double:-90.0)
            r42 = 4611686018427387904(0x4000000000000000, double:2.0)
            r44 = 4508846701240351161(0x3e92a42f961f79b9, double:2.7777777777777776E-7)
            r46 = 4457293557087583675(0x3ddb7cdfd9d7bdbb, double:1.0E-10)
            r48 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r50 = 4629137466983448576(0x403e000000000000, double:30.0)
            r52 = 0
            r54 = 4636033603912859648(0x4056800000000000, double:90.0)
            r4 = r29
            switch(r4) {
                case 65: goto L_0x06c8;
                case 66: goto L_0x0586;
                case 67: goto L_0x0552;
                case 68: goto L_0x00b8;
                case 69: goto L_0x06c8;
                case 70: goto L_0x00b8;
                case 71: goto L_0x00b8;
                case 72: goto L_0x051d;
                case 73: goto L_0x00b8;
                case 74: goto L_0x00b8;
                case 75: goto L_0x0426;
                case 76: goto L_0x00b8;
                case 77: goto L_0x03d5;
                case 78: goto L_0x00b8;
                case 79: goto L_0x0586;
                case 80: goto L_0x00b8;
                case 81: goto L_0x00b8;
                case 82: goto L_0x0348;
                case 83: goto L_0x00b8;
                case 84: goto L_0x026d;
                case 85: goto L_0x00eb;
                case 86: goto L_0x06c8;
                case 87: goto L_0x06c8;
                case 88: goto L_0x00dd;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            r0 = r4
            r4 = r5
            double r12 = swisseph.SMath.abs((double) r2)
            double r12 = r54 - r12
            double r16 = swisseph.SMath.abs((double) r61)
            int r1 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x076d
            double r2 = r2 * r10
            int r1 = (r2 > r52 ? 1 : (r2 == r52 ? 0 : -1))
            if (r1 >= 0) goto L_0x0755
            swisseph.SwissLib r1 = r9.sl
            double r14 = r14 / r42
            double r14 = r14 + r54
            double r1 = r1.swe_degnorm(r14)
            r3 = 0
            r24[r3] = r1
            goto L_0x0762
        L_0x00dd:
            swisseph.SwissLib r0 = r9.sl
            double r5 = r5 - r54
            double r0 = r0.swe_degnorm(r5)
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x00eb:
            swisseph.SwissLib r0 = r9.sl
            double r14 = r59 + r54
            double r1 = r0.swe_degnorm(r14)
            r0 = r58
            r3 = r61
            r5 = r16
            r65 = r14
            r14 = r8
            r7 = r18
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r2 = r58.sind(r59)
            double r4 = r9.tand(r12)
            double r2 = r2 * r4
            double r2 = r9.atand(r2)
            int r4 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r4 < 0) goto L_0x0123
            double r4 = r54 - r10
            double r4 = r4 + r2
            int r6 = (r4 > r52 ? 1 : (r4 == r52 ? 0 : -1))
            if (r6 >= 0) goto L_0x0123
            swisseph.SwissLib r4 = r9.sl
            double r0 = r0 + r30
            double r0 = r4.swe_degnorm(r0)
        L_0x0123:
            int r4 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r4 >= 0) goto L_0x0137
            double r40 = r40 - r10
            double r40 = r40 + r2
            int r2 = (r40 > r52 ? 1 : (r40 == r52 ? 0 : -1))
            if (r2 <= 0) goto L_0x0137
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 + r30
            double r0 = r2.swe_degnorm(r0)
        L_0x0137:
            r2 = 0
            r14[r2] = r0
            r14[r20] = r52
            r14[r21] = r22
            swisseph.SwissLib r3 = r9.sl
            r4 = r26
            r3.swe_cotrans(r14, r14, r4)
            swisseph.SwissLib r3 = r9.sl
            r6 = r65
            double r6 = r3.swe_degnorm(r6)
            swisseph.SwissLib r3 = r9.sl
            r12 = r14[r2]
            double r12 = r6 - r12
            double r12 = r3.swe_degnorm(r12)
            r14[r2] = r12
            swisseph.SwissLib r3 = r9.sl
            double r10 = r54 - r10
            double r12 = -r10
            r3.swe_cotrans(r14, r14, r12)
            r3 = r14[r2]
            double r3 = r9.tand(r3)
            double r15 = r9.cosd(r10)
            double r3 = r3 / r15
            double r3 = r9.atand(r3)
            r15 = r14[r2]
            int r5 = (r15 > r54 ? 1 : (r15 == r54 ? 0 : -1))
            if (r5 <= 0) goto L_0x0184
            r15 = r14[r2]
            int r2 = (r15 > r48 ? 1 : (r15 == r48 ? 0 : -1))
            if (r2 > 0) goto L_0x0184
            swisseph.SwissLib r2 = r9.sl
            double r3 = r3 + r30
            double r3 = r2.swe_degnorm(r3)
        L_0x0184:
            swisseph.SwissLib r2 = r9.sl
            double r2 = r2.swe_degnorm(r3)
            r4 = 0
            r14[r4] = r2
            swisseph.SwissLib r2 = r9.sl
            r15 = r14[r4]
            double r4 = r6 - r15
            double r2 = r2.swe_degnorm(r4)
            r4 = 0
            r14[r4] = r2
            r14[r20] = r52
            swisseph.SwissLib r5 = r9.sl
            r15 = r14[r4]
            double r6 = r6 - r15
            double r5 = r5.swe_degnorm(r6)
            r14[r4] = r5
            swisseph.SwissLib r4 = r9.sl
            r4.swe_cotrans(r14, r14, r12)
            r4 = r14[r20]
            double r4 = r4 + r54
            r14[r20] = r4
            swisseph.SwissLib r4 = r9.sl
            r4.swe_cotrans(r14, r14, r10)
            r4 = r14[r20]
            r6 = r28
            r7 = 0
            r6[r7] = r0
            r6[r20] = r52
            r6[r21] = r22
            swisseph.SwissLib r0 = r9.sl
            r10 = r26
            r0.swe_cotrans(r6, r6, r10)
            swisseph.SwissLib r0 = r9.sl
            r10 = r6[r7]
            double r10 = r10 - r2
            double r0 = r0.swe_degnorm(r10)
            r6[r7] = r0
            r0 = r6[r7]
            double r0 = r9.tand(r0)
            double r10 = r9.cosd(r4)
            double r0 = r0 / r10
            double r0 = r9.atand(r0)
            r10 = r6[r7]
            int r8 = (r10 > r54 ? 1 : (r10 == r54 ? 0 : -1))
            if (r8 <= 0) goto L_0x01f7
            r10 = r6[r7]
            int r7 = (r10 > r48 ? 1 : (r10 == r48 ? 0 : -1))
            if (r7 > 0) goto L_0x01f7
            swisseph.SwissLib r7 = r9.sl
            double r0 = r0 + r30
            double r0 = r7.swe_degnorm(r0)
        L_0x01f7:
            swisseph.SwissLib r7 = r9.sl
            double r0 = r7.swe_degnorm(r0)
            r7 = 0
            r6[r7] = r0
            swisseph.SwissLib r0 = r9.sl
            r10 = r25[r7]
            double r10 = r10 - r2
            double r0 = r0.swe_degnorm(r10)
            r24[r7] = r0
            r0 = r24[r7]
            double r0 = r9.tand(r0)
            double r2 = r9.cosd(r4)
            double r0 = r0 / r2
            double r0 = r9.atand(r0)
            r2 = r24[r7]
            int r8 = (r2 > r54 ? 1 : (r2 == r54 ? 0 : -1))
            if (r8 <= 0) goto L_0x022e
            r2 = r24[r7]
            int r7 = (r2 > r48 ? 1 : (r2 == r48 ? 0 : -1))
            if (r7 > 0) goto L_0x022e
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 + r30
            double r0 = r2.swe_degnorm(r0)
        L_0x022e:
            swisseph.SwissLib r2 = r9.sl
            double r0 = r2.swe_degnorm(r0)
            r2 = 0
            r24[r2] = r0
            swisseph.SwissLib r0 = r9.sl
            r7 = r24[r2]
            r10 = r6[r2]
            double r7 = r7 - r10
            double r0 = r0.swe_degnorm(r7)
            r24[r2] = r0
            r0 = r25[r2]
            r14[r2] = r0
            r0 = r25[r20]
            r14[r20] = r0
            swisseph.SwissLib r0 = r9.sl
            r0.swe_cotrans(r14, r14, r4)
            r0 = r25[r20]
            r2 = r14[r20]
            double r0 = r0 - r2
            r24[r20] = r0
            swisseph.SwissLib r0 = r9.sl
            r1 = 0
            r2 = r24[r1]
            double r2 = r2 + r44
            double r2 = r0.swe_degnorm(r2)
            r24[r1] = r2
            r0 = r24[r1]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x026d:
            swisseph.SwissLib r4 = r9.sl
            double r4 = r4.swe_degnorm(r5)
            int r6 = (r2 > r38 ? 1 : (r2 == r38 ? 0 : -1))
            if (r6 <= 0) goto L_0x0279
            r2 = r38
        L_0x0279:
            int r6 = (r2 > r36 ? 1 : (r2 == r36 ? 0 : -1))
            if (r6 >= 0) goto L_0x027f
            r2 = r36
        L_0x027f:
            double r6 = r9.tand(r2)
            double r12 = r9.tand(r10)
            double r6 = r6 * r12
            r9.asind(r6)
            double r12 = r9.cosd(r4)
            double r6 = r6 + r12
            int r8 = (r6 > r52 ? 1 : (r6 == r52 ? 0 : -1))
            if (r8 < 0) goto L_0x0297
            r6 = 1
            goto L_0x0298
        L_0x0297:
            r6 = 0
        L_0x0298:
            if (r6 != 0) goto L_0x02ab
            swisseph.SwissLib r7 = r9.sl
            double r0 = r0 + r30
            double r0 = r7.swe_degnorm(r0)
            double r2 = -r2
            swisseph.SwissLib r7 = r9.sl
            double r4 = r4 + r30
            double r4 = r7.swe_degnorm(r4)
        L_0x02ab:
            int r7 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r7 <= 0) goto L_0x02b7
            swisseph.SwissLib r0 = r9.sl
            double r4 = r59 - r4
            double r0 = r0.swe_degnorm(r4)
        L_0x02b7:
            double r4 = r9.tand(r10)
            swisseph.SwissLib r8 = r9.sl
            double r12 = r59 + r54
            double r12 = r8.swe_degnorm(r12)
            r24[r20] = r22
            r25[r20] = r2
            r2 = r42
        L_0x02ca:
            r14 = r24[r20]
            double r14 = swisseph.SMath.abs((double) r14)
            r16 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            int r8 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x031f
            r14 = r24[r20]
            int r8 = (r14 > r52 ? 1 : (r14 == r52 ? 0 : -1))
            if (r8 <= 0) goto L_0x02ee
            double r10 = r9.tand(r10)
            double r14 = r4 / r2
            double r10 = r10 - r14
            double r10 = r9.atand(r10)
            double r14 = r54 / r2
            double r12 = r12 - r14
            goto L_0x02fc
        L_0x02ee:
            double r10 = r9.tand(r10)
            double r14 = r4 / r2
            double r10 = r10 + r14
            double r10 = r9.atand(r10)
            double r14 = r54 / r2
            double r12 = r12 + r14
        L_0x02fc:
            swisseph.SwissLib r8 = r9.sl
            double r14 = r0 - r12
            double r14 = r8.swe_degnorm(r14)
            r8 = 0
            r25[r8] = r14
            swisseph.SwissLib r8 = r9.sl
            r14 = 0
            r15 = 0
            double r16 = r54 - r10
            r61 = r8
            r62 = r25
            r63 = r14
            r64 = r24
            r65 = r15
            r66 = r16
            r61.swe_cotrans(r62, r63, r64, r65, r66)
            double r2 = r2 * r42
            goto L_0x02ca
        L_0x031f:
            swisseph.SwissLib r0 = r9.sl
            double r12 = r12 - r59
            double r0 = r0.swe_degnorm(r12)
            if (r7 <= 0) goto L_0x0330
            swisseph.SwissLib r2 = r9.sl
            double r0 = -r0
            double r0 = r2.swe_degnorm(r0)
        L_0x0330:
            if (r6 != 0) goto L_0x033a
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 + r30
            double r0 = r2.swe_degnorm(r0)
        L_0x033a:
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 - r54
            double r0 = r2.swe_degnorm(r0)
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x0348:
            double r0 = swisseph.SMath.abs((double) r5)
            int r4 = (r0 > r46 ? 1 : (r0 == r46 ? 0 : -1))
            if (r4 >= 0) goto L_0x0356
            r0 = 0
            r24[r0] = r48
            r2 = 0
            goto L_0x03cd
        L_0x0356:
            r0 = 0
            double r7 = swisseph.SMath.abs((double) r5)
            double r7 = r30 - r7
            int r1 = (r7 > r46 ? 1 : (r7 == r46 ? 0 : -1))
            if (r1 >= 0) goto L_0x0365
            r24[r0] = r54
            r2 = 0
            goto L_0x03cd
        L_0x0365:
            double r0 = swisseph.SMath.abs((double) r61)
            double r0 = r54 - r0
            int r4 = (r0 > r46 ? 1 : (r0 == r46 ? 0 : -1))
            if (r4 >= 0) goto L_0x0378
            int r0 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r0 <= 0) goto L_0x0376
            r10 = r38
            goto L_0x0378
        L_0x0376:
            r10 = r36
        L_0x0378:
            double r0 = swisseph.SMath.abs((double) r2)
            double r54 = r54 - r0
            int r0 = (r54 > r46 ? 1 : (r54 == r46 ? 0 : -1))
            if (r0 >= 0) goto L_0x038b
            int r0 = (r2 > r52 ? 1 : (r2 == r52 ? 0 : -1))
            if (r0 <= 0) goto L_0x0389
            r2 = r38
            goto L_0x038b
        L_0x0389:
            r2 = r36
        L_0x038b:
            double r0 = r9.tand(r10)
            double r2 = r9.tand(r2)
            double r0 = r0 * r2
            double r2 = r9.cosd(r5)
            double r0 = r0 + r2
            swisseph.SwissLib r2 = r9.sl
            double r0 = -r0
            double r3 = r9.sind(r5)
            double r0 = r0 / r3
            double r0 = r9.atand(r0)
            double r0 = r2.swe_degnorm(r0)
            r2 = 0
            r24[r2] = r0
            int r0 = (r5 > r52 ? 1 : (r5 == r52 ? 0 : -1))
            if (r0 >= 0) goto L_0x03b7
            r0 = r24[r2]
            double r0 = r0 + r30
            r24[r2] = r0
        L_0x03b7:
            swisseph.SwissLib r0 = r9.sl
            r3 = r24[r2]
            double r0 = r0.swe_degnorm(r3)
            r24[r2] = r0
            swisseph.SwissLib r0 = r9.sl
            r3 = r24[r2]
            double r3 = r3 + r44
            double r0 = r0.swe_degnorm(r3)
            r24[r2] = r0
        L_0x03cd:
            r0 = r24[r2]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x03d5:
            r2 = 0
            r0 = r66[r2]
            double r2 = r0 - r54
            double r4 = swisseph.SMath.abs((double) r2)
            int r6 = (r4 > r46 ? 1 : (r4 == r46 ? 0 : -1))
            if (r6 <= 0) goto L_0x040a
            double r4 = r0 - r48
            double r4 = swisseph.SMath.abs((double) r4)
            int r6 = (r4 > r46 ? 1 : (r4 == r46 ? 0 : -1))
            if (r6 <= 0) goto L_0x040a
            double r2 = r9.tand(r0)
            double r2 = r2 / r18
            double r2 = r9.atand(r2)
            int r4 = (r0 > r54 ? 1 : (r0 == r54 ? 0 : -1))
            if (r4 <= 0) goto L_0x0407
            int r4 = (r0 > r48 ? 1 : (r0 == r48 ? 0 : -1))
            if (r4 > 0) goto L_0x0407
            swisseph.SwissLib r0 = r9.sl
            double r2 = r2 + r30
            double r48 = r0.swe_degnorm(r2)
            goto L_0x0416
        L_0x0407:
            r48 = r2
            goto L_0x0416
        L_0x040a:
            double r0 = swisseph.SMath.abs((double) r2)
            int r2 = (r0 > r46 ? 1 : (r0 == r46 ? 0 : -1))
            if (r2 > 0) goto L_0x0415
            r48 = r54
            goto L_0x0416
        L_0x0415:
        L_0x0416:
            swisseph.SwissLib r0 = r9.sl
            double r48 = r48 - r59
            double r1 = r48 - r54
            double r0 = r0.swe_degnorm(r1)
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x0426:
            double r0 = r58.sind(r59)
            double r14 = r9.tand(r12)
            double r0 = r0 * r14
            r9.atand(r0)
            double r0 = r54 - r10
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0462
            double r0 = r40 - r10
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0442
            goto L_0x0462
        L_0x0442:
            double r0 = r10 - r54
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x045f
            double r0 = r10 + r54
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x044f
            goto L_0x045f
        L_0x044f:
            double r0 = r9.tand(r10)
            double r2 = r9.tand(r2)
            double r0 = r0 * r2
            double r40 = r9.asind(r0)
            r0 = 0
            goto L_0x0466
        L_0x045f:
            r0 = 1
            goto L_0x0466
        L_0x0462:
            r40 = r54
            r0 = 1
        L_0x0466:
            double r1 = r9.tand(r12)
            double r3 = r9.tand(r10)
            double r1 = r1 * r3
            double r3 = r58.sind(r59)
            double r1 = r1 * r3
            double r3 = swisseph.SMath.abs((double) r1)
            int r8 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r8 <= 0) goto L_0x0489
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x0485
            r1 = r22
            goto L_0x0488
        L_0x0485:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r1 = r0
        L_0x0488:
            r0 = 1
        L_0x0489:
            double r1 = r9.asind(r1)
            double r3 = r1 + r54
            int r8 = (r3 > r52 ? 1 : (r3 == r52 ? 0 : -1))
            if (r8 != 0) goto L_0x0495
            r8 = 1
            goto L_0x0496
        L_0x0495:
            r8 = 0
        L_0x0496:
            double r10 = swisseph.SMath.abs((double) r3)
            int r12 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r12 <= 0) goto L_0x04f0
            int r10 = (r5 > r52 ? 1 : (r5 == r52 ? 0 : -1))
            if (r10 < 0) goto L_0x04c8
            double r5 = r5 - r40
            double r5 = r5 + r1
            double r5 = r5 / r3
            swisseph.SwissLib r1 = r9.sl
            double r2 = r5 - r22
            double r2 = r2 * r54
            double r1 = r1.swe_degnorm(r2)
            r3 = 0
            r24[r3] = r1
            swisseph.SwissLib r1 = r9.sl
            r10 = r24[r3]
            double r10 = r10 + r44
            double r1 = r1.swe_degnorm(r10)
            r24[r3] = r1
            int r1 = (r5 > r42 ? 1 : (r5 == r42 ? 0 : -1))
            if (r1 > 0) goto L_0x04c7
            int r1 = (r5 > r52 ? 1 : (r5 == r52 ? 0 : -1))
            if (r1 >= 0) goto L_0x04f0
        L_0x04c7:
            goto L_0x04f2
        L_0x04c8:
            double r5 = r5 + r30
            double r5 = r5 + r40
            double r5 = r5 + r1
            double r5 = r5 / r3
            swisseph.SwissLib r1 = r9.sl
            double r2 = r5 + r22
            double r2 = r2 * r54
            double r1 = r1.swe_degnorm(r2)
            r3 = 0
            r24[r3] = r1
            swisseph.SwissLib r1 = r9.sl
            r10 = r24[r3]
            double r10 = r10 + r44
            double r1 = r1.swe_degnorm(r10)
            r24[r3] = r1
            int r1 = (r5 > r42 ? 1 : (r5 == r42 ? 0 : -1))
            if (r1 > 0) goto L_0x04ef
            int r1 = (r5 > r52 ? 1 : (r5 == r52 ? 0 : -1))
            if (r1 >= 0) goto L_0x04f0
        L_0x04ef:
            goto L_0x04f2
        L_0x04f0:
            r20 = r8
        L_0x04f2:
            if (r20 == 0) goto L_0x0504
            r0 = 0
            r24[r0] = r52
            if (r7 == 0) goto L_0x07c4
            r7.setLength(r0)
            java.lang.String r0 = "Koch house position failed in circumpolar area"
            r7.append(r0)
            goto L_0x07c4
        L_0x0504:
            if (r0 == 0) goto L_0x0514
            if (r7 == 0) goto L_0x0512
            r0 = 0
            r7.setLength(r0)
            java.lang.String r1 = "Koch house position, doubtful result in circumpolar area"
            r7.append(r1)
            goto L_0x0515
        L_0x0512:
            r0 = 0
            goto L_0x0515
        L_0x0514:
            r0 = 0
        L_0x0515:
            r0 = r24[r0]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x051d:
            r0 = 0
            swisseph.SwissLib r1 = r9.sl
            double r5 = r5 - r54
            double r1 = r1.swe_degnorm(r5)
            r25[r0] = r1
            swisseph.SwissLib r0 = r9.sl
            r1 = 0
            r2 = 0
            double r3 = r54 - r10
            r59 = r0
            r60 = r25
            r61 = r1
            r62 = r24
            r63 = r2
            r64 = r3
            r59.swe_cotrans(r60, r61, r62, r63, r64)
            swisseph.SwissLib r0 = r9.sl
            r1 = 0
            r2 = r24[r1]
            double r2 = r2 + r44
            double r2 = r0.swe_degnorm(r2)
            r24[r1] = r2
            r0 = r24[r1]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x0552:
            r1 = 0
            swisseph.SwissLib r0 = r9.sl
            double r5 = r5 - r54
            double r2 = r0.swe_degnorm(r5)
            r25[r1] = r2
            swisseph.SwissLib r0 = r9.sl
            r1 = 0
            r2 = 0
            double r3 = -r10
            r59 = r0
            r60 = r25
            r61 = r1
            r62 = r24
            r63 = r2
            r64 = r3
            r59.swe_cotrans(r60, r61, r62, r63, r64)
            swisseph.SwissLib r0 = r9.sl
            r1 = 0
            r2 = r24[r1]
            double r2 = r2 + r44
            double r2 = r0.swe_degnorm(r2)
            r24[r1] = r2
            r0 = r24[r1]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x0586:
            swisseph.SwissLib r0 = r9.sl
            double r1 = r59 + r54
            double r1 = r0.swe_degnorm(r1)
            r0 = r58
            r14 = r4
            r3 = r61
            r7 = r5
            r5 = r16
            r56 = r7
            r7 = r18
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r2 = r58.sind(r59)
            double r4 = r9.tand(r12)
            double r2 = r2 * r4
            double r2 = r9.atand(r2)
            double r4 = r59 - r54
            double r6 = swisseph.SMath.abs((double) r4)
            int r8 = (r6 > r46 ? 1 : (r6 == r46 ? 0 : -1))
            if (r8 <= 0) goto L_0x05e1
            double r6 = r59 - r48
            double r6 = swisseph.SMath.abs((double) r6)
            int r8 = (r6 > r46 ? 1 : (r6 == r46 ? 0 : -1))
            if (r8 <= 0) goto L_0x05e1
            double r4 = r58.tand(r59)
            swisseph.SwissLib r6 = r9.sl
            double r4 = r4 / r18
            double r4 = r9.atand(r4)
            double r4 = r6.swe_degnorm(r4)
            int r6 = (r59 > r54 ? 1 : (r59 == r54 ? 0 : -1))
            if (r6 <= 0) goto L_0x05ee
            int r6 = (r59 > r48 ? 1 : (r59 == r48 ? 0 : -1))
            if (r6 > 0) goto L_0x05ee
            swisseph.SwissLib r6 = r9.sl
            double r4 = r4 + r30
            double r4 = r6.swe_degnorm(r4)
            goto L_0x05ee
        L_0x05e1:
            double r4 = swisseph.SMath.abs((double) r4)
            int r6 = (r4 > r46 ? 1 : (r4 == r46 ? 0 : -1))
            if (r6 > 0) goto L_0x05ec
            r4 = r54
            goto L_0x05ee
        L_0x05ec:
            r4 = r48
        L_0x05ee:
            int r6 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r6 < 0) goto L_0x0601
            double r6 = r54 - r10
            double r6 = r6 + r2
            int r8 = (r6 > r52 ? 1 : (r6 == r52 ? 0 : -1))
            if (r8 >= 0) goto L_0x0601
            swisseph.SwissLib r6 = r9.sl
            double r0 = r0 + r30
            double r0 = r6.swe_degnorm(r0)
        L_0x0601:
            int r6 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r6 >= 0) goto L_0x0615
            double r40 = r40 - r10
            double r40 = r40 + r2
            int r2 = (r40 > r52 ? 1 : (r40 == r52 ? 0 : -1))
            if (r2 <= 0) goto L_0x0615
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 + r30
            double r0 = r2.swe_degnorm(r0)
        L_0x0615:
            r2 = 79
            if (r14 != r2) goto L_0x0665
            swisseph.SwissLib r2 = r9.sl
            r3 = 0
            r6 = r66[r3]
            double r6 = r6 - r0
            double r6 = r2.swe_degnorm(r6)
            r24[r3] = r6
            swisseph.SwissLib r2 = r9.sl
            r6 = r24[r3]
            double r6 = r6 + r44
            double r6 = r2.swe_degnorm(r6)
            r24[r3] = r6
            r6 = r24[r3]
            int r2 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
            if (r2 >= 0) goto L_0x0638
            goto L_0x0640
        L_0x0638:
            r22 = 4619567317775286272(0x401c000000000000, double:7.0)
            r6 = r24[r3]
            double r6 = r6 - r30
            r24[r3] = r6
        L_0x0640:
            swisseph.SwissLib r2 = r9.sl
            double r0 = r2.swe_difdeg2n(r0, r4)
            r4 = r24[r3]
            double r6 = r30 - r0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0657
            r0 = r24[r3]
            double r0 = r0 * r34
            double r0 = r0 / r6
            double r52 = r22 + r0
            goto L_0x07c4
        L_0x0657:
            r2 = r24[r3]
            double r2 = r2 - r30
            double r2 = r2 + r0
            double r2 = r2 * r34
            double r2 = r2 / r0
            double r2 = r2 + r34
            double r52 = r22 + r2
            goto L_0x07c4
        L_0x0665:
            double r0 = r9.sind(r0)
            double r0 = r0 * r16
            double r0 = r9.asind(r0)
            double r2 = r9.tand(r10)
            double r2 = -r2
            double r0 = r9.tand(r0)
            double r2 = r2 * r0
            double r0 = swisseph.SMath.acos(r2)
            r2 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r0 = r0 * r2
            double r2 = r30 - r0
            r4 = r56
            int r6 = (r4 > r52 ? 1 : (r4 == r52 ? 0 : -1))
            if (r6 <= 0) goto L_0x069d
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0695
            double r5 = r4 * r54
            double r5 = r5 / r0
            goto L_0x06af
        L_0x0695:
            double r5 = r4 - r0
            double r5 = r5 * r54
            double r5 = r5 / r2
            double r5 = r5 + r54
            goto L_0x06af
        L_0x069d:
            double r6 = -r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x06a8
            double r5 = r4 * r54
            double r5 = r5 / r2
            double r5 = r5 + r32
            goto L_0x06af
        L_0x06a8:
            double r5 = r4 + r2
            double r5 = r5 * r54
            double r5 = r5 / r0
            double r5 = r5 + r48
        L_0x06af:
            swisseph.SwissLib r0 = r9.sl
            double r5 = r5 - r54
            double r0 = r0.swe_degnorm(r5)
            double r0 = r0 / r50
            double r0 = r0 + r22
            r2 = 4623507967449235456(0x402a000000000000, double:13.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x06c4
            r2 = 4622945017495814144(0x4028000000000000, double:12.0)
            double r0 = r0 - r2
        L_0x06c4:
            r52 = r0
            goto L_0x07c4
        L_0x06c8:
            r14 = r4
            swisseph.SwissLib r0 = r9.sl
            double r1 = r59 + r54
            double r1 = r0.swe_degnorm(r1)
            r0 = r58
            r3 = r61
            r5 = r16
            r7 = r18
            double r0 = r0.Asc1(r1, r3, r5, r7)
            double r2 = r58.sind(r59)
            double r4 = r9.tand(r12)
            double r2 = r2 * r4
            double r2 = r9.atand(r2)
            int r4 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r4 < 0) goto L_0x06ff
            double r54 = r54 - r10
            double r54 = r54 + r2
            int r4 = (r54 > r52 ? 1 : (r54 == r52 ? 0 : -1))
            if (r4 >= 0) goto L_0x06ff
            swisseph.SwissLib r4 = r9.sl
            double r0 = r0 + r30
            double r0 = r4.swe_degnorm(r0)
        L_0x06ff:
            int r4 = (r10 > r52 ? 1 : (r10 == r52 ? 0 : -1))
            if (r4 >= 0) goto L_0x0713
            double r40 = r40 - r10
            double r40 = r40 + r2
            int r2 = (r40 > r52 ? 1 : (r40 == r52 ? 0 : -1))
            if (r2 <= 0) goto L_0x0713
            swisseph.SwissLib r2 = r9.sl
            double r0 = r0 + r30
            double r0 = r2.swe_degnorm(r0)
        L_0x0713:
            swisseph.SwissLib r2 = r9.sl
            r3 = 0
            r4 = r66[r3]
            double r4 = r4 - r0
            double r4 = r2.swe_degnorm(r4)
            r24[r3] = r4
            r2 = 86
            if (r14 != r2) goto L_0x0730
            swisseph.SwissLib r2 = r9.sl
            r4 = r24[r3]
            r6 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r4 = r4 + r6
            double r4 = r2.swe_degnorm(r4)
            r24[r3] = r4
        L_0x0730:
            r2 = 87
            if (r14 != r2) goto L_0x0741
            swisseph.SwissLib r2 = r9.sl
            r4 = r24[r3]
            double r0 = r0 % r50
            double r4 = r4 + r0
            double r0 = r2.swe_degnorm(r4)
            r24[r3] = r0
        L_0x0741:
            swisseph.SwissLib r0 = r9.sl
            r1 = r24[r3]
            double r1 = r1 + r44
            double r0 = r0.swe_degnorm(r1)
            r24[r3] = r0
            r0 = r24[r3]
            double r0 = r0 / r50
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x0755:
            r3 = 0
            swisseph.SwissLib r1 = r9.sl
            double r5 = r4 / r42
            double r5 = r5 + r48
            double r1 = r1.swe_degnorm(r5)
            r24[r3] = r1
        L_0x0762:
            if (r7 == 0) goto L_0x076b
            java.lang.String r1 = "Otto Ludwig procedure within circumpolar regions."
            r7.append(r1)
            r1 = 0
            goto L_0x07ab
        L_0x076b:
            r1 = 0
            goto L_0x07ab
        L_0x076d:
            double r1 = r9.tand(r2)
            double r6 = r9.tand(r10)
            double r1 = r1 * r6
            double r6 = r9.asind(r1)
            double r10 = r9.cosd(r4)
            double r1 = r1 + r10
            int r3 = (r1 > r52 ? 1 : (r1 == r52 ? 0 : -1))
            if (r3 < 0) goto L_0x0785
            goto L_0x0787
        L_0x0785:
            r20 = 0
        L_0x0787:
            double r1 = r6 + r54
            double r6 = r54 - r6
            if (r20 == 0) goto L_0x0797
            double r5 = r4 / r1
            double r5 = r5 + r34
            double r5 = r5 * r54
            r1 = 0
            r24[r1] = r5
            goto L_0x079f
        L_0x0797:
            r1 = 0
            double r14 = r14 / r6
            double r14 = r14 + r22
            double r14 = r14 * r54
            r24[r1] = r14
        L_0x079f:
            swisseph.SwissLib r2 = r9.sl
            r3 = r24[r1]
            double r3 = r3 + r44
            double r2 = r2.swe_degnorm(r3)
            r24[r1] = r2
        L_0x07ab:
            char r0 = (char) r0
            r2 = 71
            if (r0 != r2) goto L_0x07be
            r2 = r24[r1]
            double r32 = r32 - r2
            r24[r1] = r32
            r0 = r24[r1]
            r2 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r0 = r0 / r2
            double r52 = r0 + r22
            goto L_0x07c4
        L_0x07be:
            r0 = r24[r1]
            double r0 = r0 / r50
            double r52 = r0 + r22
        L_0x07c4:
            return r52
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHouse.swe_house_pos(double, double, double, int, double[], java.lang.StringBuffer):double");
    }
}
