package cardAdventure.creatures;

import java.util.ArrayList;

import cardAdventure.cards.Card;

/**
* Abstract class to represent creatures that can become a combatant.
*/
public abstract class Creature {
    private int maxHp;
    private int hp;
    private ArrayList<Card> cards;
    private String name;

    /**
    * Default constructor for Creature class members.
    * @param maxHp max hp of the creature
    * @param cards ArrayList of cards that the creature can play as a combatant
    * @param name name of the creature
    */
    public Creature(int maxHp, ArrayList<Card> cards, String name) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.cards = cards;
        this.name = name;
    }

    /**
    * Gets the cards of the creature.
    * @return ArrayList<Card>, the cards of the creature
    */
    public ArrayList<Card> getCards() {
        return new ArrayList<Card>(this.cards);
    }

    /**
    * Adds a card to the creatures list of cards.
    * @param card the card to add
    */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
    * Remoces a card from the creatures list of cards.
    * @param card the card to remove
    */
    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    /**
    * Gets the current hp of the creature.
    * @return int, the current hp of the creature
    */
    public int getHp() {
        return this.hp;
    }

    /**
    * Gets the max hp of the creature.
    * @return int, the current hp of the creature
    */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
    * Adds hp to the creature, cannot exceed its max hp.
    * @param hp the hp to add
    */
    public void addHp(int hp) {
        this.hp += hp;

        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    /**
    * Adds max hp to the creature, current hp changes proportionally.
    * @param hp the hp to add
    */
    public void addMaxHp(int maxHp) {
        float ratio = (float)this.hp / this.maxHp;
        this.maxHp += maxHp;
        this.hp = Math.round(this.hp * ratio);
    }

    /**
    * Gets the name of the creature.
    * @return String, the name of the creature
    */
    public String getName() {
        return this.name;
    }
}
