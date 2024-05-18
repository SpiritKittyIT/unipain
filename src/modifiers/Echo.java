package modifiers;

import encounters.Combatant;

public class Echo extends Modifier {
    public Echo(String name, int value) {
        super(ModifierType.ATTACK, name, value);
    }

    @Override
    public int apply(int damage, Combatant combatant) {
        System.out.println("An echo(" + this.getValue() + ") has activated");
        combatant.dealDamage(this.getValue(), false);
        return damage;
    }
}
