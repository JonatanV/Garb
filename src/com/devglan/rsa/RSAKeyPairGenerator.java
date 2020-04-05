package com.devglan.rsa;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.util.*;

//import static com.devglan.rsa.RSAUtil.getPublicKey;

      class RandomString {
         public static Random r;
         public int n;

         // function to generate a random string of length n
         public static String getAlphaNumericString(int n) {
             r = new Random();
             // chose a Character random from this String
             String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                     "abcdefghijklmnopqrstuvxyz"+"0123456789";

             // create StringBuffer size of AlphaNumericString
             StringBuilder sb = new StringBuilder(n);

             for (int i = 0; i < n; i++) {

                 // generate a random number between
                 // 0 to AlphaNumericString variable length
                 int index = (int) (AlphaNumericString.length() * r.nextDouble());

                 // add Character one by one in end of sb
                 sb.append(AlphaNumericString
                         .charAt(index));
             }
             return sb.toString();
         }
     }


public class RSAKeyPairGenerator {


    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        long timeStart;
        long timePassed;
        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
        PublicKey Key= keyPairGenerator.getPublicKey();
        String input;

        keyPairGenerator.writeToFile("RSA/publicKey", keyPairGenerator.getPublicKey().getEncoded());
        keyPairGenerator.writeToFile("RSA/privateKey", keyPairGenerator.getPrivateKey().getEncoded());
        for (int n = 10; n <= 200; n++) {
            timeStart = System.nanoTime();
            for (int i = 0; i < 5; i++) {
                input = RandomString.getAlphaNumericString(8);
                RSAEncrypt.encrypt(input, Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
                }
                timePassed = ((System.nanoTime()-timeStart)/5);
                System.out.println( n + "\t" + timePassed);
            }
        }

    }

