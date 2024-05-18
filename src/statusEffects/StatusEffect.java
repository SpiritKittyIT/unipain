package statusEffects;

import encounters.Combatant;

public abstract class StatusEffect {
    private StatusType type;
    private int stacks;

    public StatusEffect(StatusType type, int stacks) {
        this.type = type;
        this.stacks = stacks;
    }

    public StatusType getType() {
        return this.type;
    }

    public boolean merge(StatusEffect statusEffect) {
        if (statusEffect.getType() != this.getType()) {
            return false;
        }

        this.addStacks(statusEffect.getStacks());
        return true;
    }

    public abstract void activate(Combatant combatant);

    public boolean exhausted() {
        return this.getStacks() > 0;
    }
    
    public int getStacks() {
        return this.stacks;
    }

    public void addStacks(int count) {
        this.stacks += count;
    }
}
