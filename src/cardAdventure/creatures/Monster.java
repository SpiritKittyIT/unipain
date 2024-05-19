package cardAdventure.creatures;

import java.util.ArrayList;

import cardAdventure.cards.Card;

/**
* Class to represent monsters that can become a combatant.
* extends Creature
*/
public class Monster extends Creature {
    /**
    * Default constructor for Monster class members.
    * @param maxHp max hp of the creature
    * @param cards ArrayList of cards that the creature can play as a combatant
    * @param name name of the creature
    */
    public Monster(int maxHp, ArrayList<Card> cards, String name) {
        super(maxHp, cards, name);
    }
}
