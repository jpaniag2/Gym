/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/**
 *
 * @author juliopaniagua
 */
public enum ActivityType {
    
    NOPREFERENCE("No Preference"),
    WEIGHTS("Weights"),
    AEROBIC("Aerobic"),
    SPINCLASSES("Spinclasses"),
    KICKBOXING("Kickboxing");
    
    private final String text;

    ActivityType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
