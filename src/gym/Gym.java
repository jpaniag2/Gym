/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import gym.membership.MembershipType;
import gym.paymentplan.MonthlyPaymentPlan;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juliopaniagua
 */

public class Gym {
    // Gym info
    private String name;
    
    // Data Store
    private ArrayList<Member> memberList = new ArrayList<>();
    
    public Gym(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Method used to initialize the Gym System.
     */
    
    public void startGymSystem() {
        displayGymWelcomeMessage();
        displayMainMenu();
   
    }
   
    /**
     * Method displays welcome message.
     */
    
    public void displayGymWelcomeMessage() {
        System.out.println("Welcome to Julio's Awesome Gym!");
    }
    
    /**
     * Method to display the main menu.
     */
    
    public void displayMainMenu() {
        /*
        ASK THE USER TO INPUT A NUMBER THAT REPRESENTS THE OPTION THEY WOULD LIKE TO INITIALIZE FROM THE CHOICES SHOWN.
        IF 1 IS ENTERED. 
            CALL ON THE ADD MEMBER METHOD AND PROCEED TO ADDING A MEMBER.
        ELSE IF 2 IS ENTERED
            FIND A MEMBER FROM THE ARRAYLIST CREATED
            IF NO MEMBER FOUND RETURN TO MAIN MENU
        ELSE IF 3 IS ENTERED 
            PROCEED TO MAKE A PAYMENT IF AND ONLY IF MEMBER IS FOUND AND HAS AN ACTIVE AND/OR VALID MEMBERSHIP.
            IF NO VALID/ACTIVE MEMBERSHIP OR MEMBER NOT FOUND 
                RETURN TO MAIN MENU
        */
        System.out.println("To start, type a number from the list below:");
        System.out.println("1. Add Member, 2. Find Member, 3, Make payment");

        //User Input
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        switch (selection) {
            case 1:
                addMemberAction();
                break;
            case 2:
                Member member = findMemberAction();
                displayMemberOptionsAction(member);
                break;
            case 3:
                Member member1 = findMemberAction();
                
                System.out.print(member1.getMembership().getPayment().getPaymentInfo());
                
                double currentBalance = member1.getMembership().getPayment().getCurrentBalance();
                
                if (currentBalance > 0) {
                    UserPrompts.displayPaymentConfirmation(currentBalance);
                    member1.getMembership().getPayment().makePayment(currentBalance);
                    System.out.println("Payment Successfull");
                } else {
                    System.out.println("Account has $0 balance");
                }
                
                displayMemberOptionsAction(member1);
                
                break;
            default:
                System.out.println("This option is not available. Please try again");
                displayMainMenu();
                break;
        }
    }
    
    
    /**
     * Method starts add member operation.
     */
    
    public void addMemberAction() {
        
        /*
        THIS METHOD ADDS A NEW MEMBER WITH AN ACTIVITY TYPE AND MEMBERSHIPTYPE. 
        
        ASK THE USER TO ENTER THE NEW MEMBERS NAME
        ASK THE USER FOR THE MEMBERS GYM ACTIVITY PREFERENCE
            PICK A NUMBER THAT REPRESENTS ONE OF THE ACTIVITIES SHOWN IN THE WINDOW.
        ADD MEMBER TO MEMBERLIST    
        AUTOMATICALLY ASIGN MEMBER WITH A "NO MEMBERSHIP" STATUS IN CASE THEY ARE UNDECIDED AT THE TIME.
        ASK IF MEMBER WOULD LIKE TO CREATE A MEMBERSHIP 
            IF SELECTED PROCEED TO CREATING MEMBERSHIP PROCESS.
        ASK IF MEMBER WOULD LIKE TO SEE MEMBERSHIP INFORMATION
            IF SELECTED PRINT MEMBERSHIP INFORMATION.
            IF NO MEMBERSHIP TO SHOW RETURN TO MAIN MENU.
        ASK IF MEMBER WOULD LIKE TO RETURN TO MAIN MENU
            IF SELECTED RETURN TO MAIN MENU.
        */
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter new member name:");
        String memberName = input.nextLine();
        System.out.println();
        
        ActivityType activityType = UserPrompts.getMemberActivityPrompt();
        Member newMember = new Member(memberName, activityType);
        memberList.add(newMember);
        
        System.out.println("Member created successfully");

        int option = UserPrompts.displayMemberOptions(newMember);
        
        switch (option) {
            case 1:
                createMembershipForMemberAction(newMember);
                break;
            case 9:
                displayMainMenu();
                break;
        }
        
    }
    
    /**
     * Method begins creating a Membership for unique member.
     * @param member 
     */
    
    public void createMembershipForMemberAction(Member member) {
        MembershipType membershipType = UserPrompts.getMembershipTypePrompt(member.isTrialMembershipAvailable());
        member.startMembership(membershipType);
        
        // TODO: Add step to select payment plan type
        member.getMembership().activateMembership(new MonthlyPaymentPlan());
         
        displayMemberOptionsAction(member);
    }
    

    /**
     * Method used to search for a member.
     */
    
    public Member findMemberAction() {
        
        /*
        THIS METHOD USES INPUT TO FIND A MEMBER FROM THE ARRAYLIST AND PRINT OUT GENERIC INFORMATION ABOUT THE MEMBER.
        
        ASK USER TO ENTER MEMBERS NAME FOR SEARCH
            ITERATE THROUGH THE MEMBER ARRAYLIST TO FIND MATCHING CHARACTERS
            IF FOUND:  DISPLAY MEMBERS NAME, ACTIVITY PREFERENCE, AND MEMBERSHIP TYPE.
            IF NOT FOUND: DISPLAY "MEMBER NOT FOUND" MESSAGE AND RETURN TO FIND MEMBER MENU.
        */
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Member's Name");
        String name = input.nextLine();
        System.out.println();

        Member member = null;

        for (Member foundMem : memberList) {
            if (foundMem.getName().regionMatches(true, 0, name, 0, 4)) {
                member = foundMem;
                break;
            }
        }
        
        if (member != null) {
            System.out.println("Member Profile: " + member.getProfile() + ".");
            return member;
        } else {
            System.out.println("Member could not be found.");
            return findMemberAction();
        }
    }
    
    /**
     * Method displays member options once starting Membership creation process.
     * @param member 
     */
    
    public void displayMemberOptionsAction(Member member) {
        int option = UserPrompts.displayMemberOptions(member);
                if(option == 1) {
                    createMembershipForMemberAction(member);
                } else if (option == 2) {
                    System.out.println(member.getMembership().getDescription());
                    int membershipOption = UserPrompts.displayMembershipOptions();
                    
                    if (membershipOption == 1) {
                        System.out.println(member.getMembership().getPayment().getPaymentInfo());
                        double currentBalance = member.getMembership().getPayment().getCurrentBalance();
                
                        if (currentBalance > 0) {
                            boolean confirmPayment = UserPrompts.displayPaymentConfirmation(currentBalance);
                            if (confirmPayment) {
                                member.getMembership().getPayment().makePayment(currentBalance);
                                System.out.println("Payment Successfull");
                            }   
                        } else {
                            System.out.println("Account has $0 balance");
                        }
                        
                        displayMemberOptionsAction(member);
                    } else if (membershipOption == 2) {
                        System.out.println(member.getMembership().getPayment().getPaymentInfo());
                        displayMemberOptionsAction(member);
                    } else if (membershipOption == 3) {
                        System.out.println(member.getMembership().getPayment().getCurrentBalance());
                        displayMemberOptionsAction(member);
                    } else {
                        displayMainMenu();
                    }
                } else {
                    displayMainMenu();
                }
    }
    
    /**
     * Mock TEST-METHOD to find members with trial memberships.
     * @return 
     */
    public ArrayList<Member> findMembersWithTrialMemberships() {
        ArrayList<Member> memberSearchResults = new ArrayList<>();
        for (Member foundMem : memberList) {
            if (foundMem.getMembership().getMembershipType() == MembershipType.TRIALMEMBERSHIP) {
                memberSearchResults.add(foundMem);
            }
        }
        
        return memberSearchResults;
    }
    
    /**
     * Mock TEST-METHOD to display members with trial memberships.
     */
    
    public void displayMembersWithTrialMemberships() {
        ArrayList<Member> memberResults = findMembersWithTrialMemberships();
        System.out.println("There are " + memberResults.size()+ " members with trial memberships.");
        for(Member mem: memberResults){
            System.out.println(mem.getProfile() );
        }
    }
}