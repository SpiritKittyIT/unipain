package cards;

import encounters.Combatant;

public class Attack extends Card {
    private int damage;

    public Attack(String name, String description, int damage) {
        super(name, description, CardTarget.OPPONENT);
        this.damage = damage;
    }

    @Override
    public boolean use(boolean playerAction, Combatant combatant) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        combatant.dealDamage(this.damage, true);
        
        if (playerAction) {
            System.out.println("your opponent has " + combatant.getHp() + " hp left");
        } else {
            System.out.println("you have " + combatant.getHp() + " hp left");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{d}", "" + this.damage);
    }
}
