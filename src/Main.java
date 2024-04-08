import cards.Card;
import creatures.Player;
import encounters.IEncounter;
import encounters.Shop;

import java.util.ArrayList;

import cards.Attack;

public class Main {

    public static void main(String[] args) {
        Card attBackhand = new Attack("Backhand slap", "Give your opponent a backhand slap dealing {d} damage and lowering their self esteem", 3);

        ArrayList<Card> shop1Cards = new ArrayList<Card>();
        ArrayList<Integer> shop1Prices = new ArrayList<>();
        shop1Cards.add(attBackhand);
        shop1Prices.add(5);
        IEncounter shop1 = new Shop(shop1Cards, shop1Prices);
        shop1.interact(new Player(0, shop1Cards));
    }
}