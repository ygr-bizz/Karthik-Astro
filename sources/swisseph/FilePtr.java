package swisseph;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class FilePtr implements Serializable {
    private static final int MAX_FAILURES = 100;
    private static final int STRING_BUFFER_SIZE = 200;
    public static final String useragent = "swisseph-java-2.00.00_01";
    private int BUFSIZE;
    private boolean bigendian = true;
    private byte[] data;
    private long endIdx = -1;
    String fnamp;
    transient RandomAccessFile fp;
    private long fpos = 0;
    private String host;
    private byte[] inbuf;
    transient InputStream is;
    transient BufferedOutputStream os;
    private int port;
    private long savedLength = -1;
    transient Socket sk;
    private long startIdx = -1;
    private boolean useHTTP;

    public FilePtr(RandomAccessFile randomAccessFile, Socket socket, InputStream inputStream, BufferedOutputStream bufferedOutputStream, String str, long j, int i) throws IOException {
        this.fp = randomAccessFile;
        this.sk = socket;
        this.is = inputStream;
        this.os = bufferedOutputStream;
        this.fnamp = str;
        this.savedLength = j;
        this.BUFSIZE = i;
        boolean startsWith = str.startsWith("http://");
        this.useHTTP = startsWith;
        int i2 = this.BUFSIZE;
        this.data = new byte[i2];
        this.inbuf = new byte[i2];
        if (startsWith && randomAccessFile == null) {
            try {
                URL url = new URL(str);
                this.host = url.getHost();
                int port2 = url.getPort();
                this.port = port2;
                if (port2 < 0) {
                    this.port = 80;
                }
            } catch (MalformedURLException e) {
                throw new IOException("Malformed URL '" + str + "'");
            }
        }
    }

    public void setBigendian(boolean z) {
        this.bigendian = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r2 <= r5.endIdx) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte readByte() throws java.io.IOException, java.io.EOFException {
        /*
            r5 = this;
            long r0 = r5.startIdx
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0014
            long r2 = r5.fpos
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x0014
            long r0 = r5.endIdx
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0017
        L_0x0014:
            r5.readToBuffer()
        L_0x0017:
            long r0 = r5.fpos
            r2 = 1
            long r0 = r0 + r2
            r5.fpos = r0
            byte[] r4 = r5.data
            long r0 = r0 - r2
            long r2 = r5.startIdx
            long r0 = r0 - r2
            int r1 = (int) r0
            byte r0 = r4[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.FilePtr.readByte():byte");
    }

    public int readUnsignedByte() throws IOException, EOFException {
        return readByte() & 255;
    }

    public short readShort() throws IOException, EOFException {
        if (this.bigendian) {
            return (short) ((readByte() << 8) + readUnsignedByte());
        }
        return (short) (readUnsignedByte() + (readByte() << 8));
    }

    public int readInt() throws IOException, EOFException {
        if (this.bigendian) {
            return (readByte() << 24) + (readUnsignedByte() << 16) + (readUnsignedByte() << 8) + readUnsignedByte();
        }
        return readUnsignedByte() + (readUnsignedByte() << 8) + (readUnsignedByte() << 16) + (readByte() << 24);
    }

    public double readDouble() throws IOException, EOFException {
        long j;
        if (this.bigendian) {
            j = (((long) readUnsignedByte()) << 56) + (((long) readUnsignedByte()) << 48) + (((long) readUnsignedByte()) << 40) + (((long) readUnsignedByte()) << 32) + (((long) readUnsignedByte()) << 24) + (((long) readUnsignedByte()) << 16) + (((long) readUnsignedByte()) << 8) + ((long) readUnsignedByte());
        } else {
            j = (((long) readUnsignedByte()) << 56) + ((long) readUnsignedByte()) + (((long) readUnsignedByte()) << 8) + (((long) readUnsignedByte()) << 16) + (((long) readUnsignedByte()) << 24) + (((long) readUnsignedByte()) << 32) + (((long) readUnsignedByte()) << 40) + (((long) readUnsignedByte()) << 48);
        }
        return Double.longBitsToDouble(j);
    }

    public String readLine() throws IOException, EOFException {
        char readUnsignedByte;
        StringBuffer stringBuffer = new StringBuffer(200);
        while (true) {
            try {
                readUnsignedByte = (char) readUnsignedByte();
                if (readUnsignedByte == 10) {
                    break;
                }
                stringBuffer.append(readUnsignedByte);
            } catch (EOFException e) {
                if (stringBuffer.length() == 0) {
                    throw e;
                }
            }
        }
        stringBuffer.append(readUnsignedByte);
        return stringBuffer.toString();
    }

    public void close() throws IOException {
        try {
            this.fnamp = "";
            RandomAccessFile randomAccessFile = this.fp;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.fp = null;
            Socket socket = this.sk;
            if (socket != null) {
                socket.close();
            }
            this.sk = null;
            this.is = null;
            this.os = null;
        } catch (IOException e) {
            try {
                Socket socket2 = this.sk;
                if (socket2 != null) {
                    socket2.close();
                }
                this.sk = null;
                this.is = null;
                this.os = null;
                throw e;
            } catch (IOException e2) {
                throw e2;
            }
        }
    }

    public long getFilePointer() {
        return this.fpos;
    }

    public long length() throws IOException {
        RandomAccessFile randomAccessFile = this.fp;
        if (randomAccessFile != null && this.savedLength < 0) {
            this.savedLength = randomAccessFile.length();
        }
        if (this.fp != null || this.savedLength >= 0 || !this.useHTTP) {
            return this.savedLength;
        }
        String str = "HEAD " + this.fnamp + " HTTP/1.1\r\n" + "User-Agent: " + useragent + "\r\n" + "Host: " + this.host + ":" + this.port + "\r\n\r\n";
        int i = 0;
        while (true) {
            try {
                URLwrite(this.os, str);
                String URLread = URLread(this.is);
                int checkHeader = checkHeader(URLread);
                if (checkHeader < 0) {
                    i++;
                    if (i < 100) {
                        reconnect();
                    } else {
                        throw new IOException("Failed to read a valid / complete header.");
                    }
                } else {
                    int indexOf = URLread.indexOf("Content-Length:");
                    if (checkHeader != 200 || URLread.indexOf("Content-Length:") < 0) {
                        throw new IOException("Can't determine length of (HTTP-)file '" + this.fnamp + "'. HTTP error code: " + checkHeader);
                    }
                    String substring = URLread.substring(indexOf + "Content-Length:".length());
                    return Long.parseLong(substring.substring(0, substring.indexOf("\n")).trim());
                }
            } catch (IOException e) {
                i++;
                if (i < 100) {
                    reconnect();
                } else {
                    throw new IOException("(java.net.SocketException) " + e.getMessage());
                }
            }
        }
    }

    public void seek(long j) {
        this.fpos = j;
    }

    private String URLread(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(this.BUFSIZE);
        int read = inputStream.read();
        if (read != -1) {
            stringBuffer.append((char) read);
            while (inputStream.available() > 0) {
                stringBuffer.append((char) inputStream.read());
            }
            return stringBuffer.toString();
        }
        throw new IOException("No bytes available.");
    }

    private void URLwrite(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            bufferedOutputStream.write((byte) str.charAt(i));
        }
        bufferedOutputStream.flush();
    }

    private String htmlStrip(String str) {
        int indexOf = str.indexOf("\r\n\r\n");
        if (indexOf >= 0) {
            return str.substring(indexOf + 4);
        }
        return "";
    }

    private int checkHeader(String str) {
        try {
            int indexOf = str.indexOf(" ");
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(" ", i);
            if (indexOf >= 0 && indexOf2 >= 0 && indexOf >= 8) {
                if (indexOf + 4 == indexOf2) {
                    return Integer.parseInt(str.substring(i, indexOf2));
                }
            }
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readToBuffer() throws java.io.IOException, java.io.EOFException {
        /*
            r19 = this;
            r1 = r19
            java.io.RandomAccessFile r0 = r1.fp
            java.lang.String r3 = " byte(s)."
            java.lang.String r4 = "Filepointer position "
            r5 = 1
            if (r0 == 0) goto L_0x0063
            long r7 = r1.fpos
            r0.seek(r7)
            java.io.RandomAccessFile r0 = r1.fp
            byte[] r7 = r1.inbuf
            int r0 = r0.read(r7)
            r7 = -1
            if (r0 == r7) goto L_0x0034
            r2 = 0
        L_0x001d:
            if (r2 >= r0) goto L_0x002a
            byte[] r3 = r1.data
            byte[] r4 = r1.inbuf
            byte r4 = r4[r2]
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x001d
        L_0x002a:
            long r2 = r1.fpos
            r1.startIdx = r2
            long r7 = (long) r0
            long r2 = r2 + r7
            long r2 = r2 - r5
            r1.endIdx = r2
            return
        L_0x0034:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            long r7 = r1.fpos
            r2.append(r7)
            java.lang.String r4 = " exceeds file"
            r2.append(r4)
            java.lang.String r4 = " length by "
            r2.append(r4)
            long r7 = r1.fpos
            long r9 = r19.length()
            long r7 = r7 - r9
            long r7 = r7 + r5
            r2.append(r7)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0063:
            long r7 = r1.fpos
            long r9 = r19.length()
            java.lang.String r11 = "length by "
            java.lang.String r12 = " exceeds file "
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x0203
            boolean r0 = r1.useHTTP
            if (r0 != 0) goto L_0x0076
            return
        L_0x0076:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "GET "
            r0.append(r7)
            java.lang.String r7 = r1.fnamp
            r0.append(r7)
            java.lang.String r7 = " HTTP/1.1\r\n"
            r0.append(r7)
            java.lang.String r7 = "User-Agent: "
            r0.append(r7)
            java.lang.String r7 = "swisseph-java-2.00.00_01"
            r0.append(r7)
            java.lang.String r7 = "\r\n"
            r0.append(r7)
            java.lang.String r8 = "Host: "
            r0.append(r8)
            java.lang.String r8 = r1.host
            r0.append(r8)
            java.lang.String r8 = ":"
            r0.append(r8)
            int r8 = r1.port
            r0.append(r8)
            r0.append(r7)
            java.lang.String r7 = "Range: bytes="
            r0.append(r7)
            long r7 = r1.fpos
            r0.append(r7)
            java.lang.String r7 = "-"
            r0.append(r7)
            long r7 = r19.length()
            long r7 = r7 - r5
            long r9 = r1.fpos
            int r13 = r1.BUFSIZE
            long r13 = (long) r13
            long r9 = r9 + r13
            long r9 = r9 - r5
            long r7 = swisseph.SMath.min((long) r7, (long) r9)
            r0.append(r7)
            java.lang.String r7 = "\r\n\r\n"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8 = 0
        L_0x00de:
            r9 = 100
            java.io.BufferedOutputStream r0 = r1.os     // Catch:{ IOException -> 0x01dc }
            r1.URLwrite(r0, r7)     // Catch:{ IOException -> 0x01dc }
            java.io.InputStream r0 = r1.is     // Catch:{ IOException -> 0x01dc }
            java.lang.String r0 = r1.URLread(r0)     // Catch:{ IOException -> 0x01dc }
            int r10 = r1.checkHeader(r0)
            if (r10 >= 0) goto L_0x0124
            int r8 = r8 + 1
            if (r8 >= r9) goto L_0x00f7
            goto L_0x00de
        L_0x00f7:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to read successfully from address\n'"
            r3.append(r4)
            java.lang.String r4 = r1.fnamp
            r3.append(r4)
            java.lang.String r4 = "'. The http reply from the server was "
            r3.append(r4)
            int r4 = r0.length()
            r3.append(r4)
            java.lang.String r4 = " bytes long and it's content is:\n\n"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0124:
            java.lang.String r0 = r1.htmlStrip(r0)
            int r13 = r0.length()
            r14 = 200(0xc8, float:2.8E-43)
            if (r10 == r14) goto L_0x0134
            r14 = 206(0xce, float:2.89E-43)
            if (r10 != r14) goto L_0x01a6
        L_0x0134:
            int r14 = r1.BUFSIZE
            if (r13 > r14) goto L_0x01a6
            if (r13 >= r14) goto L_0x014f
            long r14 = r1.savedLength
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x014f
            r17 = r3
            long r2 = r1.fpos
            long r5 = (long) r13
            long r2 = r2 + r5
            int r5 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x0151
            r3 = r17
            goto L_0x01a6
        L_0x014f:
            r17 = r3
        L_0x0151:
            if (r13 != 0) goto L_0x018b
            int r8 = r8 + 1
            if (r8 >= r9) goto L_0x015c
            r3 = r17
            r5 = 1
            goto L_0x00de
        L_0x015c:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            long r3 = r1.fpos
            r2.append(r3)
            r2.append(r12)
            r2.append(r11)
            long r3 = r1.fpos
            long r5 = r19.length()
            long r3 = r3 - r5
            r5 = 1
            long r3 = r3 + r5
            r2.append(r3)
            r3 = r17
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x018b:
            long r2 = r1.fpos
            r1.startIdx = r2
            long r4 = (long) r13
            long r2 = r2 + r4
            r4 = 1
            long r2 = r2 - r4
            r1.endIdx = r2
            r2 = 0
        L_0x0197:
            if (r2 >= r13) goto L_0x01a5
            byte[] r3 = r1.data
            char r4 = r0.charAt(r2)
            byte r4 = (byte) r4
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x0197
        L_0x01a5:
            return
        L_0x01a6:
            int r8 = r8 + 1
            if (r8 >= r9) goto L_0x01ae
            r5 = 1
            goto L_0x00de
        L_0x01ae:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "HTTP read failed with HTTP response "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = ". Read "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = " bytes, requested "
            r2.append(r3)
            int r3 = r1.BUFSIZE
            r2.append(r3)
            java.lang.String r3 = " bytes."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01dc:
            r0 = move-exception
            int r8 = r8 + 1
            if (r8 >= r9) goto L_0x01e8
            r19.reconnect()
            r5 = 1
            goto L_0x00de
        L_0x01e8:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "(java.net.SocketException) "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0203:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            long r4 = r1.fpos
            r2.append(r4)
            r2.append(r12)
            r2.append(r11)
            long r4 = r1.fpos
            long r6 = r19.length()
            long r4 = r4 - r6
            r6 = 1
            long r4 = r4 + r6
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: swisseph.FilePtr.readToBuffer():void");
    }

    private void reconnect() throws IOException {
        System.err.println("reconnecting...");
        this.sk.close();
        Socket socket = new Socket(this.host, this.port);
        this.sk = socket;
        socket.setSoTimeout(5000);
        this.is = this.sk.getInputStream();
        this.os = new BufferedOutputStream(this.sk.getOutputStream());
    }
}
