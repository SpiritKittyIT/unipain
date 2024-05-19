package cardAdventure.cards;

import cardAdventure.encounters.Combatant;

/**
* Class to represent healing cards that deal multiple instances of healing to the user.
* extends Card.
*/
public class Healing extends Card {
    private int health;

    /**
    * Constructor for Healing class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param health value of healing that the card effect does
    * @param attackCount number of the instances of damage
    */
    public Healing(String name, String description, int health) {
        super(name, description, CardTarget.SELF);
        this.health = health;
    }

    /**
    * Apply the cards effect on the target.
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

        target.heal(this.health);
        
        if (playerAction) {
            System.out.println("you have " + target.getHp() + " hp left");
        } else {
            System.out.println("your opponent has " + target.getHp() + " hp left");
        }

        return false;
    }

    /**
    * Gets the describtion of the card.
    * Any <b>{h}</b> in the describtion is replaced by the cards value of healing.
    * @return String, the describtion of the card
    */
    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{h}", "" + this.health);
    }
}
