package swisseph;

import java.io.Serializable;

class Epsilon implements Serializable {
    double ceps;
    double eps;
    double seps;
    double teps;

    Epsilon() {
    }

    /* access modifiers changed from: package-private */
    public void clearData() {
        this.teps = 0.0d;
        this.eps = 0.0d;
        this.seps = 0.0d;
        this.ceps = 0.0d;
    }
}
