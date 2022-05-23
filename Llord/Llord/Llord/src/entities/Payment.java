/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.LateFeeInterface;

/**
 *
 * @author TAFARI
 */
public class Payment implements LateFeeInterface {
    private String LastPaymentDate;
    private String NextPaymentDate;
    private String DaysOverdue;
    private double lateFee;
    private String DiscountedAmount;
    private String Amount;

    /**
     * @return the LastPaymentDate
     */
    public String getLastPaymentDate() {
        return LastPaymentDate;
    }

    /**
     * @param LastPaymentDate the LastPaymentDate to set
     */
    public void setLastPaymentDate(String LastPaymentDate) {
        this.LastPaymentDate = LastPaymentDate;
    }

    /**
     * @return the NextPaymentDate
     */
    public String getNextPaymentDate() {
        return NextPaymentDate;
    }

    /**
     * @param NextPaymentDate the NextPaymentDate to set
     */
    public void setNextPaymentDate(String NextPaymentDate) {
        this.NextPaymentDate = NextPaymentDate;
    }

 
    /**
     * @return the DiscountedAmount
     */
    public String getDiscountedAmount() {
        return DiscountedAmount;
    }

    /**
     * @param DiscountedAmount the DiscountedAmount to set
     */
    public void setDiscountedAmount(String DiscountedAmount) {
        this.DiscountedAmount = DiscountedAmount;
    }

    /**
     * @return the Amount
     */
    public String getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the DaysOverdue
     */
    public String getDaysOverdue() {
        return DaysOverdue;
    }

    /**
     * @param DaysOverdue the DaysOverdue to set
     */
    public void setDaysOverdue(String DaysOverdue) {
        this.DaysOverdue = DaysOverdue;
    }

    /**
     * @return the lateFee
     */
    public double getLateFee() {
        return lateFee;
    }

    /**
     * @param lateFee the lateFee to set
     */
    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

   
    }
  
    

