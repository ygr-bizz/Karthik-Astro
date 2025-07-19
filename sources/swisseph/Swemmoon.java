package swisseph;

import java.io.Serializable;
import java.lang.reflect.Array;

class Swemmoon implements Serializable {
    static final short[] BT = {2, -1, 0, -1, -7430, 2, 1, 0, -1, 3043, 2, -1, -1, 1, -2229, 2, -1, 0, 1, -1999, 2, -1, -1, -1, -1869, 0, 1, -1, -1, 1696, 0, 1, 0, 1, 1623, 0, 1, -1, 1, 1418, 0, 1, 1, 1, 1339, 0, 1, 1, -1, 1278, 0, 1, 0, -1, 1217, 2, -2, 0, -1, -547, 2, -1, 1, -1, -443, 2, 1, -1, 1, 331, 2, 1, 0, 1, 317, 2, 0, 0, -1, 295};
    static final short[] BT2 = {2, -1, 0, -1, -22, 2, 1, 0, -1, 9, 2, -1, 0, 1, -6, 2, -1, -1, 1, -6, 2, -1, -1, -1, -5, 0, 1, 0, 1, 5, 0, 1, -1, -1, 5, 0, 1, 1, 1, 4, 0, 1, 1, -1, 4, 0, 1, 0, -1, 4, 0, 1, -1, 1, 4, 2, -2, 0, -1, -2};
    static final double CORR_MAPOG_JD_T0GREG = -3063616.5d;
    static final double CORR_MAPOG_JD_T1GREG = 1209720.5d;
    static final double CORR_MAPOG_JD_T2GREG = 2780263.5d;
    static final double CORR_MAPOG_JD_T3GREG = 7930182.5d;
    static final double CORR_MNODE_JD_T0GREG = -3063616.5d;
    static final double CORR_MNODE_JD_T1GREG = 844477.5d;
    static final double CORR_MNODE_JD_T2GREG = 2780263.5d;
    static final double CORR_MNODE_JD_T3GREG = 7930182.5d;
    static double Ea = 0.0d;
    static double Ju = 0.0d;
    static final short[] LR = {0, 0, 1, 0, 22639, 5858, -20905, -3550, 2, 0, -1, 0, 4586, 4383, -3699, -1109, 2, 0, 0, 0, 2369, 9139, -2955, -9676, 0, 0, 2, 0, 769, 257, -569, -9251, 0, 1, 0, 0, -666, -4171, 48, 8883, 0, 0, 0, 2, -411, -5957, -3, -1483, 2, 0, -2, 0, 211, 6556, 246, 1585, 2, -1, -1, 0, 205, 4358, -152, -1377, 2, 0, 1, 0, 191, 9562, -170, -7331, 2, -1, 0, 0, 164, 7285, -204, -5860, 0, 1, -1, 0, -147, -3213, -129, -6201, 1, 0, 0, 0, -124, -9881, 108, 7427, 0, 1, 1, 0, -109, -3803, 104, 7552, 2, 0, 0, -2, 55, 1771, 10, 3211, 0, 0, 1, 2, -45, -996, 0, 0, 0, 0, 1, -2, 39, 5333, 79, 6606, 4, 0, -1, 0, 38, 4298, -34, -7825, 0, 0, 3, 0, 36, 1238, -23, -2104, 4, 0, -2, 0, 30, 7726, -21, -6363, 2, 1, -1, 0, -28, -3971, 24, 2085, 2, 1, 0, 0, -24, -3582, 30, 8238, 1, 0, -1, 0, -18, -5847, -8, -3791, 1, 1, 0, 0, 17, 9545, -16, -6747, 2, -1, 1, 0, 14, 5303, -12, -8314, 2, 0, 2, 0, 14, 3797, -10, -4448, 4, 0, 0, 0, 13, 8991, -11, -6500, 2, 0, -3, 0, 13, 1941, 14, 4027, 0, 1, -2, 0, -9, -6791, -7, -27, 2, 0, -1, 2, -9, -3659, 0, 7740, 2, -1, -2, 0, 8, 6055, 10, 562, 1, 0, 1, 0, -8, -4531, 6, 3220, 2, -2, 0, 0, 8, 502, -9, -8845, 0, 1, 2, 0, -7, -6302, 5, 7509, 0, 2, 0, 0, -7, -4475, 1, 657, 2, -2, -1, 0, 7, 3712, -4, -9501, 2, 0, 1, -2, -6, -3832, 4, 1311, 2, 0, 0, 2, -5, -7416, 0, 0, 4, -1, -1, 0, 4, 3740, -3, -9580, 0, 0, 2, 2, -3, -9976, 0, 0, 3, 0, -1, 0, -3, -2097, 3, 2582, 2, 1, 1, 0, -2, -9145, 2, 6164, 4, -1, -2, 0, 2, 7319, -1, -8970, 0, 2, -1, 0, -2, -5679, -2, -1171, 2, 2, -1, 0, -2, -5212, 2, 3536, 2, 1, -2, 0, 2, 4889, 0, 1437, 2, -1, 0, -2, 2, 1461, 0, 6571, 4, 0, 1, 0, 1, 9777, -1, -4226, 0, 0, 4, 0, 1, 9337, -1, -1169, 4, -1, 0, 0, 1, 8708, -1, -5714, 1, 0, -2, 0, -1, -7530, -1, -7385, 2, 1, 0, -2, -1, -4372, 0, -1357, 0, 0, 2, -2, -1, -3726, -4, -4212, 1, 1, 1, 0, 1, 2618, 0, -9333, 3, 0, -2, 0, -1, -2241, 0, 8624, 4, 0, -3, 0, 1, 1868, 0, -5142, 2, -1, 2, 0, 1, 1770, 0, -8488, 0, 2, 1, 0, -1, -1617, 1, 1655, 1, 1, -1, 0, 1, 777, 0, 8512, 2, 0, 3, 0, 1, 595, 0, -6697, 2, 0, 1, 2, 0, -9902, 0, 0, 2, 0, -4, 0, 0, 9483, 0, 7785, 2, -2, 1, 0, 0, 7517, 0, -6575, 0, 1, -3, 0, 0, -6694, 0, -4224, 4, 1, -1, 0, 0, -6352, 0, 5788, 1, 0, 2, 0, 0, -5840, 0, 3785, 1, 0, 0, -2, 0, -5833, 0, -7956, 6, 0, -2, 0, 0, 5716, 0, -4225, 2, 0, -2, -2, 0, -5606, 0, 4726, 1, -1, 0, 0, 0, -5569, 0, 4976, 0, 1, 3, 0, 0, -5459, 0, 3551, 2, 0, -2, 2, 0, -5357, 0, 7740, 2, 0, -1, -2, 0, 1790, 8, 7516, 3, 0, 0, 0, 0, 4042, -1, -4189, 2, -1, -3, 0, 0, 4784, 0, 4950, 2, -1, 3, 0, 0, 932, 0, -585, 2, 0, 2, -2, 0, -4538, 0, 2840, 2, -1, -1, 2, 0, -4262, 0, 373, 0, 0, 0, 4, 0, 4203, 0, 0, 0, 1, 0, 2, 0, 4134, 0, -1580, 6, 0, -1, 0, 0, 3945, 0, -2866, 2, -1, 0, 2, 0, -3821, 0, 0, 2, -1, 1, -2, 0, -3745, 0, 2094, 4, 1, -2, 0, 0, -3576, 0, 2370, 1, 1, -2, 0, 0, 3497, 0, 3323, 2, -3, 0, 0, 0, 3398, 0, -4107, 0, 0, 3, 2, 0, -3286, 0, 0, 4, -2, -1, 0, 0, -3087, 0, -2790, 0, 1, -1, -2, 0, 3015, 0, 0, 4, 0, -1, -2, 0, 3009, 0, -3218, 2, -2, -2, 0, 0, 2942, 0, 3430, 6, 0, -3, 0, 0, 2925, 0, -1832, 2, 1, 2, 0, 0, -2902, 0, 2125, 4, 1, 0, 0, 0, -2891, 0, 2445, 4, -1, 1, 0, 0, 2825, 0, -2029, 3, 1, -1, 0, 0, 2737, 0, -2126, 0, 1, 1, 2, 0, 2634, 0, 0, 1, 0, 0, 2, 0, 2543, 0, 0, 3, 0, 0, -2, 0, -2530, 0, 2010, 2, 2, -2, 0, 0, -2499, 0, -1089, 2, -3, -1, 0, 0, 2469, 0, -1481, 3, -1, -1, 0, 0, -2314, 0, 2556, 4, 0, 2, 0, 0, 2185, 0, -1392, 4, 0, -1, 2, 0, -2013, 0, 0, 0, 2, -2, 0, 0, -1931, 0, 0, 2, 2, 0, 0, 0, -1858, 0, 0, 2, 1, -3, 0, 0, 1762, 0, 0, 4, 0, -2, 2, 0, -1698, 0, 0, 4, -2, -2, 0, 0, 1578, 0, -1083, 4, -2, 0, 0, 0, 1522, 0, -1281, 3, 1, 0, 0, 0, 1499, 0, -1077, 1, -1, -1, 0, 0, -1364, 0, 1141, 1, -3, 0, 0, 0, -1281, 0, 0, 6, 0, 0, 0, 0, 1261, 0, -859, 2, 0, 2, 2, 0, -1239, 0, 0, 1, -1, 1, 0, 0, -1207, 0, 1100, 0, 0, 5, 0, 0, 1110, 0, -589, 0, 3, 0, 0, 0, -1013, 0, 213, 4, -1, -3, 0, 0, 998, 0, 0};
    static final short[] LRT = {0, 1, 0, 0, 16, 7680, -1, -2302, 2, -1, -1, 0, -5, -1642, 3, 8245, 2, -1, 0, 0, -4, -1383, 5, 1395, 0, 1, -1, 0, 3, 7115, 3, 2654, 0, 1, 1, 0, 2, 7560, -2, -6396, 2, 1, -1, 0, 0, 7118, 0, -6068, 2, 1, 0, 0, 0, 6128, 0, -7754, 1, 1, 0, 0, 0, -4516, 0, 4194, 2, -2, 0, 0, 0, -4048, 0, 4970, 0, 2, 0, 0, 0, 3747, 0, -540, 2, -2, -1, 0, 0, -3707, 0, 2490, 2, -1, 1, 0, 0, -3649, 0, 3222, 0, 1, -2, 0, 0, 2438, 0, 1760, 2, -1, -2, 0, 0, -2165, 0, -2530, 0, 1, 2, 0, 0, 1923, 0, -1450, 0, 2, -1, 0, 0, 1292, 0, 1070, 2, 2, -1, 0, 0, 1271, 0, -6070, 4, -1, -1, 0, 0, -1098, 0, 990, 2, 0, 0, 0, 0, 1073, 0, -1360, 2, 0, -1, 0, 0, 839, 0, -630, 2, 1, 1, 0, 0, 734, 0, -660, 4, -1, -2, 0, 0, -688, 0, 480, 2, 1, -2, 0, 0, -630, 0, 0, 0, 2, 1, 0, 0, 587, 0, -590, 2, -1, 0, -2, 0, -540, 0, -170, 4, -1, 0, 0, 0, -468, 0, 390, 2, -2, 1, 0, 0, -378, 0, 330, 2, 1, 0, -2, 0, 364, 0, 0, 1, 1, 1, 0, 0, -317, 0, 240, 2, -1, 2, 0, 0, -295, 0, 210, 1, 1, -1, 0, 0, -270, 0, -210, 2, -3, 0, 0, 0, -256, 0, 310, 2, -3, -1, 0, 0, -187, 0, 110, 0, 1, -3, 0, 0, 169, 0, 110, 4, 1, -1, 0, 0, 158, 0, -150, 4, -2, -1, 0, 0, -155, 0, 140, 0, 0, 1, 0, 0, 155, 0, -250, 2, -2, -2, 0, 0, -148, 0, -170};
    static final short[] LRT2 = {0, 1, 0, 0, 487, -36, 2, -1, -1, 0, -150, 111, 2, -1, 0, 0, -120, 149, 0, 1, -1, 0, 108, 95, 0, 1, 1, 0, 80, -77, 2, 1, -1, 0, 21, -18, 2, 1, 0, 0, 20, -23, 1, 1, 0, 0, -13, 12, 2, -2, 0, 0, -12, 14, 2, -1, 1, 0, -11, 9, 2, -2, -1, 0, -11, 7, 0, 2, 0, 0, 11, 0, 2, -1, -2, 0, -6, -7, 0, 1, -2, 0, 7, 5, 0, 1, 2, 0, 6, -4, 2, 2, -1, 0, 5, -3, 0, 2, -1, 0, 5, 3, 4, -1, -1, 0, -3, 3, 2, 0, 0, 0, 3, -4, 4, -1, -2, 0, -2, 0, 2, 1, -2, 0, -2, 0, 2, -1, 0, -2, -2, 0, 2, 1, 1, 0, 2, -2, 2, 0, -1, 0, 2, 0, 0, 2, 1, 0, 2, 0};
    static final short[] MB = {0, 0, 0, 1, 18461, 2387, 0, 0, 1, 1, 1010, 1671, 0, 0, 1, -1, 999, 6936, 2, 0, 0, -1, 623, 6524, 2, 0, -1, 1, 199, 4837, 2, 0, -1, -1, 166, 5741, 2, 0, 0, 1, 117, 2607, 0, 0, 2, 1, 61, 9120, 2, 0, 1, -1, 33, 3572, 0, 0, 2, -1, 31, 7597, 2, -1, 0, -1, 29, 5766, 2, 0, -2, -1, 15, 5663, 2, 0, 1, 1, 15, 1216, 2, 1, 0, -1, -12, -941, 2, -1, -1, 1, 8, 8681, 2, -1, 0, 1, 7, 9586, 2, -1, -1, -1, 7, 4346, 0, 1, -1, -1, -6, -7314, 4, 0, -1, -1, 6, 5796, 0, 1, 0, 1, -6, -4601, 0, 0, 0, 3, -6, -2965, 0, 1, -1, 1, -5, -6324, 1, 0, 0, 1, -5, -3684, 0, 1, 1, 1, -5, -3113, 0, 1, 1, -1, -5, -759, 0, 1, 0, -1, -4, -8396, 1, 0, 0, -1, -4, -8057, 0, 0, 3, 1, 3, 9841, 4, 0, 0, -1, 3, 6745, 4, 0, -1, 1, 2, 9985, 0, 0, 1, -3, 2, 7986, 4, 0, -2, 1, 2, 4139, 2, 0, 0, -3, 2, 1863, 2, 0, 2, -1, 2, 1462, 2, -1, 1, -1, 1, 7660, 2, 0, -2, 1, -1, -6244, 0, 0, 3, -1, 1, 5813, 2, 0, 2, 1, 1, 5198, 2, 0, -3, -1, 1, 5156, 2, 1, -1, 1, -1, -3178, 2, 1, 0, 1, -1, -2643, 4, 0, 0, 1, 1, 1919, 2, -1, 1, 1, 1, 1346, 2, -2, 0, -1, 1, 859, 0, 0, 1, 3, -1, -194, 2, 1, 1, -1, 0, -8227, 1, 1, 0, -1, 0, 8042, 1, 1, 0, 1, 0, 8026, 0, 1, -2, -1, 0, -7932, 2, 1, -1, -1, 0, -7910, 1, 0, 1, 1, 0, -6674, 2, -1, -2, -1, 0, 6502, 0, 1, 2, 1, 0, -6388, 4, 0, -2, -1, 0, 6337, 4, -1, -1, -1, 0, 5958, 1, 0, 1, -1, 0, -5889, 4, 0, 1, -1, 0, 4734, 1, 0, -1, -1, 0, -4299, 4, -1, 0, -1, 0, 4149, 2, -2, 0, 1, 0, 3835, 3, 0, 0, -1, 0, -3518, 4, -1, -1, 1, 0, 3388, 2, 0, -1, -3, 0, 3291, 2, -2, -1, 1, 0, 3147, 0, 1, 2, -1, 0, -3129, 3, 0, -1, -1, 0, -3052, 0, 1, -2, 1, 0, -3013, 2, 0, 1, -3, 0, -2912, 2, -2, -1, -1, 0, 2686, 0, 0, 4, 1, 0, 2633, 2, 0, -3, 1, 0, 2541, 2, 0, -1, 3, 0, -2448, 2, 1, 1, 1, 0, -2370, 4, -1, -2, 1, 0, 2138, 4, 0, 1, 1, 0, 2126, 3, 0, -1, 1, 0, -2059, 4, 1, -1, -1, 0, -1719};
    static double Ma = 0.0d;
    static final int NBT = 16;
    static final int NBT2 = 12;
    static final int NLR = 118;
    static final int NLRT = 38;
    static final int NLRT2 = 25;
    static final int NMB = 77;
    static double Sa;
    static double T3;
    static double T4;
    static double Ve;
    static double cg;
    static double f;
    static double g;
    static double l1;
    static double l2;
    static double l3;
    static double l4;
    static double sg;
    static final double[] z = {-13.12045233711d, -0.00113821591258d, -9.646018347184E-6d, 31.46734198839d, 0.0476835758578d, -3.421689790404E-4d, -6.84707090541d, -0.005834100476561d, -2.905334122698E-4d, -5.663161722088d, 0.005722859298199d, -8.466472828815E-5d, -84.29817796435d, -207.2552484689d, 7.876842214863d, 1.836463749022d, -15.57471855361d, -20.06969124724d, 21.52670284757d, -6.179946916139d, -0.9070028191196d, -12.70848233038d, -2.145589319058d, 13.81936399935d, -1.999840061168d};
    double B;
    double D;
    double M;
    double MP;
    double NF;
    double SWELP;
    double T;
    double T2;
    double[][] cc;
    double l;
    private double[] mean_apsis_corr;
    private double[] mean_node_corr;
    double[] moonpol;
    SwissLib sl;
    double[][] ss;
    SwissData swed;

