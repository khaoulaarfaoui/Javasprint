/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import Entities.FosUser;
import Services.FosUerService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author khaoula
 */
public class Authenticator {
    private static FosUser currentAuth ;
    private static final Map<String, FosUser> USERS = new HashMap<String, FosUser>();

    public static FosUser getCurrentAuth() {
        return currentAuth;
    }

    public static void setCurrentAuth(FosUser currentAuth) {
        Authenticator.currentAuth = currentAuth;
    }

    public static boolean validate(String userName, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        loadAuthentificators();
        FosUser validUserPassword = USERS.get(userName);
        if(validUserPassword==null)
            return false;
        else
        currentAuth=validUserPassword;
        //  Cette méthode prend l'utilisateur qui veut s'authentifier et encrypt mot de pass en claire et puis elle vérifie si la hash générer et égale au hash original
        return  FOSJCrypt.checkPassword(validUserPassword.getPassword(),password,validUserPassword.getSalt());
    }
    public static void loadAuthentificators(){
        FosUerService useserv=new FosUerService();
        ArrayList<FosUser> users=useserv.selectAllEnabled();
        for (FosUser utilisateur:
                users) {
            USERS.put(utilisateur.getUsername(),utilisateur);
        }
        System.out.println("Loading authentificators list");
    }
}
