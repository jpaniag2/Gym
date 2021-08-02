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
public class ThreeMonthMembership extends Membership {
    static final double pricePerYear = 700;
    
    private String description = null;
    
    public ThreeMonthMembership() {
        super();
        membershipType = MembershipType.THREEMONTHMEMBERSHIP;
    }
    
    @Override
    public String getDescription(){
        return "This membership is an Three-month Membership" ;
    }
    
    @Override
    public double getIndividualPaymentAmount() {
        return 300; // $300
    }
    
    @Override
    public double getTotalPaymentAmount() {
        return 300; // $300 for year
    }
    
    @Override
    public ArrayList<PaymentPlanType> getAvailablePlans() {
        ArrayList<PaymentPlanType> plans = new ArrayList();
        plans.add(PaymentPlanType.MONTHLY);
        return plans;
    }
    
}
