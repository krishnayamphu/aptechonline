package com.aptech;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTest {
    public static void main(String[] args) {
        MessageDigest digest = null;
        try {
            String pw = "123";
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(pw.getBytes());
            byte[] hash = digest.digest();
            System.out.println(hash);

            //Converting the byte array in to HexString format
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
            System.out.println("Hex format : " + hexString.toString());

            System.out.println(hexString.toString().equals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
