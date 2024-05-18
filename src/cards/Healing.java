package cards;

import encounters.Combatant;

public class Healing extends Card {
    private int health;

    public Healing(String name, String description, int health) {
        super(name, description, CardTarget.SELF);
        this.health = health;
    }

    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        target.heal(this.health);
        
        if (playerAction) {
            System.out.println("you have " + target.getHp() + " hp left");
        } else {
            System.out.println("your opponent has " + target.getHp() + " hp left");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{h}", "" + this.health);
    }
}