    Swemmoon() {
        this((SwissData) null, (SwissLib) null);
    }

    Swemmoon(SwissData swissData, SwissLib swissLib) {
        Class<double> cls = double.class;
        this.mean_node_corr = new double[]{-2.56d, -2.473d, -2.392347d, -2.316425d, -2.239639d, -2.167764d, -2.0951d, -2.02481d, -1.957622d, -1.890097d, -1.826389d, -1.763335d, -1.701047d, -1.643016d, -1.584186d, -1.527309d, -1.473352d, -1.418917d, -1.367736d, -1.317202d, -1.267269d, -1.221121d, -1.174218d, -1.128862d, -1.086214d, -1.042998d, -1.002491d, -0.962635d, -0.923176d, -0.887191d, -0.850403d, -0.814929d, -0.782117d, -0.748462d, -0.717241d, -0.686598d, -0.656013d, -0.628726d, -0.60046d, -0.573219d, -0.548634d, -0.522931d, -0.499285d, -0.476273d, -0.452978d, -0.432663d, -0.411386d, -0.390788d, -0.372825d, -0.353681d, -0.33623d, -0.31952d, -0.302343d, -0.287794d, -0.272262d, -0.257166d, -0.244534d, -0.230635d, -0.218126d, -0.206365d, -0.194d, -0.183876d, -0.172782d, -0.161877d, -0.153254d, -0.143371d, -0.134501d, -0.126552d, -0.117932d, -0.111199d, -0.103716d, -0.09616d, -0.090718d, -0.084046d, -0.078007d, -0.072959d, -0.067235d, -0.06299d, -0.058102d, -0.05307d, -0.049786d, -0.045381d, -0.041317d, -0.038165d, -0.034501d, -0.031871d, -0.028844d, -0.025701d, -0.024018d, -0.021427d, -0.018881d, -0.017291d, -0.015186d, -0.013755d, -0.012098d, -0.010261d, -0.009688d, -0.008218d, -0.00667d, -0.005979d, -0.004756d, -0.003991d, -0.002996d, -0.001974d, -0.001975d, -0.001213d, -3.77E-4d, -3.56E-4d, 5.779E-5d, 3.78E-4d, 7.1E-4d, 0.001092d, 7.67E-4d, 9.85E-4d, 0.001443d, 0.001069d, 0.001141d, 0.001321d, 0.001462d, 0.001695d, 0.001319d, 0.001567d, 0.001873d, 0.001376d, 0.001336d, 0.001347d, 0.00133d, 0.001256d, 8.13E-4d, 9.46E-4d, 0.001079d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.64E-4d, -4.52E-4d, -0.001091d, -0.001159d, -0.001136d, -0.001798d, -0.002249d, -0.002622d, -0.00299d, -0.003555d, -0.004425d, -0.004758d, -0.005134d, -0.006065d, -0.006839d, -0.007474d, -0.008283d, -0.009411d, -0.010786d, -0.01181d, -0.012989d, -0.014825d, -0.016426d, -0.017922d, -0.019774d, -0.021881d, -0.024194d, -0.02619d, -0.02844d, -0.031285d, -0.033817d, -0.036318d, -0.039212d, -0.042456d, -0.045799d, -0.048994d, -0.05271d, -0.056948d, -0.061017d, -0.065181d, -0.069843d, -0.074922d, -0.079976d, -0.085052d, -0.090755d, -0.09684d, -0.102797d, -0.108939d, -0.115568d, -0.122636d, -0.129593d, -0.136683d, -0.144641d, -0.152825d, -0.161044d, -0.169758d, -0.178916d, -0.188712d, -0.198401d, -0.208312d, -0.219395d, -0.230407d, -0.241577d, -0.253508d, -0.26564d, -0.278556d, -0.29133d, -0.304353d, -0.318815d, -0.332882d, -0.347316d, -0.362895d, -0.378421d, -0.395061d, -0.411748d, -0.428666d, -0.447477d, -0.465636d, -0.484277d, -0.5046d, -0.524405d, -0.545533d, -0.56702d, -0.588404d, -0.612099d, -0.634965d, -0.658262d, -0.683866d, -0.708526d, -0.734719d, -0.7618d, -0.788562d, -0.818092d, -0.846885d, -0.876177d, -0.908385d, -0.939371d, -0.972027d, -1.006149d, -1.039634d, -1.076135d, -1.112156d, -1.14849d, -1.188312d, -1.226761d, -1.266821d, -1.309156d, -1.350583d, -1.395223d, -1.440028d, -1.485047d, -1.534104d, -1.582023d, -1.631506d, -1.684031d, -1.735687d, -1.790421d, -1.846039d, -1.901951d, -1.961872d, -2.021179d, -2.081987d, -2.146259d, -2.210031d, -2.276609d, -2.344904d, -2.413795d, -2.486559d, -2.559564d, -2.634215d, -2.712692d, -2.791289d, -2.872533d, -2.956217d, -3.040965d, -3.129234d, -3.218545d, -3.309805d, -3.404827d, -3.5008d, -3.601d, -3.7d, -3.8d};
        this.mean_apsis_corr = new double[]{7.525d, 7.29d, 7.057295d, 6.830813d, 6.611723d, 6.396775d, 6.189569d, 5.985968d, 5.788342d, 5.597304d, 5.410167d, 5.229946d, 5.053389d, 4.882187d, 4.716494d, 4.553532d, 4.396734d, 4.243718d, 4.094282d, 3.950865d, 3.810366d, 3.674978d, 3.543284d, 3.41427d, 3.290526d, 3.168775d, 3.050904d, 2.937541d, 2.826189d, 2.719822d, 2.616193d, 2.515431d, 2.419193d, 2.323782d, 2.232545d, 2.143635d, 2.056803d, 1.974913d, 1.893874d, 1.816201d, 1.741957d, 1.668083d, 1.598335d, 1.529645d, 1.463016d, 1.399693d, 1.336905d, 1.278097d, 1.220965d, 1.165092d, 1.113071d, 1.060858d, 1.011007d, 0.963701d, 0.916523d, 0.872887d, 0.829596d, 0.788486d, 0.750017d, 0.711177d, 0.675589d, 0.640303d, 0.605303d, 0.57349d, 0.541113d, 0.511482d, 0.483159d, 0.45521d, 0.430305d, 0.404643d, 0.380782d, 0.358524d, 0.335405d, 0.315244d, 0.295131d, 0.275766d, 0.259223d, 0.241586d, 0.22589d, 0.210404d, 0.194775d, 0.181573d, 0.167246d, 0.154514d, 0.143435d, 0.131131d, 0.121648d, 0.111835d, 0.102474d, 0.094284d, 0.085204d, 0.07824d, 0.070697d, 0.063696d, 0.058894d, 0.05239d, 0.047632d, 0.043129d, 0.037823d, 0.034143d, 0.029188d, 0.025648d, 0.021972d, 0.018348d, 0.017127d, 0.013989d, 0.011967d, 0.011003d, 0.007865d, 0.007033d, 0.005574d, 0.00406d, 0.003699d, 0.002465d, 0.002889d, 0.002144d, 0.001018d, 0.001757d, -9.67E-5d, -7.34E-4d, -3.92E-4d, -0.001546d, -8.63E-4d, -0.001266d, -9.33E-4d, -5.03E-4d, -0.001304d, 2.38E-4d, -5.07E-4d, -8.97E-4d, 6.47E-4d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 5.14E-4d, 6.83E-4d, 0.002228d, 0.001974d, 0.003485d, 0.00428d, 0.005409d, 0.007468d, 0.007938d, 0.011012d, 0.012525d, 0.013757d, 0.016757d, 0.017932d, 0.02078d, 0.023416d, 0.026386d, 0.030428d, 0.033512d, 0.038789d, 0.043126d, 0.047778d, 0.054175d, 0.058891d, 0.065878d, 0.072345d, 0.079668d, 0.088238d, 0.095307d, 0.104873d, 0.113533d, 0.122336d, 0.133205d, 0.142922d, 0.154871d, 0.166488d, 0.179234d, 0.193928d, 0.207262d, 0.223089d, 0.238736d, 0.254907d, 0.273232d, 0.291085d, 0.311046d, 0.331025d, 0.351955d, 0.374422d, 0.396341d, 0.420772d, 0.444867d, 0.469984d, 0.497448d, 0.524717d, 0.554752d, 0.584581d, 0.616272d, 0.649744d, 0.682947d, 0.719405d, 0.755834d, 0.79378d, 0.833875d, 0.873893d, 0.91734d, 0.960429d, 1.005471d, 1.052384d, 1.099317d, 1.149508d, 1.20013d, 1.253038d, 1.307672d, 1.36348d, 1.422592d, 1.4819d, 1.544111d, 1.607982d, 1.672954d, 1.741025d, 1.809727d, 1.882038d, 1.955243d, 2.029956d, 2.108428d, 2.186805d, 2.268697d, 2.352071d, 2.43737d, 2.525903d, 2.615415d, 2.709082d, 2.804198d, 2.901704d, 3.002606d, 3.104412d, 3.210406d, 3.317733d, 3.428386d, 3.541634d, 3.656634d, 3.775988d, 3.896306d, 4.02048d, 4.146814d, 4.275356d, 4.408257d, 4.542282d, 4.681174d, 4.822524d, 4.966424d, 5.114948d, 5.264973d, 5.419906d, 5.577056d, 5.737688d, 5.902347d, 6.069138d, 6.241065d, 6.415155d, 6.593317d, 6.774853d, 6.959322d, 7.148845d, 7.340334d, 7.537156d, 7.737358d, 7.940882d, 8.149932d, 8.361576d, 8.57915d, 8.799591d, 9.024378d, 9.254584d, 9.487362d, 9.726535d, 9.968784d, 10.216089d, 10.467716d, 10.725293d, 10.986d, 11.25d, 11.52d};
        this.ss = (double[][]) Array.newInstance(cls, new int[]{5, 8});
        this.cc = (double[][]) Array.newInstance(cls, new int[]{5, 8});
        this.moonpol = new double[3];
        this.swed = swissData;
        this.sl = swissLib;
        if (swissData == null) {
            this.swed = new SwissData();
        }
        if (this.sl == null) {
            this.sl = new SwissLib();
        }
    }

