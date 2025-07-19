package com.cuspal.interlinks;

import java.lang.reflect.Array;
import swisseph.SweDate;

public class AstroCalc {
    static final double PADA = 3.3333333333333335d;
    static final byte P_JU = 4;
    static final byte P_KE = 8;
    static final byte P_MA = 2;
    static final byte P_ME = 3;
    static final byte P_MO = 1;
    static final byte P_RA = 7;
    static final byte P_SA = 6;
    static final byte P_SU = 0;
    static final byte P_VE = 5;
    static final double STAR_PERIOD = 13.333333333333334d;
    static final double TITHI_DURATION = 12.0d;
    public static String[] aNames = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    static double[] dasaYears = {7.0d, 20.0d, 6.0d, 10.0d, 7.0d, 18.0d, 16.0d, 19.0d, 17.0d};
    private static final byte[] pLord = {P_SU, P_MO, P_MA, P_ME, P_JU, P_VE, P_SA, P_RA, P_SU, P_MO, P_MA, P_ME, P_JU, P_VE, P_SA, P_SU, P_MO, P_MA, P_ME, P_JU, P_VE, P_SA, P_RA, P_SU, P_MO, P_MA, P_ME, P_JU, P_VE, P_RA};
    private static final String[] pStarLords = {"Ke", "Ve", "Su", "Mo", "Ma", "Ra", "Ju", "Sa", "Me", "Ke", "Ve", "Su", "Mo", "Ma", "Ra", "Ju", "Sa", "Me", "Ke", "Ve", "Su", "Mo", "Ma", "Ra", "Ju", "Sa", "Me"};
    private static final String[] pStarNamesfull = {"Aswini", "Bharani", "Krittika", "Rohini", "Mrigashirsha", "Ardra", "Punarvasu", "Pushya", "Ashlesha", "Magha", "P.Phalguni", "U.Phalguni", "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyeshtha", "Mula", "P.Ashadha", "U.Ashadha", "Shravana", "Dhanishtha", "Shatabhisha", "P.Bhadrapada", "U.Bhadrapada", "Revati"};
    private static final String[] sTithiNames = {"S.01", "S.02", "S.03", "S.04", "S.05", "S.06", "S.07", "S.08", "S.09", "S.10", "S.11", "S.12", "S.13", "S.14", "Pour", "K.01", "K.02", "K.03", "K.04", "K.05", "K.06", "K.07", "K.08", "K.09", "K.10", "K.11", "K.12", "K.13", "K.14", "Amav"};

    public static int get_StarID(double value) {
        return (int) ((1.3888888888888889E-8d + value) / STAR_PERIOD);
    }

    public static int kp_StarInt(double posVal) {
        double[] midVal = new double[29];
        for (byte i1 = P_SU; i1 <= 27; i1 = (byte) (i1 + P_MO)) {
            midVal[i1] = (((double) i1) / 27.0d) * 360.0d;
        }
        for (int j = 0; j <= 27; j = (byte) (j + 1)) {
            if (midVal[j] <= posVal && posVal < midVal[j + 1]) {
                return j;
            }
        }
        return 0;
    }

    public static int get_Star_pada(double value) {
        double xhold = 1.3888888888888889E-8d + value;
        return ((int) ((xhold - (((double) ((int) (xhold / STAR_PERIOD))) * STAR_PERIOD)) / PADA)) + 1;
    }

    public static String get_Star_Name(int starID) {
        return pStarNamesfull[starID];
    }

    public static String get_Star_Lord(int starID) {
        return pStarLords[starID];
    }

    public static int get_tithiID(double sun, double moon) {
        double moPos = moon;
        double suPos = sun;
        if (moPos < suPos) {
            moPos += 360.0d;
        }
        return (int) ((moPos - suPos) / TITHI_DURATION);
    }

    public static double get_tithi_left(int tithiId, double sun, double moon) {
        return (((((double) (tithiId + 1)) * TITHI_DURATION) - (((moon - sun) / TITHI_DURATION) * TITHI_DURATION)) * 100.0d) / TITHI_DURATION;
    }

    public static String get_tithi_lord(int tithiId) {
        return Main_details_tab.pNames[pLord[tithiId]];
    }

    public static String get_tithi_Name(int tithiId) {
        return sTithiNames[tithiId];
    }

