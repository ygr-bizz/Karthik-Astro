package swisseph;

import java.io.Serializable;

public class DblObj implements Serializable {
    public double val;

    public DblObj() {
        this.val = 0.0d;
    }

    public DblObj(double d) {
        this.val = d;
    }
}
