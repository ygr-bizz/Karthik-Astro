package swisseph;

import java.io.Serializable;
import java.lang.reflect.Array;

class Nut implements Serializable {
    double cnut;
    double[][] matrix = ((double[][]) Array.newInstance(double.class, new int[]{3, 3}));
    double[] nutlo = new double[2];
    double snut;
    double tnut;

    Nut() {
    }

    /* access modifiers changed from: package-private */
    public void clearData() {
        this.tnut = 0.0d;
        this.snut = 0.0d;
        this.cnut = 0.0d;
        int i = 0;
        while (true) {
            double[] dArr = this.nutlo;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = 0.0d;
            i++;
        }
        for (int i2 = 0; i2 < this.matrix.length; i2++) {
            int i3 = 0;
            while (true) {
                double[][] dArr2 = this.matrix;
                if (i3 >= dArr2[i2].length) {
                    break;
                }
                dArr2[i2][i3] = 0.0d;
                i3++;
            }
        }
    }
}
