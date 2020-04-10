/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasprint;

import Entities.Employee;
import Entities.FosUser;
import Services.FosUerService;
import Utils.ConnexionBD;
import java.sql.Date;

/**
 *
 * @author khaoula
 */
public class JAVASPRINT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FosUerService e=new FosUerService();
        ConnexionBD.getInstance();
        FosUser f= new FosUser("khooooo","hama","aa@aa.tn","aa@aa.tn",true,"NULL","aaa","ROLE_CLIENT","hma","hma"); 

        e.modifier(17,f);
       // e.selectOne(10);
        //e.selectAll().forEach(System.out::println);
       // e.ajouter(f);
      //   e.supprimer(1);
        // TODO code application logic here
      /* 
        ConnexionBD.dbConnexion();

         System.out.println("aaaa"); 
       FosUerService.insererUtilisateur(f);
        System.out.println("aaaa"); 
        System.out.println(f);        
       // Employee emp= new Employee(2,"aaa","bbb","ccc","aaa",date);
*/
    }
    
}
