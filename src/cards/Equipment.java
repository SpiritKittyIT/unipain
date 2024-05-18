package cards;

import encounters.Combatant;
import modifiers.Modifier;

public class Equipment extends Card {
    private Modifier modifier;

    public Equipment(String name, String description, Modifier modifier) {
        super(name, description, CardTarget.SELF);
        this.modifier = modifier;
    }

    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have equipped " + this.getName());
        } else {
            System.out.println("your opponent has equipped " + this.getName());
        }

        target.addModifier(this.modifier);

        return true;
    }
}
