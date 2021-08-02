/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import gym.payment.Payment;
import gym.membership.*;
import java.util.ArrayList;

/**
 *
 * @author juliopaniagua
 */
public class Member {
    private String name;
    private int accountNumber;
    private ActivityType activityType;
    
    private Payment payment;
    private Membership membership;
    private boolean trialMembershipAvailable = true;

    public Member(String name) {
        this.name = name;
        this.activityType = ActivityType.NOPREFERENCE;
    }
    
    public Member(String name, ActivityType activityType, MembershipType membershipType) {
        this.name = name;
        this.activityType = activityType;
    }
    
    public Member(String name, ActivityType activityType) {
        this.name = name;
        this.activityType = activityType;  
    }
    
    public String getProfile(){
        String profile = name + ", "+ activityType.toString() +", " + membership.getMembershipType().toString();
        return profile;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
        
    public Membership getMembership() {
        return this.membership;
    }
    
    public void startMembership(MembershipType type) {
        switch (type) {
            case MONTHLYMEMBERSHIP:
                this.membership = new MonthlyMembership();
                break;
            case THREEMONTHMEMBERSHIP:
                this.membership = new ThreeMonthMembership();
            break;
            case ANNUAL:
                this.membership = new AnnualMembership();
            break;
            case TRIALMEMBERSHIP:
                if (trialMembershipAvailable) {
                    trialMembershipAvailable = false;
                    this.membership = new TrialMembership();
                }
            break;
        }
    }
    
    public boolean isTrialMembershipAvailable() {
        return this.trialMembershipAvailable;
    }
    
    public boolean hasValidMembership() {
        return (this.membership.getMembershipType() != MembershipType.NOMEMBERSHIP);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
