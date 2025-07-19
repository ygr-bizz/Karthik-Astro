package swisseph;

import java.io.Serializable;

class AyaInit implements Serializable {
    double ayan_t0;
    double t0;

    AyaInit(double d, double d2) {
        this.t0 = d;
        this.ayan_t0 = d2;
    }
}
