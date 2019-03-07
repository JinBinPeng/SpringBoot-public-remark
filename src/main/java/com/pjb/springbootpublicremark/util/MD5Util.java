package com.pjb.springbootpublicremark.util;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 */
public class MD5Util {
    private MD5Util() {

    }

    /**
     * 获取指定字符串的MD5码
     *
     * @param s 字符串
     * @return 字符串的MD5码
     */
    public static String getMD5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(strTemp);
            byte[] md = messageDigest.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

}
