package swisseph;

import java.io.Serializable;

public class SweHel implements Serializable {
    private static final double Amplitude = 3.75606495492684d;
    private static final double Average = 1.80546834626888d;
    private static final double AvgRadiusMoon = 0.2590166666666667d;
    private static final double BNIGHT = 1479.0d;
    private static final double BNIGHT_FACTOR = 1.0d;
    private static final double C2K = 273.15d;
    private static final double D2H = 24.0d;
    private static final double D2S = 86400.0d;
    private static final double D2Y = 0.0027378507871321013d;
    private static final double DELTA = 18.36d;
    private static final int DONE = 1;
    private static final int FormAstroRefrac = 0;
    private static final double GBinocular = 1.0d;
    private static final double GCR = 8314.472d;
    private static final double GOpticDia = 50.0d;
    private static final double GOpticMag = 1.0d;
    private static final double GOpticTrans = 0.8d;
    private static final int GravitySource = 2;
    private static final double H2S = 3600.0d;
    private static final double JC2D = 36525.0d;
    private static final double LapseDA = 0.0098d;
    private static final double LapseSA = 0.0065d;
    private static final int LocalMinStep = 8;
    private static final double LowestAppAlt = -3.5d;
    private static final double M2S = 60.0d;
    private static final int MAX_COUNT_SYNPER = 5;
    private static final int MAX_COUNT_SYNPER_MAX = 1000000;
    private static final double MD = 28.964d;
    private static final double MW = 18.016d;
    private static final int MaxTryHours = 4;
    private static final double Min2Deg = 0.016666666666666666d;
    private static final double MoonDistance = 384410.4978d;
    private static final int PLSV = 0;
    private static final double Periodicy = 1443.67123144531d;
    private static final double PressRef = 1000.0d;
    private static final int REFR_BENNETTH = 1;
    private static final int REFR_SINCLAIR = 0;
    private static final int REarthSource = 1;
    private static final double Ra = 6378136.6d;
    private static final double Rb = 6356752.314d;
    private static final double S2H = 2.777777777777778E-4d;
    private static final int StartYear = 1820;
    private static final double TempNulDiff = 1.0E-6d;
    private static final int TimeStepDefault = 1;
    private static final boolean USE_DELTA_T_VR = false;
    private static final double Y2D = 365.25d;
    private static final double astr2tau = 0.921034037197618d;
    private static final double criticalangle = 0.0d;
    private static final double epsilon = 0.001d;
    private static final double erg2nL = 9.803921568627451E14d;
    private static final double nL2erg = 1.02E-15d;
    private static final double phase = 0.0d;
    private static final double scaleHaerosol = 3745.0d;
    private static final double scaleHozone = 20000.0d;
    private static final double scaleHrayleigh = 8515.0d;
    private static final double scaleHwater = 3000.0d;
    private static final int staticAirmass = 0;
    private static final double tau2astr = 1.0857362047581298d;
    private double Deltam__alto_last;
    private double Deltam__alts_last;
    private double Deltam__deltam_last;
    private double Deltam__sunra_last;
    double[] call_swe_fixstar_mag__dmag;
    StringBuffer call_swe_fixstar_mag__star_save;
    private double ka__alts_last;
    private double ka__ka_last;
    private double ka__sunra_last;
    private double koz__alts_last;
    private double koz__koz_last;
    private double koz__sunra_last;
    private Swecl sc;
    private SwissLib sl;
    private Swemmoon sm;
    private double sunRA_ralast;
    private double sunRA_tjdlast;
    private SwissEph sw;
    private SwissData swed;
    private double[] tcon;

    public SweHel() {
        this((SwissEph) null, (SwissLib) null, (Swemmoon) null, (SwissData) null);
    }

    public SweHel(SwissEph swissEph, SwissLib swissLib, Swemmoon swemmoon, SwissData swissData) {
        this.call_swe_fixstar_mag__dmag = new double[]{0.0d};
        this.call_swe_fixstar_mag__star_save = new StringBuffer();
        this.tcon = new double[]{0.0d, 0.0d, 2451550.0d, 2451550.0d, 2451604.0d, 2451670.0d, 2451980.0d, 2452280.0d, 2451727.0d, 2452074.0d, 2451673.0d, 2451877.0d, 2451675.0d, 2451868.0d, 2451581.0d, 2451768.0d, 2451568.0d, 2451753.0d};
        this.sw = swissEph;
        this.sl = swissLib;
        this.sm = swemmoon;
        this.swed = swissData;
        if (swissEph == null) {
            this.sw = new SwissEph();
        }
        if (swissLib == null) {
            this.sl = new SwissLib();
        }
        if (swemmoon == null) {
            this.sm = new Swemmoon();
        }
        if (swissData == null) {
            this.swed = new SwissData();
        }
        this.sc = new Swecl(this.sw, this.sl, this.sm, this.swed);
    }

    private double Tanh(double d) {
        double d2 = -d;
        return (SMath.exp(d) - SMath.exp(d2)) / (SMath.exp(d) + SMath.exp(d2));
    }

    private double CVA(double d, double d2) {
        if (d > BNIGHT) {
            return (((40.0d / d2) * SMath.pow(10.0d, SMath.pow(d, -0.29d) * 8.28d)) / M2S) / M2S;
        }
        return (SMath.min(900.0d, (380.0d / d2) * SMath.pow(10.0d, SMath.pow(d, -0.29d) * 0.3d)) / M2S) / M2S;
    }

    private double PupilDia(double d, double d2) {
        return ((0.534d - (0.00211d * d)) - ((0.236d - (d * 0.00127d)) * Tanh(((SMath.log(d2) * 0.4d) / SMath.log(10.0d)) - 2.2d))) * 10.0d;
    }

