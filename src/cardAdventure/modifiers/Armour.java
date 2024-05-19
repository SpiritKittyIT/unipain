package cardAdventure.modifiers;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Armour.
* extends Modifier
*/
public class Armour extends Modifier {
    /**
    * Default constructor for Armour class members.
    * @param name the name of the modifier
    * @param value strength of the modifier
    */
    public Armour(String name, int value) {
        super(ModifierType.DEFENCE, name, value);
    }

    /**
    * Apply the effect of the modifier.
    * @param damage the damage to modify
    * @param combatant the target to use certain modifier effects on
    * @return int, modified damage
    */
    @Override
    public int apply(int damage, Combatant combatant) {
        int modifiedDamage = damage - this.getValue();
        return modifiedDamage >= 0 ? modifiedDamage : 0;
    }
}
