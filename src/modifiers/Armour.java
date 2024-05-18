package modifiers;

import encounters.Combatant;

public class Armour extends Modifier {
    public Armour(String name, int value) {
        super(ModifierType.DEFENCE, name, value);
    }

    @Override
    public int apply(int damage, Combatant combatant) {
        int modifiedDamage = damage - this.getValue();
        return modifiedDamage >= 0 ? modifiedDamage : 0;
    }
}
