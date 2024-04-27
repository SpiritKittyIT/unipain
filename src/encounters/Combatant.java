package encounters;

import java.util.ArrayList;
import java.util.Random;

import cards.Card;
import creatures.Creature;

public class Combatant {
    private Creature creature;
    private ArrayList<Card> cards;
    private int deckLast;
    private int handFirst;

    public Combatant(Creature creature) {
        this.creature = creature;
        this.cards = creature.getCards();
        this.deckLast = this.cards.size() - 1;
        this.handFirst = this.cards.size();
    }

    public void onTurnStart() {
        for (int index = 0; index < 3; index++) {
            this.drawCard();
        }
    }

    private void swapCards(int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        Card temporal = this.cards.get(index1);
        this.cards.set(index1, this.cards.get(index2));
        this.cards.set(index2, temporal);
    }

    private void drawCard() {
        if (this.deckLast < 0) {
            return;
        }
        Random random = new Random();
        int index = random.nextInt(this.deckLast + 1);

        this.swapCards(index, this.deckLast);
        this.swapCards(this.deckLast, --this.handFirst);
    }

    public void playFromHand(boolean playerAction, int index, Combatant opponent) {
        if (this.isHandEmpty()) {
            System.out.println("you cant play with an empty hand, end the round");
            return;
        }
        if (index >= this.handFirst + this.cards.size()) {
            System.out.println("you cant play a nonexistent card, stoopid");
            return;
        }
        
        this.swapCards(this.handFirst, this.handFirst + index);

        Card card = this.cards.get(this.handFirst++);
        switch (card.getType()) {
            case ATTACK:
                card.use(playerAction, opponent);
                break;
            case EQUIPMENT:
                card.use(playerAction, this);
                break;
        
            default:
                break;
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.swapCards(this.handFirst, this.cards.size());
        this.swapCards(this.handFirst++, ++this.deckLast);
    }

    public void dealDamage(int damage) {
        this.creature.addHp(-damage);
    }

    public void heal(int hp) {
        this.creature.addHp(hp);
    }

    public int getHp() {
        return this.creature.getHp();
    }

    public void listHand() {
        if (this.isHandEmpty()) {
            System.out.println("your hand is as empty as your brain, end the round");
            return;
        }
        for (int i = 0; i < this.cards.size() - this.handFirst; i++) {
            Card card = this.cards.get(i + this.handFirst);
            System.out.println(i + " - (" + card.getName() + ": " + card.getDescription());
        }
    }

    public boolean isHandEmpty() {
        return this.handFirst >= this.cards.size();
    }
}