    public static String hp_4StepFil(int inptStr) {
        String hp_4StepFil = "";
        int i = String.valueOf(inptStr).length();
        if (i == 1) {
            hp_4StepFil = " " + inptStr;
        }
        if (i == 2) {
            return String.valueOf(inptStr);
        }
        return hp_4StepFil;
    }

    public static String toDMS(double d) {
        double d2 = d + 1.3888888888888889E-8d;
        int deg = (int) d2;
        double d3 = (d2 - ((double) deg)) * 60.0d;
        int min = (int) d3;
        return String.format("%03d° %02d' %02d\"", new Object[]{Integer.valueOf(deg), Integer.valueOf(min), Integer.valueOf((int) ((d3 - ((double) min)) * 60.0d))});
    }

    public static String toDM(double d) {
        double d2 = d + 1.3888888888888889E-8d;
        int deg = (int) d2;
        double d3 = (d2 - ((double) deg)) * 60.0d;
        int min = (int) d3;
        int i = (int) ((d3 - ((double) min)) * 60.0d);
        return String.format("%03d°%02d", new Object[]{Integer.valueOf(deg), Integer.valueOf(min)});
    }

    public static String toDMS01(double d) {
        double d2 = d + 1.3888888888888889E-8d;
        int deg = (int) d2;
        double d3 = (d2 - ((double) deg)) * 60.0d;
        int min = (int) d3;
        return String.format("%03d:%02d:%02d", new Object[]{Integer.valueOf(deg), Integer.valueOf(min), Integer.valueOf((int) ((d3 - ((double) min)) * 60.0d))});
    }

    public static int hp_Rnd0To8v(double inputVal) {
        double tempVal = inputVal % 9.0d;
        if (inputVal == 0.0d) {
            return 0;
        }
        return (int) tempVal;
    }

    public static String hp_FormalDate(double dateVal) {
        double fracMnth = (dateVal - ((double) ((int) dateVal))) * TITHI_DURATION;
        double fracDts = (fracMnth - ((double) ((int) fracMnth))) * 30.0d;
        int i = (int) ((fracDts - ((double) ((int) fracDts))) * 24.0d);
        return String.format("%02d Years -%02d Months -%2d Days", new Object[]{Integer.valueOf((int) dateVal), Integer.valueOf((int) fracMnth), Integer.valueOf((int) fracDts)});
    }

    public static double hp_Rnd0To360v(double inputVal) {
        if (inputVal < 0.0d) {
            return 360.0d + inputVal;
        }
        if (inputVal >= 360.0d) {
            return inputVal - 360.0d;
        }
        return inputVal;
    }

    public static int GetLagnaSign(double gdLagna) {
        return ((int) (gdLagna / 30.0d)) % 12;
    }

    public static int GetStarLord(double gdLagna) {
        return ((int) ((1.3888888888888889E-8d + gdLagna) / STAR_PERIOD)) % 27;
    }

    public static int kp_StarLordInt(double posVal, boolean isDasa) {
        int[] starLord1Int = {8, 5, 0, 1, 2, 7, 4, 6, 3};
        double[] midVal = new double[28];
        for (byte i = P_SU; i <= 27; i = (byte) (i + P_MO)) {
            midVal[i] = ((double) (i * 360)) / 27.0d;
        }
        if (!isDasa) {
            for (byte j = P_SU; j <= 26; j = (byte) (j + P_MO)) {
                if (midVal[j] <= posVal && posVal < midVal[j + P_MO]) {
                    return starLord1Int[hp_Rnd0To8v((double) j)];
                }
            }
            return 0;
        }
        for (byte j2 = P_SU; j2 <= 26; j2 = (byte) (j2 + P_MO)) {
            if (midVal[j2] <= posVal && posVal < midVal[j2 + P_MO]) {
                return hp_Rnd0To8v((double) j2);
            }
        }
        return 0;
    }

    public static double kp_NKPA(double julDate) {
        double T = ((julDate / 365.242199d) - 4712.10699807445d) - 1900.0d;
        return (((T * 50.2388475d) + ((T * T) * 1.11E-4d)) / 3600.0d) + 22.371111111111112d;
    }

    public static int kp_PID2N(int plntIntDas) {
        int kp_PID2N = 0;
        if (plntIntDas == 0) {
            kp_PID2N = 8;
        }
        if (plntIntDas == 1) {
            kp_PID2N = 5;
        }
        if (plntIntDas == 2) {
            kp_PID2N = 0;
        }
        if (plntIntDas == 3) {
            kp_PID2N = 1;
        }
        if (plntIntDas == 4) {
            kp_PID2N = 2;
        }
        if (plntIntDas == 5) {
            kp_PID2N = 7;
        }
        if (plntIntDas == 6) {
            kp_PID2N = 4;
        }
        if (plntIntDas == 7) {
            kp_PID2N = 6;
        }
        if (plntIntDas == 8) {
            return 3;
        }
        return kp_PID2N;
    }

