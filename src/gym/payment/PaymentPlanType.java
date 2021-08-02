/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.payment;

/**
 *
 * @author juliopaniagua
 */
public enum PaymentPlanType {
    
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly");
    
    private final String text;

    PaymentPlanType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
