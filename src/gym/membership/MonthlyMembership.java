/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.membership;

import gym.payment.PaymentPlanType;
import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */
public class MonthlyMembership extends Membership {
    
    static final double pricePerYear = 700;
    
    public MonthlyMembership() {
        super();
        membershipType = MembershipType.MONTHLYMEMBERSHIP;
    }
 
    @Override
    public String getDescription() {
        return "This membership is an Montly Membership" ;
    }
    
    @Override
    public double getIndividualPaymentAmount() {
        return pricePerYear/12; 
    }
    
    @Override
    public double getTotalPaymentAmount() {
        return pricePerYear; // $700 for year
    }
    
    @Override
    public ArrayList<PaymentPlanType> getAvailablePlans() {
        return new ArrayList(); // No payment plans available
    }
    
}
