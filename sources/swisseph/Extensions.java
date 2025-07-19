package swisseph;

import java.io.Serializable;

class Extensions implements Serializable {
    protected double[] maxBaryDist = {0.009570999d, 1.028809521d, 0.466604085d, 0.728698831d, 0.728698831d, 4.955912195d, 8.968685733d, 19.893326756d, 30.326750627d, 41.499626899d, 0.002569555d, 0.002774851d, 1.0d, 0.002782378d, 0.0d, 0.05d, 31.901319663d, 3.012409508d, 3.721614106d, 3.326307148d, 2.570197288d};
    SwissEph sw;

    Extensions(SwissEph swissEph) {
        this.sw = swissEph;
    }

    /* access modifiers changed from: package-private */
    public double getTransit(TransitCalculator transitCalculator, double d, boolean z, double d2) throws IllegalArgumentException, SwissephException {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        boolean z2;
        double d10;
        double d11;
        double d12;
        TransitCalculator transitCalculator2 = transitCalculator;
        double d13 = d2;
        double preprocessDate = transitCalculator.preprocessDate(d, z);
        double maxSpeed = transitCalculator.getMaxSpeed();
        double minSpeed = transitCalculator.getMinSpeed();
        double offset = transitCalculator.getOffset();
        boolean z3 = maxSpeed < 0.0d;
        boolean z4 = minSpeed < 0.0d;
        if (z3 || z4) {
            d3 = minSpeed;
        } else {
            d3 = maxSpeed;
        }
        if (!z3 || !z4) {
            d4 = maxSpeed;
        } else {
            d4 = d3;
        }
        double timePrecision = transitCalculator2.getTimePrecision(transitCalculator2.getDegreePrecision(preprocessDate) / 2.0d);
        double calc = transitCalculator2.calc(preprocessDate);
        if (transitCalculator2.checkIdenticalResult(offset, calc)) {
            return calc;
        }
        if (d4 == 0.0d && d3 == 0.0d) {
            throw new SwissephException(preprocessDate, SwissephException.OUT_OF_TIME_RANGE, "No transit possible due to lack of variation of speed or position.");
        }
        double d14 = preprocessDate;
        while (true) {
            if (transitCalculator2.rollover) {
                while (calc >= transitCalculator2.rolloverVal) {
                    calc -= transitCalculator2.rolloverVal;
                }
                while (calc < 0.0d) {
                    calc += transitCalculator2.rolloverVal;
                }
                d5 = calc;
            } else {
                d5 = calc;
            }
            boolean z5 = d5 >= offset;
            if (!transitCalculator2.rollover || z5) {
                d6 = d5;
            } else {
                d6 = d5 + transitCalculator2.rolloverVal;
            }
            double d15 = timePrecision;
            double d16 = offset;
            double nextJD = transitCalculator.getNextJD(d14, d6, offset, d3, d4, z);
            if (SMath.abs(nextJD - d14) < d15) {
                d7 = d14 + (z ? -d15 : d15);
            } else {
                d7 = nextJD;
            }
            if (d7 != d14) {
                double calc2 = transitCalculator2.calc(d7);
                if (calc2 != Double.POSITIVE_INFINITY) {
                    if (!transitCalculator2.rollover || calc2 < transitCalculator2.rolloverVal) {
                        d8 = calc2;
                    } else {
                        d8 = calc2 % transitCalculator2.rolloverVal;
                    }
                    while (transitCalculator2.rollover && d8 < 0.0d) {
                        d8 += transitCalculator2.rolloverVal;
                    }
                    double d17 = d16;
                    if (!transitCalculator2.checkIdenticalResult(d17, d8)) {
                        if (transitCalculator2.rollover) {
                            double d18 = d8 - d5;
                            if (d18 < 0.0d) {
                                d18 += transitCalculator2.rolloverVal;
                            }
                            double d19 = d5 - d8;
                            if (d19 < 0.0d) {
                                d9 = d15;
                                d19 += transitCalculator2.rolloverVal;
                            } else {
                                d9 = d15;
                            }
                            z2 = SMath.abs(d18 / d4) < SMath.abs(d19 / d3);
                        } else {
                            d9 = d15;
                            z2 = d5 <= d8;
                        }
                        double d20 = d17;
                        double d21 = d8;
                        if (!transitCalculator.checkResult(d17, d5, d8, z5, z2)) {
                            if (z) {
                                d12 = d9;
                                d11 = d2;
                                if (d7 < d11) {
                                    break;
                                }
                            } else {
                                d12 = d9;
                                d11 = d2;
                            }
                            if (!z && d7 > d11) {
                                break;
                            }
                            timePrecision = d12;
                            d14 = d7;
                            offset = d20;
                            calc = d21;
                            double d22 = d11;
                        } else {
                            if (transitCalculator2.rollover) {
                                if (!transitCalculator2.rollover || SMath.abs(d21 - d5) <= 300.0d) {
                                    d10 = d21;
                                } else {
                                    if (d21 > d5) {
                                        d5 += transitCalculator2.rolloverVal;
                                        d10 = d21;
                                    } else {
                                        d10 = d21 + transitCalculator2.rolloverVal;
                                    }
                                    if (d20 < 10.0d) {
                                        d20 = transitCalculator2.rolloverVal + d20;
                                    }
                                }
                                double d23 = d10 - d5;
                                if (d23 < 0.0d && d20 - d5 > 0.0d) {
                                    d10 += transitCalculator2.rolloverVal;
                                } else if (d23 > 0.0d && d20 - d5 < 0.0d) {
                                    d20 = transitCalculator2.rolloverVal + d20;
                                }
                            } else {
                                d10 = d21;
                            }
                            double d24 = d14 + (((d7 - d14) * (d20 - d5)) / (d10 - d5));
                            if (z) {
                                return SMath.max(d24, d7);
                            }
                            return SMath.min(d24, d7);
                        }
                    } else {
                        return d8;
                    }
                } else {
                    return d7;
                }
            } else {
                return d7;
            }
        }
        throw new SwissephException(d7, (int) SwissephException.BEYOND_USER_TIME_LIMIT, -1, "User time limit of " + d11 + " has been reached.");
    }
}
