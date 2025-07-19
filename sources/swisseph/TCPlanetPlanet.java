package swisseph;

import java.io.PrintStream;
import java.io.Serializable;

public class TCPlanetPlanet extends TransitCalculator implements Serializable {
    private boolean calcNonPartile = false;
    private boolean calcPartile = false;
    private boolean calcPartileBoth = false;
    private boolean calcYoga = false;
    private int flags = 0;
    private int idx = 0;
    private boolean isPartile = false;
    private double lon1 = 0.0d;
    private double lon2 = -1000.0d;
    private double maxSpeed;
    private double maxSpeed1;
    private double maxSpeed2;
    double maxVal = 0.0d;
    private double minSpeed;
    private double minSpeed1;
    private double minSpeed2;
    double minVal = 0.0d;
    private double offset = 0.0d;
    private int pl1;
    private int pl2;
    private int tflags = 0;

    public TCPlanetPlanet(SwissEph swissEph, int i, int i2, int i3, double d) {
        boolean z;
        SwissEph swissEph2 = swissEph;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        double d2 = d;
        this.sw = swissEph2;
        if (this.sw == null) {
            this.sw = new SwissEph();
        }
        this.tflags = i6;
        int i7 = i6 & 8;
        if (i7 != 0) {
        }
        int i8 = -16748064 & i6;
        if (i8 == 0) {
            int i9 = 917504 & i6;
            if (i9 != 131072 && i9 != 262144 && i9 != 524288) {
                throw new IllegalArgumentException("Invalid flag combination '" + i6 + "': specify exactly one of SEFLG_TRANSIT_LONGITUDE (" + 131072 + "), SEFLG_TRANSIT_LATITUDE (" + 262144 + "), SEFLG_TRANSIT_DISTANCE (" + 524288 + ").");
            } else if (i4 < 0 || i4 > 22 || i4 == 14) {
                throw new IllegalArgumentException("Unsupported planet number " + i4 + " (" + swissEph.swe_get_planet_name(i) + ")");
            } else if (i5 < 0 || i5 > 22 || i5 == 14) {
                throw new IllegalArgumentException("Unsupported planet number " + i5 + " (" + swissEph2.swe_get_planet_name(i5) + ")");
            } else if (i7 != 0 && (i4 == 12 || i4 == 13 || i4 == 10 || i4 == 11)) {
                throw new IllegalArgumentException("Unsupported planet number " + i4 + " (" + swissEph.swe_get_planet_name(i) + ") for heliocentric " + "calculations");
            } else if (i7 != 0 && (i5 == 12 || i5 == 13 || i5 == 10 || i5 == 11)) {
                throw new IllegalArgumentException("Unsupported planet number " + i5 + " (" + swissEph2.swe_get_planet_name(i5) + ") for heliocentric " + "calculations");
            } else if (i4 != i5) {
                this.pl1 = i4;
                this.pl2 = i5;
                boolean z2 = (4194304 & i6) != 0;
                this.calcPartile = z2;
                boolean z3 = (8388608 & i6) != 0;
                this.calcNonPartile = z3;
                this.calcPartileBoth = z2 && z3;
                this.calcYoga = (2097152 & i6) != 0;
                if ((262144 & i6) != 0) {
                    this.idx = 1;
                } else if ((524288 & i6) != 0) {
                    this.idx = 2;
                }
                if ((1048576 & i6) != 0) {
                    this.idx += 3;
                    i6 |= 256;
                }
                int i10 = i6 & -16646145;
                this.flags = i10;
                this.rollover = this.idx == 0;
                if (!this.calcPartile && !this.calcNonPartile) {
                    z = false;
                } else if (d2 % 30.0d == 0.0d) {
                    z = false;
                    this.rollover = false;
                } else {
                    throw new IllegalArgumentException("Wrong offset (" + d2 + "). Calculation of partile aspect may have offsets of multiples of 30 degrees only.");
                }
                this.offset = checkOffset(d2);
                this.maxSpeed1 = getSpeed(z, i4);
                this.minSpeed1 = getSpeed(true, i4);
                this.maxSpeed2 = getSpeed(z, i5);
                this.minSpeed2 = getSpeed(true, i5);
                String str = "Geo";
                if (Double.isInfinite(this.maxSpeed1) || Double.isInfinite(this.minSpeed1)) {
                    StringBuilder sb = new StringBuilder();
                    if ((32768 & i10) != 0) {
                        str = "Topo";
                    } else if ((i10 & 8) != 0) {
                        str = "Helio";
                    }
                    sb.append(str);
                    sb.append("centric transit calculations with planet number ");
                    sb.append(i4);
                    sb.append(" (");
                    sb.append(swissEph.swe_get_planet_name(i));
                    sb.append(") not possible: extreme ");
                    sb.append((i10 & 256) != 0 ? "accelerations" : "speeds");
                    sb.append(" of the planet ");
                    sb.append((i10 & 2048) != 0 ? "in equatorial system " : "");
                    sb.append("not available.");
                    throw new IllegalArgumentException(sb.toString());
                } else if (Double.isInfinite(this.maxSpeed2) || Double.isInfinite(this.minSpeed2)) {
                    StringBuilder sb2 = new StringBuilder();
                    if ((32768 & i10) != 0) {
                        str = "Topo";
                    } else if ((i10 & 8) != 0) {
                        str = "Helio";
                    }
                    sb2.append(str);
                    sb2.append("centric transit calculations with planet number ");
                    sb2.append(i5);
                    sb2.append(" (");
                    sb2.append(swissEph2.swe_get_planet_name(i5));
                    sb2.append(") not possible: extreme ");
                    sb2.append((i10 & 256) != 0 ? "accelerations" : "speeds");
                    sb2.append(" of the planet ");
                    sb2.append((i10 & 2048) != 0 ? "in equatorial system " : "");
                    sb2.append("not available.");
                    throw new IllegalArgumentException(sb2.toString());
                } else if (this.calcYoga) {
                    this.minSpeed = this.minSpeed1 + this.minSpeed2;
                    this.maxSpeed = this.maxSpeed1 + this.maxSpeed2;
                } else if (this.rollover) {
                    double d3 = this.maxSpeed1;
                    double d4 = this.maxSpeed2;
                    this.minSpeed = d3 > d4 ? this.minSpeed1 - d4 : this.minSpeed2 - d3;
                    this.maxSpeed = d3 > d4 ? d3 - this.minSpeed2 : d4 - this.minSpeed1;
                } else {
                    this.minSpeed = SMath.min(this.minSpeed1 - this.maxSpeed2, this.minSpeed2 - this.maxSpeed1);
                    this.maxSpeed = SMath.max(this.maxSpeed1 - this.minSpeed2, this.maxSpeed2 - this.minSpeed1);
                }
            } else {
                throw new IllegalArgumentException("Transiting and referred planet have to be different!");
            }
        } else {
            throw new IllegalArgumentException("Invalid flag(s): " + i8);
        }
    }

