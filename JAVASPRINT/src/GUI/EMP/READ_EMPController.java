/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import Services.EmployeeService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class READ_EMPController implements Initializable {
   public ObservableList<Employee> obb ;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> lastname;
    @FXML
    private TableColumn<?, ?> fonction;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private TableColumn<?, ?> birth;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setUpEmployee(){
            EmployeeService EMPS= new  EmployeeService();
            ArrayList<Employee> mahden = null ;
            mahden=(ArrayList<Employee>) EMPS.selectAll();
            obb=FXCollections.observableArrayList(mahden);
            idRecla.setCellValueFactory(new PropertyValueFactory<> ("id_reclamation"));
            dateRec.setCellValueFactory(new PropertyValueFactory<> ("date_reclamation"));
            contenu.setCellValueFactory(new PropertyValueFactory<> ("contenu"));
            etat.setCellValueFactory(new PropertyValueFactory<> ("etat"));
            idUser.setCellValueFactory(new PropertyValueFactory<> ("id_user"));
            reponse.setCellValueFactory(new PropertyValueFactory<> ("reponse"));
            tablereclamation.setItems(obb);
    }

}
