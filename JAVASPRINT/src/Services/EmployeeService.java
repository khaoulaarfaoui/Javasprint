/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Entities.FosUser;
import Utils.ConnexionBD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
    public void ajouter(Employee user) throws FileNotFoundException {
        String req = "INSERT INTO employee (fonction, Name, Last_name, Birth_Date, image, email) VALUES (?, ?, ?, ?, ?, ?)" ;
        PreparedStatement pre;
           //InputStream is = new FileInputStream(user.getEmail());
           
        try {
            pre = connection.prepareStatement(req);
            pre.setString(1, user.getFonction());
            pre.setString(2, user.getName());
            pre.setString(3, user.getLast_name());
            pre.setDate(4, user.getBirth_Date());
            pre.setString(5,user.getImage());
            pre.setString(6, user.getEmail());
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
            
            rs = ste.executeQuery("SELECT id, fonction, Name, Last_name, Birth_Date, image, email FROM employee");
       
            users = new ArrayList<>();
            while (rs.next()){
               
       users.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7)));
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
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }  

        public void editUser(Employee u) throws SQLException {
              try{
            String query = "update `employee` set fonction =?,Name = ? , Last_name =? , Birth_Date =? , image =?, email=?  where id =?  ;";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, u.getFonction());
            st.setString(2, u.getName());
            st.setString(3, u.getLast_name());
            st.setDate(4, u.getBirth_Date());
            st.setString(5, u.getImage());
            st.setString(6, u.getEmail());
           
            st.setString(7,String.valueOf(u.getId()));

            st.execute();
            System.out.println("Changes saved successfully !");

        }
    catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
