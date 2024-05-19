package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Confused StatusEffect.
* extends StatusEffect
*/
public class Confused extends StatusEffect {
    /**
    * Default constructor for Confused class members.
    * @param stacks number of stacks of the StatusEffect
    */
    public Confused(int stacks) {
        super(StatusType.CONFUSED, stacks);
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    @Override
    public void activate(Combatant combatant) {
        combatant.addDrawCount(-1);
        this.addStacks(-1);
    }
}
