/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import static GUI.EMP.READ_EMPController.i;
import Services.EmployeeService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

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
    private Button img;
    @FXML
    private TextField email;
    @FXML
    private DatePicker birthday;

    @FXML
    private Button updateEMP;
    @FXML
    private TextField fonction;
    @FXML
    private Label wrong;
    @FXML
    private Label idE;

       File s;
    @FXML
    private ImageView img1;
    public Label getIdE() {
        return idE;

    }

    /**
     * Initializes the controller class.
     */
    public void setIdE(Label idE) {    
        this.idE = idE;
     
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idE.setText(Integer.toString(idd));
    }
    public int idd= READ_EMPController.i;
    
    
    
     
     int updateEMP(int test) {
      //  System.out.println(test);
        return test;

    }

    @FXML
    private void clicked(ActionEvent event) throws SQLException, IOException {
        EmployeeService EMPS = new EmployeeService();
        Employee EMP = EMPS.selectOne(idd);
        if (name.getText().trim().isEmpty()
                || lastname.getText().trim().isEmpty()
                || fonction.getText().trim().isEmpty()
                || img.getText().trim().isEmpty()
                || email.getText().trim().isEmpty()) {

            wrong.setVisible(true);
        } else {
           EMP.setId(idd);
            EMP.setName(name.getText());
            EMP.setLast_name(lastname.getText());
            EMP.setFonction(fonction.getText());
            EMP.setBirth_Date(java.sql.Date.valueOf(birthday.getValue()));
             EMP.setImage((String)(s.getName()));
            EMP.setEmail(email.getText());
            EMPS.editUser(EMP);
            Parent home_page_parent =FXMLLoader.load(getClass().getResource("READ_EMP.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.hide(); //optional
                    app_stage.setScene(home_page_scene);
                    app_stage.show();

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
        Image image1;
        image1 = SwingFXUtils.toFXImage(bufferedImage, null);
        img1.setImage(image1);
    }    
}
