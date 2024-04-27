package creatures;

import java.util.ArrayList;

import cards.Card;

public abstract class Creature {
    private int maxHp;
    private int hp;
    private ArrayList<Card> cards;
    private String name;

    public Creature(int maxHp, ArrayList<Card> cards, String name) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.cards = cards;
        this.name = name;
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
        float ratio = (float)this.hp / this.maxHp;
        this.maxHp += maxHp;
        this.hp = Math.round(this.hp * ratio);
    }

    public String getName() {
        return this.name;
    }
}
