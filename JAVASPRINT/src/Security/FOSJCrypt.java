/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;


import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.bcrypt.BCrypt;



/**
 *
 * @author khaoula
 */
public class FOSJCrypt {

    private static final int SALT_SIZE = 32;


    /**
     * Private constructor.
     */
    private FOSJCrypt() {
    }
   
  
    public  static String generateHash(String plainTextPassword) {
        String salt = BCrypt.gensalt(13);
        String thashed_password = BCrypt.hashpw(plainTextPassword, salt);
       String hashed_password = thashed_password.substring(0, 2) + 'y' + thashed_password.substring(3);
       return hashed_password;
    }

   

    public static boolean checkPassword( String passwordClair,String hashedPassword) throws
            NoSuchAlgorithmException, UnsupportedEncodingException {
            String  hashedpassword = hashedPassword.substring(0, 2) + 'a' + hashedPassword.substring(3);
      return BCrypt.checkpw(passwordClair, hashedpassword); 
    }
}