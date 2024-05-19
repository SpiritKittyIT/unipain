package cardAdventure.creatures;

import java.util.ArrayList;

import cardAdventure.cards.Card;

/**
* Class to represent the player.
* extends Creature
*/
public class Player extends Creature {
    private int gold;

    /**
    * Default constructor for Player class members.
    * @param maxHp max hp of the creature
    * @param cards ArrayList of cards that the creature can play as a combatant
    */
    public Player(int maxHp, ArrayList<Card> cards) {
        super(maxHp, cards, "Player");
        this.gold = 0;
    }

    /**
    * Gets the players current ammount of gold.
    * @return int, the players current ammount of gold
    */
    public int getGold() {
        return this.gold;
    }

    /**
    * Adds to the players current ammount of gold.
    * @param gold the ammount of gold to add
    */
    public void addGold(int gold) {
        this.gold += gold;
    }
}
