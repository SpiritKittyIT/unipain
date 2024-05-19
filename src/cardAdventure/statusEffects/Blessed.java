package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Blessed StatusEffect.
* extends StatusEffect
*/
public class Blessed extends StatusEffect {
    /**
    * Default constructor for Blessed class members.
    * @param stacks number of stacks of the StatusEffect
    */
    public Blessed(int stacks) {
        super(StatusType.BLESSED, stacks);
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    @Override
    public void activate(Combatant combatant) {
        System.out.println("Blessed(" + this.getStacks() + ") has activated");
        combatant.heal(2);
        this.addStacks(-2);
    }
}
