/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EMP;

import Entities.Employee;
import Services.EmployeeService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class READ_EMPController implements Initializable {

    public ObservableList<Employee> obb;
    @FXML
    private TableColumn<Employee, String> id;
    @FXML
    private TableColumn<Employee, String> name;
    @FXML
    private TableColumn<Employee, String> lastname;

    @FXML
    private TableView<Employee> table;
    Parent root1;
    static int i;
    static int deleteid;
    static String emailadr;
    Writer writer;
    File filef;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpEmployee();

    }

    public void setUpEmployee() {

// this gives the value in the selected cell:
        EmployeeService EMPS = new EmployeeService();
        ObservableList<Employee> mahden = FXCollections.observableArrayList();
        mahden.addAll(EMPS.selectAll());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        TableColumn<Employee, Employee> delete = new TableColumn<>("Delete");
        delete.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        delete.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button deleteButton = new Button("Delete");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(deleteButton);
                deleteButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DELETE_EMP.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                deleteid = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();

                                DELETE_EMPController sceneController = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(DELETE_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });
        TableColumn<Employee, Employee> edit = new TableColumn<>("Edit");
        edit.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        edit.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button editButton = new Button("Edit");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);
                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(editButton);
                editButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UPDATE_EMP.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                i = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();
                                System.out.println();
                                UPDATE_EMPController scene2Controller = fxmlLoader.getController();

                                System.out.println(i);
                                //  Label l = l.setText(Integer.toString(i));

                            } catch (IOException ex) {
                                Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Employee, Employee> email = new TableColumn<>("Email");
        email.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        email.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button emailButton = new Button("Email");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(emailButton);
                emailButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EMAIL.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                // emailadr = selectedPerson.getEmail();

                                root1 = (Parent) fxmlLoader.load();

                                EMAILController sceneController3 = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(EMAILController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Employee, Employee> export = new TableColumn<>("Export");
        export.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        email.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button exportButton = new Button("Email");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(exportButton);
                exportButton.setOnAction(
                        (event) -> {
                    try {
                        writeExcel();
                    } catch (Exception ex) {
                        Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        }
                );

            }
        });

        table.setItems(mahden);
        table.getColumns().addAll(delete, edit, email, export);

    }
public void writeExcel() throws Exception {
     writer = null;
    try {
        filef = new File("/home/khaoula/Downloads/test.csv");
        writer = new BufferedWriter(new FileWriter(filef));
        {
        //Employee selectedPerson = table.getSelectionModel().getSelectedItem();
      //  String text = selectedPerson.getName() + "," + selectedPerson.getLast_name()+  "\n";
            String text="aaa";
            writer.write(text);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    finally {

        writer.flush();
         writer.close();
    } 
}
}
