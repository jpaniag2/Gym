/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import gym.membership.MembershipType;
import java.util.Scanner;

/**
 *
 * @author juliopaniagua
 */
public class UserPrompts {
    
    /**
     * Method takes user input to select Activity preference.
     * @return ActivityType
     */
    
    static public ActivityType getMemberActivityPrompt() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please select an ACTIVITY preference(1.Weights, 2.Aerobics, 3.Spinclasses, or 4.Kickboxing):");
        int activitySelection = input.nextInt();
        
        ActivityType activityType;

        switch (activitySelection) {
            case 1:
                activityType = ActivityType.WEIGHTS;
                break;
            case 2:
                activityType = ActivityType.AEROBIC;
                break;
            case 3:
                activityType = ActivityType.SPINCLASSES;
                break;
            case 4:
                activityType = ActivityType.KICKBOXING;
                break;
            default:
                System.out.println("ERROR! Pick one of the four options");
                activityType = getMemberActivityPrompt();
                break;
        }
        
        return activityType;
    }
    
    /**
     * Method takes user input to select Membership preference.
     * @param trialAvailable
     * @return 
     */
    
    static MembershipType getMembershipTypePrompt(boolean trialAvailable) {
        Scanner input = new Scanner(System.in);
        
        MembershipType membershipType;

        System.out.println("PLEASE SELECT A MEMBERSHIP FROM BELOW");
        System.out.println("1. Montly membership 2. 3-Month Membership 3. Annual Membership 4. Trial membership");

        int membershipSelected = input.nextInt();
        
        switch (membershipSelected) {
            case 1:
                System.out.println("Monthly");
                membershipType = MembershipType.MONTHLYMEMBERSHIP;
                break;
            case 2:
                System.out.println("3-Month");
                membershipType = MembershipType.THREEMONTHMEMBERSHIP;
                break;
            case 3:
                System.out.println("Annual");
                membershipType = MembershipType.ANNUAL;
                break;
            case 4:
                if (trialAvailable) {
                    System.out.println("Trial");
                    membershipType = MembershipType.TRIALMEMBERSHIP;
                } else {
                    System.out.println("ERROR! You've used your TRIAL before, select another option");
                    membershipType = getMembershipTypePrompt(trialAvailable);
                }
                break;
            default:
                System.out.println("ERROR! Pick a membership from the option");
                membershipType = getMembershipTypePrompt(trialAvailable);
                break;
        }
        return membershipType;
    }
    
    /**
     * Method takes user input to select Member's window option.
     * @param member
     * @return int
     */
    
    static int displayMemberOptions(Member member) {
        Scanner input = new Scanner(System.in);
        if (member.getMembership() == null) {
            System.out.println("1.Start Membership, 2. Get membership info, 9. Return to Main Menu.");
            int option = input.nextInt();
            if (option == 1 || option == 2 || option == 9) {
                return option;
            } else {
                return displayMemberOptions(member);
            }
        } else {
            System.out.println("2. Get membership info, 9. Return to Main Menu.");
            int option = input.nextInt();
            if (option == 2 || option == 9) {
                return option;
            } else {
                return displayMemberOptions(member);
            }
        }
        
        
    }
    
    /**
     * Method takes user input to select a Membership option.
     * @return 
     */
    
    static int displayMembershipOptions() {
        Scanner input = new Scanner(System.in);
        System.out.println("1.Make Payment, 2. Account status, 3 Balance, 9. Return to Main Menu.");
        return input.nextInt();
    }
    
    static boolean displayPaymentConfirmation(double balance) {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to make a payment for the amount of "+ balance +"?");
        System.out.println("1.YES, 2. NO");
        
        int option = input.nextInt();
        if (option == 1 || option == 2) {
            return (option == 1);
        } else {   
            return displayPaymentConfirmation(balance);
        }   
    }
    
}
