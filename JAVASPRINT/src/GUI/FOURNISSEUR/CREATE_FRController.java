/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FOURNISSEUR;

import Entities.Fournisseur;
import Services.FournisseurService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
public class CREATE_FRController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField numsociete;
    @FXML
    private TextField secteur;
    @FXML
    private DatePicker Date;
    @FXML
    private Button upload;
    @FXML
    private Button ADD;
    @FXML
    private Label wrong;
    File s;
    @FXML
    private ImageView img;
    @FXML
    private TextField societe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
         FournisseurService FS= new  FournisseurService();
        Fournisseur F= new Fournisseur();
        if (name.getText().trim().isEmpty()
                || societe.getText().trim().isEmpty()
                || lastname.getText().trim().isEmpty()
                || secteur.getText().trim().isEmpty()               
                || numsociete.getText().trim().isEmpty()
                ) 
            wrong.setVisible(true);

       
          else {
        F.setName(name.getText());
        F.setLast_name(lastname.getText());
        F.setSociete(societe.getText());
        F.setNumsociete(Integer.parseInt(numsociete.getText()));
        F.setSecteur(secteur.getText());

        F.setEntreprise_Date(java.sql.Date.valueOf(Date.getValue()));
        F.setImage((String)(s.getName()));
        
            FS.ajouter(F);

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
    

