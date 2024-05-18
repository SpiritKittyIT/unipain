package cards;

import encounters.Combatant;
import modifiers.Modifier;

public class Equipment extends Card {
    private Modifier modifier;

    public Equipment(String name, String description, Modifier modifier) {
        super(name, description, CardTarget.SELF);
    }

    @Override
    public boolean use(boolean playerAction, Combatant combatant) {
        if (playerAction) {
            System.out.println("you have equipped " + this.getName());
        } else {
            System.out.println("your opponent has equipped " + this.getName());
        }

        combatant.addModifier(this.modifier);

        return true;
    }
}
