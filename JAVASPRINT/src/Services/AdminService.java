/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khaoula
 */
public class AdminService {
    private Connection connection = ConnexionBD.getInstance().getCon();
    private static Statement ste=null;
    
    public  AdminService() {
     try {
            System.out.println("DataSource.getInstance().getCon()" + ConnexionBD.getInstance().getCon() == null);
            
            ste=ConnexionBD.getInstance().getCon().createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void supprimer(int id) {
        String SQL = "DELETE FROM admin WHERE id = ?";
        PreparedStatement pre = null;
        try {
            // get a connection and then in your try catch for executing your delete...
            pre = connection.prepareStatement(SQL);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    }
  
     
     

