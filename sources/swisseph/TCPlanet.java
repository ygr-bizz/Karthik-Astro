package swisseph;

import java.io.Serializable;

public class TCPlanet extends TransitCalculator implements Serializable {
    private int flags = 0;
    private int idx = 0;
    private double max = 0.0d;
    double maxVal = 0.0d;
    private double min = 0.0d;
    double minVal = 0.0d;
    private double offset = 0.0d;
    private int planet;
    private int tflags = 0;

    public TCPlanet(SwissEph swissEph, int i, int i2, double d) {
        this.tflags = i2;
        int i3 = i2 & 8;
        if (i3 != 0) {
        }
        int i4 = -2068000 & i2;
        if (i4 == 0) {
            int i5 = 917504 & i2;
            if (i5 != 131072 && i5 != 262144 && i5 != 524288) {
                throw new IllegalArgumentException("Invalid flag combination '" + i2 + "': specify exactly one of SEFLG_TRANSIT_LONGITUDE (" + 131072 + "), SEFLG_TRANSIT_LATITUDE (" + 262144 + "), SEFLG_TRANSIT_DISTANCE (" + 524288 + ").");
            } else if (i < 0 || i > 22 || i == 14) {
                throw new IllegalArgumentException("Unsupported planet number " + i + " (" + swissEph.swe_get_planet_name(i) + ")");
            } else if (i3 == 0 || !(i == 12 || i == 13 || i == 10 || i == 11)) {
                this.planet = i;
                this.sw = swissEph;
                if (this.sw == null) {
                    this.sw = new SwissEph();
                }
                if ((i2 & 262144) != 0) {
                    this.idx = 1;
                } else if ((i2 & 524288) != 0) {
                    this.idx = 2;
                }
                if ((1048576 & i2) != 0) {
                    this.idx += 3;
                    i2 |= 256;
                }
                int i6 = i2 & -1966081;
                this.flags = i6;
                this.rollover = this.idx == 0;
                this.offset = checkOffset(d);
                this.max = getSpeed(false);
                this.min = getSpeed(true);
                if (Double.isInfinite(this.max) || Double.isInfinite(this.min)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((32768 & i6) != 0 ? "Topo" : (i6 & 8) != 0 ? "Helio" : "Geo");
                    sb.append("centric transit calculations of planet number ");
                    sb.append(i);
                    sb.append(" (");
                    sb.append(swissEph.swe_get_planet_name(i));
                    sb.append(") not possible: extreme ");
                    sb.append((i6 & 256) != 0 ? "accelerations" : "speeds");
                    sb.append(" of the planet ");
                    sb.append((i6 & 2048) != 0 ? "in equatorial system " : "");
                    sb.append("not available.");
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                throw new IllegalArgumentException("Unsupported planet number " + i + " (" + swissEph.swe_get_planet_name(i) + ") for heliocentric " + "calculations");
            }
        } else {
            throw new IllegalArgumentException("Invalid flag(s): " + i4);
        }
    }

    public boolean getRollover() {
        return this.rollover;
    }

    public void setOffset(double d) {
        this.offset = checkOffset(d);
    }

    public double getOffset() {
        return this.offset;
    }

    public Object[] getObjectIdentifiers() {
        return new Integer[]{Integer.valueOf(this.planet)};
    }

    /* access modifiers changed from: protected */
    public double calc(double d) {
        StringBuffer stringBuffer = new StringBuffer();
        double[] dArr = new double[6];
        int swe_calc = this.sw.swe_calc(d, this.planet, this.flags, dArr, stringBuffer);
        if (swe_calc >= 0) {
            return dArr[this.idx];
        }
        throw new SwissephException(d, 0, "Calculation failed with return code " + swe_calc + ":\n" + stringBuffer.toString());
    }

    /* access modifiers changed from: protected */
    public double getMaxSpeed() {
        return this.max;
    }

    /* access modifiers changed from: protected */
    public double getMinSpeed() {
        return this.min;
    }

    /* access modifiers changed from: protected */
    public double getTimePrecision(double d) {
        double max2 = SMath.max(SMath.abs(this.min), SMath.abs(this.max));
        if (max2 != 0.0d) {
            return d / max2;
        }
        return 1.0E-9d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r13 <= 2099.0d) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getDegreePrecision(double r13) {
        /*
            r12 = this;
            int r0 = r12.idx
            r1 = 4590429028186199163(0x3fb47ae147ae147b, double:0.08)
            r3 = 5
            r4 = 2
            if (r0 <= r4) goto L_0x0012
            r1 = 4566758108544739836(0x3f60624dd2f1a9fc, double:0.002)
            goto L_0x004a
        L_0x0012:
            int r5 = r12.planet
            r6 = 4656834164887126016(0x40a0660000000000, double:2099.0)
            r8 = 4656422947538337792(0x409ef00000000000, double:1980.0)
            if (r5 < 0) goto L_0x002b
            if (r5 > r3) goto L_0x002b
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x002a
            int r5 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0042
        L_0x002a:
            goto L_0x004a
        L_0x002b:
            r10 = 4656071103817449472(0x409db00000000000, double:1900.0)
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x0039
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0039
            goto L_0x004a
        L_0x0039:
            int r1 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x0048
            int r1 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0042
            goto L_0x0048
        L_0x0042:
            r1 = 4572414629676717179(0x3f747ae147ae147b, double:0.005)
            goto L_0x004a
        L_0x0048:
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x004a:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r1 = r1 / r13
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r1 = r1 * r13
            if (r0 == r4) goto L_0x0059
            if (r0 == r3) goto L_0x0059
            goto L_0x0065
        L_0x0059:
            swisseph.SwissEph r13 = r12.sw
            swisseph.Extensions r13 = r13.ext
            double[] r13 = r13.maxBaryDist
            int r14 = r12.planet
            r3 = r13[r14]
            double r1 = r1 * r3
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.TCPlanet.getDegreePrecision(double):double");
    }

    private double checkOffset(double d) {
        if (this.rollover) {
            while (d < 0.0d) {
                d += 360.0d;
            }
            double d2 = d % 360.0d;
            this.minVal = 0.0d;
            this.maxVal = 360.0d;
            return d2;
        } else if (this.idx != 1) {
            return d;
        } else {
            while (d < -90.0d) {
                d += 180.0d;
            }
            while (d > 90.0d) {
                d -= 180.0d;
            }
            this.minVal = -90.0d;
            this.maxVal = 90.0d;
            return d;
        }
    }

    private double getSpeed(boolean z) {
        if (this.planet >= SwephData.minTopoLonSpeed.length) {
            return z ? -0.1d : 0.0157d;
        }
        int i = this.tflags;
        boolean z2 = true;
        boolean z3 = (262144 & i) != 0;
        boolean z4 = (524288 & i) != 0;
        boolean z5 = (1048576 & i) != 0;
        boolean z6 = (32768 & i) != 0;
        boolean z7 = (i & 8) != 0;
        boolean z8 = (i & 2048) != 0 && !z3 && !z4;
        if ((i & 2048) == 0 || !z3) {
            z2 = false;
        }
        if (!z6) {
            return z7 ? z5 ? z8 ? z ? SwephData.minHelioRectAccel[this.planet] : SwephData.maxHelioRectAccel[this.planet] : z2 ? z ? SwephData.minHelioDeclAccel[this.planet] : SwephData.maxHelioDeclAccel[this.planet] : z3 ? z ? SwephData.minHelioLatAccel[this.planet] : SwephData.maxHelioLatAccel[this.planet] : z4 ? z ? SwephData.minHelioDistAccel[this.planet] : SwephData.maxHelioDistAccel[this.planet] : z ? SwephData.minHelioLonAccel[this.planet] : SwephData.maxHelioLonAccel[this.planet] : z8 ? z ? SwephData.minHelioRectSpeed[this.planet] : SwephData.maxHelioRectSpeed[this.planet] : z2 ? z ? SwephData.minHelioDeclSpeed[this.planet] : SwephData.maxHelioDeclSpeed[this.planet] : z3 ? z ? SwephData.minHelioLatSpeed[this.planet] : SwephData.maxHelioLatSpeed[this.planet] : z4 ? z ? SwephData.minHelioDistSpeed[this.planet] : SwephData.maxHelioDistSpeed[this.planet] : z ? SwephData.minHelioLonSpeed[this.planet] : SwephData.maxHelioLonSpeed[this.planet] : z5 ? z8 ? z ? SwephData.minRectAccel[this.planet] : SwephData.maxRectAccel[this.planet] : z2 ? z ? SwephData.minDeclAccel[this.planet] : SwephData.maxDeclAccel[this.planet] : z3 ? z ? SwephData.minLatAccel[this.planet] : SwephData.maxLatAccel[this.planet] : z4 ? z ? SwephData.minDistAccel[this.planet] : SwephData.maxDistAccel[this.planet] : z ? SwephData.minLonAccel[this.planet] : SwephData.maxLonAccel[this.planet] : z8 ? z ? SwephData.minRectSpeed[this.planet] : SwephData.maxRectSpeed[this.planet] : z2 ? z ? SwephData.minDeclSpeed[this.planet] : SwephData.maxDeclSpeed[this.planet] : z3 ? z ? SwephData.minLatSpeed[this.planet] : SwephData.maxLatSpeed[this.planet] : z4 ? z ? SwephData.minDistSpeed[this.planet] : SwephData.maxDistSpeed[this.planet] : z ? SwephData.minLonSpeed[this.planet] : SwephData.maxLonSpeed[this.planet];
        }
        if (!this.sw.swed.geopos_is_set) {
            throw new IllegalArgumentException("Geographic position is not set for requested topocentric calculations.");
        } else if (this.sw.swed.topd.geoalt > 50000.0d) {
            throw new IllegalArgumentException("Topocentric transit calculations are restricted to a maximum altitude of 50km so far.");
        } else if (this.sw.swed.topd.geoalt >= -1.2E7d) {
            return z5 ? z8 ? z ? SwephData.minTopoRectAccel[this.planet] : SwephData.maxTopoRectAccel[this.planet] : z2 ? z ? SwephData.minTopoDeclAccel[this.planet] : SwephData.maxTopoDeclAccel[this.planet] : z3 ? z ? SwephData.minTopoLatAccel[this.planet] : SwephData.maxTopoLatAccel[this.planet] : z4 ? z ? SwephData.minTopoDistAccel[this.planet] : SwephData.maxTopoDistAccel[this.planet] : z ? SwephData.minTopoLonAccel[this.planet] : SwephData.maxTopoLonAccel[this.planet] : z8 ? z ? SwephData.minTopoRectSpeed[this.planet] : SwephData.maxTopoRectSpeed[this.planet] : z2 ? z ? SwephData.minTopoDeclSpeed[this.planet] : SwephData.maxTopoDeclSpeed[this.planet] : z3 ? z ? SwephData.minTopoLatSpeed[this.planet] : SwephData.maxTopoLatSpeed[this.planet] : z4 ? z ? SwephData.minTopoDistSpeed[this.planet] : SwephData.maxTopoDistSpeed[this.planet] : z ? SwephData.minTopoLonSpeed[this.planet] : SwephData.maxTopoLonSpeed[this.planet];
        } else {
            throw new IllegalArgumentException("Topocentric transit calculations are restricted to a minimum altitude of -12000km so far.");
        }
    }

    public String toString() {
        return "[Planet:" + this.planet + "];Offset:" + getOffset();
    }
}
