package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Poisoned StatusEffect.
* extends StatusEffect
*/
public class Poisoned extends StatusEffect {
    /**
    * Default constructor for Poisoned class members.
    * @param stacks number of stacks of the StatusEffect
    */
    public Poisoned(int stacks) {
        super(StatusType.POISONED, stacks);
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    @Override
    public void activate(Combatant combatant) {
        System.out.println("Poison(" + this.getStacks() + ") has activated");
        int stacksConsumed = (int)Math.ceil(this.getStacks() / 2.0);
        combatant.dealDamage(stacksConsumed);
        this.addStacks(-stacksConsumed);
    }
}
