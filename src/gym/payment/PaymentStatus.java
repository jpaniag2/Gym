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
public enum PaymentStatus {
    
    PASTDUE("Past Due"),
    PAIDINFULL("Paid In Full"),
    PAYMENTDUE("Payment Due"),
    NOSTATUS("Status not available"),
    CURRENT("Current");
    
    private final String text;

    PaymentStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
