package statusEffects;

import encounters.Combatant;

public class Blessed extends StatusEffect {
    public Blessed(int stacks) {
        super(StatusType.BLESSED, stacks);
    }

    @Override
    public void activate(Combatant combatant) {
        System.out.println("Blessed(" + this.getStacks() + ") has activated");
        combatant.heal(2);
        this.addStacks(-2);
    }
}
