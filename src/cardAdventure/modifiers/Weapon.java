package cardAdventure.modifiers;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Weapon.
* extends Modifier
*/
public class Weapon extends Modifier {
    /**
    * Default constructor for Weapon class members.
    * @param name the name of the modifier
    * @param value strength of the modifier
    */
    public Weapon(String name, int value) {
        super(ModifierType.ATTACK, name, value);
    }

    /**
    * Apply the effect of the modifier.
    * @param damage the damage to modify
    * @param combatant the target to use certain modifier effects on
    * @return int, modified damage
    */
    @Override
    public int apply(int damage, Combatant combatant) {
        return damage + this.getValue();
    }
}
