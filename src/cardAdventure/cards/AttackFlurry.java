package cardAdventure.cards;

import cardAdventure.encounters.Combatant;
import cardAdventure.modifiers.ModifierType;

/**
* Class to represent attack cards that deal multiple instances of damage to the opponent.
* extends Card.
*/
public class AttackFlurry extends Card {
    private int damage;
    private int attackCount;

    /**
    * Constructor for AttackFlurry class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param damage value of the damage that the unmodified card effect does
    * @param attackCount number of the instances of damage
    */
    public AttackFlurry(String name, String description, int damage, int attackCount) {
        super(name, description, CardTarget.OPPONENT);
        this.damage = damage;
        this.attackCount = attackCount;
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

        for (int i = 0; i < this.attackCount; i++) {
            int damageModified = user.applyModifiers(this.damage, target, ModifierType.ATTACK);
            damageModified = target.applyModifiers(damageModified, target, ModifierType.DEFENCE);

            target.dealDamage(damageModified);
        }
        
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
    * Any <b>{c}</b> in the describtion is replaced by the number of the instances of damage.
    * @return String, the describtion of the card
    */
    @Override
    public String getDescription() {
        return super.getDescription()
            .replaceAll("\\{d}", "" + this.damage)
            .replaceAll("\\{c}", "" + this.attackCount);
    }
}
