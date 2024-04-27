package creatures;

import java.util.ArrayList;

import cards.Card;

public class Player extends Creature {
    private int gold;

    public Player(int maxHp, ArrayList<Card> cards) {
        super(maxHp, cards, "Player");
        this.gold = 0;
    }

    public int getGold() {
        return this.gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }
}
