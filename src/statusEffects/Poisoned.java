package statusEffects;

import encounters.Combatant;

public class Poisoned extends StatusEffect {
    public Poisoned(int stacks) {
        super(StatusType.POISONED, stacks);
    }

    @Override
    public void activate(Combatant combatant) {
        System.out.println("Poison(" + this.getStacks() + ") has activated");
        int stacksConsumed = (int)Math.ceil(this.getStacks() / 2.0);
        combatant.dealDamage(stacksConsumed, false);
        this.addStacks(-stacksConsumed);
    }
}
