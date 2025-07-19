package swisseph;

import java.io.Serializable;

class Swecl implements Serializable {
    private static final double DEARTH = 8.527046503885043E-5d;
    private static final double DMOON = 2.3237630219355155E-5d;
    private static final double DSUN = 0.009304945276685664d;
    private static final double EULER = 2.718281828459d;
    private static final int NMAG_ELEM = 21;
    static final int NSAROS_LUNAR;
    static final int NSAROS_SOLAR;
    private static final double REARTH = 4.263523251942522E-5d;
    private static final double RMOON = 1.1618815109677577E-5d;
    private static final double RSUN = 0.004652472638342832d;
    static final double SAROS_CYCLE = 6585.3213d;
    private static final double[][] el_ecce = {new double[]{0.20563175d, 2.0406E-5d, -2.84E-8d, -1.7E-10d}, new double[]{0.00677188d, -4.7766E-5d, 9.75E-8d, 4.4E-10d}, new double[]{0.01670862d, -4.2037E-5d, -1.236E-7d, 4.0E-11d}, new double[]{0.09340062d, 9.0483E-5d, -8.06E-8d, -3.5E-10d}, new double[]{0.04849485d, 1.63244E-4d, -4.719E-7d, -1.97E-9d}, new double[]{0.05550862d, -3.46818E-4d, -6.456E-7d, 3.38E-9d}, new double[]{0.0462959d, -2.7337E-5d, 7.9E-8d, 2.5E-10d}, new double[]{0.00898809d, 6.408E-6d, -8.0E-10d, -5.0E-11d}};
    private static final double[][] el_incl = {new double[]{7.004986d, 0.0018215d, -1.809E-5d, 5.3E-8d}, new double[]{3.394662d, 0.0010037d, -8.8E-7d, -7.0E-9d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d}, new double[]{1.849726d, -6.01E-4d, 1.276E-5d, -6.0E-9d}, new double[]{1.30327d, -0.0054966d, 4.65E-6d, -4.0E-9d}, new double[]{2.488878d, -0.0037363d, -1.516E-5d, 8.9E-8d}, new double[]{0.773196d, 7.744E-4d, 3.749E-5d, -9.2E-8d}, new double[]{1.769952d, -0.0093082d, -7.08E-6d, 2.8E-8d}};
    private static final double[][] el_node = {new double[]{48.330893d, 1.186189d, 1.7587E-4d, 2.11E-7d}, new double[]{76.67992d, 0.901119d, 4.0665E-4d, -8.0E-8d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d}, new double[]{49.558093d, 0.7720923d, 1.605E-5d, 2.325E-6d}, new double[]{100.464441d, 1.020955d, 4.0117E-4d, 5.69E-7d}, new double[]{113.665524d, 0.877097d, -1.2067E-4d, -2.38E-6d}, new double[]{74.005947d, 0.5211258d, 0.00133982d, 1.8516E-5d}, new double[]{131.784057d, 1.1022057d, 2.6006E-4d, -6.36E-7d}};
    private static final double[][] el_peri = {new double[]{77.456119d, 1.5564775d, 2.9589E-4d, 5.6E-8d}, new double[]{131.563707d, 1.4022188d, -0.00107337d, -5.315E-6d}, new double[]{102.937348d, 1.7195269d, 4.5962E-4d, 4.99E-7d}, new double[]{336.060234d, 1.8410331d, 1.3515E-4d, 3.18E-7d}, new double[]{14.331309d, 1.6126668d, 0.00103127d, -4.569E-6d}, new double[]{93.056787d, 1.9637694d, 8.3757E-4d, 4.899E-6d}, new double[]{173.005159d, 1.4863784d, 2.145E-4d, 4.33E-7d}, new double[]{48.123691d, 1.4262677d, 3.7918E-4d, -3.0E-9d}};
    private static final double[][] el_sema = {new double[]{0.38709831d, 0.0d, 0.0d, 0.0d}, new double[]{0.72332982d, 0.0d, 0.0d, 0.0d}, new double[]{1.000001018d, 0.0d, 0.0d, 0.0d}, new double[]{1.523679342d, 0.0d, 0.0d, 0.0d}, new double[]{5.202603191d, 1.913E-7d, 0.0d, 0.0d}, new double[]{9.554909596d, 2.1389E-6d, 0.0d, 0.0d}, new double[]{19.218446062d, -3.72E-8d, 9.8E-10d, 0.0d}, new double[]{30.110386869d, -1.663E-7d, 6.9E-10d, 0.0d}};
    private static final int[] ipl_to_elem = {2, 0, 0, 1, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 2};
    private static final double lnlog = SMath.log(10.0d);
    private static final double[][] mag_elem = {new double[]{-26.86d, 0.0d, 0.0d, 0.0d}, new double[]{-12.55d, 0.0d, 0.0d, 0.0d}, new double[]{-0.42d, 3.8d, -2.73d, 2.0d}, new double[]{-4.4d, 0.09d, 2.39d, -0.65d}, new double[]{-1.52d, 1.6d, 0.0d, 0.0d}, new double[]{-9.4d, 0.5d, 0.0d, 0.0d}, new double[]{-8.88d, -2.6d, 1.25d, 0.044d}, new double[]{-7.19d, 0.0d, 0.0d, 0.0d}, new double[]{-6.87d, 0.0d, 0.0d, 0.0d}, new double[]{-1.0d, 0.0d, 0.0d, 0.0d}, new double[]{99.0d, 0.0d, 0.0d, 0.0d}, new double[]{99.0d, 0.0d, 0.0d, 0.0d}, new double[]{99.0d, 0.0d, 0.0d, 0.0d}, new double[]{99.0d, 0.0d, 0.0d, 0.0d}, new double[]{99.0d, 0.0d, 0.0d, 0.0d}, new double[]{6.5d, 0.15d, 0.0d, 0.0d}, new double[]{7.0d, 0.15d, 0.0d, 0.0d}, new double[]{3.34d, 0.12d, 0.0d, 0.0d}, new double[]{4.13d, 0.11d, 0.0d, 0.0d}, new double[]{5.33d, 0.32d, 0.0d, 0.0d}, new double[]{3.2d, 0.32d, 0.0d, 0.0d}};
    private static final double[] plmass = {6023600.0d, 408523.5d, 328900.5d, 3098710.0d, 1047.35d, 3498.0d, 22960.0d, 19314.0d, 1.3E8d};
    static final SarosData[] saros_data_lunar;
    static final SarosData[] saros_data_solar;
    private double const_lapse_rate;
    SwissLib sl;
    Swemmoon sm;
    SwissEph sw;
    SwissData swed;

    static {
        SarosData[] sarosDataArr = {new SarosData(0, 641886.5d), new SarosData(1, 672214.5d), new SarosData(2, 676200.5d), new SarosData(3, 693357.5d), new SarosData(4, 723685.5d), new SarosData(5, 727671.5d), new SarosData(6, 744829.5d), new SarosData(7, 775157.5d), new SarosData(8, 779143.5d), new SarosData(9, 783131.5d), new SarosData(10, 820044.5d), new SarosData(11, 810859.5d), new SarosData(12, 748993.5d), new SarosData(13, 792492.5d), new SarosData(14, 789892.5d), new SarosData(15, 787294.5d), new SarosData(16, 824207.5d), new SarosData(17, 834779.5d), new SarosData(18, 838766.5d), new SarosData(19, 869094.5d), new SarosData(20, 886251.5d), new SarosData(21, 890238.5d), new SarosData(22, 927151.5d), new SarosData(23, 937722.5d), new SarosData(24, 941709.5d), new SarosData(25, 978623.5d), new SarosData(26, 989194.5d), new SarosData(27, 993181.5d), new SarosData(28, 1023510.5d), new SarosData(29, 1034081.5d), new SarosData(30, 972214.5d), new SarosData(31, 1061811.5d), new SarosData(32, 1006529.5d), new SarosData(33, 997345.5d), new SarosData(34, 1021088.5d), new SarosData(35, 1038245.5d), new SarosData(36, 1042231.5d), new SarosData(37, 1065974.5d), new SarosData(38, 1089716.5d), new SarosData(39, 1093703.5d), new SarosData(40, 1117446.5d), new SarosData(41, 1141188.5d), new SarosData(42, 1145175.5d), new SarosData(43, 1168918.5d), new SarosData(44, 1192660.5d), new SarosData(45, 1196647.5d), new SarosData(46, 1220390.5d), new SarosData(47, 1244132.5d), new SarosData(48, 1234948.5d), new SarosData(49, 1265277.5d), new SarosData(50, 1282433.5d), new SarosData(51, 1207395.5d), new SarosData(52, 1217968.5d), new SarosData(53, 1254881.5d), new SarosData(54, 1252282.5d), new SarosData(55, 1262855.5d), new SarosData(56, 1293182.5d), new SarosData(57, 1297169.5d), new SarosData(58, 1314326.5d), new SarosData(59, 1344654.5d), new SarosData(60, 1348640.5d), new SarosData(61, 1365798.5d), new SarosData(62, 1396126.5d), new SarosData(63, 1400112.5d), new SarosData(64, 1417270.5d), new SarosData(65, 1447598.5d), new SarosData(66, 1444999.5d), new SarosData(67, 1462157.5d), new SarosData(68, 1492485.5d), new SarosData(69, 1456959.5d), new SarosData(70, 1421434.5d), new SarosData(71, 1471518.5d), new SarosData(72, 1455748.5d), new SarosData(73, 1466320.5d), new SarosData(74, 1496648.5d), new SarosData(75, 1500634.5d), new SarosData(76, 1511207.5d), new SarosData(77, 1548120.5d), new SarosData(78, 1552106.5d), new SarosData(79, 1562679.5d), new SarosData(80, 1599592.5d), new SarosData(81, 1603578.5d), new SarosData(82, 1614150.5d), new SarosData(83, 1644479.5d), new SarosData(84, 1655050.5d), new SarosData(85, 1659037.5d), new SarosData(86, 1695950.5d), new SarosData(87, 1693351.5d), new SarosData(88, 1631484.5d), new SarosData(89, 1727666.5d), new SarosData(90, 1672384.5d), new SarosData(91, 1663200.5d), new SarosData(92, 1693529.5d), new SarosData(93, 1710685.5d), new SarosData(94, 1714672.5d), new SarosData(95, 1738415.5d), new SarosData(96, 1755572.5d), new SarosData(97, 1766144.5d), new SarosData(98, 1789887.5d), new SarosData(99, 1807044.5d), new SarosData(100, 1817616.5d), new SarosData(101, 1841359.5d), new SarosData(102, 1858516.5d), new SarosData(103, 1862502.5d), new SarosData(104, 1892831.5d), new SarosData(105, 1903402.5d), new SarosData(106, 1887633.5d), new SarosData(107, 1924547.5d), new SarosData(108, 1921948.5d), new SarosData(109, 1873251.5d), new SarosData(110, 1890409.5d), new SarosData(111, 1914151.5d), new SarosData(112, 1918138.5d), new SarosData(113, 1935296.5d), new SarosData(114, 1959038.5d), new SarosData(115, 1963024.5d), new SarosData(116, 1986767.5d), new SarosData(117, 2010510.5d), new SarosData(118, 2014496.5d), new SarosData(119, 2031654.5d), new SarosData(120, 2061982.5d), new SarosData(121, 2065968.5d), new SarosData(122, 2083126.5d), new SarosData(123, 2113454.5d), new SarosData(124, 2104269.5d), new SarosData(125, 2108256.5d), new SarosData(126, 2151755.5d), new SarosData(127, 2083302.5d), new SarosData(128, 2080704.5d), new SarosData(SwissephException.INVALID_FILE_ERROR, 2124203.5d), new SarosData(130, 2121603.5d), new SarosData(131, 2132176.5d), new SarosData(132, 2162504.5d), new SarosData(133, 2166490.5d), new SarosData(134, 2177062.5d), new SarosData(135, 2207390.5d), new SarosData(136, 2217962.5d), new SarosData(137, 2228534.5d), new SarosData(138, 2258862.5d), new SarosData(139, 2269434.5d), new SarosData(140, 2273421.5d), new SarosData(141, 2310334.5d), new SarosData(142, 2314320.5d), new SarosData(143, 2311722.5d), new SarosData(144, 2355221.5d), new SarosData(145, 2319695.5d), new SarosData(146, 2284169.5d), new SarosData(147, 2314498.5d), new SarosData(148, 2325069.5d), new SarosData(149, 2329056.5d), new SarosData(150, 2352799.5d), new SarosData(151, 2369956.5d), new SarosData(152, 2380528.5d), new SarosData(153, 2404271.5d), new SarosData(154, 2421428.5d), new SarosData(155, 2425414.5d), new SarosData(156, 2455743.5d), new SarosData(157, 2472900.5d), new SarosData(158, 2476886.5d), new SarosData(159, 2500629.5d), new SarosData(160, 2517786.5d), new SarosData(161, 2515187.5d), new SarosData(162, 2545516.5d), new SarosData(163, 2556087.5d), new SarosData(164, 2487635.5d), new SarosData(165, 2504793.5d), new SarosData(166, 2535121.5d), new SarosData(167, 2525936.5d), new SarosData(168, 2543094.5d), new SarosData(169, 2573422.5d), new SarosData(170, 2577408.5d), new SarosData(171, 2594566.5d), new SarosData(172, 2624894.5d), new SarosData(173, 2628880.5d), new SarosData(174, 2646038.5d), new SarosData(175, 2669780.5d), new SarosData(176, 2673766.5d), new SarosData(177, 2690924.5d), new SarosData(178, 2721252.5d), new SarosData(179, 2718653.5d), new SarosData(180, 2729226.5d)};
        saros_data_solar = sarosDataArr;
        NSAROS_SOLAR = sarosDataArr.length;
        SarosData[] sarosDataArr2 = {new SarosData(1, 782437.5d), new SarosData(2, 799593.5d), new SarosData(3, 783824.5d), new SarosData(4, 754884.5d), new SarosData(5, 824724.5d), new SarosData(6, 762857.5d), new SarosData(7, 773430.5d), new SarosData(8, 810343.5d), new SarosData(9, 807743.5d), new SarosData(10, 824901.5d), new SarosData(11, 855229.5d), new SarosData(12, 859215.5d), new SarosData(13, 876373.5d), new SarosData(14, 906701.5d), new SarosData(15, 910687.5d), new SarosData(16, 927845.5d), new SarosData(17, 958173.5d), new SarosData(18, 962159.5d), new SarosData(19, 979317.5d), new SarosData(20, 1009645.5d), new SarosData(21, 1007046.5d), new SarosData(22, 1017618.5d), new SarosData(23, 1054531.5d), new SarosData(24, 979493.5d), new SarosData(25, 976895.5d), new SarosData(26, 1020394.5d), new SarosData(27, 1017794.5d), new SarosData(28, 1028367.5d), new SarosData(29, 1058695.5d), new SarosData(30, 1062681.5d), new SarosData(31, 1073253.5d), new SarosData(32, 1110167.5d), new SarosData(33, 1114153.5d), new SarosData(34, 1131311.5d), new SarosData(35, 1161639.5d), new SarosData(36, 1165625.5d), new SarosData(37, 1176197.5d), new SarosData(38, 1213111.5d), new SarosData(39, 1217097.5d), new SarosData(40, 1221084.5d), new SarosData(41, 1257997.5d), new SarosData(42, 1255398.5d), new SarosData(43, 1186946.5d), new SarosData(44, 1283128.5d), new SarosData(45, 1227845.5d), new SarosData(46, 1225247.5d), new SarosData(47, 1255575.5d), new SarosData(48, 1272732.5d), new SarosData(49, 1276719.5d), new SarosData(50, 1307047.5d), new SarosData(51, 1317619.5d), new SarosData(52, 1328191.5d), new SarosData(53, 1358519.5d), new SarosData(54, 1375676.5d), new SarosData(55, 1379663.5d), new SarosData(56, 1409991.5d), new SarosData(57, 1420562.5d), new SarosData(58, 1424549.5d), new SarosData(59, 1461463.5d), new SarosData(60, 1465449.5d), new SarosData(61, 1436509.5d), new SarosData(62, 1493179.5d), new SarosData(63, 1457653.5d), new SarosData(64, 1435298.5d), new SarosData(65, 1452456.5d), new SarosData(66, 1476198.5d), new SarosData(67, 1480184.5d), new SarosData(68, 1503928.5d), new SarosData(69, 1527670.5d), new SarosData(70, 1531656.5d), new SarosData(71, 1548814.5d), new SarosData(72, 1579142.5d), new SarosData(73, 1583128.5d), new SarosData(74, 1600286.5d), new SarosData(75, 1624028.5d), new SarosData(76, 1628015.5d), new SarosData(77, 1651758.5d), new SarosData(78, 1675500.5d), new SarosData(79, 1672901.5d), new SarosData(80, 1683474.5d), new SarosData(81, 1713801.5d), new SarosData(82, 1645349.5d), new SarosData(83, 1649336.5d), new SarosData(84, 1686249.5d), new SarosData(85, 1683650.5d), new SarosData(86, 1694222.5d), new SarosData(87, 1731136.5d), new SarosData(88, 1735122.5d), new SarosData(89, 1745694.5d), new SarosData(90, 1776022.5d), new SarosData(91, 1786594.5d), new SarosData(92, 1797166.5d), new SarosData(93, 1827494.5d), new SarosData(94, 1838066.5d), new SarosData(95, 1848638.5d), new SarosData(96, 1878966.5d), new SarosData(97, 1882952.5d), new SarosData(98, 1880354.5d), new SarosData(99, 1923853.5d), new SarosData(100, 1881741.5d), new SarosData(101, 1852801.5d), new SarosData(102, 1889715.5d), new SarosData(103, 1893701.5d), new SarosData(104, 1897688.5d), new SarosData(105, 1928016.5d), new SarosData(106, 1938588.5d), new SarosData(107, 1942575.5d), new SarosData(108, 1972903.5d), new SarosData(109, 1990059.5d), new SarosData(110, 1994046.5d), new SarosData(111, 2024375.5d), new SarosData(112, 2034946.5d), new SarosData(113, 2045518.5d), new SarosData(114, 2075847.5d), new SarosData(115, 2086418.5d), new SarosData(116, 2083820.5d), new SarosData(117, 2120733.5d), new SarosData(118, 2124719.5d), new SarosData(119, 2062852.5d), new SarosData(120, 2086596.5d), new SarosData(121, 2103752.5d), new SarosData(122, 2094568.5d), new SarosData(123, 2118311.5d), new SarosData(124, 2142054.5d), new SarosData(125, 2146040.5d), new SarosData(126, 2169783.5d), new SarosData(127, 2186940.5d), new SarosData(128, 2197512.5d), new SarosData(SwissephException.INVALID_FILE_ERROR, 2214670.5d), new SarosData(130, 2238412.5d), new SarosData(131, 2242398.5d), new SarosData(132, 2266142.5d), new SarosData(133, 2289884.5d), new SarosData(134, 2287285.5d), new SarosData(135, 2311028.5d), new SarosData(136, 2334770.5d), new SarosData(137, 2292659.5d), new SarosData(138, 2276890.5d), new SarosData(139, 2326974.5d), new SarosData(140, 2304619.5d), new SarosData(141, 2308606.5d), new SarosData(142, 2345520.5d), new SarosData(143, 2349506.5d), new SarosData(144, 2360078.5d), new SarosData(145, 2390406.5d), new SarosData(146, 2394392.5d), new SarosData(147, 2411550.5d), new SarosData(148, 2441878.5d), new SarosData(149, 2445864.5d), new SarosData(150, 2456437.5d), new SarosData(151, 2486765.5d), new SarosData(152, 2490751.5d), new SarosData(153, 2501323.5d), new SarosData(154, 2538236.5d), new SarosData(155, 2529052.5d), new SarosData(156, 2473771.5d), new SarosData(157, 2563367.5d), new SarosData(158, 2508085.5d), new SarosData(159, 2505486.5d), new SarosData(160, 2542400.5d), new SarosData(161, 2546386.5d), new SarosData(162, 2556958.5d), new SarosData(163, 2587287.5d), new SarosData(164, 2597858.5d), new SarosData(165, 2601845.5d), new SarosData(166, 2632173.5d), new SarosData(167, 2649330.5d), new SarosData(168, 2653317.5d), new SarosData(169, 2683645.5d), new SarosData(170, 2694217.5d), new SarosData(171, 2698203.5d), new SarosData(172, 2728532.5d), new SarosData(173, 2739103.5d), new SarosData(174, 2683822.5d), new SarosData(175, 2740492.5d), new SarosData(176, 2724722.5d), new SarosData(177, 2708952.5d), new SarosData(178, 2732695.5d), new SarosData(179, 2749852.5d), new SarosData(180, 2753839.5d)};
        saros_data_lunar = sarosDataArr2;
        NSAROS_LUNAR = sarosDataArr2.length;
    }

    private double log10(double d) {
        return SMath.log(d) / lnlog;
    }

    Swecl() {
        this((SwissEph) null, (SwissLib) null, (Swemmoon) null, (SwissData) null);
        this.sw = new SwissEph();
        this.sl = new SwissLib();
        this.sm = new Swemmoon();
        this.swed = new SwissData();
    }

    Swecl(SwissEph swissEph, SwissLib swissLib, Swemmoon swemmoon, SwissData swissData) {
        this.sw = null;
        this.sl = null;
        this.sm = null;
        this.swed = null;
        this.const_lapse_rate = 0.0065d;
        this.sw = swissEph;
        this.sl = swissLib;
        this.sm = swemmoon;
        this.swed = swissData;
        if (swissEph == null) {
            this.sw = new SwissEph();
        }
        if (swissLib == null) {
            this.sl = new SwissLib();
        }
        if (swemmoon == null) {
            this.sm = new Swemmoon();
        }
        if (swissData == null) {
            this.swed = new SwissData();
        }
    }

    /* access modifiers changed from: package-private */
    public int swe_sol_eclipse_where(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        double[] dArr3 = new double[10];
        int i2 = i & 7;
        int eclipse_where = eclipse_where(d, 0, (StringBuffer) null, i2, dArr, dArr3, stringBuffer);
        if (eclipse_where < 0) {
            return eclipse_where;
        }
        int eclipse_how = eclipse_how(d, 0, (StringBuffer) null, i2, dArr[0], dArr[1], 0.0d, dArr2, stringBuffer);
        if (eclipse_how == -1) {
            return eclipse_how;
        }
        dArr2[3] = dArr3[0];
        return eclipse_where;
    }

    /* access modifiers changed from: package-private */
    public int swe_lun_occult_where(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, double[] dArr2, StringBuffer stringBuffer2) {
        int i3;
        double[] dArr3 = new double[10];
        int i4 = i2 & 7;
        int i5 = i;
        if (i5 == 144340) {
            i3 = 9;
        } else {
            i3 = i5;
        }
        int eclipse_where = eclipse_where(d, i3, stringBuffer, i4, dArr, dArr3, stringBuffer2);
        if (eclipse_where < 0) {
            return eclipse_where;
        }
        int eclipse_how = eclipse_how(d, i3, stringBuffer, i4, dArr[0], dArr[1], 0.0d, dArr2, stringBuffer2);
        if (eclipse_how == -1) {
            return eclipse_how;
        }
        dArr2[3] = dArr3[0];
        return eclipse_where;
    }

    private int eclipse_where(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, double[] dArr2, StringBuffer stringBuffer2) {
        int i3;
        double d2;
        double d3;
        double d4;
        boolean z;
        int i4;
        double sqrt;
        double sqrt2;
        double sqrt3;
        double d5;
        double d6;
        int i5;
        double d7;
        boolean z2;
        int i6;
        double d8;
        double d9;
        double[] dArr3;
        double[] dArr4;
        Swecl swecl = this;
        double d10 = d;
        int i7 = i;
        StringBuffer stringBuffer3 = stringBuffer2;
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        double[] dArr8 = new double[6];
        double[] dArr9 = new double[6];
        double[] dArr10 = new double[6];
        double[] dArr11 = new double[6];
        double[] dArr12 = new double[6];
        double[] dArr13 = new double[6];
        double[] dArr14 = new double[6];
        double[] dArr15 = new double[6];
        Epsilon epsilon = swecl.swed.oec;
        double[] dArr16 = new double[6];
        int i8 = 0;
        while (i8 < 10) {
            dArr2[i8] = 0.0d;
            i8++;
            StringBuffer stringBuffer4 = stringBuffer2;
        }
        int i9 = i2 | 2304;
        int i10 = i9 | 8192;
        int i11 = i9 | 4096;
        double deltaT = d10 + SweDate.getDeltaT(d);
        double[] dArr17 = dArr13;
        double[] dArr18 = dArr11;
        double[] dArr19 = dArr12;
        double d11 = deltaT;
        double[] dArr20 = dArr14;
        double[] dArr21 = dArr15;
        double[] dArr22 = dArr6;
        double[] dArr23 = dArr16;
        int i12 = i11;
        double[] dArr24 = dArr10;
        double[] dArr25 = dArr9;
        double[] dArr26 = dArr8;
        int swe_calc = swecl.sw.swe_calc(deltaT, 1, i12, dArr7, stringBuffer2);
        if (swe_calc == -1) {
            return swe_calc;
        }
        double[] dArr27 = dArr5;
        int swe_calc2 = swecl.sw.swe_calc(d11, 1, i10, dArr17, stringBuffer2);
        if (swe_calc2 == -1) {
            return swe_calc2;
        }
        double[] dArr28 = dArr7;
        int calc_planet_star = calc_planet_star(d11, i, stringBuffer, i12, dArr26, stringBuffer2);
        if (calc_planet_star == -1) {
            return calc_planet_star;
        }
        int calc_planet_star2 = calc_planet_star(d11, i, stringBuffer, i10, dArr21, stringBuffer2);
        if (calc_planet_star2 == -1) {
            return calc_planet_star2;
        }
        int i13 = 0;
        while (true) {
            i3 = 2;
            if (i13 > 2) {
                break;
            }
            dArr24[i13] = dArr26[i13];
            i13++;
        }
        double[] dArr29 = dArr26;
        for (int i14 = 0; i14 <= 2; i14++) {
            dArr25[i14] = dArr28[i14];
        }
        double[] dArr30 = dArr28;
        if ((i12 & 64) != 0) {
            d2 = swecl.sl.swe_sidtime0(d, epsilon.eps * 57.2957795130823d, 0.0d) * 15.0d * 0.0174532925199433d;
        } else {
            d2 = swecl.sl.swe_sidtime(d10) * 15.0d * 0.0174532925199433d;
        }
        double d12 = 2.0d;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            d3 = 0.0d;
            i4 = 0;
            z = false;
            d4 = 0.9966471803021038d;
        } else if (i7 < 21) {
            d3 = (SwephData.pla_diam[i7] / 2.0d) / 1.4959787066E11d;
            i4 = 0;
            z = false;
            d4 = 0.9966471803021038d;
        } else if (i7 > 10000) {
            d3 = ((swecl.swed.ast_diam / 2.0d) * 1000.0d) / 1.4959787066E11d;
            i4 = 0;
            z = false;
            d4 = 0.9966471803021038d;
        } else {
            d3 = 0.0d;
            i4 = 0;
            z = false;
            d4 = 0.9966471803021038d;
        }
        while (true) {
            for (int i15 = 0; i15 <= i3; i15++) {
                dArr29[i15] = dArr24[i15];
                dArr30[i15] = dArr25[i15];
            }
            for (int i16 = 0; i16 <= i3; i16++) {
                dArr23[i16] = dArr17[i16];
            }
            swecl.sl.swi_polcart(dArr23, dArr30);
            dArr30[i3] = dArr30[i3] / d4;
            double sqrt4 = SMath.sqrt(swecl.sl.square_sum(dArr30));
            for (int i17 = 0; i17 <= i3; i17++) {
                dArr23[i17] = dArr21[i17];
            }
            swecl.sl.swi_polcart(dArr23, dArr29);
            dArr29[i3] = dArr29[i3] / d4;
            for (int i18 = 0; i18 <= i3; i18++) {
                dArr27[i18] = dArr30[i18] - dArr29[i18];
                dArr22[i18] = dArr25[i18] - dArr24[i18];
            }
            double[] dArr31 = dArr27;
            double sqrt5 = SMath.sqrt(swecl.sl.square_sum(dArr31));
            double[] dArr32 = dArr22;
            sqrt = SMath.sqrt(swecl.sl.square_sum(dArr32));
            for (int i19 = 0; i19 <= i3; i19++) {
                dArr31[i19] = dArr31[i19] / sqrt5;
                dArr32[i19] = dArr32[i19] / sqrt;
            }
            double d13 = (d3 - RMOON) / sqrt5;
            sqrt2 = SMath.sqrt(1.0d - (d13 * d13));
            double d14 = (d3 + RMOON) / sqrt5;
            sqrt3 = SMath.sqrt(1.0d - (d14 * d14));
            double d15 = -swecl.sw.dot_prod(dArr30, dArr31);
            double d16 = sqrt4 * sqrt4;
            double d17 = d15 * d15;
            double sqrt6 = SMath.sqrt(d16 - d17);
            double d18 = d15 / sqrt5;
            double d19 = d3 * d12;
            d5 = d19 - DMOON;
            double d20 = ((d18 * d5) - DMOON) / sqrt2;
            d6 = d19 + DMOON;
            double d21 = ((d18 * d6) + DMOON) / sqrt3;
            dArr2[2] = sqrt6;
            dArr2[3] = d20;
            dArr2[4] = d21;
            dArr2[5] = sqrt2;
            dArr2[6] = sqrt3;
            for (int i20 = 2; i20 < 5; i20++) {
                dArr2[i20] = dArr2[i20] * 1.4959787066E8d;
            }
            double d22 = REARTH * sqrt2;
            if (d22 >= sqrt6) {
                StringBuffer stringBuffer5 = stringBuffer2;
                i5 = i4;
                z2 = z;
                d8 = d11;
                i6 = 1;
                d7 = 2.0d;
            } else {
                d7 = 2.0d;
                if (sqrt6 <= d22 + (SMath.abs(d20) / 2.0d)) {
                    StringBuffer stringBuffer6 = stringBuffer2;
                    i5 = i4;
                    z2 = z;
                    d8 = d11;
                    i6 = 2;
                } else if (sqrt6 <= (REARTH * sqrt3) + (d21 / 2.0d)) {
                    StringBuffer stringBuffer7 = stringBuffer2;
                    i5 = i4;
                    z2 = z;
                    d8 = d11;
                    i6 = 18;
                } else {
                    StringBuffer stringBuffer8 = stringBuffer2;
                    if (stringBuffer8 != null) {
                        stringBuffer8.setLength(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append("no solar eclipse at tjd = ");
                        i5 = i4;
                        d8 = d11;
                        sb.append(d8);
                        stringBuffer8.append(sb.toString());
                    } else {
                        i5 = i4;
                        d8 = d11;
                    }
                    for (int i21 = 0; i21 < 10; i21++) {
                        dArr[i21] = 0.0d;
                    }
                    dArr2[0] = 0.0d;
                    i6 = 0;
                    z2 = true;
                }
            }
            double d23 = (d17 + 1.8177630519854536E-9d) - d16;
            if (d23 > 0.0d) {
                d9 = SMath.sqrt(d23);
            } else {
                d9 = 0.0d;
            }
            double d24 = d15 - d9;
            int i22 = 0;
            while (i22 <= 2) {
                dArr20[i22] = dArr30[i22] + (dArr31[i22] * d24);
                i22++;
                StringBuffer stringBuffer9 = stringBuffer2;
            }
            dArr3 = dArr20;
            for (int i23 = 0; i23 <= 2; i23++) {
                dArr18[i23] = dArr3[i23];
            }
            dArr4 = dArr18;
            dArr4[2] = dArr4[2] * d4;
            this.sl.swi_cartpol(dArr4, dArr4);
            if (i5 > 0) {
                break;
            }
            double cos = SMath.cos(dArr4[1]);
            double sin = SMath.sin(dArr4[1]);
            d4 = 0.9933056020041341d * (1.0d / SMath.sqrt((cos * cos) + ((0.9933056020041341d * sin) * sin)));
            dArr20 = dArr3;
            d11 = d8;
            i4 = i5 + 1;
            dArr18 = dArr4;
            dArr27 = dArr31;
            dArr22 = dArr32;
            z = z2;
            d12 = d7;
            i3 = 2;
            swecl = this;
        }
        this.sl.swi_polcart(dArr4, dArr4);
        this.sl.swi_cartpol(dArr3, dArr3);
        dArr3[0] = dArr3[0] - d2;
        dArr3[0] = dArr3[0] * 57.2957795130823d;
        dArr3[1] = dArr3[1] * 57.2957795130823d;
        dArr3[0] = this.sl.swe_degnorm(dArr3[0]);
        if (dArr3[0] > 180.0d) {
            dArr3[0] = dArr3[0] - 360.0d;
        }
        dArr[0] = dArr3[0];
        dArr[1] = dArr3[1];
        for (int i24 = 0; i24 <= 2; i24++) {
            dArr19[i24] = dArr25[i24] - dArr4[i24];
        }
        double sqrt7 = SMath.sqrt(this.sl.square_sum(dArr19)) / sqrt;
        dArr2[0] = ((d5 * sqrt7) - DMOON) * sqrt2;
        dArr2[0] = dArr2[0] * 1.4959787066E8d;
        dArr2[1] = ((sqrt7 * d6) + DMOON) * sqrt3;
        dArr2[1] = dArr2[1] * 1.4959787066E8d;
        if ((i6 & 16) != 0 || z2) {
            return i6;
        }
        if (dArr2[0] > 0.0d) {
            return i6 | 8;
        }
        return i6 | 4;
    }

    private int calc_planet_star(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, StringBuffer stringBuffer2) {
        if (stringBuffer == null || stringBuffer.length() == 0) {
            return this.sw.swe_calc(d, i, i2, dArr, stringBuffer2);
        }
        int swe_fixstar = this.sw.swe_fixstar(stringBuffer, d, i2, dArr, stringBuffer2);
        if (swe_fixstar != 0) {
            return swe_fixstar;
        }
        if ((i2 & 4096) != 0) {
            for (int i3 = 0; i3 < 3; i3++) {
                dArr[i3] = dArr[i3] * 1.0E8d;
            }
            return swe_fixstar;
        }
        dArr[2] = dArr[2] * 1.0E8d;
        return swe_fixstar;
    }

    /* access modifiers changed from: package-private */
    public int swe_sol_eclipse_how(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        int i2;
        double[] dArr3 = new double[10];
        int i3 = i & 7;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[20];
        double[] dArr6 = new double[6];
        int eclipse_how = eclipse_how(d, 0, (StringBuffer) null, i3, dArr[0], dArr[1], dArr[2], dArr2, stringBuffer);
        if (eclipse_how == -1) {
            return eclipse_how;
        }
        int eclipse_where = eclipse_where(d, 0, (StringBuffer) null, i3, dArr5, dArr3, stringBuffer);
        if (eclipse_where == -1) {
            return eclipse_where;
        }
        if (eclipse_how != 0) {
            i2 = eclipse_how | (eclipse_where & 3);
        } else {
            i2 = eclipse_how;
        }
        dArr2[3] = dArr3[0];
        this.sw.swe_set_topo(dArr[0], dArr[1], dArr[2]);
        if (this.sw.swe_calc_ut(d, 0, i3 | 32768 | 2048, dArr6, stringBuffer) == -1) {
            return -1;
        }
        swe_azalt(d, 1, dArr, 0.0d, 10.0d, dArr6, dArr4);
        dArr2[4] = dArr4[0];
        dArr2[5] = dArr4[1];
        dArr2[6] = dArr4[2];
        if (dArr4[2] <= 0.0d) {
            return 0;
        }
        return i2;
    }

