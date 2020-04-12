/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FosUser  {

    
    private Integer id;
    
    private String username;
    
    private String usernameCanonical;
    
    private String email;
    
    private String emailCanonical;
    
    private short enabled;
    
    private String salt;
    
    private String password;
    private Date lastLogin;
    private String confirmationToken;
    
    private Date passwordRequestedAt;
   
    private String roles;
   
    
    private String lastName;
    private String firstName;
   

    public FosUser() {
    }

    public FosUser(Integer id) {
        this.id = id;
    }

    public FosUser(Integer id, String username, String usernameCanonical, String email, String emailCanonical, short enabled, String password, String roles) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;

    }

    public FosUser(String username, String usernameCanonical, String email, String emailCanonical, short enabled, String salt, String password, String roles, String firstName, String lastName) {
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FosUser(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public FosUser(int id,String username, String usernameCanonical, String email, String emailCanonical, short enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt,String roles, String firstName, String lastName) {
         this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.lastName=lastName;
        this.firstName=firstName;
    }

    public FosUser(String username, String email, String password, String roles, String lastName, String firstName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {

        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FosUser{" + "id=" + id + ", username=" + username + ", usernameCanonical=" + usernameCanonical + ", email=" + email + ", emailCanonical=" + emailCanonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + lastLogin + ", confirmationToken=" + confirmationToken + ", passwordRequestedAt=" + passwordRequestedAt + ", roles=" + roles + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    

      public static FosUser createUser(ResultSet rs) {
        FosUser user = new FosUser();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setEnabled(rs.getShort("enabled"));
            user.setSalt(rs.getString("salt"));
            user.setPassword(rs.getString("password"));
            user.setLastLogin(rs.getDate("last_login"));

        } catch (SQLException ex) {
            Logger.getLogger(FosUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
}