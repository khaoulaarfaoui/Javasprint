/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Entities.Fournisseur;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khaoula
 */
public class FournisseurService {
      private Connection connection = ConnexionBD.getInstance().getCon();
    private static Statement ste=null;
    
    public  FournisseurService() {
     try {
            System.out.println("DataSource.getInstance().getCon()" + ConnexionBD.getInstance().getCon() == null);
            
            ste=ConnexionBD.getInstance().getCon().createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
         public void supprimer(int id) {
        String SQL = "DELETE FROM fournisseur WHERE id = ?";
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
         public void ajouter(Fournisseur user) {
        String req = "INSERT INTO employee (societe, numsociete, secteur, Name ,Last_name ,EntrepriseDate, image) VALUES (?, ?, ?, ?, ?, ?, ? )" ;
        PreparedStatement pre;
        
        try {
            pre = connection.prepareStatement(req);
            pre.setString(1, user.getSociete());
            pre.setInt(2, user.getNumsociete());
            pre.setString(3, user.getSecteur());
            pre.setString(4, user.getName());
            pre.setString(5, user.getLast_name());
            pre.setDate(6, user.getEntreprise_Date());
            pre.setString(7, user.getImage());
            pre.executeUpdate();
            System.out.println("fournisseur ajouter avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public ArrayList<Fournisseur> selectAll() {
        ArrayList<Fournisseur> users = new ArrayList<>();
        ResultSet rs;
        try {
            rs = ste.executeQuery("SELECT * FROM fournisseur");
            users = new ArrayList<>();
            while (rs.next()){
                users.add(new Fournisseur(rs.getInt(1),rs.getInt(2)));
                        //rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getShort(10),rs.getString(11),rs.getString(12),rs.getDate(13),rs.getString(14),rs.getDate(15),serializePHPtoJava(rs.getString(16)),rs.getString(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  users;
    }
                
        public Fournisseur selectOne(int id) {
        Statement ste=null;
        Fournisseur user= new Fournisseur();
        ResultSet rs=null;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery("SELECT * from fournisseur where id="+id);
             while (rs.next()) {
            System.out.println("Name : "
            + rs.getString("Name")
            + ", societe : "
            + rs.getString("societe"));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }  
}
