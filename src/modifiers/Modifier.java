package modifiers;

import encounters.Combatant;

public abstract class Modifier {
    private ModifierType type;
    private String name;
    private int value;

    public Modifier(ModifierType type, String name, int value) {
        this.type = type;
        this.value = value;
    }

    public ModifierType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public abstract int apply(int damage, Combatant combatant);
}
