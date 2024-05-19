package cardAdventure.encounters;

import java.util.ArrayList;
import java.util.Random;

import cardAdventure.cards.Card;
import cardAdventure.cards.CardTarget;
import cardAdventure.creatures.Creature;
import cardAdventure.modifiers.Modifier;
import cardAdventure.modifiers.ModifierType;
import cardAdventure.statusEffects.StatusEffect;

/**
* Class to represent the Combatant.
*/
public class Combatant {
    private Creature creature;

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;
    
    private ArrayList<StatusEffect> statusEffects;
    private ArrayList<Modifier> modifiers;
    private int drawCount;

    /**
    * Default constructor for Combatant class members.
    * @param creature creature to become Combatant
    */
    public Combatant(Creature creature) {
        this.creature = creature;
        this.deck = creature.getCards();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.drawCount = 3;

        this.statusEffects = new ArrayList<>();
        this.modifiers = new ArrayList<>();
    }

    /**
    * Triggers all happenings that should happen on turn start.
    */
    public void onTurnStart() {
        System.out.println(this.creature.getName() + " now starts their turn");

        this.deck.addAll(this.discard);
        this.discard.clear();

        int index = 0;
        while (index < this.statusEffects.size()) {
            this.statusEffects.get(index).activate(this);
            if (this.statusEffects.get(index).exhausted()) {
                this.statusEffects.remove(index);
            } else {
                index++;
            }
        }

        for (index = 0; index < this.drawCount; index++) {
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

    /**
    * play a card from hand
    * @param playerAction true if player is playing
    * @param index the index of the card on hand to play
    * @param opponent the opponent
    */
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

        boolean notRepeatable = false;
        notRepeatable = card.use(playerAction, this, card.getTarget() == CardTarget.OPPONENT ? opponent : this);

        if (notRepeatable) {
            return;
        }

        this.discard.add(card);
    }

    /**
    * adds a card to combatants dect
    * @param card the card to add
    */
    public void addCard(Card card) {
        this.deck.add(card);
    }

    /**
    * adds a modifier to combatant
    * @param modifier the modifier to add
    */
    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    /**
    * adds a statusEffect to combatant
    * @param statusEffect the statusEffect to add
    */
    public void addStatusEffect(StatusEffect statusEffect) {
        for (StatusEffect se : this.statusEffects) {
            if (se.merge(statusEffect)) {
                return;
            }
        }

        this.statusEffects.add(statusEffect);
    }

    /**
    * adds a number of cards to draw on the start of each turn
    * @param count the count to add to draws
    */
    public void addDrawCount(int count) {
        this.drawCount += count;
    }

    /**
    * applies modifiers to the damage instance
    * @param damage unmodified damage
    * @param combatant the target of certain modifiers
    * @param type ModifierType
    * @return int, modified damage
    */
    public int applyModifiers(int damage, Combatant combatant, ModifierType type) {
        for (Modifier modifier : this.modifiers) {
            if (modifier.getType() == type) {
                damage = modifier.apply(damage, combatant);
            }
        }

        return damage;
    }

    /**
    * deal damage to self
    * @param damage damage to deal
    */
    public void dealDamage(int damage) {
        this.creature.addHp(-damage);
        
        System.out.println("The attack has dealt " + damage + " damage");
    }

    /**
    * deal healing to self
    * @param hp damage to heal
    */
    public void heal(int hp) {
        this.creature.addHp(hp);
        
        System.out.println(hp + " health has been restored");
    }

    /**
    * get current hp
    * @return int, current hp
    */
    public int getHp() {
        return this.creature.getHp();
    }

    /**
    * writes all the cards in hand
    */
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

    /**
    * returns rue if hand is empty
    * @return boolean, true if hand is empty
    */
    public boolean isHandEmpty() {
        return this.hand.isEmpty();
    }
}
