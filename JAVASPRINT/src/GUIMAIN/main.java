/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMAIN;

import Entities.FosUser;
import Security.Authenticator;
import Services.FosUerService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author khaoula
 */
public class main {
        private FosUser loggedUser = new FosUser();
 public boolean userLogging(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        FosUerService us=new FosUerService();
        if (Authenticator.validate(username, password)) {
            loggedUser = Authenticator.getCurrentAuth();
            return true;
        } else {
            return false;
        }
    }
}
