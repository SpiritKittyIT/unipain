package statusEffects;

import encounters.Combatant;

public class Inspired extends StatusEffect {
    public Inspired(int stacks) {
        super(StatusType.CONFUSED, stacks);
    }

    @Override
    public void activate(Combatant combatant) {
        combatant.addDrawCount(1);
        this.addStacks(-1);
    }
}
