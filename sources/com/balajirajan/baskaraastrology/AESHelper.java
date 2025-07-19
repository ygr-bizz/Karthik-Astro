package com.cuspal.interlinks;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper {
    private static final String HEX = "0123456789ABCDEF";
    private static final byte[] keyValue = {99, 111, 100, 105, 110, 103, 97, 102, 102, 97, 105, 114, 115, 99, 111, 109};

    public static String encrypt(String cleartext) throws Exception {
        return toHex(encrypt(getRawKey(), cleartext.getBytes()));
    }

    public static String decrypt(String encrypted) throws Exception {
        return new String(decrypt(toByte(encrypted)));
    }

    private static byte[] getRawKey() throws Exception {
        return new SecretKeySpec(keyValue, "AES").getEncoded();
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKey skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, skeySpec);
        return cipher.doFinal(clear);
    }

    private static byte[] decrypt(byte[] encrypted) throws Exception {
        SecretKey skeySpec = new SecretKeySpec(keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(buf.length * 2);
        for (byte appendHex : buf) {
            appendHex(result, appendHex);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 15));
        sb.append(HEX.charAt(b & 15));
    }

    public static class client {
        private String Name;
        private int bdd;
        private int bhh;
        private int bmi;
        private int bmm;
        private int bse;
        private int byy;

        public client() {
        }

        public client(String Name2, int bdd2, int bmm2, int byy2, int bhh2, int bmi2, int bse2) {
            this.Name = Name2;
            this.bdd = bdd2;
            this.bmm = bmm2;
            this.byy = byy2;
            this.bhh = bhh2;
            this.bmi = bmi2;
            this.bse = bse2;
        }
    }
}
