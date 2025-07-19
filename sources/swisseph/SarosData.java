package swisseph;

import java.io.Serializable;

class SarosData implements Serializable {
    int series_no;
    double tstart;

    SarosData(int i, double d) {
        this.series_no = i;
        this.tstart = d;
    }
}
