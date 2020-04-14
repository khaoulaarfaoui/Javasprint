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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML
    private TableView<Employee> table;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         setUpEmployee();
    
    }    
       public void setUpEmployee(){
            EmployeeService EMPS= new  EmployeeService();
            ObservableList<Employee> mahden = FXCollections.observableArrayList();
            mahden.addAll(EMPS.selectAll());
             id.setCellValueFactory(new PropertyValueFactory<> ("id"));
            name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
            lastname.setCellValueFactory(new PropertyValueFactory<> ("Last_name"));
            fonction.setCellValueFactory(new PropertyValueFactory<> ("fonction"));
            email.setCellValueFactory(new PropertyValueFactory<> ("email"));
            birth.setCellValueFactory(new PropertyValueFactory<> ("Birth_Date"));
            image.setCellValueFactory(new PropertyValueFactory<> ("image"));   
            //approve.setCellFactory(new Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>>() {

      table.setItems(mahden);
          
    }
 
    

}
