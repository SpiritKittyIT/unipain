import cards.Card;
import creatures.Monster;
import creatures.Player;
import encounters.Encounter;
import encounters.Shop;
import global.PlayerGlobal;
import global.Reader;

import java.util.ArrayList;

import cards.Attack;

public class Main {

    public static void main(String[] args) {
        PlayerGlobal.init(new Player(10, new ArrayList<Card>()));
        Monster mon1 = new Monster(10, new ArrayList<Card>());
        Monster mon2 = new Monster(10, new ArrayList<Card>());
        Monster mon3 = new Monster(10, new ArrayList<Card>());

        Card attBackhand = new Attack("Backhand slap", "Give your opponent a backhand slap dealing {d} damage and lowering their self esteem", 3);
        Card attScratch = new Attack("Claw scratch", "Scratch your opponent with your claw dealing {d} damage", 3);
        Card attBite = new Attack("Ankle bite", "Bite the ankles of your opponent dealing {d} damage and lowering their mobility", 2);

        for (int i = 0; i < 3; i++) {
            PlayerGlobal.getPlayer().addCard(attBackhand);
        }

        for (int i = 0; i < 3; i++) {
            mon1.addCard(attScratch);
        }
        for (int i = 0; i < 5; i++) {
            mon2.addCard(attBite);
        }
        for (int i = 0; i < 4; i++) {
            mon3.addCard(attBackhand);
        }

        ArrayList<Card> shop1Cards = new ArrayList<>();
        ArrayList<Integer> shop1Prices = new ArrayList<>();
        shop1Cards.add(attBackhand);
        shop1Prices.add(5);
        Encounter shop1 = new Shop("Shop", "A place to buy stuff", shop1Cards, shop1Prices);

        ArrayList<Encounter> level1Encounters = new ArrayList<>();
        level1Encounters.add(shop1);

        Level level1 = new Level(level1Encounters);
        level1.start();

        Reader.ensureClose();
    }
}