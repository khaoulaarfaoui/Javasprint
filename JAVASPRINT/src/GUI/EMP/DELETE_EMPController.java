/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Services.EmployeeService;
import Utils.ConnexionBD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class DELETE_EMPController implements Initializable {

    @FXML
    private Button delete;
    @FXML
    private TextField id;
public int idd= READ_EMPController.deleteid;        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 id.setText(Integer.toString(idd));

    }    
        private Connection connection = ConnexionBD.getInstance().getCon();
    
    @FXML
    private void deleteEMP(ActionEvent event) throws IOException {
        int test= Integer.parseInt(id.getText());
        String SQL = "DELETE FROM employee WHERE id = ?";
        PreparedStatement pre = null;
        try {
            // get a connection and then in your try catch for executing your delete...
            pre = connection.prepareStatement(SQL);
            pre.setInt(1, test);
            pre.executeUpdate();
             Parent home_page_parent =FXMLLoader.load(getClass().getResource("READ_EMP.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.hide(); //optional
                    app_stage.setScene(home_page_scene);
                    app_stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
