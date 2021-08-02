/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.membership;

import gym.payment.Payment;
import gym.paymentplan.PaymentPlan;
import gym.payment.PaymentPlanType;
import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */

public abstract class Membership {
    MembershipType membershipType;
    
    PaymentPlan paymentPlan;
    
    Payment payment;
    
    boolean activeMembership;
    
    public Membership() {
        membershipType = MembershipType.NOMEMBERSHIP;
    }
    
    public MembershipType getMembershipType() {
        return this.membershipType;
    }
    
    public boolean isMembershipActive() {
        return activeMembership;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
    public void activateMembership(PaymentPlan plan) {
        if (!activeMembership) {
            paymentPlan = plan;
            payment = new Payment(paymentPlan.getItemPaymentAmount());
            this.activeMembership = true;
            
            if (membershipType == MembershipType.TRIALMEMBERSHIP) {
                payment.setTrialPeriod();
            }
        }
    }

    abstract public String getDescription();
    
    abstract double getIndividualPaymentAmount(); 
    
    abstract double getTotalPaymentAmount();
    
    // Payment plans
    abstract ArrayList<PaymentPlanType> getAvailablePlans();
    
    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }
    
}
