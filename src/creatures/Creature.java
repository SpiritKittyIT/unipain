package creatures;

import java.util.ArrayList;

import cards.Card;

public abstract class Creature {
    private int maxHp;
    private int hp;
    private ArrayList<Card> cards;

    public Creature(int maxHp, ArrayList<Card> cards) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<Card>(this.cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void addHp(int hp) {
        this.hp += hp;

        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void addMaxHp(int maxHp) {
        this.maxHp += maxHp;
    }
}