    /* access modifiers changed from: package-private */
    public double preprocessDate(double d, boolean z) {
        if (!this.calcPartile && !this.calcNonPartile) {
            return d;
        }
        boolean hasPartileAspect = hasPartileAspect(d, this.pl1, this.pl2, this.flags, this.offset);
        this.isPartile = hasPartileAspect;
        if (this.calcPartileBoth) {
            return d;
        }
        if (hasPartileAspect && this.calcPartile) {
            double transitET = this.sw.getTransitET(new TCPlanetPlanet(this.sw, this.pl1, this.pl2, (this.flags & -4194305) | 8519680, this.offset), d, z);
            this.isPartile = !this.isPartile;
            return transitET;
        } else if (hasPartileAspect || !this.calcNonPartile) {
            return d;
        } else {
            double transitET2 = this.sw.getTransitET(new TCPlanetPlanet(this.sw, this.pl1, this.pl2, (this.flags & -8388609) | 4325376, this.offset), d, z);
            this.isPartile = !this.isPartile;
            return transitET2;
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
        return new Object[]{"" + this.pl1, "" + this.pl2};
    }

    public boolean hasPartileAspect(double d, int i, int i2, int i3, double d2) {
        double d3 = d;
        StringBuffer stringBuffer = new StringBuffer();
        double[] dArr = new double[6];
        double[] dArr2 = new double[6];
        double d4 = (double) ((int) d2);
        int i4 = i3 & -16646145;
        int swe_calc = this.sw.swe_calc(d, i, i4, dArr, stringBuffer);
        if (swe_calc >= 0) {
            String str = "Calculation failed with return code ";
            String str2 = ":\n";
            int swe_calc2 = this.sw.swe_calc(d, i2, i4, dArr2, stringBuffer);
            if (swe_calc2 >= 0) {
                return ((int) (dArr[0] % 30.0d)) == ((int) (dArr2[0] % 30.0d)) && (((((double) ((int) dArr[0])) + d4) + this.rolloverVal) % this.rolloverVal == ((double) ((int) dArr2[0])) || ((((double) ((int) dArr[0])) - d4) + this.rolloverVal) % this.rolloverVal == ((double) ((int) dArr2[0])));
            }
            throw new SwissephException(d, 0, str + swe_calc2 + str2 + stringBuffer.toString());
        }
        throw new SwissephException(d3, 0, "Calculation failed with return code " + swe_calc + ":\n" + stringBuffer.toString());
    }

    /* access modifiers changed from: protected */
    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    /* access modifiers changed from: protected */
    public double getMinSpeed() {
        return this.minSpeed;
    }

    /* access modifiers changed from: protected */
    public double calc(double d) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = d;
        StringBuffer stringBuffer = new StringBuffer();
        double[] dArr = new double[6];
        double[] dArr2 = new double[6];
        int swe_calc = this.sw.swe_calc(d, this.pl1, this.flags, dArr, stringBuffer);
        if (swe_calc >= 0) {
            int swe_calc2 = this.sw.swe_calc(d, this.pl2, this.flags, dArr2, stringBuffer);
            if (swe_calc2 < 0) {
                throw new SwissephException(d6, 0, "Calculation failed with return code " + swe_calc2 + ":\n" + stringBuffer.toString());
            } else if (this.calcPartile || this.calcNonPartile) {
                double d7 = dArr[0];
                this.lon1 = d7;
                this.lon2 = dArr2[0];
                double d8 = ((((double) ((int) d7)) + this.offset) + this.rolloverVal) % this.rolloverVal;
                double d9 = ((((double) ((int) this.lon1)) - this.offset) + this.rolloverVal) % this.rolloverVal;
                double d10 = ((((double) ((int) this.lon2)) + this.offset) + this.rolloverVal) % this.rolloverVal;
                double d11 = ((((double) ((int) this.lon2)) - this.offset) + this.rolloverVal) % this.rolloverVal;
                double d12 = this.lon2;
                if (d12 > d8) {
                    d2 = SMath.abs(((d12 - d8) - 1.0d) + 1.0E-9d);
                } else {
                    d2 = d8 - d12;
                }
                double d13 = this.lon2;
                if (d13 > d9) {
                    d3 = SMath.abs(((d13 - d9) - 1.0d) + 1.0E-9d);
                } else {
                    d3 = d9 - d13;
                }
                double d14 = this.lon1;
                if (d14 > d10) {
                    d4 = SMath.abs(((d14 - d10) - 1.0d) + 1.0E-9d);
                } else {
                    d4 = d10 - d14;
                }
                double d15 = this.lon1;
                if (d15 > d11) {
                    d5 = SMath.abs(((d15 - d11) - 1.0d) + 1.0E-9d);
                } else {
                    d5 = d11 - d15;
                }
                double min = SMath.min(SMath.min(SMath.min(d2, d3), d4), d5) % 1.0d;
                boolean z = this.isPartile;
                if ((!z && this.calcPartile && min == 0.0d) || (z && this.calcNonPartile && min != 0.0d)) {
                    return this.offset;
                }
                int i = this.idx;
                if (((((double) (((int) dArr[i]) - ((int) dArr2[i]))) + this.rolloverVal) % this.rolloverVal) - this.offset == 0.0d) {
                    return Double.POSITIVE_INFINITY;
                }
                int i2 = this.idx;
                if (((((double) (((int) dArr2[i2]) - ((int) dArr[i2]))) + this.rolloverVal) % this.rolloverVal) - this.offset == 0.0d) {
                    return Double.POSITIVE_INFINITY;
                }
                return (((dArr[this.idx] % this.rolloverVal) - (dArr2[this.idx] % this.rolloverVal)) + this.rolloverVal) % this.rolloverVal;
            } else if (this.calcYoga) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append(dArr[this.idx]);
                sb.append(" + ");
                sb.append(dArr2[this.idx]);
                sb.append(" = ");
                int i3 = this.idx;
                sb.append(dArr[i3] + dArr2[i3]);
                printStream.println(sb.toString());
                int i4 = this.idx;
                return dArr[i4] + dArr2[i4];
            } else {
                int i5 = this.idx;
                return dArr[i5] - dArr2[i5];
            }
        } else {
            throw new SwissephException(d6, 0, "Calculation failed with return code " + swe_calc + ":\n" + stringBuffer.toString());
        }
    }

    /* access modifiers changed from: protected */
    public double getTimePrecision(double d) {
        double max = SMath.max(SMath.abs(SMath.min(SMath.abs(this.minSpeed1), SMath.abs(this.minSpeed2))), SMath.abs(SMath.min(SMath.abs(this.maxSpeed1), SMath.abs(this.maxSpeed2))));
        if (max != 0.0d) {
            return d / max;
        }
        return 1.0E-9d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getDegreePrecision(double r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r0.idx
            r2 = 2
            r3 = 5
            if (r1 <= r2) goto L_0x000f
            r4 = 4566758108544739836(0x3f60624dd2f1a9fc, double:0.002)
            goto L_0x007e
        L_0x000f:
            int r1 = r0.pl1
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6 = 4590429028186199163(0x3fb47ae147ae147b, double:0.08)
            r8 = 4656834164887126016(0x40a0660000000000, double:2099.0)
            r10 = 4656422947538337792(0x409ef00000000000, double:1980.0)
            r12 = 4656071103817449472(0x409db00000000000, double:1900.0)
            if (r1 < 0) goto L_0x0035
            if (r1 > r3) goto L_0x0035
            int r1 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x0033
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0048
        L_0x0033:
            r14 = r6
            goto L_0x004f
        L_0x0035:
            int r1 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x003f
            int r1 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x003f
            r14 = r6
            goto L_0x004f
        L_0x003f:
            int r1 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x004e
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0048
            goto L_0x004e
        L_0x0048:
            r14 = 4572414629676717179(0x3f747ae147ae147b, double:0.005)
            goto L_0x004f
        L_0x004e:
            r14 = r4
        L_0x004f:
            int r1 = r0.pl2
            if (r1 < 0) goto L_0x0062
            if (r1 > r3) goto L_0x0062
            int r1 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x005d
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0078
        L_0x005d:
            double r4 = swisseph.SMath.max((double) r6, (double) r14)
            goto L_0x007e
        L_0x0062:
            int r1 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x006f
            int r1 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x006f
            double r4 = swisseph.SMath.max((double) r6, (double) r14)
            goto L_0x007e
        L_0x006f:
            int r1 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x007a
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r4 = r14
            goto L_0x007e
        L_0x007a:
            double r4 = swisseph.SMath.max((double) r4, (double) r14)
        L_0x007e:
            r6 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r4 = r4 / r6
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r4 = r4 * r6
            int r1 = r0.idx
            if (r1 == r2) goto L_0x008f
            if (r1 == r3) goto L_0x008f
            goto L_0x00a9
        L_0x008f:
            swisseph.SwissEph r1 = r0.sw
            swisseph.Extensions r1 = r1.ext
            double[] r1 = r1.maxBaryDist
            int r2 = r0.pl1
            r2 = r1[r2]
            swisseph.SwissEph r1 = r0.sw
            swisseph.Extensions r1 = r1.ext
            double[] r1 = r1.maxBaryDist
            int r6 = r0.pl2
            r6 = r1[r6]
            double r1 = swisseph.SMath.max((double) r2, (double) r6)
            double r4 = r4 * r1
        L_0x00a9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.TCPlanetPlanet.getDegreePrecision(double):double");
    }

    private double checkOffset(double d) {
        if (this.rollover) {
            while (d < 0.0d) {
                d += this.rolloverVal;
            }
            double d2 = d % this.rolloverVal;
            this.minVal = 0.0d;
            this.maxVal = this.rolloverVal;
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

    private double getSpeed(boolean z, int i) {
        int i2 = this.tflags;
        boolean z2 = true;
        boolean z3 = (262144 & i2) != 0;
        boolean z4 = (524288 & i2) != 0;
        boolean z5 = (1048576 & i2) != 0;
        boolean z6 = (32768 & i2) != 0;
        boolean z7 = (i2 & 8) != 0;
        boolean z8 = (i2 & 2048) != 0 && !z3 && !z4;
        if ((i2 & 2048) == 0 || !z3) {
            z2 = false;
        }
        if (!z6) {
            return z7 ? z5 ? z8 ? z ? SwephData.minHelioRectAccel[i] : SwephData.maxHelioRectAccel[i] : z2 ? z ? SwephData.minHelioDeclAccel[i] : SwephData.maxHelioDeclAccel[i] : z3 ? z ? SwephData.minHelioLatAccel[i] : SwephData.maxHelioLatAccel[i] : z4 ? z ? SwephData.minHelioDistAccel[i] : SwephData.maxHelioDistAccel[i] : z ? SwephData.minHelioLonAccel[i] : SwephData.maxHelioLonAccel[i] : z8 ? z ? SwephData.minHelioRectSpeed[i] : SwephData.maxHelioRectSpeed[i] : z2 ? z ? SwephData.minHelioDeclSpeed[i] : SwephData.maxHelioDeclSpeed[i] : z3 ? z ? SwephData.minHelioLatSpeed[i] : SwephData.maxHelioLatSpeed[i] : z4 ? z ? SwephData.minHelioDistSpeed[i] : SwephData.maxHelioDistSpeed[i] : z ? SwephData.minHelioLonSpeed[i] : SwephData.maxHelioLonSpeed[i] : z5 ? z8 ? z ? SwephData.minRectAccel[i] : SwephData.maxRectAccel[i] : z2 ? z ? SwephData.minDeclAccel[i] : SwephData.maxDeclAccel[i] : z3 ? z ? SwephData.minLatAccel[i] : SwephData.maxLatAccel[i] : z4 ? z ? SwephData.minDistAccel[i] : SwephData.maxDistAccel[i] : z ? SwephData.minLonAccel[i] : SwephData.maxLonAccel[i] : z8 ? z ? SwephData.minRectSpeed[i] : SwephData.maxRectSpeed[i] : z2 ? z ? SwephData.minDeclSpeed[i] : SwephData.maxDeclSpeed[i] : z3 ? z ? SwephData.minLatSpeed[i] : SwephData.maxLatSpeed[i] : z4 ? z ? SwephData.minDistSpeed[i] : SwephData.maxDistSpeed[i] : z ? SwephData.minLonSpeed[i] : SwephData.maxLonSpeed[i];
        }
        if (!this.sw.swed.geopos_is_set) {
            throw new IllegalArgumentException("Geographic position is not set for requested topocentric calculations.");
        } else if (this.sw.swed.topd.geoalt > 50000.0d) {
            throw new IllegalArgumentException("Topocentric transit calculations are restricted to a maximum altitude of 50km so far.");
        } else if (this.sw.swed.topd.geoalt >= -1.2E7d) {
            return z5 ? z8 ? z ? SwephData.minTopoRectAccel[i] : SwephData.maxTopoRectAccel[i] : z2 ? z ? SwephData.minTopoDeclAccel[i] : SwephData.maxTopoDeclAccel[i] : z3 ? z ? SwephData.minTopoLatAccel[i] : SwephData.maxTopoLatAccel[i] : z4 ? z ? SwephData.minTopoDistAccel[i] : SwephData.maxTopoDistAccel[i] : z ? SwephData.minTopoLonAccel[i] : SwephData.maxTopoLonAccel[i] : z8 ? z ? SwephData.minTopoRectSpeed[i] : SwephData.maxTopoRectSpeed[i] : z2 ? z ? SwephData.minTopoDeclSpeed[i] : SwephData.maxTopoDeclSpeed[i] : z3 ? z ? SwephData.minTopoLatSpeed[i] : SwephData.maxTopoLatSpeed[i] : z4 ? z ? SwephData.minTopoDistSpeed[i] : SwephData.maxTopoDistSpeed[i] : z ? SwephData.minTopoLonSpeed[i] : SwephData.maxTopoLonSpeed[i];
        } else {
            throw new IllegalArgumentException("Topocentric transit calculations are restricted to a minimum altitude of -12000km so far.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkIdenticalResult(double d, double d2) {
        if (this.calcPartile) {
            double d3 = this.lon1;
            if ((d3 % 1.0d < 1.0E-9d || this.lon2 % 1.0d < 1.0E-9d) && ((int) (d3 % 30.0d)) == ((int) (this.lon2 % 30.0d)) && (((((double) ((int) d3)) + d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)) || ((((double) ((int) this.lon1)) - d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)))) {
                return true;
            }
            return false;
        } else if (this.calcNonPartile) {
            double d4 = this.lon1;
            if ((d4 % 1.0d < 1.0E-9d && this.lon2 % 1.0d < 1.0E-9d) || ((int) (d4 % 30.0d)) != ((int) (this.lon2 % 30.0d))) {
                return true;
            }
            if (((((double) ((int) d4)) + d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)) || ((((double) ((int) this.lon1)) - d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2))) {
                return false;
            }
            return true;
        } else if (d2 == d) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkResult(double d, double d2, double d3, boolean z, boolean z2) {
        if (this.calcPartile) {
            double d4 = this.lon1;
            if (((int) (d4 % 30.0d)) == ((int) (this.lon2 % 30.0d)) && (((((double) ((int) d4)) + d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)) || ((((double) ((int) this.lon1)) - d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)))) {
                return true;
            }
            return false;
        } else if (!this.calcNonPartile) {
            return super.checkResult(d, d2, d3, z, z2);
        } else {
            double d5 = this.lon1;
            if (((int) (d5 % 30.0d)) != ((int) (this.lon2 % 30.0d))) {
                return true;
            }
            if (((((double) ((int) d5)) + d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2)) || ((((double) ((int) this.lon1)) - d) + this.rolloverVal) % this.rolloverVal == ((double) ((int) this.lon2))) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public double getNextJD(double d, double d2, double d3, double d4, double d5, boolean z) {
        double d6;
        double d7;
        double d8;
        double d9;
        boolean z2 = this.calcPartile;
        if (!z2 && !this.calcNonPartile) {
            return super.getNextJD(d, d2, d3, d4, d5, z);
        }
        if (z2) {
            double d10 = ((((double) ((int) this.lon1)) + d3) + this.rolloverVal) % this.rolloverVal;
            double d11 = ((((double) ((int) this.lon1)) - d3) + this.rolloverVal) % this.rolloverVal;
            double d12 = ((((double) ((int) this.lon2)) + d3) + this.rolloverVal) % this.rolloverVal;
            double d13 = ((((double) ((int) this.lon2)) - d3) + this.rolloverVal) % this.rolloverVal;
            double d14 = this.lon2;
            if (d14 > d10) {
                d8 = SMath.abs(((d14 - d10) - 1.0d) + 1.0E-9d);
            } else {
                d8 = d10 - d14;
            }
            double d15 = this.lon2;
            if (d15 > d11) {
                d7 = SMath.abs(((d15 - d11) - 1.0d) + 1.0E-9d);
            } else {
                d7 = d11 - d15;
            }
            double d16 = this.lon1;
            if (d16 > d12) {
                d6 = SMath.abs(((d16 - d12) - 1.0d) + 1.0E-9d);
            } else {
                d6 = d12 - d16;
            }
            double d17 = this.lon1;
            if (d17 > d13) {
                d9 = SMath.abs(((d17 - d13) - 1.0d) + 1.0E-9d);
            } else {
                d9 = d13 - d17;
            }
        } else {
            double d18 = this.lon1;
            double d19 = d18 - ((double) ((int) d18));
            double d20 = 1.0d - d19;
            double d21 = this.lon2;
            double d22 = d21 - ((double) ((int) d21));
            double d23 = 1.0d - d22;
            d8 = d19 + 1.0E-9d;
            d7 = d20 + 1.0E-9d;
            d6 = d22 + 1.0E-9d;
            d9 = 1.0E-9d + d23;
        }
        double abs = SMath.abs((SMath.min(SMath.min(SMath.min(d8, d7), d6), d9) % 1.0d) / SMath.max(SMath.abs(this.maxSpeed2 - this.minSpeed1), SMath.abs(this.maxSpeed1 - this.minSpeed2)));
        if (z) {
            abs = -abs;
        }
        return d + abs;
    }

    public String toString() {
        return "[Planets:" + this.pl1 + "/" + this.pl2 + "];Offset:" + getOffset();
    }
}
