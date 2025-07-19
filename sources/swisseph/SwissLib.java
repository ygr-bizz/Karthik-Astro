package swisseph;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class SwissLib implements Serializable {
    public static final boolean APPROXIMATE_HORIZONS_ASTRODIENST = true;
    static final double AS2R = 4.848136811095361E-6d;
    static final double D2PI = 6.283185307179586d;
    static final double DCOR_EPS_JPL_TJD0 = 2437846.5d;
    static final double DCOR_RA_JPL_TJD0 = 2437846.5d;
    public static final String DPSI_DEPS_IAU1980_FILE_EOPC04 = "eop_1962_today.txt";
    public static final String DPSI_DEPS_IAU1980_FILE_FINALS = "eop_finals.txt";
    public static final double DPSI_DEPS_IAU1980_TJD0_HORIZONS = 2437684.5d;
    static final short ENDMARK = -99;
    static final double EPS0 = 0.40909260060058295d;
    public static final double HORIZONS_TJD0_DPSI_DEPS_IAU1980 = 2437684.5d;
    public static final boolean INCLUDE_CODE_FOR_DPSI_DEPS_IAU1980 = true;
    static final int NDCOR_EPS_JPL = 51;
    static final int NDCOR_RA_JPL = 51;
    static final int NPER_PECL = 8;
    static final int NPER_PEPS = 10;
    static final int NPER_PEQU = 14;
    static final int NPOL_PECL = 4;
    static final int NPOL_PEPS = 4;
    static final int NPOL_PEQU = 4;
    static final boolean NUT_IAU_1980 = false;
    static final boolean NUT_IAU_2000A = false;
    static final boolean NUT_IAU_2000B = true;
    static final double OFFSET_EPS_JPLHORIZONS = 35.95d;
    static final double OFFSET_JPLHORIZONS = -52.3d;
    static final int PREC_BRETAGNON_2003 = 4;
    static final int PREC_IAU_1976 = 1;
    static final double PREC_IAU_1976_CTIES = 2.0d;
    static final int PREC_IAU_2000 = 2;
    static final double PREC_IAU_2000_CTIES = 2.0d;
    static final int PREC_IAU_2006 = 3;
    static final double PREC_IAU_2006_CTIES = 75.0d;
    static final double PREC_IAU_CTIES = 2.0d;
    static final int PREC_LASKAR_1986 = 5;
    static final int PREC_SIMON_1994 = 6;
    static final int PREC_VONDRAK_2011 = 8;
    static final int PREC_WILLIAMS_1994 = 7;
    static final int SIDTNARG = 14;
    static final int SIDTNTERM = 33;
    static final boolean SIDT_IERS_CONV_2010 = true;
    static final double SIDT_LTERM_OFS0 = 2.522687315E-5d;
    static final double SIDT_LTERM_OFS1 = 9.387856162999999E-5d;
    static final double SIDT_LTERM_T0 = 2396758.5d;
    static final double SIDT_LTERM_T1 = 2469807.5d;
    public static final boolean USE_HORIZONS_METHOD_BEFORE_1980 = true;
    static final boolean USE_PREC_BRETAGNON_2003 = false;
    public static final boolean USE_PREC_IAU_1976 = false;
    public static final boolean USE_PREC_IAU_2000 = false;
    public static final boolean USE_PREC_IAU_2006 = false;
    static final boolean USE_PREC_LASKAR_1986 = false;
    static final boolean USE_PREC_SIMON_1994 = false;
    static final boolean USE_PREC_VONDRAK_2011 = true;
    static final boolean USE_PREC_WILLIAMS_1994 = false;
    static short[] nt = {0, 0, 0, 0, 2, 2062, 2, -895, 5, -2, 0, 2, 0, 1, 46, 0, -24, 0, 2, 0, -2, 0, 0, 11, 0, 0, 0, -2, 0, 2, 0, 2, -3, 0, 1, 0, 1, -1, 0, -1, 0, -3, 0, 0, 0, 0, -2, 2, -2, 1, -2, 0, 1, 0, 2, 0, -2, 0, 1, 1, 0, 0, 0, 0, 0, 2, -2, 2, -13187, -16, 5736, -31, 0, 1, 0, 0, 0, 1426, -34, 54, -1, 0, 1, 2, -2, 2, -517, 12, 224, -6, 0, -1, 2, -2, 2, 217, -5, -95, 3, 0, 0, 2, -2, 1, 129, 1, -70, 0, 2, 0, 0, -2, 0, 48, 0, 1, 0, 0, 0, 2, -2, 0, -22, 0, 0, 0, 0, 2, 0, 0, 0, 17, -1, 0, 0, 0, 1, 0, 0, 1, -15, 0, 9, 0, 0, 2, 2, -2, 2, -16, 1, 7, 0, 0, -1, 0, 0, 1, -12, 0, 6, 0, -2, 0, 0, 2, 1, -6, 0, 3, 0, 0, -1, 2, -2, 1, -5, 0, 3, 0, 2, 0, 0, -2, 1, 4, 0, -2, 0, 0, 1, 2, -2, 1, 4, 0, -2, 0, 1, 0, 0, -1, 0, -4, 0, 0, 0, 2, 1, 0, -2, 0, 1, 0, 0, 0, 0, 0, -2, 2, 1, 1, 0, 0, 0, 0, 1, -2, 2, 0, -1, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, -1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 2, -2, 0, -1, 0, 0, 0, 0, 0, 2, 0, 2, -2274, -2, 977, -5, 1, 0, 0, 0, 0, 712, 1, -7, 0, 0, 0, 2, 0, 1, -386, -4, 200, 0, 1, 0, 2, 0, 2, -301, 0, 129, -1, 1, 0, 0, -2, 0, -158, 0, -1, 0, -1, 0, 2, 0, 2, 123, 0, -53, 0, 0, 0, 0, 2, 0, 63, 0, -2, 0, 1, 0, 0, 0, 1, 63, 1, -33, 0, -1, 0, 0, 0, 1, -58, -1, 32, 0, -1, 0, 2, 2, 2, -59, 0, 26, 0, 1, 0, 2, 0, 1, -51, 0, 27, 0, 0, 0, 2, 2, 2, -38, 0, 16, 0, 2, 0, 0, 0, 0, 29, 0, -1, 0, 1, 0, 2, -2, 2, 29, 0, -12, 0, 2, 0, 2, 0, 2, -31, 0, 13, 0, 0, 0, 2, 0, 0, 26, 0, -1, 0, -1, 0, 2, 0, 1, 21, 0, -10, 0, -1, 0, 0, 2, 1, 16, 0, -8, 0, 1, 0, 0, -2, 1, -13, 0, 7, 0, -1, 0, 2, 2, 1, -10, 0, 5, 0, 1, 1, 0, -2, 0, -7, 0, 0, 0, 0, 1, 2, 0, 2, 7, 0, -3, 0, 0, -1, 2, 0, 2, -7, 0, 3, 0, 1, 0, 2, 2, 2, -8, 0, 3, 0, 1, 0, 0, 2, 0, 6, 0, 0, 0, 2, 0, 2, -2, 2, 6, 0, -3, 0, 0, 0, 0, 2, 1, -6, 0, 3, 0, 0, 0, 2, 2, 1, -7, 0, 3, 0, 1, 0, 2, -2, 1, 6, 0, -3, 0, 0, 0, 0, -2, 1, -5, 0, 3, 0, 1, -1, 0, 0, 0, 5, 0, 0, 0, 2, 0, 2, 0, 1, -5, 0, 3, 0, 0, 1, 0, -2, 0, -4, 0, 0, 0, 1, 0, -2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 1, 0, -4, 0, 0, 0, 1, 1, 0, 0, 0, -3, 0, 0, 0, 1, 0, 2, 0, 0, 3, 0, 0, 0, 1, -1, 2, 0, 2, -3, 0, 1, 0, -1, -1, 2, 2, 2, -3, 0, 1, 0, -2, 0, 0, 0, 1, -2, 0, 1, 0, 3, 0, 2, 0, 2, -3, 0, 1, 0, 0, -1, 2, 2, 2, -3, 0, 1, 0, 1, 1, 2, 0, 2, 2, 0, -1, 0, -1, 0, 2, -2, 1, -2, 0, 1, 0, 2, 0, 0, 0, 1, 2, 0, -1, 0, 1, 0, 0, 0, 2, -2, 0, 1, 0, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 2, 2, 0, -1, 0, -1, 0, 0, 0, 2, 1, 0, -1, 0, 1, 0, 0, -4, 0, -1, 0, 0, 0, -2, 0, 2, 2, 2, 1, 0, -1, 0, -1, 0, 2, 4, 2, -2, 0, 1, 0, 2, 0, 0, -4, 0, -1, 0, 0, 0, 1, 1, 2, -2, 2, 1, 0, -1, 0, 1, 0, 2, 2, 1, -1, 0, 1, 0, -2, 0, 2, 4, 2, -1, 0, 1, 0, -1, 0, 4, 0, 2, 1, 0, 0, 0, 1, -1, 0, -2, 0, 1, 0, 0, 0, 2, 0, 2, -2, 1, 1, 0, -1, 0, 2, 0, 2, 2, 2, -1, 0, 0, 0, 1, 0, 0, 2, 1, -1, 0, 0, 0, 0, 0, 4, -2, 2, 1, 0, 0, 0, 3, 0, 2, -2, 2, 1, 0, 0, 0, 1, 0, 2, -2, 0, -1, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 0, -1, -1, 0, 2, 1, 1, 0, 0, 0, 0, 0, -2, 0, 1, -1, 0, 0, 0, 0, 0, 2, -1, 2, -1, 0, 0, 0, 0, 1, 0, 2, 0, -1, 0, 0, 0, 1, 0, -2, -2, 0, -1, 0, 0, 0, 0, -1, 2, 0, 1, -1, 0, 0, 0, 1, 1, 0, -2, 1, -1, 0, 0, 0, 1, 0, -2, 2, 0, -1, 0, 0, 0, 2, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 2, 4, 2, -1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, ENDMARK};
    private static final double[][] peper = {new double[]{409.9d, 396.15d, 537.22d, 402.9d, 417.15d, 288.92d, 4043.0d, 306.0d, 277.0d, 203.0d}, new double[]{-6908.287473d, -3198.706291d, 1453.674527d, -857.748557d, 1173.231614d, -156.981465d, 371.83655d, -216.61904d, 193.691479d, 11.891524d}, new double[]{753.87278d, -247.805823d, 379.471484d, -53.880558d, -90.109153d, -353.60019d, -63.115353d, -28.248187d, 17.703387d, 38.911307d}, new double[]{-2845.175469d, 449.844989d, -1255.915323d, 886.736783d, 418.887514d, 997.912441d, -240.97971d, 76.541307d, -36.788069d, -170.964086d}, new double[]{-1704.720302d, -862.308358d, 447.832178d, -889.571909d, 190.402846d, -56.564991d, -296.222622d, -75.859952d, 67.473503d, 3.014055d}};
    private static final double[][] pepol = {new double[]{8134.017132d, 84028.206305d}, new double[]{5043.0520035d, 0.3624445d}, new double[]{-0.00710733d, -4.039E-5d}, new double[]{2.71E-7d, -1.1E-7d}};
    private static final double[][] pqper = {new double[]{708.15d, 2309.0d, 1620.0d, 492.2d, 1183.0d, 622.0d, 882.0d, 547.0d}, new double[]{-5486.751211d, -17.127623d, -617.517403d, 413.44294d, 78.614193d, -180.732815d, -87.676083d, 46.140315d}, new double[]{-684.66156d, 2446.28388d, 399.671049d, -356.652376d, -186.387003d, -316.80007d, 198.296701d, 101.135679d}, new double[]{667.66673d, -2354.886252d, -428.152441d, 376.202861d, 184.778874d, 335.321713d, -185.138669d, -120.97283d}, new double[]{-5523.863691d, -549.74745d, -310.998056d, 421.535876d, -36.776172d, -145.278396d, -34.74445d, 22.885731d}};
    private static final double[][] pqpol = {new double[]{5851.607687d, -1600.8863d}, new double[]{-0.1189d, 1.1689818d}, new double[]{-2.8913E-4d, -2.0E-7d}, new double[]{1.01E-7d, -4.37E-7d}};
    private static final int[] stfarg = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, -2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, -4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 1, 0, -8, 12, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2, 2, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2, 2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, -13, 0, 0, 0, 0, 0, -1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, -2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, -2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, -2, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final double[][] xyper = {new double[]{256.75d, 708.15d, 274.2d, 241.45d, 2309.0d, 492.2d, 396.1d, 288.9d, 231.1d, 1610.0d, 620.0d, 157.87d, 220.3d, 1200.0d}, new double[]{-819.940624d, -8444.676815d, 2600.009459d, 2755.17563d, -167.659835d, 871.855056d, 44.769698d, -512.313065d, -819.415595d, -538.071099d, -189.793622d, -402.922932d, 179.516345d, -9.814756d}, new double[]{75004.344875d, 624.033993d, 1251.136893d, -1102.212834d, -2660.66498d, 699.291817d, 153.16722d, -950.865637d, 499.754645d, -145.18821d, 558.116553d, -23.923029d, -165.405086d, 9.344131d}, new double[]{81491.287984d, 787.163481d, 1251.296102d, -1257.950837d, -2966.79973d, 639.744522d, 131.600209d, -445.040117d, 584.522874d, -89.756563d, 524.42963d, -13.549067d, -210.157124d, -44.919798d}, new double[]{1558.515853d, 7774.939698d, -2219.534038d, -2523.969396d, 247.850422d, -846.485643d, -1393.124055d, 368.526116d, 749.045012d, 444.704518d, 235.934465d, 374.049623d, -171.33018d, -22.899655d}};
    private static final double[][] xypol = {new double[]{5453.282155d, -73750.93035d}, new double[]{0.4252841d, -0.7675452d}, new double[]{-3.7173E-4d, -1.8725E-4d}, new double[]{-1.52E-7d, 2.31E-7d}};
    double[] dcor_eps_jpl;
    double[] dcor_ra_jpl;
    private double[] inclcof_laskar;
    private double[] inclcof_simon;
    private double[] inclcof_williams;
    private double[] nodecof_laskar;
    private double[] nodecof_simon;
    private double[] nodecof_williams;
    private double[] pAcof_laskar;
    private double[] pAcof_simon;
    private double[] pAcof_williams;
    private double[] stcf;
    SwissData swed;

    public SwissLib() {
        this((SwissData) null);
    }

    public SwissLib(SwissData swissData) {
        this.dcor_eps_jpl = new double[]{36.726d, 36.627d, 36.595d, 36.578d, 36.64d, 36.659d, 36.731d, 36.765d, 36.662d, 36.555d, 36.335d, 36.321d, 36.354d, 36.227d, 36.289d, 36.348d, 36.257d, 36.163d, 35.979d, 35.896d, 35.842d, 35.825d, 35.912d, OFFSET_EPS_JPLHORIZONS, 36.093d, 36.191d, 36.009d, 35.943d, 35.875d, 35.771d, 35.788d, 35.753d, 35.822d, 35.866d, 35.771d, 35.732d, 35.543d, 35.498d, 35.449d, 35.409d, 35.497d, 35.556d, 35.672d, 35.76d, 35.596d, 35.565d, 35.51d, 35.394d, 35.385d, 35.375d, 35.415d};
        this.pAcof_williams = new double[]{-8.66E-10d, -4.759E-8d, 2.424E-7d, 1.3095E-5d, 1.7451E-4d, -0.0018055d, -0.235316d, 0.076d, 110.5407d, 50287.7d};
        this.nodecof_williams = new double[]{6.6402E-16d, -2.69151E-15d, -1.547021E-12d, 7.521313E-12d, 1.9E-10d, -3.54E-9d, -1.8103E-7d, 1.26E-7d, 7.436169E-5d, -0.04207794833d, 3.052115282424d};
        this.inclcof_williams = new double[]{1.2147E-16d, 7.3759E-17d, -8.26287E-14d, 2.50341E-13d, 2.4650839E-11d, -5.4000441E-11d, 1.32115526E-9d, -6.012E-7d, -1.62442E-5d, 0.00227850649d, 0.0d};
        this.pAcof_simon = new double[]{-8.66E-10d, -4.759E-8d, 2.424E-7d, 1.3095E-5d, 1.7451E-4d, -0.0018055d, -0.235316d, 0.07732d, 111.2022d, 50288.2d};
        this.nodecof_simon = new double[]{6.6402E-16d, -2.69151E-15d, -1.547021E-12d, 7.521313E-12d, 1.9E-10d, -3.54E-9d, -1.8103E-7d, 2.579E-8d, 7.4379679E-5d, -0.04207829d, 3.0521126906d};
        this.inclcof_simon = new double[]{1.2147E-16d, 7.3759E-17d, -8.26287E-14d, 2.50341E-13d, 2.4650839E-11d, -5.4000441E-11d, 1.32115526E-9d, -5.99908E-7d, -1.624383E-5d, 0.002278492868d, 0.0d};
        this.pAcof_laskar = new double[]{-8.66E-10d, -4.759E-8d, 2.424E-7d, 1.3095E-5d, 1.7451E-4d, -0.0018055d, -0.235316d, 0.07732d, 111.1971d, 50290.966d};
        this.nodecof_laskar = new double[]{6.6402E-16d, -2.69151E-15d, -1.547021E-12d, 7.521313E-12d, 6.3190131E-10d, -3.48388152E-9d, -1.813065896E-7d, 2.75036225E-8d, 7.4394531426E-5d, -0.042078604317d, 3.052112654975d};
        this.inclcof_laskar = new double[]{1.2147E-16d, 7.3759E-17d, -8.26287E-14d, 2.50341E-13d, 2.4650839E-11d, -5.4000441E-11d, 1.32115526E-9d, -5.998737027E-7d, -1.6242797091E-5d, 0.002278495537d, 0.0d};
        this.dcor_ra_jpl = new double[]{-51.257d, -51.103d, -51.065d, -51.503d, -51.224d, -50.796d, -51.161d, -51.181d, -50.932d, -51.064d, -51.182d, -51.386d, -51.416d, -51.428d, -51.586d, -51.766d, -52.038d, -52.37d, -52.553d, -52.397d, -52.34d, -52.676d, -52.348d, -51.964d, -52.444d, -52.364d, -51.988d, -52.212d, -52.37d, -52.523d, -52.541d, -52.496d, -52.59d, -52.629d, -52.788d, -53.014d, -53.053d, -52.902d, -52.85d, -53.087d, -52.635d, -52.185d, -52.588d, -52.292d, -51.796d, -51.961d, -52.055d, -52.134d, -52.165d, -52.141d, -52.255d};
        this.stcf = new double[]{2640.96d, -0.39d, 63.52d, -0.02d, 11.75d, 0.01d, 11.21d, 0.01d, -4.55d, 0.0d, 2.02d, 0.0d, 1.98d, 0.0d, -1.72d, 0.0d, -1.41d, -0.01d, -1.26d, -0.01d, -0.63d, 0.0d, -0.63d, 0.0d, 0.46d, 0.0d, 0.45d, 0.0d, 0.36d, 0.0d, -0.24d, -0.12d, 0.32d, 0.0d, 0.28d, 0.0d, 0.27d, 0.0d, 0.26d, 0.0d, -0.21d, 0.0d, 0.19d, 0.0d, 0.18d, 0.0d, -0.1d, 0.05d, 0.15d, 0.0d, -0.14d, 0.0d, 0.14d, 0.0d, -0.14d, 0.0d, 0.14d, 0.0d, 0.13d, 0.0d, -0.11d, 0.0d, 0.11d, 0.0d, 0.11d, 0.0d};
        this.swed = swissData;
        if (swissData == null) {
            this.swed = new SwissData();
        }
    }

    public double square_sum(double[] dArr) {
        return (dArr[0] * dArr[0]) + (dArr[1] * dArr[1]) + (dArr[2] * dArr[2]);
    }

    public double square_sum(double[] dArr, int i) {
        double d = dArr[i] * dArr[i];
        int i2 = i + 1;
        int i3 = i + 2;
        return d + (dArr[i2] * dArr[i2]) + (dArr[i3] * dArr[i3]);
    }

    public double swe_degnorm(double d) {
        double d2 = d % 360.0d;
        if (SMath.abs(d2) < 1.0E-13d) {
            d2 = 0.0d;
        }
        if (d2 < 0.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public double swe_radnorm(double d) {
        double d2 = d % D2PI;
        if (SMath.abs(d2) < 1.0E-13d) {
            d2 = 0.0d;
        }
        if (d2 < 0.0d) {
            return d2 + D2PI;
        }
        return d2;
    }

    public double swe_deg_midp(double d, double d2) {
        return swe_degnorm(d2 + (swe_difdeg2n(d, d2) / 2.0d));
    }

    public double swe_rad_midp(double d, double d2) {
        return swe_deg_midp(d * 57.2957795130823d, d2 * 57.2957795130823d) * 0.0174532925199433d;
    }

    public double swi_mod2PI(double d) {
        double d2 = d % D2PI;
        if (d2 < 0.0d) {
            return d2 + D2PI;
        }
        return d2;
    }

    public double swi_angnorm(double d) {
        if (d < 0.0d) {
            return d + D2PI;
        }
        if (d >= D2PI) {
            return d - D2PI;
        }
        return d;
    }

    public void swi_cross_prod(double[] dArr, int i, double[] dArr2, int i2, double[] dArr3, int i3) {
        int i4 = i + 1;
        int i5 = i2 + 2;
        int i6 = i + 2;
        int i7 = i2 + 1;
        dArr3[i3 + 0] = (dArr[i4] * dArr2[i5]) - (dArr[i6] * dArr2[i7]);
        double d = dArr[i6];
        int i8 = i2 + 0;
        int i9 = i + 0;
        dArr3[i3 + 1] = (d * dArr2[i8]) - (dArr[i9] * dArr2[i5]);
        dArr3[i3 + 2] = (dArr[i9] * dArr2[i7]) - (dArr[i4] * dArr2[i8]);
    }

    public double swi_echeb(double d, double[] dArr, int i, int i2) {
        double d2 = d * 2.0d;
        int i3 = i2 - 1;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (i3 >= 0) {
            i3--;
            double d6 = ((d2 * d3) - d5) + dArr[i3 + i];
            d4 = d5;
            d5 = d3;
            d3 = d6;
        }
        return (d3 - d4) * 0.5d;
    }

    public double swi_edcheb(double d, double[] dArr, int i, int i2) {
        double d2 = 2.0d * d;
        int i3 = i2 - 1;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        while (i3 >= 1) {
            double d9 = (dArr[i3 + i] * ((double) (i3 + i3))) + d5;
            d3 = ((d2 * d6) - d7) + d9;
            i3--;
            d5 = d8;
            d8 = d9;
            d4 = d7;
            d7 = d6;
            d6 = d3;
        }
        return (d3 - d4) * 0.5d;
    }

    public void swe_cotrans(double[] dArr, double[] dArr2, double d) {
        swe_cotrans(dArr, 0, dArr2, 0, d);
    }

    public void swe_cotrans(double[] dArr, int i, double[] dArr2, int i2, double d) {
        double[] dArr3 = new double[6];
        double d2 = d * 0.0174532925199433d;
        for (int i3 = 0; i3 <= 1; i3++) {
            dArr3[i3] = dArr[i3 + i];
        }
        dArr3[0] = dArr3[0] * 0.0174532925199433d;
        dArr3[1] = dArr3[1] * 0.0174532925199433d;
        dArr3[2] = 1.0d;
        for (int i4 = 3; i4 <= 5; i4++) {
            dArr3[i4] = 0.0d;
        }
        swi_polcart(dArr3, dArr3);
        swi_coortrf(dArr3, dArr3, d2);
        swi_cartpol(dArr3, dArr3);
        dArr2[i2] = dArr3[0] * 57.2957795130823d;
        dArr2[i2 + 1] = dArr3[1] * 57.2957795130823d;
        dArr2[i2 + 2] = dArr[i + 2];
    }

    public void swe_cotrans_sp(double[] dArr, double[] dArr2, double d) {
        double[] dArr3 = dArr2;
        double[] dArr4 = new double[6];
        double d2 = d * 0.0174532925199433d;
        for (int i = 0; i <= 5; i++) {
            dArr4[i] = dArr[i];
        }
        dArr4[0] = dArr4[0] * 0.0174532925199433d;
        dArr4[1] = dArr4[1] * 0.0174532925199433d;
        dArr4[2] = 1.0d;
        dArr4[3] = dArr4[3] * 0.0174532925199433d;
        dArr4[4] = dArr4[4] * 0.0174532925199433d;
        swi_polcart_sp(dArr4, dArr4);
        swi_coortrf(dArr4, dArr4, d2);
        swi_coortrf(dArr4, 3, dArr4, 3, d2);
        swi_cartpol_sp(dArr4, dArr3);
        dArr3[0] = dArr3[0] * 57.2957795130823d;
        dArr3[1] = dArr3[1] * 57.2957795130823d;
        dArr3[2] = dArr[2];
        dArr3[3] = dArr3[3] * 57.2957795130823d;
        dArr3[4] = dArr3[4] * 57.2957795130823d;
        dArr3[5] = dArr[5];
    }

    public void swi_coortrf(double[] dArr, double[] dArr2, double d) {
        swi_coortrf(dArr, 0, dArr2, 0, d);
    }

    public void swi_coortrf(double[] dArr, int i, double[] dArr2, int i2, double d) {
        double sin = SMath.sin(d);
        double cos = SMath.cos(d);
        int i3 = i + 1;
        int i4 = i + 2;
        double[] dArr3 = {dArr[i], (dArr[i3] * cos) + (dArr[i4] * sin), ((-dArr[i3]) * sin) + (dArr[i4] * cos)};
        dArr2[i2 + 0] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        dArr2[i2 + 2] = dArr3[2];
    }

    public void swi_coortrf2(double[] dArr, double[] dArr2, double d, double d2) {
        swi_coortrf2(dArr, 0, dArr2, 0, d, d2);
    }

    public void swi_coortrf2(double[] dArr, int i, double[] dArr2, int i2, double d, double d2) {
        int i3 = i + 1;
        int i4 = i + 2;
        double[] dArr3 = {dArr[i + 0], (dArr[i3] * d2) + (dArr[i4] * d), ((-dArr[i3]) * d) + (dArr[i4] * d2)};
        dArr2[i2 + 0] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        dArr2[i2 + 2] = dArr3[2];
    }

    public void swi_cartpol(double[] dArr, double[] dArr2) {
        swi_cartpol(dArr, 0, dArr2, 0);
    }

    public void swi_cartpol(double[] dArr, int i, double[] dArr2, int i2) {
        double[] dArr3 = new double[3];
        int i3 = i + 0;
        if (dArr[i3] == 0.0d && dArr[i + 1] == 0.0d && dArr[i + 2] == 0.0d) {
            dArr2[i2 + 2] = 0.0d;
            dArr2[i2 + 1] = 0.0d;
            dArr2[i2 + 0] = 0.0d;
            return;
        }
        int i4 = i + 1;
        double d = (dArr[i3] * dArr[i3]) + (dArr[i4] * dArr[i4]);
        int i5 = i + 2;
        dArr3[2] = SMath.sqrt((dArr[i5] * dArr[i5]) + d);
        double sqrt = SMath.sqrt(d);
        dArr3[0] = SMath.atan2(dArr[i4], dArr[i3]);
        if (dArr3[0] < 0.0d) {
            dArr3[0] = dArr3[0] + D2PI;
        }
        dArr3[1] = SMath.atan(dArr[i5] / sqrt);
        dArr2[i2 + 0] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        dArr2[i2 + 2] = dArr3[2];
    }

    public void swi_polcart(double[] dArr, double[] dArr2) {
        swi_polcart(dArr, 0, dArr2, 0);
    }

    public void swi_polcart(double[] dArr, int i, double[] dArr2, int i2) {
        int i3 = i + 1;
        double cos = SMath.cos(dArr[i3]);
        int i4 = i + 2;
        double[] dArr3 = {dArr[i4] * cos * SMath.cos(dArr[i]), dArr[i4] * cos * SMath.sin(dArr[i]), dArr[i4] * SMath.sin(dArr[i3])};
        dArr2[i2] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        dArr2[i2 + 2] = dArr3[2];
    }

    public void swi_cartpol_sp(double[] dArr, double[] dArr2) {
        swi_cartpol_sp(dArr, 0, dArr2, 0);
    }

    public void swi_cartpol_sp(double[] dArr, int i, double[] dArr2, int i2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        int i3 = i + 0;
        if (dArr3[i3] == 0.0d && dArr3[i + 1] == 0.0d && dArr3[i + 2] == 0.0d) {
            int i4 = i2 + 0;
            dArr4[i2 + 4] = 0.0d;
            dArr4[i2 + 3] = 0.0d;
            dArr4[i2 + 1] = 0.0d;
            dArr4[i4] = 0.0d;
            int i5 = i + 3;
            dArr4[i2 + 5] = SMath.sqrt(square_sum(dArr3, i5));
            swi_cartpol(dArr3, i5, dArr4, i4);
            dArr4[i2 + 2] = 0.0d;
            return;
        }
        int i6 = i + 3;
        if (dArr3[i6] == 0.0d && dArr3[i + 4] == 0.0d && dArr3[i + 5] == 0.0d) {
            dArr4[i2 + 5] = 0.0d;
            dArr4[i2 + 4] = 0.0d;
            dArr4[i2 + 3] = 0.0d;
            swi_cartpol(dArr, i, dArr2, i2);
            return;
        }
        int i7 = i + 1;
        double d = (dArr3[i3] * dArr3[i3]) + (dArr3[i7] * dArr3[i7]);
        int i8 = i + 2;
        dArr6[2] = SMath.sqrt((dArr3[i8] * dArr3[i8]) + d);
        double sqrt = SMath.sqrt(d);
        dArr6[0] = SMath.atan2(dArr3[i7], dArr3[i3]);
        if (dArr6[0] < 0.0d) {
            dArr6[0] = dArr6[0] + D2PI;
        }
        dArr6[1] = SMath.atan(dArr3[i8] / sqrt);
        double d2 = dArr3[i3] / sqrt;
        double d3 = dArr3[i7] / sqrt;
        double d4 = sqrt / dArr6[2];
        double d5 = dArr3[i8] / dArr6[2];
        int i9 = i + 4;
        dArr5[3] = (dArr3[i6] * d2) + (dArr3[i9] * d3);
        dArr5[4] = ((-dArr3[i6]) * d3) + (dArr3[i9] * d2);
        dArr4[i2 + 3] = dArr5[4] / sqrt;
        int i10 = i + 5;
        dArr5[4] = ((-d5) * dArr5[3]) + (dArr3[i10] * d4);
        dArr5[5] = (d4 * dArr5[3]) + (d5 * dArr3[i10]);
        dArr4[i2 + 4] = dArr5[4] / dArr6[2];
        dArr4[i2 + 5] = dArr5[5];
        dArr4[i2 + 0] = dArr6[0];
        dArr4[i2 + 1] = dArr6[1];
        dArr4[i2 + 2] = dArr6[2];
    }

    public void swi_polcart_sp(double[] dArr, double[] dArr2) {
        swi_polcart_sp(dArr, 0, dArr2, 0);
    }

    public void swi_polcart_sp(double[] dArr, int i, double[] dArr2, int i2) {
        double[] dArr3 = new double[6];
        int i3 = i + 3;
        if (dArr[i3] == 0.0d && dArr[i + 4] == 0.0d && dArr[i + 5] == 0.0d) {
            dArr2[i2 + 5] = 0.0d;
            dArr2[i2 + 4] = 0.0d;
            dArr2[i2 + 3] = 0.0d;
            swi_polcart(dArr, i, dArr2, i2);
            return;
        }
        int i4 = i + 0;
        double cos = SMath.cos(dArr[i4]);
        double sin = SMath.sin(dArr[i4]);
        int i5 = i + 1;
        double cos2 = SMath.cos(dArr[i5]);
        double sin2 = SMath.sin(dArr[i5]);
        int i6 = i + 2;
        dArr3[0] = dArr[i6] * cos2 * cos;
        dArr3[1] = dArr[i6] * cos2 * sin;
        dArr3[2] = dArr[i6] * sin2;
        double d = dArr[i6];
        double sqrt = SMath.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
        dArr3[5] = dArr[i + 5];
        dArr3[4] = dArr[i + 4] * d;
        dArr2[i2 + 5] = (dArr3[5] * sin2) + (dArr3[4] * cos2);
        dArr3[3] = (cos2 * dArr3[5]) - (sin2 * dArr3[4]);
        dArr3[4] = dArr[i3] * sqrt;
        dArr2[i2 + 3] = (dArr3[3] * cos) - (dArr3[4] * sin);
        dArr2[i2 + 4] = (sin * dArr3[3]) + (cos * dArr3[4]);
        dArr2[i2 + 0] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        dArr2[i2 + 2] = dArr3[2];
    }

    public double swi_dot_prod_unit(double[] dArr, double[] dArr2) {
        double sqrt = ((((dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1])) + (dArr[2] * dArr2[2])) / SMath.sqrt(((dArr[0] * dArr[0]) + (dArr[1] * dArr[1])) + (dArr[2] * dArr[2]))) / SMath.sqrt(((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1])) + (dArr2[2] * dArr2[2]));
        if (sqrt > 1.0d) {
            sqrt = 1.0d;
        }
        if (sqrt < -1.0d) {
            return -1.0d;
        }
        return sqrt;
    }

    /* access modifiers changed from: package-private */
    public void swi_ldp_peps(double d, double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        double d2 = (d - 2451545.0d) / 36525.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        for (int i = 0; i < 10; i++) {
            double d5 = D2PI * d2;
            double[][] dArr5 = peper;
            double d6 = d5 / dArr5[0][i];
            double sin = SMath.sin(d6);
            double cos = SMath.cos(d6);
            d3 += (dArr5[1][i] * cos) + (dArr5[3][i] * sin);
            d4 += (cos * dArr5[2][i]) + (sin * dArr5[4][i]);
        }
        double d7 = 1.0d;
        for (int i2 = 0; i2 < 4; i2++) {
            double[][] dArr6 = pepol;
            d3 += dArr6[i2][0] * d7;
            d4 += dArr6[i2][1] * d7;
            d7 *= d2;
        }
        double d8 = d3 * AS2R;
        double d9 = d4 * AS2R;
        if (dArr3 != null && dArr3.length > 0) {
            dArr3[0] = d8;
        }
        if (dArr4 != null && dArr4.length > 0) {
            dArr4[0] = d9;
        }
    }

    private void pre_pecl(double d, double[] dArr) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (int i = 0; i < 8; i++) {
            double d6 = D2PI * d2;
            double[][] dArr2 = pqper;
            double d7 = d6 / dArr2[0][i];
            double sin = SMath.sin(d7);
            double cos = SMath.cos(d7);
            d4 += (dArr2[1][i] * cos) + (dArr2[3][i] * sin);
            d5 += (cos * dArr2[2][i]) + (sin * dArr2[4][i]);
        }
        double d8 = 1.0d;
        for (int i2 = 0; i2 < 4; i2++) {
            double[][] dArr3 = pqpol;
            d4 += dArr3[i2][0] * d8;
            d5 += dArr3[i2][1] * d8;
            d8 *= d2;
        }
        double d9 = d4 * AS2R;
        double d10 = d5 * AS2R;
        double d11 = (1.0d - (d9 * d9)) - (d10 * d10);
        if (d11 >= 0.0d) {
            d3 = SMath.sqrt(d11);
        }
        double sin2 = SMath.sin(EPS0);
        double cos2 = SMath.cos(EPS0);
        dArr[0] = d9;
        double d12 = -d10;
        dArr[1] = (d12 * cos2) - (d3 * sin2);
        dArr[2] = (d12 * sin2) + (d3 * cos2);
    }

    private void pre_pequ(double d, double[] dArr) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        for (int i = 0; i < 14; i++) {
            double d5 = D2PI * d2;
            double[][] dArr2 = xyper;
            double d6 = d5 / dArr2[0][i];
            double sin = SMath.sin(d6);
            double cos = SMath.cos(d6);
            d3 += (dArr2[1][i] * cos) + (dArr2[3][i] * sin);
            d4 += (cos * dArr2[2][i]) + (sin * dArr2[4][i]);
        }
        double d7 = 1.0d;
        for (int i2 = 0; i2 < 4; i2++) {
            double[][] dArr3 = xypol;
            d3 += dArr3[i2][0] * d7;
            d4 += dArr3[i2][1] * d7;
            d7 *= d2;
        }
        double d8 = d3 * AS2R;
        double d9 = d4 * AS2R;
        dArr[0] = d8;
        dArr[1] = d9;
        double d10 = (d8 * d8) + (d9 * d9);
        if (d10 < 1.0d) {
            dArr[2] = SMath.sqrt(1.0d - d10);
        } else {
            dArr[2] = 0.0d;
        }
    }

    private void pre_pmat(double d, double[] dArr) {
        double[] dArr2 = new double[3];
        double[] dArr3 = new double[3];
        double[] dArr4 = new double[3];
        pre_pequ(d, dArr2);
        pre_pecl(d, dArr3);
        swi_cross_prod(dArr2, 0, dArr3, 0, dArr4, 0);
        double sqrt = SMath.sqrt((dArr4[0] * dArr4[0]) + (dArr4[1] * dArr4[1]) + (dArr4[2] * dArr4[2]));
        double[] dArr5 = {dArr4[0] / sqrt, dArr4[1] / sqrt, dArr4[2] / sqrt};
        swi_cross_prod(dArr2, 0, dArr5, 0, dArr4, 0);
        dArr[0] = dArr5[0];
        dArr[1] = dArr5[1];
        dArr[2] = dArr5[2];
        dArr[3] = dArr4[0];
        dArr[4] = dArr4[1];
        dArr[5] = dArr4[2];
        dArr[6] = dArr2[0];
        dArr[7] = dArr2[1];
        dArr[8] = dArr2[2];
    }

    /* access modifiers changed from: package-private */
    public double swi_epsiln(double d, int i) {
        double d2;
        double d3 = (d - 2451545.0d) / 36525.0d;
        if ((262144 & i) != 0) {
            return (((((((0.001813d * d3) - 5.9E-4d) * d3) - 46.815d) * d3) + 84381.448d) * 0.0174532925199433d) / 3600.0d;
        }
        int i2 = i & 524288;
        double[] dArr = new double[1];
        swi_ldp_peps(d, (double[]) null, dArr);
        double d4 = dArr[0];
        if (i2 == 0) {
            return d4;
        }
        double d5 = (d - 2437846.5d) / 365.25d;
        if (d5 < 0.0d) {
            d2 = this.dcor_eps_jpl[0];
        } else if (d5 >= 50.0d) {
            d2 = this.dcor_eps_jpl[50];
        } else {
            double d6 = (double) ((int) d5);
            double[] dArr2 = this.dcor_eps_jpl;
            int i3 = (int) d6;
            double d7 = dArr2[i3];
            d2 = ((d5 - d6) * (dArr2[i3] - dArr2[(int) (1.0d + d6)])) + dArr2[i3];
        }
        return d4 + ((d2 / 3600000.0d) * 0.0174532925199433d);
    }

    private int precess_1(double[] dArr, double d, int i, int i2) {
        return precess_1(dArr, 0, d, i, i2);
    }

    private int precess_1(double[] dArr, int i, double d, int i2, int i3) {
        double d2;
        double d3;
        int i4 = i3;
        double[] dArr2 = new double[3];
        if (d == 2451545.0d) {
            return 0;
        }
        double d4 = (d - 2451545.0d) / 36525.0d;
        double d5 = 0.0d;
        if (i4 == 1) {
            d2 = ((((((0.018203d * d4) + 1.09468d) * d4) + 2306.2181d) * d4) * 0.0174532925199433d) / 3600.0d;
            double d6 = ((((((-0.041833d * d4) - 0.42665d) * d4) + 2004.3109d) * d4) * 0.0174532925199433d) / 3600.0d;
            d3 = ((((((0.017998d * d4) + 0.30188d) * d4) + 2306.2181d) * d4) * 0.0174532925199433d) / 3600.0d;
            d5 = d6;
        } else if (i4 == 2) {
            d2 = (((((((((((-3.0E-7d * d4) - 4.7E-5d) * d4) + 0.0182237d) * d4) + 1.094779d) * d4) + 2306.0803226d) * d4) - 2.5976176d) * 0.0174532925199433d) / 3600.0d;
            double d7 = ((((((((((-1.0E-7d * d4) - 6.01E-5d) * d4) - 0.0418251d) * d4) - 0.4269353d) * d4) + 2004.1917476d) * d4) * 0.0174532925199433d) / 3600.0d;
            d3 = (((((((((((-2.0E-7d * d4) - 3.27E-5d) * d4) + 0.0179663d) * d4) + 0.3019015d) * d4) + 2306.0809506d) * d4) + 2.5976176d) * 0.0174532925199433d) / 3600.0d;
            d5 = d7;
        } else if (i4 == 3) {
            d2 = (((((((((((-2.904E-7d * d4) - 2.8596E-5d) * d4) + 0.01826837d) * d4) + 1.0927348d) * d4) + 2306.077181d) * d4) - 2.650545d) * 0.0174532925199433d) / 3600.0d;
            double d8 = ((((((((((-1.1274E-7d * d4) - 7.089E-6d) * d4) - 0.04182264d) * d4) - 0.4294934d) * d4) + 2004.191903d) * d4) * 0.0174532925199433d) / 3600.0d;
            d3 = (((((((((((-3.173E-7d * d4) - 5.971E-6d) * d4) + 0.01801828d) * d4) + 0.2988499d) * d4) + 2306.083227d) * d4) + 2.650545d) * 0.0174532925199433d) / 3600.0d;
            d5 = d8;
        } else if (i4 == 4) {
            d2 = (((((((((((((-5.0E-11d * d4) - 2.486E-7d) * d4) - 2.8276E-5d) * d4) + 0.01826676d) * d4) + 1.0956768d) * d4) + 2306.07607d) * d4) - 2.72767d) * 0.0174532925199433d) / 3600.0d;
            double d9 = ((((((((((((((9.0E-12d * d4) + 3.6E-10d) * d4) - 1.127E-7d) * d4) - 7.291E-6d) * d4) - 0.04182364d) * d4) - 0.426698d) * d4) + 2004.190936d) * d4) * 0.0174532925199433d) / 3600.0d;
            d3 = (((((((((((((-1.3E-10d * d4) - 3.04E-7d) * d4) - 5.708E-6d) * d4) + 0.01801752d) * d4) + 0.3023262d) * d4) + 2306.080472d) * d4) + 2.72767d) * 0.0174532925199433d) / 3600.0d;
            d5 = d9;
        } else {
            d3 = 0.0d;
            d2 = 0.0d;
        }
        double sin = SMath.sin(d5);
        double cos = SMath.cos(d5);
        double sin2 = SMath.sin(d3);
        double cos2 = SMath.cos(d3);
        double sin3 = SMath.sin(d2);
        double cos3 = SMath.cos(d2);
        double d10 = cos2 * cos;
        double d11 = sin2 * cos;
        if (i2 < 0) {
            int i5 = i + 0;
            int i6 = i + 1;
            int i7 = i + 2;
            dArr2[0] = ((((d10 * cos3) - (sin2 * sin3)) * dArr[i5]) - (((d11 * cos3) + (cos2 * sin3)) * dArr[i6])) - ((sin * cos3) * dArr[i7]);
            dArr2[1] = ((((d10 * sin3) + (sin2 * cos3)) * dArr[i5]) - (((d11 * sin3) - (cos3 * cos2)) * dArr[i6])) - ((sin3 * sin) * dArr[i7]);
            dArr2[2] = (((cos2 * sin) * dArr[i5]) - ((sin2 * sin) * dArr[i6])) + (cos * dArr[i7]);
        } else {
            int i8 = i + 0;
            int i9 = i + 1;
            int i10 = i + 2;
            dArr2[0] = (((d10 * cos3) - (sin2 * sin3)) * dArr[i8]) + (((d10 * sin3) + (sin2 * cos3)) * dArr[i9]) + (cos2 * sin * dArr[i10]);
            dArr2[1] = (((-((d11 * cos3) + (cos2 * sin3))) * dArr[i8]) - (((d11 * sin3) - (cos2 * cos3)) * dArr[i9])) - ((sin2 * sin) * dArr[i10]);
            dArr2[2] = ((((-sin) * cos3) * dArr[i8]) - ((sin * sin3) * dArr[i9])) + (cos * dArr[i10]);
        }
        for (int i11 = 0; i11 < 3; i11++) {
            dArr[i11 + i] = dArr2[i11];
        }
        return 0;
    }

    private int precess_2(double[] dArr, double d, int i, int i2, int i3) {
        return precess_2(dArr, 0, d, i, i2, i3);
    }

    private int precess_2(double[] dArr, int i, double d, int i2, int i3, int i4) {
        double[] dArr2;
        double[] dArr3;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = d;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        double[] dArr4 = new double[3];
        if (d6 == 2451545.0d) {
            return 0;
        }
        double[] dArr5 = null;
        if (i7 == 5) {
            dArr5 = this.pAcof_laskar;
            dArr3 = this.nodecof_laskar;
            dArr2 = this.inclcof_laskar;
        } else if (i7 == 6) {
            dArr5 = this.pAcof_simon;
            dArr3 = this.nodecof_simon;
            dArr2 = this.inclcof_simon;
        } else if (i7 == 7) {
            dArr5 = this.pAcof_williams;
            dArr3 = this.nodecof_williams;
            dArr2 = this.inclcof_williams;
        } else {
            dArr3 = null;
            dArr2 = null;
        }
        double d7 = (d6 - 2451545.0d) / 36525.0d;
        if (i6 == 1) {
            d2 = swi_epsiln(d6, i5);
        } else {
            d2 = swi_epsiln(2451545.0d, i5);
        }
        double sin = SMath.sin(d2);
        double cos = SMath.cos(d2);
        dArr4[0] = dArr[i + 0];
        int i8 = i + 1;
        int i9 = i + 2;
        double d8 = (dArr[i8] * cos) + (dArr[i9] * sin);
        dArr4[2] = ((-sin) * dArr[i8]) + (cos * dArr[i9]);
        dArr4[1] = d8;
        double d9 = d7 / 10.0d;
        double d10 = dArr5[0];
        int i10 = 1;
        for (int i11 = 0; i11 < 9; i11++) {
            d10 = (d10 * d9) + dArr5[i10];
            i10++;
        }
        double d11 = d10 * AS2R * d9;
        double d12 = dArr3[0];
        int i12 = 1;
        for (int i13 = 0; i13 < 10; i13++) {
            d12 = (d12 * d9) + dArr3[i12];
            i12++;
        }
        if (i6 == 1) {
            d3 = d12 + d11;
        } else {
            d3 = d12;
        }
        double cos2 = SMath.cos(d3);
        double sin2 = SMath.sin(d3);
        double d13 = (dArr4[0] * cos2) + (dArr4[1] * sin2);
        dArr4[1] = ((-sin2) * dArr4[0]) + (cos2 * dArr4[1]);
        dArr4[0] = d13;
        double d14 = dArr2[0];
        int i14 = 1;
        for (int i15 = 0; i15 < 10; i15++) {
            d14 = (d14 * d9) + dArr2[i14];
            i14++;
        }
        if (i6 == 1) {
            d14 = -d14;
        }
        double cos3 = SMath.cos(d14);
        double sin3 = SMath.sin(d14);
        double d15 = (dArr4[1] * cos3) + (dArr4[2] * sin3);
        dArr4[2] = ((-sin3) * dArr4[1]) + (cos3 * dArr4[2]);
        dArr4[1] = d15;
        if (i6 == 1) {
            d4 = -d12;
        } else {
            d4 = (-d12) - d11;
        }
        double cos4 = SMath.cos(d4);
        double sin4 = SMath.sin(d4);
        double d16 = (dArr4[0] * cos4) + (dArr4[1] * sin4);
        dArr4[1] = ((-sin4) * dArr4[0]) + (cos4 * dArr4[1]);
        dArr4[0] = d16;
        if (i6 == 1) {
            d5 = swi_epsiln(2451545.0d, i5);
        } else {
            d5 = swi_epsiln(d, i5);
        }
        double sin5 = SMath.sin(d5);
        double cos5 = SMath.cos(d5);
        double d17 = (dArr4[1] * cos5) - (dArr4[2] * sin5);
        dArr4[2] = (sin5 * dArr4[1]) + (cos5 * dArr4[2]);
        dArr4[1] = d17;
        for (int i16 = 0; i16 < 3; i16++) {
            dArr[i16 + i] = dArr4[i16];
        }
        return 0;
    }

    private int precess_3(double[] dArr, double d, int i, int i2) {
        return precess_3(dArr, 0, d, i, i2);
    }

    private int precess_3(double[] dArr, int i, double d, int i2, int i3) {
        double[] dArr2 = new double[3];
        double[] dArr3 = new double[9];
        if (d == 2451545.0d) {
            return 0;
        }
        pre_pmat(d, dArr3);
        if (i2 == -1) {
            int i4 = 0;
            int i5 = 0;
            while (i4 <= 2) {
                dArr2[i4] = (dArr[i + 0] * dArr3[i5 + 0]) + (dArr[i + 1] * dArr3[i5 + 1]) + (dArr[i + 2] * dArr3[i5 + 2]);
                i4++;
                i5 = i4 * 3;
            }
        } else {
            for (int i6 = 0; i6 <= 2; i6++) {
                dArr2[i6] = (dArr[i + 0] * dArr3[i6 + 0]) + (dArr[i + 1] * dArr3[i6 + 3]) + (dArr[i + 2] * dArr3[i6 + 6]);
            }
        }
        for (int i7 = 0; i7 < 3; i7++) {
            dArr[i7 + i] = dArr2[i7];
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swi_precess(double[] dArr, double d, int i, int i2) {
        return swi_precess(dArr, 0, d, i, i2);
    }

    /* access modifiers changed from: package-private */
    public int swi_precess(double[] dArr, int i, double d, int i2, int i3) {
        return (i2 & 262144) != 0 ? precess_1(dArr, i, d, i3, 1) : precess_3(dArr, i, d, i3, 8);
    }

    private int swi_nutation_iau1980(double d, double[] dArr) {
        double[][] dArr2;
        double d2;
        double d3;
        int i;
        Class<double> cls = double.class;
        double[][] dArr3 = (double[][]) Array.newInstance(cls, new int[]{5, 8});
        int[] iArr = {3, 2, 4, 4, 2};
        double d4 = (d - 2451545.0d) / 36525.0d;
        double d5 = d4 * d4;
        double[][] dArr4 = (double[][]) Array.newInstance(cls, new int[]{5, 8});
        int i2 = 1;
        double[] dArr5 = {swe_degnorm((((1.717915922633E9d * d4) + 485866.733d) + (((0.064d * d4) + 31.31d) * d5)) / 3600.0d) * 0.0174532925199433d, swe_degnorm((((1.29596581224E8d * d4) + 1287099.804d) - (((0.012d * d4) + 0.577d) * d5)) / 3600.0d) * 0.0174532925199433d, swe_degnorm((((1.739527263137E9d * d4) + 335778.877d) + (((0.011d * d4) - 13.257d) * d5)) / 3600.0d) * 0.0174532925199433d, swe_degnorm((((1.602961601328E9d * d4) + 1072261.307d) + (((0.019d * d4) - 6.891d) * d5)) / 3600.0d) * 0.0174532925199433d, swe_degnorm((((-6962890.539d * d4) + 450160.28d) + (((0.008d * d4) + 7.455d) * d5)) / 3600.0d) * 0.0174532925199433d};
        for (int i3 = 0; i3 <= 4; i3++) {
            double d6 = dArr5[i3];
            int i4 = iArr[i3];
            double sin = SMath.sin(d6);
            double cos = SMath.cos(d6);
            dArr4[i3][0] = sin;
            dArr3[i3][0] = cos;
            double d7 = 2.0d * sin * cos;
            double d8 = (cos * cos) - (sin * sin);
            dArr4[i3][1] = d7;
            dArr3[i3][1] = d8;
            int i5 = 2;
            while (i5 < i4) {
                double d9 = (sin * d8) + (cos * d7);
                d8 = (d8 * cos) - (d7 * sin);
                dArr4[i3][i5] = d9;
                dArr3[i3][i5] = d8;
                i5++;
                d7 = d9;
            }
        }
        double d10 = ((-0.01742d * d4) - 17.1996d) * dArr4[4][0];
        double d11 = ((8.9E-4d * d4) + 9.2025d) * dArr3[4][0];
        int i6 = 0;
        while (nt[i6] != -99) {
            double d12 = 0.0d;
            double d13 = 0.0d;
            int i7 = 0;
            boolean z = false;
            while (i7 < 5) {
                short s = nt[i6 + i7];
                if (s > 100) {
                    s = 0;
                }
                if (s != 0) {
                    if (s < 0) {
                        i = -s;
                    } else {
                        i = s;
                    }
                    int i8 = i - i2;
                    d3 = d10;
                    double d14 = dArr4[i7][i8];
                    if (s < 0) {
                        d14 = -d14;
                    }
                    double d15 = dArr3[i7][i8];
                    if (!z) {
                        d13 = d14;
                        d12 = d15;
                        z = true;
                    } else {
                        d12 = (d15 * d12) - (d14 * d13);
                        d13 = (d14 * d12) + (d15 * d13);
                    }
                } else {
                    d3 = d10;
                }
                i7++;
                d10 = d3;
                i2 = 1;
            }
            double d16 = d10;
            short[] sArr = nt;
            double d17 = ((double) sArr[i6 + 5]) * 1.0E-4d;
            int i9 = i6 + 6;
            if (sArr[i9] != 0) {
                d17 += d4 * 1.0E-5d * ((double) sArr[i9]);
            }
            double d18 = ((double) sArr[i6 + 7]) * 1.0E-4d;
            int i10 = i6 + 8;
            if (sArr[i10] != 0) {
                dArr2 = dArr3;
                d18 += 1.0E-5d * d4 * ((double) sArr[i10]);
            } else {
                dArr2 = dArr3;
            }
            if (sArr[i6] >= 100) {
                d17 *= 0.1d;
                d18 *= 0.1d;
            }
            if (sArr[i6] != 102) {
                d10 = d16 + (d17 * d13);
                d2 = d18 * d12;
            } else {
                d10 = d16 + (d17 * d12);
                d2 = d18 * d13;
            }
            d11 += d2;
            i6 += 9;
            dArr3 = dArr2;
            i2 = 1;
        }
        dArr[0] = (d10 * 0.0174532925199433d) / 3600.0d;
        dArr[1] = (d11 * 0.0174532925199433d) / 3600.0d;
        return 0;
    }

    private int swi_nutation_iau2000ab(double d, double[] dArr) {
        SwissLib swissLib = this;
        double d2 = (d - 2451545.0d) / 36525.0d;
        double swe_degnorm = swissLib.swe_degnorm(((((((((-2.447E-4d * d2) + 0.051635d) * d2) + 31.8792d) * d2) + 1.7179159232178E9d) * d2) + 485868.249036d) / 3600.0d) * 0.0174532925199433d;
        double swe_degnorm2 = swissLib.swe_degnorm(((((((((-1.149E-5d * d2) + 1.36E-4d) * d2) - 7.5744d) * d2) + 1.295965810481E8d) * d2) + 1287104.79305d) / 3600.0d) * 0.0174532925199433d;
        double swe_degnorm3 = swissLib.swe_degnorm(((((((((4.17E-6d * d2) - 3969.253376d) * d2) - 0.351525d) * d2) + 1.7395272628478E9d) * d2) + 335779.526232d) / 3600.0d) * 0.0174532925199433d;
        double swe_degnorm4 = swissLib.swe_degnorm(((((((((-3.169E-5d * d2) + 0.006593d) * d2) - 0.703675d) * d2) + 1.602961601209E9d) * d2) + 1072260.70369d) / 3600.0d) * 0.0174532925199433d;
        double swe_degnorm5 = swissLib.swe_degnorm(((((((((-5.939E-5d * d2) + 0.007702d) * d2) + 7.4722d) * d2) - 6.389224673625904E-7d) * d2) + 450160.398036d) / 3600.0d) * 0.0174532925199433d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i = 76;
        while (i >= 0) {
            int i2 = i * 5;
            double d5 = swe_degnorm;
            double swe_radnorm = swissLib.swe_radnorm((((double) Swenut2000aNls.nls[i2 + 0]) * swe_degnorm) + (((double) Swenut2000aNls.nls[i2 + 1]) * swe_degnorm2) + (((double) Swenut2000aNls.nls[i2 + 2]) * swe_degnorm3) + (((double) Swenut2000aNls.nls[i2 + 3]) * swe_degnorm4) + (((double) Swenut2000aNls.nls[i2 + 4]) * swe_degnorm5));
            double sin = SMath.sin(swe_radnorm);
            double cos = SMath.cos(swe_radnorm);
            int i3 = i * 6;
            d3 += ((((double) Swenut2000a_cls.cls[i3 + 0]) + (((double) Swenut2000a_cls.cls[i3 + 1]) * d2)) * sin) + (((double) Swenut2000a_cls.cls[i3 + 2]) * cos);
            d4 += ((((double) Swenut2000a_cls.cls[i3 + 3]) + (((double) Swenut2000a_cls.cls[i3 + 4]) * d2)) * cos) + (((double) Swenut2000a_cls.cls[i3 + 5]) * sin);
            i--;
            swissLib = this;
            swe_degnorm5 = swe_degnorm5;
            swe_degnorm = d5;
            swe_degnorm2 = swe_degnorm2;
        }
        dArr[0] = d3 * 2.7777777777777777E-11d;
        dArr[1] = d4 * 2.7777777777777777E-11d;
        dArr[0] = dArr[0] * 0.0174532925199433d;
        dArr[1] = dArr[1] * 0.0174532925199433d;
        return 0;
    }

    private double bessel(double[] dArr, int i, double d) {
        int i2;
        int i3;
        int i4 = i;
        double d2 = d;
        double[] dArr2 = new double[6];
        if (d2 <= 0.0d) {
            return dArr[0];
        }
        int i5 = i4 - 1;
        if (d2 >= ((double) i5)) {
            return dArr[i5];
        }
        double floor = SMath.floor(d);
        int i6 = (int) d2;
        double d3 = dArr[i6];
        int i7 = i6 + 1;
        if (i7 >= i4) {
            return d3;
        }
        double d4 = d2 - floor;
        double d5 = d3 + ((dArr[i7] - dArr[i6]) * d4);
        if (i6 - 1 < 0 || (i2 = i6 + 2) >= i4) {
            return d5;
        }
        int i8 = i6 - 2;
        int i9 = i8;
        for (int i10 = 0; i10 < 5; i10++) {
            if (i9 < 0 || (i3 = i9 + 1) >= i4) {
                dArr2[i10] = 0.0d;
            } else {
                dArr2[i10] = dArr[i3] - dArr[i9];
            }
            i9++;
        }
        int i11 = 0;
        while (i11 < 4) {
            int i12 = i11 + 1;
            dArr2[i11] = dArr2[i12] - dArr2[i11];
            i11 = i12;
        }
        double d6 = 0.25d * d4 * (d4 - 1.0d);
        double d7 = d5 + ((dArr2[1] + dArr2[2]) * d6);
        if (i2 >= i4) {
            return d7;
        }
        int i13 = 0;
        while (i13 < 3) {
            int i14 = i13 + 1;
            dArr2[i13] = dArr2[i14] - dArr2[i13];
            i13 = i14;
        }
        double d8 = (d6 * 2.0d) / 3.0d;
        double d9 = d7 + ((d4 - 0.5d) * d8 * dArr2[1]);
        if (i8 < 0 || i6 + 3 > i4) {
            return d9;
        }
        int i15 = 0;
        while (i15 < 2) {
            int i16 = i15 + 1;
            dArr2[i15] = dArr2[i16] - dArr2[i15];
            i15 = i16;
        }
        return d9 + (d8 * 0.125d * (1.0d + d4) * (d4 - 2.0d) * (dArr2[0] + dArr2[1]));
    }

    /* access modifiers changed from: package-private */
    public int swi_nutation(double d, int i, double[] dArr) {
        int i2 = i & 262144;
        if (i2 != 0) {
            swi_nutation_iau1980(d, dArr);
        } else {
            swi_nutation_iau2000ab(d, dArr);
        }
        if (i2 != 0) {
            int i3 = (int) ((this.swed.eop_tjd_end - this.swed.eop_tjd_beg) + 1.0E-6d);
            if (d < this.swed.eop_tjd_beg_horizons) {
                d = this.swed.eop_tjd_beg_horizons;
            }
            int i4 = i3 + 1;
            double bessel = bessel(this.swed.dpsi, i4, d - this.swed.eop_tjd_beg);
            double bessel2 = bessel(this.swed.deps, i4, d - this.swed.eop_tjd_beg);
            dArr[0] = dArr[0] + ((bessel / 3600.0d) * 0.0174532925199433d);
            dArr[1] = dArr[1] + ((bessel2 / 3600.0d) * 0.0174532925199433d);
        }
        return 0;
    }

    private void swi_approx_jplhor(double[] dArr, double d, int i, boolean z) {
        double d2;
        double d3 = (d - 2437846.5d) / 365.25d;
        if ((i & 524288) != 0) {
            if (d3 < 0.0d) {
                d2 = this.dcor_ra_jpl[0];
            } else if (d3 >= 50.0d) {
                d2 = this.dcor_ra_jpl[50];
            } else {
                double d4 = (double) ((int) d3);
                double[] dArr2 = this.dcor_ra_jpl;
                int i2 = (int) d4;
                double d5 = dArr2[i2];
                d2 = dArr2[i2] + ((d3 - d4) * (dArr2[i2] - dArr2[(int) (1.0d + d4)]));
            }
            double d6 = d2 / 3600000.0d;
            swi_cartpol(dArr, dArr);
            if (z) {
                dArr[0] = dArr[0] - (d6 * 0.0174532925199433d);
            } else {
                dArr[0] = dArr[0] + (d6 * 0.0174532925199433d);
            }
            swi_polcart(dArr, dArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: double[][]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swi_bias(double[] r19, double r20, int r22, boolean r23) {
        /*
            r18 = this;
            r6 = r22
            r0 = 6
            double[] r7 = new double[r0]
            r8 = 2
            int[] r0 = new int[r8]
            r0 = {3, 3} // fill-array
            java.lang.Class<double> r1 = double.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r1, r0)
            r9 = r0
            double[][] r9 = (double[][]) r9
            r0 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r6
            if (r0 == 0) goto L_0x001a
            return
        L_0x001a:
            r10 = 0
            r0 = r9[r10]
            r1 = 4607182418800017355(0x3fefffffffffffcb, double:0.9999999999999941)
            r0[r10] = r1
            r11 = 1
            r0 = r9[r11]
            r1 = -4723431344365451002(0xbe730037d626c906, double:-7.078368961E-8)
            r0[r10] = r1
            r0 = r9[r8]
            r1 = 4500679531294720309(0x3e75a03026b18135, double:8.056213978E-8)
            r0[r10] = r1
            r0 = r9[r10]
            r1 = 4499940692288340888(0x3e730037ca2c0398, double:7.078368695E-8)
            r0[r11] = r1
            r0 = r9[r11]
            r1 = 4607182418800017381(0x3fefffffffffffe5, double:0.999999999999997)
            r0[r11] = r1
            r0 = r9[r8]
            r1 = 4495085362048925434(0x3e61c0521ffbfefa, double:3.306428553E-8)
            r0[r11] = r1
            r0 = r9[r10]
            r1 = -4722692505383250098(0xbe75a030313b574e, double:-8.056214212E-8)
            r0[r8] = r1
            r0 = r9[r11]
            r1 = -4728286675670232335(0xbe61c051ec7692f1, double:-3.306427981E-8)
            r0[r8] = r1
            r0 = r9[r8]
            r1 = 4607182418800017375(0x3fefffffffffffdf, double:0.9999999999999963)
            r0[r8] = r1
            r12 = 4
            r13 = 5
            r14 = 3
            if (r23 == 0) goto L_0x00c2
            r5 = 1
            r0 = r18
            r1 = r19
            r2 = r20
            r4 = r22
            r0.swi_approx_jplhor(r1, r2, r4, r5)
            r0 = 0
        L_0x007f:
            if (r0 > r8) goto L_0x0111
            r1 = r19[r10]
            r3 = r9[r0]
            r4 = r3[r10]
            double r1 = r1 * r4
            r3 = r19[r11]
            r5 = r9[r0]
            r15 = r5[r11]
            double r3 = r3 * r15
            double r1 = r1 + r3
            r3 = r19[r8]
            r5 = r9[r0]
            r15 = r5[r8]
            double r3 = r3 * r15
            double r1 = r1 + r3
            r7[r0] = r1
            r1 = r6 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x00bf
            int r1 = r0 + 3
            r2 = r19[r14]
            r4 = r9[r0]
            r15 = r4[r10]
            double r2 = r2 * r15
            r4 = r19[r12]
            r15 = r9[r0]
            r16 = r15[r11]
            double r4 = r4 * r16
            double r2 = r2 + r4
            r4 = r19[r13]
            r15 = r9[r0]
            r16 = r15[r8]
            double r4 = r4 * r16
            double r2 = r2 + r4
            r7[r1] = r2
        L_0x00bf:
            int r0 = r0 + 1
            goto L_0x007f
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            if (r0 > r8) goto L_0x0106
            r1 = r19[r10]
            r3 = r9[r10]
            r4 = r3[r0]
            double r1 = r1 * r4
            r3 = r19[r11]
            r5 = r9[r11]
            r15 = r5[r0]
            double r3 = r3 * r15
            double r1 = r1 + r3
            r3 = r19[r8]
            r5 = r9[r8]
            r15 = r5[r0]
            double r3 = r3 * r15
            double r1 = r1 + r3
            r7[r0] = r1
            r1 = r6 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0103
            int r1 = r0 + 3
            r2 = r19[r14]
            r4 = r9[r10]
            r15 = r4[r0]
            double r2 = r2 * r15
            r4 = r19[r12]
            r15 = r9[r11]
            r16 = r15[r0]
            double r4 = r4 * r16
            double r2 = r2 + r4
            r4 = r19[r13]
            r15 = r9[r8]
            r16 = r15[r0]
            double r4 = r4 * r16
            double r2 = r2 + r4
            r7[r1] = r2
        L_0x0103:
            int r0 = r0 + 1
            goto L_0x00c3
        L_0x0106:
            r5 = 0
            r0 = r18
            r1 = r7
            r2 = r20
            r4 = r22
            r0.swi_approx_jplhor(r1, r2, r4, r5)
        L_0x0111:
        L_0x0112:
            if (r10 > r8) goto L_0x011b
            r0 = r7[r10]
            r19[r10] = r0
            int r10 = r10 + 1
            goto L_0x0112
        L_0x011b:
            r0 = r6 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0129
        L_0x0120:
            if (r14 > r13) goto L_0x0129
            r0 = r7[r14]
            r19[r14] = r0
            int r14 = r14 + 1
            goto L_0x0120
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissLib.swi_bias(double[], double, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void swi_icrs2fk5(double[] dArr, int i, boolean z) {
        int i2 = i;
        double[] dArr2 = new double[6];
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        dArr3[0][0] = 0.9999999999999928d;
        dArr3[0][1] = 1.110223287E-7d;
        dArr3[0][2] = 4.41180557E-8d;
        dArr3[1][0] = -1.11022333E-7d;
        dArr3[1][1] = 0.9999999999999891d;
        dArr3[1][2] = 9.64779176E-8d;
        dArr3[2][0] = -4.4118045E-8d;
        dArr3[2][1] = -9.64779225E-8d;
        dArr3[2][2] = 0.9999999999999943d;
        if (z) {
            for (int i3 = 0; i3 <= 2; i3++) {
                dArr2[i3] = (dArr[0] * dArr3[i3][0]) + (dArr[1] * dArr3[i3][1]) + (dArr[2] * dArr3[i3][2]);
                if ((i2 & 256) != 0) {
                    dArr2[i3 + 3] = (dArr[3] * dArr3[i3][0]) + (dArr[4] * dArr3[i3][1]) + (dArr[5] * dArr3[i3][2]);
                }
            }
        } else {
            for (int i4 = 0; i4 <= 2; i4++) {
                dArr2[i4] = (dArr[0] * dArr3[0][i4]) + (dArr[1] * dArr3[1][i4]) + (dArr[2] * dArr3[2][i4]);
                if ((i2 & 256) != 0) {
                    dArr2[i4 + 3] = (dArr[3] * dArr3[0][i4]) + (dArr[4] * dArr3[1][i4]) + (dArr[5] * dArr3[2][i4]);
                }
            }
        }
        for (int i5 = 0; i5 <= 5; i5++) {
            dArr[i5] = dArr2[i5];
        }
    }

    private double sidtime_long_term(double d, double d2, double d3) {
        return sidtime_long_term(d, d2, d3, new SwissEph());
    }

    private double sidtime_long_term(double d, double d2, double d3, SwissEph swissEph) {
        double[] dArr = new double[6];
        double[] dArr2 = new double[6];
        double deltaT = d + SweDate.getDeltaT(d);
        double d4 = (deltaT - 2451545.0d) / 365250.0d;
        double d5 = d4 * d4;
        dArr[0] = swe_degnorm((((((d4 * 1.29597742283429E9d) - (d5 * 2.04411d)) - ((d4 * d5) * 0.00523d)) / 3600.0d) + 100.46645683d) - 0.005692619558765017d) * 0.0174532925199433d;
        dArr[1] = 0.0d;
        dArr[2] = 1.0d;
        SwissEph swissEph2 = swissEph;
        double[] dArr3 = dArr2;
        swissEph2.swe_calc_ut(2451545.0d, -1, 0, dArr3, (StringBuffer) null);
        swi_polcart(dArr, dArr);
        swi_coortrf(dArr, dArr, (-dArr2[1]) * 0.0174532925199433d);
        swi_precess(dArr, deltaT, 0, -1);
        swissEph2.swe_calc_ut(d, -1, 0, dArr3, (StringBuffer) null);
        swi_coortrf(dArr, dArr, dArr2[1] * 0.0174532925199433d);
        swi_cartpol(dArr, dArr);
        dArr[0] = dArr[0] * 57.2957795130823d;
        double d6 = ((d - 0.5d) % 1.0d) * 360.0d;
        if (d2 == 0.0d) {
            dArr[0] = dArr[0] + (dArr2[2] * SMath.cos(dArr2[0] * 0.0174532925199433d));
        } else {
            dArr[0] = dArr[0] + (SMath.cos(d2 * 0.0174532925199433d) * d3);
        }
        dArr[0] = swe_degnorm(dArr[0] + (SMath.cos(d2 * 0.0174532925199433d) * d3) + d6);
        return dArr[0] / 15.0d;
    }

    public int swi_cutstr(String str, String str2, String[] strArr, int i) {
        if (str.indexOf(10) >= 0) {
            str = str.substring(0, str.indexOf(10));
        }
        if (str.indexOf(13) >= 0) {
            str = str.substring(0, str.indexOf(13));
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2, true);
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens() && i2 < 20) {
            String nextToken = stringTokenizer.nextToken();
            while (nextToken.endsWith("\\") && stringTokenizer.hasMoreTokens()) {
                nextToken = nextToken.substring(0, nextToken.length() - 1) + stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    nextToken = nextToken + stringTokenizer.nextToken();
                }
            }
            strArr[i2] = nextToken;
            i2++;
            if (stringTokenizer.hasMoreTokens()) {
                stringTokenizer.nextToken();
            }
        }
        strArr[19] = "";
        while (stringTokenizer.hasMoreTokens()) {
            strArr[19] = strArr[19] + stringTokenizer.nextToken();
        }
        if (i2 < i) {
            strArr[i2] = null;
        }
        return i2;
    }

    private double sidtime_non_polynomial_part(double d) {
        double[] dArr = {swe_radnorm((8328.6914269554d * d) + 2.35555598d), swe_radnorm((628.301955d * d) + 6.24006013d), swe_radnorm((8433.466158131d * d) + 1.627905234d), swe_radnorm((7771.3771468121d * d) + 5.198466741d), swe_radnorm(2.1824392d - (33.757045d * d)), swe_radnorm((2608.7903141574d * d) + 4.402608842d), swe_radnorm((1021.3285546211d * d) + 3.176146697d), swe_radnorm((628.3075849991d * d) + 1.753470314d), swe_radnorm((334.06124267d * d) + 6.203480913d), swe_radnorm((52.9690962641d * d) + 0.599546497d), swe_radnorm((21.329910496d * d) + 0.874016757d), swe_radnorm((7.4781598567d * d) + 5.481293871d), swe_radnorm((3.8127774d * d) + 5.321159d), ((5.38691E-6d * d) + 0.02438175d) * d};
        double sin = SMath.sin(dArr[4]) * -0.87d * d;
        for (int i = 0; i < 33; i++) {
            double d2 = 0.0d;
            for (int i2 = 0; i2 < 14; i2++) {
                d2 += ((double) stfarg[(i * 14) + i2]) * dArr[i2];
            }
            int i3 = i * 2;
            sin += (this.stcf[i3] * SMath.sin(d2)) + (this.stcf[i3 + 1] * SMath.cos(d2));
        }
        return sin / 3.6E9d;
    }

    public double swe_sidtime0(double d, double d2, double d3) {
        int i = (d > SIDT_LTERM_T0 ? 1 : (d == SIDT_LTERM_T0 ? 0 : -1));
        if (i <= 0 || d >= SIDT_LTERM_T1) {
            double sidtime_long_term = sidtime_long_term(d, d2, d3);
            if (i <= 0) {
                sidtime_long_term -= SIDT_LTERM_OFS0;
            } else if (d >= SIDT_LTERM_T1) {
                sidtime_long_term -= SIDT_LTERM_OFS1;
            }
            if (sidtime_long_term >= 24.0d) {
                sidtime_long_term -= 24.0d;
            }
            if (sidtime_long_term < 0.0d) {
                return sidtime_long_term + 24.0d;
            }
            return sidtime_long_term;
        }
        if (d - SMath.floor(d) < 0.5d) {
        }
        double deltaT = ((d + SweDate.getDeltaT(d)) - 2451545.0d) / 36525.0d;
        double swe_degnorm = ((swe_degnorm((swe_degnorm((((d - 2451545.0d) * 1.0027378119113546d) + 0.779057273264d) * 360.0d) + (((((((((((-3.68E-8d * deltaT) - 135895.919362048d) * deltaT) - 9684700.28091392d) * deltaT) + 1.3915817d) * deltaT) + 4612.156534d) * deltaT) + 0.014506d) / 3600.0d)) + sidtime_non_polynomial_part(deltaT)) / 15.0d) * 3600.0d) + (240.0d * d3 * SMath.cos(0.0174532925199433d * d2));
        return (swe_degnorm - (SMath.floor(swe_degnorm / 86400.0d) * 86400.0d)) / 3600.0d;
    }

    public double swe_sidtime(double d) {
        double[] dArr = new double[2];
        double deltaT = SweDate.getDeltaT(d) + d;
        double swi_epsiln = swi_epsiln(deltaT, 0) * 57.2957795130823d;
        swi_nutation(deltaT, 0, dArr);
        for (int i = 0; i < 2; i++) {
            dArr[i] = dArr[i] * 57.2957795130823d;
        }
        return swe_sidtime0(d, swi_epsiln + dArr[1], dArr[0]);
    }

    public String swi_gen_filename(SweDate sweDate, int i) {
        String str;
        String str2;
        String str3;
        char c = 1;
        switch (i) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "sepl";
                break;
            case 1:
                str = "semo";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                str = "seas";
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("00000");
                int i2 = i - 10000;
                sb.append(i2);
                String sb2 = sb.toString();
                String substring = sb2.substring(sb2.length() - 6);
                if (i2 <= 99999) {
                    substring = substring.substring(1);
                    str3 = "se";
                } else {
                    str3 = "s";
                }
                return "ast" + (i2 / 1000) + this.swed.DIR_GLUE + str3 + substring + "." + "se1";
        }
        if (sweDate.getJulDay() >= 2305447.5d) {
            sweDate.setCalendarType(true, false);
        } else {
            sweDate.setCalendarType(false, false);
        }
        int year = sweDate.getYear();
        if (year < 0) {
            c = 65535;
        }
        int i3 = year / 100;
        if (c < 0 && year % 100 != 0) {
            i3--;
        }
        while (i3 % 6 != 0) {
            i3--;
        }
        if (i3 < 0) {
            str2 = str + "m";
        } else {
            str2 = str + "_";
        }
        int abs = SMath.abs(i3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(abs < 10 ? "0" : "");
        sb3.append(abs);
        sb3.append(".");
        sb3.append("se1");
        return sb3.toString();
    }

    public void swe_split_deg(double d, int i, IntObj intObj, IntObj intObj2, IntObj intObj3, DblObj dblObj, IntObj intObj4) {
        double d2;
        double d3 = d;
        IntObj intObj5 = intObj;
        IntObj intObj6 = intObj2;
        IntObj intObj7 = intObj3;
        IntObj intObj8 = intObj4;
        intObj8.val = 1;
        double d4 = 0.0d;
        if (d3 < 0.0d) {
            intObj8.val = -1;
            d3 = -d3;
        }
        if ((i & 4) != 0) {
            d2 = 0.5d;
        } else if ((i & 2) != 0) {
            d2 = 0.008333333333333333d;
        } else if ((i & 1) != 0) {
            d2 = 1.388888888888889E-4d;
        } else {
            d2 = 0.0d;
        }
        if ((i & 32) == 0 ? (i & 16) == 0 || (d3 % 30.0d) + d2 < 30.0d : ((int) (d3 + d2)) - ((int) d3) <= 0) {
            d4 = d2;
        }
        double d5 = d3 + d4;
        if ((i & 8) != 0) {
            intObj8.val = (int) (d5 / 30.0d);
            d5 %= 30.0d;
        }
        intObj5.val = (int) d5;
        double d6 = d5 - ((double) intObj5.val);
        intObj6.val = (int) (d6 * 60.0d);
        double d7 = (d6 - (((double) intObj6.val) / 60.0d)) * 3600.0d;
        intObj7.val = (int) d7;
        if ((i & 7) == 0) {
            dblObj.val = d7 - ((double) intObj7.val);
        }
    }

    public double swi_kepler(double d, double d2, double d3) {
        if (d3 < 0.4d) {
            double d4 = 1.0d;
            double d5 = d;
            while (d4 > 1.0E-12d) {
                double sin = d2 + (SMath.sin(d5) * d3);
                double abs = SMath.abs(sin - d5);
                d5 = sin;
                d4 = abs;
            }
            return d5;
        }
        double d6 = d;
        double d7 = 1.0d;
        while (d7 > 1.0E-12d) {
            double sin2 = ((d2 + (SMath.sin(d6) * d3)) - d6) / (1.0d - (SMath.cos(d6) * d3));
            double abs2 = SMath.abs(sin2);
            if (abs2 < 0.01d) {
                d6 += sin2;
                d7 = abs2;
            } else {
                double swi_mod2PI = swi_mod2PI(sin2 + d6);
                double abs3 = SMath.abs(swi_mod2PI - d6);
                d6 = swi_mod2PI;
                d7 = abs3;
            }
        }
        return d6;
    }

    public void swi_FK4_FK5(double[] dArr, double d) {
        if (dArr[0] != 0.0d || dArr[1] != 0.0d || dArr[2] != 0.0d) {
            swi_cartpol(dArr, dArr);
            dArr[0] = dArr[0] + ((((((d - 2433282.42345905d) * 0.085d) / 36524.2198782d) + 0.035d) / 3600.0d) * 15.0d * 0.0174532925199433d);
            dArr[3] = dArr[3] + 1.6924042333443586E-10d;
            swi_polcart(dArr, dArr);
        }
    }

    public void swi_FK5_FK4(double[] dArr, double d) {
        if (dArr[0] != 0.0d || dArr[1] != 0.0d || dArr[2] != 0.0d) {
            swi_cartpol(dArr, dArr);
            dArr[0] = dArr[0] - (((((((d - 2433282.42345905d) * 0.085d) / 36524.2198782d) + 0.035d) / 3600.0d) * 15.0d) * 0.0174532925199433d);
            dArr[3] = dArr[3] - 1.6924042333443586E-10d;
            swi_polcart(dArr, dArr);
        }
    }

    /* access modifiers changed from: package-private */
    public String swi_strcpy(String str, String str2) {
        return str2;
    }

    /* access modifiers changed from: package-private */
    public String swi_strncpy(String str, String str2, int i) {
        return str2.substring(0, Math.min(str2.length(), i));
    }

    public int swe_d2l(double d) {
        if (d >= 0.0d) {
            return (int) (d + 0.5d);
        }
        return -((int) (0.5d - d));
    }

    public double swe_difdeg2n(double d, double d2) {
        double swe_degnorm = swe_degnorm(d - d2);
        if (swe_degnorm >= 180.0d) {
            return swe_degnorm - 360.0d;
        }
        return swe_degnorm;
    }

    public double swe_difrad2n(double d, double d2) {
        double swe_radnorm = swe_radnorm(d - d2);
        if (swe_radnorm >= 3.141592653589793d) {
            return swe_radnorm - D2PI;
        }
        return swe_radnorm;
    }

    public static synchronized double atof(String str) {
        synchronized (SwissLib.class) {
            String trim = str.trim();
            int i = 0;
            while (i < trim.length() && (Character.isDigit(trim.charAt(i)) || trim.charAt(i) == '.')) {
                i++;
            }
            String trim2 = trim.substring(0, i).trim();
            if (trim2.length() != 0) {
                if (trim2.replace('.', ' ').trim().length() != 0) {
                    double doubleValue = Double.valueOf(trim2).doubleValue();
                    return doubleValue;
                }
            }
            return 0.0d;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int atoi(java.lang.String r4) {
        /*
            java.lang.Class<swisseph.SwissLib> r0 = swisseph.SwissLib.class
            monitor-enter(r0)
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x004a }
            r1 = 0
            r2 = 0
        L_0x000a:
            int r3 = r4.length()     // Catch:{ all -> 0x004a }
            if (r2 >= r3) goto L_0x001d
            char r3 = r4.charAt(r2)     // Catch:{ all -> 0x004a }
            boolean r3 = java.lang.Character.isDigit(r3)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x001d
            int r2 = r2 + 1
            goto L_0x000a
        L_0x001d:
            java.lang.String r4 = r4.substring(r1, r2)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x004a }
            int r2 = r4.length()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0048
            r2 = 46
            r3 = 32
            java.lang.String r2 = r4.replace(r2, r3)     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r2.trim()     // Catch:{ all -> 0x004a }
            int r2 = r2.length()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x003e
            goto L_0x0048
        L_0x003e:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x004a }
            int r4 = r4.intValue()     // Catch:{ all -> 0x004a }
            monitor-exit(r0)
            return r4
        L_0x0048:
            monitor-exit(r0)
            return r1
        L_0x004a:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SwissLib.atoi(java.lang.String):int");
    }
}
