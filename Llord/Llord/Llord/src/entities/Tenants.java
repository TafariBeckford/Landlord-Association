/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.*;
import java.io.Serializable;

/**
 *
 * @author TAFARI
 */
public class Tenants implements Serializable {
   private String EmailAddress;
   private String TelephoneNumber;
   private String CellphoneNumber;
   private String Occupation;
   private String Residence;
   private String TFirstName;
   private String TLastName;
   private String DOB;
   private String Gender;
   private String Street;
   private String City;
   private String Parish;
   private String District;
   private String Country;
   private String Town;
   private String LandLordID;
   private Payment payment;
   private String TenantID;
   private String image;
    /**
     * @return the EmailAddress
     */
    public String getEmailAddress() {
        return EmailAddress;
    }

    /**
     * @param EmailAddress the EmailAddress to set
     */
    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    /**
     * @return the TelephoneNumber
     */
    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    /**
     * @param TelephoneNumber the TelephoneNumber to set
     */
    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }

    /**
     * @return the Occupation
     */
    public String getOccupation() {
        return Occupation;
    }

    /**
     * @param Occupation the Occupation to set
     */
    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    /**
     * @return the Residence
     */
    public String getResidence() {
        return Residence;
    }

    /**
     * @param Residence the Residence to set
     */
    public void setResidence(String Residence) {
        this.Residence = Residence;
    }

    /**
     * @return the TFirstName
     */
    public String getTFirstName() {
        return TFirstName;
    }

    /**
     * @param TFirstName the TFirstName to set
     */
    public void setTFirstName(String TFirstName) {
        this.TFirstName = TFirstName;
    }

    /**
     * @return the TLastName
     */
    public String getTLastName() {
        return TLastName;
    }

    /**
     * @param TLastName the TLastName to set
     */
    public void setTLastName(String TLastName) {
        this.TLastName = TLastName;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the CellphoneNumber
     */
    public String getCellphoneNumber() {
        return CellphoneNumber;
    }

    /**
     * @param CellphoneNumber the CellphoneNumber to set
     */
    public void setCellphoneNumber(String CellphoneNumber) {
        this.CellphoneNumber = CellphoneNumber;
    }


    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Street
     */
    public String getStreet() {
        return Street;
    }

    /**
     * @param Street the Street to set
     */
    public void setStreet(String Street) {
        this.Street = Street;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the Parish
     */
    public String getParish() {
        return Parish;
    }

    /**
     * @param Parish the Parish to set
     */
    public void setParish(String Parish) {
        this.Parish = Parish;
    }

    /**
     * @return the District
     */
    public String getDistrict() {
        return District;
    }

    /**
     * @param District the District to set
     */
    public void setDistrict(String District) {
        this.District = District;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * @return the Town
     */
    public String getTown() {
        return Town;
    }

    /**
     * @param Town the Town to set
     */
    public void setTown(String Town) {
        this.Town = Town;
    }

    /**
     * @return the LandLordID
     */
    public String getLandLordID() {
        return LandLordID;
    }

    /**
     * @param LandLordID the LandLordID to set
     */
    public void setLandLordID(String LandLordID) {
        this.LandLordID = LandLordID;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * @return the TenantID
     */
    public String getTenantID() {
        return TenantID;
    }

    /**
     * @param TenantID the TenantID to set
     */
    public void setTenantID(String TenantID) {
        this.TenantID = TenantID;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }
   
    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
           
}
