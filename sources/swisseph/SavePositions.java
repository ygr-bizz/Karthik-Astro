package swisseph;

import java.io.Serializable;

class SavePositions implements Serializable {
    int iflgsave;
    int ipl;
    double tsave = 0.0d;
    double[] xsaves = new double[24];

    SavePositions() {
    }

    /* access modifiers changed from: package-private */
    public void clearData() {
        int i = 0;
        while (true) {
            double[] dArr = this.xsaves;
            if (i < dArr.length) {
                dArr[i] = 0.0d;
                i++;
            } else {
                this.ipl = 0;
                this.tsave = 0.0d;
                this.iflgsave = 0;
                return;
            }
        }
    }
}
