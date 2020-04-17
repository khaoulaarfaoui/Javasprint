/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FOURNISSEUR;

import Entities.Employee;
import Entities.Fournisseur;
import Services.EmployeeService;
import Services.FournisseurService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class READ_FRController implements Initializable {

    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> lastname;
    @FXML
    private TableColumn<?, ?> societe;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private TableColumn<?, ?> secteur;
    @FXML
    private TableView<Fournisseur> table;
    @FXML
    private TableColumn<?, ?> numsociete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         setUpFournisseur();
    
    }    
       public void setUpFournisseur(){
           
            FournisseurService FS= new  FournisseurService();
            ObservableList<Fournisseur> listeF = FXCollections.observableArrayList();
            listeF.addAll(FS.selectAll());
            id.setCellValueFactory(new PropertyValueFactory<> ("id"));
            societe.setCellValueFactory(new PropertyValueFactory<> ("societe"));
            numsociete.setCellValueFactory(new PropertyValueFactory<> ("numsociete"));
             secteur.setCellValueFactory(new PropertyValueFactory<> ("secteur"));
            name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
            lastname.setCellValueFactory(new PropertyValueFactory<> ("Last_name"));
            
            
     
            date.setCellValueFactory(new PropertyValueFactory<> ("EntrepriseDate"));
           image.setCellValueFactory(new PropertyValueFactory<> ("image"));
          // imageview.setImage(new Image("arrow.png"));
           // String img = image.getText();
           //  image = new Image(img);
            //approve.setCellFactory(new Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>>() {

      table.setItems(listeF);
          
    }}
