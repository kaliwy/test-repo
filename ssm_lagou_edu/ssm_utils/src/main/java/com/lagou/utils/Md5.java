package com.lagou.utils;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * @program: com.lagou.utils
 * @description: MD5
 * @author: 霂惷
 */
public class Md5 {
    private final static String str = "lagou";
    public static String md5(String password, String str){
        String encodeStr = DigestUtils.md5Hex(password + str);
        return encodeStr;
    }
    public static boolean verify(String password,String key, String encodeStr){
         if(encodeStr.equalsIgnoreCase(md5(password , key))){
            return true;
         }
         return false;

    }
}
