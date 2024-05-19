package cardAdventure.statusEffects;

import cardAdventure.encounters.Combatant;

/**
* Abstract class to represent StatusEffect.
*/
public abstract class StatusEffect {
    private StatusType type;
    private int stacks;

    /**
    * Default constructor for StatusEffect class members.
    * @param type the type of the StatusEffect, used to merge StatusEffects of the same type
    * @param stacks number of stacks of the StatusEffect
    */
    public StatusEffect(StatusType type, int stacks) {
        this.type = type;
        this.stacks = stacks;
    }

    /**
    * Gets the type of the card.
    * @return StatusType, the type of the card
    */
    public StatusType getType() {
        return this.type;
    }

    /**
    * Merge the status effect if it is the same type.
    * @param statusEffect the statusEffect to merge into this one
    * @return boolean, true if the merge is successful
    */
    public boolean merge(StatusEffect statusEffect) {
        if (statusEffect.getType() != this.getType()) {
            return false;
        }

        this.addStacks(statusEffect.getStacks());
        return true;
    }

    /**
    * Activate the statusEffect on the target.
    * @param combatant combatant the is target of the statusEffect
    */
    public abstract void activate(Combatant combatant);

    /**
    * Returns true if the stacks of the statusEffect are 0.
    * @return boolean, true if the stacks of the statusEffect are 0
    */
    public boolean exhausted() {
        return this.getStacks() > 0;
    }
    
    /**
    * Gets the number of stacks of the statusEffect.
    * @return int, the number stacks of the statusEffect
    */
    public int getStacks() {
        return this.stacks;
    }

    /**
    * Adds the number of stacks to the number of stacks of the statusEffect.
    * @param count the number stacks of the statusEffect to add
    */
    public void addStacks(int count) {
        this.stacks += count;
    }
}
