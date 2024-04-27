package cards;

import encounters.Combatant;

public abstract class Equipment extends Card {
    public Equipment(String name, String description) {
        super(name, description, CardType.EQUIPMENT);
    }

    @Override
    public void use(boolean playerAction, Combatant combatant) {
        if (playerAction) {
            System.out.println("you have equipped " + this.getName());
        } else {
            System.out.println("your opponent has equipped " + this.getName());
        }
    }
}
