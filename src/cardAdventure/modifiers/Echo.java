package cardAdventure.modifiers;

import cardAdventure.encounters.Combatant;

/**
* Class to represent Echo.
* extends Modifier
*/
public class Echo extends Modifier {
    /**
    * Default constructor for Echo class members.
    * @param name the name of the modifier
    * @param value strength of the modifier
    */
    public Echo(String name, int value) {
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
        System.out.println("An echo(" + this.getValue() + ") has activated");
        combatant.dealDamage(this.getValue());
        return damage;
    }
}
