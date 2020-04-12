/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import Services.EmployeeService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class UPDATE_EMPController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField img;
    @FXML
    private TextField email;
    @FXML
    private DatePicker birthday;
    @FXML
    private TextField idE;
    @FXML
    private Button updateEMP;
    @FXML
    private TextField fonction;
    @FXML
    private Label wrong;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateEMP(ActionEvent event) throws SQLException {
         EmployeeService EMPS= new  EmployeeService();
         int test= Integer.parseInt(idE.getText());
        Employee EMP= EMPS.selectOne(test);
       
        if (name.getText().trim().isEmpty()
               
            
                || lastname.getText().trim().isEmpty()
                || fonction.getText().trim().isEmpty()               
                || img.getText().trim().isEmpty()
                || email.getText().trim().isEmpty()
                || idE.getText().trim().isEmpty()
                ) {

            wrong.setVisible(true);

        }
          else {
        EMP.setName(name.getText());
        EMP.setLast_name(lastname.getText());
        EMP.setFonction(fonction.getText());
    
        EMP.setBirth_Date(java.sql.Date.valueOf(birthday.getValue()));
        EMP.setImage(img.getText());
        EMP.setEmail(email.getText());
        
        EMPS.editUser(EMP,test);
        
        
        
        
        
        
        
    }
    }
    }
    

