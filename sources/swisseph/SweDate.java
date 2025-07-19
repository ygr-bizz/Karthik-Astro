package swisseph;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SweDate implements Serializable {
    private static final boolean ESPENAK_MEEUS_2006 = true;
    public static final int FRIDAY = 5;
    private static final double J1972 = 2441317.5d;
    public static final double JD0 = 2440587.5d;
    private static final int LTERM_EQUATION_COEFF = 32;
    private static final int LTERM_EQUATION_YSTART = 1820;
    public static final int MONDAY = 1;
    private static final int NLEAP_INIT = 10;
    private static final int NLEAP_SECONDS = 24;
    private static final int NLEAP_SECONDS_SPACE = 100;
    public static final int SATURDAY = 6;
    public static final boolean SE_GREG_CAL = true;
    public static final boolean SE_JUL_CAL = false;
    public static final boolean SE_KEEP_DATE = true;
    public static final boolean SE_KEEP_JD = false;
    public static final double SE_TIDAL_26 = -26.0d;
    public static final double SE_TIDAL_DE200 = -23.8946d;
    public static final double SE_TIDAL_DE403 = -25.58d;
    public static final double SE_TIDAL_DE404 = -25.58d;
    public static final double SE_TIDAL_DE405 = -25.826d;
    public static final double SE_TIDAL_DE406 = -25.826d;
    public static final double SE_TIDAL_DE421 = -25.85d;
    public static final double SE_TIDAL_DE430 = -25.82d;
    public static final double SE_TIDAL_DE431 = -25.82d;
    public static final double SE_TIDAL_DEFAULT = -25.82d;
    public static final int SUNDAY = 0;
    private static final int TAB2_END = 1600;
    private static final int TAB2_SIZ = 27;
    private static final int TAB2_START = -1000;
    private static final int TAB2_STEP = 100;
    private static final int TABEND = 2019;
    private static final int TABSIZ = 400;
    private static final int TABSIZ_SPACE = 500;
    private static final int TABSTART = 1620;
    public static final int THURSDAY = 4;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    private static double[] dt;
    private static short[] dt2 = {25400, 23700, 22000, 21000, 19040, 17190, 15530, 14080, 12790, 11640, 10580, 9600, 8640, 7680, 6700, 5710, 4740, 3810, 2960, 2200, 1570, 1090, 740, 490, 320, 200, 120};
    private static boolean init_dt_done = false;
    private static final int[] leap_seconds = {19720630, 19721231, 19731231, 19741231, 19751231, 19761231, 19771231, 19781231, 19791231, 19810630, 19820630, 19830630, 19850630, 19871231, 19891231, 19901231, 19920630, 19930630, 19940630, 19951231, 19970630, 19981231, 20051231, 20081231, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static SwissEph sw = new SwissEph();
    private static double tid_acc = -25.82d;
    private boolean calType;
    private int day;
    private double deltaT;
    private boolean deltatIsValid = false;
    private double hour;
    private boolean init_leapseconds_done = false;
    private double jd;
    private double jdCO = 2299160.5d;
    private int month;
    private int year;

    static {
        double[] dArr = new double[TABSIZ_SPACE];
        // fill-array-data instruction
        dArr[0] = 4638426141214900224;
        dArr[1] = 4638074297494011904;
        dArr[2] = 4637792822517301248;
        dArr[3] = 4637440978796412928;
        dArr[4] = 4637159503819702272;
        dArr[5] = 4636878028842991616;
        dArr[6] = 4636596553866280960;
        dArr[7] = 4636385447633747968;
        dArr[8] = 4636103972657037312;
        dArr[9] = 4635892866424504320;
        dArr[10] = 4635681760191971328;
        dArr[11] = 4635470653959438336;
        dArr[12] = 4635259547726905344;
        dArr[13] = 4635118810238550016;
        dArr[14] = 4634907704006017024;
        dArr[15] = 4634766966517661696;
        dArr[16] = 4634626229029306368;
        dArr[17] = 4634415122796773376;
        dArr[18] = 4634274385308418048;
        dArr[19] = 4634063279075885056;
        dArr[20] = 4633922541587529728;
        dArr[21] = 4633641066610819072;
        dArr[22] = 4633359591634108416;
        dArr[23] = 4633218854145753088;
        dArr[24] = 4632937379169042432;
        dArr[25] = 4632796641680687104;
        dArr[26] = 4632655904192331776;
        dArr[27] = 4632374429215621120;
        dArr[28] = 4632233691727265792;
        dArr[29] = 4632092954238910464;
        dArr[30] = 4631952216750555136;
        dArr[31] = 4631811479262199808;
        dArr[32] = 4631670741773844480;
        dArr[33] = 4631530004285489152;
        dArr[34] = 4631389266797133824;
        dArr[35] = 4631248529308778496;
        dArr[36] = 4631107791820423168;
        dArr[37] = 4630967054332067840;
        dArr[38] = 4630826316843712512;
        dArr[39] = 4630544841867001856;
        dArr[40] = 4630404104378646528;
        dArr[41] = 4630263366890291200;
        dArr[42] = 4630122629401935872;
        dArr[43] = 4629981891913580544;
        dArr[44] = 4629841154425225216;
        dArr[45] = 4629700416936869888;
        dArr[46] = 4629418941960159232;
        dArr[47] = 4629137466983448576;
        dArr[48] = 4628574517030027264;
        dArr[49] = 4628293042053316608;
        dArr[50] = 4628011567076605952;
        dArr[51] = 4627730092099895296;
        dArr[52] = 4627448617123184640;
        dArr[53] = 4627167142146473984;
        dArr[54] = 4626885667169763328;
        dArr[55] = 4626604192193052672;
        dArr[56] = 4626322717216342016;
        dArr[57] = 4626041242239631360;
        dArr[58] = 4625759767262920704;
        dArr[59] = 4625478292286210048;
        dArr[60] = 4625196817309499392;
        dArr[61] = 4624633867356078080;
        dArr[62] = 4624070917402656768;
        dArr[63] = 4624070917402656768;
        dArr[64] = 4623507967449235456;
        dArr[65] = 4622945017495814144;
        dArr[66] = 4622945017495814144;
        dArr[67] = 4622382067542392832;
        dArr[68] = 4622382067542392832;
        dArr[69] = 4621819117588971520;
        dArr[70] = 4621819117588971520;
        dArr[71] = 4621819117588971520;
        dArr[72] = 4621256167635550208;
        dArr[73] = 4621256167635550208;
        dArr[74] = 4621256167635550208;
        dArr[75] = 4621256167635550208;
        dArr[76] = 4621256167635550208;
        dArr[77] = 4621256167635550208;
        dArr[78] = 4621256167635550208;
        dArr[79] = 4621256167635550208;
        dArr[80] = 4621256167635550208;
        dArr[81] = 4621256167635550208;
        dArr[82] = 4621256167635550208;
        dArr[83] = 4621256167635550208;
        dArr[84] = 4621256167635550208;
        dArr[85] = 4621256167635550208;
        dArr[86] = 4621256167635550208;
        dArr[87] = 4621256167635550208;
        dArr[88] = 4621819117588971520;
        dArr[89] = 4621819117588971520;
        dArr[90] = 4621819117588971520;
        dArr[91] = 4621819117588971520;
        dArr[92] = 4621819117588971520;
        dArr[93] = 4621819117588971520;
        dArr[94] = 4621819117588971520;
        dArr[95] = 4621819117588971520;
        dArr[96] = 4621819117588971520;
        dArr[97] = 4622382067542392832;
        dArr[98] = 4622382067542392832;
        dArr[99] = 4622382067542392832;
        dArr[100] = 4622382067542392832;
        dArr[101] = 4622382067542392832;
        dArr[102] = 4622382067542392832;
        dArr[103] = 4622382067542392832;
        dArr[104] = 4622382067542392832;
        dArr[105] = 4622382067542392832;
        dArr[106] = 4622382067542392832;
        dArr[107] = 4622382067542392832;
        dArr[108] = 4622382067542392832;
        dArr[109] = 4622382067542392832;
        dArr[110] = 4622382067542392832;
        dArr[111] = 4622382067542392832;
        dArr[112] = 4622382067542392832;
        dArr[113] = 4622382067542392832;
        dArr[114] = 4622945017495814144;
        dArr[115] = 4622945017495814144;
        dArr[116] = 4622945017495814144;
        dArr[117] = 4622945017495814144;
        dArr[118] = 4622945017495814144;
        dArr[119] = 4622945017495814144;
        dArr[120] = 4622945017495814144;
        dArr[121] = 4622945017495814144;
        dArr[122] = 4622945017495814144;
        dArr[123] = 4622945017495814144;
        dArr[124] = 4623507967449235456;
        dArr[125] = 4623507967449235456;
        dArr[126] = 4623507967449235456;
        dArr[127] = 4623507967449235456;
        dArr[128] = 4623507967449235456;
        dArr[129] = 4623507967449235456;
        dArr[130] = 4623507967449235456;
        dArr[131] = 4624070917402656768;
        dArr[132] = 4624070917402656768;
        dArr[133] = 4624070917402656768;
        dArr[134] = 4624070917402656768;
        dArr[135] = 4624070917402656768;
        dArr[136] = 4624070917402656768;
        dArr[137] = 4624070917402656768;
        dArr[138] = 4624633867356078080;
        dArr[139] = 4624633867356078080;
        dArr[140] = 4624633867356078080;
        dArr[141] = 4624633867356078080;
        dArr[142] = 4624633867356078080;
        dArr[143] = 4624633867356078080;
        dArr[144] = 4624633867356078080;
        dArr[145] = 4625196817309499392;
        dArr[146] = 4625196817309499392;
        dArr[147] = 4625196817309499392;
        dArr[148] = 4625196817309499392;
        dArr[149] = 4625196817309499392;
        dArr[150] = 4625196817309499392;
        dArr[151] = 4625196817309499392;
        dArr[152] = 4625196817309499392;
        dArr[153] = 4625196817309499392;
        dArr[154] = 4625196817309499392;
        dArr[155] = 4625478292286210048;
        dArr[156] = 4625478292286210048;
        dArr[157] = 4625478292286210048;
        dArr[158] = 4625478292286210048;
        dArr[159] = 4625478292286210048;
        dArr[160] = 4625478292286210048;
        dArr[161] = 4625478292286210048;
        dArr[162] = 4625478292286210048;
        dArr[163] = 4625478292286210048;
        dArr[164] = 4625478292286210048;
        dArr[165] = 4625478292286210048;
        dArr[166] = 4625478292286210048;
        dArr[167] = 4625478292286210048;
        dArr[168] = 4625478292286210048;
        dArr[169] = 4625478292286210048;
        dArr[170] = 4625478292286210048;
        dArr[171] = 4625478292286210048;
        dArr[172] = 4625196817309499392;
        dArr[173] = 4625196817309499392;
        dArr[174] = 4625196817309499392;
        dArr[175] = 4625196817309499392;
        dArr[176] = 4624633867356078080;
        dArr[177] = 4624633867356078080;
        dArr[178] = 4624070917402656768;
        dArr[179] = 4624070917402656768;
        dArr[180] = 4623902032416630374;
        dArr[181] = 4623733147430603981;
        dArr[182] = 4623564262444577587;
        dArr[183] = 4623451672453893325;
        dArr[184] = 4623339082463209062;
        dArr[185] = 4623282787467866931;
        dArr[186] = 4623226492472524800;
        dArr[187] = 4623226492472524800;
        dArr[188] = 4623226492472524800;
        dArr[189] = 4623226492472524800;
        dArr[190] = 4623226492472524800;
        dArr[191] = 4623226492472524800;
        dArr[192] = 4623226492472524800;
        dArr[193] = 4623226492472524800;
        dArr[194] = 4623226492472524800;
        dArr[195] = 4623226492472524800;
        dArr[196] = 4623226492472524800;
        dArr[197] = 4623170197477182669;
        dArr[198] = 4623113902481840538;
        dArr[199] = 4623057607486498406;
        dArr[200] = 4622945017495814144;
        dArr[201] = 4622776132509787750;
        dArr[202] = 4622607247523761357;
        dArr[203] = 4622438362537734963;
        dArr[204] = 4622156887561024307;
        dArr[205] = 4621931707579655782;
        dArr[206] = 4621593937607602995;
        dArr[207] = 4621312462630892339;
        dArr[208] = 4621030987654181683;
        dArr[209] = 4620693217682128896;
        dArr[210] = 4620130267728707584;
        dArr[211] = 4619567317775286272;
        dArr[212] = 4619116957812549222;
        dArr[213] = 4618779187840496435;
        dArr[214] = 4618441417868443648;
        dArr[215] = 4618216237887075123;
        dArr[216] = 4618103647896390861;
        dArr[217] = 4617991057905706598;
        dArr[218] = 4617991057905706598;
        dArr[219] = 4617991057905706598;
        dArr[220] = 4618103647896390861;
        dArr[221] = 4618216237887075123;
        dArr[222] = 4618328827877759386;
        dArr[223] = 4618554007859127910;
        dArr[224] = 4618666597849812173;
        dArr[225] = 4618779187840496435;
        dArr[226] = 4619004367821864960;
        dArr[227] = 4619116957812549222;
        dArr[228] = 4619342137793917747;
        dArr[229] = 4619454727784602010;
        dArr[230] = 4619679907765970534;
        dArr[231] = 4619792497756654797;
        dArr[232] = 4619905087747339059;
        dArr[233] = 4620017677738023322;
        dArr[234] = 4620130267728707584;
        dArr[235] = 4620242857719391846;
        dArr[236] = 4620355447710076109;
        dArr[237] = 4620355447710076109;
        dArr[238] = 4620468037700760371;
        dArr[239] = 4620468037700760371;
        dArr[240] = 4620558109693307781;
        dArr[241] = 4620490555698897224;
        dArr[242] = 4620175303724981289;
        dArr[243] = 4619533540778080993;
        dArr[244] = 4618891777831180698;
        dArr[245] = 4618463935866580500;
        dArr[246] = 4617777136923406500;
        dArr[247] = 4616302208045442662;
        dArr[248] = 4613757674255978332;
        dArr[249] = 4610875370494461215;
        dArr[250] = 4609929614572713411;
        dArr[251] = 4591870180066957722;
        dArr[252] = -4616099546062210990;
        dArr[253] = -4614928610159094661;
        dArr[254] = -4610132276555945083;
        dArr[255] = -4608893786658418196;
        dArr[256] = -4607993066732944097;
        dArr[257] = -4606574432850322391;
        dArr[258] = -4606383029866159145;
        dArr[259] = -4605932669903422095;
        dArr[260] = -4605606158930437734;
        dArr[261] = -4605583640932300882;
        dArr[262] = -4605831338911806259;
        dArr[263] = -4605538604936027177;
        dArr[264] = -4605538604936027177;
        dArr[265] = -4605167057966769111;
        dArr[266] = -4605347201951863931;
        dArr[267] = -4605335942952795505;
        dArr[268] = -4605155798967700685;
        dArr[269] = -4605313424954658652;
        dArr[270] = -4605076985974221701;
        dArr[271] = -4604919359987263734;
        dArr[272] = -4604716698004032061;
        dArr[273] = -4604210043045952881;
        dArr[274] = -4604435223027321405;
        dArr[275] = -4604401446030116127;
        dArr[276] = -4604829287994716324;
        dArr[277] = -4605200834963974390;
        dArr[278] = -4606439324861501276;
        dArr[279] = -4607767886751575572;
        dArr[280] = -4610064722561534525;
        dArr[281] = -4613757674255978332;
        dArr[282] = -4641950207923317637;
        dArr[283] = 4608263282710586327;
        dArr[284] = 4613127170308146463;
        dArr[285] = 4615874366080842465;
        dArr[286] = 4617732100927132795;
        dArr[287] = 4618599043855401615;
        dArr[288] = 4620411742705418240;
        dArr[289] = 4621329351129494979;
        dArr[290] = 4622078074567545324;
        dArr[291] = 4622680431017706127;
        dArr[292] = 4623710629432467128;
        dArr[293] = 4624436834872380621;
        dArr[294] = 4625199632059266499;
        dArr[295] = 4625534587281552179;
        dArr[296] = 4625827321257331261;
        dArr[297] = 4626058130738233999;
        dArr[298] = 4626393085960519680;
        dArr[299] = 4626590118444217139;
        dArr[300] = 4626649228189326377;
        dArr[301] = 4626956035913940992;
        dArr[302] = 4627001071910214697;
        dArr[303] = 4627175586395775304;
        dArr[304] = 4627305064885062205;
        dArr[305] = 4627341656632034591;
        dArr[306] = 4627409210626445148;
        dArr[307] = 4627586539861772861;
        dArr[308] = 4627544318615266263;
        dArr[309] = 4627471135121321492;
        dArr[310] = 4627454246622718853;
        dArr[311] = 4627448617123184640;
        dArr[312] = 4627412025376212255;
        dArr[313] = 4627434543374349107;
        dArr[314] = 4627409210626445148;
        dArr[315] = 4627428913874814894;
        dArr[316] = 4627372618879472763;
        dArr[317] = 4627426099125047788;
        dArr[318] = 4627437358124116214;
        dArr[319] = 4627454246622718853;
        dArr[320] = 4627541503865499156;
        dArr[321] = 4627682241353854484;
        dArr[322] = 4627814534592908493;
        dArr[323] = 4627927124583592755;
        dArr[324] = 4628079121071016509;
        dArr[325] = 4628228302808673157;
        dArr[326] = 4628371855046795592;
        dArr[327] = 4628512592535150920;
        dArr[328] = 4628644885774204928;
        dArr[329] = 4628774364263491830;
        dArr[330] = 4628898213253244518;
        dArr[331] = 4629016432743462994;
        dArr[332] = 4629129022734147256;
        dArr[333] = 4629238797975064412;
        dArr[334] = 4629340128966680248;
        dArr[335] = 4629438645208528978;
        dArr[336] = 4629517458202007962;
        dArr[337] = 4629610344944322478;
        dArr[338] = 4629725749684773847;
        dArr[339] = 4629796118428951511;
        dArr[340] = 4629862265048478515;
        dArr[341] = 4629924189543354860;
        dArr[342] = 4629981891913580544;
        dArr[343] = 4630048038533107548;
        dArr[344] = 4630126851526586532;
        dArr[345] = 4630225367768435261;
        dArr[346] = 4630339365134003077;
        dArr[347] = 4630464621498639319;
        dArr[348] = 4630585655738624901;
        dArr[349] = 4630713726853028250;
        dArr[350] = 4630851649591616471;
        dArr[351] = 4630990979705088246;
        dArr[352] = 4631140161442744893;
        dArr[353] = 4631300602179469967;
        dArr[354] = 4631458228166427935;
        dArr[355] = 4631597558279899709;
        dArr[356] = 4631735481018487931;
        dArr[357] = 4631884662756144579;
        dArr[358] = 4632026807619383460;
        dArr[359] = 4632175989357040108;
        dArr[360] = 4632309689970977669;
        dArr[361] = 4632427909461196145;
        dArr[362] = 4632539092076996854;
        dArr[363] = 4632650274692797563;
        dArr[364] = 4632767086808132485;
        dArr[365] = 4632844492426727916;
        dArr[366] = 4632919083295556239;
        dArr[367] = 4632982415165316137;
        dArr[368] = 4633052783909493801;
        dArr[369] = 4633120337903904358;
        dArr[370] = 4633199150897383342;
        dArr[371] = 4633299074514115625;
        dArr[372] = 4633403220255498568;
        dArr[373] = 4633517217621066383;
        dArr[374] = 4633638251861051965;
        dArr[375] = 4633750841851736228;
        dArr[376] = 4633870468716838257;
        dArr[377] = 4633964762834036326;
        dArr[378] = 4634059056951234396;
        dArr[379] = 4634129425695412060;
        dArr[380] = 4634180091191219978;
        dArr[381] = 4634210349751216374;
        dArr[382] = 4634225127187493683;
        dArr[383] = 4634237089874003886;
        dArr[384] = 4634244126748421652;
        dArr[385] = 4634252570997722972;
        dArr[386] = 4634263829996791398;
        dArr[387] = 4634284940620044698;
        dArr[388] = 4634306754930739773;
        dArr[389] = 4634329272928876626;
        dArr[390] = 4634349679864688148;
        dArr[391] = 4634367272050732564;
        dArr[392] = 4634386975299102310;
        dArr[393] = 4634408578503564853;
        dArr[394] = 4634433911251468812;
        dArr[395] = 4634478454666533274;
        dArr[396] = 4634513639038622106;
        dArr[397] = 4634555860285128704;
        dArr[398] = 4634591044657217536;
        dArr[399] = 4634626229029306368;
        dArr[400] = 0;
        dArr[401] = 0;
        dArr[402] = 0;
        dArr[403] = 0;
        dArr[404] = 0;
        dArr[405] = 0;
        dArr[406] = 0;
        dArr[407] = 0;
        dArr[408] = 0;
        dArr[409] = 0;
        dArr[410] = 0;
        dArr[411] = 0;
        dArr[412] = 0;
        dArr[413] = 0;
        dArr[414] = 0;
        dArr[415] = 0;
        dArr[416] = 0;
        dArr[417] = 0;
        dArr[418] = 0;
        dArr[419] = 0;
        dArr[420] = 0;
        dArr[421] = 0;
        dArr[422] = 0;
        dArr[423] = 0;
        dArr[424] = 0;
        dArr[425] = 0;
        dArr[426] = 0;
        dArr[427] = 0;
        dArr[428] = 0;
        dArr[429] = 0;
        dArr[430] = 0;
        dArr[431] = 0;
        dArr[432] = 0;
        dArr[433] = 0;
        dArr[434] = 0;
        dArr[435] = 0;
        dArr[436] = 0;
        dArr[437] = 0;
        dArr[438] = 0;
        dArr[439] = 0;
        dArr[440] = 0;
        dArr[441] = 0;
        dArr[442] = 0;
        dArr[443] = 0;
        dArr[444] = 0;
        dArr[445] = 0;
        dArr[446] = 0;
        dArr[447] = 0;
        dArr[448] = 0;
        dArr[449] = 0;
        dArr[450] = 0;
        dArr[451] = 0;
        dArr[452] = 0;
        dArr[453] = 0;
        dArr[454] = 0;
        dArr[455] = 0;
        dArr[456] = 0;
        dArr[457] = 0;
        dArr[458] = 0;
        dArr[459] = 0;
        dArr[460] = 0;
        dArr[461] = 0;
        dArr[462] = 0;
        dArr[463] = 0;
        dArr[464] = 0;
        dArr[465] = 0;
        dArr[466] = 0;
        dArr[467] = 0;
        dArr[468] = 0;
        dArr[469] = 0;
        dArr[470] = 0;
        dArr[471] = 0;
        dArr[472] = 0;
        dArr[473] = 0;
        dArr[474] = 0;
        dArr[475] = 0;
        dArr[476] = 0;
        dArr[477] = 0;
        dArr[478] = 0;
        dArr[479] = 0;
        dArr[480] = 0;
        dArr[481] = 0;
        dArr[482] = 0;
        dArr[483] = 0;
        dArr[484] = 0;
        dArr[485] = 0;
        dArr[486] = 0;
        dArr[487] = 0;
        dArr[488] = 0;
        dArr[489] = 0;
        dArr[490] = 0;
        dArr[491] = 0;
        dArr[492] = 0;
        dArr[493] = 0;
        dArr[494] = 0;
        dArr[495] = 0;
        dArr[496] = 0;
        dArr[497] = 0;
        dArr[498] = 0;
        dArr[499] = 0;
        dt = dArr;
    }

    public SweDate() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        setFields(instance.get(1), instance.get(2) + 1, instance.get(5), (((double) instance.get(14)) / 3600000.0d) + ((double) instance.get(11)) + (((double) instance.get(12)) / 60.0d) + (((double) instance.get(13)) / 3600.0d), true);
    }

    public SweDate(double d) {
        boolean z = false;
        initDateFromJD(d, 2299160.5d <= d ? true : z);
    }

    public SweDate(double d, boolean z) {
        initDateFromJD(d, z);
    }

    public SweDate(int i, int i2, int i3, double d) {
        setFields(i, i2, i3, d);
    }

    public SweDate(int i, int i2, int i3, double d, boolean z) {
        setFields(i, i2, i3, d, z);
    }

    public double getJulDay() {
        return this.jd;
    }

    public static double getJulDay(int i, int i2, int i3, double d) {
        return swe_julday(i, i2, i3, d, true);
    }

    public static double getJulDay(int i, int i2, int i3, double d, boolean z) {
        return swe_julday(i, i2, i3, d, z);
    }

    public int getDayOfWeekNr() {
        return ((int) (this.jd - 5.5d)) % 7;
    }

    public static synchronized int getDayOfWeekNr(double d) {
        int i;
        synchronized (SweDate.class) {
            i = ((int) (d - 5.5d)) % 7;
        }
        return i;
    }

    public static int getDayOfWeekNr(int i, int i2, int i3) {
        return ((int) (swe_julday(i, i2, i3, 0.0d, true) - 5.5d)) % 7;
    }

    public static int getDayOfWeekNr(int i, int i2, int i3, boolean z) {
        return ((int) (swe_julday(i, i2, i3, 0.0d, z) - 5.5d)) % 7;
    }

    public boolean getCalendarType() {
        return this.calType;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public double getHour() {
        return this.hour;
    }

    public double getDeltaT() {
        if (this.deltatIsValid) {
            return this.deltaT;
        }
        double calc_deltaT = calc_deltaT(getJulDay());
        this.deltaT = calc_deltaT;
        this.deltatIsValid = true;
        return calc_deltaT;
    }

    public static double getDeltaT(double d) {
        return calc_deltaT(d, tid_acc);
    }

    public Date getDate(long j) {
        return new Date(((long) ((getJulDay() - 2440587.5d) * 24.0d * 3600.0d * 1000.0d)) + j);
    }

    public static Date getDate(double d) {
        return new Date((long) ((d - 2440587.5d) * 24.0d * 3600.0d * 1000.0d));
    }

    public void setJulDay(double d) {
        this.jd = d;
        this.deltatIsValid = false;
        IDate swe_revjul = swe_revjul(d, this.calType);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
    }

    public void setCalendarType(boolean z, boolean z2) {
        if (this.calType != z) {
            this.calType = z;
            this.deltatIsValid = false;
            if (z2) {
                this.jd = swe_julday(this.year, this.month, this.day, this.hour, z);
                return;
            }
            IDate swe_revjul = swe_revjul(this.jd, z);
            this.year = swe_revjul.year;
            this.month = swe_revjul.month;
            this.day = swe_revjul.day;
            this.hour = swe_revjul.hour;
        }
    }

    public void updateCalendarType() {
        this.calType = this.jdCO <= this.jd;
    }

    public boolean setDate(int i, int i2, int i3, double d) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = d;
        this.deltatIsValid = false;
        this.jd = swe_julday(i, i2, i3, d, this.calType);
        return true;
    }

    public boolean setDate(int i, int i2, int i3, double d, boolean z) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = d;
        this.deltatIsValid = false;
        double swe_julday = swe_julday(i, i2, i3, d, this.calType);
        this.jd = swe_julday;
        if (!z) {
            return true;
        }
        double d2 = (double) i2;
        double d3 = (double) i3;
        IDate swe_revjul = swe_revjul(swe_julday, this.calType);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        double d4 = swe_revjul.hour;
        this.hour = d4;
        if (this.year == i && ((double) this.month) == d2 && ((double) this.day) == d3 && Math.abs(d4 - d) < 1.0E-6d) {
            return true;
        }
        return false;
    }

    public boolean setYear(int i) {
        this.year = i;
        this.deltatIsValid = false;
        this.jd = swe_julday(i, this.month, this.day, this.hour, this.calType);
        return true;
    }

    public boolean setYear(int i, boolean z) {
        this.year = i;
        this.deltatIsValid = false;
        double swe_julday = swe_julday(i, this.month, this.day, this.hour, this.calType);
        this.jd = swe_julday;
        if (!z) {
            return true;
        }
        double d = (double) this.month;
        double d2 = (double) this.day;
        IDate swe_revjul = swe_revjul(swe_julday, this.calType);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
        if (this.year == i && ((double) this.month) == d && ((double) this.day) == d2) {
            return true;
        }
        return false;
    }

    public boolean setMonth(int i) {
        this.month = i;
        this.deltatIsValid = false;
        this.jd = swe_julday(this.year, i, this.day, this.hour, this.calType);
        return true;
    }

    public boolean setMonth(int i, boolean z) {
        this.month = i;
        this.deltatIsValid = false;
        double swe_julday = swe_julday(this.year, i, this.day, this.hour, this.calType);
        this.jd = swe_julday;
        if (!z) {
            return true;
        }
        double d = (double) this.year;
        double d2 = (double) this.day;
        IDate swe_revjul = swe_revjul(swe_julday, this.calType);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
        if (((double) this.year) == d && this.month == i && ((double) this.day) == d2) {
            return true;
        }
        return false;
    }

    public boolean setDay(int i) {
        this.day = i;
        this.deltatIsValid = false;
        this.jd = swe_julday(this.year, this.month, i, this.hour, this.calType);
        return true;
    }

    public boolean setDay(int i, boolean z) {
        this.day = i;
        this.deltatIsValid = false;
        double swe_julday = swe_julday(this.year, this.month, i, this.hour, this.calType);
        this.jd = swe_julday;
        if (!z) {
            return true;
        }
        double d = (double) this.year;
        double d2 = (double) this.month;
        IDate swe_revjul = swe_revjul(swe_julday, this.calType);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
        if (((double) this.year) == d && ((double) this.month) == d2 && this.day == i) {
            return true;
        }
        return false;
    }

    public boolean setHour(double d) {
        this.hour = d;
        this.jd = swe_julday(this.year, this.month, this.day, d, this.calType);
        return true;
    }

    public boolean checkDate() {
        return checkDate(this.year, this.month, this.day, this.hour);
    }

    public boolean checkDate(int i, int i2, int i3) {
        return checkDate(i, i2, i3, 0.0d);
    }

    public boolean checkDate(int i, int i2, int i3, double d) {
        IDate swe_revjul = swe_revjul(swe_julday(i, i2, i3, d, true), true);
        if (swe_revjul.year == i && swe_revjul.month == i2 && swe_revjul.day == i3) {
            return true;
        }
        return false;
    }

    public void makeValidDate() {
        IDate swe_revjul = swe_revjul(swe_julday(this.year, this.month, this.day, this.hour, true), true);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
    }

    public double getGregorianChange() {
        return this.jdCO;
    }

    public void setGregorianChange(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.deltatIsValid = false;
        this.calType = true;
        if (i < i || ((i == i && i2 < i2) || (i == i && i2 == i2 && i3 < i3))) {
            this.calType = false;
        }
        this.jdCO = swe_julday(i, i2, i3, 0.0d, true);
        this.jd = swe_julday(this.year, this.month, this.day, this.hour, this.calType);
    }

    public void setGregorianChange(double d) {
        this.jdCO = d;
        double d2 = this.jd;
        boolean z = d2 >= d;
        this.calType = z;
        IDate swe_revjul = swe_revjul(d2, z);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
    }

    public double getGlobalTidalAcc() {
        return tid_acc;
    }

    public static void setGlobalTidalAcc(double d) {
        double[] dArr = new double[6];
        int i = 404;
        int i2 = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        if (i2 == 0 || d == 2.0d) {
            if (sw.swed.fidat[1].fptr == null) {
                sw.swe_calc(2451545.0d, 1, 131122, dArr, (StringBuffer) null);
            }
            if (sw.swed.fidat[1].fptr != null) {
                i = sw.swed.fidat[1].sweph_denum;
            }
        } else if (d != 4.0d) {
            i = i2 > 0 ? (int) d : 0;
        }
        if (i > 0) {
            if (i == 200) {
                d = -23.8946d;
            } else if (i == 421) {
                d = -25.85d;
            } else if (i == 430) {
                d = -25.82d;
            } else if (i != 431) {
                switch (i) {
                    case 403:
                        d = -25.58d;
                        break;
                    case 404:
                        d = -25.58d;
                        break;
                    case 405:
                        d = -25.826d;
                        break;
                    case 406:
                        d = -25.826d;
                        break;
                    default:
                        d = -25.82d;
                        break;
                }
            } else {
                d = -25.82d;
            }
        }
        tid_acc = d;
    }

    public String toString() {
        String str;
        String str2;
        double hour2 = getHour();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        sb.append(hour2 < 10.0d ? " " : str3);
        int i = (int) hour2;
        sb.append(i);
        sb.append(":");
        String sb2 = sb.toString();
        double d = (hour2 - ((double) i)) * 60.0d;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(d < 10.0d ? "0" : str3);
        int i2 = (int) d;
        sb3.append(i2);
        sb3.append(":");
        String sb4 = sb3.toString();
        double d2 = (d - ((double) i2)) * 60.0d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        if (d2 < 10.0d) {
            str = "0";
        } else {
            str = str3;
        }
        sb5.append(str);
        sb5.append(d2);
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("(YYYY/MM/DD) ");
        sb7.append(getYear());
        sb7.append("/");
        if (getMonth() < 10) {
            str2 = "0";
        } else {
            str2 = str3;
        }
        sb7.append(str2);
        sb7.append(getMonth());
        sb7.append("/");
        if (getDay() < 10) {
            str3 = "0";
        }
        sb7.append(str3);
        sb7.append(getDay());
        sb7.append(", ");
        sb7.append(sb6);
        sb7.append("h ");
        sb7.append(getCalendarType() ? "(greg)" : "(jul)");
        sb7.append("\n");
        sb7.append("Jul. Day: ");
        sb7.append(getJulDay());
        sb7.append("; ");
        sb7.append("DeltaT: ");
        sb7.append(getDeltaT());
        return sb7.toString();
    }

    private static synchronized double swe_julday(int i, int i2, int i3, double d, boolean z) {
        double floor;
        synchronized (SweDate.class) {
            double d2 = (double) i;
            if (i2 < 3) {
                d2 -= 1.0d;
            }
            double d3 = 4712.0d + d2;
            double d4 = ((double) i2) + 1.0d;
            if (d4 < 4.0d) {
                d4 += 12.0d;
            }
            floor = (((SMath.floor(d3 * 365.25d) + SMath.floor((d4 * 30.6d) + 1.0E-6d)) + ((double) i3)) + (d / 24.0d)) - 63.5d;
            if (z) {
                double floor2 = SMath.floor(SMath.abs(d2) / 100.0d) - SMath.floor(SMath.abs(d2) / 400.0d);
                int i4 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
                if (i4 < 0) {
                    floor2 = -floor2;
                }
                floor = (floor - floor2) + 2.0d;
                if (i4 < 0) {
                    double d5 = d2 / 100.0d;
                    if (d5 == SMath.floor(d5)) {
                        double d6 = d2 / 400.0d;
                        if (d6 != SMath.floor(d6)) {
                            floor -= 1.0d;
                        }
                    }
                }
            }
        }
        return floor;
    }

    private synchronized IDate swe_revjul(double d, boolean z) {
        IDate iDate;
        iDate = new IDate();
        double d2 = d + 32082.5d;
        if (z) {
            double floor = ((SMath.floor(d2 / 36525.0d) + d2) - SMath.floor(d2 / 146100.0d)) - 38.0d;
            if (d >= 1830691.5d) {
                floor += 1.0d;
            }
            d2 = ((d2 + SMath.floor(floor / 36525.0d)) - SMath.floor(floor / 146100.0d)) - 38.0d;
        }
        double floor2 = SMath.floor(d2 + 123.0d);
        double floor3 = SMath.floor((floor2 - 122.2d) / 365.25d);
        double d3 = 365.25d * floor3;
        double floor4 = SMath.floor((floor2 - SMath.floor(d3)) / 30.6001d);
        iDate.month = (int) (floor4 - 1.0d);
        if (iDate.month > 12) {
            iDate.month -= 12;
        }
        iDate.day = (int) ((floor2 - SMath.floor(d3)) - SMath.floor(30.6001d * floor4));
        iDate.year = (int) ((floor3 + SMath.floor((floor4 - 2.0d) / 12.0d)) - 4800.0d);
        iDate.hour = ((d - SMath.floor(d + 0.5d)) + 0.5d) * 24.0d;
        return iDate;
    }

    private synchronized double calc_deltaT(double d) {
        return calc_deltaT(d, tid_acc);
    }

    private static synchronized double calc_deltaT(double d, double d2) {
        synchronized (SweDate.class) {
            double d3 = d - 2451545.0d;
            double d4 = (d3 / 365.25d) + 2000.0d;
            double d5 = (d3 / 365.2425d) + 2000.0d;
            if (d < 2317746.130902778d) {
                double deltat_espenak_meeus_1620 = deltat_espenak_meeus_1620(d, d2);
                return deltat_espenak_meeus_1620;
            }
            if (d4 < 1620.0d) {
                if (d4 < 1600.0d) {
                    double deltat_stephenson_morrison_1600 = deltat_stephenson_morrison_1600(d, d2);
                    return deltat_stephenson_morrison_1600;
                } else if (d4 >= 1600.0d) {
                    double d6 = (d4 - 1600.0d) / 20.0d;
                    short[] sArr = dt2;
                    double adjust_for_tidacc = adjust_for_tidacc(d2, ((double) sArr[26]) + (d6 * (dt[0] - ((double) sArr[26]))), d5) / 86400.0d;
                    return adjust_for_tidacc;
                }
            }
            if (d4 < 1620.0d) {
                return 0.0d;
            }
            double deltat_aa = deltat_aa(d, d2);
            return deltat_aa;
        }
    }

    private static double deltat_aa(double d, double d2) {
        int i;
        int i2;
        double[] dArr = new double[6];
        int init_dt = init_dt();
        int i3 = (init_dt + TABSTART) - 1;
        double d3 = ((d - 2451545.0d) / 365.2425d) + 2000.0d;
        if (d3 <= ((double) i3)) {
            double floor = SMath.floor(d3);
            int i4 = (int) (floor - 1620.0d);
            double[] dArr2 = dt;
            double d4 = dArr2[i4];
            int i5 = i4 + 1;
            if (i5 >= init_dt) {
                return deltat_aa_label_done(d2, d4, d3);
            }
            double d5 = d3 - floor;
            double d6 = d4 + ((dArr2[i5] - dArr2[i4]) * d5);
            if (i4 - 1 < 0 || (i = i4 + 2) >= init_dt) {
                return deltat_aa_label_done(d2, d6, d3);
            }
            int i6 = i4 - 2;
            int i7 = i6;
            for (int i8 = 0; i8 < 5; i8++) {
                if (i7 < 0 || (i2 = i7 + 1) >= init_dt) {
                    dArr[i8] = 0.0d;
                } else {
                    double[] dArr3 = dt;
                    dArr[i8] = dArr3[i2] - dArr3[i7];
                }
                i7++;
            }
            int i9 = 0;
            while (i9 < 4) {
                int i10 = i9 + 1;
                dArr[i9] = dArr[i10] - dArr[i9];
                i9 = i10;
            }
            double d7 = 0.25d * d5 * (d5 - 1.0d);
            double d8 = d6 + ((dArr[1] + dArr[2]) * d7);
            if (i >= init_dt) {
                return deltat_aa_label_done(d2, d8, d3);
            }
            int i11 = 0;
            while (i11 < 3) {
                int i12 = i11 + 1;
                dArr[i11] = dArr[i12] - dArr[i11];
                i11 = i12;
            }
            double d9 = (d7 * 2.0d) / 3.0d;
            double d10 = d8 + ((d5 - 0.5d) * d9 * dArr[1]);
            if (i6 < 0 || i4 + 3 > init_dt) {
                return deltat_aa_label_done(d2, d10, d3);
            }
            int i13 = 0;
            while (i13 < 2) {
                int i14 = i13 + 1;
                dArr[i13] = dArr[i14] - dArr[i13];
                i13 = i14;
            }
            return deltat_aa_label_done(d2, d10 + (d9 * 0.125d * (d5 + 1.0d) * (d5 - 2.0d) * (dArr[0] + dArr[1])), d3);
        }
        double d11 = (d3 - 1820.0d) * 0.01d;
        double d12 = ((d11 * 31.0d) * d11) - 0.21875d;
        double d13 = (double) (i3 + 100);
        if (d3 <= d13) {
            double d14 = ((double) (i3 - 1820)) * 0.01d;
            d12 += ((((31.0d * d14) * d14) - 0.21875d) - dt[init_dt - 1]) * (d3 - d13) * 0.01d;
        }
        return d12 / 86400.0d;
    }

    private static double deltat_longterm_morrison_stephenson(double d) {
        double d2 = ((((d - 2451545.0d) / 365.2425d) + 2000.0d) - 1820.0d) / 100.0d;
        return ((32.0d * d2) * d2) - 0.21875d;
    }

    private static double deltat_stephenson_morrison_1600(double d, double d2) {
        double d3;
        double d4 = ((d - 2451545.0d) / 365.2425d) + 2000.0d;
        if (d4 < -1000.0d) {
            d3 = adjust_for_tidacc(d2, deltat_longterm_morrison_stephenson(d), d4);
            if (d4 >= -1100.0d) {
                d3 -= (adjust_for_tidacc(d2, deltat_longterm_morrison_stephenson(1355817.5d), d4) - adjust_for_tidacc(d2, (double) dt2[0], -1000.0d)) * ((d4 - -1100.0d) * 0.01d);
            }
        } else {
            d3 = 0.0d;
        }
        if (d4 >= -1000.0d && d4 < 1600.0d) {
            double d5 = ((d - 2451557.5d) / 365.25d) + 2000.0d;
            int floor = (int) ((SMath.floor(d5) - -1000.0d) / 100.0d);
            short[] sArr = dt2;
            double d6 = d2;
            d3 = adjust_for_tidacc(d6, ((double) sArr[floor]) + (((double) (sArr[floor + 1] - sArr[floor])) * ((d5 - ((double) ((floor * 100) - 1000))) / 100.0d)), d4);
        }
        return d3 / 86400.0d;
    }

    private static double deltat_espenak_meeus_1620(double d, double d2) {
        double d3;
        double d4 = ((d - 2451545.0d) / 365.2425d) + 2000.0d;
        if (d4 < -500.0d) {
            d3 = deltat_longterm_morrison_stephenson(d);
        } else if (d4 < 500.0d) {
            double d5 = d4 / 100.0d;
            d3 = (((((((((((0.0090316521d * d5) + 0.022174192d) * d5) - 0.1798452d) * d5) - 5.952053d) * d5) + 33.78311d) * d5) - 1014.41d) * d5) + 10583.6d;
        } else if (d4 < 1600.0d) {
            double d6 = (d4 - 1000.0d) / 100.0d;
            d3 = (((((((((((0.0083572073d * d6) - 0.005050998d) * d6) - 0.8503463d) * d6) + 0.319781d) * d6) + 71.23472d) * d6) - 556.01d) * d6) + 1574.2d;
        } else if (d4 < 1700.0d) {
            double d7 = d4 - 1600.0d;
            d3 = ((120.0d - (0.9808d * d7)) - ((0.01532d * d7) * d7)) + (((d7 * d7) * d7) / 7129.0d);
        } else if (d4 < 1800.0d) {
            double d8 = d4 - 1700.0d;
            d3 = ((((((((-d8) / 1174000.0d) + 1.3336E-4d) * d8) - 0.0059285d) * d8) + 0.1603d) * d8) + 8.83d;
        } else if (d4 < 1860.0d) {
            double d9 = d4 - 1800.0d;
            d3 = (((((((((((((8.75E-10d * d9) - 1.699E-7d) * d9) + 1.21272E-5d) * d9) - 3.7436E-4d) * d9) + 0.0041116d) * d9) + 0.0068612d) * d9) - 0.332447d) * d9) + 13.72d;
        } else if (d4 < 1900.0d) {
            double d10 = d4 - 1860.0d;
            d3 = (((((((((d10 / 233174.0d) - 4.473624E-4d) * d10) + 0.01680668d) * d10) - 0.251754d) * d10) + 0.5737d) * d10) + 7.62d;
        } else if (d4 < 1920.0d) {
            double d11 = d4 - 1900.0d;
            d3 = (((((((-1.97E-4d * d11) + 0.0061966d) * d11) - 0.0598939d) * d11) + 1.494119d) * d11) - 2.79d;
        } else if (d4 < 1941.0d) {
            double d12 = d4 - 1920.0d;
            d3 = (((0.84493d * d12) + 21.2d) - ((0.0761d * d12) * d12)) + (0.0020936d * d12 * d12 * d12);
        } else if (d4 < 1961.0d) {
            double d13 = d4 - 1950.0d;
            double d14 = d13 * d13;
            d3 = (((0.407d * d13) + 29.07d) - (d14 / 233.0d)) + ((d14 * d13) / 2547.0d);
        } else if (d4 < 1986.0d) {
            double d15 = d4 - 1975.0d;
            double d16 = d15 * d15;
            d3 = (((1.067d * d15) + 45.45d) - (d16 / 260.0d)) - ((d16 * d15) / 718.0d);
        } else if (d4 < 2005.0d) {
            double d17 = d4 - 2000.0d;
            d3 = (((((((((2.373599E-5d * d17) + 6.51814E-4d) * d17) + 0.0017275d) * d17) - 0.060374d) * d17) + 0.3345d) * d17) + 63.86d;
        } else {
            d3 = 0.0d;
        }
        return adjust_for_tidacc(d2, d3, d4) / 86400.0d;
    }

    private static synchronized double deltat_aa_label_done(double d, double d2, double d3) {
        double adjust_for_tidacc;
        synchronized (SweDate.class) {
            adjust_for_tidacc = adjust_for_tidacc(d, d2, d3) / 86400.0d;
        }
        return adjust_for_tidacc;
    }

    private static int init_dt() {
        FilePtr filePtr;
        if (!init_dt_done) {
            init_dt_done = true;
            try {
                SwissEph swissEph = sw;
                filePtr = swissEph.swi_fopen(-1, "swe_deltat.txt", swissEph.swed.ephepath, (StringBuffer) null);
                if (filePtr == null) {
                    SwissEph swissEph2 = sw;
                    filePtr = swissEph2.swi_fopen(-1, "sedeltat.txt", swissEph2.swed.ephepath, (StringBuffer) null);
                    if (filePtr == null) {
                        return TABSIZ;
                    }
                }
            } catch (SwissephException e) {
                try {
                    SwissEph swissEph3 = sw;
                    filePtr = swissEph3.swi_fopen(-1, "sedeltat.txt", swissEph3.swed.ephepath, (StringBuffer) null);
                    if (filePtr == null) {
                        return TABSIZ;
                    }
                } catch (SwissephException e2) {
                    return TABSIZ;
                }
            }
            while (true) {
                try {
                    String readLine = filePtr.readLine();
                    if (readLine != null) {
                        readLine.trim();
                        if (readLine.length() != 0) {
                            if (readLine.charAt(0) != '#') {
                                int atoi = SwissLib.atoi(readLine) - 1620;
                                if (atoi < TABSIZ_SPACE) {
                                    if (readLine.length() > 4) {
                                        readLine = readLine.substring(4).trim();
                                    }
                                    dt[atoi] = (double) ((short) ((int) SwissLib.atof(readLine)));
                                }
                            }
                        }
                    }
                } catch (IOException e3) {
                }
                try {
                    break;
                } catch (IOException e4) {
                }
            }
            filePtr.close();
        }
        int i = 382;
        int i2 = 381;
        while (i2 < TABSIZ_SPACE && dt[i2] != 0.0d) {
            i++;
            i2++;
        }
        return i - 1;
    }

    private static double adjust_for_tidacc(double d, double d2, double d3) {
        if (d3 >= 1955.0d) {
            return d2;
        }
        double d4 = d3 - 1955.0d;
        return d2 + ((d + 26.0d) * -9.1E-5d * d4 * d4);
    }

    private void initDateFromJD(double d, boolean z) {
        this.jd = d;
        this.calType = z;
        IDate swe_revjul = swe_revjul(d, z);
        this.year = swe_revjul.year;
        this.month = swe_revjul.month;
        this.day = swe_revjul.day;
        this.hour = swe_revjul.hour;
    }

    private void setFields(int i, int i2, int i3, double d) {
        boolean z;
        IDate swe_revjul = swe_revjul(this.jdCO, true);
        if (swe_revjul.year > i || ((swe_revjul.year == i && swe_revjul.month > i2) || (swe_revjul.year == i && swe_revjul.month == i2 && swe_revjul.day > i3))) {
            z = false;
        } else {
            z = true;
        }
        setFields(i, i2, i3, d, z);
    }

    private void setFields(int i, int i2, int i3, double d, boolean z) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = d;
        this.calType = z;
        this.jd = swe_julday(i, i2, i3, d, z);
    }

    public SDate getUTCFromLocalTime(int i, int i2, int i3, int i4, int i5, double d, double d2) {
        return getLocalTimeFromUTC(i, i2, i3, i4, i5, d, -d2);
    }

    public SDate getLocalTimeFromUTC(int i, int i2, int i3, int i4, int i5, double d, double d2) {
        boolean z;
        double d3;
        if (d >= 60.0d) {
            d3 = d - 1.0d;
            z = true;
        } else {
            d3 = d;
            z = false;
        }
        double d4 = ((double) i4) + (((double) i5) / 60.0d) + (d3 / 3600.0d);
        double swe_julday = swe_julday(i, i2, i3, 0.0d, true);
        double d5 = d4 - d2;
        if (d5 < 0.0d) {
            swe_julday -= 1.0d;
            d5 += 24.0d;
        }
        if (d5 >= 24.0d) {
            swe_julday += 1.0d;
            d5 -= 24.0d;
        }
        IDate swe_revjul = swe_revjul(swe_julday + 0.001d, true);
        int i6 = swe_revjul.year;
        int i7 = swe_revjul.month;
        int i8 = swe_revjul.day;
        int i9 = (int) d5;
        double d6 = (d5 - ((double) i9)) * 60.0d;
        int i10 = (int) d6;
        double d7 = (d6 - ((double) i10)) * 60.0d;
        if (z) {
            d7 += 1.0d;
        }
        return new SDate(i6, i7, i8, i9, i10, d7);
    }

    private int init_leapsec() {
        int i;
        int i2 = 0;
        if (!this.init_leapseconds_done) {
            this.init_leapseconds_done = true;
            int i3 = leap_seconds[23];
            FilePtr filePtr = null;
            int i4 = 24;
            try {
                SwissEph swissEph = sw;
                filePtr = swissEph.swi_fopen(-1, "seleapsec.txt", swissEph.swed.ephepath, (StringBuffer) null);
                if (filePtr == null) {
                    return 24;
                }
                i = 24;
                while (true) {
                    try {
                        String readLine = filePtr.readLine();
                        if (readLine != null) {
                            readLine.trim();
                            if (!readLine.startsWith("#")) {
                                if (readLine.length() != 0) {
                                    int atoi = SwissLib.atoi(readLine);
                                    if (atoi > i3) {
                                        if (i >= 100) {
                                            return i;
                                        }
                                        leap_seconds[i] = atoi;
                                        i++;
                                    }
                                }
                            }
                        } else {
                            if (i > 24) {
                                leap_seconds[i] = 0;
                            }
                            filePtr.close();
                        }
                    } catch (IOException e) {
                        i4 = i;
                        i = i4;
                        filePtr.close();
                        return i;
                    } catch (SwissephException e2) {
                        return i;
                    }
                }
                try {
                    filePtr.close();
                } catch (IOException e3) {
                }
                return i;
            } catch (IOException e4) {
                i = i4;
                filePtr.close();
                return i;
            } catch (SwissephException e5) {
                return 24;
            }
        } else {
            int i5 = 0;
            while (i2 < 100 && leap_seconds[i2] != 0) {
                i5++;
                i2++;
            }
            return i5;
        }
    }

    public boolean isValidUTCDate(int i, int i2, int i3, int i4, int i5, double d, boolean z) {
        return getInvalidUTCDateError(i, i2, i3, i4, i5, d, z) == null;
    }

    public String getInvalidUTCDateError(int i, int i2, int i3, int i4, int i5, double d, boolean z) {
        int i6;
        double swe_julday = swe_julday(i, i2, i3, 0.0d, z);
        IDate swe_revjul = swe_revjul(swe_julday, z);
        if (i != swe_revjul.year || i2 != swe_revjul.month || i3 != swe_revjul.day) {
            return "invalid date: year = " + i + ", month = " + i2 + ", day = " + i + i3;
        } else if (i4 < 0 || i4 > 23 || i5 < 0 || i5 > 59 || d < 0.0d || d >= 61.0d || (d >= 60.0d && (i5 < 59 || i4 < 23 || swe_julday < J1972))) {
            return "invalid time: " + i4 + ":" + i5 + ":" + d;
        } else {
            int init_leapsec = init_leapsec();
            int i7 = (i * SweConst.SE_AST_OFFSET) + (i2 * 100) + i3;
            if (i6 < 0) {
                return null;
            }
            boolean z2 = false;
            int i8 = 0;
            while (true) {
                if (i8 >= init_leapsec) {
                    break;
                } else if (i7 == leap_seconds[i8]) {
                    z2 = true;
                    break;
                } else {
                    i8++;
                }
            }
            if (z2) {
                return null;
            }
            return "invalid time (no leap second!): " + i4 + ":" + i5 + ":" + d;
        }
    }

    public double[] getJDfromUTC(int i, int i2, int i3, int i4, int i5, double d, boolean z, boolean z2) throws SwissephException {
        String invalidUTCDateError;
        int i6 = i4;
        int i7 = i5;
        double[] dArr = new double[2];
        if (!z2 || (invalidUTCDateError = getInvalidUTCDateError(i, i2, i3, i4, i5, d, z)) == null) {
            double swe_julday = swe_julday(i, i2, i3, 0.0d, z);
            double d2 = (double) i6;
            double d3 = (double) i7;
            double d4 = (d3 / 60.0d) + d2 + (d / 3600.0d);
            if (swe_julday < J1972) {
                dArr[1] = swe_julday(i, i2, i3, d4, z);
                dArr[0] = dArr[1] + getDeltaT(dArr[1]);
                return dArr;
            }
            if (!z) {
                swe_revjul(swe_julday, true);
            }
            int init_leapsec = init_leapsec();
            int i8 = (i * SweConst.SE_AST_OFFSET) + (i2 * 100) + i3;
            int i9 = 0;
            int i10 = 10;
            while (i9 < init_leapsec && i8 > leap_seconds[i9]) {
                i10++;
                i9++;
            }
            double d5 = swe_julday;
            if (((getDeltaT(swe_julday) * 86400.0d) - ((double) i10)) - 32.184d >= 1.0d) {
                dArr[1] = d5 + (d4 / 24.0d);
                dArr[0] = dArr[1] + getDeltaT(dArr[1]);
                return dArr;
            }
            double d6 = (d5 - J1972) + (d2 / 24.0d) + (d3 / 1440.0d) + (d / 86400.0d) + 2441317.5004882407d + (((double) (i10 - 10)) / 86400.0d);
            dArr[0] = d6;
            dArr[1] = d6 - getDeltaT(d6 - getDeltaT(d6));
            return dArr;
        }
        throw new SwissephException(swe_julday(i, i2, i3, ((double) i6) + (((double) i7) / 60.0d) + (d / 3600.0d), z), SwissephException.INVALID_DATE, invalidUTCDateError);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public swisseph.SDate getUTCfromJDET(double r24, boolean r26) {
        /*
            r23 = this;
            r10 = r23
            r11 = r26
            double r0 = getDeltaT(r24)
            double r0 = r24 - r0
            double r0 = getDeltaT(r0)
            double r0 = r24 - r0
            r12 = 4702497100759302057(0x4142a032c00fffa9, double:2441317.5004882407)
            int r2 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            swisseph.IDate r0 = r10.swe_revjul(r0, r11)
            swisseph.SDate r7 = new swisseph.SDate
            int r2 = r0.year
            int r3 = r0.month
            int r4 = r0.day
            double r5 = r0.hour
            r1 = r7
            r1.<init>(r2, r3, r4, r5)
            return r7
        L_0x002e:
            int r2 = r23.init_leapsec()
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r0 - r14
            r9 = 1
            swisseph.IDate r3 = r10.swe_revjul(r3, r9)
            int r4 = r3.year
            int r5 = r3.month
            int r6 = r3.day
            double r7 = r3.hour
            int r4 = r4 * 10000
            int r5 = r5 * 100
            int r4 = r4 + r5
            int r4 = r4 + r6
            r16 = 0
            r3 = 0
            r8 = 0
        L_0x004e:
            if (r3 >= r2) goto L_0x005c
            int[] r5 = leap_seconds
            r5 = r5[r3]
            if (r4 > r5) goto L_0x0057
            goto L_0x005c
        L_0x0057:
            int r8 = r8 + 1
            int r3 = r3 + 1
            goto L_0x004e
        L_0x005c:
            if (r8 >= r2) goto L_0x00b4
            int[] r2 = leap_seconds
            r2 = r2[r8]
            int r3 = r2 / 10000
            int r4 = r2 % 10000
            int r18 = r4 / 100
            int r19 = r2 % 100
            r20 = 0
            r22 = 1
            r17 = r3
            swe_julday(r17, r18, r19, r20, r22)
            double r0 = r0 + r14
            swisseph.IDate r0 = r10.swe_revjul(r0, r9)
            int r1 = r0.year
            int r2 = r0.month
            int r3 = r0.day
            double r4 = r0.hour
            r4 = 0
            r5 = 0
            r6 = 0
            r17 = 1
            r18 = 0
            r0 = r23
            r19 = r8
            r8 = r17
            r14 = 1
            r9 = r18
            double[] r0 = r0.getJDfromUTC(r1, r2, r3, r4, r5, r6, r8, r9)
            r1 = r0[r16]
            double r0 = r24 - r1
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x00a3
            int r8 = r19 + 1
            r9 = 0
            goto L_0x00ba
        L_0x00a3:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b7
            r2 = -4690422283912720087(0xbee845c8a0ce5129, double:-1.1574074074074073E-5)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b7
            r8 = r19
            r9 = 1
            goto L_0x00ba
        L_0x00b4:
            r19 = r8
            r14 = 1
        L_0x00b7:
            r8 = r19
            r9 = 0
        L_0x00ba:
            r0 = 4702497100758253568(0x4142a032c0000000, double:2441317.5)
            double r2 = r24 - r12
            double r2 = r2 + r0
            double r0 = (double) r8
            double r4 = (double) r9
            double r0 = r0 + r4
            r6 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r0 = r0 / r6
            double r2 = r2 - r0
            swisseph.IDate r0 = r10.swe_revjul(r2, r14)
            int r1 = r0.year
            int r2 = r0.month
            int r3 = r0.day
            double r12 = r0.hour
            int r0 = (int) r12
            double r14 = (double) r0
            double r12 = r12 - r14
            r14 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r12 = r12 * r14
            int r9 = (int) r12
            double r6 = (double) r9
            double r12 = r12 - r6
            double r12 = r12 * r14
            double r12 = r12 + r4
            double r4 = getDeltaT(r24)
            double r4 = r24 - r4
            double r4 = getDeltaT(r4)
            r6 = 4680673776000565248(0x40f5180000000000, double:86400.0)
            double r6 = r6 * r4
            int r8 = r8 + 10
            double r14 = (double) r8
            double r6 = r6 - r14
            r14 = 4629726312634727268(0x4040178d4fdf3b64, double:32.184)
            double r6 = r6 - r14
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x012a
            double r0 = r24 - r4
            r2 = 1
            swisseph.IDate r0 = r10.swe_revjul(r0, r2)
            int r1 = r0.year
            int r2 = r0.month
            int r3 = r0.day
            double r5 = r0.hour
            int r0 = (int) r5
            double r7 = (double) r0
            double r5 = r5 - r7
            r7 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r5 = r5 * r7
            int r9 = (int) r5
            double r12 = (double) r9
            double r5 = r5 - r12
            double r12 = r5 * r7
            r18 = r0
            r19 = r9
            r20 = r12
            r12 = r2
            r13 = r3
            goto L_0x0132
        L_0x012a:
            r18 = r0
            r19 = r9
            r20 = r12
            r12 = r2
            r13 = r3
        L_0x0132:
            if (r11 != 0) goto L_0x0151
            r14 = 0
            r16 = 1
            r11 = r1
            double r0 = swe_julday(r11, r12, r13, r14, r16)
            r2 = 1
            swisseph.IDate r0 = r10.swe_revjul(r0, r2)
            swisseph.SDate r7 = new swisseph.SDate
            int r2 = r0.year
            int r3 = r0.month
            int r4 = r0.day
            double r5 = r0.hour
            r1 = r7
            r1.<init>(r2, r3, r4, r5)
            return r7
        L_0x0151:
            swisseph.SDate r0 = new swisseph.SDate
            r14 = r0
            r15 = r1
            r16 = r12
            r17 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.SweDate.getUTCfromJDET(double, boolean):swisseph.SDate");
    }

    public SDate getUTCfromJDUT1(double d, boolean z) {
        return getUTCfromJDET(d + getDeltaT(d), z);
    }
}
