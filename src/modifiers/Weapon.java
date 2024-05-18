package modifiers;

import encounters.Combatant;

public class Weapon extends Modifier {
    public Weapon(String name, int value) {
        super(ModifierType.ATTACK, name, value);
    }

    @Override
    public int apply(int damage, Combatant combatant) {
        return damage + this.getValue();
    }
}
