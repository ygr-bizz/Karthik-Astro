package swisseph;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.Serializable;

class FileData implements Serializable {
    static final int CRC32_POLY = 79764919;
    static long[] crc32_table = null;
    final byte SEI_FILE_NMAXPLAN = 50;
    String astnam;
    String fnam;
    FilePtr fptr = null;
    int fversion;
    int iflg;
    int[] ipl = new int[50];
    short npl;
    String serr_file_damage = "Ephemeris file %s is damaged. ";
    int sweph_denum;
    double tfend = 0.0d;
    double tfstart = 1.0d;

    FileData() {
    }

    /* access modifiers changed from: package-private */
    public void clearData() {
        this.fnam = "";
        this.fversion = 0;
        this.astnam = "";
        this.sweph_denum = 0;
        try {
            FilePtr filePtr = this.fptr;
            if (filePtr != null) {
                filePtr.close();
            }
        } catch (IOException e) {
        }
        this.fptr = null;
        this.tfstart = 1.0d;
        this.tfend = 0.0d;
        this.iflg = 0;
        this.npl = 0;
        for (int i = 0; i < 50; i++) {
            this.ipl[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public int read_const(int i, StringBuffer stringBuffer, SwissData swissData) {
        String sb;
        String sb2;
        String str;
        int i2;
        int i3;
        short s;
        char c;
        PlanData planData;
        int i4;
        String sb3;
        int i5 = i;
        StringBuffer stringBuffer2 = stringBuffer;
        SwissData swissData2 = swissData;
        String str2 = "";
        String str3 = str2;
        byte b = 0;
        while (true) {
            char c2 = (char) b;
            try {
                byte readByte = this.fptr.readByte();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                char c3 = (char) readByte;
                sb4.append(c3);
                sb = sb4.toString();
                if (c2 == 13 || c3 == 10) {
                    break;
                } else if (sb.length() >= 256) {
                    break;
                } else {
                    b = readByte;
                    str3 = sb;
                }
            } catch (NumberFormatException e) {
                label_file_damage(stringBuffer2, " (1)");
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            } catch (IOException e2) {
                label_file_damage(stringBuffer2, " (6a)");
                System.out.println(e2.getMessage());
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            } catch (Exception e3) {
                label_file_damage(stringBuffer2, " (6c)");
                System.out.println(e3);
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            }
        }
        String trim = sb.trim();
        int i6 = 0;
        while (!Character.isDigit(trim.charAt(i6))) {
            i6++;
        }
        this.fversion = Integer.parseInt(trim.substring(i6));
        String str4 = str2;
        byte b2 = 0;
        while (true) {
            char c4 = (char) b2;
            byte readByte2 = this.fptr.readByte();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            char c5 = (char) readByte2;
            sb5.append(c5);
            sb2 = sb5.toString();
            if (c4 == 13 || c5 == 10) {
                break;
            } else if (sb2.length() >= 256) {
                break;
            } else {
                b2 = readByte2;
                str4 = sb2;
            }
        }
        String str5 = this.fnam;
        String lowerCase = str5.substring(str5.lastIndexOf(swissData2.DIR_GLUE) + 1).toLowerCase();
        String lowerCase2 = sb2.trim().toLowerCase();
        if (!lowerCase2.equals(lowerCase)) {
            String str6 = this.fnam;
            if (!lowerCase2.equals(str6.substring(str6.lastIndexOf("/") + 1).toLowerCase())) {
                String str7 = this.fnam;
                String lowerCase3 = str7.substring(str7.lastIndexOf(swissData2.DIR_GLUE) + 1).toLowerCase();
                if (stringBuffer2 != null) {
                    stringBuffer2.setLength(0);
                    stringBuffer2.append("Ephemeris file name '" + lowerCase3 + "' is wrong; rename to '" + lowerCase2 + "'");
                }
                clearData();
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            }
        }
        String str8 = str2;
        byte b3 = 0;
        while (true) {
            char c6 = (char) b3;
            byte readByte3 = this.fptr.readByte();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str8);
            char c7 = (char) readByte3;
            sb6.append(c7);
            String sb7 = sb6.toString();
            if (c6 == 13 || c7 == 10) {
                break;
            } else if (sb7.length() >= 256) {
                break;
            } else {
                b3 = readByte3;
                str8 = sb7;
            }
        }
        if (i5 == 3) {
            String str9 = str2;
            byte b4 = 0;
            while (true) {
                char c8 = (char) b4;
                byte readByte4 = this.fptr.readByte();
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str9);
                char c9 = (char) readByte4;
                sb8.append(c9);
                sb3 = sb8.toString();
                if (c8 == 13 || c9 == 10) {
                    break;
                } else if (sb3.length() >= 512) {
                    break;
                } else {
                    str9 = sb3;
                    b4 = readByte4;
                }
            }
            String str10 = sb3;
            while (Character.isWhitespace(str10.charAt(0))) {
                str10 = str10.substring(1);
            }
            while (Character.isDigit(str10.charAt(0))) {
                str10 = str10.substring(1);
            }
            String substring = str10.substring(1);
            int length = sb3.length() - substring.length();
            String substring2 = substring.substring(0, length + 19);
            swissData2.astelem = sb3;
            swissData2.ast_H = SwissLib.atof(sb3.substring(length + 35));
            swissData2.ast_G = SwissLib.atof(sb3.substring(length + 42));
            if (swissData2.ast_G == 0.0d) {
                swissData2.ast_G = 0.15d;
            }
            swissData2.ast_diam = SwissLib.atof(sb3.substring(length + 51, length + 58));
            if (swissData2.ast_diam == 0.0d) {
                swissData2.ast_diam = (1329.0d / SMath.sqrt(0.15d)) * SMath.pow(10.0d, swissData2.ast_H * -0.2d);
            }
            str = substring2;
        } else {
            str = str2;
        }
        int readInt = this.fptr.readInt();
        if (readInt == 6382179) {
            i2 = 0;
        } else if (((long) (((readInt & 255) << 24) + ((65280 & readInt) << 8) + ((16711680 & readInt) >> 8) + ((-16777216 & readInt) >> 24))) == 6382179) {
            i2 = 2;
        } else {
            throw new SwissephException(this.tfstart, 65, -1, "File is damaged: byte ordering info not correct.");
        }
        if ((readInt & 255) == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        this.iflg = i2 | i3;
        long read4 = (long) read4(this.fptr, -1, false, i2, i3);
        if (read4 < 0) {
            read4 &= -1;
        }
        long filePointer = this.fptr.getFilePointer();
        if (read4 == this.fptr.length()) {
            this.fptr.seek(filePointer);
            int read42 = read4(this.fptr, filePointer, false, i2, i3);
            this.sweph_denum = read42;
            swissData2.jpldenum = read42;
            this.tfstart = read8(this.fptr, -1, i2, i3);
            this.tfend = read8(this.fptr, -1, i2, i3);
            short read2 = read2(this.fptr, -1, i2, i3);
            if (read2 > 256) {
                s = (short) (read2 % 256);
                c = 4;
            } else {
                s = read2;
                c = 2;
            }
            if (s < 1 || s > 20) {
                label_file_damage(stringBuffer2, " (3)");
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            }
            this.npl = s;
            if (c == 2) {
                int i7 = 0;
                while (i7 < s) {
                    int i8 = i7;
                    this.ipl[i8] = read2(this.fptr, -1, i2, i3) & 65535;
                    i7 = i8 + 1;
                    s = s;
                }
            } else {
                short s2 = s;
                if (c == 4) {
                    int i9 = 0;
                    while (i9 < s2) {
                        int i10 = i9;
                        this.ipl[i10] = read4(this.fptr, -1, false, i2, i3);
                        i9 = i10 + 1;
                    }
                } else {
                    label_file_damage(stringBuffer2, " (3b)");
                }
            }
            if (i5 == 3) {
                int i11 = 4;
                while (str.charAt(i11) != ' ' && i11 < 10) {
                    i11++;
                }
                try {
                    i4 = Integer.parseInt(str.substring(0, SMath.min(str.length(), i11)).trim());
                } catch (NumberFormatException e4) {
                    i4 = 0;
                }
                if (i4 == this.ipl[0] - SweConst.SE_AST_OFFSET) {
                    int i12 = i11 + 1;
                    this.astnam = str.substring(SMath.min(str.length(), i12), SMath.min(str.length(), i12 + 19));
                    String str11 = str2;
                    for (int i13 = 0; i13 < 30; i13++) {
                        str11 = str11 + ((char) this.fptr.readByte());
                    }
                } else {
                    this.astnam = str2;
                    for (int i14 = 0; i14 < 30; i14++) {
                        this.astnam += ((char) this.fptr.readByte());
                    }
                }
                this.astnam = this.astnam.trim();
            }
            long filePointer2 = this.fptr.getFilePointer();
            long read43 = (long) read4(this.fptr, -1, false, i2, i3);
            this.fptr.seek(0);
            if (filePointer2 - 1 <= 512) {
                byte[] bArr = new byte[512];
                for (int i15 = 0; ((long) i15) < filePointer2; i15++) {
                    byte readByte5 = this.fptr.readByte();
                    bArr[i15] = readByte5;
                    str2 = str2 + ((char) readByte5);
                }
                if (((int) swi_crc32(bArr, (int) filePointer2)) == ((int) read43)) {
                    this.fptr.seek(filePointer2 + 4);
                    swissData2.gcdat.clight = read8(this.fptr, -1, i2, i3);
                    swissData2.gcdat.aunit = read8(this.fptr, -1, i2, i3);
                    swissData2.gcdat.helgravconst = read8(this.fptr, -1, i2, i3);
                    swissData2.gcdat.ratme = read8(this.fptr, -1, i2, i3);
                    swissData2.gcdat.sunradius = read8(this.fptr, -1, i2, i3);
                    for (int i16 = 0; i16 < this.npl; i16++) {
                        int i17 = this.ipl[i16];
                        if (i17 >= 10000) {
                            planData = swissData2.pldat[11];
                        } else {
                            planData = swissData2.pldat[i17];
                        }
                        planData.ibdy = i17;
                        planData.lndx0 = ((long) read4(this.fptr, -1, false, i2, i3)) & 4294967295L;
                        planData.iflg = this.fptr.readUnsignedByte();
                        planData.ncoe = this.fptr.readUnsignedByte();
                        planData.rmax = ((double) ((long) read4(this.fptr, -1, false, i2, i3))) / 1000.0d;
                        planData.tfstart = read8(this.fptr, -1, i2, i3);
                        planData.tfend = read8(this.fptr, -1, i2, i3);
                        planData.dseg = read8(this.fptr, -1, i2, i3);
                        planData.nndx = (int) (((planData.tfend - planData.tfstart) + 0.1d) / planData.dseg);
                        planData.telem = read8(this.fptr, -1, i2, i3);
                        planData.prot = read8(this.fptr, -1, i2, i3);
                        planData.dprot = read8(this.fptr, -1, i2, i3);
                        planData.qrot = read8(this.fptr, -1, i2, i3);
                        planData.dqrot = read8(this.fptr, -1, i2, i3);
                        planData.peri = read8(this.fptr, -1, i2, i3);
                        planData.dperi = read8(this.fptr, -1, i2, i3);
                        if ((planData.iflg & 4) != 0) {
                            if (planData.refep != null) {
                                planData.refep = null;
                                if (planData.segp != null) {
                                    planData.segp = null;
                                }
                            }
                            planData.refep = new double[(planData.ncoe * 2)];
                            for (int i18 = 0; i18 < planData.ncoe * 2; i18++) {
                                planData.refep[i18] = read8(this.fptr, -1, i2, i3);
                            }
                        }
                    }
                    return 0;
                }
                label_file_damage(stringBuffer2, " (5)");
                throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
            }
            label_file_damage(stringBuffer2, " (4)");
            throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
        }
        label_file_damage(stringBuffer2, " (2)");
        throw new SwissephException(this.tfstart, 65, -1, stringBuffer);
    }

    private int label_file_damage(StringBuffer stringBuffer, String str) {
        if (stringBuffer != null) {
            stringBuffer.setLength(0);
            if (this.serr_file_damage.length() + this.fnam.length() < 256) {
                stringBuffer.append(this.serr_file_damage.replaceFirst("%s", this.fnam));
                stringBuffer.append(str);
            } else {
                stringBuffer.append(this.serr_file_damage.replaceFirst("%s", this.fnam));
                stringBuffer.append(str);
            }
        }
        clearData();
        System.out.println(stringBuffer);
        return -1;
    }

    /* access modifiers changed from: package-private */
    public long swi_crc32(byte[] bArr, int i) {
        if (crc32_table == null) {
            init_crc32();
        }
        int i2 = 0;
        long j = 4294967295L;
        while (i > 0) {
            j = crc32_table[(int) ((j >> 24) ^ (((long) bArr[i2]) & 255))] ^ ((j << 8) & 4294967295L);
            i2++;
            i--;
        }
        return ~j;
    }

    /* access modifiers changed from: package-private */
    public void init_crc32() {
        crc32_table = new long[256];
        for (long j = 0; j < 256; j++) {
            long j2 = j << 24;
            for (long j3 = 8; j3 > 0; j3--) {
                int i = ((2147483648L & j2) > 0 ? 1 : ((2147483648L & j2) == 0 ? 0 : -1));
                j2 <<= 1;
                if (i != 0) {
                    j2 ^= 79764919;
                }
            }
            crc32_table[(int) j] = j2 & 4294967295L;
        }
    }

    private short read2(FilePtr filePtr, long j, int i, int i2) throws Exception {
        if (j >= 0) {
            filePtr.seek(j);
        }
        short readShort = filePtr.readShort();
        if (i == 0) {
            return readShort;
        }
        return (short) ((((readShort >>> 8) & 255) | (readShort << 8)) & SupportMenu.USER_MASK);
    }

    private int read3(FilePtr filePtr, long j, int i, int i2) throws Exception {
        if (j >= 0) {
            filePtr.seek(j);
        }
        int readUnsignedByte = filePtr.readUnsignedByte();
        short readShort = filePtr.readShort();
        if (readShort < 0) {
            readShort &= 65535;
        }
        int i3 = (readUnsignedByte << 16) + readShort;
        if (i == 0) {
            return i3;
        }
        int i4 = ((i3 & 255) << 24) + ((65280 & i3) << 8) + ((16711680 & i3) >> 8) + ((i3 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        boolean z = true;
        if ((i2 != 0 || i == 0) && !(i2 == 1 && i == 0)) {
            z = false;
        }
        return z ? i4 >> 8 : i4;
    }

    private int read4(FilePtr filePtr, long j, boolean z, int i, int i2) throws Exception {
        if (j >= 0) {
            filePtr.seek(j);
        }
        int readInt = filePtr.readInt();
        if (i != 0) {
            if (z) {
                return ((readInt & ViewCompat.MEASURED_STATE_MASK) >> 24) + ((readInt & 255) << 24) + ((65280 & readInt) << 8) + ((16711680 & readInt) >> 8);
            }
            return ((readInt & ViewCompat.MEASURED_STATE_MASK) >>> 24) + ((readInt & 255) << 24) + ((65280 & readInt) << 8) + ((16711680 & readInt) >> 8);
        } else if (!z || readInt >= 0) {
            return readInt;
        } else {
            return readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    private double read8(FilePtr filePtr, long j, int i, int i2) throws Exception {
        if (j >= 0) {
            filePtr.seek(j);
        }
        long doubleToLongBits = Double.doubleToLongBits(filePtr.readDouble());
        if (i != 0) {
            doubleToLongBits = ((doubleToLongBits & -72057594037927936L) >> 56) + ((255 & doubleToLongBits) << 56) + ((65280 & doubleToLongBits) << 40) + ((16711680 & doubleToLongBits) << 24) + ((4278190080L & doubleToLongBits) << 8) + ((1095216660480L & doubleToLongBits) >> 8) + ((280375465082880L & doubleToLongBits) >> 24) + ((71776119061217280L & doubleToLongBits) >> 40);
        }
        return Double.longBitsToDouble(doubleToLongBits);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0387, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x03d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x044a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x048b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x048c, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x04b2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x04b3, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03d4 A[ExcHandler: Exception (e java.lang.Exception), PHI: r7 
      PHI: (r7v20 swisseph.FileData) = (r7v18 swisseph.FileData), (r7v18 swisseph.FileData), (r7v18 swisseph.FileData), (r7v18 swisseph.FileData), (r7v21 swisseph.FileData), (r7v21 swisseph.FileData) binds: [B:135:0x03df, B:150:0x0415, B:146:0x03f9, B:147:?, B:128:0x03c8, B:129:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:128:0x03c8] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x044c A[ExcHandler: Exception (e java.lang.Exception), PHI: r3 
      PHI: (r3v28 java.lang.String) = (r3v29 java.lang.String), (r3v29 java.lang.String), (r3v44 java.lang.String) binds: [B:123:0x03bd, B:124:?, B:107:0x0366] A[DONT_GENERATE, DONT_INLINE], Splitter:B:107:0x0366] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x048b A[ExcHandler: Exception (e java.lang.Exception), PHI: r8 r12 
      PHI: (r8v2 swisseph.FileData) = (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v4 swisseph.FileData), (r8v4 swisseph.FileData), (r8v4 swisseph.FileData), (r8v5 swisseph.FileData), (r8v5 swisseph.FileData), (r8v5 swisseph.FileData), (r8v5 swisseph.FileData), (r8v5 swisseph.FileData), (r8v4 swisseph.FileData), (r8v4 swisseph.FileData), (r8v4 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData), (r8v0 swisseph.FileData) binds: [B:1:0x004a, B:2:?, B:4:0x0057, B:5:?, B:10:0x006f, B:11:?, B:18:0x0080, B:19:?, B:30:0x012d, B:38:0x01a0, B:39:?, B:80:0x0308, B:81:?, B:45:0x01c5, B:25:0x00fa, B:22:0x00a2, B:23:?, B:13:0x0074, B:14:?, B:7:0x0065, B:8:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v4 java.lang.String) = (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v6 java.lang.String), (r12v6 java.lang.String), (r12v6 java.lang.String), (r12v7 java.lang.String), (r12v7 java.lang.String), (r12v7 java.lang.String), (r12v7 java.lang.String), (r12v7 java.lang.String), (r12v6 java.lang.String), (r12v6 java.lang.String), (r12v6 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String) binds: [B:1:0x004a, B:2:?, B:4:0x0057, B:5:?, B:10:0x006f, B:11:?, B:18:0x0080, B:19:?, B:30:0x012d, B:38:0x01a0, B:39:?, B:80:0x0308, B:81:?, B:45:0x01c5, B:25:0x00fa, B:22:0x00a2, B:23:?, B:13:0x0074, B:14:?, B:7:0x0065, B:8:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int get_new_segment(swisseph.SwissData r42, double r43, int r45, int r46, java.lang.StringBuffer r47) {
        /*
            r41 = this;
            r8 = r41
            r0 = r42
            r9 = r47
            java.lang.String r10 = ". "
            java.lang.String r11 = " coefficients instead of "
            java.lang.String r12 = "file error in swisseph.FileData: "
            r13 = 6
            int[] r14 = new int[r13]
            r15 = 4
            short[] r7 = new short[r15]
            swisseph.PlanData[] r1 = r0.pldat
            r6 = r1[r45]
            swisseph.FileData[] r0 = r0.fidat
            r0 = r0[r46]
            int r1 = r0.iflg
            r16 = r1 & 2
            r5 = 1
            r17 = r1 & 1
            r1 = 41
            long[] r3 = new long[r1]
            double r1 = r6.tfstart
            double r1 = r43 - r1
            r18 = r14
            double r13 = r6.dseg
            double r1 = r1 / r13
            int r1 = (int) r1
            double r13 = r6.tfstart
            r4 = r3
            double r2 = (double) r1
            r43 = r4
            double r4 = r6.dseg
            double r2 = r2 * r4
            double r13 = r13 + r2
            r6.tseg0 = r13
            double r2 = r6.tseg0
            double r4 = r6.dseg
            double r2 = r2 + r4
            r6.tseg1 = r2
            long r2 = r6.lndx0
            int r3 = (int) r2
            r13 = 3
            int r1 = r1 * 3
            int r3 = r3 + r1
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r3 = (long) r3
            r1 = r41
            r14 = r43
            r15 = 1
            r5 = r16
            r15 = r6
            r6 = r17
            int r1 = r1.read3(r2, r3, r5, r6)     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            long r3 = (long) r1     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r2.seek(r3)     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            double[] r1 = r15.segp     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            if (r1 != 0) goto L_0x006d
            int r1 = r15.ncoe     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r1 = r1 * 3
            double[] r1 = new double[r1]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r15.segp = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
        L_0x006d:
            r6 = 0
            r1 = 0
        L_0x006f:
            double[] r2 = r15.segp     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2.length     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            if (r1 >= r2) goto L_0x007d
            double[] r2 = r15.segp     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = 0
            r2[r1] = r3     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r1 = r1 + 1
            goto L_0x006f
        L_0x007d:
            r5 = 0
        L_0x007e:
            if (r5 >= r13) goto L_0x0481
            int r1 = r15.ncoe     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r1 = r1 * r5
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2.readUnsignedByte()     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = (short) r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r7[r6] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2.readUnsignedByte()     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = (short) r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r3 = 1
            r7[r3] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = r7[r6]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r2 = r2 & 128(0x80, float:1.794E-43)
            r3 = 5
            r4 = 2
            r20 = 16
            if (r2 == 0) goto L_0x00f9
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2.readUnsignedByte()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = (short) r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r7[r4] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2.readUnsignedByte()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = (short) r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r7[r13] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r2 = 1
            short r21 = r7[r2]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r21 = r21 / 16
            r18[r6] = r21     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r21 = r7[r2]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r21 = r21 % 16
            r18[r2] = r21     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = r7[r4]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 / 16
            r18[r4] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = r7[r4]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 % 16
            r18[r13] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = r7[r13]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 / 16
            r19 = 4
            r18[r19] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            short r2 = r7[r13]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 % 16
            r18[r3] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r2 = r18[r6]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r21 = 1
            r22 = r18[r21]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 + r22
            r21 = r18[r4]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 + r21
            r21 = r18[r13]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 + r21
            r19 = 4
            r21 = r18[r19]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 + r21
            r21 = r18[r3]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r2 = r2 + r21
            r21 = r5
            r5 = 6
            goto L_0x0127
        L_0x00f9:
            short r2 = r7[r6]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 / 16
            r18[r6] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = r7[r6]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 % 16
            r21 = 1
            r18[r21] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = r7[r21]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 / 16
            r18[r4] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            short r2 = r7[r21]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 % 16
            r18[r13] = r2     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r2 = r18[r6]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            r21 = 1
            r22 = r18[r21]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 + r22
            r21 = r18[r4]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 + r21
            r21 = r18[r13]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            int r2 = r2 + r21
            r21 = r5
            r5 = 4
        L_0x0127:
            int r3 = r15.ncoe     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            if (r2 <= r3) goto L_0x019b
            if (r9 == 0) goto L_0x018a
            r9.setLength(r6)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.<init>()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r3 = "error in ephemeris file: "
            r1.append(r3)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r2)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r11)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = r15.ncoe     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r3)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r10)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r9.append(r1)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r1 = r47.length()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r3 = r0.fnam     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = r3.length()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r1 = r1 + r3
            r3 = 255(0xff, float:3.57E-43)
            if (r1 >= r3) goto L_0x018a
            r9.setLength(r6)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.<init>()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r3 = "error in ephemeris file "
            r1.append(r3)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r0 = r0.fnam     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r0)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r0 = ": "
            r1.append(r0)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r2)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r11)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r0 = r15.ncoe     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r0)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1.append(r10)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r9.append(r0)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
        L_0x018a:
            r0 = 0
            r15.segp = r0     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            swisseph.SwissephException r6 = new swisseph.SwissephException     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            double r1 = r8.tfstart     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = 65
            r4 = -1
            r0 = r6
            r5 = r47
            r0.<init>((double) r1, (int) r3, (int) r4, (java.lang.StringBuffer) r5)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            throw r6     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
        L_0x019b:
            r22 = r1
            r3 = 0
        L_0x019e:
            if (r3 >= r5) goto L_0x046b
            r1 = r18[r3]     // Catch:{ IOException -> 0x0485, Exception -> 0x048b }
            if (r1 != 0) goto L_0x01b5
            r35 = r0
            r0 = r3
            r31 = r5
            r36 = r7
            r7 = r8
            r37 = r10
            r34 = r11
            r3 = r12
            r33 = 0
            goto L_0x0455
        L_0x01b5:
            r23 = 4611686018427387904(0x4000000000000000, double:2.0)
            r25 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            r27 = 2
            r29 = 0
            r1 = 4
            if (r3 >= r1) goto L_0x02f2
            int r2 = 4 - r3
            r1 = r18[r3]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r44 = r5
            r5 = 0
        L_0x01ca:
            if (r5 >= r1) goto L_0x02a2
            r6 = 1
            if (r2 == r6) goto L_0x0279
            if (r2 == r4) goto L_0x024b
            if (r2 == r13) goto L_0x021d
            r6 = 4
            if (r2 == r6) goto L_0x01e6
            r31 = r44
            r35 = r0
            r13 = r1
            r34 = r2
            r0 = r3
            r32 = r5
            r36 = r7
            r33 = 0
            goto L_0x0291
        L_0x01e6:
            swisseph.FilePtr r6 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r31 = -1
            r33 = 0
            r13 = r1
            r1 = r41
            r34 = r2
            r2 = r6
            r35 = r0
            r6 = r3
            r0 = 2
            r3 = r31
            r31 = r44
            r32 = r5
            r5 = r33
            r0 = r6
            r33 = 0
            r6 = r16
            r36 = r7
            r7 = r17
            int r1 = r1.read4(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r1 = (long) r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = (r1 > r29 ? 1 : (r1 == r29 ? 0 : -1))
            if (r3 >= 0) goto L_0x0291
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = -1
            long r1 = r1 & r3
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            goto L_0x0291
        L_0x021d:
            r31 = r44
            r35 = r0
            r13 = r1
            r34 = r2
            r0 = r3
            r32 = r5
            r36 = r7
            r33 = 0
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = -1
            r1 = r41
            r5 = r16
            r6 = r17
            int r1 = r1.read3(r2, r3, r5, r6)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r1 = (long) r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = (r1 > r29 ? 1 : (r1 == r29 ? 0 : -1))
            if (r3 >= 0) goto L_0x0291
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = 16777215(0xffffff, double:8.2890456E-317)
            long r1 = r1 & r3
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            goto L_0x0291
        L_0x024b:
            r31 = r44
            r35 = r0
            r13 = r1
            r34 = r2
            r0 = r3
            r32 = r5
            r36 = r7
            r33 = 0
            swisseph.FilePtr r2 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = -1
            r1 = r41
            r5 = r16
            r6 = r17
            short r1 = r1.read2(r2, r3, r5, r6)     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r1 = (long) r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = (r1 > r29 ? 1 : (r1 == r29 ? 0 : -1))
            if (r3 >= 0) goto L_0x0291
            r1 = r14[r32]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = 65535(0xffff, double:3.23786E-319)
            long r1 = r1 & r3
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            goto L_0x0291
        L_0x0279:
            r31 = r44
            r35 = r0
            r13 = r1
            r34 = r2
            r0 = r3
            r32 = r5
            r36 = r7
            r33 = 0
            swisseph.FilePtr r1 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r1 = r1.readUnsignedByte()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r1 = (long) r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r14[r32] = r1     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
        L_0x0291:
            int r5 = r32 + 1
            r3 = r0
            r1 = r13
            r44 = r31
            r2 = r34
            r0 = r35
            r7 = r36
            r4 = 2
            r6 = 0
            r13 = 3
            goto L_0x01ca
        L_0x02a2:
            r31 = r44
            r35 = r0
            r13 = r1
            r0 = r3
            r36 = r7
            r33 = 0
            r6 = 0
        L_0x02ad:
            if (r6 >= r13) goto L_0x02ea
            r1 = r14[r6]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r3 = 1
            long r1 = r1 & r3
            r37 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r29 ? 1 : (r1 == r29 ? 0 : -1))
            if (r5 == 0) goto L_0x02d2
            double[] r1 = r15.segp     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r39 = r14[r6]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r39 = r39 + r3
            long r39 = r39 / r27
            long r2 = r39 & r37
            double r2 = (double) r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            double r2 = r2 / r25
            double r4 = r15.rmax     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            double r2 = r2 * r4
            double r2 = r2 / r23
            double r2 = -r2
            r1[r22] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            goto L_0x02e5
        L_0x02d2:
            double[] r1 = r15.segp     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r2 = r14[r6]     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r2 = r2 / r27
            long r2 = r2 & r37
            double r2 = (double) r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            double r2 = r2 / r25
            double r4 = r15.rmax     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            double r2 = r2 * r4
            double r2 = r2 / r23
            r1[r22] = r2     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
        L_0x02e5:
            int r6 = r6 + 1
            int r22 = r22 + 1
            goto L_0x02ad
        L_0x02ea:
            r7 = r8
            r37 = r10
            r34 = r11
            r3 = r12
            goto L_0x0455
        L_0x02f2:
            r35 = r0
            r0 = r3
            r31 = r5
            r36 = r7
            r33 = 0
            r1 = 4
            if (r0 != r1) goto L_0x03b4
            r1 = r18[r0]     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            r2 = 1
            int r1 = r1 + r2
            r3 = 2
            int r1 = r1 / r3
            r6 = 0
        L_0x0306:
            if (r6 >= r1) goto L_0x0314
            swisseph.FilePtr r3 = r8.fptr     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r3 = r3.readUnsignedByte()     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            long r3 = (long) r3     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            r14[r6] = r3     // Catch:{ IOException -> 0x04b2, Exception -> 0x048b }
            int r6 = r6 + 1
            goto L_0x0306
        L_0x0314:
            r3 = 0
            r6 = 0
        L_0x0316:
            if (r6 >= r1) goto L_0x039e
            r4 = r18[r0]     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            if (r3 >= r4) goto L_0x039e
            r4 = 0
            r5 = 16
        L_0x031f:
            r7 = 2
            if (r4 >= r7) goto L_0x0389
            r13 = r18[r0]     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            if (r3 >= r13) goto L_0x0389
            r37 = r14[r6]     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            long r7 = (long) r5
            long r37 = r37 & r7
            int r13 = (r37 > r29 ? 1 : (r37 == r29 ? 0 : -1))
            if (r13 == 0) goto L_0x0357
            double[] r13 = r15.segp     // Catch:{ IOException -> 0x0352, Exception -> 0x034d }
            r37 = r14[r6]     // Catch:{ IOException -> 0x0352, Exception -> 0x034d }
            long r37 = r37 + r7
            long r37 = r37 / r7
            r32 = r3
            long r2 = r37 / r27
            double r2 = (double) r2     // Catch:{ IOException -> 0x0352, Exception -> 0x034d }
            r37 = r10
            r34 = r11
            double r10 = r15.rmax     // Catch:{ IOException -> 0x0352, Exception -> 0x034d }
            double r2 = r2 * r10
            double r2 = r2 / r23
            double r2 = r2 / r25
            double r2 = -r2
            r13[r22] = r2     // Catch:{ IOException -> 0x0352, Exception -> 0x034d }
            r3 = r12
            goto L_0x0370
        L_0x034d:
            r0 = move-exception
            r7 = r41
            goto L_0x048d
        L_0x0352:
            r0 = move-exception
            r7 = r41
            goto L_0x04b4
        L_0x0357:
            r32 = r3
            r37 = r10
            r34 = r11
            double[] r2 = r15.segp     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            r10 = r14[r6]     // Catch:{ IOException -> 0x03ad, Exception -> 0x03a7 }
            long r10 = r10 / r7
            long r10 = r10 / r27
            double r10 = (double) r10
            r3 = r12
            double r12 = r15.rmax     // Catch:{ IOException -> 0x0387, Exception -> 0x044c }
            double r10 = r10 * r12
            double r10 = r10 / r23
            double r10 = r10 / r25
            r2[r22] = r10     // Catch:{ IOException -> 0x0387, Exception -> 0x044c }
        L_0x0370:
            int r4 = r4 + 1
            int r2 = r32 + 1
            int r22 = r22 + 1
            r10 = r14[r6]     // Catch:{ IOException -> 0x0387, Exception -> 0x044c }
            long r10 = r10 % r7
            r14[r6] = r10     // Catch:{ IOException -> 0x0387, Exception -> 0x044c }
            int r5 = r5 / 16
            r8 = r41
            r12 = r3
            r11 = r34
            r10 = r37
            r3 = r2
            r2 = 1
            goto L_0x031f
        L_0x0387:
            r0 = move-exception
            goto L_0x03af
        L_0x0389:
            r32 = r3
            r37 = r10
            r34 = r11
            r3 = r12
            int r6 = r6 + 1
            r2 = 1
            r8 = r41
            r12 = r3
            r3 = r32
            r11 = r34
            r10 = r37
            goto L_0x0316
        L_0x039e:
            r37 = r10
            r34 = r11
            r3 = r12
            r7 = r41
            goto L_0x0455
        L_0x03a7:
            r0 = move-exception
            r3 = r12
        L_0x03a9:
            r7 = r41
            goto L_0x048e
        L_0x03ad:
            r0 = move-exception
            r3 = r12
        L_0x03af:
            r7 = r41
        L_0x03b1:
            r5 = r9
            goto L_0x04b6
        L_0x03b4:
            r37 = r10
            r34 = r11
            r3 = r12
            r1 = 5
            if (r0 != r1) goto L_0x0453
            r2 = r18[r0]     // Catch:{ IOException -> 0x044f, Exception -> 0x044c }
            r4 = 3
            int r2 = r2 + r4
            r5 = 4
            int r2 = r2 / r5
            r6 = 0
        L_0x03c4:
            if (r6 >= r2) goto L_0x03d9
            r7 = r41
            swisseph.FilePtr r5 = r7.fptr     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            int r5 = r5.readUnsignedByte()     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            long r10 = (long) r5     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            r14[r6] = r10     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            int r6 = r6 + 1
            goto L_0x03c4
        L_0x03d4:
            r0 = move-exception
            goto L_0x048e
        L_0x03d7:
            r0 = move-exception
            goto L_0x03b1
        L_0x03d9:
            r7 = r41
            r5 = 0
            r6 = 0
        L_0x03dd:
            if (r6 >= r2) goto L_0x0455
            r8 = r18[r0]     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            if (r5 >= r8) goto L_0x0455
            r8 = 64
            r8 = 0
            r10 = 64
        L_0x03e8:
            r11 = 4
            if (r8 >= r11) goto L_0x043d
            r12 = r18[r0]     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            if (r5 >= r12) goto L_0x043d
            r12 = r14[r6]     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            r45 = r2
            long r1 = (long) r10
            long r12 = r12 & r1
            int r19 = (r12 > r29 ? 1 : (r12 == r29 ? 0 : -1))
            if (r19 == 0) goto L_0x0414
            double[] r12 = r15.segp     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            r38 = r14[r6]     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            long r38 = r38 + r1
            long r38 = r38 / r1
            r13 = r5
            long r4 = r38 / r27
            double r4 = (double) r4     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            r32 = r12
            double r11 = r15.rmax     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            double r4 = r4 * r11
            double r4 = r4 / r23
            double r4 = r4 / r25
            double r4 = -r4
            r32[r22] = r4     // Catch:{ IOException -> 0x03d7, Exception -> 0x03d4 }
            r5 = r10
            goto L_0x0428
        L_0x0414:
            r13 = r5
            double[] r4 = r15.segp     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            r11 = r14[r6]     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            long r11 = r11 / r1
            long r11 = r11 / r27
            double r11 = (double) r11     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            r5 = r10
            double r9 = r15.rmax     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            double r11 = r11 * r9
            double r11 = r11 / r23
            double r11 = r11 / r25
            r4[r22] = r11     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
        L_0x0428:
            int r8 = r8 + 1
            int r4 = r13 + 1
            int r22 = r22 + 1
            r9 = r14[r6]     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            long r9 = r9 % r1
            r14[r6] = r9     // Catch:{ IOException -> 0x044a, Exception -> 0x03d4 }
            int r10 = r5 / 4
            r2 = r45
            r9 = r47
            r5 = r4
            r1 = 5
            r4 = 3
            goto L_0x03e8
        L_0x043d:
            r45 = r2
            r13 = r5
            int r6 = r6 + 1
            r2 = r45
            r9 = r47
            r5 = r13
            r1 = 5
            r4 = 3
            goto L_0x03dd
        L_0x044a:
            r0 = move-exception
            goto L_0x0488
        L_0x044c:
            r0 = move-exception
            goto L_0x03a9
        L_0x044f:
            r0 = move-exception
            r7 = r41
            goto L_0x0488
        L_0x0453:
            r7 = r41
        L_0x0455:
            int r0 = r0 + 1
            r9 = r47
            r12 = r3
            r8 = r7
            r5 = r31
            r11 = r34
            r7 = r36
            r10 = r37
            r4 = 2
            r6 = 0
            r13 = 3
            r3 = r0
            r0 = r35
            goto L_0x019e
        L_0x046b:
            r35 = r0
            r36 = r7
            r7 = r8
            r37 = r10
            r34 = r11
            r3 = r12
            r33 = 0
            int r5 = r21 + 1
            r9 = r47
            r7 = r36
            r6 = 0
            r13 = 3
            goto L_0x007e
        L_0x0481:
            r7 = r8
            r33 = 0
            return r33
        L_0x0485:
            r0 = move-exception
            r7 = r8
            r3 = r12
        L_0x0488:
            r5 = r47
            goto L_0x04b6
        L_0x048b:
            r0 = move-exception
            r7 = r8
        L_0x048d:
            r3 = r12
        L_0x048e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5 = r47
            r5.append(r0)
            swisseph.SwissephException r6 = new swisseph.SwissephException
            double r1 = r7.tfstart
            r3 = 65
            r4 = -1
            r0 = r6
            r0.<init>((double) r1, (int) r3, (int) r4, (java.lang.StringBuffer) r5)
            throw r6
        L_0x04b2:
            r0 = move-exception
            r7 = r8
        L_0x04b4:
            r5 = r9
            r3 = r12
        L_0x04b6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.append(r0)
            swisseph.SwissephException r6 = new swisseph.SwissephException
            double r1 = r7.tfstart
            r3 = 65
            r4 = -1
            r0 = r6
            r5 = r47
            r0.<init>((double) r1, (int) r3, (int) r4, (java.lang.StringBuffer) r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.FileData.get_new_segment(swisseph.SwissData, double, int, int, java.lang.StringBuffer):int");
    }
}
