package cards;

import encounters.Combatant;

public class Attack extends Card {
    private int damage;

    public Attack(String name, String description, int damage) {
        super(name, description, CardType.ATTACK);
        this.damage = damage;
    }

    @Override
    public void use(boolean playerAction, Combatant combatant) {
        combatant.dealDamage(this.damage);
        
        if (playerAction) {
            System.out.println("you have attacked with " + this.getName() + " dealing " + this.damage + " damage and leaving your opponent with " + combatant.getHp() + "hp");
        } else {
            System.out.println("your opponent has attacked with " + this.getName() + " dealing " + this.damage + " damage and leaving you with " + combatant.getHp() + "hp");
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{d}", "" + this.damage);
    }
}
