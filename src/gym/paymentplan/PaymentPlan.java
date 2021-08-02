/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.paymentplan;

import gym.payment.PaymentPlanType;
import gym.payment.PaymentStatus;

/**
 *
 * @author juliopaniagua
 */
public abstract class PaymentPlan {
    final double YEARLY_PRICE = 700.00;

    public PaymentPlan() {
        
    }
    
    public double getYearlyPrice() {
        return YEARLY_PRICE;
    }
    
    public double getItemPaymentAmount() {
        return 0;
    }
    
}