    private int eclipse_how(double d, int i, StringBuffer stringBuffer, int i2, double d2, double d3, double d4, double[] dArr, StringBuffer stringBuffer2) {
        double d5;
        int i3;
        char c;
        int i4;
        long j;
        double d6 = d;
        int i5 = i;
        StringBuffer stringBuffer3 = stringBuffer2;
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        int i6 = i2 | 34816;
        int i7 = i6 | 4096;
        double[] dArr8 = new double[6];
        double[] dArr9 = new double[3];
        for (int i8 = 0; i8 < 10; i8++) {
            dArr[i8] = 0.0d;
        }
        dArr9[0] = d2;
        dArr9[1] = d3;
        dArr9[2] = d4;
        double deltaT = d6 + SweDate.getDeltaT(d);
        this.sw.swe_set_topo(d2, d3, d4);
        int i9 = i7;
        double[] dArr10 = dArr8;
        int i10 = i6;
        double[] dArr11 = dArr7;
        double[] dArr12 = dArr6;
        double[] dArr13 = dArr5;
        double[] dArr14 = dArr4;
        if (calc_planet_star(deltaT, i, stringBuffer, i10, dArr4, stringBuffer2) == -1 || this.sw.swe_calc(deltaT, 1, i10, dArr13, stringBuffer2) == -1 || calc_planet_star(deltaT, i, stringBuffer, i9, dArr2, stringBuffer2) == -1 || this.sw.swe_calc(deltaT, 1, i9, dArr3, stringBuffer2) == -1) {
            return -1;
        }
        if (stringBuffer != null && stringBuffer.length() > 0) {
            d5 = 0.0d;
        } else if (i5 < 21) {
            d5 = (SwephData.pla_diam[i5] / 2.0d) / 1.4959787066E11d;
        } else if (i5 > 10000) {
            d5 = ((this.swed.ast_diam / 2.0d) * 1000.0d) / 1.4959787066E11d;
        } else {
            d5 = 0.0d;
        }
        double[] dArr15 = dArr3;
        double[] dArr16 = dArr2;
        swe_azalt(d, 1, dArr9, 0.0d, 10.0d, dArr14, dArr10);
        double asin = SMath.asin(RMOON / dArr13[2]) * 57.2957795130823d;
        double asin2 = SMath.asin(d5 / dArr14[2]) * 57.2957795130823d;
        double d7 = asin2 + asin;
        double d8 = asin2 - asin;
        int i11 = 0;
        while (i11 < 3) {
            double[] dArr17 = dArr12;
            dArr17[i11] = dArr16[i11] / dArr14[2];
            dArr11[i11] = dArr15[i11] / dArr13[2];
            i11++;
            dArr12 = dArr17;
        }
        double acos = SMath.acos(this.sl.swi_dot_prod_unit(dArr12, dArr11)) * 57.2957795130823d;
        if (acos < d8) {
            c = 0;
            i3 = 8;
        } else if (acos < SMath.abs(d8)) {
            c = 0;
            i3 = 4;
        } else if (acos < d7) {
            c = 0;
            i3 = 16;
        } else {
            StringBuffer stringBuffer4 = stringBuffer2;
            c = 0;
            if (stringBuffer4 != null) {
                stringBuffer4.setLength(0);
                stringBuffer4.append("no solar eclipse at tjd = " + d6);
            }
            i3 = 0;
        }
        int i12 = (asin2 > 0.0d ? 1 : (asin2 == 0.0d ? 0 : -1));
        if (i12 > 0) {
            dArr[1] = asin / asin2;
        } else {
            dArr[1] = 0.0d;
        }
        double d9 = (-acos) + asin2 + asin;
        if (SMath.asin((asin2 / 2.0d) * 0.0174532925199433d) * 2.0d > 0.0d) {
            dArr[c] = (d9 / asin2) / 2.0d;
        } else {
            dArr[c] = 100.0d;
        }
        long j2 = 4607182418800017408L;
        if (i3 == 0 || i12 == 0) {
            dArr[2] = 100.0d;
        } else if (i3 == 4 || i3 == 8) {
            dArr[2] = ((asin * asin) / asin2) / asin2;
        } else {
            double d10 = acos * 2.0d;
            double d11 = d10 * asin;
            double d12 = d10 * asin2;
            if (d11 < 1.0E-9d) {
                dArr[2] = ((asin * asin) / asin2) / asin2;
            } else {
                double d13 = acos * acos;
                double d14 = asin * asin;
                double d15 = asin2 * asin2;
                double d16 = ((d13 + d14) - d15) / d11;
                if (d16 > 1.0d) {
                    d16 = 1.0d;
                }
                double d17 = -1.0d;
                if (d16 < -1.0d) {
                    d16 = -1.0d;
                }
                double d18 = ((d13 + d15) - d14) / d12;
                if (d18 > 1.0d) {
                    d18 = 1.0d;
                }
                if (d18 >= -1.0d) {
                    d17 = d18;
                }
                double acos2 = SMath.acos(d16);
                double acos3 = SMath.acos(d17);
                dArr[2] = ((((((((acos2 * asin) * asin) / 2.0d) - ((((SMath.cos(acos2) * SMath.sin(acos2)) * asin) * asin) / 2.0d)) + ((((acos3 * asin2) * asin2) / 2.0d) - ((((SMath.cos(acos3) * SMath.sin(acos3)) * asin2) * asin2) / 2.0d))) * 2.0d) / 3.141592653589793d) / asin2) / asin2;
            }
        }
        dArr[7] = acos;
        if (dArr10[1] + asin2 + SMath.abs((-((SMath.sqrt(d4) * 2.12d) + 34.4556d)) / 60.0d) >= 0.0d && i3 != 0) {
            i3 |= 128;
        }
        dArr[4] = dArr10[c];
        dArr[5] = dArr10[1];
        dArr[6] = dArr10[2];
        if (i5 == 0 && (stringBuffer == null || stringBuffer.length() == 0)) {
            dArr[8] = dArr[c];
            if ((i3 & 12) != 0) {
                dArr[8] = dArr[1];
            }
            int i13 = 0;
            while (true) {
                i4 = NSAROS_SOLAR;
                if (i13 >= i4) {
                    break;
                }
                SarosData[] sarosDataArr = saros_data_solar;
                double d19 = (d6 - sarosDataArr[i13].tstart) / SAROS_CYCLE;
                if (d19 < 0.0d) {
                    j = j2;
                } else {
                    int i14 = (int) d19;
                    double d20 = (double) i14;
                    if ((d19 - d20) * SAROS_CYCLE < 2.0d) {
                        dArr[9] = (double) sarosDataArr[i13].series_no;
                        dArr[10] = d20 + 1.0d;
                        break;
                    }
                    double d21 = (double) (i14 + 1);
                    if ((d21 - d19) * SAROS_CYCLE < 2.0d) {
                        dArr[9] = (double) sarosDataArr[i13].series_no;
                        dArr[10] = d21 + 1.0d;
                        break;
                    }
                    j = 4607182418800017408L;
                }
                i13++;
                j2 = j;
            }
            if (i13 == i4) {
                dArr[10] = -9.9999999E7d;
                dArr[9] = -9.9999999E7d;
            }
        }
        return i3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v12, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v13, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v14, resolved type: double} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0742, code lost:
        if (r7 >= 2) goto L_0x078f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0744, code lost:
        r0 = r7 + 2;
        r19 = r71[r0] + swisseph.SweDate.getDeltaT(r71[r0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x075f, code lost:
        if (r14.sw.swe_calc(r19, 0, r37, r47, r73) != -1) goto L_0x0762;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0761, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0771, code lost:
        if (r14.sw.swe_calc(r19, 1, r37, r31, r73) != -1) goto L_0x0774;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0773, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0774, code lost:
        r27[r7] = r14.sl.swe_degnorm(r47[0] - r31[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0785, code lost:
        if (r27[r7] <= 180.0d) goto L_0x078c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0787, code lost:
        r27[r7] = r27[r7] - 360.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x078c, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0798, code lost:
        if ((r27[0] * r27[1]) < 0.0d) goto L_0x079e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x079a, code lost:
        r71[1] = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x079e, code lost:
        r0 = 0.1d;
        r9.val = (r71[3] - r71[2]) / 2.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x07b1, code lost:
        if (r9.val >= 0.1d) goto L_0x07b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x07b3, code lost:
        r0 = r9.val / 2.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x07b7, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x07bf, code lost:
        if (r7 <= 0.01d) goto L_0x0835;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x07c1, code lost:
        r12 = r43;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x07c5, code lost:
        if (r10 > 1) goto L_0x0818;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x07c7, code lost:
        r19 = r12 + swisseph.SweDate.getDeltaT(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x07dc, code lost:
        if (r14.sw.swe_calc(r19, 0, r37, r47, r73) != -1) goto L_0x07df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x07de, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x07ee, code lost:
        if (r14.sw.swe_calc(r19, 1, r37, r31, r73) != -1) goto L_0x07f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x07f0, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x07f1, code lost:
        r27[r10] = r14.sl.swe_degnorm(r47[0] - r31[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0802, code lost:
        if (r27[r10] <= 180.0d) goto L_0x0809;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0804, code lost:
        r27[r10] = r27[r10] - 360.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x080d, code lost:
        if (r27[r10] <= 180.0d) goto L_0x0814;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x080f, code lost:
        r27[r10] = r27[r10] - 360.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0814, code lost:
        r10 = r10 + 1;
        r12 = r12 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0818, code lost:
        r1 = (r27[1] - r27[0]) / r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0826, code lost:
        if (r1 >= 1.0E-10d) goto L_0x0829;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0829, code lost:
        r9.val = r27[0] / r1;
        r43 = r43 + r9.val;
        r7 = r7 / 3.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0835, code lost:
        r71[1] = r43;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_sol_eclipse_when_glob(double r67, int r69, int r70, double[] r71, int r72, java.lang.StringBuffer r73) {
        /*
            r66 = this;
            r14 = r66
            r0 = r70
            r15 = r73
            swisseph.DblObj r13 = new swisseph.DblObj
            r13.<init>()
            r12 = 6
            double[] r11 = new double[r12]
            double[] r10 = new double[r12]
            double[] r9 = new double[r12]
            double[] r7 = new double[r12]
            r1 = 10
            double[] r8 = new double[r1]
            r6 = 3
            double[] r5 = new double[r6]
            swisseph.DblObj r16 = new swisseph.DblObj
            r16.<init>()
            swisseph.DblObj r4 = new swisseph.DblObj
            r1 = 0
            r4.<init>(r1)
            swisseph.DblObj r3 = new swisseph.DblObj
            r3.<init>(r1)
            r6 = 20
            r18 = r3
            double[] r3 = new double[r6]
            double[] r6 = new double[r6]
            r19 = r3
            double[] r3 = new double[r12]
            r20 = r3
            double[] r3 = new double[r12]
            r21 = 7
            r22 = r3
            r3 = r69 & 7
            r1 = r3 | 2048(0x800, float:2.87E-42)
            r2 = r1 | 4096(0x1000, float:5.74E-42)
            r69 = r3
            r3 = 0
            r12 = 17
            if (r0 != r12) goto L_0x005f
            if (r15 == 0) goto L_0x005d
            r15.setLength(r3)
            java.lang.String r0 = "central partial eclipses do not exist"
            r15.append(r0)
        L_0x005d:
            r12 = -1
            return r12
        L_0x005f:
            r12 = -1
            if (r0 != 0) goto L_0x0067
            r0 = 63
            r25 = 63
            goto L_0x0069
        L_0x0067:
            r25 = r0
        L_0x0069:
            if (r72 == 0) goto L_0x006d
            r0 = -1
            goto L_0x006e
        L_0x006d:
            r0 = 1
        L_0x006e:
            r27 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            double r27 = r67 - r27
            r29 = 4645133030202938491(0x4076d3e147ae147b, double:365.2425)
            double r27 = r27 / r29
            r29 = 4623152464553649897(0x4028bcac083126e9, double:12.3685)
            r31 = r4
            double r3 = r27 * r29
            int r3 = (int) r3
            double r3 = (double) r3
            r28 = r13
            double r12 = (double) r0
            double r3 = r3 - r12
            r29 = r3
            r33 = 0
            r34 = 0
        L_0x0091:
            r0 = 0
        L_0x0094:
            r3 = 9
            if (r0 > r3) goto L_0x009f
            r3 = 0
            r71[r0] = r3
            int r0 = r0 + 1
            goto L_0x0094
        L_0x009f:
            r3 = 0
            r23 = 4653154539273610854(0x4093536666666666, double:1236.85)
            double r23 = r29 / r23
            double r35 = r23 * r23
            double r37 = r35 * r23
            double r39 = r37 * r23
            swisseph.SwissLib r0 = r14.sl
            r41 = 4639858525150134246(0x406416bedfa43fe6, double:160.7108)
            r43 = 4645580364357878491(0x40786aba6114c2db, double:390.67050274)
            double r43 = r43 * r29
            double r43 = r43 + r41
            r41 = 4565178779021654147(0x3f5ac5e983bcb883, double:0.0016341)
            double r41 = r41 * r35
            double r43 = r43 - r41
            r41 = 4522470312210664535(0x3ec30ac9b2910c57, double:2.27E-6)
            double r41 = r41 * r37
            double r43 = r43 - r41
            r41 = 4487730721241523980(0x3e479f505f35670c, double:1.1E-8)
            double r41 = r41 * r39
            double r3 = r43 + r41
            double r3 = r0.swe_degnorm(r3)
            r41 = 4640537203540230144(0x4066800000000000, double:180.0)
            int r0 = (r3 > r41 ? 1 : (r3 == r41 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e8
            double r3 = r3 - r41
        L_0x00e8:
            r43 = 4626604192193052672(0x4035000000000000, double:21.0)
            int r0 = (r3 > r43 ? 1 : (r3 == r43 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fa
            r43 = 4639798331726364672(0x4063e00000000000, double:159.0)
            int r0 = (r3 > r43 ? 1 : (r3 == r43 ? 0 : -1))
            if (r0 >= 0) goto L_0x00fa
            double r29 = r29 + r12
            goto L_0x0091
        L_0x00fa:
            r3 = 4702519075094383506(0x4142b42f0c7fcb92, double:2451550.09765)
            r43 = 4629005339491779029(0x403d87d4abcb41d5, double:29.530588853)
            double r43 = r43 * r29
            double r43 = r43 + r3
            r3 = 4549064683382140398(0x3f21863a41446dee, double:1.337E-4)
            double r3 = r3 * r35
            double r43 = r43 + r3
            r3 = 4504762867522569078(0x3e8421f5f40d8376, double:1.5E-7)
            double r3 = r3 * r37
            double r43 = r43 - r3
            r3 = 4470127357510710970(0x3e091525dd2e76ba, double:7.3E-10)
            double r3 = r3 * r39
            double r43 = r43 + r3
            swisseph.SwissLib r0 = r14.sl
            r3 = 4612932164444281320(0x40046d5cfaacd9e8, double:2.5534)
            r47 = 4628885647278601982(0x403d1af8a7f1f6fe, double:29.10535669)
            double r47 = r47 * r29
            double r47 = r47 + r3
            r3 = 4537055449467628868(0x3ef6dbe497c4ad44, double:2.18E-5)
            double r3 = r3 * r35
            double r47 = r47 - r3
            r3 = 4502903793125605584(0x3e7d87247702c0d0, double:1.1E-7)
            double r3 = r3 * r37
            double r3 = r47 - r3
            double r3 = r0.swe_degnorm(r3)
            swisseph.SwissLib r0 = r14.sl
            r47 = 4641295929895265344(0x4069320ebedfa440, double:201.5643)
            r49 = 4645494979496143047(0x40781d122aba68c7, double:385.81693528)
            double r49 = r49 * r29
            double r49 = r49 + r47
            r47 = 4591995834099441060(0x3fba0be1b5921da4, double:0.1017438)
            double r47 = r47 * r35
            double r49 = r49 + r47
            r47 = 4533431390597692843(0x3ee9fbd4a22e3dab, double:1.239E-5)
            double r37 = r37 * r47
            double r49 = r49 + r37
            r37 = 4498853540680590574(0x3e6f237594c664ee, double:5.8E-8)
            double r39 = r39 * r37
            r37 = r1
            r38 = r2
            double r1 = r49 + r39
            double r0 = r0.swe_degnorm(r1)
            r39 = 4567947923537494102(0x3f649c6f36ef8056, double:0.002516)
            double r23 = r23 * r39
            r39 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r23 = r39 - r23
            r47 = 4530350403873286828(0x3edf09b082ea2aac, double:7.4E-6)
            double r35 = r35 * r47
            double r23 = r23 - r35
            r35 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r3 = r3 * r35
            double r0 = r0 * r35
            r35 = 4601012487310519828(0x3fda147ae147ae14, double:0.4075)
            double r0 = swisseph.SMath.sin(r0)
            double r0 = r0 * r35
            double r43 = r43 - r0
            r0 = 4595368576257499123(0x3fc6075f6fd21ff3, double:0.1721)
            double r23 = r23 * r0
            double r0 = swisseph.SMath.sin(r3)
            double r23 = r23 * r0
            double r43 = r43 + r23
            r0 = 4701340746312056832(0x413e848000000000, double:2000000.0)
            int r2 = (r43 > r0 ? 1 : (r43 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x01c1
            r39 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x01c1:
            r23 = 4616189618054758400(0x4010000000000000, double:4.0)
        L_0x01c4:
            r35 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            r4 = 2
            int r0 = (r39 > r35 ? 1 : (r39 == r35 ? 0 : -1))
            if (r0 <= 0) goto L_0x02f8
            double r0 = r43 - r39
            r35 = r0
            r3 = 0
        L_0x01d3:
            if (r3 > r4) goto L_0x029f
            swisseph.SwissEph r0 = r14.sw
            r47 = 0
            r1 = 1
            r15 = 1
            r45 = 0
            r1 = r35
            r32 = r3
            r48 = r12
            r15 = r20
            r13 = r22
            r12 = -1
            r20 = r69
            r69 = r18
            r18 = 0
            r3 = r47
            r22 = r31
            r4 = r37
            r27 = r5
            r5 = r9
            r17 = r6
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r12) goto L_0x0202
            return r12
        L_0x0202:
            swisseph.SwissEph r0 = r14.sw
            r3 = 1
            r1 = r35
            r4 = r37
            r5 = r7
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r12) goto L_0x0213
            return r12
        L_0x0213:
            swisseph.SwissEph r0 = r14.sw
            r3 = 0
            r1 = r35
            r4 = r38
            r5 = r11
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r12) goto L_0x0224
            return r12
        L_0x0224:
            swisseph.SwissEph r0 = r14.sw
            r3 = 1
            r1 = r35
            r4 = r38
            r5 = r10
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r12) goto L_0x0235
            return r12
        L_0x0235:
            r3 = 0
        L_0x0236:
            r5 = 3
            if (r3 >= r5) goto L_0x024d
            r0 = r11[r3]
            r6 = 2
            r50 = r9[r6]
            double r0 = r0 / r50
            r15[r3] = r0
            r0 = r10[r3]
            r50 = r7[r6]
            double r0 = r0 / r50
            r13[r3] = r0
            int r3 = r3 + 1
            goto L_0x0236
        L_0x024d:
            r6 = 2
            swisseph.SwissLib r0 = r14.sl
            double r0 = r0.swi_dot_prod_unit(r15, r13)
            double r0 = swisseph.SMath.acos(r0)
            r2 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r0 = r0 * r2
            r27[r32] = r0
            r0 = 4532976163387923579(0x3ee85dcdca0cdc7b, double:1.1618815109677577E-5)
            r50 = r7[r6]
            double r0 = r0 / r50
            double r0 = swisseph.SMath.asin(r0)
            double r0 = r0 * r2
            r50 = 4572013957908023349(0x3f730e789d3c4835, double:0.004652472638342832)
            r52 = r9[r6]
            double r50 = r50 / r52
            double r50 = swisseph.SMath.asin(r50)
            double r50 = r50 * r2
            r2 = r27[r32]
            double r0 = r0 + r50
            double r2 = r2 - r0
            r27[r32] = r2
            int r3 = r32 + 1
            double r35 = r35 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r31 = r22
            r5 = r27
            r4 = 2
            r22 = r13
            r20 = r15
            r12 = r48
            r15 = r73
            goto L_0x01d3
        L_0x029f:
            r27 = r5
            r17 = r6
            r48 = r12
            r15 = r20
            r13 = r22
            r22 = r31
            r5 = 3
            r6 = 2
            r12 = -1
            r45 = 0
            r20 = r69
            r69 = r18
            r18 = 0
            r1 = r27[r18]
            r0 = 1
            r3 = r27[r0]
            r31 = r27[r6]
            r0 = r66
            r5 = r31
            r31 = r7
            r32 = r8
            r7 = r39
            r47 = r9
            r9 = r28
            r50 = r10
            r10 = r16
            r0.find_maximum(r1, r3, r5, r7, r9, r10)
            r10 = r28
            double r0 = r10.val
            double r0 = r0 + r39
            double r43 = r43 + r0
            double r39 = r39 / r23
            r18 = r69
            r6 = r17
            r69 = r20
            r5 = r27
            r7 = r31
            r8 = r32
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r15 = r73
            r22 = r13
            r12 = r48
            goto L_0x01c4
        L_0x02f8:
            r27 = r5
            r17 = r6
            r32 = r8
            r47 = r9
            r50 = r10
            r48 = r12
            r15 = r20
            r13 = r22
            r10 = r28
            r22 = r31
            r6 = 2
            r12 = -1
            r45 = 0
            r20 = r69
            r31 = r7
            r69 = r18
            r18 = 0
            double r0 = swisseph.SweDate.getDeltaT(r43)
            double r43 = r43 - r0
            r3 = 0
            r4 = 0
            r0 = r66
            r1 = r43
            r5 = r20
            r9 = 2
            r6 = r19
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r12) goto L_0x0334
            return r0
        L_0x0334:
            r3 = 0
            r4 = 0
            r6 = r19[r18]
            r0 = 1
            r23 = r19[r0]
            r39 = 0
            r0 = r66
            r1 = r43
            r5 = r20
            r8 = r23
            r23 = r10
            r24 = r11
            r10 = r39
            r39 = r48
            r26 = 6
            r12 = r17
            r28 = r13
            r13 = r73
            int r0 = r0.eclipse_how(r1, r3, r4, r5, r6, r8, r10, r12, r13)
            r11 = -1
            if (r0 != r11) goto L_0x035e
            return r0
        L_0x035e:
            if (r0 != 0) goto L_0x0386
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x0386:
            r71[r18] = r43
            if (r72 == 0) goto L_0x0392
            r0 = r71[r18]
            double r2 = r67 - r35
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x039c
        L_0x0392:
            if (r72 != 0) goto L_0x03c2
            r0 = r71[r18]
            double r2 = r67 + r35
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x03c2
        L_0x039c:
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x03c2:
            r3 = 0
            r4 = 0
            r0 = r66
            r1 = r43
            r5 = r20
            r6 = r19
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x03d7
            return r0
        L_0x03d7:
            r12 = 5
            r13 = 4
            if (r0 != 0) goto L_0x03e5
            r0 = 18
            r71[r12] = r43
            r71[r13] = r43
            r3 = 1
            r35 = 18
            goto L_0x03e8
        L_0x03e5:
            r35 = r0
            r3 = 0
        L_0x03e8:
            r0 = r25 & 2
            if (r0 != 0) goto L_0x0416
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0416
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x0416:
            r0 = r25 & 1
            if (r0 != 0) goto L_0x0444
            r0 = r35 & 1
            if (r0 == 0) goto L_0x0444
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x0444:
            r0 = r25 & 8
            if (r0 != 0) goto L_0x0472
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0472
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x0472:
            r0 = r25 & 16
            if (r0 != 0) goto L_0x04a0
            r0 = r35 & 16
            if (r0 == 0) goto L_0x04a0
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x04a0:
            r0 = r25 & 36
            if (r0 != 0) goto L_0x04ce
            r0 = r35 & 4
            if (r0 == 0) goto L_0x04ce
            double r29 = r29 + r39
            r18 = r69
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r9 = r47
            r10 = r50
            r20 = r15
            r31 = r22
            r22 = r28
            r15 = r73
            r28 = r23
            goto L_0x0091
        L_0x04ce:
            if (r3 == 0) goto L_0x04d2
            goto L_0x0839
        L_0x04d2:
            r36 = r35 & 16
            if (r36 == 0) goto L_0x04d8
            r10 = 0
            goto L_0x04df
        L_0x04d8:
            r0 = r35 & 2
            if (r0 == 0) goto L_0x04de
            r10 = 1
            goto L_0x04df
        L_0x04de:
            r10 = 2
        L_0x04df:
            r48 = 4567484022084677481(0x3f62f684bda12f69, double:0.002314814814814815)
            r9 = 0
        L_0x04e6:
            r51 = 4613937818241073152(0x4008000000000000, double:3.0)
            r55 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r9 > r10) goto L_0x066c
            if (r9 != 0) goto L_0x04f3
            r7 = 3
            r8 = 2
            r33 = 2
            goto L_0x0518
        L_0x04f3:
            r0 = 1
            if (r9 != r0) goto L_0x04ff
            if (r36 == 0) goto L_0x04fa
            r8 = 2
            goto L_0x0507
        L_0x04fa:
            r7 = 5
            r8 = 2
            r33 = 4
            goto L_0x0518
        L_0x04ff:
            r8 = 2
            if (r9 != r8) goto L_0x0516
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0512
        L_0x0507:
            r0 = r9
            r53 = r10
            r9 = r22
            r12 = 3
            r13 = 2
            r10 = r69
            goto L_0x065f
        L_0x0512:
            r7 = 7
            r33 = 6
            goto L_0x0518
        L_0x0516:
            r7 = r34
        L_0x0518:
            r57 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            double r0 = r43 - r57
            r59 = r0
            r6 = 0
        L_0x0522:
            r61 = 4663734853794676081(0x40b8ea23d70a3d71, double:6378.14)
            if (r6 > r8) goto L_0x0584
            r3 = 0
            r4 = 0
            r0 = r66
            r1 = r59
            r5 = r20
            r34 = r6
            r6 = r19
            r63 = r7
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x0542
            return r0
        L_0x0542:
            if (r9 != 0) goto L_0x0556
            r0 = r32[r13]
            double r0 = r0 / r55
            r2 = r32[r12]
            double r61 = r61 / r2
            double r0 = r0 + r61
            r7 = 2
            r2 = r32[r7]
            double r0 = r0 - r2
            r27[r34] = r0
            r8 = 3
            goto L_0x057c
        L_0x0556:
            r7 = 2
            r0 = 1
            if (r9 != r0) goto L_0x056f
            r8 = 3
            r0 = r32[r8]
            double r0 = swisseph.SMath.abs((double) r0)
            double r0 = r0 / r55
            r2 = r32[r26]
            double r61 = r61 / r2
            double r0 = r0 + r61
            r2 = r32[r7]
            double r0 = r0 - r2
            r27[r34] = r0
            goto L_0x057c
        L_0x056f:
            r8 = 3
            if (r9 != r7) goto L_0x057c
            r0 = r32[r26]
            double r61 = r61 / r0
            r0 = r32[r7]
            double r61 = r61 - r0
            r27[r34] = r61
        L_0x057c:
            int r6 = r34 + 1
            double r59 = r59 + r57
            r7 = r63
            r8 = 2
            goto L_0x0522
        L_0x0584:
            r63 = r7
            r7 = 2
            r8 = 3
            r1 = r27[r18]
            r0 = 1
            r3 = r27[r0]
            r5 = r27[r7]
            r53 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            r0 = r66
            r12 = 3
            r13 = 2
            r7 = r53
            r65 = r9
            r9 = r22
            r53 = r10
            r10 = r69
            r0.find_zero(r1, r3, r5, r7, r9, r10)
            double r0 = r9.val
            double r0 = r43 + r0
            double r0 = r0 + r57
            r71[r33] = r0
            double r0 = r10.val
            double r0 = r43 + r0
            double r0 = r0 + r57
            r8 = r63
            r71[r8] = r0
            r57 = r48
            r7 = 0
        L_0x05ba:
            if (r7 >= r12) goto L_0x0659
            r6 = r33
        L_0x05be:
            if (r6 > r8) goto L_0x064d
            r0 = r71[r6]
            double r0 = r0 - r57
            r63 = r0
            r5 = 0
        L_0x05c7:
            if (r5 >= r13) goto L_0x0629
            r3 = 0
            r4 = 0
            r0 = r66
            r1 = r63
            r22 = r5
            r5 = r20
            r34 = r6
            r6 = r19
            r54 = r7
            r7 = r32
            r60 = r8
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x05e6
            return r0
        L_0x05e6:
            r0 = r65
            if (r0 != 0) goto L_0x05fb
            r1 = 4
            r2 = r32[r1]
            double r2 = r2 / r55
            r1 = 5
            r4 = r32[r1]
            double r4 = r61 / r4
            double r2 = r2 + r4
            r4 = r32[r13]
            double r2 = r2 - r4
            r27[r22] = r2
            goto L_0x061c
        L_0x05fb:
            r1 = 1
            if (r0 != r1) goto L_0x0611
            r1 = r32[r12]
            double r1 = swisseph.SMath.abs((double) r1)
            double r1 = r1 / r55
            r3 = r32[r26]
            double r3 = r61 / r3
            double r1 = r1 + r3
            r3 = r32[r13]
            double r1 = r1 - r3
            r27[r22] = r1
            goto L_0x061c
        L_0x0611:
            if (r0 != r13) goto L_0x061c
            r1 = r32[r26]
            double r1 = r61 / r1
            r3 = r32[r13]
            double r1 = r1 - r3
            r27[r22] = r1
        L_0x061c:
            int r5 = r22 + 1
            double r63 = r63 + r57
            r65 = r0
            r6 = r34
            r7 = r54
            r8 = r60
            goto L_0x05c7
        L_0x0629:
            r34 = r6
            r54 = r7
            r60 = r8
            r0 = r65
            r1 = 1
            r2 = r27[r1]
            r4 = r27[r1]
            r6 = r27[r18]
            double r4 = r4 - r6
            double r4 = r4 / r57
            double r2 = r2 / r4
            r9.val = r2
            r1 = r71[r34]
            double r3 = r9.val
            double r1 = r1 - r3
            r71[r34] = r1
            int r7 = r60 - r33
            int r6 = r34 + r7
            r7 = r54
            goto L_0x05be
        L_0x064d:
            r54 = r7
            r60 = r8
            r0 = r65
            int r7 = r54 + 1
            double r57 = r57 / r51
            goto L_0x05ba
        L_0x0659:
            r60 = r8
            r0 = r65
            r34 = r60
        L_0x065f:
            int r0 = r0 + 1
            r22 = r9
            r69 = r10
            r10 = r53
            r12 = 5
            r13 = 4
            r9 = r0
            goto L_0x04e6
        L_0x066c:
            r10 = r69
            r9 = r22
            r12 = 3
            r13 = 2
            r0 = r35 & 4
            if (r0 == 0) goto L_0x06df
            r1 = r71[r18]
            r3 = 0
            r4 = 0
            r0 = r66
            r5 = r20
            r6 = r19
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x068b
            return r0
        L_0x068b:
            r0 = r32[r18]
            r27[r18] = r0
            r0 = 4
            r1 = r71[r0]
            r3 = 0
            r4 = 0
            r0 = r66
            r5 = r20
            r6 = r19
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x06a5
            return r0
        L_0x06a5:
            r0 = r32[r18]
            r2 = 1
            r27[r2] = r0
            r0 = 5
            r1 = r71[r0]
            r3 = 0
            r4 = 0
            r0 = r66
            r5 = r20
            r6 = r19
            r7 = r32
            r8 = r73
            int r0 = r0.eclipse_where(r1, r3, r4, r5, r6, r7, r8)
            if (r0 != r11) goto L_0x06c0
            return r0
        L_0x06c0:
            r0 = r32[r18]
            r27[r13] = r0
            r0 = r27[r18]
            r2 = 1
            r3 = r27[r2]
            double r0 = r0 * r3
            int r2 = (r0 > r45 ? 1 : (r0 == r45 ? 0 : -1))
            if (r2 < 0) goto L_0x06d9
            r0 = r27[r18]
            r2 = r27[r13]
            double r0 = r0 * r2
            int r2 = (r0 > r45 ? 1 : (r0 == r45 ? 0 : -1))
            if (r2 >= 0) goto L_0x06df
        L_0x06d9:
            r0 = r35 | 32
            r0 = r0 & -5
            r35 = r0
        L_0x06df:
            r0 = r25 & 4
            if (r0 != 0) goto L_0x070d
            r0 = r35 & 4
            if (r0 == 0) goto L_0x070d
            double r29 = r29 + r39
            r18 = r10
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r22 = r28
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r10 = r50
            r31 = r9
            r20 = r15
            r28 = r23
            r9 = r47
            r15 = r73
            goto L_0x0091
        L_0x070d:
            r0 = r25 & 32
            if (r0 != 0) goto L_0x073b
            r0 = r35 & 32
            if (r0 == 0) goto L_0x073b
            double r29 = r29 + r39
            r18 = r10
            r6 = r17
            r69 = r20
            r11 = r24
            r5 = r27
            r22 = r28
            r7 = r31
            r8 = r32
            r1 = r37
            r2 = r38
            r12 = r39
            r10 = r50
            r31 = r9
            r20 = r15
            r28 = r23
            r9 = r47
            r15 = r73
            goto L_0x0091
        L_0x073b:
            r7 = 0
        L_0x073d:
            r15 = 4645040803167600640(0x4076800000000000, double:360.0)
            if (r7 >= r13) goto L_0x078f
            int r0 = r7 + 2
            r1 = r71[r0]
            r3 = r71[r0]
            double r3 = swisseph.SweDate.getDeltaT(r3)
            double r19 = r1 + r3
            swisseph.SwissEph r0 = r14.sw
            r3 = 0
            r1 = r19
            r4 = r37
            r5 = r47
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x0762
            return r11
        L_0x0762:
            swisseph.SwissEph r0 = r14.sw
            r3 = 1
            r1 = r19
            r4 = r37
            r5 = r31
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x0774
            return r11
        L_0x0774:
            swisseph.SwissLib r0 = r14.sl
            r1 = r47[r18]
            r3 = r31[r18]
            double r1 = r1 - r3
            double r0 = r0.swe_degnorm(r1)
            r27[r7] = r0
            r0 = r27[r7]
            int r2 = (r0 > r41 ? 1 : (r0 == r41 ? 0 : -1))
            if (r2 <= 0) goto L_0x078c
            r0 = r27[r7]
            double r0 = r0 - r15
            r27[r7] = r0
        L_0x078c:
            int r7 = r7 + 1
            goto L_0x073d
        L_0x078f:
            r0 = r27[r18]
            r2 = 1
            r3 = r27[r2]
            double r0 = r0 * r3
            int r3 = (r0 > r45 ? 1 : (r0 == r45 ? 0 : -1))
            if (r3 < 0) goto L_0x079e
            r71[r2] = r45
            goto L_0x0839
        L_0x079e:
            r0 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            r2 = r71[r12]
            r4 = r71[r13]
            double r2 = r2 - r4
            double r2 = r2 / r55
            r9.val = r2
            double r2 = r9.val
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x07b7
            double r0 = r9.val
            double r0 = r0 / r55
        L_0x07b7:
            r7 = r0
        L_0x07b8:
            r0 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0835
            r12 = r43
            r10 = 0
        L_0x07c4:
            r0 = 1
            if (r10 > r0) goto L_0x0818
            double r0 = swisseph.SweDate.getDeltaT(r12)
            double r19 = r12 + r0
            swisseph.SwissEph r0 = r14.sw
            r3 = 0
            r1 = r19
            r4 = r37
            r5 = r47
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x07df
            return r11
        L_0x07df:
            swisseph.SwissEph r0 = r14.sw
            r3 = 1
            r1 = r19
            r4 = r37
            r5 = r31
            r6 = r73
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x07f1
            return r11
        L_0x07f1:
            swisseph.SwissLib r0 = r14.sl
            r1 = r47[r18]
            r3 = r31[r18]
            double r1 = r1 - r3
            double r0 = r0.swe_degnorm(r1)
            r27[r10] = r0
            r0 = r27[r10]
            int r2 = (r0 > r41 ? 1 : (r0 == r41 ? 0 : -1))
            if (r2 <= 0) goto L_0x0809
            r0 = r27[r10]
            double r0 = r0 - r15
            r27[r10] = r0
        L_0x0809:
            r0 = r27[r10]
            int r2 = (r0 > r41 ? 1 : (r0 == r41 ? 0 : -1))
            if (r2 <= 0) goto L_0x0814
            r0 = r27[r10]
            double r0 = r0 - r15
            r27[r10] = r0
        L_0x0814:
            int r10 = r10 + 1
            double r12 = r12 - r7
            goto L_0x07c4
        L_0x0818:
            r0 = 1
            r1 = r27[r0]
            r3 = r27[r18]
            double r1 = r1 - r3
            double r1 = r1 / r7
            r3 = 4457293557087583675(0x3ddb7cdfd9d7bdbb, double:1.0E-10)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0829
            goto L_0x0835
        L_0x0829:
            r3 = r27[r18]
            double r3 = r3 / r1
            r9.val = r3
            double r0 = r9.val
            double r43 = r43 + r0
            double r7 = r7 / r51
            goto L_0x07b8
        L_0x0835:
            r0 = 1
            r71[r0] = r43
        L_0x0839:
            return r35
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_sol_eclipse_when_glob(double, int, int, double[], int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public int swe_lun_occult_when_glob(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, int i4, StringBuffer stringBuffer2) {
        int i5;
        int i6;
        double d2;
        int i7;
        int i8;
        DblObj dblObj;
        DblObj dblObj2;
        double[] dArr2;
        double[] dArr3;
        int i9;
        double[] dArr4;
        double[] dArr5;
        double d3;
        double deltaT;
        int i10;
        boolean z;
        int i11;
        int i12;
        DblObj dblObj3;
        int i13;
        DblObj dblObj4;
        DblObj dblObj5;
        DblObj dblObj6;
        int i14;
        int i15;
        String str;
        int i16 = i3;
        int i17 = i4;
        StringBuffer stringBuffer3 = stringBuffer2;
        DblObj dblObj7 = new DblObj();
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        double[] dArr8 = new double[6];
        double[] dArr9 = new double[10];
        double[] dArr10 = new double[20];
        DblObj dblObj8 = new DblObj();
        double[] dArr11 = new double[6];
        DblObj dblObj9 = new DblObj(0.0d);
        DblObj dblObj10 = new DblObj(0.0d);
        double[] dArr12 = new double[20];
        int i18 = i17 & 32768;
        int i19 = i;
        if (i19 == 144340) {
            i19 = 9;
        }
        int i20 = i2 & 7;
        int i21 = i20 | 2048;
        DblObj dblObj11 = dblObj7;
        int i22 = i21 | 4096;
        double[] dArr13 = dArr12;
        int i23 = (int) (((long) i17) & 1);
        double[] dArr14 = dArr8;
        if (i16 != 17) {
            if (i16 == 0) {
                i5 = 63;
            } else {
                i5 = i16;
            }
            for (int i24 = 0; i24 <= 9; i24++) {
                dArr[i24] = 0.0d;
            }
            if (i23 != 0) {
                i6 = -1;
            } else {
                i6 = 1;
            }
            double[] dArr15 = dArr7;
            double[] dArr16 = dArr6;
            double d4 = (double) i6;
            double d5 = d - (0.001d * d4);
            double d6 = d5;
            boolean z2 = false;
            int i25 = 0;
            int i26 = 0;
            while (true) {
                int i27 = i6;
                double d7 = d6;
                int i28 = 0;
                while (true) {
                    d2 = 6.0d;
                    i7 = i20;
                    if (i28 >= 10) {
                        i8 = i23;
                        dblObj = dblObj10;
                        dblObj2 = dblObj9;
                        dArr2 = dArr10;
                        dArr3 = dArr9;
                        i9 = i21;
                        dArr4 = dArr11;
                        dArr5 = dArr16;
                        break;
                    }
                    i9 = i21;
                    i8 = i23;
                    dblObj = dblObj10;
                    dblObj2 = dblObj9;
                    dArr2 = dArr10;
                    dArr3 = dArr9;
                    if (calc_planet_star(d7, i19, stringBuffer, i22, dArr11, stringBuffer2) == -1 || this.sw.swe_calc(d7, 1, i22, dArr16, stringBuffer2) == -1) {
                        return -1;
                    }
                    dArr4 = dArr11;
                    dArr5 = dArr16;
                    dArr2[i28] = SMath.acos(this.sl.swi_dot_prod_unit(dArr4, dArr5)) * 57.2957795130823d;
                    if (i28 > 1) {
                        int i29 = i28 - 1;
                        if (dArr2[i28] > dArr2[i29] && dArr2[i28 - 2] > dArr2[i29]) {
                            d6 = d7 - (d4 * 6.0d);
                            break;
                        }
                    }
                    if (SMath.abs(d6 - d7) > 25.2d) {
                        d7 = d6;
                    } else if (i28 == 9) {
                        if (stringBuffer3 == null) {
                            return -1;
                        }
                        if (stringBuffer == null || stringBuffer.length() <= 0) {
                            str = this.sw.swe_get_planet_name(i19);
                        } else {
                            str = stringBuffer.toString();
                        }
                        stringBuffer3.setLength(0);
                        stringBuffer3.append("error in swe_lun_occult_when_glob(): conjunction of moon with planet ");
                        stringBuffer3.append(str);
                        stringBuffer3.append(" not found\n");
                        return -1;
                    }
                    i28++;
                    d7 += 6.0d * d4;
                    dblObj10 = dblObj;
                    dblObj9 = dblObj2;
                    dArr16 = dArr5;
                    dArr11 = dArr4;
                    i21 = i9;
                    i20 = i7;
                    i23 = i8;
                    dArr10 = dArr2;
                    dArr9 = dArr3;
                }
                if (stringBuffer != null && stringBuffer.length() > 0) {
                    d3 = 0.0d;
                } else if (i19 < 21) {
                    d3 = (SwephData.pla_diam[i19] / 2.0d) / 1.4959787066E11d;
                } else if (i19 > 10000) {
                    d3 = ((this.swed.ast_diam / 2.0d) * 1000.0d) / 1.4959787066E11d;
                } else {
                    d3 = 0.0d;
                }
                while (d2 > 1.0E-4d) {
                    double d8 = d6 - d2;
                    int i30 = 0;
                    while (i30 <= 2) {
                        int i31 = i30;
                        double[] dArr17 = dArr5;
                        double[] dArr18 = dArr4;
                        if (calc_planet_star(d8, i19, stringBuffer, i9, dArr15, stringBuffer2) == -1 || this.sw.swe_calc(d8, 1, i9, dArr14, stringBuffer2) == -1 || calc_planet_star(d8, i19, stringBuffer, i22, dArr18, stringBuffer2) == -1 || this.sw.swe_calc(d8, 1, i22, dArr17, stringBuffer2) == -1) {
                            return -1;
                        }
                        double[] dArr19 = dArr17;
                        dArr4 = dArr18;
                        dArr2[i31] = SMath.acos(this.sl.swi_dot_prod_unit(dArr4, dArr19)) * 57.2957795130823d;
                        dArr2[i31] = dArr2[i31] - ((SMath.asin(RMOON / dArr14[2]) * 57.2957795130823d) + (SMath.asin(d3 / dArr15[2]) * 57.2957795130823d));
                        i30 = i31 + 1;
                        d8 += d2;
                        dArr5 = dArr19;
                    }
                    int i32 = i27;
                    find_maximum(dArr2[0], dArr2[1], dArr2[2], d2, dblObj11, dblObj8);
                    d6 += dblObj11.val + d2;
                    d2 /= 3.0d;
                    dArr4 = dArr4;
                    dArr5 = dArr5;
                    d4 = d4;
                }
                int i33 = i27;
                double[] dArr20 = dArr5;
                dArr11 = dArr4;
                double d9 = d4;
                DblObj dblObj12 = dblObj11;
                int i34 = -1;
                deltaT = d6 - SweDate.getDeltaT(d6);
                int i35 = 2;
                int eclipse_where = eclipse_where(deltaT, i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                if (eclipse_where == -1) {
                    return eclipse_where;
                }
                if (eclipse_where != 0) {
                    dArr[0] = deltaT;
                    if ((i8 == 0 || dArr[0] < d5 - 1.0E-4d) && (i8 != 0 || dArr[0] > d5 + 1.0E-4d)) {
                        int eclipse_where2 = eclipse_where(deltaT, i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                        if (eclipse_where2 == -1) {
                            return eclipse_where2;
                        }
                        if (eclipse_where2 == 0) {
                            dArr[5] = deltaT;
                            dArr[4] = deltaT;
                            dArr[5] = deltaT;
                            dArr[4] = deltaT;
                            i11 = 18;
                            z = true;
                        } else {
                            z = z2;
                            i11 = eclipse_where2;
                        }
                        if ((i5 & 2) == 0 && (i11 & 2) != 0) {
                            d6 = deltaT + ((double) (i33 * 20));
                            dblObj10 = dblObj;
                            dblObj9 = dblObj2;
                            dblObj11 = dblObj12;
                            i21 = i9;
                            z2 = z;
                            i20 = i7;
                            i23 = i8;
                            dArr10 = dArr2;
                            dArr9 = dArr3;
                            dArr16 = dArr20;
                            i10 = i33;
                            d4 = d9;
                        } else if ((i5 & 1) == 0 && (i11 & 1) != 0) {
                            d6 = deltaT + ((double) (i33 * 20));
                            dblObj10 = dblObj;
                            dblObj9 = dblObj2;
                            dblObj11 = dblObj12;
                            i21 = i9;
                            z2 = z;
                            i20 = i7;
                            i23 = i8;
                            dArr10 = dArr2;
                            dArr9 = dArr3;
                            dArr16 = dArr20;
                            i10 = i33;
                            d4 = d9;
                        } else if ((i5 & 8) == 0 && (i11 & 8) != 0) {
                            d6 = deltaT + ((double) (i33 * 20));
                            dblObj10 = dblObj;
                            dblObj9 = dblObj2;
                            dblObj11 = dblObj12;
                            i21 = i9;
                            z2 = z;
                            i20 = i7;
                            i23 = i8;
                            dArr10 = dArr2;
                            dArr9 = dArr3;
                            dArr16 = dArr20;
                            i10 = i33;
                            d4 = d9;
                        } else if ((i5 & 16) == 0 && (i11 & 16) != 0) {
                            d6 = deltaT + ((double) (i33 * 20));
                            dblObj10 = dblObj;
                            dblObj9 = dblObj2;
                            dblObj11 = dblObj12;
                            i21 = i9;
                            z2 = z;
                            i20 = i7;
                            i23 = i8;
                            dArr10 = dArr2;
                            dArr9 = dArr3;
                            dArr16 = dArr20;
                            i10 = i33;
                            d4 = d9;
                        } else if ((i5 & 36) == 0 && (i11 & 4) != 0) {
                            d6 = deltaT + ((double) (i33 * 20));
                            dblObj10 = dblObj;
                            dblObj9 = dblObj2;
                            dblObj11 = dblObj12;
                            i21 = i9;
                            z2 = z;
                            i20 = i7;
                            i23 = i8;
                            dArr10 = dArr2;
                            dArr9 = dArr3;
                            dArr16 = dArr20;
                            i10 = i33;
                            d4 = d9;
                        } else if (z) {
                            return i11;
                        } else {
                            int i36 = i11 & 16;
                            if (i36 != 0) {
                                i12 = 0;
                            } else if ((i11 & 2) != 0) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            int i37 = 0;
                            while (i37 <= i12) {
                                if (i37 == 0) {
                                    i15 = 3;
                                    i25 = 2;
                                } else {
                                    if (i37 == 1) {
                                        if (i36 == 0) {
                                            i15 = 5;
                                            i25 = 4;
                                        }
                                    } else if (i37 != i35) {
                                        i15 = i26;
                                    } else if ((i11 & 2) == 0) {
                                        i15 = 7;
                                        i25 = 6;
                                    }
                                    dblObj6 = dblObj2;
                                    i14 = i37;
                                    i13 = i12;
                                    dblObj4 = dblObj12;
                                    dblObj5 = dblObj;
                                    i37 = i14 + 1;
                                    dblObj2 = dblObj6;
                                    dblObj = dblObj5;
                                    dblObj12 = dblObj4;
                                    i12 = i13;
                                    i35 = 2;
                                    i34 = -1;
                                }
                                double d10 = deltaT - 0.08333333333333333d;
                                int i38 = 0;
                                while (i38 <= i35) {
                                    int i39 = i38;
                                    int i40 = i15;
                                    int i41 = i37;
                                    int i42 = i12;
                                    int eclipse_where3 = eclipse_where(d10, i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                                    if (eclipse_where3 == i34) {
                                        return eclipse_where3;
                                    }
                                    if (i41 == 0) {
                                        dArr2[i39] = ((dArr3[4] / 2.0d) + (6378.14d / dArr3[5])) - dArr3[2];
                                    } else if (i41 == 1) {
                                        dArr2[i39] = ((SMath.abs(dArr3[3]) / 2.0d) + (6378.14d / dArr3[6])) - dArr3[2];
                                    } else if (i41 == 2) {
                                        dArr2[i39] = (6378.14d / dArr3[6]) - dArr3[2];
                                    }
                                    i38 = i39 + 1;
                                    d10 += 0.08333333333333333d;
                                    i37 = i41;
                                    i15 = i40;
                                    i12 = i42;
                                    i35 = 2;
                                }
                                i13 = i12;
                                int i43 = i37;
                                dblObj6 = dblObj2;
                                dblObj4 = dblObj12;
                                dblObj5 = dblObj;
                                find_zero(dArr2[0], dArr2[1], dArr2[2], 0.08333333333333333d, dblObj6, dblObj5);
                                dArr[i25] = deltaT + dblObj6.val + 0.08333333333333333d;
                                int i44 = i15;
                                dArr[i44] = deltaT + dblObj5.val + 0.08333333333333333d;
                                double d11 = 0.006944444444444445d;
                                int i45 = 0;
                                for (int i46 = 3; i45 < i46; i46 = 3) {
                                    int i47 = i25;
                                    while (i47 <= i44) {
                                        double d12 = dArr[i47] - d11;
                                        int i48 = 0;
                                        while (i48 < 2) {
                                            int i49 = i48;
                                            int i50 = i47;
                                            int i51 = i45;
                                            int i52 = i44;
                                            int eclipse_where4 = eclipse_where(d12, i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                                            if (eclipse_where4 == -1) {
                                                return eclipse_where4;
                                            }
                                            int i53 = i43;
                                            if (i53 == 0) {
                                                dArr2[i49] = ((dArr3[4] / 2.0d) + (6378.14d / dArr3[5])) - dArr3[2];
                                            } else if (i53 == 1) {
                                                dArr2[i49] = ((SMath.abs(dArr3[3]) / 2.0d) + (6378.14d / dArr3[6])) - dArr3[2];
                                            } else if (i53 == 2) {
                                                dArr2[i49] = (6378.14d / dArr3[6]) - dArr3[2];
                                            }
                                            i48 = i49 + 1;
                                            d12 += d11;
                                            i43 = i53;
                                            i47 = i50;
                                            i45 = i51;
                                            i44 = i52;
                                        }
                                        int i54 = i47;
                                        int i55 = i43;
                                        dblObj6.val = dArr2[1] / ((dArr2[1] - dArr2[0]) / d11);
                                        dArr[i54] = dArr[i54] - dblObj6.val;
                                        i47 = i54 + (i44 - i25);
                                        i45 = i45;
                                    }
                                    int i56 = i44;
                                    int i57 = i43;
                                    i45++;
                                    d11 /= 3.0d;
                                }
                                i14 = i43;
                                i26 = i44;
                                i37 = i14 + 1;
                                dblObj2 = dblObj6;
                                dblObj = dblObj5;
                                dblObj12 = dblObj4;
                                i12 = i13;
                                i35 = 2;
                                i34 = -1;
                            }
                            dblObj3 = dblObj2;
                            DblObj dblObj13 = dblObj12;
                            DblObj dblObj14 = dblObj;
                            if ((i11 & 4) != 0) {
                                int eclipse_where5 = eclipse_where(dArr[0], i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                                if (eclipse_where5 == -1) {
                                    return eclipse_where5;
                                }
                                dArr2[0] = dArr3[0];
                                int eclipse_where6 = eclipse_where(dArr[4], i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                                if (eclipse_where6 == -1) {
                                    return eclipse_where6;
                                }
                                dArr2[1] = dArr3[0];
                                int eclipse_where7 = eclipse_where(dArr[5], i19, stringBuffer, i7, dArr13, dArr3, stringBuffer2);
                                if (eclipse_where7 == -1) {
                                    return eclipse_where7;
                                }
                                dArr2[2] = dArr3[0];
                                if (dArr2[0] * dArr2[1] < 0.0d || dArr2[0] * dArr2[2] < 0.0d) {
                                    i11 = (i11 | 32) & -5;
                                }
                            }
                            if ((i5 & 4) == 0 && (i11 & 4) != 0) {
                                d6 = deltaT + ((double) (i33 * 20));
                                dblObj9 = dblObj3;
                                dblObj10 = dblObj14;
                                i21 = i9;
                                z2 = z;
                                i20 = i7;
                                i23 = i8;
                                dArr10 = dArr2;
                                dArr9 = dArr3;
                                dblObj11 = dblObj13;
                                dArr16 = dArr20;
                                i10 = i33;
                                d4 = d9;
                            } else if ((i5 & 32) != 0 || (i11 & 32) == 0) {
                            } else {
                                d6 = deltaT + ((double) (i33 * 20));
                                dblObj9 = dblObj3;
                                dblObj10 = dblObj14;
                                i21 = i9;
                                z2 = z;
                                i20 = i7;
                                i23 = i8;
                                dArr10 = dArr2;
                                dArr9 = dArr3;
                                dblObj11 = dblObj13;
                                dArr16 = dArr20;
                                i10 = i33;
                                d4 = d9;
                            }
                        }
                    } else {
                        d6 = deltaT + ((double) (i33 * 20));
                        dblObj10 = dblObj;
                        dblObj9 = dblObj2;
                        dblObj11 = dblObj12;
                        i21 = i9;
                        i20 = i7;
                        i23 = i8;
                        dArr10 = dArr2;
                        dArr9 = dArr3;
                        dArr16 = dArr20;
                        i10 = i33;
                        d4 = d9;
                    }
                } else if (i18 != 0) {
                    dArr[0] = deltaT;
                    return 0;
                } else {
                    d6 = deltaT + ((double) (i33 * 20));
                    dblObj10 = dblObj;
                    dblObj9 = dblObj2;
                    dblObj11 = dblObj12;
                    i21 = i9;
                    i20 = i7;
                    i23 = i8;
                    dArr10 = dArr2;
                    dArr9 = dArr3;
                    dArr16 = dArr20;
                    i10 = i33;
                    d4 = d9;
                }
            }
            for (int i58 = 0; i58 < 2; i58++) {
                int i59 = i58 + 2;
                double deltaT2 = dArr[i59] + SweDate.getDeltaT(dArr[i59]);
                if (calc_planet_star(deltaT2, i19, stringBuffer, i9, dArr15, stringBuffer2) == -1 || this.sw.swe_calc(deltaT2, 1, i9, dArr14, stringBuffer2) == -1) {
                    return -1;
                }
                dArr2[i58] = this.sl.swe_degnorm(dArr15[0] - dArr14[0]);
                if (dArr2[i58] > 180.0d) {
                    dArr2[i58] = dArr2[i58] - 360.0d;
                }
            }
            if (dArr2[0] * dArr2[1] >= 0.0d) {
                dArr[1] = 0.0d;
            } else {
                double d13 = 0.1d;
                dblObj3.val = (dArr[3] - dArr[2]) / 2.0d;
                if (dblObj3.val < 0.1d) {
                    d13 = dblObj3.val / 2.0d;
                }
                for (double d14 = d13; d14 > 0.01d; d14 /= 3.0d) {
                    double d15 = deltaT;
                    int i60 = 0;
                    while (i60 <= 1) {
                        double deltaT3 = d15 + SweDate.getDeltaT(d15);
                        if (calc_planet_star(deltaT3, i19, stringBuffer, i9, dArr15, stringBuffer2) == -1 || this.sw.swe_calc(deltaT3, 1, i9, dArr14, stringBuffer2) == -1) {
                            return -1;
                        }
                        dArr2[i60] = this.sl.swe_degnorm(dArr15[0] - dArr14[0]);
                        if (dArr2[i60] > 180.0d) {
                            dArr2[i60] = dArr2[i60] - 360.0d;
                        }
                        if (dArr2[i60] > 180.0d) {
                            dArr2[i60] = dArr2[i60] - 360.0d;
                        }
                        i60++;
                        d15 -= d14;
                    }
                    double d16 = (dArr2[1] - dArr2[0]) / d14;
                    if (d16 < 1.0E-10d) {
                        break;
                    }
                    dblObj3.val = dArr2[0] / d16;
                    deltaT += dblObj3.val;
                }
                dArr[1] = deltaT;
            }
            return i11;
        } else if (stringBuffer3 == null) {
            return -1;
        } else {
            stringBuffer3.setLength(0);
            stringBuffer3.append("central partial eclipses do not exist");
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int swe_sol_eclipse_when_loc(double d, int i, double[] dArr, double[] dArr2, double[] dArr3, int i2, StringBuffer stringBuffer) {
        double[] dArr4 = new double[20];
        double[] dArr5 = new double[10];
        int i3 = i & 7;
        int eclipse_when_loc = eclipse_when_loc(d, i3, dArr, dArr2, dArr3, i2, stringBuffer);
        if (eclipse_when_loc <= 0) {
            return eclipse_when_loc;
        }
        int eclipse_where = eclipse_where(dArr2[0], 0, (StringBuffer) null, i3, dArr4, dArr5, stringBuffer);
        if (eclipse_where == -1) {
            return eclipse_where;
        }
        int i4 = (eclipse_where & 2) | eclipse_when_loc;
        dArr3[3] = dArr5[0];
        return i4;
    }

    /* access modifiers changed from: package-private */
    public int swe_lun_occult_when_loc(double d, int i, StringBuffer stringBuffer, int i2, double[] dArr, double[] dArr2, double[] dArr3, int i3, StringBuffer stringBuffer2) {
        int i4;
        double[] dArr4 = new double[20];
        double[] dArr5 = new double[10];
        int i5 = i;
        if (i5 == 144340) {
            i4 = 9;
        } else {
            i4 = i5;
        }
        int i6 = i2 & 7;
        int occult_when_loc = occult_when_loc(d, i4, stringBuffer, i6, dArr, dArr2, dArr3, i3, stringBuffer2);
        if (occult_when_loc <= 0) {
            return occult_when_loc;
        }
        int eclipse_where = eclipse_where(dArr2[0], i4, stringBuffer, i6, dArr4, dArr5, stringBuffer2);
        if (eclipse_where == -1) {
            return eclipse_where;
        }
        int i7 = (eclipse_where & 2) | occult_when_loc;
        dArr3[3] = dArr5[0];
        return i7;
    }

    private int eclipse_when_loc(double d, int i, double[] dArr, double[] dArr2, double[] dArr3, int i2, StringBuffer stringBuffer) {
        int i3;
        double d2;
        double d3;
        DblObj dblObj;
        double d4;
        DblObj dblObj2;
        int i4;
        DblObj dblObj3;
        DblObj dblObj4;
        double[] dArr4;
        DblObj dblObj5;
        DblObj dblObj6;
        double[] dArr5;
        double[] dArr6;
        DblObj dblObj7;
        DblObj dblObj8;
        double[] dArr7;
        DblObj dblObj9;
        DblObj dblObj10;
        DblObj dblObj11;
        double[] dArr8;
        int i5;
        int i6;
        double[] dArr9;
        DblObj dblObj12;
        double[] dArr10;
        DblObj dblObj13;
        double d5;
        DblObj dblObj14 = new DblObj();
        DblObj dblObj15 = new DblObj();
        DblObj dblObj16 = new DblObj();
        double[] dArr11 = new double[6];
        double[] dArr12 = new double[6];
        double[] dArr13 = new double[6];
        double[] dArr14 = new double[6];
        double[] dArr15 = new double[6];
        double[] dArr16 = new double[6];
        DblObj dblObj17 = new DblObj();
        double[] dArr17 = new double[3];
        DblObj dblObj18 = new DblObj(0.0d);
        DblObj dblObj19 = new DblObj(0.0d);
        int i7 = i | 34816;
        int i8 = i7;
        this.sw.swe_set_topo(dArr[0], dArr[1], dArr[2]);
        int i9 = i7 | 4096;
        double d6 = (double) ((int) (((d - 2451545.0d) / 365.2425d) * 12.3685d));
        if (i2 != 0) {
            d2 = d6 + 1.0d;
            i3 = 0;
        } else {
            d2 = d6 - 1.0d;
            i3 = 0;
        }
        while (true) {
            double d7 = d2 / 1236.85d;
            double d8 = d7 * d7;
            double d9 = d8 * d7;
            double d10 = d9 * d7;
            DblObj dblObj20 = dblObj19;
            DblObj dblObj21 = dblObj17;
            DblObj dblObj22 = dblObj18;
            double swe_degnorm = this.sl.swe_degnorm(((((390.67050274d * d2) + 160.7108d) - (0.0016341d * d8)) - (2.27E-6d * d9)) + (1.1E-8d * d10));
            if (swe_degnorm > 180.0d) {
                swe_degnorm -= 180.0d;
            }
            if (swe_degnorm <= 21.0d || swe_degnorm >= 159.0d) {
                double swe_degnorm2 = this.sl.swe_degnorm((((29.10535669d * d2) + 2.5534d) - (2.18E-5d * d8)) - (1.1E-7d * d9));
                double[] dArr18 = dArr16;
                double[] dArr19 = dArr15;
                double swe_degnorm3 = this.sl.swe_degnorm((385.81693528d * d2) + 201.5643d + (0.1017438d * d8) + (1.239E-5d * d9) + (d10 * 5.8E-8d));
                int i10 = i9;
                DblObj dblObj23 = dblObj16;
                this.sl.swe_degnorm((124.7746d - (1.5637558d * d2)) + (0.0020691d * d8) + (d9 * 2.15E-6d));
                this.sl.swe_degnorm(((0.107408d * d2) + 299.77d) - (d8 * 0.009173d));
                double sin = ((((((29.530588853d * d2) + 2451550.09765d) + (1.337E-4d * d8)) - (1.5E-7d * d9)) + (7.3E-10d * d10)) - (SMath.sin(swe_degnorm3 * 0.0174532925199433d) * 0.4075d)) + (((1.0d - (d7 * 0.002516d)) - (7.4E-6d * d8)) * 0.1721d * SMath.sin(swe_degnorm2 * 0.0174532925199433d));
                this.sw.swe_set_topo(dArr[0], dArr[1], dArr[2]);
                double d11 = 0.5d;
                double d12 = 2.0d;
                if (sin < 1900000.0d) {
                    d11 = 2.0d;
                }
                double d13 = d11;
                while (true) {
                    int i11 = -1;
                    if (d13 > 1.0E-5d) {
                        if (d13 < 0.1d) {
                            d5 = 3.0d;
                        } else {
                            d5 = d12;
                        }
                        double d14 = sin - d13;
                        int i12 = 0;
                        while (i12 <= 2) {
                            DblObj dblObj24 = dblObj20;
                            DblObj dblObj25 = dblObj21;
                            double[] dArr20 = dArr17;
                            int i13 = i8;
                            int i14 = i10;
                            DblObj dblObj26 = dblObj24;
                            double[] dArr21 = dArr18;
                            int i15 = i12;
                            double[] dArr22 = dArr19;
                            if (this.sw.swe_calc(d14, 0, i14, dArr11, stringBuffer) == i11 || this.sw.swe_calc(d14, 0, i13, dArr13, stringBuffer) == i11 || this.sw.swe_calc(d14, 1, i14, dArr12, stringBuffer) == i11 || this.sw.swe_calc(d14, 1, i13, dArr14, stringBuffer) == i11) {
                                return i11;
                            }
                            double sqrt = SMath.sqrt(this.sl.square_sum(dArr12));
                            double sqrt2 = SMath.sqrt(this.sl.square_sum(dArr11));
                            int i16 = 0;
                            for (int i17 = 3; i16 < i17; i17 = 3) {
                                dArr22[i16] = dArr11[i16] / sqrt2;
                                dArr21[i16] = dArr12[i16] / sqrt;
                                i16++;
                            }
                            double[] dArr23 = dArr21;
                            double[] dArr24 = dArr22;
                            dArr20[i15] = SMath.acos(this.sl.swi_dot_prod_unit(dArr24, dArr23)) * 57.2957795130823d;
                            i12 = i15 + 1;
                            d14 += d13;
                            dArr19 = dArr24;
                            dArr18 = dArr23;
                            dArr17 = dArr20;
                            dblObj21 = dblObj25;
                            i10 = i14;
                            dblObj20 = dblObj26;
                            i11 = -1;
                            i8 = i13;
                        }
                        double[] dArr25 = dArr17;
                        int i18 = i8;
                        double[] dArr26 = dArr19;
                        double[] dArr27 = dArr18;
                        DblObj dblObj27 = dblObj21;
                        DblObj dblObj28 = dblObj20;
                        find_maximum(dArr25[0], dArr25[1], dArr25[2], d13, dblObj23, dblObj27);
                        sin += dblObj23.val + d13;
                        d13 /= d5;
                        d12 = d5;
                        dArr13 = dArr13;
                        dArr14 = dArr14;
                        dArr12 = dArr12;
                        dArr11 = dArr11;
                        dblObj21 = dblObj27;
                        i10 = i10;
                        dblObj20 = dblObj28;
                        i8 = i18;
                    } else {
                        double[] dArr28 = dArr13;
                        double[] dArr29 = dArr11;
                        double[] dArr30 = dArr17;
                        int i19 = i8;
                        double[] dArr31 = dArr19;
                        double[] dArr32 = dArr18;
                        DblObj dblObj29 = dblObj21;
                        DblObj dblObj30 = dblObj23;
                        double[] dArr33 = dArr14;
                        DblObj dblObj31 = dblObj20;
                        int i20 = i10;
                        double[] dArr34 = dArr12;
                        if (this.sw.swe_calc(sin, 0, i20, dArr29, stringBuffer) == -1 || this.sw.swe_calc(sin, 0, i19, dArr28, stringBuffer) == -1 || this.sw.swe_calc(sin, 1, i20, dArr34, stringBuffer) == -1 || this.sw.swe_calc(sin, 1, i19, dArr33, stringBuffer) == -1) {
                            return -1;
                        }
                        double[] dArr35 = dArr34;
                        double[] dArr36 = dArr29;
                        DblObj dblObj32 = dblObj29;
                        dblObj32.val = SMath.acos(this.sl.swi_dot_prod_unit(dArr36, dArr35)) * 57.2957795130823d;
                        double asin = SMath.asin(RMOON / dArr33[2]) * 57.2957795130823d;
                        double asin2 = SMath.asin(RSUN / dArr28[2]) * 57.2957795130823d;
                        double d15 = asin2 + asin;
                        double d16 = asin2 - asin;
                        if (dblObj32.val <= d15) {
                            dArr2[0] = sin - SweDate.getDeltaT(sin);
                            if ((i2 == 0 || dArr2[0] < d - 1.0E-4d) && (i2 != 0 || dArr2[0] > d + 1.0E-4d)) {
                                if (dblObj32.val < d16) {
                                    i3 = 8;
                                } else if (dblObj32.val < SMath.abs(d16)) {
                                    i3 = 4;
                                } else if (dblObj32.val <= d15) {
                                    i3 = 16;
                                }
                                double d17 = dblObj32.val;
                                double[] dArr37 = dArr35;
                                if (dblObj32.val > SMath.abs(d16)) {
                                    dArr2[3] = 0.0d;
                                    dArr2[2] = 0.0d;
                                    d4 = d17;
                                    dArr5 = dArr36;
                                    dblObj2 = dblObj30;
                                    dblObj = dblObj14;
                                    dArr4 = dArr37;
                                    dblObj6 = dblObj22;
                                    dblObj4 = dblObj15;
                                    dblObj5 = dblObj32;
                                    DblObj dblObj33 = dblObj31;
                                    i4 = i20;
                                    dblObj3 = dblObj33;
                                } else {
                                    dArr30[1] = SMath.abs(d16) - d17;
                                    double d18 = sin - 0.0013888888888888887d;
                                    int i21 = 0;
                                    while (i21 <= 2) {
                                        double d19 = d17;
                                        DblObj dblObj34 = dblObj14;
                                        if (this.sw.swe_calc(d18, 0, i20, dArr36, stringBuffer) == -1 || this.sw.swe_calc(d18, 1, i20, dArr37, stringBuffer) == -1) {
                                            return -1;
                                        }
                                        double[] dArr38 = dArr37;
                                        double sqrt3 = SMath.sqrt(this.sl.square_sum(dArr38));
                                        double sqrt4 = SMath.sqrt(this.sl.square_sum(dArr36));
                                        double asin3 = (SMath.asin(RSUN / sqrt4) * 57.2957795130823d) - ((SMath.asin(RMOON / sqrt3) * 57.2957795130823d) * 0.99916d);
                                        for (int i22 = 0; i22 < 3; i22++) {
                                            dArr31[i22] = dArr36[i22] / sqrt4;
                                            dArr32[i22] = dArr38[i22] / sqrt3;
                                        }
                                        dblObj32.val = SMath.acos(this.sl.swi_dot_prod_unit(dArr31, dArr32)) * 57.2957795130823d;
                                        dArr30[i21] = SMath.abs(asin3) - dblObj32.val;
                                        i21 += 2;
                                        d18 = sin + 0.0013888888888888887d;
                                        dArr37 = dArr38;
                                        d17 = d19;
                                        dblObj14 = dblObj34;
                                    }
                                    d4 = d17;
                                    dblObj = dblObj14;
                                    dArr4 = dArr37;
                                    dblObj4 = dblObj15;
                                    dblObj5 = dblObj32;
                                    double[] dArr39 = dArr36;
                                    dblObj2 = dblObj30;
                                    find_zero(dArr30[0], dArr30[1], dArr30[2], 0.0013888888888888887d, dblObj22, dblObj31);
                                    dblObj6 = dblObj22;
                                    int i23 = 2;
                                    dArr2[2] = sin + dblObj6.val + 0.0013888888888888887d;
                                    DblObj dblObj35 = dblObj31;
                                    int i24 = 3;
                                    dArr2[3] = sin + dblObj35.val + 0.0013888888888888887d;
                                    double d20 = 1.1574074074074075E-4d;
                                    int i25 = 0;
                                    while (i25 < i23) {
                                        int i26 = 2;
                                        while (i26 <= i24) {
                                            int i27 = i20;
                                            int i28 = i27 | 256;
                                            int i29 = i27;
                                            int i30 = i26;
                                            int i31 = i25;
                                            if (this.sw.swe_calc(dArr2[i26], 0, i28, dArr39, stringBuffer) == -1 || this.sw.swe_calc(dArr2[i30], 1, i28, dArr4, stringBuffer) == -1) {
                                                return -1;
                                            }
                                            int i32 = 0;
                                            while (i32 < 2) {
                                                if (i32 == 1) {
                                                    for (int i33 = 0; i33 < 3; i33++) {
                                                        double[] dArr40 = dArr39;
                                                        int i34 = i33 + 3;
                                                        dArr40[i33] = dArr40[i33] - (dArr40[i34] * d20);
                                                        dArr4[i33] = dArr4[i33] - (dArr4[i34] * d20);
                                                    }
                                                    dArr10 = dArr39;
                                                } else {
                                                    dArr10 = dArr39;
                                                }
                                                double sqrt5 = SMath.sqrt(this.sl.square_sum(dArr4));
                                                double sqrt6 = SMath.sqrt(this.sl.square_sum(dArr10));
                                                double asin4 = (SMath.asin(RSUN / sqrt6) * 57.2957795130823d) - ((SMath.asin(RMOON / sqrt5) * 57.2957795130823d) * 0.99916d);
                                                int i35 = 0;
                                                while (true) {
                                                    dblObj13 = dblObj35;
                                                    if (i35 >= 3) {
                                                        break;
                                                    }
                                                    dArr31[i35] = dArr10[i35] / sqrt6;
                                                    dArr32[i35] = dArr4[i35] / sqrt5;
                                                    i35++;
                                                    dblObj35 = dblObj13;
                                                }
                                                dblObj5.val = SMath.acos(this.sl.swi_dot_prod_unit(dArr31, dArr32)) * 57.2957795130823d;
                                                dArr30[i32] = SMath.abs(asin4) - dblObj5.val;
                                                i32++;
                                                dArr39 = dArr10;
                                                dblObj35 = dblObj13;
                                            }
                                            DblObj dblObj36 = dblObj35;
                                            double[] dArr41 = dArr39;
                                            dblObj6.val = (-dArr30[0]) / ((dArr30[0] - dArr30[1]) / d20);
                                            dArr2[i30] = dArr2[i30] + dblObj6.val;
                                            i26 = i30 + 1;
                                            i20 = i29;
                                            i25 = i31;
                                            i24 = 3;
                                        }
                                        int i36 = i25;
                                        int i37 = i20;
                                        double[] dArr42 = dArr39;
                                        DblObj dblObj37 = dblObj35;
                                        d20 /= 10.0d;
                                        i20 = i37;
                                        i23 = 2;
                                        i24 = 3;
                                        i25 = i36 + 1;
                                    }
                                    i4 = i20;
                                    dArr5 = dArr39;
                                    dblObj3 = dblObj35;
                                    dArr2[2] = dArr2[2] - SweDate.getDeltaT(dArr2[2]);
                                    dArr2[3] = dArr2[3] - SweDate.getDeltaT(dArr2[3]);
                                }
                                dArr30[1] = d15 - d4;
                                double d21 = sin - 0.08333333333333333d;
                                int i38 = 0;
                                while (i38 <= 2) {
                                    DblObj dblObj38 = dblObj6;
                                    double[] dArr43 = dArr5;
                                    if (this.sw.swe_calc(d21, 0, i4, dArr5, stringBuffer) == -1 || this.sw.swe_calc(d21, 1, i4, dArr4, stringBuffer) == -1) {
                                        return -1;
                                    }
                                    double sqrt7 = SMath.sqrt(this.sl.square_sum(dArr4));
                                    double sqrt8 = SMath.sqrt(this.sl.square_sum(dArr43));
                                    double asin5 = (SMath.asin(RSUN / sqrt8) * 57.2957795130823d) + (SMath.asin(RMOON / sqrt7) * 57.2957795130823d);
                                    for (int i39 = 0; i39 < 3; i39++) {
                                        dArr31[i39] = dArr43[i39] / sqrt8;
                                        dArr32[i39] = dArr4[i39] / sqrt7;
                                    }
                                    dblObj5.val = SMath.acos(this.sl.swi_dot_prod_unit(dArr31, dArr32)) * 57.2957795130823d;
                                    dArr30[i38] = asin5 - dblObj5.val;
                                    i38 += 2;
                                    d21 = sin + 0.08333333333333333d;
                                    dArr5 = dArr43;
                                    dblObj6 = dblObj38;
                                }
                                DblObj dblObj39 = dblObj6;
                                DblObj dblObj40 = dblObj3;
                                double[] dArr44 = dArr5;
                                DblObj dblObj41 = dblObj5;
                                DblObj dblObj42 = dblObj39;
                                DblObj dblObj43 = dblObj40;
                                find_zero(dArr30[0], dArr30[1], dArr30[2], 0.08333333333333333d, dblObj39, dblObj43);
                                dArr2[1] = sin + dblObj42.val + 0.08333333333333333d;
                                int i40 = 4;
                                dArr2[4] = sin + dblObj43.val + 0.08333333333333333d;
                                double d22 = 0.006944444444444445d;
                                int i41 = 0;
                                while (i41 < 3) {
                                    int i42 = 1;
                                    while (i42 <= i40) {
                                        int i43 = i4;
                                        int i44 = i43 | 256;
                                        int i45 = i44;
                                        int i46 = i43;
                                        int i47 = i42;
                                        if (this.sw.swe_calc(dArr2[i42], 0, i44, dArr44, stringBuffer) == -1 || this.sw.swe_calc(dArr2[i47], 1, i45, dArr4, stringBuffer) == -1) {
                                            return -1;
                                        }
                                        int i48 = 0;
                                        while (i48 < 2) {
                                            if (i48 == 1) {
                                                for (int i49 = 0; i49 < 3; i49++) {
                                                    double[] dArr45 = dArr44;
                                                    int i50 = i49 + 3;
                                                    dArr45[i49] = dArr45[i49] - (dArr45[i50] * d22);
                                                    dArr4[i49] = dArr4[i49] - (dArr4[i50] * d22);
                                                }
                                                dArr9 = dArr44;
                                            } else {
                                                dArr9 = dArr44;
                                            }
                                            double sqrt9 = SMath.sqrt(this.sl.square_sum(dArr4));
                                            double sqrt10 = SMath.sqrt(this.sl.square_sum(dArr9));
                                            double asin6 = (SMath.asin(RSUN / sqrt10) * 57.2957795130823d) + (SMath.asin(RMOON / sqrt9) * 57.2957795130823d);
                                            int i51 = 0;
                                            while (true) {
                                                dblObj12 = dblObj43;
                                                if (i51 >= 3) {
                                                    break;
                                                }
                                                dArr31[i51] = dArr9[i51] / sqrt10;
                                                dArr32[i51] = dArr4[i51] / sqrt9;
                                                i51++;
                                                dblObj43 = dblObj12;
                                            }
                                            DblObj dblObj44 = dblObj41;
                                            dblObj44.val = SMath.acos(this.sl.swi_dot_prod_unit(dArr31, dArr32)) * 57.2957795130823d;
                                            dArr30[i48] = SMath.abs(asin6) - dblObj44.val;
                                            i48++;
                                            dArr44 = dArr9;
                                            dblObj43 = dblObj12;
                                        }
                                        DblObj dblObj45 = dblObj41;
                                        double[] dArr46 = dArr44;
                                        dblObj42.val = (-dArr30[0]) / ((dArr30[0] - dArr30[1]) / d22);
                                        dArr2[i47] = dArr2[i47] + dblObj42.val;
                                        dblObj43 = dblObj43;
                                        i4 = i46;
                                        i42 = i47 + 3;
                                        i40 = 4;
                                    }
                                    DblObj dblObj46 = dblObj41;
                                    double[] dArr47 = dArr44;
                                    i41++;
                                    d22 /= 10.0d;
                                    dblObj43 = dblObj43;
                                    i4 = i4;
                                    i40 = 4;
                                }
                                DblObj dblObj47 = dblObj41;
                                int i52 = i4;
                                double[] dArr48 = dArr44;
                                DblObj dblObj48 = dblObj43;
                                dArr2[1] = dArr2[1] - SweDate.getDeltaT(dArr2[1]);
                                dArr2[4] = dArr2[4] - SweDate.getDeltaT(dArr2[4]);
                                int i53 = i3;
                                int i54 = 4;
                                while (i54 >= 0) {
                                    if (dArr2[i54] == 0.0d) {
                                        dArr6 = dArr48;
                                        i5 = i54;
                                        dArr8 = dArr31;
                                        dArr7 = dArr32;
                                        dblObj7 = dblObj42;
                                        dblObj11 = dblObj48;
                                        dblObj9 = dblObj2;
                                        i6 = i53;
                                        dblObj8 = dblObj4;
                                        dblObj10 = dblObj47;
                                    } else {
                                        dArr6 = dArr48;
                                        int i55 = i54;
                                        int i56 = i53;
                                        dArr8 = dArr31;
                                        dblObj11 = dblObj48;
                                        dArr7 = dArr32;
                                        dblObj9 = dblObj2;
                                        dblObj7 = dblObj42;
                                        dblObj8 = dblObj4;
                                        dblObj10 = dblObj47;
                                        if (eclipse_how(dArr2[i54], 0, (StringBuffer) null, i, dArr[0], dArr[1], dArr[2], dArr3, stringBuffer) == -1) {
                                            return -1;
                                        }
                                        if (dArr3[6] > 0.0d) {
                                            i53 = i56 | 128;
                                            i5 = i55;
                                            if (i5 == 0) {
                                                i53 |= 256;
                                            } else if (i5 == 1) {
                                                i53 |= 512;
                                            } else if (i5 == 2) {
                                                i53 |= 1024;
                                            } else if (i5 == 3) {
                                                i53 |= 2048;
                                            } else if (i5 == 4) {
                                                i53 |= 4096;
                                            }
                                            i54 = i5 - 1;
                                            dArr31 = dArr8;
                                            dblObj47 = dblObj10;
                                            dblObj2 = dblObj9;
                                            dArr32 = dArr7;
                                            dblObj4 = dblObj8;
                                            dblObj42 = dblObj7;
                                            dArr48 = dArr6;
                                            dblObj48 = dblObj11;
                                        } else {
                                            i6 = i56;
                                            i5 = i55;
                                        }
                                    }
                                    i53 = i6;
                                    i54 = i5 - 1;
                                    dArr31 = dArr8;
                                    dblObj47 = dblObj10;
                                    dblObj2 = dblObj9;
                                    dArr32 = dArr7;
                                    dblObj4 = dblObj8;
                                    dblObj42 = dblObj7;
                                    dArr48 = dArr6;
                                    dblObj48 = dblObj11;
                                }
                                double[] dArr49 = dArr48;
                                double[] dArr50 = dArr31;
                                double[] dArr51 = dArr32;
                                DblObj dblObj49 = dblObj42;
                                DblObj dblObj50 = dblObj48;
                                DblObj dblObj51 = dblObj2;
                                int i57 = i53;
                                DblObj dblObj52 = dblObj4;
                                DblObj dblObj53 = dblObj47;
                                if ((i57 & 128) != 0) {
                                    int i58 = i57;
                                    if (swe_rise_trans(dArr2[1] - 0.1d, 0, (StringBuffer) null, i19, 8193, dArr, 0.0d, 0.0d, dblObj, stringBuffer) == -1) {
                                        return -1;
                                    }
                                    if (swe_rise_trans(dArr2[1] - 0.1d, 0, (StringBuffer) null, i19, 8194, dArr, 0.0d, 0.0d, dblObj52, stringBuffer) == -1) {
                                        return -1;
                                    }
                                    DblObj dblObj54 = dblObj;
                                    if (dblObj54.val > dArr2[1] && dblObj54.val < dArr2[4]) {
                                        dArr2[5] = dblObj54.val;
                                        if ((i58 & 256) == 0) {
                                            dArr2[0] = dblObj54.val;
                                            int eclipse_how = eclipse_how(dArr2[5], 0, (StringBuffer) null, i, dArr[0], dArr[1], dArr[2], dArr3, stringBuffer);
                                            if (eclipse_how == -1) {
                                                return -1;
                                            }
                                            i58 = (i58 & -29) | (eclipse_how & 28);
                                        }
                                    }
                                    DblObj dblObj55 = dblObj52;
                                    if (dblObj55.val <= dArr2[1] || dblObj55.val >= dArr2[4]) {
                                        return i58;
                                    }
                                    dArr2[6] = dblObj55.val;
                                    if ((i58 & 256) != 0) {
                                        return i58;
                                    }
                                    dArr2[0] = dblObj55.val;
                                    int eclipse_how2 = eclipse_how(dArr2[6], 0, (StringBuffer) null, i, dArr[0], dArr[1], dArr[2], dArr3, stringBuffer);
                                    if (eclipse_how2 == -1) {
                                        return -1;
                                    }
                                    return (i58 & -29) | (eclipse_how2 & 28);
                                } else if (i2 != 0) {
                                    d3 = d2 - 1.0d;
                                    dArr12 = dArr4;
                                    dArr15 = dArr50;
                                    dblObj19 = dblObj50;
                                    dArr17 = dArr30;
                                    dblObj17 = dblObj53;
                                    dArr16 = dArr51;
                                    dblObj15 = dblObj52;
                                    dblObj18 = dblObj49;
                                    dArr13 = dArr28;
                                    i9 = i52;
                                    dArr11 = dArr49;
                                    dArr14 = dArr33;
                                    dblObj14 = dblObj;
                                    i8 = i19;
                                    DblObj dblObj56 = dblObj51;
                                    i3 = i57;
                                    dblObj16 = dblObj56;
                                } else {
                                    d3 = d2 + 1.0d;
                                    dArr12 = dArr4;
                                    dArr15 = dArr50;
                                    dblObj19 = dblObj50;
                                    dArr17 = dArr30;
                                    dblObj17 = dblObj53;
                                    dArr16 = dArr51;
                                    dblObj15 = dblObj52;
                                    dblObj18 = dblObj49;
                                    dArr13 = dArr28;
                                    i9 = i52;
                                    dArr11 = dArr49;
                                    dArr14 = dArr33;
                                    dblObj14 = dblObj;
                                    i8 = i19;
                                    DblObj dblObj57 = dblObj51;
                                    i3 = i57;
                                    dblObj16 = dblObj57;
                                }
                            } else if (i2 != 0) {
                                d3 = d2 - 1.0d;
                                dblObj17 = dblObj32;
                                dArr15 = dArr31;
                                dArr16 = dArr32;
                                dArr17 = dArr30;
                                i9 = i20;
                                dblObj19 = dblObj31;
                                dArr14 = dArr33;
                                dblObj18 = dblObj22;
                                dblObj16 = dblObj30;
                                i8 = i19;
                                dArr11 = dArr36;
                                dArr12 = dArr35;
                                dArr13 = dArr28;
                            } else {
                                d3 = d2 + 1.0d;
                                dblObj17 = dblObj32;
                                dArr15 = dArr31;
                                dArr16 = dArr32;
                                dArr17 = dArr30;
                                i9 = i20;
                                dblObj19 = dblObj31;
                                dArr14 = dArr33;
                                dblObj18 = dblObj22;
                                dblObj16 = dblObj30;
                                i8 = i19;
                                dArr11 = dArr36;
                                dArr12 = dArr35;
                                dArr13 = dArr28;
                            }
                        } else if (i2 != 0) {
                            d3 = d2 - 1.0d;
                            dblObj17 = dblObj32;
                            dArr15 = dArr31;
                            dArr16 = dArr32;
                            dArr17 = dArr30;
                            i9 = i20;
                            dblObj19 = dblObj31;
                            dArr14 = dArr33;
                            dblObj18 = dblObj22;
                            dblObj16 = dblObj30;
                            i8 = i19;
                            dArr11 = dArr36;
                            dArr12 = dArr35;
                            dArr13 = dArr28;
                        } else {
                            d3 = d2 + 1.0d;
                            dblObj17 = dblObj32;
                            dArr15 = dArr31;
                            dArr16 = dArr32;
                            dArr17 = dArr30;
                            i9 = i20;
                            dblObj19 = dblObj31;
                            dArr14 = dArr33;
                            dblObj18 = dblObj22;
                            dblObj16 = dblObj30;
                            i8 = i19;
                            dArr11 = dArr36;
                            dArr12 = dArr35;
                            dArr13 = dArr28;
                        }
                    }
                }
            } else if (i2 != 0) {
                d3 = d2 - 1.0d;
                dblObj19 = dblObj20;
                dblObj17 = dblObj21;
                dblObj18 = dblObj22;
            } else {
                d3 = d2 + 1.0d;
                dblObj19 = dblObj20;
                dblObj17 = dblObj21;
                dblObj18 = dblObj22;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r73v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v15, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v44, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v124, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v15, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v55, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v78, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v70, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v75, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v66, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v80, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v51, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v200, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v202, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int occult_when_loc(double r73, int r75, java.lang.StringBuffer r76, int r77, double[] r78, double[] r79, double[] r80, int r81, java.lang.StringBuffer r82) {
        /*
            r72 = this;
            r14 = r72
            r15 = r75
            r0 = r81
            swisseph.DblObj r13 = new swisseph.DblObj
            r13.<init>()
            swisseph.DblObj r12 = new swisseph.DblObj
            r12.<init>()
            swisseph.DblObj r11 = new swisseph.DblObj
            r11.<init>()
            r10 = 6
            double[] r9 = new double[r10]
            double[] r8 = new double[r10]
            double[] r7 = new double[r10]
            double[] r6 = new double[r10]
            double[] r5 = new double[r10]
            double[] r4 = new double[r10]
            r1 = 20
            double[] r3 = new double[r1]
            swisseph.DblObj r1 = new swisseph.DblObj
            r1.<init>()
            swisseph.DblObj r2 = new swisseph.DblObj
            r17 = r11
            r16 = r12
            r11 = 0
            r2.<init>(r11)
            swisseph.DblObj r10 = new swisseph.DblObj
            r10.<init>(r11)
            r19 = 32768(0x8000, float:4.5918E-41)
            r11 = r77 | r19
            r12 = -32769(0xffffffffffff7fff, float:NaN)
            r12 = r12 & r11
            r22 = r10
            r10 = r11 | 4096(0x1000, float:5.74E-42)
            r12 = r12 | 4096(0x1000, float:5.74E-42)
            r19 = r0 & r19
            r23 = 0
            r24 = r13
            if (r19 == 0) goto L_0x005c
            r19 = 1
            goto L_0x005e
        L_0x005c:
            r19 = 0
        L_0x005e:
            long r13 = (long) r0
            r26 = 1
            long r13 = r13 & r26
            int r14 = (int) r13
            r13 = r72
            swisseph.SwissEph r0 = r13.sw
            r27 = r78[r23]
            r25 = 1
            r29 = r78[r25]
            r33 = r11
            r11 = 2
            r31 = r78[r11]
            r26 = r0
            r26.swe_set_topo(r27, r29, r31)
            r0 = 0
        L_0x007b:
            r11 = 9
            if (r0 > r11) goto L_0x0087
            r20 = 0
            r79[r0] = r20
            int r0 = r0 + 1
            r11 = 2
            goto L_0x007b
        L_0x0087:
            r0 = -1
            if (r14 == 0) goto L_0x008c
            r11 = -1
            goto L_0x008d
        L_0x008c:
            r11 = 1
        L_0x008d:
            r27 = r14
            double r14 = (double) r11
            r28 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r30 = r14 * r28
            double r30 = r73 - r30
            r34 = r30
            r36 = r34
            r32 = 0
            r38 = 0
        L_0x00a3:
            r39 = r11
            r11 = 0
        L_0x00a7:
            r40 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            r42 = 4618441417868443648(0x4018000000000000, double:6.0)
            r44 = r10
            r10 = 10
            if (r11 >= r10) goto L_0x0170
            r10 = -1
            r0 = r72
            r74 = r1
            r45 = r2
            r1 = r34
            r46 = r3
            r3 = r75
            r47 = r4
            r4 = r76
            r48 = r5
            r5 = r12
            r49 = r6
            r6 = r9
            r50 = r7
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r10) goto L_0x00d6
            return r10
        L_0x00d6:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r34
            r4 = r12
            r5 = r8
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r10) goto L_0x00e6
            return r10
        L_0x00e6:
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.swi_dot_prod_unit(r9, r8)
            double r0 = swisseph.SMath.acos(r0)
            double r0 = r0 * r40
            r46[r11] = r0
            r0 = 1
            if (r11 <= r0) goto L_0x0116
            r0 = r46[r11]
            int r2 = r11 + -1
            r3 = r46[r2]
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0116
            int r0 = r11 + -2
            r0 = r46[r0]
            r2 = r46[r2]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0116
            double r0 = r14 * r42
            double r36 = r34 - r0
            r34 = r36
            r7 = 9
            goto L_0x0181
        L_0x0116:
            double r0 = r36 - r34
            double r0 = swisseph.SMath.abs((double) r0)
            r2 = 4627786387095237427(0x4039333333333333, double:25.2)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x012b
            r34 = r36
            r7 = 9
            goto L_0x0181
        L_0x012b:
            r7 = 9
            if (r11 != r7) goto L_0x0157
            r0 = 0
        L_0x0130:
            r1 = 10
            if (r0 >= r1) goto L_0x014f
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r46[r0]
            r3.append(r4)
            java.lang.String r4 = " "
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.print(r3)
            int r0 = r0 + 1
            goto L_0x0130
        L_0x014f:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "swe_lun_occult_when_loc(): problem planet\n"
            r0.print(r1)
            return r10
        L_0x0157:
            int r11 = r11 + 1
            double r42 = r42 * r14
            double r34 = r34 + r42
            r1 = r74
            r10 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r0 = -1
            goto L_0x00a7
        L_0x0170:
            r74 = r1
            r45 = r2
            r46 = r3
            r47 = r4
            r48 = r5
            r49 = r6
            r50 = r7
            r7 = 9
            r10 = -1
        L_0x0181:
            r51 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r76 == 0) goto L_0x0192
            int r0 = r76.length()
            if (r0 <= 0) goto L_0x0192
            r53 = r14
            r55 = 0
            r14 = r75
            goto L_0x01c2
        L_0x0192:
            r0 = 21
            r1 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            r53 = r14
            r14 = r75
            if (r14 >= r0) goto L_0x01aa
            double[] r0 = swisseph.SwephData.pla_diam
            r3 = r0[r14]
            double r3 = r3 / r51
            double r0 = r3 / r1
            r55 = r0
            goto L_0x01c2
        L_0x01aa:
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r14 <= r0) goto L_0x01c0
            swisseph.SwissData r0 = r13.swed
            double r3 = r0.ast_diam
            double r3 = r3 / r51
            r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 * r5
            double r0 = r3 / r1
            r55 = r0
            goto L_0x01c2
        L_0x01c0:
            r55 = 0
        L_0x01c2:
            r11 = 0
        L_0x01c5:
            r0 = 4532020583610935537(0x3ee4f8b588e368f1, double:1.0E-5)
            r57 = 4532976163387923579(0x3ee85dcdca0cdc7b, double:1.1618815109677577E-5)
            int r2 = (r42 > r0 ? 1 : (r42 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x02cb
            r0 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r2 = (r42 > r0 ? 1 : (r42 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x01dc
        L_0x01dc:
            r34 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r0 = r36 - r42
            r59 = r0
            r15 = 0
        L_0x01e3:
            r0 = 2
            if (r15 > r0) goto L_0x0289
            r0 = r72
            r1 = r59
            r3 = r75
            r4 = r76
            r5 = r44
            r6 = r9
            r26 = 9
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r10) goto L_0x01fc
            return r10
        L_0x01fc:
            r0 = r72
            r1 = r59
            r3 = r75
            r4 = r76
            r5 = r33
            r6 = r50
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r10) goto L_0x0211
            return r10
        L_0x0211:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r59
            r4 = r44
            r5 = r8
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r10) goto L_0x0222
            return r10
        L_0x0222:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r59
            r4 = r33
            r5 = r49
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r10) goto L_0x0234
            return r10
        L_0x0234:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r42 > r0 ? 1 : (r42 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0258
            r0 = 1
            r1 = r50[r0]
            r3 = r49[r0]
            double r1 = r1 - r3
            double r0 = swisseph.SMath.abs((double) r1)
            int r2 = (r0 > r51 ? 1 : (r0 == r51 ? 0 : -1))
            if (r2 <= 0) goto L_0x0258
            if (r19 == 0) goto L_0x024d
            r32 = 1
            goto L_0x0258
        L_0x024d:
            int r11 = r39 * 20
            double r0 = (double) r11
            double r36 = r36 + r0
            r59 = r36
            r11 = 1
            goto L_0x028b
        L_0x0258:
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.swi_dot_prod_unit(r9, r8)
            double r0 = swisseph.SMath.acos(r0)
            double r0 = r0 * r40
            r46[r15] = r0
            r0 = 2
            r1 = r49[r0]
            double r1 = r57 / r1
            double r1 = swisseph.SMath.asin(r1)
            double r1 = r1 * r40
            r3 = r50[r0]
            double r3 = r55 / r3
            double r3 = swisseph.SMath.asin(r3)
            double r3 = r3 * r40
            r5 = r46[r15]
            double r1 = r1 + r3
            double r5 = r5 - r1
            r46[r15] = r5
            int r15 = r15 + 1
            double r59 = r59 + r42
            r7 = 9
            goto L_0x01e3
        L_0x0289:
            r26 = 9
        L_0x028b:
            if (r11 == 0) goto L_0x029a
            r15 = r8
            r73 = r9
            r61 = r22
            r10 = r24
            r34 = r59
            r14 = -1
            r18 = 6
            goto L_0x02d7
        L_0x029a:
            r1 = r46[r23]
            r0 = 1
            r3 = r46[r0]
            r0 = 2
            r5 = r46[r0]
            r0 = r72
            r15 = r8
            r7 = r42
            r73 = r9
            r9 = r24
            r61 = r22
            r14 = -1
            r18 = 6
            r10 = r74
            r0.find_maximum(r1, r3, r5, r7, r9, r10)
            r10 = r24
            double r0 = r10.val
            double r0 = r0 + r42
            double r36 = r36 + r0
            double r42 = r42 / r34
            r9 = r73
            r14 = r75
            r8 = r15
            r34 = r59
            r7 = 9
            r10 = -1
            goto L_0x01c5
        L_0x02cb:
            r15 = r8
            r73 = r9
            r61 = r22
            r10 = r24
            r14 = -1
            r18 = 6
            r26 = 9
        L_0x02d7:
            if (r11 == 0) goto L_0x02f7
            r9 = r73
            r1 = r74
            r24 = r10
            r8 = r15
            r11 = r39
            r10 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r14 = r53
            r22 = r61
            r0 = -1
            goto L_0x00a3
        L_0x02f7:
            if (r32 == 0) goto L_0x02fc
            r79[r23] = r36
            return r23
        L_0x02fc:
            r0 = r72
            r1 = r36
            r3 = r75
            r4 = r76
            r5 = r44
            r6 = r73
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r14) goto L_0x0311
            return r14
        L_0x0311:
            r0 = r72
            r1 = r36
            r3 = r75
            r4 = r76
            r5 = r33
            r6 = r50
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r14) goto L_0x0326
            return r14
        L_0x0326:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r36
            r4 = r44
            r5 = r15
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r14) goto L_0x0337
            return r14
        L_0x0337:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r36
            r4 = r33
            r5 = r49
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r14) goto L_0x0349
            return r14
        L_0x0349:
            swisseph.SwissLib r0 = r13.sl
            r11 = r73
            double r0 = r0.swi_dot_prod_unit(r11, r15)
            double r0 = swisseph.SMath.acos(r0)
            double r0 = r0 * r40
            r9 = r74
            r9.val = r0
            r0 = 2
            r1 = r49[r0]
            double r1 = r57 / r1
            double r1 = swisseph.SMath.asin(r1)
            double r1 = r1 * r40
            r3 = r50[r0]
            double r3 = r55 / r3
            double r3 = swisseph.SMath.asin(r3)
            double r3 = r3 * r40
            double r34 = r3 + r1
            double r3 = r3 - r1
            double r0 = r9.val
            int r2 = (r0 > r34 ? 1 : (r0 == r34 ? 0 : -1))
            if (r2 <= 0) goto L_0x03a2
            if (r19 == 0) goto L_0x037e
            r79[r23] = r36
            return r23
        L_0x037e:
            int r0 = r39 * 20
            double r0 = (double) r0
            double r36 = r36 + r0
            r1 = r9
            r24 = r10
            r9 = r11
            r8 = r15
            r34 = r36
            r11 = r39
            r10 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r14 = r53
            r22 = r61
            r0 = -1
            goto L_0x00a3
        L_0x03a2:
            double r0 = swisseph.SweDate.getDeltaT(r36)
            double r0 = r36 - r0
            r79[r23] = r0
            r0 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            if (r27 == 0) goto L_0x03b9
            r5 = r79[r23]
            double r7 = r30 - r0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x03c3
        L_0x03b9:
            if (r27 != 0) goto L_0x03e7
            r5 = r79[r23]
            double r0 = r30 + r0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x03e7
        L_0x03c3:
            int r0 = r39 * 20
            double r0 = (double) r0
            double r36 = r36 + r0
            r1 = r9
            r24 = r10
            r9 = r11
            r8 = r15
            r34 = r36
            r11 = r39
            r10 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r14 = r53
            r22 = r61
            r0 = -1
            goto L_0x00a3
        L_0x03e7:
            double r0 = r9.val
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x03f0
            r38 = 8
            goto L_0x0405
        L_0x03f0:
            double r0 = r9.val
            double r5 = swisseph.SMath.abs((double) r3)
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x03fd
            r38 = 4
            goto L_0x0405
        L_0x03fd:
            double r0 = r9.val
            int r2 = (r0 > r34 ? 1 : (r0 == r34 ? 0 : -1))
            if (r2 > 0) goto L_0x0405
            r38 = 16
        L_0x0405:
            double r6 = r9.val
            double r0 = r9.val
            double r42 = swisseph.SMath.abs((double) r3)
            r51 = 4621819117588971520(0x4024000000000000, double:10.0)
            r5 = 3
            int r2 = (r0 > r42 ? 1 : (r0 == r42 ? 0 : -1))
            if (r2 <= 0) goto L_0x042f
            r0 = 0
            r79[r5] = r0
            r2 = 2
            r79[r2] = r0
            r64 = r6
            r6 = r9
            r22 = r12
            r74 = r44
            r7 = r47
            r12 = r48
            r9 = r61
            r14 = 3
            r47 = r10
            r10 = r45
            goto L_0x0613
        L_0x042f:
            double r0 = swisseph.SMath.abs((double) r3)
            double r0 = r0 - r6
            r2 = 1
            r46[r2] = r0
            r42 = 4564047942368979990(0x3f56c16c16c16c16, double:0.0013888888888888887)
            double r0 = r36 - r42
            r59 = r0
            r4 = 0
        L_0x0441:
            r62 = 4607174852752643426(0x3feff91e646f1562, double:0.99916)
            r0 = 2
            if (r4 > r0) goto L_0x04d6
            r0 = r72
            r1 = r59
            r3 = r75
            r22 = r4
            r4 = r76
            r8 = 3
            r5 = r44
            r64 = r6
            r6 = r11
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            if (r0 != r14) goto L_0x0462
            return r14
        L_0x0462:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r59
            r4 = r44
            r5 = r15
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r14) goto L_0x0473
            return r14
        L_0x0473:
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.square_sum(r15)
            double r0 = swisseph.SMath.sqrt(r0)
            swisseph.SwissLib r2 = r13.sl
            double r2 = r2.square_sum(r11)
            double r2 = swisseph.SMath.sqrt(r2)
            double r4 = r57 / r0
            double r4 = swisseph.SMath.asin(r4)
            double r4 = r4 * r40
            double r4 = r4 * r62
            double r6 = r55 / r2
            double r6 = swisseph.SMath.asin(r6)
            double r6 = r6 * r40
            double r6 = r6 - r4
            r4 = 0
        L_0x049b:
            if (r4 >= r8) goto L_0x04b1
            r59 = r11[r4]
            double r59 = r59 / r2
            r5 = r48
            r5[r4] = r59
            r59 = r15[r4]
            double r59 = r59 / r0
            r14 = r47
            r14[r4] = r59
            int r4 = r4 + 1
            r14 = -1
            goto L_0x049b
        L_0x04b1:
            r14 = r47
            r5 = r48
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.swi_dot_prod_unit(r5, r14)
            double r0 = swisseph.SMath.acos(r0)
            double r0 = r0 * r40
            r9.val = r0
            double r0 = swisseph.SMath.abs((double) r6)
            double r2 = r9.val
            double r0 = r0 - r2
            r46[r22] = r0
            int r4 = r22 + 2
            double r59 = r36 + r42
            r6 = r64
            r5 = 3
            r14 = -1
            goto L_0x0441
        L_0x04d6:
            r64 = r6
            r14 = r47
            r5 = r48
            r8 = 3
            r1 = r46[r23]
            r0 = 1
            r3 = r46[r0]
            r0 = 2
            r6 = r46[r0]
            r47 = 4564047942368979990(0x3f56c16c16c16c16, double:0.0013888888888888887)
            r0 = r72
            r22 = r12
            r12 = r5
            r5 = r6
            r73 = r14
            r14 = 3
            r7 = r47
            r66 = r9
            r9 = r45
            r47 = r10
            r10 = r61
            r0.find_zero(r1, r3, r5, r7, r9, r10)
            r10 = r45
            double r0 = r10.val
            double r0 = r36 + r0
            double r0 = r0 + r42
            r2 = 2
            r79[r2] = r0
            r9 = r61
            double r0 = r9.val
            double r0 = r36 + r0
            double r0 = r0 + r42
            r79[r14] = r0
            r0 = 4548168583682844020(0x3f1e573ac901e574, double:1.1574074074074075E-4)
            r42 = r0
            r8 = 0
        L_0x051d:
            if (r8 >= r2) goto L_0x05f6
            r7 = 2
        L_0x0520:
            if (r7 > r14) goto L_0x05e9
            r1 = r79[r7]
            r6 = r44
            r5 = r6 | 256(0x100, float:3.59E-43)
            r0 = r72
            r3 = r75
            r4 = r76
            r44 = r5
            r74 = r6
            r6 = r11
            r45 = r7
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            r1 = -1
            if (r0 != r1) goto L_0x053f
            return r1
        L_0x053f:
            swisseph.SwissEph r0 = r13.sw
            r1 = r79[r45]
            r3 = 1
            r4 = r44
            r5 = r15
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x0551
            return r1
        L_0x0551:
            r0 = 0
        L_0x0552:
            r1 = 2
            if (r0 >= r1) goto L_0x05c8
            r1 = 1
            if (r0 != r1) goto L_0x0572
            r1 = 0
        L_0x0559:
            if (r1 >= r14) goto L_0x0572
            r2 = r11[r1]
            int r4 = r1 + 3
            r5 = r11[r4]
            double r5 = r5 * r42
            double r2 = r2 - r5
            r11[r1] = r2
            r2 = r15[r1]
            r4 = r15[r4]
            double r4 = r4 * r42
            double r2 = r2 - r4
            r15[r1] = r2
            int r1 = r1 + 1
            goto L_0x0559
        L_0x0572:
            swisseph.SwissLib r1 = r13.sl
            double r1 = r1.square_sum(r15)
            double r1 = swisseph.SMath.sqrt(r1)
            swisseph.SwissLib r3 = r13.sl
            double r3 = r3.square_sum(r11)
            double r3 = swisseph.SMath.sqrt(r3)
            double r5 = r57 / r1
            double r5 = swisseph.SMath.asin(r5)
            double r5 = r5 * r40
            double r5 = r5 * r62
            double r59 = r55 / r3
            double r59 = swisseph.SMath.asin(r59)
            double r59 = r59 * r40
            double r59 = r59 - r5
            r5 = 0
        L_0x059b:
            if (r5 >= r14) goto L_0x05aa
            r6 = r11[r5]
            double r6 = r6 / r3
            r12[r5] = r6
            r6 = r15[r5]
            double r6 = r6 / r1
            r73[r5] = r6
            int r5 = r5 + 1
            goto L_0x059b
        L_0x05aa:
            swisseph.SwissLib r1 = r13.sl
            r7 = r73
            double r1 = r1.swi_dot_prod_unit(r12, r7)
            double r1 = swisseph.SMath.acos(r1)
            double r1 = r1 * r40
            r6 = r66
            r6.val = r1
            double r1 = swisseph.SMath.abs((double) r59)
            double r3 = r6.val
            double r1 = r1 - r3
            r46[r0] = r1
            int r0 = r0 + 1
            goto L_0x0552
        L_0x05c8:
            r7 = r73
            r6 = r66
            r0 = r46[r23]
            double r0 = -r0
            r2 = r46[r23]
            r4 = 1
            r59 = r46[r4]
            double r2 = r2 - r59
            double r2 = r2 / r42
            double r0 = r0 / r2
            r10.val = r0
            r0 = r79[r45]
            double r2 = r10.val
            double r0 = r0 + r2
            r79[r45] = r0
            int r0 = r45 + 1
            r44 = r74
            r7 = r0
            goto L_0x0520
        L_0x05e9:
            r7 = r73
            r74 = r44
            r6 = r66
            int r8 = r8 + 1
            double r42 = r42 / r51
            r2 = 2
            goto L_0x051d
        L_0x05f6:
            r7 = r73
            r74 = r44
            r6 = r66
            r0 = 2
            r1 = r79[r0]
            r3 = r79[r0]
            double r3 = swisseph.SweDate.getDeltaT(r3)
            double r1 = r1 - r3
            r79[r0] = r1
            r0 = r79[r14]
            r2 = r79[r14]
            double r2 = swisseph.SweDate.getDeltaT(r2)
            double r0 = r0 - r2
            r79[r14] = r0
        L_0x0613:
            double r34 = r34 - r64
            r0 = 1
            r46[r0] = r34
            r34 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            double r0 = r36 - r34
            r42 = r0
            r8 = 0
        L_0x0622:
            r0 = 2
            if (r8 > r0) goto L_0x06a7
            r0 = r72
            r1 = r42
            r3 = r75
            r4 = r76
            r5 = r74
            r67 = r6
            r6 = r11
            r68 = r7
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            r7 = -1
            if (r0 != r7) goto L_0x063e
            return r7
        L_0x063e:
            swisseph.SwissEph r0 = r13.sw
            r3 = 1
            r1 = r42
            r4 = r74
            r5 = r15
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r7) goto L_0x064f
            return r7
        L_0x064f:
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.square_sum(r15)
            double r0 = swisseph.SMath.sqrt(r0)
            swisseph.SwissLib r2 = r13.sl
            double r2 = r2.square_sum(r11)
            double r2 = swisseph.SMath.sqrt(r2)
            double r4 = r57 / r0
            double r4 = swisseph.SMath.asin(r4)
            double r4 = r4 * r40
            double r6 = r55 / r2
            double r6 = swisseph.SMath.asin(r6)
            double r6 = r6 * r40
            double r6 = r6 + r4
            r4 = 0
        L_0x0675:
            if (r4 >= r14) goto L_0x0688
            r42 = r11[r4]
            double r42 = r42 / r2
            r12[r4] = r42
            r42 = r15[r4]
            double r42 = r42 / r0
            r5 = r68
            r5[r4] = r42
            int r4 = r4 + 1
            goto L_0x0675
        L_0x0688:
            r5 = r68
            swisseph.SwissLib r0 = r13.sl
            double r0 = r0.swi_dot_prod_unit(r12, r5)
            double r0 = swisseph.SMath.acos(r0)
            double r0 = r0 * r40
            r3 = r67
            r3.val = r0
            double r0 = r3.val
            double r6 = r6 - r0
            r46[r8] = r6
            int r8 = r8 + 2
            double r42 = r36 + r34
            r6 = r3
            r7 = r5
            goto L_0x0622
        L_0x06a7:
            r3 = r6
            r5 = r7
            r1 = r46[r23]
            r0 = 1
            r6 = r46[r0]
            r0 = 2
            r42 = r46[r0]
            r44 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            r0 = r72
            r8 = r3
            r3 = r6
            r7 = r5
            r5 = r42
            r69 = r7
            r70 = r8
            r7 = r44
            r61 = r9
            r9 = r10
            r14 = r10
            r10 = r61
            r0.find_zero(r1, r3, r5, r7, r9, r10)
            double r0 = r14.val
            double r0 = r36 + r0
            double r0 = r0 + r34
            r2 = 1
            r79[r2] = r0
            double r0 = r10.val
            double r0 = r36 + r0
            double r0 = r0 + r34
            r8 = 4
            r79[r8] = r0
            r0 = 4574656421491230493(0x3f7c71c71c71c71d, double:0.006944444444444445)
            r34 = r0
            r9 = 0
        L_0x06e6:
            r0 = 3
            if (r9 >= r0) goto L_0x07c4
            r7 = 1
        L_0x06ea:
            if (r7 > r8) goto L_0x07b7
            r1 = r79[r7]
            r6 = r74
            r5 = r6 | 256(0x100, float:3.59E-43)
            r0 = r72
            r3 = r75
            r4 = r76
            r42 = r5
            r43 = r6
            r6 = r11
            r44 = r7
            r7 = r82
            int r0 = r0.calc_planet_star(r1, r3, r4, r5, r6, r7)
            r1 = -1
            if (r0 != r1) goto L_0x0709
            return r1
        L_0x0709:
            swisseph.SwissEph r0 = r13.sw
            r1 = r79[r44]
            r3 = 1
            r4 = r42
            r5 = r15
            r6 = r82
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x071b
            return r1
        L_0x071b:
            r0 = 0
        L_0x071c:
            r1 = 2
            if (r0 >= r1) goto L_0x0796
            r1 = 1
            if (r0 != r1) goto L_0x073d
            r1 = 0
        L_0x0723:
            r2 = 3
            if (r1 >= r2) goto L_0x073d
            r2 = r11[r1]
            int r4 = r1 + 3
            r5 = r11[r4]
            double r5 = r5 * r34
            double r2 = r2 - r5
            r11[r1] = r2
            r2 = r15[r1]
            r4 = r15[r4]
            double r4 = r4 * r34
            double r2 = r2 - r4
            r15[r1] = r2
            int r1 = r1 + 1
            goto L_0x0723
        L_0x073d:
            swisseph.SwissLib r1 = r13.sl
            double r1 = r1.square_sum(r15)
            double r1 = swisseph.SMath.sqrt(r1)
            swisseph.SwissLib r3 = r13.sl
            double r3 = r3.square_sum(r11)
            double r3 = swisseph.SMath.sqrt(r3)
            double r5 = r57 / r1
            double r5 = swisseph.SMath.asin(r5)
            double r5 = r5 * r40
            double r59 = r55 / r3
            double r59 = swisseph.SMath.asin(r59)
            double r59 = r59 * r40
            double r59 = r59 + r5
            r5 = 0
        L_0x0764:
            r6 = 3
            if (r5 >= r6) goto L_0x0777
            r6 = r11[r5]
            double r6 = r6 / r3
            r12[r5] = r6
            r6 = r15[r5]
            double r6 = r6 / r1
            r8 = r69
            r8[r5] = r6
            int r5 = r5 + 1
            r8 = 4
            goto L_0x0764
        L_0x0777:
            r8 = r69
            swisseph.SwissLib r1 = r13.sl
            double r1 = r1.swi_dot_prod_unit(r12, r8)
            double r1 = swisseph.SMath.acos(r1)
            double r1 = r1 * r40
            r6 = r70
            r6.val = r1
            double r1 = swisseph.SMath.abs((double) r59)
            double r3 = r6.val
            double r1 = r1 - r3
            r46[r0] = r1
            int r0 = r0 + 1
            r8 = 4
            goto L_0x071c
        L_0x0796:
            r8 = r69
            r6 = r70
            r0 = r46[r23]
            double r0 = -r0
            r2 = r46[r23]
            r4 = 1
            r59 = r46[r4]
            double r2 = r2 - r59
            double r2 = r2 / r34
            double r0 = r0 / r2
            r14.val = r0
            r0 = r79[r44]
            double r2 = r14.val
            double r0 = r0 + r2
            r79[r44] = r0
            int r7 = r44 + 3
            r74 = r43
            r8 = 4
            goto L_0x06ea
        L_0x07b7:
            r43 = r74
            r8 = r69
            r6 = r70
            int r9 = r9 + 1
            double r34 = r34 / r51
            r8 = 4
            goto L_0x06e6
        L_0x07c4:
            r43 = r74
            r8 = r69
            r6 = r70
            r0 = 1
            r1 = r79[r0]
            r3 = r79[r0]
            double r3 = swisseph.SweDate.getDeltaT(r3)
            double r1 = r1 - r3
            r79[r0] = r1
            r9 = 4
            r0 = r79[r9]
            r2 = r79[r9]
            double r2 = swisseph.SweDate.getDeltaT(r2)
            double r0 = r0 - r2
            r79[r9] = r0
            r5 = r38
            r7 = 4
        L_0x07e5:
            if (r7 < 0) goto L_0x08a8
            r0 = r79[r7]
            r20 = 0
            int r2 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r2 != 0) goto L_0x0812
            r48 = r6
            r34 = r8
            r42 = r14
            r74 = r15
            r35 = r16
            r81 = r17
            r26 = r39
            r25 = r47
            r13 = 1
            r14 = r5
            r15 = r7
            r17 = r11
            r16 = r12
            r38 = r20
            r21 = r33
            r12 = 2
            r33 = 9
            r20 = r10
            r10 = 4
            goto L_0x0886
        L_0x0812:
            r1 = r79[r7]
            r34 = r78[r23]
            r25 = 1
            r40 = r78[r25]
            r38 = 2
            r44 = r78[r38]
            r0 = r72
            r3 = r75
            r4 = r76
            r42 = r14
            r14 = r5
            r5 = r77
            r48 = r6
            r74 = r15
            r15 = r7
            r6 = r34
            r34 = r8
            r8 = r40
            r81 = r17
            r26 = r39
            r17 = r11
            r38 = r20
            r21 = r33
            r33 = 9
            r20 = r10
            r10 = r44
            r35 = r16
            r16 = r12
            r12 = r80
            r25 = r47
            r13 = r82
            int r0 = r0.eclipse_how(r1, r3, r4, r5, r6, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x0856
            return r1
        L_0x0856:
            r0 = r80[r18]
            int r2 = (r0 > r38 ? 1 : (r0 == r38 ? 0 : -1))
            if (r2 <= 0) goto L_0x0883
            r5 = r14 | 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x087d
            r13 = 1
            if (r15 == r13) goto L_0x0878
            r12 = 2
            if (r15 == r12) goto L_0x0874
            r0 = 3
            if (r15 == r0) goto L_0x0870
            r10 = 4
            if (r15 == r10) goto L_0x086d
            goto L_0x0887
        L_0x086d:
            r5 = r5 | 4096(0x1000, float:5.74E-42)
            goto L_0x0887
        L_0x0870:
            r10 = 4
            r5 = r5 | 2048(0x800, float:2.87E-42)
            goto L_0x0887
        L_0x0874:
            r10 = 4
            r5 = r5 | 1024(0x400, float:1.435E-42)
            goto L_0x0887
        L_0x0878:
            r10 = 4
            r12 = 2
            r5 = r5 | 512(0x200, float:7.175E-43)
            goto L_0x0887
        L_0x087d:
            r10 = 4
            r12 = 2
            r13 = 1
            r5 = r5 | 256(0x100, float:3.59E-43)
            goto L_0x0887
        L_0x0883:
            r10 = 4
            r12 = 2
            r13 = 1
        L_0x0886:
            r5 = r14
        L_0x0887:
            int r7 = r15 + -1
            r13 = r72
            r15 = r74
            r12 = r16
            r11 = r17
            r10 = r20
            r33 = r21
            r47 = r25
            r39 = r26
            r8 = r34
            r16 = r35
            r14 = r42
            r6 = r48
            r9 = 4
            r26 = 9
            r17 = r81
            goto L_0x07e5
        L_0x08a8:
            r48 = r6
            r34 = r8
            r20 = r10
            r42 = r14
            r74 = r15
            r35 = r16
            r81 = r17
            r21 = r33
            r26 = r39
            r25 = r47
            r10 = 4
            r13 = 1
            r33 = 9
            r38 = 0
            r14 = r5
            r17 = r11
            r16 = r12
            r12 = 2
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x08ff
            int r11 = r26 * 20
            double r0 = (double) r11
            double r36 = r36 + r0
            r13 = r72
            r8 = r74
            r38 = r14
            r5 = r16
            r9 = r17
            r33 = r21
            r12 = r22
            r24 = r25
            r11 = r26
            r4 = r34
            r16 = r35
            r34 = r36
            r2 = r42
            r10 = r43
            r3 = r46
            r1 = r48
            r6 = r49
            r7 = r50
            r14 = r53
            r0 = -1
            r17 = r81
            r22 = r20
            goto L_0x00a3
        L_0x08ff:
            r0 = r79[r13]
            double r1 = r0 - r28
            r6 = 8193(0x2001, float:1.1481E-41)
            r8 = 0
            r15 = 0
            r0 = r72
            r3 = r75
            r4 = r76
            r5 = r21
            r7 = r78
            r17 = 4
            r10 = r15
            r15 = 2
            r12 = r35
            r16 = 1
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x0925
            return r1
        L_0x0925:
            r0 = r79[r16]
            double r1 = r0 - r28
            r6 = 8194(0x2002, float:1.1482E-41)
            r8 = 0
            r10 = 0
            r0 = r72
            r3 = r75
            r4 = r76
            r5 = r21
            r7 = r78
            r12 = r81
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x0945
            return r1
        L_0x0945:
            r13 = r35
            double r0 = r13.val
            r2 = r79[r16]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x095c
            double r0 = r13.val
            r2 = r79[r17]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x095c
            r0 = 5
            double r1 = r13.val
            r79[r0] = r1
        L_0x095c:
            r12 = r81
            double r0 = r12.val
            r2 = r79[r16]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0972
            double r0 = r12.val
            r2 = r79[r17]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0972
            double r0 = r12.val
            r79[r18] = r0
        L_0x0972:
            r1 = r79[r15]
            r3 = 0
            r4 = 0
            r6 = 1
            r8 = 0
            r10 = 0
            r0 = r72
            r5 = r21
            r7 = r78
            r81 = r12
            r12 = r13
            r71 = r13
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x0990
            return r1
        L_0x0990:
            r1 = r79[r15]
            r3 = 0
            r4 = 0
            r6 = 2
            r8 = 0
            r10 = 0
            r0 = r72
            r5 = r21
            r7 = r78
            r12 = r81
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x09ab
            return r1
        L_0x09ab:
            r15 = r81
            double r0 = r15.val
            r13 = r71
            double r2 = r13.val
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x09ba
            r5 = r14 | 8192(0x2000, float:1.14794E-41)
            r14 = r5
        L_0x09ba:
            r0 = 3
            r1 = r79[r0]
            r3 = 0
            r4 = 0
            r6 = 1
            r8 = 0
            r10 = 0
            r0 = r72
            r5 = r21
            r7 = r78
            r12 = r13
            r16 = r14
            r14 = r13
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x09d8
            return r1
        L_0x09d8:
            r0 = 3
            r1 = r79[r0]
            r3 = 0
            r4 = 0
            r6 = 2
            r8 = 0
            r10 = 0
            r0 = r72
            r5 = r21
            r7 = r78
            r12 = r15
            r13 = r82
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r1 = -1
            if (r0 != r1) goto L_0x09f3
            return r1
        L_0x09f3:
            double r0 = r15.val
            double r2 = r14.val
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a00
            r5 = r16
            r14 = r5 | 16384(0x4000, float:2.2959E-41)
            goto L_0x0a03
        L_0x0a00:
            r5 = r16
            r14 = r5
        L_0x0a03:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.occult_when_loc(double, int, java.lang.StringBuffer, int, double[], double[], double[], int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public void swe_azalt(double d, int i, double[] dArr, double d2, double d3, double[] dArr2, double[] dArr3) {
        char c;
        double d4;
        double d5 = d;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[3];
        SwissLib swissLib = this.sl;
        double swe_degnorm = swissLib.swe_degnorm((swissLib.swe_sidtime(d5) * 15.0d) + dArr[0]);
        for (int i2 = 0; i2 < 2; i2++) {
            dArr5[i2] = dArr2[i2];
        }
        dArr5[2] = 1.0d;
        if (i == 0) {
            this.sw.swe_calc(d5 + SweDate.getDeltaT(d), -1, 0, dArr4, (StringBuffer) null);
            c = 2;
            this.sl.swe_cotrans(dArr5, 0, dArr5, 0, -dArr4[0]);
        } else {
            c = 2;
        }
        dArr4[0] = this.sl.swe_degnorm(this.sl.swe_degnorm(dArr5[0] - swe_degnorm) - 90.0d);
        dArr4[1] = dArr5[1];
        dArr4[c] = 1.0d;
        this.sl.swe_cotrans(dArr4, 0, dArr4, 0, 90.0d - dArr[1]);
        dArr4[0] = this.sl.swe_degnorm(dArr4[0] + 90.0d);
        dArr3[0] = 360.0d - dArr4[0];
        dArr3[1] = dArr4[1];
        if (d2 == 0.0d) {
            d4 = 1013.25d * SMath.pow(1.0d - ((dArr[c] * 0.0065d) / 288.0d), 5.255d);
        } else {
            d4 = d2;
        }
        dArr3[c] = swe_refrac_extended(dArr4[1], dArr[c], d4, d3, this.const_lapse_rate, 0, (double[]) null);
    }

    /* access modifiers changed from: package-private */
    public void swe_azalt_rev(double d, int i, double[] dArr, double[] dArr2, double[] dArr3) {
        double d2 = d;
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[3];
        double d3 = dArr[0];
        double d4 = dArr[1];
        SwissLib swissLib = this.sl;
        double swe_degnorm = swissLib.swe_degnorm((swissLib.swe_sidtime(d2) * 15.0d) + d3);
        for (int i2 = 0; i2 < 2; i2++) {
            dArr5[i2] = dArr2[i2];
        }
        dArr5[2] = 1.0d;
        dArr5[0] = 360.0d - dArr5[0];
        dArr5[0] = this.sl.swe_degnorm(dArr5[0] - 90.0d);
        this.sl.swe_cotrans(dArr5, 0, dArr5, 0, d4 - 90.0d);
        dArr5[0] = this.sl.swe_degnorm(dArr5[0] + swe_degnorm + 90.0d);
        dArr3[0] = dArr5[0];
        dArr3[1] = dArr5[1];
        if (i == 0) {
            this.sw.swe_calc(d2 + SweDate.getDeltaT(d), -1, 0, dArr4, (StringBuffer) null);
            this.sl.swe_cotrans(dArr5, 0, dArr4, 0, dArr4[0]);
            dArr3[0] = dArr4[0];
            dArr3[1] = dArr4[1];
        }
    }

    /* access modifiers changed from: package-private */
    public double swe_refrac(double d, double d2, double d3, int i) {
        double d4;
        double d5;
        double d6;
        double d7 = ((d2 / 1010.0d) * 283.0d) / (d3 + 273.0d);
        if (i == 0) {
            if (d > 15.0d) {
                double tan = SMath.tan((90.0d - d) * 0.0174532925199433d);
                d5 = ((58.276d * tan) - (((0.0824d * tan) * tan) * tan)) * (d7 / 3600.0d);
            } else if (d > -5.0d) {
                double d8 = d + (10.3d / (d + 5.11d));
                if (1.0E-10d + d8 >= 90.0d) {
                    d6 = 0.0d;
                } else {
                    d6 = 1.02d / SMath.tan(d8 * 0.0174532925199433d);
                }
                d5 = d6 * (d7 / 60.0d);
            } else {
                d5 = 0.0d;
            }
            double d9 = d + d5;
            if (d9 > 0.0d) {
                return d9;
            }
            return d;
        }
        double d10 = d + (7.31d / (d + 4.4d));
        if (1.0E-10d + d10 >= 90.0d) {
            d4 = 0.0d;
        } else {
            double tan2 = 1.0d / SMath.tan(d10 * 0.0174532925199433d);
            d4 = tan2 - (SMath.sin((14.7d * tan2) + 13.0d) * 0.06d);
        }
        double d11 = d - (d4 * (d7 / 60.0d));
        if (d11 > 0.0d) {
            return d11;
        }
        return d;
    }

    /* access modifiers changed from: package-private */
    public void swe_set_lapse_rate(double d) {
        this.const_lapse_rate = d;
    }

    /* access modifiers changed from: package-private */
    public double swe_refrac_extended(double d, double d2, double d3, double d4, double d5, int i, double[] dArr) {
        double d6;
        double d7;
        double[] dArr2 = dArr;
        double calc_dip = calc_dip(d2, d3, d4, d5);
        if (d > 90.0d) {
            d6 = 180.0d - d;
        } else {
            d6 = d;
        }
        if (i != 0) {
            double calc_astronomical_refr = calc_astronomical_refr(d6, d3, d4);
            double d8 = d6 - calc_astronomical_refr;
            if (dArr2 != null) {
                if (d6 > calc_dip) {
                    dArr2[0] = d8;
                    dArr2[1] = d6;
                    dArr2[2] = calc_astronomical_refr;
                    dArr2[3] = calc_dip;
                } else {
                    dArr2[0] = d6;
                    dArr2[1] = d6;
                    dArr2[2] = 0.0d;
                    dArr2[3] = calc_dip;
                }
            }
            if (d8 > calc_dip) {
                return d8;
            }
            return d6;
        } else if (d6 < -10.0d) {
            if (dArr2 != null && dArr2.length > 3) {
                dArr2[0] = d6;
                dArr2[1] = d6;
                dArr2[2] = 0.0d;
                dArr2[3] = calc_dip;
            }
            return d6;
        } else {
            double d9 = d6;
            double d10 = 0.0d;
            double d11 = 0.0d;
            int i2 = 0;
            while (i2 < 5) {
                double calc_astronomical_refr2 = calc_astronomical_refr(d9, d3, d4);
                double d12 = d9 - d11;
                double d13 = (calc_astronomical_refr2 - d10) - d12;
                if (d12 == 0.0d || d13 == 0.0d) {
                    d7 = d6 + calc_astronomical_refr2;
                } else {
                    d7 = d9 - ((d12 * ((d6 + calc_astronomical_refr2) - d9)) / d13);
                }
                i2++;
                d11 = d9;
                d9 = d7;
                d10 = calc_astronomical_refr2;
            }
            double d14 = d6 + d10;
            if (d14 < calc_dip) {
                if (dArr2 != null) {
                    dArr2[0] = d6;
                    dArr2[1] = d6;
                    dArr2[2] = 0.0d;
                    dArr2[3] = calc_dip;
                }
                return d6;
            }
            if (dArr2 != null) {
                dArr2[0] = d6;
                dArr2[1] = d14;
                dArr2[2] = d10;
                dArr2[3] = calc_dip;
            }
            return d14;
        }
    }

    private double calc_astronomical_refr(double d, double d2, double d3) {
        double d4;
        if (d > 17.904104638432d) {
            d4 = 0.97d / SMath.tan(d * 0.0174532925199433d);
        } else {
            d4 = (((4.23d * d) + 34.46d) + ((0.004d * d) * d)) / (((0.505d * d) + 1.0d) + ((0.0845d * d) * d));
        }
        return ((((d2 - 80.0d) / 930.0d) / ((((39.0d + d4) * 8.0E-5d) * (d3 - 10.0d)) + 1.0d)) * d4) / 60.0d;
    }

    private double calc_dip(double d, double d2, double d3, double d4) {
        double d5 = d3 + 273.16d;
        return SMath.acos(1.0d / ((d / 6378136.6d) + 1.0d)) * -57.29577951308232d * SMath.sqrt(1.0d - ((((((d4 + 0.0342d) / 0.0036652000000000004d) * 1.848d) * d2) / d5) / d5));
    }

    /* access modifiers changed from: package-private */
    public int swe_lun_eclipse_how(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        int i2 = i & -32769 & -786433;
        int lun_eclipse_how = lun_eclipse_how(d, i2, dArr2, new double[10], stringBuffer);
        if (dArr == null) {
            return lun_eclipse_how;
        }
        this.sw.swe_set_topo(dArr[0], dArr[1], dArr[2]);
        if (this.sw.swe_calc_ut(d, 1, 32768 | i2 | 2048, dArr3, stringBuffer) == -1) {
            return -1;
        }
        double[] dArr5 = dArr4;
        swe_azalt(d, 1, dArr, 0.0d, 10.0d, dArr3, dArr4);
        dArr2[4] = dArr5[0];
        dArr2[5] = dArr5[1];
        dArr2[6] = dArr5[2];
        if (dArr5[2] <= 0.0d) {
            return 0;
        }
        return lun_eclipse_how;
    }

    private int lun_eclipse_how(double d, int i, double[] dArr, double[] dArr2, StringBuffer stringBuffer) {
        int i2;
        StringBuffer stringBuffer2 = stringBuffer;
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[6];
        int i3 = 0;
        for (int i4 = 0; i4 < 10; i4++) {
            dArr2[i4] = 0.0d;
        }
        for (int i5 = 0; i5 < 20; i5++) {
            dArr[i5] = 0.0d;
        }
        int i6 = i | 2304 | 4096;
        double deltaT = d + SweDate.getDeltaT(d);
        double d2 = deltaT;
        int i7 = i6;
        if (this.sw.swe_calc(deltaT, 1, i6, dArr4, stringBuffer) == -1) {
            return -1;
        }
        double sqrt = SMath.sqrt(this.sl.square_sum(dArr4));
        if (this.sw.swe_calc(d2, 0, i7, dArr5, stringBuffer) == -1) {
            return -1;
        }
        double sqrt2 = SMath.sqrt(this.sl.square_sum(dArr5));
        for (int i8 = 0; i8 < 3; i8++) {
            dArr6[i8] = dArr5[i8] / sqrt2;
            dArr7[i8] = dArr4[i8] / sqrt;
        }
        double acos = SMath.acos(this.sl.swi_dot_prod_unit(dArr6, dArr7)) * 57.2957795130823d;
        for (int i9 = 0; i9 <= 2; i9++) {
            dArr5[i9] = dArr5[i9] - dArr4[i9];
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            dArr4[i10] = -dArr4[i10];
        }
        for (int i11 = 0; i11 <= 2; i11++) {
            dArr3[i11] = dArr4[i11] - dArr5[i11];
        }
        double sqrt3 = SMath.sqrt(this.sl.square_sum(dArr3));
        for (int i12 = 0; i12 <= 2; i12++) {
            dArr3[i12] = dArr3[i12] / sqrt3;
        }
        double d3 = 0.004609837405823407d / sqrt3;
        double sqrt4 = SMath.sqrt(1.0d - (d3 * d3));
        double d4 = 0.004695107870862257d / sqrt3;
        double sqrt5 = SMath.sqrt(1.0d - (d4 * d4));
        double d5 = -this.sw.dot_prod(dArr4, dArr3);
        double sqrt6 = SMath.sqrt((sqrt * sqrt) - (d5 * d5));
        double d6 = d5 / sqrt3;
        double abs = (((SMath.abs((0.009219674811646815d * d6) - DEARTH) * 1.02d) / sqrt4) / sqrt4) * 0.99405d;
        double d7 = (((((d6 * 0.009390215741724514d) + DEARTH) * 1.02d) / sqrt5) / sqrt5) * 0.98813d;
        dArr2[0] = sqrt6;
        dArr2[1] = abs;
        dArr2[2] = d7;
        dArr2[3] = sqrt4;
        int i13 = 4;
        dArr2[4] = sqrt5;
        double d8 = abs / 2.0d;
        double d9 = RMOON / sqrt4;
        if (d8 >= sqrt6 + d9) {
            dArr[0] = ((d8 - sqrt6) + RMOON) / DMOON;
        } else if (d8 >= sqrt6 - d9) {
            i13 = 16;
            dArr[0] = ((d8 - sqrt6) + RMOON) / DMOON;
        } else if (d7 / 2.0d >= sqrt6 - (RMOON / sqrt5)) {
            i13 = 64;
            dArr[0] = 0.0d;
        } else {
            if (stringBuffer2 != null) {
                stringBuffer2.setLength(0);
                stringBuffer2.append("no lunar eclipse at tjd = " + d2);
            }
            i13 = 0;
        }
        dArr[8] = dArr[0];
        dArr[1] = (((d7 / 2.0d) - sqrt6) + RMOON) / DMOON;
        if (i13 != 0) {
            dArr[7] = 180.0d - SMath.abs(acos);
        }
        while (true) {
            i2 = NSAROS_LUNAR;
            if (i3 >= i2) {
                break;
            }
            SarosData[] sarosDataArr = saros_data_lunar;
            double d10 = (d - sarosDataArr[i3].tstart) / SAROS_CYCLE;
            if (d10 >= 0.0d) {
                int i14 = (int) d10;
                double d11 = (double) i14;
                if ((d10 - d11) * SAROS_CYCLE < 2.0d) {
                    dArr[9] = (double) sarosDataArr[i3].series_no;
                    dArr[10] = d11 + 1.0d;
                    break;
                }
                double d12 = (double) (i14 + 1);
                if ((d12 - d10) * SAROS_CYCLE < 2.0d) {
                    dArr[9] = (double) sarosDataArr[i3].series_no;
                    dArr[10] = d12 + 1.0d;
                    break;
                }
            }
            i3++;
        }
        if (i3 == i2) {
            dArr[10] = -9.9999999E7d;
            dArr[9] = -9.9999999E7d;
        }
        return i13;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_lun_eclipse_when(double r49, int r51, int r52, double[] r53, int r54, java.lang.StringBuffer r55) {
        /*
            r48 = this;
            r11 = r48
            swisseph.DblObj r12 = new swisseph.DblObj
            r12.<init>()
            r13 = 6
            double[] r14 = new double[r13]
            double[] r15 = new double[r13]
            r0 = 10
            double[] r10 = new double[r0]
            r9 = 3
            double[] r7 = new double[r9]
            swisseph.DblObj r16 = new swisseph.DblObj
            r16.<init>()
            swisseph.DblObj r8 = new swisseph.DblObj
            r5 = 0
            r8.<init>(r5)
            swisseph.DblObj r4 = new swisseph.DblObj
            r4.<init>(r5)
            r0 = 20
            double[] r3 = new double[r0]
            double[] r1 = new double[r13]
            double[] r2 = new double[r13]
            r17 = 7
            r0 = r51 & 7
            r13 = r0 | 2048(0x800, float:2.87E-42)
            r13 = r13 | 4096(0x1000, float:5.74E-42)
            if (r52 != 0) goto L_0x003d
            r18 = 84
            goto L_0x003f
        L_0x003d:
            r18 = r52
        L_0x003f:
            if (r54 == 0) goto L_0x0043
            r9 = -1
            goto L_0x0044
        L_0x0043:
            r9 = 1
        L_0x0044:
            r20 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            double r20 = r49 - r20
            r22 = 4645133030202938491(0x4076d3e147ae147b, double:365.2425)
            double r20 = r20 / r22
            r22 = 4623152464553649897(0x4028bcac083126e9, double:12.3685)
            double r5 = r20 * r22
            int r5 = (int) r5
            double r5 = (double) r5
            r21 = r3
            r20 = r4
            double r3 = (double) r9
            double r5 = r5 - r3
            r22 = r5
        L_0x0063:
            r26 = 0
            r5 = 0
        L_0x0067:
            r6 = 9
            if (r5 > r6) goto L_0x0072
            r24 = 0
            r53[r5] = r24
            int r5 = r5 + 1
            goto L_0x0067
        L_0x0072:
            r24 = 0
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r22 + r5
            r27 = 4653154539273610854(0x4093536666666666, double:1236.85)
            double r27 = r5 / r27
            double r29 = r27 * r27
            double r31 = r29 * r27
            double r33 = r31 * r27
            swisseph.SwissLib r9 = r11.sl
            r35 = 4639858525150134246(0x406416bedfa43fe6, double:160.7108)
            r37 = 4645580364357878491(0x40786aba6114c2db, double:390.67050274)
            double r37 = r37 * r5
            double r37 = r37 + r35
            r35 = 4565178779021654147(0x3f5ac5e983bcb883, double:0.0016341)
            double r35 = r35 * r29
            double r37 = r37 - r35
            r35 = 4522470312210664535(0x3ec30ac9b2910c57, double:2.27E-6)
            double r35 = r35 * r31
            double r37 = r37 - r35
            r35 = 4487730721241523980(0x3e479f505f35670c, double:1.1E-8)
            double r35 = r35 * r33
            r40 = r0
            r39 = r1
            double r0 = r37 + r35
            double r0 = r9.swe_degnorm(r0)
            r35 = 4640537203540230144(0x4066800000000000, double:180.0)
            int r9 = (r0 > r35 ? 1 : (r0 == r35 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            double r35 = r0 - r35
            goto L_0x00c6
        L_0x00c4:
            r35 = r0
        L_0x00c6:
            r37 = 4626604192193052672(0x4035000000000000, double:21.0)
            int r9 = (r35 > r37 ? 1 : (r35 == r37 ? 0 : -1))
            if (r9 <= 0) goto L_0x00dc
            r37 = 4639798331726364672(0x4063e00000000000, double:159.0)
            int r9 = (r35 > r37 ? 1 : (r35 == r37 ? 0 : -1))
            if (r9 >= 0) goto L_0x00dc
            double r22 = r22 + r3
            r1 = r39
            r0 = r40
            goto L_0x0063
        L_0x00dc:
            r35 = 4702519075094383506(0x4142b42f0c7fcb92, double:2451550.09765)
            r37 = 4629005339491779029(0x403d87d4abcb41d5, double:29.530588853)
            double r37 = r37 * r5
            double r37 = r37 + r35
            r35 = 4549064683382140398(0x3f21863a41446dee, double:1.337E-4)
            double r35 = r35 * r29
            double r37 = r37 + r35
            r35 = 4504762867522569078(0x3e8421f5f40d8376, double:1.5E-7)
            double r35 = r35 * r31
            double r37 = r37 - r35
            r35 = 4470127357510710970(0x3e091525dd2e76ba, double:7.3E-10)
            double r35 = r35 * r33
            double r37 = r37 + r35
            swisseph.SwissLib r9 = r11.sl
            r35 = 4612932164444281320(0x40046d5cfaacd9e8, double:2.5534)
            r41 = 4628885647278601982(0x403d1af8a7f1f6fe, double:29.10535669)
            double r41 = r41 * r5
            double r41 = r41 + r35
            r35 = 4537055449467628868(0x3ef6dbe497c4ad44, double:2.18E-5)
            double r35 = r35 * r29
            double r41 = r41 - r35
            r35 = 4502903793125605584(0x3e7d87247702c0d0, double:1.1E-7)
            double r35 = r35 * r31
            r43 = r2
            r44 = r3
            double r2 = r41 - r35
            double r2 = r9.swe_degnorm(r2)
            swisseph.SwissLib r4 = r11.sl
            r35 = 4641295929895265344(0x4069320ebedfa440, double:201.5643)
            r41 = 4645494979496143047(0x40781d122aba68c7, double:385.81693528)
            double r41 = r41 * r5
            double r41 = r41 + r35
            r35 = 4591995834099441060(0x3fba0be1b5921da4, double:0.1017438)
            double r35 = r35 * r29
            double r41 = r41 + r35
            r35 = 4533431390597692843(0x3ee9fbd4a22e3dab, double:1.239E-5)
            double r35 = r35 * r31
            double r41 = r41 + r35
            r35 = 4498853540680590574(0x3e6f237594c664ee, double:5.8E-8)
            double r33 = r33 * r35
            r35 = r8
            double r8 = r41 + r33
            double r8 = r4.swe_degnorm(r8)
            swisseph.SwissLib r4 = r11.sl
            r33 = 4638480648844140243(0x405f31930be0ded3, double:124.7746)
            r41 = 4609721349210825364(0x3ff90524cd3ee294, double:1.5637558)
            double r41 = r41 * r5
            double r33 = r33 - r41
            r41 = 4566917442296676502(0x3f60f3379aa10096, double:0.0020691)
            double r41 = r41 * r29
            double r33 = r33 + r41
            r41 = 4522186970221692357(0x3ec20916fff6c5c5, double:2.15E-6)
            double r31 = r31 * r41
            r36 = r14
            r41 = r15
            double r14 = r33 + r31
            double r14 = r4.swe_degnorm(r14)
            r31 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r33 = 4567947923537494102(0x3f649c6f36ef8056, double:0.002516)
            double r27 = r27 * r33
            double r31 = r31 - r27
            r27 = 4530350403873286828(0x3edf09b082ea2aac, double:7.4E-6)
            double r27 = r27 * r29
            double r31 = r31 - r27
            swisseph.SwissLib r4 = r11.sl
            r27 = 4643981225802145464(0x4072bc51eb851eb8, double:299.77)
            r33 = 4592403982723590692(0x3fbb7f1737542a24, double:0.107408)
            double r5 = r5 * r33
            double r5 = r5 + r27
            r27 = 4576441496261932744(0x3f82c94b380cb6c8, double:0.009173)
            double r29 = r29 * r27
            double r5 = r5 - r29
            double r4 = r4.swe_degnorm(r5)
            r27 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            double r2 = r2 * r27
            double r8 = r8 * r27
            double r0 = r0 * r27
            double r14 = r14 * r27
            r29 = 4583338560932867054(0x3f9b4a2339c0ebee, double:0.02665)
            double r33 = swisseph.SMath.sin(r14)
            double r33 = r33 * r29
            double r33 = r33 * r27
            double r0 = r0 - r33
            double r4 = r4 * r27
            r27 = 4601012487310519828(0x3fda147ae147ae14, double:0.4075)
            double r29 = swisseph.SMath.sin(r8)
            double r29 = r29 * r27
            double r37 = r37 - r29
            r27 = 4595368576257499123(0x3fc6075f6fd21ff3, double:0.1721)
            double r27 = r27 * r31
            double r29 = swisseph.SMath.sin(r2)
            double r27 = r27 * r29
            double r37 = r37 + r27
            r27 = 4580297730464466495(0x3f907c84b5dcc63f, double:0.0161)
            r29 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r33 = r8 * r29
            double r46 = swisseph.SMath.sin(r33)
            double r46 = r46 * r27
            double r37 = r37 + r46
            r27 = 4576745291078396648(0x3f83dd97f62b6ae8, double:0.0097)
            double r0 = r0 * r29
            double r46 = swisseph.SMath.sin(r0)
            double r46 = r46 * r27
            double r37 = r37 - r46
            r27 = 4575066349137312927(0x3f7de69ad42c3c9f, double:0.0073)
            double r27 = r27 * r31
            double r46 = r8 - r2
            double r46 = swisseph.SMath.sin(r46)
            double r27 = r27 * r46
            double r37 = r37 + r27
            r27 = 4572414629676717179(0x3f747ae147ae147b, double:0.005)
            double r27 = r27 * r31
            double r46 = r8 + r2
            double r46 = swisseph.SMath.sin(r46)
            double r27 = r27 * r46
            double r37 = r37 - r27
            r27 = 4567449861447503944(0x3f62d77318fc5048, double:0.0023)
            double r46 = r8 - r0
            double r46 = swisseph.SMath.sin(r46)
            double r46 = r46 * r27
            double r37 = r37 - r46
            r27 = 4566988692845661205(0x3f613404ea4a8c15, double:0.0021)
            double r27 = r27 * r31
            double r46 = r2 * r29
            double r46 = swisseph.SMath.sin(r46)
            double r27 = r27 * r46
            double r37 = r37 + r27
            r27 = 4563176846121054817(0x3f53a92a30553261, double:0.0012)
            double r46 = r8 + r0
            double r46 = swisseph.SMath.sin(r46)
            double r46 = r46 * r27
            double r37 = r37 + r46
            r27 = 4558673246493684321(0x3f43a92a30553261, double:6.0E-4)
            double r27 = r27 * r31
            double r46 = r33 + r2
            double r46 = swisseph.SMath.sin(r46)
            double r27 = r27 * r46
            double r37 = r37 + r27
            r27 = 4556014321273684781(0x3f3a36e2eb1c432d, double:4.0E-4)
            r46 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r8 = r8 * r46
            double r8 = swisseph.SMath.sin(r8)
            double r8 = r8 * r27
            double r37 = r37 - r8
            r8 = 4554169646866313825(0x3f33a92a30553261, double:3.0E-4)
            double r27 = r31 * r8
            double r46 = r2 + r0
            double r46 = swisseph.SMath.sin(r46)
            double r27 = r27 * r46
            double r37 = r37 - r27
            double r4 = swisseph.SMath.sin(r4)
            double r4 = r4 * r8
            double r37 = r37 + r4
            r4 = 4551510721646314285(0x3f2a36e2eb1c432d, double:2.0E-4)
            double r31 = r31 * r4
            double r0 = r2 - r0
            double r0 = swisseph.SMath.sin(r0)
            double r0 = r0 * r31
            double r37 = r37 - r0
            double r33 = r33 - r2
            double r0 = swisseph.SMath.sin(r33)
            double r31 = r31 * r0
            double r37 = r37 - r31
            double r0 = swisseph.SMath.sin(r14)
            double r0 = r0 * r4
            double r37 = r37 - r0
            r0 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            r2 = 4701340746312056832(0x413e848000000000, double:2000000.0)
            int r4 = (r37 > r2 ? 1 : (r37 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x02d4
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x02d4:
            r27 = r0
        L_0x02d7:
            r0 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            r9 = 2
            int r2 = (r27 > r0 ? 1 : (r27 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e1
            double r0 = r37 - r27
            r31 = r0
            r8 = 0
        L_0x02e6:
            if (r8 > r9) goto L_0x03a0
            swisseph.SwissEph r0 = r11.sw
            r3 = 0
            r33 = r40
            r6 = r39
            r5 = r43
            r1 = r31
            r39 = r44
            r34 = r20
            r4 = r13
            r14 = r5
            r5 = r36
            r15 = r6
            r6 = r55
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r6 = -1
            if (r0 != r6) goto L_0x0306
            return r6
        L_0x0306:
            swisseph.SwissEph r0 = r11.sw
            r3 = 1
            r1 = r31
            r4 = r13
            r5 = r41
            r9 = -1
            r6 = r55
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r9) goto L_0x0318
            return r9
        L_0x0318:
            r0 = 0
        L_0x0319:
            r1 = 3
            if (r0 >= r1) goto L_0x032b
            r1 = r36[r0]
            r3 = r41[r0]
            double r1 = r1 - r3
            r36[r0] = r1
            r1 = r41[r0]
            double r1 = -r1
            r41[r0] = r1
            int r0 = r0 + 1
            goto L_0x0319
        L_0x032b:
            swisseph.SwissLib r0 = r11.sl
            r5 = r36
            double r0 = r0.square_sum(r5)
            double r0 = swisseph.SMath.sqrt(r0)
            swisseph.SwissLib r2 = r11.sl
            r6 = r41
            double r2 = r2.square_sum(r6)
            double r2 = swisseph.SMath.sqrt(r2)
            r4 = 0
        L_0x0344:
            r9 = 3
            if (r4 >= r9) goto L_0x0357
            r44 = r5[r4]
            double r44 = r44 / r0
            r15[r4] = r44
            r44 = r6[r4]
            double r44 = r44 / r2
            r14[r4] = r44
            int r4 = r4 + 1
            r9 = -1
            goto L_0x0344
        L_0x0357:
            swisseph.SwissLib r4 = r11.sl
            double r44 = r4.swi_dot_prod_unit(r15, r14)
            double r44 = swisseph.SMath.acos(r44)
            r46 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r44 = r44 * r46
            r7[r8] = r44
            r44 = 4541416674544560959(0x3f065a676f43ab3f, double:4.263523251942522E-5)
            double r44 = r44 / r2
            double r2 = swisseph.SMath.asin(r44)
            double r2 = r2 * r46
            r44 = 4572013957908023349(0x3f730e789d3c4835, double:0.004652472638342832)
            double r44 = r44 / r0
            double r0 = swisseph.SMath.asin(r44)
            double r0 = r0 * r46
            r44 = r7[r8]
            double r2 = r2 + r0
            double r44 = r44 - r2
            r7[r8] = r44
            int r8 = r8 + 1
            double r31 = r31 + r27
            r36 = r5
            r41 = r6
            r43 = r14
            r20 = r34
            r44 = r39
            r9 = 2
            r39 = r15
            r40 = r33
            goto L_0x02e6
        L_0x03a0:
            r34 = r20
            r5 = r36
            r15 = r39
            r33 = r40
            r6 = r41
            r14 = r43
            r39 = r44
            r9 = 3
            r1 = r7[r26]
            r19 = 1
            r3 = r7[r19]
            r0 = 2
            r31 = r7[r0]
            r0 = r48
            r5 = r31
            r31 = r7
            r7 = r27
            r11 = -1
            r9 = r12
            r20 = r10
            r10 = r16
            r0.find_maximum(r1, r3, r5, r7, r9, r10)
            double r0 = r12.val
            double r0 = r0 + r27
            double r37 = r37 + r0
            r0 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r27 = r27 / r0
            r11 = r48
            r10 = r20
            r7 = r31
            r20 = r34
            r39 = r15
            r40 = r33
            goto L_0x02d7
        L_0x03e1:
            r31 = r7
            r34 = r20
            r15 = r39
            r33 = r40
            r14 = r43
            r39 = r44
            r11 = -1
            r20 = r10
            double r0 = swisseph.SweDate.getDeltaT(r37)
            double r37 = r37 - r0
            r4 = 0
            r0 = r48
            r1 = r37
            r3 = r33
            r5 = r21
            r6 = r55
            int r10 = r0.swe_lun_eclipse_how(r1, r3, r4, r5, r6)
            if (r10 != r11) goto L_0x0408
            return r10
        L_0x0408:
            if (r10 != 0) goto L_0x0422
            double r22 = r22 + r39
            r11 = r48
            r2 = r14
            r1 = r15
            r10 = r20
            r7 = r31
            r0 = r33
            r20 = r34
            r8 = r35
            r14 = r36
            r3 = r39
            r15 = r41
            goto L_0x0063
        L_0x0422:
            r53[r26] = r37
            r0 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            if (r54 == 0) goto L_0x0433
            r2 = r53[r26]
            double r4 = r49 - r0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x043d
        L_0x0433:
            if (r54 != 0) goto L_0x0455
            r2 = r53[r26]
            double r0 = r49 + r0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x0455
        L_0x043d:
            double r22 = r22 + r39
            r11 = r48
            r2 = r14
            r1 = r15
            r10 = r20
            r7 = r31
            r0 = r33
            r20 = r34
            r8 = r35
            r14 = r36
            r3 = r39
            r15 = r41
            goto L_0x0063
        L_0x0455:
            r0 = r18 & 64
            if (r0 != 0) goto L_0x0475
            r0 = r10 & 64
            if (r0 == 0) goto L_0x0475
            double r22 = r22 + r39
            r11 = r48
            r2 = r14
            r1 = r15
            r10 = r20
            r7 = r31
            r0 = r33
            r20 = r34
            r8 = r35
            r14 = r36
            r3 = r39
            r15 = r41
            goto L_0x0063
        L_0x0475:
            r0 = r18 & 16
            if (r0 != 0) goto L_0x0495
            r0 = r10 & 16
            if (r0 == 0) goto L_0x0495
            double r22 = r22 + r39
            r11 = r48
            r2 = r14
            r1 = r15
            r10 = r20
            r7 = r31
            r0 = r33
            r20 = r34
            r8 = r35
            r14 = r36
            r3 = r39
            r15 = r41
            goto L_0x0063
        L_0x0495:
            r0 = r18 & 4
            if (r0 != 0) goto L_0x04b5
            r0 = r10 & 4
            if (r0 == 0) goto L_0x04b5
            double r22 = r22 + r39
            r11 = r48
            r2 = r14
            r1 = r15
            r10 = r20
            r7 = r31
            r0 = r33
            r20 = r34
            r8 = r35
            r14 = r36
            r3 = r39
            r15 = r41
            goto L_0x0063
        L_0x04b5:
            r0 = r10 & 64
            if (r0 == 0) goto L_0x04bb
            r12 = 0
            goto L_0x04c2
        L_0x04bb:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x04c1
            r12 = 1
            goto L_0x04c2
        L_0x04c1:
            r12 = 2
        L_0x04c2:
            r0 = 0
            r9 = 0
            r13 = 0
        L_0x04c7:
            if (r13 > r12) goto L_0x0623
            r14 = 4
            if (r13 != 0) goto L_0x04cf
            r9 = 7
            r15 = 6
            goto L_0x04dc
        L_0x04cf:
            r1 = 1
            if (r13 != r1) goto L_0x04d5
            r9 = 3
            r15 = 2
            goto L_0x04dc
        L_0x04d5:
            r1 = 2
            if (r13 != r1) goto L_0x04db
            r9 = 5
            r15 = 4
            goto L_0x04dc
        L_0x04db:
            r15 = r0
        L_0x04dc:
            r22 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            double r0 = r37 - r22
            r7 = r0
            r6 = 0
        L_0x04e5:
            r24 = 4532976163387923579(0x3ee85dcdca0cdc7b, double:1.1618815109677577E-5)
            r0 = 2
            if (r6 > r0) goto L_0x0541
            r0 = r48
            r1 = r7
            r3 = r33
            r4 = r21
            r5 = r20
            r16 = r6
            r6 = r55
            int r0 = r0.lun_eclipse_how(r1, r3, r4, r5, r6)
            if (r0 != r11) goto L_0x0501
            return r0
        L_0x0501:
            if (r13 != 0) goto L_0x0514
            r0 = 2
            r1 = r20[r0]
            double r1 = r1 / r29
            r3 = r20[r14]
            double r24 = r24 / r3
            double r1 = r1 + r24
            r3 = r20[r26]
            double r1 = r1 - r3
            r31[r16] = r1
            goto L_0x053c
        L_0x0514:
            r0 = 1
            if (r13 != r0) goto L_0x0528
            r1 = r20[r0]
            double r1 = r1 / r29
            r0 = 3
            r3 = r20[r0]
            double r24 = r24 / r3
            double r1 = r1 + r24
            r3 = r20[r26]
            double r1 = r1 - r3
            r31[r16] = r1
            goto L_0x053c
        L_0x0528:
            r0 = 2
            if (r13 != r0) goto L_0x053c
            r0 = 1
            r1 = r20[r0]
            double r1 = r1 / r29
            r0 = 3
            r3 = r20[r0]
            double r24 = r24 / r3
            double r1 = r1 - r24
            r3 = r20[r26]
            double r1 = r1 - r3
            r31[r16] = r1
        L_0x053c:
            int r6 = r16 + 1
            double r7 = r7 + r22
            goto L_0x04e5
        L_0x0541:
            r1 = r31[r26]
            r0 = 1
            r3 = r31[r0]
            r16 = 2
            r5 = r31[r16]
            r7 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            r0 = r48
            r14 = r9
            r11 = 2
            r9 = r35
            r16 = r10
            r10 = r34
            r0.find_zero(r1, r3, r5, r7, r9, r10)
            r7 = r35
            double r0 = r7.val
            double r0 = r0 + r22
            double r0 = r0 / r29
            double r2 = r7.val
            double r2 = r37 + r2
            double r2 = r2 + r22
            r53[r15] = r2
            r8 = r34
            double r2 = r8.val
            double r2 = r37 + r2
            double r2 = r2 + r22
            r53[r14] = r2
            double r0 = r0 / r29
            r9 = r0
            r6 = 0
        L_0x057a:
            r0 = 3
            if (r6 >= r0) goto L_0x0614
            r5 = r15
        L_0x057e:
            if (r5 > r14) goto L_0x060a
            r0 = r53[r5]
            double r0 = r0 - r9
            r22 = r0
            r4 = 0
        L_0x0586:
            if (r4 >= r11) goto L_0x05e7
            r0 = r48
            r1 = r22
            r3 = r33
            r18 = r4
            r4 = r21
            r27 = r5
            r5 = r20
            r28 = r6
            r6 = r55
            int r0 = r0.lun_eclipse_how(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x05a2
            return r0
        L_0x05a2:
            if (r13 != 0) goto L_0x05b5
            r2 = r20[r11]
            double r2 = r2 / r29
            r0 = 4
            r4 = r20[r0]
            double r4 = r24 / r4
            double r2 = r2 + r4
            r4 = r20[r26]
            double r2 = r2 - r4
            r31[r18] = r2
            r2 = 3
            goto L_0x05de
        L_0x05b5:
            r0 = 4
            r2 = 1
            if (r13 != r2) goto L_0x05ca
            r3 = r20[r2]
            double r3 = r3 / r29
            r2 = 3
            r5 = r20[r2]
            double r5 = r24 / r5
            double r3 = r3 + r5
            r5 = r20[r26]
            double r3 = r3 - r5
            r31[r18] = r3
            r2 = 3
            goto L_0x05de
        L_0x05ca:
            if (r13 != r11) goto L_0x05dd
            r2 = 1
            r3 = r20[r2]
            double r3 = r3 / r29
            r2 = 3
            r5 = r20[r2]
            double r5 = r24 / r5
            double r3 = r3 - r5
            r5 = r20[r26]
            double r3 = r3 - r5
            r31[r18] = r3
            goto L_0x05de
        L_0x05dd:
            r2 = 3
        L_0x05de:
            int r4 = r18 + 1
            double r22 = r22 + r9
            r5 = r27
            r6 = r28
            goto L_0x0586
        L_0x05e7:
            r27 = r5
            r28 = r6
            r0 = 4
            r1 = -1
            r2 = 3
            r3 = 1
            r4 = r31[r3]
            r18 = r31[r3]
            r22 = r31[r26]
            double r18 = r18 - r22
            double r18 = r18 / r9
            double r4 = r4 / r18
            r7.val = r4
            r4 = r53[r27]
            double r0 = r7.val
            double r4 = r4 - r0
            r53[r27] = r4
            int r0 = r14 - r15
            int r5 = r27 + r0
            goto L_0x057e
        L_0x060a:
            r28 = r6
            r2 = 3
            r3 = 1
            int r6 = r28 + 1
            double r9 = r9 / r29
            goto L_0x057a
        L_0x0614:
            r2 = 3
            r3 = 1
            int r13 = r13 + 1
            r35 = r7
            r34 = r8
            r9 = r14
            r0 = r15
            r10 = r16
            r11 = -1
            goto L_0x04c7
        L_0x0623:
            r16 = r10
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_lun_eclipse_when(double, int, int, double[], int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_lun_eclipse_when_loc(double r27, int r29, double[] r30, double[] r31, double[] r32, int r33, java.lang.StringBuffer r34) {
        /*
            r26 = this;
            swisseph.DblObj r14 = new swisseph.DblObj
            r14.<init>()
            swisseph.DblObj r15 = new swisseph.DblObj
            r15.<init>()
            r0 = -786433(0xfffffffffff3ffff, float:NaN)
            r16 = r29 & r0
            r1 = r27
        L_0x0013:
            r4 = 0
            r0 = r26
            r3 = r16
            r5 = r31
            r6 = r33
            r7 = r34
            int r0 = r0.swe_lun_eclipse_when(r1, r3, r4, r5, r6, r7)
            r13 = -1
            if (r0 != r13) goto L_0x0026
            return r13
        L_0x0026:
            r17 = 7
            r18 = 0
            r0 = 7
            r12 = 0
        L_0x002d:
            r19 = 0
            r21 = 6
            if (r0 < 0) goto L_0x0076
            r1 = 1
            if (r0 != r1) goto L_0x0037
            goto L_0x0073
        L_0x0037:
            r1 = r31[r0]
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x003e
            goto L_0x0073
        L_0x003e:
            r2 = r31[r0]
            r1 = r26
            r4 = r16
            r5 = r30
            r6 = r32
            r7 = r34
            int r1 = r1.swe_lun_eclipse_how(r2, r4, r5, r6, r7)
            if (r1 != r13) goto L_0x0051
            return r13
        L_0x0051:
            r1 = r32[r21]
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x0073
            r12 = r12 | 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0071
            switch(r0) {
                case 2: goto L_0x006e;
                case 3: goto L_0x006b;
                case 4: goto L_0x0068;
                case 5: goto L_0x0065;
                case 6: goto L_0x0062;
                case 7: goto L_0x005f;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x0073
        L_0x005f:
            r12 = r12 | 16384(0x4000, float:2.2959E-41)
            goto L_0x0073
        L_0x0062:
            r12 = r12 | 8192(0x2000, float:1.14794E-41)
            goto L_0x0073
        L_0x0065:
            r12 = r12 | 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0068:
            r12 = r12 | 1024(0x400, float:1.435E-42)
            goto L_0x0073
        L_0x006b:
            r12 = r12 | 4096(0x1000, float:5.74E-42)
            goto L_0x0073
        L_0x006e:
            r12 = r12 | 512(0x200, float:7.175E-43)
            goto L_0x0073
        L_0x0071:
            r12 = r12 | 256(0x100, float:3.59E-43)
        L_0x0073:
            int r0 = r0 + -1
            goto L_0x002d
        L_0x0076:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x0088
            r0 = 4627730092099895296(0x4039000000000000, double:25.0)
            if (r33 == 0) goto L_0x0083
            r2 = r31[r18]
            double r1 = r2 - r0
            goto L_0x0013
        L_0x0083:
            r2 = r31[r18]
            double r1 = r2 + r0
            goto L_0x0013
        L_0x0088:
            r0 = r31[r21]
            r22 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r1 = r0 - r22
            r3 = 1
            r4 = 0
            r6 = 8193(0x2001, float:1.1481E-41)
            r8 = 0
            r10 = 0
            r0 = r26
            r5 = r16
            r7 = r30
            r24 = r12
            r12 = r14
            r25 = r14
            r14 = -1
            r13 = r34
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            if (r0 != r14) goto L_0x00ae
            return r14
        L_0x00ae:
            r0 = r31[r21]
            double r1 = r0 - r22
            r3 = 1
            r4 = 0
            r6 = 8194(0x2002, float:1.1482E-41)
            r8 = 0
            r10 = 0
            r0 = r26
            r5 = r16
            r7 = r30
            r12 = r15
            r13 = r34
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            if (r0 != r14) goto L_0x00ca
            return r14
        L_0x00ca:
            r0 = r31[r18]
            r2 = r25
            double r3 = r2.val
            r5 = r31[r21]
            r7 = 5
            r8 = 2
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0102
            double r3 = r2.val
            r5 = r31[r17]
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x0102
            r31[r21] = r19
            r3 = 2
        L_0x00e3:
            if (r3 > r7) goto L_0x00f2
            double r4 = r2.val
            r9 = r31[r3]
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ef
            r31[r3] = r19
        L_0x00ef:
            int r3 = r3 + 1
            goto L_0x00e3
        L_0x00f2:
            r3 = 8
            double r4 = r2.val
            r31[r3] = r4
            double r3 = r2.val
            r5 = r31[r18]
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0102
            double r0 = r2.val
        L_0x0102:
            double r2 = r15.val
            r4 = r31[r21]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0136
            double r2 = r15.val
            r4 = r31[r17]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0136
            r31[r17] = r19
        L_0x0115:
            if (r8 > r7) goto L_0x0124
            double r2 = r15.val
            r4 = r31[r8]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0121
            r31[r8] = r19
        L_0x0121:
            int r8 = r8 + 1
            goto L_0x0115
        L_0x0124:
            r2 = 9
            double r3 = r15.val
            r31[r2] = r3
            double r2 = r15.val
            r4 = r31[r18]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0136
            double r0 = r15.val
            r2 = r0
            goto L_0x0137
        L_0x0136:
            r2 = r0
        L_0x0137:
            r31[r18] = r2
            r1 = r26
            r4 = r16
            r5 = r30
            r6 = r32
            r7 = r34
            int r0 = r1.swe_lun_eclipse_how(r2, r4, r5, r6, r7)
            if (r0 != r14) goto L_0x014a
            return r14
        L_0x014a:
            r0 = r0 & 84
            r0 = r24 | r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_lun_eclipse_when_loc(double, int, double[], double[], double[], int, java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public int swe_pheno(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        int i3;
        int i4;
        int i5;
        double d2;
        double d3;
        int i6;
        int i7;
        char c;
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        double[] dArr5 = new double[6];
        double[] dArr6 = new double[6];
        double[] dArr7 = new double[2];
        int i8 = i2 & -786433;
        int i9 = i;
        if (i9 == 144340) {
            i3 = 9;
        } else {
            i3 = i9;
        }
        for (int i10 = 0; i10 < 20; i10++) {
            dArr[i10] = 0.0d;
        }
        if (i3 <= 10000 || i3 > 10004) {
            i4 = i3;
        } else {
            i4 = ((i3 - 10000) - 1) + 17;
        }
        int i11 = i8 & 34423;
        int i12 = i11 | 4096;
        int i13 = (i11 & 1143) | 8;
        int i14 = i11 & 7;
        int i15 = i11;
        int i16 = i4;
        if (this.sw.swe_calc(d, i4, i12, dArr2, stringBuffer) == -1 || this.sw.swe_calc(d, i16, i15, dArr5, stringBuffer) == -1) {
            return -1;
        }
        int i17 = i16;
        if (i17 == 1) {
            double[] dArr8 = dArr4;
            i5 = i17;
            if (this.sw.swe_calc(d, 0, i12, dArr8, stringBuffer) == -1) {
                return -1;
            }
        } else {
            i5 = i17;
        }
        if (i5 == 0 || i5 == 14 || i5 == 10 || i5 == 11 || i5 == 12 || i5 == 13) {
            d2 = 0.0d;
        } else {
            double d4 = ((dArr5[2] * 1.4959787066E11d) / 2.99792458E8d) / 86400.0d;
            if ((i15 & 16) != 0) {
                d2 = 0.0d;
            } else {
                d2 = d4;
            }
            double d5 = d - d2;
            if (this.sw.swe_calc(d5, i5, i13 | 4096, dArr3, stringBuffer) == -1 || this.sw.swe_calc(d5, i5, i13, dArr6, stringBuffer) == -1) {
                return -1;
            }
            dArr[0] = SMath.acos(this.sl.swi_dot_prod_unit(dArr2, dArr3)) * 57.2957795130823d;
            dArr[1] = (SMath.cos(dArr[0] * 0.0174532925199433d) + 1.0d) / 2.0d;
        }
        if (i5 < 21) {
            d3 = SwephData.pla_diam[i5];
            i6 = SweConst.SE_AST_OFFSET;
        } else {
            i6 = SweConst.SE_AST_OFFSET;
            if (i5 > 10000) {
                d3 = this.swed.ast_diam * 1000.0d;
            } else {
                d3 = 0.0d;
            }
        }
        double d6 = (d3 / 2.0d) / 1.4959787066E11d;
        if (dArr5[2] < d6) {
            dArr[3] = 180.0d;
        } else {
            dArr[3] = SMath.asin(d6 / dArr5[2]) * 2.0d * 57.2957795130823d;
        }
        if (i5 <= i6 && (i5 >= 21 || mag_elem[i5][0] >= 99.0d)) {
            i7 = i12;
        } else if (i5 == 0) {
            double asin = dArr[3] / ((SMath.asin((SwephData.pla_diam[0] / 2.0d) / 1.4959787066E11d) * 2.0d) * 57.2957795130823d);
            dArr[4] = mag_elem[i5][0] - (log10(asin * asin) * 2.5d);
            i7 = i12;
        } else if (i5 == 1) {
            dArr[4] = (((log10((dArr5[2] * 1.49597870691E11d) / 6378136.6d) * 5.0d) / log10(10.0d)) - 0.20609375d) + (SMath.abs(dArr[0]) * 0.026d) + (SMath.pow(dArr[0], 4.0d) * 4.0E-9d);
            i7 = i12;
        } else if (i5 == 6) {
            double d7 = ((d - d2) - 2451545.0d) / 36525.0d;
            double d8 = ((28.075216d - (0.012998d * d7)) + (4.0E-6d * d7 * d7)) * 0.0174532925199433d;
            double d9 = ((1.394681d * d7) + 169.50847d + (4.12E-4d * d7 * d7)) * 0.0174532925199433d;
            double abs = SMath.abs(((SMath.sin(d8) * SMath.cos(dArr5[1] * 0.0174532925199433d)) * SMath.sin((dArr5[0] * 0.0174532925199433d) - d9)) - (SMath.cos(d8) * SMath.sin(dArr5[1] * 0.0174532925199433d)));
            double swe_degnorm = this.sl.swe_degnorm((SMath.atan2((SMath.sin(d8) * SMath.tan(dArr6[1] * 0.0174532925199433d)) + (SMath.cos(d8) * SMath.sin((dArr6[0] * 0.0174532925199433d) - d9)), SMath.cos((dArr6[0] * 0.0174532925199433d) - d9)) * 57.2957795130823d) - (SMath.atan2((SMath.sin(d8) * SMath.tan(dArr5[1] * 0.0174532925199433d)) + (SMath.cos(d8) * SMath.sin((dArr5[0] * 0.0174532925199433d) - d9)), SMath.cos((dArr5[0] * 0.0174532925199433d) - d9)) * 57.2957795130823d));
            if (swe_degnorm > 10.0d) {
                swe_degnorm = 360.0d - swe_degnorm;
            }
            double[][] dArr9 = mag_elem;
            dArr[4] = (log10(dArr6[2] * dArr5[2]) * 5.0d) + (dArr9[i5][1] * abs) + (dArr9[i5][2] * abs * abs) + (dArr9[i5][3] * swe_degnorm) + dArr9[i5][0];
            i7 = i12;
        } else if (i5 < 15) {
            double[][] dArr10 = mag_elem;
            dArr[4] = (log10(dArr6[2] * dArr5[2]) * 5.0d) + ((dArr10[i5][1] * dArr[0]) / 100.0d) + (((dArr10[i5][2] * dArr[0]) * dArr[0]) / 10000.0d) + ((((dArr10[i5][3] * dArr[0]) * dArr[0]) * dArr[0]) / 1000000.0d) + dArr10[i5][0];
            i7 = i12;
        } else if (i5 < 21 || i5 > i6) {
            double pow = SMath.pow(EULER, SMath.pow(SMath.tan((dArr[0] * 0.0174532925199433d) / 2.0d), 0.63d) * -3.33d);
            i7 = i12;
            double pow2 = SMath.pow(EULER, SMath.pow(SMath.tan((dArr[0] * 0.0174532925199433d) / 2.0d), 1.22d) * -1.87d);
            if (i5 < 21) {
                double[][] dArr11 = mag_elem;
                dArr7[0] = dArr11[i5][0];
                c = 1;
                dArr7[1] = dArr11[i5][1];
            } else {
                c = 1;
                if (i5 == 11566) {
                    dArr7[0] = 16.9d;
                    dArr7[1] = 0.15d;
                } else {
                    dArr7[0] = this.swed.ast_H;
                    dArr7[1] = this.swed.ast_G;
                }
            }
            dArr[4] = ((log10(dArr6[2] * dArr5[2]) * 5.0d) + dArr7[0]) - (log10(((1.0d - dArr7[c]) * pow) + (dArr7[c] * pow2)) * 2.5d);
        } else {
            dArr[4] = 0.0d;
            i7 = i12;
        }
        if (!(i5 == 0 || i5 == 14)) {
            if (this.sw.swe_calc(d, 0, i7, dArr3, stringBuffer) == -1 || this.sw.swe_calc(d, 0, i15, dArr6, stringBuffer) == -1) {
                return -1;
            }
            dArr[2] = SMath.acos(this.sl.swi_dot_prod_unit(dArr2, dArr3)) * 57.2957795130823d;
        }
        if (i5 == 1) {
            double[] dArr12 = new double[6];
            int i18 = i14;
            if (this.sw.swe_calc(d, i5, i18 | 16 | 2048 | 8192, dArr12, stringBuffer) == -1) {
                return -1;
            }
            dArr[5] = SMath.asin((6378136.6d / dArr12[2]) / 1.49597870691E11d) / 0.0174532925199433d;
            if ((i15 & 32768) != 0) {
                int i19 = i18 | 4096;
                if (this.sw.swe_calc(d, i5, i19 | 32768, dArr12, stringBuffer) == -1 || this.sw.swe_calc(d, i5, i19, dArr2, stringBuffer) == -1) {
                    return -1;
                }
                dArr[5] = SMath.acos(this.sl.swi_dot_prod_unit(dArr12, dArr2)) / 0.0174532925199433d;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int swe_pheno_ut(double d, int i, int i2, double[] dArr, StringBuffer stringBuffer) {
        return swe_pheno(d + SweDate.getDeltaT(d), i, i2, dArr, stringBuffer);
    }

    private int find_maximum(double d, double d2, double d3, double d4, DblObj dblObj, DblObj dblObj2) {
        DblObj dblObj3 = dblObj2;
        double d5 = (d3 - d) / 2.0d;
        double d6 = ((d3 + d) / 2.0d) - d2;
        double d7 = ((((d6 * 4.0d) * d2) - (d5 * d5)) / 4.0d) / d6;
        dblObj.val = ((((-d5) / 2.0d) / d6) - 1.0d) * d4;
        if (dblObj3 == null) {
            return 0;
        }
        dblObj3.val = d7;
        return 0;
    }

    private int find_zero(double d, double d2, double d3, double d4, DblObj dblObj, DblObj dblObj2) {
        double d5 = (d3 - d) / 2.0d;
        double d6 = ((d3 + d) / 2.0d) - d2;
        double d7 = (d5 * d5) - ((4.0d * d6) * d2);
        if (d7 < 0.0d) {
            return -1;
        }
        double d8 = -d5;
        double sqrt = ((d8 - SMath.sqrt(d7)) / 2.0d) / d6;
        dblObj.val = ((((SMath.sqrt(d7) + d8) / 2.0d) / d6) - 1.0d) * d4;
        dblObj2.val = (sqrt - 1.0d) * d4;
        return 0;
    }

    private double rdi_twilight(int i) {
        double d;
        if ((i & 1024) != 0) {
            d = 6.0d;
        } else {
            d = 0.0d;
        }
        if ((i & 2048) != 0) {
            d = 12.0d;
        }
        if ((i & 4096) != 0) {
            return 18.0d;
        }
        return d;
    }

    /* access modifiers changed from: package-private */
    public int swe_rise_trans(double d, int i, StringBuffer stringBuffer, int i2, int i3, double[] dArr, double d2, double d3, DblObj dblObj, StringBuffer stringBuffer2) {
        return swe_rise_trans_true_hor(d, i, stringBuffer, i2, i3, dArr, d2, d3, 0.0d, dblObj, stringBuffer2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: double[][]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014c, code lost:
        if (r15 == 1) goto L_0x0151;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_rise_trans_true_hor(double r51, int r53, java.lang.StringBuffer r54, int r55, int r56, double[] r57, double r58, double r60, double r62, swisseph.DblObj r64, java.lang.StringBuffer r65) {
        /*
            r50 = this;
            r11 = r50
            r12 = r64
            r13 = r65
            double r0 = swisseph.SweDate.getDeltaT(r51)
            double r2 = r51 + r0
            r0 = 6
            double[] r14 = new double[r0]
            r15 = 2
            int[] r1 = new int[r15]
            r1 = {20, 6} // fill-array
            java.lang.Class<double> r4 = double.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            r16 = r1
            double[][] r16 = (double[][]) r16
            double[] r10 = new double[r0]
            r1 = 4
            double[] r9 = new double[r1]
            r7 = 20
            double[] r8 = new double[r7]
            double[] r6 = new double[r7]
            double[] r5 = new double[r0]
            double[] r4 = new double[r0]
            swisseph.DblObj r1 = new swisseph.DblObj
            r1.<init>()
            swisseph.DblObj r17 = new swisseph.DblObj
            r17.<init>()
            r18 = 0
            if (r54 == 0) goto L_0x004a
            int r19 = r54.length()
            if (r19 <= 0) goto L_0x004a
            r19 = 1
            goto L_0x004c
        L_0x004a:
            r19 = 0
        L_0x004c:
            r7 = 144340(0x233d4, float:2.02263E-40)
            r15 = r53
            if (r15 != r7) goto L_0x0057
            r7 = 9
            r15 = 9
        L_0x0057:
            r7 = r55 & 87
            r22 = r1
            r0 = 0
            r12.val = r0
            r24 = 34816(0x8800, float:4.8788E-41)
            r24 = r7 | r24
            swisseph.SwissEph r7 = r11.sw
            r26 = r57[r18]
            r23 = 1
            r28 = r57[r23]
            r21 = 2
            r30 = r57[r21]
            r25 = r7
            r25.swe_set_topo(r26, r28, r30)
            r7 = r56 & 12
            if (r7 == 0) goto L_0x008f
            r0 = r50
            r1 = r51
            r3 = r15
            r4 = r55
            r5 = r56
            r6 = r57
            r7 = r54
            r8 = r64
            r9 = r65
            int r0 = r0.calc_mer_trans(r1, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x008f:
            r7 = r56 & 3
            if (r7 != 0) goto L_0x0096
            r7 = r56 | 1
            goto L_0x0098
        L_0x0096:
            r7 = r56
        L_0x0098:
            if (r15 != 0) goto L_0x00a8
            r0 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r0 == 0) goto L_0x00a8
            r7 = r7 | 768(0x300, float:1.076E-42)
            double r0 = r11.rdi_twilight(r7)
            double r0 = -r0
            r27 = r0
            goto L_0x00aa
        L_0x00a8:
            r27 = r62
        L_0x00aa:
            r1 = -1
            if (r19 == 0) goto L_0x00c5
            swisseph.SwissEph r0 = r11.sw
            r12 = 1
            r13 = -1
            r1 = r54
            r23 = r4
            r4 = r24
            r29 = r5
            r5 = r14
            r30 = r6
            r6 = r65
            int r0 = r0.swe_fixstar(r1, r2, r4, r5, r6)
            if (r0 != r13) goto L_0x00cd
            return r13
        L_0x00c5:
            r23 = r4
            r29 = r5
            r30 = r6
            r12 = 1
            r13 = -1
        L_0x00cd:
            r31 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            double r0 = r51 - r31
            r33 = r0
            r5 = 0
            r6 = -1
            r35 = 0
        L_0x00da:
            r37 = 4568072439059991641(0x3f650dae3e6c4c59, double:0.00257)
            r39 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r41 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            r43 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            r45 = 4611686018427387904(0x4000000000000000, double:2.0)
            r0 = 14
            if (r5 > r0) goto L_0x02d0
            r8[r5] = r33
            if (r19 != 0) goto L_0x010d
            double r0 = swisseph.SweDate.getDeltaT(r33)
            double r1 = r33 + r0
            swisseph.SwissEph r0 = r11.sw
            r3 = r15
            r4 = r24
            r12 = r5
            r5 = r14
            r47 = r6
            r6 = r65
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            if (r0 != r13) goto L_0x0110
            return r13
        L_0x010d:
            r12 = r5
            r47 = r6
        L_0x0110:
            if (r12 != 0) goto L_0x013f
            if (r19 == 0) goto L_0x0117
            r35 = 0
            goto L_0x013f
        L_0x0117:
            r0 = r7 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x011e
            r35 = 0
            goto L_0x013f
        L_0x011e:
            r0 = 21
            if (r15 >= r0) goto L_0x012b
            if (r15 < 0) goto L_0x012b
            double[] r0 = swisseph.SwephData.pla_diam
            r1 = r0[r15]
            r35 = r1
            goto L_0x013f
        L_0x012b:
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r15 <= r0) goto L_0x013d
            swisseph.SwissData r0 = r11.swed
            double r0 = r0.ast_diam
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r0 = r0 * r2
            r35 = r0
            goto L_0x013f
        L_0x013d:
            r35 = 0
        L_0x013f:
            r0 = 2
            r1 = r14[r0]
            r0 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x014f
            if (r15 != 0) goto L_0x014b
            r37 = r39
            goto L_0x0151
        L_0x014b:
            r0 = 1
            if (r15 != r0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r37 = r1
        L_0x0151:
            double r0 = r35 / r45
            double r0 = r0 / r43
            double r0 = r0 / r37
            double r0 = swisseph.SMath.asin(r0)
            double r37 = r0 * r41
            r3 = 1
            r39 = r16[r12]
            r0 = r50
            r1 = r33
            r4 = r57
            r5 = r58
            r13 = r7
            r20 = r8
            r7 = r60
            r48 = r9
            r9 = r14
            r49 = r10
            r10 = r39
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0185
            r0 = r16[r12]
            r1 = 1
            r2 = r0[r1]
            double r2 = r2 - r37
            r0[r1] = r2
            goto L_0x018e
        L_0x0185:
            r1 = 1
            r0 = r16[r12]
            r2 = r0[r1]
            double r2 = r2 + r37
            r0[r1] = r2
        L_0x018e:
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a1
            r0 = r16[r12]
            r2 = r0[r1]
            double r2 = r2 - r27
            r0[r1] = r2
            r0 = r16[r12]
            r2 = r0[r1]
            r30[r12] = r2
            goto L_0x01d0
        L_0x01a1:
            r3 = 1
            r5 = r16[r12]
            r0 = r50
            r1 = r33
            r4 = r57
            r6 = r14
            r0.swe_azalt_rev(r1, r3, r4, r5, r6)
            r10 = r16[r12]
            r5 = r58
            r7 = r60
            r9 = r14
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r16[r12]
            r1 = 1
            r2 = r0[r1]
            double r2 = r2 - r27
            r0[r1] = r2
            r0 = r16[r12]
            r1 = 2
            r2 = r0[r1]
            double r2 = r2 - r27
            r0[r1] = r2
            r0 = r16[r12]
            r2 = r0[r1]
            r30[r12] = r2
        L_0x01d0:
            r0 = 1
            if (r12 <= r0) goto L_0x0212
            int r5 = r12 + -2
            r1 = r16[r5]
            r2 = r1[r0]
            r23[r18] = r2
            int r5 = r12 + -1
            r1 = r16[r5]
            r2 = r1[r0]
            r23[r0] = r2
            r1 = r16[r12]
            r2 = r1[r0]
            r1 = 2
            r23[r1] = r2
            r2 = r23[r0]
            r4 = r23[r18]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x01fd
            r2 = r23[r0]
            r4 = r23[r1]
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01fd
            r0 = 1
            goto L_0x01fe
        L_0x01fd:
            r0 = 0
        L_0x01fe:
            r1 = 1
            r2 = r23[r1]
            r4 = r23[r18]
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0213
            r2 = r23[r1]
            r1 = 2
            r4 = r23[r1]
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0213
            r0 = 2
            goto L_0x0213
        L_0x0212:
            r0 = 0
        L_0x0213:
            if (r0 == 0) goto L_0x02ba
            double r37 = r33 - r31
            r1 = r23[r18]
            r0 = 1
            r3 = r23[r0]
            r0 = 2
            r5 = r23[r0]
            r7 = 4590669220166325589(0x3fb5555555555555, double:0.08333333333333333)
            r0 = r50
            r9 = r22
            r10 = r17
            r0.find_maximum(r1, r3, r5, r7, r9, r10)
            r10 = r22
            double r0 = r10.val
            double r0 = r0 + r31
            double r37 = r37 + r0
            r0 = 4583663620745971484(0x3f9c71c71c71c71c, double:0.027777777777777776)
            r39 = r37
            r37 = r0
        L_0x023f:
            r0 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r2 = (r37 > r0 ? 1 : (r37 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x02b2
            double r0 = r39 - r37
            r41 = r0
            r9 = 0
        L_0x024d:
            r0 = 3
            if (r9 >= r0) goto L_0x028f
            double r0 = swisseph.SweDate.getDeltaT(r41)
            double r1 = r41 + r0
            if (r19 != 0) goto L_0x0268
            swisseph.SwissEph r0 = r11.sw
            r3 = r15
            r4 = r24
            r5 = r14
            r6 = r65
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x0268
            return r1
        L_0x0268:
            r3 = 1
            r0 = r50
            r1 = r41
            r4 = r57
            r5 = r58
            r7 = r60
            r22 = r9
            r9 = r14
            r54 = r10
            r10 = r49
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r1 = r49[r0]
            r23[r22] = r1
            double r41 = r41 + r37
            int r9 = r22 + 1
            r10 = r54
            goto L_0x024d
        L_0x028f:
            r54 = r10
            r0 = 1
            r1 = r23[r18]
            r3 = r23[r0]
            r0 = 2
            r5 = r23[r0]
            r0 = r50
            r7 = r37
            r9 = r54
            r10 = r17
            r0.find_maximum(r1, r3, r5, r7, r9, r10)
            r1 = r54
            double r2 = r1.val
            double r2 = r2 + r37
            double r39 = r39 + r2
            r2 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r37 = r37 / r2
            r10 = r1
            goto L_0x023f
        L_0x02b2:
            r1 = r10
            r10 = r47
            int r6 = r10 + 1
            r48[r6] = r39
            goto L_0x02bf
        L_0x02ba:
            r1 = r22
            r10 = r47
            r6 = r10
        L_0x02bf:
            int r5 = r12 + 1
            double r33 = r33 + r31
            r22 = r1
            r7 = r13
            r8 = r20
            r9 = r48
            r10 = r49
            r12 = 1
            r13 = -1
            goto L_0x00da
        L_0x02d0:
            r13 = r7
            r20 = r8
            r48 = r9
            r49 = r10
            r10 = r6
            r9 = 0
            r12 = 14
        L_0x02db:
            if (r9 > r10) goto L_0x03af
            r7 = 1
        L_0x02de:
            if (r7 > r12) goto L_0x03a5
            r0 = r48[r9]
            r2 = r20[r7]
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x039b
            r0 = r12
        L_0x02e9:
            if (r0 < r7) goto L_0x02f8
            int r1 = r0 + 1
            r2 = r20[r0]
            r20[r1] = r2
            r2 = r30[r0]
            r30[r1] = r2
            int r0 = r0 + -1
            goto L_0x02e9
        L_0x02f8:
            r0 = r48[r9]
            r20[r7] = r0
            if (r19 != 0) goto L_0x0318
            r0 = r20[r7]
            r2 = r20[r7]
            double r2 = swisseph.SweDate.getDeltaT(r2)
            double r1 = r0 + r2
            swisseph.SwissEph r0 = r11.sw
            r3 = r15
            r4 = r24
            r5 = r14
            r6 = r65
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x0318
            return r1
        L_0x0318:
            r0 = 2
            r1 = r14[r0]
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0329
            if (r15 != 0) goto L_0x0324
            r1 = r39
            goto L_0x0329
        L_0x0324:
            r0 = 1
            if (r15 != r0) goto L_0x0329
            r1 = r37
        L_0x0329:
            double r3 = r35 / r45
            double r3 = r3 / r43
            double r3 = r3 / r1
            double r0 = swisseph.SMath.asin(r3)
            double r16 = r0 * r41
            r1 = r20[r7]
            r3 = 1
            r0 = r50
            r4 = r57
            r5 = r58
            r22 = r7
            r7 = r60
            r31 = r9
            r9 = r14
            r32 = r10
            r10 = r49
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0357
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 - r16
            r49[r0] = r1
            goto L_0x035e
        L_0x0357:
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 + r16
            r49[r0] = r1
        L_0x035e:
            r1 = r13 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x036d
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r1 = r49[r0]
            r30[r22] = r1
            goto L_0x0398
        L_0x036d:
            r1 = r20[r22]
            r3 = 1
            r0 = r50
            r4 = r57
            r5 = r49
            r6 = r14
            r0.swe_azalt_rev(r1, r3, r4, r5, r6)
            r1 = r20[r22]
            r5 = r58
            r7 = r60
            r9 = r14
            r10 = r49
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r0 = 2
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r1 = r49[r0]
            r30[r22] = r1
        L_0x0398:
            int r12 = r12 + 1
            goto L_0x03a9
        L_0x039b:
            r22 = r7
            r31 = r9
            r32 = r10
            int r7 = r22 + 1
            goto L_0x02de
        L_0x03a5:
            r31 = r9
            r32 = r10
        L_0x03a9:
            int r9 = r31 + 1
            r10 = r32
            goto L_0x02db
        L_0x03af:
            r10 = r64
            r7 = 0
            r10.val = r7
            r9 = 1
        L_0x03b6:
            if (r9 > r12) goto L_0x04e8
            int r0 = r9 + -1
            r1 = r30[r0]
            r3 = r30[r9]
            double r1 = r1 * r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x03c5
            goto L_0x03df
        L_0x03c5:
            r1 = r30[r0]
            r3 = r30[r9]
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x03d2
            r1 = r13 & 1
            if (r1 != 0) goto L_0x03d2
            goto L_0x03df
        L_0x03d2:
            r1 = r30[r0]
            r3 = r30[r9]
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x03ee
            r1 = r13 & 2
            if (r1 != 0) goto L_0x03ee
        L_0x03df:
            r47 = r9
            r11 = r10
            r0 = r33
            r2 = 2
            r3 = 1
            r22 = 20
            r26 = -1
            r33 = r7
            goto L_0x04dd
        L_0x03ee:
            r1 = r30[r0]
            r23[r18] = r1
            r1 = r30[r9]
            r3 = 1
            r23[r3] = r1
            r0 = r20[r0]
            r29[r18] = r0
            r0 = r20[r9]
            r29[r3] = r0
            r0 = r33
            r6 = 0
        L_0x0402:
            r5 = 20
            if (r6 >= r5) goto L_0x04cc
            r0 = r29[r18]
            r16 = r29[r3]
            double r0 = r0 + r16
            double r16 = r0 / r45
            if (r19 != 0) goto L_0x042a
            double r0 = swisseph.SweDate.getDeltaT(r16)
            double r1 = r16 + r0
            swisseph.SwissEph r0 = r11.sw
            r3 = r15
            r4 = r24
            r22 = 20
            r5 = r14
            r25 = r6
            r6 = r65
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r5 = -1
            if (r0 != r5) goto L_0x042f
            return r5
        L_0x042a:
            r25 = r6
            r5 = -1
            r22 = 20
        L_0x042f:
            r0 = 2
            r1 = r14[r0]
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0440
            if (r15 != 0) goto L_0x043b
            r1 = r39
            goto L_0x0440
        L_0x043b:
            r0 = 1
            if (r15 != r0) goto L_0x0440
            r1 = r37
        L_0x0440:
            double r3 = r35 / r45
            double r3 = r3 / r43
            double r3 = r3 / r1
            double r0 = swisseph.SMath.asin(r3)
            double r31 = r0 * r41
            r3 = 1
            r0 = r50
            r1 = r16
            r4 = r57
            r26 = -1
            r5 = r58
            r33 = r7
            r7 = r60
            r47 = r9
            r9 = r14
            r11 = r10
            r10 = r49
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x046f
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 - r31
            r49[r0] = r1
            goto L_0x0476
        L_0x046f:
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 + r31
            r49[r0] = r1
        L_0x0476:
            r1 = r13 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0485
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r1 = r49[r0]
            r0 = r1
            r2 = 2
            goto L_0x04ac
        L_0x0485:
            r3 = 1
            r0 = r50
            r1 = r16
            r4 = r57
            r5 = r49
            r6 = r14
            r0.swe_azalt_rev(r1, r3, r4, r5, r6)
            r5 = r58
            r7 = r60
            r9 = r14
            r10 = r49
            r0.swe_azalt(r1, r3, r4, r5, r7, r9, r10)
            r0 = 1
            r1 = r49[r0]
            double r1 = r1 - r27
            r49[r0] = r1
            r2 = 2
            r0 = r49[r2]
            double r0 = r0 - r27
            r49[r2] = r0
            r0 = r49[r2]
        L_0x04ac:
            r3 = r23[r18]
            double r3 = r3 * r0
            int r5 = (r3 > r33 ? 1 : (r3 == r33 ? 0 : -1))
            if (r5 > 0) goto L_0x04ba
            r3 = 1
            r23[r3] = r0
            r29[r3] = r16
            goto L_0x04bf
        L_0x04ba:
            r3 = 1
            r23[r18] = r0
            r29[r18] = r16
        L_0x04bf:
            int r6 = r25 + 1
            r10 = r11
            r0 = r16
            r7 = r33
            r9 = r47
            r11 = r50
            goto L_0x0402
        L_0x04cc:
            r33 = r7
            r47 = r9
            r11 = r10
            r2 = 2
            r22 = 20
            r26 = -1
            int r4 = (r0 > r51 ? 1 : (r0 == r51 ? 0 : -1))
            if (r4 <= 0) goto L_0x04dd
            r11.val = r0
            return r18
        L_0x04dd:
            int r9 = r47 + 1
            r10 = r11
            r7 = r33
            r11 = r50
            r33 = r0
            goto L_0x03b6
        L_0x04e8:
            r0 = r65
            if (r0 == 0) goto L_0x04f4
            java.lang.String r1 = "rise or set not found for planet "
            r0.append(r1)
            r0.append(r15)
        L_0x04f4:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_rise_trans_true_hor(double, int, java.lang.StringBuffer, int, int, double[], double, double, double, swisseph.DblObj, java.lang.StringBuffer):int");
    }

    private int calc_mer_trans(double d, int i, int i2, int i3, double[] dArr, StringBuffer stringBuffer, DblObj dblObj, StringBuffer stringBuffer2) {
        double d2;
        int i4;
        double[] dArr2;
        double d3 = d;
        DblObj dblObj2 = dblObj;
        double deltaT = SweDate.getDeltaT(d) + d3;
        double[] dArr3 = new double[6];
        double[] dArr4 = new double[6];
        boolean z = stringBuffer != null && stringBuffer.length() > 0;
        dblObj2.val = 0.0d;
        int i5 = (i2 & 7) | 34816;
        double swe_sidtime = this.sl.swe_sidtime(d3) + (dArr[0] / 15.0d);
        if (swe_sidtime >= 24.0d) {
            swe_sidtime -= 24.0d;
        }
        if (swe_sidtime < 0.0d) {
            swe_sidtime += 24.0d;
        }
        double d4 = swe_sidtime * 15.0d;
        if (z) {
            double d5 = deltaT;
            i4 = -1;
            d2 = 0.0d;
            if (this.sw.swe_fixstar(stringBuffer, d5, i5, dArr3, stringBuffer2) == -1) {
                return -1;
            }
        } else {
            d2 = 0.0d;
            i4 = -1;
            if (this.sw.swe_calc(deltaT, i, i5, dArr3, stringBuffer2) == -1) {
                return -1;
            }
        }
        dArr4[0] = dArr3[0];
        dArr4[1] = dArr3[1];
        int i6 = i3 & 8;
        if (i6 != 0) {
            d4 = this.sl.swe_degnorm(d4 + 180.0d);
        }
        int i7 = 0;
        while (i7 < 4) {
            double swe_degnorm = this.sl.swe_degnorm(dArr4[0] - d4);
            if (i7 > 0 && swe_degnorm > 180.0d) {
                swe_degnorm -= 360.0d;
            }
            d3 += swe_degnorm / 361.0d;
            double swe_sidtime2 = this.sl.swe_sidtime(d3) + (dArr[0] / 15.0d);
            if (swe_sidtime2 >= 24.0d) {
                swe_sidtime2 -= 24.0d;
            }
            if (swe_sidtime2 < d2) {
                swe_sidtime2 += 24.0d;
            }
            double d6 = swe_sidtime2 * 15.0d;
            if (i6 != 0) {
                d6 = this.sl.swe_degnorm(d6 + 180.0d);
            }
            if (!z) {
                dArr2 = dArr4;
                if (this.sw.swe_calc(SweDate.getDeltaT(d3) + d3, i, i5, dArr2, stringBuffer2) == i4) {
                    return i4;
                }
            } else {
                dArr2 = dArr4;
            }
            i7++;
            d4 = d6;
            dArr4 = dArr2;
        }
        dblObj2.val = d3;
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v1, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r76v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r76v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r76v4, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r76v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v48, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v30, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v31, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r76v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v52, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v112, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v116, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v53, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v16, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v49, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v77, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v44, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v83, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v45, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v121, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v14, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v122, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v15, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v123, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v124, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v22, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v24, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v55, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v54, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v25, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v126, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v127, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v128, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v129, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v91, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v29, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r62v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v92, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v133, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v134, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v135, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v94, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v95, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v71, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v33, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v55, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v35, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v37, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v149, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v150, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v151, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v84, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v153, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v154, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v33, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v155, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v34, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v156, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v87, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v88, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v102, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v161, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v12, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v163, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v167, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v104, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v137, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v35, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v110, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v4, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v39, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v40, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v41, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v42, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v46, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v112, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v47, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v48, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v116, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v62, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v123, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v67, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v68, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v143, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v47, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v182, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v96, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v11, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v97, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v99, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v101, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v103, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v30, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v193, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v194, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v14, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v107, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v90, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v54, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v179, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v4, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v4, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v18, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v19, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v6, resolved type: double[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0959  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x097d  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0998 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x09a0  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x09b2  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x09bf  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x09d2  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x09f5  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x09fb  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0ead A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_nod_aps(double r74, int r76, int r77, int r78, double[] r79, double[] r80, double[] r81, double[] r82, java.lang.StringBuffer r83) {
        /*
            r73 = this;
            r0 = r73
            r8 = r74
            r1 = r77
            r2 = r78
            r15 = r83
            java.lang.Class<double> r3 = double.class
            r4 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            double r4 = r8 - r4
            r6 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r4 = r4 / r6
            r14 = 6
            double[] r10 = new double[r14]
            r11 = 24
            double[] r13 = new double[r11]
            double[] r12 = new double[r14]
            double[] r11 = new double[r14]
            r15 = 2
            int[] r6 = new int[r15]
            r6 = {3, 6} // fill-array
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r3, r6)
            r18 = r6
            double[][] r18 = (double[][]) r18
            double[] r7 = new double[r14]
            double[] r6 = new double[r14]
            int[] r14 = new int[r15]
            r14 = {3, 6} // fill-array
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r3, r14)
            double[][] r14 = (double[][]) r14
            r19 = r6
            int[] r6 = new int[r15]
            r6 = {3, 6} // fill-array
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r3, r6)
            r27 = r6
            double[][] r27 = (double[][]) r27
            int[] r6 = new int[r15]
            r6 = {3, 6} // fill-array
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r3, r6)
            r28 = r6
            double[][] r28 = (double[][]) r28
            int[] r6 = new int[r15]
            r6 = {3, 6} // fill-array
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r6)
            r29 = r3
            double[][] r29 = (double[][]) r29
            r3 = 6
            double[] r6 = new double[r3]
            double[] r15 = new double[r3]
            swisseph.SwissData r3 = r0.swed
            swisseph.PlanData[] r3 = r3.pldat
            r31 = r11
            r11 = 0
            r3 = r3[r11]
            swisseph.SwissData r11 = r0.swed
            swisseph.PlanData[] r11 = r11.pldat
            r20 = 10
            r11 = r11[r20]
            r32 = r15
            swisseph.PlanData r15 = new swisseph.PlanData
            r15.<init>()
            double[] r11 = r11.x
            double[] r3 = r3.x
            r20 = r3
            r3 = r1 & 1040(0x410, float:1.457E-42)
            r33 = r15
            if (r3 != 0) goto L_0x0097
            r3 = 1
            goto L_0x0098
        L_0x0097:
            r3 = 0
        L_0x0098:
            r21 = r1 & 16
            if (r21 != 0) goto L_0x00a2
            r15 = r1 & 512(0x200, float:7.175E-43)
            if (r15 != 0) goto L_0x00a2
            r15 = 1
            goto L_0x00a3
        L_0x00a2:
            r15 = 0
        L_0x00a3:
            r21 = r3
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x00ac
            r35 = 1
            goto L_0x00ae
        L_0x00ac:
            r35 = 0
        L_0x00ae:
            r3 = -786433(0xfffffffffff3ffff, float:NaN)
            r3 = r3 & r1
            r1 = 144340(0x233d4, float:2.02263E-40)
            r22 = r6
            r6 = r76
            if (r6 != r1) goto L_0x00c0
            r1 = 9
            r6 = 9
        L_0x00c0:
            swisseph.SwissEph r1 = r0.sw
            r1.swi_force_app_pos_etc()
            int r2 = r2 % 256
            if (r6 != 0) goto L_0x00d3
            r23 = r15
            r15 = 14
            goto L_0x00d6
        L_0x00d3:
            r23 = r15
            r15 = r6
        L_0x00d6:
            r1 = 1
            if (r6 != r1) goto L_0x00e8
            r1 = r3 & 8
            if (r1 != 0) goto L_0x00e3
            r36 = 0
            r37 = 0
            goto L_0x00ec
        L_0x00e3:
            r36 = r21
            r37 = 0
            goto L_0x00ec
        L_0x00e8:
            r36 = r21
            r37 = r23
        L_0x00ec:
            r1 = r3 & 71
            r1 = r1 | 256(0x100, float:3.59E-43)
            r23 = 16
            r1 = r1 | 16
            r77 = r3
            r3 = 1
            if (r15 == r3) goto L_0x00fd
            r1 = r1 | 8
            r3 = r1
            goto L_0x00fe
        L_0x00fd:
            r3 = r1
        L_0x00fe:
            r38 = 0
            r40 = r11
            r1 = 10
            if (r6 == r1) goto L_0x0ee4
            r1 = 11
            if (r6 == r1) goto L_0x0ee4
            r1 = 12
            if (r6 == r1) goto L_0x0ee4
            r11 = 13
            if (r6 == r11) goto L_0x0ee4
            if (r6 < 0) goto L_0x0ee4
            r11 = 23
            if (r6 < r11) goto L_0x0124
            r11 = 10000(0x2710, float:1.4013E-41)
            if (r6 > r11) goto L_0x0124
            r4 = r83
            r72 = r6
            r25 = -1
            goto L_0x0eea
        L_0x0124:
            r11 = 0
        L_0x0125:
            r1 = 24
            if (r11 >= r1) goto L_0x0130
            r13[r11] = r38
            int r11 = r11 + 1
            r1 = 12
            goto L_0x0125
        L_0x0130:
            r41 = 4580687790476533050(0x3f91df46a2529d3a, double:0.0174532925199433)
            r43 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r45 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r2 == 0) goto L_0x0152
            r25 = r2 & 1
            if (r25 == 0) goto L_0x0140
            goto L_0x0152
        L_0x0140:
            r50 = r77
            r77 = r3
            r56 = r6
            r55 = r10
            r47 = r12
            r48 = r15
            r49 = r20
            r52 = r22
            goto L_0x04f5
        L_0x0152:
            r11 = 8
            if (r6 < 0) goto L_0x015c
            if (r6 <= r11) goto L_0x0159
            goto L_0x015c
        L_0x0159:
            r1 = 14
            goto L_0x0160
        L_0x015c:
            r1 = 14
            if (r6 != r1) goto L_0x04e5
        L_0x0160:
            r2 = 1
            if (r6 != r2) goto L_0x01df
            swisseph.DblObj r7 = new swisseph.DblObj
            r7.<init>()
            r2 = 0
            r4 = r13[r2]
            r7.val = r4
            swisseph.DblObj r5 = new swisseph.DblObj
            r5.<init>()
            r47 = r12
            r2 = 3
            r11 = r13[r2]
            r5.val = r11
            swisseph.DblObj r11 = new swisseph.DblObj
            r11.<init>()
            r48 = r15
            r2 = 12
            r14 = r13[r2]
            r11.val = r14
            swisseph.DblObj r14 = new swisseph.DblObj
            r14.<init>()
            r4 = 15
            r1 = r13[r4]
            r14.val = r1
            swisseph.Swemmoon r1 = r0.sm
            r2 = -1
            r4 = 18
            r15 = 12
            r50 = r77
            r77 = r3
            r49 = r20
            r2 = r74
            r4 = r7
            r16 = r5
            r53 = r6
            r52 = r22
            r6 = r11
            r12 = r7
            r7 = r14
            r1.swi_mean_lunar_elements(r2, r4, r5, r6, r7)
            double r1 = r12.val
            r3 = 0
            r13[r3] = r1
            r1 = r16
            double r1 = r1.val
            r3 = 3
            r13[r3] = r1
            double r1 = r11.val
            r13[r15] = r1
            double r1 = r14.val
            r3 = 15
            r13[r3] = r1
            r1 = 4617479219754816277(0x401494e2cb3bd315, double:5.1453964)
            r3 = 4588072815333485888(0x3fac1beab9942d40, double:0.054900489)
            r5 = 4568071413629670068(0x3f650cbf7e0352b4, double:0.002569555290487047)
            r24 = r38
            r27 = r24
            r11 = r53
            r53 = r27
            goto L_0x02e0
        L_0x01df:
            r50 = r77
            r77 = r3
            r53 = r6
            r47 = r12
            r48 = r15
            r49 = r20
            r52 = r22
            r15 = 12
            int[] r1 = ipl_to_elem
            r11 = r53
            r1 = r1[r11]
            double[][] r2 = el_incl
            r2 = r2[r1]
            r3 = 0
            r6 = r2[r3]
            r3 = 1
            r18 = r2[r3]
            double r18 = r18 * r4
            double r6 = r6 + r18
            r3 = 2
            r18 = r2[r3]
            double r18 = r18 * r4
            double r18 = r18 * r4
            double r6 = r6 + r18
            r3 = 3
            r18 = r2[r3]
            double r18 = r18 * r4
            double r18 = r18 * r4
            double r18 = r18 * r4
            double r6 = r6 + r18
            r3 = 1
            r18 = r2[r3]
            r16 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r18 = r18 / r16
            double[][] r2 = el_sema
            r2 = r2[r1]
            r14 = 0
            r20 = r2[r14]
            r24 = r2[r3]
            double r24 = r24 * r4
            double r20 = r20 + r24
            r3 = 2
            r24 = r2[r3]
            double r24 = r24 * r4
            double r24 = r24 * r4
            double r20 = r20 + r24
            r3 = 3
            r24 = r2[r3]
            double r24 = r24 * r4
            double r24 = r24 * r4
            double r24 = r24 * r4
            double r20 = r20 + r24
            r3 = 1
            r24 = r2[r3]
            r16 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r24 = r24 / r16
            double[][] r2 = el_ecce
            r2 = r2[r1]
            r14 = 0
            r27 = r2[r14]
            r53 = r2[r3]
            double r53 = r53 * r4
            double r27 = r27 + r53
            r3 = 2
            r53 = r2[r3]
            double r53 = r53 * r4
            double r53 = r53 * r4
            double r27 = r27 + r53
            r3 = 3
            r53 = r2[r3]
            double r53 = r53 * r4
            double r53 = r53 * r4
            double r53 = r53 * r4
            double r27 = r27 + r53
            r3 = 1
            r53 = r2[r3]
            r16 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r53 = r53 / r16
            double[][] r2 = el_node
            r2 = r2[r1]
            r14 = 0
            r55 = r2[r14]
            r57 = r2[r3]
            double r57 = r57 * r4
            double r55 = r55 + r57
            r3 = 2
            r57 = r2[r3]
            double r57 = r57 * r4
            double r57 = r57 * r4
            double r55 = r55 + r57
            r3 = 3
            r57 = r2[r3]
            double r57 = r57 * r4
            double r57 = r57 * r4
            double r57 = r57 * r4
            double r55 = r55 + r57
            r14 = 0
            r13[r14] = r55
            r22 = 1
            r55 = r2[r22]
            r16 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r55 = r55 / r16
            r13[r3] = r55
            double[][] r2 = el_peri
            r1 = r2[r1]
            r2 = r1[r14]
            r55 = r1[r22]
            double r55 = r55 * r4
            double r2 = r2 + r55
            r14 = 2
            r55 = r1[r14]
            double r55 = r55 * r4
            double r55 = r55 * r4
            double r2 = r2 + r55
            r14 = 3
            r55 = r1[r14]
            double r55 = r55 * r4
            double r55 = r55 * r4
            double r55 = r55 * r4
            double r2 = r2 + r55
            r13[r15] = r2
            r2 = 1
            r3 = r1[r2]
            r1 = 4675252771358769152(0x40e1d5a000000000, double:36525.0)
            double r3 = r3 / r1
            r1 = 15
            r13[r1] = r3
            r1 = r6
            r5 = r20
            r3 = r27
            r27 = r24
            r24 = r18
        L_0x02e0:
            swisseph.SwissLib r7 = r0.sl
            r14 = 0
            r16 = r13[r14]
            r18 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r8 = r16 + r18
            double r7 = r7.swe_degnorm(r8)
            r9 = 6
            r13[r9] = r7
            r7 = 9
            r8 = 3
            r16 = r13[r8]
            r13[r7] = r16
            swisseph.SwissLib r7 = r0.sl
            r8 = r13[r15]
            r14 = 0
            r16 = r13[r14]
            double r8 = r8 - r16
            double r7 = r7.swe_degnorm(r8)
            r13[r15] = r7
            swisseph.SwissLib r9 = r0.sl
            r16 = r13[r15]
            r12 = 15
            r18 = r13[r12]
            double r16 = r16 + r18
            r14 = 3
            r18 = r13[r14]
            r55 = r10
            r56 = r11
            double r10 = r16 - r18
            double r9 = r9.swe_degnorm(r10)
            r13[r12] = r9
            swisseph.SwissLib r11 = r0.sl
            r18 = 12
            r20 = 12
            double r1 = -r1
            r16 = r11
            r17 = r13
            r19 = r13
            r21 = r1
            r16.swe_cotrans(r17, r18, r19, r20, r21)
            swisseph.SwissLib r11 = r0.sl
            r18 = 15
            r20 = 15
            double r21 = r1 - r24
            r16 = r11
            r16.swe_cotrans(r17, r18, r19, r20, r21)
            swisseph.SwissLib r1 = r0.sl
            r16 = r13[r15]
            r2 = 0
            r18 = r13[r2]
            r20 = r3
            double r2 = r16 + r18
            double r1 = r1.swe_degnorm(r2)
            r13[r15] = r1
            swisseph.SwissLib r1 = r0.sl
            r2 = 15
            r3 = r13[r2]
            r11 = 0
            r16 = r13[r11]
            double r3 = r3 + r16
            r11 = 3
            r16 = r13[r11]
            double r3 = r3 + r16
            double r3 = r1.swe_degnorm(r3)
            r13[r2] = r3
            swisseph.SwissLib r1 = r0.sl
            r3 = r13[r2]
            r11 = r13[r15]
            double r3 = r3 - r11
            double r3 = r1.swe_degnorm(r3)
            r13[r2] = r3
            double r1 = r43 - r20
            double r3 = r5 * r1
            r11 = 14
            r13[r11] = r3
            r3 = 17
            double r27 = r5 + r27
            double r16 = r1 - r53
            double r18 = r27 * r16
            r24 = r13[r11]
            double r18 = r18 - r24
            r13[r3] = r18
            swisseph.SwissLib r3 = r0.sl
            r18 = r13[r15]
            r24 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r11 = r18 + r24
            double r11 = r3.swe_degnorm(r11)
            r3 = 18
            r13[r3] = r11
            r11 = 19
            r12 = 13
            r3 = r13[r12]
            double r3 = -r3
            r13[r11] = r3
            r3 = 21
            r4 = 15
            r11 = r13[r4]
            r13[r3] = r11
            r3 = 22
            r11 = r13[r23]
            double r11 = -r11
            r13[r3] = r11
            if (r35 == 0) goto L_0x03d1
            r3 = 20
            double r11 = r5 * r20
            double r11 = r11 * r45
            r13[r3] = r11
            r3 = 23
            double r11 = r20 + r53
            double r11 = r11 * r27
            double r11 = r11 * r45
            r4 = 20
            r18 = r13[r4]
            double r11 = r11 - r18
            r13[r3] = r11
            goto L_0x03e7
        L_0x03d1:
            r3 = 20
            double r11 = r20 + r43
            double r18 = r5 * r11
            r13[r3] = r18
            r3 = 23
            double r11 = r11 + r53
            double r11 = r11 * r27
            r4 = 20
            r18 = r13[r4]
            double r11 = r11 - r18
            r13[r3] = r11
        L_0x03e7:
            double r3 = -r7
            double r3 = r3 * r41
            double r3 = r3 / r45
            double r3 = swisseph.SMath.tan(r3)
            double r11 = r20 + r43
            double r1 = r1 / r11
            double r18 = swisseph.SMath.sqrt(r1)
            double r3 = r3 * r18
            double r3 = swisseph.SMath.atan(r3)
            double r3 = r3 * r45
            double r14 = -r9
            double r14 = r14 * r41
            double r14 = r14 / r45
            double r14 = swisseph.SMath.tan(r14)
            double r11 = r11 + r53
            double r16 = r16 / r11
            double r11 = swisseph.SMath.sqrt(r16)
            double r14 = r14 * r11
            double r11 = swisseph.SMath.atan(r14)
            double r11 = r11 * r45
            double r3 = swisseph.SMath.cos(r3)
            double r3 = r3 - r20
            double r3 = r3 * r5
            double r14 = r7 * r41
            double r14 = swisseph.SMath.cos(r14)
            double r3 = r3 / r14
            r14 = 2
            r13[r14] = r3
            double r3 = swisseph.SMath.cos(r11)
            double r3 = r3 - r20
            double r3 = r3 - r53
            double r3 = r3 * r27
            double r11 = r9 * r41
            double r11 = swisseph.SMath.cos(r11)
            double r3 = r3 / r11
            r11 = 5
            r13[r11] = r3
            r3 = r13[r11]
            r12 = 2
            r14 = r13[r12]
            double r3 = r3 - r14
            r13[r11] = r3
            r3 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r3 = r3 - r7
            double r3 = r3 * r41
            double r7 = r3 / r45
            double r7 = swisseph.SMath.tan(r7)
            double r1 = swisseph.SMath.sqrt(r1)
            double r7 = r7 * r1
            double r1 = swisseph.SMath.atan(r7)
            double r1 = r1 * r45
            r7 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r7 = r7 - r9
            double r7 = r7 * r41
            double r9 = r7 / r45
            double r9 = swisseph.SMath.tan(r9)
            double r11 = swisseph.SMath.sqrt(r16)
            double r9 = r9 * r11
            double r9 = swisseph.SMath.atan(r9)
            double r9 = r9 * r45
            double r1 = swisseph.SMath.cos(r1)
            double r1 = r1 - r20
            double r5 = r5 * r1
            double r1 = swisseph.SMath.cos(r3)
            double r5 = r5 / r1
            r1 = 8
            r13[r1] = r5
            r1 = 11
            double r2 = swisseph.SMath.cos(r9)
            double r2 = r2 - r20
            double r2 = r2 - r53
            double r27 = r27 * r2
            double r2 = swisseph.SMath.cos(r7)
            double r27 = r27 / r2
            r13[r1] = r27
            r2 = r13[r1]
            r4 = 8
            r4 = r13[r4]
            double r2 = r2 - r4
            r13[r1] = r2
            r1 = 0
            r2 = 0
        L_0x04aa:
            r3 = 4
            if (r1 >= r3) goto L_0x04d7
            int r3 = r2 + 0
            r4 = r13[r3]
            double r4 = r4 * r41
            r13[r3] = r4
            int r3 = r2 + 1
            r4 = r13[r3]
            double r4 = r4 * r41
            r13[r3] = r4
            int r3 = r2 + 3
            r4 = r13[r3]
            double r4 = r4 * r41
            r13[r3] = r4
            int r3 = r2 + 4
            r4 = r13[r3]
            double r4 = r4 * r41
            r13[r3] = r4
            swisseph.SwissLib r3 = r0.sl
            r3.swi_polcart_sp(r13, r2, r13, r2)
            int r1 = r1 + 1
            r3 = 6
            int r2 = r2 + r3
            goto L_0x04aa
        L_0x04d7:
            r59 = r13
            r60 = r48
            r58 = r50
            r8 = 2
            r9 = 6
            r26 = 0
            r27 = 0
            goto L_0x0954
        L_0x04e5:
            r50 = r77
            r77 = r3
            r56 = r6
            r55 = r10
            r47 = r12
            r48 = r15
            r49 = r20
            r52 = r22
        L_0x04f5:
            swisseph.SwissEph r1 = r0.sw
            r8 = r2
            r9 = 18
            r2 = r74
            r4 = r48
            r5 = r77
            r10 = r19
            r6 = r55
            r11 = r7
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            r15 = -1
            if (r1 != r15) goto L_0x050f
            return r15
        L_0x050f:
            r12 = r50
            r1 = r12 & 7
            r1 = r1 | 32
            r1 = r1 | 2048(0x800, float:2.87E-42)
            r1 = r1 | 4096(0x1000, float:5.74E-42)
            r1 = r1 | 16
            r1 = r1 | 64
            r1 = r1 | 256(0x100, float:3.59E-43)
            r7 = r48
            r2 = 1
            if (r7 == r2) goto L_0x053f
            r2 = 4
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0539
            r2 = 2
            r3 = r55[r2]
            r5 = 4618441417868443648(0x4018000000000000, double:6.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0539
            r1 = r1 | 16384(0x4000, float:2.2959E-41)
            r8 = r1
            r16 = 1
            goto L_0x0542
        L_0x0539:
            r1 = r1 | 8
            r8 = r1
            r16 = 0
            goto L_0x0542
        L_0x053f:
            r8 = r1
            r16 = 0
        L_0x0542:
            r1 = 1
            if (r7 != r1) goto L_0x0559
            r1 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            r3 = 4382569440205035030(0x3cd203af9ee75616, double:1.0E-15)
            r5 = 4471768606512584721(0x3e0ee9daeced1811, double:8.997011693402468E-10)
            r19 = r3
            r50 = r5
            goto L_0x05ab
        L_0x0559:
            r1 = 2
            if (r7 < r1) goto L_0x0560
            r1 = 9
            if (r7 <= r1) goto L_0x0564
        L_0x0560:
            r1 = 14
            if (r7 != r1) goto L_0x056f
        L_0x0564:
            double[] r1 = plmass
            int[] r2 = ipl_to_elem
            r2 = r2[r56]
            r2 = r1[r2]
            double r1 = r43 / r2
            goto L_0x0571
        L_0x056f:
            r1 = r38
        L_0x0571:
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            r5 = 2
            r19 = r55[r5]
            double r3 = r3 * r19
            r5 = 4382569440205035030(0x3cd203af9ee75616, double:1.0E-15)
            double r5 = r5 * r3
            r19 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            double r5 = r5 / r19
            r19 = 4908016519091916237(0x441cc70534390dcd, double:1.32712440017987E20)
            double r1 = r1 + r43
            double r1 = r1 * r19
            r19 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            double r1 = r1 / r19
            double r1 = r1 / r19
            double r1 = r1 / r19
            r19 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r1 = r1 * r19
            double r1 = r1 * r19
            r50 = r1
            r1 = r3
            r19 = r5
        L_0x05ab:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x05b4
            r53 = r1
            r5 = 2
            goto L_0x05b8
        L_0x05b4:
            r53 = r38
            r5 = 0
        L_0x05b8:
            r2 = r74
            double r21 = r2 - r53
            r4 = 0
        L_0x05bd:
            if (r4 > r5) goto L_0x062c
            if (r5 != 0) goto L_0x05c4
            r23 = r2
            goto L_0x05c6
        L_0x05c4:
            r23 = r21
        L_0x05c6:
            swisseph.SwissEph r1 = r0.sw
            r17 = r18[r4]
            r2 = r23
            r21 = r4
            r4 = r7
            r9 = r5
            r5 = r8
            r57 = r6
            r6 = r17
            r59 = r7
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            if (r1 != r15) goto L_0x05e0
            return r15
        L_0x05e0:
            r7 = r59
            r1 = 14
            if (r7 != r1) goto L_0x0610
            swisseph.SwissEph r1 = r0.sw
            r4 = 1
            r5 = r8 & -16393(0xffffffffffffbff7, float:NaN)
            r2 = r23
            r6 = r10
            r60 = r7
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            if (r1 != r15) goto L_0x05f9
            return r15
        L_0x05f9:
            r1 = 0
        L_0x05fa:
            r2 = 2
            if (r1 > r2) goto L_0x0612
            r2 = r18[r21]
            r3 = r2[r1]
            r5 = r10[r1]
            r58 = 4635491803978825048(0x4054933c5f647d58, double:82.30055985272827)
            double r5 = r5 / r58
            double r3 = r3 + r5
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x05fa
        L_0x0610:
            r60 = r7
        L_0x0612:
            swisseph.SwissEph r1 = r0.sw
            r2 = r18[r21]
            r7 = r77
            r3 = r23
            r1.swi_plan_for_osc_elem(r7, r3, r2)
            int r1 = r21 + 1
            double r21 = r3 + r53
            r2 = r74
            r4 = r1
            r5 = r9
            r6 = r57
            r7 = r60
            r9 = 18
            goto L_0x05bd
        L_0x062c:
            r9 = r5
            r57 = r6
            r60 = r7
            r7 = r77
            r1 = 0
        L_0x0634:
            if (r1 > r9) goto L_0x068b
            r2 = r18[r1]
            r3 = 5
            r4 = r2[r3]
            double r4 = swisseph.SMath.abs((double) r4)
            int r2 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x0647
            r2 = r18[r1]
            r2[r3] = r19
        L_0x0647:
            r2 = r18[r1]
            r4 = 2
            r5 = r2[r4]
            r2 = r18[r1]
            r21 = r2[r3]
            double r5 = r5 / r21
            r2 = r18[r1]
            r21 = r2[r3]
            r2 = r18[r1]
            r23 = r2[r3]
            double r2 = swisseph.SMath.abs((double) r23)
            double r21 = r21 / r2
            r2 = 0
        L_0x0661:
            r3 = 2
            if (r2 > r3) goto L_0x0688
            r3 = r14[r1]
            r4 = r18[r1]
            r23 = r4[r2]
            r4 = r18[r1]
            int r8 = r2 + 3
            r58 = r4[r8]
            double r58 = r58 * r5
            double r23 = r23 - r58
            double r23 = r23 * r21
            r3[r2] = r23
            r3 = r27[r1]
            r4 = r14[r1]
            r76 = r5
            r5 = r4[r2]
            double r4 = -r5
            r3[r2] = r4
            int r2 = r2 + 1
            r5 = r76
            goto L_0x0661
        L_0x0688:
            int r1 = r1 + 1
            goto L_0x0634
        L_0x068b:
            r1 = 0
        L_0x068c:
            if (r1 > r9) goto L_0x089b
            r2 = r14[r1]
            r3 = 0
            r4 = r2[r3]
            r2 = r14[r1]
            r19 = r2[r3]
            double r4 = r4 * r19
            r2 = r14[r1]
            r6 = 1
            r19 = r2[r6]
            r2 = r14[r1]
            r21 = r2[r6]
            double r19 = r19 * r21
            double r4 = r4 + r19
            double r4 = swisseph.SMath.sqrt(r4)
            r2 = r14[r1]
            r19 = r2[r3]
            double r2 = r19 / r4
            r8 = r14[r1]
            r19 = r8[r6]
            double r4 = r19 / r4
            swisseph.SwissLib r6 = r0.sl
            r20 = r18[r1]
            r21 = 0
            r22 = r18[r1]
            r23 = 3
            r25 = 0
            r19 = r6
            r24 = r11
            r19.swi_cross_prod(r20, r21, r22, r23, r24, r25)
            r6 = 0
            r19 = r11[r6]
            r21 = r11[r6]
            double r19 = r19 * r21
            r6 = 1
            r21 = r11[r6]
            r23 = r11[r6]
            double r21 = r21 * r23
            double r19 = r19 + r21
            r6 = 2
            r21 = r11[r6]
            r23 = r11[r6]
            double r21 = r21 * r23
            double r21 = r19 + r21
            double r23 = swisseph.SMath.sqrt(r21)
            double r19 = swisseph.SMath.sqrt(r19)
            r6 = r9
            double r8 = r19 / r23
            double r19 = r8 * r8
            double r19 = r43 - r19
            r76 = r6
            r77 = r7
            double r6 = swisseph.SMath.sqrt(r19)
            r10 = 2
            r19 = r11[r10]
            int r10 = (r19 > r38 ? 1 : (r19 == r38 ? 0 : -1))
            if (r10 >= 0) goto L_0x0701
            double r6 = -r6
        L_0x0701:
            r66 = r6
            r6 = r18[r1]
            r7 = 0
            r19 = r6[r7]
            double r19 = r19 * r2
            r6 = r18[r1]
            r7 = 1
            r23 = r6[r7]
            double r23 = r23 * r4
            double r6 = r19 + r23
            r10 = r18[r1]
            r17 = 2
            r19 = r10[r17]
            r17 = r11
            double r10 = r19 / r8
            double r6 = swisseph.SMath.atan2(r10, r6)
            swisseph.SwissLib r10 = r0.sl
            r11 = r18[r1]
            double r10 = r10.square_sum(r11)
            double r10 = swisseph.SMath.sqrt(r10)
            swisseph.SwissLib r15 = r0.sl
            r58 = r12
            r12 = r18[r1]
            r59 = r13
            r13 = 3
            double r19 = r15.square_sum(r12, r13)
            double r12 = r45 / r10
            double r19 = r19 / r50
            double r12 = r12 - r19
            double r12 = r43 / r12
            double r21 = r21 / r50
            double r21 = r21 / r12
            double r19 = r43 - r21
            double r19 = swisseph.SMath.sqrt(r19)
            double r21 = r43 / r19
            double r10 = r10 / r12
            double r10 = r43 - r10
            double r10 = r10 * r21
            double r23 = r12 * r50
            double r23 = swisseph.SMath.sqrt(r23)
            double r21 = r21 / r23
            swisseph.SwissEph r15 = r0.sw
            r23 = r14
            r14 = r18[r1]
            r68 = r2
            r2 = r18[r1]
            r3 = 3
            double r14 = r15.dot_prod(r14, r2, r3)
            double r21 = r21 * r14
            double r14 = r19 + r43
            double r61 = r43 - r19
            double r70 = r14 / r61
            double r63 = swisseph.SMath.sqrt(r70)
            double r63 = r63 * r21
            double r10 = r10 + r43
            double r63 = r63 / r10
            double r10 = swisseph.SMath.atan(r63)
            double r10 = r10 * r45
            r2 = r28[r1]
            swisseph.SwissLib r3 = r0.sl
            r21 = r14
            double r14 = r6 - r10
            double r14 = r3.swi_mod2PI(r14)
            r3 = 0
            r2[r3] = r14
            r2 = r28[r1]
            r3 = 1
            r2[r3] = r38
            r2 = r28[r1]
            double r61 = r61 * r12
            r3 = 2
            r2[r3] = r61
            swisseph.SwissLib r2 = r0.sl
            r3 = r28[r1]
            r14 = r28[r1]
            r2.swi_polcart(r3, r14)
            swisseph.SwissLib r2 = r0.sl
            r62 = r28[r1]
            r63 = r28[r1]
            double r8 = -r8
            r61 = r2
            r64 = r8
            r61.swi_coortrf2(r62, r63, r64, r66)
            swisseph.SwissLib r2 = r0.sl
            r3 = r28[r1]
            r8 = r28[r1]
            r2.swi_cartpol(r3, r8)
            r2 = r28[r1]
            r3 = 0
            r8 = r2[r3]
            r14 = r68
            double r4 = swisseph.SMath.atan2(r4, r14)
            double r8 = r8 + r4
            r2[r3] = r8
            r2 = r29[r1]
            swisseph.SwissLib r4 = r0.sl
            r5 = r28[r1]
            r8 = r5[r3]
            r14 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r8 = r8 + r14
            double r4 = r4.swi_mod2PI(r8)
            r2[r3] = r4
            r2 = r29[r1]
            r3 = r28[r1]
            r4 = 1
            r8 = r3[r4]
            double r8 = -r8
            r2[r4] = r8
            if (r35 == 0) goto L_0x07f5
            r2 = r29[r1]
            double r3 = r12 * r19
            double r3 = r3 * r45
            r5 = 2
            r2[r5] = r3
            goto L_0x07fc
        L_0x07f5:
            r5 = 2
            r2 = r29[r1]
            double r14 = r12 * r21
            r2[r5] = r14
        L_0x07fc:
            swisseph.SwissLib r2 = r0.sl
            r3 = r28[r1]
            r4 = r28[r1]
            r2.swi_polcart(r3, r4)
            swisseph.SwissLib r2 = r0.sl
            r3 = r29[r1]
            r4 = r29[r1]
            r2.swi_polcart(r3, r4)
            swisseph.SwissLib r2 = r0.sl
            double r10 = r10 - r6
            double r2 = r2.swi_mod2PI(r10)
            swisseph.SwissLib r4 = r0.sl
            r5 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r5 = r5 + r2
            double r4 = r4.swi_mod2PI(r5)
            double r2 = r2 / r45
            double r2 = swisseph.SMath.tan(r2)
            double r6 = swisseph.SMath.sqrt(r70)
            double r2 = r2 / r6
            double r2 = swisseph.SMath.atan(r2)
            double r2 = r2 * r45
            double r2 = swisseph.SMath.cos(r2)
            double r4 = r4 / r45
            double r4 = swisseph.SMath.tan(r4)
            double r6 = swisseph.SMath.sqrt(r70)
            double r4 = r4 / r6
            double r4 = swisseph.SMath.atan(r4)
            double r4 = r4 * r45
            double r4 = swisseph.SMath.cos(r4)
            double r2 = r2 * r19
            double r2 = r43 - r2
            double r2 = r2 * r12
            double r19 = r19 * r4
            double r4 = r43 - r19
            double r12 = r12 * r4
            swisseph.SwissLib r4 = r0.sl
            r5 = r23[r1]
            double r4 = r4.square_sum(r5)
            double r4 = swisseph.SMath.sqrt(r4)
            swisseph.SwissLib r6 = r0.sl
            r7 = r27[r1]
            double r6 = r6.square_sum(r7)
            double r6 = swisseph.SMath.sqrt(r6)
            r8 = 0
        L_0x0870:
            r9 = 2
            if (r8 > r9) goto L_0x088a
            r9 = r23[r1]
            r10 = r9[r8]
            double r14 = r2 / r4
            double r10 = r10 * r14
            r9[r8] = r10
            r9 = r27[r1]
            r10 = r9[r8]
            double r14 = r12 / r6
            double r10 = r10 * r14
            r9[r8] = r10
            int r8 = r8 + 1
            goto L_0x0870
        L_0x088a:
            int r1 = r1 + 1
            r9 = r76
            r7 = r77
            r11 = r17
            r14 = r23
            r12 = r58
            r13 = r59
            r15 = -1
            goto L_0x068c
        L_0x089b:
            r77 = r7
            r58 = r12
            r59 = r13
            r23 = r14
            r2 = 0
        L_0x08a4:
            r1 = 2
            if (r2 > r1) goto L_0x094e
            if (r57 == 0) goto L_0x0919
            int r1 = r2 + 12
            r3 = 1
            r4 = r28[r3]
            r3 = r4[r2]
            r59[r1] = r3
            int r1 = r2 + 3
            int r3 = r1 + 12
            r4 = 2
            r5 = r28[r4]
            r4 = r5[r2]
            r6 = 0
            r7 = r28[r6]
            r6 = r7[r2]
            double r4 = r4 - r6
            double r4 = r4 / r53
            double r4 = r4 / r45
            r59[r3] = r4
            int r3 = r2 + 18
            r4 = 1
            r5 = r29[r4]
            r4 = r5[r2]
            r59[r3] = r4
            int r3 = r1 + 18
            r4 = 2
            r5 = r29[r4]
            r4 = r5[r2]
            r6 = 0
            r7 = r29[r6]
            r6 = r7[r2]
            double r4 = r4 - r6
            double r4 = r4 / r53
            double r4 = r4 / r45
            r59[r3] = r4
            r3 = 1
            r4 = r23[r3]
            r3 = r4[r2]
            r59[r2] = r3
            r3 = 2
            r4 = r23[r3]
            r3 = r4[r2]
            r5 = 0
            r6 = r23[r5]
            r5 = r6[r2]
            double r3 = r3 - r5
            double r3 = r3 / r53
            double r3 = r3 / r45
            r59[r1] = r3
            int r3 = r2 + 6
            r4 = 1
            r5 = r27[r4]
            r4 = r5[r2]
            r59[r3] = r4
            r3 = 6
            int r1 = r1 + r3
            r8 = 2
            r3 = r27[r8]
            r4 = r3[r2]
            r3 = 0
            r6 = r27[r3]
            r9 = r6[r2]
            double r4 = r4 - r9
            double r4 = r4 / r53
            double r4 = r4 / r45
            r59[r1] = r4
            r9 = 6
            goto L_0x094a
        L_0x0919:
            r3 = 0
            r8 = 2
            int r1 = r2 + 12
            r4 = r28[r3]
            r3 = r4[r2]
            r59[r1] = r3
            int r1 = r2 + 3
            int r3 = r1 + 12
            r59[r3] = r38
            int r3 = r2 + 18
            r4 = 0
            r5 = r29[r4]
            r6 = r5[r2]
            r59[r3] = r6
            int r3 = r1 + 18
            r59[r3] = r38
            r3 = r23[r4]
            r5 = r3[r2]
            r59[r2] = r5
            r59[r1] = r38
            int r3 = r2 + 6
            r5 = r27[r4]
            r4 = r5[r2]
            r59[r3] = r4
            r9 = 6
            int r1 = r1 + r9
            r59[r1] = r38
        L_0x094a:
            int r2 = r2 + 1
            goto L_0x08a4
        L_0x094e:
            r8 = 2
            r9 = 6
            r27 = r16
            r26 = 1
        L_0x0954:
            r15 = r60
            r1 = 1
            if (r15 != r1) goto L_0x097d
            r12 = r58
            r1 = r12 & 16392(0x4008, float:2.297E-41)
            if (r1 == 0) goto L_0x097a
            swisseph.SwissEph r1 = r0.sw
            r1.swi_force_app_pos_etc()
            swisseph.SwissEph r1 = r0.sw
            r4 = 0
            r11 = 3
            r2 = r74
            r5 = r77
            r6 = r55
            r28 = r77
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            r2 = -1
            if (r1 != r2) goto L_0x0999
            return r2
        L_0x097a:
            r28 = r77
            goto L_0x0981
        L_0x097d:
            r28 = r77
            r12 = r58
        L_0x0981:
            r11 = 3
            swisseph.SwissEph r1 = r0.sw
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            r5 = r28 | r2
            r2 = r74
            r4 = r15
            r6 = r55
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            r2 = -1
            if (r1 != r2) goto L_0x0999
            return r2
        L_0x0999:
            r1 = 32768(0x8000, float:4.5918E-41)
            r29 = r12 & r1
            if (r29 == 0) goto L_0x09b2
            swisseph.SwissEph r1 = r0.sw
            r5 = 0
            r2 = r74
            r4 = r12
            r6 = r47
            r7 = r83
            int r1 = r1.swi_get_observer(r2, r4, r5, r6, r7)
            if (r1 == 0) goto L_0x09bb
            r1 = -1
            return r1
        L_0x09b2:
            r2 = 0
        L_0x09b3:
            r1 = 5
            if (r2 > r1) goto L_0x09bb
            r47[r2] = r38
            int r2 = r2 + 1
            goto L_0x09b3
        L_0x09bb:
            r14 = r12 & 16392(0x4008, float:2.297E-41)
            if (r14 == 0) goto L_0x09d2
            r1 = r12 & 8
            if (r1 == 0) goto L_0x09f1
            r1 = r12 & 4
            if (r1 != 0) goto L_0x09f1
            r2 = 0
        L_0x09c8:
            r1 = 5
            if (r2 > r1) goto L_0x09f1
            r3 = r40[r2]
            r47[r2] = r3
            int r2 = r2 + 1
            goto L_0x09c8
        L_0x09d2:
            if (r56 != 0) goto L_0x09e3
            r1 = r12 & 4
            if (r1 != 0) goto L_0x09e3
            r2 = 0
        L_0x09d9:
            r1 = 5
            if (r2 > r1) goto L_0x09f1
            r3 = r40[r2]
            r47[r2] = r3
            int r2 = r2 + 1
            goto L_0x09d9
        L_0x09e3:
            r2 = 0
        L_0x09e4:
            r1 = 5
            if (r2 > r1) goto L_0x09f1
            r3 = r47[r2]
            r5 = r49[r2]
            double r3 = r3 + r5
            r47[r2] = r3
            int r2 = r2 + 1
            goto L_0x09e4
        L_0x09f1:
            r30 = r12 & 32
            if (r30 == 0) goto L_0x09fb
            swisseph.SwissData r1 = r0.swed
            swisseph.Epsilon r1 = r1.oec2000
            r13 = r1
            goto L_0x0a00
        L_0x09fb:
            swisseph.SwissData r1 = r0.swed
            swisseph.Epsilon r1 = r1.oec
            r13 = r1
        L_0x0a00:
            r7 = 0
            r10 = 0
        L_0x0a02:
            r6 = 4
            if (r10 >= r6) goto L_0x0ea5
            r4 = 14
            if (r15 != r4) goto L_0x0a3f
            r1 = 1
            if (r10 > r1) goto L_0x0a3f
            r2 = 0
        L_0x0a0d:
            r1 = 5
            if (r2 > r1) goto L_0x0a17
            int r1 = r2 + r7
            r59[r1] = r38
            int r2 = r2 + 1
            goto L_0x0a0d
        L_0x0a17:
            r4 = r83
            r8 = r7
            r7 = r10
            r9 = r12
            r22 = r13
            r5 = r14
            r23 = r15
            r76 = r31
            r6 = r32
            r1 = r33
            r18 = r40
            r21 = r47
            r72 = r56
            r2 = r59
            r3 = 6
            r10 = 2
            r19 = 4
            r20 = 3
            r24 = 14
            r25 = -1
            r31 = 1
            r12 = r74
            goto L_0x0e86
        L_0x0a3f:
            if (r26 == 0) goto L_0x0a89
            r1 = r12 & 64
            if (r1 != 0) goto L_0x0a89
            swisseph.SwissLib r1 = r0.sl
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r2 = r2.snut
            double r2 = -r2
            swisseph.SwissData r5 = r0.swed
            swisseph.Nut r5 = r5.nut
            double r4 = r5.cnut
            r16 = r1
            r17 = r59
            r18 = r7
            r19 = r59
            r20 = r7
            r21 = r2
            r23 = r4
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0a89
            swisseph.SwissLib r1 = r0.sl
            int r20 = r7 + 3
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r2 = r2.snut
            double r2 = -r2
            swisseph.SwissData r4 = r0.swed
            swisseph.Nut r4 = r4.nut
            double r4 = r4.cnut
            r16 = r1
            r17 = r59
            r18 = r20
            r19 = r59
            r21 = r2
            r23 = r4
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
        L_0x0a89:
            swisseph.SwissLib r1 = r0.sl
            double r2 = r13.seps
            double r2 = -r2
            double r4 = r13.ceps
            r16 = r1
            r17 = r59
            r18 = r7
            r19 = r59
            r20 = r7
            r21 = r2
            r23 = r4
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
            swisseph.SwissLib r1 = r0.sl
            int r35 = r7 + 3
            double r2 = r13.seps
            double r2 = -r2
            double r4 = r13.ceps
            r16 = r1
            r18 = r35
            r20 = r35
            r21 = r2
            r23 = r4
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
            if (r26 == 0) goto L_0x0ac9
            r1 = r12 & 64
            if (r1 != 0) goto L_0x0ac6
            swisseph.SwissEph r1 = r0.sw
            r4 = r59
            r2 = 1
            r1.swi_nutate(r4, r7, r12, r2)
            goto L_0x0acb
        L_0x0ac6:
            r4 = r59
            goto L_0x0acb
        L_0x0ac9:
            r4 = r59
        L_0x0acb:
            swisseph.SwissLib r1 = r0.sl
            r16 = 1
            r2 = r4
            r3 = r7
            r59 = r4
            r43 = 14
            r4 = r74
            r44 = 4
            r6 = r12
            r76 = r7
            r7 = r16
            r1.swi_precess(r2, r3, r4, r6, r7)
            r7 = r12 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0af8
            swisseph.SwissEph r1 = r0.sw
            r16 = 1
            r2 = r59
            r3 = r76
            r4 = r74
            r6 = r12
            r45 = r7
            r7 = r16
            r1.swi_precess_speed(r2, r3, r4, r6, r7)
            goto L_0x0afa
        L_0x0af8:
            r45 = r7
        L_0x0afa:
            r7 = 1
            if (r15 != r7) goto L_0x0b17
            r2 = 0
        L_0x0afe:
            r1 = 5
            if (r2 > r1) goto L_0x0b12
            r6 = r76
            int r1 = r2 + r6
            r5 = r59
            r3 = r5[r1]
            r16 = r49[r2]
            double r3 = r3 + r16
            r5[r1] = r3
            int r2 = r2 + 1
            goto L_0x0afe
        L_0x0b12:
            r6 = r76
            r5 = r59
            goto L_0x0b32
        L_0x0b17:
            r6 = r76
            r5 = r59
            r1 = r12 & 4
            if (r1 != 0) goto L_0x0b32
            if (r27 != 0) goto L_0x0b32
            r2 = 0
        L_0x0b22:
            r1 = 5
            if (r2 > r1) goto L_0x0b32
            int r1 = r2 + r6
            r3 = r5[r1]
            r16 = r40[r2]
            double r3 = r3 + r16
            r5[r1] = r3
            int r2 = r2 + 1
            goto L_0x0b22
        L_0x0b32:
            r2 = 0
        L_0x0b33:
            r1 = 5
            if (r2 > r1) goto L_0x0b43
            int r1 = r2 + r6
            r3 = r5[r1]
            r16 = r47[r2]
            double r3 = r3 - r16
            r5[r1] = r3
            int r2 = r2 + 1
            goto L_0x0b33
        L_0x0b43:
            if (r56 != 0) goto L_0x0b55
            if (r14 != 0) goto L_0x0b55
            r2 = 0
        L_0x0b48:
            r1 = 5
            if (r2 > r1) goto L_0x0b55
            int r1 = r2 + r6
            r3 = r5[r1]
            double r3 = -r3
            r5[r1] = r3
            int r2 = r2 + 1
            goto L_0x0b48
        L_0x0b55:
            swisseph.SwissLib r1 = r0.sl
            double r1 = r1.square_sum(r5, r6)
            double r1 = swisseph.SMath.sqrt(r1)
            r3 = 4774214028411142144(0x42416a5d2d220000, double:1.4959787066E11)
            double r1 = r1 * r3
            r3 = 4733809291562057728(0x41b1de784a000000, double:2.99792458E8)
            double r1 = r1 / r3
            r3 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r1 = r1 / r3
            if (r37 == 0) goto L_0x0b83
            swisseph.SwissEph r3 = r0.sw
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = r1
            r21 = r12
            r16.swi_deflect_light(r17, r18, r19, r21)
        L_0x0b83:
            if (r36 == 0) goto L_0x0c2f
            swisseph.SwissEph r3 = r0.sw
            r4 = r47
            r3.swi_aberr_light(r5, r6, r4, r12)
            if (r45 == 0) goto L_0x0c26
            swisseph.SwissEph r3 = r0.sw
            r8 = r74
            double r16 = r8 - r1
            r18 = r28 | r29
            r1 = r3
            r2 = r16
            r34 = r4
            r4 = r15
            r59 = r15
            r15 = r5
            r5 = r18
            r8 = r6
            r6 = r32
            r9 = 1
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            r2 = -1
            if (r1 != r2) goto L_0x0baf
            return r2
        L_0x0baf:
            if (r29 == 0) goto L_0x0bc2
            r2 = 0
        L_0x0bb2:
            r1 = 5
            if (r2 > r1) goto L_0x0bcb
            swisseph.SwissData r1 = r0.swed
            swisseph.TopoData r1 = r1.topd
            double[] r1 = r1.xobs
            r3 = r1[r2]
            r52[r2] = r3
            int r2 = r2 + 1
            goto L_0x0bb2
        L_0x0bc2:
            r2 = 0
        L_0x0bc3:
            r1 = 5
            if (r2 > r1) goto L_0x0bcb
            r52[r2] = r38
            int r2 = r2 + 1
            goto L_0x0bc3
        L_0x0bcb:
            if (r14 == 0) goto L_0x0be0
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0bff
            r1 = r12 & 4
            if (r1 != 0) goto L_0x0bff
            r2 = 0
        L_0x0bd6:
            r1 = 5
            if (r2 > r1) goto L_0x0bff
            r3 = r40[r2]
            r52[r2] = r3
            int r2 = r2 + 1
            goto L_0x0bd6
        L_0x0be0:
            if (r56 != 0) goto L_0x0bf1
            r1 = r12 & 4
            if (r1 != 0) goto L_0x0bf1
            r2 = 0
        L_0x0be7:
            r1 = 5
            if (r2 > r1) goto L_0x0bff
            r3 = r40[r2]
            r52[r2] = r3
            int r2 = r2 + 1
            goto L_0x0be7
        L_0x0bf1:
            r2 = 0
        L_0x0bf2:
            r1 = 5
            if (r2 > r1) goto L_0x0bff
            r3 = r52[r2]
            r5 = r49[r2]
            double r3 = r3 + r5
            r52[r2] = r3
            int r2 = r2 + 1
            goto L_0x0bf2
        L_0x0bff:
            r2 = 3
        L_0x0c00:
            r1 = 5
            if (r2 > r1) goto L_0x0c13
            int r7 = r2 + r8
            r3 = r15[r7]
            r5 = r34[r2]
            r16 = r52[r2]
            double r5 = r5 - r16
            double r3 = r3 + r5
            r15[r7] = r3
            int r2 = r2 + 1
            goto L_0x0c00
        L_0x0c13:
            swisseph.SwissEph r1 = r0.sw
            r4 = 0
            r2 = r74
            r5 = r18
            r6 = r32
            r7 = r83
            int r1 = r1.swe_calc(r2, r4, r5, r6, r7)
            r7 = -1
            if (r1 != r7) goto L_0x0c37
            return r7
        L_0x0c26:
            r34 = r4
            r8 = r6
            r59 = r15
            r7 = -1
            r9 = 1
            r15 = r5
            goto L_0x0c37
        L_0x0c2f:
            r8 = r6
            r59 = r15
            r34 = r47
            r7 = -1
            r9 = 1
            r15 = r5
        L_0x0c37:
            r2 = 0
        L_0x0c38:
            r1 = 5
            if (r2 > r1) goto L_0x0c44
            int r1 = r2 + r8
            r3 = r15[r1]
            r31[r2] = r3
            int r2 = r2 + 1
            goto L_0x0c38
        L_0x0c44:
            if (r30 != 0) goto L_0x0c64
            swisseph.SwissLib r1 = r0.sl
            r16 = -1
            r2 = r15
            r3 = r8
            r4 = r74
            r6 = r12
            r25 = -1
            r7 = r16
            r1.swi_precess(r2, r3, r4, r6, r7)
            if (r45 == 0) goto L_0x0c66
            swisseph.SwissEph r1 = r0.sw
            r7 = -1
            r2 = r15
            r3 = r8
            r4 = r74
            r6 = r12
            r1.swi_precess_speed(r2, r3, r4, r6, r7)
            goto L_0x0c66
        L_0x0c64:
            r25 = -1
        L_0x0c66:
            r1 = r12 & 64
            if (r1 != 0) goto L_0x0c71
            swisseph.SwissEph r2 = r0.sw
            r3 = 0
            r2.swi_nutate(r15, r8, r12, r3)
            goto L_0x0c72
        L_0x0c71:
            r3 = 0
        L_0x0c72:
            r2 = 0
        L_0x0c73:
            r4 = 5
            if (r2 > r4) goto L_0x0c85
            r4 = r33
            double[] r5 = r4.xreturn
            int r6 = r2 + 18
            int r7 = r2 + r8
            r16 = r15[r7]
            r5[r6] = r16
            int r2 = r2 + 1
            goto L_0x0c73
        L_0x0c85:
            r4 = r33
            swisseph.SwissLib r2 = r0.sl
            double r5 = r13.seps
            r7 = r10
            double r9 = r13.ceps
            r16 = r2
            r17 = r15
            r18 = r8
            r19 = r15
            r20 = r8
            r21 = r5
            r23 = r9
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
            if (r45 == 0) goto L_0x0cb8
            swisseph.SwissLib r2 = r0.sl
            double r5 = r13.seps
            double r9 = r13.ceps
            r16 = r2
            r17 = r15
            r18 = r35
            r19 = r15
            r20 = r35
            r21 = r5
            r23 = r9
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
        L_0x0cb8:
            if (r1 != 0) goto L_0x0cfa
            swisseph.SwissLib r1 = r0.sl
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r5 = r2.snut
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r9 = r2.cnut
            r16 = r1
            r17 = r15
            r18 = r8
            r19 = r15
            r20 = r8
            r21 = r5
            r23 = r9
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
            if (r45 == 0) goto L_0x0cfa
            swisseph.SwissLib r1 = r0.sl
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r5 = r2.snut
            swisseph.SwissData r2 = r0.swed
            swisseph.Nut r2 = r2.nut
            double r9 = r2.cnut
            r16 = r1
            r17 = r15
            r18 = r35
            r19 = r15
            r20 = r35
            r21 = r5
            r23 = r9
            r16.swi_coortrf2(r17, r18, r19, r20, r21, r23)
        L_0x0cfa:
            r2 = 0
        L_0x0cfb:
            r1 = 5
            if (r2 > r1) goto L_0x0d0b
            double[] r5 = r4.xreturn
            int r6 = r2 + 6
            int r9 = r2 + r8
            r9 = r15[r9]
            r5[r6] = r9
            int r2 = r2 + 1
            goto L_0x0cfb
        L_0x0d0b:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x0dbe
            swisseph.SwissData r2 = r0.swed
            swisseph.SidData r2 = r2.sidd
            int r2 = r2.sid_mode
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0d56
            swisseph.SwissEph r10 = r0.sw
            double[] r2 = r4.xreturn
            r5 = 6
            double[] r6 = r4.xreturn
            r9 = 18
            r3 = r31
            r18 = r40
            r72 = r56
            r1 = 0
            r19 = 4
            r20 = 3
            r11 = r3
            r50 = r12
            r21 = r34
            r12 = r2
            r22 = r13
            r2 = r15
            r13 = r5
            r5 = r14
            r15 = 6
            r14 = r6
            r1 = r4
            r6 = r32
            r23 = r59
            r24 = 14
            r31 = 1
            r4 = r83
            r15 = r9
            r16 = r50
            r17 = r83
            int r9 = r10.swi_trop_ra2sid_lon(r11, r12, r13, r14, r15, r16, r17)
            if (r9 == 0) goto L_0x0d52
            return r25
        L_0x0d52:
            r12 = r74
            goto L_0x0ddd
        L_0x0d56:
            r1 = r4
            r50 = r12
            r22 = r13
            r5 = r14
            r2 = r15
            r3 = r31
            r6 = r32
            r21 = r34
            r18 = r40
            r72 = r56
            r23 = r59
            r19 = 4
            r20 = 3
            r24 = 14
            r31 = 1
            r4 = r83
            swisseph.SwissData r9 = r0.swed
            swisseph.SidData r9 = r9.sidd
            int r9 = r9.sid_mode
            r9 = r9 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0d95
            swisseph.SwissEph r10 = r0.sw
            double[] r12 = r1.xreturn
            r13 = 6
            double[] r14 = r1.xreturn
            r15 = 18
            r11 = r3
            r16 = r50
            r17 = r83
            int r9 = r10.swi_trop_ra2sid_lon_sosy(r11, r12, r13, r14, r15, r16, r17)
            if (r9 == 0) goto L_0x0d92
            return r25
        L_0x0d92:
            r12 = r74
            goto L_0x0ddd
        L_0x0d95:
            swisseph.SwissLib r9 = r0.sl
            double[] r10 = r1.xreturn
            double[] r11 = r1.xreturn
            r12 = 6
            r13 = 0
            r9.swi_cartpol_sp(r10, r12, r11, r13)
            double[] r9 = r1.xreturn
            r10 = r9[r13]
            swisseph.SwissEph r14 = r0.sw
            r12 = r74
            double r16 = r14.swe_get_ayanamsa(r12)
            double r16 = r16 * r41
            double r10 = r10 - r16
            r14 = 0
            r9[r14] = r10
            swisseph.SwissLib r9 = r0.sl
            double[] r10 = r1.xreturn
            double[] r11 = r1.xreturn
            r15 = 6
            r9.swi_polcart_sp(r10, r14, r11, r15)
            goto L_0x0ddd
        L_0x0dbe:
            r1 = r4
            r50 = r12
            r22 = r13
            r5 = r14
            r2 = r15
            r3 = r31
            r6 = r32
            r21 = r34
            r18 = r40
            r72 = r56
            r23 = r59
            r19 = 4
            r20 = 3
            r24 = 14
            r31 = 1
            r12 = r74
            r4 = r83
        L_0x0ddd:
            r9 = r50
            r10 = r9 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0dfe
            r11 = r9 & 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x0dfe
            r11 = 0
        L_0x0de8:
            r14 = 5
            if (r11 > r14) goto L_0x0df8
            int r10 = r11 + r8
            double[] r15 = r1.xreturn
            int r16 = r11 + 18
            r16 = r15[r16]
            r2[r10] = r16
            int r11 = r11 + 1
            goto L_0x0de8
        L_0x0df8:
            r76 = r3
            r3 = 6
            r10 = 2
            goto L_0x0e86
        L_0x0dfe:
            r14 = 5
            if (r10 == 0) goto L_0x0e16
            r11 = 0
        L_0x0e02:
            if (r11 > r14) goto L_0x0e11
            int r10 = r11 + r8
            double[] r15 = r1.xreturn
            int r16 = r11 + 6
            r16 = r15[r16]
            r2[r10] = r16
            int r11 = r11 + 1
            goto L_0x0e02
        L_0x0e11:
            r76 = r3
            r3 = 6
            r10 = 2
            goto L_0x0e86
        L_0x0e16:
            swisseph.SwissLib r10 = r0.sl
            double[] r11 = r1.xreturn
            double[] r15 = r1.xreturn
            r76 = r3
            r3 = 12
            r14 = 18
            r10.swi_cartpol_sp(r11, r14, r15, r3)
            swisseph.SwissLib r10 = r0.sl
            double[] r11 = r1.xreturn
            double[] r15 = r1.xreturn
            r3 = 6
            r14 = 0
            r10.swi_cartpol_sp(r11, r3, r15, r14)
            r11 = 0
        L_0x0e31:
            r10 = 2
            if (r11 >= r10) goto L_0x0e62
            double[] r14 = r1.xreturn
            r15 = r14[r11]
            r32 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r15 = r15 * r32
            r14[r11] = r15
            double[] r14 = r1.xreturn
            int r15 = r11 + 3
            r16 = r14[r15]
            double r16 = r16 * r32
            r14[r15] = r16
            double[] r14 = r1.xreturn
            int r15 = r11 + 12
            r16 = r14[r15]
            double r16 = r16 * r32
            r14[r15] = r16
            double[] r14 = r1.xreturn
            int r15 = r11 + 15
            r16 = r14[r15]
            double r16 = r16 * r32
            r14[r15] = r16
            int r11 = r11 + 1
            goto L_0x0e31
        L_0x0e62:
            r11 = r9 & 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x0e77
            r11 = 0
        L_0x0e67:
            r14 = 5
            if (r11 > r14) goto L_0x0e86
            int r14 = r11 + r8
            double[] r15 = r1.xreturn
            int r16 = r11 + 12
            r16 = r15[r16]
            r2[r14] = r16
            int r11 = r11 + 1
            goto L_0x0e67
        L_0x0e77:
            r11 = 0
        L_0x0e78:
            r14 = 5
            if (r11 > r14) goto L_0x0e86
            int r14 = r11 + r8
            double[] r15 = r1.xreturn
            r16 = r15[r11]
            r2[r14] = r16
            int r11 = r11 + 1
            goto L_0x0e78
        L_0x0e86:
            int r7 = r7 + 1
            int r8 = r8 + 6
            r31 = r76
            r33 = r1
            r59 = r2
            r14 = r5
            r32 = r6
            r10 = r7
            r7 = r8
            r12 = r9
            r40 = r18
            r47 = r21
            r13 = r22
            r15 = r23
            r56 = r72
            r8 = 2
            r9 = 6
            r11 = 3
            goto L_0x0a02
        L_0x0ea5:
            r9 = r12
            r2 = r59
            r10 = 2
            r11 = 0
        L_0x0eaa:
            r1 = 5
            if (r11 > r1) goto L_0x0ee2
            if (r11 <= r10) goto L_0x0ec1
            r1 = r9 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0ec1
            int r1 = r11 + 6
            int r3 = r11 + 12
            int r4 = r11 + 18
            r2[r4] = r38
            r2[r3] = r38
            r2[r1] = r38
            r2[r11] = r38
        L_0x0ec1:
            if (r79 == 0) goto L_0x0ec7
            r3 = r2[r11]
            r79[r11] = r3
        L_0x0ec7:
            if (r80 == 0) goto L_0x0ecf
            int r1 = r11 + 6
            r3 = r2[r1]
            r80[r11] = r3
        L_0x0ecf:
            if (r81 == 0) goto L_0x0ed7
            int r1 = r11 + 12
            r3 = r2[r1]
            r81[r11] = r3
        L_0x0ed7:
            if (r82 == 0) goto L_0x0edf
            int r1 = r11 + 18
            r3 = r2[r1]
            r82[r11] = r3
        L_0x0edf:
            int r11 = r11 + 1
            goto L_0x0eaa
        L_0x0ee2:
            r1 = 0
            return r1
        L_0x0ee4:
            r4 = r83
            r72 = r6
            r25 = -1
        L_0x0eea:
            if (r4 == 0) goto L_0x0f0c
            r1 = 0
            r4.setLength(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "nodes/apsides for planet "
            r2.append(r3)
            r6 = r72
            r2.append(r6)
            java.lang.String r3 = " are not implemented"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r4.append(r2)
            goto L_0x0f0d
        L_0x0f0c:
            r1 = 0
        L_0x0f0d:
            if (r79 == 0) goto L_0x0f18
            r11 = 0
        L_0x0f10:
            r2 = 5
            if (r11 > r2) goto L_0x0f18
            r79[r11] = r38
            int r11 = r11 + 1
            goto L_0x0f10
        L_0x0f18:
            if (r80 == 0) goto L_0x0f23
            r11 = 0
        L_0x0f1b:
            r2 = 5
            if (r11 > r2) goto L_0x0f23
            r80[r11] = r38
            int r11 = r11 + 1
            goto L_0x0f1b
        L_0x0f23:
            if (r82 == 0) goto L_0x0f2e
            r11 = 0
        L_0x0f26:
            r2 = 5
            if (r11 > r2) goto L_0x0f2e
            r82[r11] = r38
            int r11 = r11 + 1
            goto L_0x0f26
        L_0x0f2e:
            if (r81 == 0) goto L_0x0f39
            r11 = 0
        L_0x0f31:
            r1 = 5
            if (r11 > r1) goto L_0x0f39
            r81[r11] = r38
            int r11 = r11 + 1
            goto L_0x0f31
        L_0x0f39:
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_nod_aps(double, int, int, int, double[], double[], double[], double[], java.lang.StringBuffer):int");
    }

    /* access modifiers changed from: package-private */
    public int swe_nod_aps_ut(double d, int i, int i2, int i3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, StringBuffer stringBuffer) {
        return swe_nod_aps(d + SweDate.getDeltaT(d), i, i2, i3, dArr, dArr2, dArr3, dArr4, stringBuffer);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0178 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int swe_gauquelin_sector(double r26, int r28, java.lang.StringBuffer r29, int r30, int r31, double[] r32, double r33, double r35, swisseph.DblObj r37, java.lang.StringBuffer r38) {
        /*
            r25 = this;
            r14 = r25
            r7 = r30
            r8 = r31
            r15 = r37
            r13 = r38
            swisseph.DblObj r12 = new swisseph.DblObj
            r12.<init>()
            r0 = 3
            double[] r10 = new double[r0]
            r1 = 6
            double[] r9 = new double[r1]
            r11 = 2
            double[] r5 = new double[r11]
            r16 = r7 & 7
            r4 = 1
            if (r29 == 0) goto L_0x0028
            int r1 = r29.length()
            if (r1 <= 0) goto L_0x0028
            r17 = 1
            goto L_0x002a
        L_0x0028:
            r17 = 0
        L_0x002a:
            if (r8 < 0) goto L_0x0259
            r1 = 5
            if (r8 <= r1) goto L_0x0036
            r7 = r13
            r11 = r14
            r0 = 0
            goto L_0x025c
        L_0x0036:
            r1 = 144340(0x233d4, float:2.02263E-40)
            r2 = r28
            if (r2 != r1) goto L_0x0040
            r1 = 9
            goto L_0x0041
        L_0x0040:
            r1 = r2
        L_0x0041:
            r6 = 0
            if (r8 == 0) goto L_0x01ba
            if (r8 != r4) goto L_0x004d
            r12 = r1
            r10 = r6
            r7 = r13
            r6 = 1
            goto L_0x01be
        L_0x004d:
            if (r8 == r11) goto L_0x0055
            r2 = 4
            if (r8 != r2) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r2 = 0
            goto L_0x0057
        L_0x0055:
            r2 = 512(0x200, float:7.175E-43)
        L_0x0057:
            if (r8 == r11) goto L_0x005f
            if (r8 != r0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            r17 = r2
            goto L_0x0063
        L_0x005f:
            r2 = r2 | 256(0x100, float:3.59E-43)
            r17 = r2
        L_0x0063:
            r8 = 0
            r3 = r10[r8]
            r12.val = r3
            r18 = r17 | 1
            r0 = r25
            r9 = r1
            r1 = r26
            r5 = -1
            r3 = r9
            r14 = 1
            r4 = r29
            r14 = -1
            r5 = r16
            r6 = r18
            r7 = r32
            r28 = r9
            r14 = 0
            r8 = r33
            r21 = r10
            r22 = 2
            r10 = r35
            r30 = r12
            r13 = r38
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r13 = r30
            double r1 = r13.val
            r21[r14] = r1
            r1 = -1
            if (r0 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r12 = -2
            if (r0 != r12) goto L_0x009d
            r10 = 0
            goto L_0x009e
        L_0x009d:
            r10 = 1
        L_0x009e:
            r0 = 1
            r1 = r21[r0]
            r13.val = r1
            r17 = r17 | 2
            r0 = r25
            r1 = r26
            r3 = r28
            r4 = r29
            r5 = r16
            r6 = r17
            r7 = r32
            r8 = r33
            r23 = r10
            r10 = r35
            r14 = -2
            r12 = r13
            r14 = r13
            r13 = r38
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            double r1 = r14.val
            r3 = 1
            r21[r3] = r1
            r1 = -1
            if (r0 != r1) goto L_0x00cb
            return r1
        L_0x00cb:
            r1 = -2
            if (r0 != r1) goto L_0x00d0
            r13 = 0
            goto L_0x00d1
        L_0x00d0:
            r13 = 1
        L_0x00d1:
            r0 = 0
            r1 = r21[r0]
            r0 = 1
            r3 = r21[r0]
            r5 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0126
            r12 = r23
            if (r12 != r0) goto L_0x0123
            double r1 = r26 - r5
            if (r13 == 0) goto L_0x00ec
            r1 = r21[r0]
            double r1 = r1 - r5
        L_0x00ec:
            r3 = r21[r0]
            r14.val = r3
            r0 = r25
            r3 = r28
            r4 = r29
            r5 = r16
            r6 = r17
            r7 = r32
            r8 = r33
            r10 = r35
            r17 = r12
            r12 = r14
            r13 = r38
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            double r1 = r14.val
            r3 = 1
            r21[r3] = r1
            r1 = -1
            if (r0 != r1) goto L_0x0113
            return r1
        L_0x0113:
            r1 = -2
            if (r0 != r1) goto L_0x011d
            r6 = r17
            r0 = 0
            r16 = 0
            goto L_0x0176
        L_0x011d:
            r6 = r17
            r0 = 0
            r16 = 1
            goto L_0x0176
        L_0x0123:
            r17 = r12
            goto L_0x0128
        L_0x0126:
            r17 = r23
        L_0x0128:
            r0 = 0
            r1 = r21[r0]
            r0 = 1
            r3 = r21[r0]
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x0171
            if (r13 != r0) goto L_0x0171
            double r0 = r26 - r5
            if (r17 == 0) goto L_0x013e
            r2 = 0
            r0 = r21[r2]
            double r0 = r0 - r5
            goto L_0x013f
        L_0x013e:
            r2 = 0
        L_0x013f:
            r3 = r0
            r0 = r21[r2]
            r14.val = r0
            r0 = r25
            r1 = r3
            r3 = r28
            r4 = r29
            r5 = r16
            r6 = r18
            r7 = r32
            r8 = r33
            r10 = r35
            r12 = r14
            r16 = r13
            r13 = r38
            int r0 = r0.swe_rise_trans(r1, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            double r1 = r14.val
            r3 = 0
            r21[r3] = r1
            r1 = -1
            if (r0 != r1) goto L_0x0168
            return r1
        L_0x0168:
            r1 = -2
            if (r0 != r1) goto L_0x016e
            r0 = 1
            r6 = 0
            goto L_0x0176
        L_0x016e:
            r0 = 1
            r6 = 1
            goto L_0x0176
        L_0x0171:
            r16 = r13
            r6 = r17
            r0 = 0
        L_0x0176:
            if (r6 == 0) goto L_0x01a6
            if (r16 == 0) goto L_0x01a6
            r1 = 4625759767262920704(0x4032000000000000, double:18.0)
            if (r0 == 0) goto L_0x0192
            r0 = 0
            r3 = r21[r0]
            double r3 = r26 - r3
            r6 = 1
            r5 = r21[r6]
            r7 = r21[r0]
            double r5 = r5 - r7
            double r3 = r3 / r5
            double r3 = r3 * r1
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r1
            r15.val = r3
            goto L_0x01a5
        L_0x0192:
            r0 = 0
            r6 = 1
            r3 = r21[r6]
            double r3 = r26 - r3
            r7 = r21[r0]
            r5 = r21[r6]
            double r7 = r7 - r5
            double r3 = r3 / r7
            double r3 = r3 * r1
            r1 = 4626041242239631360(0x4033000000000000, double:19.0)
            double r3 = r3 + r1
            r15.val = r3
        L_0x01a5:
            return r0
        L_0x01a6:
            r10 = 0
            r15.val = r10
            r7 = r38
            if (r7 == 0) goto L_0x01b8
            java.lang.String r0 = "rise or set not found for planet "
            r7.append(r0)
            r12 = r28
            r7.append(r12)
        L_0x01b8:
            r0 = -1
            return r0
        L_0x01ba:
            r12 = r1
            r10 = r6
            r7 = r13
            r6 = 1
        L_0x01be:
            double r0 = swisseph.SweDate.getDeltaT(r26)
            double r13 = r26 + r0
            r3 = 1
            r6 = r25
            swisseph.SwissLib r0 = r6.sl
            r4 = r30
            double r0 = r0.swi_epsiln(r13, r4)
            r18 = 4633260481411531253(0x404ca5dc1a63c1f5, double:57.2957795130823)
            double r20 = r0 * r18
            swisseph.SwissLib r0 = r6.sl
            r0.swi_nutation(r13, r4, r5)
            r16 = 0
            r0 = r5[r16]
            double r0 = r0 * r18
            r5[r16] = r0
            r0 = r5[r3]
            double r0 = r0 * r18
            r5[r3] = r0
            swisseph.SwissLib r1 = r6.sl
            r18 = r5[r3]
            double r18 = r20 + r18
            r22 = r5[r16]
            r0 = r1
            r10 = r1
            r1 = r26
            r11 = 1
            r3 = r18
            r18 = r5
            r11 = r6
            r5 = r22
            double r0 = r0.swe_sidtime0(r1, r3, r5)
            r2 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r0 = r0 * r2
            r2 = r32[r16]
            double r0 = r0 + r2
            double r23 = r10.swe_degnorm(r0)
            if (r17 == 0) goto L_0x0220
            swisseph.SwissEph r0 = r11.sw
            r1 = r29
            r2 = r13
            r4 = r30
            r5 = r9
            r6 = r38
            int r0 = r0.swe_fixstar(r1, r2, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x0231
            return r1
        L_0x0220:
            swisseph.SwissEph r0 = r11.sw
            r1 = r13
            r3 = r12
            r4 = r30
            r5 = r9
            r6 = r38
            int r0 = r0.swe_calc(r1, r3, r4, r5, r6)
            r1 = -1
            if (r0 != r1) goto L_0x0231
            return r1
        L_0x0231:
            r0 = 1
            if (r8 != r0) goto L_0x0238
            r1 = 0
            r9[r0] = r1
        L_0x0238:
            swisseph.SwissEph r1 = r11.sw
            r2 = r32[r0]
            r4 = r18[r0]
            double r4 = r20 + r4
            r0 = 71
            r6 = 0
            r26 = r1
            r27 = r23
            r29 = r2
            r31 = r4
            r33 = r0
            r34 = r9
            r35 = r6
            double r0 = r26.swe_house_pos(r27, r29, r31, r33, r34, r35)
            r15.val = r0
            r0 = 0
            return r0
        L_0x0259:
            r7 = r13
            r11 = r14
            r0 = 0
        L_0x025c:
            if (r7 == 0) goto L_0x0261
            r7.setLength(r0)
        L_0x0261:
            java.lang.String r0 = "invalid method: "
            r7.append(r0)
            r7.append(r8)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.Swecl.swe_gauquelin_sector(double, int, java.lang.StringBuffer, int, int, double[], double, double, swisseph.DblObj, java.lang.StringBuffer):int");
    }
}