    public static double[] kp_SubLord02(double posVal, boolean isSubSub) {
        double d = posVal;
        double[] nakBorders = new double[28];
        byte i1 = P_SU;
        while (i1 <= 27) {
            nakBorders[i1] = (((double) i1) / 27.0d) * 360.0d;
            i1 = (byte) (i1 + P_MO);
        }
        double selVal1 = 0.0d;
        byte i2 = P_SU;
        while (true) {
            if (i2 <= 26) {
                if (nakBorders[i2] <= d && d < nakBorders[i2 + P_MO]) {
                    selVal1 = nakBorders[i2];
                    break;
                }
                i2 = (byte) (i2 + P_MO);
            } else {
                break;
            }
        }
        int selNakLord = kp_StarLordInt(d, true);
        double[] sub1LordDur = new double[9];
        int[] sub1LordInt = new int[9];
        for (byte j1 = P_SU; j1 <= 8; j1 = (byte) (j1 + P_MO)) {
            sub1LordDur[j1] = (dasaYears[hp_Rnd0To8v((double) (selNakLord + j1))] / 120.0d) * 13.3333333333333d;
        }
        for (byte j2 = P_SU; j2 <= 8; j2 = (byte) (j2 + P_MO)) {
            sub1LordInt[j2] = hp_Rnd0To8v((double) (selNakLord + j2));
        }
        double[] sub1Bor = new double[10];
        sub1Bor[0] = selVal1;
        for (byte j3 = P_SU; j3 <= 8; j3 = (byte) (j3 + P_MO)) {
            sub1Bor[j3 + P_MO] = sub1Bor[j3] + sub1LordDur[j3];
        }
        double selVal2 = 0.0d;
        double sub1Duration = 0.0d;
        int sub1Lord = 0;
        byte i3 = 0;
        while (true) {
            double[] nakBorders2 = nakBorders;
            if (i3 <= 8) {
                if (sub1Bor[i3] <= d && d < sub1Bor[i3 + P_MO]) {
                    selVal2 = sub1Bor[i3];
                    sub1Duration = sub1Bor[i3 + P_MO] - sub1Bor[i3];
                    sub1Lord = sub1LordInt[i3];
                    break;
                }
                i3 = (byte) (i3 + P_MO);
                nakBorders = nakBorders2;
            } else {
                break;
            }
        }
        byte b = i3;
        double[] sub2LordDur = new double[9];
        int[] sub2LordInt = new int[9];
        byte b2 = i1;
        double d2 = selVal1;
        double[] sub2_lord = new double[10];
        sub2_lord[0] = d;
        byte j4 = P_SU;
        while (j4 <= 8) {
            sub2LordDur[j4] = (dasaYears[hp_Rnd0To8v((double) (sub1Lord + j4))] / 120.0d) * sub1Duration;
            sub2_lord[j4 + P_MO] = sub2_lord[j4] + sub2LordDur[j4];
            j4 = (byte) (j4 + P_MO);
            double d3 = posVal;
        }
        byte j5 = P_SU;
        while (j5 <= 8) {
            sub2LordInt[j5] = hp_Rnd0To8v((double) (sub1Lord + j5));
            j5 = (byte) (j5 + P_MO);
            i2 = i2;
        }
        double[] sub2Bor = new double[10];
        sub2Bor[0] = selVal2;
        for (byte j6 = P_SU; j6 <= 8; j6 = (byte) (j6 + P_MO)) {
            sub2Bor[j6 + P_MO] = sub2Bor[j6] + sub2LordDur[j6];
        }
        return sub2_lord;
    }

