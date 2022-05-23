/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.LandLords;
import generics.GenericClass;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javax.management.Query.match;

/**
 *
 * @author TAFARI
 * 
 */

public class LoginController implements Initializable {

    @FXML
    private JFXTextField UNTextField;
    @FXML
    private JFXPasswordField PassFiled;
    

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 static final String LANDLORDS_FILE = "LanLords.txt";
    @FXML
    private void Submit(ActionEvent event) throws IOException {
         ValidatePassword();
    }

  
    @FXML
    private void RegLink(ActionEvent event) throws IOException {    
        Parent root=FXMLLoader.load(getClass().getResource("/Registration/Landlord Registration.fxml"));
        Scene s=new Scene(root);
        Stage stage=new Stage(StageStyle.DECORATED);
        stage.setTitle("Registration");
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    
     public void ValidatePassword() throws IOException {
        GenericClass< LandLords> genP = new GenericClass();
        List<LandLords> pList = (List<LandLords>) genP.deserializeObject(LANDLORDS_FILE); 
        String id=UNTextField.getText();
        String password=PassFiled.getText();
         boolean match=false;
         for(LandLords lan:pList ){
         if (id.equals(lan.getID()) && password.equals(lan.getPassword())){
         match=true;
         new GenericClass().serializeObject(lan, "Login.txt");
               
          
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Password is Correct!!");
alert.showAndWait();
Parent root = FXMLLoader.load(getClass().getResource("/Dashboard/TenantTable.fxml"));
        Scene s = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Registration");
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
          }
           }
           if(!match){
    
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Password is Incorrect");
alert.showAndWait();
           }
     }
}
    
    

    
    

