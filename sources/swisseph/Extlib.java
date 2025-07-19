package swisseph;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class Extlib implements Serializable {
    String decNumSeparator = ".";
    String decTimeSeparator = ".";
    SimpleDateFormat df = null;
    SweDate sde1 = new SweDate();
    SweDate sde2 = new SweDate();
    SweDate sdu1;
    SweDate sdu2;
    int secondsIdx = 0;
    SwissLib sl = new SwissLib();
    SwissEph sw = new SwissEph();
    SwissData swed = new SwissData();
    double transitVal = 0.0d;

    public static void main(String[] strArr) {
        new Extlib();
    }

    public String[] getLocales() {
        Locale[] availableLocales = DateFormat.getAvailableLocales();
        String[] strArr = new String[availableLocales.length];
        for (int i = 0; i < availableLocales.length; i++) {
            strArr[i] = availableLocales[i].getLanguage();
            if (availableLocales[i].getCountry().length() > 0) {
                strArr[i] = strArr[i] + "_" + availableLocales[i].getCountry();
                if (availableLocales[i].getVariant().length() > 0) {
                    strArr[i] = strArr[i] + "_" + availableLocales[i].getVariant();
                }
            }
        }
        return strArr;
    }

    public Locale getLocale(String str) {
        String str2;
        String str3;
        if (str == null || "".equals(str)) {
            return Locale.getDefault();
        }
        int indexOf = str.indexOf("_");
        if (indexOf >= 0) {
            str3 = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
        } else {
            str3 = str;
            str2 = "";
        }
        if (str2.equals("")) {
            return new Locale(str3);
        }
        return new Locale(str3, str2);
    }

    public SimpleDateFormat createLocDateTimeFormatter(String str, boolean z) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateTimeInstance(3, 2, getLocale(str));
        simpleDateFormat.getCalendar().setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat.applyPattern(getNormalizedDatePattern(simpleDateFormat.toPattern(), z));
        return simpleDateFormat;
    }

    public String getNormalizedDatePattern(String str, boolean z) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int indexOf4;
        for (int i = 0; i < "yMdHhms".length(); i++) {
            char charAt = "yMdHhms".charAt(i);
            if (str.indexOf(charAt + "" + charAt) < 0 && (indexOf4 = str.indexOf(charAt)) >= 0) {
                str = str.substring(0, indexOf4) + charAt + str.substring(indexOf4);
            }
        }
        if (str.indexOf("yyyy") < 0 && (indexOf3 = str.indexOf("yy")) >= 0) {
            str = str.substring(0, indexOf3) + "yy" + str.substring(indexOf3);
        }
        if (str.indexOf("s") < 0 && (indexOf2 = str.indexOf("mm")) >= 0) {
            try {
                StringBuilder sb = new StringBuilder();
                int i2 = indexOf2 + 3;
                sb.append(str.substring(0, i2));
                sb.append("ss");
                sb.append(str.substring(i2));
                str = sb.toString();
            } catch (StringIndexOutOfBoundsException e) {
                StringBuilder sb2 = new StringBuilder();
                int i3 = indexOf2 + 2;
                sb2.append(str.substring(0, i3));
                sb2.append(str.substring(indexOf2 - 1, indexOf2));
                sb2.append("ss");
                sb2.append(str.substring(i3));
                str = sb2.toString();
            }
        }
        if (!z || (indexOf = str.indexOf("a")) < 0) {
            return str;
        }
        String str2 = str.substring(0, indexOf) + str.substring(indexOf + 1);
        int indexOf5 = str2.indexOf("hh");
        return str2.substring(0, indexOf5) + "HH" + str2.substring(indexOf5 + 2);
    }

    public String getDecimalSeparator(NumberFormat numberFormat) {
        if (numberFormat instanceof DecimalFormat) {
            return String.valueOf(((DecimalFormat) numberFormat).getDecimalFormatSymbols().getDecimalSeparator());
        }
        return null;
    }

    public int getPatternLastIdx(String str, String str2, SimpleDateFormat simpleDateFormat) {
        int lastIndexOf = str.lastIndexOf(str2) + 1;
        int i = lastIndexOf;
        for (int i2 = 0; i2 < lastIndexOf; i2++) {
            if (str.charAt(i2) == '\'') {
                i--;
            }
        }
        if (str.indexOf("a") < 0 || str.indexOf("a") >= str.indexOf(str2)) {
            return i;
        }
        return i + (simpleDateFormat.getDateFormatSymbols().getAmPmStrings()[0].length() - 1);
    }
}
