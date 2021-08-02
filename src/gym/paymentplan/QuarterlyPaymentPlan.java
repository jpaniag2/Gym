/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.paymentplan;

import gym.payment.PaymentPlanType;
import gym.paymentplan.PaymentPlan;

/**
 *
 * @author juliopaniagua
 */
public class QuarterlyPaymentPlan extends PaymentPlan{
    final int threeMonths = 3;
    double quarterlyMonthPayment;

    public QuarterlyPaymentPlan() {
        super();
    }
    
    public void calculateQuarterlyPayment(double price){
        quarterlyMonthPayment = price/threeMonths;
    }
    
    public double getQuarterlyMonthPayment(){
        return quarterlyMonthPayment;
    }
    
    @Override
    public double getItemPaymentAmount(){
        return YEARLY_PRICE/4;
    }
    
}
