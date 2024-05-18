package statusEffects;

import encounters.Combatant;

public class Confused extends StatusEffect {
    public Confused(int stacks) {
        super(StatusType.CONFUSED, stacks);
    }

    @Override
    public void activate(Combatant combatant) {
        combatant.addDrawCount(-1);
        this.addStacks(-1);
    }
}
