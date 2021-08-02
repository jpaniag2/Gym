/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.paymentplan;

/**
 *
 * @author juliopaniagua
 */
public class MonthlyPaymentPlan extends PaymentPlan {
    
    public MonthlyPaymentPlan() {
        super();
    }
    
    @Override
    public double getItemPaymentAmount(){
        return YEARLY_PRICE/12;
    }
}
