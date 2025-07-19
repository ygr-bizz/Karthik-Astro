package swisseph;

import java.io.Serializable;

public class TCHouses extends TransitCalculator implements Serializable {
    static final double B0_ARMC_MAX = 360.985931d;
    static final double B0_ARMC_MIN = 360.985828d;
    static final double B0_ASC_MAX = 393.49442d;
    static final double B0_ASC_MIN = 331.162937d;
    static final double B0_COASC1_MAX = 393.49442d;
    static final double B0_COASC1_MIN = 331.162937d;
    static final double B0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double B0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double B0_EQUASC_MAX = 393.49442d;
    static final double B0_EQUASC_MIN = 331.162937d;
    static final double B0_HOUSE10_MAX = 393.49442d;
    static final double B0_HOUSE10_MIN = 331.162936d;
    static final double B0_HOUSE11_MAX = 393.49442d;
    static final double B0_HOUSE11_MIN = 331.162936d;
    static final double B0_HOUSE12_MAX = 393.49442d;
    static final double B0_HOUSE12_MIN = 331.162937d;
    static final double B0_HOUSE1_MAX = 393.49442d;
    static final double B0_HOUSE1_MIN = 331.162937d;
    static final double B0_HOUSE2_MAX = 393.49442d;
    static final double B0_HOUSE2_MIN = 331.162937d;
    static final double B0_HOUSE3_MAX = 393.494421d;
    static final double B0_HOUSE3_MIN = 331.162936d;
    static final double B0_HOUSE4_MAX = 393.49442d;
    static final double B0_HOUSE4_MIN = 331.162936d;
    static final double B0_HOUSE5_MAX = 393.49442d;
    static final double B0_HOUSE5_MIN = 331.162936d;
    static final double B0_HOUSE6_MAX = 393.49442d;
    static final double B0_HOUSE6_MIN = 331.162937d;
    static final double B0_HOUSE7_MAX = 393.49442d;
    static final double B0_HOUSE7_MIN = 331.162937d;
    static final double B0_HOUSE8_MAX = 393.49442d;
    static final double B0_HOUSE8_MIN = 331.162937d;
    static final double B0_HOUSE9_MAX = 393.494421d;
    static final double B0_HOUSE9_MIN = 331.162936d;
    static final double B0_MC_MAX = 393.49442d;
    static final double B0_MC_MIN = 331.162936d;
    static final double B0_POLASC_MAX = 393.49442d;
    static final double B0_POLASC_MIN = 331.162937d;
    static final double B0_VERTEX_MAX = 777600.0d;
    static final double B0_VERTEX_MIN = -777600.0d;
    static final double B10_ARMC_MAX = 360.985931d;
    static final double B10_ARMC_MIN = 360.985828d;
    static final double B10_ASC_MAX = 426.089536d;
    static final double B10_ASC_MIN = 328.169552d;
    static final double B10_COASC1_MAX = 426.089531d;
    static final double B10_COASC1_MIN = 328.16955d;
    static final double B10_COASC2_MAX = 113.797795d;
    static final double B10_COASC2_MIN = -269.99607d;
    static final double B10_EQUASC_MAX = 393.49442d;
    static final double B10_EQUASC_MIN = 331.162937d;
    static final double B10_HOUSE10_MAX = 393.49442d;
    static final double B10_HOUSE10_MIN = 331.162936d;
    static final double B10_HOUSE11_MAX = 398.606213d;
    static final double B10_HOUSE11_MIN = 324.158599d;
    static final double B10_HOUSE12_MAX = 412.380154d;
    static final double B10_HOUSE12_MIN = 321.940442d;
    static final double B10_HOUSE1_MAX = 426.089536d;
    static final double B10_HOUSE1_MIN = 328.169552d;
    static final double B10_HOUSE2_MAX = 412.380174d;
    static final double B10_HOUSE2_MIN = 321.940442d;
    static final double B10_HOUSE3_MAX = 398.606221d;
    static final double B10_HOUSE3_MIN = 324.158589d;
    static final double B10_HOUSE4_MAX = 393.49442d;
    static final double B10_HOUSE4_MIN = 331.162936d;
    static final double B10_HOUSE5_MAX = 398.606213d;
    static final double B10_HOUSE5_MIN = 324.158599d;
    static final double B10_HOUSE6_MAX = 412.380154d;
    static final double B10_HOUSE6_MIN = 321.940442d;
    static final double B10_HOUSE7_MAX = 426.089536d;
    static final double B10_HOUSE7_MIN = 328.169552d;
    static final double B10_HOUSE8_MAX = 412.380174d;
    static final double B10_HOUSE8_MIN = 321.940442d;
    static final double B10_HOUSE9_MAX = 398.606221d;
    static final double B10_HOUSE9_MIN = 324.158589d;
    static final double B10_MC_MAX = 393.49442d;
    static final double B10_MC_MIN = 331.162936d;
    static final double B10_POLASC_MAX = 426.089531d;
    static final double B10_POLASC_MIN = 328.16955d;
    static final double B10_VERTEX_MAX = 1554930.566243d;
    static final double B10_VERTEX_MIN = -777600.124028d;
    static final double B20_ARMC_MAX = 360.985931d;
    static final double B20_ARMC_MIN = 360.985828d;
    static final double B20_ASC_MAX = 467.280896d;
    static final double B20_ASC_MIN = 319.225068d;
    static final double B20_COASC1_MAX = 467.280888d;
    static final double B20_COASC1_MIN = 319.22507d;
    static final double B20_COASC2_MAX = 179.610407d;
    static final double B20_COASC2_MIN = -2066.7575d;
    static final double B20_EQUASC_MAX = 393.49442d;
    static final double B20_EQUASC_MIN = 331.162937d;
    static final double B20_HOUSE10_MAX = 393.49442d;
    static final double B20_HOUSE10_MIN = 331.162936d;
    static final double B20_HOUSE11_MAX = 404.457857d;
    static final double B20_HOUSE11_MIN = 317.40522d;
    static final double B20_HOUSE12_MAX = 436.546696d;
    static final double B20_HOUSE12_MIN = 311.28233d;
    static final double B20_HOUSE1_MAX = 467.280896d;
    static final double B20_HOUSE1_MIN = 319.225068d;
    static final double B20_HOUSE2_MAX = 436.546667d;
    static final double B20_HOUSE2_MIN = 311.282344d;
    static final double B20_HOUSE3_MAX = 404.457847d;
    static final double B20_HOUSE3_MIN = 317.405224d;
    static final double B20_HOUSE4_MAX = 393.49442d;
    static final double B20_HOUSE4_MIN = 331.162936d;
    static final double B20_HOUSE5_MAX = 404.457857d;
    static final double B20_HOUSE5_MIN = 317.40522d;
    static final double B20_HOUSE6_MAX = 436.546696d;
    static final double B20_HOUSE6_MIN = 311.28233d;
    static final double B20_HOUSE7_MAX = 467.280896d;
    static final double B20_HOUSE7_MIN = 319.225068d;
    static final double B20_HOUSE8_MAX = 436.546667d;
    static final double B20_HOUSE8_MIN = 311.282344d;
    static final double B20_HOUSE9_MAX = 404.457847d;
    static final double B20_HOUSE9_MIN = 317.405224d;
    static final double B20_MC_MAX = 393.49442d;
    static final double B20_MC_MIN = 331.162936d;
    static final double B20_POLASC_MAX = 467.280888d;
    static final double B20_POLASC_MIN = 319.22507d;
    static final double B20_VERTEX_MAX = 1553150.33462d;
    static final double B20_VERTEX_MIN = -777600.393091d;
    static final double B30_ARMC_MAX = 360.985931d;
    static final double B30_ARMC_MIN = 360.985828d;
    static final double B30_ASC_MAX = 524.994891d;
    static final double B30_ASC_MIN = 304.407972d;
    static final double B30_COASC1_MAX = 524.994878d;
    static final double B30_COASC1_MIN = 304.407972d;
    static final double B30_COASC2_MAX = 1583.084164d;
    static final double B30_COASC2_MIN = 220.207028d;
    static final double B30_EQUASC_MAX = 393.49442d;
    static final double B30_EQUASC_MIN = 331.162937d;
    static final double B30_HOUSE10_MAX = 393.49442d;
    static final double B30_HOUSE10_MIN = 331.162936d;
    static final double B30_HOUSE11_MAX = 412.373726d;
    static final double B30_HOUSE11_MIN = 310.557237d;
    static final double B30_HOUSE12_MAX = 471.067526d;
    static final double B30_HOUSE12_MIN = 299.181964d;
    static final double B30_HOUSE1_MAX = 524.994891d;
    static final double B30_HOUSE1_MIN = 304.407972d;
    static final double B30_HOUSE2_MAX = 471.067521d;
    static final double B30_HOUSE2_MIN = 299.181971d;
    static final double B30_HOUSE3_MAX = 412.373722d;
    static final double B30_HOUSE3_MIN = 310.557231d;
    static final double B30_HOUSE4_MAX = 393.49442d;
    static final double B30_HOUSE4_MIN = 331.162936d;
    static final double B30_HOUSE5_MAX = 412.373726d;
    static final double B30_HOUSE5_MIN = 310.557237d;
    static final double B30_HOUSE6_MAX = 471.067526d;
    static final double B30_HOUSE6_MIN = 299.181964d;
    static final double B30_HOUSE7_MAX = 524.994891d;
    static final double B30_HOUSE7_MIN = 304.407972d;
    static final double B30_HOUSE8_MAX = 471.067521d;
    static final double B30_HOUSE8_MIN = 299.181971d;
    static final double B30_HOUSE9_MAX = 412.373722d;
    static final double B30_HOUSE9_MIN = 310.557231d;
    static final double B30_MC_MAX = 393.49442d;
    static final double B30_MC_MIN = 331.162936d;
    static final double B30_POLASC_MAX = 524.994878d;
    static final double B30_POLASC_MIN = 304.407972d;
    static final double B30_VERTEX_MAX = 1583.084212d;
    static final double B30_VERTEX_MIN = 220.207025d;
    static final double B40_ARMC_MAX = 360.985931d;
    static final double B40_ARMC_MIN = 360.985828d;
    static final double B40_ASC_MAX = 618.738596d;
    static final double B40_ASC_MIN = 283.720808d;
    static final double B40_COASC1_MAX = 618.738574d;
    static final double B40_COASC1_MIN = 283.720804d;
    static final double B40_COASC2_MAX = 814.745889d;
    static final double B40_COASC2_MIN = 256.684961d;
    static final double B40_EQUASC_MAX = 393.49442d;
    static final double B40_EQUASC_MIN = 331.162937d;
    static final double B40_HOUSE10_MAX = 393.49442d;
    static final double B40_HOUSE10_MIN = 331.162936d;
    static final double B40_HOUSE11_MAX = 427.334772d;
    static final double B40_HOUSE11_MIN = 303.213369d;
    static final double B40_HOUSE12_MAX = 528.455277d;
    static final double B40_HOUSE12_MIN = 285.118858d;
    static final double B40_HOUSE1_MAX = 618.738596d;
    static final double B40_HOUSE1_MIN = 283.720808d;
    static final double B40_HOUSE2_MAX = 528.455287d;
    static final double B40_HOUSE2_MIN = 285.118865d;
    static final double B40_HOUSE3_MAX = 427.334781d;
    static final double B40_HOUSE3_MIN = 303.213378d;
    static final double B40_HOUSE4_MAX = 393.49442d;
    static final double B40_HOUSE4_MIN = 331.162936d;
    static final double B40_HOUSE5_MAX = 427.334772d;
    static final double B40_HOUSE5_MIN = 303.213369d;
    static final double B40_HOUSE6_MAX = 528.455277d;
    static final double B40_HOUSE6_MIN = 285.118858d;
    static final double B40_HOUSE7_MAX = 618.738596d;
    static final double B40_HOUSE7_MIN = 283.720808d;
    static final double B40_HOUSE8_MAX = 528.455287d;
    static final double B40_HOUSE8_MIN = 285.118865d;
    static final double B40_HOUSE9_MAX = 427.334781d;
    static final double B40_HOUSE9_MIN = 303.213378d;
    static final double B40_MC_MAX = 393.49442d;
    static final double B40_MC_MIN = 331.162936d;
    static final double B40_POLASC_MAX = 618.738574d;
    static final double B40_POLASC_MIN = 283.720804d;
    static final double B40_VERTEX_MAX = 814.74585d;
    static final double B40_VERTEX_MIN = 256.68496d;
    static final double B50_ARMC_MAX = 360.985931d;
    static final double B50_ARMC_MIN = 360.985828d;
    static final double B50_ASC_MAX = 814.745889d;
    static final double B50_ASC_MIN = 256.684961d;
    static final double B50_COASC1_MAX = 814.74585d;
    static final double B50_COASC1_MIN = 256.68496d;
    static final double B50_COASC2_MAX = 618.738596d;
    static final double B50_COASC2_MIN = 283.720808d;
    static final double B50_EQUASC_MAX = 393.49442d;
    static final double B50_EQUASC_MIN = 331.162937d;
    static final double B50_HOUSE10_MAX = 393.49442d;
    static final double B50_HOUSE10_MIN = 331.162936d;
    static final double B50_HOUSE11_MAX = 474.236306d;
    static final double B50_HOUSE11_MIN = 294.827044d;
    static final double B50_HOUSE12_MAX = 651.12408d;
    static final double B50_HOUSE12_MIN = 267.896035d;
    static final double B50_HOUSE1_MAX = 814.745889d;
    static final double B50_HOUSE1_MIN = 256.684961d;
    static final double B50_HOUSE2_MAX = 651.124056d;
    static final double B50_HOUSE2_MIN = 267.896031d;
    static final double B50_HOUSE3_MAX = 474.236268d;
    static final double B50_HOUSE3_MIN = 294.82705d;
    static final double B50_HOUSE4_MAX = 393.49442d;
    static final double B50_HOUSE4_MIN = 331.162936d;
    static final double B50_HOUSE5_MAX = 474.236306d;
    static final double B50_HOUSE5_MIN = 294.827044d;
    static final double B50_HOUSE6_MAX = 651.12408d;
    static final double B50_HOUSE6_MIN = 267.896035d;
    static final double B50_HOUSE7_MAX = 814.745889d;
    static final double B50_HOUSE7_MIN = 256.684961d;
    static final double B50_HOUSE8_MAX = 651.124056d;
    static final double B50_HOUSE8_MIN = 267.896031d;
    static final double B50_HOUSE9_MAX = 474.236268d;
    static final double B50_HOUSE9_MIN = 294.82705d;
    static final double B50_MC_MAX = 393.49442d;
    static final double B50_MC_MIN = 331.162936d;
    static final double B50_POLASC_MAX = 814.74585d;
    static final double B50_POLASC_MIN = 256.68496d;
    static final double B50_VERTEX_MAX = 618.738574d;
    static final double B50_VERTEX_MIN = 283.720804d;
    static final double B60_ARMC_MAX = 360.985931d;
    static final double B60_ARMC_MIN = 360.985828d;
    static final double B60_ASC_MAX = 1583.084164d;
    static final double B60_ASC_MIN = 220.207028d;
    static final double B60_COASC1_MAX = 1583.084212d;
    static final double B60_COASC1_MIN = 220.207025d;
    static final double B60_COASC2_MAX = 524.994891d;
    static final double B60_COASC2_MIN = 304.407972d;
    static final double B60_EQUASC_MAX = 393.49442d;
    static final double B60_EQUASC_MIN = 331.162937d;
    static final double B60_HOUSE10_MAX = 393.49442d;
    static final double B60_HOUSE10_MIN = 331.162936d;
    static final double B60_HOUSE11_MAX = 694.410977d;
    static final double B60_HOUSE11_MIN = 284.51373d;
    static final double B60_HOUSE12_MAX = 1139.339601d;
    static final double B60_HOUSE12_MIN = 244.641873d;
    static final double B60_HOUSE1_MAX = 1583.084164d;
    static final double B60_HOUSE1_MIN = 220.207028d;
    static final double B60_HOUSE2_MAX = 1139.338559d;
    static final double B60_HOUSE2_MIN = 244.641869d;
    static final double B60_HOUSE3_MAX = 694.410604d;
    static final double B60_HOUSE3_MIN = 284.51374d;
    static final double B60_HOUSE4_MAX = 393.49442d;
    static final double B60_HOUSE4_MIN = 331.162936d;
    static final double B60_HOUSE5_MAX = 694.410977d;
    static final double B60_HOUSE5_MIN = 284.51373d;
    static final double B60_HOUSE6_MAX = 1139.339601d;
    static final double B60_HOUSE6_MIN = 244.641873d;
    static final double B60_HOUSE7_MAX = 1583.084164d;
    static final double B60_HOUSE7_MIN = 220.207028d;
    static final double B60_HOUSE8_MAX = 1139.338559d;
    static final double B60_HOUSE8_MIN = 244.641869d;
    static final double B60_HOUSE9_MAX = 694.410604d;
    static final double B60_HOUSE9_MIN = 284.51374d;
    static final double B60_MC_MAX = 393.49442d;
    static final double B60_MC_MIN = 331.162936d;
    static final double B60_POLASC_MAX = 1583.084212d;
    static final double B60_POLASC_MIN = 220.207025d;
    static final double B60_VERTEX_MAX = 524.994878d;
    static final double B60_VERTEX_MIN = 304.407972d;
    static final double B66_ARMC_MAX = 360.985931d;
    static final double B66_ARMC_MIN = 360.985828d;
    static final double B66_ASC_MAX = 15382.763492d;
    static final double B66_ASC_MIN = 180.714519d;
    static final double B66_COASC1_MAX = 15382.960178d;
    static final double B66_COASC1_MIN = 180.714532d;
    static final double B66_COASC2_MAX = 487.697885d;
    static final double B66_COASC2_MIN = 313.998924d;
    static final double B66_EQUASC_MAX = 393.49442d;
    static final double B66_EQUASC_MIN = 331.162937d;
    static final double B66_HOUSE10_MAX = 393.49442d;
    static final double B66_HOUSE10_MIN = 331.162936d;
    static final double B66_HOUSE11_MAX = 4726.655116d;
    static final double B66_HOUSE11_MIN = 276.758457d;
    static final double B66_HOUSE12_MAX = 9947.874571d;
    static final double B66_HOUSE12_MIN = 223.494433d;
    static final double B66_HOUSE1_MAX = 15382.763492d;
    static final double B66_HOUSE1_MIN = 180.714519d;
    static final double B66_HOUSE2_MAX = 9947.774284d;
    static final double B66_HOUSE2_MIN = 223.494434d;
    static final double B66_HOUSE3_MAX = 4726.637257d;
    static final double B66_HOUSE3_MIN = 276.758452d;
    static final double B66_HOUSE4_MAX = 393.49442d;
    static final double B66_HOUSE4_MIN = 331.162936d;
    static final double B66_HOUSE5_MAX = 4726.655116d;
    static final double B66_HOUSE5_MIN = 276.758457d;
    static final double B66_HOUSE6_MAX = 9947.874571d;
    static final double B66_HOUSE6_MIN = 223.494433d;
    static final double B66_HOUSE7_MAX = 15382.763492d;
    static final double B66_HOUSE7_MIN = 180.714519d;
    static final double B66_HOUSE8_MAX = 9947.774284d;
    static final double B66_HOUSE8_MIN = 223.494434d;
    static final double B66_HOUSE9_MAX = 4726.637257d;
    static final double B66_HOUSE9_MIN = 276.758452d;
    static final double B66_MC_MAX = 393.49442d;
    static final double B66_MC_MIN = 331.162936d;
    static final double B66_POLASC_MAX = 15382.960178d;
    static final double B66_POLASC_MIN = 180.714532d;
    static final double B66_VERTEX_MAX = 487.697876d;
    static final double B66_VERTEX_MIN = 313.998925d;
    static final double B70_ARMC_MAX = 360.985931d;
    static final double B70_ARMC_MIN = 360.985828d;
    static final double B70_ASC_MAX = 1553150.32968d;
    static final double B70_ASC_MIN = -777600.39302d;
    static final double B70_COASC1_MAX = 1553150.33462d;
    static final double B70_COASC1_MIN = -2066.704127d;
    static final double B70_COASC2_MAX = 467.280896d;
    static final double B70_COASC2_MIN = 319.225068d;
    static final double B70_EQUASC_MAX = 393.49442d;
    static final double B70_EQUASC_MIN = 331.162937d;
    static final double B70_HOUSE10_MAX = 393.49442d;
    static final double B70_HOUSE10_MIN = 331.162936d;
    static final double B70_HOUSE11_MAX = 1555199.999988d;
    static final double B70_HOUSE11_MIN = 9.0E-6d;
    static final double B70_HOUSE12_MAX = 1555199.999989d;
    static final double B70_HOUSE12_MIN = 9.0E-6d;
    static final double B70_HOUSE1_MAX = 1555199.608408d;
    static final double B70_HOUSE1_MIN = 0.389863d;
    static final double B70_HOUSE2_MAX = 1555199.999988d;
    static final double B70_HOUSE2_MIN = 5.0E-6d;
    static final double B70_HOUSE3_MAX = 1555199.999989d;
    static final double B70_HOUSE3_MIN = 1.3E-5d;
    static final double B70_HOUSE4_MAX = 393.49442d;
    static final double B70_HOUSE4_MIN = 331.162936d;
    static final double B70_HOUSE5_MAX = 1555199.999988d;
    static final double B70_HOUSE5_MIN = 9.0E-6d;
    static final double B70_HOUSE6_MAX = 1555199.999989d;
    static final double B70_HOUSE6_MIN = 9.0E-6d;
    static final double B70_HOUSE7_MAX = 1555199.608408d;
    static final double B70_HOUSE7_MIN = 0.389863d;
    static final double B70_HOUSE8_MAX = 1555199.999988d;
    static final double B70_HOUSE8_MIN = 5.0E-6d;
    static final double B70_HOUSE9_MAX = 1555199.999989d;
    static final double B70_HOUSE9_MIN = 1.3E-5d;
    static final double B70_MC_MAX = 393.49442d;
    static final double B70_MC_MIN = 331.162936d;
    static final double B70_POLASC_MAX = 179.610407d;
    static final double B70_POLASC_MIN = -2066.757416d;
    static final double B70_VERTEX_MAX = 467.280888d;
    static final double B70_VERTEX_MIN = 319.22507d;
    static final double B80_ARMC_MAX = 360.985931d;
    static final double B80_ARMC_MIN = 360.985828d;
    static final double B80_ASC_MAX = 1554930.566184d;
    static final double B80_ASC_MIN = -777600.124007d;
    static final double B80_COASC1_MAX = 1554930.566243d;
    static final double B80_COASC1_MIN = -269.995683d;
    static final double B80_COASC2_MAX = 426.089536d;
    static final double B80_COASC2_MIN = 328.169552d;
    static final double B80_EQUASC_MAX = 393.49442d;
    static final double B80_EQUASC_MIN = 331.162937d;
    static final double B80_HOUSE10_MAX = 393.49442d;
    static final double B80_HOUSE10_MIN = 331.162936d;
    static final double B80_HOUSE11_MAX = 277883.18118d;
    static final double B80_HOUSE11_MIN = 150.875989d;
    static final double B80_HOUSE12_MAX = 1555200.0d;
    static final double B80_HOUSE12_MIN = 3.0E-6d;
    static final double B80_HOUSE1_MAX = 1555199.876097d;
    static final double B80_HOUSE1_MIN = 0.12375d;
    static final double B80_HOUSE2_MAX = 1555199.999998d;
    static final double B80_HOUSE2_MIN = 2.0E-6d;
    static final double B80_HOUSE3_MAX = 277883.286595d;
    static final double B80_HOUSE3_MIN = 150.875954d;
    static final double B80_HOUSE4_MAX = 393.49442d;
    static final double B80_HOUSE4_MIN = 331.162936d;
    static final double B80_HOUSE5_MAX = 277883.18118d;
    static final double B80_HOUSE5_MIN = 150.875989d;
    static final double B80_HOUSE6_MAX = 1555200.0d;
    static final double B80_HOUSE6_MIN = 3.0E-6d;
    static final double B80_HOUSE7_MAX = 1555199.876097d;
    static final double B80_HOUSE7_MIN = 0.12375d;
    static final double B80_HOUSE8_MAX = 1555199.999998d;
    static final double B80_HOUSE8_MIN = 2.0E-6d;
    static final double B80_HOUSE9_MAX = 277883.286595d;
    static final double B80_HOUSE9_MIN = 150.875954d;
    static final double B80_MC_MAX = 393.49442d;
    static final double B80_MC_MIN = 331.162936d;
    static final double B80_POLASC_MAX = 113.797793d;
    static final double B80_POLASC_MIN = -269.996067d;
    static final double B80_VERTEX_MAX = 426.089531d;
    static final double B80_VERTEX_MIN = 328.16955d;
    static final double B85_ARMC_MAX = 360.985931d;
    static final double B85_ARMC_MIN = 360.985828d;
    static final double B85_ASC_MAX = 1555100.603952d;
    static final double B85_ASC_MIN = -777600.058703d;
    static final double B85_COASC1_MAX = 1555100.603957d;
    static final double B85_COASC1_MIN = -99.544583d;
    static final double B85_COASC2_MAX = 409.019308d;
    static final double B85_COASC2_MIN = 330.413985d;
    static final double B85_EQUASC_MAX = 393.49442d;
    static final double B85_EQUASC_MIN = 331.162937d;
    static final double B85_HOUSE10_MAX = 393.49442d;
    static final double B85_HOUSE10_MIN = 331.162936d;
    static final double B85_HOUSE11_MAX = 274378.070732d;
    static final double B85_HOUSE11_MIN = 198.762972d;
    static final double B85_HOUSE12_MAX = 516765.880903d;
    static final double B85_HOUSE12_MIN = 61.859581d;
    static final double B85_HOUSE1_MAX = 1555199.941344d;
    static final double B85_HOUSE1_MIN = 0.058615d;
    static final double B85_HOUSE2_MAX = 516765.810197d;
    static final double B85_HOUSE2_MIN = 61.859575d;
    static final double B85_HOUSE3_MAX = 274378.178787d;
    static final double B85_HOUSE3_MIN = 198.76297d;
    static final double B85_HOUSE4_MAX = 393.49442d;
    static final double B85_HOUSE4_MIN = 331.162936d;
    static final double B85_HOUSE5_MAX = 274378.070732d;
    static final double B85_HOUSE5_MIN = 198.762972d;
    static final double B85_HOUSE6_MAX = 516765.880903d;
    static final double B85_HOUSE6_MIN = 61.859581d;
    static final double B85_HOUSE7_MAX = 1555199.941344d;
    static final double B85_HOUSE7_MIN = 0.058615d;
    static final double B85_HOUSE8_MAX = 516765.810197d;
    static final double B85_HOUSE8_MIN = 61.859575d;
    static final double B85_HOUSE9_MAX = 274378.178787d;
    static final double B85_HOUSE9_MIN = 198.76297d;
    static final double B85_MC_MAX = 393.49442d;
    static final double B85_MC_MIN = 331.162936d;
    static final double B85_POLASC_MAX = 66.096027d;
    static final double B85_POLASC_MIN = -99.544653d;
    static final double B85_VERTEX_MAX = 409.019306d;
    static final double B85_VERTEX_MIN = 330.413985d;
    static final double B88_ARMC_MAX = 360.985931d;
    static final double B88_ARMC_MIN = 360.985828d;
    static final double B88_ASC_MAX = 1555165.554408d;
    static final double B88_ASC_MIN = -777600.02317d;
    static final double B88_COASC1_MAX = 1555165.554409d;
    static final double B88_COASC1_MIN = -34.489296d;
    static final double B88_COASC2_MAX = 399.547623d;
    static final double B88_COASC2_MIN = 331.043079d;
    static final double B88_EQUASC_MAX = 393.49442d;
    static final double B88_EQUASC_MIN = 331.162937d;
    static final double B88_HOUSE10_MAX = 393.49442d;
    static final double B88_HOUSE10_MIN = 331.162936d;
    static final double B88_HOUSE11_MAX = 271066.072583d;
    static final double B88_HOUSE11_MIN = 213.853833d;
    static final double B88_HOUSE12_MAX = 512298.186003d;
    static final double B88_HOUSE12_MIN = 102.932767d;
    static final double B88_HOUSE1_MAX = 1555199.976849d;
    static final double B88_HOUSE1_MIN = 0.023142d;
    static final double B88_HOUSE2_MAX = 512298.259258d;
    static final double B88_HOUSE2_MIN = 102.932766d;
    static final double B88_HOUSE3_MAX = 271066.008245d;
    static final double B88_HOUSE3_MIN = 213.853836d;
    static final double B88_HOUSE4_MAX = 393.49442d;
    static final double B88_HOUSE4_MIN = 331.162936d;
    static final double B88_HOUSE5_MAX = 271066.072583d;
    static final double B88_HOUSE5_MIN = 213.853833d;
    static final double B88_HOUSE6_MAX = 512298.186003d;
    static final double B88_HOUSE6_MIN = 102.932767d;
    static final double B88_HOUSE7_MAX = 1555199.976849d;
    static final double B88_HOUSE7_MIN = 0.023142d;
    static final double B88_HOUSE8_MAX = 512298.259258d;
    static final double B88_HOUSE8_MIN = 102.932766d;
    static final double B88_HOUSE9_MAX = 271066.008245d;
    static final double B88_HOUSE9_MIN = 213.853836d;
    static final double B88_MC_MAX = 393.49442d;
    static final double B88_MC_MIN = 331.162936d;
    static final double B88_POLASC_MAX = 29.34423d;
    static final double B88_POLASC_MIN = -34.489313d;
    static final double B88_VERTEX_MAX = 399.547621d;
    static final double B88_VERTEX_MIN = 331.043081d;
    static final double B90_ARMC_MAX = 360.985931d;
    static final double B90_ARMC_MIN = 360.985828d;
    static final double B90_ASC_MAX = 1555200.0d;
    static final double B90_ASC_MIN = -777600.0d;
    static final double B90_COASC1_MAX = 1555200.0d;
    static final double B90_COASC1_MIN = -0.0d;
    static final double B90_COASC2_MAX = 393.49442d;
    static final double B90_COASC2_MIN = 331.162937d;
    static final double B90_EQUASC_MAX = 393.49442d;
    static final double B90_EQUASC_MIN = 331.162937d;
    static final double B90_HOUSE10_MAX = 393.49442d;
    static final double B90_HOUSE10_MIN = 331.162936d;
    static final double B90_HOUSE11_MAX = 1555199.999841d;
    static final double B90_HOUSE11_MIN = 3.14E-4d;
    static final double B90_HOUSE12_MAX = 1555199.999958d;
    static final double B90_HOUSE12_MIN = 5.0E-6d;
    static final double B90_HOUSE1_MAX = 1555200.0d;
    static final double B90_HOUSE1_MIN = 0.0d;
    static final double B90_HOUSE2_MAX = 1555199.999958d;
    static final double B90_HOUSE2_MIN = 6.0E-6d;
    static final double B90_HOUSE3_MAX = 1555199.999848d;
    static final double B90_HOUSE3_MIN = 3.63E-4d;
    static final double B90_HOUSE4_MAX = 393.49442d;
    static final double B90_HOUSE4_MIN = 331.162936d;
    static final double B90_HOUSE5_MAX = 1555199.999841d;
    static final double B90_HOUSE5_MIN = 3.14E-4d;
    static final double B90_HOUSE6_MAX = 1555199.999958d;
    static final double B90_HOUSE6_MIN = 5.0E-6d;
    static final double B90_HOUSE7_MAX = 1555200.0d;
    static final double B90_HOUSE7_MIN = 0.0d;
    static final double B90_HOUSE8_MAX = 1555199.999958d;
    static final double B90_HOUSE8_MIN = 6.0E-6d;
    static final double B90_HOUSE9_MAX = 1555199.999848d;
    static final double B90_HOUSE9_MIN = 3.63E-4d;
    static final double B90_MC_MAX = 393.49442d;
    static final double B90_MC_MIN = 331.162936d;
    static final double B90_POLASC_MAX = 0.0d;
    static final double B90_POLASC_MIN = -0.0d;
    static final double B90_VERTEX_MAX = 393.49442d;
    static final double B90_VERTEX_MIN = 331.162937d;
    static final double C0_ARMC_MAX = 360.985931d;
    static final double C0_ARMC_MIN = 360.985828d;
    static final double C0_ASC_MAX = 393.49442d;
    static final double C0_ASC_MIN = 331.162937d;
    static final double C0_COASC1_MAX = 393.49442d;
    static final double C0_COASC1_MIN = 331.162937d;
    static final double C0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double C0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double C0_EQUASC_MAX = 393.49442d;
    static final double C0_EQUASC_MIN = 331.162937d;
    static final double C0_HOUSE10_MAX = 393.49442d;
    static final double C0_HOUSE10_MIN = 331.162936d;
    static final double C0_HOUSE11_MAX = 393.49442d;
    static final double C0_HOUSE11_MIN = 331.162936d;
    static final double C0_HOUSE12_MAX = 393.49442d;
    static final double C0_HOUSE12_MIN = 331.162937d;
    static final double C0_HOUSE1_MAX = 393.49442d;
    static final double C0_HOUSE1_MIN = 331.162937d;
    static final double C0_HOUSE2_MAX = 393.49442d;
    static final double C0_HOUSE2_MIN = 331.162937d;
    static final double C0_HOUSE3_MAX = 393.494421d;
    static final double C0_HOUSE3_MIN = 331.162936d;
    static final double C0_HOUSE4_MAX = 393.49442d;
    static final double C0_HOUSE4_MIN = 331.162936d;
    static final double C0_HOUSE5_MAX = 393.49442d;
    static final double C0_HOUSE5_MIN = 331.162936d;
    static final double C0_HOUSE6_MAX = 393.49442d;
    static final double C0_HOUSE6_MIN = 331.162937d;
    static final double C0_HOUSE7_MAX = 393.49442d;
    static final double C0_HOUSE7_MIN = 331.162937d;
    static final double C0_HOUSE8_MAX = 393.49442d;
    static final double C0_HOUSE8_MIN = 331.162937d;
    static final double C0_HOUSE9_MAX = 393.494421d;
    static final double C0_HOUSE9_MIN = 331.162936d;
    static final double C0_MC_MAX = 393.49442d;
    static final double C0_MC_MIN = 331.162936d;
    static final double C0_POLASC_MAX = 393.49442d;
    static final double C0_POLASC_MIN = 331.162937d;
    static final double C0_VERTEX_MAX = 777600.0d;
    static final double C0_VERTEX_MIN = -777600.0d;
    static final double C10_ARMC_MAX = 360.985931d;
    static final double C10_ARMC_MIN = 360.985828d;
    static final double C10_ASC_MAX = 426.089536d;
    static final double C10_ASC_MIN = 328.169552d;
    static final double C10_COASC1_MAX = 426.089531d;
    static final double C10_COASC1_MIN = 328.16955d;
    static final double C10_COASC2_MAX = 113.797795d;
    static final double C10_COASC2_MIN = -269.99607d;
    static final double C10_EQUASC_MAX = 393.49442d;
    static final double C10_EQUASC_MIN = 331.162937d;
    static final double C10_HOUSE10_MAX = 393.49442d;
    static final double C10_HOUSE10_MIN = 331.162936d;
    static final double C10_HOUSE11_MAX = 408.957438d;
    static final double C10_HOUSE11_MIN = 330.419688d;
    static final double C10_HOUSE12_MAX = 421.297286d;
    static final double C10_HOUSE12_MIN = 328.923043d;
    static final double C10_HOUSE1_MAX = 426.089536d;
    static final double C10_HOUSE1_MIN = 328.169552d;
    static final double C10_HOUSE2_MAX = 421.297279d;
    static final double C10_HOUSE2_MIN = 328.923046d;
    static final double C10_HOUSE3_MAX = 408.957435d;
    static final double C10_HOUSE3_MIN = 330.419688d;
    static final double C10_HOUSE4_MAX = 393.49442d;
    static final double C10_HOUSE4_MIN = 331.162936d;
    static final double C10_HOUSE5_MAX = 408.957438d;
    static final double C10_HOUSE5_MIN = 330.419688d;
    static final double C10_HOUSE6_MAX = 421.297286d;
    static final double C10_HOUSE6_MIN = 328.923043d;
    static final double C10_HOUSE7_MAX = 426.089536d;
    static final double C10_HOUSE7_MIN = 328.169552d;
    static final double C10_HOUSE8_MAX = 421.297279d;
    static final double C10_HOUSE8_MIN = 328.923046d;
    static final double C10_HOUSE9_MAX = 408.957435d;
    static final double C10_HOUSE9_MIN = 330.419688d;
    static final double C10_MC_MAX = 393.49442d;
    static final double C10_MC_MIN = 331.162936d;
    static final double C10_POLASC_MAX = 426.089531d;
    static final double C10_POLASC_MIN = 328.16955d;
    static final double C10_VERTEX_MAX = 1554930.566243d;
    static final double C10_VERTEX_MIN = -777600.124028d;
    static final double C20_ARMC_MAX = 360.985931d;
    static final double C20_ARMC_MIN = 360.985828d;
    static final double C20_ASC_MAX = 467.280896d;
    static final double C20_ASC_MIN = 319.225068d;
    static final double C20_COASC1_MAX = 467.280888d;
    static final double C20_COASC1_MIN = 319.22507d;
    static final double C20_COASC2_MAX = 179.610407d;
    static final double C20_COASC2_MIN = -2066.7575d;
    static final double C20_EQUASC_MAX = 393.49442d;
    static final double C20_EQUASC_MIN = 331.162937d;
    static final double C20_HOUSE10_MAX = 393.49442d;
    static final double C20_HOUSE10_MIN = 331.162936d;
    static final double C20_HOUSE11_MAX = 425.537741d;
    static final double C20_HOUSE11_MIN = 328.260619d;
    static final double C20_HOUSE12_MAX = 454.665521d;
    static final double C20_HOUSE12_MIN = 322.294824d;
    static final double C20_HOUSE1_MAX = 467.280896d;
    static final double C20_HOUSE1_MIN = 319.225068d;
    static final double C20_HOUSE2_MAX = 454.665487d;
    static final double C20_HOUSE2_MIN = 322.294813d;
    static final double C20_HOUSE3_MAX = 425.537755d;
    static final double C20_HOUSE3_MIN = 328.260627d;
    static final double C20_HOUSE4_MAX = 393.49442d;
    static final double C20_HOUSE4_MIN = 331.162936d;
    static final double C20_HOUSE5_MAX = 425.537741d;
    static final double C20_HOUSE5_MIN = 328.260619d;
    static final double C20_HOUSE6_MAX = 454.665521d;
    static final double C20_HOUSE6_MIN = 322.294824d;
    static final double C20_HOUSE7_MAX = 467.280896d;
    static final double C20_HOUSE7_MIN = 319.225068d;
    static final double C20_HOUSE8_MAX = 454.665487d;
    static final double C20_HOUSE8_MIN = 322.294813d;
    static final double C20_HOUSE9_MAX = 425.537755d;
    static final double C20_HOUSE9_MIN = 328.260627d;
    static final double C20_MC_MAX = 393.49442d;
    static final double C20_MC_MIN = 331.162936d;
    static final double C20_POLASC_MAX = 467.280888d;
    static final double C20_POLASC_MIN = 319.22507d;
    static final double C20_VERTEX_MAX = 1553150.33462d;
    static final double C20_VERTEX_MIN = -777600.393091d;
    static final double C30_ARMC_MAX = 360.985931d;
    static final double C30_ARMC_MIN = 360.985828d;
    static final double C30_ASC_MAX = 524.994891d;
    static final double C30_ASC_MIN = 304.407972d;
    static final double C30_COASC1_MAX = 524.994878d;
    static final double C30_COASC1_MIN = 304.407972d;
    static final double C30_COASC2_MAX = 1583.084164d;
    static final double C30_COASC2_MIN = 220.207028d;
    static final double C30_EQUASC_MAX = 393.49442d;
    static final double C30_EQUASC_MIN = 331.162937d;
    static final double C30_HOUSE10_MAX = 393.49442d;
    static final double C30_HOUSE10_MIN = 331.162936d;
    static final double C30_HOUSE11_MAX = 443.133242d;
    static final double C30_HOUSE11_MIN = 324.895992d;
    static final double C30_HOUSE12_MAX = 497.094671d;
    static final double C30_HOUSE12_MIN = 311.557165d;
    static final double C30_HOUSE1_MAX = 524.994891d;
    static final double C30_HOUSE1_MIN = 304.407972d;
    static final double C30_HOUSE2_MAX = 497.094707d;
    static final double C30_HOUSE2_MIN = 311.557166d;
    static final double C30_HOUSE3_MAX = 443.133258d;
    static final double C30_HOUSE3_MIN = 324.895998d;
    static final double C30_HOUSE4_MAX = 393.49442d;
    static final double C30_HOUSE4_MIN = 331.162936d;
    static final double C30_HOUSE5_MAX = 443.133242d;
    static final double C30_HOUSE5_MIN = 324.895992d;
    static final double C30_HOUSE6_MAX = 497.094671d;
    static final double C30_HOUSE6_MIN = 311.557165d;
    static final double C30_HOUSE7_MAX = 524.994891d;
    static final double C30_HOUSE7_MIN = 304.407972d;
    static final double C30_HOUSE8_MAX = 497.094707d;
    static final double C30_HOUSE8_MIN = 311.557166d;
    static final double C30_HOUSE9_MAX = 443.133258d;
    static final double C30_HOUSE9_MIN = 324.895998d;
    static final double C30_MC_MAX = 393.49442d;
    static final double C30_MC_MIN = 331.162936d;
    static final double C30_POLASC_MAX = 524.994878d;
    static final double C30_POLASC_MIN = 304.407972d;
    static final double C30_VERTEX_MAX = 1583.084212d;
    static final double C30_VERTEX_MIN = 220.207025d;
    static final double C40_ARMC_MAX = 360.985931d;
    static final double C40_ARMC_MIN = 360.985828d;
    static final double C40_ASC_MAX = 618.738596d;
    static final double C40_ASC_MIN = 283.720808d;
    static final double C40_COASC1_MAX = 618.738574d;
    static final double C40_COASC1_MIN = 283.720804d;
    static final double C40_COASC2_MAX = 814.745889d;
    static final double C40_COASC2_MIN = 256.684961d;
    static final double C40_EQUASC_MAX = 393.49442d;
    static final double C40_EQUASC_MIN = 331.162937d;
    static final double C40_HOUSE10_MAX = 393.49442d;
    static final double C40_HOUSE10_MIN = 331.162936d;
    static final double C40_HOUSE11_MAX = 461.43987d;
    static final double C40_HOUSE11_MIN = 320.668999d;
    static final double C40_HOUSE12_MAX = 554.777147d;
    static final double C40_HOUSE12_MIN = 297.194477d;
    static final double C40_HOUSE1_MAX = 618.738596d;
    static final double C40_HOUSE1_MIN = 283.720808d;
    static final double C40_HOUSE2_MAX = 554.777085d;
    static final double C40_HOUSE2_MIN = 297.194471d;
    static final double C40_HOUSE3_MAX = 461.439872d;
    static final double C40_HOUSE3_MIN = 320.669002d;
    static final double C40_HOUSE4_MAX = 393.49442d;
    static final double C40_HOUSE4_MIN = 331.162936d;
    static final double C40_HOUSE5_MAX = 461.43987d;
    static final double C40_HOUSE5_MIN = 320.668999d;
    static final double C40_HOUSE6_MAX = 554.777147d;
    static final double C40_HOUSE6_MIN = 297.194477d;
    static final double C40_HOUSE7_MAX = 618.738596d;
    static final double C40_HOUSE7_MIN = 283.720808d;
    static final double C40_HOUSE8_MAX = 554.777085d;
    static final double C40_HOUSE8_MIN = 297.194471d;
    static final double C40_HOUSE9_MAX = 461.439872d;
    static final double C40_HOUSE9_MIN = 320.669002d;
    static final double C40_MC_MAX = 393.49442d;
    static final double C40_MC_MIN = 331.162936d;
    static final double C40_POLASC_MAX = 618.738574d;
    static final double C40_POLASC_MIN = 283.720804d;
    static final double C40_VERTEX_MAX = 814.74585d;
    static final double C40_VERTEX_MIN = 256.68496d;
    static final double C50_ARMC_MAX = 360.985931d;
    static final double C50_ARMC_MIN = 360.985828d;
    static final double C50_ASC_MAX = 814.745889d;
    static final double C50_ASC_MIN = 256.684961d;
    static final double C50_COASC1_MAX = 814.74585d;
    static final double C50_COASC1_MIN = 256.68496d;
    static final double C50_COASC2_MAX = 618.738596d;
    static final double C50_COASC2_MIN = 283.720808d;
    static final double C50_EQUASC_MAX = 393.49442d;
    static final double C50_EQUASC_MIN = 331.162937d;
    static final double C50_HOUSE10_MAX = 393.49442d;
    static final double C50_HOUSE10_MIN = 331.162936d;
    static final double C50_HOUSE11_MAX = 479.80696d;
    static final double C50_HOUSE11_MIN = 316.04037d;
    static final double C50_HOUSE12_MAX = 639.467588d;
    static final double C50_HOUSE12_MIN = 279.945757d;
    static final double C50_HOUSE1_MAX = 814.745889d;
    static final double C50_HOUSE1_MIN = 256.684961d;
    static final double C50_HOUSE2_MAX = 639.467438d;
    static final double C50_HOUSE2_MIN = 279.945752d;
    static final double C50_HOUSE3_MAX = 479.806992d;
    static final double C50_HOUSE3_MIN = 316.04036d;
    static final double C50_HOUSE4_MAX = 393.49442d;
    static final double C50_HOUSE4_MIN = 331.162936d;
    static final double C50_HOUSE5_MAX = 479.80696d;
    static final double C50_HOUSE5_MIN = 316.04037d;
    static final double C50_HOUSE6_MAX = 639.467588d;
    static final double C50_HOUSE6_MIN = 279.945757d;
    static final double C50_HOUSE7_MAX = 814.745889d;
    static final double C50_HOUSE7_MIN = 256.684961d;
    static final double C50_HOUSE8_MAX = 639.467438d;
    static final double C50_HOUSE8_MIN = 279.945752d;
    static final double C50_HOUSE9_MAX = 479.806992d;
    static final double C50_HOUSE9_MIN = 316.04036d;
    static final double C50_MC_MAX = 393.49442d;
    static final double C50_MC_MIN = 331.162936d;
    static final double C50_POLASC_MAX = 814.74585d;
    static final double C50_POLASC_MIN = 256.68496d;
    static final double C50_VERTEX_MAX = 618.738574d;
    static final double C50_VERTEX_MIN = 283.720804d;
    static final double C60_ARMC_MAX = 360.985931d;
    static final double C60_ARMC_MIN = 360.985828d;
    static final double C60_ASC_MAX = 1583.084164d;
    static final double C60_ASC_MIN = 220.207028d;
    static final double C60_COASC1_MAX = 1583.084212d;
    static final double C60_COASC1_MIN = 220.207025d;
    static final double C60_COASC2_MAX = 524.994891d;
    static final double C60_COASC2_MIN = 304.407972d;
    static final double C60_EQUASC_MAX = 393.49442d;
    static final double C60_EQUASC_MIN = 331.162937d;
    static final double C60_HOUSE10_MAX = 393.49442d;
    static final double C60_HOUSE10_MIN = 331.162936d;
    static final double C60_HOUSE11_MAX = 497.094653d;
    static final double C60_HOUSE11_MIN = 311.557168d;
    static final double C60_HOUSE12_MAX = 774.491511d;
    static final double C60_HOUSE12_MIN = 260.934857d;
    static final double C60_HOUSE1_MAX = 1583.084164d;
    static final double C60_HOUSE1_MIN = 220.207028d;
    static final double C60_HOUSE2_MAX = 774.491318d;
    static final double C60_HOUSE2_MIN = 260.934858d;
    static final double C60_HOUSE3_MAX = 497.094702d;
    static final double C60_HOUSE3_MIN = 311.557164d;
    static final double C60_HOUSE4_MAX = 393.49442d;
    static final double C60_HOUSE4_MIN = 331.162936d;
    static final double C60_HOUSE5_MAX = 497.094653d;
    static final double C60_HOUSE5_MIN = 311.557168d;
    static final double C60_HOUSE6_MAX = 774.491511d;
    static final double C60_HOUSE6_MIN = 260.934857d;
    static final double C60_HOUSE7_MAX = 1583.084164d;
    static final double C60_HOUSE7_MIN = 220.207028d;
    static final double C60_HOUSE8_MAX = 774.491318d;
    static final double C60_HOUSE8_MIN = 260.934858d;
    static final double C60_HOUSE9_MAX = 497.094702d;
    static final double C60_HOUSE9_MIN = 311.557164d;
    static final double C60_MC_MAX = 393.49442d;
    static final double C60_MC_MIN = 331.162936d;
    static final double C60_POLASC_MAX = 1583.084212d;
    static final double C60_POLASC_MIN = 220.207025d;
    static final double C60_VERTEX_MAX = 524.994878d;
    static final double C60_VERTEX_MIN = 304.407972d;
    static final double C66_ARMC_MAX = 360.985931d;
    static final double C66_ARMC_MIN = 360.985828d;
    static final double C66_ASC_MAX = 15382.763492d;
    static final double C66_ASC_MIN = 180.714519d;
    static final double C66_COASC1_MAX = 15382.960178d;
    static final double C66_COASC1_MIN = 180.714532d;
    static final double C66_COASC2_MAX = 487.697885d;
    static final double C66_COASC2_MIN = 313.998924d;
    static final double C66_EQUASC_MAX = 393.49442d;
    static final double C66_EQUASC_MIN = 331.162937d;
    static final double C66_HOUSE10_MAX = 393.49442d;
    static final double C66_HOUSE10_MIN = 331.162936d;
    static final double C66_HOUSE11_MAX = 506.274507d;
    static final double C66_HOUSE11_MIN = 309.178712d;
    static final double C66_HOUSE12_MAX = 896.74019d;
    static final double C66_HOUSE12_MIN = 249.403078d;
    static final double C66_HOUSE1_MAX = 15382.763492d;
    static final double C66_HOUSE1_MIN = 180.714519d;
    static final double C66_HOUSE2_MAX = 896.74045d;
    static final double C66_HOUSE2_MIN = 249.403075d;
    static final double C66_HOUSE3_MAX = 506.274478d;
    static final double C66_HOUSE3_MIN = 309.178718d;
    static final double C66_HOUSE4_MAX = 393.49442d;
    static final double C66_HOUSE4_MIN = 331.162936d;
    static final double C66_HOUSE5_MAX = 506.274507d;
    static final double C66_HOUSE5_MIN = 309.178712d;
    static final double C66_HOUSE6_MAX = 896.74019d;
    static final double C66_HOUSE6_MIN = 249.403078d;
    static final double C66_HOUSE7_MAX = 15382.763492d;
    static final double C66_HOUSE7_MIN = 180.714519d;
    static final double C66_HOUSE8_MAX = 896.74045d;
    static final double C66_HOUSE8_MIN = 249.403075d;
    static final double C66_HOUSE9_MAX = 506.274478d;
    static final double C66_HOUSE9_MIN = 309.178718d;
    static final double C66_MC_MAX = 393.49442d;
    static final double C66_MC_MIN = 331.162936d;
    static final double C66_POLASC_MAX = 15382.960178d;
    static final double C66_POLASC_MIN = 180.714532d;
    static final double C66_VERTEX_MAX = 487.697876d;
    static final double C66_VERTEX_MIN = 313.998925d;
    static final double C70_ARMC_MAX = 360.985931d;
    static final double C70_ARMC_MIN = 360.985828d;
    static final double C70_ASC_MAX = 1553150.32968d;
    static final double C70_ASC_MIN = -777600.39302d;
    static final double C70_COASC1_MAX = 1553150.33462d;
    static final double C70_COASC1_MIN = -2066.704127d;
    static final double C70_COASC2_MAX = 467.280896d;
    static final double C70_COASC2_MIN = 319.225068d;
    static final double C70_EQUASC_MAX = 393.49442d;
    static final double C70_EQUASC_MIN = 331.162937d;
    static final double C70_HOUSE10_MAX = 777947.502418d;
    static final double C70_HOUSE10_MIN = 331.162936d;
    static final double C70_HOUSE11_MAX = 777998.635025d;
    static final double C70_HOUSE11_MIN = 307.797903d;
    static final double C70_HOUSE12_MAX = 778164.968826d;
    static final double C70_HOUSE12_MIN = 242.015105d;
    static final double C70_HOUSE1_MAX = 1555199.608408d;
    static final double C70_HOUSE1_MIN = 0.389863d;
    static final double C70_HOUSE2_MAX = 778164.963032d;
    static final double C70_HOUSE2_MIN = 242.015106d;
    static final double C70_HOUSE3_MAX = 777998.63387d;
    static final double C70_HOUSE3_MIN = 307.797905d;
    static final double C70_HOUSE4_MAX = 777947.502418d;
    static final double C70_HOUSE4_MIN = 331.162936d;
    static final double C70_HOUSE5_MAX = 777998.635025d;
    static final double C70_HOUSE5_MIN = 307.797903d;
    static final double C70_HOUSE6_MAX = 778164.968826d;
    static final double C70_HOUSE6_MIN = 242.015105d;
    static final double C70_HOUSE7_MAX = 1555199.608408d;
    static final double C70_HOUSE7_MIN = 0.389863d;
    static final double C70_HOUSE8_MAX = 778164.963032d;
    static final double C70_HOUSE8_MIN = 242.015106d;
    static final double C70_HOUSE9_MAX = 777998.63387d;
    static final double C70_HOUSE9_MIN = 307.797905d;
    static final double C70_MC_MAX = 777947.502418d;
    static final double C70_MC_MIN = -777252.648535d;
    static final double C70_POLASC_MAX = 179.610407d;
    static final double C70_POLASC_MIN = -2066.757416d;
    static final double C70_VERTEX_MAX = 467.280888d;
    static final double C70_VERTEX_MIN = 319.22507d;
    static final double C80_ARMC_MAX = 360.985931d;
    static final double C80_ARMC_MIN = 360.985828d;
    static final double C80_ASC_MAX = 1554930.566184d;
    static final double C80_ASC_MIN = -777600.124007d;
    static final double C80_COASC1_MAX = 1554930.566243d;
    static final double C80_COASC1_MIN = -269.995683d;
    static final double C80_COASC2_MAX = 426.089536d;
    static final double C80_COASC2_MIN = 328.169552d;
    static final double C80_EQUASC_MAX = 393.49442d;
    static final double C80_EQUASC_MIN = 331.162937d;
    static final double C80_HOUSE10_MAX = 777981.666378d;
    static final double C80_HOUSE10_MIN = 331.162936d;
    static final double C80_HOUSE11_MAX = 778092.785427d;
    static final double C80_HOUSE11_MIN = 305.289672d;
    static final double C80_HOUSE12_MAX = 778780.06859d;
    static final double C80_HOUSE12_MIN = 226.579047d;
    static final double C80_HOUSE1_MAX = 1555199.876097d;
    static final double C80_HOUSE1_MIN = 0.12375d;
    static final double C80_HOUSE2_MAX = 778780.060688d;
    static final double C80_HOUSE2_MIN = 226.579046d;
    static final double C80_HOUSE3_MAX = 778092.784956d;
    static final double C80_HOUSE3_MIN = 305.289674d;
    static final double C80_HOUSE4_MAX = 777981.666378d;
    static final double C80_HOUSE4_MIN = 331.162936d;
    static final double C80_HOUSE5_MAX = 778092.785427d;
    static final double C80_HOUSE5_MIN = 305.289672d;
    static final double C80_HOUSE6_MAX = 778780.06859d;
    static final double C80_HOUSE6_MIN = 226.579047d;
    static final double C80_HOUSE7_MAX = 1555199.876097d;
    static final double C80_HOUSE7_MIN = 0.12375d;
    static final double C80_HOUSE8_MAX = 778780.060688d;
    static final double C80_HOUSE8_MIN = 226.579046d;
    static final double C80_HOUSE9_MAX = 778092.784956d;
    static final double C80_HOUSE9_MIN = 305.289674d;
    static final double C80_MC_MAX = 777981.666378d;
    static final double C80_MC_MIN = -777218.490322d;
    static final double C80_POLASC_MAX = 113.797793d;
    static final double C80_POLASC_MIN = -269.996067d;
    static final double C80_VERTEX_MAX = 426.089531d;
    static final double C80_VERTEX_MIN = 328.16955d;
    static final double C85_ARMC_MAX = 360.985931d;
    static final double C85_ARMC_MIN = 360.985828d;
    static final double C85_ASC_MAX = 1555100.603952d;
    static final double C85_ASC_MIN = -777600.058703d;
    static final double C85_COASC1_MAX = 1555100.603957d;
    static final double C85_COASC1_MIN = -99.544583d;
    static final double C85_COASC2_MAX = 409.019308d;
    static final double C85_COASC2_MIN = 330.413985d;
    static final double C85_EQUASC_MAX = 393.49442d;
    static final double C85_EQUASC_MIN = 331.162937d;
    static final double C85_HOUSE10_MAX = 777990.526167d;
    static final double C85_HOUSE10_MIN = 331.162936d;
    static final double C85_HOUSE11_MAX = 778116.882169d;
    static final double C85_HOUSE11_MIN = 304.63061d;
    static final double C85_HOUSE12_MAX = 779064.982659d;
    static final double C85_HOUSE12_MIN = 221.880221d;
    static final double C85_HOUSE1_MAX = 1555199.941344d;
    static final double C85_HOUSE1_MIN = 0.058615d;
    static final double C85_HOUSE2_MAX = 779064.965957d;
    static final double C85_HOUSE2_MIN = 221.880225d;
    static final double C85_HOUSE3_MAX = 778116.881242d;
    static final double C85_HOUSE3_MIN = 304.630612d;
    static final double C85_HOUSE4_MAX = 777990.526167d;
    static final double C85_HOUSE4_MIN = 331.162936d;
    static final double C85_HOUSE5_MAX = 778116.882169d;
    static final double C85_HOUSE5_MIN = 304.63061d;
    static final double C85_HOUSE6_MAX = 779064.982659d;
    static final double C85_HOUSE6_MIN = 221.880221d;
    static final double C85_HOUSE7_MAX = 1555199.941344d;
    static final double C85_HOUSE7_MIN = 0.058615d;
    static final double C85_HOUSE8_MAX = 779064.965957d;
    static final double C85_HOUSE8_MIN = 221.880225d;
    static final double C85_HOUSE9_MAX = 778116.881242d;
    static final double C85_HOUSE9_MIN = 304.630612d;
    static final double C85_MC_MAX = 777990.526167d;
    static final double C85_MC_MIN = -777209.599297d;
    static final double C85_POLASC_MAX = 66.096027d;
    static final double C85_POLASC_MIN = -99.544653d;
    static final double C85_VERTEX_MAX = 409.019306d;
    static final double C85_VERTEX_MIN = 330.413985d;
    static final double C88_ARMC_MAX = 360.985931d;
    static final double C88_ARMC_MIN = 360.985828d;
    static final double C88_ASC_MAX = 1555165.554408d;
    static final double C88_ASC_MIN = -777600.02317d;
    static final double C88_COASC1_MAX = 1555165.554409d;
    static final double C88_COASC1_MIN = -34.489296d;
    static final double C88_COASC2_MAX = 399.547623d;
    static final double C88_COASC2_MIN = 331.043079d;
    static final double C88_EQUASC_MAX = 393.49442d;
    static final double C88_EQUASC_MIN = 331.162937d;
    static final double C88_HOUSE10_MAX = 777993.023575d;
    static final double C88_HOUSE10_MIN = 331.162936d;
    static final double C88_HOUSE11_MAX = 778123.708399d;
    static final double C88_HOUSE11_MIN = 304.443697d;
    static final double C88_HOUSE12_MAX = 779163.540891d;
    static final double C88_HOUSE12_MIN = 220.47874d;
    static final double C88_HOUSE1_MAX = 1555199.976849d;
    static final double C88_HOUSE1_MIN = 0.023142d;
    static final double C88_HOUSE2_MAX = 779163.542082d;
    static final double C88_HOUSE2_MIN = 220.478743d;
    static final double C88_HOUSE3_MAX = 778123.708457d;
    static final double C88_HOUSE3_MIN = 304.443698d;
    static final double C88_HOUSE4_MAX = 777993.023575d;
    static final double C88_HOUSE4_MIN = 331.162936d;
    static final double C88_HOUSE5_MAX = 778123.708399d;
    static final double C88_HOUSE5_MIN = 304.443697d;
    static final double C88_HOUSE6_MAX = 779163.540891d;
    static final double C88_HOUSE6_MIN = 220.47874d;
    static final double C88_HOUSE7_MAX = 1555199.976849d;
    static final double C88_HOUSE7_MIN = 0.023142d;
    static final double C88_HOUSE8_MAX = 779163.542082d;
    static final double C88_HOUSE8_MIN = 220.478743d;
    static final double C88_HOUSE9_MAX = 778123.708457d;
    static final double C88_HOUSE9_MIN = 304.443698d;
    static final double C88_MC_MAX = 777993.023523d;
    static final double C88_MC_MIN = -777207.078222d;
    static final double C88_POLASC_MAX = 29.34423d;
    static final double C88_POLASC_MIN = -34.489313d;
    static final double C88_VERTEX_MAX = 399.547621d;
    static final double C88_VERTEX_MIN = 331.043081d;
    static final double C90_ARMC_MAX = 360.985931d;
    static final double C90_ARMC_MIN = 360.985828d;
    static final double C90_ASC_MAX = 1555200.0d;
    static final double C90_ASC_MIN = -777600.0d;
    static final double C90_COASC1_MAX = 1555200.0d;
    static final double C90_COASC1_MIN = -0.0d;
    static final double C90_COASC2_MAX = 393.49442d;
    static final double C90_COASC2_MIN = 331.162937d;
    static final double C90_EQUASC_MAX = 393.49442d;
    static final double C90_EQUASC_MIN = 331.162937d;
    static final double C90_HOUSE10_MAX = 777993.49442d;
    static final double C90_HOUSE10_MIN = 331.162936d;
    static final double C90_HOUSE11_MAX = 778124.994882d;
    static final double C90_HOUSE11_MIN = 304.407971d;
    static final double C90_HOUSE12_MAX = 779183.083669d;
    static final double C90_HOUSE12_MIN = 220.207025d;
    static final double C90_HOUSE1_MAX = 1555200.0d;
    static final double C90_HOUSE1_MIN = 0.0d;
    static final double C90_HOUSE2_MAX = 779183.084379d;
    static final double C90_HOUSE2_MIN = 220.207028d;
    static final double C90_HOUSE3_MAX = 778124.994889d;
    static final double C90_HOUSE3_MIN = 304.407971d;
    static final double C90_HOUSE4_MAX = 777993.49442d;
    static final double C90_HOUSE4_MIN = 331.162936d;
    static final double C90_HOUSE5_MAX = 778124.994882d;
    static final double C90_HOUSE5_MIN = 304.407971d;
    static final double C90_HOUSE6_MAX = 779183.083669d;
    static final double C90_HOUSE6_MIN = 220.207025d;
    static final double C90_HOUSE7_MAX = 1555200.0d;
    static final double C90_HOUSE7_MIN = 0.0d;
    static final double C90_HOUSE8_MAX = 779183.084379d;
    static final double C90_HOUSE8_MIN = 220.207028d;
    static final double C90_HOUSE9_MAX = 778124.994889d;
    static final double C90_HOUSE9_MIN = 304.407971d;
    static final double C90_MC_MAX = 393.494367d;
    static final double C90_MC_MIN = -777206.547265d;
    static final double C90_POLASC_MAX = 0.0d;
    static final double C90_POLASC_MIN = -0.0d;
    static final double C90_VERTEX_MAX = 393.49442d;
    static final double C90_VERTEX_MIN = 331.162937d;
    static final double E0_ARMC_MAX = 360.985931d;
    static final double E0_ARMC_MIN = 360.985828d;
    static final double E0_ASC_MAX = 393.49442d;
    static final double E0_ASC_MIN = 331.162937d;
    static final double E0_COASC1_MAX = 393.49442d;
    static final double E0_COASC1_MIN = 331.162937d;
    static final double E0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double E0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double E0_EQUASC_MAX = 393.49442d;
    static final double E0_EQUASC_MIN = 331.162937d;
    static final double E0_HOUSE10_MAX = 393.49442d;
    static final double E0_HOUSE10_MIN = 331.162937d;
    static final double E0_HOUSE11_MAX = 393.49442d;
    static final double E0_HOUSE11_MIN = 331.162937d;
    static final double E0_HOUSE12_MAX = 393.49442d;
    static final double E0_HOUSE12_MIN = 331.162937d;
    static final double E0_HOUSE1_MAX = 393.49442d;
    static final double E0_HOUSE1_MIN = 331.162937d;
    static final double E0_HOUSE2_MAX = 393.49442d;
    static final double E0_HOUSE2_MIN = 331.162937d;
    static final double E0_HOUSE3_MAX = 393.49442d;
    static final double E0_HOUSE3_MIN = 331.162937d;
    static final double E0_HOUSE4_MAX = 393.49442d;
    static final double E0_HOUSE4_MIN = 331.162937d;
    static final double E0_HOUSE5_MAX = 393.49442d;
    static final double E0_HOUSE5_MIN = 331.162937d;
    static final double E0_HOUSE6_MAX = 393.49442d;
    static final double E0_HOUSE6_MIN = 331.162937d;
    static final double E0_HOUSE7_MAX = 393.49442d;
    static final double E0_HOUSE7_MIN = 331.162937d;
    static final double E0_HOUSE8_MAX = 393.49442d;
    static final double E0_HOUSE8_MIN = 331.162937d;
    static final double E0_HOUSE9_MAX = 393.49442d;
    static final double E0_HOUSE9_MIN = 331.162937d;
    static final double E0_MC_MAX = 393.49442d;
    static final double E0_MC_MIN = 331.162936d;
    static final double E0_POLASC_MAX = 393.49442d;
    static final double E0_POLASC_MIN = 331.162937d;
    static final double E0_VERTEX_MAX = 777600.0d;
    static final double E0_VERTEX_MIN = -777600.0d;
    static final double E10_ARMC_MAX = 360.985931d;
    static final double E10_ARMC_MIN = 360.985828d;
    static final double E10_ASC_MAX = 426.089536d;
    static final double E10_ASC_MIN = 328.169552d;
    static final double E10_COASC1_MAX = 426.089531d;
    static final double E10_COASC1_MIN = 328.16955d;
    static final double E10_COASC2_MAX = 113.797795d;
    static final double E10_COASC2_MIN = -269.99607d;
    static final double E10_EQUASC_MAX = 393.49442d;
    static final double E10_EQUASC_MIN = 331.162937d;
    static final double E10_HOUSE10_MAX = 426.089536d;
    static final double E10_HOUSE10_MIN = 328.169552d;
    static final double E10_HOUSE11_MAX = 426.089536d;
    static final double E10_HOUSE11_MIN = 328.169552d;
    static final double E10_HOUSE12_MAX = 426.089536d;
    static final double E10_HOUSE12_MIN = 328.169552d;
    static final double E10_HOUSE1_MAX = 426.089536d;
    static final double E10_HOUSE1_MIN = 328.169552d;
    static final double E10_HOUSE2_MAX = 426.089536d;
    static final double E10_HOUSE2_MIN = 328.169552d;
    static final double E10_HOUSE3_MAX = 426.089536d;
    static final double E10_HOUSE3_MIN = 328.169552d;
    static final double E10_HOUSE4_MAX = 426.089536d;
    static final double E10_HOUSE4_MIN = 328.169552d;
    static final double E10_HOUSE5_MAX = 426.089536d;
    static final double E10_HOUSE5_MIN = 328.169552d;
    static final double E10_HOUSE6_MAX = 426.089536d;
    static final double E10_HOUSE6_MIN = 328.169552d;
    static final double E10_HOUSE7_MAX = 426.089536d;
    static final double E10_HOUSE7_MIN = 328.169552d;
    static final double E10_HOUSE8_MAX = 426.089536d;
    static final double E10_HOUSE8_MIN = 328.169552d;
    static final double E10_HOUSE9_MAX = 426.089536d;
    static final double E10_HOUSE9_MIN = 328.169552d;
    static final double E10_MC_MAX = 393.49442d;
    static final double E10_MC_MIN = 331.162936d;
    static final double E10_POLASC_MAX = 426.089531d;
    static final double E10_POLASC_MIN = 328.16955d;
    static final double E10_VERTEX_MAX = 1554930.566243d;
    static final double E10_VERTEX_MIN = -777600.124028d;
    static final double E20_ARMC_MAX = 360.985931d;
    static final double E20_ARMC_MIN = 360.985828d;
    static final double E20_ASC_MAX = 467.280896d;
    static final double E20_ASC_MIN = 319.225068d;
    static final double E20_COASC1_MAX = 467.280888d;
    static final double E20_COASC1_MIN = 319.22507d;
    static final double E20_COASC2_MAX = 179.610407d;
    static final double E20_COASC2_MIN = -2066.7575d;
    static final double E20_EQUASC_MAX = 393.49442d;
    static final double E20_EQUASC_MIN = 331.162937d;
    static final double E20_HOUSE10_MAX = 467.280896d;
    static final double E20_HOUSE10_MIN = 319.225068d;
    static final double E20_HOUSE11_MAX = 467.280896d;
    static final double E20_HOUSE11_MIN = 319.225068d;
    static final double E20_HOUSE12_MAX = 467.280896d;
    static final double E20_HOUSE12_MIN = 319.225068d;
    static final double E20_HOUSE1_MAX = 467.280896d;
    static final double E20_HOUSE1_MIN = 319.225068d;
    static final double E20_HOUSE2_MAX = 467.280896d;
    static final double E20_HOUSE2_MIN = 319.225068d;
    static final double E20_HOUSE3_MAX = 467.280896d;
    static final double E20_HOUSE3_MIN = 319.225068d;
    static final double E20_HOUSE4_MAX = 467.280896d;
    static final double E20_HOUSE4_MIN = 319.225068d;
    static final double E20_HOUSE5_MAX = 467.280896d;
    static final double E20_HOUSE5_MIN = 319.225068d;
    static final double E20_HOUSE6_MAX = 467.280896d;
    static final double E20_HOUSE6_MIN = 319.225068d;
    static final double E20_HOUSE7_MAX = 467.280896d;
    static final double E20_HOUSE7_MIN = 319.225068d;
    static final double E20_HOUSE8_MAX = 467.280896d;
    static final double E20_HOUSE8_MIN = 319.225068d;
    static final double E20_HOUSE9_MAX = 467.280896d;
    static final double E20_HOUSE9_MIN = 319.225068d;
    static final double E20_MC_MAX = 393.49442d;
    static final double E20_MC_MIN = 331.162936d;
    static final double E20_POLASC_MAX = 467.280888d;
    static final double E20_POLASC_MIN = 319.22507d;
    static final double E20_VERTEX_MAX = 1553150.33462d;
    static final double E20_VERTEX_MIN = -777600.393091d;
    static final double E30_ARMC_MAX = 360.985931d;
    static final double E30_ARMC_MIN = 360.985828d;
    static final double E30_ASC_MAX = 524.994891d;
    static final double E30_ASC_MIN = 304.407972d;
    static final double E30_COASC1_MAX = 524.994878d;
    static final double E30_COASC1_MIN = 304.407972d;
    static final double E30_COASC2_MAX = 1583.084164d;
    static final double E30_COASC2_MIN = 220.207028d;
    static final double E30_EQUASC_MAX = 393.49442d;
    static final double E30_EQUASC_MIN = 331.162937d;
    static final double E30_HOUSE10_MAX = 524.994891d;
    static final double E30_HOUSE10_MIN = 304.407972d;
    static final double E30_HOUSE11_MAX = 524.994891d;
    static final double E30_HOUSE11_MIN = 304.407972d;
    static final double E30_HOUSE12_MAX = 524.994891d;
    static final double E30_HOUSE12_MIN = 304.407972d;
    static final double E30_HOUSE1_MAX = 524.994891d;
    static final double E30_HOUSE1_MIN = 304.407972d;
    static final double E30_HOUSE2_MAX = 524.994891d;
    static final double E30_HOUSE2_MIN = 304.407972d;
    static final double E30_HOUSE3_MAX = 524.994891d;
    static final double E30_HOUSE3_MIN = 304.407972d;
    static final double E30_HOUSE4_MAX = 524.994891d;
    static final double E30_HOUSE4_MIN = 304.407972d;
    static final double E30_HOUSE5_MAX = 524.994891d;
    static final double E30_HOUSE5_MIN = 304.407972d;
    static final double E30_HOUSE6_MAX = 524.994891d;
    static final double E30_HOUSE6_MIN = 304.407972d;
    static final double E30_HOUSE7_MAX = 524.994891d;
    static final double E30_HOUSE7_MIN = 304.407972d;
    static final double E30_HOUSE8_MAX = 524.994891d;
    static final double E30_HOUSE8_MIN = 304.407972d;
    static final double E30_HOUSE9_MAX = 524.994891d;
    static final double E30_HOUSE9_MIN = 304.407972d;
    static final double E30_MC_MAX = 393.49442d;
    static final double E30_MC_MIN = 331.162936d;
    static final double E30_POLASC_MAX = 524.994878d;
    static final double E30_POLASC_MIN = 304.407972d;
    static final double E30_VERTEX_MAX = 1583.084212d;
    static final double E30_VERTEX_MIN = 220.207025d;
    static final double E40_ARMC_MAX = 360.985931d;
    static final double E40_ARMC_MIN = 360.985828d;
    static final double E40_ASC_MAX = 618.738596d;
    static final double E40_ASC_MIN = 283.720808d;
    static final double E40_COASC1_MAX = 618.738574d;
    static final double E40_COASC1_MIN = 283.720804d;
    static final double E40_COASC2_MAX = 814.745889d;
    static final double E40_COASC2_MIN = 256.684961d;
    static final double E40_EQUASC_MAX = 393.49442d;
    static final double E40_EQUASC_MIN = 331.162937d;
    static final double E40_HOUSE10_MAX = 618.738596d;
    static final double E40_HOUSE10_MIN = 283.720808d;
    static final double E40_HOUSE11_MAX = 618.738596d;
    static final double E40_HOUSE11_MIN = 283.720808d;
    static final double E40_HOUSE12_MAX = 618.738596d;
    static final double E40_HOUSE12_MIN = 283.720808d;
    static final double E40_HOUSE1_MAX = 618.738596d;
    static final double E40_HOUSE1_MIN = 283.720808d;
    static final double E40_HOUSE2_MAX = 618.738596d;
    static final double E40_HOUSE2_MIN = 283.720808d;
    static final double E40_HOUSE3_MAX = 618.738596d;
    static final double E40_HOUSE3_MIN = 283.720808d;
    static final double E40_HOUSE4_MAX = 618.738596d;
    static final double E40_HOUSE4_MIN = 283.720808d;
    static final double E40_HOUSE5_MAX = 618.738596d;
    static final double E40_HOUSE5_MIN = 283.720808d;
    static final double E40_HOUSE6_MAX = 618.738596d;
    static final double E40_HOUSE6_MIN = 283.720808d;
    static final double E40_HOUSE7_MAX = 618.738596d;
    static final double E40_HOUSE7_MIN = 283.720808d;
    static final double E40_HOUSE8_MAX = 618.738596d;
    static final double E40_HOUSE8_MIN = 283.720808d;
    static final double E40_HOUSE9_MAX = 618.738596d;
    static final double E40_HOUSE9_MIN = 283.720808d;
    static final double E40_MC_MAX = 393.49442d;
    static final double E40_MC_MIN = 331.162936d;
    static final double E40_POLASC_MAX = 618.738574d;
    static final double E40_POLASC_MIN = 283.720804d;
    static final double E40_VERTEX_MAX = 814.74585d;
    static final double E40_VERTEX_MIN = 256.68496d;
    static final double E50_ARMC_MAX = 360.985931d;
    static final double E50_ARMC_MIN = 360.985828d;
    static final double E50_ASC_MAX = 814.745889d;
    static final double E50_ASC_MIN = 256.684961d;
    static final double E50_COASC1_MAX = 814.74585d;
    static final double E50_COASC1_MIN = 256.68496d;
    static final double E50_COASC2_MAX = 618.738596d;
    static final double E50_COASC2_MIN = 283.720808d;
    static final double E50_EQUASC_MAX = 393.49442d;
    static final double E50_EQUASC_MIN = 331.162937d;
    static final double E50_HOUSE10_MAX = 814.745889d;
    static final double E50_HOUSE10_MIN = 256.684961d;
    static final double E50_HOUSE11_MAX = 814.745889d;
    static final double E50_HOUSE11_MIN = 256.684961d;
    static final double E50_HOUSE12_MAX = 814.745889d;
    static final double E50_HOUSE12_MIN = 256.684961d;
    static final double E50_HOUSE1_MAX = 814.745889d;
    static final double E50_HOUSE1_MIN = 256.684961d;
    static final double E50_HOUSE2_MAX = 814.745889d;
    static final double E50_HOUSE2_MIN = 256.684961d;
    static final double E50_HOUSE3_MAX = 814.745889d;
    static final double E50_HOUSE3_MIN = 256.684961d;
    static final double E50_HOUSE4_MAX = 814.745889d;
    static final double E50_HOUSE4_MIN = 256.684961d;
    static final double E50_HOUSE5_MAX = 814.745889d;
    static final double E50_HOUSE5_MIN = 256.684961d;
    static final double E50_HOUSE6_MAX = 814.745889d;
    static final double E50_HOUSE6_MIN = 256.684961d;
    static final double E50_HOUSE7_MAX = 814.745889d;
    static final double E50_HOUSE7_MIN = 256.684961d;
    static final double E50_HOUSE8_MAX = 814.745889d;
    static final double E50_HOUSE8_MIN = 256.684961d;
    static final double E50_HOUSE9_MAX = 814.745889d;
    static final double E50_HOUSE9_MIN = 256.684961d;
    static final double E50_MC_MAX = 393.49442d;
    static final double E50_MC_MIN = 331.162936d;
    static final double E50_POLASC_MAX = 814.74585d;
    static final double E50_POLASC_MIN = 256.68496d;
    static final double E50_VERTEX_MAX = 618.738574d;
    static final double E50_VERTEX_MIN = 283.720804d;
    static final double E60_ARMC_MAX = 360.985931d;
    static final double E60_ARMC_MIN = 360.985828d;
    static final double E60_ASC_MAX = 1583.084164d;
    static final double E60_ASC_MIN = 220.207028d;
    static final double E60_COASC1_MAX = 1583.084212d;
    static final double E60_COASC1_MIN = 220.207025d;
    static final double E60_COASC2_MAX = 524.994891d;
    static final double E60_COASC2_MIN = 304.407972d;
    static final double E60_EQUASC_MAX = 393.49442d;
    static final double E60_EQUASC_MIN = 331.162937d;
    static final double E60_HOUSE10_MAX = 1583.084164d;
    static final double E60_HOUSE10_MIN = 220.207028d;
    static final double E60_HOUSE11_MAX = 1583.084164d;
    static final double E60_HOUSE11_MIN = 220.207028d;
    static final double E60_HOUSE12_MAX = 1583.084164d;
    static final double E60_HOUSE12_MIN = 220.207028d;
    static final double E60_HOUSE1_MAX = 1583.084164d;
    static final double E60_HOUSE1_MIN = 220.207028d;
    static final double E60_HOUSE2_MAX = 1583.084164d;
    static final double E60_HOUSE2_MIN = 220.207028d;
    static final double E60_HOUSE3_MAX = 1583.084164d;
    static final double E60_HOUSE3_MIN = 220.207028d;
    static final double E60_HOUSE4_MAX = 1583.084164d;
    static final double E60_HOUSE4_MIN = 220.207028d;
    static final double E60_HOUSE5_MAX = 1583.084164d;
    static final double E60_HOUSE5_MIN = 220.207028d;
    static final double E60_HOUSE6_MAX = 1583.084164d;
    static final double E60_HOUSE6_MIN = 220.207028d;
    static final double E60_HOUSE7_MAX = 1583.084164d;
    static final double E60_HOUSE7_MIN = 220.207028d;
    static final double E60_HOUSE8_MAX = 1583.084164d;
    static final double E60_HOUSE8_MIN = 220.207028d;
    static final double E60_HOUSE9_MAX = 1583.084164d;
    static final double E60_HOUSE9_MIN = 220.207028d;
    static final double E60_MC_MAX = 393.49442d;
    static final double E60_MC_MIN = 331.162936d;
    static final double E60_POLASC_MAX = 1583.084212d;
    static final double E60_POLASC_MIN = 220.207025d;
    static final double E60_VERTEX_MAX = 524.994878d;
    static final double E60_VERTEX_MIN = 304.407972d;
    static final double E66_ARMC_MAX = 360.985931d;
    static final double E66_ARMC_MIN = 360.985828d;
    static final double E66_ASC_MAX = 15382.763492d;
    static final double E66_ASC_MIN = 180.714519d;
    static final double E66_COASC1_MAX = 15382.960178d;
    static final double E66_COASC1_MIN = 180.714532d;
    static final double E66_COASC2_MAX = 487.697885d;
    static final double E66_COASC2_MIN = 313.998924d;
    static final double E66_EQUASC_MAX = 393.49442d;
    static final double E66_EQUASC_MIN = 331.162937d;
    static final double E66_HOUSE10_MAX = 15382.763492d;
    static final double E66_HOUSE10_MIN = 180.714519d;
    static final double E66_HOUSE11_MAX = 15382.763492d;
    static final double E66_HOUSE11_MIN = 180.714519d;
    static final double E66_HOUSE12_MAX = 15382.763492d;
    static final double E66_HOUSE12_MIN = 180.714519d;
    static final double E66_HOUSE1_MAX = 15382.763492d;
    static final double E66_HOUSE1_MIN = 180.714519d;
    static final double E66_HOUSE2_MAX = 15382.763492d;
    static final double E66_HOUSE2_MIN = 180.714519d;
    static final double E66_HOUSE3_MAX = 15382.763492d;
    static final double E66_HOUSE3_MIN = 180.714519d;
    static final double E66_HOUSE4_MAX = 15382.763492d;
    static final double E66_HOUSE4_MIN = 180.714519d;
    static final double E66_HOUSE5_MAX = 15382.763492d;
    static final double E66_HOUSE5_MIN = 180.714519d;
    static final double E66_HOUSE6_MAX = 15382.763492d;
    static final double E66_HOUSE6_MIN = 180.714519d;
    static final double E66_HOUSE7_MAX = 15382.763492d;
    static final double E66_HOUSE7_MIN = 180.714519d;
    static final double E66_HOUSE8_MAX = 15382.763492d;
    static final double E66_HOUSE8_MIN = 180.714519d;
    static final double E66_HOUSE9_MAX = 15382.763492d;
    static final double E66_HOUSE9_MIN = 180.714519d;
    static final double E66_MC_MAX = 393.49442d;
    static final double E66_MC_MIN = 331.162936d;
    static final double E66_POLASC_MAX = 15382.960178d;
    static final double E66_POLASC_MIN = 180.714532d;
    static final double E66_VERTEX_MAX = 487.697876d;
    static final double E66_VERTEX_MIN = 313.998925d;
    static final double E70_ARMC_MAX = 360.985931d;
    static final double E70_ARMC_MIN = 360.985828d;
    static final double E70_ASC_MAX = 1553150.32968d;
    static final double E70_ASC_MIN = -777600.39302d;
    static final double E70_COASC1_MAX = 1553150.33462d;
    static final double E70_COASC1_MIN = -2066.704127d;
    static final double E70_COASC2_MAX = 467.280896d;
    static final double E70_COASC2_MIN = 319.225068d;
    static final double E70_EQUASC_MAX = 393.49442d;
    static final double E70_EQUASC_MIN = 331.162937d;
    static final double E70_HOUSE10_MAX = 1555199.608408d;
    static final double E70_HOUSE10_MIN = 0.389863d;
    static final double E70_HOUSE11_MAX = 1555199.608408d;
    static final double E70_HOUSE11_MIN = 0.389863d;
    static final double E70_HOUSE12_MAX = 1555199.608408d;
    static final double E70_HOUSE12_MIN = 0.389863d;
    static final double E70_HOUSE1_MAX = 1555199.608408d;
    static final double E70_HOUSE1_MIN = 0.389863d;
    static final double E70_HOUSE2_MAX = 1555199.608408d;
    static final double E70_HOUSE2_MIN = 0.389863d;
    static final double E70_HOUSE3_MAX = 1555199.608408d;
    static final double E70_HOUSE3_MIN = 0.389863d;
    static final double E70_HOUSE4_MAX = 1555199.608408d;
    static final double E70_HOUSE4_MIN = 0.389863d;
    static final double E70_HOUSE5_MAX = 1555199.608408d;
    static final double E70_HOUSE5_MIN = 0.389863d;
    static final double E70_HOUSE6_MAX = 1555199.608408d;
    static final double E70_HOUSE6_MIN = 0.389863d;
    static final double E70_HOUSE7_MAX = 1555199.608408d;
    static final double E70_HOUSE7_MIN = 0.389863d;
    static final double E70_HOUSE8_MAX = 1555199.608408d;
    static final double E70_HOUSE8_MIN = 0.389863d;
    static final double E70_HOUSE9_MAX = 1555199.608408d;
    static final double E70_HOUSE9_MIN = 0.389863d;
    static final double E70_MC_MAX = 393.49442d;
    static final double E70_MC_MIN = 331.162936d;
    static final double E70_POLASC_MAX = 179.610407d;
    static final double E70_POLASC_MIN = -2066.757416d;
    static final double E70_VERTEX_MAX = 467.280888d;
    static final double E70_VERTEX_MIN = 319.22507d;
    static final double E80_ARMC_MAX = 360.985931d;
    static final double E80_ARMC_MIN = 360.985828d;
    static final double E80_ASC_MAX = 1554930.566184d;
    static final double E80_ASC_MIN = -777600.124007d;
    static final double E80_COASC1_MAX = 1554930.566243d;
    static final double E80_COASC1_MIN = -269.995683d;
    static final double E80_COASC2_MAX = 426.089536d;
    static final double E80_COASC2_MIN = 328.169552d;
    static final double E80_EQUASC_MAX = 393.49442d;
    static final double E80_EQUASC_MIN = 331.162937d;
    static final double E80_HOUSE10_MAX = 1555199.876097d;
    static final double E80_HOUSE10_MIN = 0.12375d;
    static final double E80_HOUSE11_MAX = 1555199.876097d;
    static final double E80_HOUSE11_MIN = 0.12375d;
    static final double E80_HOUSE12_MAX = 1555199.876097d;
    static final double E80_HOUSE12_MIN = 0.12375d;
    static final double E80_HOUSE1_MAX = 1555199.876097d;
    static final double E80_HOUSE1_MIN = 0.12375d;
    static final double E80_HOUSE2_MAX = 1555199.876097d;
    static final double E80_HOUSE2_MIN = 0.12375d;
    static final double E80_HOUSE3_MAX = 1555199.876097d;
    static final double E80_HOUSE3_MIN = 0.12375d;
    static final double E80_HOUSE4_MAX = 1555199.876097d;
    static final double E80_HOUSE4_MIN = 0.12375d;
    static final double E80_HOUSE5_MAX = 1555199.876097d;
    static final double E80_HOUSE5_MIN = 0.12375d;
    static final double E80_HOUSE6_MAX = 1555199.876097d;
    static final double E80_HOUSE6_MIN = 0.12375d;
    static final double E80_HOUSE7_MAX = 1555199.876097d;
    static final double E80_HOUSE7_MIN = 0.12375d;
    static final double E80_HOUSE8_MAX = 1555199.876097d;
    static final double E80_HOUSE8_MIN = 0.12375d;
    static final double E80_HOUSE9_MAX = 1555199.876097d;
    static final double E80_HOUSE9_MIN = 0.12375d;
    static final double E80_MC_MAX = 393.49442d;
    static final double E80_MC_MIN = 331.162936d;
    static final double E80_POLASC_MAX = 113.797793d;
    static final double E80_POLASC_MIN = -269.996067d;
    static final double E80_VERTEX_MAX = 426.089531d;
    static final double E80_VERTEX_MIN = 328.16955d;
    static final double E85_ARMC_MAX = 360.985931d;
    static final double E85_ARMC_MIN = 360.985828d;
    static final double E85_ASC_MAX = 1555100.603952d;
    static final double E85_ASC_MIN = -777600.058703d;
    static final double E85_COASC1_MAX = 1555100.603957d;
    static final double E85_COASC1_MIN = -99.544583d;
    static final double E85_COASC2_MAX = 409.019308d;
    static final double E85_COASC2_MIN = 330.413985d;
    static final double E85_EQUASC_MAX = 393.49442d;
    static final double E85_EQUASC_MIN = 331.162937d;
    static final double E85_HOUSE10_MAX = 1555199.941344d;
    static final double E85_HOUSE10_MIN = 0.058615d;
    static final double E85_HOUSE11_MAX = 1555199.941344d;
    static final double E85_HOUSE11_MIN = 0.058615d;
    static final double E85_HOUSE12_MAX = 1555199.941344d;
    static final double E85_HOUSE12_MIN = 0.058615d;
    static final double E85_HOUSE1_MAX = 1555199.941344d;
    static final double E85_HOUSE1_MIN = 0.058615d;
    static final double E85_HOUSE2_MAX = 1555199.941344d;
    static final double E85_HOUSE2_MIN = 0.058615d;
    static final double E85_HOUSE3_MAX = 1555199.941344d;
    static final double E85_HOUSE3_MIN = 0.058615d;
    static final double E85_HOUSE4_MAX = 1555199.941344d;
    static final double E85_HOUSE4_MIN = 0.058615d;
    static final double E85_HOUSE5_MAX = 1555199.941344d;
    static final double E85_HOUSE5_MIN = 0.058615d;
    static final double E85_HOUSE6_MAX = 1555199.941344d;
    static final double E85_HOUSE6_MIN = 0.058615d;
    static final double E85_HOUSE7_MAX = 1555199.941344d;
    static final double E85_HOUSE7_MIN = 0.058615d;
    static final double E85_HOUSE8_MAX = 1555199.941344d;
    static final double E85_HOUSE8_MIN = 0.058615d;
    static final double E85_HOUSE9_MAX = 1555199.941344d;
    static final double E85_HOUSE9_MIN = 0.058615d;
    static final double E85_MC_MAX = 393.49442d;
    static final double E85_MC_MIN = 331.162936d;
    static final double E85_POLASC_MAX = 66.096027d;
    static final double E85_POLASC_MIN = -99.544653d;
    static final double E85_VERTEX_MAX = 409.019306d;
    static final double E85_VERTEX_MIN = 330.413985d;
    static final double E88_ARMC_MAX = 360.985931d;
    static final double E88_ARMC_MIN = 360.985828d;
    static final double E88_ASC_MAX = 1555165.554408d;
    static final double E88_ASC_MIN = -777600.02317d;
    static final double E88_COASC1_MAX = 1555165.554409d;
    static final double E88_COASC1_MIN = -34.489296d;
    static final double E88_COASC2_MAX = 399.547623d;
    static final double E88_COASC2_MIN = 331.043079d;
    static final double E88_EQUASC_MAX = 393.49442d;
    static final double E88_EQUASC_MIN = 331.162937d;
    static final double E88_HOUSE10_MAX = 1555199.976849d;
    static final double E88_HOUSE10_MIN = 0.023142d;
    static final double E88_HOUSE11_MAX = 1555199.976849d;
    static final double E88_HOUSE11_MIN = 0.023142d;
    static final double E88_HOUSE12_MAX = 1555199.976849d;
    static final double E88_HOUSE12_MIN = 0.023142d;
    static final double E88_HOUSE1_MAX = 1555199.976849d;
    static final double E88_HOUSE1_MIN = 0.023142d;
    static final double E88_HOUSE2_MAX = 1555199.976849d;
    static final double E88_HOUSE2_MIN = 0.023142d;
    static final double E88_HOUSE3_MAX = 1555199.976849d;
    static final double E88_HOUSE3_MIN = 0.023142d;
    static final double E88_HOUSE4_MAX = 1555199.976849d;
    static final double E88_HOUSE4_MIN = 0.023142d;
    static final double E88_HOUSE5_MAX = 1555199.976849d;
    static final double E88_HOUSE5_MIN = 0.023142d;
    static final double E88_HOUSE6_MAX = 1555199.976849d;
    static final double E88_HOUSE6_MIN = 0.023142d;
    static final double E88_HOUSE7_MAX = 1555199.976849d;
    static final double E88_HOUSE7_MIN = 0.023142d;
    static final double E88_HOUSE8_MAX = 1555199.976849d;
    static final double E88_HOUSE8_MIN = 0.023142d;
    static final double E88_HOUSE9_MAX = 1555199.976849d;
    static final double E88_HOUSE9_MIN = 0.023142d;
    static final double E88_MC_MAX = 393.49442d;
    static final double E88_MC_MIN = 331.162936d;
    static final double E88_POLASC_MAX = 29.34423d;
    static final double E88_POLASC_MIN = -34.489313d;
    static final double E88_VERTEX_MAX = 399.547621d;
    static final double E88_VERTEX_MIN = 331.043081d;
    static final double E90_ARMC_MAX = 360.985931d;
    static final double E90_ARMC_MIN = 360.985828d;
    static final double E90_ASC_MAX = 1555200.0d;
    static final double E90_ASC_MIN = -777600.0d;
    static final double E90_COASC1_MAX = 1555200.0d;
    static final double E90_COASC1_MIN = -0.0d;
    static final double E90_COASC2_MAX = 393.49442d;
    static final double E90_COASC2_MIN = 331.162937d;
    static final double E90_EQUASC_MAX = 393.49442d;
    static final double E90_EQUASC_MIN = 331.162937d;
    static final double E90_HOUSE10_MAX = 1555200.0d;
    static final double E90_HOUSE10_MIN = 0.0d;
    static final double E90_HOUSE11_MAX = 1555200.0d;
    static final double E90_HOUSE11_MIN = 0.0d;
    static final double E90_HOUSE12_MAX = 1555200.0d;
    static final double E90_HOUSE12_MIN = 0.0d;
    static final double E90_HOUSE1_MAX = 1555200.0d;
    static final double E90_HOUSE1_MIN = 0.0d;
    static final double E90_HOUSE2_MAX = 1555200.0d;
    static final double E90_HOUSE2_MIN = 0.0d;
    static final double E90_HOUSE3_MAX = 1555200.0d;
    static final double E90_HOUSE3_MIN = 0.0d;
    static final double E90_HOUSE4_MAX = 1555200.0d;
    static final double E90_HOUSE4_MIN = 0.0d;
    static final double E90_HOUSE5_MAX = 1555200.0d;
    static final double E90_HOUSE5_MIN = 0.0d;
    static final double E90_HOUSE6_MAX = 1555200.0d;
    static final double E90_HOUSE6_MIN = 0.0d;
    static final double E90_HOUSE7_MAX = 1555200.0d;
    static final double E90_HOUSE7_MIN = 0.0d;
    static final double E90_HOUSE8_MAX = 1555200.0d;
    static final double E90_HOUSE8_MIN = 0.0d;
    static final double E90_HOUSE9_MAX = 1555200.0d;
    static final double E90_HOUSE9_MIN = 0.0d;
    static final double E90_MC_MAX = 393.49442d;
    static final double E90_MC_MIN = 331.162936d;
    static final double E90_POLASC_MAX = 0.0d;
    static final double E90_POLASC_MIN = -0.0d;
    static final double E90_VERTEX_MAX = 393.49442d;
    static final double E90_VERTEX_MIN = 331.162937d;
    static final double G0_ARMC_MAX = 360.985931d;
    static final double G0_ARMC_MIN = 360.985828d;
    static final double G0_ASC_MAX = 393.49442d;
    static final double G0_ASC_MIN = 331.162937d;
    static final double G0_COASC1_MAX = 393.49442d;
    static final double G0_COASC1_MIN = 331.162937d;
    static final double G0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double G0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double G0_EQUASC_MAX = 393.49442d;
    static final double G0_EQUASC_MIN = 331.162937d;
    static final double G0_HOUSE10_MAX = 618069.26865d;
    static final double G0_HOUSE11_MAX = 618069.271879d;
    static final double G0_HOUSE12_MAX = 618069.269675d;
    static final double G0_HOUSE1_MAX = 618069.268986d;
    static final double G0_HOUSE2_MAX = 618069.272193d;
    static final double G0_HOUSE3_MAX = 618069.269514d;
    static final double G0_HOUSE4_MAX = 618069.268981d;
    static final double G0_HOUSE5_MAX = 618069.272083d;
    static final double G0_HOUSE6_MAX = 618069.269644d;
    static final double G0_HOUSE7_MAX = 618069.268869d;
    static final double G0_HOUSE8_MAX = 618069.271867d;
    static final double G0_HOUSE9_MAX = 618069.269698d;
    static final double G0_MC_MAX = 393.49442d;
    static final double G0_MC_MIN = 331.162936d;
    static final double G0_POLASC_MAX = 393.49442d;
    static final double G0_POLASC_MIN = 331.162937d;
    static final double G0_VERTEX_MAX = 777600.0d;
    static final double G0_VERTEX_MIN = -777600.0d;
    static final double G10_ARMC_MAX = 360.985931d;
    static final double G10_ARMC_MIN = 360.985828d;
    static final double G10_ASC_MAX = 426.089536d;
    static final double G10_ASC_MIN = 328.169552d;
    static final double G10_COASC1_MAX = 426.089531d;
    static final double G10_COASC1_MIN = 328.16955d;
    static final double G10_COASC2_MAX = 113.797795d;
    static final double G10_COASC2_MIN = -269.99607d;
    static final double G10_EQUASC_MAX = 393.49442d;
    static final double G10_EQUASC_MIN = 331.162937d;
    static final double G10_HOUSE10_MAX = 625566.05649d;
    static final double G10_HOUSE11_MAX = 625519.156807d;
    static final double G10_HOUSE12_MAX = 625503.499422d;
    static final double G10_HOUSE1_MAX = 626259.230911d;
    static final double G10_HOUSE2_MAX = 622607.544407d;
    static final double G10_HOUSE3_MAX = 618981.972839d;
    static final double G10_HOUSE4_MAX = 622607.550167d;
    static final double G10_HOUSE5_MAX = 626259.235177d;
    static final double G10_HOUSE6_MAX = 626060.954671d;
    static final double G10_HOUSE7_MAX = 625891.938453d;
    static final double G10_HOUSE8_MAX = 625752.799804d;
    static final double G10_HOUSE9_MAX = 625644.037926d;
    static final double G10_MC_MAX = 393.49442d;
    static final double G10_MC_MIN = 331.162936d;
    static final double G10_POLASC_MAX = 426.089531d;
    static final double G10_POLASC_MIN = 328.16955d;
    static final double G10_VERTEX_MAX = 1554930.566243d;
    static final double G10_VERTEX_MIN = -777600.124028d;
    static final double G20_ARMC_MAX = 360.985931d;
    static final double G20_ARMC_MIN = 360.985828d;
    static final double G20_ASC_MAX = 467.280896d;
    static final double G20_ASC_MIN = 319.225068d;
    static final double G20_COASC1_MAX = 467.280888d;
    static final double G20_COASC1_MIN = 319.22507d;
    static final double G20_COASC2_MAX = 179.610407d;
    static final double G20_COASC2_MIN = -2066.7575d;
    static final double G20_EQUASC_MAX = 393.49442d;
    static final double G20_EQUASC_MIN = 331.162937d;
    static final double G20_HOUSE10_MAX = 633757.325623d;
    static final double G20_HOUSE11_MAX = 633591.944009d;
    static final double G20_HOUSE12_MAX = 633536.546825d;
    static final double G20_HOUSE1_MAX = 636105.591001d;
    static final double G20_HOUSE2_MAX = 628862.994299d;
    static final double G20_HOUSE3_MAX = 621813.876521d;
    static final double G20_HOUSE4_MAX = 628862.996048d;
    static final double G20_HOUSE5_MAX = 636105.595255d;
    static final double G20_HOUSE6_MAX = 635451.214241d;
    static final double G20_HOUSE7_MAX = 634882.813844d;
    static final double G20_HOUSE8_MAX = 634407.177802d;
    static final double G20_HOUSE9_MAX = 634030.335144d;
    static final double G20_MC_MAX = 393.49442d;
    static final double G20_MC_MIN = 331.162936d;
    static final double G20_POLASC_MAX = 467.280888d;
    static final double G20_POLASC_MIN = 319.22507d;
    static final double G20_VERTEX_MAX = 1553150.33462d;
    static final double G20_VERTEX_MIN = -777600.393091d;
    static final double G30_ARMC_MAX = 360.985931d;
    static final double G30_ARMC_MIN = 360.985828d;
    static final double G30_ASC_MAX = 524.994891d;
    static final double G30_ASC_MIN = 304.407972d;
    static final double G30_COASC1_MAX = 524.994878d;
    static final double G30_COASC1_MIN = 304.407972d;
    static final double G30_COASC2_MAX = 1583.084164d;
    static final double G30_COASC2_MIN = 220.207028d;
    static final double G30_EQUASC_MAX = 393.49442d;
    static final double G30_EQUASC_MIN = 331.162937d;
    static final double G30_HOUSE10_MAX = 643338.504381d;
    static final double G30_HOUSE11_MAX = 643000.097945d;
    static final double G30_HOUSE12_MAX = 642886.058685d;
    static final double G30_HOUSE1_MAX = 647860.611906d;
    static final double G30_HOUSE2_MAX = 636985.811051d;
    static final double G30_HOUSE3_MAX = 626838.903213d;
    static final double G30_HOUSE4_MAX = 636985.804802d;
    static final double G30_HOUSE5_MAX = 647860.615574d;
    static final double G30_HOUSE6_MAX = 646648.019389d;
    static final double G30_HOUSE7_MAX = 645566.843184d;
    static final double G30_HOUSE8_MAX = 644640.212711d;
    static final double G30_HOUSE9_MAX = 643890.658803d;
    static final double G30_MC_MAX = 393.49442d;
    static final double G30_MC_MIN = 331.162936d;
    static final double G30_POLASC_MAX = 524.994878d;
    static final double G30_POLASC_MIN = 304.407972d;
    static final double G30_VERTEX_MAX = 1583.084212d;
    static final double G30_VERTEX_MIN = 220.207025d;
    static final double G40_ARMC_MAX = 360.985931d;
    static final double G40_ARMC_MIN = 360.985828d;
    static final double G40_ASC_MAX = 618.738596d;
    static final double G40_ASC_MIN = 283.720808d;
    static final double G40_COASC1_MAX = 618.738574d;
    static final double G40_COASC1_MIN = 283.720804d;
    static final double G40_COASC2_MAX = 814.745889d;
    static final double G40_COASC2_MIN = 256.684961d;
    static final double G40_EQUASC_MAX = 393.49442d;
    static final double G40_EQUASC_MIN = 331.162937d;
    static final double G40_HOUSE10_MAX = 655542.982582d;
    static final double G40_HOUSE11_MAX = 654984.466139d;
    static final double G40_HOUSE12_MAX = 654794.496837d;
    static final double G40_HOUSE1_MAX = 662426.923641d;
    static final double G40_HOUSE2_MAX = 647516.608835d;
    static final double G40_HOUSE3_MAX = 634495.596469d;
    static final double G40_HOUSE4_MAX = 647516.602274d;
    static final double G40_HOUSE5_MAX = 662426.924775d;
    static final double G40_HOUSE6_MAX = 660669.275697d;
    static final double G40_HOUSE7_MAX = 659053.150387d;
    static final double G40_HOUSE8_MAX = 657625.757986d;
    static final double G40_HOUSE9_MAX = 656438.527042d;
    static final double G40_MC_MAX = 393.49442d;
    static final double G40_MC_MIN = 331.162936d;
    static final double G40_POLASC_MAX = 618.738574d;
    static final double G40_POLASC_MIN = 283.720804d;
    static final double G40_VERTEX_MAX = 814.74585d;
    static final double G40_VERTEX_MIN = 256.68496d;
    static final double G50_ARMC_MAX = 360.985931d;
    static final double G50_ARMC_MIN = 360.985828d;
    static final double G50_ASC_MAX = 814.745889d;
    static final double G50_ASC_MIN = 256.684961d;
    static final double G50_COASC1_MAX = 814.74585d;
    static final double G50_COASC1_MIN = 256.68496d;
    static final double G50_COASC2_MAX = 618.738596d;
    static final double G50_COASC2_MIN = 283.720808d;
    static final double G50_EQUASC_MAX = 393.49442d;
    static final double G50_EQUASC_MIN = 331.162937d;
    static final double G50_HOUSE10_MAX = 673078.010261d;
    static final double G50_HOUSE11_MAX = 672271.164629d;
    static final double G50_HOUSE12_MAX = 671992.714643d;
    static final double G50_HOUSE1_MAX = 682028.400403d;
    static final double G50_HOUSE2_MAX = 661833.55613d;
    static final double G50_HOUSE3_MAX = 645460.039452d;
    static final double G50_HOUSE4_MAX = 661833.552021d;
    static final double G50_HOUSE5_MAX = 682028.392125d;
    static final double G50_HOUSE6_MAX = 679877.214011d;
    static final double G50_HOUSE7_MAX = 677829.789784d;
    static final double G50_HOUSE8_MAX = 675954.995592d;
    static final double G50_HOUSE9_MAX = 674338.421562d;
    static final double G50_MC_MAX = 393.49442d;
    static final double G50_MC_MIN = 331.162936d;
    static final double G50_POLASC_MAX = 814.74585d;
    static final double G50_POLASC_MIN = 256.68496d;
    static final double G50_VERTEX_MAX = 618.738574d;
    static final double G50_VERTEX_MIN = 283.720804d;
    static final double G60_ARMC_MAX = 360.985931d;
    static final double G60_ARMC_MIN = 360.985828d;
    static final double G60_ASC_MAX = 1583.084164d;
    static final double G60_ASC_MIN = 220.207028d;
    static final double G60_COASC1_MAX = 1583.084212d;
    static final double G60_COASC1_MIN = 220.207025d;
    static final double G60_COASC2_MAX = 524.994891d;
    static final double G60_COASC2_MIN = 304.407972d;
    static final double G60_EQUASC_MAX = 393.49442d;
    static final double G60_EQUASC_MIN = 331.162937d;
    static final double G60_HOUSE10_MAX = 704539.539703d;
    static final double G60_HOUSE11_MAX = 703592.906555d;
    static final double G60_HOUSE12_MAX = 703258.014848d;
    static final double G60_HOUSE1_MAX = 713644.738826d;
    static final double G60_HOUSE2_MAX = 684351.324974d;
    static final double G60_HOUSE3_MAX = 661579.518493d;
    static final double G60_HOUSE4_MAX = 684351.329299d;
    static final double G60_HOUSE5_MAX = 713644.731227d;
    static final double G60_HOUSE6_MAX = 711618.608226d;
    static final double G60_HOUSE7_MAX = 709612.762295d;
    static final double G60_HOUSE8_MAX = 707693.631935d;
    static final double G60_HOUSE9_MAX = 705958.513528d;
    static final double G60_MC_MAX = 393.49442d;
    static final double G60_MC_MIN = 331.162936d;
    static final double G60_POLASC_MAX = 1583.084212d;
    static final double G60_POLASC_MIN = 220.207025d;
    static final double G60_VERTEX_MAX = 524.994878d;
    static final double G60_VERTEX_MIN = 304.407972d;
    static final double G66_ARMC_MAX = 360.985931d;
    static final double G66_ARMC_MIN = 360.985828d;
    static final double G66_ASC_MAX = 15382.763492d;
    static final double G66_ASC_MIN = 180.714519d;
    static final double G66_COASC1_MAX = 15382.960178d;
    static final double G66_COASC1_MIN = 180.714532d;
    static final double G66_COASC2_MAX = 487.697885d;
    static final double G66_COASC2_MIN = 313.998924d;
    static final double G66_EQUASC_MAX = 393.49442d;
    static final double G66_EQUASC_MIN = 331.162937d;
    static final double G66_HOUSE10_MAX = 754716.060187d;
    static final double G66_HOUSE11_MAX = 754299.736921d;
    static final double G66_HOUSE12_MAX = 754148.73999d;
    static final double G66_HOUSE1_MAX = 758295.347687d;
    static final double G66_HOUSE2_MAX = 715025.938248d;
    static final double G66_HOUSE3_MAX = 680264.439391d;
    static final double G66_HOUSE4_MAX = 715025.943727d;
    static final double G66_HOUSE5_MAX = 758295.323647d;
    static final double G66_HOUSE6_MAX = 757541.363295d;
    static final double G66_HOUSE7_MAX = 756776.012625d;
    static final double G66_HOUSE8_MAX = 756022.464545d;
    static final double G66_HOUSE9_MAX = 755316.703909d;
    static final double G66_MC_MAX = 393.49442d;
    static final double G66_MC_MIN = 331.162936d;
    static final double G66_POLASC_MAX = 15382.960178d;
    static final double G66_POLASC_MIN = 180.714532d;
    static final double G66_VERTEX_MAX = 487.697876d;
    static final double G66_VERTEX_MIN = 313.998925d;
    static final double H0_ARMC_MAX = 360.985929d;
    static final double H0_ARMC_MIN = 360.985828d;
    static final double H0_ASC_MAX = 393.49442d;
    static final double H0_ASC_MIN = 331.162937d;
    static final double H0_COASC1_MAX = 393.49442d;
    static final double H0_COASC1_MIN = 331.162937d;
    static final double H0_COASC2_MAX = 1555200.0d;
    static final double H0_COASC2_MIN = -0.0d;
    static final double H0_EQUASC_MAX = 393.49442d;
    static final double H0_EQUASC_MIN = 331.162937d;
    static final double H0_HOUSE10_MAX = 393.49442d;
    static final double H0_HOUSE10_MIN = 331.162936d;
    static final double H0_HOUSE11_MAX = 524.994882d;
    static final double H0_HOUSE11_MIN = 304.407971d;
    static final double H0_HOUSE12_MAX = 1583.083669d;
    static final double H0_HOUSE12_MIN = 220.207025d;
    static final double H0_HOUSE1_MAX = 1555200.0d;
    static final double H0_HOUSE1_MIN = 0.0d;
    static final double H0_HOUSE2_MAX = 1583.084379d;
    static final double H0_HOUSE2_MIN = 220.207028d;
    static final double H0_HOUSE3_MAX = 524.994889d;
    static final double H0_HOUSE3_MIN = 304.407971d;
    static final double H0_HOUSE4_MAX = 393.49442d;
    static final double H0_HOUSE4_MIN = 331.162936d;
    static final double H0_HOUSE5_MAX = 524.994882d;
    static final double H0_HOUSE5_MIN = 304.407971d;
    static final double H0_HOUSE6_MAX = 1583.083669d;
    static final double H0_HOUSE6_MIN = 220.207025d;
    static final double H0_HOUSE7_MAX = 1555200.0d;
    static final double H0_HOUSE7_MIN = 0.0d;
    static final double H0_HOUSE8_MAX = 1583.084379d;
    static final double H0_HOUSE8_MIN = 220.207028d;
    static final double H0_HOUSE9_MAX = 524.994889d;
    static final double H0_HOUSE9_MIN = 304.407971d;
    static final double H0_MC_MAX = 393.49442d;
    static final double H0_MC_MIN = 331.162936d;
    static final double H0_POLASC_MAX = 393.49442d;
    static final double H0_POLASC_MIN = 331.162937d;
    static final double H0_VERTEX_MAX = 777600.0d;
    static final double H0_VERTEX_MIN = -0.0d;
    static final double H10_ARMC_MAX = 360.985931d;
    static final double H10_ARMC_MIN = 360.985828d;
    static final double H10_ASC_MAX = 426.089536d;
    static final double H10_ASC_MIN = 328.169552d;
    static final double H10_COASC1_MAX = 426.089531d;
    static final double H10_COASC1_MIN = 328.16955d;
    static final double H10_COASC2_MAX = 113.797795d;
    static final double H10_COASC2_MIN = -269.99607d;
    static final double H10_EQUASC_MAX = 393.49442d;
    static final double H10_EQUASC_MIN = 331.162937d;
    static final double H10_HOUSE10_MAX = 393.49442d;
    static final double H10_HOUSE10_MIN = 331.162936d;
    static final double H10_HOUSE11_MAX = 521.491146d;
    static final double H10_HOUSE11_MIN = 305.289673d;
    static final double H10_HOUSE12_MAX = 1350.649613d;
    static final double H10_HOUSE12_MIN = 226.579051d;
    static final double H10_HOUSE1_MAX = 1555199.999999d;
    static final double H10_HOUSE1_MIN = 1.0E-6d;
    static final double H10_HOUSE2_MAX = 1350.648027d;
    static final double H10_HOUSE2_MIN = 226.579047d;
    static final double H10_HOUSE3_MAX = 521.49115d;
    static final double H10_HOUSE3_MIN = 305.289672d;
    static final double H10_HOUSE4_MAX = 393.49442d;
    static final double H10_HOUSE4_MIN = 331.162936d;
    static final double H10_HOUSE5_MAX = 521.491146d;
    static final double H10_HOUSE5_MIN = 305.289673d;
    static final double H10_HOUSE6_MAX = 1350.649613d;
    static final double H10_HOUSE6_MIN = 226.579051d;
    static final double H10_HOUSE7_MAX = 1555199.999999d;
    static final double H10_HOUSE7_MIN = 1.0E-6d;
    static final double H10_HOUSE8_MAX = 1350.648027d;
    static final double H10_HOUSE8_MIN = 226.579047d;
    static final double H10_HOUSE9_MAX = 521.49115d;
    static final double H10_HOUSE9_MIN = 305.289672d;
    static final double H10_MC_MAX = 393.49442d;
    static final double H10_MC_MIN = 331.162936d;
    static final double H10_POLASC_MAX = 426.089531d;
    static final double H10_POLASC_MIN = 328.16955d;
    static final double H10_VERTEX_MAX = 1554930.566243d;
    static final double H10_VERTEX_MIN = -777600.124028d;
    static final double H20_ARMC_MAX = 360.985931d;
    static final double H20_ARMC_MIN = 360.985828d;
    static final double H20_ASC_MAX = 467.280896d;
    static final double H20_ASC_MIN = 319.225068d;
    static final double H20_COASC1_MAX = 467.280888d;
    static final double H20_COASC1_MIN = 319.22507d;
    static final double H20_COASC2_MAX = 179.610407d;
    static final double H20_COASC2_MIN = -2066.7575d;
    static final double H20_EQUASC_MAX = 393.49442d;
    static final double H20_EQUASC_MIN = 331.162937d;
    static final double H20_HOUSE10_MAX = 393.49442d;
    static final double H20_HOUSE10_MIN = 331.162936d;
    static final double H20_HOUSE11_MAX = 511.63953d;
    static final double H20_HOUSE11_MIN = 307.797905d;
    static final double H20_HOUSE12_MAX = 1002.589923d;
    static final double H20_HOUSE12_MIN = 242.015106d;
    static final double H20_HOUSE1_MAX = 1555199.99999d;
    static final double H20_HOUSE1_MIN = 4.0E-6d;
    static final double H20_HOUSE2_MAX = 1002.590468d;
    static final double H20_HOUSE2_MIN = 242.015108d;
    static final double H20_HOUSE3_MAX = 511.639579d;
    static final double H20_HOUSE3_MIN = 307.79791d;
    static final double H20_HOUSE4_MAX = 393.49442d;
    static final double H20_HOUSE4_MIN = 331.162936d;
    static final double H20_HOUSE5_MAX = 511.63953d;
    static final double H20_HOUSE5_MIN = 307.797905d;
    static final double H20_HOUSE6_MAX = 1002.589923d;
    static final double H20_HOUSE6_MIN = 242.015106d;
    static final double H20_HOUSE7_MAX = 1555199.99999d;
    static final double H20_HOUSE7_MIN = 4.0E-6d;
    static final double H20_HOUSE8_MAX = 1002.590468d;
    static final double H20_HOUSE8_MIN = 242.015108d;
    static final double H20_HOUSE9_MAX = 511.639579d;
    static final double H20_HOUSE9_MIN = 307.79791d;
    static final double H20_MC_MAX = 393.49442d;
    static final double H20_MC_MIN = 331.162936d;
    static final double H20_POLASC_MAX = 467.280888d;
    static final double H20_POLASC_MIN = 319.22507d;
    static final double H20_VERTEX_MAX = 1553150.33462d;
    static final double H20_VERTEX_MIN = -777600.393091d;
    static final double H30_ARMC_MAX = 360.985931d;
    static final double H30_ARMC_MIN = 360.985828d;
    static final double H30_ASC_MAX = 524.994891d;
    static final double H30_ASC_MIN = 304.407972d;
    static final double H30_COASC1_MAX = 524.994878d;
    static final double H30_COASC1_MIN = 304.407972d;
    static final double H30_COASC2_MAX = 1583.084164d;
    static final double H30_COASC2_MIN = 220.207028d;
    static final double H30_EQUASC_MAX = 393.49442d;
    static final double H30_EQUASC_MIN = 331.162937d;
    static final double H30_HOUSE10_MAX = 393.49442d;
    static final double H30_HOUSE10_MIN = 331.162936d;
    static final double H30_HOUSE11_MAX = 497.094652d;
    static final double H30_HOUSE11_MIN = 311.55717d;
    static final double H30_HOUSE12_MAX = 774.491553d;
    static final double H30_HOUSE12_MIN = 260.934856d;
    static final double H30_HOUSE1_MAX = 1583.084212d;
    static final double H30_HOUSE1_MIN = 220.207025d;
    static final double H30_HOUSE2_MAX = 774.491349d;
    static final double H30_HOUSE2_MIN = 260.934858d;
    static final double H30_HOUSE3_MAX = 497.0947d;
    static final double H30_HOUSE3_MIN = 311.557167d;
    static final double H30_HOUSE4_MAX = 393.49442d;
    static final double H30_HOUSE4_MIN = 331.162936d;
    static final double H30_HOUSE5_MAX = 497.094652d;
    static final double H30_HOUSE5_MIN = 311.55717d;
    static final double H30_HOUSE6_MAX = 774.491553d;
    static final double H30_HOUSE6_MIN = 260.934856d;
    static final double H30_HOUSE7_MAX = 1583.084212d;
    static final double H30_HOUSE7_MIN = 220.207025d;
    static final double H30_HOUSE8_MAX = 774.491349d;
    static final double H30_HOUSE8_MIN = 260.934858d;
    static final double H30_HOUSE9_MAX = 497.0947d;
    static final double H30_HOUSE9_MIN = 311.557167d;
    static final double H30_MC_MAX = 393.49442d;
    static final double H30_MC_MIN = 331.162936d;
    static final double H30_POLASC_MAX = 524.994878d;
    static final double H30_POLASC_MIN = 304.407972d;
    static final double H30_VERTEX_MAX = 1583.084212d;
    static final double H30_VERTEX_MIN = 220.207025d;
    static final double H40_ARMC_MAX = 360.985931d;
    static final double H40_ARMC_MIN = 360.985828d;
    static final double H40_ASC_MAX = 618.738596d;
    static final double H40_ASC_MIN = 283.720808d;
    static final double H40_COASC1_MAX = 618.738574d;
    static final double H40_COASC1_MIN = 283.720804d;
    static final double H40_COASC2_MAX = 814.745889d;
    static final double H40_COASC2_MIN = 256.684961d;
    static final double H40_EQUASC_MAX = 393.49442d;
    static final double H40_EQUASC_MIN = 331.162937d;
    static final double H40_HOUSE10_MAX = 393.49442d;
    static final double H40_HOUSE10_MIN = 331.162936d;
    static final double H40_HOUSE11_MAX = 479.806955d;
    static final double H40_HOUSE11_MIN = 316.040367d;
    static final double H40_HOUSE12_MAX = 639.467581d;
    static final double H40_HOUSE12_MIN = 279.945759d;
    static final double H40_HOUSE1_MAX = 814.74585d;
    static final double H40_HOUSE1_MIN = 256.68496d;
    static final double H40_HOUSE2_MAX = 639.467472d;
    static final double H40_HOUSE2_MIN = 279.945753d;
    static final double H40_HOUSE3_MAX = 479.806987d;
    static final double H40_HOUSE3_MIN = 316.040361d;
    static final double H40_HOUSE4_MAX = 393.49442d;
    static final double H40_HOUSE4_MIN = 331.162936d;
    static final double H40_HOUSE5_MAX = 479.806955d;
    static final double H40_HOUSE5_MIN = 316.040367d;
    static final double H40_HOUSE6_MAX = 639.467581d;
    static final double H40_HOUSE6_MIN = 279.945759d;
    static final double H40_HOUSE7_MAX = 814.74585d;
    static final double H40_HOUSE7_MIN = 256.68496d;
    static final double H40_HOUSE8_MAX = 639.467472d;
    static final double H40_HOUSE8_MIN = 279.945753d;
    static final double H40_HOUSE9_MAX = 479.806987d;
    static final double H40_HOUSE9_MIN = 316.040361d;
    static final double H40_MC_MAX = 393.49442d;
    static final double H40_MC_MIN = 331.162936d;
    static final double H40_POLASC_MAX = 618.738574d;
    static final double H40_POLASC_MIN = 283.720804d;
    static final double H40_VERTEX_MAX = 814.74585d;
    static final double H40_VERTEX_MIN = 256.68496d;
    static final double H50_ARMC_MAX = 360.985931d;
    static final double H50_ARMC_MIN = 360.985828d;
    static final double H50_ASC_MAX = 814.745889d;
    static final double H50_ASC_MIN = 256.684961d;
    static final double H50_COASC1_MAX = 814.74585d;
    static final double H50_COASC1_MIN = 256.68496d;
    static final double H50_COASC2_MAX = 618.738596d;
    static final double H50_COASC2_MIN = 283.720808d;
    static final double H50_EQUASC_MAX = 393.49442d;
    static final double H50_EQUASC_MIN = 331.162937d;
    static final double H50_HOUSE10_MAX = 393.49442d;
    static final double H50_HOUSE10_MIN = 331.162936d;
    static final double H50_HOUSE11_MAX = 461.439867d;
    static final double H50_HOUSE11_MIN = 320.669d;
    static final double H50_HOUSE12_MAX = 554.777132d;
    static final double H50_HOUSE12_MIN = 297.194478d;
    static final double H50_HOUSE1_MAX = 618.738574d;
    static final double H50_HOUSE1_MIN = 283.720804d;
    static final double H50_HOUSE2_MAX = 554.777091d;
    static final double H50_HOUSE2_MIN = 297.194474d;
    static final double H50_HOUSE3_MAX = 461.439869d;
    static final double H50_HOUSE3_MIN = 320.668998d;
    static final double H50_HOUSE4_MAX = 393.49442d;
    static final double H50_HOUSE4_MIN = 331.162936d;
    static final double H50_HOUSE5_MAX = 461.439867d;
    static final double H50_HOUSE5_MIN = 320.669d;
    static final double H50_HOUSE6_MAX = 554.777132d;
    static final double H50_HOUSE6_MIN = 297.194478d;
    static final double H50_HOUSE7_MAX = 618.738574d;
    static final double H50_HOUSE7_MIN = 283.720804d;
    static final double H50_HOUSE8_MAX = 554.777091d;
    static final double H50_HOUSE8_MIN = 297.194474d;
    static final double H50_HOUSE9_MAX = 461.439869d;
    static final double H50_HOUSE9_MIN = 320.668998d;
    static final double H50_MC_MAX = 393.49442d;
    static final double H50_MC_MIN = 331.162936d;
    static final double H50_POLASC_MAX = 814.74585d;
    static final double H50_POLASC_MIN = 256.68496d;
    static final double H50_VERTEX_MAX = 618.738574d;
    static final double H50_VERTEX_MIN = 283.720804d;
    static final double H60_ARMC_MAX = 360.985931d;
    static final double H60_ARMC_MIN = 360.985828d;
    static final double H60_ASC_MAX = 1583.084164d;
    static final double H60_ASC_MIN = 220.207028d;
    static final double H60_COASC1_MAX = 1583.084212d;
    static final double H60_COASC1_MIN = 220.207025d;
    static final double H60_COASC2_MAX = 524.994891d;
    static final double H60_COASC2_MIN = 304.407972d;
    static final double H60_EQUASC_MAX = 393.49442d;
    static final double H60_EQUASC_MIN = 331.162937d;
    static final double H60_HOUSE10_MAX = 393.49442d;
    static final double H60_HOUSE10_MIN = 331.162936d;
    static final double H60_HOUSE11_MAX = 443.133249d;
    static final double H60_HOUSE11_MIN = 324.895991d;
    static final double H60_HOUSE12_MAX = 497.094683d;
    static final double H60_HOUSE12_MIN = 311.557166d;
    static final double H60_HOUSE1_MAX = 524.994878d;
    static final double H60_HOUSE1_MIN = 304.407972d;
    static final double H60_HOUSE2_MAX = 497.094708d;
    static final double H60_HOUSE2_MIN = 311.557167d;
    static final double H60_HOUSE3_MAX = 443.133258d;
    static final double H60_HOUSE3_MIN = 324.895996d;
    static final double H60_HOUSE4_MAX = 393.49442d;
    static final double H60_HOUSE4_MIN = 331.162936d;
    static final double H60_HOUSE5_MAX = 443.133249d;
    static final double H60_HOUSE5_MIN = 324.895991d;
    static final double H60_HOUSE6_MAX = 497.094683d;
    static final double H60_HOUSE6_MIN = 311.557166d;
    static final double H60_HOUSE7_MAX = 524.994878d;
    static final double H60_HOUSE7_MIN = 304.407972d;
    static final double H60_HOUSE8_MAX = 497.094708d;
    static final double H60_HOUSE8_MIN = 311.557167d;
    static final double H60_HOUSE9_MAX = 443.133258d;
    static final double H60_HOUSE9_MIN = 324.895996d;
    static final double H60_MC_MAX = 393.49442d;
    static final double H60_MC_MIN = 331.162936d;
    static final double H60_POLASC_MAX = 1583.084212d;
    static final double H60_POLASC_MIN = 220.207025d;
    static final double H60_VERTEX_MAX = 524.994878d;
    static final double H60_VERTEX_MIN = 304.407972d;
    static final double H66_ARMC_MAX = 360.985931d;
    static final double H66_ARMC_MIN = 360.985828d;
    static final double H66_ASC_MAX = 15382.763492d;
    static final double H66_ASC_MIN = 180.714519d;
    static final double H66_COASC1_MAX = 15382.960178d;
    static final double H66_COASC1_MIN = 180.714532d;
    static final double H66_COASC2_MAX = 487.697885d;
    static final double H66_COASC2_MIN = 313.998924d;
    static final double H66_EQUASC_MAX = 393.49442d;
    static final double H66_EQUASC_MIN = 331.162937d;
    static final double H66_HOUSE10_MAX = 393.49442d;
    static final double H66_HOUSE10_MIN = 331.162936d;
    static final double H66_HOUSE11_MAX = 432.465199d;
    static final double H66_HOUSE11_MIN = 327.04308d;
    static final double H66_HOUSE12_MAX = 470.284291d;
    static final double H66_HOUSE12_MIN = 318.470681d;
    static final double H66_HOUSE1_MAX = 487.697876d;
    static final double H66_HOUSE1_MIN = 313.998925d;
    static final double H66_HOUSE2_MAX = 470.284305d;
    static final double H66_HOUSE2_MIN = 318.470679d;
    static final double H66_HOUSE3_MAX = 432.465219d;
    static final double H66_HOUSE3_MIN = 327.043088d;
    static final double H66_HOUSE4_MAX = 393.49442d;
    static final double H66_HOUSE4_MIN = 331.162936d;
    static final double H66_HOUSE5_MAX = 432.465199d;
    static final double H66_HOUSE5_MIN = 327.04308d;
    static final double H66_HOUSE6_MAX = 470.284291d;
    static final double H66_HOUSE6_MIN = 318.470681d;
    static final double H66_HOUSE7_MAX = 487.697876d;
    static final double H66_HOUSE7_MIN = 313.998925d;
    static final double H66_HOUSE8_MAX = 470.284305d;
    static final double H66_HOUSE8_MIN = 318.470679d;
    static final double H66_HOUSE9_MAX = 432.465219d;
    static final double H66_HOUSE9_MIN = 327.043088d;
    static final double H66_MC_MAX = 393.49442d;
    static final double H66_MC_MIN = 331.162936d;
    static final double H66_POLASC_MAX = 15382.960178d;
    static final double H66_POLASC_MIN = 180.714532d;
    static final double H66_VERTEX_MAX = 487.697876d;
    static final double H66_VERTEX_MIN = 313.998925d;
    static final double H70_ARMC_MAX = 360.985931d;
    static final double H70_ARMC_MIN = 360.985828d;
    static final double H70_ASC_MAX = 179.610407d;
    static final double H70_ASC_MIN = -2066.7575d;
    static final double H70_COASC1_MAX = 1553150.33462d;
    static final double H70_COASC1_MIN = -2066.704127d;
    static final double H70_COASC2_MAX = 467.280896d;
    static final double H70_COASC2_MIN = 319.225068d;
    static final double H70_EQUASC_MAX = 393.49442d;
    static final double H70_EQUASC_MIN = 331.162937d;
    static final double H70_HOUSE10_MAX = 393.49442d;
    static final double H70_HOUSE10_MIN = 331.162936d;
    static final double H70_HOUSE11_MAX = 425.537745d;
    static final double H70_HOUSE11_MIN = 328.260618d;
    static final double H70_HOUSE12_MAX = 454.665522d;
    static final double H70_HOUSE12_MIN = 322.294821d;
    static final double H70_HOUSE1_MAX = 467.280888d;
    static final double H70_HOUSE1_MIN = 319.22507d;
    static final double H70_HOUSE2_MAX = 454.665495d;
    static final double H70_HOUSE2_MIN = 322.294812d;
    static final double H70_HOUSE3_MAX = 425.537759d;
    static final double H70_HOUSE3_MIN = 328.260625d;
    static final double H70_HOUSE4_MAX = 393.49442d;
    static final double H70_HOUSE4_MIN = 331.162936d;
    static final double H70_HOUSE5_MAX = 425.537745d;
    static final double H70_HOUSE5_MIN = 328.260618d;
    static final double H70_HOUSE6_MAX = 454.665522d;
    static final double H70_HOUSE6_MIN = 322.294821d;
    static final double H70_HOUSE7_MAX = 467.280888d;
    static final double H70_HOUSE7_MIN = 319.22507d;
    static final double H70_HOUSE8_MAX = 454.665495d;
    static final double H70_HOUSE8_MIN = 322.294812d;
    static final double H70_HOUSE9_MAX = 425.537759d;
    static final double H70_HOUSE9_MIN = 328.260625d;
    static final double H70_MC_MAX = 393.49442d;
    static final double H70_MC_MIN = 331.162936d;
    static final double H70_POLASC_MAX = 179.610407d;
    static final double H70_POLASC_MIN = -2066.757416d;
    static final double H70_VERTEX_MAX = 467.280888d;
    static final double H70_VERTEX_MIN = 319.22507d;
    static final double H80_ARMC_MAX = 360.985931d;
    static final double H80_ARMC_MIN = 360.985828d;
    static final double H80_ASC_MAX = 113.797795d;
    static final double H80_ASC_MIN = -269.99607d;
    static final double H80_COASC1_MAX = 1554930.566243d;
    static final double H80_COASC1_MIN = -269.995683d;
    static final double H80_COASC2_MAX = 426.089536d;
    static final double H80_COASC2_MIN = 328.169552d;
    static final double H80_EQUASC_MAX = 393.49442d;
    static final double H80_EQUASC_MIN = 331.162937d;
    static final double H80_HOUSE10_MAX = 393.49442d;
    static final double H80_HOUSE10_MIN = 331.162936d;
    static final double H80_HOUSE11_MAX = 408.957437d;
    static final double H80_HOUSE11_MIN = 330.419686d;
    static final double H80_HOUSE12_MAX = 421.297286d;
    static final double H80_HOUSE12_MIN = 328.923043d;
    static final double H80_HOUSE1_MAX = 426.089531d;
    static final double H80_HOUSE1_MIN = 328.16955d;
    static final double H80_HOUSE2_MAX = 421.297279d;
    static final double H80_HOUSE2_MIN = 328.923047d;
    static final double H80_HOUSE3_MAX = 408.957435d;
    static final double H80_HOUSE3_MIN = 330.419688d;
    static final double H80_HOUSE4_MAX = 393.49442d;
    static final double H80_HOUSE4_MIN = 331.162936d;
    static final double H80_HOUSE5_MAX = 408.957437d;
    static final double H80_HOUSE5_MIN = 330.419686d;
    static final double H80_HOUSE6_MAX = 421.297286d;
    static final double H80_HOUSE6_MIN = 328.923043d;
    static final double H80_HOUSE7_MAX = 426.089531d;
    static final double H80_HOUSE7_MIN = 328.16955d;
    static final double H80_HOUSE8_MAX = 421.297279d;
    static final double H80_HOUSE8_MIN = 328.923047d;
    static final double H80_HOUSE9_MAX = 408.957435d;
    static final double H80_HOUSE9_MIN = 330.419688d;
    static final double H80_MC_MAX = 393.49442d;
    static final double H80_MC_MIN = 331.162936d;
    static final double H80_POLASC_MAX = 113.797793d;
    static final double H80_POLASC_MIN = -269.996067d;
    static final double H80_VERTEX_MAX = 426.089531d;
    static final double H80_VERTEX_MIN = 328.16955d;
    static final double H85_ARMC_MAX = 360.985931d;
    static final double H85_ARMC_MIN = 360.985828d;
    static final double H85_ASC_MAX = 66.096028d;
    static final double H85_ASC_MIN = -99.54465d;
    static final double H85_COASC1_MAX = 1555100.603957d;
    static final double H85_COASC1_MIN = -99.544583d;
    static final double H85_COASC2_MAX = 409.019308d;
    static final double H85_COASC2_MIN = 330.413985d;
    static final double H85_EQUASC_MAX = 393.49442d;
    static final double H85_EQUASC_MIN = 331.162937d;
    static final double H85_HOUSE10_MAX = 393.49442d;
    static final double H85_HOUSE10_MIN = 331.162936d;
    static final double H85_HOUSE11_MAX = 401.084516d;
    static final double H85_HOUSE11_MIN = 330.976019d;
    static final double H85_HOUSE12_MAX = 406.855456d;
    static final double H85_HOUSE12_MIN = 330.601543d;
    static final double H85_HOUSE1_MAX = 409.019306d;
    static final double H85_HOUSE1_MIN = 330.413985d;
    static final double H85_HOUSE2_MAX = 406.855463d;
    static final double H85_HOUSE2_MIN = 330.601551d;
    static final double H85_HOUSE3_MAX = 401.084523d;
    static final double H85_HOUSE3_MIN = 330.976014d;
    static final double H85_HOUSE4_MAX = 393.49442d;
    static final double H85_HOUSE4_MIN = 331.162936d;
    static final double H85_HOUSE5_MAX = 401.084516d;
    static final double H85_HOUSE5_MIN = 330.976019d;
    static final double H85_HOUSE6_MAX = 406.855456d;
    static final double H85_HOUSE6_MIN = 330.601543d;
    static final double H85_HOUSE7_MAX = 409.019306d;
    static final double H85_HOUSE7_MIN = 330.413985d;
    static final double H85_HOUSE8_MAX = 406.855463d;
    static final double H85_HOUSE8_MIN = 330.601551d;
    static final double H85_HOUSE9_MAX = 401.084523d;
    static final double H85_HOUSE9_MIN = 330.976014d;
    static final double H85_MC_MAX = 393.49442d;
    static final double H85_MC_MIN = 331.162936d;
    static final double H85_POLASC_MAX = 66.096027d;
    static final double H85_POLASC_MIN = -99.544653d;
    static final double H85_VERTEX_MAX = 409.019306d;
    static final double H85_VERTEX_MIN = 330.413985d;
    static final double H88_ARMC_MAX = 360.985931d;
    static final double H88_ARMC_MIN = 360.985828d;
    static final double H88_ASC_MAX = 29.344231d;
    static final double H88_ASC_MIN = -34.489311d;
    static final double H88_COASC1_MAX = 1555165.554409d;
    static final double H88_COASC1_MIN = -34.489296d;
    static final double H88_COASC2_MAX = 399.547623d;
    static final double H88_COASC2_MIN = 331.043079d;
    static final double H88_EQUASC_MAX = 393.49442d;
    static final double H88_EQUASC_MIN = 331.162937d;
    static final double H88_HOUSE10_MAX = 393.49442d;
    static final double H88_HOUSE10_MIN = 331.162936d;
    static final double H88_HOUSE11_MAX = 396.496529d;
    static final double H88_HOUSE11_MIN = 331.132982d;
    static final double H88_HOUSE12_MAX = 398.72505d;
    static final double H88_HOUSE12_MIN = 331.073048d;
    static final double H88_HOUSE1_MAX = 399.547621d;
    static final double H88_HOUSE1_MIN = 331.043081d;
    static final double H88_HOUSE2_MAX = 398.725059d;
    static final double H88_HOUSE2_MIN = 331.073058d;
    static final double H88_HOUSE3_MAX = 396.496538d;
    static final double H88_HOUSE3_MIN = 331.132983d;
    static final double H88_HOUSE4_MAX = 393.49442d;
    static final double H88_HOUSE4_MIN = 331.162936d;
    static final double H88_HOUSE5_MAX = 396.496529d;
    static final double H88_HOUSE5_MIN = 331.132982d;
    static final double H88_HOUSE6_MAX = 398.72505d;
    static final double H88_HOUSE6_MIN = 331.073048d;
    static final double H88_HOUSE7_MAX = 399.547621d;
    static final double H88_HOUSE7_MIN = 331.043081d;
    static final double H88_HOUSE8_MAX = 398.725059d;
    static final double H88_HOUSE8_MIN = 331.073058d;
    static final double H88_HOUSE9_MAX = 396.496538d;
    static final double H88_HOUSE9_MIN = 331.132983d;
    static final double H88_MC_MAX = 393.49442d;
    static final double H88_MC_MIN = 331.162936d;
    static final double H88_POLASC_MAX = 29.34423d;
    static final double H88_POLASC_MIN = -34.489313d;
    static final double H88_VERTEX_MAX = 399.547621d;
    static final double H88_VERTEX_MIN = 331.043081d;
    static final double H90_ARMC_MAX = 360.985931d;
    static final double H90_ARMC_MIN = 360.985828d;
    static final double H90_ASC_MAX = 0.0d;
    static final double H90_ASC_MIN = -0.0d;
    static final double H90_COASC1_MAX = 1555200.0d;
    static final double H90_COASC1_MIN = -0.0d;
    static final double H90_COASC2_MAX = 393.49442d;
    static final double H90_COASC2_MIN = 331.162937d;
    static final double H90_EQUASC_MAX = 393.49442d;
    static final double H90_EQUASC_MIN = 331.162937d;
    static final double H90_HOUSE10_MAX = 393.49442d;
    static final double H90_HOUSE10_MIN = 331.162936d;
    static final double H90_HOUSE11_MAX = 393.49442d;
    static final double H90_HOUSE11_MIN = 331.162936d;
    static final double H90_HOUSE12_MAX = 393.49442d;
    static final double H90_HOUSE12_MIN = 331.162937d;
    static final double H90_HOUSE1_MAX = 393.49442d;
    static final double H90_HOUSE1_MIN = 331.162937d;
    static final double H90_HOUSE2_MAX = 393.49442d;
    static final double H90_HOUSE2_MIN = 331.162937d;
    static final double H90_HOUSE3_MAX = 393.494421d;
    static final double H90_HOUSE3_MIN = 331.162936d;
    static final double H90_HOUSE4_MAX = 393.49442d;
    static final double H90_HOUSE4_MIN = 331.162936d;
    static final double H90_HOUSE5_MAX = 393.49442d;
    static final double H90_HOUSE5_MIN = 331.162936d;
    static final double H90_HOUSE6_MAX = 393.49442d;
    static final double H90_HOUSE6_MIN = 331.162937d;
    static final double H90_HOUSE7_MAX = 393.49442d;
    static final double H90_HOUSE7_MIN = 331.162937d;
    static final double H90_HOUSE8_MAX = 393.49442d;
    static final double H90_HOUSE8_MIN = 331.162937d;
    static final double H90_HOUSE9_MAX = 393.494421d;
    static final double H90_HOUSE9_MIN = 331.162936d;
    static final double H90_MC_MAX = 393.49442d;
    static final double H90_MC_MIN = 331.162936d;
    static final double H90_POLASC_MAX = 0.0d;
    static final double H90_POLASC_MIN = -0.0d;
    static final double H90_VERTEX_MAX = 393.49442d;
    static final double H90_VERTEX_MIN = 331.162937d;
    static final double K0_ARMC_MAX = 360.985931d;
    static final double K0_ARMC_MIN = 360.985828d;
    static final double K0_ASC_MAX = 393.49442d;
    static final double K0_ASC_MIN = 331.162937d;
    static final double K0_COASC1_MAX = 393.49442d;
    static final double K0_COASC1_MIN = 331.162937d;
    static final double K0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K0_EQUASC_MAX = 393.49442d;
    static final double K0_EQUASC_MIN = 331.162937d;
    static final double K0_HOUSE10_MAX = 393.49442d;
    static final double K0_HOUSE10_MIN = 331.162936d;
    static final double K0_HOUSE11_MAX = 393.49442d;
    static final double K0_HOUSE11_MIN = 331.162936d;
    static final double K0_HOUSE12_MAX = 393.49442d;
    static final double K0_HOUSE12_MIN = 331.162937d;
    static final double K0_HOUSE1_MAX = 393.49442d;
    static final double K0_HOUSE1_MIN = 331.162937d;
    static final double K0_HOUSE2_MAX = 393.49442d;
    static final double K0_HOUSE2_MIN = 331.162937d;
    static final double K0_HOUSE3_MAX = 393.494421d;
    static final double K0_HOUSE3_MIN = 331.162936d;
    static final double K0_HOUSE4_MAX = 393.49442d;
    static final double K0_HOUSE4_MIN = 331.162936d;
    static final double K0_HOUSE5_MAX = 393.49442d;
    static final double K0_HOUSE5_MIN = 331.162936d;
    static final double K0_HOUSE6_MAX = 393.49442d;
    static final double K0_HOUSE6_MIN = 331.162937d;
    static final double K0_HOUSE7_MAX = 393.49442d;
    static final double K0_HOUSE7_MIN = 331.162937d;
    static final double K0_HOUSE8_MAX = 393.49442d;
    static final double K0_HOUSE8_MIN = 331.162937d;
    static final double K0_HOUSE9_MAX = 393.494421d;
    static final double K0_HOUSE9_MIN = 331.162936d;
    static final double K0_MC_MAX = 393.49442d;
    static final double K0_MC_MIN = 331.162936d;
    static final double K0_POLASC_MAX = 393.49442d;
    static final double K0_POLASC_MIN = 331.162937d;
    static final double K0_VERTEX_MAX = 777600.0d;
    static final double K0_VERTEX_MIN = -777600.0d;
    static final double K10_ARMC_MAX = 360.985931d;
    static final double K10_ARMC_MIN = 360.985828d;
    static final double K10_ASC_MAX = 426.089536d;
    static final double K10_ASC_MIN = 328.169552d;
    static final double K10_COASC1_MAX = 426.089531d;
    static final double K10_COASC1_MIN = 328.16955d;
    static final double K10_COASC2_MAX = 113.797795d;
    static final double K10_COASC2_MIN = -269.99607d;
    static final double K10_EQUASC_MAX = 393.49442d;
    static final double K10_EQUASC_MIN = 331.162937d;
    static final double K10_HOUSE10_MAX = 393.49442d;
    static final double K10_HOUSE10_MIN = 331.162936d;
    static final double K10_HOUSE11_MAX = 407.903569d;
    static final double K10_HOUSE11_MIN = 321.779064d;
    static final double K10_HOUSE12_MAX = 421.06777d;
    static final double K10_HOUSE12_MIN = 321.636172d;
    static final double K10_HOUSE1_MAX = 426.089536d;
    static final double K10_HOUSE1_MIN = 328.169552d;
    static final double K10_HOUSE2_MAX = 421.067784d;
    static final double K10_HOUSE2_MIN = 321.636178d;
    static final double K10_HOUSE3_MAX = 407.90358d;
    static final double K10_HOUSE3_MIN = 321.779053d;
    static final double K10_HOUSE4_MAX = 393.49442d;
    static final double K10_HOUSE4_MIN = 331.162936d;
    static final double K10_HOUSE5_MAX = 407.903569d;
    static final double K10_HOUSE5_MIN = 321.779064d;
    static final double K10_HOUSE6_MAX = 421.06777d;
    static final double K10_HOUSE6_MIN = 321.636172d;
    static final double K10_HOUSE7_MAX = 426.089536d;
    static final double K10_HOUSE7_MIN = 328.169552d;
    static final double K10_HOUSE8_MAX = 421.067784d;
    static final double K10_HOUSE8_MIN = 321.636178d;
    static final double K10_HOUSE9_MAX = 407.90358d;
    static final double K10_HOUSE9_MIN = 321.779053d;
    static final double K10_MC_MAX = 393.49442d;
    static final double K10_MC_MIN = 331.162936d;
    static final double K10_POLASC_MAX = 426.089531d;
    static final double K10_POLASC_MIN = 328.16955d;
    static final double K10_VERTEX_MAX = 1554930.566243d;
    static final double K10_VERTEX_MIN = -777600.124028d;
    static final double K20_ARMC_MAX = 360.985931d;
    static final double K20_ARMC_MIN = 360.985828d;
    static final double K20_ASC_MAX = 467.280896d;
    static final double K20_ASC_MIN = 319.225068d;
    static final double K20_COASC1_MAX = 467.280888d;
    static final double K20_COASC1_MIN = 319.22507d;
    static final double K20_COASC2_MAX = 179.610407d;
    static final double K20_COASC2_MIN = -2066.7575d;
    static final double K20_EQUASC_MAX = 393.49442d;
    static final double K20_EQUASC_MIN = 331.162937d;
    static final double K20_HOUSE10_MAX = 393.49442d;
    static final double K20_HOUSE10_MIN = 331.162936d;
    static final double K20_HOUSE11_MAX = 427.493934d;
    static final double K20_HOUSE11_MIN = 310.048728d;
    static final double K20_HOUSE12_MAX = 456.60921d;
    static final double K20_HOUSE12_MIN = 307.660615d;
    static final double K20_HOUSE1_MAX = 467.280896d;
    static final double K20_HOUSE1_MIN = 319.225068d;
    static final double K20_HOUSE2_MAX = 456.609208d;
    static final double K20_HOUSE2_MIN = 307.660606d;
    static final double K20_HOUSE3_MAX = 427.493924d;
    static final double K20_HOUSE3_MIN = 310.048717d;
    static final double K20_HOUSE4_MAX = 393.49442d;
    static final double K20_HOUSE4_MIN = 331.162936d;
    static final double K20_HOUSE5_MAX = 427.493934d;
    static final double K20_HOUSE5_MIN = 310.048728d;
    static final double K20_HOUSE6_MAX = 456.60921d;
    static final double K20_HOUSE6_MIN = 307.660615d;
    static final double K20_HOUSE7_MAX = 467.280896d;
    static final double K20_HOUSE7_MIN = 319.225068d;
    static final double K20_HOUSE8_MAX = 456.609208d;
    static final double K20_HOUSE8_MIN = 307.660606d;
    static final double K20_HOUSE9_MAX = 427.493924d;
    static final double K20_HOUSE9_MIN = 310.048717d;
    static final double K20_MC_MAX = 393.49442d;
    static final double K20_MC_MIN = 331.162936d;
    static final double K20_POLASC_MAX = 467.280888d;
    static final double K20_POLASC_MIN = 319.22507d;
    static final double K20_VERTEX_MAX = 1553150.33462d;
    static final double K20_VERTEX_MIN = -777600.393091d;
    static final double K30_ARMC_MAX = 360.985931d;
    static final double K30_ARMC_MIN = 360.985828d;
    static final double K30_ASC_MAX = 524.994891d;
    static final double K30_ASC_MIN = 304.407972d;
    static final double K30_COASC1_MAX = 524.994878d;
    static final double K30_COASC1_MIN = 304.407972d;
    static final double K30_COASC2_MAX = 1583.084164d;
    static final double K30_COASC2_MIN = 220.207028d;
    static final double K30_EQUASC_MAX = 393.49442d;
    static final double K30_EQUASC_MIN = 331.162937d;
    static final double K30_HOUSE10_MAX = 393.49442d;
    static final double K30_HOUSE10_MIN = 331.162936d;
    static final double K30_HOUSE11_MAX = 456.419331d;
    static final double K30_HOUSE11_MIN = 294.890755d;
    static final double K30_HOUSE12_MAX = 506.955512d;
    static final double K30_HOUSE12_MIN = 289.017735d;
    static final double K30_HOUSE1_MAX = 524.994891d;
    static final double K30_HOUSE1_MIN = 304.407972d;
    static final double K30_HOUSE2_MAX = 506.955469d;
    static final double K30_HOUSE2_MIN = 289.017738d;
    static final double K30_HOUSE3_MAX = 456.419314d;
    static final double K30_HOUSE3_MIN = 294.890761d;
    static final double K30_HOUSE4_MAX = 393.49442d;
    static final double K30_HOUSE4_MIN = 331.162936d;
    static final double K30_HOUSE5_MAX = 456.419331d;
    static final double K30_HOUSE5_MIN = 294.890755d;
    static final double K30_HOUSE6_MAX = 506.955512d;
    static final double K30_HOUSE6_MIN = 289.017735d;
    static final double K30_HOUSE7_MAX = 524.994891d;
    static final double K30_HOUSE7_MIN = 304.407972d;
    static final double K30_HOUSE8_MAX = 506.955469d;
    static final double K30_HOUSE8_MIN = 289.017738d;
    static final double K30_HOUSE9_MAX = 456.419314d;
    static final double K30_HOUSE9_MIN = 294.890761d;
    static final double K30_MC_MAX = 393.49442d;
    static final double K30_MC_MIN = 331.162936d;
    static final double K30_POLASC_MAX = 524.994878d;
    static final double K30_POLASC_MIN = 304.407972d;
    static final double K30_VERTEX_MAX = 1583.084212d;
    static final double K30_VERTEX_MIN = 220.207025d;
    static final double K40_ARMC_MAX = 360.985931d;
    static final double K40_ARMC_MIN = 360.985828d;
    static final double K40_ASC_MAX = 618.738596d;
    static final double K40_ASC_MIN = 283.720808d;
    static final double K40_COASC1_MAX = 618.738574d;
    static final double K40_COASC1_MIN = 283.720804d;
    static final double K40_COASC2_MAX = 814.745889d;
    static final double K40_COASC2_MIN = 256.684961d;
    static final double K40_EQUASC_MAX = 393.49442d;
    static final double K40_EQUASC_MIN = 331.162937d;
    static final double K40_HOUSE10_MAX = 393.49442d;
    static final double K40_HOUSE10_MIN = 331.162936d;
    static final double K40_HOUSE11_MAX = 505.07724d;
    static final double K40_HOUSE11_MIN = 273.462215d;
    static final double K40_HOUSE12_MAX = 589.267858d;
    static final double K40_HOUSE12_MIN = 264.373489d;
    static final double K40_HOUSE1_MAX = 618.738596d;
    static final double K40_HOUSE1_MIN = 283.720808d;
    static final double K40_HOUSE2_MAX = 589.267962d;
    static final double K40_HOUSE2_MIN = 264.373474d;
    static final double K40_HOUSE3_MAX = 505.077304d;
    static final double K40_HOUSE3_MIN = 273.462225d;
    static final double K40_HOUSE4_MAX = 393.49442d;
    static final double K40_HOUSE4_MIN = 331.162936d;
    static final double K40_HOUSE5_MAX = 505.07724d;
    static final double K40_HOUSE5_MIN = 273.462215d;
    static final double K40_HOUSE6_MAX = 589.267858d;
    static final double K40_HOUSE6_MIN = 264.373489d;
    static final double K40_HOUSE7_MAX = 618.738596d;
    static final double K40_HOUSE7_MIN = 283.720808d;
    static final double K40_HOUSE8_MAX = 589.267962d;
    static final double K40_HOUSE8_MIN = 264.373474d;
    static final double K40_HOUSE9_MAX = 505.077304d;
    static final double K40_HOUSE9_MIN = 273.462225d;
    static final double K40_MC_MAX = 393.49442d;
    static final double K40_MC_MIN = 331.162936d;
    static final double K40_POLASC_MAX = 618.738574d;
    static final double K40_POLASC_MIN = 283.720804d;
    static final double K40_VERTEX_MAX = 814.74585d;
    static final double K40_VERTEX_MIN = 256.68496d;
    static final double K50_ARMC_MAX = 360.985931d;
    static final double K50_ARMC_MIN = 360.985828d;
    static final double K50_ASC_MAX = 814.745889d;
    static final double K50_ASC_MIN = 256.684961d;
    static final double K50_COASC1_MAX = 814.74585d;
    static final double K50_COASC1_MIN = 256.68496d;
    static final double K50_COASC2_MAX = 618.738596d;
    static final double K50_COASC2_MIN = 283.720808d;
    static final double K50_EQUASC_MAX = 393.49442d;
    static final double K50_EQUASC_MIN = 331.162937d;
    static final double K50_HOUSE10_MAX = 393.49442d;
    static final double K50_HOUSE10_MIN = 331.162936d;
    static final double K50_HOUSE11_MAX = 609.302287d;
    static final double K50_HOUSE11_MIN = 237.53456d;
    static final double K50_HOUSE12_MAX = 762.191568d;
    static final double K50_HOUSE12_MIN = 229.755592d;
    static final double K50_HOUSE1_MAX = 814.745889d;
    static final double K50_HOUSE1_MIN = 256.684961d;
    static final double K50_HOUSE2_MAX = 762.191331d;
    static final double K50_HOUSE2_MIN = 229.755579d;
    static final double K50_HOUSE3_MAX = 609.302286d;
    static final double K50_HOUSE3_MIN = 237.534571d;
    static final double K50_HOUSE4_MAX = 393.49442d;
    static final double K50_HOUSE4_MIN = 331.162936d;
    static final double K50_HOUSE5_MAX = 609.302287d;
    static final double K50_HOUSE5_MIN = 237.53456d;
    static final double K50_HOUSE6_MAX = 762.191568d;
    static final double K50_HOUSE6_MIN = 229.755592d;
    static final double K50_HOUSE7_MAX = 814.745889d;
    static final double K50_HOUSE7_MIN = 256.684961d;
    static final double K50_HOUSE8_MAX = 762.191331d;
    static final double K50_HOUSE8_MIN = 229.755579d;
    static final double K50_HOUSE9_MAX = 609.302286d;
    static final double K50_HOUSE9_MIN = 237.534571d;
    static final double K50_MC_MAX = 393.49442d;
    static final double K50_MC_MIN = 331.162936d;
    static final double K50_POLASC_MAX = 814.74585d;
    static final double K50_POLASC_MIN = 256.68496d;
    static final double K50_VERTEX_MAX = 618.738574d;
    static final double K50_VERTEX_MIN = 283.720804d;
    static final double K60_ARMC_MAX = 360.985931d;
    static final double K60_ARMC_MIN = 360.985828d;
    static final double K60_ASC_MAX = 1583.084164d;
    static final double K60_ASC_MIN = 220.207028d;
    static final double K60_COASC1_MAX = 1583.084212d;
    static final double K60_COASC1_MIN = 220.207025d;
    static final double K60_COASC2_MAX = 524.994891d;
    static final double K60_COASC2_MIN = 304.407972d;
    static final double K60_EQUASC_MAX = 393.49442d;
    static final double K60_EQUASC_MIN = 331.162937d;
    static final double K60_HOUSE10_MAX = 393.49442d;
    static final double K60_HOUSE10_MIN = 331.162936d;
    static final double K60_HOUSE11_MAX = 1027.36296d;
    static final double K60_HOUSE11_MIN = 159.418256d;
    static final double K60_HOUSE12_MAX = 1443.127407d;
    static final double K60_HOUSE12_MIN = 174.688239d;
    static final double K60_HOUSE1_MAX = 1583.084164d;
    static final double K60_HOUSE1_MIN = 220.207028d;
    static final double K60_HOUSE2_MAX = 1443.125795d;
    static final double K60_HOUSE2_MIN = 174.688246d;
    static final double K60_HOUSE3_MAX = 1027.363599d;
    static final double K60_HOUSE3_MIN = 159.418282d;
    static final double K60_HOUSE4_MAX = 393.49442d;
    static final double K60_HOUSE4_MIN = 331.162936d;
    static final double K60_HOUSE5_MAX = 1027.36296d;
    static final double K60_HOUSE5_MIN = 159.418256d;
    static final double K60_HOUSE6_MAX = 1443.127407d;
    static final double K60_HOUSE6_MIN = 174.688239d;
    static final double K60_HOUSE7_MAX = 1583.084164d;
    static final double K60_HOUSE7_MIN = 220.207028d;
    static final double K60_HOUSE8_MAX = 1443.125795d;
    static final double K60_HOUSE8_MIN = 174.688246d;
    static final double K60_HOUSE9_MAX = 1027.363599d;
    static final double K60_HOUSE9_MIN = 159.418282d;
    static final double K60_MC_MAX = 393.49442d;
    static final double K60_MC_MIN = 331.162936d;
    static final double K60_POLASC_MAX = 1583.084212d;
    static final double K60_POLASC_MIN = 220.207025d;
    static final double K60_VERTEX_MAX = 524.994878d;
    static final double K60_VERTEX_MIN = 304.407972d;
    static final double K66_ARMC_MAX = 360.985931d;
    static final double K66_ARMC_MIN = 360.985828d;
    static final double K66_ASC_MAX = 15382.763492d;
    static final double K66_ASC_MIN = 180.714519d;
    static final double K66_COASC1_MAX = 15382.960178d;
    static final double K66_COASC1_MIN = 180.714532d;
    static final double K66_COASC2_MAX = 487.697885d;
    static final double K66_COASC2_MIN = 313.998924d;
    static final double K66_EQUASC_MAX = 393.49442d;
    static final double K66_EQUASC_MIN = 331.162937d;
    static final double K66_HOUSE10_MAX = 393.49442d;
    static final double K66_HOUSE10_MIN = 331.162936d;
    static final double K66_HOUSE11_MAX = 8684.36616d;
    static final double K66_HOUSE11_MIN = 66.28286d;
    static final double K66_HOUSE12_MAX = 13708.365617d;
    static final double K66_HOUSE12_MIN = 122.022516d;
    static final double K66_HOUSE1_MAX = 15382.763492d;
    static final double K66_HOUSE1_MIN = 180.714519d;
    static final double K66_HOUSE2_MAX = 13708.40777d;
    static final double K66_HOUSE2_MIN = 122.022521d;
    static final double K66_HOUSE3_MAX = 8684.165243d;
    static final double K66_HOUSE3_MIN = 66.282868d;
    static final double K66_HOUSE4_MAX = 393.49442d;
    static final double K66_HOUSE4_MIN = 331.162936d;
    static final double K66_HOUSE5_MAX = 8684.36616d;
    static final double K66_HOUSE5_MIN = 66.28286d;
    static final double K66_HOUSE6_MAX = 13708.365617d;
    static final double K66_HOUSE6_MIN = 122.022516d;
    static final double K66_HOUSE7_MAX = 15382.763492d;
    static final double K66_HOUSE7_MIN = 180.714519d;
    static final double K66_HOUSE8_MAX = 13708.40777d;
    static final double K66_HOUSE8_MIN = 122.022521d;
    static final double K66_HOUSE9_MAX = 8684.165243d;
    static final double K66_HOUSE9_MIN = 66.282868d;
    static final double K66_MC_MAX = 393.49442d;
    static final double K66_MC_MIN = 331.162936d;
    static final double K66_POLASC_MAX = 15382.960178d;
    static final double K66_POLASC_MIN = 180.714532d;
    static final double K66_VERTEX_MAX = 487.697876d;
    static final double K66_VERTEX_MIN = 313.998925d;
    static final double K70_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double K70_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double K70_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double K70_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double K70_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double K70_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double K70_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K70_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K70_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double K70_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double K70_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double K70_MC_MAX = Double.POSITIVE_INFINITY;
    static final double K70_MC_MIN = Double.POSITIVE_INFINITY;
    static final double K70_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double K70_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double K70_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double K70_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double K80_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double K80_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double K80_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double K80_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double K80_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double K80_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double K80_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K80_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K80_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double K80_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double K80_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double K80_MC_MAX = Double.POSITIVE_INFINITY;
    static final double K80_MC_MIN = Double.POSITIVE_INFINITY;
    static final double K80_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double K80_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double K80_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double K80_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double K85_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double K85_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double K85_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double K85_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double K85_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double K85_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double K85_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K85_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K85_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double K85_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double K85_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double K85_MC_MAX = Double.POSITIVE_INFINITY;
    static final double K85_MC_MIN = Double.POSITIVE_INFINITY;
    static final double K85_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double K85_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double K85_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double K85_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double K88_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double K88_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double K88_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double K88_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double K88_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double K88_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double K88_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K88_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K88_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double K88_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double K88_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double K88_MC_MAX = Double.POSITIVE_INFINITY;
    static final double K88_MC_MIN = Double.POSITIVE_INFINITY;
    static final double K88_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double K88_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double K88_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double K88_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double K90_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double K90_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double K90_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double K90_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double K90_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double K90_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double K90_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double K90_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double K90_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double K90_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double K90_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double K90_MC_MAX = Double.POSITIVE_INFINITY;
    static final double K90_MC_MIN = Double.POSITIVE_INFINITY;
    static final double K90_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double K90_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double K90_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double K90_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double O0_ARMC_MAX = 360.985931d;
    static final double O0_ARMC_MIN = 360.985828d;
    static final double O0_ASC_MAX = 393.49442d;
    static final double O0_ASC_MIN = 331.162937d;
    static final double O0_COASC1_MAX = 393.49442d;
    static final double O0_COASC1_MIN = 331.162937d;
    static final double O0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double O0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double O0_EQUASC_MAX = 393.49442d;
    static final double O0_EQUASC_MIN = 331.162937d;
    static final double O0_HOUSE10_MAX = 393.49442d;
    static final double O0_HOUSE10_MIN = 331.162936d;
    static final double O0_HOUSE11_MAX = 372.717259d;
    static final double O0_HOUSE11_MIN = 351.940097d;
    static final double O0_HOUSE12_MAX = 372.71726d;
    static final double O0_HOUSE12_MIN = 351.940098d;
    static final double O0_HOUSE1_MAX = 393.49442d;
    static final double O0_HOUSE1_MIN = 331.162937d;
    static final double O0_HOUSE2_MAX = 372.71726d;
    static final double O0_HOUSE2_MIN = 351.940098d;
    static final double O0_HOUSE3_MAX = 372.717259d;
    static final double O0_HOUSE3_MIN = 351.940097d;
    static final double O0_HOUSE4_MAX = 393.49442d;
    static final double O0_HOUSE4_MIN = 331.162936d;
    static final double O0_HOUSE5_MAX = 372.717259d;
    static final double O0_HOUSE5_MIN = 351.940097d;
    static final double O0_HOUSE6_MAX = 372.71726d;
    static final double O0_HOUSE6_MIN = 351.940098d;
    static final double O0_HOUSE7_MAX = 393.49442d;
    static final double O0_HOUSE7_MIN = 331.162937d;
    static final double O0_HOUSE8_MAX = 372.71726d;
    static final double O0_HOUSE8_MIN = 351.940098d;
    static final double O0_HOUSE9_MAX = 372.717259d;
    static final double O0_HOUSE9_MIN = 351.940097d;
    static final double O0_MC_MAX = 393.49442d;
    static final double O0_MC_MIN = 331.162936d;
    static final double O0_POLASC_MAX = 393.49442d;
    static final double O0_POLASC_MIN = 331.162937d;
    static final double O0_VERTEX_MAX = 777600.0d;
    static final double O0_VERTEX_MIN = -777600.0d;
    static final double O10_ARMC_MAX = 360.985931d;
    static final double O10_ARMC_MIN = 360.985828d;
    static final double O10_ASC_MAX = 426.089536d;
    static final double O10_ASC_MIN = 328.169552d;
    static final double O10_COASC1_MAX = 426.089531d;
    static final double O10_COASC1_MIN = 328.16955d;
    static final double O10_COASC2_MAX = 113.797795d;
    static final double O10_COASC2_MIN = -269.99607d;
    static final double O10_EQUASC_MAX = 393.49442d;
    static final double O10_EQUASC_MIN = 331.162937d;
    static final double O10_HOUSE10_MAX = 393.49442d;
    static final double O10_HOUSE10_MIN = 331.162936d;
    static final double O10_HOUSE11_MAX = 372.436247d;
    static final double O10_HOUSE11_MIN = 342.619247d;
    static final double O10_HOUSE12_MAX = 394.447336d;
    static final double O10_HOUSE12_MIN = 347.876271d;
    static final double O10_HOUSE1_MAX = 426.089536d;
    static final double O10_HOUSE1_MIN = 328.169552d;
    static final double O10_HOUSE2_MAX = 394.447336d;
    static final double O10_HOUSE2_MIN = 347.876271d;
    static final double O10_HOUSE3_MAX = 372.436247d;
    static final double O10_HOUSE3_MIN = 342.619247d;
    static final double O10_HOUSE4_MAX = 393.49442d;
    static final double O10_HOUSE4_MIN = 331.162936d;
    static final double O10_HOUSE5_MAX = 372.436247d;
    static final double O10_HOUSE5_MIN = 342.619247d;
    static final double O10_HOUSE6_MAX = 394.447336d;
    static final double O10_HOUSE6_MIN = 347.876271d;
    static final double O10_HOUSE7_MAX = 426.089536d;
    static final double O10_HOUSE7_MIN = 328.169552d;
    static final double O10_HOUSE8_MAX = 394.447336d;
    static final double O10_HOUSE8_MIN = 347.876271d;
    static final double O10_HOUSE9_MAX = 372.436247d;
    static final double O10_HOUSE9_MIN = 342.619247d;
    static final double O10_MC_MAX = 393.49442d;
    static final double O10_MC_MIN = 331.162936d;
    static final double O10_POLASC_MAX = 426.089531d;
    static final double O10_POLASC_MIN = 328.16955d;
    static final double O10_VERTEX_MAX = 1554930.566243d;
    static final double O10_VERTEX_MIN = -777600.124028d;
    static final double O20_ARMC_MAX = 360.985931d;
    static final double O20_ARMC_MIN = 360.985828d;
    static final double O20_ASC_MAX = 467.280896d;
    static final double O20_ASC_MIN = 319.225068d;
    static final double O20_COASC1_MAX = 467.280888d;
    static final double O20_COASC1_MIN = 319.22507d;
    static final double O20_COASC2_MAX = 179.610407d;
    static final double O20_COASC2_MIN = -2066.7575d;
    static final double O20_EQUASC_MAX = 393.49442d;
    static final double O20_EQUASC_MIN = 331.162937d;
    static final double O20_HOUSE10_MAX = 393.49442d;
    static final double O20_HOUSE10_MIN = 331.162936d;
    static final double O20_HOUSE11_MAX = 376.535598d;
    static final double O20_HOUSE11_MIN = 334.052883d;
    static final double O20_HOUSE12_MAX = 421.908242d;
    static final double O20_HOUSE12_MIN = 336.56951d;
    static final double O20_HOUSE1_MAX = 467.280896d;
    static final double O20_HOUSE1_MIN = 319.225068d;
    static final double O20_HOUSE2_MAX = 421.908242d;
    static final double O20_HOUSE2_MIN = 336.56951d;
    static final double O20_HOUSE3_MAX = 376.535598d;
    static final double O20_HOUSE3_MIN = 334.052883d;
    static final double O20_HOUSE4_MAX = 393.49442d;
    static final double O20_HOUSE4_MIN = 331.162936d;
    static final double O20_HOUSE5_MAX = 376.535598d;
    static final double O20_HOUSE5_MIN = 334.052883d;
    static final double O20_HOUSE6_MAX = 421.908242d;
    static final double O20_HOUSE6_MIN = 336.56951d;
    static final double O20_HOUSE7_MAX = 467.280896d;
    static final double O20_HOUSE7_MIN = 319.225068d;
    static final double O20_HOUSE8_MAX = 421.908242d;
    static final double O20_HOUSE8_MIN = 336.56951d;
    static final double O20_HOUSE9_MAX = 376.535598d;
    static final double O20_HOUSE9_MIN = 334.052883d;
    static final double O20_MC_MAX = 393.49442d;
    static final double O20_MC_MIN = 331.162936d;
    static final double O20_POLASC_MAX = 467.280888d;
    static final double O20_POLASC_MIN = 319.22507d;
    static final double O20_VERTEX_MAX = 1553150.33462d;
    static final double O20_VERTEX_MIN = -777600.393091d;
    static final double O30_ARMC_MAX = 360.985931d;
    static final double O30_ARMC_MIN = 360.985828d;
    static final double O30_ASC_MAX = 524.994891d;
    static final double O30_ASC_MIN = 304.407972d;
    static final double O30_COASC1_MAX = 524.994878d;
    static final double O30_COASC1_MIN = 304.407972d;
    static final double O30_COASC2_MAX = 1583.084164d;
    static final double O30_COASC2_MIN = 220.207028d;
    static final double O30_EQUASC_MAX = 393.49442d;
    static final double O30_EQUASC_MIN = 331.162937d;
    static final double O30_HOUSE10_MAX = 393.49442d;
    static final double O30_HOUSE10_MIN = 331.162936d;
    static final double O30_HOUSE11_MAX = 395.773587d;
    static final double O30_HOUSE11_MIN = 325.666898d;
    static final double O30_HOUSE12_MAX = 460.384239d;
    static final double O30_HOUSE12_MIN = 320.170855d;
    static final double O30_HOUSE1_MAX = 524.994891d;
    static final double O30_HOUSE1_MIN = 304.407972d;
    static final double O30_HOUSE2_MAX = 460.384239d;
    static final double O30_HOUSE2_MIN = 320.170855d;
    static final double O30_HOUSE3_MAX = 395.773587d;
    static final double O30_HOUSE3_MIN = 325.666898d;
    static final double O30_HOUSE4_MAX = 393.49442d;
    static final double O30_HOUSE4_MIN = 331.162936d;
    static final double O30_HOUSE5_MAX = 395.773587d;
    static final double O30_HOUSE5_MIN = 325.666898d;
    static final double O30_HOUSE6_MAX = 460.384239d;
    static final double O30_HOUSE6_MIN = 320.170855d;
    static final double O30_HOUSE7_MAX = 524.994891d;
    static final double O30_HOUSE7_MIN = 304.407972d;
    static final double O30_HOUSE8_MAX = 460.384239d;
    static final double O30_HOUSE8_MIN = 320.170855d;
    static final double O30_HOUSE9_MAX = 395.773587d;
    static final double O30_HOUSE9_MIN = 325.666898d;
    static final double O30_MC_MAX = 393.49442d;
    static final double O30_MC_MIN = 331.162936d;
    static final double O30_POLASC_MAX = 524.994878d;
    static final double O30_POLASC_MIN = 304.407972d;
    static final double O30_VERTEX_MAX = 1583.084212d;
    static final double O30_VERTEX_MIN = 220.207025d;
    static final double O40_ARMC_MAX = 360.985931d;
    static final double O40_ARMC_MIN = 360.985828d;
    static final double O40_ASC_MAX = 618.738596d;
    static final double O40_ASC_MIN = 283.720808d;
    static final double O40_COASC1_MAX = 618.738574d;
    static final double O40_COASC1_MIN = 283.720804d;
    static final double O40_COASC2_MAX = 814.745889d;
    static final double O40_COASC2_MIN = 256.684961d;
    static final double O40_EQUASC_MAX = 393.49442d;
    static final double O40_EQUASC_MIN = 331.162937d;
    static final double O40_HOUSE10_MAX = 393.49442d;
    static final double O40_HOUSE10_MIN = 331.162936d;
    static final double O40_HOUSE11_MAX = 427.021489d;
    static final double O40_HOUSE11_MIN = 316.934513d;
    static final double O40_HOUSE12_MAX = 522.880043d;
    static final double O40_HOUSE12_MIN = 302.706085d;
    static final double O40_HOUSE1_MAX = 618.738596d;
    static final double O40_HOUSE1_MIN = 283.720808d;
    static final double O40_HOUSE2_MAX = 522.880043d;
    static final double O40_HOUSE2_MIN = 302.706085d;
    static final double O40_HOUSE3_MAX = 427.021489d;
    static final double O40_HOUSE3_MIN = 316.934513d;
    static final double O40_HOUSE4_MAX = 393.49442d;
    static final double O40_HOUSE4_MIN = 331.162936d;
    static final double O40_HOUSE5_MAX = 427.021489d;
    static final double O40_HOUSE5_MIN = 316.934513d;
    static final double O40_HOUSE6_MAX = 522.880043d;
    static final double O40_HOUSE6_MIN = 302.706085d;
    static final double O40_HOUSE7_MAX = 618.738596d;
    static final double O40_HOUSE7_MIN = 283.720808d;
    static final double O40_HOUSE8_MAX = 522.880043d;
    static final double O40_HOUSE8_MIN = 302.706085d;
    static final double O40_HOUSE9_MAX = 427.021489d;
    static final double O40_HOUSE9_MIN = 316.934513d;
    static final double O40_MC_MAX = 393.49442d;
    static final double O40_MC_MIN = 331.162936d;
    static final double O40_POLASC_MAX = 618.738574d;
    static final double O40_POLASC_MIN = 283.720804d;
    static final double O40_VERTEX_MAX = 814.74585d;
    static final double O40_VERTEX_MIN = 256.68496d;
    static final double O50_ARMC_MAX = 360.985931d;
    static final double O50_ARMC_MIN = 360.985828d;
    static final double O50_ASC_MAX = 814.745889d;
    static final double O50_ASC_MIN = 256.684961d;
    static final double O50_COASC1_MAX = 814.74585d;
    static final double O50_COASC1_MIN = 256.68496d;
    static final double O50_COASC2_MAX = 618.738596d;
    static final double O50_COASC2_MIN = 283.720808d;
    static final double O50_EQUASC_MAX = 393.49442d;
    static final double O50_EQUASC_MIN = 331.162937d;
    static final double O50_HOUSE10_MAX = 393.49442d;
    static final double O50_HOUSE10_MIN = 331.162936d;
    static final double O50_HOUSE11_MAX = 492.357254d;
    static final double O50_HOUSE11_MIN = 307.236624d;
    static final double O50_HOUSE12_MAX = 653.551572d;
    static final double O50_HOUSE12_MIN = 283.310307d;
    static final double O50_HOUSE1_MAX = 814.745889d;
    static final double O50_HOUSE1_MIN = 256.684961d;
    static final double O50_HOUSE2_MAX = 653.551572d;
    static final double O50_HOUSE2_MIN = 283.310307d;
    static final double O50_HOUSE3_MAX = 492.357254d;
    static final double O50_HOUSE3_MIN = 307.236624d;
    static final double O50_HOUSE4_MAX = 393.49442d;
    static final double O50_HOUSE4_MIN = 331.162936d;
    static final double O50_HOUSE5_MAX = 492.357254d;
    static final double O50_HOUSE5_MIN = 307.236624d;
    static final double O50_HOUSE6_MAX = 653.551572d;
    static final double O50_HOUSE6_MIN = 283.310307d;
    static final double O50_HOUSE7_MAX = 814.745889d;
    static final double O50_HOUSE7_MIN = 256.684961d;
    static final double O50_HOUSE8_MAX = 653.551572d;
    static final double O50_HOUSE8_MIN = 283.310307d;
    static final double O50_HOUSE9_MAX = 492.357254d;
    static final double O50_HOUSE9_MIN = 307.236624d;
    static final double O50_MC_MAX = 393.49442d;
    static final double O50_MC_MIN = 331.162936d;
    static final double O50_POLASC_MAX = 814.74585d;
    static final double O50_POLASC_MIN = 256.68496d;
    static final double O50_VERTEX_MAX = 618.738574d;
    static final double O50_VERTEX_MIN = 283.720804d;
    static final double O60_ARMC_MAX = 360.985931d;
    static final double O60_ARMC_MIN = 360.985828d;
    static final double O60_ASC_MAX = 1583.084164d;
    static final double O60_ASC_MIN = 220.207028d;
    static final double O60_COASC1_MAX = 1583.084212d;
    static final double O60_COASC1_MIN = 220.207025d;
    static final double O60_COASC2_MAX = 524.994891d;
    static final double O60_COASC2_MIN = 304.407972d;
    static final double O60_EQUASC_MAX = 393.49442d;
    static final double O60_EQUASC_MIN = 331.162937d;
    static final double O60_HOUSE10_MAX = 393.49442d;
    static final double O60_HOUSE10_MIN = 331.162936d;
    static final double O60_HOUSE11_MAX = 748.470012d;
    static final double O60_HOUSE11_MIN = 295.665045d;
    static final double O60_HOUSE12_MAX = 1165.777088d;
    static final double O60_HOUSE12_MIN = 260.167148d;
    static final double O60_HOUSE1_MAX = 1583.084164d;
    static final double O60_HOUSE1_MIN = 220.207028d;
    static final double O60_HOUSE2_MAX = 1165.777088d;
    static final double O60_HOUSE2_MIN = 260.167148d;
    static final double O60_HOUSE3_MAX = 748.470012d;
    static final double O60_HOUSE3_MIN = 295.665045d;
    static final double O60_HOUSE4_MAX = 393.49442d;
    static final double O60_HOUSE4_MIN = 331.162936d;
    static final double O60_HOUSE5_MAX = 748.470012d;
    static final double O60_HOUSE5_MIN = 295.665045d;
    static final double O60_HOUSE6_MAX = 1165.777088d;
    static final double O60_HOUSE6_MIN = 260.167148d;
    static final double O60_HOUSE7_MAX = 1583.084164d;
    static final double O60_HOUSE7_MIN = 220.207028d;
    static final double O60_HOUSE8_MAX = 1165.777088d;
    static final double O60_HOUSE8_MIN = 260.167148d;
    static final double O60_HOUSE9_MAX = 748.470012d;
    static final double O60_HOUSE9_MIN = 295.665045d;
    static final double O60_MC_MAX = 393.49442d;
    static final double O60_MC_MIN = 331.162936d;
    static final double O60_POLASC_MAX = 1583.084212d;
    static final double O60_POLASC_MIN = 220.207025d;
    static final double O60_VERTEX_MAX = 524.994878d;
    static final double O60_VERTEX_MIN = 304.407972d;
    static final double O66_ARMC_MAX = 360.985931d;
    static final double O66_ARMC_MIN = 360.985828d;
    static final double O66_ASC_MAX = 15382.763492d;
    static final double O66_ASC_MIN = 180.714519d;
    static final double O66_COASC1_MAX = 15382.960178d;
    static final double O66_COASC1_MIN = 180.714532d;
    static final double O66_COASC2_MAX = 487.697885d;
    static final double O66_COASC2_MIN = 313.998924d;
    static final double O66_EQUASC_MAX = 393.49442d;
    static final double O66_EQUASC_MIN = 331.162937d;
    static final double O66_HOUSE10_MAX = 393.49442d;
    static final double O66_HOUSE10_MIN = 331.162936d;
    static final double O66_HOUSE11_MAX = 5348.363137d;
    static final double O66_HOUSE11_MIN = 287.207091d;
    static final double O66_HOUSE12_MAX = 10365.563314d;
    static final double O66_HOUSE12_MIN = 242.387231d;
    static final double O66_HOUSE1_MAX = 15382.763492d;
    static final double O66_HOUSE1_MIN = 180.714519d;
    static final double O66_HOUSE2_MAX = 10365.563314d;
    static final double O66_HOUSE2_MIN = 242.387231d;
    static final double O66_HOUSE3_MAX = 5348.363137d;
    static final double O66_HOUSE3_MIN = 287.207091d;
    static final double O66_HOUSE4_MAX = 393.49442d;
    static final double O66_HOUSE4_MIN = 331.162936d;
    static final double O66_HOUSE5_MAX = 5348.363137d;
    static final double O66_HOUSE5_MIN = 287.207091d;
    static final double O66_HOUSE6_MAX = 10365.563314d;
    static final double O66_HOUSE6_MIN = 242.387231d;
    static final double O66_HOUSE7_MAX = 15382.763492d;
    static final double O66_HOUSE7_MIN = 180.714519d;
    static final double O66_HOUSE8_MAX = 10365.563314d;
    static final double O66_HOUSE8_MIN = 242.387231d;
    static final double O66_HOUSE9_MAX = 5348.363137d;
    static final double O66_HOUSE9_MIN = 287.207091d;
    static final double O66_MC_MAX = 393.49442d;
    static final double O66_MC_MIN = 331.162936d;
    static final double O66_POLASC_MAX = 15382.960178d;
    static final double O66_POLASC_MIN = 180.714532d;
    static final double O66_VERTEX_MAX = 487.697876d;
    static final double O66_VERTEX_MIN = 313.998925d;
    static final double O70_ARMC_MAX = 360.985931d;
    static final double O70_ARMC_MIN = 360.985828d;
    static final double O70_ASC_MAX = 1553150.32968d;
    static final double O70_ASC_MIN = -777600.39302d;
    static final double O70_COASC1_MAX = 1553150.33462d;
    static final double O70_COASC1_MIN = -2066.704127d;
    static final double O70_COASC2_MAX = 467.280896d;
    static final double O70_COASC2_MIN = 319.225068d;
    static final double O70_EQUASC_MAX = 393.49442d;
    static final double O70_EQUASC_MIN = 331.162937d;
    static final double O70_HOUSE10_MAX = 393.49442d;
    static final double O70_HOUSE10_MIN = 331.162936d;
    static final double O70_HOUSE11_MAX = 1555199.999991d;
    static final double O70_HOUSE11_MIN = 8.0E-6d;
    static final double O70_HOUSE12_MAX = 1555199.999993d;
    static final double O70_HOUSE12_MIN = 1.5E-5d;
    static final double O70_HOUSE1_MAX = 1555199.608408d;
    static final double O70_HOUSE1_MIN = 0.389863d;
    static final double O70_HOUSE2_MAX = 1555199.999993d;
    static final double O70_HOUSE2_MIN = 1.5E-5d;
    static final double O70_HOUSE3_MAX = 1555199.999991d;
    static final double O70_HOUSE3_MIN = 8.0E-6d;
    static final double O70_HOUSE4_MAX = 393.49442d;
    static final double O70_HOUSE4_MIN = 331.162936d;
    static final double O70_HOUSE5_MAX = 1555199.999991d;
    static final double O70_HOUSE5_MIN = 8.0E-6d;
    static final double O70_HOUSE6_MAX = 1555199.999993d;
    static final double O70_HOUSE6_MIN = 1.5E-5d;
    static final double O70_HOUSE7_MAX = 1555199.608408d;
    static final double O70_HOUSE7_MIN = 0.389863d;
    static final double O70_HOUSE8_MAX = 1555199.999993d;
    static final double O70_HOUSE8_MIN = 1.5E-5d;
    static final double O70_HOUSE9_MAX = 1555199.999991d;
    static final double O70_HOUSE9_MIN = 8.0E-6d;
    static final double O70_MC_MAX = 393.49442d;
    static final double O70_MC_MIN = 331.162936d;
    static final double O70_POLASC_MAX = 179.610407d;
    static final double O70_POLASC_MIN = -2066.757416d;
    static final double O70_VERTEX_MAX = 467.280888d;
    static final double O70_VERTEX_MIN = 319.22507d;
    static final double O80_ARMC_MAX = 360.985931d;
    static final double O80_ARMC_MIN = 360.985828d;
    static final double O80_ASC_MAX = 1554930.566184d;
    static final double O80_ASC_MIN = -777600.124007d;
    static final double O80_COASC1_MAX = 1554930.566243d;
    static final double O80_COASC1_MIN = -269.995683d;
    static final double O80_COASC2_MAX = 426.089536d;
    static final double O80_COASC2_MIN = 328.169552d;
    static final double O80_EQUASC_MAX = 393.49442d;
    static final double O80_EQUASC_MIN = 331.162937d;
    static final double O80_HOUSE10_MAX = 393.49442d;
    static final double O80_HOUSE10_MIN = 331.162936d;
    static final double O80_HOUSE11_MAX = 259454.485276d;
    static final double O80_HOUSE11_MIN = 130.824313d;
    static final double O80_HOUSE12_MAX = 1555199.999998d;
    static final double O80_HOUSE12_MIN = 1.0E-6d;
    static final double O80_HOUSE1_MAX = 1555199.876097d;
    static final double O80_HOUSE1_MIN = 0.12375d;
    static final double O80_HOUSE2_MAX = 1555199.999998d;
    static final double O80_HOUSE2_MIN = 1.0E-6d;
    static final double O80_HOUSE3_MAX = 259454.485276d;
    static final double O80_HOUSE3_MIN = 130.824313d;
    static final double O80_HOUSE4_MAX = 393.49442d;
    static final double O80_HOUSE4_MIN = 331.162936d;
    static final double O80_HOUSE5_MAX = 259454.485276d;
    static final double O80_HOUSE5_MIN = 130.824313d;
    static final double O80_HOUSE6_MAX = 1555199.999998d;
    static final double O80_HOUSE6_MIN = 1.0E-6d;
    static final double O80_HOUSE7_MAX = 1555199.876097d;
    static final double O80_HOUSE7_MIN = 0.12375d;
    static final double O80_HOUSE8_MAX = 1555199.999998d;
    static final double O80_HOUSE8_MIN = 1.0E-6d;
    static final double O80_HOUSE9_MAX = 259454.485276d;
    static final double O80_HOUSE9_MIN = 130.824313d;
    static final double O80_MC_MAX = 393.49442d;
    static final double O80_MC_MIN = 331.162936d;
    static final double O80_POLASC_MAX = 113.797793d;
    static final double O80_POLASC_MIN = -269.996067d;
    static final double O80_VERTEX_MAX = 426.089531d;
    static final double O80_VERTEX_MIN = 328.16955d;
    static final double O85_ARMC_MAX = 360.985931d;
    static final double O85_ARMC_MIN = 360.985828d;
    static final double O85_ASC_MAX = 1555100.603952d;
    static final double O85_ASC_MIN = -777600.058703d;
    static final double O85_COASC1_MAX = 1555100.603957d;
    static final double O85_COASC1_MIN = -99.544583d;
    static final double O85_COASC2_MAX = 409.019308d;
    static final double O85_COASC2_MIN = 330.413985d;
    static final double O85_EQUASC_MAX = 393.49442d;
    static final double O85_EQUASC_MIN = 331.162937d;
    static final double O85_HOUSE10_MAX = 393.49442d;
    static final double O85_HOUSE10_MIN = 331.162936d;
    static final double O85_HOUSE11_MAX = 259460.370169d;
    static final double O85_HOUSE11_MIN = 187.641431d;
    static final double O85_HOUSE12_MAX = 518530.214171d;
    static final double O85_HOUSE12_MIN = 44.048402d;
    static final double O85_HOUSE1_MAX = 1555199.941344d;
    static final double O85_HOUSE1_MIN = 0.058615d;
    static final double O85_HOUSE2_MAX = 518530.214171d;
    static final double O85_HOUSE2_MIN = 44.048402d;
    static final double O85_HOUSE3_MAX = 259460.370169d;
    static final double O85_HOUSE3_MIN = 187.641431d;
    static final double O85_HOUSE4_MAX = 393.49442d;
    static final double O85_HOUSE4_MIN = 331.162936d;
    static final double O85_HOUSE5_MAX = 259460.370169d;
    static final double O85_HOUSE5_MIN = 187.641431d;
    static final double O85_HOUSE6_MAX = 518530.214171d;
    static final double O85_HOUSE6_MIN = 44.048402d;
    static final double O85_HOUSE7_MAX = 1555199.941344d;
    static final double O85_HOUSE7_MIN = 0.058615d;
    static final double O85_HOUSE8_MAX = 518530.214171d;
    static final double O85_HOUSE8_MIN = 44.048402d;
    static final double O85_HOUSE9_MAX = 259460.370169d;
    static final double O85_HOUSE9_MIN = 187.641431d;
    static final double O85_MC_MAX = 393.49442d;
    static final double O85_MC_MIN = 331.162936d;
    static final double O85_POLASC_MAX = 66.096027d;
    static final double O85_POLASC_MIN = -99.544653d;
    static final double O85_VERTEX_MAX = 409.019306d;
    static final double O85_VERTEX_MIN = 330.413985d;
    static final double O88_ARMC_MAX = 360.985931d;
    static final double O88_ARMC_MIN = 360.985828d;
    static final double O88_ASC_MAX = 1555165.554408d;
    static final double O88_ASC_MIN = -777600.02317d;
    static final double O88_COASC1_MAX = 1555165.554409d;
    static final double O88_COASC1_MIN = -34.489296d;
    static final double O88_COASC2_MAX = 399.547623d;
    static final double O88_COASC2_MIN = 331.043079d;
    static final double O88_EQUASC_MAX = 393.49442d;
    static final double O88_EQUASC_MIN = 331.162937d;
    static final double O88_HOUSE10_MAX = 393.49442d;
    static final double O88_HOUSE10_MIN = 331.162936d;
    static final double O88_HOUSE11_MAX = 259462.023358d;
    static final double O88_HOUSE11_MIN = 209.293425d;
    static final double O88_HOUSE12_MAX = 518531.023142d;
    static final double O88_HOUSE12_MIN = 87.418623d;
    static final double O88_HOUSE1_MAX = 1555199.976849d;
    static final double O88_HOUSE1_MIN = 0.023142d;
    static final double O88_HOUSE2_MAX = 518531.023142d;
    static final double O88_HOUSE2_MIN = 87.418623d;
    static final double O88_HOUSE3_MAX = 259462.023358d;
    static final double O88_HOUSE3_MIN = 209.293425d;
    static final double O88_HOUSE4_MAX = 393.49442d;
    static final double O88_HOUSE4_MIN = 331.162936d;
    static final double O88_HOUSE5_MAX = 259462.023358d;
    static final double O88_HOUSE5_MIN = 209.293425d;
    static final double O88_HOUSE6_MAX = 518531.023142d;
    static final double O88_HOUSE6_MIN = 87.418623d;
    static final double O88_HOUSE7_MAX = 1555199.976849d;
    static final double O88_HOUSE7_MIN = 0.023142d;
    static final double O88_HOUSE8_MAX = 518531.023142d;
    static final double O88_HOUSE8_MIN = 87.418623d;
    static final double O88_HOUSE9_MAX = 259462.023358d;
    static final double O88_HOUSE9_MIN = 209.293425d;
    static final double O88_MC_MAX = 393.49442d;
    static final double O88_MC_MIN = 331.162936d;
    static final double O88_POLASC_MAX = 29.34423d;
    static final double O88_POLASC_MIN = -34.489313d;
    static final double O88_VERTEX_MAX = 399.547621d;
    static final double O88_VERTEX_MIN = 331.043081d;
    static final double O90_ARMC_MAX = 360.985931d;
    static final double O90_ARMC_MIN = 360.985828d;
    static final double O90_ASC_MAX = 1555200.0d;
    static final double O90_ASC_MIN = -777600.0d;
    static final double O90_COASC1_MAX = 1555200.0d;
    static final double O90_COASC1_MIN = -0.0d;
    static final double O90_COASC2_MAX = 393.49442d;
    static final double O90_COASC2_MIN = 331.162937d;
    static final double O90_EQUASC_MAX = 393.49442d;
    static final double O90_EQUASC_MIN = 331.162937d;
    static final double O90_HOUSE10_MAX = 393.49442d;
    static final double O90_HOUSE10_MIN = 331.162936d;
    static final double O90_HOUSE11_MAX = 259462.329614d;
    static final double O90_HOUSE11_MIN = 220.775291d;
    static final double O90_HOUSE12_MAX = 518531.164807d;
    static final double O90_HOUSE12_MIN = 110.387645d;
    static final double O90_HOUSE1_MAX = 1555200.0d;
    static final double O90_HOUSE1_MIN = 0.0d;
    static final double O90_HOUSE2_MAX = 518531.164807d;
    static final double O90_HOUSE2_MIN = 110.387645d;
    static final double O90_HOUSE3_MAX = 259462.329614d;
    static final double O90_HOUSE3_MIN = 220.775291d;
    static final double O90_HOUSE4_MAX = 393.49442d;
    static final double O90_HOUSE4_MIN = 331.162936d;
    static final double O90_HOUSE5_MAX = 259462.329614d;
    static final double O90_HOUSE5_MIN = 220.775291d;
    static final double O90_HOUSE6_MAX = 518531.164807d;
    static final double O90_HOUSE6_MIN = 110.387645d;
    static final double O90_HOUSE7_MAX = 1555200.0d;
    static final double O90_HOUSE7_MIN = 0.0d;
    static final double O90_HOUSE8_MAX = 518531.164807d;
    static final double O90_HOUSE8_MIN = 110.387645d;
    static final double O90_HOUSE9_MAX = 259462.329614d;
    static final double O90_HOUSE9_MIN = 220.775291d;
    static final double O90_MC_MAX = 393.49442d;
    static final double O90_MC_MIN = 331.162936d;
    static final double O90_POLASC_MAX = 0.0d;
    static final double O90_POLASC_MIN = -0.0d;
    static final double O90_VERTEX_MAX = 393.49442d;
    static final double O90_VERTEX_MIN = 331.162937d;
    static final double P0_ARMC_MAX = 360.985931d;
    static final double P0_ARMC_MIN = 360.985828d;
    static final double P0_ASC_MAX = 393.49442d;
    static final double P0_ASC_MIN = 331.162937d;
    static final double P0_COASC1_MAX = 393.49442d;
    static final double P0_COASC1_MIN = 331.162937d;
    static final double P0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P0_EQUASC_MAX = 393.49442d;
    static final double P0_EQUASC_MIN = 331.162937d;
    static final double P0_HOUSE10_MAX = 393.49442d;
    static final double P0_HOUSE10_MIN = 331.162936d;
    static final double P0_HOUSE11_MAX = 393.49442d;
    static final double P0_HOUSE11_MIN = 331.162936d;
    static final double P0_HOUSE12_MAX = 393.49442d;
    static final double P0_HOUSE12_MIN = 331.162937d;
    static final double P0_HOUSE1_MAX = 393.49442d;
    static final double P0_HOUSE1_MIN = 331.162937d;
    static final double P0_HOUSE2_MAX = 393.49442d;
    static final double P0_HOUSE2_MIN = 331.162937d;
    static final double P0_HOUSE3_MAX = 393.494421d;
    static final double P0_HOUSE3_MIN = 331.162936d;
    static final double P0_HOUSE4_MAX = 393.49442d;
    static final double P0_HOUSE4_MIN = 331.162936d;
    static final double P0_HOUSE5_MAX = 393.49442d;
    static final double P0_HOUSE5_MIN = 331.162936d;
    static final double P0_HOUSE6_MAX = 393.49442d;
    static final double P0_HOUSE6_MIN = 331.162937d;
    static final double P0_HOUSE7_MAX = 393.49442d;
    static final double P0_HOUSE7_MIN = 331.162937d;
    static final double P0_HOUSE8_MAX = 393.49442d;
    static final double P0_HOUSE8_MIN = 331.162937d;
    static final double P0_HOUSE9_MAX = 393.494421d;
    static final double P0_HOUSE9_MIN = 331.162936d;
    static final double P0_MC_MAX = 393.49442d;
    static final double P0_MC_MIN = 331.162936d;
    static final double P0_POLASC_MAX = 393.49442d;
    static final double P0_POLASC_MIN = 331.162937d;
    static final double P0_VERTEX_MAX = 777600.0d;
    static final double P0_VERTEX_MIN = -777600.0d;
    static final double P10_ARMC_MAX = 360.985931d;
    static final double P10_ARMC_MIN = 360.985828d;
    static final double P10_ASC_MAX = 426.089536d;
    static final double P10_ASC_MIN = 328.169552d;
    static final double P10_COASC1_MAX = 426.089531d;
    static final double P10_COASC1_MIN = 328.16955d;
    static final double P10_COASC2_MAX = 113.797795d;
    static final double P10_COASC2_MIN = -269.99607d;
    static final double P10_EQUASC_MAX = 393.49442d;
    static final double P10_EQUASC_MIN = 331.162937d;
    static final double P10_HOUSE10_MAX = 393.49442d;
    static final double P10_HOUSE10_MIN = 331.162936d;
    static final double P10_HOUSE11_MAX = 403.790854d;
    static final double P10_HOUSE11_MIN = 330.822162d;
    static final double P10_HOUSE12_MAX = 414.640615d;
    static final double P10_HOUSE12_MIN = 329.812399d;
    static final double P10_HOUSE1_MAX = 426.089536d;
    static final double P10_HOUSE1_MIN = 328.169552d;
    static final double P10_HOUSE2_MAX = 414.640616d;
    static final double P10_HOUSE2_MIN = 329.812397d;
    static final double P10_HOUSE3_MAX = 403.790856d;
    static final double P10_HOUSE3_MIN = 330.822162d;
    static final double P10_HOUSE4_MAX = 393.49442d;
    static final double P10_HOUSE4_MIN = 331.162936d;
    static final double P10_HOUSE5_MAX = 403.790854d;
    static final double P10_HOUSE5_MIN = 330.822162d;
    static final double P10_HOUSE6_MAX = 414.640615d;
    static final double P10_HOUSE6_MIN = 329.812399d;
    static final double P10_HOUSE7_MAX = 426.089536d;
    static final double P10_HOUSE7_MIN = 328.169552d;
    static final double P10_HOUSE8_MAX = 414.640616d;
    static final double P10_HOUSE8_MIN = 329.812397d;
    static final double P10_HOUSE9_MAX = 403.790856d;
    static final double P10_HOUSE9_MIN = 330.822162d;
    static final double P10_MC_MAX = 393.49442d;
    static final double P10_MC_MIN = 331.162936d;
    static final double P10_POLASC_MAX = 426.089531d;
    static final double P10_POLASC_MIN = 328.16955d;
    static final double P10_VERTEX_MAX = 1554930.566243d;
    static final double P10_VERTEX_MIN = -777600.124028d;
    static final double P20_ARMC_MAX = 360.985931d;
    static final double P20_ARMC_MIN = 360.985828d;
    static final double P20_ASC_MAX = 467.280896d;
    static final double P20_ASC_MIN = 319.225068d;
    static final double P20_COASC1_MAX = 467.280888d;
    static final double P20_COASC1_MIN = 319.22507d;
    static final double P20_COASC2_MAX = 179.610407d;
    static final double P20_COASC2_MIN = -2066.7575d;
    static final double P20_EQUASC_MAX = 393.49442d;
    static final double P20_EQUASC_MIN = 331.162937d;
    static final double P20_HOUSE10_MAX = 393.49442d;
    static final double P20_HOUSE10_MIN = 331.162936d;
    static final double P20_HOUSE11_MAX = 415.356872d;
    static final double P20_HOUSE11_MIN = 329.698504d;
    static final double P20_HOUSE12_MAX = 439.791585d;
    static final double P20_HOUSE12_MIN = 325.53223d;
    static final double P20_HOUSE1_MAX = 467.280896d;
    static final double P20_HOUSE1_MIN = 319.225068d;
    static final double P20_HOUSE2_MAX = 439.791586d;
    static final double P20_HOUSE2_MIN = 325.532229d;
    static final double P20_HOUSE3_MAX = 415.356874d;
    static final double P20_HOUSE3_MIN = 329.698504d;
    static final double P20_HOUSE4_MAX = 393.49442d;
    static final double P20_HOUSE4_MIN = 331.162936d;
    static final double P20_HOUSE5_MAX = 415.356872d;
    static final double P20_HOUSE5_MIN = 329.698504d;
    static final double P20_HOUSE6_MAX = 439.791585d;
    static final double P20_HOUSE6_MIN = 325.53223d;
    static final double P20_HOUSE7_MAX = 467.280896d;
    static final double P20_HOUSE7_MIN = 319.225068d;
    static final double P20_HOUSE8_MAX = 439.791586d;
    static final double P20_HOUSE8_MIN = 325.532229d;
    static final double P20_HOUSE9_MAX = 415.356874d;
    static final double P20_HOUSE9_MIN = 329.698504d;
    static final double P20_MC_MAX = 393.49442d;
    static final double P20_MC_MIN = 331.162936d;
    static final double P20_POLASC_MAX = 467.280888d;
    static final double P20_POLASC_MIN = 319.22507d;
    static final double P20_VERTEX_MAX = 1553150.33462d;
    static final double P20_VERTEX_MIN = -777600.393091d;
    static final double P30_ARMC_MAX = 360.985931d;
    static final double P30_ARMC_MIN = 360.985828d;
    static final double P30_ASC_MAX = 524.994891d;
    static final double P30_ASC_MIN = 304.407972d;
    static final double P30_COASC1_MAX = 524.994878d;
    static final double P30_COASC1_MIN = 304.407972d;
    static final double P30_COASC2_MAX = 1583.084164d;
    static final double P30_COASC2_MIN = 220.207028d;
    static final double P30_EQUASC_MAX = 393.49442d;
    static final double P30_EQUASC_MIN = 331.162937d;
    static final double P30_HOUSE10_MAX = 393.49442d;
    static final double P30_HOUSE10_MIN = 331.162936d;
    static final double P30_HOUSE11_MAX = 429.341506d;
    static final double P30_HOUSE11_MIN = 327.422098d;
    static final double P30_HOUSE12_MAX = 472.374519d;
    static final double P30_HOUSE12_MIN = 317.609869d;
    static final double P30_HOUSE1_MAX = 524.994891d;
    static final double P30_HOUSE1_MIN = 304.407972d;
    static final double P30_HOUSE2_MAX = 472.37452d;
    static final double P30_HOUSE2_MIN = 317.60987d;
    static final double P30_HOUSE3_MAX = 429.341508d;
    static final double P30_HOUSE3_MIN = 327.4221d;
    static final double P30_HOUSE4_MAX = 393.49442d;
    static final double P30_HOUSE4_MIN = 331.162936d;
    static final double P30_HOUSE5_MAX = 429.341506d;
    static final double P30_HOUSE5_MIN = 327.422098d;
    static final double P30_HOUSE6_MAX = 472.374519d;
    static final double P30_HOUSE6_MIN = 317.609869d;
    static final double P30_HOUSE7_MAX = 524.994891d;
    static final double P30_HOUSE7_MIN = 304.407972d;
    static final double P30_HOUSE8_MAX = 472.37452d;
    static final double P30_HOUSE8_MIN = 317.60987d;
    static final double P30_HOUSE9_MAX = 429.341508d;
    static final double P30_HOUSE9_MIN = 327.4221d;
    static final double P30_MC_MAX = 393.49442d;
    static final double P30_MC_MIN = 331.162936d;
    static final double P30_POLASC_MAX = 524.994878d;
    static final double P30_POLASC_MIN = 304.407972d;
    static final double P30_VERTEX_MAX = 1583.084212d;
    static final double P30_VERTEX_MIN = 220.207025d;
    static final double P40_ARMC_MAX = 360.985931d;
    static final double P40_ARMC_MIN = 360.985828d;
    static final double P40_ASC_MAX = 618.738596d;
    static final double P40_ASC_MIN = 283.720808d;
    static final double P40_COASC1_MAX = 618.738574d;
    static final double P40_COASC1_MIN = 283.720804d;
    static final double P40_COASC2_MAX = 814.745889d;
    static final double P40_COASC2_MIN = 256.684961d;
    static final double P40_EQUASC_MAX = 393.49442d;
    static final double P40_EQUASC_MIN = 331.162937d;
    static final double P40_HOUSE10_MAX = 393.49442d;
    static final double P40_HOUSE10_MIN = 331.162936d;
    static final double P40_HOUSE11_MAX = 447.837693d;
    static final double P40_HOUSE11_MIN = 323.089002d;
    static final double P40_HOUSE12_MAX = 519.596154d;
    static final double P40_HOUSE12_MIN = 304.779671d;
    static final double P40_HOUSE1_MAX = 618.738596d;
    static final double P40_HOUSE1_MIN = 283.720808d;
    static final double P40_HOUSE2_MAX = 519.596156d;
    static final double P40_HOUSE2_MIN = 304.779671d;
    static final double P40_HOUSE3_MAX = 447.837695d;
    static final double P40_HOUSE3_MIN = 323.089002d;
    static final double P40_HOUSE4_MAX = 393.49442d;
    static final double P40_HOUSE4_MIN = 331.162936d;
    static final double P40_HOUSE5_MAX = 447.837693d;
    static final double P40_HOUSE5_MIN = 323.089002d;
    static final double P40_HOUSE6_MAX = 519.596154d;
    static final double P40_HOUSE6_MIN = 304.779671d;
    static final double P40_HOUSE7_MAX = 618.738596d;
    static final double P40_HOUSE7_MIN = 283.720808d;
    static final double P40_HOUSE8_MAX = 519.596156d;
    static final double P40_HOUSE8_MIN = 304.779671d;
    static final double P40_HOUSE9_MAX = 447.837695d;
    static final double P40_HOUSE9_MIN = 323.089002d;
    static final double P40_MC_MAX = 393.49442d;
    static final double P40_MC_MIN = 331.162936d;
    static final double P40_POLASC_MAX = 618.738574d;
    static final double P40_POLASC_MIN = 283.720804d;
    static final double P40_VERTEX_MAX = 814.74585d;
    static final double P40_VERTEX_MIN = 256.68496d;
    static final double P50_ARMC_MAX = 360.985931d;
    static final double P50_ARMC_MIN = 360.985828d;
    static final double P50_ASC_MAX = 814.745889d;
    static final double P50_ASC_MIN = 256.684961d;
    static final double P50_COASC1_MAX = 814.74585d;
    static final double P50_COASC1_MIN = 256.68496d;
    static final double P50_COASC2_MAX = 618.738596d;
    static final double P50_COASC2_MIN = 283.720808d;
    static final double P50_EQUASC_MAX = 393.49442d;
    static final double P50_EQUASC_MIN = 331.162937d;
    static final double P50_HOUSE10_MAX = 393.49442d;
    static final double P50_HOUSE10_MIN = 331.162936d;
    static final double P50_HOUSE11_MAX = 475.432767d;
    static final double P50_HOUSE11_MIN = 314.502994d;
    static final double P50_HOUSE12_MAX = 600.470193d;
    static final double P50_HOUSE12_MIN = 285.008627d;
    static final double P50_HOUSE1_MAX = 814.745889d;
    static final double P50_HOUSE1_MIN = 256.684961d;
    static final double P50_HOUSE2_MAX = 600.470197d;
    static final double P50_HOUSE2_MIN = 285.008628d;
    static final double P50_HOUSE3_MAX = 475.43277d;
    static final double P50_HOUSE3_MIN = 314.502994d;
    static final double P50_HOUSE4_MAX = 393.49442d;
    static final double P50_HOUSE4_MIN = 331.162936d;
    static final double P50_HOUSE5_MAX = 475.432767d;
    static final double P50_HOUSE5_MIN = 314.502994d;
    static final double P50_HOUSE6_MAX = 600.470193d;
    static final double P50_HOUSE6_MIN = 285.008627d;
    static final double P50_HOUSE7_MAX = 814.745889d;
    static final double P50_HOUSE7_MIN = 256.684961d;
    static final double P50_HOUSE8_MAX = 600.470197d;
    static final double P50_HOUSE8_MIN = 285.008628d;
    static final double P50_HOUSE9_MAX = 475.43277d;
    static final double P50_HOUSE9_MIN = 314.502994d;
    static final double P50_MC_MAX = 393.49442d;
    static final double P50_MC_MIN = 331.162936d;
    static final double P50_POLASC_MAX = 814.74585d;
    static final double P50_POLASC_MIN = 256.68496d;
    static final double P50_VERTEX_MAX = 618.738574d;
    static final double P50_VERTEX_MIN = 283.720804d;
    static final double P60_ARMC_MAX = 360.985931d;
    static final double P60_ARMC_MIN = 360.985828d;
    static final double P60_ASC_MAX = 1583.084164d;
    static final double P60_ASC_MIN = 220.207028d;
    static final double P60_COASC1_MAX = 1583.084212d;
    static final double P60_COASC1_MIN = 220.207025d;
    static final double P60_COASC2_MAX = 524.994891d;
    static final double P60_COASC2_MIN = 304.407972d;
    static final double P60_EQUASC_MAX = 393.49442d;
    static final double P60_EQUASC_MIN = 331.162937d;
    static final double P60_HOUSE10_MAX = 393.49442d;
    static final double P60_HOUSE10_MIN = 331.162936d;
    static final double P60_HOUSE11_MAX = 524.994903d;
    static final double P60_HOUSE11_MIN = 295.498614d;
    static final double P60_HOUSE12_MAX = 788.501228d;
    static final double P60_HOUSE12_MIN = 253.591619d;
    static final double P60_HOUSE1_MAX = 1583.084164d;
    static final double P60_HOUSE1_MIN = 220.207028d;
    static final double P60_HOUSE2_MAX = 788.501238d;
    static final double P60_HOUSE2_MIN = 253.591619d;
    static final double P60_HOUSE3_MAX = 524.994905d;
    static final double P60_HOUSE3_MIN = 295.498614d;
    static final double P60_HOUSE4_MAX = 393.49442d;
    static final double P60_HOUSE4_MIN = 331.162936d;
    static final double P60_HOUSE5_MAX = 524.994903d;
    static final double P60_HOUSE5_MIN = 295.498614d;
    static final double P60_HOUSE6_MAX = 788.501228d;
    static final double P60_HOUSE6_MIN = 253.591619d;
    static final double P60_HOUSE7_MAX = 1583.084164d;
    static final double P60_HOUSE7_MIN = 220.207028d;
    static final double P60_HOUSE8_MAX = 788.501238d;
    static final double P60_HOUSE8_MIN = 253.591619d;
    static final double P60_HOUSE9_MAX = 524.994905d;
    static final double P60_HOUSE9_MIN = 295.498614d;
    static final double P60_MC_MAX = 393.49442d;
    static final double P60_MC_MIN = 331.162936d;
    static final double P60_POLASC_MAX = 1583.084212d;
    static final double P60_POLASC_MIN = 220.207025d;
    static final double P60_VERTEX_MAX = 524.994878d;
    static final double P60_VERTEX_MIN = 304.407972d;
    static final double P66_ARMC_MAX = 360.985931d;
    static final double P66_ARMC_MIN = 360.985828d;
    static final double P66_ASC_MAX = 15382.763492d;
    static final double P66_ASC_MIN = 180.714519d;
    static final double P66_COASC1_MAX = 15382.960178d;
    static final double P66_COASC1_MIN = 180.714532d;
    static final double P66_COASC2_MAX = 487.697885d;
    static final double P66_COASC2_MIN = 313.998924d;
    static final double P66_EQUASC_MAX = 393.49442d;
    static final double P66_EQUASC_MIN = 331.162937d;
    static final double P66_HOUSE10_MAX = 393.49442d;
    static final double P66_HOUSE10_MIN = 331.162936d;
    static final double P66_HOUSE11_MAX = 582.790092d;
    static final double P66_HOUSE11_MIN = 263.653337d;
    static final double P66_HOUSE12_MAX = 1123.046149d;
    static final double P66_HOUSE12_MIN = 214.759019d;
    static final double P66_HOUSE1_MAX = 15382.763492d;
    static final double P66_HOUSE1_MIN = 180.714519d;
    static final double P66_HOUSE2_MAX = 1123.046159d;
    static final double P66_HOUSE2_MIN = 214.759019d;
    static final double P66_HOUSE3_MAX = 582.790093d;
    static final double P66_HOUSE3_MIN = 263.653341d;
    static final double P66_HOUSE4_MAX = 393.49442d;
    static final double P66_HOUSE4_MIN = 331.162936d;
    static final double P66_HOUSE5_MAX = 582.790092d;
    static final double P66_HOUSE5_MIN = 263.653337d;
    static final double P66_HOUSE6_MAX = 1123.046149d;
    static final double P66_HOUSE6_MIN = 214.759019d;
    static final double P66_HOUSE7_MAX = 15382.763492d;
    static final double P66_HOUSE7_MIN = 180.714519d;
    static final double P66_HOUSE8_MAX = 1123.046159d;
    static final double P66_HOUSE8_MIN = 214.759019d;
    static final double P66_HOUSE9_MAX = 582.790093d;
    static final double P66_HOUSE9_MIN = 263.653341d;
    static final double P66_MC_MAX = 393.49442d;
    static final double P66_MC_MIN = 331.162936d;
    static final double P66_POLASC_MAX = 15382.960178d;
    static final double P66_POLASC_MIN = 180.714532d;
    static final double P66_VERTEX_MAX = 487.697876d;
    static final double P66_VERTEX_MIN = 313.998925d;
    static final double P70_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double P70_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double P70_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double P70_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double P70_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double P70_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double P70_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P70_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P70_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double P70_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double P70_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double P70_MC_MAX = Double.POSITIVE_INFINITY;
    static final double P70_MC_MIN = Double.POSITIVE_INFINITY;
    static final double P70_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double P70_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double P70_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double P70_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double P80_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double P80_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double P80_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double P80_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double P80_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double P80_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double P80_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P80_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P80_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double P80_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double P80_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double P80_MC_MAX = Double.POSITIVE_INFINITY;
    static final double P80_MC_MIN = Double.POSITIVE_INFINITY;
    static final double P80_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double P80_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double P80_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double P80_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double P85_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double P85_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double P85_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double P85_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double P85_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double P85_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double P85_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P85_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P85_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double P85_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double P85_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double P85_MC_MAX = Double.POSITIVE_INFINITY;
    static final double P85_MC_MIN = Double.POSITIVE_INFINITY;
    static final double P85_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double P85_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double P85_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double P85_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double P88_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double P88_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double P88_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double P88_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double P88_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double P88_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double P88_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P88_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P88_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double P88_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double P88_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double P88_MC_MAX = Double.POSITIVE_INFINITY;
    static final double P88_MC_MIN = Double.POSITIVE_INFINITY;
    static final double P88_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double P88_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double P88_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double P88_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double P90_ARMC_MAX = Double.POSITIVE_INFINITY;
    static final double P90_ARMC_MIN = Double.POSITIVE_INFINITY;
    static final double P90_ASC_MAX = Double.POSITIVE_INFINITY;
    static final double P90_ASC_MIN = Double.POSITIVE_INFINITY;
    static final double P90_COASC1_MAX = Double.POSITIVE_INFINITY;
    static final double P90_COASC1_MIN = Double.POSITIVE_INFINITY;
    static final double P90_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double P90_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double P90_EQUASC_MAX = Double.POSITIVE_INFINITY;
    static final double P90_EQUASC_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE10_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE10_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE11_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE11_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE12_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE12_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE1_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE1_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE2_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE2_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE3_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE3_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE4_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE4_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE5_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE5_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE6_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE6_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE7_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE7_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE8_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE8_MIN = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE9_MAX = Double.POSITIVE_INFINITY;
    static final double P90_HOUSE9_MIN = Double.POSITIVE_INFINITY;
    static final double P90_MC_MAX = Double.POSITIVE_INFINITY;
    static final double P90_MC_MIN = Double.POSITIVE_INFINITY;
    static final double P90_POLASC_MAX = Double.POSITIVE_INFINITY;
    static final double P90_POLASC_MIN = Double.POSITIVE_INFINITY;
    static final double P90_VERTEX_MAX = Double.POSITIVE_INFINITY;
    static final double P90_VERTEX_MIN = Double.POSITIVE_INFINITY;
    static final double R0_ARMC_MAX = 360.985931d;
    static final double R0_ARMC_MIN = 360.985828d;
    static final double R0_ASC_MAX = 393.49442d;
    static final double R0_ASC_MIN = 331.162937d;
    static final double R0_COASC1_MAX = 393.49442d;
    static final double R0_COASC1_MIN = 331.162937d;
    static final double R0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double R0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double R0_EQUASC_MAX = 393.49442d;
    static final double R0_EQUASC_MIN = 331.162937d;
    static final double R0_HOUSE10_MAX = 393.49442d;
    static final double R0_HOUSE10_MIN = 331.162936d;
    static final double R0_HOUSE11_MAX = 393.49442d;
    static final double R0_HOUSE11_MIN = 331.162936d;
    static final double R0_HOUSE12_MAX = 393.49442d;
    static final double R0_HOUSE12_MIN = 331.162937d;
    static final double R0_HOUSE1_MAX = 393.49442d;
    static final double R0_HOUSE1_MIN = 331.162937d;
    static final double R0_HOUSE2_MAX = 393.49442d;
    static final double R0_HOUSE2_MIN = 331.162937d;
    static final double R0_HOUSE3_MAX = 393.494421d;
    static final double R0_HOUSE3_MIN = 331.162936d;
    static final double R0_HOUSE4_MAX = 393.49442d;
    static final double R0_HOUSE4_MIN = 331.162936d;
    static final double R0_HOUSE5_MAX = 393.49442d;
    static final double R0_HOUSE5_MIN = 331.162936d;
    static final double R0_HOUSE6_MAX = 393.49442d;
    static final double R0_HOUSE6_MIN = 331.162937d;
    static final double R0_HOUSE7_MAX = 393.49442d;
    static final double R0_HOUSE7_MIN = 331.162937d;
    static final double R0_HOUSE8_MAX = 393.49442d;
    static final double R0_HOUSE8_MIN = 331.162937d;
    static final double R0_HOUSE9_MAX = 393.494421d;
    static final double R0_HOUSE9_MIN = 331.162936d;
    static final double R0_MC_MAX = 393.49442d;
    static final double R0_MC_MIN = 331.162936d;
    static final double R0_POLASC_MAX = 393.49442d;
    static final double R0_POLASC_MIN = 331.162937d;
    static final double R0_VERTEX_MAX = 777600.0d;
    static final double R0_VERTEX_MIN = -777600.0d;
    static final double R10_ARMC_MAX = 360.985931d;
    static final double R10_ARMC_MIN = 360.985828d;
    static final double R10_ASC_MAX = 426.089536d;
    static final double R10_ASC_MIN = 328.169552d;
    static final double R10_COASC1_MAX = 426.089531d;
    static final double R10_COASC1_MIN = 328.16955d;
    static final double R10_COASC2_MAX = 113.797795d;
    static final double R10_COASC2_MIN = -269.99607d;
    static final double R10_EQUASC_MAX = 393.49442d;
    static final double R10_EQUASC_MIN = 331.162937d;
    static final double R10_HOUSE10_MAX = 393.49442d;
    static final double R10_HOUSE10_MIN = 331.162936d;
    static final double R10_HOUSE11_MAX = 409.143818d;
    static final double R10_HOUSE11_MIN = 330.402452d;
    static final double R10_HOUSE12_MAX = 421.412785d;
    static final double R10_HOUSE12_MIN = 328.905912d;
    static final double R10_HOUSE1_MAX = 426.089536d;
    static final double R10_HOUSE1_MIN = 328.169552d;
    static final double R10_HOUSE2_MAX = 421.412786d;
    static final double R10_HOUSE2_MIN = 328.905911d;
    static final double R10_HOUSE3_MAX = 409.143819d;
    static final double R10_HOUSE3_MIN = 330.402452d;
    static final double R10_HOUSE4_MAX = 393.49442d;
    static final double R10_HOUSE4_MIN = 331.162936d;
    static final double R10_HOUSE5_MAX = 409.143818d;
    static final double R10_HOUSE5_MIN = 330.402452d;
    static final double R10_HOUSE6_MAX = 421.412785d;
    static final double R10_HOUSE6_MIN = 328.905912d;
    static final double R10_HOUSE7_MAX = 426.089536d;
    static final double R10_HOUSE7_MIN = 328.169552d;
    static final double R10_HOUSE8_MAX = 421.412786d;
    static final double R10_HOUSE8_MIN = 328.905911d;
    static final double R10_HOUSE9_MAX = 409.143819d;
    static final double R10_HOUSE9_MIN = 330.402452d;
    static final double R10_MC_MAX = 393.49442d;
    static final double R10_MC_MIN = 331.162936d;
    static final double R10_POLASC_MAX = 426.089531d;
    static final double R10_POLASC_MIN = 328.16955d;
    static final double R10_VERTEX_MAX = 1554930.566243d;
    static final double R10_VERTEX_MIN = -777600.124028d;
    static final double R20_ARMC_MAX = 360.985931d;
    static final double R20_ARMC_MIN = 360.985828d;
    static final double R20_ASC_MAX = 467.280896d;
    static final double R20_ASC_MIN = 319.225068d;
    static final double R20_COASC1_MAX = 467.280888d;
    static final double R20_COASC1_MIN = 319.22507d;
    static final double R20_COASC2_MAX = 179.610407d;
    static final double R20_COASC2_MIN = -2066.7575d;
    static final double R20_EQUASC_MAX = 393.49442d;
    static final double R20_EQUASC_MIN = 331.162937d;
    static final double R20_HOUSE10_MAX = 393.49442d;
    static final double R20_HOUSE10_MIN = 331.162936d;
    static final double R20_HOUSE11_MAX = 427.225134d;
    static final double R20_HOUSE11_MIN = 327.978769d;
    static final double R20_HOUSE12_MAX = 455.82938d;
    static final double R20_HOUSE12_MIN = 322.019861d;
    static final double R20_HOUSE1_MAX = 467.280896d;
    static final double R20_HOUSE1_MIN = 319.225068d;
    static final double R20_HOUSE2_MAX = 455.829381d;
    static final double R20_HOUSE2_MIN = 322.019861d;
    static final double R20_HOUSE3_MAX = 427.225136d;
    static final double R20_HOUSE3_MIN = 327.978771d;
    static final double R20_HOUSE4_MAX = 393.49442d;
    static final double R20_HOUSE4_MIN = 331.162936d;
    static final double R20_HOUSE5_MAX = 427.225134d;
    static final double R20_HOUSE5_MIN = 327.978769d;
    static final double R20_HOUSE6_MAX = 455.82938d;
    static final double R20_HOUSE6_MIN = 322.019861d;
    static final double R20_HOUSE7_MAX = 467.280896d;
    static final double R20_HOUSE7_MIN = 319.225068d;
    static final double R20_HOUSE8_MAX = 455.829381d;
    static final double R20_HOUSE8_MIN = 322.019861d;
    static final double R20_HOUSE9_MAX = 427.225136d;
    static final double R20_HOUSE9_MIN = 327.978771d;
    static final double R20_MC_MAX = 393.49442d;
    static final double R20_MC_MIN = 331.162936d;
    static final double R20_POLASC_MAX = 467.280888d;
    static final double R20_POLASC_MIN = 319.22507d;
    static final double R20_VERTEX_MAX = 1553150.33462d;
    static final double R20_VERTEX_MIN = -777600.393091d;
    static final double R30_ARMC_MAX = 360.985931d;
    static final double R30_ARMC_MIN = 360.985828d;
    static final double R30_ASC_MAX = 524.994891d;
    static final double R30_ASC_MIN = 304.407972d;
    static final double R30_COASC1_MAX = 524.994878d;
    static final double R30_COASC1_MIN = 304.407972d;
    static final double R30_COASC2_MAX = 1583.084164d;
    static final double R30_COASC2_MIN = 220.207028d;
    static final double R30_EQUASC_MAX = 393.49442d;
    static final double R30_EQUASC_MIN = 331.162937d;
    static final double R30_HOUSE10_MAX = 393.49442d;
    static final double R30_HOUSE10_MIN = 331.162936d;
    static final double R30_HOUSE11_MAX = 449.831169d;
    static final double R30_HOUSE11_MIN = 323.414436d;
    static final double R30_HOUSE12_MAX = 502.496859d;
    static final double R30_HOUSE12_MIN = 310.155614d;
    static final double R30_HOUSE1_MAX = 524.994891d;
    static final double R30_HOUSE1_MIN = 304.407972d;
    static final double R30_HOUSE2_MAX = 502.496861d;
    static final double R30_HOUSE2_MIN = 310.155614d;
    static final double R30_HOUSE3_MAX = 449.831172d;
    static final double R30_HOUSE3_MIN = 323.414435d;
    static final double R30_HOUSE4_MAX = 393.49442d;
    static final double R30_HOUSE4_MIN = 331.162936d;
    static final double R30_HOUSE5_MAX = 449.831169d;
    static final double R30_HOUSE5_MIN = 323.414436d;
    static final double R30_HOUSE6_MAX = 502.496859d;
    static final double R30_HOUSE6_MIN = 310.155614d;
    static final double R30_HOUSE7_MAX = 524.994891d;
    static final double R30_HOUSE7_MIN = 304.407972d;
    static final double R30_HOUSE8_MAX = 502.496861d;
    static final double R30_HOUSE8_MIN = 310.155614d;
    static final double R30_HOUSE9_MAX = 449.831172d;
    static final double R30_HOUSE9_MIN = 323.414435d;
    static final double R30_MC_MAX = 393.49442d;
    static final double R30_MC_MIN = 331.162936d;
    static final double R30_POLASC_MAX = 524.994878d;
    static final double R30_POLASC_MIN = 304.407972d;
    static final double R30_VERTEX_MAX = 1583.084212d;
    static final double R30_VERTEX_MIN = 220.207025d;
    static final double R40_ARMC_MAX = 360.985931d;
    static final double R40_ARMC_MIN = 360.985828d;
    static final double R40_ASC_MAX = 618.738596d;
    static final double R40_ASC_MIN = 283.720808d;
    static final double R40_COASC1_MAX = 618.738574d;
    static final double R40_COASC1_MIN = 283.720804d;
    static final double R40_COASC2_MAX = 814.745889d;
    static final double R40_COASC2_MIN = 256.684961d;
    static final double R40_EQUASC_MAX = 393.49442d;
    static final double R40_EQUASC_MIN = 331.162937d;
    static final double R40_HOUSE10_MAX = 393.49442d;
    static final double R40_HOUSE10_MIN = 331.162936d;
    static final double R40_HOUSE11_MAX = 481.055615d;
    static final double R40_HOUSE11_MIN = 315.718503d;
    static final double R40_HOUSE12_MAX = 574.667482d;
    static final double R40_HOUSE12_MIN = 292.699861d;
    static final double R40_HOUSE1_MAX = 618.738596d;
    static final double R40_HOUSE1_MIN = 283.720808d;
    static final double R40_HOUSE2_MAX = 574.667486d;
    static final double R40_HOUSE2_MIN = 292.699861d;
    static final double R40_HOUSE3_MAX = 481.055618d;
    static final double R40_HOUSE3_MIN = 315.718503d;
    static final double R40_HOUSE4_MAX = 393.49442d;
    static final double R40_HOUSE4_MIN = 331.162936d;
    static final double R40_HOUSE5_MAX = 481.055615d;
    static final double R40_HOUSE5_MIN = 315.718503d;
    static final double R40_HOUSE6_MAX = 574.667482d;
    static final double R40_HOUSE6_MIN = 292.699861d;
    static final double R40_HOUSE7_MAX = 618.738596d;
    static final double R40_HOUSE7_MIN = 283.720808d;
    static final double R40_HOUSE8_MAX = 574.667486d;
    static final double R40_HOUSE8_MIN = 292.699861d;
    static final double R40_HOUSE9_MAX = 481.055618d;
    static final double R40_HOUSE9_MIN = 315.718503d;
    static final double R40_MC_MAX = 393.49442d;
    static final double R40_MC_MIN = 331.162936d;
    static final double R40_POLASC_MAX = 618.738574d;
    static final double R40_POLASC_MIN = 283.720804d;
    static final double R40_VERTEX_MAX = 814.74585d;
    static final double R40_VERTEX_MIN = 256.68496d;
    static final double R50_ARMC_MAX = 360.985931d;
    static final double R50_ARMC_MIN = 360.985828d;
    static final double R50_ASC_MAX = 814.745889d;
    static final double R50_ASC_MIN = 256.684961d;
    static final double R50_COASC1_MAX = 814.74585d;
    static final double R50_COASC1_MIN = 256.68496d;
    static final double R50_COASC2_MAX = 618.738596d;
    static final double R50_COASC2_MIN = 283.720808d;
    static final double R50_EQUASC_MAX = 393.49442d;
    static final double R50_EQUASC_MIN = 331.162937d;
    static final double R50_HOUSE10_MAX = 393.49442d;
    static final double R50_HOUSE10_MIN = 331.162936d;
    static final double R50_HOUSE11_MAX = 530.685783d;
    static final double R50_HOUSE11_MIN = 302.989184d;
    static final double R50_HOUSE12_MAX = 712.548542d;
    static final double R50_HOUSE12_MIN = 268.606056d;
    static final double R50_HOUSE1_MAX = 814.745889d;
    static final double R50_HOUSE1_MIN = 256.684961d;
    static final double R50_HOUSE2_MAX = 712.548553d;
    static final double R50_HOUSE2_MIN = 268.606055d;
    static final double R50_HOUSE3_MAX = 530.685789d;
    static final double R50_HOUSE3_MIN = 302.989185d;
    static final double R50_HOUSE4_MAX = 393.49442d;
    static final double R50_HOUSE4_MIN = 331.162936d;
    static final double R50_HOUSE5_MAX = 530.685783d;
    static final double R50_HOUSE5_MIN = 302.989184d;
    static final double R50_HOUSE6_MAX = 712.548542d;
    static final double R50_HOUSE6_MIN = 268.606056d;
    static final double R50_HOUSE7_MAX = 814.745889d;
    static final double R50_HOUSE7_MIN = 256.684961d;
    static final double R50_HOUSE8_MAX = 712.548553d;
    static final double R50_HOUSE8_MIN = 268.606055d;
    static final double R50_HOUSE9_MAX = 530.685789d;
    static final double R50_HOUSE9_MIN = 302.989185d;
    static final double R50_MC_MAX = 393.49442d;
    static final double R50_MC_MIN = 331.162936d;
    static final double R50_POLASC_MAX = 814.74585d;
    static final double R50_POLASC_MIN = 256.68496d;
    static final double R50_VERTEX_MAX = 618.738574d;
    static final double R50_VERTEX_MIN = 283.720804d;
    static final double R60_ARMC_MAX = 360.985931d;
    static final double R60_ARMC_MIN = 360.985828d;
    static final double R60_ASC_MAX = 1583.084164d;
    static final double R60_ASC_MIN = 220.207028d;
    static final double R60_COASC1_MAX = 1583.084212d;
    static final double R60_COASC1_MIN = 220.207025d;
    static final double R60_COASC2_MAX = 524.994891d;
    static final double R60_COASC2_MIN = 304.407972d;
    static final double R60_EQUASC_MAX = 393.49442d;
    static final double R60_EQUASC_MIN = 331.162937d;
    static final double R60_HOUSE10_MAX = 393.49442d;
    static final double R60_HOUSE10_MIN = 331.162936d;
    static final double R60_HOUSE11_MAX = 630.316442d;
    static final double R60_HOUSE11_MIN = 281.578681d;
    static final double R60_HOUSE12_MAX = 1126.731333d;
    static final double R60_HOUSE12_MIN = 235.319792d;
    static final double R60_HOUSE1_MAX = 1583.084164d;
    static final double R60_HOUSE1_MIN = 220.207028d;
    static final double R60_HOUSE2_MAX = 1126.731409d;
    static final double R60_HOUSE2_MIN = 235.319792d;
    static final double R60_HOUSE3_MAX = 630.316454d;
    static final double R60_HOUSE3_MIN = 281.57868d;
    static final double R60_HOUSE4_MAX = 393.49442d;
    static final double R60_HOUSE4_MIN = 331.162936d;
    static final double R60_HOUSE5_MAX = 630.316442d;
    static final double R60_HOUSE5_MIN = 281.578681d;
    static final double R60_HOUSE6_MAX = 1126.731333d;
    static final double R60_HOUSE6_MIN = 235.319792d;
    static final double R60_HOUSE7_MAX = 1583.084164d;
    static final double R60_HOUSE7_MIN = 220.207028d;
    static final double R60_HOUSE8_MAX = 1126.731409d;
    static final double R60_HOUSE8_MIN = 235.319792d;
    static final double R60_HOUSE9_MAX = 630.316454d;
    static final double R60_HOUSE9_MIN = 281.57868d;
    static final double R60_MC_MAX = 393.49442d;
    static final double R60_MC_MIN = 331.162936d;
    static final double R60_POLASC_MAX = 1583.084212d;
    static final double R60_POLASC_MIN = 220.207025d;
    static final double R60_VERTEX_MAX = 524.994878d;
    static final double R60_VERTEX_MIN = 304.407972d;
    static final double R66_ARMC_MAX = 360.985931d;
    static final double R66_ARMC_MIN = 360.985828d;
    static final double R66_ASC_MAX = 15382.763492d;
    static final double R66_ASC_MIN = 180.714519d;
    static final double R66_COASC1_MAX = 15382.960178d;
    static final double R66_COASC1_MIN = 180.714532d;
    static final double R66_COASC2_MAX = 487.697885d;
    static final double R66_COASC2_MIN = 313.998924d;
    static final double R66_EQUASC_MAX = 393.49442d;
    static final double R66_EQUASC_MIN = 331.162937d;
    static final double R66_HOUSE10_MAX = 393.49442d;
    static final double R66_HOUSE10_MIN = 331.162936d;
    static final double R66_HOUSE11_MAX = 767.365572d;
    static final double R66_HOUSE11_MIN = 261.742666d;
    static final double R66_HOUSE12_MAX = 2520.433379d;
    static final double R66_HOUSE12_MIN = 206.200959d;
    static final double R66_HOUSE1_MAX = 15382.763492d;
    static final double R66_HOUSE1_MIN = 180.714519d;
    static final double R66_HOUSE2_MAX = 2520.434718d;
    static final double R66_HOUSE2_MIN = 206.200958d;
    static final double R66_HOUSE3_MAX = 767.365603d;
    static final double R66_HOUSE3_MIN = 261.742665d;
    static final double R66_HOUSE4_MAX = 393.49442d;
    static final double R66_HOUSE4_MIN = 331.162936d;
    static final double R66_HOUSE5_MAX = 767.365572d;
    static final double R66_HOUSE5_MIN = 261.742666d;
    static final double R66_HOUSE6_MAX = 2520.433379d;
    static final double R66_HOUSE6_MIN = 206.200959d;
    static final double R66_HOUSE7_MAX = 15382.763492d;
    static final double R66_HOUSE7_MIN = 180.714519d;
    static final double R66_HOUSE8_MAX = 2520.434718d;
    static final double R66_HOUSE8_MIN = 206.200958d;
    static final double R66_HOUSE9_MAX = 767.365603d;
    static final double R66_HOUSE9_MIN = 261.742665d;
    static final double R66_MC_MAX = 393.49442d;
    static final double R66_MC_MIN = 331.162936d;
    static final double R66_POLASC_MAX = 15382.960178d;
    static final double R66_POLASC_MIN = 180.714532d;
    static final double R66_VERTEX_MAX = 487.697876d;
    static final double R66_VERTEX_MIN = 313.998925d;
    static final double R70_ARMC_MAX = 360.985931d;
    static final double R70_ARMC_MIN = 360.985828d;
    static final double R70_ASC_MAX = 1553150.32968d;
    static final double R70_ASC_MIN = -777600.39302d;
    static final double R70_COASC1_MAX = 1553150.33462d;
    static final double R70_COASC1_MIN = -2066.704127d;
    static final double R70_COASC2_MAX = 467.280896d;
    static final double R70_COASC2_MIN = 319.225068d;
    static final double R70_EQUASC_MAX = 393.49442d;
    static final double R70_EQUASC_MIN = 331.162937d;
    static final double R70_HOUSE10_MAX = 777947.502418d;
    static final double R70_HOUSE10_MIN = 331.162936d;
    static final double R70_HOUSE11_MAX = 778156.125875d;
    static final double R70_HOUSE11_MIN = 243.832233d;
    static final double R70_HOUSE12_MAX = 1555199.999973d;
    static final double R70_HOUSE12_MIN = 2.6E-5d;
    static final double R70_HOUSE1_MAX = 1555199.608408d;
    static final double R70_HOUSE1_MIN = 0.389863d;
    static final double R70_HOUSE2_MAX = 1555199.999981d;
    static final double R70_HOUSE2_MIN = 3.0E-6d;
    static final double R70_HOUSE3_MAX = 778156.120386d;
    static final double R70_HOUSE3_MIN = 243.832233d;
    static final double R70_HOUSE4_MAX = 777947.502418d;
    static final double R70_HOUSE4_MIN = 331.162936d;
    static final double R70_HOUSE5_MAX = 778156.125875d;
    static final double R70_HOUSE5_MIN = 243.832233d;
    static final double R70_HOUSE6_MAX = 1555199.999973d;
    static final double R70_HOUSE6_MIN = 2.6E-5d;
    static final double R70_HOUSE7_MAX = 1555199.608408d;
    static final double R70_HOUSE7_MIN = 0.389863d;
    static final double R70_HOUSE8_MAX = 1555199.999981d;
    static final double R70_HOUSE8_MIN = 3.0E-6d;
    static final double R70_HOUSE9_MAX = 778156.120386d;
    static final double R70_HOUSE9_MIN = 243.832233d;
    static final double R70_MC_MAX = 777947.502418d;
    static final double R70_MC_MIN = -777252.648535d;
    static final double R70_POLASC_MAX = 179.610407d;
    static final double R70_POLASC_MIN = -2066.757416d;
    static final double R70_VERTEX_MAX = 467.280888d;
    static final double R70_VERTEX_MIN = 319.22507d;
    static final double R80_ARMC_MAX = 360.985931d;
    static final double R80_ARMC_MIN = 360.985828d;
    static final double R80_ASC_MAX = 1554930.566184d;
    static final double R80_ASC_MIN = -777600.124007d;
    static final double R80_COASC1_MAX = 1554930.566243d;
    static final double R80_COASC1_MIN = -269.995683d;
    static final double R80_COASC2_MAX = 426.089536d;
    static final double R80_COASC2_MIN = 328.169552d;
    static final double R80_EQUASC_MAX = 393.49442d;
    static final double R80_EQUASC_MIN = 331.162937d;
    static final double R80_HOUSE10_MAX = 777981.666378d;
    static final double R80_HOUSE10_MIN = 331.162936d;
    static final double R80_HOUSE11_MAX = 1555199.999999d;
    static final double R80_HOUSE11_MIN = 8.0E-6d;
    static final double R80_HOUSE12_MAX = 1555199.999998d;
    static final double R80_HOUSE12_MIN = 2.0E-6d;
    static final double R80_HOUSE1_MAX = 1555199.876097d;
    static final double R80_HOUSE1_MIN = 0.12375d;
    static final double R80_HOUSE2_MAX = 1555199.999998d;
    static final double R80_HOUSE2_MIN = 1.0E-6d;
    static final double R80_HOUSE3_MAX = 1555199.999993d;
    static final double R80_HOUSE3_MIN = 9.0E-6d;
    static final double R80_HOUSE4_MAX = 777981.666378d;
    static final double R80_HOUSE4_MIN = 331.162936d;
    static final double R80_HOUSE5_MAX = 1555199.999999d;
    static final double R80_HOUSE5_MIN = 8.0E-6d;
    static final double R80_HOUSE6_MAX = 1555199.999998d;
    static final double R80_HOUSE6_MIN = 2.0E-6d;
    static final double R80_HOUSE7_MAX = 1555199.876097d;
    static final double R80_HOUSE7_MIN = 0.12375d;
    static final double R80_HOUSE8_MAX = 1555199.999998d;
    static final double R80_HOUSE8_MIN = 1.0E-6d;
    static final double R80_HOUSE9_MAX = 1555199.999993d;
    static final double R80_HOUSE9_MIN = 9.0E-6d;
    static final double R80_MC_MAX = 777981.666378d;
    static final double R80_MC_MIN = -777218.490322d;
    static final double R80_POLASC_MAX = 113.797793d;
    static final double R80_POLASC_MIN = -269.996067d;
    static final double R80_VERTEX_MAX = 426.089531d;
    static final double R80_VERTEX_MIN = 328.16955d;
    static final double R85_ARMC_MAX = 360.985931d;
    static final double R85_ARMC_MIN = 360.985828d;
    static final double R85_ASC_MAX = 1555100.603952d;
    static final double R85_ASC_MIN = -777600.058703d;
    static final double R85_COASC1_MAX = 1555100.603957d;
    static final double R85_COASC1_MIN = -99.544583d;
    static final double R85_COASC2_MAX = 409.019308d;
    static final double R85_COASC2_MIN = 330.413985d;
    static final double R85_EQUASC_MAX = 393.49442d;
    static final double R85_EQUASC_MIN = 331.162937d;
    static final double R85_HOUSE10_MAX = 777990.526167d;
    static final double R85_HOUSE10_MIN = 331.162936d;
    static final double R85_HOUSE11_MAX = 1555200.0d;
    static final double R85_HOUSE11_MIN = 0.0d;
    static final double R85_HOUSE12_MAX = 1555200.0d;
    static final double R85_HOUSE12_MIN = 0.0d;
    static final double R85_HOUSE1_MAX = 1555199.941344d;
    static final double R85_HOUSE1_MIN = 0.058615d;
    static final double R85_HOUSE2_MAX = 1555199.999998d;
    static final double R85_HOUSE2_MIN = 0.0d;
    static final double R85_HOUSE3_MAX = 1555200.0d;
    static final double R85_HOUSE3_MIN = 0.0d;
    static final double R85_HOUSE4_MAX = 777990.526167d;
    static final double R85_HOUSE4_MIN = 331.162936d;
    static final double R85_HOUSE5_MAX = 1555200.0d;
    static final double R85_HOUSE5_MIN = 0.0d;
    static final double R85_HOUSE6_MAX = 1555200.0d;
    static final double R85_HOUSE6_MIN = 0.0d;
    static final double R85_HOUSE7_MAX = 1555199.941344d;
    static final double R85_HOUSE7_MIN = 0.058615d;
    static final double R85_HOUSE8_MAX = 1555199.999998d;
    static final double R85_HOUSE8_MIN = 0.0d;
    static final double R85_HOUSE9_MAX = 1555200.0d;
    static final double R85_HOUSE9_MIN = 0.0d;
    static final double R85_MC_MAX = 777990.526167d;
    static final double R85_MC_MIN = -777209.599297d;
    static final double R85_POLASC_MAX = 66.096027d;
    static final double R85_POLASC_MIN = -99.544653d;
    static final double R85_VERTEX_MAX = 409.019306d;
    static final double R85_VERTEX_MIN = 330.413985d;
    static final double R88_ARMC_MAX = 360.985931d;
    static final double R88_ARMC_MIN = 360.985828d;
    static final double R88_ASC_MAX = 1555165.554408d;
    static final double R88_ASC_MIN = -777600.02317d;
    static final double R88_COASC1_MAX = 1555165.554409d;
    static final double R88_COASC1_MIN = -34.489296d;
    static final double R88_COASC2_MAX = 399.547623d;
    static final double R88_COASC2_MIN = 331.043079d;
    static final double R88_EQUASC_MAX = 393.49442d;
    static final double R88_EQUASC_MIN = 331.162937d;
    static final double R88_HOUSE10_MAX = 777993.023575d;
    static final double R88_HOUSE10_MIN = 331.162936d;
    static final double R88_HOUSE11_MAX = 1555199.999999d;
    static final double R88_HOUSE11_MIN = 1.0E-6d;
    static final double R88_HOUSE12_MAX = 1555200.0d;
    static final double R88_HOUSE12_MIN = 0.0d;
    static final double R88_HOUSE1_MAX = 1555199.976849d;
    static final double R88_HOUSE1_MIN = 0.023142d;
    static final double R88_HOUSE2_MAX = 1555200.0d;
    static final double R88_HOUSE2_MIN = 1.0E-6d;
    static final double R88_HOUSE3_MAX = 1555200.0d;
    static final double R88_HOUSE3_MIN = 1.0E-6d;
    static final double R88_HOUSE4_MAX = 777993.023575d;
    static final double R88_HOUSE4_MIN = 331.162936d;
    static final double R88_HOUSE5_MAX = 1555199.999999d;
    static final double R88_HOUSE5_MIN = 1.0E-6d;
    static final double R88_HOUSE6_MAX = 1555200.0d;
    static final double R88_HOUSE6_MIN = 0.0d;
    static final double R88_HOUSE7_MAX = 1555199.976849d;
    static final double R88_HOUSE7_MIN = 0.023142d;
    static final double R88_HOUSE8_MAX = 1555200.0d;
    static final double R88_HOUSE8_MIN = 1.0E-6d;
    static final double R88_HOUSE9_MAX = 1555200.0d;
    static final double R88_HOUSE9_MIN = 1.0E-6d;
    static final double R88_MC_MAX = 777993.023523d;
    static final double R88_MC_MIN = -777207.078222d;
    static final double R88_POLASC_MAX = 29.34423d;
    static final double R88_POLASC_MIN = -34.489313d;
    static final double R88_VERTEX_MAX = 399.547621d;
    static final double R88_VERTEX_MIN = 331.043081d;
    static final double R90_ARMC_MAX = 360.985929d;
    static final double R90_ARMC_MIN = 360.985828d;
    static final double R90_ASC_MAX = 1555200.0d;
    static final double R90_ASC_MIN = -777600.0d;
    static final double R90_COASC1_MAX = 1555200.0d;
    static final double R90_COASC1_MIN = -0.0d;
    static final double R90_COASC2_MAX = 393.49442d;
    static final double R90_COASC2_MIN = 331.162937d;
    static final double R90_EQUASC_MAX = 393.49442d;
    static final double R90_EQUASC_MIN = 331.162937d;
    static final double R90_HOUSE10_MAX = 777993.49442d;
    static final double R90_HOUSE10_MIN = 331.162936d;
    static final double R90_HOUSE11_MAX = 1555200.0d;
    static final double R90_HOUSE11_MIN = 0.0d;
    static final double R90_HOUSE12_MAX = 1555200.0d;
    static final double R90_HOUSE12_MIN = 0.0d;
    static final double R90_HOUSE1_MAX = 1555200.0d;
    static final double R90_HOUSE1_MIN = 0.0d;
    static final double R90_HOUSE2_MAX = 1555200.0d;
    static final double R90_HOUSE2_MIN = 0.0d;
    static final double R90_HOUSE3_MAX = 1555200.0d;
    static final double R90_HOUSE3_MIN = 0.0d;
    static final double R90_HOUSE4_MAX = 777993.49442d;
    static final double R90_HOUSE4_MIN = 331.162936d;
    static final double R90_HOUSE5_MAX = 1555200.0d;
    static final double R90_HOUSE5_MIN = 0.0d;
    static final double R90_HOUSE6_MAX = 1555200.0d;
    static final double R90_HOUSE6_MIN = 0.0d;
    static final double R90_HOUSE7_MAX = 1555200.0d;
    static final double R90_HOUSE7_MIN = 0.0d;
    static final double R90_HOUSE8_MAX = 1555200.0d;
    static final double R90_HOUSE8_MIN = 0.0d;
    static final double R90_HOUSE9_MAX = 1555200.0d;
    static final double R90_HOUSE9_MIN = 0.0d;
    static final double R90_MC_MAX = 393.494367d;
    static final double R90_MC_MIN = -777206.525627d;
    static final double R90_POLASC_MAX = 0.0d;
    static final double R90_POLASC_MIN = -0.0d;
    static final double R90_VERTEX_MAX = 393.49442d;
    static final double R90_VERTEX_MIN = 331.162937d;
    static final double T10_ARMC_MAX = 360.985931d;
    static final double T10_ARMC_MIN = 360.985828d;
    static final double T10_ASC_MAX = 426.089536d;
    static final double T10_ASC_MIN = 328.169552d;
    static final double T10_COASC1_MAX = 426.089531d;
    static final double T10_COASC1_MIN = 328.16955d;
    static final double T10_COASC2_MAX = 113.797795d;
    static final double T10_COASC2_MIN = -269.99607d;
    static final double T10_EQUASC_MAX = 393.49442d;
    static final double T10_EQUASC_MIN = 331.162937d;
    static final double T10_HOUSE10_MAX = 393.49442d;
    static final double T10_HOUSE10_MIN = 331.162936d;
    static final double T10_HOUSE11_MAX = 403.790854d;
    static final double T10_HOUSE11_MIN = 330.823922d;
    static final double T10_HOUSE12_MAX = 414.640615d;
    static final double T10_HOUSE12_MIN = 329.816633d;
    static final double T10_HOUSE1_MAX = 426.089536d;
    static final double T10_HOUSE1_MIN = 328.169552d;
    static final double T10_HOUSE2_MAX = 414.640616d;
    static final double T10_HOUSE2_MIN = 329.816636d;
    static final double T10_HOUSE3_MAX = 403.790856d;
    static final double T10_HOUSE3_MIN = 330.823923d;
    static final double T10_HOUSE4_MAX = 393.49442d;
    static final double T10_HOUSE4_MIN = 331.162936d;
    static final double T10_HOUSE5_MAX = 403.790854d;
    static final double T10_HOUSE5_MIN = 330.823922d;
    static final double T10_HOUSE6_MAX = 414.640615d;
    static final double T10_HOUSE6_MIN = 329.816633d;
    static final double T10_HOUSE7_MAX = 426.089536d;
    static final double T10_HOUSE7_MIN = 328.169552d;
    static final double T10_HOUSE8_MAX = 414.640616d;
    static final double T10_HOUSE8_MIN = 329.816636d;
    static final double T10_HOUSE9_MAX = 403.790856d;
    static final double T10_HOUSE9_MIN = 330.823923d;
    static final double T10_MC_MAX = 393.49442d;
    static final double T10_MC_MIN = 331.162936d;
    static final double T10_POLASC_MAX = 426.089531d;
    static final double T10_POLASC_MIN = 328.16955d;
    static final double T10_VERTEX_MAX = 1554930.566243d;
    static final double T10_VERTEX_MIN = -777600.124028d;
    static final double T20_ARMC_MAX = 360.985931d;
    static final double T20_ARMC_MIN = 360.985828d;
    static final double T20_ASC_MAX = 467.280896d;
    static final double T20_ASC_MIN = 319.225068d;
    static final double T20_COASC1_MAX = 467.280888d;
    static final double T20_COASC1_MIN = 319.22507d;
    static final double T20_COASC2_MAX = 179.610407d;
    static final double T20_COASC2_MIN = -2066.7575d;
    static final double T20_EQUASC_MAX = 393.49442d;
    static final double T20_EQUASC_MIN = 331.162937d;
    static final double T20_HOUSE10_MAX = 393.49442d;
    static final double T20_HOUSE10_MIN = 331.162936d;
    static final double T20_HOUSE11_MAX = 415.356872d;
    static final double T20_HOUSE11_MIN = 329.729745d;
    static final double T20_HOUSE12_MAX = 439.791585d;
    static final double T20_HOUSE12_MIN = 325.599538d;
    static final double T20_HOUSE1_MAX = 467.280896d;
    static final double T20_HOUSE1_MIN = 319.225068d;
    static final double T20_HOUSE2_MAX = 439.791586d;
    static final double T20_HOUSE2_MIN = 325.599539d;
    static final double T20_HOUSE3_MAX = 415.356874d;
    static final double T20_HOUSE3_MIN = 329.729746d;
    static final double T20_HOUSE4_MAX = 393.49442d;
    static final double T20_HOUSE4_MIN = 331.162936d;
    static final double T20_HOUSE5_MAX = 415.356872d;
    static final double T20_HOUSE5_MIN = 329.729745d;
    static final double T20_HOUSE6_MAX = 439.791585d;
    static final double T20_HOUSE6_MIN = 325.599538d;
    static final double T20_HOUSE7_MAX = 467.280896d;
    static final double T20_HOUSE7_MIN = 319.225068d;
    static final double T20_HOUSE8_MAX = 439.791586d;
    static final double T20_HOUSE8_MIN = 325.599539d;
    static final double T20_HOUSE9_MAX = 415.356874d;
    static final double T20_HOUSE9_MIN = 329.729746d;
    static final double T20_MC_MAX = 393.49442d;
    static final double T20_MC_MIN = 331.162936d;
    static final double T20_POLASC_MAX = 467.280888d;
    static final double T20_POLASC_MIN = 319.22507d;
    static final double T20_VERTEX_MAX = 1553150.33462d;
    static final double T20_VERTEX_MIN = -777600.393091d;
    static final double T30_ARMC_MAX = 360.985931d;
    static final double T30_ARMC_MIN = 360.985828d;
    static final double T30_ASC_MAX = 524.994891d;
    static final double T30_ASC_MIN = 304.407972d;
    static final double T30_COASC1_MAX = 524.994878d;
    static final double T30_COASC1_MIN = 304.407972d;
    static final double T30_COASC2_MAX = 1583.084164d;
    static final double T30_COASC2_MIN = 220.207028d;
    static final double T30_EQUASC_MAX = 393.49442d;
    static final double T30_EQUASC_MIN = 331.162937d;
    static final double T30_HOUSE10_MAX = 393.49442d;
    static final double T30_HOUSE10_MIN = 331.162936d;
    static final double T30_HOUSE11_MAX = 429.341506d;
    static final double T30_HOUSE11_MIN = 327.611506d;
    static final double T30_HOUSE12_MAX = 472.374518d;
    static final double T30_HOUSE12_MIN = 317.941733d;
    static final double T30_HOUSE1_MAX = 524.994891d;
    static final double T30_HOUSE1_MIN = 304.407972d;
    static final double T30_HOUSE2_MAX = 472.37452d;
    static final double T30_HOUSE2_MIN = 317.941733d;
    static final double T30_HOUSE3_MAX = 429.341508d;
    static final double T30_HOUSE3_MIN = 327.611509d;
    static final double T30_HOUSE4_MAX = 393.49442d;
    static final double T30_HOUSE4_MIN = 331.162936d;
    static final double T30_HOUSE5_MAX = 429.341506d;
    static final double T30_HOUSE5_MIN = 327.611506d;
    static final double T30_HOUSE6_MAX = 472.374518d;
    static final double T30_HOUSE6_MIN = 317.941733d;
    static final double T30_HOUSE7_MAX = 524.994891d;
    static final double T30_HOUSE7_MIN = 304.407972d;
    static final double T30_HOUSE8_MAX = 472.37452d;
    static final double T30_HOUSE8_MIN = 317.941733d;
    static final double T30_HOUSE9_MAX = 429.341508d;
    static final double T30_HOUSE9_MIN = 327.611509d;
    static final double T30_MC_MAX = 393.49442d;
    static final double T30_MC_MIN = 331.162936d;
    static final double T30_POLASC_MAX = 524.994878d;
    static final double T30_POLASC_MIN = 304.407972d;
    static final double T30_VERTEX_MAX = 1583.084212d;
    static final double T30_VERTEX_MIN = 220.207025d;
    static final double T40_ARMC_MAX = 360.985931d;
    static final double T40_ARMC_MIN = 360.985828d;
    static final double T40_ASC_MAX = 618.738596d;
    static final double T40_ASC_MIN = 283.720808d;
    static final double T40_COASC1_MAX = 618.738574d;
    static final double T40_COASC1_MIN = 283.720804d;
    static final double T40_COASC2_MAX = 814.745889d;
    static final double T40_COASC2_MIN = 256.684961d;
    static final double T40_EQUASC_MAX = 393.49442d;
    static final double T40_EQUASC_MIN = 331.162937d;
    static final double T40_HOUSE10_MAX = 393.49442d;
    static final double T40_HOUSE10_MIN = 331.162936d;
    static final double T40_HOUSE11_MAX = 447.837692d;
    static final double T40_HOUSE11_MIN = 323.864511d;
    static final double T40_HOUSE12_MAX = 519.596152d;
    static final double T40_HOUSE12_MIN = 305.768972d;
    static final double T40_HOUSE1_MAX = 618.738596d;
    static final double T40_HOUSE1_MIN = 283.720808d;
    static final double T40_HOUSE2_MAX = 519.596154d;
    static final double T40_HOUSE2_MIN = 305.768972d;
    static final double T40_HOUSE3_MAX = 447.837694d;
    static final double T40_HOUSE3_MIN = 323.864511d;
    static final double T40_HOUSE4_MAX = 393.49442d;
    static final double T40_HOUSE4_MIN = 331.162936d;
    static final double T40_HOUSE5_MAX = 447.837692d;
    static final double T40_HOUSE5_MIN = 323.864511d;
    static final double T40_HOUSE6_MAX = 519.596152d;
    static final double T40_HOUSE6_MIN = 305.768972d;
    static final double T40_HOUSE7_MAX = 618.738596d;
    static final double T40_HOUSE7_MIN = 283.720808d;
    static final double T40_HOUSE8_MAX = 519.596154d;
    static final double T40_HOUSE8_MIN = 305.768972d;
    static final double T40_HOUSE9_MAX = 447.837694d;
    static final double T40_HOUSE9_MIN = 323.864511d;
    static final double T40_MC_MAX = 393.49442d;
    static final double T40_MC_MIN = 331.162936d;
    static final double T40_POLASC_MAX = 618.738574d;
    static final double T40_POLASC_MIN = 283.720804d;
    static final double T40_VERTEX_MAX = 814.74585d;
    static final double T40_VERTEX_MIN = 256.68496d;
    static final double T50_ARMC_MAX = 360.985931d;
    static final double T50_ARMC_MIN = 360.985828d;
    static final double T50_ASC_MAX = 814.745889d;
    static final double T50_ASC_MIN = 256.684961d;
    static final double T50_COASC1_MAX = 814.74585d;
    static final double T50_COASC1_MIN = 256.68496d;
    static final double T50_COASC2_MAX = 618.738596d;
    static final double T50_COASC2_MIN = 283.720808d;
    static final double T50_EQUASC_MAX = 393.49442d;
    static final double T50_EQUASC_MIN = 331.162937d;
    static final double T50_HOUSE10_MAX = 393.49442d;
    static final double T50_HOUSE10_MIN = 331.162936d;
    static final double T50_HOUSE11_MAX = 475.432763d;
    static final double T50_HOUSE11_MIN = 317.162818d;
    static final double T50_HOUSE12_MAX = 600.470182d;
    static final double T50_HOUSE12_MIN = 287.280781d;
    static final double T50_HOUSE1_MAX = 814.745889d;
    static final double T50_HOUSE1_MIN = 256.684961d;
    static final double T50_HOUSE2_MAX = 600.470187d;
    static final double T50_HOUSE2_MIN = 287.28078d;
    static final double T50_HOUSE3_MAX = 475.432767d;
    static final double T50_HOUSE3_MIN = 317.162818d;
    static final double T50_HOUSE4_MAX = 393.49442d;
    static final double T50_HOUSE4_MIN = 331.162936d;
    static final double T50_HOUSE5_MAX = 475.432763d;
    static final double T50_HOUSE5_MIN = 317.162818d;
    static final double T50_HOUSE6_MAX = 600.470182d;
    static final double T50_HOUSE6_MIN = 287.280781d;
    static final double T50_HOUSE7_MAX = 814.745889d;
    static final double T50_HOUSE7_MIN = 256.684961d;
    static final double T50_HOUSE8_MAX = 600.470187d;
    static final double T50_HOUSE8_MIN = 287.28078d;
    static final double T50_HOUSE9_MAX = 475.432767d;
    static final double T50_HOUSE9_MIN = 317.162818d;
    static final double T50_MC_MAX = 393.49442d;
    static final double T50_MC_MIN = 331.162936d;
    static final double T50_POLASC_MAX = 814.74585d;
    static final double T50_POLASC_MIN = 256.68496d;
    static final double T50_VERTEX_MAX = 618.738574d;
    static final double T50_VERTEX_MIN = 283.720804d;
    static final double T60_ARMC_MAX = 360.985931d;
    static final double T60_ARMC_MIN = 360.985828d;
    static final double T60_ASC_MAX = 1583.084164d;
    static final double T60_ASC_MIN = 220.207028d;
    static final double T60_COASC1_MAX = 1583.084212d;
    static final double T60_COASC1_MIN = 220.207025d;
    static final double T60_COASC2_MAX = 524.994891d;
    static final double T60_COASC2_MIN = 304.407972d;
    static final double T60_EQUASC_MAX = 393.49442d;
    static final double T60_EQUASC_MIN = 331.162937d;
    static final double T60_HOUSE10_MAX = 393.49442d;
    static final double T60_HOUSE10_MIN = 331.162936d;
    static final double T60_HOUSE11_MAX = 524.994886d;
    static final double T60_HOUSE11_MIN = 304.407972d;
    static final double T60_HOUSE12_MAX = 788.501124d;
    static final double T60_HOUSE12_MIN = 259.397226d;
    static final double T60_HOUSE1_MAX = 1583.084164d;
    static final double T60_HOUSE1_MIN = 220.207028d;
    static final double T60_HOUSE2_MAX = 788.501142d;
    static final double T60_HOUSE2_MIN = 259.397225d;
    static final double T60_HOUSE3_MAX = 524.994891d;
    static final double T60_HOUSE3_MIN = 304.407971d;
    static final double T60_HOUSE4_MAX = 393.49442d;
    static final double T60_HOUSE4_MIN = 331.162936d;
    static final double T60_HOUSE5_MAX = 524.994886d;
    static final double T60_HOUSE5_MIN = 304.407972d;
    static final double T60_HOUSE6_MAX = 788.501124d;
    static final double T60_HOUSE6_MIN = 259.397226d;
    static final double T60_HOUSE7_MAX = 1583.084164d;
    static final double T60_HOUSE7_MIN = 220.207028d;
    static final double T60_HOUSE8_MAX = 788.501142d;
    static final double T60_HOUSE8_MIN = 259.397225d;
    static final double T60_HOUSE9_MAX = 524.994891d;
    static final double T60_HOUSE9_MIN = 304.407971d;
    static final double T60_MC_MAX = 393.49442d;
    static final double T60_MC_MIN = 331.162936d;
    static final double T60_POLASC_MAX = 1583.084212d;
    static final double T60_POLASC_MIN = 220.207025d;
    static final double T60_VERTEX_MAX = 524.994878d;
    static final double T60_VERTEX_MIN = 304.407972d;
    static final double T66_ARMC_MAX = 360.985931d;
    static final double T66_ARMC_MIN = 360.985828d;
    static final double T66_ASC_MAX = 15382.763492d;
    static final double T66_ASC_MIN = 180.714519d;
    static final double T66_COASC1_MAX = 15382.960178d;
    static final double T66_COASC1_MIN = 180.714532d;
    static final double T66_COASC2_MAX = 487.697885d;
    static final double T66_COASC2_MIN = 313.998924d;
    static final double T66_EQUASC_MAX = 393.49442d;
    static final double T66_EQUASC_MIN = 331.162937d;
    static final double T66_HOUSE10_MAX = 393.49442d;
    static final double T66_HOUSE10_MIN = 331.162936d;
    static final double T66_HOUSE11_MAX = 582.790036d;
    static final double T66_HOUSE11_MIN = 290.943764d;
    static final double T66_HOUSE12_MAX = 1123.045219d;
    static final double T66_HOUSE12_MIN = 235.495124d;
    static final double T66_HOUSE1_MAX = 15382.763492d;
    static final double T66_HOUSE1_MIN = 180.714519d;
    static final double T66_HOUSE2_MAX = 1123.045295d;
    static final double T66_HOUSE2_MIN = 235.495123d;
    static final double T66_HOUSE3_MAX = 582.790044d;
    static final double T66_HOUSE3_MIN = 290.943764d;
    static final double T66_HOUSE4_MAX = 393.49442d;
    static final double T66_HOUSE4_MIN = 331.162936d;
    static final double T66_HOUSE5_MAX = 582.790036d;
    static final double T66_HOUSE5_MIN = 290.943764d;
    static final double T66_HOUSE6_MAX = 1123.045219d;
    static final double T66_HOUSE6_MIN = 235.495124d;
    static final double T66_HOUSE7_MAX = 15382.763492d;
    static final double T66_HOUSE7_MIN = 180.714519d;
    static final double T66_HOUSE8_MAX = 1123.045295d;
    static final double T66_HOUSE8_MIN = 235.495123d;
    static final double T66_HOUSE9_MAX = 582.790044d;
    static final double T66_HOUSE9_MIN = 290.943764d;
    static final double T66_MC_MAX = 393.49442d;
    static final double T66_MC_MIN = 331.162936d;
    static final double T66_POLASC_MAX = 15382.960178d;
    static final double T66_POLASC_MIN = 180.714532d;
    static final double T66_VERTEX_MAX = 487.697876d;
    static final double T66_VERTEX_MIN = 313.998925d;
    static final double T70_ARMC_MAX = 360.985931d;
    static final double T70_ARMC_MIN = 360.985828d;
    static final double T70_ASC_MAX = 1553150.32968d;
    static final double T70_ASC_MIN = -777600.39302d;
    static final double T70_COASC1_MAX = 1553150.33462d;
    static final double T70_COASC1_MIN = -2066.704127d;
    static final double T70_COASC2_MAX = 467.280896d;
    static final double T70_COASC2_MIN = 319.225068d;
    static final double T70_EQUASC_MAX = 393.49442d;
    static final double T70_EQUASC_MIN = 331.162937d;
    static final double T70_HOUSE10_MAX = 777947.502418d;
    static final double T70_HOUSE10_MIN = 331.162936d;
    static final double T70_HOUSE11_MAX = 778120.305084d;
    static final double T70_HOUSE11_MIN = 277.639303d;
    static final double T70_HOUSE12_MAX = 779415.313613d;
    static final double T70_HOUSE12_MIN = 213.749348d;
    static final double T70_HOUSE1_MAX = 1555199.608408d;
    static final double T70_HOUSE1_MIN = 0.389863d;
    static final double T70_HOUSE2_MAX = 779415.323087d;
    static final double T70_HOUSE2_MIN = 213.749348d;
    static final double T70_HOUSE3_MAX = 778120.30174d;
    static final double T70_HOUSE3_MIN = 277.639305d;
    static final double T70_HOUSE4_MAX = 777947.502418d;
    static final double T70_HOUSE4_MIN = 331.162936d;
    static final double T70_HOUSE5_MAX = 778120.305084d;
    static final double T70_HOUSE5_MIN = 277.639303d;
    static final double T70_HOUSE6_MAX = 779415.313613d;
    static final double T70_HOUSE6_MIN = 213.749348d;
    static final double T70_HOUSE7_MAX = 1555199.608408d;
    static final double T70_HOUSE7_MIN = 0.389863d;
    static final double T70_HOUSE8_MAX = 779415.323087d;
    static final double T70_HOUSE8_MIN = 213.749348d;
    static final double T70_HOUSE9_MAX = 778120.30174d;
    static final double T70_HOUSE9_MIN = 277.639305d;
    static final double T70_MC_MAX = 777947.502418d;
    static final double T70_MC_MIN = -777252.648535d;
    static final double T70_POLASC_MAX = 179.610407d;
    static final double T70_POLASC_MIN = -2066.757416d;
    static final double T70_VERTEX_MAX = 467.280888d;
    static final double T70_VERTEX_MIN = 319.22507d;
    static final double T80_ARMC_MAX = 360.985931d;
    static final double T80_ARMC_MIN = 360.985828d;
    static final double T80_ASC_MAX = 1554930.566184d;
    static final double T80_ASC_MIN = -777600.124007d;
    static final double T80_COASC1_MAX = 1554930.566243d;
    static final double T80_COASC1_MIN = -269.995683d;
    static final double T80_COASC2_MAX = 426.089536d;
    static final double T80_COASC2_MIN = 328.169552d;
    static final double T80_EQUASC_MAX = 393.49442d;
    static final double T80_EQUASC_MIN = 331.162937d;
    static final double T80_HOUSE10_MAX = 777981.666378d;
    static final double T80_HOUSE10_MIN = 331.162936d;
    static final double T80_HOUSE11_MAX = 779274.695436d;
    static final double T80_HOUSE11_MIN = 209.879728d;
    static final double T80_HOUSE12_MAX = 1555200.0d;
    static final double T80_HOUSE12_MIN = 2.0E-6d;
    static final double T80_HOUSE1_MAX = 1555199.876097d;
    static final double T80_HOUSE1_MIN = 0.12375d;
    static final double T80_HOUSE2_MAX = 1555199.999999d;
    static final double T80_HOUSE2_MIN = 3.0E-6d;
    static final double T80_HOUSE3_MAX = 779274.695159d;
    static final double T80_HOUSE3_MIN = 209.879732d;
    static final double T80_HOUSE4_MAX = 777981.666378d;
    static final double T80_HOUSE4_MIN = 331.162936d;
    static final double T80_HOUSE5_MAX = 779274.695436d;
    static final double T80_HOUSE5_MIN = 209.879728d;
    static final double T80_HOUSE6_MAX = 1555200.0d;
    static final double T80_HOUSE6_MIN = 2.0E-6d;
    static final double T80_HOUSE7_MAX = 1555199.876097d;
    static final double T80_HOUSE7_MIN = 0.12375d;
    static final double T80_HOUSE8_MAX = 1555199.999999d;
    static final double T80_HOUSE8_MIN = 3.0E-6d;
    static final double T80_HOUSE9_MAX = 779274.695159d;
    static final double T80_HOUSE9_MIN = 209.879732d;
    static final double T80_MC_MAX = 777981.666378d;
    static final double T80_MC_MIN = -777218.490322d;
    static final double T80_POLASC_MAX = 113.797793d;
    static final double T80_POLASC_MIN = -269.996067d;
    static final double T80_VERTEX_MAX = 426.089531d;
    static final double T80_VERTEX_MIN = 328.16955d;
    static final double T85_ARMC_MAX = 360.985931d;
    static final double T85_ARMC_MIN = 360.985828d;
    static final double T85_ASC_MAX = 1555100.603952d;
    static final double T85_ASC_MIN = -777600.058703d;
    static final double T85_COASC1_MAX = 1555100.603957d;
    static final double T85_COASC1_MIN = -99.544583d;
    static final double T85_COASC2_MAX = 409.019308d;
    static final double T85_COASC2_MIN = 330.413985d;
    static final double T85_EQUASC_MAX = 393.49442d;
    static final double T85_EQUASC_MIN = 331.162937d;
    static final double T85_HOUSE10_MAX = 777990.526167d;
    static final double T85_HOUSE10_MIN = 331.162936d;
    static final double T85_HOUSE11_MAX = 1555199.999994d;
    static final double T85_HOUSE11_MIN = 5.0E-6d;
    static final double T85_HOUSE12_MAX = 1555199.999999d;
    static final double T85_HOUSE12_MIN = 1.0E-6d;
    static final double T85_HOUSE1_MAX = 1555199.941344d;
    static final double T85_HOUSE1_MIN = 0.058615d;
    static final double T85_HOUSE2_MAX = 1555199.999992d;
    static final double T85_HOUSE2_MIN = 0.0d;
    static final double T85_HOUSE3_MAX = 1555199.999999d;
    static final double T85_HOUSE3_MIN = 0.0d;
    static final double T85_HOUSE4_MAX = 777990.526167d;
    static final double T85_HOUSE4_MIN = 331.162936d;
    static final double T85_HOUSE5_MAX = 1555199.999994d;
    static final double T85_HOUSE5_MIN = 5.0E-6d;
    static final double T85_HOUSE6_MAX = 1555199.999999d;
    static final double T85_HOUSE6_MIN = 1.0E-6d;
    static final double T85_HOUSE7_MAX = 1555199.941344d;
    static final double T85_HOUSE7_MIN = 0.058615d;
    static final double T85_HOUSE8_MAX = 1555199.999992d;
    static final double T85_HOUSE8_MIN = 0.0d;
    static final double T85_HOUSE9_MAX = 1555199.999999d;
    static final double T85_HOUSE9_MIN = 0.0d;
    static final double T85_MC_MAX = 777990.526167d;
    static final double T85_MC_MIN = -777209.599297d;
    static final double T85_POLASC_MAX = 66.096027d;
    static final double T85_POLASC_MIN = -99.544653d;
    static final double T85_VERTEX_MAX = 409.019306d;
    static final double T85_VERTEX_MIN = 330.413985d;
    static final double T88_ARMC_MAX = 360.985931d;
    static final double T88_ARMC_MIN = 360.985828d;
    static final double T88_ASC_MAX = 1555165.554408d;
    static final double T88_ASC_MIN = -777600.02317d;
    static final double T88_COASC1_MAX = 1555165.554409d;
    static final double T88_COASC1_MIN = -34.489296d;
    static final double T88_COASC2_MAX = 399.547623d;
    static final double T88_COASC2_MIN = 331.043079d;
    static final double T88_EQUASC_MAX = 393.49442d;
    static final double T88_EQUASC_MIN = 331.162937d;
    static final double T88_HOUSE10_MAX = 777993.023575d;
    static final double T88_HOUSE10_MIN = 331.162936d;
    static final double T88_HOUSE11_MAX = 1555199.999996d;
    static final double T88_HOUSE11_MIN = 1.0E-6d;
    static final double T88_HOUSE12_MAX = 1555200.0d;
    static final double T88_HOUSE12_MIN = 1.0E-6d;
    static final double T88_HOUSE1_MAX = 1555199.976849d;
    static final double T88_HOUSE1_MIN = 0.023142d;
    static final double T88_HOUSE2_MAX = 1555200.0d;
    static final double T88_HOUSE2_MIN = 0.0d;
    static final double T88_HOUSE3_MAX = 1555200.0d;
    static final double T88_HOUSE3_MIN = 0.0d;
    static final double T88_HOUSE4_MAX = 777993.023575d;
    static final double T88_HOUSE4_MIN = 331.162936d;
    static final double T88_HOUSE5_MAX = 1555199.999996d;
    static final double T88_HOUSE5_MIN = 1.0E-6d;
    static final double T88_HOUSE6_MAX = 1555200.0d;
    static final double T88_HOUSE6_MIN = 1.0E-6d;
    static final double T88_HOUSE7_MAX = 1555199.976849d;
    static final double T88_HOUSE7_MIN = 0.023142d;
    static final double T88_HOUSE8_MAX = 1555200.0d;
    static final double T88_HOUSE8_MIN = 0.0d;
    static final double T88_HOUSE9_MAX = 1555200.0d;
    static final double T88_HOUSE9_MIN = 0.0d;
    static final double T88_MC_MAX = 777993.023523d;
    static final double T88_MC_MIN = -777207.078222d;
    static final double T88_POLASC_MAX = 29.34423d;
    static final double T88_POLASC_MIN = -34.489313d;
    static final double T88_VERTEX_MAX = 399.547621d;
    static final double T88_VERTEX_MIN = 331.043081d;
    static final double T90_ARMC_MAX = 360.985912d;
    static final double T90_ARMC_MIN = 360.985907d;
    static final double T90_ASC_MAX = 1555200.0d;
    static final double T90_ASC_MIN = -777600.0d;
    static final double T90_COASC1_MAX = 1555200.0d;
    static final double T90_COASC1_MIN = -0.0d;
    static final double T90_COASC2_MAX = 393.489619d;
    static final double T90_COASC2_MIN = 331.167116d;
    static final double T90_EQUASC_MAX = 393.489619d;
    static final double T90_EQUASC_MIN = 331.167116d;
    static final double T90_HOUSE10_MAX = 777993.489627d;
    static final double T90_HOUSE10_MIN = 331.167125d;
    static final double T90_HOUSE11_MAX = 1555200.0d;
    static final double T90_HOUSE11_MIN = 0.0d;
    static final double T90_HOUSE12_MAX = 1555200.0d;
    static final double T90_HOUSE12_MIN = 0.0d;
    static final double T90_HOUSE1_MAX = 1555200.0d;
    static final double T90_HOUSE1_MIN = 0.0d;
    static final double T90_HOUSE2_MAX = 1555200.0d;
    static final double T90_HOUSE2_MIN = 0.0d;
    static final double T90_HOUSE3_MAX = 1555200.0d;
    static final double T90_HOUSE3_MIN = 0.0d;
    static final double T90_HOUSE4_MAX = 777993.489627d;
    static final double T90_HOUSE4_MIN = 331.167125d;
    static final double T90_HOUSE5_MAX = 1555200.0d;
    static final double T90_HOUSE5_MIN = 0.0d;
    static final double T90_HOUSE6_MAX = 1555200.0d;
    static final double T90_HOUSE6_MIN = 0.0d;
    static final double T90_HOUSE7_MAX = 1555200.0d;
    static final double T90_HOUSE7_MIN = 0.0d;
    static final double T90_HOUSE8_MAX = 1555200.0d;
    static final double T90_HOUSE8_MIN = 0.0d;
    static final double T90_HOUSE9_MAX = 1555200.0d;
    static final double T90_HOUSE9_MIN = 0.0d;
    static final double T90_MC_MAX = 393.489571d;
    static final double T90_MC_MIN = -777206.51039d;
    static final double T90_POLASC_MAX = 0.0d;
    static final double T90_POLASC_MIN = -0.0d;
    static final double T90_VERTEX_MAX = 393.489619d;
    static final double T90_VERTEX_MIN = 331.167116d;
    static final double U0_ARMC_MAX = 360.985931d;
    static final double U0_ARMC_MIN = 360.985828d;
    static final double U0_ASC_MAX = 393.49442d;
    static final double U0_ASC_MIN = 331.162937d;
    static final double U0_COASC1_MAX = 393.49442d;
    static final double U0_COASC1_MIN = 331.162937d;
    static final double U0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double U0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double U0_EQUASC_MAX = 393.49442d;
    static final double U0_EQUASC_MIN = 331.162937d;
    static final double U0_HOUSE10_MAX = 393.49442d;
    static final double U0_HOUSE10_MIN = 331.162936d;
    static final double U0_HOUSE11_MAX = 383.575205d;
    static final double U0_HOUSE11_MIN = 341.146541d;
    static final double U0_HOUSE12_MAX = 381.083914d;
    static final double U0_HOUSE12_MIN = 341.114232d;
    static final double U0_HOUSE1_MAX = 393.49442d;
    static final double U0_HOUSE1_MIN = 331.162937d;
    static final double U0_HOUSE2_MAX = 381.083912d;
    static final double U0_HOUSE2_MIN = 341.114236d;
    static final double U0_HOUSE3_MAX = 383.575198d;
    static final double U0_HOUSE3_MIN = 341.146541d;
    static final double U0_HOUSE4_MAX = 393.49442d;
    static final double U0_HOUSE4_MIN = 331.162936d;
    static final double U0_HOUSE5_MAX = 383.575205d;
    static final double U0_HOUSE5_MIN = 341.146541d;
    static final double U0_HOUSE6_MAX = 381.083914d;
    static final double U0_HOUSE6_MIN = 341.114232d;
    static final double U0_HOUSE7_MAX = 393.49442d;
    static final double U0_HOUSE7_MIN = 331.162937d;
    static final double U0_HOUSE8_MAX = 381.083912d;
    static final double U0_HOUSE8_MIN = 341.114236d;
    static final double U0_HOUSE9_MAX = 383.575198d;
    static final double U0_HOUSE9_MIN = 341.146541d;
    static final double U0_MC_MAX = 393.49442d;
    static final double U0_MC_MIN = 331.162936d;
    static final double U0_POLASC_MAX = 393.49442d;
    static final double U0_POLASC_MIN = 331.162937d;
    static final double U0_VERTEX_MAX = 777600.0d;
    static final double U0_VERTEX_MIN = -777600.0d;
    static final double U10_ARMC_MAX = 360.985931d;
    static final double U10_ARMC_MIN = 360.985828d;
    static final double U10_ASC_MAX = 426.089536d;
    static final double U10_ASC_MIN = 328.169552d;
    static final double U10_COASC1_MAX = 426.089531d;
    static final double U10_COASC1_MIN = 328.16955d;
    static final double U10_COASC2_MAX = 113.797795d;
    static final double U10_COASC2_MIN = -269.99607d;
    static final double U10_EQUASC_MAX = 393.49442d;
    static final double U10_EQUASC_MIN = 331.162937d;
    static final double U10_HOUSE10_MAX = 393.49442d;
    static final double U10_HOUSE10_MIN = 331.162936d;
    static final double U10_HOUSE11_MAX = 385.88306d;
    static final double U10_HOUSE11_MIN = 335.024068d;
    static final double U10_HOUSE12_MAX = 403.510494d;
    static final double U10_HOUSE12_MIN = 332.530159d;
    static final double U10_HOUSE1_MAX = 426.089536d;
    static final double U10_HOUSE1_MIN = 328.169552d;
    static final double U10_HOUSE2_MAX = 403.510494d;
    static final double U10_HOUSE2_MIN = 332.53016d;
    static final double U10_HOUSE3_MAX = 385.883051d;
    static final double U10_HOUSE3_MIN = 335.024065d;
    static final double U10_HOUSE4_MAX = 393.49442d;
    static final double U10_HOUSE4_MIN = 331.162936d;
    static final double U10_HOUSE5_MAX = 385.88306d;
    static final double U10_HOUSE5_MIN = 335.024068d;
    static final double U10_HOUSE6_MAX = 403.510494d;
    static final double U10_HOUSE6_MIN = 332.530159d;
    static final double U10_HOUSE7_MAX = 426.089536d;
    static final double U10_HOUSE7_MIN = 328.169552d;
    static final double U10_HOUSE8_MAX = 403.510494d;
    static final double U10_HOUSE8_MIN = 332.53016d;
    static final double U10_HOUSE9_MAX = 385.883051d;
    static final double U10_HOUSE9_MIN = 335.024065d;
    static final double U10_MC_MAX = 393.49442d;
    static final double U10_MC_MIN = 331.162936d;
    static final double U10_POLASC_MAX = 426.089531d;
    static final double U10_POLASC_MIN = 328.16955d;
    static final double U10_VERTEX_MAX = 1554930.566243d;
    static final double U10_VERTEX_MIN = -777600.124028d;
    static final double U20_ARMC_MAX = 360.985931d;
    static final double U20_ARMC_MIN = 360.985828d;
    static final double U20_ASC_MAX = 467.280896d;
    static final double U20_ASC_MIN = 319.225068d;
    static final double U20_COASC1_MAX = 467.280888d;
    static final double U20_COASC1_MIN = 319.22507d;
    static final double U20_COASC2_MAX = 179.610407d;
    static final double U20_COASC2_MIN = -2066.7575d;
    static final double U20_EQUASC_MAX = 393.49442d;
    static final double U20_EQUASC_MIN = 331.162937d;
    static final double U20_HOUSE10_MAX = 393.49442d;
    static final double U20_HOUSE10_MIN = 331.162936d;
    static final double U20_HOUSE11_MAX = 387.665403d;
    static final double U20_HOUSE11_MIN = 329.112064d;
    static final double U20_HOUSE12_MAX = 434.915163d;
    static final double U20_HOUSE12_MIN = 319.971639d;
    static final double U20_HOUSE1_MAX = 467.280896d;
    static final double U20_HOUSE1_MIN = 319.225068d;
    static final double U20_HOUSE2_MAX = 434.915163d;
    static final double U20_HOUSE2_MIN = 319.971642d;
    static final double U20_HOUSE3_MAX = 387.665409d;
    static final double U20_HOUSE3_MIN = 329.112066d;
    static final double U20_HOUSE4_MAX = 393.49442d;
    static final double U20_HOUSE4_MIN = 331.162936d;
    static final double U20_HOUSE5_MAX = 387.665403d;
    static final double U20_HOUSE5_MIN = 329.112064d;
    static final double U20_HOUSE6_MAX = 434.915163d;
    static final double U20_HOUSE6_MIN = 319.971639d;
    static final double U20_HOUSE7_MAX = 467.280896d;
    static final double U20_HOUSE7_MIN = 319.225068d;
    static final double U20_HOUSE8_MAX = 434.915163d;
    static final double U20_HOUSE8_MIN = 319.971642d;
    static final double U20_HOUSE9_MAX = 387.665409d;
    static final double U20_HOUSE9_MIN = 329.112066d;
    static final double U20_MC_MAX = 393.49442d;
    static final double U20_MC_MIN = 331.162936d;
    static final double U20_POLASC_MAX = 467.280888d;
    static final double U20_POLASC_MIN = 319.22507d;
    static final double U20_VERTEX_MAX = 1553150.33462d;
    static final double U20_VERTEX_MIN = -777600.393091d;
    static final double U30_ARMC_MAX = 360.985931d;
    static final double U30_ARMC_MIN = 360.985828d;
    static final double U30_ASC_MAX = 524.994891d;
    static final double U30_ASC_MIN = 304.407972d;
    static final double U30_COASC1_MAX = 524.994878d;
    static final double U30_COASC1_MIN = 304.407972d;
    static final double U30_COASC2_MAX = 1583.084164d;
    static final double U30_COASC2_MIN = 220.207028d;
    static final double U30_EQUASC_MAX = 393.49442d;
    static final double U30_EQUASC_MIN = 331.162937d;
    static final double U30_HOUSE10_MAX = 393.49442d;
    static final double U30_HOUSE10_MIN = 331.162936d;
    static final double U30_HOUSE11_MAX = 389.431148d;
    static final double U30_HOUSE11_MIN = 322.126945d;
    static final double U30_HOUSE12_MAX = 483.25662d;
    static final double U30_HOUSE12_MIN = 303.48812d;
    static final double U30_HOUSE1_MAX = 524.994891d;
    static final double U30_HOUSE1_MIN = 304.407972d;
    static final double U30_HOUSE2_MAX = 483.256574d;
    static final double U30_HOUSE2_MIN = 303.488116d;
    static final double U30_HOUSE3_MAX = 389.431148d;
    static final double U30_HOUSE3_MIN = 322.126946d;
    static final double U30_HOUSE4_MAX = 393.49442d;
    static final double U30_HOUSE4_MIN = 331.162936d;
    static final double U30_HOUSE5_MAX = 389.431148d;
    static final double U30_HOUSE5_MIN = 322.126945d;
    static final double U30_HOUSE6_MAX = 483.25662d;
    static final double U30_HOUSE6_MIN = 303.48812d;
    static final double U30_HOUSE7_MAX = 524.994891d;
    static final double U30_HOUSE7_MIN = 304.407972d;
    static final double U30_HOUSE8_MAX = 483.256574d;
    static final double U30_HOUSE8_MIN = 303.488116d;
    static final double U30_HOUSE9_MAX = 389.431148d;
    static final double U30_HOUSE9_MIN = 322.126946d;
    static final double U30_MC_MAX = 393.49442d;
    static final double U30_MC_MIN = 331.162936d;
    static final double U30_POLASC_MAX = 524.994878d;
    static final double U30_POLASC_MIN = 304.407972d;
    static final double U30_VERTEX_MAX = 1583.084212d;
    static final double U30_VERTEX_MIN = 220.207025d;
    static final double U40_ARMC_MAX = 360.985931d;
    static final double U40_ARMC_MIN = 360.985828d;
    static final double U40_ASC_MAX = 618.738596d;
    static final double U40_ASC_MIN = 283.720808d;
    static final double U40_COASC1_MAX = 618.738574d;
    static final double U40_COASC1_MIN = 283.720804d;
    static final double U40_COASC2_MAX = 814.745889d;
    static final double U40_COASC2_MIN = 256.684961d;
    static final double U40_EQUASC_MAX = 393.49442d;
    static final double U40_EQUASC_MIN = 331.162937d;
    static final double U40_HOUSE10_MAX = 393.49442d;
    static final double U40_HOUSE10_MIN = 331.162936d;
    static final double U40_HOUSE11_MAX = 424.34377d;
    static final double U40_HOUSE11_MIN = 312.149698d;
    static final double U40_HOUSE12_MAX = 567.646602d;
    static final double U40_HOUSE12_MIN = 281.866036d;
    static final double U40_HOUSE1_MAX = 618.738596d;
    static final double U40_HOUSE1_MIN = 283.720808d;
    static final double U40_HOUSE2_MAX = 567.646515d;
    static final double U40_HOUSE2_MIN = 281.866039d;
    static final double U40_HOUSE3_MAX = 424.343793d;
    static final double U40_HOUSE3_MIN = 312.149687d;
    static final double U40_HOUSE4_MAX = 393.49442d;
    static final double U40_HOUSE4_MIN = 331.162936d;
    static final double U40_HOUSE5_MAX = 424.34377d;
    static final double U40_HOUSE5_MIN = 312.149698d;
    static final double U40_HOUSE6_MAX = 567.646602d;
    static final double U40_HOUSE6_MIN = 281.866036d;
    static final double U40_HOUSE7_MAX = 618.738596d;
    static final double U40_HOUSE7_MIN = 283.720808d;
    static final double U40_HOUSE8_MAX = 567.646515d;
    static final double U40_HOUSE8_MIN = 281.866039d;
    static final double U40_HOUSE9_MAX = 424.343793d;
    static final double U40_HOUSE9_MIN = 312.149687d;
    static final double U40_MC_MAX = 393.49442d;
    static final double U40_MC_MIN = 331.162936d;
    static final double U40_POLASC_MAX = 618.738574d;
    static final double U40_POLASC_MIN = 283.720804d;
    static final double U40_VERTEX_MAX = 814.74585d;
    static final double U40_VERTEX_MIN = 256.68496d;
    static final double U50_ARMC_MAX = 360.985931d;
    static final double U50_ARMC_MIN = 360.985828d;
    static final double U50_ASC_MAX = 814.745889d;
    static final double U50_ASC_MIN = 256.684961d;
    static final double U50_COASC1_MAX = 814.74585d;
    static final double U50_COASC1_MIN = 256.68496d;
    static final double U50_COASC2_MAX = 618.738596d;
    static final double U50_COASC2_MIN = 283.720808d;
    static final double U50_EQUASC_MAX = 393.49442d;
    static final double U50_EQUASC_MIN = 331.162937d;
    static final double U50_HOUSE10_MAX = 393.49442d;
    static final double U50_HOUSE10_MIN = 331.162936d;
    static final double U50_HOUSE11_MAX = 527.04862d;
    static final double U50_HOUSE11_MIN = 295.38882d;
    static final double U50_HOUSE12_MAX = 751.931769d;
    static final double U50_HOUSE12_MIN = 252.022191d;
    static final double U50_HOUSE1_MAX = 814.745889d;
    static final double U50_HOUSE1_MIN = 256.684961d;
    static final double U50_HOUSE2_MAX = 751.931714d;
    static final double U50_HOUSE2_MIN = 252.022195d;
    static final double U50_HOUSE3_MAX = 527.048719d;
    static final double U50_HOUSE3_MIN = 295.388824d;
    static final double U50_HOUSE4_MAX = 393.49442d;
    static final double U50_HOUSE4_MIN = 331.162936d;
    static final double U50_HOUSE5_MAX = 527.04862d;
    static final double U50_HOUSE5_MIN = 295.38882d;
    static final double U50_HOUSE6_MAX = 751.931769d;
    static final double U50_HOUSE6_MIN = 252.022191d;
    static final double U50_HOUSE7_MAX = 814.745889d;
    static final double U50_HOUSE7_MIN = 256.684961d;
    static final double U50_HOUSE8_MAX = 751.931714d;
    static final double U50_HOUSE8_MIN = 252.022195d;
    static final double U50_HOUSE9_MAX = 527.048719d;
    static final double U50_HOUSE9_MIN = 295.388824d;
    static final double U50_MC_MAX = 393.49442d;
    static final double U50_MC_MIN = 331.162936d;
    static final double U50_POLASC_MAX = 814.74585d;
    static final double U50_POLASC_MIN = 256.68496d;
    static final double U50_VERTEX_MAX = 618.738574d;
    static final double U50_VERTEX_MIN = 283.720804d;
    static final double U60_ARMC_MAX = 360.985931d;
    static final double U60_ARMC_MIN = 360.985828d;
    static final double U60_ASC_MAX = 1583.084164d;
    static final double U60_ASC_MIN = 220.207028d;
    static final double U60_COASC1_MAX = 1583.084212d;
    static final double U60_COASC1_MIN = 220.207025d;
    static final double U60_COASC2_MAX = 524.994891d;
    static final double U60_COASC2_MIN = 304.407972d;
    static final double U60_EQUASC_MAX = 393.49442d;
    static final double U60_EQUASC_MIN = 331.162937d;
    static final double U60_HOUSE10_MAX = 393.49442d;
    static final double U60_HOUSE10_MIN = 331.162936d;
    static final double U60_HOUSE11_MAX = 993.688005d;
    static final double U60_HOUSE11_MIN = 261.439081d;
    static final double U60_HOUSE12_MAX = 1485.125916d;
    static final double U60_HOUSE12_MIN = 204.97622d;
    static final double U60_HOUSE1_MAX = 1583.084164d;
    static final double U60_HOUSE1_MIN = 220.207028d;
    static final double U60_HOUSE2_MAX = 1485.125243d;
    static final double U60_HOUSE2_MIN = 204.97622d;
    static final double U60_HOUSE3_MAX = 993.687267d;
    static final double U60_HOUSE3_MIN = 261.43909d;
    static final double U60_HOUSE4_MAX = 393.49442d;
    static final double U60_HOUSE4_MIN = 331.162936d;
    static final double U60_HOUSE5_MAX = 993.688005d;
    static final double U60_HOUSE5_MIN = 261.439081d;
    static final double U60_HOUSE6_MAX = 1485.125916d;
    static final double U60_HOUSE6_MIN = 204.97622d;
    static final double U60_HOUSE7_MAX = 1583.084164d;
    static final double U60_HOUSE7_MIN = 220.207028d;
    static final double U60_HOUSE8_MAX = 1485.125243d;
    static final double U60_HOUSE8_MIN = 204.97622d;
    static final double U60_HOUSE9_MAX = 993.687267d;
    static final double U60_HOUSE9_MIN = 261.43909d;
    static final double U60_MC_MAX = 393.49442d;
    static final double U60_MC_MIN = 331.162936d;
    static final double U60_POLASC_MAX = 1583.084212d;
    static final double U60_POLASC_MIN = 220.207025d;
    static final double U60_VERTEX_MAX = 524.994878d;
    static final double U60_VERTEX_MIN = 304.407972d;
    static final double U66_ARMC_MAX = 360.985931d;
    static final double U66_ARMC_MIN = 360.985828d;
    static final double U66_ASC_MAX = 15382.763492d;
    static final double U66_ASC_MIN = 180.714519d;
    static final double U66_COASC1_MAX = 15382.960178d;
    static final double U66_COASC1_MIN = 180.714532d;
    static final double U66_COASC2_MAX = 487.697885d;
    static final double U66_COASC2_MIN = 313.998924d;
    static final double U66_EQUASC_MAX = 393.49442d;
    static final double U66_EQUASC_MIN = 331.162937d;
    static final double U66_HOUSE10_MAX = 393.49442d;
    static final double U66_HOUSE10_MIN = 331.162936d;
    static final double U66_HOUSE11_MAX = 9910.222805d;
    static final double U66_HOUSE11_MIN = 60.45765d;
    static final double U66_HOUSE12_MAX = 14645.526041d;
    static final double U66_HOUSE12_MIN = 140.297938d;
    static final double U66_HOUSE1_MAX = 15382.763492d;
    static final double U66_HOUSE1_MIN = 180.714519d;
    static final double U66_HOUSE2_MAX = 14645.378876d;
    static final double U66_HOUSE2_MIN = 140.297939d;
    static final double U66_HOUSE3_MAX = 9910.124544d;
    static final double U66_HOUSE3_MIN = 60.457624d;
    static final double U66_HOUSE4_MAX = 393.49442d;
    static final double U66_HOUSE4_MIN = 331.162936d;
    static final double U66_HOUSE5_MAX = 9910.222805d;
    static final double U66_HOUSE5_MIN = 60.45765d;
    static final double U66_HOUSE6_MAX = 14645.526041d;
    static final double U66_HOUSE6_MIN = 140.297938d;
    static final double U66_HOUSE7_MAX = 15382.763492d;
    static final double U66_HOUSE7_MIN = 180.714519d;
    static final double U66_HOUSE8_MAX = 14645.378876d;
    static final double U66_HOUSE8_MIN = 140.297939d;
    static final double U66_HOUSE9_MAX = 9910.124544d;
    static final double U66_HOUSE9_MIN = 60.457624d;
    static final double U66_MC_MAX = 393.49442d;
    static final double U66_MC_MIN = 331.162936d;
    static final double U66_POLASC_MAX = 15382.960178d;
    static final double U66_POLASC_MIN = 180.714532d;
    static final double U66_VERTEX_MAX = 487.697876d;
    static final double U66_VERTEX_MIN = 313.998925d;
    static final double U70_ARMC_MAX = 360.985931d;
    static final double U70_ARMC_MIN = 360.985828d;
    static final double U70_ASC_MAX = 1553150.32968d;
    static final double U70_ASC_MIN = -777600.39302d;
    static final double U70_COASC1_MAX = 1553150.33462d;
    static final double U70_COASC1_MIN = -2066.704127d;
    static final double U70_COASC2_MAX = 467.280896d;
    static final double U70_COASC2_MIN = 319.225068d;
    static final double U70_EQUASC_MAX = 393.49442d;
    static final double U70_EQUASC_MIN = 331.162937d;
    static final double U70_HOUSE10_MAX = 393.49442d;
    static final double U70_HOUSE10_MIN = 331.162936d;
    static final double U70_HOUSE11_MAX = 1555199.999998d;
    static final double U70_HOUSE11_MIN = 2.4E-5d;
    static final double U70_HOUSE12_MAX = 1555199.999998d;
    static final double U70_HOUSE12_MIN = 3.0E-6d;
    static final double U70_HOUSE1_MAX = 1555199.608408d;
    static final double U70_HOUSE1_MIN = 0.389863d;
    static final double U70_HOUSE2_MAX = 1555200.0d;
    static final double U70_HOUSE2_MIN = 1.0E-6d;
    static final double U70_HOUSE3_MAX = 1555199.999981d;
    static final double U70_HOUSE3_MIN = 3.0E-6d;
    static final double U70_HOUSE4_MAX = 393.49442d;
    static final double U70_HOUSE4_MIN = 331.162936d;
    static final double U70_HOUSE5_MAX = 1555199.999998d;
    static final double U70_HOUSE5_MIN = 2.4E-5d;
    static final double U70_HOUSE6_MAX = 1555199.999998d;
    static final double U70_HOUSE6_MIN = 3.0E-6d;
    static final double U70_HOUSE7_MAX = 1555199.608408d;
    static final double U70_HOUSE7_MIN = 0.389863d;
    static final double U70_HOUSE8_MAX = 1555200.0d;
    static final double U70_HOUSE8_MIN = 1.0E-6d;
    static final double U70_HOUSE9_MAX = 1555199.999981d;
    static final double U70_HOUSE9_MIN = 3.0E-6d;
    static final double U70_MC_MAX = 393.49442d;
    static final double U70_MC_MIN = 331.162936d;
    static final double U70_POLASC_MAX = 179.610407d;
    static final double U70_POLASC_MIN = -2066.757416d;
    static final double U70_VERTEX_MAX = 467.280888d;
    static final double U70_VERTEX_MIN = 319.22507d;
    static final double U80_ARMC_MAX = 360.985931d;
    static final double U80_ARMC_MIN = 360.985828d;
    static final double U80_ASC_MAX = 1554930.566184d;
    static final double U80_ASC_MIN = -777600.124007d;
    static final double U80_COASC1_MAX = 1554930.566243d;
    static final double U80_COASC1_MIN = -269.995683d;
    static final double U80_COASC2_MAX = 426.089536d;
    static final double U80_COASC2_MIN = 328.169552d;
    static final double U80_EQUASC_MAX = 393.49442d;
    static final double U80_EQUASC_MIN = 331.162937d;
    static final double U80_HOUSE10_MAX = 393.49442d;
    static final double U80_HOUSE10_MIN = 331.162936d;
    static final double U80_HOUSE11_MAX = 1555199.999993d;
    static final double U80_HOUSE11_MIN = 5.0E-6d;
    static final double U80_HOUSE12_MAX = 1555199.999999d;
    static final double U80_HOUSE12_MIN = 3.0E-6d;
    static final double U80_HOUSE1_MAX = 1555199.876097d;
    static final double U80_HOUSE1_MIN = 0.12375d;
    static final double U80_HOUSE2_MAX = 1555199.999999d;
    static final double U80_HOUSE2_MIN = 0.0d;
    static final double U80_HOUSE3_MAX = 1555199.999998d;
    static final double U80_HOUSE3_MIN = 2.0E-6d;
    static final double U80_HOUSE4_MAX = 393.49442d;
    static final double U80_HOUSE4_MIN = 331.162936d;
    static final double U80_HOUSE5_MAX = 1555199.999993d;
    static final double U80_HOUSE5_MIN = 5.0E-6d;
    static final double U80_HOUSE6_MAX = 1555199.999999d;
    static final double U80_HOUSE6_MIN = 3.0E-6d;
    static final double U80_HOUSE7_MAX = 1555199.876097d;
    static final double U80_HOUSE7_MIN = 0.12375d;
    static final double U80_HOUSE8_MAX = 1555199.999999d;
    static final double U80_HOUSE8_MIN = 0.0d;
    static final double U80_HOUSE9_MAX = 1555199.999998d;
    static final double U80_HOUSE9_MIN = 2.0E-6d;
    static final double U80_MC_MAX = 393.49442d;
    static final double U80_MC_MIN = 331.162936d;
    static final double U80_POLASC_MAX = 113.797793d;
    static final double U80_POLASC_MIN = -269.996067d;
    static final double U80_VERTEX_MAX = 426.089531d;
    static final double U80_VERTEX_MIN = 328.16955d;
    static final double U85_ARMC_MAX = 360.985931d;
    static final double U85_ARMC_MIN = 360.985828d;
    static final double U85_ASC_MAX = 1555100.603952d;
    static final double U85_ASC_MIN = -777600.058703d;
    static final double U85_COASC1_MAX = 1555100.603957d;
    static final double U85_COASC1_MIN = -99.544583d;
    static final double U85_COASC2_MAX = 409.019308d;
    static final double U85_COASC2_MIN = 330.413985d;
    static final double U85_EQUASC_MAX = 393.49442d;
    static final double U85_EQUASC_MIN = 331.162937d;
    static final double U85_HOUSE10_MAX = 393.49442d;
    static final double U85_HOUSE10_MIN = 331.162936d;
    static final double U85_HOUSE11_MAX = 1555200.0d;
    static final double U85_HOUSE11_MIN = 0.0d;
    static final double U85_HOUSE12_MAX = 1555200.0d;
    static final double U85_HOUSE12_MIN = 1.0E-6d;
    static final double U85_HOUSE1_MAX = 1555199.941344d;
    static final double U85_HOUSE1_MIN = 0.058615d;
    static final double U85_HOUSE2_MAX = 1555199.999999d;
    static final double U85_HOUSE2_MIN = 0.0d;
    static final double U85_HOUSE3_MAX = 1555199.999998d;
    static final double U85_HOUSE3_MIN = 0.0d;
    static final double U85_HOUSE4_MAX = 393.49442d;
    static final double U85_HOUSE4_MIN = 331.162936d;
    static final double U85_HOUSE5_MAX = 1555200.0d;
    static final double U85_HOUSE5_MIN = 0.0d;
    static final double U85_HOUSE6_MAX = 1555200.0d;
    static final double U85_HOUSE6_MIN = 1.0E-6d;
    static final double U85_HOUSE7_MAX = 1555199.941344d;
    static final double U85_HOUSE7_MIN = 0.058615d;
    static final double U85_HOUSE8_MAX = 1555199.999999d;
    static final double U85_HOUSE8_MIN = 0.0d;
    static final double U85_HOUSE9_MAX = 1555199.999998d;
    static final double U85_HOUSE9_MIN = 0.0d;
    static final double U85_MC_MAX = 393.49442d;
    static final double U85_MC_MIN = 331.162936d;
    static final double U85_POLASC_MAX = 66.096027d;
    static final double U85_POLASC_MIN = -99.544653d;
    static final double U85_VERTEX_MAX = 409.019306d;
    static final double U85_VERTEX_MIN = 330.413985d;
    static final double U88_ARMC_MAX = 360.985931d;
    static final double U88_ARMC_MIN = 360.985828d;
    static final double U88_ASC_MAX = 1555165.554408d;
    static final double U88_ASC_MIN = -777600.02317d;
    static final double U88_COASC1_MAX = 1555165.554409d;
    static final double U88_COASC1_MIN = -34.489296d;
    static final double U88_COASC2_MAX = 399.547623d;
    static final double U88_COASC2_MIN = 331.043079d;
    static final double U88_EQUASC_MAX = 393.49442d;
    static final double U88_EQUASC_MIN = 331.162937d;
    static final double U88_HOUSE10_MAX = 393.49442d;
    static final double U88_HOUSE10_MIN = 331.162936d;
    static final double U88_HOUSE11_MAX = 1555199.999999d;
    static final double U88_HOUSE11_MIN = 1.0E-6d;
    static final double U88_HOUSE12_MAX = 1555200.0d;
    static final double U88_HOUSE12_MIN = 0.0d;
    static final double U88_HOUSE1_MAX = 1555199.976849d;
    static final double U88_HOUSE1_MIN = 0.023142d;
    static final double U88_HOUSE2_MAX = 1555200.0d;
    static final double U88_HOUSE2_MIN = 0.0d;
    static final double U88_HOUSE3_MAX = 1555199.999999d;
    static final double U88_HOUSE3_MIN = 0.0d;
    static final double U88_HOUSE4_MAX = 393.49442d;
    static final double U88_HOUSE4_MIN = 331.162936d;
    static final double U88_HOUSE5_MAX = 1555199.999999d;
    static final double U88_HOUSE5_MIN = 1.0E-6d;
    static final double U88_HOUSE6_MAX = 1555200.0d;
    static final double U88_HOUSE6_MIN = 0.0d;
    static final double U88_HOUSE7_MAX = 1555199.976849d;
    static final double U88_HOUSE7_MIN = 0.023142d;
    static final double U88_HOUSE8_MAX = 1555200.0d;
    static final double U88_HOUSE8_MIN = 0.0d;
    static final double U88_HOUSE9_MAX = 1555199.999999d;
    static final double U88_HOUSE9_MIN = 0.0d;
    static final double U88_MC_MAX = 393.49442d;
    static final double U88_MC_MIN = 331.162936d;
    static final double U88_POLASC_MAX = 29.34423d;
    static final double U88_POLASC_MIN = -34.489313d;
    static final double U88_VERTEX_MAX = 399.547621d;
    static final double U88_VERTEX_MIN = 331.043081d;
    static final double U90_ARMC_MAX = 360.985929d;
    static final double U90_ARMC_MIN = 360.985828d;
    static final double U90_ASC_MAX = 1555200.0d;
    static final double U90_ASC_MIN = -777600.0d;
    static final double U90_COASC1_MAX = 1555200.0d;
    static final double U90_COASC1_MIN = -0.0d;
    static final double U90_COASC2_MAX = 393.49442d;
    static final double U90_COASC2_MIN = 331.162937d;
    static final double U90_EQUASC_MAX = 393.49442d;
    static final double U90_EQUASC_MIN = 331.162937d;
    static final double U90_HOUSE10_MAX = 393.610455d;
    static final double U90_HOUSE10_MIN = 234.352498d;
    static final double U90_HOUSE11_MAX = 1555200.0d;
    static final double U90_HOUSE11_MIN = 0.0d;
    static final double U90_HOUSE12_MAX = 1555200.0d;
    static final double U90_HOUSE12_MIN = 0.0d;
    static final double U90_HOUSE1_MAX = 1555200.0d;
    static final double U90_HOUSE1_MIN = 0.0d;
    static final double U90_HOUSE2_MAX = 1555200.0d;
    static final double U90_HOUSE2_MIN = 0.0d;
    static final double U90_HOUSE3_MAX = 1555200.0d;
    static final double U90_HOUSE3_MIN = 0.0d;
    static final double U90_HOUSE4_MAX = 393.610455d;
    static final double U90_HOUSE4_MIN = 234.352498d;
    static final double U90_HOUSE5_MAX = 1555200.0d;
    static final double U90_HOUSE5_MIN = 0.0d;
    static final double U90_HOUSE6_MAX = 1555200.0d;
    static final double U90_HOUSE6_MIN = 0.0d;
    static final double U90_HOUSE7_MAX = 1555200.0d;
    static final double U90_HOUSE7_MIN = 0.0d;
    static final double U90_HOUSE8_MAX = 1555200.0d;
    static final double U90_HOUSE8_MIN = 0.0d;
    static final double U90_HOUSE9_MAX = 1555200.0d;
    static final double U90_HOUSE9_MIN = 0.0d;
    static final double U90_MC_MAX = 393.49442d;
    static final double U90_MC_MIN = 331.162936d;
    static final double U90_POLASC_MAX = 0.0d;
    static final double U90_POLASC_MIN = -0.0d;
    static final double U90_VERTEX_MAX = 393.49442d;
    static final double U90_VERTEX_MIN = 331.162937d;
    static final double V0_ARMC_MAX = 360.985931d;
    static final double V0_ARMC_MIN = 360.985828d;
    static final double V0_ASC_MAX = 393.49442d;
    static final double V0_ASC_MIN = 331.162937d;
    static final double V0_COASC1_MAX = 393.49442d;
    static final double V0_COASC1_MIN = 331.162937d;
    static final double V0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double V0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double V0_EQUASC_MAX = 393.49442d;
    static final double V0_EQUASC_MIN = 331.162937d;
    static final double V0_HOUSE10_MAX = 393.49442d;
    static final double V0_HOUSE10_MIN = 331.162937d;
    static final double V0_HOUSE11_MAX = 393.49442d;
    static final double V0_HOUSE11_MIN = 331.162937d;
    static final double V0_HOUSE12_MAX = 393.49442d;
    static final double V0_HOUSE12_MIN = 331.162937d;
    static final double V0_HOUSE1_MAX = 393.49442d;
    static final double V0_HOUSE1_MIN = 331.162937d;
    static final double V0_HOUSE2_MAX = 393.49442d;
    static final double V0_HOUSE2_MIN = 331.162937d;
    static final double V0_HOUSE3_MAX = 393.49442d;
    static final double V0_HOUSE3_MIN = 331.162937d;
    static final double V0_HOUSE4_MAX = 393.49442d;
    static final double V0_HOUSE4_MIN = 331.162937d;
    static final double V0_HOUSE5_MAX = 393.49442d;
    static final double V0_HOUSE5_MIN = 331.162937d;
    static final double V0_HOUSE6_MAX = 393.49442d;
    static final double V0_HOUSE6_MIN = 331.162937d;
    static final double V0_HOUSE7_MAX = 393.49442d;
    static final double V0_HOUSE7_MIN = 331.162937d;
    static final double V0_HOUSE8_MAX = 393.49442d;
    static final double V0_HOUSE8_MIN = 331.162937d;
    static final double V0_HOUSE9_MAX = 393.49442d;
    static final double V0_HOUSE9_MIN = 331.162937d;
    static final double V0_MC_MAX = 393.49442d;
    static final double V0_MC_MIN = 331.162936d;
    static final double V0_POLASC_MAX = 393.49442d;
    static final double V0_POLASC_MIN = 331.162937d;
    static final double V0_VERTEX_MAX = 777600.0d;
    static final double V0_VERTEX_MIN = -777600.0d;
    static final double V10_ARMC_MAX = 360.985931d;
    static final double V10_ARMC_MIN = 360.985828d;
    static final double V10_ASC_MAX = 426.089536d;
    static final double V10_ASC_MIN = 328.169552d;
    static final double V10_COASC1_MAX = 426.089531d;
    static final double V10_COASC1_MIN = 328.16955d;
    static final double V10_COASC2_MAX = 113.797795d;
    static final double V10_COASC2_MIN = -269.99607d;
    static final double V10_EQUASC_MAX = 393.49442d;
    static final double V10_EQUASC_MIN = 331.162937d;
    static final double V10_HOUSE10_MAX = 426.089536d;
    static final double V10_HOUSE10_MIN = 328.169552d;
    static final double V10_HOUSE11_MAX = 426.089536d;
    static final double V10_HOUSE11_MIN = 328.169552d;
    static final double V10_HOUSE12_MAX = 426.089536d;
    static final double V10_HOUSE12_MIN = 328.169552d;
    static final double V10_HOUSE1_MAX = 426.089536d;
    static final double V10_HOUSE1_MIN = 328.169552d;
    static final double V10_HOUSE2_MAX = 426.089536d;
    static final double V10_HOUSE2_MIN = 328.169552d;
    static final double V10_HOUSE3_MAX = 426.089536d;
    static final double V10_HOUSE3_MIN = 328.169552d;
    static final double V10_HOUSE4_MAX = 426.089536d;
    static final double V10_HOUSE4_MIN = 328.169552d;
    static final double V10_HOUSE5_MAX = 426.089536d;
    static final double V10_HOUSE5_MIN = 328.169552d;
    static final double V10_HOUSE6_MAX = 426.089536d;
    static final double V10_HOUSE6_MIN = 328.169552d;
    static final double V10_HOUSE7_MAX = 426.089536d;
    static final double V10_HOUSE7_MIN = 328.169552d;
    static final double V10_HOUSE8_MAX = 426.089536d;
    static final double V10_HOUSE8_MIN = 328.169552d;
    static final double V10_HOUSE9_MAX = 426.089536d;
    static final double V10_HOUSE9_MIN = 328.169552d;
    static final double V10_MC_MAX = 393.49442d;
    static final double V10_MC_MIN = 331.162936d;
    static final double V10_POLASC_MAX = 426.089531d;
    static final double V10_POLASC_MIN = 328.16955d;
    static final double V10_VERTEX_MAX = 1554930.566243d;
    static final double V10_VERTEX_MIN = -777600.124028d;
    static final double V20_ARMC_MAX = 360.985931d;
    static final double V20_ARMC_MIN = 360.985828d;
    static final double V20_ASC_MAX = 467.280896d;
    static final double V20_ASC_MIN = 319.225068d;
    static final double V20_COASC1_MAX = 467.280888d;
    static final double V20_COASC1_MIN = 319.22507d;
    static final double V20_COASC2_MAX = 179.610407d;
    static final double V20_COASC2_MIN = -2066.7575d;
    static final double V20_EQUASC_MAX = 393.49442d;
    static final double V20_EQUASC_MIN = 331.162937d;
    static final double V20_HOUSE10_MAX = 467.280896d;
    static final double V20_HOUSE10_MIN = 319.225068d;
    static final double V20_HOUSE11_MAX = 467.280896d;
    static final double V20_HOUSE11_MIN = 319.225068d;
    static final double V20_HOUSE12_MAX = 467.280896d;
    static final double V20_HOUSE12_MIN = 319.225068d;
    static final double V20_HOUSE1_MAX = 467.280896d;
    static final double V20_HOUSE1_MIN = 319.225068d;
    static final double V20_HOUSE2_MAX = 467.280896d;
    static final double V20_HOUSE2_MIN = 319.225068d;
    static final double V20_HOUSE3_MAX = 467.280896d;
    static final double V20_HOUSE3_MIN = 319.225068d;
    static final double V20_HOUSE4_MAX = 467.280896d;
    static final double V20_HOUSE4_MIN = 319.225068d;
    static final double V20_HOUSE5_MAX = 467.280896d;
    static final double V20_HOUSE5_MIN = 319.225068d;
    static final double V20_HOUSE6_MAX = 467.280896d;
    static final double V20_HOUSE6_MIN = 319.225068d;
    static final double V20_HOUSE7_MAX = 467.280896d;
    static final double V20_HOUSE7_MIN = 319.225068d;
    static final double V20_HOUSE8_MAX = 467.280896d;
    static final double V20_HOUSE8_MIN = 319.225068d;
    static final double V20_HOUSE9_MAX = 467.280896d;
    static final double V20_HOUSE9_MIN = 319.225068d;
    static final double V20_MC_MAX = 393.49442d;
    static final double V20_MC_MIN = 331.162936d;
    static final double V20_POLASC_MAX = 467.280888d;
    static final double V20_POLASC_MIN = 319.22507d;
    static final double V20_VERTEX_MAX = 1553150.33462d;
    static final double V20_VERTEX_MIN = -777600.393091d;
    static final double V30_ARMC_MAX = 360.985931d;
    static final double V30_ARMC_MIN = 360.985828d;
    static final double V30_ASC_MAX = 524.994891d;
    static final double V30_ASC_MIN = 304.407972d;
    static final double V30_COASC1_MAX = 524.994878d;
    static final double V30_COASC1_MIN = 304.407972d;
    static final double V30_COASC2_MAX = 1583.084164d;
    static final double V30_COASC2_MIN = 220.207028d;
    static final double V30_EQUASC_MAX = 393.49442d;
    static final double V30_EQUASC_MIN = 331.162937d;
    static final double V30_HOUSE10_MAX = 524.994891d;
    static final double V30_HOUSE10_MIN = 304.407972d;
    static final double V30_HOUSE11_MAX = 524.994891d;
    static final double V30_HOUSE11_MIN = 304.407972d;
    static final double V30_HOUSE12_MAX = 524.994891d;
    static final double V30_HOUSE12_MIN = 304.407972d;
    static final double V30_HOUSE1_MAX = 524.994891d;
    static final double V30_HOUSE1_MIN = 304.407972d;
    static final double V30_HOUSE2_MAX = 524.994891d;
    static final double V30_HOUSE2_MIN = 304.407972d;
    static final double V30_HOUSE3_MAX = 524.994891d;
    static final double V30_HOUSE3_MIN = 304.407972d;
    static final double V30_HOUSE4_MAX = 524.994891d;
    static final double V30_HOUSE4_MIN = 304.407972d;
    static final double V30_HOUSE5_MAX = 524.994891d;
    static final double V30_HOUSE5_MIN = 304.407972d;
    static final double V30_HOUSE6_MAX = 524.994891d;
    static final double V30_HOUSE6_MIN = 304.407972d;
    static final double V30_HOUSE7_MAX = 524.994891d;
    static final double V30_HOUSE7_MIN = 304.407972d;
    static final double V30_HOUSE8_MAX = 524.994891d;
    static final double V30_HOUSE8_MIN = 304.407972d;
    static final double V30_HOUSE9_MAX = 524.994891d;
    static final double V30_HOUSE9_MIN = 304.407972d;
    static final double V30_MC_MAX = 393.49442d;
    static final double V30_MC_MIN = 331.162936d;
    static final double V30_POLASC_MAX = 524.994878d;
    static final double V30_POLASC_MIN = 304.407972d;
    static final double V30_VERTEX_MAX = 1583.084212d;
    static final double V30_VERTEX_MIN = 220.207025d;
    static final double V40_ARMC_MAX = 360.985931d;
    static final double V40_ARMC_MIN = 360.985828d;
    static final double V40_ASC_MAX = 618.738596d;
    static final double V40_ASC_MIN = 283.720808d;
    static final double V40_COASC1_MAX = 618.738574d;
    static final double V40_COASC1_MIN = 283.720804d;
    static final double V40_COASC2_MAX = 814.745889d;
    static final double V40_COASC2_MIN = 256.684961d;
    static final double V40_EQUASC_MAX = 393.49442d;
    static final double V40_EQUASC_MIN = 331.162937d;
    static final double V40_HOUSE10_MAX = 618.738596d;
    static final double V40_HOUSE10_MIN = 283.720808d;
    static final double V40_HOUSE11_MAX = 618.738596d;
    static final double V40_HOUSE11_MIN = 283.720808d;
    static final double V40_HOUSE12_MAX = 618.738596d;
    static final double V40_HOUSE12_MIN = 283.720808d;
    static final double V40_HOUSE1_MAX = 618.738596d;
    static final double V40_HOUSE1_MIN = 283.720808d;
    static final double V40_HOUSE2_MAX = 618.738596d;
    static final double V40_HOUSE2_MIN = 283.720808d;
    static final double V40_HOUSE3_MAX = 618.738596d;
    static final double V40_HOUSE3_MIN = 283.720808d;
    static final double V40_HOUSE4_MAX = 618.738596d;
    static final double V40_HOUSE4_MIN = 283.720808d;
    static final double V40_HOUSE5_MAX = 618.738596d;
    static final double V40_HOUSE5_MIN = 283.720808d;
    static final double V40_HOUSE6_MAX = 618.738596d;
    static final double V40_HOUSE6_MIN = 283.720808d;
    static final double V40_HOUSE7_MAX = 618.738596d;
    static final double V40_HOUSE7_MIN = 283.720808d;
    static final double V40_HOUSE8_MAX = 618.738596d;
    static final double V40_HOUSE8_MIN = 283.720808d;
    static final double V40_HOUSE9_MAX = 618.738596d;
    static final double V40_HOUSE9_MIN = 283.720808d;
    static final double V40_MC_MAX = 393.49442d;
    static final double V40_MC_MIN = 331.162936d;
    static final double V40_POLASC_MAX = 618.738574d;
    static final double V40_POLASC_MIN = 283.720804d;
    static final double V40_VERTEX_MAX = 814.74585d;
    static final double V40_VERTEX_MIN = 256.68496d;
    static final double V50_ARMC_MAX = 360.985931d;
    static final double V50_ARMC_MIN = 360.985828d;
    static final double V50_ASC_MAX = 814.745889d;
    static final double V50_ASC_MIN = 256.684961d;
    static final double V50_COASC1_MAX = 814.74585d;
    static final double V50_COASC1_MIN = 256.68496d;
    static final double V50_COASC2_MAX = 618.738596d;
    static final double V50_COASC2_MIN = 283.720808d;
    static final double V50_EQUASC_MAX = 393.49442d;
    static final double V50_EQUASC_MIN = 331.162937d;
    static final double V50_HOUSE10_MAX = 814.745889d;
    static final double V50_HOUSE10_MIN = 256.684961d;
    static final double V50_HOUSE11_MAX = 814.745889d;
    static final double V50_HOUSE11_MIN = 256.684961d;
    static final double V50_HOUSE12_MAX = 814.745889d;
    static final double V50_HOUSE12_MIN = 256.684961d;
    static final double V50_HOUSE1_MAX = 814.745889d;
    static final double V50_HOUSE1_MIN = 256.684961d;
    static final double V50_HOUSE2_MAX = 814.745889d;
    static final double V50_HOUSE2_MIN = 256.684961d;
    static final double V50_HOUSE3_MAX = 814.745889d;
    static final double V50_HOUSE3_MIN = 256.684961d;
    static final double V50_HOUSE4_MAX = 814.745889d;
    static final double V50_HOUSE4_MIN = 256.684961d;
    static final double V50_HOUSE5_MAX = 814.745889d;
    static final double V50_HOUSE5_MIN = 256.684961d;
    static final double V50_HOUSE6_MAX = 814.745889d;
    static final double V50_HOUSE6_MIN = 256.684961d;
    static final double V50_HOUSE7_MAX = 814.745889d;
    static final double V50_HOUSE7_MIN = 256.684961d;
    static final double V50_HOUSE8_MAX = 814.745889d;
    static final double V50_HOUSE8_MIN = 256.684961d;
    static final double V50_HOUSE9_MAX = 814.745889d;
    static final double V50_HOUSE9_MIN = 256.684961d;
    static final double V50_MC_MAX = 393.49442d;
    static final double V50_MC_MIN = 331.162936d;
    static final double V50_POLASC_MAX = 814.74585d;
    static final double V50_POLASC_MIN = 256.68496d;
    static final double V50_VERTEX_MAX = 618.738574d;
    static final double V50_VERTEX_MIN = 283.720804d;
    static final double V60_ARMC_MAX = 360.985931d;
    static final double V60_ARMC_MIN = 360.985828d;
    static final double V60_ASC_MAX = 1583.084164d;
    static final double V60_ASC_MIN = 220.207028d;
    static final double V60_COASC1_MAX = 1583.084212d;
    static final double V60_COASC1_MIN = 220.207025d;
    static final double V60_COASC2_MAX = 524.994891d;
    static final double V60_COASC2_MIN = 304.407972d;
    static final double V60_EQUASC_MAX = 393.49442d;
    static final double V60_EQUASC_MIN = 331.162937d;
    static final double V60_HOUSE10_MAX = 1583.084164d;
    static final double V60_HOUSE10_MIN = 220.207028d;
    static final double V60_HOUSE11_MAX = 1583.084164d;
    static final double V60_HOUSE11_MIN = 220.207028d;
    static final double V60_HOUSE12_MAX = 1583.084164d;
    static final double V60_HOUSE12_MIN = 220.207028d;
    static final double V60_HOUSE1_MAX = 1583.084164d;
    static final double V60_HOUSE1_MIN = 220.207028d;
    static final double V60_HOUSE2_MAX = 1583.084164d;
    static final double V60_HOUSE2_MIN = 220.207028d;
    static final double V60_HOUSE3_MAX = 1583.084164d;
    static final double V60_HOUSE3_MIN = 220.207028d;
    static final double V60_HOUSE4_MAX = 1583.084164d;
    static final double V60_HOUSE4_MIN = 220.207028d;
    static final double V60_HOUSE5_MAX = 1583.084164d;
    static final double V60_HOUSE5_MIN = 220.207028d;
    static final double V60_HOUSE6_MAX = 1583.084164d;
    static final double V60_HOUSE6_MIN = 220.207028d;
    static final double V60_HOUSE7_MAX = 1583.084164d;
    static final double V60_HOUSE7_MIN = 220.207028d;
    static final double V60_HOUSE8_MAX = 1583.084164d;
    static final double V60_HOUSE8_MIN = 220.207028d;
    static final double V60_HOUSE9_MAX = 1583.084164d;
    static final double V60_HOUSE9_MIN = 220.207028d;
    static final double V60_MC_MAX = 393.49442d;
    static final double V60_MC_MIN = 331.162936d;
    static final double V60_POLASC_MAX = 1583.084212d;
    static final double V60_POLASC_MIN = 220.207025d;
    static final double V60_VERTEX_MAX = 524.994878d;
    static final double V60_VERTEX_MIN = 304.407972d;
    static final double V66_ARMC_MAX = 360.985931d;
    static final double V66_ARMC_MIN = 360.985828d;
    static final double V66_ASC_MAX = 15382.763492d;
    static final double V66_ASC_MIN = 180.714519d;
    static final double V66_COASC1_MAX = 15382.960178d;
    static final double V66_COASC1_MIN = 180.714532d;
    static final double V66_COASC2_MAX = 487.697885d;
    static final double V66_COASC2_MIN = 313.998924d;
    static final double V66_EQUASC_MAX = 393.49442d;
    static final double V66_EQUASC_MIN = 331.162937d;
    static final double V66_HOUSE10_MAX = 15382.763492d;
    static final double V66_HOUSE10_MIN = 180.714519d;
    static final double V66_HOUSE11_MAX = 15382.763492d;
    static final double V66_HOUSE11_MIN = 180.714519d;
    static final double V66_HOUSE12_MAX = 15382.763492d;
    static final double V66_HOUSE12_MIN = 180.714519d;
    static final double V66_HOUSE1_MAX = 15382.763492d;
    static final double V66_HOUSE1_MIN = 180.714519d;
    static final double V66_HOUSE2_MAX = 15382.763492d;
    static final double V66_HOUSE2_MIN = 180.714519d;
    static final double V66_HOUSE3_MAX = 15382.763492d;
    static final double V66_HOUSE3_MIN = 180.714519d;
    static final double V66_HOUSE4_MAX = 15382.763492d;
    static final double V66_HOUSE4_MIN = 180.714519d;
    static final double V66_HOUSE5_MAX = 15382.763492d;
    static final double V66_HOUSE5_MIN = 180.714519d;
    static final double V66_HOUSE6_MAX = 15382.763492d;
    static final double V66_HOUSE6_MIN = 180.714519d;
    static final double V66_HOUSE7_MAX = 15382.763492d;
    static final double V66_HOUSE7_MIN = 180.714519d;
    static final double V66_HOUSE8_MAX = 15382.763492d;
    static final double V66_HOUSE8_MIN = 180.714519d;
    static final double V66_HOUSE9_MAX = 15382.763492d;
    static final double V66_HOUSE9_MIN = 180.714519d;
    static final double V66_MC_MAX = 393.49442d;
    static final double V66_MC_MIN = 331.162936d;
    static final double V66_POLASC_MAX = 15382.960178d;
    static final double V66_POLASC_MIN = 180.714532d;
    static final double V66_VERTEX_MAX = 487.697876d;
    static final double V66_VERTEX_MIN = 313.998925d;
    static final double V70_ARMC_MAX = 360.985931d;
    static final double V70_ARMC_MIN = 360.985828d;
    static final double V70_ASC_MAX = 1553150.32968d;
    static final double V70_ASC_MIN = -777600.39302d;
    static final double V70_COASC1_MAX = 1553150.33462d;
    static final double V70_COASC1_MIN = -2066.704127d;
    static final double V70_COASC2_MAX = 467.280896d;
    static final double V70_COASC2_MIN = 319.225068d;
    static final double V70_EQUASC_MAX = 393.49442d;
    static final double V70_EQUASC_MIN = 331.162937d;
    static final double V70_HOUSE10_MAX = 1555199.608408d;
    static final double V70_HOUSE10_MIN = 0.389863d;
    static final double V70_HOUSE11_MAX = 1555199.608408d;
    static final double V70_HOUSE11_MIN = 0.389863d;
    static final double V70_HOUSE12_MAX = 1555199.608408d;
    static final double V70_HOUSE12_MIN = 0.389863d;
    static final double V70_HOUSE1_MAX = 1555199.608408d;
    static final double V70_HOUSE1_MIN = 0.389863d;
    static final double V70_HOUSE2_MAX = 1555199.608408d;
    static final double V70_HOUSE2_MIN = 0.389863d;
    static final double V70_HOUSE3_MAX = 1555199.608408d;
    static final double V70_HOUSE3_MIN = 0.389863d;
    static final double V70_HOUSE4_MAX = 1555199.608408d;
    static final double V70_HOUSE4_MIN = 0.389863d;
    static final double V70_HOUSE5_MAX = 1555199.608408d;
    static final double V70_HOUSE5_MIN = 0.389863d;
    static final double V70_HOUSE6_MAX = 1555199.608408d;
    static final double V70_HOUSE6_MIN = 0.389863d;
    static final double V70_HOUSE7_MAX = 1555199.608408d;
    static final double V70_HOUSE7_MIN = 0.389863d;
    static final double V70_HOUSE8_MAX = 1555199.608408d;
    static final double V70_HOUSE8_MIN = 0.389863d;
    static final double V70_HOUSE9_MAX = 1555199.608408d;
    static final double V70_HOUSE9_MIN = 0.389863d;
    static final double V70_MC_MAX = 393.49442d;
    static final double V70_MC_MIN = 331.162936d;
    static final double V70_POLASC_MAX = 179.610407d;
    static final double V70_POLASC_MIN = -2066.757416d;
    static final double V70_VERTEX_MAX = 467.280888d;
    static final double V70_VERTEX_MIN = 319.22507d;
    static final double V80_ARMC_MAX = 360.985931d;
    static final double V80_ARMC_MIN = 360.985828d;
    static final double V80_ASC_MAX = 1554930.566184d;
    static final double V80_ASC_MIN = -777600.124007d;
    static final double V80_COASC1_MAX = 1554930.566243d;
    static final double V80_COASC1_MIN = -269.995683d;
    static final double V80_COASC2_MAX = 426.089536d;
    static final double V80_COASC2_MIN = 328.169552d;
    static final double V80_EQUASC_MAX = 393.49442d;
    static final double V80_EQUASC_MIN = 331.162937d;
    static final double V80_HOUSE10_MAX = 1555199.876097d;
    static final double V80_HOUSE10_MIN = 0.12375d;
    static final double V80_HOUSE11_MAX = 1555199.876097d;
    static final double V80_HOUSE11_MIN = 0.12375d;
    static final double V80_HOUSE12_MAX = 1555199.876097d;
    static final double V80_HOUSE12_MIN = 0.12375d;
    static final double V80_HOUSE1_MAX = 1555199.876097d;
    static final double V80_HOUSE1_MIN = 0.12375d;
    static final double V80_HOUSE2_MAX = 1555199.876097d;
    static final double V80_HOUSE2_MIN = 0.12375d;
    static final double V80_HOUSE3_MAX = 1555199.876097d;
    static final double V80_HOUSE3_MIN = 0.12375d;
    static final double V80_HOUSE4_MAX = 1555199.876097d;
    static final double V80_HOUSE4_MIN = 0.12375d;
    static final double V80_HOUSE5_MAX = 1555199.876097d;
    static final double V80_HOUSE5_MIN = 0.12375d;
    static final double V80_HOUSE6_MAX = 1555199.876097d;
    static final double V80_HOUSE6_MIN = 0.12375d;
    static final double V80_HOUSE7_MAX = 1555199.876097d;
    static final double V80_HOUSE7_MIN = 0.12375d;
    static final double V80_HOUSE8_MAX = 1555199.876097d;
    static final double V80_HOUSE8_MIN = 0.12375d;
    static final double V80_HOUSE9_MAX = 1555199.876097d;
    static final double V80_HOUSE9_MIN = 0.12375d;
    static final double V80_MC_MAX = 393.49442d;
    static final double V80_MC_MIN = 331.162936d;
    static final double V80_POLASC_MAX = 113.797793d;
    static final double V80_POLASC_MIN = -269.996067d;
    static final double V80_VERTEX_MAX = 426.089531d;
    static final double V80_VERTEX_MIN = 328.16955d;
    static final double V85_ARMC_MAX = 360.985931d;
    static final double V85_ARMC_MIN = 360.985828d;
    static final double V85_ASC_MAX = 1555100.603952d;
    static final double V85_ASC_MIN = -777600.058703d;
    static final double V85_COASC1_MAX = 1555100.603957d;
    static final double V85_COASC1_MIN = -99.544583d;
    static final double V85_COASC2_MAX = 409.019308d;
    static final double V85_COASC2_MIN = 330.413985d;
    static final double V85_EQUASC_MAX = 393.49442d;
    static final double V85_EQUASC_MIN = 331.162937d;
    static final double V85_HOUSE10_MAX = 1555199.941344d;
    static final double V85_HOUSE10_MIN = 0.058615d;
    static final double V85_HOUSE11_MAX = 1555199.941344d;
    static final double V85_HOUSE11_MIN = 0.058615d;
    static final double V85_HOUSE12_MAX = 1555199.941344d;
    static final double V85_HOUSE12_MIN = 0.058615d;
    static final double V85_HOUSE1_MAX = 1555199.941344d;
    static final double V85_HOUSE1_MIN = 0.058615d;
    static final double V85_HOUSE2_MAX = 1555199.941344d;
    static final double V85_HOUSE2_MIN = 0.058615d;
    static final double V85_HOUSE3_MAX = 1555199.941344d;
    static final double V85_HOUSE3_MIN = 0.058615d;
    static final double V85_HOUSE4_MAX = 1555199.941344d;
    static final double V85_HOUSE4_MIN = 0.058615d;
    static final double V85_HOUSE5_MAX = 1555199.941344d;
    static final double V85_HOUSE5_MIN = 0.058615d;
    static final double V85_HOUSE6_MAX = 1555199.941344d;
    static final double V85_HOUSE6_MIN = 0.058615d;
    static final double V85_HOUSE7_MAX = 1555199.941344d;
    static final double V85_HOUSE7_MIN = 0.058615d;
    static final double V85_HOUSE8_MAX = 1555199.941344d;
    static final double V85_HOUSE8_MIN = 0.058615d;
    static final double V85_HOUSE9_MAX = 1555199.941344d;
    static final double V85_HOUSE9_MIN = 0.058615d;
    static final double V85_MC_MAX = 393.49442d;
    static final double V85_MC_MIN = 331.162936d;
    static final double V85_POLASC_MAX = 66.096027d;
    static final double V85_POLASC_MIN = -99.544653d;
    static final double V85_VERTEX_MAX = 409.019306d;
    static final double V85_VERTEX_MIN = 330.413985d;
    static final double V88_ARMC_MAX = 360.985931d;
    static final double V88_ARMC_MIN = 360.985828d;
    static final double V88_ASC_MAX = 1555165.554408d;
    static final double V88_ASC_MIN = -777600.02317d;
    static final double V88_COASC1_MAX = 1555165.554409d;
    static final double V88_COASC1_MIN = -34.489296d;
    static final double V88_COASC2_MAX = 399.547623d;
    static final double V88_COASC2_MIN = 331.043079d;
    static final double V88_EQUASC_MAX = 393.49442d;
    static final double V88_EQUASC_MIN = 331.162937d;
    static final double V88_HOUSE10_MAX = 1555199.976849d;
    static final double V88_HOUSE10_MIN = 0.023142d;
    static final double V88_HOUSE11_MAX = 1555199.976849d;
    static final double V88_HOUSE11_MIN = 0.023142d;
    static final double V88_HOUSE12_MAX = 1555199.976849d;
    static final double V88_HOUSE12_MIN = 0.023142d;
    static final double V88_HOUSE1_MAX = 1555199.976849d;
    static final double V88_HOUSE1_MIN = 0.023142d;
    static final double V88_HOUSE2_MAX = 1555199.976849d;
    static final double V88_HOUSE2_MIN = 0.023142d;
    static final double V88_HOUSE3_MAX = 1555199.976849d;
    static final double V88_HOUSE3_MIN = 0.023142d;
    static final double V88_HOUSE4_MAX = 1555199.976849d;
    static final double V88_HOUSE4_MIN = 0.023142d;
    static final double V88_HOUSE5_MAX = 1555199.976849d;
    static final double V88_HOUSE5_MIN = 0.023142d;
    static final double V88_HOUSE6_MAX = 1555199.976849d;
    static final double V88_HOUSE6_MIN = 0.023142d;
    static final double V88_HOUSE7_MAX = 1555199.976849d;
    static final double V88_HOUSE7_MIN = 0.023142d;
    static final double V88_HOUSE8_MAX = 1555199.976849d;
    static final double V88_HOUSE8_MIN = 0.023142d;
    static final double V88_HOUSE9_MAX = 1555199.976849d;
    static final double V88_HOUSE9_MIN = 0.023142d;
    static final double V88_MC_MAX = 393.49442d;
    static final double V88_MC_MIN = 331.162936d;
    static final double V88_POLASC_MAX = 29.34423d;
    static final double V88_POLASC_MIN = -34.489313d;
    static final double V88_VERTEX_MAX = 399.547621d;
    static final double V88_VERTEX_MIN = 331.043081d;
    static final double V90_ARMC_MAX = 360.985931d;
    static final double V90_ARMC_MIN = 360.985828d;
    static final double V90_ASC_MAX = 1555200.0d;
    static final double V90_ASC_MIN = -777600.0d;
    static final double V90_COASC1_MAX = 1555200.0d;
    static final double V90_COASC1_MIN = -0.0d;
    static final double V90_COASC2_MAX = 393.49442d;
    static final double V90_COASC2_MIN = 331.162937d;
    static final double V90_EQUASC_MAX = 393.49442d;
    static final double V90_EQUASC_MIN = 331.162937d;
    static final double V90_HOUSE10_MAX = 1555200.0d;
    static final double V90_HOUSE10_MIN = 0.0d;
    static final double V90_HOUSE11_MAX = 1555200.0d;
    static final double V90_HOUSE11_MIN = 0.0d;
    static final double V90_HOUSE12_MAX = 1555200.0d;
    static final double V90_HOUSE12_MIN = 0.0d;
    static final double V90_HOUSE1_MAX = 1555200.0d;
    static final double V90_HOUSE1_MIN = 0.0d;
    static final double V90_HOUSE2_MAX = 1555200.0d;
    static final double V90_HOUSE2_MIN = 0.0d;
    static final double V90_HOUSE3_MAX = 1555200.0d;
    static final double V90_HOUSE3_MIN = 0.0d;
    static final double V90_HOUSE4_MAX = 1555200.0d;
    static final double V90_HOUSE4_MIN = 0.0d;
    static final double V90_HOUSE5_MAX = 1555200.0d;
    static final double V90_HOUSE5_MIN = 0.0d;
    static final double V90_HOUSE6_MAX = 1555200.0d;
    static final double V90_HOUSE6_MIN = 0.0d;
    static final double V90_HOUSE7_MAX = 1555200.0d;
    static final double V90_HOUSE7_MIN = 0.0d;
    static final double V90_HOUSE8_MAX = 1555200.0d;
    static final double V90_HOUSE8_MIN = 0.0d;
    static final double V90_HOUSE9_MAX = 1555200.0d;
    static final double V90_HOUSE9_MIN = 0.0d;
    static final double V90_MC_MAX = 393.49442d;
    static final double V90_MC_MIN = 331.162936d;
    static final double V90_POLASC_MAX = 0.0d;
    static final double V90_POLASC_MIN = -0.0d;
    static final double V90_VERTEX_MAX = 393.49442d;
    static final double V90_VERTEX_MIN = 331.162937d;
    static final double W0_ARMC_MAX = 360.985931d;
    static final double W0_ARMC_MIN = 360.985828d;
    static final double W0_ASC_MAX = 393.49442d;
    static final double W0_ASC_MIN = 331.162937d;
    static final double W0_COASC1_MAX = 393.49442d;
    static final double W0_COASC1_MIN = 331.162937d;
    static final double W0_COASC2_MAX = 0.0d;
    static final double W0_COASC2_MIN = 0.0d;
    static final double W0_EQUASC_MAX = 393.49442d;
    static final double W0_EQUASC_MIN = 331.162937d;
    static final double W0_HOUSE10_MAX = 129600.0d;
    static final double W0_HOUSE10_MIN = 0.0d;
    static final double W0_HOUSE11_MAX = 129600.0d;
    static final double W0_HOUSE11_MIN = 0.0d;
    static final double W0_HOUSE12_MAX = 129600.0d;
    static final double W0_HOUSE12_MIN = 0.0d;
    static final double W0_HOUSE1_MAX = 129600.0d;
    static final double W0_HOUSE1_MIN = 0.0d;
    static final double W0_HOUSE2_MAX = 129600.0d;
    static final double W0_HOUSE2_MIN = 0.0d;
    static final double W0_HOUSE3_MAX = 129600.0d;
    static final double W0_HOUSE3_MIN = 0.0d;
    static final double W0_HOUSE4_MAX = 129600.0d;
    static final double W0_HOUSE4_MIN = 0.0d;
    static final double W0_HOUSE5_MAX = 129600.0d;
    static final double W0_HOUSE5_MIN = 0.0d;
    static final double W0_HOUSE6_MAX = 129600.0d;
    static final double W0_HOUSE6_MIN = 0.0d;
    static final double W0_HOUSE7_MAX = 129600.0d;
    static final double W0_HOUSE7_MIN = 0.0d;
    static final double W0_HOUSE8_MAX = 129600.0d;
    static final double W0_HOUSE8_MIN = 0.0d;
    static final double W0_HOUSE9_MAX = 129600.0d;
    static final double W0_HOUSE9_MIN = 0.0d;
    static final double W0_MC_MAX = 393.49442d;
    static final double W0_MC_MIN = 331.162936d;
    static final double W0_POLASC_MAX = 393.49442d;
    static final double W0_POLASC_MIN = 331.162937d;
    static final double W0_VERTEX_MAX = 777600.0d;
    static final double W0_VERTEX_MIN = -777600.0d;
    static final double W10_ARMC_MAX = 360.985931d;
    static final double W10_ARMC_MIN = 360.985828d;
    static final double W10_ASC_MAX = 426.089536d;
    static final double W10_ASC_MIN = 328.169552d;
    static final double W10_COASC1_MAX = 426.089531d;
    static final double W10_COASC1_MIN = 328.16955d;
    static final double W10_COASC2_MAX = 113.797795d;
    static final double W10_COASC2_MIN = -269.99607d;
    static final double W10_EQUASC_MAX = 393.49442d;
    static final double W10_EQUASC_MIN = 331.162937d;
    static final double W10_HOUSE10_MAX = 129600.0d;
    static final double W10_HOUSE10_MIN = 0.0d;
    static final double W10_HOUSE11_MAX = 129600.0d;
    static final double W10_HOUSE11_MIN = 0.0d;
    static final double W10_HOUSE12_MAX = 129600.0d;
    static final double W10_HOUSE12_MIN = 0.0d;
    static final double W10_HOUSE1_MAX = 129600.0d;
    static final double W10_HOUSE1_MIN = 0.0d;
    static final double W10_HOUSE2_MAX = 129600.0d;
    static final double W10_HOUSE2_MIN = 0.0d;
    static final double W10_HOUSE3_MAX = 129600.0d;
    static final double W10_HOUSE3_MIN = 0.0d;
    static final double W10_HOUSE4_MAX = 129600.0d;
    static final double W10_HOUSE4_MIN = 0.0d;
    static final double W10_HOUSE5_MAX = 129600.0d;
    static final double W10_HOUSE5_MIN = 0.0d;
    static final double W10_HOUSE6_MAX = 129600.0d;
    static final double W10_HOUSE6_MIN = 0.0d;
    static final double W10_HOUSE7_MAX = 129600.0d;
    static final double W10_HOUSE7_MIN = 0.0d;
    static final double W10_HOUSE8_MAX = 129600.0d;
    static final double W10_HOUSE8_MIN = 0.0d;
    static final double W10_HOUSE9_MAX = 129600.0d;
    static final double W10_HOUSE9_MIN = 0.0d;
    static final double W10_MC_MAX = 393.49442d;
    static final double W10_MC_MIN = 331.162936d;
    static final double W10_POLASC_MAX = 426.089531d;
    static final double W10_POLASC_MIN = 328.16955d;
    static final double W10_VERTEX_MAX = 1554930.566243d;
    static final double W10_VERTEX_MIN = -777600.124028d;
    static final double W20_ARMC_MAX = 360.985931d;
    static final double W20_ARMC_MIN = 360.985828d;
    static final double W20_ASC_MAX = 467.280896d;
    static final double W20_ASC_MIN = 319.225068d;
    static final double W20_COASC1_MAX = 467.280888d;
    static final double W20_COASC1_MIN = 319.22507d;
    static final double W20_COASC2_MAX = 179.610407d;
    static final double W20_COASC2_MIN = -2066.7575d;
    static final double W20_EQUASC_MAX = 393.49442d;
    static final double W20_EQUASC_MIN = 331.162937d;
    static final double W20_HOUSE10_MAX = 129600.0d;
    static final double W20_HOUSE10_MIN = 0.0d;
    static final double W20_HOUSE11_MAX = 129600.0d;
    static final double W20_HOUSE11_MIN = 0.0d;
    static final double W20_HOUSE12_MAX = 129600.0d;
    static final double W20_HOUSE12_MIN = 0.0d;
    static final double W20_HOUSE1_MAX = 129600.0d;
    static final double W20_HOUSE1_MIN = 0.0d;
    static final double W20_HOUSE2_MAX = 129600.0d;
    static final double W20_HOUSE2_MIN = 0.0d;
    static final double W20_HOUSE3_MAX = 129600.0d;
    static final double W20_HOUSE3_MIN = 0.0d;
    static final double W20_HOUSE4_MAX = 129600.0d;
    static final double W20_HOUSE4_MIN = 0.0d;
    static final double W20_HOUSE5_MAX = 129600.0d;
    static final double W20_HOUSE5_MIN = 0.0d;
    static final double W20_HOUSE6_MAX = 129600.0d;
    static final double W20_HOUSE6_MIN = 0.0d;
    static final double W20_HOUSE7_MAX = 129600.0d;
    static final double W20_HOUSE7_MIN = 0.0d;
    static final double W20_HOUSE8_MAX = 129600.0d;
    static final double W20_HOUSE8_MIN = 0.0d;
    static final double W20_HOUSE9_MAX = 129600.0d;
    static final double W20_HOUSE9_MIN = 0.0d;
    static final double W20_MC_MAX = 393.49442d;
    static final double W20_MC_MIN = 331.162936d;
    static final double W20_POLASC_MAX = 467.280888d;
    static final double W20_POLASC_MIN = 319.22507d;
    static final double W20_VERTEX_MAX = 1553150.33462d;
    static final double W20_VERTEX_MIN = -777600.393091d;
    static final double W30_ARMC_MAX = 360.985931d;
    static final double W30_ARMC_MIN = 360.985828d;
    static final double W30_ASC_MAX = 524.994891d;
    static final double W30_ASC_MIN = 304.407972d;
    static final double W30_COASC1_MAX = 524.994878d;
    static final double W30_COASC1_MIN = 304.407972d;
    static final double W30_COASC2_MAX = 1583.084164d;
    static final double W30_COASC2_MIN = 220.207028d;
    static final double W30_EQUASC_MAX = 393.49442d;
    static final double W30_EQUASC_MIN = 331.162937d;
    static final double W30_HOUSE10_MAX = 129600.0d;
    static final double W30_HOUSE10_MIN = 0.0d;
    static final double W30_HOUSE11_MAX = 129600.0d;
    static final double W30_HOUSE11_MIN = 0.0d;
    static final double W30_HOUSE12_MAX = 129600.0d;
    static final double W30_HOUSE12_MIN = 0.0d;
    static final double W30_HOUSE1_MAX = 129600.0d;
    static final double W30_HOUSE1_MIN = 0.0d;
    static final double W30_HOUSE2_MAX = 129600.0d;
    static final double W30_HOUSE2_MIN = 0.0d;
    static final double W30_HOUSE3_MAX = 129600.0d;
    static final double W30_HOUSE3_MIN = 0.0d;
    static final double W30_HOUSE4_MAX = 129600.0d;
    static final double W30_HOUSE4_MIN = 0.0d;
    static final double W30_HOUSE5_MAX = 129600.0d;
    static final double W30_HOUSE5_MIN = 0.0d;
    static final double W30_HOUSE6_MAX = 129600.0d;
    static final double W30_HOUSE6_MIN = 0.0d;
    static final double W30_HOUSE7_MAX = 129600.0d;
    static final double W30_HOUSE7_MIN = 0.0d;
    static final double W30_HOUSE8_MAX = 129600.0d;
    static final double W30_HOUSE8_MIN = 0.0d;
    static final double W30_HOUSE9_MAX = 129600.0d;
    static final double W30_HOUSE9_MIN = 0.0d;
    static final double W30_MC_MAX = 393.49442d;
    static final double W30_MC_MIN = 331.162936d;
    static final double W30_POLASC_MAX = 524.994878d;
    static final double W30_POLASC_MIN = 304.407972d;
    static final double W30_VERTEX_MAX = 1583.084212d;
    static final double W30_VERTEX_MIN = 220.207025d;
    static final double W40_ARMC_MAX = 360.985931d;
    static final double W40_ARMC_MIN = 360.985828d;
    static final double W40_ASC_MAX = 618.738596d;
    static final double W40_ASC_MIN = 283.720808d;
    static final double W40_COASC1_MAX = 618.738574d;
    static final double W40_COASC1_MIN = 283.720804d;
    static final double W40_COASC2_MAX = 814.745889d;
    static final double W40_COASC2_MIN = 256.684961d;
    static final double W40_EQUASC_MAX = 393.49442d;
    static final double W40_EQUASC_MIN = 331.162937d;
    static final double W40_HOUSE10_MAX = 129600.0d;
    static final double W40_HOUSE10_MIN = 0.0d;
    static final double W40_HOUSE11_MAX = 129600.0d;
    static final double W40_HOUSE11_MIN = 0.0d;
    static final double W40_HOUSE12_MAX = 129600.0d;
    static final double W40_HOUSE12_MIN = 0.0d;
    static final double W40_HOUSE1_MAX = 129600.0d;
    static final double W40_HOUSE1_MIN = 0.0d;
    static final double W40_HOUSE2_MAX = 129600.0d;
    static final double W40_HOUSE2_MIN = 0.0d;
    static final double W40_HOUSE3_MAX = 129600.0d;
    static final double W40_HOUSE3_MIN = 0.0d;
    static final double W40_HOUSE4_MAX = 129600.0d;
    static final double W40_HOUSE4_MIN = 0.0d;
    static final double W40_HOUSE5_MAX = 129600.0d;
    static final double W40_HOUSE5_MIN = 0.0d;
    static final double W40_HOUSE6_MAX = 129600.0d;
    static final double W40_HOUSE6_MIN = 0.0d;
    static final double W40_HOUSE7_MAX = 129600.0d;
    static final double W40_HOUSE7_MIN = 0.0d;
    static final double W40_HOUSE8_MAX = 129600.0d;
    static final double W40_HOUSE8_MIN = 0.0d;
    static final double W40_HOUSE9_MAX = 129600.0d;
    static final double W40_HOUSE9_MIN = 0.0d;
    static final double W40_MC_MAX = 393.49442d;
    static final double W40_MC_MIN = 331.162936d;
    static final double W40_POLASC_MAX = 618.738574d;
    static final double W40_POLASC_MIN = 283.720804d;
    static final double W40_VERTEX_MAX = 814.74585d;
    static final double W40_VERTEX_MIN = 256.68496d;
    static final double W50_ARMC_MAX = 360.985931d;
    static final double W50_ARMC_MIN = 360.985828d;
    static final double W50_ASC_MAX = 814.745889d;
    static final double W50_ASC_MIN = 256.684961d;
    static final double W50_COASC1_MAX = 814.74585d;
    static final double W50_COASC1_MIN = 256.68496d;
    static final double W50_COASC2_MAX = 618.738596d;
    static final double W50_COASC2_MIN = 283.720808d;
    static final double W50_EQUASC_MAX = 393.49442d;
    static final double W50_EQUASC_MIN = 331.162937d;
    static final double W50_HOUSE10_MAX = 129600.0d;
    static final double W50_HOUSE10_MIN = 0.0d;
    static final double W50_HOUSE11_MAX = 129600.0d;
    static final double W50_HOUSE11_MIN = 0.0d;
    static final double W50_HOUSE12_MAX = 129600.0d;
    static final double W50_HOUSE12_MIN = 0.0d;
    static final double W50_HOUSE1_MAX = 129600.0d;
    static final double W50_HOUSE1_MIN = 0.0d;
    static final double W50_HOUSE2_MAX = 129600.0d;
    static final double W50_HOUSE2_MIN = 0.0d;
    static final double W50_HOUSE3_MAX = 129600.0d;
    static final double W50_HOUSE3_MIN = 0.0d;
    static final double W50_HOUSE4_MAX = 129600.0d;
    static final double W50_HOUSE4_MIN = 0.0d;
    static final double W50_HOUSE5_MAX = 129600.0d;
    static final double W50_HOUSE5_MIN = 0.0d;
    static final double W50_HOUSE6_MAX = 129600.0d;
    static final double W50_HOUSE6_MIN = 0.0d;
    static final double W50_HOUSE7_MAX = 129600.0d;
    static final double W50_HOUSE7_MIN = 0.0d;
    static final double W50_HOUSE8_MAX = 129600.0d;
    static final double W50_HOUSE8_MIN = 0.0d;
    static final double W50_HOUSE9_MAX = 129600.0d;
    static final double W50_HOUSE9_MIN = 0.0d;
    static final double W50_MC_MAX = 393.49442d;
    static final double W50_MC_MIN = 331.162936d;
    static final double W50_POLASC_MAX = 814.74585d;
    static final double W50_POLASC_MIN = 256.68496d;
    static final double W50_VERTEX_MAX = 618.738574d;
    static final double W50_VERTEX_MIN = 283.720804d;
    static final double W60_ARMC_MAX = 360.985931d;
    static final double W60_ARMC_MIN = 360.985828d;
    static final double W60_ASC_MAX = 1583.084164d;
    static final double W60_ASC_MIN = 220.207028d;
    static final double W60_COASC1_MAX = 1583.084212d;
    static final double W60_COASC1_MIN = 220.207025d;
    static final double W60_COASC2_MAX = 524.994891d;
    static final double W60_COASC2_MIN = 304.407972d;
    static final double W60_EQUASC_MAX = 393.49442d;
    static final double W60_EQUASC_MIN = 331.162937d;
    static final double W60_HOUSE10_MAX = 129600.0d;
    static final double W60_HOUSE10_MIN = 0.0d;
    static final double W60_HOUSE11_MAX = 129600.0d;
    static final double W60_HOUSE11_MIN = 0.0d;
    static final double W60_HOUSE12_MAX = 129600.0d;
    static final double W60_HOUSE12_MIN = 0.0d;
    static final double W60_HOUSE1_MAX = 129600.0d;
    static final double W60_HOUSE1_MIN = 0.0d;
    static final double W60_HOUSE2_MAX = 129600.0d;
    static final double W60_HOUSE2_MIN = 0.0d;
    static final double W60_HOUSE3_MAX = 129600.0d;
    static final double W60_HOUSE3_MIN = 0.0d;
    static final double W60_HOUSE4_MAX = 129600.0d;
    static final double W60_HOUSE4_MIN = 0.0d;
    static final double W60_HOUSE5_MAX = 129600.0d;
    static final double W60_HOUSE5_MIN = 0.0d;
    static final double W60_HOUSE6_MAX = 129600.0d;
    static final double W60_HOUSE6_MIN = 0.0d;
    static final double W60_HOUSE7_MAX = 129600.0d;
    static final double W60_HOUSE7_MIN = 0.0d;
    static final double W60_HOUSE8_MAX = 129600.0d;
    static final double W60_HOUSE8_MIN = 0.0d;
    static final double W60_HOUSE9_MAX = 129600.0d;
    static final double W60_HOUSE9_MIN = 0.0d;
    static final double W60_MC_MAX = 393.49442d;
    static final double W60_MC_MIN = 331.162936d;
    static final double W60_POLASC_MAX = 1583.084212d;
    static final double W60_POLASC_MIN = 220.207025d;
    static final double W60_VERTEX_MAX = 524.994878d;
    static final double W60_VERTEX_MIN = 304.407972d;
    static final double W66_ARMC_MAX = 360.985931d;
    static final double W66_ARMC_MIN = 360.985828d;
    static final double W66_ASC_MAX = 15382.763492d;
    static final double W66_ASC_MIN = 180.714519d;
    static final double W66_COASC1_MAX = 15382.960178d;
    static final double W66_COASC1_MIN = 180.714532d;
    static final double W66_COASC2_MAX = 487.697885d;
    static final double W66_COASC2_MIN = 313.998924d;
    static final double W66_EQUASC_MAX = 393.49442d;
    static final double W66_EQUASC_MIN = 331.162937d;
    static final double W66_HOUSE10_MAX = 129600.0d;
    static final double W66_HOUSE10_MIN = 0.0d;
    static final double W66_HOUSE11_MAX = 129600.0d;
    static final double W66_HOUSE11_MIN = 0.0d;
    static final double W66_HOUSE12_MAX = 129600.0d;
    static final double W66_HOUSE12_MIN = 0.0d;
    static final double W66_HOUSE1_MAX = 129600.0d;
    static final double W66_HOUSE1_MIN = 0.0d;
    static final double W66_HOUSE2_MAX = 129600.0d;
    static final double W66_HOUSE2_MIN = 0.0d;
    static final double W66_HOUSE3_MAX = 129600.0d;
    static final double W66_HOUSE3_MIN = 0.0d;
    static final double W66_HOUSE4_MAX = 129600.0d;
    static final double W66_HOUSE4_MIN = 0.0d;
    static final double W66_HOUSE5_MAX = 129600.0d;
    static final double W66_HOUSE5_MIN = 0.0d;
    static final double W66_HOUSE6_MAX = 129600.0d;
    static final double W66_HOUSE6_MIN = 0.0d;
    static final double W66_HOUSE7_MAX = 129600.0d;
    static final double W66_HOUSE7_MIN = 0.0d;
    static final double W66_HOUSE8_MAX = 129600.0d;
    static final double W66_HOUSE8_MIN = 0.0d;
    static final double W66_HOUSE9_MAX = 129600.0d;
    static final double W66_HOUSE9_MIN = 0.0d;
    static final double W66_MC_MAX = 393.49442d;
    static final double W66_MC_MIN = 331.162936d;
    static final double W66_POLASC_MAX = 15382.960178d;
    static final double W66_POLASC_MIN = 180.714532d;
    static final double W66_VERTEX_MAX = 487.697876d;
    static final double W66_VERTEX_MIN = 313.998925d;
    static final double W70_ARMC_MAX = 360.985931d;
    static final double W70_ARMC_MIN = 360.985828d;
    static final double W70_ASC_MAX = 1553150.32968d;
    static final double W70_ASC_MIN = -777600.39302d;
    static final double W70_COASC1_MAX = 1553150.33462d;
    static final double W70_COASC1_MIN = -2066.704127d;
    static final double W70_COASC2_MAX = 467.280896d;
    static final double W70_COASC2_MIN = 319.225068d;
    static final double W70_EQUASC_MAX = 393.49442d;
    static final double W70_EQUASC_MIN = 331.162937d;
    static final double W70_HOUSE10_MAX = 1425600.0d;
    static final double W70_HOUSE10_MIN = 0.0d;
    static final double W70_HOUSE11_MAX = 1425600.0d;
    static final double W70_HOUSE11_MIN = 0.0d;
    static final double W70_HOUSE12_MAX = 1425600.0d;
    static final double W70_HOUSE12_MIN = 0.0d;
    static final double W70_HOUSE1_MAX = 1425600.0d;
    static final double W70_HOUSE1_MIN = 0.0d;
    static final double W70_HOUSE2_MAX = 1425600.0d;
    static final double W70_HOUSE2_MIN = 0.0d;
    static final double W70_HOUSE3_MAX = 1425600.0d;
    static final double W70_HOUSE3_MIN = 0.0d;
    static final double W70_HOUSE4_MAX = 1425600.0d;
    static final double W70_HOUSE4_MIN = 0.0d;
    static final double W70_HOUSE5_MAX = 1425600.0d;
    static final double W70_HOUSE5_MIN = 0.0d;
    static final double W70_HOUSE6_MAX = 1425600.0d;
    static final double W70_HOUSE6_MIN = 0.0d;
    static final double W70_HOUSE7_MAX = 1425600.0d;
    static final double W70_HOUSE7_MIN = 0.0d;
    static final double W70_HOUSE8_MAX = 1425600.0d;
    static final double W70_HOUSE8_MIN = 0.0d;
    static final double W70_HOUSE9_MAX = 1425600.0d;
    static final double W70_HOUSE9_MIN = 0.0d;
    static final double W70_MC_MAX = 393.49442d;
    static final double W70_MC_MIN = 331.162936d;
    static final double W70_POLASC_MAX = 179.610407d;
    static final double W70_POLASC_MIN = -2066.757416d;
    static final double W70_VERTEX_MAX = 467.280888d;
    static final double W70_VERTEX_MIN = 319.22507d;
    static final double W80_ARMC_MAX = 360.985931d;
    static final double W80_ARMC_MIN = 360.985828d;
    static final double W80_ASC_MAX = 1554930.566184d;
    static final double W80_ASC_MIN = -777600.124007d;
    static final double W80_COASC1_MAX = 1554930.566243d;
    static final double W80_COASC1_MIN = -269.995683d;
    static final double W80_COASC2_MAX = 426.089536d;
    static final double W80_COASC2_MIN = 328.169552d;
    static final double W80_EQUASC_MAX = 393.49442d;
    static final double W80_EQUASC_MIN = 331.162937d;
    static final double W80_HOUSE10_MAX = 1425600.0d;
    static final double W80_HOUSE10_MIN = 0.0d;
    static final double W80_HOUSE11_MAX = 1425600.0d;
    static final double W80_HOUSE11_MIN = 0.0d;
    static final double W80_HOUSE12_MAX = 1425600.0d;
    static final double W80_HOUSE12_MIN = 0.0d;
    static final double W80_HOUSE1_MAX = 1425600.0d;
    static final double W80_HOUSE1_MIN = 0.0d;
    static final double W80_HOUSE2_MAX = 1425600.0d;
    static final double W80_HOUSE2_MIN = 0.0d;
    static final double W80_HOUSE3_MAX = 1425600.0d;
    static final double W80_HOUSE3_MIN = 0.0d;
    static final double W80_HOUSE4_MAX = 1425600.0d;
    static final double W80_HOUSE4_MIN = 0.0d;
    static final double W80_HOUSE5_MAX = 1425600.0d;
    static final double W80_HOUSE5_MIN = 0.0d;
    static final double W80_HOUSE6_MAX = 1425600.0d;
    static final double W80_HOUSE6_MIN = 0.0d;
    static final double W80_HOUSE7_MAX = 1425600.0d;
    static final double W80_HOUSE7_MIN = 0.0d;
    static final double W80_HOUSE8_MAX = 1425600.0d;
    static final double W80_HOUSE8_MIN = 0.0d;
    static final double W80_HOUSE9_MAX = 1425600.0d;
    static final double W80_HOUSE9_MIN = 0.0d;
    static final double W80_MC_MAX = 393.49442d;
    static final double W80_MC_MIN = 331.162936d;
    static final double W80_POLASC_MAX = 113.797793d;
    static final double W80_POLASC_MIN = -269.996067d;
    static final double W80_VERTEX_MAX = 426.089531d;
    static final double W80_VERTEX_MIN = 328.16955d;
    static final double W85_ARMC_MAX = 360.985931d;
    static final double W85_ARMC_MIN = 360.985828d;
    static final double W85_ASC_MAX = 1555100.603952d;
    static final double W85_ASC_MIN = -777600.058703d;
    static final double W85_COASC1_MAX = 1555100.603957d;
    static final double W85_COASC1_MIN = -99.544583d;
    static final double W85_COASC2_MAX = 409.019308d;
    static final double W85_COASC2_MIN = 330.413985d;
    static final double W85_EQUASC_MAX = 393.49442d;
    static final double W85_EQUASC_MIN = 331.162937d;
    static final double W85_HOUSE10_MAX = 1425600.0d;
    static final double W85_HOUSE10_MIN = 0.0d;
    static final double W85_HOUSE11_MAX = 1425600.0d;
    static final double W85_HOUSE11_MIN = 0.0d;
    static final double W85_HOUSE12_MAX = 1425600.0d;
    static final double W85_HOUSE12_MIN = 0.0d;
    static final double W85_HOUSE1_MAX = 1425600.0d;
    static final double W85_HOUSE1_MIN = 0.0d;
    static final double W85_HOUSE2_MAX = 1425600.0d;
    static final double W85_HOUSE2_MIN = 0.0d;
    static final double W85_HOUSE3_MAX = 1425600.0d;
    static final double W85_HOUSE3_MIN = 0.0d;
    static final double W85_HOUSE4_MAX = 1425600.0d;
    static final double W85_HOUSE4_MIN = 0.0d;
    static final double W85_HOUSE5_MAX = 1425600.0d;
    static final double W85_HOUSE5_MIN = 0.0d;
    static final double W85_HOUSE6_MAX = 1425600.0d;
    static final double W85_HOUSE6_MIN = 0.0d;
    static final double W85_HOUSE7_MAX = 1425600.0d;
    static final double W85_HOUSE7_MIN = 0.0d;
    static final double W85_HOUSE8_MAX = 1425600.0d;
    static final double W85_HOUSE8_MIN = 0.0d;
    static final double W85_HOUSE9_MAX = 1425600.0d;
    static final double W85_HOUSE9_MIN = 0.0d;
    static final double W85_MC_MAX = 393.49442d;
    static final double W85_MC_MIN = 331.162936d;
    static final double W85_POLASC_MAX = 66.096027d;
    static final double W85_POLASC_MIN = -99.544653d;
    static final double W85_VERTEX_MAX = 409.019306d;
    static final double W85_VERTEX_MIN = 330.413985d;
    static final double W88_ARMC_MAX = 360.985931d;
    static final double W88_ARMC_MIN = 360.985828d;
    static final double W88_ASC_MAX = 1555165.554408d;
    static final double W88_ASC_MIN = -777600.02317d;
    static final double W88_COASC1_MAX = 1555165.554409d;
    static final double W88_COASC1_MIN = -34.489296d;
    static final double W88_COASC2_MAX = 399.547623d;
    static final double W88_COASC2_MIN = 331.043079d;
    static final double W88_EQUASC_MAX = 393.49442d;
    static final double W88_EQUASC_MIN = 331.162937d;
    static final double W88_HOUSE10_MAX = 1425600.0d;
    static final double W88_HOUSE10_MIN = 0.0d;
    static final double W88_HOUSE11_MAX = 1425600.0d;
    static final double W88_HOUSE11_MIN = 0.0d;
    static final double W88_HOUSE12_MAX = 1425600.0d;
    static final double W88_HOUSE12_MIN = 0.0d;
    static final double W88_HOUSE1_MAX = 1425600.0d;
    static final double W88_HOUSE1_MIN = 0.0d;
    static final double W88_HOUSE2_MAX = 1425600.0d;
    static final double W88_HOUSE2_MIN = 0.0d;
    static final double W88_HOUSE3_MAX = 1425600.0d;
    static final double W88_HOUSE3_MIN = 0.0d;
    static final double W88_HOUSE4_MAX = 1425600.0d;
    static final double W88_HOUSE4_MIN = 0.0d;
    static final double W88_HOUSE5_MAX = 1425600.0d;
    static final double W88_HOUSE5_MIN = 0.0d;
    static final double W88_HOUSE6_MAX = 1425600.0d;
    static final double W88_HOUSE6_MIN = 0.0d;
    static final double W88_HOUSE7_MAX = 1425600.0d;
    static final double W88_HOUSE7_MIN = 0.0d;
    static final double W88_HOUSE8_MAX = 1425600.0d;
    static final double W88_HOUSE8_MIN = 0.0d;
    static final double W88_HOUSE9_MAX = 1425600.0d;
    static final double W88_HOUSE9_MIN = 0.0d;
    static final double W88_MC_MAX = 393.49442d;
    static final double W88_MC_MIN = 331.162936d;
    static final double W88_POLASC_MAX = 29.34423d;
    static final double W88_POLASC_MIN = -34.489313d;
    static final double W88_VERTEX_MAX = 399.547621d;
    static final double W88_VERTEX_MIN = 331.043081d;
    static final double W90_ARMC_MAX = 360.985931d;
    static final double W90_ARMC_MIN = 360.985828d;
    static final double W90_ASC_MAX = 1555200.0d;
    static final double W90_ASC_MIN = -777600.0d;
    static final double W90_COASC1_MAX = 1555200.0d;
    static final double W90_COASC1_MIN = -0.0d;
    static final double W90_COASC2_MAX = 393.49442d;
    static final double W90_COASC2_MIN = 331.162937d;
    static final double W90_EQUASC_MAX = 393.49442d;
    static final double W90_EQUASC_MIN = 331.162937d;
    static final double W90_HOUSE10_MAX = 1425600.0d;
    static final double W90_HOUSE10_MIN = 0.0d;
    static final double W90_HOUSE11_MAX = 1425600.0d;
    static final double W90_HOUSE11_MIN = 0.0d;
    static final double W90_HOUSE12_MAX = 1425600.0d;
    static final double W90_HOUSE12_MIN = 0.0d;
    static final double W90_HOUSE1_MAX = 1425600.0d;
    static final double W90_HOUSE1_MIN = 0.0d;
    static final double W90_HOUSE2_MAX = 1425600.0d;
    static final double W90_HOUSE2_MIN = 0.0d;
    static final double W90_HOUSE3_MAX = 1425600.0d;
    static final double W90_HOUSE3_MIN = 0.0d;
    static final double W90_HOUSE4_MAX = 1425600.0d;
    static final double W90_HOUSE4_MIN = 0.0d;
    static final double W90_HOUSE5_MAX = 1425600.0d;
    static final double W90_HOUSE5_MIN = 0.0d;
    static final double W90_HOUSE6_MAX = 1425600.0d;
    static final double W90_HOUSE6_MIN = 0.0d;
    static final double W90_HOUSE7_MAX = 1425600.0d;
    static final double W90_HOUSE7_MIN = 0.0d;
    static final double W90_HOUSE8_MAX = 1425600.0d;
    static final double W90_HOUSE8_MIN = 0.0d;
    static final double W90_HOUSE9_MAX = 1425600.0d;
    static final double W90_HOUSE9_MIN = 0.0d;
    static final double W90_MC_MAX = 393.49442d;
    static final double W90_MC_MIN = 331.162936d;
    static final double W90_POLASC_MAX = 0.0d;
    static final double W90_POLASC_MIN = -0.0d;
    static final double W90_VERTEX_MAX = 393.49442d;
    static final double W90_VERTEX_MIN = 331.162937d;
    static final double X0_ARMC_MAX = 360.985931d;
    static final double X0_ARMC_MIN = 360.985828d;
    static final double X0_ASC_MAX = 393.49442d;
    static final double X0_ASC_MIN = 331.162937d;
    static final double X0_COASC1_MAX = 393.49442d;
    static final double X0_COASC1_MIN = 331.162937d;
    static final double X0_COASC2_MAX = Double.POSITIVE_INFINITY;
    static final double X0_COASC2_MIN = Double.POSITIVE_INFINITY;
    static final double X0_EQUASC_MAX = 393.49442d;
    static final double X0_EQUASC_MIN = 331.162937d;
    static final double X0_HOUSE10_MAX = 393.49442d;
    static final double X0_HOUSE10_MIN = 331.162936d;
    static final double X0_HOUSE11_MAX = 393.49442d;
    static final double X0_HOUSE11_MIN = 331.162936d;
    static final double X0_HOUSE12_MAX = 393.49442d;
    static final double X0_HOUSE12_MIN = 331.162937d;
    static final double X0_HOUSE1_MAX = 393.49442d;
    static final double X0_HOUSE1_MIN = 331.162937d;
    static final double X0_HOUSE2_MAX = 393.49442d;
    static final double X0_HOUSE2_MIN = 331.162937d;
    static final double X0_HOUSE3_MAX = 393.494421d;
    static final double X0_HOUSE3_MIN = 331.162936d;
    static final double X0_HOUSE4_MAX = 393.49442d;
    static final double X0_HOUSE4_MIN = 331.162936d;
    static final double X0_HOUSE5_MAX = 393.49442d;
    static final double X0_HOUSE5_MIN = 331.162936d;
    static final double X0_HOUSE6_MAX = 393.49442d;
    static final double X0_HOUSE6_MIN = 331.162937d;
    static final double X0_HOUSE7_MAX = 393.49442d;
    static final double X0_HOUSE7_MIN = 331.162937d;
    static final double X0_HOUSE8_MAX = 393.49442d;
    static final double X0_HOUSE8_MIN = 331.162937d;
    static final double X0_HOUSE9_MAX = 393.494421d;
    static final double X0_HOUSE9_MIN = 331.162936d;
    static final double X0_MC_MAX = 393.49442d;
    static final double X0_MC_MIN = 331.162936d;
    static final double X0_POLASC_MAX = 393.49442d;
    static final double X0_POLASC_MIN = 331.162937d;
    static final double X0_VERTEX_MAX = 777600.0d;
    static final double X0_VERTEX_MIN = -777600.0d;
    static final double X10_ARMC_MAX = 360.985931d;
    static final double X10_ARMC_MIN = 360.985828d;
    static final double X10_ASC_MAX = 426.089536d;
    static final double X10_ASC_MIN = 328.169552d;
    static final double X10_COASC1_MAX = 426.089531d;
    static final double X10_COASC1_MIN = 328.16955d;
    static final double X10_COASC2_MAX = 113.797795d;
    static final double X10_COASC2_MIN = -269.99607d;
    static final double X10_EQUASC_MAX = 393.49442d;
    static final double X10_EQUASC_MIN = 331.162937d;
    static final double X10_HOUSE10_MAX = 393.49442d;
    static final double X10_HOUSE10_MIN = 331.162936d;
    static final double X10_HOUSE11_MAX = 393.49442d;
    static final double X10_HOUSE11_MIN = 331.162936d;
    static final double X10_HOUSE12_MAX = 393.49442d;
    static final double X10_HOUSE12_MIN = 331.162937d;
    static final double X10_HOUSE1_MAX = 393.49442d;
    static final double X10_HOUSE1_MIN = 331.162937d;
    static final double X10_HOUSE2_MAX = 393.49442d;
    static final double X10_HOUSE2_MIN = 331.162937d;
    static final double X10_HOUSE3_MAX = 393.494421d;
    static final double X10_HOUSE3_MIN = 331.162936d;
    static final double X10_HOUSE4_MAX = 393.49442d;
    static final double X10_HOUSE4_MIN = 331.162936d;
    static final double X10_HOUSE5_MAX = 393.49442d;
    static final double X10_HOUSE5_MIN = 331.162936d;
    static final double X10_HOUSE6_MAX = 393.49442d;
    static final double X10_HOUSE6_MIN = 331.162937d;
    static final double X10_HOUSE7_MAX = 393.49442d;
    static final double X10_HOUSE7_MIN = 331.162937d;
    static final double X10_HOUSE8_MAX = 393.49442d;
    static final double X10_HOUSE8_MIN = 331.162937d;
    static final double X10_HOUSE9_MAX = 393.494421d;
    static final double X10_HOUSE9_MIN = 331.162936d;
    static final double X10_MC_MAX = 393.49442d;
    static final double X10_MC_MIN = 331.162936d;
    static final double X10_POLASC_MAX = 426.089531d;
    static final double X10_POLASC_MIN = 328.16955d;
    static final double X10_VERTEX_MAX = 1554930.566243d;
    static final double X10_VERTEX_MIN = -777600.124028d;
    static final double X20_ARMC_MAX = 360.985931d;
    static final double X20_ARMC_MIN = 360.985828d;
    static final double X20_ASC_MAX = 467.280896d;
    static final double X20_ASC_MIN = 319.225068d;
    static final double X20_COASC1_MAX = 467.280888d;
    static final double X20_COASC1_MIN = 319.22507d;
    static final double X20_COASC2_MAX = 179.610407d;
    static final double X20_COASC2_MIN = -2066.7575d;
    static final double X20_EQUASC_MAX = 393.49442d;
    static final double X20_EQUASC_MIN = 331.162937d;
    static final double X20_HOUSE10_MAX = 393.49442d;
    static final double X20_HOUSE10_MIN = 331.162936d;
    static final double X20_HOUSE11_MAX = 393.49442d;
    static final double X20_HOUSE11_MIN = 331.162936d;
    static final double X20_HOUSE12_MAX = 393.49442d;
    static final double X20_HOUSE12_MIN = 331.162937d;
    static final double X20_HOUSE1_MAX = 393.49442d;
    static final double X20_HOUSE1_MIN = 331.162937d;
    static final double X20_HOUSE2_MAX = 393.49442d;
    static final double X20_HOUSE2_MIN = 331.162937d;
    static final double X20_HOUSE3_MAX = 393.494421d;
    static final double X20_HOUSE3_MIN = 331.162936d;
    static final double X20_HOUSE4_MAX = 393.49442d;
    static final double X20_HOUSE4_MIN = 331.162936d;
    static final double X20_HOUSE5_MAX = 393.49442d;
    static final double X20_HOUSE5_MIN = 331.162936d;
    static final double X20_HOUSE6_MAX = 393.49442d;
    static final double X20_HOUSE6_MIN = 331.162937d;
    static final double X20_HOUSE7_MAX = 393.49442d;
    static final double X20_HOUSE7_MIN = 331.162937d;
    static final double X20_HOUSE8_MAX = 393.49442d;
    static final double X20_HOUSE8_MIN = 331.162937d;
    static final double X20_HOUSE9_MAX = 393.494421d;
    static final double X20_HOUSE9_MIN = 331.162936d;
    static final double X20_MC_MAX = 393.49442d;
    static final double X20_MC_MIN = 331.162936d;
    static final double X20_POLASC_MAX = 467.280888d;
    static final double X20_POLASC_MIN = 319.22507d;
    static final double X20_VERTEX_MAX = 1553150.33462d;
    static final double X20_VERTEX_MIN = -777600.393091d;
    static final double X30_ARMC_MAX = 360.985931d;
    static final double X30_ARMC_MIN = 360.985828d;
    static final double X30_ASC_MAX = 524.994891d;
    static final double X30_ASC_MIN = 304.407972d;
    static final double X30_COASC1_MAX = 524.994878d;
    static final double X30_COASC1_MIN = 304.407972d;
    static final double X30_COASC2_MAX = 1583.084164d;
    static final double X30_COASC2_MIN = 220.207028d;
    static final double X30_EQUASC_MAX = 393.49442d;
    static final double X30_EQUASC_MIN = 331.162937d;
    static final double X30_HOUSE10_MAX = 393.49442d;
    static final double X30_HOUSE10_MIN = 331.162936d;
    static final double X30_HOUSE11_MAX = 393.49442d;
    static final double X30_HOUSE11_MIN = 331.162936d;
    static final double X30_HOUSE12_MAX = 393.49442d;
    static final double X30_HOUSE12_MIN = 331.162937d;
    static final double X30_HOUSE1_MAX = 393.49442d;
    static final double X30_HOUSE1_MIN = 331.162937d;
    static final double X30_HOUSE2_MAX = 393.49442d;
    static final double X30_HOUSE2_MIN = 331.162937d;
    static final double X30_HOUSE3_MAX = 393.494421d;
    static final double X30_HOUSE3_MIN = 331.162936d;
    static final double X30_HOUSE4_MAX = 393.49442d;
    static final double X30_HOUSE4_MIN = 331.162936d;
    static final double X30_HOUSE5_MAX = 393.49442d;
    static final double X30_HOUSE5_MIN = 331.162936d;
    static final double X30_HOUSE6_MAX = 393.49442d;
    static final double X30_HOUSE6_MIN = 331.162937d;
    static final double X30_HOUSE7_MAX = 393.49442d;
    static final double X30_HOUSE7_MIN = 331.162937d;
    static final double X30_HOUSE8_MAX = 393.49442d;
    static final double X30_HOUSE8_MIN = 331.162937d;
    static final double X30_HOUSE9_MAX = 393.494421d;
    static final double X30_HOUSE9_MIN = 331.162936d;
    static final double X30_MC_MAX = 393.49442d;
    static final double X30_MC_MIN = 331.162936d;
    static final double X30_POLASC_MAX = 524.994878d;
    static final double X30_POLASC_MIN = 304.407972d;
    static final double X30_VERTEX_MAX = 1583.084212d;
    static final double X30_VERTEX_MIN = 220.207025d;
    static final double X40_ARMC_MAX = 360.985931d;
    static final double X40_ARMC_MIN = 360.985828d;
    static final double X40_ASC_MAX = 618.738596d;
    static final double X40_ASC_MIN = 283.720808d;
    static final double X40_COASC1_MAX = 618.738574d;
    static final double X40_COASC1_MIN = 283.720804d;
    static final double X40_COASC2_MAX = 814.745889d;
    static final double X40_COASC2_MIN = 256.684961d;
    static final double X40_EQUASC_MAX = 393.49442d;
    static final double X40_EQUASC_MIN = 331.162937d;
    static final double X40_HOUSE10_MAX = 393.49442d;
    static final double X40_HOUSE10_MIN = 331.162936d;
    static final double X40_HOUSE11_MAX = 393.49442d;
    static final double X40_HOUSE11_MIN = 331.162936d;
    static final double X40_HOUSE12_MAX = 393.49442d;
    static final double X40_HOUSE12_MIN = 331.162937d;
    static final double X40_HOUSE1_MAX = 393.49442d;
    static final double X40_HOUSE1_MIN = 331.162937d;
    static final double X40_HOUSE2_MAX = 393.49442d;
    static final double X40_HOUSE2_MIN = 331.162937d;
    static final double X40_HOUSE3_MAX = 393.494421d;
    static final double X40_HOUSE3_MIN = 331.162936d;
    static final double X40_HOUSE4_MAX = 393.49442d;
    static final double X40_HOUSE4_MIN = 331.162936d;
    static final double X40_HOUSE5_MAX = 393.49442d;
    static final double X40_HOUSE5_MIN = 331.162936d;
    static final double X40_HOUSE6_MAX = 393.49442d;
    static final double X40_HOUSE6_MIN = 331.162937d;
    static final double X40_HOUSE7_MAX = 393.49442d;
    static final double X40_HOUSE7_MIN = 331.162937d;
    static final double X40_HOUSE8_MAX = 393.49442d;
    static final double X40_HOUSE8_MIN = 331.162937d;
    static final double X40_HOUSE9_MAX = 393.494421d;
    static final double X40_HOUSE9_MIN = 331.162936d;
    static final double X40_MC_MAX = 393.49442d;
    static final double X40_MC_MIN = 331.162936d;
    static final double X40_POLASC_MAX = 618.738574d;
    static final double X40_POLASC_MIN = 283.720804d;
    static final double X40_VERTEX_MAX = 814.74585d;
    static final double X40_VERTEX_MIN = 256.68496d;
    static final double X50_ARMC_MAX = 360.985931d;
    static final double X50_ARMC_MIN = 360.985828d;
    static final double X50_ASC_MAX = 814.745889d;
    static final double X50_ASC_MIN = 256.684961d;
    static final double X50_COASC1_MAX = 814.74585d;
    static final double X50_COASC1_MIN = 256.68496d;
    static final double X50_COASC2_MAX = 618.738596d;
    static final double X50_COASC2_MIN = 283.720808d;
    static final double X50_EQUASC_MAX = 393.49442d;
    static final double X50_EQUASC_MIN = 331.162937d;
    static final double X50_HOUSE10_MAX = 393.49442d;
    static final double X50_HOUSE10_MIN = 331.162936d;
    static final double X50_HOUSE11_MAX = 393.49442d;
    static final double X50_HOUSE11_MIN = 331.162936d;
    static final double X50_HOUSE12_MAX = 393.49442d;
    static final double X50_HOUSE12_MIN = 331.162937d;
    static final double X50_HOUSE1_MAX = 393.49442d;
    static final double X50_HOUSE1_MIN = 331.162937d;
    static final double X50_HOUSE2_MAX = 393.49442d;
    static final double X50_HOUSE2_MIN = 331.162937d;
    static final double X50_HOUSE3_MAX = 393.494421d;
    static final double X50_HOUSE3_MIN = 331.162936d;
    static final double X50_HOUSE4_MAX = 393.49442d;
    static final double X50_HOUSE4_MIN = 331.162936d;
    static final double X50_HOUSE5_MAX = 393.49442d;
    static final double X50_HOUSE5_MIN = 331.162936d;
    static final double X50_HOUSE6_MAX = 393.49442d;
    static final double X50_HOUSE6_MIN = 331.162937d;
    static final double X50_HOUSE7_MAX = 393.49442d;
    static final double X50_HOUSE7_MIN = 331.162937d;
    static final double X50_HOUSE8_MAX = 393.49442d;
    static final double X50_HOUSE8_MIN = 331.162937d;
    static final double X50_HOUSE9_MAX = 393.494421d;
    static final double X50_HOUSE9_MIN = 331.162936d;
    static final double X50_MC_MAX = 393.49442d;
    static final double X50_MC_MIN = 331.162936d;
    static final double X50_POLASC_MAX = 814.74585d;
    static final double X50_POLASC_MIN = 256.68496d;
    static final double X50_VERTEX_MAX = 618.738574d;
    static final double X50_VERTEX_MIN = 283.720804d;
    static final double X60_ARMC_MAX = 360.985931d;
    static final double X60_ARMC_MIN = 360.985828d;
    static final double X60_ASC_MAX = 1583.084164d;
    static final double X60_ASC_MIN = 220.207028d;
    static final double X60_COASC1_MAX = 1583.084212d;
    static final double X60_COASC1_MIN = 220.207025d;
    static final double X60_COASC2_MAX = 524.994891d;
    static final double X60_COASC2_MIN = 304.407972d;
    static final double X60_EQUASC_MAX = 393.49442d;
    static final double X60_EQUASC_MIN = 331.162937d;
    static final double X60_HOUSE10_MAX = 393.49442d;
    static final double X60_HOUSE10_MIN = 331.162936d;
    static final double X60_HOUSE11_MAX = 393.49442d;
    static final double X60_HOUSE11_MIN = 331.162936d;
    static final double X60_HOUSE12_MAX = 393.49442d;
    static final double X60_HOUSE12_MIN = 331.162937d;
    static final double X60_HOUSE1_MAX = 393.49442d;
    static final double X60_HOUSE1_MIN = 331.162937d;
    static final double X60_HOUSE2_MAX = 393.49442d;
    static final double X60_HOUSE2_MIN = 331.162937d;
    static final double X60_HOUSE3_MAX = 393.494421d;
    static final double X60_HOUSE3_MIN = 331.162936d;
    static final double X60_HOUSE4_MAX = 393.49442d;
    static final double X60_HOUSE4_MIN = 331.162936d;
    static final double X60_HOUSE5_MAX = 393.49442d;
    static final double X60_HOUSE5_MIN = 331.162936d;
    static final double X60_HOUSE6_MAX = 393.49442d;
    static final double X60_HOUSE6_MIN = 331.162937d;
    static final double X60_HOUSE7_MAX = 393.49442d;
    static final double X60_HOUSE7_MIN = 331.162937d;
    static final double X60_HOUSE8_MAX = 393.49442d;
    static final double X60_HOUSE8_MIN = 331.162937d;
    static final double X60_HOUSE9_MAX = 393.494421d;
    static final double X60_HOUSE9_MIN = 331.162936d;
    static final double X60_MC_MAX = 393.49442d;
    static final double X60_MC_MIN = 331.162936d;
    static final double X60_POLASC_MAX = 1583.084212d;
    static final double X60_POLASC_MIN = 220.207025d;
    static final double X60_VERTEX_MAX = 524.994878d;
    static final double X60_VERTEX_MIN = 304.407972d;
    static final double X66_ARMC_MAX = 360.985931d;
    static final double X66_ARMC_MIN = 360.985828d;
    static final double X66_ASC_MAX = 15382.763492d;
    static final double X66_ASC_MIN = 180.714519d;
    static final double X66_COASC1_MAX = 15382.960178d;
    static final double X66_COASC1_MIN = 180.714532d;
    static final double X66_COASC2_MAX = 487.697885d;
    static final double X66_COASC2_MIN = 313.998924d;
    static final double X66_EQUASC_MAX = 393.49442d;
    static final double X66_EQUASC_MIN = 331.162937d;
    static final double X66_HOUSE10_MAX = 393.49442d;
    static final double X66_HOUSE10_MIN = 331.162936d;
    static final double X66_HOUSE11_MAX = 393.49442d;
    static final double X66_HOUSE11_MIN = 331.162936d;
    static final double X66_HOUSE12_MAX = 393.49442d;
    static final double X66_HOUSE12_MIN = 331.162937d;
    static final double X66_HOUSE1_MAX = 393.49442d;
    static final double X66_HOUSE1_MIN = 331.162937d;
    static final double X66_HOUSE2_MAX = 393.49442d;
    static final double X66_HOUSE2_MIN = 331.162937d;
    static final double X66_HOUSE3_MAX = 393.494421d;
    static final double X66_HOUSE3_MIN = 331.162936d;
    static final double X66_HOUSE4_MAX = 393.49442d;
    static final double X66_HOUSE4_MIN = 331.162936d;
    static final double X66_HOUSE5_MAX = 393.49442d;
    static final double X66_HOUSE5_MIN = 331.162936d;
    static final double X66_HOUSE6_MAX = 393.49442d;
    static final double X66_HOUSE6_MIN = 331.162937d;
    static final double X66_HOUSE7_MAX = 393.49442d;
    static final double X66_HOUSE7_MIN = 331.162937d;
    static final double X66_HOUSE8_MAX = 393.49442d;
    static final double X66_HOUSE8_MIN = 331.162937d;
    static final double X66_HOUSE9_MAX = 393.494421d;
    static final double X66_HOUSE9_MIN = 331.162936d;
    static final double X66_MC_MAX = 393.49442d;
    static final double X66_MC_MIN = 331.162936d;
    static final double X66_POLASC_MAX = 15382.960178d;
    static final double X66_POLASC_MIN = 180.714532d;
    static final double X66_VERTEX_MAX = 487.697876d;
    static final double X66_VERTEX_MIN = 313.998925d;
    static final double X70_ARMC_MAX = 360.985931d;
    static final double X70_ARMC_MIN = 360.985828d;
    static final double X70_ASC_MAX = 179.610407d;
    static final double X70_ASC_MIN = -2066.7575d;
    static final double X70_COASC1_MAX = 1553150.33462d;
    static final double X70_COASC1_MIN = -2066.704127d;
    static final double X70_COASC2_MAX = 467.280896d;
    static final double X70_COASC2_MIN = 319.225068d;
    static final double X70_EQUASC_MAX = 393.49442d;
    static final double X70_EQUASC_MIN = 331.162937d;
    static final double X70_HOUSE10_MAX = 393.49442d;
    static final double X70_HOUSE10_MIN = 331.162936d;
    static final double X70_HOUSE11_MAX = 393.49442d;
    static final double X70_HOUSE11_MIN = 331.162936d;
    static final double X70_HOUSE12_MAX = 393.49442d;
    static final double X70_HOUSE12_MIN = 331.162937d;
    static final double X70_HOUSE1_MAX = 393.49442d;
    static final double X70_HOUSE1_MIN = 331.162937d;
    static final double X70_HOUSE2_MAX = 393.49442d;
    static final double X70_HOUSE2_MIN = 331.162937d;
    static final double X70_HOUSE3_MAX = 393.494421d;
    static final double X70_HOUSE3_MIN = 331.162936d;
    static final double X70_HOUSE4_MAX = 393.49442d;
    static final double X70_HOUSE4_MIN = 331.162936d;
    static final double X70_HOUSE5_MAX = 393.49442d;
    static final double X70_HOUSE5_MIN = 331.162936d;
    static final double X70_HOUSE6_MAX = 393.49442d;
    static final double X70_HOUSE6_MIN = 331.162937d;
    static final double X70_HOUSE7_MAX = 393.49442d;
    static final double X70_HOUSE7_MIN = 331.162937d;
    static final double X70_HOUSE8_MAX = 393.49442d;
    static final double X70_HOUSE8_MIN = 331.162937d;
    static final double X70_HOUSE9_MAX = 393.494421d;
    static final double X70_HOUSE9_MIN = 331.162936d;
    static final double X70_MC_MAX = 393.49442d;
    static final double X70_MC_MIN = 331.162936d;
    static final double X70_POLASC_MAX = 179.610407d;
    static final double X70_POLASC_MIN = -2066.757416d;
    static final double X70_VERTEX_MAX = 467.280888d;
    static final double X70_VERTEX_MIN = 319.22507d;
    static final double X80_ARMC_MAX = 360.985931d;
    static final double X80_ARMC_MIN = 360.985828d;
    static final double X80_ASC_MAX = 113.797795d;
    static final double X80_ASC_MIN = -269.99607d;
    static final double X80_COASC1_MAX = 1554930.566243d;
    static final double X80_COASC1_MIN = -269.995683d;
    static final double X80_COASC2_MAX = 426.089536d;
    static final double X80_COASC2_MIN = 328.169552d;
    static final double X80_EQUASC_MAX = 393.49442d;
    static final double X80_EQUASC_MIN = 331.162937d;
    static final double X80_HOUSE10_MAX = 393.49442d;
    static final double X80_HOUSE10_MIN = 331.162936d;
    static final double X80_HOUSE11_MAX = 393.49442d;
    static final double X80_HOUSE11_MIN = 331.162936d;
    static final double X80_HOUSE12_MAX = 393.49442d;
    static final double X80_HOUSE12_MIN = 331.162937d;
    static final double X80_HOUSE1_MAX = 393.49442d;
    static final double X80_HOUSE1_MIN = 331.162937d;
    static final double X80_HOUSE2_MAX = 393.49442d;
    static final double X80_HOUSE2_MIN = 331.162937d;
    static final double X80_HOUSE3_MAX = 393.494421d;
    static final double X80_HOUSE3_MIN = 331.162936d;
    static final double X80_HOUSE4_MAX = 393.49442d;
    static final double X80_HOUSE4_MIN = 331.162936d;
    static final double X80_HOUSE5_MAX = 393.49442d;
    static final double X80_HOUSE5_MIN = 331.162936d;
    static final double X80_HOUSE6_MAX = 393.49442d;
    static final double X80_HOUSE6_MIN = 331.162937d;
    static final double X80_HOUSE7_MAX = 393.49442d;
    static final double X80_HOUSE7_MIN = 331.162937d;
    static final double X80_HOUSE8_MAX = 393.49442d;
    static final double X80_HOUSE8_MIN = 331.162937d;
    static final double X80_HOUSE9_MAX = 393.494421d;
    static final double X80_HOUSE9_MIN = 331.162936d;
    static final double X80_MC_MAX = 393.49442d;
    static final double X80_MC_MIN = 331.162936d;
    static final double X80_POLASC_MAX = 113.797793d;
    static final double X80_POLASC_MIN = -269.996067d;
    static final double X80_VERTEX_MAX = 426.089531d;
    static final double X80_VERTEX_MIN = 328.16955d;
    static final double X85_ARMC_MAX = 360.985931d;
    static final double X85_ARMC_MIN = 360.985828d;
    static final double X85_ASC_MAX = 66.096028d;
    static final double X85_ASC_MIN = -99.54465d;
    static final double X85_COASC1_MAX = 1555100.603957d;
    static final double X85_COASC1_MIN = -99.544583d;
    static final double X85_COASC2_MAX = 409.019308d;
    static final double X85_COASC2_MIN = 330.413985d;
    static final double X85_EQUASC_MAX = 393.49442d;
    static final double X85_EQUASC_MIN = 331.162937d;
    static final double X85_HOUSE10_MAX = 393.49442d;
    static final double X85_HOUSE10_MIN = 331.162936d;
    static final double X85_HOUSE11_MAX = 393.49442d;
    static final double X85_HOUSE11_MIN = 331.162936d;
    static final double X85_HOUSE12_MAX = 393.49442d;
    static final double X85_HOUSE12_MIN = 331.162937d;
    static final double X85_HOUSE1_MAX = 393.49442d;
    static final double X85_HOUSE1_MIN = 331.162937d;
    static final double X85_HOUSE2_MAX = 393.49442d;
    static final double X85_HOUSE2_MIN = 331.162937d;
    static final double X85_HOUSE3_MAX = 393.494421d;
    static final double X85_HOUSE3_MIN = 331.162936d;
    static final double X85_HOUSE4_MAX = 393.49442d;
    static final double X85_HOUSE4_MIN = 331.162936d;
    static final double X85_HOUSE5_MAX = 393.49442d;
    static final double X85_HOUSE5_MIN = 331.162936d;
    static final double X85_HOUSE6_MAX = 393.49442d;
    static final double X85_HOUSE6_MIN = 331.162937d;
    static final double X85_HOUSE7_MAX = 393.49442d;
    static final double X85_HOUSE7_MIN = 331.162937d;
    static final double X85_HOUSE8_MAX = 393.49442d;
    static final double X85_HOUSE8_MIN = 331.162937d;
    static final double X85_HOUSE9_MAX = 393.494421d;
    static final double X85_HOUSE9_MIN = 331.162936d;
    static final double X85_MC_MAX = 393.49442d;
    static final double X85_MC_MIN = 331.162936d;
    static final double X85_POLASC_MAX = 66.096027d;
    static final double X85_POLASC_MIN = -99.544653d;
    static final double X85_VERTEX_MAX = 409.019306d;
    static final double X85_VERTEX_MIN = 330.413985d;
    static final double X88_ARMC_MAX = 360.985931d;
    static final double X88_ARMC_MIN = 360.985828d;
    static final double X88_ASC_MAX = 29.344231d;
    static final double X88_ASC_MIN = -34.489311d;
    static final double X88_COASC1_MAX = 1555165.554409d;
    static final double X88_COASC1_MIN = -34.489296d;
    static final double X88_COASC2_MAX = 399.547623d;
    static final double X88_COASC2_MIN = 331.043079d;
    static final double X88_EQUASC_MAX = 393.49442d;
    static final double X88_EQUASC_MIN = 331.162937d;
    static final double X88_HOUSE10_MAX = 393.49442d;
    static final double X88_HOUSE10_MIN = 331.162936d;
    static final double X88_HOUSE11_MAX = 393.49442d;
    static final double X88_HOUSE11_MIN = 331.162936d;
    static final double X88_HOUSE12_MAX = 393.49442d;
    static final double X88_HOUSE12_MIN = 331.162937d;
    static final double X88_HOUSE1_MAX = 393.49442d;
    static final double X88_HOUSE1_MIN = 331.162937d;
    static final double X88_HOUSE2_MAX = 393.49442d;
    static final double X88_HOUSE2_MIN = 331.162937d;
    static final double X88_HOUSE3_MAX = 393.494421d;
    static final double X88_HOUSE3_MIN = 331.162936d;
    static final double X88_HOUSE4_MAX = 393.49442d;
    static final double X88_HOUSE4_MIN = 331.162936d;
    static final double X88_HOUSE5_MAX = 393.49442d;
    static final double X88_HOUSE5_MIN = 331.162936d;
    static final double X88_HOUSE6_MAX = 393.49442d;
    static final double X88_HOUSE6_MIN = 331.162937d;
    static final double X88_HOUSE7_MAX = 393.49442d;
    static final double X88_HOUSE7_MIN = 331.162937d;
    static final double X88_HOUSE8_MAX = 393.49442d;
    static final double X88_HOUSE8_MIN = 331.162937d;
    static final double X88_HOUSE9_MAX = 393.494421d;
    static final double X88_HOUSE9_MIN = 331.162936d;
    static final double X88_MC_MAX = 393.49442d;
    static final double X88_MC_MIN = 331.162936d;
    static final double X88_POLASC_MAX = 29.34423d;
    static final double X88_POLASC_MIN = -34.489313d;
    static final double X88_VERTEX_MAX = 399.547621d;
    static final double X88_VERTEX_MIN = 331.043081d;
    static final double X90_ARMC_MAX = 360.985931d;
    static final double X90_ARMC_MIN = 360.985828d;
    static final double X90_ASC_MAX = 0.0d;
    static final double X90_ASC_MIN = -0.0d;
    static final double X90_COASC1_MAX = 1555200.0d;
    static final double X90_COASC1_MIN = -0.0d;
    static final double X90_COASC2_MAX = 393.49442d;
    static final double X90_COASC2_MIN = 331.162937d;
    static final double X90_EQUASC_MAX = 393.49442d;
    static final double X90_EQUASC_MIN = 331.162937d;
    static final double X90_HOUSE10_MAX = 393.49442d;
    static final double X90_HOUSE10_MIN = 331.162936d;
    static final double X90_HOUSE11_MAX = 393.49442d;
    static final double X90_HOUSE11_MIN = 331.162936d;
    static final double X90_HOUSE12_MAX = 393.49442d;
    static final double X90_HOUSE12_MIN = 331.162937d;
    static final double X90_HOUSE1_MAX = 393.49442d;
    static final double X90_HOUSE1_MIN = 331.162937d;
    static final double X90_HOUSE2_MAX = 393.49442d;
    static final double X90_HOUSE2_MIN = 331.162937d;
    static final double X90_HOUSE3_MAX = 393.494421d;
    static final double X90_HOUSE3_MIN = 331.162936d;
    static final double X90_HOUSE4_MAX = 393.49442d;
    static final double X90_HOUSE4_MIN = 331.162936d;
    static final double X90_HOUSE5_MAX = 393.49442d;
    static final double X90_HOUSE5_MIN = 331.162936d;
    static final double X90_HOUSE6_MAX = 393.49442d;
    static final double X90_HOUSE6_MIN = 331.162937d;
    static final double X90_HOUSE7_MAX = 393.49442d;
    static final double X90_HOUSE7_MIN = 331.162937d;
    static final double X90_HOUSE8_MAX = 393.49442d;
    static final double X90_HOUSE8_MIN = 331.162937d;
    static final double X90_HOUSE9_MAX = 393.494421d;
    static final double X90_HOUSE9_MIN = 331.162936d;
    static final double X90_MC_MAX = 393.49442d;
    static final double X90_MC_MIN = 331.162936d;
    static final double X90_POLASC_MAX = 0.0d;
    static final double X90_POLASC_MIN = -0.0d;
    static final double X90_VERTEX_MAX = 393.49442d;
    static final double X90_VERTEX_MIN = 331.162937d;
    static final double[] maxLonB10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 412.380174d, 398.606221d, 393.49442d, 398.606213d, 412.380154d, 426.089536d, 412.380174d, 398.606221d, 393.49442d, 398.606213d, 412.380154d};
    static final double[] maxLonB20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 436.546667d, 404.457847d, 393.49442d, 404.457857d, 436.546696d, 467.280896d, 436.546667d, 404.457847d, 393.49442d, 404.457857d, 436.546696d};
    static final double[] maxLonB30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 471.067521d, 412.373722d, 393.49442d, 412.373726d, 471.067526d, 524.994891d, 471.067521d, 412.373722d, 393.49442d, 412.373726d, 471.067526d};
    static final double[] maxLonB40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 528.455287d, 427.334781d, 393.49442d, 427.334772d, 528.455277d, 618.738596d, 528.455287d, 427.334781d, 393.49442d, 427.334772d, 528.455277d};
    static final double[] maxLonB50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 651.124056d, 474.236268d, 393.49442d, 474.236306d, 651.12408d, 814.745889d, 651.124056d, 474.236268d, 393.49442d, 474.236306d, 651.12408d};
    static final double[] maxLonB60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1139.338559d, 694.410604d, 393.49442d, 694.410977d, 1139.339601d, 1583.084164d, 1139.338559d, 694.410604d, 393.49442d, 694.410977d, 1139.339601d};
    static final double[] maxLonB66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 9947.774284d, 4726.637257d, 393.49442d, 4726.655116d, 9947.874571d, 15382.763492d, 9947.774284d, 4726.637257d, 393.49442d, 4726.655116d, 9947.874571d};
    static final double[] maxLonB70 = {1553150.32968d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 1555199.999988d, 1555199.999989d, 393.49442d, 1555199.999988d, 1555199.999989d, 1555199.608408d, 1555199.999988d, 1555199.999989d, 393.49442d, 1555199.999988d, 1555199.999989d};
    static final double[] maxLonB80 = {1554930.566184d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.999998d, 277883.286595d, 393.49442d, 277883.18118d, 1555200.0d, 1555199.876097d, 1555199.999998d, 277883.286595d, 393.49442d, 277883.18118d, 1555200.0d};
    static final double[] maxLonB85 = {1555100.603952d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 516765.810197d, 274378.178787d, 393.49442d, 274378.070732d, 516765.880903d, 1555199.941344d, 516765.810197d, 274378.178787d, 393.49442d, 274378.070732d, 516765.880903d};
    static final double[] maxLonB88 = {1555165.554408d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 512298.259258d, 271066.008245d, 393.49442d, 271066.072583d, 512298.186003d, 1555199.976849d, 512298.259258d, 271066.008245d, 393.49442d, 271066.072583d, 512298.186003d};
    static final double[] maxLonB90 = {1555200.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 1555199.999958d, 1555199.999848d, 393.49442d, 1555199.999841d, 1555199.999958d, 1555200.0d, 1555199.999958d, 1555199.999848d, 393.49442d, 1555199.999841d, 1555199.999958d};
    static final double[] maxLonC10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 421.297279d, 408.957435d, 393.49442d, 408.957438d, 421.297286d, 426.089536d, 421.297279d, 408.957435d, 393.49442d, 408.957438d, 421.297286d};
    static final double[] maxLonC20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 454.665487d, 425.537755d, 393.49442d, 425.537741d, 454.665521d, 467.280896d, 454.665487d, 425.537755d, 393.49442d, 425.537741d, 454.665521d};
    static final double[] maxLonC30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 497.094707d, 443.133258d, 393.49442d, 443.133242d, 497.094671d, 524.994891d, 497.094707d, 443.133258d, 393.49442d, 443.133242d, 497.094671d};
    static final double[] maxLonC40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 554.777085d, 461.439872d, 393.49442d, 461.43987d, 554.777147d, 618.738596d, 554.777085d, 461.439872d, 393.49442d, 461.43987d, 554.777147d};
    static final double[] maxLonC50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 639.467438d, 479.806992d, 393.49442d, 479.80696d, 639.467588d, 814.745889d, 639.467438d, 479.806992d, 393.49442d, 479.80696d, 639.467588d};
    static final double[] maxLonC60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 774.491318d, 497.094702d, 393.49442d, 497.094653d, 774.491511d, 1583.084164d, 774.491318d, 497.094702d, 393.49442d, 497.094653d, 774.491511d};
    static final double[] maxLonC66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 896.74045d, 506.274478d, 393.49442d, 506.274507d, 896.74019d, 15382.763492d, 896.74045d, 506.274478d, 393.49442d, 506.274507d, 896.74019d};
    static final double[] maxLonC70 = {1553150.32968d, 777947.502418d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 778164.963032d, 777998.63387d, 777947.502418d, 777998.635025d, 778164.968826d, 1555199.608408d, 778164.963032d, 777998.63387d, 777947.502418d, 777998.635025d, 778164.968826d};
    static final double[] maxLonC80 = {1554930.566184d, 777981.666378d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 778780.060688d, 778092.784956d, 777981.666378d, 778092.785427d, 778780.06859d, 1555199.876097d, 778780.060688d, 778092.784956d, 777981.666378d, 778092.785427d, 778780.06859d};
    static final double[] maxLonC85 = {1555100.603952d, 777990.526167d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 779064.965957d, 778116.881242d, 777990.526167d, 778116.882169d, 779064.982659d, 1555199.941344d, 779064.965957d, 778116.881242d, 777990.526167d, 778116.882169d, 779064.982659d};
    static final double[] maxLonC88 = {1555165.554408d, 777993.023523d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 779163.542082d, 778123.708457d, 777993.023575d, 778123.708399d, 779163.540891d, 1555199.976849d, 779163.542082d, 778123.708457d, 777993.023575d, 778123.708399d, 779163.540891d};
    static final double[] maxLonC90 = {1555200.0d, 393.494367d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 779183.084379d, 778124.994889d, 777993.49442d, 778124.994882d, 779183.083669d, 1555200.0d, 779183.084379d, 778124.994889d, 777993.49442d, 778124.994882d, 779183.083669d};
    static final double[] maxLonE10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d};
    static final double[] maxLonE20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d};
    static final double[] maxLonE30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d};
    static final double[] maxLonE40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d};
    static final double[] maxLonE50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d};
    static final double[] maxLonE60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d};
    static final double[] maxLonE66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d};
    static final double[] maxLonE70 = {1553150.32968d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d};
    static final double[] maxLonE80 = {1554930.566184d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d};
    static final double[] maxLonE85 = {1555100.603952d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d};
    static final double[] maxLonE88 = {1555165.554408d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d};
    static final double[] maxLonE90 = {1555200.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d};
    static final double[] maxLonH10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 1555199.999999d, 1350.648027d, 521.49115d, 393.49442d, 521.491146d, 1350.649613d, 1555199.999999d, 1350.648027d, 521.49115d, 393.49442d, 521.491146d, 1350.649613d};
    static final double[] maxLonH20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 1555199.99999d, 1002.590468d, 511.639579d, 393.49442d, 511.63953d, 1002.589923d, 1555199.99999d, 1002.590468d, 511.639579d, 393.49442d, 511.63953d, 1002.589923d};
    static final double[] maxLonH30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 1583.084212d, 774.491349d, 497.0947d, 393.49442d, 497.094652d, 774.491553d, 1583.084212d, 774.491349d, 497.0947d, 393.49442d, 497.094652d, 774.491553d};
    static final double[] maxLonH40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 814.74585d, 639.467472d, 479.806987d, 393.49442d, 479.806955d, 639.467581d, 814.74585d, 639.467472d, 479.806987d, 393.49442d, 479.806955d, 639.467581d};
    static final double[] maxLonH50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 618.738574d, 554.777091d, 461.439869d, 393.49442d, 461.439867d, 554.777132d, 618.738574d, 554.777091d, 461.439869d, 393.49442d, 461.439867d, 554.777132d};
    static final double[] maxLonH60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 524.994878d, 497.094708d, 443.133258d, 393.49442d, 443.133249d, 497.094683d, 524.994878d, 497.094708d, 443.133258d, 393.49442d, 443.133249d, 497.094683d};
    static final double[] maxLonH66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 487.697876d, 470.284305d, 432.465219d, 393.49442d, 432.465199d, 470.284291d, 487.697876d, 470.284305d, 432.465219d, 393.49442d, 432.465199d, 470.284291d};
    static final double[] maxLonH70 = {179.610407d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 467.280888d, 454.665495d, 425.537759d, 393.49442d, 425.537745d, 454.665522d, 467.280888d, 454.665495d, 425.537759d, 393.49442d, 425.537745d, 454.665522d};
    static final double[] maxLonH80 = {113.797795d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 426.089531d, 421.297279d, 408.957435d, 393.49442d, 408.957437d, 421.297286d, 426.089531d, 421.297279d, 408.957435d, 393.49442d, 408.957437d, 421.297286d};
    static final double[] maxLonH85 = {66.096028d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 409.019306d, 406.855463d, 401.084523d, 393.49442d, 401.084516d, 406.855456d, 409.019306d, 406.855463d, 401.084523d, 393.49442d, 401.084516d, 406.855456d};
    static final double[] maxLonH88 = {29.344231d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 399.547621d, 398.725059d, 396.496538d, 393.49442d, 396.496529d, 398.72505d, 399.547621d, 398.725059d, 396.496538d, 393.49442d, 396.496529d, 398.72505d};
    static final double[] maxLonH90 = {0.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonK10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 421.067784d, 407.90358d, 393.49442d, 407.903569d, 421.06777d, 426.089536d, 421.067784d, 407.90358d, 393.49442d, 407.903569d, 421.06777d};
    static final double[] maxLonK20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 456.609208d, 427.493924d, 393.49442d, 427.493934d, 456.60921d, 467.280896d, 456.609208d, 427.493924d, 393.49442d, 427.493934d, 456.60921d};
    static final double[] maxLonK30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 506.955469d, 456.419314d, 393.49442d, 456.419331d, 506.955512d, 524.994891d, 506.955469d, 456.419314d, 393.49442d, 456.419331d, 506.955512d};
    static final double[] maxLonK40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 589.267962d, 505.077304d, 393.49442d, 505.07724d, 589.267858d, 618.738596d, 589.267962d, 505.077304d, 393.49442d, 505.07724d, 589.267858d};
    static final double[] maxLonK50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 762.191331d, 609.302286d, 393.49442d, 609.302287d, 762.191568d, 814.745889d, 762.191331d, 609.302286d, 393.49442d, 609.302287d, 762.191568d};
    static final double[] maxLonK60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1443.125795d, 1027.363599d, 393.49442d, 1027.36296d, 1443.127407d, 1583.084164d, 1443.125795d, 1027.363599d, 393.49442d, 1027.36296d, 1443.127407d};
    static final double[] maxLonK66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 13708.40777d, 8684.165243d, 393.49442d, 8684.36616d, 13708.365617d, 15382.763492d, 13708.40777d, 8684.165243d, 393.49442d, 8684.36616d, 13708.365617d};
    static final double[] maxLonK70 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonK80 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonK85 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonK88 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonK90 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonO10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 394.447336d, 372.436247d, 393.49442d, 372.436247d, 394.447336d, 426.089536d, 394.447336d, 372.436247d, 393.49442d, 372.436247d, 394.447336d};
    static final double[] maxLonO20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 421.908242d, 376.535598d, 393.49442d, 376.535598d, 421.908242d, 467.280896d, 421.908242d, 376.535598d, 393.49442d, 376.535598d, 421.908242d};
    static final double[] maxLonO30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 460.384239d, 395.773587d, 393.49442d, 395.773587d, 460.384239d, 524.994891d, 460.384239d, 395.773587d, 393.49442d, 395.773587d, 460.384239d};
    static final double[] maxLonO40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 522.880043d, 427.021489d, 393.49442d, 427.021489d, 522.880043d, 618.738596d, 522.880043d, 427.021489d, 393.49442d, 427.021489d, 522.880043d};
    static final double[] maxLonO50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 653.551572d, 492.357254d, 393.49442d, 492.357254d, 653.551572d, 814.745889d, 653.551572d, 492.357254d, 393.49442d, 492.357254d, 653.551572d};
    static final double[] maxLonO60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1165.777088d, 748.470012d, 393.49442d, 748.470012d, 1165.777088d, 1583.084164d, 1165.777088d, 748.470012d, 393.49442d, 748.470012d, 1165.777088d};
    static final double[] maxLonO66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 10365.563314d, 5348.363137d, 393.49442d, 5348.363137d, 10365.563314d, 15382.763492d, 10365.563314d, 5348.363137d, 393.49442d, 5348.363137d, 10365.563314d};
    static final double[] maxLonO70 = {1553150.32968d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 1555199.999993d, 1555199.999991d, 393.49442d, 1555199.999991d, 1555199.999993d, 1555199.608408d, 1555199.999993d, 1555199.999991d, 393.49442d, 1555199.999991d, 1555199.999993d};
    static final double[] maxLonO80 = {1554930.566184d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.999998d, 259454.485276d, 393.49442d, 259454.485276d, 1555199.999998d, 1555199.876097d, 1555199.999998d, 259454.485276d, 393.49442d, 259454.485276d, 1555199.999998d};
    static final double[] maxLonO85 = {1555100.603952d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 518530.214171d, 259460.370169d, 393.49442d, 259460.370169d, 518530.214171d, 1555199.941344d, 518530.214171d, 259460.370169d, 393.49442d, 259460.370169d, 518530.214171d};
    static final double[] maxLonO88 = {1555165.554408d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 518531.023142d, 259462.023358d, 393.49442d, 259462.023358d, 518531.023142d, 1555199.976849d, 518531.023142d, 259462.023358d, 393.49442d, 259462.023358d, 518531.023142d};
    static final double[] maxLonO90 = {1555200.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 518531.164807d, 259462.329614d, 393.49442d, 259462.329614d, 518531.164807d, 1555200.0d, 518531.164807d, 259462.329614d, 393.49442d, 259462.329614d, 518531.164807d};
    static final double[] maxLonP10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 414.640616d, 403.790856d, 393.49442d, 403.790854d, 414.640615d, 426.089536d, 414.640616d, 403.790856d, 393.49442d, 403.790854d, 414.640615d};
    static final double[] maxLonP20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 439.791586d, 415.356874d, 393.49442d, 415.356872d, 439.791585d, 467.280896d, 439.791586d, 415.356874d, 393.49442d, 415.356872d, 439.791585d};
    static final double[] maxLonP30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 472.37452d, 429.341508d, 393.49442d, 429.341506d, 472.374519d, 524.994891d, 472.37452d, 429.341508d, 393.49442d, 429.341506d, 472.374519d};
    static final double[] maxLonP40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 519.596156d, 447.837695d, 393.49442d, 447.837693d, 519.596154d, 618.738596d, 519.596156d, 447.837695d, 393.49442d, 447.837693d, 519.596154d};
    static final double[] maxLonP50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 600.470197d, 475.43277d, 393.49442d, 475.432767d, 600.470193d, 814.745889d, 600.470197d, 475.43277d, 393.49442d, 475.432767d, 600.470193d};
    static final double[] maxLonP60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 788.501238d, 524.994905d, 393.49442d, 524.994903d, 788.501228d, 1583.084164d, 788.501238d, 524.994905d, 393.49442d, 524.994903d, 788.501228d};
    static final double[] maxLonP66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 1123.046159d, 582.790093d, 393.49442d, 582.790092d, 1123.046149d, 15382.763492d, 1123.046159d, 582.790093d, 393.49442d, 582.790092d, 1123.046149d};
    static final double[] maxLonP70 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonP80 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonP85 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonP88 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonP90 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] maxLonR10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 421.412786d, 409.143819d, 393.49442d, 409.143818d, 421.412785d, 426.089536d, 421.412786d, 409.143819d, 393.49442d, 409.143818d, 421.412785d};
    static final double[] maxLonR20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 455.829381d, 427.225136d, 393.49442d, 427.225134d, 455.82938d, 467.280896d, 455.829381d, 427.225136d, 393.49442d, 427.225134d, 455.82938d};
    static final double[] maxLonR30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 502.496861d, 449.831172d, 393.49442d, 449.831169d, 502.496859d, 524.994891d, 502.496861d, 449.831172d, 393.49442d, 449.831169d, 502.496859d};
    static final double[] maxLonR40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 574.667486d, 481.055618d, 393.49442d, 481.055615d, 574.667482d, 618.738596d, 574.667486d, 481.055618d, 393.49442d, 481.055615d, 574.667482d};
    static final double[] maxLonR50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 712.548553d, 530.685789d, 393.49442d, 530.685783d, 712.548542d, 814.745889d, 712.548553d, 530.685789d, 393.49442d, 530.685783d, 712.548542d};
    static final double[] maxLonR60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1126.731409d, 630.316454d, 393.49442d, 630.316442d, 1126.731333d, 1583.084164d, 1126.731409d, 630.316454d, 393.49442d, 630.316442d, 1126.731333d};
    static final double[] maxLonR66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 2520.434718d, 767.365603d, 393.49442d, 767.365572d, 2520.433379d, 15382.763492d, 2520.434718d, 767.365603d, 393.49442d, 767.365572d, 2520.433379d};
    static final double[] maxLonR70 = {1553150.32968d, 777947.502418d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 1555199.999981d, 778156.120386d, 777947.502418d, 778156.125875d, 1555199.999973d, 1555199.608408d, 1555199.999981d, 778156.120386d, 777947.502418d, 778156.125875d, 1555199.999973d};
    static final double[] maxLonR80 = {1554930.566184d, 777981.666378d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.999998d, 1555199.999993d, 777981.666378d, 1555199.999999d, 1555199.999998d, 1555199.876097d, 1555199.999998d, 1555199.999993d, 777981.666378d, 1555199.999999d, 1555199.999998d};
    static final double[] maxLonR85 = {1555100.603952d, 777990.526167d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 1555199.999998d, 1555200.0d, 777990.526167d, 1555200.0d, 1555200.0d, 1555199.941344d, 1555199.999998d, 1555200.0d, 777990.526167d, 1555200.0d, 1555200.0d};
    static final double[] maxLonR88 = {1555165.554408d, 777993.023523d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 1555200.0d, 1555200.0d, 777993.023575d, 1555199.999999d, 1555200.0d, 1555199.976849d, 1555200.0d, 1555200.0d, 777993.023575d, 1555199.999999d, 1555200.0d};
    static final double[] maxLonR90 = {1555200.0d, 393.494367d, 360.985929d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 1555200.0d, 1555200.0d, 777993.49442d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 777993.49442d, 1555200.0d, 1555200.0d};
    static final double[] maxLonT10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 414.640616d, 403.790856d, 393.49442d, 403.790854d, 414.640615d, 426.089536d, 414.640616d, 403.790856d, 393.49442d, 403.790854d, 414.640615d};
    static final double[] maxLonT20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 439.791586d, 415.356874d, 393.49442d, 415.356872d, 439.791585d, 467.280896d, 439.791586d, 415.356874d, 393.49442d, 415.356872d, 439.791585d};
    static final double[] maxLonT30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 472.37452d, 429.341508d, 393.49442d, 429.341506d, 472.374518d, 524.994891d, 472.37452d, 429.341508d, 393.49442d, 429.341506d, 472.374518d};
    static final double[] maxLonT40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 519.596154d, 447.837694d, 393.49442d, 447.837692d, 519.596152d, 618.738596d, 519.596154d, 447.837694d, 393.49442d, 447.837692d, 519.596152d};
    static final double[] maxLonT50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 600.470187d, 475.432767d, 393.49442d, 475.432763d, 600.470182d, 814.745889d, 600.470187d, 475.432767d, 393.49442d, 475.432763d, 600.470182d};
    static final double[] maxLonT60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 788.501142d, 524.994891d, 393.49442d, 524.994886d, 788.501124d, 1583.084164d, 788.501142d, 524.994891d, 393.49442d, 524.994886d, 788.501124d};
    static final double[] maxLonT66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 1123.045295d, 582.790044d, 393.49442d, 582.790036d, 1123.045219d, 15382.763492d, 1123.045295d, 582.790044d, 393.49442d, 582.790036d, 1123.045219d};
    static final double[] maxLonT70 = {1553150.32968d, 777947.502418d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 779415.323087d, 778120.30174d, 777947.502418d, 778120.305084d, 779415.313613d, 1555199.608408d, 779415.323087d, 778120.30174d, 777947.502418d, 778120.305084d, 779415.313613d};
    static final double[] maxLonT80 = {1554930.566184d, 777981.666378d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.999999d, 779274.695159d, 777981.666378d, 779274.695436d, 1555200.0d, 1555199.876097d, 1555199.999999d, 779274.695159d, 777981.666378d, 779274.695436d, 1555200.0d};
    static final double[] maxLonT85 = {1555100.603952d, 777990.526167d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 1555199.999992d, 1555199.999999d, 777990.526167d, 1555199.999994d, 1555199.999999d, 1555199.941344d, 1555199.999992d, 1555199.999999d, 777990.526167d, 1555199.999994d, 1555199.999999d};
    static final double[] maxLonT88 = {1555165.554408d, 777993.023523d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 1555200.0d, 1555200.0d, 777993.023575d, 1555199.999996d, 1555200.0d, 1555199.976849d, 1555200.0d, 1555200.0d, 777993.023575d, 1555199.999996d, 1555200.0d};
    static final double[] maxLonT90 = {1555200.0d, T90_MC_MAX, T90_ARMC_MAX, 393.489619d, 393.489619d, 1555200.0d, 393.489619d, 0.0d, 1555200.0d, 1555200.0d, 1555200.0d, 777993.489627d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 777993.489627d, 1555200.0d, 1555200.0d};
    static final double[] maxLonV10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d, 426.089536d};
    static final double[] maxLonV20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d, 467.280896d};
    static final double[] maxLonV30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d, 524.994891d};
    static final double[] maxLonV40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d, 618.738596d};
    static final double[] maxLonV50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d, 814.745889d};
    static final double[] maxLonV60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d, 1583.084164d};
    static final double[] maxLonV66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d, 15382.763492d};
    static final double[] maxLonV70 = {1553150.32968d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d, 1555199.608408d};
    static final double[] maxLonV80 = {1554930.566184d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d, 1555199.876097d};
    static final double[] maxLonV85 = {1555100.603952d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d, 1555199.941344d};
    static final double[] maxLonV88 = {1555165.554408d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d, 1555199.976849d};
    static final double[] maxLonV90 = {1555200.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d, 1555200.0d};
    static final double[] maxLonX10 = {426.089536d, 393.49442d, 360.985931d, 1554930.566243d, 393.49442d, 426.089531d, 113.797795d, 426.089531d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX20 = {467.280896d, 393.49442d, 360.985931d, 1553150.33462d, 393.49442d, 467.280888d, 179.610407d, 467.280888d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX30 = {524.994891d, 393.49442d, 360.985931d, 1583.084212d, 393.49442d, 524.994878d, 1583.084164d, 524.994878d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX40 = {618.738596d, 393.49442d, 360.985931d, 814.74585d, 393.49442d, 618.738574d, 814.745889d, 618.738574d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX50 = {814.745889d, 393.49442d, 360.985931d, 618.738574d, 393.49442d, 814.74585d, 618.738596d, 814.74585d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX60 = {1583.084164d, 393.49442d, 360.985931d, 524.994878d, 393.49442d, 1583.084212d, 524.994891d, 1583.084212d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX66 = {15382.763492d, 393.49442d, 360.985931d, 487.697876d, 393.49442d, 15382.960178d, 487.697885d, 15382.960178d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX70 = {179.610407d, 393.49442d, 360.985931d, 467.280888d, 393.49442d, 1553150.33462d, 467.280896d, 179.610407d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX80 = {113.797795d, 393.49442d, 360.985931d, 426.089531d, 393.49442d, 1554930.566243d, 426.089536d, 113.797793d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX85 = {66.096028d, 393.49442d, 360.985931d, 409.019306d, 393.49442d, 1555100.603957d, 409.019308d, 66.096027d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX88 = {29.344231d, 393.49442d, 360.985931d, 399.547621d, 393.49442d, 1555165.554409d, 399.547623d, 29.34423d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] maxLonX90 = {0.0d, 393.49442d, 360.985931d, 393.49442d, 393.49442d, 1555200.0d, 393.49442d, 0.0d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.49442d, 393.494421d, 393.49442d, 393.49442d, 393.49442d};
    static final double[] minLonB10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 321.940442d, 324.158589d, 331.162936d, 324.158599d, 321.940442d, 328.169552d, 321.940442d, 324.158589d, 331.162936d, 324.158599d, 321.940442d};
    static final double[] minLonB20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 311.282344d, 317.405224d, 331.162936d, 317.40522d, 311.28233d, 319.225068d, 311.282344d, 317.405224d, 331.162936d, 317.40522d, 311.28233d};
    static final double[] minLonB30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 299.181971d, 310.557231d, 331.162936d, 310.557237d, 299.181964d, 304.407972d, 299.181971d, 310.557231d, 331.162936d, 310.557237d, 299.181964d};
    static final double[] minLonB40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 285.118865d, 303.213378d, 331.162936d, 303.213369d, 285.118858d, 283.720808d, 285.118865d, 303.213378d, 331.162936d, 303.213369d, 285.118858d};
    static final double[] minLonB50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 267.896031d, 294.82705d, 331.162936d, 294.827044d, 267.896035d, 256.684961d, 267.896031d, 294.82705d, 331.162936d, 294.827044d, 267.896035d};
    static final double[] minLonB60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 244.641869d, 284.51374d, 331.162936d, 284.51373d, 244.641873d, 220.207028d, 244.641869d, 284.51374d, 331.162936d, 284.51373d, 244.641873d};
    static final double[] minLonB66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 223.494434d, 276.758452d, 331.162936d, 276.758457d, 223.494433d, 180.714519d, 223.494434d, 276.758452d, 331.162936d, 276.758457d, 223.494433d};
    static final double[] minLonB70 = {-777600.39302d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 5.0E-6d, 1.3E-5d, 331.162936d, 9.0E-6d, 9.0E-6d, 0.389863d, 5.0E-6d, 1.3E-5d, 331.162936d, 9.0E-6d, 9.0E-6d};
    static final double[] minLonB80 = {-777600.124007d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 2.0E-6d, 150.875954d, 331.162936d, 150.875989d, 3.0E-6d, 0.12375d, 2.0E-6d, 150.875954d, 331.162936d, 150.875989d, 3.0E-6d};
    static final double[] minLonB85 = {-777600.058703d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 61.859575d, 198.76297d, 331.162936d, 198.762972d, 61.859581d, 0.058615d, 61.859575d, 198.76297d, 331.162936d, 198.762972d, 61.859581d};
    static final double[] minLonB88 = {-777600.02317d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 102.932766d, 213.853836d, 331.162936d, 213.853833d, 102.932767d, 0.023142d, 102.932766d, 213.853836d, 331.162936d, 213.853833d, 102.932767d};
    static final double[] minLonB90 = {-777600.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 6.0E-6d, 3.63E-4d, 331.162936d, 3.14E-4d, 5.0E-6d, 0.0d, 6.0E-6d, 3.63E-4d, 331.162936d, 3.14E-4d, 5.0E-6d};
    static final double[] minLonC10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 328.923046d, 330.419688d, 331.162936d, 330.419688d, 328.923043d, 328.169552d, 328.923046d, 330.419688d, 331.162936d, 330.419688d, 328.923043d};
    static final double[] minLonC20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 322.294813d, 328.260627d, 331.162936d, 328.260619d, 322.294824d, 319.225068d, 322.294813d, 328.260627d, 331.162936d, 328.260619d, 322.294824d};
    static final double[] minLonC30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 311.557166d, 324.895998d, 331.162936d, 324.895992d, 311.557165d, 304.407972d, 311.557166d, 324.895998d, 331.162936d, 324.895992d, 311.557165d};
    static final double[] minLonC40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 297.194471d, 320.669002d, 331.162936d, 320.668999d, 297.194477d, 283.720808d, 297.194471d, 320.669002d, 331.162936d, 320.668999d, 297.194477d};
    static final double[] minLonC50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 279.945752d, 316.04036d, 331.162936d, 316.04037d, 279.945757d, 256.684961d, 279.945752d, 316.04036d, 331.162936d, 316.04037d, 279.945757d};
    static final double[] minLonC60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 260.934858d, 311.557164d, 331.162936d, 311.557168d, 260.934857d, 220.207028d, 260.934858d, 311.557164d, 331.162936d, 311.557168d, 260.934857d};
    static final double[] minLonC66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 249.403075d, 309.178718d, 331.162936d, 309.178712d, 249.403078d, 180.714519d, 249.403075d, 309.178718d, 331.162936d, 309.178712d, 249.403078d};
    static final double[] minLonC70 = {-777600.39302d, -777252.648535d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 242.015106d, 307.797905d, 331.162936d, 307.797903d, 242.015105d, 0.389863d, 242.015106d, 307.797905d, 331.162936d, 307.797903d, 242.015105d};
    static final double[] minLonC80 = {-777600.124007d, -777218.490322d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 226.579046d, 305.289674d, 331.162936d, 305.289672d, 226.579047d, 0.12375d, 226.579046d, 305.289674d, 331.162936d, 305.289672d, 226.579047d};
    static final double[] minLonC85 = {-777600.058703d, -777209.599297d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 221.880225d, 304.630612d, 331.162936d, 304.63061d, 221.880221d, 0.058615d, 221.880225d, 304.630612d, 331.162936d, 304.63061d, 221.880221d};
    static final double[] minLonC88 = {-777600.02317d, -777207.078222d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 220.478743d, 304.443698d, 331.162936d, 304.443697d, 220.47874d, 0.023142d, 220.478743d, 304.443698d, 331.162936d, 304.443697d, 220.47874d};
    static final double[] minLonC90 = {-777600.0d, C90_MC_MIN, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 220.207028d, 304.407971d, 331.162936d, 304.407971d, 220.207025d, 0.0d, 220.207028d, 304.407971d, 331.162936d, 304.407971d, 220.207025d};
    static final double[] minLonE10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d};
    static final double[] minLonE20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d};
    static final double[] minLonE30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d};
    static final double[] minLonE40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d};
    static final double[] minLonE50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d};
    static final double[] minLonE60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d};
    static final double[] minLonE66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d};
    static final double[] minLonE70 = {-777600.39302d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d};
    static final double[] minLonE80 = {-777600.124007d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d};
    static final double[] minLonE85 = {-777600.058703d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d};
    static final double[] minLonE88 = {-777600.02317d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d};
    static final double[] minLonE90 = {-777600.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static final double[] minLonH10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 1.0E-6d, 226.579047d, 305.289672d, 331.162936d, 305.289673d, 226.579051d, 1.0E-6d, 226.579047d, 305.289672d, 331.162936d, 305.289673d, 226.579051d};
    static final double[] minLonH20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 4.0E-6d, 242.015108d, 307.79791d, 331.162936d, 307.797905d, 242.015106d, 4.0E-6d, 242.015108d, 307.79791d, 331.162936d, 307.797905d, 242.015106d};
    static final double[] minLonH30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 220.207025d, 260.934858d, 311.557167d, 331.162936d, 311.55717d, 260.934856d, 220.207025d, 260.934858d, 311.557167d, 331.162936d, 311.55717d, 260.934856d};
    static final double[] minLonH40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 256.68496d, 279.945753d, 316.040361d, 331.162936d, 316.040367d, 279.945759d, 256.68496d, 279.945753d, 316.040361d, 331.162936d, 316.040367d, 279.945759d};
    static final double[] minLonH50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 283.720804d, 297.194474d, 320.668998d, 331.162936d, 320.669d, 297.194478d, 283.720804d, 297.194474d, 320.668998d, 331.162936d, 320.669d, 297.194478d};
    static final double[] minLonH60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 304.407972d, 311.557167d, 324.895996d, 331.162936d, 324.895991d, 311.557166d, 304.407972d, 311.557167d, 324.895996d, 331.162936d, 324.895991d, 311.557166d};
    static final double[] minLonH66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 313.998925d, 318.470679d, 327.043088d, 331.162936d, 327.04308d, 318.470681d, 313.998925d, 318.470679d, 327.043088d, 331.162936d, 327.04308d, 318.470681d};
    static final double[] minLonH70 = {-2066.7575d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 319.22507d, 322.294812d, 328.260625d, 331.162936d, 328.260618d, 322.294821d, 319.22507d, 322.294812d, 328.260625d, 331.162936d, 328.260618d, 322.294821d};
    static final double[] minLonH80 = {-269.99607d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 328.16955d, 328.923047d, 330.419688d, 331.162936d, 330.419686d, 328.923043d, 328.16955d, 328.923047d, 330.419688d, 331.162936d, 330.419686d, 328.923043d};
    static final double[] minLonH85 = {-99.54465d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 330.413985d, 330.601551d, 330.976014d, 331.162936d, 330.976019d, 330.601543d, 330.413985d, 330.601551d, 330.976014d, 331.162936d, 330.976019d, 330.601543d};
    static final double[] minLonH88 = {-34.489311d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 331.043081d, 331.073058d, 331.132983d, 331.162936d, 331.132982d, 331.073048d, 331.043081d, 331.073058d, 331.132983d, 331.162936d, 331.132982d, 331.073048d};
    static final double[] minLonH90 = {-0.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonK10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 321.636178d, 321.779053d, 331.162936d, 321.779064d, 321.636172d, 328.169552d, 321.636178d, 321.779053d, 331.162936d, 321.779064d, 321.636172d};
    static final double[] minLonK20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 307.660606d, 310.048717d, 331.162936d, 310.048728d, 307.660615d, 319.225068d, 307.660606d, 310.048717d, 331.162936d, 310.048728d, 307.660615d};
    static final double[] minLonK30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 289.017738d, 294.890761d, 331.162936d, 294.890755d, 289.017735d, 304.407972d, 289.017738d, 294.890761d, 331.162936d, 294.890755d, 289.017735d};
    static final double[] minLonK40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 264.373474d, 273.462225d, 331.162936d, 273.462215d, 264.373489d, 283.720808d, 264.373474d, 273.462225d, 331.162936d, 273.462215d, 264.373489d};
    static final double[] minLonK50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 229.755579d, 237.534571d, 331.162936d, 237.53456d, 229.755592d, 256.684961d, 229.755579d, 237.534571d, 331.162936d, 237.53456d, 229.755592d};
    static final double[] minLonK60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 174.688246d, 159.418282d, 331.162936d, 159.418256d, 174.688239d, 220.207028d, 174.688246d, 159.418282d, 331.162936d, 159.418256d, 174.688239d};
    static final double[] minLonK66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 122.022521d, 66.282868d, 331.162936d, 66.28286d, 122.022516d, 180.714519d, 122.022521d, 66.282868d, 331.162936d, 66.28286d, 122.022516d};
    static final double[] minLonK70 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonK80 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonK85 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonK88 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonK90 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonO10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 347.876271d, 342.619247d, 331.162936d, 342.619247d, 347.876271d, 328.169552d, 347.876271d, 342.619247d, 331.162936d, 342.619247d, 347.876271d};
    static final double[] minLonO20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 336.56951d, 334.052883d, 331.162936d, 334.052883d, 336.56951d, 319.225068d, 336.56951d, 334.052883d, 331.162936d, 334.052883d, 336.56951d};
    static final double[] minLonO30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 320.170855d, 325.666898d, 331.162936d, 325.666898d, 320.170855d, 304.407972d, 320.170855d, 325.666898d, 331.162936d, 325.666898d, 320.170855d};
    static final double[] minLonO40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 302.706085d, 316.934513d, 331.162936d, 316.934513d, 302.706085d, 283.720808d, 302.706085d, 316.934513d, 331.162936d, 316.934513d, 302.706085d};
    static final double[] minLonO50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 283.310307d, 307.236624d, 331.162936d, 307.236624d, 283.310307d, 256.684961d, 283.310307d, 307.236624d, 331.162936d, 307.236624d, 283.310307d};
    static final double[] minLonO60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 260.167148d, 295.665045d, 331.162936d, 295.665045d, 260.167148d, 220.207028d, 260.167148d, 295.665045d, 331.162936d, 295.665045d, 260.167148d};
    static final double[] minLonO66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 242.387231d, 287.207091d, 331.162936d, 287.207091d, 242.387231d, 180.714519d, 242.387231d, 287.207091d, 331.162936d, 287.207091d, 242.387231d};
    static final double[] minLonO70 = {-777600.39302d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 1.5E-5d, 8.0E-6d, 331.162936d, 8.0E-6d, 1.5E-5d, 0.389863d, 1.5E-5d, 8.0E-6d, 331.162936d, 8.0E-6d, 1.5E-5d};
    static final double[] minLonO80 = {-777600.124007d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 1.0E-6d, 130.824313d, 331.162936d, 130.824313d, 1.0E-6d, 0.12375d, 1.0E-6d, 130.824313d, 331.162936d, 130.824313d, 1.0E-6d};
    static final double[] minLonO85 = {-777600.058703d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 44.048402d, 187.641431d, 331.162936d, 187.641431d, 44.048402d, 0.058615d, 44.048402d, 187.641431d, 331.162936d, 187.641431d, 44.048402d};
    static final double[] minLonO88 = {-777600.02317d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 87.418623d, 209.293425d, 331.162936d, 209.293425d, 87.418623d, 0.023142d, 87.418623d, 209.293425d, 331.162936d, 209.293425d, 87.418623d};
    static final double[] minLonO90 = {-777600.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 110.387645d, 220.775291d, 331.162936d, 220.775291d, 110.387645d, 0.0d, 110.387645d, 220.775291d, 331.162936d, 220.775291d, 110.387645d};
    static final double[] minLonP10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 329.812397d, 330.822162d, 331.162936d, 330.822162d, 329.812399d, 328.169552d, 329.812397d, 330.822162d, 331.162936d, 330.822162d, 329.812399d};
    static final double[] minLonP20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 325.532229d, 329.698504d, 331.162936d, 329.698504d, 325.53223d, 319.225068d, 325.532229d, 329.698504d, 331.162936d, 329.698504d, 325.53223d};
    static final double[] minLonP30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 317.60987d, 327.4221d, 331.162936d, 327.422098d, 317.609869d, 304.407972d, 317.60987d, 327.4221d, 331.162936d, 327.422098d, 317.609869d};
    static final double[] minLonP40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 304.779671d, 323.089002d, 331.162936d, 323.089002d, 304.779671d, 283.720808d, 304.779671d, 323.089002d, 331.162936d, 323.089002d, 304.779671d};
    static final double[] minLonP50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 285.008628d, 314.502994d, 331.162936d, 314.502994d, 285.008627d, 256.684961d, 285.008628d, 314.502994d, 331.162936d, 314.502994d, 285.008627d};
    static final double[] minLonP60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 253.591619d, 295.498614d, 331.162936d, 295.498614d, 253.591619d, 220.207028d, 253.591619d, 295.498614d, 331.162936d, 295.498614d, 253.591619d};
    static final double[] minLonP66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 214.759019d, 263.653341d, 331.162936d, 263.653337d, 214.759019d, 180.714519d, 214.759019d, 263.653341d, 331.162936d, 263.653337d, 214.759019d};
    static final double[] minLonP70 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonP80 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonP85 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonP88 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonP90 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    static final double[] minLonR10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 328.905911d, 330.402452d, 331.162936d, 330.402452d, 328.905912d, 328.169552d, 328.905911d, 330.402452d, 331.162936d, 330.402452d, 328.905912d};
    static final double[] minLonR20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 322.019861d, 327.978771d, 331.162936d, 327.978769d, 322.019861d, 319.225068d, 322.019861d, 327.978771d, 331.162936d, 327.978769d, 322.019861d};
    static final double[] minLonR30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 310.155614d, 323.414435d, 331.162936d, 323.414436d, 310.155614d, 304.407972d, 310.155614d, 323.414435d, 331.162936d, 323.414436d, 310.155614d};
    static final double[] minLonR40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 292.699861d, 315.718503d, 331.162936d, 315.718503d, 292.699861d, 283.720808d, 292.699861d, 315.718503d, 331.162936d, 315.718503d, 292.699861d};
    static final double[] minLonR50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 268.606055d, 302.989185d, 331.162936d, 302.989184d, 268.606056d, 256.684961d, 268.606055d, 302.989185d, 331.162936d, 302.989184d, 268.606056d};
    static final double[] minLonR60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 235.319792d, 281.57868d, 331.162936d, 281.578681d, 235.319792d, 220.207028d, 235.319792d, 281.57868d, 331.162936d, 281.578681d, 235.319792d};
    static final double[] minLonR66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 206.200958d, 261.742665d, 331.162936d, 261.742666d, 206.200959d, 180.714519d, 206.200958d, 261.742665d, 331.162936d, 261.742666d, 206.200959d};
    static final double[] minLonR70 = {-777600.39302d, -777252.648535d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 3.0E-6d, 243.832233d, 331.162936d, 243.832233d, 2.6E-5d, 0.389863d, 3.0E-6d, 243.832233d, 331.162936d, 243.832233d, 2.6E-5d};
    static final double[] minLonR80 = {-777600.124007d, -777218.490322d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 1.0E-6d, 9.0E-6d, 331.162936d, 8.0E-6d, 2.0E-6d, 0.12375d, 1.0E-6d, 9.0E-6d, 331.162936d, 8.0E-6d, 2.0E-6d};
    static final double[] minLonR85 = {-777600.058703d, -777209.599297d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 0.0d, 0.0d, 331.162936d, 0.0d, 0.0d, 0.058615d, 0.0d, 0.0d, 331.162936d, 0.0d, 0.0d};
    static final double[] minLonR88 = {-777600.02317d, -777207.078222d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 1.0E-6d, 1.0E-6d, 331.162936d, 1.0E-6d, 0.0d, 0.023142d, 1.0E-6d, 1.0E-6d, 331.162936d, 1.0E-6d, 0.0d};
    static final double[] minLonR90 = {-777600.0d, R90_MC_MIN, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 0.0d, 0.0d, 331.162936d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 331.162936d, 0.0d, 0.0d};
    static final double[] minLonT10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 329.816636d, 330.823923d, 331.162936d, 330.823922d, 329.816633d, 328.169552d, 329.816636d, 330.823923d, 331.162936d, 330.823922d, 329.816633d};
    static final double[] minLonT20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 325.599539d, 329.729746d, 331.162936d, 329.729745d, 325.599538d, 319.225068d, 325.599539d, 329.729746d, 331.162936d, 329.729745d, 325.599538d};
    static final double[] minLonT30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 317.941733d, 327.611509d, 331.162936d, 327.611506d, 317.941733d, 304.407972d, 317.941733d, 327.611509d, 331.162936d, 327.611506d, 317.941733d};
    static final double[] minLonT40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 305.768972d, 323.864511d, 331.162936d, 323.864511d, 305.768972d, 283.720808d, 305.768972d, 323.864511d, 331.162936d, 323.864511d, 305.768972d};
    static final double[] minLonT50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 287.28078d, 317.162818d, 331.162936d, 317.162818d, 287.280781d, 256.684961d, 287.28078d, 317.162818d, 331.162936d, 317.162818d, 287.280781d};
    static final double[] minLonT60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 259.397225d, 304.407971d, 331.162936d, 304.407972d, 259.397226d, 220.207028d, 259.397225d, 304.407971d, 331.162936d, 304.407972d, 259.397226d};
    static final double[] minLonT66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 235.495123d, 290.943764d, 331.162936d, 290.943764d, 235.495124d, 180.714519d, 235.495123d, 290.943764d, 331.162936d, 290.943764d, 235.495124d};
    static final double[] minLonT70 = {-777600.39302d, -777252.648535d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 213.749348d, 277.639305d, 331.162936d, 277.639303d, 213.749348d, 0.389863d, 213.749348d, 277.639305d, 331.162936d, 277.639303d, 213.749348d};
    static final double[] minLonT80 = {-777600.124007d, -777218.490322d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 3.0E-6d, 209.879732d, 331.162936d, 209.879728d, 2.0E-6d, 0.12375d, 3.0E-6d, 209.879732d, 331.162936d, 209.879728d, 2.0E-6d};
    static final double[] minLonT85 = {-777600.058703d, -777209.599297d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 0.0d, 0.0d, 331.162936d, 5.0E-6d, 1.0E-6d, 0.058615d, 0.0d, 0.0d, 331.162936d, 5.0E-6d, 1.0E-6d};
    static final double[] minLonT88 = {-777600.02317d, -777207.078222d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 0.0d, 0.0d, 331.162936d, 1.0E-6d, 1.0E-6d, 0.023142d, 0.0d, 0.0d, 331.162936d, 1.0E-6d, 1.0E-6d};
    static final double[] minLonT90 = {-777600.0d, T90_MC_MIN, T90_ARMC_MIN, 331.167116d, 331.167116d, -0.0d, 331.167116d, -0.0d, 0.0d, 0.0d, 0.0d, 331.167125d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 331.167125d, 0.0d, 0.0d};
    static final double[] minLonV10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d, 328.169552d};
    static final double[] minLonV20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d, 319.225068d};
    static final double[] minLonV30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d, 304.407972d};
    static final double[] minLonV40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d, 283.720808d};
    static final double[] minLonV50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d, 256.684961d};
    static final double[] minLonV60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d, 220.207028d};
    static final double[] minLonV66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d, 180.714519d};
    static final double[] minLonV70 = {-777600.39302d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d, 0.389863d};
    static final double[] minLonV80 = {-777600.124007d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d, 0.12375d};
    static final double[] minLonV85 = {-777600.058703d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d, 0.058615d};
    static final double[] minLonV88 = {-777600.02317d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d, 0.023142d};
    static final double[] minLonV90 = {-777600.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static final double[] minLonX10 = {328.169552d, 331.162936d, 360.985828d, -777600.124028d, 331.162937d, 328.16955d, -269.99607d, 328.16955d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX20 = {319.225068d, 331.162936d, 360.985828d, -777600.393091d, 331.162937d, 319.22507d, -2066.7575d, 319.22507d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX30 = {304.407972d, 331.162936d, 360.985828d, 220.207025d, 331.162937d, 304.407972d, 220.207028d, 304.407972d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX40 = {283.720808d, 331.162936d, 360.985828d, 256.68496d, 331.162937d, 283.720804d, 256.684961d, 283.720804d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX50 = {256.684961d, 331.162936d, 360.985828d, 283.720804d, 331.162937d, 256.68496d, 283.720808d, 256.68496d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX60 = {220.207028d, 331.162936d, 360.985828d, 304.407972d, 331.162937d, 220.207025d, 304.407972d, 220.207025d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX66 = {180.714519d, 331.162936d, 360.985828d, 313.998925d, 331.162937d, 180.714532d, 313.998924d, 180.714532d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX70 = {-2066.7575d, 331.162936d, 360.985828d, 319.22507d, 331.162937d, -2066.704127d, 319.225068d, -2066.757416d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX80 = {-269.99607d, 331.162936d, 360.985828d, 328.16955d, 331.162937d, -269.995683d, 328.169552d, -269.996067d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX85 = {-99.54465d, 331.162936d, 360.985828d, 330.413985d, 331.162937d, -99.544583d, 330.413985d, -99.544653d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX88 = {-34.489311d, 331.162936d, 360.985828d, 331.043081d, 331.162937d, -34.489296d, 331.043079d, -34.489313d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    static final double[] minLonX90 = {-0.0d, 331.162936d, 360.985828d, 331.162937d, 331.162937d, -0.0d, 331.162937d, -0.0d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d, 331.162937d, 331.162937d, 331.162936d, 331.162936d, 331.162936d, 331.162937d};
    private int flags = 0;
    private double geolat;
    private double geolon;
    private int house_object;
    private int hsys;
    private int idx = 0;
    private double max = 0.0d;
    double maxVal = 0.0d;
    private double min = 0.0d;
    double minVal = 0.0d;
    private double offset = 0.0d;
    private int tflags = 0;

    public TCHouses(SwissEph swissEph, int i, int i2, double d, double d2, int i3, double d3) {
        this.house_object = i;
        this.geolon = d;
        this.geolat = d2;
        this.tflags = i3;
        int i4 = -229384 & i3;
        if (i4 == 0) {
            int i5 = i3 & 131072;
            if (i5 == 131072 || i5 == 0) {
                int i6 = i & -1;
                if (i6 != -1 && i6 != -2 && i6 != -3 && i6 != -4 && i6 != -5 && i6 != -6 && i6 != -7 && i6 != -8 && i6 != -9 && i6 != -10 && i6 != -11 && i6 != -12 && i6 != 0 && i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
                    throw new IllegalArgumentException("Invalid or multiple objects given: " + i6);
                } else if (i2 == 80 || i2 == 75 || i2 == 79 || i2 == 82 || i2 == 67 || i2 == 69 || i2 == 86 || i2 == 88 || i2 == 72 || i2 == 84 || i2 == 66 || i2 == 77 || i2 == 85 || i2 == 87) {
                    this.hsys = i2;
                    this.sw = swissEph;
                    if (this.sw == null) {
                        this.sw = new SwissEph();
                    }
                    int i7 = -131073 & i3;
                    this.flags = i7;
                    this.rollover = true;
                    this.offset = checkOffset(d3);
                    this.max = getSpeed(false);
                    this.min = getSpeed(true);
                    if (Double.isInfinite(this.max) || Double.isInfinite(this.min)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append((32768 & i7) == 0 ? (i7 & 8) != 0 ? "Helio" : "Geo" : "Topo");
                        sb.append("centric transit calculations of ");
                        sb.append(getObjectname(i));
                        sb.append(" not possible: extreme speeds of the object not available.");
                        throw new IllegalArgumentException(sb.toString());
                    } else if (this.max == 0.0d && this.min == 0.0d) {
                        throw new IllegalArgumentException("Transit calculation of " + getObjectname(i) + " on latitude of " + d2 + " with house system '" + i2 + "' not possible.");
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported house system '" + i2 + "'.");
                }
            } else {
                throw new IllegalArgumentException("Invalid flag '" + i3 + "': specify exactly one of SEFLG_TRANSIT_LONGITUDE (" + 131072 + ").");
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

    public void setGeopos(double d, double d2) {
        this.geolon = d;
        this.geolat = d2;
    }

    public double getLongitude() {
        return this.geolon;
    }

    public double getLatitude() {
        return this.geolat;
    }

    public Object[] getObjectIdentifiers() {
        return new Integer[]{Integer.valueOf(this.house_object)};
    }

    /* access modifiers changed from: protected */
    public double calc(double d) {
        double[] dArr = new double[(this.hsys == 71 ? 37 : 13)];
        double[] dArr2 = new double[10];
        this.sw.swe_set_topo(this.geolon, this.geolat, 0.0d);
        int swe_houses = this.sw.swe_houses(d, this.flags, this.geolat, this.geolon, this.hsys, dArr, dArr2);
        if (swe_houses >= 0) {
            int i = this.house_object;
            if (i < 0) {
                return dArr[Math.abs(i)];
            }
            return dArr2[i];
        }
        throw new SwissephException(d, 0, "Calculation failed with return code " + swe_houses + ".");
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
    public double getDegreePrecision(double d) {
        return 6.944444444444444E-5d;
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

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x056c  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0578  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x059c  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x05a8  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x05cc  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x05dd  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x05e9  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x060d  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0625  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0631  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x063d  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0649  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0655  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0661  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0704  */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0707  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double getSpeed(boolean r11) {
        /*
            r10 = this;
            double r0 = r10.geolat
            int r0 = (int) r0
            int r0 = java.lang.Math.abs(r0)
            int r0 = r0 + 1
            int r0 = r0 / 10
            int r0 = r0 + 10
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            r3 = 66
            r4 = 88
            r5 = 4634344754052595712(0x4050800000000000, double:66.0)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x002f
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            r5 = 4633641066610819072(0x404e000000000000, double:60.0)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002f
            r0 = 66
            goto L_0x0065
        L_0x002f:
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            r5 = 4635681760191971328(0x4055400000000000, double:85.0)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x004d
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            r7 = 4635329916471083008(0x4054000000000000, double:80.0)
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x004d
            r0 = 88
            goto L_0x0065
        L_0x004d:
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            r7 = 4635892866424504320(0x4056000000000000, double:88.0)
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0065
            double r1 = r10.geolat
            double r1 = java.lang.Math.abs(r1)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0065
            r0 = 88
        L_0x0065:
            int r1 = r10.house_object
            if (r1 >= 0) goto L_0x006f
            int r1 = java.lang.Math.abs(r1)
            int r1 = r1 + 7
        L_0x006f:
            int r2 = r10.hsys
            if (r2 == r3) goto L_0x066d
            r3 = 67
            if (r2 == r3) goto L_0x02ef
            r3 = 69
            if (r2 == r3) goto L_0x0384
            r3 = 72
            if (r2 == r3) goto L_0x0543
            r3 = 75
            if (r2 == r3) goto L_0x0130
            r3 = 82
            if (r2 == r3) goto L_0x025a
            r3 = 84
            if (r2 == r3) goto L_0x05d8
            r3 = 86
            if (r2 == r3) goto L_0x0419
            if (r2 == r4) goto L_0x04ae
            r3 = 79
            if (r2 == r3) goto L_0x01c5
            r3 = 80
            if (r2 == r3) goto L_0x009b
            goto L_0x0702
        L_0x009b:
            switch(r0) {
                case 10: goto L_0x0124;
                case 20: goto L_0x0118;
                case 30: goto L_0x010c;
                case 40: goto L_0x0100;
                case 50: goto L_0x00f4;
                case 60: goto L_0x00e8;
                case 66: goto L_0x00dc;
                case 70: goto L_0x00d0;
                case 80: goto L_0x00c4;
                case 85: goto L_0x00b8;
                case 88: goto L_0x00ac;
                case 90: goto L_0x00a0;
                default: goto L_0x009e;
            }
        L_0x009e:
            goto L_0x0130
        L_0x00a0:
            if (r11 == 0) goto L_0x00a7
            double[] r11 = minLonP90
            r0 = r11[r1]
            goto L_0x00ab
        L_0x00a7:
            double[] r11 = maxLonP90
            r0 = r11[r1]
        L_0x00ab:
            return r0
        L_0x00ac:
            if (r11 == 0) goto L_0x00b3
            double[] r11 = minLonP88
            r0 = r11[r1]
            goto L_0x00b7
        L_0x00b3:
            double[] r11 = maxLonP88
            r0 = r11[r1]
        L_0x00b7:
            return r0
        L_0x00b8:
            if (r11 == 0) goto L_0x00bf
            double[] r11 = minLonP85
            r0 = r11[r1]
            goto L_0x00c3
        L_0x00bf:
            double[] r11 = maxLonP85
            r0 = r11[r1]
        L_0x00c3:
            return r0
        L_0x00c4:
            if (r11 == 0) goto L_0x00cb
            double[] r11 = minLonP80
            r0 = r11[r1]
            goto L_0x00cf
        L_0x00cb:
            double[] r11 = maxLonP80
            r0 = r11[r1]
        L_0x00cf:
            return r0
        L_0x00d0:
            if (r11 == 0) goto L_0x00d7
            double[] r11 = minLonP70
            r0 = r11[r1]
            goto L_0x00db
        L_0x00d7:
            double[] r11 = maxLonP70
            r0 = r11[r1]
        L_0x00db:
            return r0
        L_0x00dc:
            if (r11 == 0) goto L_0x00e3
            double[] r11 = minLonP66
            r0 = r11[r1]
            goto L_0x00e7
        L_0x00e3:
            double[] r11 = maxLonP66
            r0 = r11[r1]
        L_0x00e7:
            return r0
        L_0x00e8:
            if (r11 == 0) goto L_0x00ef
            double[] r11 = minLonP60
            r0 = r11[r1]
            goto L_0x00f3
        L_0x00ef:
            double[] r11 = maxLonP60
            r0 = r11[r1]
        L_0x00f3:
            return r0
        L_0x00f4:
            if (r11 == 0) goto L_0x00fb
            double[] r11 = minLonP50
            r0 = r11[r1]
            goto L_0x00ff
        L_0x00fb:
            double[] r11 = maxLonP50
            r0 = r11[r1]
        L_0x00ff:
            return r0
        L_0x0100:
            if (r11 == 0) goto L_0x0107
            double[] r11 = minLonP40
            r0 = r11[r1]
            goto L_0x010b
        L_0x0107:
            double[] r11 = maxLonP40
            r0 = r11[r1]
        L_0x010b:
            return r0
        L_0x010c:
            if (r11 == 0) goto L_0x0113
            double[] r11 = minLonP30
            r0 = r11[r1]
            goto L_0x0117
        L_0x0113:
            double[] r11 = maxLonP30
            r0 = r11[r1]
        L_0x0117:
            return r0
        L_0x0118:
            if (r11 == 0) goto L_0x011f
            double[] r11 = minLonP20
            r0 = r11[r1]
            goto L_0x0123
        L_0x011f:
            double[] r11 = maxLonP20
            r0 = r11[r1]
        L_0x0123:
            return r0
        L_0x0124:
            if (r11 == 0) goto L_0x012b
            double[] r11 = minLonP10
            r0 = r11[r1]
            goto L_0x012f
        L_0x012b:
            double[] r11 = maxLonP10
            r0 = r11[r1]
        L_0x012f:
            return r0
        L_0x0130:
            switch(r0) {
                case 10: goto L_0x01b9;
                case 20: goto L_0x01ad;
                case 30: goto L_0x01a1;
                case 40: goto L_0x0195;
                case 50: goto L_0x0189;
                case 60: goto L_0x017d;
                case 66: goto L_0x0171;
                case 70: goto L_0x0165;
                case 80: goto L_0x0159;
                case 85: goto L_0x014d;
                case 88: goto L_0x0141;
                case 90: goto L_0x0135;
                default: goto L_0x0133;
            }
        L_0x0133:
            goto L_0x01c5
        L_0x0135:
            if (r11 == 0) goto L_0x013c
            double[] r11 = minLonK90
            r0 = r11[r1]
            goto L_0x0140
        L_0x013c:
            double[] r11 = maxLonK90
            r0 = r11[r1]
        L_0x0140:
            return r0
        L_0x0141:
            if (r11 == 0) goto L_0x0148
            double[] r11 = minLonK88
            r0 = r11[r1]
            goto L_0x014c
        L_0x0148:
            double[] r11 = maxLonK88
            r0 = r11[r1]
        L_0x014c:
            return r0
        L_0x014d:
            if (r11 == 0) goto L_0x0154
            double[] r11 = minLonK85
            r0 = r11[r1]
            goto L_0x0158
        L_0x0154:
            double[] r11 = maxLonK85
            r0 = r11[r1]
        L_0x0158:
            return r0
        L_0x0159:
            if (r11 == 0) goto L_0x0160
            double[] r11 = minLonK80
            r0 = r11[r1]
            goto L_0x0164
        L_0x0160:
            double[] r11 = maxLonK80
            r0 = r11[r1]
        L_0x0164:
            return r0
        L_0x0165:
            if (r11 == 0) goto L_0x016c
            double[] r11 = minLonK70
            r0 = r11[r1]
            goto L_0x0170
        L_0x016c:
            double[] r11 = maxLonK70
            r0 = r11[r1]
        L_0x0170:
            return r0
        L_0x0171:
            if (r11 == 0) goto L_0x0178
            double[] r11 = minLonK66
            r0 = r11[r1]
            goto L_0x017c
        L_0x0178:
            double[] r11 = maxLonK66
            r0 = r11[r1]
        L_0x017c:
            return r0
        L_0x017d:
            if (r11 == 0) goto L_0x0184
            double[] r11 = minLonK60
            r0 = r11[r1]
            goto L_0x0188
        L_0x0184:
            double[] r11 = maxLonK60
            r0 = r11[r1]
        L_0x0188:
            return r0
        L_0x0189:
            if (r11 == 0) goto L_0x0190
            double[] r11 = minLonK50
            r0 = r11[r1]
            goto L_0x0194
        L_0x0190:
            double[] r11 = maxLonK50
            r0 = r11[r1]
        L_0x0194:
            return r0
        L_0x0195:
            if (r11 == 0) goto L_0x019c
            double[] r11 = minLonK40
            r0 = r11[r1]
            goto L_0x01a0
        L_0x019c:
            double[] r11 = maxLonK40
            r0 = r11[r1]
        L_0x01a0:
            return r0
        L_0x01a1:
            if (r11 == 0) goto L_0x01a8
            double[] r11 = minLonK30
            r0 = r11[r1]
            goto L_0x01ac
        L_0x01a8:
            double[] r11 = maxLonK30
            r0 = r11[r1]
        L_0x01ac:
            return r0
        L_0x01ad:
            if (r11 == 0) goto L_0x01b4
            double[] r11 = minLonK20
            r0 = r11[r1]
            goto L_0x01b8
        L_0x01b4:
            double[] r11 = maxLonK20
            r0 = r11[r1]
        L_0x01b8:
            return r0
        L_0x01b9:
            if (r11 == 0) goto L_0x01c0
            double[] r11 = minLonK10
            r0 = r11[r1]
            goto L_0x01c4
        L_0x01c0:
            double[] r11 = maxLonK10
            r0 = r11[r1]
        L_0x01c4:
            return r0
        L_0x01c5:
            switch(r0) {
                case 10: goto L_0x024e;
                case 20: goto L_0x0242;
                case 30: goto L_0x0236;
                case 40: goto L_0x022a;
                case 50: goto L_0x021e;
                case 60: goto L_0x0212;
                case 66: goto L_0x0206;
                case 70: goto L_0x01fa;
                case 80: goto L_0x01ee;
                case 85: goto L_0x01e2;
                case 88: goto L_0x01d6;
                case 90: goto L_0x01ca;
                default: goto L_0x01c8;
            }
        L_0x01c8:
            goto L_0x025a
        L_0x01ca:
            if (r11 == 0) goto L_0x01d1
            double[] r11 = minLonO90
            r0 = r11[r1]
            goto L_0x01d5
        L_0x01d1:
            double[] r11 = maxLonO90
            r0 = r11[r1]
        L_0x01d5:
            return r0
        L_0x01d6:
            if (r11 == 0) goto L_0x01dd
            double[] r11 = minLonO88
            r0 = r11[r1]
            goto L_0x01e1
        L_0x01dd:
            double[] r11 = maxLonO88
            r0 = r11[r1]
        L_0x01e1:
            return r0
        L_0x01e2:
            if (r11 == 0) goto L_0x01e9
            double[] r11 = minLonO85
            r0 = r11[r1]
            goto L_0x01ed
        L_0x01e9:
            double[] r11 = maxLonO85
            r0 = r11[r1]
        L_0x01ed:
            return r0
        L_0x01ee:
            if (r11 == 0) goto L_0x01f5
            double[] r11 = minLonO80
            r0 = r11[r1]
            goto L_0x01f9
        L_0x01f5:
            double[] r11 = maxLonO80
            r0 = r11[r1]
        L_0x01f9:
            return r0
        L_0x01fa:
            if (r11 == 0) goto L_0x0201
            double[] r11 = minLonO70
            r0 = r11[r1]
            goto L_0x0205
        L_0x0201:
            double[] r11 = maxLonO70
            r0 = r11[r1]
        L_0x0205:
            return r0
        L_0x0206:
            if (r11 == 0) goto L_0x020d
            double[] r11 = minLonO66
            r0 = r11[r1]
            goto L_0x0211
        L_0x020d:
            double[] r11 = maxLonO66
            r0 = r11[r1]
        L_0x0211:
            return r0
        L_0x0212:
            if (r11 == 0) goto L_0x0219
            double[] r11 = minLonO60
            r0 = r11[r1]
            goto L_0x021d
        L_0x0219:
            double[] r11 = maxLonO60
            r0 = r11[r1]
        L_0x021d:
            return r0
        L_0x021e:
            if (r11 == 0) goto L_0x0225
            double[] r11 = minLonO50
            r0 = r11[r1]
            goto L_0x0229
        L_0x0225:
            double[] r11 = maxLonO50
            r0 = r11[r1]
        L_0x0229:
            return r0
        L_0x022a:
            if (r11 == 0) goto L_0x0231
            double[] r11 = minLonO40
            r0 = r11[r1]
            goto L_0x0235
        L_0x0231:
            double[] r11 = maxLonO40
            r0 = r11[r1]
        L_0x0235:
            return r0
        L_0x0236:
            if (r11 == 0) goto L_0x023d
            double[] r11 = minLonO30
            r0 = r11[r1]
            goto L_0x0241
        L_0x023d:
            double[] r11 = maxLonO30
            r0 = r11[r1]
        L_0x0241:
            return r0
        L_0x0242:
            if (r11 == 0) goto L_0x0249
            double[] r11 = minLonO20
            r0 = r11[r1]
            goto L_0x024d
        L_0x0249:
            double[] r11 = maxLonO20
            r0 = r11[r1]
        L_0x024d:
            return r0
        L_0x024e:
            if (r11 == 0) goto L_0x0255
            double[] r11 = minLonO10
            r0 = r11[r1]
            goto L_0x0259
        L_0x0255:
            double[] r11 = maxLonO10
            r0 = r11[r1]
        L_0x0259:
            return r0
        L_0x025a:
            switch(r0) {
                case 10: goto L_0x02e3;
                case 20: goto L_0x02d7;
                case 30: goto L_0x02cb;
                case 40: goto L_0x02bf;
                case 50: goto L_0x02b3;
                case 60: goto L_0x02a7;
                case 66: goto L_0x029b;
                case 70: goto L_0x028f;
                case 80: goto L_0x0283;
                case 85: goto L_0x0277;
                case 88: goto L_0x026b;
                case 90: goto L_0x025f;
                default: goto L_0x025d;
            }
        L_0x025d:
            goto L_0x02ef
        L_0x025f:
            if (r11 == 0) goto L_0x0266
            double[] r11 = minLonR90
            r0 = r11[r1]
            goto L_0x026a
        L_0x0266:
            double[] r11 = maxLonR90
            r0 = r11[r1]
        L_0x026a:
            return r0
        L_0x026b:
            if (r11 == 0) goto L_0x0272
            double[] r11 = minLonR88
            r0 = r11[r1]
            goto L_0x0276
        L_0x0272:
            double[] r11 = maxLonR88
            r0 = r11[r1]
        L_0x0276:
            return r0
        L_0x0277:
            if (r11 == 0) goto L_0x027e
            double[] r11 = minLonR85
            r0 = r11[r1]
            goto L_0x0282
        L_0x027e:
            double[] r11 = maxLonR85
            r0 = r11[r1]
        L_0x0282:
            return r0
        L_0x0283:
            if (r11 == 0) goto L_0x028a
            double[] r11 = minLonR80
            r0 = r11[r1]
            goto L_0x028e
        L_0x028a:
            double[] r11 = maxLonR80
            r0 = r11[r1]
        L_0x028e:
            return r0
        L_0x028f:
            if (r11 == 0) goto L_0x0296
            double[] r11 = minLonR70
            r0 = r11[r1]
            goto L_0x029a
        L_0x0296:
            double[] r11 = maxLonR70
            r0 = r11[r1]
        L_0x029a:
            return r0
        L_0x029b:
            if (r11 == 0) goto L_0x02a2
            double[] r11 = minLonR66
            r0 = r11[r1]
            goto L_0x02a6
        L_0x02a2:
            double[] r11 = maxLonR66
            r0 = r11[r1]
        L_0x02a6:
            return r0
        L_0x02a7:
            if (r11 == 0) goto L_0x02ae
            double[] r11 = minLonR60
            r0 = r11[r1]
            goto L_0x02b2
        L_0x02ae:
            double[] r11 = maxLonR60
            r0 = r11[r1]
        L_0x02b2:
            return r0
        L_0x02b3:
            if (r11 == 0) goto L_0x02ba
            double[] r11 = minLonR50
            r0 = r11[r1]
            goto L_0x02be
        L_0x02ba:
            double[] r11 = maxLonR50
            r0 = r11[r1]
        L_0x02be:
            return r0
        L_0x02bf:
            if (r11 == 0) goto L_0x02c6
            double[] r11 = minLonR40
            r0 = r11[r1]
            goto L_0x02ca
        L_0x02c6:
            double[] r11 = maxLonR40
            r0 = r11[r1]
        L_0x02ca:
            return r0
        L_0x02cb:
            if (r11 == 0) goto L_0x02d2
            double[] r11 = minLonR30
            r0 = r11[r1]
            goto L_0x02d6
        L_0x02d2:
            double[] r11 = maxLonR30
            r0 = r11[r1]
        L_0x02d6:
            return r0
        L_0x02d7:
            if (r11 == 0) goto L_0x02de
            double[] r11 = minLonR20
            r0 = r11[r1]
            goto L_0x02e2
        L_0x02de:
            double[] r11 = maxLonR20
            r0 = r11[r1]
        L_0x02e2:
            return r0
        L_0x02e3:
            if (r11 == 0) goto L_0x02ea
            double[] r11 = minLonR10
            r0 = r11[r1]
            goto L_0x02ee
        L_0x02ea:
            double[] r11 = maxLonR10
            r0 = r11[r1]
        L_0x02ee:
            return r0
        L_0x02ef:
            switch(r0) {
                case 10: goto L_0x0378;
                case 20: goto L_0x036c;
                case 30: goto L_0x0360;
                case 40: goto L_0x0354;
                case 50: goto L_0x0348;
                case 60: goto L_0x033c;
                case 66: goto L_0x0330;
                case 70: goto L_0x0324;
                case 80: goto L_0x0318;
                case 85: goto L_0x030c;
                case 88: goto L_0x0300;
                case 90: goto L_0x02f4;
                default: goto L_0x02f2;
            }
        L_0x02f2:
            goto L_0x0384
        L_0x02f4:
            if (r11 == 0) goto L_0x02fb
            double[] r11 = minLonC90
            r0 = r11[r1]
            goto L_0x02ff
        L_0x02fb:
            double[] r11 = maxLonC90
            r0 = r11[r1]
        L_0x02ff:
            return r0
        L_0x0300:
            if (r11 == 0) goto L_0x0307
            double[] r11 = minLonC88
            r0 = r11[r1]
            goto L_0x030b
        L_0x0307:
            double[] r11 = maxLonC88
            r0 = r11[r1]
        L_0x030b:
            return r0
        L_0x030c:
            if (r11 == 0) goto L_0x0313
            double[] r11 = minLonC85
            r0 = r11[r1]
            goto L_0x0317
        L_0x0313:
            double[] r11 = maxLonC85
            r0 = r11[r1]
        L_0x0317:
            return r0
        L_0x0318:
            if (r11 == 0) goto L_0x031f
            double[] r11 = minLonC80
            r0 = r11[r1]
            goto L_0x0323
        L_0x031f:
            double[] r11 = maxLonC80
            r0 = r11[r1]
        L_0x0323:
            return r0
        L_0x0324:
            if (r11 == 0) goto L_0x032b
            double[] r11 = minLonC70
            r0 = r11[r1]
            goto L_0x032f
        L_0x032b:
            double[] r11 = maxLonC70
            r0 = r11[r1]
        L_0x032f:
            return r0
        L_0x0330:
            if (r11 == 0) goto L_0x0337
            double[] r11 = minLonC66
            r0 = r11[r1]
            goto L_0x033b
        L_0x0337:
            double[] r11 = maxLonC66
            r0 = r11[r1]
        L_0x033b:
            return r0
        L_0x033c:
            if (r11 == 0) goto L_0x0343
            double[] r11 = minLonC60
            r0 = r11[r1]
            goto L_0x0347
        L_0x0343:
            double[] r11 = maxLonC60
            r0 = r11[r1]
        L_0x0347:
            return r0
        L_0x0348:
            if (r11 == 0) goto L_0x034f
            double[] r11 = minLonC50
            r0 = r11[r1]
            goto L_0x0353
        L_0x034f:
            double[] r11 = maxLonC50
            r0 = r11[r1]
        L_0x0353:
            return r0
        L_0x0354:
            if (r11 == 0) goto L_0x035b
            double[] r11 = minLonC40
            r0 = r11[r1]
            goto L_0x035f
        L_0x035b:
            double[] r11 = maxLonC40
            r0 = r11[r1]
        L_0x035f:
            return r0
        L_0x0360:
            if (r11 == 0) goto L_0x0367
            double[] r11 = minLonC30
            r0 = r11[r1]
            goto L_0x036b
        L_0x0367:
            double[] r11 = maxLonC30
            r0 = r11[r1]
        L_0x036b:
            return r0
        L_0x036c:
            if (r11 == 0) goto L_0x0373
            double[] r11 = minLonC20
            r0 = r11[r1]
            goto L_0x0377
        L_0x0373:
            double[] r11 = maxLonC20
            r0 = r11[r1]
        L_0x0377:
            return r0
        L_0x0378:
            if (r11 == 0) goto L_0x037f
            double[] r11 = minLonC10
            r0 = r11[r1]
            goto L_0x0383
        L_0x037f:
            double[] r11 = maxLonC10
            r0 = r11[r1]
        L_0x0383:
            return r0
        L_0x0384:
            switch(r0) {
                case 10: goto L_0x040d;
                case 20: goto L_0x0401;
                case 30: goto L_0x03f5;
                case 40: goto L_0x03e9;
                case 50: goto L_0x03dd;
                case 60: goto L_0x03d1;
                case 66: goto L_0x03c5;
                case 70: goto L_0x03b9;
                case 80: goto L_0x03ad;
                case 85: goto L_0x03a1;
                case 88: goto L_0x0395;
                case 90: goto L_0x0389;
                default: goto L_0x0387;
            }
        L_0x0387:
            goto L_0x0419
        L_0x0389:
            if (r11 == 0) goto L_0x0390
            double[] r11 = minLonE90
            r0 = r11[r1]
            goto L_0x0394
        L_0x0390:
            double[] r11 = maxLonE90
            r0 = r11[r1]
        L_0x0394:
            return r0
        L_0x0395:
            if (r11 == 0) goto L_0x039c
            double[] r11 = minLonE88
            r0 = r11[r1]
            goto L_0x03a0
        L_0x039c:
            double[] r11 = maxLonE88
            r0 = r11[r1]
        L_0x03a0:
            return r0
        L_0x03a1:
            if (r11 == 0) goto L_0x03a8
            double[] r11 = minLonE85
            r0 = r11[r1]
            goto L_0x03ac
        L_0x03a8:
            double[] r11 = maxLonE85
            r0 = r11[r1]
        L_0x03ac:
            return r0
        L_0x03ad:
            if (r11 == 0) goto L_0x03b4
            double[] r11 = minLonE80
            r0 = r11[r1]
            goto L_0x03b8
        L_0x03b4:
            double[] r11 = maxLonE80
            r0 = r11[r1]
        L_0x03b8:
            return r0
        L_0x03b9:
            if (r11 == 0) goto L_0x03c0
            double[] r11 = minLonE70
            r0 = r11[r1]
            goto L_0x03c4
        L_0x03c0:
            double[] r11 = maxLonE70
            r0 = r11[r1]
        L_0x03c4:
            return r0
        L_0x03c5:
            if (r11 == 0) goto L_0x03cc
            double[] r11 = minLonE66
            r0 = r11[r1]
            goto L_0x03d0
        L_0x03cc:
            double[] r11 = maxLonE66
            r0 = r11[r1]
        L_0x03d0:
            return r0
        L_0x03d1:
            if (r11 == 0) goto L_0x03d8
            double[] r11 = minLonE60
            r0 = r11[r1]
            goto L_0x03dc
        L_0x03d8:
            double[] r11 = maxLonE60
            r0 = r11[r1]
        L_0x03dc:
            return r0
        L_0x03dd:
            if (r11 == 0) goto L_0x03e4
            double[] r11 = minLonE50
            r0 = r11[r1]
            goto L_0x03e8
        L_0x03e4:
            double[] r11 = maxLonE50
            r0 = r11[r1]
        L_0x03e8:
            return r0
        L_0x03e9:
            if (r11 == 0) goto L_0x03f0
            double[] r11 = minLonE40
            r0 = r11[r1]
            goto L_0x03f4
        L_0x03f0:
            double[] r11 = maxLonE40
            r0 = r11[r1]
        L_0x03f4:
            return r0
        L_0x03f5:
            if (r11 == 0) goto L_0x03fc
            double[] r11 = minLonE30
            r0 = r11[r1]
            goto L_0x0400
        L_0x03fc:
            double[] r11 = maxLonE30
            r0 = r11[r1]
        L_0x0400:
            return r0
        L_0x0401:
            if (r11 == 0) goto L_0x0408
            double[] r11 = minLonE20
            r0 = r11[r1]
            goto L_0x040c
        L_0x0408:
            double[] r11 = maxLonE20
            r0 = r11[r1]
        L_0x040c:
            return r0
        L_0x040d:
            if (r11 == 0) goto L_0x0414
            double[] r11 = minLonE10
            r0 = r11[r1]
            goto L_0x0418
        L_0x0414:
            double[] r11 = maxLonE10
            r0 = r11[r1]
        L_0x0418:
            return r0
        L_0x0419:
            switch(r0) {
                case 10: goto L_0x04a2;
                case 20: goto L_0x0496;
                case 30: goto L_0x048a;
                case 40: goto L_0x047e;
                case 50: goto L_0x0472;
                case 60: goto L_0x0466;
                case 66: goto L_0x045a;
                case 70: goto L_0x044e;
                case 80: goto L_0x0442;
                case 85: goto L_0x0436;
                case 88: goto L_0x042a;
                case 90: goto L_0x041e;
                default: goto L_0x041c;
            }
        L_0x041c:
            goto L_0x04ae
        L_0x041e:
            if (r11 == 0) goto L_0x0425
            double[] r11 = minLonV90
            r0 = r11[r1]
            goto L_0x0429
        L_0x0425:
            double[] r11 = maxLonV90
            r0 = r11[r1]
        L_0x0429:
            return r0
        L_0x042a:
            if (r11 == 0) goto L_0x0431
            double[] r11 = minLonV88
            r0 = r11[r1]
            goto L_0x0435
        L_0x0431:
            double[] r11 = maxLonV88
            r0 = r11[r1]
        L_0x0435:
            return r0
        L_0x0436:
            if (r11 == 0) goto L_0x043d
            double[] r11 = minLonV85
            r0 = r11[r1]
            goto L_0x0441
        L_0x043d:
            double[] r11 = maxLonV85
            r0 = r11[r1]
        L_0x0441:
            return r0
        L_0x0442:
            if (r11 == 0) goto L_0x0449
            double[] r11 = minLonV80
            r0 = r11[r1]
            goto L_0x044d
        L_0x0449:
            double[] r11 = maxLonV80
            r0 = r11[r1]
        L_0x044d:
            return r0
        L_0x044e:
            if (r11 == 0) goto L_0x0455
            double[] r11 = minLonV70
            r0 = r11[r1]
            goto L_0x0459
        L_0x0455:
            double[] r11 = maxLonV70
            r0 = r11[r1]
        L_0x0459:
            return r0
        L_0x045a:
            if (r11 == 0) goto L_0x0461
            double[] r11 = minLonV66
            r0 = r11[r1]
            goto L_0x0465
        L_0x0461:
            double[] r11 = maxLonV66
            r0 = r11[r1]
        L_0x0465:
            return r0
        L_0x0466:
            if (r11 == 0) goto L_0x046d
            double[] r11 = minLonV60
            r0 = r11[r1]
            goto L_0x0471
        L_0x046d:
            double[] r11 = maxLonV60
            r0 = r11[r1]
        L_0x0471:
            return r0
        L_0x0472:
            if (r11 == 0) goto L_0x0479
            double[] r11 = minLonV50
            r0 = r11[r1]
            goto L_0x047d
        L_0x0479:
            double[] r11 = maxLonV50
            r0 = r11[r1]
        L_0x047d:
            return r0
        L_0x047e:
            if (r11 == 0) goto L_0x0485
            double[] r11 = minLonV40
            r0 = r11[r1]
            goto L_0x0489
        L_0x0485:
            double[] r11 = maxLonV40
            r0 = r11[r1]
        L_0x0489:
            return r0
        L_0x048a:
            if (r11 == 0) goto L_0x0491
            double[] r11 = minLonV30
            r0 = r11[r1]
            goto L_0x0495
        L_0x0491:
            double[] r11 = maxLonV30
            r0 = r11[r1]
        L_0x0495:
            return r0
        L_0x0496:
            if (r11 == 0) goto L_0x049d
            double[] r11 = minLonV20
            r0 = r11[r1]
            goto L_0x04a1
        L_0x049d:
            double[] r11 = maxLonV20
            r0 = r11[r1]
        L_0x04a1:
            return r0
        L_0x04a2:
            if (r11 == 0) goto L_0x04a9
            double[] r11 = minLonV10
            r0 = r11[r1]
            goto L_0x04ad
        L_0x04a9:
            double[] r11 = maxLonV10
            r0 = r11[r1]
        L_0x04ad:
            return r0
        L_0x04ae:
            switch(r0) {
                case 10: goto L_0x0537;
                case 20: goto L_0x052b;
                case 30: goto L_0x051f;
                case 40: goto L_0x0513;
                case 50: goto L_0x0507;
                case 60: goto L_0x04fb;
                case 66: goto L_0x04ef;
                case 70: goto L_0x04e3;
                case 80: goto L_0x04d7;
                case 85: goto L_0x04cb;
                case 88: goto L_0x04bf;
                case 90: goto L_0x04b3;
                default: goto L_0x04b1;
            }
        L_0x04b1:
            goto L_0x0543
        L_0x04b3:
            if (r11 == 0) goto L_0x04ba
            double[] r11 = minLonX90
            r0 = r11[r1]
            goto L_0x04be
        L_0x04ba:
            double[] r11 = maxLonX90
            r0 = r11[r1]
        L_0x04be:
            return r0
        L_0x04bf:
            if (r11 == 0) goto L_0x04c6
            double[] r11 = minLonX88
            r0 = r11[r1]
            goto L_0x04ca
        L_0x04c6:
            double[] r11 = maxLonX88
            r0 = r11[r1]
        L_0x04ca:
            return r0
        L_0x04cb:
            if (r11 == 0) goto L_0x04d2
            double[] r11 = minLonX85
            r0 = r11[r1]
            goto L_0x04d6
        L_0x04d2:
            double[] r11 = maxLonX85
            r0 = r11[r1]
        L_0x04d6:
            return r0
        L_0x04d7:
            if (r11 == 0) goto L_0x04de
            double[] r11 = minLonX80
            r0 = r11[r1]
            goto L_0x04e2
        L_0x04de:
            double[] r11 = maxLonX80
            r0 = r11[r1]
        L_0x04e2:
            return r0
        L_0x04e3:
            if (r11 == 0) goto L_0x04ea
            double[] r11 = minLonX70
            r0 = r11[r1]
            goto L_0x04ee
        L_0x04ea:
            double[] r11 = maxLonX70
            r0 = r11[r1]
        L_0x04ee:
            return r0
        L_0x04ef:
            if (r11 == 0) goto L_0x04f6
            double[] r11 = minLonX66
            r0 = r11[r1]
            goto L_0x04fa
        L_0x04f6:
            double[] r11 = maxLonX66
            r0 = r11[r1]
        L_0x04fa:
            return r0
        L_0x04fb:
            if (r11 == 0) goto L_0x0502
            double[] r11 = minLonX60
            r0 = r11[r1]
            goto L_0x0506
        L_0x0502:
            double[] r11 = maxLonX60
            r0 = r11[r1]
        L_0x0506:
            return r0
        L_0x0507:
            if (r11 == 0) goto L_0x050e
            double[] r11 = minLonX50
            r0 = r11[r1]
            goto L_0x0512
        L_0x050e:
            double[] r11 = maxLonX50
            r0 = r11[r1]
        L_0x0512:
            return r0
        L_0x0513:
            if (r11 == 0) goto L_0x051a
            double[] r11 = minLonX40
            r0 = r11[r1]
            goto L_0x051e
        L_0x051a:
            double[] r11 = maxLonX40
            r0 = r11[r1]
        L_0x051e:
            return r0
        L_0x051f:
            if (r11 == 0) goto L_0x0526
            double[] r11 = minLonX30
            r0 = r11[r1]
            goto L_0x052a
        L_0x0526:
            double[] r11 = maxLonX30
            r0 = r11[r1]
        L_0x052a:
            return r0
        L_0x052b:
            if (r11 == 0) goto L_0x0532
            double[] r11 = minLonX20
            r0 = r11[r1]
            goto L_0x0536
        L_0x0532:
            double[] r11 = maxLonX20
            r0 = r11[r1]
        L_0x0536:
            return r0
        L_0x0537:
            if (r11 == 0) goto L_0x053e
            double[] r11 = minLonX10
            r0 = r11[r1]
            goto L_0x0542
        L_0x053e:
            double[] r11 = maxLonX10
            r0 = r11[r1]
        L_0x0542:
            return r0
        L_0x0543:
            switch(r0) {
                case 10: goto L_0x05cc;
                case 20: goto L_0x05c0;
                case 30: goto L_0x05b4;
                case 40: goto L_0x05a8;
                case 50: goto L_0x059c;
                case 60: goto L_0x0590;
                case 66: goto L_0x0584;
                case 70: goto L_0x0578;
                case 80: goto L_0x056c;
                case 85: goto L_0x0560;
                case 88: goto L_0x0554;
                case 90: goto L_0x0548;
                default: goto L_0x0546;
            }
        L_0x0546:
            goto L_0x05d8
        L_0x0548:
            if (r11 == 0) goto L_0x054f
            double[] r11 = minLonH90
            r0 = r11[r1]
            goto L_0x0553
        L_0x054f:
            double[] r11 = maxLonH90
            r0 = r11[r1]
        L_0x0553:
            return r0
        L_0x0554:
            if (r11 == 0) goto L_0x055b
            double[] r11 = minLonH88
            r0 = r11[r1]
            goto L_0x055f
        L_0x055b:
            double[] r11 = maxLonH88
            r0 = r11[r1]
        L_0x055f:
            return r0
        L_0x0560:
            if (r11 == 0) goto L_0x0567
            double[] r11 = minLonH85
            r0 = r11[r1]
            goto L_0x056b
        L_0x0567:
            double[] r11 = maxLonH85
            r0 = r11[r1]
        L_0x056b:
            return r0
        L_0x056c:
            if (r11 == 0) goto L_0x0573
            double[] r11 = minLonH80
            r0 = r11[r1]
            goto L_0x0577
        L_0x0573:
            double[] r11 = maxLonH80
            r0 = r11[r1]
        L_0x0577:
            return r0
        L_0x0578:
            if (r11 == 0) goto L_0x057f
            double[] r11 = minLonH70
            r0 = r11[r1]
            goto L_0x0583
        L_0x057f:
            double[] r11 = maxLonH70
            r0 = r11[r1]
        L_0x0583:
            return r0
        L_0x0584:
            if (r11 == 0) goto L_0x058b
            double[] r11 = minLonH66
            r0 = r11[r1]
            goto L_0x058f
        L_0x058b:
            double[] r11 = maxLonH66
            r0 = r11[r1]
        L_0x058f:
            return r0
        L_0x0590:
            if (r11 == 0) goto L_0x0597
            double[] r11 = minLonH60
            r0 = r11[r1]
            goto L_0x059b
        L_0x0597:
            double[] r11 = maxLonH60
            r0 = r11[r1]
        L_0x059b:
            return r0
        L_0x059c:
            if (r11 == 0) goto L_0x05a3
            double[] r11 = minLonH50
            r0 = r11[r1]
            goto L_0x05a7
        L_0x05a3:
            double[] r11 = maxLonH50
            r0 = r11[r1]
        L_0x05a7:
            return r0
        L_0x05a8:
            if (r11 == 0) goto L_0x05af
            double[] r11 = minLonH40
            r0 = r11[r1]
            goto L_0x05b3
        L_0x05af:
            double[] r11 = maxLonH40
            r0 = r11[r1]
        L_0x05b3:
            return r0
        L_0x05b4:
            if (r11 == 0) goto L_0x05bb
            double[] r11 = minLonH30
            r0 = r11[r1]
            goto L_0x05bf
        L_0x05bb:
            double[] r11 = maxLonH30
            r0 = r11[r1]
        L_0x05bf:
            return r0
        L_0x05c0:
            if (r11 == 0) goto L_0x05c7
            double[] r11 = minLonH20
            r0 = r11[r1]
            goto L_0x05cb
        L_0x05c7:
            double[] r11 = maxLonH20
            r0 = r11[r1]
        L_0x05cb:
            return r0
        L_0x05cc:
            if (r11 == 0) goto L_0x05d3
            double[] r11 = minLonH10
            r0 = r11[r1]
            goto L_0x05d7
        L_0x05d3:
            double[] r11 = maxLonH10
            r0 = r11[r1]
        L_0x05d7:
            return r0
        L_0x05d8:
            switch(r0) {
                case 10: goto L_0x0661;
                case 20: goto L_0x0655;
                case 30: goto L_0x0649;
                case 40: goto L_0x063d;
                case 50: goto L_0x0631;
                case 60: goto L_0x0625;
                case 66: goto L_0x0619;
                case 70: goto L_0x060d;
                case 80: goto L_0x0601;
                case 85: goto L_0x05f5;
                case 88: goto L_0x05e9;
                case 90: goto L_0x05dd;
                default: goto L_0x05db;
            }
        L_0x05db:
            goto L_0x066d
        L_0x05dd:
            if (r11 == 0) goto L_0x05e4
            double[] r11 = minLonT90
            r0 = r11[r1]
            goto L_0x05e8
        L_0x05e4:
            double[] r11 = maxLonT90
            r0 = r11[r1]
        L_0x05e8:
            return r0
        L_0x05e9:
            if (r11 == 0) goto L_0x05f0
            double[] r11 = minLonT88
            r0 = r11[r1]
            goto L_0x05f4
        L_0x05f0:
            double[] r11 = maxLonT88
            r0 = r11[r1]
        L_0x05f4:
            return r0
        L_0x05f5:
            if (r11 == 0) goto L_0x05fc
            double[] r11 = minLonT85
            r0 = r11[r1]
            goto L_0x0600
        L_0x05fc:
            double[] r11 = maxLonT85
            r0 = r11[r1]
        L_0x0600:
            return r0
        L_0x0601:
            if (r11 == 0) goto L_0x0608
            double[] r11 = minLonT80
            r0 = r11[r1]
            goto L_0x060c
        L_0x0608:
            double[] r11 = maxLonT80
            r0 = r11[r1]
        L_0x060c:
            return r0
        L_0x060d:
            if (r11 == 0) goto L_0x0614
            double[] r11 = minLonT70
            r0 = r11[r1]
            goto L_0x0618
        L_0x0614:
            double[] r11 = maxLonT70
            r0 = r11[r1]
        L_0x0618:
            return r0
        L_0x0619:
            if (r11 == 0) goto L_0x0620
            double[] r11 = minLonT66
            r0 = r11[r1]
            goto L_0x0624
        L_0x0620:
            double[] r11 = maxLonT66
            r0 = r11[r1]
        L_0x0624:
            return r0
        L_0x0625:
            if (r11 == 0) goto L_0x062c
            double[] r11 = minLonT60
            r0 = r11[r1]
            goto L_0x0630
        L_0x062c:
            double[] r11 = maxLonT60
            r0 = r11[r1]
        L_0x0630:
            return r0
        L_0x0631:
            if (r11 == 0) goto L_0x0638
            double[] r11 = minLonT50
            r0 = r11[r1]
            goto L_0x063c
        L_0x0638:
            double[] r11 = maxLonT50
            r0 = r11[r1]
        L_0x063c:
            return r0
        L_0x063d:
            if (r11 == 0) goto L_0x0644
            double[] r11 = minLonT40
            r0 = r11[r1]
            goto L_0x0648
        L_0x0644:
            double[] r11 = maxLonT40
            r0 = r11[r1]
        L_0x0648:
            return r0
        L_0x0649:
            if (r11 == 0) goto L_0x0650
            double[] r11 = minLonT30
            r0 = r11[r1]
            goto L_0x0654
        L_0x0650:
            double[] r11 = maxLonT30
            r0 = r11[r1]
        L_0x0654:
            return r0
        L_0x0655:
            if (r11 == 0) goto L_0x065c
            double[] r11 = minLonT20
            r0 = r11[r1]
            goto L_0x0660
        L_0x065c:
            double[] r11 = maxLonT20
            r0 = r11[r1]
        L_0x0660:
            return r0
        L_0x0661:
            if (r11 == 0) goto L_0x0668
            double[] r11 = minLonT10
            r0 = r11[r1]
            goto L_0x066c
        L_0x0668:
            double[] r11 = maxLonT10
            r0 = r11[r1]
        L_0x066c:
            return r0
        L_0x066d:
            switch(r0) {
                case 10: goto L_0x06f6;
                case 20: goto L_0x06ea;
                case 30: goto L_0x06de;
                case 40: goto L_0x06d2;
                case 50: goto L_0x06c6;
                case 60: goto L_0x06ba;
                case 66: goto L_0x06ae;
                case 70: goto L_0x06a2;
                case 80: goto L_0x0696;
                case 85: goto L_0x068a;
                case 88: goto L_0x067e;
                case 90: goto L_0x0672;
                default: goto L_0x0670;
            }
        L_0x0670:
            goto L_0x0702
        L_0x0672:
            if (r11 == 0) goto L_0x0679
            double[] r11 = minLonB90
            r0 = r11[r1]
            goto L_0x067d
        L_0x0679:
            double[] r11 = maxLonB90
            r0 = r11[r1]
        L_0x067d:
            return r0
        L_0x067e:
            if (r11 == 0) goto L_0x0685
            double[] r11 = minLonB88
            r0 = r11[r1]
            goto L_0x0689
        L_0x0685:
            double[] r11 = maxLonB88
            r0 = r11[r1]
        L_0x0689:
            return r0
        L_0x068a:
            if (r11 == 0) goto L_0x0691
            double[] r11 = minLonB85
            r0 = r11[r1]
            goto L_0x0695
        L_0x0691:
            double[] r11 = maxLonB85
            r0 = r11[r1]
        L_0x0695:
            return r0
        L_0x0696:
            if (r11 == 0) goto L_0x069d
            double[] r11 = minLonB80
            r0 = r11[r1]
            goto L_0x06a1
        L_0x069d:
            double[] r11 = maxLonB80
            r0 = r11[r1]
        L_0x06a1:
            return r0
        L_0x06a2:
            if (r11 == 0) goto L_0x06a9
            double[] r11 = minLonB70
            r0 = r11[r1]
            goto L_0x06ad
        L_0x06a9:
            double[] r11 = maxLonB70
            r0 = r11[r1]
        L_0x06ad:
            return r0
        L_0x06ae:
            if (r11 == 0) goto L_0x06b5
            double[] r11 = minLonB66
            r0 = r11[r1]
            goto L_0x06b9
        L_0x06b5:
            double[] r11 = maxLonB66
            r0 = r11[r1]
        L_0x06b9:
            return r0
        L_0x06ba:
            if (r11 == 0) goto L_0x06c1
            double[] r11 = minLonB60
            r0 = r11[r1]
            goto L_0x06c5
        L_0x06c1:
            double[] r11 = maxLonB60
            r0 = r11[r1]
        L_0x06c5:
            return r0
        L_0x06c6:
            if (r11 == 0) goto L_0x06cd
            double[] r11 = minLonB50
            r0 = r11[r1]
            goto L_0x06d1
        L_0x06cd:
            double[] r11 = maxLonB50
            r0 = r11[r1]
        L_0x06d1:
            return r0
        L_0x06d2:
            if (r11 == 0) goto L_0x06d9
            double[] r11 = minLonB40
            r0 = r11[r1]
            goto L_0x06dd
        L_0x06d9:
            double[] r11 = maxLonB40
            r0 = r11[r1]
        L_0x06dd:
            return r0
        L_0x06de:
            if (r11 == 0) goto L_0x06e5
            double[] r11 = minLonB30
            r0 = r11[r1]
            goto L_0x06e9
        L_0x06e5:
            double[] r11 = maxLonB30
            r0 = r11[r1]
        L_0x06e9:
            return r0
        L_0x06ea:
            if (r11 == 0) goto L_0x06f1
            double[] r11 = minLonB20
            r0 = r11[r1]
            goto L_0x06f5
        L_0x06f1:
            double[] r11 = maxLonB20
            r0 = r11[r1]
        L_0x06f5:
            return r0
        L_0x06f6:
            if (r11 == 0) goto L_0x06fd
            double[] r11 = minLonB10
            r0 = r11[r1]
            goto L_0x0701
        L_0x06fd:
            double[] r11 = maxLonB10
            r0 = r11[r1]
        L_0x0701:
            return r0
        L_0x0702:
            if (r11 == 0) goto L_0x0707
            r11 = 3200(0xc80, float:4.484E-42)
            goto L_0x0709
        L_0x0707:
            r11 = 4000(0xfa0, float:5.605E-42)
        L_0x0709:
            double r0 = (double) r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.TCHouses.getSpeed(boolean):double");
    }

    private String getObjectname(int i) {
        switch (i) {
            case SweConst.SE_HOUSE12:
                return "house 12";
            case SweConst.SE_HOUSE11:
                return "house 11";
            case -10:
                return "house 10";
            case SweConst.SE_HOUSE9:
                return "house 9";
            case SweConst.SE_HOUSE8:
                return "house 8";
            case SweConst.SE_HOUSE7:
                return "house 7";
            case SweConst.SE_HOUSE6:
                return "house 6";
            case SweConst.SE_HOUSE5:
                return "house 5";
            case -4:
                return "house 4";
            case -3:
                return "house 3";
            case -2:
                return "house 2";
            case -1:
                return "house 1";
            case 0:
                return "ascendant";
            case 1:
                return "medium coeli";
            case 2:
                return "sidereal time";
            case 3:
                return "vertex";
            case 4:
                return "equatorial ascendant";
            case 5:
                return "co-ascendant of W. Koch";
            case 6:
                return "co-ascendant of M. Munkasey";
            case 7:
                return "polar ascendant value of M. Munkasey";
            default:
                return "";
        }
    }

    public String toString() {
        return "TCHouses [Object:" + this.house_object + "];Offset:" + getOffset();
    }
}
