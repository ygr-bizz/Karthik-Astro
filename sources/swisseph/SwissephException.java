package swisseph;

import java.io.Serializable;

public class SwissephException extends RuntimeException implements Serializable {
    public static final int BEYOND_USER_TIME_LIMIT = 786432;
    public static final int DAMAGED_FILE_ERROR = 65;
    public static final int FILE_ERROR = 1;
    public static final int FILE_NOT_FOUND = 9;
    public static final int FILE_OPEN_FAILED = 17;
    public static final int FILE_READ_ERROR = 33;
    public static final int INVALID_DATE = 17408;
    public static final int INVALID_FILE_ERROR = 129;
    public static final int INVALID_FILE_NAME = 5;
    public static final int INVALID_PARAMETER_COMBINATION = 9216;
    public static final int OUT_OF_TIME_RANGE = 3072;
    public static final int PARAM_ERROR = 1024;
    public static final int UNDEFINED_ERROR = 0;
    public static final int UNSPECIFIED_FILE_ERROR = 3;
    public static final int UNSUPPORTED_OBJECT = 5120;
    public static final int USER_ERROR = 262144;
    private double jdet;
    private int rc;
    private int type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwissephException(double d, int i, int i2, StringBuffer stringBuffer) {
        super(stringBuffer == null ? null : stringBuffer.toString());
        this.jdet = 0.0d;
        this.type = 0;
        this.rc = 0;
        this.jdet = d;
        this.type = i;
        this.rc = i2;
    }

    public SwissephException(double d, int i, int i2, String str) {
        super(str);
        this.jdet = 0.0d;
        this.type = 0;
        this.rc = 0;
        this.jdet = d;
        this.type = i;
        this.rc = i2;
    }

    public SwissephException(double d, int i, String str) {
        super(str);
        this.jdet = 0.0d;
        this.type = 0;
        this.rc = 0;
        this.jdet = d;
        this.type = i;
    }

    public SwissephException(double d, String str) {
        super(str);
        this.jdet = 0.0d;
        this.type = 0;
        this.rc = 0;
        this.jdet = d;
        this.type = 0;
    }

    public double getJD() {
        return this.jdet;
    }

    public int getType() {
        return this.type;
    }

    public int getRC() {
        return this.rc;
    }
}
