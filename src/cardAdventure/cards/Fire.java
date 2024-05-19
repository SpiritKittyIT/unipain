package cardAdventure.cards;

import cardAdventure.encounters.Combatant;
import cardAdventure.modifiers.ModifierType;
import cardAdventure.statusEffects.Burning;
import cardAdventure.statusEffects.StatusEffect;

/**
* Class to represent attack cards that deal a single of damage and apply the Burning StatusEffect to the opponent.
* extends Card.
*/
public class Fire extends Card {
    private int damage;
    private StatusEffect statusEffect;

    /**
    * Constructor for Fire class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param damage value of the damage that the unmodified card effect does
    * @param stacks number of stacks for the Burning StatusEffect that the card grants
    */
    public Fire(String name, String description, int damage, int stacks) {
        super(name, description, CardTarget.OPPONENT);
        this.statusEffect = new Burning(stacks);
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
        target.addStatusEffect(this.statusEffect);
        
        if (playerAction) {
            System.out.println("your opponent has " + target.getHp() + " hp left " + " and is now burning(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have " + target.getHp() + " hp left " + " and are now burning(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    /**
    * Gets the describtion of the card.
    * Any <b>{d}</b> in the describtion is replaced by the cards unmodified damage.
    * Any <b>{s}</b> in the describtion is replaced by the number of stacks for the Burning StatusEffect that the card grants.
    * @return String, the describtion of the card
    */
    @Override
    public String getDescription() {
        return super.getDescription()
            .replaceAll("\\{d}", "" + this.damage)
            .replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
