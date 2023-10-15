package org.example;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;
import java.util.Base64;

public class test {
    public static void main(String[] args) throws Exception {
        // 특정한 문자열을 기반으로 해시 생성
        String inputString = "3o3TaskShinJunYoung";
        byte[] hashedBytes = sha256Hash(inputString);

        // SHA-256 해시 값을 기반으로 RSA 키 쌍 생성
        KeyPair keyPair = generateKeyPair(hashedBytes);

        // Base64로 인코딩하여 출력
        String publicKeyBase64 = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKeyBase64 = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

        // Base64로 인코딩된 키 출력
        System.out.println("Public Key (Base64): " + publicKeyBase64);
        System.out.println("Private Key (Base64): " + privateKeyBase64);
    }

    private static byte[] sha256Hash(String input) throws Exception {
        java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));
        return hash;
    }

    private static KeyPair generateKeyPair(byte[] seed) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new java.security.SecureRandom(seed));
        return keyPairGenerator.generateKeyPair();
    }
}
