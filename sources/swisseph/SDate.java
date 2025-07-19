package swisseph;

public class SDate {
    public int day;
    public int hour;
    public int minute;
    public int month;
    public double second;
    public int year;

    public SDate(int i, int i2, int i3, double d) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        int i4 = (int) d;
        this.hour = i4;
        double d2 = (d - ((double) i4)) * 60.0d;
        int i5 = (int) d2;
        this.minute = i5;
        this.second = (d2 - ((double) i5)) * 60.0d;
    }

    public SDate(int i, int i2, int i3, int i4, int i5, double d) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = i4;
        this.minute = i5;
        this.second = d;
    }
}
