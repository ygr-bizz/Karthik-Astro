package swisseph;

import java.io.Serializable;

public abstract class TransitCalculator implements Serializable {
    protected boolean rollover = false;
    protected double rolloverVal = 360.0d;
    SwissEph sw;

    /* access modifiers changed from: protected */
    public abstract double calc(double d);

    /* access modifiers changed from: protected */
    public abstract double getDegreePrecision(double d);

    /* access modifiers changed from: protected */
    public abstract double getMaxSpeed();

    /* access modifiers changed from: protected */
    public abstract double getMinSpeed();

    public abstract double getOffset();

    public abstract boolean getRollover();

    /* access modifiers changed from: protected */
    public abstract double getTimePrecision(double d);

    public abstract void setOffset(double d);

    public double getRolloverVal() {
        return this.rolloverVal;
    }

    public Object[] getObjectIdentifiers() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public double preprocessDate(double d, boolean z) {
        return d;
    }

    /* access modifiers changed from: protected */
    public boolean checkIdenticalResult(double d, double d2) {
        return d2 == d;
    }

    /* access modifiers changed from: protected */
    public boolean checkResult(double d, double d2, double d3, boolean z, boolean z2) {
        return (z && d3 <= d && !z2) || (!z && d3 >= d && z2) || (this.rollover && ((d < d2 && d3 > this.rolloverVal * 0.9d && d2 < 20.0d && !z2) || ((d > d2 && d3 < 20.0d && d2 > this.rolloverVal * 0.9d && z2) || ((d > d3 && d3 > this.rolloverVal * 0.9d && d2 < 20.0d && !z2) || (d < d3 && d3 < 20.0d && d2 > this.rolloverVal * 0.9d && z2)))));
    }

    /* access modifiers changed from: protected */
    public double getNextJD(double d, double d2, double d3, double d4, double d5, boolean z) {
        if (this.rollover) {
            double d6 = d2 - d3;
            double min = SMath.min(d6, (this.rolloverVal - d2) + d3) / SMath.abs(d5);
            double min2 = SMath.min(d6, (this.rolloverVal - d2) + d3) / SMath.abs(d4);
            if (z) {
                return d - SMath.min(min, min2);
            }
            return SMath.min(min, min2) + d;
        }
        double d7 = d3 - d2;
        double d8 = d7 / d5;
        double d9 = d7 / d4;
        if (z) {
            int i = (d8 > 0.0d ? 1 : (d8 == 0.0d ? 0 : -1));
            if (i >= 0 && d9 >= 0.0d) {
                throw new SwissephException(d, (int) SwissephException.OUT_OF_TIME_RANGE, -1, "No transit in ephemeris time range.");
            } else if (i >= 0) {
                return d9 + d;
            } else {
                return d + d8;
            }
        } else {
            int i2 = (d8 > 0.0d ? 1 : (d8 == 0.0d ? 0 : -1));
            if (i2 <= 0 && d9 <= 0.0d) {
                throw new SwissephException(d, (int) SwissephException.OUT_OF_TIME_RANGE, -1, "No transit in ephemeris time range.");
            } else if (i2 <= 0) {
                return d9 + d;
            } else {
                return d + d8;
            }
        }
    }
}
