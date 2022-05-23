/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entities.Payment;
import entities.Tenants;
import interfaces.DiscountInterface;
import interfaces.LateFeeInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author TAFARI
 */
public class TenantPaymentController implements Initializable {

    @FXML
    private JFXTextField DO;
    @FXML
    private JFXTextField LF;
    @FXML
    private JFXTextField DA;
    @FXML
    private JFXDatePicker PD;
    @FXML
    private JFXDatePicker NPD;
    @FXML
    private JFXTextField AD;
    @FXML
    private JFXDatePicker BD;

    Tenants t=new Tenants();
    @FXML
    private JFXTextField PN;
    @FXML
    private JFXTextField Owe;
    @FXML
    private JFXTextField CH;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField TTID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    double discamount;
    double latefee;
    double finalamtdue;
    int amtdue;
    int weekrate=1000;
    int weekendrate=1200;
    int weekdays;
    int weekend;
    int mondays;
    int tuesdays;
    int wednesdays;
    int thursdays;
    int fridays;
    int saturdays;
    int sundays;
    String TenId;
    String gender;
   

    Tenants tt=new Tenants();
    
   public void Payment(){
        LocalDate date = PD.getValue();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        PD.getValue().format(dtf);
        NPD.setValue(PD.getValue().plusDays(28));
  }

    @FXML
    private void SubmitPayment(ActionEvent event) {
        FileWriter fileWriter = null;
        Payment();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String localDate = PD.getValue().toString();
            LocalDate loc = LocalDate.now();
            LocalDate i =  BD.getValue();
            LocalDate paye = BD.getValue();
            Date dat = new Date();
            Calendar start = Calendar.getInstance();
            Calendar end = new GregorianCalendar();
            String bdate = LocalDate.now().toString();
            System.out.println(bdate);
            LocalDate nextPayDate = PD.getValue().plusDays(28);
            NPD.setValue(nextPayDate);
            java.util.Date d = java.sql.Date.valueOf(i);
            java.util.Date q = java.sql.Date.valueOf(localDate);
             start.setTime(q);
             end.setTime(d);
            LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            for (LocalDate local = startDate; local.isBefore(endDate); local = local.plusDays(1)) {

                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.MONDAY) {

                    mondays++;
                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.TUESDAY) {

                    tuesdays++;
                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.WEDNESDAY) {

                    wednesdays++;
                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.THURSDAY) {

                    thursdays++;

                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.FRIDAY) {

                    fridays++;
                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.SATURDAY) {
                    saturdays++;

                }
                if (local.atStartOfDay().getDayOfWeek() == DayOfWeek.SUNDAY) {

                    sundays++;
                }

            }

            weekdays = mondays + tuesdays + wednesdays + thursdays + fridays;
            weekend = saturdays + sundays;

            amtdue = (weekdays* weekrate) + (weekend * weekendrate);
            System.out.println("amt"+":"+amtdue);
            
            Calendar c = Calendar.getInstance();
            Calendar c1 = Calendar.getInstance();
            java.util.Date datepaid = java.sql.Date.valueOf(paye);
            java.util.Date da = java.sql.Date.valueOf(nextPayDate);

                c.setTime(da);
                c1.setTime(datepaid);

            // Get the represented date in milliseconds
            long millis1 = c.getTimeInMillis();
            long millis2 = c1.getTimeInMillis();

            // Calculate difference in milliseconds
            long diff = millis2 - millis1;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 0) {

                latefee = LateFeeInterface.LATEFEE * diffDays;

            } else {
                latefee = 0;
            }  
    
//            if (tt.getGender().equals("Female")) {
//            discamount = DiscountInterface.FDISCOUNT* amtdue;
//        } else {
//            discamount = 0;
//            }
            
            DO.setText(Long.toString(diffDays));
            finalamtdue = latefee + amtdue - discamount;
            DA.setText(Double.toString(discamount));
            LF.setText(Double.toString(latefee));
            AD.setText(Double.toString(amtdue));
            try{
            t.getPayment().setNextPaymentDate(nextPayDate.toString());
            t.getPayment().setDaysOverdue(DO.getText());
            System.out.println(t.getPayment().getDaysOverdue());
            t.getPayment().setAmount(AD.getText());
            }
            catch(NullPointerException e)
        {
//            System.out.print("NullPointerException caught");
        }
           
    }

    @FXML
    private void SendEmail(ActionEvent event) {
        
        String amt = AD.getText();
        String pay = PN.getText();
        String filename = email.getText()+ ".txt";
        double realamt = Double.parseDouble(amt);
        double realpay = Double.parseDouble(pay);
        double change = realamt - realpay;

        if (realpay > realamt) {
            change = realpay - realamt;
            CH.setText(Double.toString(change));

        } else {
            Owe.setText(Double.toString(change));
            
        }
        FileWriter fileWriter = null;
        final String username = "beckfordtafari55@gmail.com"; 
        final String password = "geniusofscience123";
        String body = "Test body";

        File f = new File(filename);
        if (!f.exists()) {

            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            fileWriter = new FileWriter(filename);
        } catch (IOException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.append("---------PAYMENT RECEIPT---------"+"\n");
        printWriter.append("AMOUNT DUE:" + finalamtdue+"\n");
        printWriter.append("AMOUNT PAID:"+realpay+"\n");
        printWriter.append("AMOUNT OWING :"+change+"\n");
        printWriter.append("CHANGE :"+change+"\n");
        printWriter.append("NEXT PAYMENT DATE :" +NPD.getValue()+"\n");
        
        printWriter.close();
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("beckfordtafari55@gmail.com")); 
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getText()));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            MimeBodyPart messagePart = new MimeBodyPart();

            messagePart.setText(body);


            MimeBodyPart attachmentPart = new MimeBodyPart();

            FileDataSource fileDataSource = new FileDataSource(filename) {

                @Override

                public String getContentType() {

                    return "application/octet-stream";

                }

            };

            attachmentPart.setDataHandler(new DataHandler(fileDataSource));

            attachmentPart.setFileName(fileDataSource.getName());


            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messagePart);

            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);


            Transport.send(message);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Email Sent");
        alert.showAndWait(); 

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
}
    


