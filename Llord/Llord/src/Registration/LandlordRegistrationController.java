/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import static Registration.LandlordRegistrationController.LANDLORDS_FILE;
import Tenant.Tenant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.LandLords;
import generics.GenericClass;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author TAFARI
 */
public class LandlordRegistrationController implements Initializable {

    @FXML
    private JFXTextField FNReg;
    @FXML
    private JFXTextField LNReg;
    @FXML
    private JFXTextField IDReg;
    @FXML
    private JFXPasswordField PasswordReg;
    @FXML
    private JFXButton Submit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    static final String LANDLORDS_FILE = "LanLords.txt";

    private void RegCancel(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/landlord/Landlords.fxml"));
        Scene s = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Registration");
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.close();

    }

    @FXML
    private void SubmitReg(ActionEvent event) {
        register();

    }

    public void register(){
        LandLords l = new LandLords();
        GenericClass<LandLords> genL = new GenericClass();
        GenericClass<List<LandLords>> genPList = new GenericClass();
        List<LandLords> pList = new ArrayList();
        l.setFirstName(FNReg.getText());
        l.setLastName(LNReg.getText());
        l.setID(IDReg.getText());
        l.setPassword(PasswordReg.getText());

        Window owner = Submit.getScene().getWindow();
        if (FNReg.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("\"Form Error!\", \n"
                    + "                    \"Please enter your First Name");
            alert.showAndWait();
        }
        if (LNReg.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("\"Form Error!\", \n"
                    + "                    \"Please enter your Last Name");
            alert.showAndWait();
        }
        if (IDReg.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("\"Form Error!\", \n"
                    + "                    \"Please enter your ID");
            alert.showAndWait();
        }
        if (PasswordReg.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("\"Form Error!\", \n"
                    + "                    \"Please enter your Password");
            alert.showAndWait();
        }

//Clears textfeild after submit
        LNReg.clear();
        FNReg.clear();
        IDReg.clear();
        PasswordReg.clear();

        if (genL.deserializeObject(LANDLORDS_FILE) == null) {
            pList = new ArrayList<>();
        } else {
            pList = (List<LandLords>) genL.deserializeObject(LANDLORDS_FILE);
        }
        pList.add(l);
        if (genPList.serializeObject(pList, LANDLORDS_FILE)) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Saved!!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Not Saved!!");
            alert.showAndWait();
        }
        List<LandLords> perList = (List<LandLords>) genL.deserializeObject(LANDLORDS_FILE);

        for (LandLords per : perList) {
            System.out.println(per.getFirstName() + per.getLastName() + per.getID() + per.getPassword());
        }
    }
//public void Hashmap(){
//GenericClass genp=new GenericClass();
//Map<String,List<Tenant>> personList = new HashMap<String,List<Tenant>>();
//ArrayList<LandLords> landList= (ArrayList<LandLords>)genp.deserializeObject("LanLords.txt");
//ArrayList<Tenant> tenantList= (ArrayList<Tenant>)genp.deserializeObject("Tenants.txt");
// if(genp.deserializeObject(FirstName){
//     personList = new HashMap<String,List<Tenant>>();
// }else{
//     personList=(Map<String,List<Tenant>>)genp.deserializeObject("LanLordsTenants.txt");
// }
// for(Iterator<LandLords> it = landList.iterator(); it.hasNext();){
//     LandLords l =it.next();
//     LandLords land = new LandLords();
//     if(getID().equals(l.getID())){
//         personList.put(l.getID(), tenantList);
//     }
// }
// if(genp.serializeObject(personList, "Landlord Tenant.txt"));
//    System.out.println("Tenant Registrered");
//}

}
