/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;
import com.google.common.io.BaseEncoding;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.common.primitives.Bytes;


import java.security.SecureRandom;
import java.util.Base64;
/**
 *
 * @author khaoula
 */
public class FOSJCrypt {
     private static final String ALGORITHM = "SHA-512";
    private static final int ITERATIONS = 5000;
    private static final int SALT_SIZE = 32;


    /**
     * Private constructor.
     */
    private FOSJCrypt() {
    }
    public static Sha512 crypt(String clairPass) {
        String gs=generateSalt();
        try {
            byte[] hash = encodePassword(clairPass, gs);
            return passwordToPersist(hash, clairPass, gs);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * tgeneri salt kif al yasn3ou fosuser(bel algorrithm par défaut :sh512)
     * igeneri 32 byte et y7awelhom en base64
     * ibadel el + bel .
     * ine7i el char el le5er
     * @return
     */
    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);
        String saltBase64_encoded=BaseEncoding.base64().encode(salt);
        String saltPlusDot= saltBase64_encoded.replace("+",".");
        return saltPlusDot.substring(0,saltPlusDot.length()-1);
    }

    /**
     * 4999 itération dans la boucles une seul avant la boucle
     * 1ére : fait merge passwrd et sal par méthode
     * dans la boucle il réutilise le hash précédant pour générer le nouveau message en clair
     * @param password
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static byte[] encodePassword(String password,String salt) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        String mergedPasswordAndSalt =mergePasswordAndSalt(password, salt);
        MessageDigest digester = MessageDigest.getInstance(ALGORITHM);
        byte[] hash = digester.digest(mergedPasswordAndSalt .getBytes("UTF-8"));
        for (int i = 1; i < ITERATIONS; ++i) {
            hash = digester.digest(Bytes.concat(hash, mergedPasswordAndSalt.getBytes("UTF-8")));
        }
        return hash;
    }

    /**
     * i7ot des accolade mnloul welle5er mta3 salt
     * @param pass
     * @param salt
     * @return
     */
    private static String mergePasswordAndSalt(String pass, String salt) {
        if (salt == null) {
            return salt;
        }
        String cg="{";String cd="}";
        return pass+cg+salt+cd;
    }
    /*
     *  paramétre: originalHash el hash ala mel base de donnés mais en byte donc lazem el hash ala en String tetbadel bytes
     */
    public static   boolean verifyPassword(byte[] originalHash, String passwordClair, String salt) throws
            NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] comparisonHash = encodePassword(passwordClair, salt);
        return comparePasswords(originalHash, comparisonHash);
    }
    private static Sha512 passwordToPersist(byte[] originalHash, String password, String salt) throws
            NoSuchAlgorithmException, UnsupportedEncodingException {
        Sha512 sh=new Sha512();
//        byte[] comparisonHash = encodePassword(password, salt);
        sh.setSalt(salt);sh.setHash(BaseEncoding.base64().encode(originalHash));
        return sh;
    }
    private static boolean comparePasswords(byte[] originalHash, byte[] comparisonHash) {
        int diff = originalHash.length ^ comparisonHash.length;
        for (int i = 0; i < originalHash.length && i < comparisonHash.length; i++) {
            diff |= originalHash[i] ^ comparisonHash[i];
        }

        return diff == 0;
    }

    public static boolean checkPassword(String originalHashStr, String passwordClair,String salt) throws
            NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] comparisonHash = encodePassword(passwordClair, salt);
        System.out.println();
        byte[] originalHash = Base64.getDecoder().decode(originalHashStr.getBytes("UTF-8"));
        return comparePasswords(originalHash, comparisonHash);
    }
}
