package cardAdventure.cards;

import cardAdventure.encounters.Combatant;
import cardAdventure.statusEffects.Confused;
import cardAdventure.statusEffects.StatusEffect;

/**
* Class to represent status effect cards that give the Confused StatusEffect to the user.
* extends Card.
*/
public class Confusion extends Card {
    private StatusEffect statusEffect;

    /**
    * Constructor for Confusion class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param stacks number of stacks for the Confused StatusEffect that the card grants
    */
    public Confusion(String name, String description, int stacks) {
        super(name, description, CardTarget.OPPONENT);
        this.statusEffect = new Confused(stacks);
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

        target.addStatusEffect(this.statusEffect);
        
        if (playerAction) {
            System.out.println("your opponent has been confused(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have been confused(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    /**
    * Gets the describtion of the card.
    * Any <b>{s}</b> in the describtion is replaced by the number of stacks for the Confused StatusEffect that the card grants.
    * @return String, the describtion of the card
    */
    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
