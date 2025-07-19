package swisseph;

import java.io.Serializable;

class Plantbl implements Serializable {
    byte[] arg_tbl;
    double distance;
    double[] lat_tbl;
    double[] lon_tbl;
    short[] max_harmonic = new short[9];
    short max_power_of_t;
    double[] rad_tbl;

    Plantbl(short[] sArr, short s, byte[] bArr, double[] dArr, double[] dArr2, double[] dArr3, double d) {
        this.max_harmonic = sArr;
        this.max_power_of_t = s;
        this.arg_tbl = bArr;
        this.lon_tbl = dArr;
        this.lat_tbl = dArr2;
        this.rad_tbl = dArr3;
        this.distance = d;
    }
}