    public static int kp_SubLord01(double posVal, boolean isSubSub) {
        int sub2Lord;
        double d = posVal;
        double[] nakBorders = new double[28];
        byte i1 = P_SU;
        while (i1 <= 27) {
            nakBorders[i1] = (((double) i1) / 27.0d) * 360.0d;
            i1 = (byte) (i1 + P_MO);
        }
        double selVal1 = 0.0d;
        byte i2 = P_SU;
        while (true) {
            if (i2 <= 26) {
                if (nakBorders[i2] <= d && d < nakBorders[i2 + P_MO]) {
                    selVal1 = nakBorders[i2];
                    break;
                }
                i2 = (byte) (i2 + P_MO);
            } else {
                break;
            }
        }
        int selNakLord = kp_StarLordInt(d, true);
        double[] sub1LordDur = new double[9];
        int[] sub1LordInt = new int[9];
        for (byte j1 = P_SU; j1 <= 8; j1 = (byte) (j1 + P_MO)) {
            sub1LordDur[j1] = (dasaYears[hp_Rnd0To8v((double) (selNakLord + j1))] / 120.0d) * 13.3333333333333d;
        }
        for (byte j2 = P_SU; j2 <= 8; j2 = (byte) (j2 + P_MO)) {
            sub1LordInt[j2] = hp_Rnd0To8v((double) (selNakLord + j2));
        }
        double[] sub1Bor = new double[10];
        sub1Bor[0] = selVal1;
        for (byte j3 = P_SU; j3 <= 8; j3 = (byte) (j3 + P_MO)) {
            sub1Bor[j3 + P_MO] = sub1Bor[j3] + sub1LordDur[j3];
        }
        double selVal2 = 0.0d;
        double sub1Duration = 0.0d;
        int sub1Lord = 0;
        byte i3 = 0;
        while (true) {
            double[] nakBorders2 = nakBorders;
            if (i3 <= 8) {
                if (sub1Bor[i3] <= d && d < sub1Bor[i3 + P_MO]) {
                    selVal2 = sub1Bor[i3];
                    sub1Duration = sub1Bor[i3 + P_MO] - sub1Bor[i3];
                    sub1Lord = sub1LordInt[i3];
                    break;
                }
                i3 = (byte) (i3 + P_MO);
                nakBorders = nakBorders2;
            } else {
                break;
            }
        }
        byte b = i3;
        double[] sub2LordDur = new double[9];
        int[] sub2LordInt = new int[9];
        byte b2 = i1;
        byte j4 = 0;
        while (true) {
            double selVal12 = selVal1;
            if (j4 > 8) {
                break;
            }
            sub2LordDur[j4] = (dasaYears[hp_Rnd0To8v((double) (sub1Lord + j4))] / 120.0d) * sub1Duration;
            j4 = (byte) (j4 + P_MO);
            i2 = i2;
            selVal1 = selVal12;
        }
        for (byte j5 = P_SU; j5 <= 8; j5 = (byte) (j5 + P_MO)) {
            sub2LordInt[j5] = hp_Rnd0To8v((double) (sub1Lord + j5));
        }
        double[] sub2Bor = new double[10];
        sub2Bor[0] = selVal2;
        byte j6 = P_SU;
        while (true) {
            byte j42 = j4;
            if (j6 > 8) {
                break;
            }
            sub2Bor[j6 + P_MO] = sub2Bor[j6] + sub2LordDur[j6];
            j6 = (byte) (j6 + P_MO);
            j4 = j42;
        }
        int sub2Lord2 = 0;
        double[] dArr = sub2LordDur;
        int i4 = 0;
        while (true) {
            int sub2Lord3 = sub2Lord2;
            if (i4 <= 8) {
                if (sub2Bor[i4] <= d && d < sub2Bor[i4 + 1]) {
                    double selVal3 = sub2Bor[i4];
                    double sub2Duration = sub2Bor[i4 + 1] - sub2Bor[i4];
                    sub2Lord = sub2LordInt[i4];
                    break;
                }
                i4++;
                sub2Lord2 = sub2Lord3;
            } else {
                sub2Lord = sub2Lord3;
                break;
            }
        }
        if (!isSubSub) {
            return sub1Lord;
        }
        return sub2Lord;
    }

    public static String kp_PlanetName(int planetInt, double speedVal) {
        for (byte i = P_SU; i <= 11; i = (byte) (i + P_MO)) {
            if (planetInt == i && speedVal >= 0.0d) {
                return Main_details_tab.planetName1Tr[i];
            }
            if (planetInt == i && speedVal < 0.0d) {
                return Main_details_tab.planetName1TrR[i];
            }
        }
        return null;
    }

