/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;


import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class EMAILController implements Initializable {

    @FXML
    private static TextField email;
    @FXML
    private static TextField subject;
    @FXML
    private static TextArea text;
    @FXML
    private Button sendbtn;
    @FXML
    private Label wrong;
 static Session session;
 static String password ;
 static String myAccountEmail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //     email.setText(idd);
    }    
   //  public String idd= READ_EMPController.emailadr;
public static void sendMail() throws Exception {
 System.out.println("Preparing to send email");
        Properties properties = new Properties();
        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
         myAccountEmail = "alarfaouikhaoula@gmail.com";
        //Your gmail password
         password = "khaoula56591671";
        System.out.println("aaaaaaaaaaaaaaaa");
        //Create a session with account credentials
         session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

}


    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("hello");
           message.setContent("test", "text/html");
            return message;
        } catch (Exception ex) {
        System.out.println("aaaaaaa");
        }
        return null;
    }  
    
 
    @FXML
    private void submit(ActionEvent event) throws Exception {
        sendMail();
        
        Message message = prepareMessage(session, "alarfaouikhaoula@gmail.com", "alarfaouikhaoula@gmail.com");
        
        //Send mail
       Transport.send(message);
    

    }
    }

    
    

