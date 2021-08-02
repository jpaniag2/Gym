/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.membership;

/**
 *
 * @author juliopaniagua
 */
public enum MembershipType {
    
    TRIALMEMBERSHIP("Trial Membership"),
    THREEMONTHMEMBERSHIP("Three-Month Membership"),
    ANNUAL("Annual Membership"),
    NOMEMBERSHIP("No Membership"),
    MONTHLYMEMBERSHIP("Monthly Membership");
    
    private final String text;

    MembershipType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
}
