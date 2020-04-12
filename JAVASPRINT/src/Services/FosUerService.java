/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.FosUser;
import Security.FOSJCrypt;
import Util.SerializedPhpParser;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
//import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author khaoula
 */
public class FosUerService {

    private Connection connection = ConnexionBD.getInstance().getCon();
    private static Statement ste=null;
    
    public  FosUerService() {
     try {
            System.out.println("DataSource.getInstance().getCon()" + ConnexionBD.getInstance().getCon() == null);
            
            ste=ConnexionBD.getInstance().getCon().createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        

   public void supprimer(int id) {
        String SQL = "DELETE FROM fos_user WHERE id = ?";
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(SQL);
            pre.setString(1,String.valueOf(id));
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
  //2eme methode Ajout 
    public void ajouter(FosUser user) {
        String req = "INSERT INTO fos_user (username, username_canonical, email, email_canonical, enabled, salt, password, last_login, roles,last_name,first_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
        PreparedStatement pre;
        String pwd= FOSJCrypt.generateHash(user.getPassword());
        String usernameCanoical =user.getUsername().toLowerCase();
        String EmailCanonical =user.getEmail().toLowerCase();
     
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        
        try {
            pre = connection.prepareStatement(req);
            pre.setString(1, user.getUsername());
            pre.setString(2, usernameCanoical);
            pre.setString(3, user.getEmail());
            pre.setString(4, EmailCanonical );
            pre.setShort(5,(short)1);
            pre.setString(6, user.getSalt());
            pre.setString(7, pwd);
            pre.setString(8,dateFormat.format(date));
  
            if(user.getRoles().equals("ROLE_CLIENT"))
                pre.setString(9,"a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            else 
             if(user.getRoles().equals("ROLE_ADMIN"))
                pre.setString(9,"a:1:{i:0;s:5:\"ROLE_ADMIN\";}");
            else
            if(user.getRoles().equals("ROLE_Employee"))
                pre.setString(9,"a:1:{i:0;s:13:\"ROLE_EmployeeT\";}");
                pre.setString(10, user.getFirstName());
                pre.setString(11, user.getLastName());  
            pre.executeUpdate();
            System.out.println("Utilisateur ajouter avec succés");
        } 
        catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //3eme methode 
     public ArrayList<FosUser> selectAll() {
        ArrayList<FosUser> users = new ArrayList<>();
        ResultSet rs;
        try {
            rs = ste.executeQuery("SELECT * FROM fos_user");
            users = new ArrayList<>();
            while (rs.next()){
             users.add(new FosUser(rs.getInt(1),rs.getString(2)));
                        //rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getShort(10),rs.getString(11),rs.getString(12),rs.getDate(13),rs.getString(14),rs.getDate(15),serializePHPtoJava(rs.getString(16)),rs.getString(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  users;
    } 
    
    
     /* public String serializePHPtoJava(String role_role){
        String strResultat ="";
        if (role_role!=null) {
            SerializedPhpParser serializedPhpParser = new SerializedPhpParser(role_role);
            Object result = serializedPhpParser.parse();
             strResultat = result.toString();
            strResultat= strResultat.substring(3,strResultat.length()-1);
        }
        return strResultat;
    }
    
    */
    //4eme methode 
        public FosUser selectOne(int id) {
        Statement ste=null;
        FosUser user= new FosUser();
        ResultSet rs=null;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery("SELECT * from fos_user where id="+id);
             while (rs.next()) {
            System.out.println("nom : "
            + rs.getString("first_name")
            + ", prenom : "
            + rs.getString("last_name"));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }   

    
    
     public void modifier(int id, FosUser user) {
        String requete="UPDATE fos_user set "
                + "username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
                + "salt=?,password=?,roles=?,prenom=? where id=?";
        PreparedStatement pre=null;
        try {
            System.out.println(user);
            pre = connection.prepareStatement(requete);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getUsernameCanonical());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getEmailCanonical());
            pre.setShort(5, user.getEnabled());
            pre.setString(6, user.getSalt());
            pre.setString(7, user.getPassword());
            if(user.getRoles().equals("ROLE_CLIENT"))
                pre.setString(8,"a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            else
            if(user.getRoles().equals("ROLE_Employee"))
                pre.setString(8,"a:1:{i:0;s:18:\"ROLE_EmployeeT\";}");
                pre.setString(9, user.getFirstName());
                pre.setString(10, user.getLastName());
            if(id==user.getId())
            pre.setInt(11, id);
            else System.out.println("be carfull error id ");
            pre.executeUpdate();
            System.out.println("Utilisateur Modifier avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String serializePHPtoJava(String role_role){
        String strResultat ="";
        if (role_role!=null) {
            SerializedPhpParser serializedPhpParser = new SerializedPhpParser(role_role);
            Object result = serializedPhpParser.parse();
             strResultat = result.toString();
            strResultat= strResultat.substring(3,strResultat.length()-1);
        }
        return strResultat;
    }
     
        public ArrayList<FosUser> selectAllEnabled() {
         ArrayList<FosUser> users = new ArrayList<>();
        ResultSet rs;
        try {
            rs = ste.executeQuery("SELECT * FROM utilisateur where enabled=1");
            users = new ArrayList<>();
            while (rs.next()){
users.add(new FosUser(rs.getInt(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getShort(6),
        rs.getString(7),
        rs.getString(8),
        rs.getDate(9),
        rs.getString(10),
        rs.getDate(11),
        serializePHPtoJava(rs.getString(12)),
        rs.getString(13),rs.getString(14)));
                //users.add(new FosUser(rs.getInt(1),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getShort(10),rs.getString(11),rs.getString(12),rs.getDate(13),rs.getString(14),rs.getDate(15),serializePHPtoJava(rs.getString(16)),rs.getString(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  users;
    }

     /* public FosUser getUserByUsername(String username) {
        try {
            String req = "select * from fos_user where username=?";
            FosUser u = null;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                u = FosUser.createUser(rs);
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public FosUser login(String username, String password) throws SQLException {
        String query = "SELECT * FROM fos_user WHERE email = ?";
        PreparedStatement preparedStmt = cnx.prepareStatement(query);
        preparedStmt.setString(1, username);

        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {

            FosUser user_found = new FosUser();

            user_found.setId(rs.getInt("id"));
            user_found.setUsername(rs.getString("username"));
            user_found.setEmail(rs.getString("email"));
            user_found.setRoles(rs.getString("roles"));
            user_found.setPassword(rs.getString("password"));
            if (BCrypt.checkpw(password, user_found.getPassword().replaceFirst("2y", "2a"))) {
                return user_found;
            } else {
                return null;
            }

        }
        return null;
    }

    public static void insererUtilisateur(FosUser e) {
        String query = "INSERT INTO fos_user(username,username_canonical, email,email_canonical,enabled,roles, password, firstName, lastName) VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);

            ste.setString(1, e.getUsername());
            ste.setString(2, e.getUsernameCanonical());
            ste.setString(3, e.getEmail());
            ste.setString(4, e.getEmailCanonical());
            ste.setString(11, e.getRoles());
            ste.setString(7, e.getPassword());
            ste.setString(12, e.getFirstName());
            ste.setString(13, e.getLastName());
            ste.setInt(10, 0);
            ste.setInt(11, 0);

            ste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FosUerService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/*
    public ObservableList<FosUser> UsersList() {
        ObservableList data;
        data = FXCollections.observableArrayList();
        try {
            String req = "select * from fos_user";
            ResultSet rs = cnx.createStatement().executeQuery(req);

            while (rs.next()) {
                Offer o = new Offer(rs.getInt("id"), rs.getString("firstName"), rs.getInt("lastName"), rs.getString("email"));
                data.add(o);

            }
            System.out.println(data.toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
*/
}