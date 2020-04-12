/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import GUIMAIN.Main;
import Security.FOSJCrypt;
import Utils.ConnexionBD;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class Admin_guiController implements Initializable {
    private Connection connection = ConnexionBD.getInstance().getCon();
    private static Statement ste=null;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
private Main main;
    @FXML
    private Label errorMessage;
    @FXML
    private Label hash;
    /**
     * Initializes the controller class.
     */
     /* public void setApp(Main application){
        this.main = application;
   }
*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMessage.setText("");
        username.setPromptText("login");
        password.setPromptText("password");
    }    

    @FXML
    private void Login(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException, SQLException {
   Boolean u = false;
        int i=0;
            try {

            String query = "select password  from fos_user where  (username = ? );";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, username.getText());
            ResultSet rest = stm.executeQuery();
            String pas= password.getText();
            while (rest.next()) {
                i++;
               String DBpassword = rest.getString("password");
               boolean test =FOSJCrypt.checkPassword(pas,DBpassword);
               System.out.println(test);
                if (test) {
                    u = true;
                     errorMessage.setText("Logged in with success  "+u);
   
                }
                else {
                    u = false;
                     errorMessage.setText("Wrong credentials  "+ u);

                 } }
       if(i==0){System.out.println("Could not find user ");}
        } catch (SQLException ex) {

    System.out.println("not good at all ");
        }
            }}

            
            
    


