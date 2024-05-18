package creatures;

import java.util.ArrayList;

import cards.Card;

public class Monster extends Creature {
    public Monster(int maxHp, ArrayList<Card> cards, String name) {
        super(maxHp, cards, name);
    }
}
