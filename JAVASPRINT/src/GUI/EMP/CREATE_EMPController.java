/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import Services.EmployeeService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class CREATE_EMPController implements Initializable {

    @FXML
    private ImageView img;
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
    @FXML
    private Button upload;
    File s;
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
    private void ADDEMP(ActionEvent event) throws FileNotFoundException {
        EmployeeService EMPS= new  EmployeeService();
        Employee EMP= new Employee();
        if (name.getText().trim().isEmpty()
               
            
                || lastname.getText().trim().isEmpty()
                || fonction.getText().trim().isEmpty()               
              
                || email.getText().trim().isEmpty()
             
                ) {

            wrong.setVisible(true);

        }
          else {
        EMP.setName(name.getText());
        EMP.setLast_name(lastname.getText());
        EMP.setFonction(fonction.getText());
        EMP.setBirth_Date(java.sql.Date.valueOf(birthdate.getValue()));
            EMP.setImage((String)(s.getAbsolutePath()));
        EMP.setEmail(email.getText());
            EMPS.ajouter(EMP);

    }
    }

    @FXML
    private void upload(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        s = file;
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image;
        image = SwingFXUtils.toFXImage(bufferedImage, null);
        img.setImage(image);
    }    
    }
    

