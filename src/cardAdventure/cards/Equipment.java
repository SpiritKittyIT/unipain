package cardAdventure.cards;

import cardAdventure.encounters.Combatant;
import cardAdventure.modifiers.Modifier;

/**
* Class to represent equipment cards that grant modifiers to the cards user.
* extends Card.
*/
public class Equipment extends Card {
    private Modifier modifier;

    /**
    * Constructor for Equipment class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param modifier the modifier that the cards use grants
    */
    public Equipment(String name, String description, Modifier modifier) {
        super(name, description, CardTarget.SELF);
        this.modifier = modifier;
    }

    /**
    * Apply the cards effect on the target.
    * @param playerAction true if the player used it
    * @param user combatant that uset the card
    * @param target the target of the cards effect
    * @return boolean, true if the caster cannot play this card again during this combat
    */
    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have equipped " + this.getName());
        } else {
            System.out.println("your opponent has equipped " + this.getName());
        }

        target.addModifier(this.modifier);

        return true;
    }
}