    public static double kp_Sub249Hor(int sInt1to249) {
        double[] nakBor = new double[28];
        for (byte a0 = P_SU; a0 < 28; a0 = (byte) (a0 + P_MO)) {
            nakBor[a0] = (((double) a0) / 27.0d) * 360.0d;
        }
        double[][] sub243Bor = (double[][]) Array.newInstance(double.class, new int[]{27, 9});
        for (byte a1 = P_SU; a1 < 27; a1 = (byte) (a1 + P_MO)) {
            sub243Bor[a1][0] = nakBor[a1];
            for (byte a2 = P_SU; a2 < 8; a2 = (byte) (a2 + P_MO)) {
                sub243Bor[a1][a2 + P_MO] = sub243Bor[a1][a2] + ((dasaYears[hp_Rnd0To8v((double) (a1 + a2))] / 120.0d) * 13.3333333333333d);
            }
        }
        double[] sub243 = new double[243];
        int a5 = 0;
        for (byte a3 = P_SU; a3 < 27; a3 = (byte) (a3 + P_MO)) {
            for (byte a4 = P_SU; a4 < 9; a4 = (byte) (a4 + P_MO)) {
                sub243[a5] = sub243Bor[a3][a4];
                a5++;
            }
        }
        double[] sub249 = new double[249];
        for (int a6 = 1; a6 < 22; a6++) {
            sub249[a6] = sub243[a6];
        }
        sub249[22] = 30.0d;
        for (int a7 = 23; a7 < 62; a7++) {
            sub249[a7] = sub243[a7 - 1];
        }
        sub249[62] = 90.0d;
        for (int a8 = 63; a8 < 105; a8++) {
            sub249[a8] = sub243[a8 - 2];
        }
        sub249[105] = 150.0d;
        for (int a9 = 106; a9 < 145; a9++) {
            sub249[a9] = sub243[a9 - 3];
        }
        sub249[145] = 210.0d;
        for (int b1 = 146; b1 < 188; b1++) {
            sub249[b1] = sub243[b1 - 4];
        }
        sub249[188] = 270.0d;
        for (int b2 = 189; b2 < 228; b2++) {
            sub249[b2] = sub243[b2 - 5];
        }
        sub249[228] = 330.0d;
        for (int b3 = 229; b3 < 249; b3++) {
            sub249[b3] = sub243[b3 - 6];
        }
        return sub249[sInt1to249];
    }

    public static String[] kp_DasaShesha(double moonPos) {
        double d = moonPos;
        double[] nakBorder = new double[28];
        for (byte i1 = P_SU; i1 <= 27; i1 = (byte) (i1 + P_MO)) {
            nakBorder[i1] = (((double) i1) / 27.0d) * 360.0d;
        }
        double selNak = 0.0d;
        byte i2 = P_SU;
        while (true) {
            if (i2 <= 26) {
                if (nakBorder[i2] <= d && d < nakBorder[i2 + P_MO]) {
                    selNak = nakBorder[i2];
                    break;
                }
                i2 = (byte) (i2 + P_MO);
            } else {
                break;
            }
        }
        int nakLordInt = kp_StarLordInt(d, true);
        double d2 = dasaYears[nakLordInt];
        return new String[]{Main_details_tab.planetName2Tr[nakLordInt] + " Maha Dasa", hp_FormalDate((d2 * (13.3333333333333d - (d - selNak))) / 13.3333333333333d)};
    }

    public static String kp_RevJtime(double dblDate) {
        SweDate sd = new SweDate(dblDate);
        sd.getJulDay();
        int h1 = (int) sd.getHour();
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(h1), Integer.valueOf((int) ((sd.getHour() - ((double) h1)) * 60.0d))});
    }

    public static double kp_GeoCorr(Double geoCentricLat) {
        return Math.atan(Math.tan(geoCentricLat.doubleValue() * 0.0174532925199433d) * 0.99330546d) * 57.2957795130823d;
    }

    public static double get_sid() {
        return new SweDate(291, 4, 22, 0.0d).getJulDay();
    }

    public static void posSort(double[] posList, int min, int max) {
        for (int i = min; i <= max - 1; i++) {
            double selVal = posList[i];
            int selInt = i;
            for (int j = i + 1; j <= max; j++) {
                if (posList[j] < selVal) {
                    selVal = posList[j];
                    selInt = j;
                }
            }
            posList[selInt] = posList[i];
            posList[i] = selVal;
        }
    }

    public static double get_ayan(double Ayan) {
        return (((double) ((int) (Ayan - new SweDate(291, 4, 22, 0.0d).getJulDay()))) * 0.13754556356097866d) / 3600.0d;
    }
}