    /* access modifiers changed from: package-private */
    public int swi_moshmoon2(double d, double[] dArr) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        this.T = d2;
        this.T2 = d2 * d2;
        mean_elements();
        mean_elements_pl();
        moon1();
        moon2();
        moon3();
        moon4();
        for (int i = 0; i < 3; i++) {
            dArr[i] = this.moonpol[i];
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swi_moshmoon(double d, boolean z2, double[] dArr, StringBuffer stringBuffer) {
        double d2 = d;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        PlanData planData = this.swed.pldat[1];
        if (z2) {
            dArr4 = planData.x;
        }
        if (d2 < 625000.3d || d2 > 2818000.7d) {
            if (stringBuffer2 != null) {
                String str = "jd " + d2 + " outside Moshier's Moon range " + 625000.5d + " .. " + 2818000.5d + " ";
                if (stringBuffer.length() + str.length() < 256) {
                    stringBuffer2.append(str);
                }
            }
            return -1;
        } else if (d2 == planData.teval && planData.iephe == 4) {
            if (dArr != null) {
                for (int i = 0; i <= 5; i++) {
                    dArr[i] = planData.x[i];
                }
            }
            return 0;
        } else {
            swi_moshmoon2(d2, dArr4);
            if (z2) {
                planData.teval = d2;
                planData.xflgs = -1;
                planData.iephe = 4;
            }
            ecldat_equ2000(d2, dArr4);
            double d3 = d2 + 5.0E-5d;
            swi_moshmoon2(d3, dArr2);
            ecldat_equ2000(d3, dArr2);
            double d4 = d2 - 5.0E-5d;
            swi_moshmoon2(d4, dArr3);
            ecldat_equ2000(d4, dArr3);
            for (int i2 = 0; i2 <= 2; i2++) {
                dArr4[i2 + 3] = (((((dArr2[i2] + dArr3[i2]) / 2.0d) - dArr4[i2]) * 2.0d) + ((dArr2[i2] - dArr3[i2]) / 2.0d)) / 5.0E-5d;
            }
            if (dArr != null) {
                for (int i3 = 0; i3 <= 5; i3++) {
                    dArr[i3] = dArr4[i3];
                }
            }
            return 0;
        }
    }

    private void moon1() {
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                this.ss[i][i2] = 0.0d;
                this.cc[i][i2] = 0.0d;
            }
        }
        sscc(0, this.D * 4.84813681109536E-6d, 6);
        sscc(1, this.M * 4.84813681109536E-6d, 4);
        sscc(2, this.MP * 4.84813681109536E-6d, 4);
        sscc(3, this.NF * 4.84813681109536E-6d, 4);
        double[] dArr = this.moonpol;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        chewm(LRT2, 25, 4, 2, dArr);
        chewm(BT2, 12, 4, 4, this.moonpol);
        double d = (Ve * 18.0d) - (Ea * 16.0d);
        f = d;
        double d2 = (d - this.MP) * 4.84813681109536E-6d;
        g = d2;
        cg = SMath.cos(d2);
        double sin = SMath.sin(g);
        sg = sin;
        double d3 = cg;
        this.l = (6.367278d * d3) + (12.747036d * sin);
        l1 = (23123.7d * d3) - (10570.02d * sin);
        double[] dArr2 = z;
        l2 = (dArr2[12] * d3) + (dArr2[13] * sin);
        double[] dArr3 = this.moonpol;
        dArr3[2] = dArr3[2] + (d3 * 5.01d) + (sin * 2.72d);
        double d4 = (((Ve * 10.0d) - (Ea * 3.0d)) - this.MP) * 4.84813681109536E-6d;
        g = d4;
        cg = SMath.cos(d4);
        double sin2 = SMath.sin(g);
        sg = sin2;
        double d5 = this.l;
        double d6 = cg;
        this.l = d5 + (-0.253102d * d6) + (0.503359d * sin2);
        l1 += (1258.46d * d6) + (707.29d * sin2);
        l2 += (dArr2[14] * d6) + (dArr2[15] * sin2);
        double d7 = ((Ve * 8.0d) - (Ea * 13.0d)) * 4.84813681109536E-6d;
        g = d7;
        cg = SMath.cos(d7);
        double sin3 = SMath.sin(g);
        sg = sin3;
        double d8 = this.l;
        double d9 = cg;
        this.l = d8 + ((-0.187231d * d9) - (0.127481d * sin3));
        l1 += (-319.87d * d9) - (18.34d * sin3);
        l2 += (dArr2[16] * d9) + (dArr2[17] * sin3);
        double d10 = ((Ea * 4.0d) - (Ma * 8.0d)) + (Ju * 3.0d);
        double d11 = d10 * 4.84813681109536E-6d;
        g = d11;
        cg = SMath.cos(d11);
        double sin4 = SMath.sin(g);
        sg = sin4;
        double d12 = this.l;
        double d13 = cg;
        this.l = d12 + (-0.866287d * d13) + (0.248192d * sin4);
        l1 += (41.87d * d13) + (1053.97d * sin4);
        l2 += (dArr2[18] * d13) + (dArr2[19] * sin4);
        double d14 = (d10 - this.MP) * 4.84813681109536E-6d;
        g = d14;
        cg = SMath.cos(d14);
        double sin5 = SMath.sin(g);
        sg = sin5;
        double d15 = this.l;
        double d16 = cg;
        this.l = d15 + (d16 * -0.165009d) + (sin5 * 0.044176d);
        l1 += (d16 * 4.67d) + (sin5 * 201.55d);
        double d17 = f * 4.84813681109536E-6d;
        g = d17;
        cg = SMath.cos(d17);
        double sin6 = SMath.sin(g);
        sg = sin6;
        double d18 = this.l;
        double d19 = cg;
        this.l = d18 + (0.330401d * d19) + (0.661362d * sin6);
        l1 += (1202.67d * d19) - (555.59d * sin6);
        l2 += (dArr2[20] * d19) + (dArr2[21] * sin6);
        double d20 = (f - (this.MP * 2.0d)) * 4.84813681109536E-6d;
        g = d20;
        cg = SMath.cos(d20);
        double sin7 = SMath.sin(g);
        sg = sin7;
        double d21 = this.l;
        double d22 = cg;
        this.l = d21 + (0.352185d * d22) + (0.705041d * sin7);
        l1 += (d22 * 1283.59d) - (sin7 * 586.43d);
        double d23 = ((Ju * 2.0d) - (Sa * 5.0d)) * 4.84813681109536E-6d;
        g = d23;
        cg = SMath.cos(d23);
        double sin8 = SMath.sin(g);
        sg = sin8;
        double d24 = this.l;
        double d25 = cg;
        this.l = d24 + (-0.0347d * d25) + (0.160041d * sin8);
        l2 += (dArr2[22] * d25) + (dArr2[23] * sin8);
        double d26 = (this.SWELP - this.NF) * 4.84813681109536E-6d;
        g = d26;
        cg = SMath.cos(d26);
        double sin9 = SMath.sin(g);
        sg = sin9;
        this.l += (cg * 1.16E-4d) + (7.06304d * sin9);
        l1 += sin9 * 298.8d;
        double sin10 = SMath.sin(this.M * 4.84813681109536E-6d);
        sg = sin10;
        l3 = dArr2[24] * sin10;
        l4 = 0.0d;
        double d27 = ((this.D * 2.0d) - this.M) * 4.84813681109536E-6d;
        g = d27;
        sg = SMath.sin(d27);
        double cos = SMath.cos(g);
        cg = cos;
        double[] dArr4 = this.moonpol;
        dArr4[2] = dArr4[2] + (cos * -0.2655d * this.T);
        double d28 = (this.M - this.MP) * 4.84813681109536E-6d;
        g = d28;
        dArr4[2] = dArr4[2] + (SMath.cos(d28) * -0.1568d * this.T);
        double d29 = (this.M + this.MP) * 4.84813681109536E-6d;
        g = d29;
        double[] dArr5 = this.moonpol;
        dArr5[2] = dArr5[2] + (SMath.cos(d29) * 0.1309d * this.T);
        double d30 = (((this.D + this.M) * 2.0d) - this.MP) * 4.84813681109536E-6d;
        g = d30;
        sg = SMath.sin(d30);
        double cos2 = SMath.cos(g);
        cg = cos2;
        double[] dArr6 = this.moonpol;
        dArr6[2] = dArr6[2] + (cos2 * 0.5568d * this.T);
        l2 += dArr6[0];
        double d31 = (((this.D * 2.0d) - this.M) - this.MP) * 4.84813681109536E-6d;
        g = d31;
        double d32 = dArr6[2];
        double d33 = this.T;
        dArr6[2] = d32 + (SMath.cos(d31) * -0.191d * d33);
        double[] dArr7 = this.moonpol;
        dArr7[1] = dArr7[1] * d33;
        dArr7[2] = dArr7[2] * d33;
        dArr7[0] = 0.0d;
        chewm(BT, 16, 4, 4, dArr7);
        chewm(LRT, 38, 4, 1, this.moonpol);
        double d34 = (((f - this.MP) - this.NF) - 2355767.6d) * 4.84813681109536E-6d;
        g = d34;
        double[] dArr8 = this.moonpol;
        dArr8[1] = dArr8[1] + (SMath.sin(d34) * -1127.0d);
        double d35 = (((f - this.MP) + this.NF) - 235353.6d) * 4.84813681109536E-6d;
        g = d35;
        double[] dArr9 = this.moonpol;
        dArr9[1] = dArr9[1] + (SMath.sin(d35) * -1123.0d);
        double d36 = (Ea + this.D + 51987.6d) * 4.84813681109536E-6d;
        g = d36;
        double[] dArr10 = this.moonpol;
        dArr10[1] = dArr10[1] + (SMath.sin(d36) * 1303.0d);
        double d37 = this.SWELP * 4.84813681109536E-6d;
        g = d37;
        double[] dArr11 = this.moonpol;
        dArr11[1] = dArr11[1] + (SMath.sin(d37) * 342.0d);
        double d38 = ((Ve * 2.0d) - (Ea * 3.0d)) * 4.84813681109536E-6d;
        g = d38;
        cg = SMath.cos(d38);
        double sin11 = SMath.sin(g);
        sg = sin11;
        double d39 = this.l;
        double d40 = cg;
        this.l = d39 + ((-0.34355d * d40) - (2.76E-4d * sin11));
        l1 += (d40 * 105.9d) + (sin11 * 336.53d);
        double d41 = (f - (this.D * 2.0d)) * 4.84813681109536E-6d;
        g = d41;
        cg = SMath.cos(d41);
        double sin12 = SMath.sin(g);
        sg = sin12;
        double d42 = this.l;
        double d43 = cg;
        this.l = d42 + (0.074668d * d43) + (0.149501d * sin12);
        l1 += (d43 * 271.77d) - (sin12 * 124.2d);
        double d44 = ((f - (this.D * 2.0d)) - this.MP) * 4.84813681109536E-6d;
        g = d44;
        cg = SMath.cos(d44);
        double sin13 = SMath.sin(g);
        sg = sin13;
        double d45 = this.l;
        double d46 = cg;
        this.l = d45 + (0.073444d * d46) + (0.147094d * sin13);
        l1 += (d46 * 265.24d) - (sin13 * 121.16d);
        double d47 = ((f + (this.D * 2.0d)) - this.MP) * 4.84813681109536E-6d;
        g = d47;
        cg = SMath.cos(d47);
        double sin14 = SMath.sin(g);
        sg = sin14;
        double d48 = this.l;
        double d49 = cg;
        this.l = d48 + (0.072844d * d49) + (0.145829d * sin14);
        l1 += (d49 * 265.18d) - (sin14 * 121.29d);
        double d50 = (f + ((this.D - this.MP) * 2.0d)) * 4.84813681109536E-6d;
        g = d50;
        cg = SMath.cos(d50);
        double sin15 = SMath.sin(g);
        sg = sin15;
        double d51 = this.l;
        double d52 = cg;
        this.l = d51 + (0.070201d * d52) + (0.140542d * sin15);
        l1 += (d52 * 255.36d) - (sin15 * 116.79d);
        double d53 = ((Ea + this.D) - this.NF) * 4.84813681109536E-6d;
        g = d53;
        cg = SMath.cos(d53);
        double sin16 = SMath.sin(g);
        sg = sin16;
        double d54 = this.l;
        double d55 = cg;
        this.l = d54 + ((0.288209d * d55) - (0.025901d * sin16));
        l1 += (d55 * -63.51d) - (sin16 * 240.14d);
        double d56 = ((((Ea * 2.0d) - (Ju * 3.0d)) + (this.D * 2.0d)) - this.MP) * 4.84813681109536E-6d;
        g = d56;
        cg = SMath.cos(d56);
        double sin17 = SMath.sin(g);
        sg = sin17;
        double d57 = this.l;
        double d58 = cg;
        this.l = d57 + (0.077865d * d58) + (0.43846d * sin17);
        l1 += (d58 * 210.57d) + (sin17 * 124.84d);
        double d59 = (Ea - (Ma * 2.0d)) * 4.84813681109536E-6d;
        g = d59;
        cg = SMath.cos(d59);
        double sin18 = SMath.sin(g);
        sg = sin18;
        double d60 = this.l;
        double d61 = cg;
        this.l = d60 + (-0.216579d * d61) + (0.241702d * sin18);
        l1 += (d61 * 197.67d) + (sin18 * 125.23d);
        double d62 = (d10 + this.MP) * 4.84813681109536E-6d;
        g = d62;
        cg = SMath.cos(d62);
        double sin19 = SMath.sin(g);
        sg = sin19;
        double d63 = this.l;
        double d64 = cg;
        this.l = d63 + (-0.165009d * d64) + (0.044176d * sin19);
        l1 += (d64 * 4.67d) + (sin19 * 201.55d);
        double d65 = ((d10 + (this.D * 2.0d)) - this.MP) * 4.84813681109536E-6d;
        g = d65;
        cg = SMath.cos(d65);
        double sin20 = SMath.sin(g);
        sg = sin20;
        double d66 = this.l;
        double d67 = cg;
        this.l = d66 + (-0.133533d * d67) + (0.041116d * sin20);
        l1 += (d67 * 6.95d) + (sin20 * 187.07d);
        double d68 = ((d10 - (this.D * 2.0d)) + this.MP) * 4.84813681109536E-6d;
        g = d68;
        cg = SMath.cos(d68);
        double sin21 = SMath.sin(g);
        sg = sin21;
        double d69 = this.l;
        double d70 = cg;
        this.l = d69 + (-0.13343d * d70) + (0.041079d * sin21);
        l1 += (d70 * 6.28d) + (sin21 * 169.08d);
        double d71 = ((Ve * 3.0d) - (Ea * 4.0d)) * 4.84813681109536E-6d;
        g = d71;
        cg = SMath.cos(d71);
        double sin22 = SMath.sin(g);
        sg = sin22;
        double d72 = this.l;
        double d73 = cg;
        this.l = d72 + (-0.175074d * d73) + (0.003035d * sin22);
        double d74 = l1 + (d73 * 49.17d) + (sin22 * 150.57d);
        l1 = d74;
        double d75 = (((((Ea + this.D) - this.MP) * 2.0d) - (Ju * 3.0d)) + 213534.0d) * 4.84813681109536E-6d;
        g = d75;
        double sin23 = d74 + (SMath.sin(d75) * 158.4d);
        l1 = sin23;
        double[] dArr12 = this.moonpol;
        l1 = sin23 + dArr12[0];
        double d76 = this.T * 0.1d;
        dArr12[1] = dArr12[1] * d76;
        dArr12[2] = dArr12[2] * d76;
    }

    /* access modifiers changed from: package-private */
    public void moon2() {
        double d = (((((Ea - Ju) + this.D) * 2.0d) - this.MP) + 648431.172d) * 4.84813681109536E-6d;
        g = d;
        double sin = this.l + (SMath.sin(d) * 1.14307d);
        this.l = sin;
        double d2 = ((Ve - Ea) + 648035.568d) * 4.84813681109536E-6d;
        g = d2;
        double sin2 = sin + (SMath.sin(d2) * 0.82155d);
        this.l = sin2;
        double d3 = (((((Ve - Ea) * 3.0d) + (this.D * 2.0d)) - this.MP) + 647933.184d) * 4.84813681109536E-6d;
        g = d3;
        double sin3 = sin2 + (SMath.sin(d3) * 0.64371d);
        this.l = sin3;
        double d4 = ((Ea - Ju) + 4424.04d) * 4.84813681109536E-6d;
        g = d4;
        double sin4 = sin3 + (SMath.sin(d4) * 0.6388d);
        this.l = sin4;
        double d5 = (((this.SWELP + this.MP) - this.NF) + 4.68d) * 4.84813681109536E-6d;
        g = d5;
        double sin5 = sin4 + (SMath.sin(d5) * 0.49331d);
        this.l = sin5;
        double d6 = (((this.SWELP - this.MP) - this.NF) + 4.68d) * 4.84813681109536E-6d;
        g = d6;
        double sin6 = sin5 + (SMath.sin(d6) * 0.4914d);
        this.l = sin6;
        double d7 = (this.SWELP + this.NF + 2.52d) * 4.84813681109536E-6d;
        g = d7;
        double sin7 = sin6 + (SMath.sin(d7) * 0.36061d);
        this.l = sin7;
        double d8 = (((Ve * 2.0d) - (Ea * 2.0d)) + 736.2d) * 4.84813681109536E-6d;
        g = d8;
        double sin8 = sin7 + (SMath.sin(d8) * 0.30154d);
        this.l = sin8;
        double d9 = (((((Ea * 2.0d) - (Ju * 3.0d)) + (this.D * 2.0d)) - (this.MP * 2.0d)) + 36138.2d) * 4.84813681109536E-6d;
        g = d9;
        double sin9 = sin8 + (SMath.sin(d9) * 0.28282d);
        this.l = sin9;
        double d10 = (((((Ea * 2.0d) - (Ju * 2.0d)) + (this.D * 2.0d)) - (this.MP * 2.0d)) + 311.0d) * 4.84813681109536E-6d;
        g = d10;
        double sin10 = sin9 + (SMath.sin(d10) * 0.24516d);
        this.l = sin10;
        double d11 = (((Ea - Ju) - (this.D * 2.0d)) + this.MP + 6275.88d) * 4.84813681109536E-6d;
        g = d11;
        double sin11 = sin10 + (SMath.sin(d11) * 0.21117d);
        this.l = sin11;
        double d12 = (((Ea - Ma) * 2.0d) - 846.36d) * 4.84813681109536E-6d;
        g = d12;
        double sin12 = sin11 + (SMath.sin(d12) * 0.19444d);
        this.l = sin12;
        double d13 = (((Ea - Ju) * 2.0d) + 1569.96d) * 4.84813681109536E-6d;
        g = d13;
        double sin13 = sin12 - (SMath.sin(d13) * 0.18457d);
        this.l = sin13;
        double d14 = ((((Ea - Ju) * 2.0d) - this.MP) - 55.8d) * 4.84813681109536E-6d;
        g = d14;
        double sin14 = sin13 + (SMath.sin(d14) * 0.18256d);
        this.l = sin14;
        double d15 = (((Ea - Ju) - (this.D * 2.0d)) + 6490.08d) * 4.84813681109536E-6d;
        g = d15;
        double sin15 = sin14 + (SMath.sin(d15) * 0.16499d);
        this.l = sin15;
        double d16 = ((Ea - (Ju * 2.0d)) - 212378.4d) * 4.84813681109536E-6d;
        g = d16;
        double sin16 = sin15 + (SMath.sin(d16) * 0.16427d);
        this.l = sin16;
        double d17 = ((((Ve - Ea) - this.D) * 2.0d) + this.MP + 1122.48d) * 4.84813681109536E-6d;
        g = d17;
        double sin17 = sin16 + (SMath.sin(d17) * 0.16088d);
        this.l = sin17;
        double d18 = (((Ve - Ea) - this.MP) + 32.04d) * 4.84813681109536E-6d;
        g = d18;
        double sin18 = sin17 - (SMath.sin(d18) * 0.1535d);
        this.l = sin18;
        double d19 = (((Ea - Ju) - this.MP) + 4488.88d) * 4.84813681109536E-6d;
        g = d19;
        double sin19 = sin18 + (SMath.sin(d19) * 0.14346d);
        this.l = sin19;
        double d20 = (((((Ve - Ea) + this.D) * 2.0d) - this.MP) - 8.64d) * 4.84813681109536E-6d;
        g = d20;
        double sin20 = sin19 + (SMath.sin(d20) * 0.13594d);
        this.l = sin20;
        double d21 = ((((Ve - Ea) - this.D) * 2.0d) + 1319.76d) * 4.84813681109536E-6d;
        g = d21;
        double sin21 = sin20 + (SMath.sin(d21) * 0.13432d);
        this.l = sin21;
        double d22 = ((((Ve - Ea) - (this.D * 2.0d)) + this.MP) - 56.16d) * 4.84813681109536E-6d;
        g = d22;
        double sin22 = sin21 - (SMath.sin(d22) * 0.13122d);
        this.l = sin22;
        double d23 = ((Ve - Ea) + this.MP + 54.36d) * 4.84813681109536E-6d;
        g = d23;
        double sin23 = sin22 - (SMath.sin(d23) * 0.12722d);
        this.l = sin23;
        double d24 = ((((Ve - Ea) * 3.0d) - this.MP) + 433.8d) * 4.84813681109536E-6d;
        g = d24;
        double sin24 = sin23 + (SMath.sin(d24) * 0.12539d);
        this.l = sin24;
        double d25 = ((Ea - Ju) + this.MP + 4002.12d) * 4.84813681109536E-6d;
        g = d25;
        double sin25 = sin24 + (SMath.sin(d25) * 0.10994d);
        this.l = sin25;
        double d26 = (((((Ve * 20.0d) - (Ea * 21.0d)) - (this.D * 2.0d)) + this.MP) - 317511.72d) * 4.84813681109536E-6d;
        g = d26;
        double sin26 = sin25 + (SMath.sin(d26) * 0.10652d);
        this.l = sin26;
        double d27 = ((((Ve * 26.0d) - (Ea * 29.0d)) - this.MP) + 270002.52d) * 4.84813681109536E-6d;
        g = d27;
        double sin27 = sin26 + (SMath.sin(d27) * 0.1049d);
        this.l = sin27;
        double d28 = (((((Ve * 3.0d) - (Ea * 4.0d)) + this.D) - this.MP) - 322765.56d) * 4.84813681109536E-6d;
        g = d28;
        this.l = sin27 + (SMath.sin(d28) * 0.10386d);
        double d29 = (this.SWELP + 648002.556d) * 4.84813681109536E-6d;
        g = d29;
        double sin28 = SMath.sin(d29) * 8.04508d;
        this.B = sin28;
        double d30 = (Ea + this.D + 996048.252d) * 4.84813681109536E-6d;
        g = d30;
        double sin29 = sin28 + (SMath.sin(d30) * 1.51021d);
        this.B = sin29;
        double d31 = ((f - this.MP) + this.NF + 95554.332d) * 4.84813681109536E-6d;
        g = d31;
        double sin30 = sin29 + (SMath.sin(d31) * 0.63037d);
        this.B = sin30;
        double d32 = (((f - this.MP) - this.NF) + 95553.792d) * 4.84813681109536E-6d;
        g = d32;
        double sin31 = sin30 + (SMath.sin(d32) * 0.63014d);
        this.B = sin31;
        double d33 = ((this.SWELP - this.MP) + 2.9d) * 4.84813681109536E-6d;
        g = d33;
        double sin32 = sin31 + (SMath.sin(d33) * 0.45587d);
        this.B = sin32;
        double d34 = (this.SWELP + this.MP + 2.5d) * 4.84813681109536E-6d;
        g = d34;
        double sin33 = sin32 + (SMath.sin(d34) * -0.41573d);
        this.B = sin33;
        double d35 = ((this.SWELP - (this.NF * 2.0d)) + 3.2d) * 4.84813681109536E-6d;
        g = d35;
        double sin34 = sin33 + (SMath.sin(d35) * 0.32623d);
        this.B = sin34;
        double d36 = ((this.SWELP - (this.D * 2.0d)) + 2.5d) * 4.84813681109536E-6d;
        g = d36;
        this.B = sin34 + (SMath.sin(d36) * 0.29855d);
    }

    /* access modifiers changed from: package-private */
    public void moon3() {
        double[] dArr = this.moonpol;
        dArr[0] = 0.0d;
        chewm(LR, 118, 4, 1, dArr);
        chewm(MB, 77, 4, 3, this.moonpol);
        double d = this.l;
        double d2 = l4;
        double d3 = this.T;
        double d4 = d + (((((((d2 * d3) + l3) * d3) + l2) * d3) + l1) * d3 * 1.0E-5d);
        this.l = d4;
        double[] dArr2 = this.moonpol;
        dArr2[0] = this.SWELP + d4 + (dArr2[0] * 1.0E-4d);
        dArr2[1] = (dArr2[1] * 1.0E-4d) + this.B;
        dArr2[2] = (dArr2[2] * 1.0E-4d) + 385000.52899d;
    }

    /* access modifiers changed from: package-private */
    public void moon4() {
        double[] dArr = this.moonpol;
        dArr[2] = dArr[2] / 1.4959787066E8d;
        dArr[0] = mods3600(dArr[0]) * 4.84813681109536E-6d;
        double[] dArr2 = this.moonpol;
        dArr2[1] = dArr2[1] * 4.84813681109536E-6d;
        this.B = dArr2[1];
    }

    private double corr_mean_node(double d) {
        if (d < -3027215.5d || d > 7930192.5d) {
            return 0.0d;
        }
        double d2 = d - -3063616.5d;
        int floor = (int) SMath.floor(d2 / 36524.25d);
        double[] dArr = this.mean_node_corr;
        double d3 = dArr[floor];
        return d3 + (((d2 - (((double) floor) * 36524.25d)) / 36524.25d) * (dArr[floor + 1] - d3));
    }

    /* access modifiers changed from: package-private */
    public int swi_mean_node(double d, double[] dArr, StringBuffer stringBuffer) {
        return swi_mean_node(d, dArr, 0, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int swi_mean_node(double d, double[] dArr, int i, StringBuffer stringBuffer) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        this.T = d2;
        double d3 = d2 * d2;
        this.T2 = d3;
        T3 = d2 * d3;
        T4 = d3 * d3;
        if (d >= -3100015.5d && d <= 8000016.5d) {
            mean_elements();
            dArr[i] = this.sl.swi_mod2PI(((this.SWELP - this.NF) - (corr_mean_node(d) * 3600.0d)) * 4.84813681109536E-6d);
            dArr[i + 1] = 0.0d;
            dArr[i + 2] = 0.002569555290487047d;
            return 0;
        } else if (stringBuffer == null) {
            return -1;
        } else {
            stringBuffer.append("jd " + d + " outside mean node range " + -3100015.5d + " .. " + 8000016.5d + " ");
            return -1;
        }
    }

    private double corr_mean_apog(double d) {
        if (d < -3027215.5d || d > 7930192.5d) {
            return 0.0d;
        }
        double d2 = d - -3063616.5d;
        int floor = (int) SMath.floor(d2 / 36524.25d);
        double[] dArr = this.mean_apsis_corr;
        double d3 = dArr[floor];
        return d3 + (((d2 - (((double) floor) * 36524.25d)) / 36524.25d) * (dArr[floor + 1] - d3));
    }

    /* access modifiers changed from: package-private */
    public int swi_mean_apog(double d, double[] dArr, StringBuffer stringBuffer) {
        return swi_mean_apog(d, dArr, 0, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    public int swi_mean_apog(double d, double[] dArr, int i, StringBuffer stringBuffer) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        this.T = d2;
        double d3 = d2 * d2;
        this.T2 = d3;
        T3 = d2 * d3;
        T4 = d3 * d3;
        if (d >= -3100015.5d && d <= 8000016.5d) {
            mean_elements();
            dArr[i] = this.sl.swi_mod2PI(((this.SWELP - this.MP) * 4.84813681109536E-6d) + 3.141592653589793d);
            dArr[i + 1] = 0.0d;
            dArr[i + 2] = 0.002710625132447323d;
            dArr[i] = this.sl.swi_mod2PI(dArr[i] - (corr_mean_apog(d) * 0.0174532925199433d));
            double swi_mod2PI = this.sl.swi_mod2PI(((this.SWELP - this.NF) * 4.84813681109536E-6d) - (corr_mean_node(d) * 0.0174532925199433d));
            dArr[i] = this.sl.swi_mod2PI(dArr[i] - swi_mod2PI);
            this.sl.swi_polcart(dArr, i, dArr, i);
            this.sl.swi_coortrf(dArr, i, dArr, i, -0.08980410850026319d);
            this.sl.swi_cartpol(dArr, i, dArr, i);
            dArr[i] = this.sl.swi_mod2PI(dArr[i] + swi_mod2PI);
            return 0;
        } else if (stringBuffer == null) {
            return -1;
        } else {
            String str = "jd " + d + " outside mean apogee range " + -3100015.5d + " .. " + 8000016.5d + " ";
            if (stringBuffer.length() + str.length() >= 256) {
                return -1;
            }
            stringBuffer.append(str);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public void chewm(short[] sArr, int i, int i2, int i3, double[] dArr) {
        int i4;
        int i5;
        int i6 = i3;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i) {
            double d = 0.0d;
            double d2 = 0.0d;
            int i9 = 0;
            boolean z2 = false;
            while (i9 < i2) {
                int i10 = i8 + 1;
                short s = sArr[i8];
                if (s != 0) {
                    if (s < 0) {
                        i5 = -s;
                    } else {
                        i5 = s;
                    }
                    int i11 = i5 - 1;
                    double d3 = this.ss[i9][i11];
                    double d4 = this.cc[i9][i11];
                    if (s < 0) {
                        d3 = -d3;
                    }
                    if (!z2) {
                        d = d3;
                        d2 = d4;
                        z2 = true;
                    } else {
                        d2 = (d4 * d2) - (d3 * d);
                        d = (d3 * d2) + (d4 * d);
                    }
                }
                i9++;
                i8 = i10;
            }
            if (i6 == 1) {
                i4 = i7;
                int i12 = i8 + 1;
                short s2 = sArr[i8];
                int i13 = i12 + 1;
                dArr[0] = dArr[0] + (((((double) s2) * 10000.0d) + ((double) sArr[i12])) * d);
                int i14 = i13 + 1;
                short s3 = sArr[i13];
                int i15 = i14 + 1;
                short s4 = sArr[i14];
                if (s4 != 0) {
                    dArr[2] = dArr[2] + (((((double) s3) * 10000.0d) + ((double) s4)) * d2);
                }
                i8 = i15;
            } else if (i6 == 2) {
                int i16 = i8 + 1;
                short s5 = sArr[i8];
                int i17 = i16 + 1;
                short s6 = sArr[i16];
                i4 = i7;
                dArr[0] = dArr[0] + (((double) s5) * d);
                dArr[2] = dArr[2] + (((double) s6) * d2);
                i8 = i17;
            } else if (i6 == 3) {
                int i18 = i8 + 1;
                dArr[1] = dArr[1] + (((((double) sArr[i8]) * 10000.0d) + ((double) sArr[i18])) * d);
                i4 = i7;
                i8 = i18 + 1;
            } else if (i6 != 4) {
                i4 = i7;
            } else {
                dArr[1] = dArr[1] + (((double) sArr[i8]) * d);
                i8++;
                i4 = i7;
            }
            i7 = i4 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void sscc(int i, double d, int i2) {
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

    /* access modifiers changed from: package-private */
    public void ecldat_equ2000(double d, double[] dArr) {
        this.sl.swi_polcart(dArr, dArr);
        double[] dArr2 = dArr;
        this.sl.swi_coortrf2(dArr2, dArr, -this.swed.oec.seps, this.swed.oec.ceps);
        this.sl.swi_precess(dArr2, d, 0, 1);
    }

    /* access modifiers changed from: package-private */
    public double mods3600(double d) {
        return d - (SMath.floor(d / 1296000.0d) * 1296000.0d);
    }

    /* access modifiers changed from: package-private */
    public void swi_mean_lunar_elements(double d, DblObj dblObj, DblObj dblObj2, DblObj dblObj3, DblObj dblObj4) {
        DblObj dblObj5 = dblObj;
        DblObj dblObj6 = dblObj2;
        DblObj dblObj7 = dblObj3;
        double d2 = (d - 2451545.0d) / 36525.0d;
        this.T = d2;
        this.T2 = d2 * d2;
        mean_elements();
        dblObj5.val = this.sl.swe_degnorm((this.SWELP - this.NF) * 4.84813681109536E-6d * 57.2957795130823d);
        dblObj7.val = this.sl.swe_degnorm((this.SWELP - this.MP) * 4.84813681109536E-6d * 57.2957795130823d);
        this.T -= 2.7378507871321012E-5d;
        mean_elements();
        dblObj6.val = this.sl.swe_degnorm(dblObj5.val - (((this.SWELP - this.NF) * 4.84813681109536E-6d) * 57.2957795130823d));
        dblObj6.val -= 360.0d;
        dblObj4.val = this.sl.swe_degnorm(dblObj7.val - (((this.SWELP - this.MP) * 4.84813681109536E-6d) * 57.2957795130823d));
        dblObj5.val = this.sl.swe_degnorm(dblObj5.val - corr_mean_node(d));
        dblObj7.val = this.sl.swe_degnorm(dblObj7.val - corr_mean_apog(d));
    }

    /* access modifiers changed from: package-private */
    public void mean_elements() {
        double d = this.T;
        double d2 = d % 1.0d;
        double mods3600 = mods3600(((1.296E8d * d2) - (d * 3418.961646d)) + 1287104.76154d);
        this.M = mods3600;
        double d3 = this.T;
        this.M = mods3600 + (((((((((((((((((1.62E-20d * d3) - 1.039E-17d) * d3) - 3.83508E-15d) * d3) + 4.237343E-13d) * d3) + 8.8555011E-11d) * d3) - 4.77258489E-8d) * d3) - 1.1297037031E-5d) * d3) + 1.4732069041E-4d) * d3) - 0.552891801772d) * this.T2);
        this.NF = mods3600((((1.739232E9d * d2) + (295263.0983d * d3)) - (d3 * 0.207941990176d)) + 335779.55755d);
        double d4 = this.T;
        this.MP = mods3600((((1.7172E9d * d2) + (715923.4728d * d4)) - (d4 * 0.2035946368532d)) + 485868.28096d);
        double d5 = this.T;
        this.D = mods3600((1.601856E9d * d2) + (1105601.4603d * d5) + (d5 * 0.3962893294503d) + 1072260.73512d);
        double d6 = this.T;
        double mods36002 = mods3600((((d2 * 1.731456E9d) + (1108372.83264d * d6)) - (d6 * 0.6784914260953d)) + 785939.95571d);
        this.SWELP = mods36002;
        double d7 = this.NF;
        double[] dArr = z;
        double d8 = dArr[2];
        double d9 = this.T;
        double d10 = (((d8 * d9) + dArr[1]) * d9) + dArr[0];
        double d11 = this.T2;
        this.NF = d7 + (d10 * d11);
        this.MP += ((((dArr[5] * d9) + dArr[4]) * d9) + dArr[3]) * d11;
        this.D += ((((dArr[8] * d9) + dArr[7]) * d9) + dArr[6]) * d11;
        this.SWELP = mods36002 + (((((dArr[11] * d9) + dArr[10]) * d9) + dArr[9]) * d11);
    }

    /* access modifiers changed from: package-private */
    public void mean_elements_pl() {
        double mods3600 = mods3600((this.T * 2.106641364335482E8d) + 655127.283046d);
        Ve = mods3600;
        double d = this.T;
        Ve = mods3600 + (((((((((((((((((-9.36E-23d * d) - 1.95E-20d) * d) + 6.097E-18d) * d) + 4.43201E-15d) * d) + 2.509418E-13d) * d) - 3.0622898E-10d) * d) - 2.26602516E-9d) * d) - 1.4244812531E-5d) * d) + 0.005871373088d) * this.T2);
        double mods36002 = mods3600((d * 1.2959774226669231E8d) + 361679.214649d);
        Ea = mods36002;
        double d2 = this.T;
        Ea = mods36002 + (((((((((((((((((-1.16E-22d * d2) + 2.976E-19d) * d2) + 2.846E-17d) * d2) - 1.08402E-14d) * d2) - 1.226182E-12d) * d2) + 1.7228268E-10d) * d2) + 1.515912254E-7d) * d2) + 8.863982531E-6d) * d2) - 0.020199859001d) * this.T2);
        double mods36003 = mods3600((d2 * 6.890507759284E7d) + 1279559.78866d);
        Ma = mods36003;
        double d3 = this.T;
        Ma = mods36003 + (((-1.043E-5d * d3) + 0.00938012d) * this.T2);
        double mods36004 = mods3600((d3 * 1.0925660428608E7d) + 123665.34212d);
        Ju = mods36004;
        double d4 = this.T;
        Ju = mods36004 + (((1.543273E-5d * d4) - 0.306037836351d) * this.T2);
        double mods36005 = mods3600((d4 * 4399609.65932d) + 180278.89694d);
        Sa = mods36005;
        double d5 = this.T;
        Sa = mods36005 + (((((4.475946E-8d * d5) - 6.874806E-5d) * d5) + 0.756161437443d) * this.T2);
    }

    /* access modifiers changed from: package-private */
    public int swi_intp_apsides(double d, double[] dArr, int i) {
        int i2;
        double d2;
        int i3;
        double d3;
        int i4 = i;
        double d4 = (d - 2451545.0d) / 36525.0d;
        this.T = d4;
        double d5 = d4 * d4;
        this.T2 = d5;
        T4 = d5 * d5;
        mean_elements();
        mean_elements_pl();
        double d6 = this.NF;
        double d7 = this.M;
        double d8 = Ve;
        double d9 = Ea;
        double d10 = Ma;
        double d11 = Ju;
        double d12 = Sa;
        double mods3600 = mods3600(d6);
        double[] dArr2 = new double[3];
        double mods36002 = mods3600(this.D);
        double d13 = d11;
        double mods36003 = mods3600(this.SWELP);
        double d14 = d10;
        double mods36004 = mods3600(this.MP);
        double d15 = d9;
        if (i4 == 5) {
            this.MP = 0.0d;
            i2 = 5;
        } else {
            i2 = 4;
        }
        if (i4 == 4) {
            d2 = mods36004;
            this.MP = 648000.0d;
            i3 = 4;
        } else {
            d2 = mods36004;
            i3 = i2;
        }
        double d16 = 18000.0d;
        int i5 = 0;
        while (i5 <= i3) {
            double d17 = mods36002;
            double d18 = d2 - this.MP;
            double d19 = mods36003 - d18;
            double d20 = mods3600 - d18;
            double d21 = d17 - d18;
            double d22 = d2 - d18;
            int i6 = 0;
            while (true) {
                d3 = mods3600;
                if (i6 > 2) {
                    break;
                }
                double d23 = d7;
                double d24 = ((double) (i6 - 1)) * d16;
                double d25 = d8;
                this.MP = d22 + d24;
                this.NF = d20 + (d24 / 0.9875763144565655d);
                this.D = d21 + (d24 / 1.0717137083931927d);
                this.SWELP = d19 + (d24 / 0.9915452119154704d);
                this.M = d23 + (d24 / 13.255873802718783d);
                Ve = d25 + (d24 / 8.154762138324577d);
                Ea = d15 + (d24 / 13.255755020157855d);
                Ma = d14 + (d24 / 24.931630343874083d);
                double d26 = d13;
                Ju = d26 + (d24 / 157.236803608421d);
                Sa = d12 + (d24 / 390.4700772415594d);
                moon1();
                moon2();
                moon3();
                moon4();
                if (i6 == 1) {
                    for (int i7 = 0; i7 < 3; i7++) {
                        dArr[i7] = this.moonpol[i7];
                    }
                }
                dArr2[i6] = this.moonpol[2];
                i6++;
                mods3600 = d3;
                d7 = d23;
                d8 = d25;
                d13 = d26;
            }
            double d27 = d13;
            this.MP = d22 + ((((((dArr2[0] * 1.5d) - (dArr2[1] * 2.0d)) + (dArr2[2] * 0.5d)) / ((dArr2[0] + dArr2[2]) - (dArr2[1] * 2.0d))) * d16) - d16);
            d16 /= 10.0d;
            i5++;
            mods36002 = d17;
            mods3600 = d3;
            d7 = d7;
            d8 = d8;
        }
        return 0;
    }
}
