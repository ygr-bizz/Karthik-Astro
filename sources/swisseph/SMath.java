package swisseph;

import java.io.Serializable;

public class SMath implements Serializable {
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;

    public static int abs(int i) {
        return Math.abs(i);
    }

    public static long abs(long j) {
        return Math.abs(j);
    }

    public static float abs(float f) {
        return Math.abs(f);
    }

    public static double abs(double d) {
        return Math.abs(d);
    }

    public static int min(int i, int i2) {
        return Math.min(i, i2);
    }

    public static long min(long j, long j2) {
        return Math.min(j, j2);
    }

    public static float min(float f, float f2) {
        return Math.min(f, f2);
    }

    public static double min(double d, double d2) {
        return Math.min(d, d2);
    }

    public static int max(int i, int i2) {
        return Math.max(i, i2);
    }

    public static long max(long j, long j2) {
        return Math.max(j, j2);
    }

    public static float max(float f, float f2) {
        return Math.max(f, f2);
    }

    public static double max(double d, double d2) {
        return Math.max(d, d2);
    }

    public static double sin(double d) {
        return Math.sin(d);
    }

    public static double cos(double d) {
        return Math.cos(d);
    }

    public static double tan(double d) {
        return Math.tan(d);
    }

    public static double asin(double d) {
        return Math.asin(d);
    }

    public static double acos(double d) {
        return Math.acos(d);
    }

    public static double atan(double d) {
        return Math.atan(d);
    }

    public static double atan2(double d, double d2) {
        return Math.atan2(d, d2);
    }

    public static double exp(double d) {
        return Math.exp(d);
    }

    public static double log(double d) {
        return Math.log(d);
    }

    public static double sqrt(double d) {
        return Math.sqrt(d);
    }

    public static double pow(double d, double d2) {
        return Math.pow(d, d2);
    }

    public static double IEEEremainder(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    public static double ceil(double d) {
        return Math.ceil(d);
    }

    public static double floor(double d) {
        return Math.floor(d);
    }

    public static double rint(double d) {
        return Math.rint(d);
    }

    public static int round(float f) {
        return Math.round(f);
    }

    public static long round(double d) {
        return Math.round(d);
    }

    public static synchronized double random() {
        double random;
        synchronized (SMath.class) {
            random = Math.random();
        }
        return random;
    }
}
