import cards.Card;
import creatures.Monster;
import creatures.Player;
import encounters.Combat;
import encounters.Encounter;
import encounters.Shop;
import global.PlayerGlobal;
import global.Reader;

import java.util.ArrayList;

import cards.Attack;

public class Main {

    public static void main(String[] args) {
        PlayerGlobal.init(new Player(10, new ArrayList<Card>()));
        Monster mon1 = new Monster(10, new ArrayList<Card>(), "mad squirrel");
        Monster mon2 = new Monster(10, new ArrayList<Card>(), "tiny tortoise");
        Monster mon3 = new Monster(10, new ArrayList<Card>(), "ugly bastard");

        Card attBackhand = new Attack("Backhand slap", "Give your opponent a backhand slap dealing {d} damage and lowering their self esteem", 3);
        Card attKick = new Attack("Shin kick", "Kick your opponent in the shin dealing {d} damage and making them wince in pain", 3);
        Card attScratch = new Attack("Claw scratch", "Scratch your opponent with your claw dealing {d} damage", 3);
        Card attBite = new Attack("Ankle bite", "Bite the ankles of your opponent dealing {d} damage and lowering their mobility", 2);

        for (int i = 0; i < 3; i++) {
            PlayerGlobal.getPlayer().addCard(attBackhand);
            PlayerGlobal.getPlayer().addCard(attKick);
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
        Encounter combat1 = new Combat("a very angry tiny tortoise", mon2);

        ArrayList<Encounter> level1Encounters = new ArrayList<>();
        level1Encounters.add(shop1);
        level1Encounters.add(combat1);

        Level level1 = new Level(level1Encounters);
        level1.start();

        Reader.ensureClose();
    }
}