package swisseph;

import java.io.Serializable;

public class SwissData implements Serializable {
    public static final int AS_MAXCH = 256;
    static final String BFILE_A_ACCESS = "a+";
    static final String BFILE_RW_ACCESS = "r+";
    static final String BFILE_R_ACCESS = "r";
    static final String BFILE_W_CREATE = "w";
    static final double CS2DEG = 2.777777777777778E-6d;
    static final double CSTORAD = 4.84813681109536E-8d;
    static final int DEG = 360000;
    static final int DEG120 = 43200000;
    static final int DEG15 = 5400000;
    static final int DEG150 = 54000000;
    static final int DEG180 = 64800000;
    static final int DEG24 = 8640000;
    static final int DEG270 = 97200000;
    static final int DEG30 = 10800000;
    static final int DEG360 = 129600000;
    static final int DEG60 = 21600000;
    static final int DEG7_30 = 2700000;
    static final int DEG90 = 32400000;
    static final double DEGTORAD = 0.0174532925199433d;
    static final String FILE_A_ACCESS = "a+";
    static final String FILE_RW_ACCESS = "r+";
    static final String FILE_R_ACCESS = "r";
    static final String FILE_W_CREATE = "w";
    static final int OPEN_MODE = 438;
    static final int O_BINARY = 0;
    public static final String PATH_SEPARATOR = ";:";
    static final double RADTOCS = 2.06264806247096E7d;
    static final double RADTODEG = 57.2957795130823d;
    public static final int SE_NSIDM_PREDEF = 29;
    public static final String[] ayanamsa_name = {"Fagan/Bradley", "Lahiri", "De Luce", "Raman", "Ushashashi", "Krishnamurti", "Djwhal Khul", "Yukteshwar", "J.N. Bhasin", "Babylonian/Kugler 1", "Babylonian/Kugler 2", "Babylonian/Kugler 3", "Babylonian/Huber", "Babylonian/Eta Piscium", "Babylonian/Aldebaran = 15 Tau", "Hipparchos", "Sassanian", "Galact. Center = 0 Sag", "J2000", "J1900", "B1950", "Suryasiddhanta", "Suryasiddhanta, mean Sun", "Aryabhata", "Aryabhata, mean Sun", "SS Revati", "SS Citra", "True Citra"};
    static final int[] pnoext2int = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 12, 13, 14, 15, 16, 17};
    public String DIR_GLUE;
    public String ODEGREE_STRING = "°";
    double ast_G;
    double ast_H;
    double ast_diam;
    String astelem;
    boolean ayana_is_set;
    double[] deps;
    double[] dpsi;
    int eop_dpsi_loaded;
    double eop_tjd_beg;
    double eop_tjd_beg_horizons;
    double eop_tjd_end;
    double eop_tjd_end_add;
    boolean ephe_path_is_set;
    String ephepath;
    FileData[] fidat;
    FilePtr fixfp;
    GenConst gcdat;
    boolean geopos_is_set;
    int i_saved_planet_name;
    boolean is_old_starfile;
    int jpldenum;
    PlanData[] nddat;
    Nut nut;
    Nut nut2000;
    Nut nutv;
    Epsilon oec;
    Epsilon oec2000;
    PlanData[] pldat;
    String saved_planet_name;
    SavePositions[] savedat;
    SidData sidd;
    TopoData topd;

    public SwissData() {
        this.ephe_path_is_set = false;
        this.fixfp = null;
        this.ephepath = SweConst.SE_EPHE_PATH;
        this.jpldenum = 0;
        this.geopos_is_set = false;
        this.ayana_is_set = false;
        this.is_old_starfile = false;
        this.fidat = new FileData[7];
        this.pldat = new PlanData[18];
        this.nddat = new PlanData[6];
        this.savedat = new SavePositions[24];
        this.dpsi = new double[36525];
        this.deps = new double[36525];
        String property = System.getProperty("file.separator");
        this.DIR_GLUE = property;
        if (property == null) {
            this.DIR_GLUE = "/";
        }
        for (int i = 0; i < 7; i++) {
            this.fidat[i] = new FileData();
        }
        this.gcdat = new GenConst();
        for (int i2 = 0; i2 < 18; i2++) {
            this.pldat[i2] = new PlanData();
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.nddat[i3] = new PlanData();
        }
        for (int i4 = 0; i4 < 24; i4++) {
            this.savedat[i4] = new SavePositions();
        }
        this.oec = new Epsilon();
        this.oec2000 = new Epsilon();
        this.nut = new Nut();
        this.nut2000 = new Nut();
        this.nutv = new Nut();
        this.topd = new TopoData();
        this.sidd = new SidData();
    }
}
