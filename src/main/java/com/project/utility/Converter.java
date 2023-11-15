package com.project.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Converter {
    
    public Converter(){}
    
    public String toMD5(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
            return hashtext;
        }catch (NoSuchAlgorithmException e) {throw new RuntimeException(e);}
    }
    public String toHour(LocalDateTime input){
        return "'"+input.getHour()+":"+input.getMinute()+":"+input.getSecond()+"'";
    }
}