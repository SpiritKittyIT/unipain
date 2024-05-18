package statusEffects;

import encounters.Combatant;

public class Burning extends StatusEffect {
    public Burning(int stacks) {
        super(StatusType.BURNING, stacks);
    }

    @Override
    public void activate(Combatant combatant) {
        System.out.println("Burning(" + this.getStacks() + ") has activated");
        combatant.dealDamage(2, false);
        this.addStacks(-2);
    }
}
