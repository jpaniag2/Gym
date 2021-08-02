/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.membership;

import gym.Member;
import gym.payment.PaymentPlanType;
import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */
public class TrialMembership extends Membership {
    
    private String description;
    private int trialDays = 7;
    

    public TrialMembership() {
        super();
        membershipType = MembershipType.TRIALMEMBERSHIP;
    }

    public int getTrialDays() {
        return trialDays;
    }
    
    @Override
    public String getDescription(){
        return "This Membership includes access to all Charlotte facilities for only ONE WEEK" ;
    }
    
    @Override
    public double getIndividualPaymentAmount() {
        return 0; // FREE
    }
    
    @Override
    public double getTotalPaymentAmount() {
        return 0; // FREE
    }
    
    @Override
    public ArrayList<PaymentPlanType> getAvailablePlans() {
        return new ArrayList(); // No payment plans available
    }
}
