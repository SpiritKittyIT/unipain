package encounters;

import java.util.ArrayList;
import java.util.Random;

import cards.Card;
import creatures.Creature;
import modifiers.Modifier;
import statusEffects.StatusEffect;

public class Combatant {
    private Creature creature;

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;
    
    private ArrayList<StatusEffect> statusEffects;
    private ArrayList<Modifier> modifiers;
    private int drawCount;

    public Combatant(Creature creature) {
        this.creature = creature;
        this.deck = creature.getCards();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.drawCount = 3;

        this.statusEffects = new ArrayList<>();
        this.modifiers = new ArrayList<>();
    }

    public void onTurnStart() {
        System.out.println(this.creature.getName() + " now starts their turn");

        this.deck.addAll(this.discard);
        this.discard.clear();

        int effects = this.statusEffects.size();
        for (int index = 0; index < effects; index++) {
            this.statusEffects.get(index).activate(this);
            if (this.statusEffects.get(index).exhausted()) {
                this.statusEffects.remove(index--);
                effects--;
            }
        }

        for (int index = 0; index < this.drawCount; index++) {
            this.drawCard();
        }
        System.out.println(this.drawCount + " cards have been drawn");

        this.drawCount = 3;
    }

    private void drawCard() {
        if (this.deck.isEmpty()) {
            return;
        }
        Random random = new Random();
        int index = random.nextInt(this.deck.size());

        this.hand.add(this.deck.remove(index));
    }

    public void playFromHand(boolean playerAction, int index, Combatant opponent) {
        if (this.isHandEmpty()) {
            System.out.println("you cant play with an empty hand, end the round");
            return;
        }
        if (index >= this.hand.size()) {
            System.out.println("you cant play a nonexistent card, stoopid");
            return;
        }

        Card card = this.hand.remove(index);

        boolean discard = false;
        switch (card.getTarget()) {
            case OPPONENT:
                discard = card.use(playerAction, opponent);
                break;
            case SELF:
                discard = card.use(playerAction, this);
                break;
        
            default:
                break;
        }

        if (discard) {
            return;
        }
        this.discard.add(card);
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    public void addStatusEffect(StatusEffect statusEffect) {
        for (StatusEffect se : this.statusEffects) {
            if (se.merge(statusEffect)) {
                return;
            }
        }

        this.statusEffects.add(statusEffect);
    }

    public void addDrawCount(int count) {
        this.drawCount += count;
    }

    public void dealDamage(int damage, boolean modifiers) {
        if (modifiers) {
            for (Modifier modifier : this.modifiers) {
                damage = modifier.apply(damage, this);
            }
        }
        this.creature.addHp(-damage);
        
        System.out.println("The attack has dealt " + damage + " damage");
    }

    public void heal(int hp) {
        this.creature.addHp(hp);
        
        System.out.println(hp + " health has been restored");
    }

    public int getHp() {
        return this.creature.getHp();
    }

    public void listHand() {
        if (this.isHandEmpty()) {
            System.out.println("your hand is as empty as your brain, end the round");
            return;
        }
        for (int i = 0; i < this.hand.size(); i++) {
            Card card = this.hand.get(i);
            System.out.println(i + " - (" + card.getName() + ": " + card.getDescription());
        }
    }

    public boolean isHandEmpty() {
        return this.hand.isEmpty();
    }
}
