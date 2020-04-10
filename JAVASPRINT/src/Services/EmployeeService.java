/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Entities.FosUser;
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
public class EmployeeService {
      private Connection connection = ConnexionBD.getInstance().getCon();
    private static Statement ste=null;
    
    public  EmployeeService() {
     try {
            System.out.println("DataSource.getInstance().getCon()" + ConnexionBD.getInstance().getCon() == null);
            
            ste=ConnexionBD.getInstance().getCon().createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
       public void supprimer(int id) {
        String SQL = "DELETE FROM employee WHERE id = ?";
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
    public void ajouter(Employee user) {
        String req = "INSERT INTO employee (fonction, Name, Last_name, Birth_Date,image) VALUES (?, ?, ?, ?, ?)" ;
        PreparedStatement pre;
        
        try {
            pre = connection.prepareStatement(req);
            pre.setString(1, user.getFonction());
            pre.setString(2, user.getName());
            pre.setString(3, user.getLast_name());
            pre.setDate(4, user.getBirth_Date());
            pre.setString(5, user.getImage());
            pre.executeUpdate();
            System.out.println("Employee ajouter avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
          public ArrayList<Employee> selectAll() {
        ArrayList<Employee> users = new ArrayList<>();
        ResultSet rs;
        try {
            rs = ste.executeQuery("SELECT * FROM employee");
            users = new ArrayList<>();
            while (rs.next()){
                users.add(new Employee(rs.getInt(1),rs.getString(2)));
                        //rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getShort(10),rs.getString(11),rs.getString(12),rs.getDate(13),rs.getString(14),rs.getDate(15),serializePHPtoJava(rs.getString(16)),rs.getString(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  users;
    } 
          
        public Employee selectOne(int id) {
        Statement ste=null;
        Employee user= new Employee();
        ResultSet rs=null;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery("SELECT * from employee where id="+id);
             while (rs.next()) {
            System.out.println("Name : "
            + rs.getString("first_name")
            + ", prenom : "
            + rs.getString("Last_name"));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }  
        public void modifier(int id, FosUser user) {
        String requete="UPDATE employee set "
                + "fonction=?,Name=?,Last_name=?,Birth_Date=?,image=?"
               + "where id=?";
        PreparedStatement pre=null;
        try {
            System.out.println(user);
            pre = connection.prepareStatement(requete);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getUsernameCanonical());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getEmailCanonical());
            pre.setBoolean(5, user.getEnabled());
            pre.setString(6, user.getSalt());
            pre.setString(7, user.getPassword());
       
            if(id==user.getId())
            pre.setInt(8, id);
            else System.out.println("be carfull error id ");
            pre.executeUpdate();
            System.out.println("Employee Modifier avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