    private double OpticFactor(double d, double d2, double[] dArr, double d3, String str, int i, int i2) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13 = d;
        double d14 = dArr[0];
        double d15 = dArr[1];
        double d16 = dArr[2];
        double d17 = dArr[3];
        double d18 = dArr[4];
        double d19 = dArr[5];
        if (d15 <= 1.0E-8d) {
            d15 = 1.0E-8d;
        }
        double d20 = d18;
        double PupilDia = PupilDia(23.0d, d13);
        double d21 = d19;
        if (d17 == 1.0d) {
            d5 = PupilDia;
            d4 = 1.0d;
        } else {
            d4 = d21;
            d5 = d20;
        }
        str.equals("moon");
        double d22 = d16 == 0.0d ? 1.41d : 1.0d;
        if (d13 > BNIGHT || (i2 & 16384) != 0) {
            d6 = d15;
            d7 = d22;
            double d23 = d5 / d17;
            d10 = 1.0d;
            d12 = SMath.min(1.0d, (SMath.pow(d23 / PupilDia, 2.0d) * (1.0d - SMath.exp(-SMath.pow(PupilDia / 6.2d, 2.0d)))) / (1.0d - SMath.exp(-SMath.pow(d23 / 6.2d, 2.0d))));
            d8 = SMath.pow(10.0d, 0.4d * d2);
            d11 = 1.0d;
            d9 = 1.0d;
        } else {
            d7 = d22;
            double pow = SMath.pow(10.0d, 0.48d * d2);
            d6 = d15;
            d12 = SMath.min(1.0d, (1.0d - SMath.pow(PupilDia / 124.4d, 4.0d)) / (1.0d - SMath.pow((d5 / d17) / 124.4d, 4.0d)));
            d8 = pow;
            d9 = SMath.pow(10.0d, -0.30000000000000004d);
            d11 = SMath.pow(10.0d, -0.26d);
            d10 = 1.0d;
        }
        double d24 = d10 / d4;
        double d25 = d;
        double d26 = d11;
        double max = SMath.max(1.0d, SMath.pow(PupilDia / (PupilDia(d14, d25) * d17), 2.0d));
        double pow2 = SMath.pow(PupilDia / d5, 2.0d);
        double d27 = d6;
        double d28 = d9;
        double pow3 = ((SMath.pow((0.0d * d17) / CVA(d25, d27), 2.0d) * 0.03d) + 1.0d) / SMath.pow(d27, 2.0d);
        double pow4 = SMath.pow(d17, 2.0d);
        if (i == 0) {
            return d7 * d8 * d24 * max * pow2 * pow3 * d12 * d28;
        }
        return d7 * d24 * max * pow2 * pow4 * d12 * d26;
    }

    private int DeterObject(StringBuffer stringBuffer) {
        return DeterObject(stringBuffer.toString());
    }

    private int DeterObject(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("sun")) {
            return 0;
        }
        if (lowerCase.startsWith("venus")) {
            return 3;
        }
        if (lowerCase.startsWith("mars")) {
            return 4;
        }
        if (lowerCase.startsWith("mercur")) {
            return 2;
        }
        if (lowerCase.startsWith("jupiter")) {
            return 5;
        }
        if (lowerCase.startsWith("saturn")) {
            return 6;
        }
        if (lowerCase.startsWith("uranus")) {
            return 7;
        }
        if (lowerCase.startsWith("neptun")) {
            return 8;
        }
        if (lowerCase.startsWith("moon")) {
            return 1;
        }
        int atoi = SwissLib.atoi(lowerCase);
        if (atoi > 0) {
            return atoi + SweConst.SE_AST_OFFSET;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int call_swe_fixstar(StringBuffer stringBuffer, double d, int i, double[] dArr, StringBuffer stringBuffer2) {
        return this.sw.swe_fixstar(new StringBuffer(stringBuffer), d, i, dArr, stringBuffer2);
    }

    /* access modifiers changed from: package-private */
    public int call_swe_fixstar_mag(StringBuffer stringBuffer, double[] dArr, int i, StringBuffer stringBuffer2) {
        StringBuffer stringBuffer3 = new StringBuffer();
        if (stringBuffer.equals(this.call_swe_fixstar_mag__star_save)) {
            dArr[i] = this.call_swe_fixstar_mag__dmag[0];
            return 0;
        }
        this.call_swe_fixstar_mag__star_save.setLength(0);
        this.call_swe_fixstar_mag__star_save.append(stringBuffer);
        stringBuffer3.setLength(0);
        stringBuffer3.append(stringBuffer);
        int swe_fixstar_mag = this.sw.swe_fixstar_mag(stringBuffer3, this.call_swe_fixstar_mag__dmag, stringBuffer2);
        dArr[i] = this.call_swe_fixstar_mag__dmag[0];
        return swe_fixstar_mag;
    }

    /* access modifiers changed from: package-private */
    public int call_swe_rise_trans(double d, int i, String str, int i2, int i3, double[] dArr, double d2, double d3, double[] dArr2, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = new StringBuffer(str);
        DblObj dblObj = new DblObj();
        dblObj.val = dArr2[0];
        int swe_rise_trans = this.sc.swe_rise_trans(d, i, stringBuffer2, i2 & 6, i3, dArr, d2, d3, dblObj, stringBuffer);
        dArr2[0] = dblObj.val;
        return swe_rise_trans;
    }

    private int calc_rise_and_set(double d, int i, double[] dArr, double[] dArr2, int i2, int i3, double[] dArr3, StringBuffer stringBuffer) {
        int i4;
        int i5;
        double d2;
        int i6;
        int i7 = i2;
        int i8 = i3;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        double d3 = ((double) ((int) d)) - ((dArr[0] / 15.0d) / D2H);
        int i9 = (i8 & 6) | 2048;
        int i10 = i8 & 256;
        if (i10 == 0) {
            i4 = i9 | 80;
        } else {
            i4 = i9;
        }
        int i11 = i10;
        if (this.sw.swe_calc_ut(d, 0, i4, dArr4, stringBuffer) == 0) {
            if (stringBuffer2 != null) {
                stringBuffer2.setLength(0);
                stringBuffer2.append("error in calc_rise_and_set(): calc(sun) failed ");
            }
            return -1;
        } else if (this.sw.swe_calc_ut(d, i, i4, dArr5, stringBuffer) != 0) {
            double d4 = 0.0d;
            double swe_degnorm = d3 - ((this.sl.swe_degnorm(dArr4[0] - dArr5[0]) / 360.0d) + 0.0d);
            double[] dArr8 = dArr7;
            double[] dArr9 = dArr6;
            double[] dArr10 = dArr5;
            this.sc.swe_azalt(d, 1, dArr, dArr2[0], dArr2[1], dArr5, dArr9);
            int i12 = i7 & 1;
            if (i12 == 0) {
                i5 = 0;
                if (dArr9[2] > 0.0d) {
                    while (d - swe_degnorm > 0.5d) {
                        swe_degnorm += 1.0d;
                    }
                    while (d - swe_degnorm < -0.5d) {
                        swe_degnorm -= 1.0d;
                    }
                } else {
                    while (d - swe_degnorm > 0.0d) {
                        swe_degnorm += 1.0d;
                    }
                    while (d - swe_degnorm < -1.0d) {
                        swe_degnorm -= 1.0d;
                    }
                }
            } else if (dArr9[2] > 0.0d) {
                while (true) {
                    i5 = 0;
                    if (swe_degnorm - d >= 0.5d) {
                        break;
                    }
                    swe_degnorm += 1.0d;
                }
                while (swe_degnorm - d > 1.5d) {
                    swe_degnorm -= 1.0d;
                }
            } else {
                i5 = 0;
                while (swe_degnorm - d < 0.0d) {
                    swe_degnorm += 1.0d;
                }
                while (swe_degnorm - d > 1.0d) {
                    swe_degnorm -= 1.0d;
                }
            }
            if (this.sw.swe_calc_ut(swe_degnorm, i, i4, dArr10, stringBuffer) == -1) {
                if (stringBuffer2 != null) {
                    stringBuffer2.setLength(i5);
                    stringBuffer2.append("error in calc_rise_and_set(): calc(sun) failed ");
                }
                return -1;
            }
            double asin = SMath.asin(0.004652472637378737d / dArr10[2]) / 0.0174532925199433d;
            if ((i7 & 256) == 0) {
                d4 = asin;
            }
            double d5 = -(d4 + 0.575d);
            double acos = SMath.acos((-SMath.tan(dArr[1] * 0.0174532925199433d)) * SMath.tan(dArr10[1] * 0.0174532925199433d)) * 57.2957795130823d;
            if (i12 != 0) {
                d2 = swe_degnorm - (acos / 360.0d);
            } else {
                d2 = swe_degnorm + (acos / 360.0d);
            }
            int i13 = 2304;
            if (i == 1) {
                i13 = 35072;
            }
            if (i11 == 0) {
                i6 = i13 | 80;
            } else {
                i6 = i13;
            }
            int i14 = 0;
            for (int i15 = 2; i14 < i15; i15 = 2) {
                if (this.sw.swe_calc_ut(d2, i, i6, dArr10, stringBuffer) == -1) {
                    return -1;
                }
                double[] dArr11 = dArr;
                double[] dArr12 = dArr10;
                this.sc.swe_azalt(d2, 1, dArr11, dArr2[i5], dArr2[1], dArr12, dArr9);
                dArr10[0] = dArr10[0] - (dArr10[3] * D2Y);
                dArr10[1] = dArr10[1] - (dArr10[4] * D2Y);
                this.sc.swe_azalt(d2 - D2Y, 1, dArr11, dArr2[0], dArr2[1], dArr12, dArr8);
                d2 -= ((dArr9[1] - d5) / (dArr9[1] - dArr8[1])) * D2Y;
                i14++;
                int i16 = i;
                i5 = 0;
            }
            dArr3[0] = d2;
            return 0;
        } else if (stringBuffer2 == null) {
            return -1;
        } else {
            stringBuffer2.setLength(0);
            stringBuffer2.append("error in calc_rise_and_set(): calc(sun) failed ");
            return -1;
        }
    }

    private int my_rise_trans(double d, int i, String str, int i2, int i3, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer) {
        int i4;
        String str2 = str;
        if (str2 == null || "".equals(str2)) {
            i4 = i;
        } else {
            i4 = DeterObject(str2);
        }
        if (i4 != -1 && SMath.abs(dArr[1]) < 63.0d) {
            return calc_rise_and_set(d, i4, dArr, dArr2, i2, i3, dArr3, stringBuffer);
        }
        return call_swe_rise_trans(d, i4, str, i3, i2, dArr, dArr2[0], dArr2[1], dArr3, stringBuffer);
    }

    private int RiseSet(double d, double[] dArr, double[] dArr2, String str, int i, int i2, int i3, double[] dArr3, StringBuffer stringBuffer) {
        int i4;
        if (i3 == 0) {
            i4 = i | 256;
        } else {
            i4 = i;
        }
        int DeterObject = DeterObject(str);
        if (DeterObject != -1) {
            return my_rise_trans(d, DeterObject, "", i4, i2, dArr, dArr2, dArr3, stringBuffer);
        }
        return my_rise_trans(d, -1, str, i4, i2, dArr, dArr2, dArr3, stringBuffer);
    }

    private double SunRA(double d, int i, StringBuffer stringBuffer) {
        if (d == this.sunRA_tjdlast) {
            return this.sunRA_ralast;
        }
        SweDate sweDate = new SweDate(d, true);
        int month = sweDate.getMonth();
        int day = sweDate.getDay();
        this.sunRA_tjdlast = d;
        double swe_degnorm = this.sl.swe_degnorm(((((double) month) + (((double) (day - 1)) / 30.4d)) - 3.69d) * 30.0d);
        this.sunRA_ralast = swe_degnorm;
        return swe_degnorm;
    }

    private double Kelvin(double d) {
        return d + C2K;
    }

    private double TopoAltfromAppAlt(double d, double d2, double d3) {
        double d4;
        if (d < LowestAppAlt) {
            return d;
        }
        if (d > 17.904104638432d) {
            d4 = 0.97d / SMath.tan(0.0174532925199433d * d);
        } else {
            d4 = (((4.23d * d) + 34.46d) + ((0.004d * d) * d)) / (((0.505d * d) + 1.0d) + ((0.0845d * d) * d));
        }
        return d - (((((d3 - 80.0d) / 930.0d) / ((((39.0d + d4) * 8.0E-5d) * (d2 - 10.0d)) + 1.0d)) * d4) * Min2Deg);
    }

    private double AppAltfromTopoAlt(double d, double d2, double d3, int i) {
        int i2;
        double d4;
        if ((i & 256) != 0) {
            i2 = 5;
        } else {
            i2 = 2;
        }
        int i3 = 0;
        double d5 = d;
        double d6 = d5;
        double d7 = 0.0d;
        while (i3 <= i2) {
            double TopoAltfromAppAlt = d5 - TopoAltfromAppAlt(d5, d2, d3);
            double d8 = d5 - d6;
            double d9 = (TopoAltfromAppAlt - d7) - d8;
            if (d8 == 0.0d || d9 == 0.0d) {
                d4 = d + TopoAltfromAppAlt;
            } else {
                d4 = d5 - ((d8 * ((d + TopoAltfromAppAlt) - d5)) / d9);
            }
            i3++;
            d6 = d5;
            d5 = d4;
            d7 = TopoAltfromAppAlt;
        }
        double d10 = d + d7;
        if (d10 < LowestAppAlt) {
            return d;
        }
        return d10;
    }

    private double HourAngle(double d, double d2, double d3) {
        double d4 = d2 * 0.0174532925199433d;
        double d5 = d3 * 0.0174532925199433d;
        double sin = ((SMath.sin(d * 0.0174532925199433d) - (SMath.sin(d5) * SMath.sin(d4))) / SMath.cos(d5)) / SMath.cos(d4);
        if (sin < -1.0d) {
            sin = -1.0d;
        }
        if (sin > 1.0d) {
            sin = 1.0d;
        }
        return (SMath.acos(sin) / 0.0174532925199433d) / 15.0d;
    }

    private double DeltaTSE(double d, int i) {
        if (i == 0) {
            return SweDate.getDeltaT(d) * D2S;
        }
        double julDay = (SweDate.getJulDay(StartYear, 1, 1, 0.0d, true) - d) / Y2D;
        return (((((julDay * julDay) / 100.0d) / 2.0d) * ((double) i)) * Y2D) / PressRef;
    }

    private double DeltaTVR(double d, int i) {
        double d2;
        double julDay = (SweDate.getJulDay(StartYear, 1, 1, 0.0d, true) - d) / Y2D;
        if (i == 0) {
            d2 = (((((julDay * julDay) / 100.0d) / 2.0d) * Average) + ((SMath.cos((julDay * 6.283185307179586d) / Periodicy) - 1.0d) * 863.0213265669036d)) * Y2D;
        } else {
            d2 = (((julDay * julDay) / 100.0d) / 2.0d) * ((double) i) * Y2D;
        }
        return d2 / PressRef;
    }

    private double DeltaT(double d, int i) {
        return DeltaTSE(d, i);
    }

    private int ObjectLoc(double d, double[] dArr, double[] dArr2, String str, int i, int i2, double[] dArr3, StringBuffer stringBuffer) {
        String str2 = str;
        return ObjectLoc(d, dArr, dArr2, new StringBuffer(str), i, i2, dArr3, stringBuffer);
    }

    private int ObjectLoc(double d, double[] dArr, double[] dArr2, StringBuffer stringBuffer, int i, int i2, double[] dArr3, StringBuffer stringBuffer2) {
        int i3;
        int i4;
        char c;
        int i5;
        int i6;
        double d2 = d;
        int i7 = i;
        int i8 = i2;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[3];
        double[] dArr6 = new double[3];
        int i9 = (i8 & 6) | 2048;
        if ((i8 & 256) == 0) {
            i9 |= 80;
        }
        if (i7 < 5) {
            i9 |= 32768;
        }
        int i10 = i9;
        int i11 = i7 == 7 ? 0 : i7;
        double DeltaT = d2 + (DeltaT(d2, 0) / D2S);
        int DeterObject = DeterObject(stringBuffer);
        if (DeterObject != -1) {
            i4 = i11;
            i3 = 0;
            if (this.sw.swe_calc(DeltaT, DeterObject, i10, dArr4, stringBuffer2) == -1) {
                return -1;
            }
        } else {
            i4 = i11;
            i3 = 0;
            if (call_swe_fixstar(stringBuffer, DeltaT, i10, dArr4, stringBuffer2) == -1) {
                return -1;
            }
        }
        if (i4 == 2) {
            c = 1;
        } else if (i4 == 5) {
            c = 1;
        } else if (i4 == 3 || i4 == 6) {
            dArr3[i3] = dArr4[i3];
            return i3;
        } else {
            dArr5[i3] = dArr4[i3];
            dArr5[1] = dArr4[1];
            int i12 = i4;
            double[] dArr7 = dArr6;
            this.sc.swe_azalt(d, 1, dArr, dArr2[i3], dArr2[1], dArr5, dArr7);
            if (i12 == 0) {
                dArr3[i3] = dArr7[1];
            }
            if (i12 == 4) {
                i6 = i12;
                i5 = 1;
                dArr3[i3] = AppAltfromTopoAlt(dArr7[1], dArr2[i3], dArr2[1], i2);
            } else {
                i6 = i12;
                i5 = 1;
            }
            if (i6 == i5) {
                dArr7[i3] = dArr7[i3] + 180.0d;
                if (dArr7[i3] >= 360.0d) {
                    dArr7[i3] = dArr7[i3] - 360.0d;
                }
                dArr3[i3] = dArr7[i3];
            }
            return i3;
        }
        dArr3[i3] = dArr4[c];
        return i3;
    }

    private int azalt_cart(double d, double[] dArr, double[] dArr2, StringBuffer stringBuffer, int i, double[] dArr3, StringBuffer stringBuffer2) {
        return azalt_cart(d, dArr, dArr2, stringBuffer, i, dArr3, 0, stringBuffer2);
    }

    private int azalt_cart(double d, double[] dArr, double[] dArr2, StringBuffer stringBuffer, int i, double[] dArr3, int i2, StringBuffer stringBuffer2) {
        int i3;
        double[] dArr4;
        double[] dArr5;
        double d2 = d;
        int i4 = i;
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[3];
        double[] dArr8 = new double[3];
        int i5 = (i4 & 6) | 2048;
        if ((i4 & 256) == 0) {
            i5 |= 80;
        }
        int i6 = i5 | 32768;
        double DeltaT = d2 + (DeltaT(d2, 0) / D2S);
        int DeterObject = DeterObject(stringBuffer);
        if (DeterObject == -1) {
            i3 = 0;
            int i7 = i6;
            dArr5 = dArr8;
            dArr4 = dArr7;
            if (call_swe_fixstar(stringBuffer, DeltaT, i7, dArr6, stringBuffer2) == -1) {
                return -1;
            }
        } else if (this.sw.swe_calc(DeltaT, DeterObject, i6, dArr6, stringBuffer2) == -1) {
            return -1;
        } else {
            dArr5 = dArr8;
            dArr4 = dArr7;
            i3 = 0;
        }
        dArr4[i3] = dArr6[i3];
        dArr4[1] = dArr6[1];
        double[] dArr9 = dArr5;
        this.sc.swe_azalt(d, 1, dArr, dArr2[i3], dArr2[1], dArr4, dArr9);
        dArr3[i2] = dArr9[i3];
        dArr3[i2 + 1] = dArr9[1];
        dArr3[i2 + 2] = dArr9[2];
        dArr9[1] = dArr9[2];
        dArr9[2] = 1.0d;
        this.sl.swi_polcart(dArr9, dArr9);
        dArr3[i2 + 3] = dArr9[i3];
        dArr3[i2 + 4] = dArr9[1];
        dArr3[i2 + 5] = dArr9[2];
        return i3;
    }

    private double DistanceAngle(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double sin = SMath.sin((d3 - d) / 2.0d);
        double sin2 = SMath.sin(d5 / 2.0d);
        double cos = (sin * sin) + (SMath.cos(d) * SMath.cos(d3) * sin2 * sin2);
        if (cos > 1.0d) {
            cos = 1.0d;
        }
        return SMath.asin(SMath.sqrt(cos)) * 2.0d;
    }

    private double kW(double d, double d2, double d3) {
        return (d3 / 100.0d) * 0.94d * SMath.exp(d2 / 15.0d) * SMath.exp((d * -1.0d) / scaleHwater) * 0.031d;
    }

    private double kOZ(double d, double d2, double d3) {
        if (d == this.koz__alts_last && d2 == this.koz__sunra_last) {
            return this.koz__koz_last;
        }
        this.koz__alts_last = d;
        this.koz__sunra_last = d2;
        double d4 = d3 * 0.0174532925199433d;
        double cos = ((((((SMath.cos(d2 * 0.0174532925199433d) * d4) - SMath.cos(d4 * 3.0d)) * 0.4d) + 3.0d) * 0.031d) / 3.0d) * ((100.0d - (SMath.min(6.0d, SMath.max((-d) - 12.0d, 0.0d)) * 11.6d)) / 100.0d);
        this.koz__koz_last = cos;
        return cos;
    }

    private double kR(double d, double d2) {
        double d3 = (-d) - 12.0d;
        if (d3 < 0.0d) {
            d3 = 0.0d;
        }
        if (d3 > 6.0d) {
            d3 = 6.0d;
        }
        return SMath.exp((d2 * -1.0d) / scaleHrayleigh) * 0.1066d * SMath.pow(((((1.0d - (d3 * 0.166667d)) - 1.0d) * 0.04d) + 0.55d) / 0.55d, -4.0d);
    }

    private int Sgn(double d) {
        if (d < 0.0d) {
            return -1;
        }
        return 1;
    }

    private double ka(double d, double d2, double d3, double d4, double d5, double d6, double d7, StringBuffer stringBuffer) {
        double d8;
        double d9 = d;
        double d10 = d2;
        double d11 = d4;
        StringBuffer stringBuffer2 = stringBuffer;
        double Sgn = (double) Sgn(d3);
        if (d9 == this.ka__alts_last && d10 == this.ka__sunra_last) {
            return this.ka__ka_last;
        }
        this.ka__alts_last = d9;
        this.ka__sunra_last = d10;
        double min = (((1.0d - (SMath.min(6.0d, SMath.max((-d9) - 12.0d, 0.0d)) * 0.166667d)) - 1.0d) * 0.04d) + 0.55d;
        if (d7 == 0.0d) {
            double d12 = 1.0E-8d;
            if (d6 > 1.0E-8d) {
                d12 = d6;
            }
            if (d12 >= 99.99999999d) {
                d12 = 99.99999999d;
            }
            d8 = SMath.exp((d11 * -1.0d) / scaleHaerosol) * 0.1d * SMath.pow(1.0d - (0.32d / SMath.log(d12 / 100.0d)), 1.33d) * ((Sgn * 0.33d * SMath.sin(0.0174532925199433d * d2)) + 1.0d) * SMath.pow(min / 0.55d, -1.3d);
        } else if (d7 >= 1.0d) {
            d8 = ((((3.912d / d7) - ((((kW(d4, d5, d6) / scaleHwater) + (kR(d9, d11) / scaleHrayleigh)) * PressRef) * astr2tau)) * scaleHaerosol) / PressRef) * tau2astr;
            if (d8 < 0.0d && stringBuffer2 != null) {
                stringBuffer2.setLength(0);
                stringBuffer2.append("The provided Meteorological range is too long, when taking into acount other atmospheric parameters");
            }
        } else {
            d8 = ((d7 - kW(d4, d5, d6)) - kR(d9, d11)) - kOZ(d, d2, d3);
            if (d8 < 0.0d && stringBuffer2 != null) {
                stringBuffer2.setLength(0);
                stringBuffer2.append("The provided atmosphic coeefficent (ktot) is too low, when taking into acount other atmospheric parameters");
            }
        }
        this.ka__ka_last = d8;
        return d8;
    }

    private double kt(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i, StringBuffer stringBuffer) {
        double d8;
        double d9;
        double d10;
        double d11;
        int i2 = i;
        double d12 = 0.0d;
        if (i2 == 2 || i2 == 4) {
            d8 = kR(d, d4);
        } else {
            double d13 = d;
            double d14 = d4;
            d8 = 0.0d;
        }
        if (i2 == 1 || i2 == 4) {
            d9 = kW(d4, d5, d6);
        } else {
            d9 = 0.0d;
        }
        if (i2 == 3 || i2 == 4) {
            d10 = kOZ(d, d2, d3);
        } else {
            d10 = 0.0d;
        }
        if (i2 == 0 || i2 == 4) {
            d11 = ka(d, d2, d3, d4, d5, d6, d7, stringBuffer);
        } else {
            d11 = 0.0d;
        }
        if (d11 >= 0.0d) {
            d12 = d11;
        }
        return d9 + d8 + d10 + d12;
    }

    private double Airmass(double d, double d2) {
        double d3 = (90.0d - d) * 0.0174532925199433d;
        if (d3 > 1.5707963267948966d) {
            d3 = 1.5707963267948966d;
        }
        return (d2 / 1013.0d) * (1.0d / (SMath.cos(d3) + (SMath.exp(SMath.cos(d3) * -11.0d) * 0.025d)));
    }

    private double Xext(double d, double d2, double d3) {
        double cos = SMath.cos(d2);
        double d4 = d / PressRef;
        return (d3 / 1013.0d) / (cos + ((SMath.sqrt(d4) * 0.01d) * SMath.exp((-30.0d / SMath.sqrt(d4)) * SMath.cos(d2))));
    }

    private double Xlay(double d, double d2, double d3) {
        double sin = SMath.sin(d2) / ((d / Ra) + 1.0d);
        return (d3 / 1013.0d) / SMath.sqrt(1.0d - (sin * sin));
    }

    private double TempEfromTempS(double d, double d2, double d3) {
        return d - (d3 * d2);
    }

    private double PresEfromPresS(double d, double d2, double d3) {
        return d2 * SMath.exp(((-0.28404373326d / (Kelvin(d) + ((3.25d * d3) / PressRef))) / 8.31441d) * d3);
    }

    private double Deltam(double d, double d2, double d3, double d4, double d5, double[] dArr, int i, StringBuffer stringBuffer) {
        double d6;
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        double AppAltfromTopoAlt = AppAltfromTopoAlt(d, TempEfromTempS(dArr[1], d5, LapseSA), PresEfromPresS(dArr[1], dArr[0], d5), i);
        if (d8 == this.Deltam__alts_last && d7 == this.Deltam__alto_last && d9 == this.Deltam__sunra_last) {
            return this.Deltam__deltam_last;
        }
        this.Deltam__alts_last = d8;
        this.Deltam__alto_last = d7;
        this.Deltam__sunra_last = d9;
        double d10 = (90.0d - AppAltfromTopoAlt) * 0.0174532925199433d;
        if (d10 > 1.5707963267948966d) {
            d6 = 1.5707963267948966d;
        } else {
            d6 = d10;
        }
        double d11 = d6;
        double Xext = Xext(scaleHrayleigh, d11, dArr[0]);
        double Xext2 = Xext(scaleHwater, d11, dArr[0]);
        double Xext3 = Xext(scaleHaerosol, d11, dArr[0]);
        double Xlay = Xlay(scaleHozone, d11, dArr[0]);
        double d12 = d3;
        double d13 = d4;
        double kR = (Xext * kR(d8, d5)) + (kt(d2, d12, d13, d5, dArr[1], dArr[2], dArr[3], 0, stringBuffer) * Xext3) + (kOZ(d2, d12, d13) * Xlay) + (kW(d5, dArr[1], dArr[2]) * Xext2);
        this.Deltam__deltam_last = kR;
        return kR;
    }

    private double Bn(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, int i, StringBuffer stringBuffer) {
        double AppAltfromTopoAlt = AppAltfromTopoAlt(d, TempEfromTempS(dArr[1], d6, LapseSA), PresEfromPresS(dArr[1], dArr[0], d6), i);
        if (AppAltfromTopoAlt < 10.0d) {
            AppAltfromTopoAlt = 10.0d;
        }
        double d7 = (90.0d - AppAltfromTopoAlt) * 0.0174532925199433d;
        SweDate sweDate = new SweDate(d2, true);
        return SMath.max(SMath.pow(10.0d, Deltam(d, d3, d4, d5, d6, dArr, i, stringBuffer) * -0.4d) * 1.0E-13d * ((SMath.cos((((((double) sweDate.getYear()) + (((((((double) sweDate.getDay()) - 1.0d) / 30.4d) + ((double) sweDate.getMonth())) - 1.0d) / 12.0d)) - 1990.33d) * 6.283d) / 11.1d) * 0.3d) + 1.0d) * ((0.6d / SMath.sqrt(1.0d - (SMath.pow(SMath.sin(d7), 2.0d) * 0.96d))) + 0.4d), 0.0d) * erg2nL;
    }

    private int Magnitude(double d, double[] dArr, StringBuffer stringBuffer, int i, double[] dArr2, int i2, StringBuffer stringBuffer2) {
        int i3;
        StringBuffer stringBuffer3 = stringBuffer;
        int i4 = i;
        double[] dArr3 = dArr2;
        int i5 = i2;
        double[] dArr4 = new double[20];
        dArr3[i5] = -99.0d;
        int DeterObject = DeterObject(stringBuffer3);
        int i6 = (i4 & 6) | 34816;
        if ((i4 & 256) == 0) {
            i3 = i6 | 80;
        } else {
            i3 = i6;
        }
        if (DeterObject != -1) {
            this.sw.swe_set_topo(dArr[0], dArr[1], dArr[2]);
            if (this.sw.swe_pheno_ut(d, DeterObject, i3, dArr4, stringBuffer2) == -1) {
                return -1;
            }
            dArr3[i5] = dArr4[4];
        } else if (call_swe_fixstar_mag(stringBuffer3, dArr3, i5, stringBuffer2) == -1) {
            return -1;
        }
        return 0;
    }

    private double MoonsBrightness(double d, double d2) {
        return (((SMath.log(d / 6378.1366d) * 5.0d) / 2.302585092994d) - 0.20609375d) + (SMath.abs(d2) * 0.026d) + (SMath.pow(d2, 4.0d) * 4.0E-9d);
    }

    private double MoonPhase(double d, double d2, double d3) {
        return 180.0d - (SMath.acos(SMath.cos((d3 * 0.0174532925199433d) - (d2 * 0.0174532925199433d)) * SMath.cos((d * 0.0174532925199433d) + 0.016580627893946133d)) / 0.0174532925199433d);
    }

    private double Bm(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double[] dArr, int i, StringBuffer stringBuffer) {
        double d10;
        if (d3 > -0.26d) {
            double DistanceAngle = DistanceAngle(d * 0.0174532925199433d, d2 * 0.0174532925199433d, d3 * 0.0174532925199433d, d4 * 0.0174532925199433d) / 0.0174532925199433d;
            double d11 = d5;
            double d12 = d7;
            double d13 = d8;
            double d14 = d9;
            double[] dArr2 = dArr;
            int i2 = i;
            StringBuffer stringBuffer2 = stringBuffer;
            double Deltam = Deltam(d3, d11, d12, d13, d14, dArr2, i2, stringBuffer2);
            double Deltam2 = Deltam(d, d11, d12, d13, d14, dArr2, i2, stringBuffer2);
            double pow = SMath.pow(10.0d, Deltam * -0.4d);
            d10 = (((((6.2E7d / DistanceAngle) / DistanceAngle) + SMath.pow(10.0d, 6.15d - (DistanceAngle / 40.0d)) + (SMath.pow(10.0d, 5.36d) * (SMath.pow(SMath.cos(DistanceAngle * 0.0174532925199433d), 2.0d) + 1.06d))) * pow) + ((1.0d - pow) * 440000.0d)) * SMath.pow(10.0d, ((MoonsBrightness(MoonDistance, MoonPhase(d3, d4, d6)) - -11.05d) + 43.27d) * -0.4d) * (1.0d - SMath.pow(10.0d, Deltam2 * -0.4d));
        } else {
            d10 = 0.0d;
        }
        return SMath.max(d10, 0.0d) * erg2nL;
    }

    private double Btwi(double d, double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, int i, StringBuffer stringBuffer) {
        double d8 = d;
        int i2 = i;
        double AppAltfromTopoAlt = 90.0d - AppAltfromTopoAlt(d8, TempEfromTempS(dArr[1], d7, LapseSA), PresEfromPresS(dArr[1], dArr[0], d7), i2);
        double DistanceAngle = DistanceAngle(d * 0.0174532925199433d, d2 * 0.0174532925199433d, d3 * 0.0174532925199433d, d4 * 0.0174532925199433d) / 0.0174532925199433d;
        double Deltam = Deltam(d, d3, d5, d6, d7, dArr, i2, stringBuffer);
        return SMath.max(SMath.pow(10.0d, ((16.810000000000002d - d3) - (AppAltfromTopoAlt / (kt(d3, d5, d6, d7, dArr[1], dArr[2], dArr[3], 4, stringBuffer) * 360.0d))) * -0.4d) * (100.0d / DistanceAngle) * (1.0d - SMath.pow(10.0d, Deltam * -0.4d)), 0.0d) * erg2nL;
    }

    private double Bday(double d, double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, int i, StringBuffer stringBuffer) {
        double DistanceAngle = DistanceAngle(d * 0.0174532925199433d, d2 * 0.0174532925199433d, d3 * 0.0174532925199433d, d4 * 0.0174532925199433d) / 0.0174532925199433d;
        double Deltam = Deltam(d3, d3, d5, d6, d7, dArr, i, stringBuffer);
        double Deltam2 = Deltam(d, d3, d5, d6, d7, dArr, i, stringBuffer);
        double pow = SMath.pow(10.0d, Deltam * -0.4d);
        return SMath.max((((((6.2E7d / DistanceAngle) / DistanceAngle) + SMath.pow(10.0d, 6.15d - (DistanceAngle / 40.0d)) + (SMath.pow(10.0d, 5.36d) * (SMath.pow(SMath.cos(DistanceAngle * 0.0174532925199433d), 2.0d) + 1.06d))) * pow) + ((1.0d - pow) * 440000.0d)) * SMath.pow(10.0d, -11.032000000000004d) * (1.0d - SMath.pow(10.0d, Deltam2 * -0.4d)), 0.0d) * erg2nL;
    }

    private double Bcity(double d, double d2) {
        return SMath.max(d, 0.0d);
    }

    private double Bsky(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double[] dArr, int i, StringBuffer stringBuffer) {
        double d11;
        if (d6 < -3.0d) {
            d11 = Btwi(d, d2, d6, d7, d8, d9, d10, dArr, i, stringBuffer) + 0.0d;
        } else if (d6 > 4.0d) {
            d11 = Bday(d, d2, d6, d7, d8, d9, d10, dArr, i, stringBuffer) + 0.0d;
        } else {
            double d12 = d;
            double d13 = d2;
            double d14 = d6;
            double d15 = d7;
            double d16 = d8;
            double d17 = d9;
            double[] dArr2 = dArr;
            int i2 = i;
            StringBuffer stringBuffer2 = stringBuffer;
            d11 = SMath.min(Bday(d12, d13, d14, d15, d16, d17, d10, dArr2, i2, stringBuffer2), Btwi(d12, d13, d14, d15, d16, d17, d10, dArr2, i2, stringBuffer2)) + 0.0d;
        }
        if (d11 < 2.0E8d) {
            d11 += Bm(d, d2, d3, d4, d6, d7, d8, d9, d10, dArr, i, stringBuffer);
        }
        if (d6 <= 0.0d) {
            d11 += Bcity(0.0d, dArr[0]);
        }
        if (d11 < 5000.0d) {
            return d11 + Bn(d, d5, d6, d8, d9, d10, dArr, i, stringBuffer);
        }
        return d11;
    }

    private void default_heliacal_parameters(double[] dArr, double[] dArr2, double[] dArr3, int i) {
        if (dArr[0] <= 0.0d) {
            dArr[0] = SMath.pow(1.0d - ((dArr2[2] * LapseSA) / 288.0d), 5.255d) * 1013.25d;
            if (dArr[1] == 0.0d) {
                dArr[1] = 15.0d - (dArr2[2] * LapseSA);
            }
            if (dArr[2] == 0.0d) {
                dArr[2] = 40.0d;
            }
        }
        if (dArr3[0] == 0.0d) {
            dArr3[0] = 36.0d;
        }
        if (dArr3[1] == 0.0d) {
            dArr3[1] = 1.0d;
        }
        if ((i & 512) == 0) {
            for (int i2 = 2; i2 <= 5; i2++) {
                dArr3[i2] = 0.0d;
            }
        }
        if (dArr3[3] == 0.0d) {
            dArr3[2] = 1.0d;
            dArr3[3] = 1.0d;
        }
    }

    private double VisLimMagn(double[] dArr, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double[] dArr2, int i, int[] iArr, StringBuffer stringBuffer) {
        double d11;
        double d12;
        double Bsky = Bsky(d, d2, d3, d4, d5, d6, d7, d8, d9, d10, dArr2, i, stringBuffer);
        double d13 = Bsky;
        double Deltam = Deltam(d, d6, d8, d9, d10, dArr2, i, stringBuffer);
        double[] dArr3 = dArr;
        double d14 = d5;
        int i2 = i;
        double OpticFactor = OpticFactor(d13, Deltam, dArr3, d14, "", 1, i2);
        double OpticFactor2 = OpticFactor(d13, Deltam, dArr3, d14, "", 0, i2);
        if (Bsky >= BNIGHT || (i & 16384) != 0) {
            d12 = 4.4668359215096E-9d;
            d11 = 1.2589254117942E-6d;
            if (iArr != null) {
                iArr[0] = 0;
            }
        } else {
            d12 = 1.5848931924611E-10d;
            d11 = 0.012589254117942d;
            if (iArr != null) {
                iArr[0] = 1;
            }
        }
        if (iArr != null && BNIGHT > Bsky && BNIGHT < Bsky) {
            iArr[0] = iArr[0] | 2;
        }
        return -16.57d - ((SMath.log((d12 * SMath.pow(SMath.sqrt(d11 * (Bsky / OpticFactor)) + 1.0d, 2.0d)) * OpticFactor2) / 2.302585092994d) * 2.5d);
    }

    public int swe_vis_limit_mag(double d, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, double[] dArr4, StringBuffer stringBuffer2) {
        int i2;
        char c;
        double[] dArr5 = dArr;
        int i3 = i;
        StringBuffer stringBuffer3 = stringBuffer2;
        int[] iArr = {0};
        double[] dArr6 = new double[1];
        double[] dArr7 = new double[1];
        double[] dArr8 = new double[1];
        double[] dArr9 = new double[1];
        double[] dArr10 = new double[1];
        double SunRA = SunRA(d, i3, stringBuffer3);
        double[] dArr11 = new double[1];
        default_heliacal_parameters(dArr2, dArr5, dArr3, i3);
        this.sw.swe_set_topo(dArr5[0], dArr5[1], dArr5[2]);
        for (int i4 = 0; i4 < 7; i4++) {
            dArr4[i4] = 0.0d;
        }
        double[] dArr12 = dArr10;
        double[] dArr13 = dArr9;
        double[] dArr14 = dArr8;
        double[] dArr15 = dArr11;
        double[] dArr16 = dArr7;
        double[] dArr17 = dArr6;
        if (ObjectLoc(d, dArr, dArr2, stringBuffer, 0, i, dArr6, stringBuffer2) == -1) {
            return -1;
        }
        if (dArr17[0] < 0.0d && stringBuffer3 != null) {
            stringBuffer3.setLength(0);
            stringBuffer3.append("object is below local horizon");
            dArr4[0] = -100.0d;
            return -2;
        } else if (ObjectLoc(d, dArr, dArr2, stringBuffer, 1, i, dArr16, stringBuffer2) == -1) {
            return -1;
        } else {
            int i5 = i3 & 4096;
            if (i5 != 0) {
                dArr13[0] = -90.0d;
                dArr12[0] = 0.0d;
                i2 = i5;
            } else {
                i2 = i5;
                if (ObjectLoc(d, dArr, dArr2, "sun", 0, i, dArr13, stringBuffer2) == -1 || ObjectLoc(d, dArr, dArr2, "sun", 1, i, dArr12, stringBuffer2) == -1) {
                    return -1;
                }
            }
            if (stringBuffer.toString().startsWith("moon") || i2 != 0 || (i3 & 8192) != 0) {
                c = 0;
                dArr15[0] = -90.0d;
                dArr14[0] = 0.0d;
            } else if (ObjectLoc(d, dArr, dArr2, "moon", 0, i, dArr15, stringBuffer2) == -1 || ObjectLoc(d, dArr, dArr2, "moon", 1, i, dArr14, stringBuffer2) == -1) {
                return -1;
            } else {
                c = 0;
            }
            int[] iArr2 = iArr;
            dArr4[0] = VisLimMagn(dArr3, dArr17[c], dArr16[c], dArr15[c], dArr14[c], d, dArr13[c], dArr12[c], SunRA, dArr5[1], dArr5[2], dArr2, i, iArr2, stringBuffer2);
            dArr4[1] = dArr17[0];
            dArr4[2] = dArr16[0];
            dArr4[3] = dArr13[0];
            dArr4[4] = dArr12[0];
            dArr4[5] = dArr15[0];
            dArr4[6] = dArr14[0];
            if (Magnitude(d, dArr, stringBuffer, i, dArr4, 7, stringBuffer2) == -1) {
                return -1;
            }
            return iArr2[0];
        }
    }

    private int TopoArcVisionis(double d, double[] dArr, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double[] dArr2, int i, double[] dArr3, StringBuffer stringBuffer) {
        double d11;
        double d12 = 45.0d;
        double VisLimMagn = d - VisLimMagn(dArr, d2, d3, d4, d5, d6, d2 - 45.0d, d7, d8, d9, d10, dArr2, i, (int[]) null, stringBuffer);
        if ((d - VisLimMagn(dArr, d2, d3, d4, d5, d6, d2 - 0.0d, d7, d8, d9, d10, dArr2, i, (int[]) null, stringBuffer)) * VisLimMagn <= 0.0d) {
            double d13 = VisLimMagn;
            double d14 = 0.0d;
            while (SMath.abs(d14 - d12) > epsilon) {
                double d15 = (d14 + d12) / 2.0d;
                double VisLimMagn2 = d - VisLimMagn(dArr, d2, d3, d4, d5, d6, d2 - d15, d7, d8, d9, d10, dArr2, i, (int[]) null, stringBuffer);
                if (d13 * VisLimMagn2 > 0.0d) {
                    d13 = VisLimMagn2;
                    d12 = d15;
                } else {
                    d14 = d15;
                }
            }
            d11 = (d14 + d12) / 2.0d;
        } else {
            d11 = 99.0d;
        }
        if (d11 < d2) {
            d11 = d2;
        }
        dArr3[0] = d11;
        return 0;
    }

    public int swe_topo_arcus_visionis(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr4, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = stringBuffer;
        double SunRA = SunRA(d, i, stringBuffer2);
        if (stringBuffer2 != null && stringBuffer.length() > 0) {
            return -1;
        }
        return TopoArcVisionis(d2, dArr3, d4, d3, d7, d6, d, d5, SunRA, dArr[1], dArr[2], dArr2, i, dArr4, stringBuffer);
    }

    private int HeliacalAngle(double d, double[] dArr, double d2, double d3, double d4, double d5, double d6, double[] dArr2, double[] dArr3, int i, double[] dArr4, StringBuffer stringBuffer) {
        double[] dArr5 = new double[1];
        double[] dArr6 = new double[1];
        double[] dArr7 = new double[1];
        double[] dArr8 = new double[1];
        double[] dArr9 = new double[1];
        double SunRA = SunRA(d5, i, stringBuffer);
        double d7 = dArr2[1];
        double d8 = dArr2[2];
        double d9 = 0.0d;
        double d10 = 10000.0d;
        for (double d11 = 2.0d; d11 <= 20.0d; d11 += 1.0d) {
            if (TopoArcVisionis(d, dArr, d11, d2, d3, d4, d5, d6, SunRA, d7, d8, dArr3, i, dArr9, stringBuffer) == -1) {
                return -1;
            }
            if (dArr9[0] < d10) {
                d10 = dArr9[0];
                d9 = d11;
            }
        }
        double d12 = d9 - 1.0d;
        double d13 = d9 + 1.0d;
        double[] dArr10 = dArr8;
        double[] dArr11 = dArr6;
        double[] dArr12 = dArr7;
        double[] dArr13 = dArr5;
        if (TopoArcVisionis(d, dArr, d13, d2, d3, d4, d5, d6, SunRA, d7, d8, dArr3, i, dArr13, stringBuffer) == -1 || TopoArcVisionis(d, dArr, d12, d2, d3, d4, d5, d6, SunRA, d7, d8, dArr3, i, dArr11, stringBuffer) == -1) {
            return -1;
        }
        while (SMath.abs(d13 - d12) > 0.1d) {
            double d14 = (d13 + d12) / 2.0d;
            double d15 = 0.025d + d14;
            if (TopoArcVisionis(d, dArr, d14, d2, d3, d4, d5, d6, SunRA, d7, d8, dArr3, i, dArr12, stringBuffer) == -1 || TopoArcVisionis(d, dArr, d15, d2, d3, d4, d5, d6, SunRA, d7, d8, dArr3, i, dArr10, stringBuffer) == -1) {
                return -1;
            }
            if (dArr12[0] >= dArr10[0]) {
                dArr11[0] = dArr12[0];
                d12 = d14;
            } else {
                dArr13[0] = dArr12[0];
                d13 = d14;
            }
        }
        double d16 = (d13 + d12) / 2.0d;
        dArr12[0] = (dArr13[0] + dArr11[0]) / 2.0d;
        dArr4[1] = dArr12[0];
        dArr4[2] = d16 - dArr12[0];
        dArr4[0] = d16;
        return 0;
    }

    public int swe_heliacal_angle(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, double d2, double d3, double d4, double d5, double d6, double[] dArr4, StringBuffer stringBuffer) {
        return HeliacalAngle(d2, dArr3, d3, d6, d5, d, d4, dArr, dArr2, i, dArr4, stringBuffer);
    }

    private double WidthMoon(double d, double d2, double d3, double d4, double d5) {
        double d6 = d + d5;
        return 0.27245d * d5 * ((SMath.sin(d6 * 0.0174532925199433d) * SMath.sin(d5 * 0.0174532925199433d)) + 1.0d) * (1.0d - (SMath.cos((d3 - d6) * 0.0174532925199433d) * SMath.cos((d4 - d2) * 0.0174532925199433d)));
    }

    private double LengthMoon(double d, double d2) {
        if (d2 == 0.0d) {
            d2 = 0.5180333333333333d;
        }
        double d3 = d * M2S;
        double d4 = d2 * M2S;
        return (d4 - ((((d4 + d3) * 0.3d) / 2.0d) / d3)) / M2S;
    }

    private double qYallop(double d, double d2) {
        double d3 = d * M2S;
        return (d2 - (((11.8371d - (6.3226d * d3)) + ((0.7319d * d3) * d3)) - (((0.1018d * d3) * d3) * d3))) / 10.0d;
    }

    private double crossing(double d, double d2, double d3, double d4) {
        return (d3 - d) / ((d2 - d) - (d4 - d3));
    }

    private int DeterTAV(double[] dArr, double d, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, double[] dArr4, StringBuffer stringBuffer2) {
        double[] dArr5 = new double[1];
        double[] dArr6 = new double[1];
        double[] dArr7 = new double[1];
        double[] dArr8 = new double[1];
        double[] dArr9 = new double[1];
        double[] dArr10 = new double[1];
        int i2 = i;
        double SunRA = SunRA(d, i2, stringBuffer2);
        if (Magnitude(d, dArr2, stringBuffer, i2, dArr5, 0, stringBuffer2) == -1) {
            return -1;
        }
        double[] dArr11 = dArr10;
        if (ObjectLoc(d, dArr2, dArr3, stringBuffer, 0, i, dArr6, stringBuffer2) == -1 || ObjectLoc(d, dArr2, dArr3, stringBuffer, 1, i, dArr8, stringBuffer2) == -1) {
            return -1;
        }
        if (stringBuffer.toString().startsWith("moon")) {
            dArr11[0] = -90.0d;
            dArr9[0] = 0.0d;
        } else if (ObjectLoc(d, dArr2, dArr3, "moon", 0, i, dArr11, stringBuffer2) == -1 || ObjectLoc(d, dArr2, dArr3, "moon", 1, i, dArr9, stringBuffer2) == -1) {
            return -1;
        }
        if (ObjectLoc(d, dArr2, dArr3, "sun", 1, i, dArr7, stringBuffer2) == -1) {
            return -1;
        }
        if (TopoArcVisionis(dArr5[0], dArr, dArr6[0], dArr8[0], dArr11[0], dArr9[0], d, dArr7[0], SunRA, dArr2[1], dArr2[2], dArr3, i, dArr4, stringBuffer2) == -1) {
            return -1;
        }
        return 0;
    }

    private double x2min(double d, double d2, double d3) {
        double d4 = (d + d3) - (d2 * 2.0d);
        if (d4 == 0.0d) {
            return 0.0d;
        }
        return ((-(d - d3)) / 2.0d) / d4;
    }

    private double funct2(double d, double d2, double d3, double d4) {
        return ((((d + d3) - (d2 * 2.0d)) / 2.0d) * d4 * d4) + (((d - d3) / 2.0d) * d4) + d2;
    }

    private void strcpy_VBsafe(StringBuffer stringBuffer, String str) {
        stringBuffer.setLength(0);
        for (int i = 0; i < Math.min(str.length(), 30); i++) {
            stringBuffer.append(str.charAt(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02d7, code lost:
        if (r10 == 4) goto L_0x02db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0514  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0520  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x038f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0391  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_heliacal_pheno_ut(double r107, double[] r109, double[] r110, double[] r111, java.lang.StringBuffer r112, int r113, int r114, double[] r115, java.lang.StringBuffer r116) {
        /*
            r106 = this;
            r15 = r106
            r13 = r107
            r11 = r109
            r12 = r110
            r10 = r113
            r9 = r114
            r8 = 1
            double[] r7 = new double[r8]
            double[] r6 = new double[r8]
            double[] r5 = new double[r8]
            double[] r4 = new double[r8]
            double[] r3 = new double[r8]
            double[] r1 = new double[r8]
            double[] r2 = new double[r8]
            double[] r0 = new double[r8]
            r16 = r6
            double[] r6 = new double[r8]
            r17 = r6
            double[] r6 = new double[r8]
            r18 = r6
            double[] r6 = new double[r8]
            r8 = 30
            double[] r8 = new double[r8]
            r20 = r0
            r21 = r6
            r0 = 1
            double[] r6 = new double[r0]
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r22 = r6
            r6 = r116
            double r23 = r15.SunRA(r13, r9, r6)
            r25 = r9 & 6
            r26 = r1
            java.lang.String r1 = r112.toString()
            r15.strcpy_VBsafe(r0, r1)
            r1 = r111
            r15.default_heliacal_parameters(r12, r11, r1, r9)
            r34 = r0
            swisseph.SwissEph r0 = r15.sw
            r50 = 0
            r28 = r11[r50]
            r19 = 1
            r30 = r11[r19]
            r6 = 2
            r32 = r11[r6]
            r27 = r0
            r27.swe_set_topo(r28, r30, r32)
            java.lang.String r27 = "sun"
            r28 = 1
            r51 = r20
            r112 = r34
            r0 = r106
            r53 = r2
            r52 = r26
            r1 = r107
            r54 = r3
            r3 = r109
            r55 = r4
            r4 = r110
            r56 = r5
            r5 = r27
            r57 = r16
            r58 = r17
            r59 = r18
            r60 = r21
            r61 = r22
            r13 = 2
            r6 = r28
            r62 = r7
            r7 = r114
            r16 = r8
            r14 = 1
            r8 = r62
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.String) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
            if (r0 != 0) goto L_0x00b8
            r6 = 0
            java.lang.String r5 = "sun"
            r0 = r106
            r1 = r107
            r3 = r109
            r4 = r110
            r7 = r114
            r8 = r57
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.String) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
        L_0x00b8:
            if (r0 != 0) goto L_0x00cf
            r6 = 1
            r0 = r106
            r1 = r107
            r3 = r109
            r4 = r110
            r5 = r112
            r7 = r114
            r8 = r55
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.StringBuffer) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
        L_0x00cf:
            if (r0 != 0) goto L_0x00e6
            r6 = 0
            r0 = r106
            r1 = r107
            r3 = r109
            r4 = r110
            r5 = r112
            r7 = r114
            r8 = r54
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.StringBuffer) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
        L_0x00e6:
            if (r0 != 0) goto L_0x00fd
            r6 = 7
            r0 = r106
            r1 = r107
            r3 = r109
            r4 = r110
            r5 = r112
            r7 = r114
            r8 = r53
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.StringBuffer) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
        L_0x00fd:
            r9 = -1
            if (r0 != r9) goto L_0x0101
            return r9
        L_0x0101:
            r1 = r54[r50]
            r3 = r12[r14]
            r5 = r12[r50]
            r0 = r106
            r7 = r114
            double r63 = r0.AppAltfromTopoAlt(r1, r3, r5, r7)
            r0 = r62[r50]
            r2 = r55[r50]
            double r65 = r0 - r2
            r0 = r54[r50]
            r2 = r57[r50]
            double r67 = r0 - r2
            r0 = r53[r50]
            r2 = r54[r50]
            double r69 = r0 - r2
            r7 = 0
            r0 = r106
            r1 = r107
            r3 = r109
            r4 = r112
            r5 = r114
            r6 = r51
            r8 = r116
            int r0 = r0.Magnitude(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r9) goto L_0x0137
            return r9
        L_0x0137:
            double r7 = r67 + r69
            r0 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r2 = r7 * r0
            double r2 = swisseph.SMath.cos(r2)
            double r4 = r65 * r0
            double r4 = swisseph.SMath.cos(r4)
            double r2 = r2 * r4
            double r2 = swisseph.SMath.acos(r2)
            double r71 = r2 / r0
            r6 = r112
            int r5 = r15.DeterObject((java.lang.StringBuffer) r6)
            r17 = 4636737291354636288(0x4059000000000000, double:100.0)
            if (r5 != r9) goto L_0x0166
            r73 = r5
            r74 = r6
            r77 = r17
            r75 = r71
            goto L_0x0189
        L_0x0166:
            swisseph.SwissEph r0 = r15.sw
            r1 = 34816(0x8800, float:4.8788E-41)
            r4 = r25 | r1
            r1 = r107
            r3 = r5
            r73 = r5
            r5 = r16
            r74 = r6
            r6 = r116
            int r0 = r0.swe_pheno_ut(r1, r3, r4, r5, r6)
            if (r0 != r9) goto L_0x017f
            return r9
        L_0x017f:
            r0 = r16[r13]
            r2 = r16[r14]
            double r2 = r2 * r17
            r75 = r0
            r77 = r2
        L_0x0189:
            r1 = r57[r50]
            r5 = r11[r14]
            r3 = r11[r13]
            r79 = r7
            r7 = r3
            r3 = r12[r14]
            r0 = r10
            r9 = r3
            r3 = r12[r13]
            r11 = r3
            r3 = 3
            r16 = r110[r3]
            r4 = 2
            r13 = r16
            r16 = 4
            r15 = r16
            r0 = r106
            r3 = r23
            r16 = r116
            double r82 = r0.kt(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r84 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r9 = 0
            r15 = r73
            r7 = 1
            if (r15 != r7) goto L_0x023c
            r1 = r54[r50]
            r3 = r55[r50]
            r5 = r57[r50]
            r16 = r62[r50]
            r0 = r106
            r11 = 1
            r7 = r16
            r13 = r9
            r9 = r69
            double r0 = r0.WidthMoon(r1, r3, r5, r7, r9)
            r12 = r106
            double r2 = r12.LengthMoon(r0, r13)
            r9 = r79
            double r4 = r12.qYallop(r0, r9)
            r6 = 4596950240446631641(0x3fcba5e353f7ced9, double:0.216)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01e6
            r20 = r84
            goto L_0x01e8
        L_0x01e6:
            r20 = r13
        L_0x01e8:
            r22 = -4644147964541474439(0xbf8cac083126e979, double:-0.014)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x01f7
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x01f7
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
        L_0x01f7:
            r6 = -4628439409041206149(0xbfc47ae147ae147b, double:-0.16)
            int r8 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r8 >= 0) goto L_0x0206
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0206
            r20 = 4613937818241073152(0x4008000000000000, double:3.0)
        L_0x0206:
            r22 = -4625845335655840743(0xbfcdb22d0e560419, double:-0.232)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0215
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x0215
            r20 = 4616189618054758400(0x4010000000000000, double:4.0)
        L_0x0215:
            r6 = -4624422198173591667(0xbfd2c083126e978d, double:-0.293)
            int r8 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r8 >= 0) goto L_0x0224
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0224
            r20 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x0224:
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0233
            r6 = 4618441417868443648(0x4018000000000000, double:6.0)
            r79 = r0
            r90 = r2
            r86 = r4
            r88 = r6
            goto L_0x024a
        L_0x0233:
            r79 = r0
            r90 = r2
            r86 = r4
            r88 = r20
            goto L_0x024a
        L_0x023c:
            r12 = r106
            r13 = r9
            r9 = r79
            r11 = 1
            r79 = r13
            r86 = r79
            r88 = r86
            r90 = r88
        L_0x024a:
            r8 = 4
            r7 = r113
            if (r7 == r11) goto L_0x0255
            if (r7 != r8) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r6 = 2
            goto L_0x0256
        L_0x0255:
            r6 = 1
        L_0x0256:
            r92 = 4595172819793696085(0x3fc5555555555555, double:0.16666666666666666)
            double r20 = r107 - r92
            r22 = 0
            java.lang.String r5 = "sun"
            r0 = r106
            r1 = r20
            r3 = r109
            r4 = r110
            r107 = r6
            r7 = r114
            r8 = r22
            r94 = r9
            r9 = r59
            r10 = r116
            int r0 = r0.RiseSet(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r10 = -1
            if (r0 != r10) goto L_0x027d
            return r10
        L_0x027d:
            java.lang.String r5 = r74.toString()
            r8 = 0
            r0 = r106
            r1 = r20
            r3 = r109
            r4 = r110
            r6 = r107
            r7 = r114
            r9 = r58
            r11 = -1
            r10 = r116
            int r0 = r0.RiseSet(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r11) goto L_0x029a
            return r11
        L_0x029a:
            r1 = -2
            r96 = 4726483295817170944(0x4197d783fc000000, double:9.9999999E7)
            if (r0 != r1) goto L_0x02ac
            r100 = r13
            r98 = r96
            r9 = 1
            r81 = 1
            goto L_0x02d1
        L_0x02ac:
            r0 = r58[r50]
            r2 = r59[r50]
            double r0 = r0 - r2
            r9 = 1
            if (r15 != r9) goto L_0x02cb
            r2 = r58[r50]
            r4 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r2 = r2 * r4
            r4 = r59[r50]
            r6 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r4 = r4 * r6
            double r2 = r2 + r4
            r4 = 4621256167635550208(0x4022000000000000, double:9.0)
            double r2 = r2 / r4
            r100 = r0
            r98 = r2
            r81 = 0
            goto L_0x02d1
        L_0x02cb:
            r100 = r0
            r98 = r96
            r81 = 0
        L_0x02d1:
            r10 = r113
            r8 = 3
            if (r10 == r8) goto L_0x02da
            r7 = 4
            if (r10 != r7) goto L_0x02e0
            goto L_0x02db
        L_0x02da:
            r7 = 4
        L_0x02db:
            if (r15 == r11) goto L_0x02e3
            if (r15 < r7) goto L_0x02e0
            goto L_0x02e3
        L_0x02e0:
            r102 = r13
            goto L_0x0330
        L_0x02e3:
            r21 = 4726483295817170944(0x4197d783fc000000, double:9.9999999E7)
            r23 = 4726483295817170944(0x4197d783fc000000, double:9.9999999E7)
            r25 = 4726483295817170944(0x4197d783fc000000, double:9.9999999E7)
            r42 = 0
            r19 = 0
            r0 = r106
            r1 = r115
            r2 = r54
            r3 = r63
            r5 = r53
            r6 = r55
            r15 = 4
            r7 = r57
            r8 = r62
            r16 = 1
            r9 = r67
            r11 = r94
            r102 = r13
            r13 = r65
            r15 = r71
            r17 = r82
            r27 = r98
            r29 = r79
            r31 = r86
            r33 = r88
            r35 = r69
            r37 = r51
            r38 = r58
            r39 = r59
            r40 = r100
            r44 = r90
            r46 = r75
            r48 = r77
            r0.goto_output_heliacal_pheno(r1, r2, r3, r5, r6, r7, r8, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40, r42, r44, r46, r48)
        L_0x0330:
            r0 = 4641205706609917952(0x4068e00000000000, double:199.0)
            r60[r50] = r0
            r0 = -4663827694113166314(0xbf46c16c16c16c16, double:-6.944444444444444E-4)
            r11 = r107
            r10 = 2
            if (r11 != r10) goto L_0x034b
            r0 = 4559544342741609494(0x3f46c16c16c16c16, double:6.944444444444444E-4)
        L_0x034b:
            r12 = r0
            r0 = r59[r50]
            double r0 = r0 - r12
            r14 = r102
            r16 = r14
            r18 = r16
            r20 = r18
            r22 = r20
            r24 = r22
        L_0x035b:
            double r26 = r0 + r12
            r28 = r60[r50]
            r6 = 0
            java.lang.String r5 = "sun"
            r0 = r106
            r1 = r26
            r3 = r109
            r4 = r110
            r7 = r114
            r8 = r56
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.String) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
            if (r0 != 0) goto L_0x038d
            r6 = 0
            r0 = r106
            r1 = r26
            r3 = r109
            r4 = r110
            r5 = r74
            r7 = r114
            r8 = r52
            r9 = r116
            int r0 = r0.ObjectLoc((double) r1, (double[]) r3, (double[]) r4, (java.lang.StringBuffer) r5, (int) r6, (int) r7, (double[]) r8, (java.lang.StringBuffer) r9)
        L_0x038d:
            if (r0 == 0) goto L_0x0391
            r9 = -1
            return r9
        L_0x0391:
            r9 = -1
            r0 = r52[r50]
            r2 = r56[r50]
            double r30 = r0 - r2
            r0 = r106
            r1 = r111
            r2 = r26
            r4 = r109
            r5 = r110
            r6 = r74
            r7 = r114
            r8 = r60
            r10 = -1
            r9 = r116
            int r0 = r0.DeterTAV(r1, r2, r4, r5, r6, r7, r8, r9)
            if (r0 != r10) goto L_0x03b2
            return r10
        L_0x03b2:
            r0 = r60[r50]
            int r2 = (r28 > r0 ? 1 : (r28 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0423
            int r0 = (r18 > r102 ? 1 : (r18 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0423
            r9 = r106
            int r0 = r9.Sgn(r12)
            int r0 = r0 * 8
            double r0 = (double) r0
            r2 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r0 = r0 / r2
            r2 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r0 = r0 / r2
            double r0 = r26 + r0
            r2 = r58[r50]
            int r4 = (r2 > r102 ? 1 : (r2 == r102 ? 0 : -1))
            if (r4 == 0) goto L_0x03e7
            int r2 = (r12 > r102 ? 1 : (r12 == r102 ? 0 : -1))
            if (r2 <= 0) goto L_0x03df
            r2 = r58[r50]
            double r0 = swisseph.SMath.min((double) r0, (double) r2)
            r2 = r0
            goto L_0x03e8
        L_0x03df:
            r2 = r58[r50]
            double r0 = swisseph.SMath.max((double) r0, (double) r2)
            r2 = r0
            goto L_0x03e8
        L_0x03e7:
            r2 = r0
        L_0x03e8:
            r0 = r106
            r1 = r111
            r4 = r109
            r5 = r110
            r6 = r74
            r7 = r114
            r8 = r61
            r9 = r116
            int r0 = r0.DeterTAV(r1, r2, r4, r5, r6, r7, r8, r9)
            if (r0 != r10) goto L_0x03ff
            return r10
        L_0x03ff:
            r0 = r61[r50]
            r2 = r60[r50]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0423
            r1 = r60[r50]
            r0 = r106
            r3 = r28
            r5 = r16
            double r7 = r0.x2min(r1, r3, r5)
            double r0 = r84 - r7
            double r0 = r0 * r12
            double r18 = r26 - r0
            r1 = r60[r50]
            r0 = r106
            double r0 = r0.funct2(r1, r3, r5, r7)
            r24 = r0
        L_0x0423:
            r0 = r60[r50]
            int r2 = (r30 > r0 ? 1 : (r30 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0446
            int r0 = (r22 > r102 ? 1 : (r22 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0446
            int r0 = (r18 > r102 ? 1 : (r18 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0446
            r7 = r60[r50]
            r0 = r106
            r1 = r14
            r3 = r30
            r5 = r28
            double r0 = r0.crossing(r1, r3, r5, r7)
            double r0 = r84 - r0
            double r0 = r0 * r12
            double r0 = r26 - r0
            r22 = r0
        L_0x0446:
            r0 = r60[r50]
            int r2 = (r30 > r0 ? 1 : (r30 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0469
            int r0 = (r20 > r102 ? 1 : (r20 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0469
            int r0 = (r22 > r102 ? 1 : (r22 == r102 ? 0 : -1))
            if (r0 == 0) goto L_0x0469
            r7 = r60[r50]
            r0 = r106
            r1 = r14
            r3 = r30
            r5 = r28
            double r0 = r0.crossing(r1, r3, r5, r7)
            double r0 = r84 - r0
            double r0 = r0 * r12
            double r0 = r26 - r0
            r20 = r0
        L_0x0469:
            r0 = r59[r50]
            double r0 = r26 - r0
            double r0 = swisseph.SMath.abs((double) r0)
            int r2 = (r0 > r92 ? 1 : (r0 == r92 ? 0 : -1))
            if (r2 > 0) goto L_0x04b9
            int r0 = (r20 > r102 ? 1 : (r20 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x04b9
            int r0 = (r18 > r102 ? 1 : (r18 == r102 ? 0 : -1))
            if (r0 == 0) goto L_0x04ac
            r0 = r113
            r1 = 3
            if (r0 == r1) goto L_0x0486
            r2 = 4
            if (r0 != r2) goto L_0x04b0
            goto L_0x0487
        L_0x0486:
            r2 = 4
        L_0x0487:
            java.lang.String r3 = r74.toString()
            java.lang.String r4 = "moon"
            boolean r3 = r3.startsWith(r4)
            if (r3 != 0) goto L_0x04b0
            java.lang.String r3 = r74.toString()
            java.lang.String r4 = "venus"
            boolean r3 = r3.startsWith(r4)
            if (r3 != 0) goto L_0x04b0
            java.lang.String r3 = r74.toString()
            java.lang.String r4 = "mercury"
            boolean r3 = r3.startsWith(r4)
            if (r3 != 0) goto L_0x04b0
            goto L_0x04b9
        L_0x04ac:
            r0 = r113
            r1 = 3
            r2 = 4
        L_0x04b0:
            r0 = r26
            r16 = r28
            r14 = r30
            r10 = 2
            goto L_0x035b
        L_0x04b9:
            r0 = 2
            if (r11 != r0) goto L_0x04be
            goto L_0x04c5
        L_0x04be:
            r104 = r20
            r20 = r22
            r22 = r104
        L_0x04c5:
            int r0 = (r22 > r102 ? 1 : (r22 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x04e3
            int r0 = (r20 > r102 ? 1 : (r20 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x04e3
            r0 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r2 = 1
            if (r11 != r2) goto L_0x04dc
            double r22 = r18 - r0
            r0 = r20
            r3 = r22
            goto L_0x04e8
        L_0x04dc:
            double r20 = r18 + r0
            r0 = r20
            r3 = r22
            goto L_0x04e8
        L_0x04e3:
            r2 = 1
            r0 = r20
            r3 = r22
        L_0x04e8:
            if (r81 != 0) goto L_0x04f9
            if (r11 != r2) goto L_0x04f3
            r5 = r58[r50]
            double r3 = swisseph.SMath.max((double) r3, (double) r5)
            goto L_0x04f9
        L_0x04f3:
            r5 = r58[r50]
            double r0 = swisseph.SMath.min((double) r0, (double) r5)
        L_0x04f9:
            int r2 = (r0 > r102 ? 1 : (r0 == r102 ? 0 : -1))
            if (r2 == 0) goto L_0x0507
            int r5 = (r3 > r102 ? 1 : (r3 == r102 ? 0 : -1))
            if (r5 == 0) goto L_0x0507
            double r5 = r0 - r3
            r42 = r5
            goto L_0x0509
        L_0x0507:
            r42 = r96
        L_0x0509:
            if (r2 != 0) goto L_0x050e
            r26 = r96
            goto L_0x0510
        L_0x050e:
            r26 = r0
        L_0x0510:
            int r0 = (r18 > r102 ? 1 : (r18 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0517
            r28 = r96
            goto L_0x0519
        L_0x0517:
            r28 = r18
        L_0x0519:
            int r0 = (r3 > r102 ? 1 : (r3 == r102 ? 0 : -1))
            if (r0 != 0) goto L_0x0520
            r21 = r96
            goto L_0x0522
        L_0x0520:
            r21 = r3
        L_0x0522:
            r0 = r106
            r1 = r115
            r2 = r54
            r3 = r63
            r5 = r53
            r6 = r55
            r7 = r57
            r8 = r62
            r9 = r67
            r11 = r94
            r13 = r65
            r15 = r71
            r17 = r82
            r19 = r24
            r23 = r28
            r25 = r26
            r27 = r98
            r29 = r79
            r31 = r86
            r33 = r88
            r35 = r69
            r37 = r51
            r38 = r58
            r39 = r59
            r40 = r100
            r44 = r90
            r46 = r75
            r48 = r77
            r0.goto_output_heliacal_pheno(r1, r2, r3, r5, r6, r7, r8, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40, r42, r44, r46, r48)
            return r50
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.swe_heliacal_pheno_ut(double, double[], double[], double[], java.lang.StringBuffer, int, int, double[], java.lang.StringBuffer):int");
    }

    private void goto_output_heliacal_pheno(double[] dArr, double[] dArr2, double d, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr7, double[] dArr8, double[] dArr9, double d16, double d17, double d18, double d19, double d20) {
        dArr[0] = dArr2[0];
        dArr[1] = d;
        dArr[2] = dArr3[0];
        dArr[3] = dArr4[0];
        dArr[4] = dArr5[0];
        dArr[5] = dArr6[0];
        dArr[6] = d2;
        dArr[7] = d3;
        dArr[8] = d4;
        dArr[9] = d5;
        dArr[10] = d6;
        dArr[11] = d7;
        dArr[12] = d8;
        dArr[13] = d9;
        dArr[14] = d10;
        dArr[15] = d11;
        dArr[16] = d12;
        dArr[17] = d13;
        dArr[18] = d14;
        dArr[19] = d15;
        dArr[20] = dArr7[0];
        dArr[21] = dArr8[0];
        dArr[22] = dArr9[0];
        dArr[23] = d16;
        dArr[24] = d17;
        dArr[25] = d18;
        dArr[26] = d19;
        dArr[27] = d20;
    }

    private double get_synodic_period(int i) {
        switch (i) {
            case 1:
                return 29.530588853d;
            case 2:
                return 115.8775d;
            case 3:
                return 583.9214d;
            case 4:
                return 779.9361d;
            case 5:
                return 398.884d;
            case 6:
                return 378.0919d;
            case 7:
                return 369.656d;
            case 8:
                return 367.4867d;
            case 9:
                return 366.7207d;
            default:
                return 366.0d;
        }
    }

    private int moon_event_arc_vis(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, double[] dArr4, StringBuffer stringBuffer) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        double d2;
        double[] dArr5;
        double d3;
        boolean z;
        double[] dArr6;
        double[] dArr7;
        double d4;
        double d5;
        double d6;
        double d7;
        int i8 = i;
        int i9 = i2;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr8 = new double[20];
        double[] dArr9 = new double[1];
        double[] dArr10 = new double[1];
        double[] dArr11 = new double[1];
        double[] dArr12 = new double[1];
        double[] dArr13 = new double[1];
        StringBuffer stringBuffer3 = new StringBuffer();
        int i10 = 491520 & i9;
        int i11 = i9 & 6;
        dArr4[0] = d;
        if (i10 == 0) {
            i10 = 32768;
        }
        if (i10 != 32768) {
            if (stringBuffer2 != null) {
                stringBuffer2.setLength(0);
                stringBuffer2.append("error: in valid AV kind for the moon");
            }
            return -1;
        }
        if (i8 == 1) {
            i4 = -1;
            i3 = 0;
        } else if (i8 == 2) {
            i4 = -1;
            i3 = 0;
        } else {
            stringBuffer3.append("moon");
            int i12 = i11 | 34816;
            if ((i9 & 256) == 0) {
                i5 = i12 | 80;
            } else {
                i5 = i12;
            }
            if (i8 == 3) {
                i7 = 1;
                i6 = 2;
            } else {
                i7 = -1;
                i6 = 1;
            }
            double d8 = i6 == 1 ? d + 30.0d : d;
            int i13 = i7;
            int i14 = i6;
            StringBuffer stringBuffer4 = stringBuffer3;
            double[] dArr14 = dArr13;
            this.sw.swe_pheno_ut(d8, 1, i5, dArr8, stringBuffer);
            boolean z2 = false;
            double d9 = d8;
            double d10 = dArr8[0];
            while (true) {
                double d11 = (double) i13;
                d2 = d9 + d11;
                int i15 = i13;
                dArr5 = dArr12;
                d3 = d11;
                this.sw.swe_pheno_ut(d2, 1, i5, dArr8, stringBuffer);
                double d12 = dArr8[0];
                int i16 = (d12 > d10 ? 1 : (d12 == d10 ? 0 : -1));
                if (i16 > 0) {
                    z = true;
                } else {
                    z = z2;
                }
                if (!z) {
                    dArr6 = dArr11;
                    dArr7 = dArr5;
                } else if (!z || i16 <= 0) {
                    double d13 = d2 - d3;
                    double d14 = d13 - d3;
                    double d15 = 90.0d;
                    double d16 = 199.0d;
                } else {
                    dArr6 = dArr11;
                    dArr7 = dArr5;
                }
                i13 = i15;
                int i17 = i2;
                d10 = d12;
                dArr12 = dArr7;
                dArr11 = dArr6;
                d9 = d2;
                z2 = z;
            }
            double d132 = d2 - d3;
            double d142 = d132 - d3;
            double d152 = 90.0d;
            double d162 = 199.0d;
            while (true) {
                d4 = d142 + d3;
                double d17 = d3;
                double[] dArr15 = dArr5;
                double[] dArr16 = dArr11;
                int RiseSet = RiseSet(d4, dArr, dArr2, stringBuffer4.toString(), i14, i2, 0, dArr10, stringBuffer);
                if (RiseSet != 0) {
                    return RiseSet;
                }
                double d18 = dArr10[0];
                dArr9[0] = 199.0d;
                double d19 = dArr9[0];
                while (true) {
                    d5 = dArr9[0];
                    double d20 = d17;
                    dArr10[0] = dArr10[0] - (((double) Sgn(d20)) * 6.944444444444445E-4d);
                    double d21 = d20;
                    if (ObjectLoc(dArr10[0], dArr, dArr2, "sun", 0, i2, dArr15, stringBuffer) == -1) {
                        return -1;
                    }
                    if (ObjectLoc(dArr10[0], dArr, dArr2, stringBuffer4, 0, i2, dArr14, stringBuffer) == -1) {
                        return -1;
                    }
                    d6 = dArr14[0] - dArr15[0];
                    if (DeterTAV(dArr3, dArr10[0], dArr, dArr2, stringBuffer4, i2, dArr9, stringBuffer) == -1) {
                        return -1;
                    }
                    double d22 = d21;
                    d7 = d22;
                    if (DeterTAV(dArr3, dArr10[0] - (((double) Sgn(d22)) * 0.005555555555555556d), dArr, dArr2, stringBuffer4, i2, dArr16, stringBuffer) == -1) {
                        return -1;
                    }
                    if ((dArr9[0] <= d5 || dArr16[0] < dArr9[0]) && SMath.abs(dArr10[0] - d18) < 0.08333333333333333d) {
                        d152 = d6;
                        d162 = d5;
                        d17 = d7;
                    }
                }
                if (d152 < d5 && SMath.abs(d4 - d132) < 15.0d) {
                    dArr5 = dArr15;
                    dArr11 = dArr16;
                    d142 = d4;
                    d152 = d6;
                    d162 = d5;
                    d3 = d7;
                }
            }
            if (SMath.abs(d4 - d132) < 15.0d) {
                dArr10[0] = dArr10[0] + ((((1.0d - x2min(dArr9[0], d5, d162)) * ((double) Sgn(d7))) / M2S) / D2H);
                dArr4[0] = dArr10[0];
                return 0;
            }
            stringBuffer2.setLength(0);
            stringBuffer2.append("no date found for lunar event");
            return -1;
        }
        if (stringBuffer2 != null) {
            stringBuffer2.setLength(i3);
            stringBuffer2.append("error: the moon has no morning first or evening last");
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b0, code lost:
        if (r14 == 3) goto L_0x01b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int heliacal_ut_arc_vis(double r78, double[] r80, double[] r81, double[] r82, java.lang.StringBuffer r83, int r84, int r85, double[] r86, java.lang.StringBuffer r87) {
        /*
            r77 = this;
            r15 = r77
            r14 = r84
            r12 = r85
            r13 = r87
            r9 = 6
            double[] r11 = new double[r9]
            r10 = 2
            double[] r8 = new double[r10]
            double[] r7 = new double[r10]
            r6 = 3
            double[] r5 = new double[r6]
            r4 = 1
            double[] r3 = new double[r4]
            r1 = 0
            r19 = 0
            r3[r1] = r19
            double[] r2 = new double[r4]
            double[] r0 = new double[r4]
            double[] r9 = new double[r4]
            double[] r10 = new double[r4]
            r18 = r7
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            r86[r1] = r78
            r21 = r7
            r7 = r83
            int r4 = r15.DeterObject((java.lang.StringBuffer) r7)
            r23 = r81[r1]
            r22 = 1
            r25 = r81[r22]
            r27 = 0
            r28 = r0
            r0 = r77
            r29 = r2
            r1 = r78
            r31 = r3
            r3 = r80
            r32 = r4
            r4 = r83
            r33 = r5
            r5 = r85
            r34 = r11
            r11 = 3
            r6 = r31
            r35 = r21
            r21 = r18
            r7 = r27
            r27 = r8
            r8 = r35
            int r0 = r0.Magnitude(r1, r3, r4, r5, r6, r7, r8)
            r8 = -1
            if (r0 != r8) goto L_0x006f
            r7 = r35
            int r0 = r15.goto_swe_heliacal_err1(r7, r13, r0)
            return r0
        L_0x006f:
            r7 = r35
            r0 = r12 & 6
            r1 = 34816(0x8800, float:4.8788E-41)
            r0 = r0 | r1
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0080
            r0 = r0 | 80
            r35 = r0
            goto L_0x0082
        L_0x0080:
            r35 = r0
        L_0x0082:
            r0 = 4643211215818981376(0x4070000000000000, double:256.0)
            r4 = 4
            r5 = 4634204016564240384(0x4050000000000000, double:64.0)
            r36 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3 = r32
            r2 = 2
            if (r3 == r2) goto L_0x00b6
            if (r3 == r11) goto L_0x00b2
            if (r3 == r4) goto L_0x00a8
            r2 = 5
            if (r3 == r2) goto L_0x00a4
            r2 = 6
            if (r3 == r2) goto L_0x009e
            r75 = r0
            r0 = r5
            r5 = r75
            goto L_0x00bb
        L_0x009e:
            r75 = r0
            r0 = r5
            r5 = r75
            goto L_0x00bb
        L_0x00a4:
            r0 = r5
            r5 = 4645463015632666624(0x4078000000000000, double:384.0)
            goto L_0x00bb
        L_0x00a8:
            r5 = 4638707616191610880(0x4060000000000000, double:128.0)
            r0 = 4648840715353194496(0x4084000000000000, double:640.0)
            r75 = r0
            r0 = r5
            r5 = r75
            goto L_0x00bb
        L_0x00b2:
            r0 = r5
            r5 = 4645463015632666624(0x4078000000000000, double:384.0)
            goto L_0x00bb
        L_0x00b6:
            r0 = 4636737291354636288(0x4059000000000000, double:100.0)
            r5 = r0
            r0 = r36
        L_0x00bb:
            r2 = 2
            if (r14 != r2) goto L_0x00c0
            double r0 = -r0
        L_0x00c0:
            if (r14 != r4) goto L_0x00c6
            double r0 = -r0
            r4 = 1
            goto L_0x00c7
        L_0x00c6:
            r4 = r14
        L_0x00c7:
            if (r4 != r11) goto L_0x00ca
            r4 = 2
        L_0x00ca:
            r4 = r4 | 256(0x100, float:3.59E-43)
            double r16 = r78 + r5
            double r38 = r78 - r36
            int r18 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r18 >= 0) goto L_0x00dc
            r40 = r38
            r38 = r16
            goto L_0x00de
        L_0x00dc:
            r40 = r16
        L_0x00de:
            double r16 = r38 - r0
            r42 = 4641205706609917952(0x4068e00000000000, double:199.0)
            r44 = -4605437273944411341(0xc016333333333333, double:-5.55)
            r17 = r16
            r16 = 0
        L_0x00ef:
            double r46 = swisseph.SMath.abs((double) r0)
            int r32 = (r46 > r36 ? 1 : (r46 == r36 ? 0 : -1))
            if (r32 != 0) goto L_0x00fa
            r32 = 1
            goto L_0x00fc
        L_0x00fa:
            r32 = r16
        L_0x00fc:
            r75 = r17
            r16 = r44
            r44 = r42
            r42 = r75
        L_0x0104:
            double r46 = r42 + r0
            r18 = 0
            java.lang.String r48 = ""
            r49 = r0
            r0 = r77
            r51 = 2
            r1 = r46
            r52 = r3
            r3 = r18
            r53 = r4
            r4 = r48
            r54 = r5
            r5 = r53
            r6 = r85
            r48 = r7
            r7 = r80
            r11 = -1
            r8 = r81
            r56 = r9
            r9 = r29
            r51 = r10
            r10 = r48
            int r0 = r0.my_rise_trans(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r11) goto L_0x013e
            r10 = r48
            int r0 = r15.goto_swe_heliacal_err1(r10, r13, r0)
            return r0
        L_0x013e:
            r10 = r48
            r9 = 0
            r0 = r29[r9]
            r2 = r29[r9]
            double r2 = r15.DeltaT(r2, r9)
            r58 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r2 = r2 / r58
            double r1 = r0 + r2
            swisseph.SwissEph r0 = r15.sw
            r3 = 0
            r4 = r35
            r5 = r34
            r6 = r10
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x0165
            int r0 = r15.goto_swe_heliacal_err1(r10, r13, r0)
            return r0
        L_0x0165:
            r0 = r34[r9]
            r27[r9] = r0
            r0 = r34[r22]
            r27[r22] = r0
            swisseph.Swecl r0 = r15.sc
            r1 = r29[r9]
            r3 = 1
            r4 = r80
            r5 = r23
            r7 = r25
            r11 = 0
            r9 = r27
            r48 = r10
            r10 = r21
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r1 = r21[r22]
            r3 = r34[r22]
            r5 = r80[r22]
            r0 = r77
            double r7 = r0.HourAngle(r1, r3, r5)
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r12
            if (r0 == 0) goto L_0x0196
            r16 = -4603804719079489536(0xc01c000000000000, double:-7.0)
        L_0x0196:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r12
            if (r0 == 0) goto L_0x019f
            r0 = -4602115869219225600(0xc022000000000000, double:-9.0)
            r1 = r0
            goto L_0x01a1
        L_0x019f:
            r1 = r16
        L_0x01a1:
            r3 = r34[r22]
            r5 = r80[r22]
            r0 = r77
            double r0 = r0.HourAngle(r1, r3, r5)
            double r0 = r0 - r7
            r10 = 2
            if (r14 == r10) goto L_0x01b3
            r9 = 3
            if (r14 != r9) goto L_0x01b5
            goto L_0x01b4
        L_0x01b3:
            r9 = 3
        L_0x01b4:
            double r0 = -r0
        L_0x01b5:
            r2 = r29[r11]
            r4 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r0 = r0 / r4
            double r7 = r2 - r0
            double r0 = r15.DeltaT(r7, r11)
            double r0 = r0 / r58
            double r16 = r7 + r0
            swisseph.SwissEph r0 = r15.sw
            r3 = 0
            r1 = r16
            r4 = r35
            r5 = r34
            r6 = r48
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x01dd
            r5 = r48
            int r0 = r15.goto_swe_heliacal_err1(r5, r13, r0)
            return r0
        L_0x01dd:
            r5 = r48
            r0 = r34[r11]
            r27[r11] = r0
            r0 = r34[r22]
            r27[r22] = r0
            swisseph.Swecl r0 = r15.sc
            r3 = 1
            r1 = r7
            r4 = r80
            r5 = r23
            r60 = r7
            r7 = r25
            r18 = 3
            r9 = r27
            r57 = 2
            r10 = r21
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r21[r11]
            r62 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 + r62
            r64 = 4645040803167600640(0x4076800000000000, double:360.0)
            int r2 = (r0 > r64 ? 1 : (r0 == r64 ? 0 : -1))
            if (r2 < 0) goto L_0x0212
            double r0 = r0 - r64
        L_0x0212:
            r66 = r0
            r68 = r21[r22]
            r10 = r52
            r7 = -1
            if (r10 == r7) goto L_0x0251
            swisseph.SwissEph r0 = r15.sw
            r1 = r16
            r3 = r10
            r4 = r35
            r5 = r34
            r6 = r48
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r7) goto L_0x0233
            r9 = r48
            int r0 = r15.goto_swe_heliacal_err1(r9, r13, r0)
            return r0
        L_0x0233:
            r9 = r48
            r7 = 0
            r0 = r77
            r1 = r60
            r3 = r80
            r4 = r83
            r5 = r85
            r6 = r31
            r8 = r9
            int r0 = r0.Magnitude(r1, r3, r4, r5, r6, r7, r8)
            r1 = -1
            if (r0 != r1) goto L_0x024f
            int r0 = r15.goto_swe_heliacal_err1(r9, r13, r0)
            return r0
        L_0x024f:
            r7 = -1
            goto L_0x026a
        L_0x0251:
            r9 = r48
            r0 = r77
            r1 = r83
            r2 = r16
            r4 = r35
            r5 = r34
            r6 = r9
            int r0 = r0.call_swe_fixstar(r1, r2, r4, r5, r6)
            r7 = -1
            if (r0 != r7) goto L_0x026a
            int r0 = r15.goto_swe_heliacal_err1(r9, r13, r0)
            return r0
        L_0x026a:
            r0 = r34[r11]
            r27[r11] = r0
            r0 = r34[r22]
            r27[r22] = r0
            swisseph.Swecl r0 = r15.sc
            r3 = 1
            r1 = r60
            r4 = r80
            r5 = r23
            r16 = -1
            r7 = r25
            r48 = r9
            r9 = r27
            r70 = r10
            r10 = r21
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r21[r11]
            double r0 = r0 + r62
            int r2 = (r0 > r64 ? 1 : (r0 == r64 ? 0 : -1))
            if (r2 < 0) goto L_0x0294
            double r0 = r0 - r64
        L_0x0294:
            r4 = r0
            r0 = r21[r22]
            double r62 = r0 - r68
            r1 = r31[r11]
            r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r8 = 0
            r0 = r77
            r3 = r82
            r30 = r34
            r34 = 3
            r10 = r60
            r12 = r66
            r14 = r80
            r15 = r81
            r16 = r85
            r17 = r33
            r18 = r48
            int r10 = r0.HeliacalAngle(r1, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17, r18)
            r11 = -1
            if (r10 != r11) goto L_0x02c7
            r12 = r77
            r13 = r87
            r14 = r48
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r10)
            return r0
        L_0x02c7:
            r12 = r77
            r13 = r87
            r14 = r48
            r0 = r33[r22]
            r16 = r33[r57]
            double r0 = r62 - r0
            int r2 = (r44 > r19 ? 1 : (r44 == r19 ? 0 : -1))
            if (r2 > 0) goto L_0x02df
            int r2 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x02dc
            goto L_0x02df
        L_0x02dc:
            r4 = r49
            goto L_0x02ee
        L_0x02df:
            double r2 = r40 - r46
            r4 = r49
            int r6 = r12.Sgn(r4)
            double r6 = (double) r6
            double r2 = r2 * r6
            int r6 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r6 > 0) goto L_0x04e7
        L_0x02ee:
            r48 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r32 != 0) goto L_0x030f
            double r2 = r40 - r46
            int r6 = r12.Sgn(r4)
            double r6 = (double) r6
            double r2 = r2 * r6
            int r6 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r6 <= 0) goto L_0x030f
            double r0 = swisseph.SMath.abs((double) r4)
            double r0 = r0 / r48
            int r0 = (int) r0
            int r1 = r12.Sgn(r4)
            int r0 = r0 * r1
            double r0 = (double) r0
            goto L_0x0314
        L_0x030f:
            r44 = r0
            r0 = r4
            r42 = r46
        L_0x0314:
            if (r32 != 0) goto L_0x0345
            double r2 = r40 - r42
            int r4 = r12.Sgn(r0)
            double r4 = (double) r4
            double r2 = r2 * r4
            int r4 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r4 > 0) goto L_0x0324
            goto L_0x0345
        L_0x0324:
            r15 = r12
            r7 = r14
            r34 = r30
            r10 = r51
            r4 = r53
            r5 = r54
            r9 = r56
            r3 = r70
            r2 = 2
            r8 = -1
            r11 = 3
            r14 = r84
            r12 = r85
            r75 = r16
            r16 = r32
            r17 = r42
            r42 = r44
            r44 = r75
            goto L_0x00ef
        L_0x0345:
            double r40 = r40 - r42
            int r2 = r12.Sgn(r0)
            double r2 = (double) r2
            double r40 = r40 * r2
            int r2 = (r40 > r19 ? 1 : (r40 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x04c0
            r2 = r54
            int r4 = (r40 > r2 ? 1 : (r40 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x035b
            r11 = 0
            goto L_0x04c3
        L_0x035b:
            r2 = 4559544342741609494(0x3f46c16c16c16c16, double:6.944444444444444E-4)
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 >= 0) goto L_0x0369
            r2 = -4663827694113166314(0xbf46c16c16c16c16, double:-6.944444444444444E-4)
        L_0x0369:
            r8 = r2
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r85 & r0
            if (r0 == 0) goto L_0x041a
            r0 = r77
            r1 = r82
            r2 = r60
            r4 = r80
            r5 = r81
            r6 = r83
            r7 = r85
            r71 = r8
            r8 = r28
            r9 = r14
            int r0 = r0.DeterTAV(r1, r2, r4, r5, r6, r7, r8, r9)
            if (r0 != r11) goto L_0x038e
            return r11
        L_0x038e:
            r8 = r71
            double r15 = r60 + r8
            r0 = r77
            r1 = r82
            r2 = r15
            r4 = r80
            r5 = r81
            r6 = r83
            r7 = r85
            r73 = r8
            r8 = r56
            r9 = r14
            int r0 = r0.DeterTAV(r1, r2, r4, r5, r6, r7, r8, r9)
            if (r0 != r11) goto L_0x03ab
            return r11
        L_0x03ab:
            r9 = 0
            r0 = r56[r9]
            r2 = r28[r9]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x03c0
            r7 = r73
            double r0 = -r7
            r2 = r28[r9]
            r51[r9] = r2
            r15 = r0
            r17 = r19
            goto L_0x03cf
        L_0x03c0:
            r7 = r73
            r0 = r56[r9]
            r51[r9] = r0
            r0 = r28[r9]
            r56[r9] = r0
            r60 = r15
            r17 = r19
            r15 = r7
        L_0x03cf:
            double r60 = r60 + r15
            r0 = r56[r9]
            r28[r9] = r0
            r0 = r51[r9]
            r56[r9] = r0
            r0 = r77
            r1 = r82
            r2 = r60
            r4 = r80
            r5 = r81
            r6 = r83
            r31 = r7
            r7 = r85
            r8 = r51
            r9 = r14
            int r0 = r0.DeterTAV(r1, r2, r4, r5, r6, r7, r8, r9)
            if (r0 != r11) goto L_0x03f3
            return r11
        L_0x03f3:
            r9 = 0
            r0 = r56[r9]
            r2 = r51[r9]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0410
            r1 = r51[r9]
            r3 = r56[r9]
            r5 = r28[r9]
            r0 = r77
            double r0 = r0.x2min(r1, r3, r5)
            double r0 = r36 - r0
            double r0 = r0 * r15
            double r0 = r60 - r0
            r17 = r0
        L_0x0410:
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0417
            r7 = r17
            goto L_0x041f
        L_0x0417:
            r7 = r31
            goto L_0x03cf
        L_0x041a:
            r31 = r8
            r9 = 0
            r7 = r60
        L_0x041f:
            r0 = 65536(0x10000, float:9.18355E-41)
            r0 = r85 & r0
            if (r0 == 0) goto L_0x0494
            r15 = r7
        L_0x0426:
            double r7 = r15 - r31
            double r0 = r12.DeltaT(r7, r9)
            double r0 = r0 / r58
            double r2 = r7 + r0
            r10 = r70
            if (r10 == r11) goto L_0x044c
            swisseph.SwissEph r0 = r12.sw
            r1 = r2
            r3 = r10
            r4 = r35
            r5 = r30
            r6 = r14
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x0449
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r0)
            return r0
        L_0x0449:
            r17 = r0
            goto L_0x0462
        L_0x044c:
            r0 = r77
            r1 = r83
            r4 = r35
            r5 = r30
            r6 = r14
            int r0 = r0.call_swe_fixstar(r1, r2, r4, r5, r6)
            if (r0 != r11) goto L_0x0460
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r0)
            return r0
        L_0x0460:
            r17 = r0
        L_0x0462:
            r0 = r30[r9]
            r27[r9] = r0
            r0 = r30[r22]
            r27[r22] = r0
            swisseph.Swecl r0 = r12.sc
            r3 = 1
            r1 = r7
            r4 = r80
            r5 = r23
            r28 = r7
            r7 = r25
            r11 = 0
            r9 = r27
            r18 = r10
            r10 = r21
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r21[r22]
            int r2 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r2 > 0) goto L_0x048d
            double r7 = r28 + r15
            double r7 = r7 / r48
            r10 = r17
            goto L_0x0495
        L_0x048d:
            r70 = r18
            r15 = r28
            r9 = 0
            r11 = -1
            goto L_0x0426
        L_0x0494:
            r11 = 0
        L_0x0495:
            r0 = -4511741717669478400(0xc16312cfe0000000, double:-9999999.0)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x04af
            r0 = 4711630319185297408(0x416312cfe0000000, double:9999999.0)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x04a8
            goto L_0x04af
        L_0x04a8:
            r86[r11] = r7
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r10)
            return r0
        L_0x04af:
            r86[r11] = r38
            r14.setLength(r11)
            java.lang.String r0 = "no heliacal date found"
            r14.append(r0)
            r6 = -1
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r6)
            return r0
        L_0x04c0:
            r2 = r54
            r11 = 0
        L_0x04c3:
            r86[r11] = r78
            r0 = -2
            r14.setLength(r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "heliacal event not found within maxlength "
            r1.append(r4)
            r1.append(r2)
            java.lang.String r2 = "\n"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r14.append(r1)
            int r0 = r12.goto_swe_heliacal_err1(r14, r13, r0)
            return r0
        L_0x04e7:
            r2 = r54
            r18 = r70
            r6 = -1
            r11 = 0
            r44 = r0
            r0 = r4
            r15 = r12
            r7 = r14
            r34 = r30
            r42 = r46
            r10 = r51
            r4 = r53
            r9 = r56
            r8 = -1
            r11 = 3
            r14 = r84
            r12 = r85
            r5 = r2
            r3 = r18
            r2 = 2
            goto L_0x0104
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.heliacal_ut_arc_vis(double, double[], double[], double[], java.lang.StringBuffer, int, int, double[], java.lang.StringBuffer):int");
    }

    private int goto_swe_heliacal_err1(StringBuffer stringBuffer, StringBuffer stringBuffer2, int i) {
        if (!(stringBuffer2 == null || stringBuffer.length() == 0)) {
            stringBuffer2.setLength(0);
            stringBuffer2.append(stringBuffer);
        }
        return i;
    }

    private int get_asc_obl(double d, int i, String str, int i2, double[] dArr, boolean z, double[] dArr2, StringBuffer stringBuffer) {
        String str2 = str;
        return get_asc_obl(d, i, new StringBuffer(str), i2, dArr, z, dArr2, stringBuffer);
    }

    private int get_asc_obl(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, boolean z, double[] dArr2, StringBuffer stringBuffer2) {
        String str;
        int i3 = i;
        StringBuffer stringBuffer3 = stringBuffer;
        StringBuffer stringBuffer4 = stringBuffer2;
        int i4 = i2 & 6;
        double[] dArr3 = new double[6];
        StringBuffer stringBuffer5 = new StringBuffer(stringBuffer3);
        if (i3 == -1) {
            if (this.sw.swe_fixstar(stringBuffer5, d, i4 | 2048, dArr3, stringBuffer2) == -1) {
                return -1;
            }
        } else {
            if (this.sw.swe_calc(d, i, i4 | 2048, dArr3, stringBuffer2) == -1) {
                return -1;
            }
        }
        double tan = SMath.tan(dArr[1] * 0.0174532925199433d) * SMath.tan(dArr3[1] * 0.0174532925199433d);
        if (SMath.abs(tan) > 1.0d) {
            if (stringBuffer3 == null || stringBuffer.length() <= 0) {
                str = this.sw.swe_get_planet_name(i3);
            } else {
                str = stringBuffer.toString();
            }
            stringBuffer4.setLength(0);
            stringBuffer4.append(str + " is circumpolar, cannot calculate heliacal event");
            return -2;
        }
        double asin = SMath.asin(tan) / 0.0174532925199433d;
        if (z) {
            dArr2[0] = dArr3[0] + asin;
        } else {
            dArr2[0] = dArr3[0] - asin;
        }
        dArr2[0] = this.sl.swe_degnorm(dArr2[0]);
        return 0;
    }

    private int get_asc_obl_diff(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, boolean z, boolean z2, double[] dArr2, StringBuffer stringBuffer2) {
        boolean z3;
        double[] dArr3 = new double[1];
        double[] dArr4 = new double[1];
        int i3 = get_asc_obl(d, 0, "", i2, dArr, z, dArr3, stringBuffer2);
        if (i3 != 0) {
            return i3;
        }
        if (!z2) {
            z3 = z;
        } else if (z) {
            z3 = false;
        } else {
            z3 = true;
        }
        int i4 = get_asc_obl(d, i, stringBuffer, i2, dArr, z3, dArr4, stringBuffer2);
        if (i4 != 0) {
            return i4;
        }
        dArr2[0] = this.sl.swe_degnorm(dArr3[0] - dArr4[0]);
        if (z2) {
            dArr2[0] = this.sl.swe_degnorm(dArr2[0] - 180.0d);
        }
        if (dArr2[0] > 180.0d) {
            dArr2[0] = dArr2[0] - 360.0d;
        }
        return 0;
    }

    private int find_conjunct_sun(double d, int i, int i2, int i3, double[] dArr, StringBuffer stringBuffer) {
        double d2;
        int i4 = i;
        int i5 = i3;
        int i6 = i2 & 6;
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        if (i4 < 4 || i5 < 3) {
            d2 = 0.0d;
        } else {
            d2 = 180.0d;
        }
        double d3 = this.tcon[((i5 - 1) / 2) + (i4 * 2)];
        double d4 = get_synodic_period(i4);
        double d5 = 100.0d;
        double floor = d3 + ((SMath.floor((d - d3) / d4) + 1.0d) * d4);
        while (d5 > 0.5d) {
            int i7 = i6 | 256;
            if (this.sw.swe_calc(floor, i, i7, dArr2, stringBuffer) == -1) {
                return -1;
            }
            double[] dArr4 = dArr3;
            if (this.sw.swe_calc(floor, 0, i7, dArr4, stringBuffer) == -1) {
                return -1;
            }
            double swe_degnorm = this.sl.swe_degnorm((dArr2[0] - dArr4[0]) - d2);
            if (swe_degnorm > 180.0d) {
                swe_degnorm -= 360.0d;
            }
            floor -= swe_degnorm / (dArr2[3] - dArr4[3]);
            dArr3 = dArr4;
            d5 = swe_degnorm;
        }
        dArr[0] = floor;
        return 0;
    }

    private int get_asc_obl_with_sun(double d, int i, StringBuffer stringBuffer, int i2, int i3, double d2, double[] dArr, double[] dArr2, StringBuffer stringBuffer2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        double d3;
        int i4 = i3;
        StringBuffer stringBuffer3 = stringBuffer2;
        int i5 = i2 & 6;
        double[] dArr3 = {1.0d};
        double[] dArr4 = new double[1];
        if (i4 == 2 || i4 == 3) {
            z = true;
        } else {
            z = false;
        }
        if (i4 == 1 || i4 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i4 == 5) {
            z3 = true;
        } else {
            z3 = z;
        }
        if (i4 != 5 && i4 != 6) {
            int i6 = i;
            z5 = z2;
            z4 = false;
        } else if (i != 1) {
            z5 = true;
            z4 = true;
        } else {
            z5 = z2;
            z4 = true;
        }
        double[] dArr5 = dArr4;
        int i7 = get_asc_obl_diff(d, i, stringBuffer, i5, dArr, z3, z4, dArr3, stringBuffer2);
        if (i7 != 0) {
            return i7;
        }
        double d4 = d;
        double d5 = -9.99999999E8d;
        int i8 = 0;
        while (true) {
            d3 = 10.0d;
            if (d5 == -9.99999999E8d || SMath.abs(dArr3[0]) + SMath.abs(d5) > 180.0d || ((z5 && (d5 >= 0.0d || dArr3[0] < 0.0d)) || (!z5 && (d5 < 0.0d || dArr3[0] >= 0.0d)))) {
                int i9 = i8 + 1;
                if (i9 > 5000) {
                    stringBuffer3.setLength(0);
                    stringBuffer3.append("loop in get_asc_obl_with_sun() (1)");
                    return -1;
                }
                d5 = dArr3[0];
                double d6 = d4 + 10.0d;
                if (d2 > 0.0d && d6 - d > d2) {
                    return -2;
                }
                int i10 = i9;
                int i11 = get_asc_obl_diff(d6, i, stringBuffer, i5, dArr, z3, z4, dArr3, stringBuffer2);
                if (i11 != 0) {
                    return i11;
                }
                d4 = d6;
                i8 = i10;
            }
        }
        double d7 = d4 - 20.0d;
        double d8 = d7 + 10.0d;
        int i12 = get_asc_obl_diff(d8, i, stringBuffer, i5, dArr, z3, z4, dArr5, stringBuffer2);
        if (i12 != 0) {
            return i12;
        }
        int i13 = 0;
        while (SMath.abs(dArr3[0]) > 1.0E-5d) {
            int i14 = i13 + 1;
            if (i14 > 5000) {
                stringBuffer3.setLength(0);
                stringBuffer3.append("loop in get_asc_obl_with_sun() (2)");
                return -1;
            }
            if (dArr5[0] * d5 >= 0.0d) {
                d5 = dArr5[0];
                d7 = d8;
            } else {
                dArr3[0] = dArr5[0];
            }
            d3 /= 2.0d;
            d8 = d7 + d3;
            int i15 = i14;
            int i16 = get_asc_obl_diff(d8, i, stringBuffer, i5, dArr, z3, z4, dArr5, stringBuffer2);
            if (i16 != 0) {
                return i16;
            }
            i13 = i15;
        }
        dArr2[0] = d8;
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:93:0x021a, code lost:
        r51[0] = r14[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021e, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int get_heliacal_day(double r43, double[] r45, double[] r46, double[] r47, java.lang.StringBuffer r48, int r49, int r50, double[] r51, java.lang.StringBuffer r52) {
        /*
            r42 = this;
            r11 = r42
            r12 = r48
            r0 = r50
            r13 = r52
            r1 = 1
            double[] r14 = new double[r1]
            r2 = 30
            double[] r15 = new double[r2]
            double[] r2 = new double[r1]
            int r10 = r11.DeterObject((java.lang.StringBuffer) r12)
            r3 = 3
            r9 = 4
            r4 = 2
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = 0
            r20 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 == r1) goto L_0x0047
            if (r0 == r4) goto L_0x003e
            if (r0 == r3) goto L_0x0035
            if (r0 == r9) goto L_0x002d
            r22 = r18
            r25 = r22
            r24 = 0
            goto L_0x004f
        L_0x002d:
            r22 = r16
            r25 = r22
            r24 = 1
            goto L_0x004f
        L_0x0035:
            r22 = r20
            r25 = r22
            r24 = 2
            goto L_0x004f
        L_0x003e:
            r22 = r16
            r25 = r20
            r24 = 2
            goto L_0x004f
        L_0x0047:
            r25 = r16
            r22 = r20
            r24 = 1
        L_0x004f:
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            r27 = 4624633867356078080(0x402e000000000000, double:15.0)
            r7 = 300(0x12c, float:4.2E-43)
            r29 = 4617315517961601024(0x4014000000000000, double:5.0)
            r8 = -1
            if (r10 == r8) goto L_0x00be
            r2 = 6
            if (r10 == r2) goto L_0x00b2
            if (r10 == r1) goto L_0x00a7
            if (r10 == r4) goto L_0x0098
            if (r10 == r3) goto L_0x0080
            if (r10 == r9) goto L_0x0073
            r1 = r43
            r4 = 0
            r40 = r5
            r5 = r27
            r27 = r40
            goto L_0x00e7
        L_0x0073:
            r7 = 400(0x190, float:5.6E-43)
            r1 = r43
            r5 = r27
            r27 = r29
            r4 = 0
            goto L_0x00e7
        L_0x0080:
            r1 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r1 = r1 * r22
            double r1 = r43 - r1
            if (r0 < r3) goto L_0x0092
            r4 = 0
            r40 = r5
            r5 = r27
            r27 = r40
            goto L_0x00e7
        L_0x0092:
            r27 = r20
            r5 = r29
            r4 = 0
            goto L_0x00e7
        L_0x0098:
            r7 = 60
            double r0 = r22 * r18
            double r0 = r43 - r0
            r1 = r0
            r5 = r29
            r27 = r5
            r4 = 0
            goto L_0x00e7
        L_0x00a7:
            r7 = 16
            r1 = r43
            r5 = r20
            r27 = r5
            r4 = 0
            goto L_0x00e7
        L_0x00b2:
            r27 = 4626322717216342016(0x4034000000000000, double:20.0)
            r1 = r43
            r5 = r27
            r27 = r29
            r4 = 0
            goto L_0x00e7
        L_0x00be:
            r4 = 0
            int r0 = r11.call_swe_fixstar_mag(r12, r2, r4, r13)
            if (r0 != r8) goto L_0x00c7
            return r8
        L_0x00c7:
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            r31 = r2[r4]
            r33 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r3 = (r31 > r33 ? 1 : (r31 == r33 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d2
        L_0x00d2:
            r31 = r2[r4]
            int r2 = (r31 > r18 ? 1 : (r31 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x00e1
            r1 = r43
            r40 = r5
            r5 = r27
            r27 = r40
            goto L_0x00e7
        L_0x00e1:
            r5 = r27
            r27 = r0
            r1 = r43
        L_0x00e7:
            r43 = r5
            double r4 = (double) r7
            double r4 = r4 * r22
            double r32 = r1 + r4
            r7 = -2
            r36 = r43
            r34 = r1
            r6 = -2
        L_0x00f5:
            int r0 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fd
            int r0 = (r34 > r32 ? 1 : (r34 == r32 ? 0 : -1))
            if (r0 < 0) goto L_0x0105
        L_0x00fd:
            int r0 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x022e
            int r0 = (r34 > r32 ? 1 : (r34 == r32 ? 0 : -1))
            if (r0 <= 0) goto L_0x022e
        L_0x0105:
            r3 = 0
            java.lang.String r4 = ""
            r0 = r42
            r1 = r34
            r31 = 0
            r5 = r24
            r38 = r6
            r6 = r49
            r7 = r45
            r8 = r46
            r9 = r14
            r11 = r10
            r10 = r52
            int r0 = r0.my_rise_trans(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r10 = -1
            if (r0 != r10) goto L_0x0125
            return r10
        L_0x0125:
            r9 = -2
            if (r0 != r9) goto L_0x0130
            r6 = r0
            r0 = 0
            r1 = 4
            r38 = -2
            goto L_0x0222
        L_0x0130:
            r8 = 0
            r1 = r14[r8]
            r0 = r42
            r3 = r45
            r4 = r46
            r5 = r47
            r6 = r48
            r7 = r49
            r8 = r15
            r9 = r52
            int r9 = r0.swe_vis_limit_mag(r1, r3, r4, r5, r6, r7, r8, r9)
            if (r9 != r10) goto L_0x0149
            return r10
        L_0x0149:
            r7 = r38
            r8 = -2
            if (r7 != r8) goto L_0x0172
            if (r9 < 0) goto L_0x0172
            int r0 = (r36 > r20 ? 1 : (r36 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x0172
            double r36 = r36 * r22
            double r34 = r34 - r36
            r7 = 4
            if (r11 >= r7) goto L_0x0169
            if (r11 != r10) goto L_0x0160
            goto L_0x0169
        L_0x0160:
            r6 = r9
            r36 = r20
            r0 = 0
            r1 = 4
            r38 = -2
            goto L_0x0222
        L_0x0169:
            r6 = r9
            r36 = r29
            r0 = 0
            r1 = 4
            r38 = -2
            goto L_0x0222
        L_0x0172:
            r7 = 4
            if (r9 != r8) goto L_0x017e
            r39 = r9
            r0 = 0
            r1 = 4
            r38 = -2
            goto L_0x0220
        L_0x017e:
            r6 = 0
            r0 = r15[r6]
            r31 = 7
            r0 = r15[r31]
            r0 = r9
        L_0x0186:
            if (r0 == r8) goto L_0x01fa
            r0 = r15[r6]
            r2 = r15[r31]
            double r0 = r0 - r2
            int r2 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x01fa
            int r2 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r2 >= 0) goto L_0x01a4
            r0 = r14[r6]
            r2 = 4570152821863859996(0x3f6c71c71c71c71c, double:0.003472222222222222)
            double r2 = r2 * r25
            double r2 = r2 * r27
            double r0 = r0 + r2
            r14[r6] = r0
            goto L_0x01d8
        L_0x01a4:
            r2 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x01b9
            r0 = r14[r6]
            r2 = 4564047942368979991(0x3f56c16c16c16c17, double:0.001388888888888889)
            double r2 = r2 * r25
            double r2 = r2 * r27
            double r0 = r0 + r2
            r14[r6] = r0
            goto L_0x01d8
        L_0x01b9:
            r2 = -4631501856787818086(0xbfb999999999999a, double:-0.1)
            r4 = 4559544342741609495(0x3f46c16c16c16c17, double:6.944444444444445E-4)
            int r38 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r38 >= 0) goto L_0x01d1
            r0 = r14[r6]
            double r4 = r4 * r25
            double r4 = r4 * r27
            double r0 = r0 + r4
            r14[r6] = r0
            goto L_0x01d8
        L_0x01d1:
            r0 = r14[r6]
            double r4 = r4 * r25
            double r0 = r0 + r4
            r14[r6] = r0
        L_0x01d8:
            r1 = r14[r6]
            r0 = r42
            r3 = r45
            r4 = r46
            r5 = r47
            r6 = r48
            r7 = r49
            r38 = -2
            r8 = r15
            r39 = r9
            r9 = r52
            int r0 = r0.swe_vis_limit_mag(r1, r3, r4, r5, r6, r7, r8, r9)
            if (r0 != r10) goto L_0x01f4
            return r10
        L_0x01f4:
            r9 = r39
            r6 = 0
            r7 = 4
            r8 = -2
            goto L_0x0186
        L_0x01fa:
            r39 = r9
            r38 = -2
            r0 = 0
            r1 = r15[r0]
            r3 = r15[r31]
            double r1 = r1 - r3
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x021f
            r1 = 4
            if (r11 >= r1) goto L_0x020d
            if (r11 != r10) goto L_0x021a
        L_0x020d:
            int r2 = (r36 > r20 ? 1 : (r36 == r20 ? 0 : -1))
            if (r2 <= 0) goto L_0x021a
            double r36 = r36 * r22
            double r34 = r34 - r36
            r36 = r20
            r6 = r39
            goto L_0x0222
        L_0x021a:
            r1 = r14[r0]
            r51[r0] = r1
            return r0
        L_0x021f:
            r1 = 4
        L_0x0220:
            r6 = r39
        L_0x0222:
            double r2 = r36 * r22
            double r34 = r34 + r2
            r10 = r11
            r7 = -2
            r8 = -1
            r9 = 4
            r11 = r42
            goto L_0x00f5
        L_0x022e:
            r0 = 0
            r38 = -2
            r13.setLength(r0)
            java.lang.String r0 = "heliacal event does not happen"
            r13.append(r0)
            return r38
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.get_heliacal_day(double, double[], double[], double[], java.lang.StringBuffer, int, int, double[], java.lang.StringBuffer):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084 A[LOOP:2: B:16:0x0084->B:22:0x00ae, LOOP_START, PHI: r16 r18 r19 r21 
      PHI: (r16v2 double) = (r16v1 double), (r16v3 double) binds: [B:14:0x0081, B:22:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r18v2 int) = (r18v1 int), (r18v3 int) binds: [B:14:0x0081, B:22:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v2 double) = (r19v1 double), (r19v3 double) binds: [B:14:0x0081, B:22:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r21v2 double) = (r21v1 double), (r21v3 double) binds: [B:14:0x0081, B:22:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c2 A[LOOP:0: B:4:0x0037->B:25:0x00c2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int time_optimum_visibility(double r27, double[] r29, double[] r30, double[] r31, java.lang.StringBuffer r32, int r33, double[] r34, int r35, java.lang.StringBuffer r36) {
        /*
            r26 = this;
            r0 = 10
            double[] r0 = new double[r0]
            r34[r35] = r27
            r1 = r26
            r2 = r27
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r0
            r10 = r36
            int r1 = r1.swe_vis_limit_mag(r2, r4, r5, r6, r7, r8, r9, r10)
            r11 = -1
            if (r1 != r11) goto L_0x001f
            return r11
        L_0x001f:
            r12 = 0
            r2 = r0[r12]
            r13 = 7
            r4 = r0[r13]
            double r2 = r2 - r4
            r4 = r1 & 1
            double r4 = (double) r4
            r6 = 4562980422457306984(0x3f52f684bda12f68, double:0.0011574074074074073)
            r14 = r6
            r10 = 0
            r7 = r4
            r4 = r1
            r5 = r2
            r3 = r4
            r1 = r27
        L_0x0037:
            r9 = 3
            if (r10 >= r9) goto L_0x00d1
            r16 = r1
            r18 = r4
            r19 = r5
            r21 = r7
        L_0x0042:
            double r23 = r16 - r14
            r1 = r26
            r2 = r23
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r0
            r25 = r10
            r10 = r36
            int r4 = r1.swe_vis_limit_mag(r2, r4, r5, r6, r7, r8, r9, r10)
            if (r4 < 0) goto L_0x0081
            r1 = r0[r12]
            r5 = r0[r13]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0081
            r1 = r0[r12]
            r5 = r0[r13]
            double r1 = r1 - r5
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x0081
            r1 = r0[r12]
            r5 = r0[r13]
            double r19 = r1 - r5
            r1 = r4 & 1
            double r1 = (double) r1
            r21 = r1
            r18 = r4
            r16 = r23
            r10 = r25
            goto L_0x0042
        L_0x0081:
            if (r4 != r11) goto L_0x0084
            return r11
        L_0x0084:
            double r23 = r16 + r14
            r1 = r26
            r2 = r23
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r0
            r10 = r36
            int r3 = r1.swe_vis_limit_mag(r2, r4, r5, r6, r7, r8, r9, r10)
            if (r3 < 0) goto L_0x00bf
            r1 = r0[r12]
            r4 = r0[r13]
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bf
            r1 = r0[r12]
            r4 = r0[r13]
            double r1 = r1 - r4
            int r4 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r4 <= 0) goto L_0x00bf
            r1 = r0[r12]
            r4 = r0[r13]
            double r19 = r1 - r4
            r1 = r3 & 1
            double r1 = (double) r1
            r21 = r1
            r18 = r3
            r16 = r23
            goto L_0x0084
        L_0x00bf:
            if (r3 != r11) goto L_0x00c2
            return r11
        L_0x00c2:
            int r10 = r25 + 1
            r1 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r14 = r14 / r1
            r1 = r16
            r4 = r18
            r5 = r19
            r7 = r21
            goto L_0x0037
        L_0x00d1:
            r34[r35] = r1
            if (r3 < 0) goto L_0x00e3
            r0 = r3 & 1
            double r0 = (double) r0
            r2 = -2
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x00de
            return r2
        L_0x00de:
            r0 = r4 & 2
            if (r0 == 0) goto L_0x00e3
            return r2
        L_0x00e3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.time_optimum_visibility(double, double[], double[], double[], java.lang.StringBuffer, int, double[], int, java.lang.StringBuffer):int");
    }

    private int time_limit_invisible(double d, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, int i2, double[] dArr4, int i3, StringBuffer stringBuffer2) {
        int i4;
        double d2;
        int i5;
        int i6;
        double[] dArr5 = new double[10];
        dArr4[i3] = d;
        if (stringBuffer.toString().equals("moon")) {
            d2 = 0.011574074074074073d;
            i4 = 4;
        } else {
            d2 = 0.0011574074074074073d;
            i4 = 3;
        }
        double d3 = (double) i2;
        int swe_vis_limit_mag = swe_vis_limit_mag(d + (0.0d * d3), dArr, dArr2, dArr3, stringBuffer, i, dArr5, stringBuffer2);
        if (swe_vis_limit_mag == -1) {
            return -1;
        }
        int i7 = swe_vis_limit_mag;
        double d4 = (double) (swe_vis_limit_mag & 1);
        int i8 = 0;
        double d5 = d;
        int i9 = i7;
        while (i8 < i4) {
            double d6 = d5;
            int i10 = i7;
            double d7 = d4;
            while (true) {
                double d8 = d6 + (d2 * d3);
                i5 = i8;
                i6 = i4;
                i9 = swe_vis_limit_mag(d8, dArr, dArr2, dArr3, stringBuffer, i, dArr5, stringBuffer2);
                if (i9 < 0 || dArr5[0] <= dArr5[7]) {
                    i8 = i5 + 1;
                    d2 /= 10.0d;
                    d5 = d6;
                    i7 = i10;
                    d4 = d7;
                    i4 = i6;
                } else {
                    d7 = (double) (i9 & 1);
                    i10 = i9;
                    d6 = d8;
                    i8 = i5;
                    i4 = i6;
                }
            }
            i8 = i5 + 1;
            d2 /= 10.0d;
            d5 = d6;
            i7 = i10;
            d4 = d7;
            i4 = i6;
        }
        dArr4[i3] = d5;
        stringBuffer2.setLength(0);
        if (i9 < 0 || (d4 == ((double) (i9 & 1)) && (i7 & 2) == 0)) {
            return 0;
        }
        return -2;
    }

    private int get_acronychal_day(double d, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, int i2, double[] dArr4, StringBuffer stringBuffer2) {
        int i3;
        int i4;
        int i5 = i2;
        StringBuffer stringBuffer3 = stringBuffer2;
        double[] dArr5 = {d};
        double[] dArr6 = new double[1];
        double[] dArr7 = new double[1];
        double[] dArr8 = new double[30];
        int DeterObject = DeterObject(stringBuffer);
        int i6 = i | 16384;
        if (i5 == 3 || i5 == 5) {
            i4 = -1;
            i3 = 1;
        } else {
            i4 = 1;
            i3 = 2;
        }
        double d2 = 999.0d;
        while (SMath.abs(d2) > 3.4722222222222224E-4d) {
            int i7 = i6;
            dArr5[0] = dArr5[0] + (((double) i4) * 0.7d);
            if (i4 < 0) {
                dArr5[0] = dArr5[0] - 1.0d;
            }
            int i8 = i4;
            int i9 = i7;
            double[] dArr9 = dArr8;
            double[] dArr10 = dArr7;
            if (my_rise_trans(dArr5[0], DeterObject, stringBuffer.toString(), i3, i9, dArr, dArr2, dArr5, stringBuffer2) == -1) {
                return -1;
            }
            swe_vis_limit_mag(dArr5[0], dArr, dArr2, dArr3, stringBuffer, i9, dArr9, stringBuffer2);
            while (dArr9[0] < dArr9[7]) {
                dArr5[0] = dArr5[0] + (((double) (-i8)) * 0.006944444444444444d);
                swe_vis_limit_mag(dArr5[0], dArr, dArr2, dArr3, stringBuffer, i9, dArr9, stringBuffer2);
            }
            int i10 = i8;
            int i11 = i9;
            int i12 = i11;
            int i13 = i10;
            double[] dArr11 = dArr6;
            if (time_limit_invisible(dArr5[0], dArr, dArr2, dArr3, stringBuffer, i11 | 4096, i10, dArr10, 0, stringBuffer2) == -1) {
                return -1;
            }
            if (time_limit_invisible(dArr5[0], dArr, dArr2, dArr3, stringBuffer, i12 | 8192, i13, dArr11, 0, stringBuffer2) == -1) {
                return -1;
            }
            d2 = SMath.abs(dArr11[0] - dArr10[0]);
            StringBuffer stringBuffer4 = stringBuffer;
            dArr8 = dArr9;
            dArr6 = dArr11;
            dArr7 = dArr10;
            i6 = i12;
            i4 = i13;
        }
        int i14 = i6;
        double[] dArr12 = dArr8;
        double[] dArr13 = dArr6;
        if (azalt_cart(dArr13[0], dArr, dArr2, new StringBuffer("sun"), i6, dArr12, stringBuffer2) == -1) {
            return -1;
        }
        dArr4[0] = dArr13[0];
        if (dArr12[1] < -12.0d) {
            stringBuffer3.setLength(0);
            stringBuffer3.append("acronychal rising/setting not available, " + dArr12[1]);
            return 0;
        }
        stringBuffer3.setLength(0);
        stringBuffer3.append("solar altitude, " + dArr12[1]);
        return 0;
    }

    private int get_heliacal_details(double d, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, int i2, double[] dArr4, StringBuffer stringBuffer2) {
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5 = i;
        StringBuffer stringBuffer3 = stringBuffer2;
        int time_optimum_visibility = time_optimum_visibility(d, dArr, dArr2, dArr3, stringBuffer, i2, dArr4, 1, stringBuffer2);
        if (time_optimum_visibility == -1) {
            return -1;
        }
        if (time_optimum_visibility == -2) {
            z = true;
        } else {
            z = false;
        }
        if (i5 == 1 || i5 == 4) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        int time_limit_invisible = time_limit_invisible(d, dArr, dArr2, dArr3, stringBuffer, i2, i3, dArr4, 0, stringBuffer2);
        if (time_limit_invisible == -1) {
            return -1;
        }
        if (time_limit_invisible == -2) {
            z2 = true;
        } else {
            z2 = false;
        }
        int time_limit_invisible2 = time_limit_invisible(dArr4[1], dArr, dArr2, dArr3, stringBuffer, i2, i3 * -1, dArr4, 2, stringBuffer2);
        if (time_limit_invisible2 == -1) {
            return -1;
        }
        if (time_limit_invisible2 == -2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i5 == 2 || i5 == 3) {
            double d2 = dArr4[2];
            i4 = 0;
            dArr4[2] = dArr4[0];
            dArr4[0] = d2;
            boolean z4 = z2;
            z2 = z3;
            z3 = z4;
        } else {
            i4 = 0;
        }
        if (z || z2 || z3) {
            stringBuffer3.setLength(i4);
            stringBuffer3.append("return values [");
            if (z2) {
                stringBuffer3.append("0,");
            }
            if (z) {
                stringBuffer3.append("1,");
            }
            if (z3) {
                stringBuffer3.append("2,");
            }
            stringBuffer3.append("] are uncertain due to change between photopic and scotopic vision");
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        if (r26 <= 2) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int heliacal_ut_vis_lim(double r20, double[] r22, double[] r23, double[] r24, java.lang.StringBuffer r25, int r26, int r27, double[] r28, java.lang.StringBuffer r29) {
        /*
            r19 = this;
            r12 = r19
            r13 = r26
            r14 = r27
            r15 = r29
            r0 = 1
            double[] r11 = new double[r0]
            double[] r10 = new double[r0]
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            r16 = 0
            r0 = 0
        L_0x0017:
            r1 = 10
            if (r0 >= r1) goto L_0x0022
            r1 = 0
            r28[r0] = r1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0022:
            r28[r16] = r20
            r7 = r25
            int r8 = r12.DeterObject((java.lang.StringBuffer) r7)
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0030
        L_0x0030:
            r6 = 2
            if (r8 != r6) goto L_0x003a
            r0 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r0 = r20 - r0
            r11[r16] = r0
            goto L_0x0040
        L_0x003a:
            r0 = 4632233691727265792(0x4049000000000000, double:50.0)
            double r0 = r20 - r0
            r11[r16] = r0
        L_0x0040:
            r5 = 3
            r4 = -1
            if (r8 == r6) goto L_0x0096
            if (r8 == r5) goto L_0x0096
            if (r13 > r6) goto L_0x004e
            r13 = r8
            r17 = r11
            r11 = r9
            goto L_0x009a
        L_0x004e:
            r1 = r11[r16]
            r17 = 0
            r0 = r19
            r3 = r8
            r10 = -1
            r4 = r25
            r5 = r27
            r13 = 2
            r6 = r26
            r13 = r8
            r7 = r17
            r21 = r9
            r9 = r22
            r10 = r11
            r17 = r11
            r11 = r21
            int r0 = r0.get_asc_obl_with_sun(r1, r3, r4, r5, r6, r7, r9, r10, r11)
            if (r0 == 0) goto L_0x0076
            r11 = r21
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x0076:
            r11 = r21
            r1 = r17[r16]
            r0 = r19
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r27
            r8 = r26
            r9 = r17
            r10 = r11
            int r0 = r0.get_acronychal_day(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x00fd
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x0096:
            r13 = r8
            r17 = r11
            r11 = r9
        L_0x009a:
            r9 = -1
            if (r13 != r9) goto L_0x00c3
            r1 = r17[r16]
            r7 = 0
            r0 = r19
            r3 = r13
            r4 = r25
            r5 = r27
            r6 = r26
            r9 = r22
            r18 = r10
            r10 = r17
            r21 = r11
            int r0 = r0.get_asc_obl_with_sun(r1, r3, r4, r5, r6, r7, r9, r10, r11)
            if (r0 == 0) goto L_0x00bf
            r11 = r21
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x00bf:
            r11 = r21
            r10 = -1
            goto L_0x00dd
        L_0x00c3:
            r18 = r10
            r1 = r17[r16]
            r0 = r19
            r3 = r13
            r4 = r27
            r5 = r26
            r6 = r17
            r7 = r11
            int r0 = r0.find_conjunct_sun(r1, r3, r4, r5, r6, r7)
            r10 = -1
            if (r0 != r10) goto L_0x00dd
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x00dd:
            r1 = r17[r16]
            r0 = r19
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r27
            r8 = r26
            r9 = r18
            r10 = r11
            int r0 = r0.get_heliacal_day(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x00fb
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x00fb:
            r17 = r18
        L_0x00fd:
            r1 = r17[r16]
            r28[r16] = r1
            r1 = r14 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0131
            r1 = 2
            if (r13 == r1) goto L_0x0110
            r2 = 3
            if (r13 == r2) goto L_0x0110
            r7 = r26
            if (r7 > r1) goto L_0x0131
            goto L_0x0112
        L_0x0110:
            r7 = r26
        L_0x0112:
            r1 = r17[r16]
            r0 = r19
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r11
            int r0 = r0.get_heliacal_details(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = -1
            if (r0 != r1) goto L_0x0131
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        L_0x0131:
            int r0 = r12.goto_swe_heliacal_err2(r11, r15, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.heliacal_ut_vis_lim(double, double[], double[], double[], java.lang.StringBuffer, int, int, double[], java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public int goto_swe_heliacal_err2(StringBuffer stringBuffer, StringBuffer stringBuffer2, int i) {
        if (!(stringBuffer2 == null || stringBuffer.length() == 0)) {
            stringBuffer2.append(stringBuffer);
        }
        return i;
    }

    private int moon_event_vis_lim(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, double[] dArr4, StringBuffer stringBuffer) {
        int i3;
        StringBuffer stringBuffer2;
        int i4;
        int i5;
        int i6 = i;
        int i7 = i2;
        StringBuffer stringBuffer3 = stringBuffer;
        double[] dArr5 = new double[1];
        double[] dArr6 = new double[1];
        StringBuffer stringBuffer4 = new StringBuffer();
        StringBuffer stringBuffer5 = new StringBuffer();
        dArr4[0] = d;
        if (i6 == 1) {
            stringBuffer2 = stringBuffer4;
            i3 = 0;
        } else if (i6 == 2) {
            stringBuffer2 = stringBuffer4;
            i3 = 0;
        } else {
            stringBuffer5.append("moon");
            if ((i7 & 256) == 0) {
            }
            dArr5[0] = d - 30.0d;
            int i8 = i7 & -257;
            StringBuffer stringBuffer6 = stringBuffer5;
            if (find_conjunct_sun(dArr5[0], 1, i2, i, dArr5, stringBuffer4) == -1) {
                return -1;
            }
            StringBuffer stringBuffer7 = stringBuffer4;
            double[] dArr7 = dArr6;
            double[] dArr8 = dArr5;
            int i9 = get_heliacal_day(dArr5[0], dArr, dArr2, dArr3, stringBuffer6, i8, i, dArr5, stringBuffer7);
            if (i9 != 0) {
                return goto_moon_event_err(stringBuffer7, stringBuffer3, i9);
            }
            dArr4[0] = dArr8[0];
            int time_optimum_visibility = time_optimum_visibility(dArr8[0], dArr, dArr2, dArr3, stringBuffer6, i2, dArr8, 0, stringBuffer7);
            if (time_optimum_visibility == -1) {
                return goto_moon_event_err(stringBuffer7, stringBuffer3, time_optimum_visibility);
            }
            StringBuffer stringBuffer8 = stringBuffer7;
            dArr4[1] = dArr8[0];
            if (i6 == 4) {
                i4 = -1;
            } else {
                i4 = 1;
            }
            StringBuffer stringBuffer9 = stringBuffer8;
            int time_limit_invisible = time_limit_invisible(dArr8[0], dArr, dArr2, dArr3, stringBuffer6, i2, i4, dArr8, 0, stringBuffer9);
            if (time_limit_invisible == -1) {
                return goto_moon_event_err(stringBuffer9, stringBuffer3, time_limit_invisible);
            }
            dArr4[2] = dArr8[0];
            double d2 = dArr4[1];
            double[] dArr9 = dArr;
            double[] dArr10 = dArr2;
            double[] dArr11 = dArr3;
            StringBuffer stringBuffer10 = stringBuffer6;
            int i10 = i2;
            int time_limit_invisible2 = time_limit_invisible(d2, dArr9, dArr10, dArr11, stringBuffer10, i10, i4 * -1, dArr8, 0, stringBuffer9);
            dArr4[0] = dArr8[0];
            if (time_limit_invisible2 == -1) {
                return goto_moon_event_err(stringBuffer9, stringBuffer3, time_limit_invisible2);
            }
            StringBuffer stringBuffer11 = stringBuffer9;
            if (i6 == 3) {
                i5 = my_rise_trans(dArr8[0], 0, "", 2, i2, dArr, dArr2, dArr7, stringBuffer11);
                if (i5 == -1) {
                    return -1;
                }
                if (dArr7[0] < dArr4[1]) {
                    dArr4[0] = dArr7[0];
                }
            } else {
                i5 = my_rise_trans(dArr4[1], 0, "", 1, i2, dArr, dArr2, dArr7, stringBuffer11);
                if (i5 == -1) {
                    return -1;
                }
                if (dArr4[0] > dArr7[0]) {
                    dArr4[0] = dArr7[0];
                }
            }
            if (i6 == 4) {
                dArr8[0] = dArr4[0];
                dArr4[0] = dArr4[2];
                dArr4[2] = dArr8[0];
            }
            return goto_moon_event_err(stringBuffer11, stringBuffer3, i5);
        }
        stringBuffer2.setLength(i3);
        stringBuffer2.append("error: the moon has no morning first or evening last");
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int goto_moon_event_err(StringBuffer stringBuffer, StringBuffer stringBuffer2, int i) {
        if (!(stringBuffer2 == null || stringBuffer.length() == 0)) {
            stringBuffer2.append(stringBuffer);
        }
        return i;
    }

    private int MoonEventJDut(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, double[] dArr4, StringBuffer stringBuffer) {
        if ((491520 & i2) != 0) {
            return moon_event_arc_vis(d, dArr, dArr2, dArr3, i, i2, dArr4, stringBuffer);
        }
        return moon_event_vis_lim(d, dArr, dArr2, dArr3, i, i2, dArr4, stringBuffer);
    }

    private int heliacal_ut(double d, double[] dArr, double[] dArr2, double[] dArr3, StringBuffer stringBuffer, int i, int i2, double[] dArr4, StringBuffer stringBuffer2) {
        if ((491520 & i2) != 0) {
            return heliacal_ut_arc_vis(d, dArr, dArr2, dArr3, stringBuffer, i, i2, dArr4, stringBuffer2);
        }
        return heliacal_ut_vis_lim(d, dArr, dArr2, dArr3, stringBuffer, i, i2, dArr4, stringBuffer2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_heliacal_ut(double r28, double[] r30, double[] r31, double[] r32, java.lang.StringBuffer r33, int r34, int r35, double[] r36, java.lang.StringBuffer r37) {
        /*
            r27 = this;
            r11 = r27
            r12 = r30
            r10 = r34
            r13 = r35
            r14 = r37
            java.lang.StringBuffer r15 = new java.lang.StringBuffer
            r15.<init>()
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.String r0 = ""
            java.lang.String r1 = "morning first"
            java.lang.String r2 = "evening last"
            java.lang.String r3 = "evening first"
            java.lang.String r4 = "morning last"
            java.lang.String r5 = "acronychal rising"
            java.lang.String r6 = "acronychal setting"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3, r4, r5, r6}
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0033
            r1 = 1000000(0xf4240, float:1.401298E-39)
            r8 = 1000000(0xf4240, float:1.401298E-39)
            goto L_0x0034
        L_0x0033:
            r8 = 5
        L_0x0034:
            r7 = 0
            r9.setLength(r7)
            if (r14 == 0) goto L_0x003d
            r14.setLength(r7)
        L_0x003d:
            java.lang.String r1 = r33.toString()
            r11.strcpy_VBsafe(r15, r1)
            r6 = r31
            r5 = r32
            r11.default_heliacal_parameters(r6, r12, r5, r13)
            swisseph.SwissEph r1 = r11.sw
            r17 = r12[r7]
            r3 = 1
            r19 = r12[r3]
            r4 = 2
            r21 = r12[r4]
            r16 = r1
            r16.swe_set_topo(r17, r19, r21)
            int r1 = r11.DeterObject((java.lang.StringBuffer) r15)
            java.lang.String r7 = " (event type "
            r4 = -2
            r2 = -1
            if (r1 != r3) goto L_0x00e5
            if (r10 == r3) goto L_0x00c2
            r1 = 2
            if (r10 != r1) goto L_0x006b
            r12 = 0
            goto L_0x00c3
        L_0x006b:
            r0 = r27
            r1 = r28
            r3 = r30
            r15 = -2
            r4 = r31
            r5 = r32
            r6 = r34
            r8 = 0
            r7 = r35
            r8 = r36
            r16 = r9
            int r0 = r0.MoonEventJDut(r1, r3, r4, r5, r6, r7, r8, r9)
        L_0x0084:
            if (r0 == r15) goto L_0x00b0
            r9 = 0
            r3 = r36[r9]
            int r5 = (r3 > r28 ? 1 : (r3 == r28 ? 0 : -1))
            if (r5 >= 0) goto L_0x00b0
            r3 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r17 = r1 + r3
            r8 = r16
            r8.setLength(r9)
            r0 = r27
            r1 = r17
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r34
            r7 = r35
            r8 = r36
            r12 = 0
            r9 = r16
            int r0 = r0.MoonEventJDut(r1, r3, r4, r5, r6, r7, r8, r9)
            r12 = r30
            goto L_0x0084
        L_0x00b0:
            r12 = 0
            if (r14 == 0) goto L_0x00c1
            int r1 = r16.length()
            if (r1 == 0) goto L_0x00c1
            r14.setLength(r12)
            r9 = r16
            r14.append(r9)
        L_0x00c1:
            return r0
        L_0x00c2:
            r12 = 0
        L_0x00c3:
            if (r14 == 0) goto L_0x00e4
            r14.setLength(r12)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = r0[r10]
            r1.append(r0)
            r1.append(r7)
            r1.append(r10)
            java.lang.String r0 = ") does not exist for the moon\n"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r14.append(r0)
        L_0x00e4:
            return r2
        L_0x00e5:
            r6 = -2
            r12 = 0
            r3 = 491520(0x78000, float:6.88766E-40)
            r3 = r3 & r13
            java.lang.String r4 = "\n"
            r5 = 3
            r6 = 4
            if (r3 != 0) goto L_0x012e
            if (r1 == r2) goto L_0x00f5
            if (r1 < r6) goto L_0x012e
        L_0x00f5:
            if (r10 == r5) goto L_0x00f9
            if (r10 != r6) goto L_0x012e
        L_0x00f9:
            if (r14 == 0) goto L_0x012d
            if (r1 != r2) goto L_0x0102
            java.lang.String r1 = r15.toString()
            goto L_0x0108
        L_0x0102:
            swisseph.SwissEph r3 = r11.sw
            java.lang.String r1 = r3.swe_get_planet_name(r1)
        L_0x0108:
            r14.setLength(r12)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r0 = r0[r10]
            r3.append(r0)
            r3.append(r7)
            r3.append(r10)
            java.lang.String r0 = ") does not exist for "
            r3.append(r0)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            r14.append(r0)
        L_0x012d:
            return r2
        L_0x012e:
            r5 = 6
            if (r3 == 0) goto L_0x0141
            if (r1 == r2) goto L_0x0135
            if (r1 < r6) goto L_0x0148
        L_0x0135:
            r0 = 5
            if (r10 != r0) goto L_0x0139
            r10 = 3
        L_0x0139:
            if (r10 != r5) goto L_0x013e
            r17 = 4
            goto L_0x014a
        L_0x013e:
            r17 = r10
            goto L_0x014a
        L_0x0141:
            r3 = 5
            if (r10 == r3) goto L_0x021f
            if (r10 != r5) goto L_0x0148
            goto L_0x021f
        L_0x0148:
            r17 = r10
        L_0x014a:
            double r18 = r11.get_synodic_period(r1)
            double r3 = (double) r8
            double r3 = r3 * r18
            double r20 = r28 + r3
            r3 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r3 = r3 * r18
            r0 = 2
            if (r1 != r0) goto L_0x0162
            r3 = 4629137466983448576(0x403e000000000000, double:30.0)
            r22 = r3
            goto L_0x0164
        L_0x0162:
            r22 = r3
        L_0x0164:
            r24 = r28
            r4 = -2
        L_0x0169:
            int r0 = (r24 > r20 ? 1 : (r24 == r20 ? 0 : -1))
            if (r0 >= 0) goto L_0x01c1
            r6 = -2
            if (r4 != r6) goto L_0x01c1
            r9.setLength(r12)
            r0 = r27
            r10 = -1
            r1 = r24
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = -2
            r6 = r15
            r12 = -2
            r7 = r17
            r26 = r8
            r8 = r35
            r33 = r9
            r9 = r36
            r10 = r33
            int r0 = r0.heliacal_ut(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r4 = r0
        L_0x0192:
            if (r4 == r12) goto L_0x01b8
            r0 = 0
            r1 = r36[r0]
            int r3 = (r1 > r28 ? 1 : (r1 == r28 ? 0 : -1))
            if (r3 >= 0) goto L_0x01b8
            double r24 = r24 + r22
            r10 = r33
            r10.setLength(r0)
            r0 = r27
            r1 = r24
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r15
            r7 = r17
            r8 = r35
            r9 = r36
            int r4 = r0.heliacal_ut(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0192
        L_0x01b8:
            double r24 = r24 + r22
            r9 = r33
            r8 = r26
            r2 = -1
            r12 = 0
            goto L_0x0169
        L_0x01c1:
            r26 = r8
            r33 = r9
            r12 = -2
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01eb
            if (r4 == r12) goto L_0x01de
            r0 = 0
            r1 = r36[r0]
            r5 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r18 = r18 * r5
            double r5 = r28 + r18
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x01da
            goto L_0x01de
        L_0x01da:
            r0 = r33
            r1 = 0
            goto L_0x01ee
        L_0x01de:
            r0 = r33
            r1 = 0
            r0.setLength(r1)
            java.lang.String r2 = "no heliacal date found within this synodic period"
            r0.append(r2)
            r4 = -2
            goto L_0x020f
        L_0x01eb:
            r0 = r33
            r1 = 0
        L_0x01ee:
            if (r4 != r12) goto L_0x020f
            r0.setLength(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "no heliacal date found within "
            r1.append(r2)
            r2 = r26
            r1.append(r2)
            java.lang.String r2 = " synodic periods"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            r4 = -1
        L_0x020f:
            if (r14 == 0) goto L_0x021e
            int r1 = r0.length()
            if (r1 == 0) goto L_0x021e
            r1 = 0
            r14.setLength(r1)
            r14.append(r0)
        L_0x021e:
            return r4
        L_0x021f:
            if (r14 == 0) goto L_0x0256
            r2 = -1
            if (r1 != r2) goto L_0x0229
            java.lang.String r1 = r15.toString()
            goto L_0x022f
        L_0x0229:
            swisseph.SwissEph r3 = r11.sw
            java.lang.String r1 = r3.swe_get_planet_name(r1)
        L_0x022f:
            r3 = 0
            r14.setLength(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r0 = r0[r10]
            r3.append(r0)
            r3.append(r7)
            r3.append(r10)
            java.lang.String r0 = ") is not provided for "
            r3.append(r0)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            r14.append(r0)
            goto L_0x0257
        L_0x0256:
            r2 = -1
        L_0x0257:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweHel.swe_heliacal_ut(double, double[], double[], double[], java.lang.StringBuffer, int, int, double[], java.lang.StringBuffer):int");
    }
}
