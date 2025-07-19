package swisseph;

import java.io.Serializable;

class PlanData implements Serializable {
    double dperi;
    double dprot;
    double dqrot;
    double dseg;
    int ibdy;
    int iephe;
    int iflg;
    long lndx0;
    int ncoe;
    int neval;
    int nndx;
    double peri;
    double prot;
    double qrot;
    double[] refep;
    double rmax;
    double[] segp;
    double telem;
    double teval;
    double tfend;
    double tfstart;
    double tseg0;
    double tseg1;
    double[] x = new double[6];
    int xflgs;
    double[] xreturn = new double[24];

    PlanData() {
        this.ibdy = 0;
        this.iflg = 0;
        this.ncoe = 0;
        this.lndx0 = 0;
        this.nndx = 0;
        this.tfstart = 0.0d;
        this.tfend = 0.0d;
        this.dseg = 0.0d;
        this.telem = 0.0d;
        this.prot = 0.0d;
        this.qrot = 0.0d;
        this.dprot = 0.0d;
        this.dqrot = 0.0d;
        this.rmax = 0.0d;
        this.peri = 0.0d;
        this.dperi = 0.0d;
        this.refep = null;
        this.tseg0 = 0.0d;
        this.tseg1 = 0.0d;
        this.segp = null;
        this.neval = 0;
        this.teval = 0.0d;
        this.iephe = 0;
        this.xflgs = 0;
        int i = 0;
        while (true) {
            double[] dArr = this.x;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = 0.0d;
            i++;
        }
        for (int i2 = 0; i2 < this.x.length; i2++) {
            this.xreturn[i2] = 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public void clearData() {
        int i = 0;
        this.ibdy = 0;
        this.iflg = 0;
        this.ncoe = 0;
        this.lndx0 = 0;
        this.nndx = 0;
        this.tfstart = 0.0d;
        this.tfend = 0.0d;
        this.dseg = 0.0d;
        this.telem = 0.0d;
        this.prot = 0.0d;
        this.qrot = 0.0d;
        this.dprot = 0.0d;
        this.dqrot = 0.0d;
        this.rmax = 0.0d;
        this.peri = 0.0d;
        this.dperi = 0.0d;
        this.tseg0 = 0.0d;
        this.tseg1 = 0.0d;
        this.neval = 0;
        this.teval = 0.0d;
        this.iephe = 0;
        this.xflgs = 0;
        int i2 = 0;
        while (true) {
            double[] dArr = this.x;
            if (i2 >= dArr.length) {
                break;
            }
            dArr[i2] = 0.0d;
            i2++;
        }
        while (true) {
            double[] dArr2 = this.xreturn;
            if (i < dArr2.length) {
                dArr2[i] = 0.0d;
                i++;
            } else {
                this.refep = null;
                this.segp = null;
                return;
            }
        }
    }
}
