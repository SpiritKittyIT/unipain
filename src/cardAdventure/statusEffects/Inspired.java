package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Inspired StatusEffect.
* extends StatusEffect
*/
public class Inspired extends StatusEffect {
    /**
    * Default constructor for Inspired class members.
    * @param stacks number of stacks of the StatusEffect
    */
    public Inspired(int stacks) {
        super(StatusType.CONFUSED, stacks);
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    @Override
    public void activate(Combatant combatant) {
        combatant.addDrawCount(1);
        this.addStacks(-1);
    }
}
