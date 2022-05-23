/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import entities.LandLords;
import entities.Tenants;
import generics.GenericClass;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author TAFARI
 */
public class TenantTableController implements Initializable {
 LandLords l=new LandLords();
 Tenants t=new Tenants();
 
   GenericClass<Tenants> genL = new GenericClass();
    @FXML
    private TableView<Tenants> TT;
    @FXML
    private TableColumn<Tenants,String>FirstName;
    @FXML
    private TableColumn<Tenants,String>LastName;
    @FXML
    private TableColumn<Tenants,String>TelePhone;
    @FXML
    private TableColumn<Tenants,String>Occupation;
    @FXML
    private TableColumn<Tenants,String>Gender;
    @FXML
    private TableColumn<Tenants,String>DateofBirth;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FirstName.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TFirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TLastName"));
        TelePhone.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TelephoneNumber"));
        Occupation.setCellValueFactory(new PropertyValueFactory<Tenants, String>("Occupation"));
        Gender.setCellValueFactory(new PropertyValueFactory<Tenants, String>("Gender"));
        DateofBirth.setCellValueFactory(new PropertyValueFactory<Tenants, String>("DOB"));
        List<Tenants> wList = (List<Tenants>)genL.deserializeObject("Tenants.txt");
        ObservableList<Tenants> info = FXCollections.observableArrayList();
        this.l=(LandLords) new GenericClass().deserializeObject("Login.txt");
        for(Tenants ten: wList){   
        if (l.getID().equals(ten.getLandLordID())) {
        info.add(ten);
        TT.setItems(info);
    }    
        }
    }
   
    @FXML
    private void AddT(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Tenant/Tenant.fxml"));
        Scene s = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Registration");
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void AddP(ActionEvent event) throws IOException {
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/Payment/TenantPayment.fxml"));
        Scene s = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Registration");
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
        
         
    }

    @FXML
    private void Refresh(ActionEvent event) {
  
        FirstName.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TFirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TLastName"));
        TelePhone.setCellValueFactory(new PropertyValueFactory<Tenants, String>("TelephoneNumber"));
        Occupation.setCellValueFactory(new PropertyValueFactory<Tenants, String>("Occupation"));
        Gender.setCellValueFactory(new PropertyValueFactory<Tenants, String>("Gender"));
        DateofBirth.setCellValueFactory(new PropertyValueFactory<Tenants, String>("DOB"));
        List<Tenants> wList = (List<Tenants>)genL.deserializeObject("Tenants.txt");
        ObservableList<Tenants> info = FXCollections.observableArrayList();
        this.l=(LandLords) new GenericClass().deserializeObject("Login.txt");
        for(Tenants ten: wList){   
        if (l.getID().equals(ten.getLandLordID())) {
        info.add(ten);
        TT.setItems(info);
    }    
        }
    }
}

        
      

