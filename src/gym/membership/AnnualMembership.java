/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.membership;

import gym.paymentplan.PaymentPlan;
import gym.payment.PaymentPlanType;
import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */
public class AnnualMembership extends Membership {
    static final double pricePerYear = 700;
    
    public AnnualMembership() {
        super();
        membershipType = MembershipType.ANNUAL;
    }
    
    @Override
    public String getDescription() {
        return "This membership is an Annual Membership" ;
    }
    
    @Override
    public double getIndividualPaymentAmount() {
        return pricePerYear; // $700
    }
    
    @Override
    public double getTotalPaymentAmount() {
        return pricePerYear; // $700 for year
    }
    
    @Override
    public ArrayList<PaymentPlanType> getAvailablePlans() {
        ArrayList<PaymentPlanType> plans = new ArrayList();
        plans.add(PaymentPlanType.QUARTERLY);
        plans.add(PaymentPlanType.MONTHLY);
        return plans;
    }
}
