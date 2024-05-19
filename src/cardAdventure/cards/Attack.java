package cardAdventure.cards;

import cardAdventure.encounters.Combatant;
import cardAdventure.modifiers.ModifierType;

/**
* Class to represent attack cards that deal a single instance of damage to the opponent.
* extends Card.
*/
public class Attack extends Card {
    private int damage;

    /**
    * Constructor for Attack class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param damage value of the damage that the unmodified card effect does
    */
    public Attack(String name, String description, int damage) {
        super(name, description, CardTarget.OPPONENT);
        this.damage = damage;
    }

    /**
    * Apply the cards effect on the target.
    * Effect is modified by modifiers of user and target.
    * @param playerAction true if the player used it
    * @param user combatant that uset the card
    * @param target the target of the cards effect
    * @return boolean, true if the caster cannot play this card again during this combat
    */
    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        int damageModified = user.applyModifiers(this.damage, target, ModifierType.ATTACK);
        damageModified = target.applyModifiers(damageModified, target, ModifierType.DEFENCE);

        target.dealDamage(damageModified);
        
        if (playerAction) {
            System.out.println("your opponent has " + target.getHp() + " hp left");
        } else {
            System.out.println("you have " + target.getHp() + " hp left");
        }

        return false;
    }

    /**
    * Gets the describtion of the card.
    * Any <b>{d}</b> in the describtion is replaced by the cards unmodified damage.
    * @return String, the describtion of the card
    */
    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{d}", "" + this.damage);
    }
}
