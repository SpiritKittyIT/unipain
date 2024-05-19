package cardAdventure.modifiers;

import cardAdventure.encounters.Combatant;

/**
* Abstract class to represent Modifiers.
*/
public abstract class Modifier {
    private ModifierType type;
    private String name;
    private int value;

    /**
    * Default constructor for Modifier class members.
    * @param type the type of the modifier, used to dertermine if is deffensive or offensive
    * @param name the name of the modifier
    * @param value strength of the modifier
    */
    public Modifier(ModifierType type, String name, int value) {
        this.type = type;
        this.value = value;
    }

    /**
    * Gets the type of the modifier.
    * @return ModifierType, the type of the modifier
    */
    public ModifierType getType() {
        return this.type;
    }

    /**
    * Gets the name of the modifier.
    * @return String, the name of the modifier
    */
    public String getName() {
        return this.name;
    }

    /**
    * Gets the strength of the modifier.
    * @return int, the strength of the modifier
    */
    public int getValue() {
        return this.value;
    }

    /**
    * Apply the effect of the modifier.
    * @param damage the damage to modify
    * @param combatant the target to use certain modifier effects on
    * @return int, modified damage
    */
    public abstract int apply(int damage, Combatant combatant);
}
