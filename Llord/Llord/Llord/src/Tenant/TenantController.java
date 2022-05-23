/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tenant;


import entities.Tenants;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entities.LandLords;
import generics.GenericClass;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author TAFARI
 */
public class TenantController implements Initializable {

    
    @FXML
    private JFXButton btn_PI,btn_PA,btn_CD,btn_UP;
   
    @FXML
    private Pane pnl_PI,pnl_PA,pnl_CD,pnl_UP;
    @FXML
    private JFXComboBox<String> GenderCombo;
    @FXML
    private JFXTextField PI_FN;
    @FXML
    private JFXTextField PI_LN;
    @FXML
    private JFXDatePicker PI_DOB;
    @FXML
    private JFXTextField PI_Occupation;
    @FXML
    private JFXTextField CD_Email;
    @FXML
    private JFXTextField CD_Tele;
    @FXML
    private JFXTextField CD_cell;
    @FXML
    private JFXTextField PA_Street;
    @FXML
    private JFXTextField PA_District;
    @FXML
    private JFXTextField PA_Town;
    @FXML
    private JFXTextField PA_Country;
    @FXML
    private JFXComboBox<String> PA_Parish;
    @FXML
    private JFXTextField LID;
    @FXML
    private JFXTextField TID;
    @FXML
    private ImageView frame;
    
   Tenants ttt=new Tenants();
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource()==btn_PI){
            pnl_PI.toFront();
        }else
            if(event.getSource()==btn_PA){
            pnl_PA.toFront();
        }else
                if(event.getSource()==btn_CD){
            pnl_CD.toFront();
        }else
                    if(event.getSource()==btn_UP){
            pnl_UP.toFront();
        }
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       GenderCombo.getItems().addAll("Male","Female");
       PA_Parish.getItems().addAll("Kingston","St.Andrew","Manchester","St.Catherine","St.Thomas","St.Mary","Portland","St.Ann","Trelawny","St.James","Hanover","Westmoreland","St.Elizabeth","Clarendon");
    }
static final String TENANTS_FILE = "Tenants.txt";
    Tenants t=new Tenants();
    @FXML
    public void RegisterTenants(){
    
//    LandLords l=new LandLords();
    GenericClass<Tenants> genL = new GenericClass();
    GenericClass<List<Tenants>> genPList = new GenericClass();
    List<Tenants> pList = new ArrayList();
    t.setTFirstName(PI_FN.getText());
    t.setTLastName(PI_LN.getText());
    t.setOccupation(PI_Occupation.getText());
    t.setEmailAddress(CD_Email.getText());
    t.setTelephoneNumber(CD_Tele.getText());
    t.setCellphoneNumber(CD_cell.getText());
    t.setGender(GenderCombo.getSelectionModel().getSelectedItem());
    t.setDOB(PI_DOB.getValue().toString());
    t.setTown(PA_Town.getText());
    t.setCountry(PA_Country.getText());
    t.setDistrict(PA_District.getText());
    t.setStreet(PA_Street.getText());
    t.setLandLordID(LID.getText());
    t.setLandLordID(LID.getText());
    t.setTenantID(TID.getText());
    
  if(TENANTS_FILE == null){
            pList= new ArrayList<>();
            }else{
  pList = (List<Tenants>)genL.deserializeObject(TENANTS_FILE);
  }
   List<LandLords> PList = (List<LandLords>) genL.deserializeObject("LanLords.txt");
            for (LandLords l : PList) {
                if (l.getID().equals(t.getLandLordID())) {
                     pList.add(t);
                    String lid = l.getID();
                    
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Saved!!");
alert.showAndWait(); 
                } else {
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Not Saved!!");
alert.showAndWait();
                }
            }
  if (genPList.serializeObject(pList,TENANTS_FILE)){
List<Tenants> perList=(List<Tenants>)genL.deserializeObject(TENANTS_FILE);
for(Tenants per: perList){
        System.out.println(per.getTenantID()+per.getLandLordID()+per.getTFirstName()+ per.getTLastName()+per.getGender()+per.getDOB()+per.getEmailAddress()+per.getOccupation()+per.getTelephoneNumber()+per.getCellphoneNumber()
    );
}
    }
    }
String FilePath;
    public void setFilePath(String x){
        this.FilePath=x;
    }
    public String getFilePath (){
        return this.FilePath;
    }
    @FXML
    private void upload(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter exeFilter = new FileChooser.ExtensionFilter("Images",  "*.jpg", "*.jpeg", "*.png", "*.SVG");
        fileChooser.getExtensionFilters().add(exeFilter);
        File file = fileChooser.showOpenDialog(null);

        //get selcted image
        BufferedImage img = null;

        img = ImageIO.read(file.getAbsoluteFile());
        WritableImage i = SwingFXUtils.toFXImage(img, null);
        frame.setImage(i);

        String imagePath = fileLocation(file.getAbsolutePath());
        setFilePath(imagePath);
        File writeImage = new File(imagePath);
        String extention = " ";

        int x = imagePath.lastIndexOf('.');
        if (x >= 0) {
            extention = imagePath.substring(x + 1);
        }
        if (!writeImage.exists()) {
            writeImage.getAbsoluteFile().getParentFile().mkdir();
            writeImage.createNewFile();
            ImageIO.write(img, extention, writeImage);
        }
    }
            

    public String fileLocation(String path) {
        File file = new File("Tenants.txt");
        String fileP = file.getAbsolutePath();
        String newFile = fileP.replace("Tenants.txt", "\\");
        String extension = " ";

        int x = path.lastIndexOf('.');
        if (x >= 0) {
            extension = path.substring(x + 1);
        }
        return newFile + "images\\" + ttt.getTFirstName()+ " " + ttt.getTLastName()+ "." + extension;
    } 
        
        
    }
