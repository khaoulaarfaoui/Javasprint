/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import Services.EmployeeService;
import java.net.URL;
import java.util.Date;

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
public class CREATE_EMPController implements Initializable {

    @FXML
    private TextField img;
    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField fonction;
    @FXML
    private DatePicker birthdate;
    @FXML
    private Button submit;
    @FXML
    private Label wrong;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fonction(ActionEvent event) {
    }

    @FXML
    private void ADDEMP(ActionEvent event) {
        EmployeeService EMPS= new  EmployeeService();
        Employee EMP= new Employee();
        
        if (name.getText().trim().isEmpty()
               
            
                || lastname.getText().trim().isEmpty()
                || fonction.getText().trim().isEmpty()               
                || img.getText().trim().isEmpty()
                || email.getText().trim().isEmpty()
             
                ) {

            wrong.setVisible(true);

        }
          else {
        EMP.setName(name.getText());
        EMP.setLast_name(lastname.getText());
        EMP.setFonction(fonction.getText());
    
        EMP.setBirth_Date(java.sql.Date.valueOf(birthdate.getValue()));
        EMP.setImage(img.getText());
        EMP.setEmail(email.getText());
        
            EMPS.ajouter(EMP);
        
        
        
        
        
        
        
    }
    }
    
}
