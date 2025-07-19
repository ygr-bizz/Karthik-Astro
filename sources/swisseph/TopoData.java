package swisseph;

import java.io.Serializable;

class TopoData implements Serializable {
    double geoalt;
    double geolat;
    double geolon;
    double teval;
    double tjd_ut;
    double[] xobs = new double[6];

    TopoData() {
    }
}
