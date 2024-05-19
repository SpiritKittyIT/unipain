package cardAdventure.cards;

import cardAdventure.encounters.Combatant;

/**
* Abstract class to represent playable cards.
*/
public abstract class Card {
    private String name;
    private String description;
    private CardTarget type;

    /**
    * Default constructor for Card class members.
    * @param name the name of the card
    * @param description the cards describtion
    * @param type cards target type (if the caster uses it on themselves or the opponent)
    */
    public Card(String name, String description, CardTarget type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
    * Apply the cards effect on the target.
    * @param playerAction true if the player used it
    * @param user combatant that uset the card
    * @param target the target of the cards effect
    * @return boolean, true if the caster cannot play this card again during this combat
    */
    public abstract boolean use(boolean playerAction, Combatant user, Combatant target);
    
    /**
    * Gets the name of the card.
    * @return String, the name of the card
    */
    public String getName() {
        return this.name;
    }

    /**
    * Gets the describtion of the card.
    * @return String, the describtion of the card
    */
    public String getDescription() {
        return this.description;
    }

    /**
    * Gets the target type of the card.
    * @return CardTarget, the target type of the card
    */
    public CardTarget getTarget() {
        return this.type;
    }
}
