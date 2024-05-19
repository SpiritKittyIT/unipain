package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Burning StatusEffect.
* extends StatusEffect
*/
public class Burning extends StatusEffect {
    /**
    * Default constructor for Burning class members.
    * @param stacks number of stacks of the StatusEffect
    */
    public Burning(int stacks) {
        super(StatusType.BURNING, stacks);
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    @Override
    public void activate(Combatant combatant) {
        System.out.println("Burning(" + this.getStacks() + ") has activated");
        combatant.dealDamage(2);
        this.addStacks(-2);
    }
}
