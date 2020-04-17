/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasprint;

import Services.JavaMailUtil;
import Entities.FosUser;
import Security.FOSJCrypt;
import Services.FosUerService;
import Utils.ConnexionBD;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author khaoula
 */
public class JAVASPRINT  extends Application {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("READ_EMP.fxml"));
        Scene scene = new Scene(root);
 
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) throws Exception { 
        
      //  JavaMailUtil.sendMail("alarfaouikhaoula@gmail.com");

            //throws NoSuchAlgorithmException, UnsupportedEncodingException {
       // boolean test =FOSJCrypt.checkPassword("123","$2y$12$f8lPIEQ5bKqWBXPqbfKyGebVsN9flIh4eC8CBMFTkuMGf WrB0C7ua");
        //System.out.println("test is "+ test);
    launch(args);   
    //  FosUerService e=new FosUerService();
     // ConnexionBD.getInstance();
     // FosUser f= new FosUser("testjava","test@java.tn","1234","ROLE_CLIENT","test","java"); 
      //e.ajouter(f);
        //e.modifier(17,f);
       // e.selectOne(10);
        //e.selectAll().forEach(System.out::println);
        
       //  e.supprimer(1);
        // TODO code application logic here
      /* 
        ConnexionBD.dbConnexion();
         System.out.println("aaaa"); 
       FosUerService.insererUtilisateur(f);
        System.out.println("aaaa"); 
        System.out.println(f);        
       // Employee emp= new Employee(2,"aaa","bbb","ccc","aaa",date);
*/
    
    
}}
