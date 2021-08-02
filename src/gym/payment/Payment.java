/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.payment;

import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */
public class Payment {
    
    private double balance = 0;
    private PaymentStatus paymentStatus = PaymentStatus.NOSTATUS;
    
    private ArrayList<Double> paymentHistory = new ArrayList<>();
    
    public Payment(double balance){
        if (balance == 0) {
            this.paymentStatus = PaymentStatus.PAYMENTDUE;
        } else {
            this.paymentStatus = PaymentStatus.PASTDUE;
        }
        
        this.balance += balance;  
    }
    
    public void makePayment(double payment){
        this.paymentHistory.add(payment);
        
        balance = balance - payment;
        
        if (balance <=0) {
            this.paymentStatus = PaymentStatus.CURRENT;
        }
    }
    
    public String getPaymentInfo(){
        String paymentInfo = "Payment Status:" + paymentStatus + " Balance:" + balance + " Last Payment:" + getLastPayment();
        return paymentInfo;
    }
    
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    
    public double getLastPayment() {
        if (this.paymentHistory.isEmpty()) {
            return 0;
        } else {
            return this.paymentHistory.get(paymentHistory.size()-1);
        }
    }

    public double getCurrentBalance() {
        return balance;
    }
    
    public void updateNewBalance(double newBalance) {
        balance += newBalance; 
        
        if (balance <= 0) {
            this.paymentStatus = PaymentStatus.CURRENT;
        } else if (balance == newBalance) {
            this.paymentStatus = PaymentStatus.PAYMENTDUE;
        } else {
            this.paymentStatus = PaymentStatus.PASTDUE;
        }

    }
    
    public void setTrialPeriod() {
        balance = 0;
        this.paymentStatus = PaymentStatus.CURRENT;
    }
  
}
