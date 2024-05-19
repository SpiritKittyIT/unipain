import java.util.ArrayList;

import cardAdventure.Level;
import cardAdventure.cards.Attack;
import cardAdventure.cards.AttackFlurry;
import cardAdventure.cards.Blessing;
import cardAdventure.cards.Card;
import cardAdventure.cards.Confusion;
import cardAdventure.cards.Equipment;
import cardAdventure.cards.Fire;
import cardAdventure.cards.Healing;
import cardAdventure.cards.Inspiration;
import cardAdventure.cards.Poison;
import cardAdventure.creatures.Monster;
import cardAdventure.creatures.Player;
import cardAdventure.encounters.Combat;
import cardAdventure.encounters.Encounter;
import cardAdventure.encounters.Gym;
import cardAdventure.encounters.Shop;
import cardAdventure.encounters.Tavern;
import cardAdventure.global.PlayerGlobal;
import cardAdventure.global.Reader;
import cardAdventure.modifiers.Armour;
import cardAdventure.modifiers.Echo;
import cardAdventure.modifiers.Modifier;
import cardAdventure.modifiers.Weapon;

/**
* Class to represent the Main program.
*/
public class Main {
    /**
    * Method to represent the Main program.
    * @param args arguments of the Main program
    */
    public static void main(String[] args) {
        Monster troll = new Monster(25, new ArrayList<Card>(), "troll");
        Card attClub = new Attack("Attack with a big club", "Give your opponent with a big club dealig {d} damage", 5);
        Card attSpit = new Poison("A nasty boogie", "Spit yours snot at your opponent giving them {s} stacks of poison", 3);
        Card healing = new Healing("Eat a bone", "Eat a bone to restore {h} health", 5);
        for (int i = 0; i < 4; i++) {
            troll.addCard(attClub);
        }
        for (int i = 0; i < 2; i++) {
            troll.addCard(attSpit);
        }
        troll.addCard(healing);

        Monster arsonKid = new Monster(20, new ArrayList<Card>(), "arson kid");
        Card attFireBall = new Fire("Fire ball", "Throw a fire ball at your enemies dealing {d} and giving them {s} stacks of burning", 7, 4);
        Card attArson = new Fire("Arson curse", "Cast an arson curse at your enemy dealing {d} and giving them {s} stacks of burning", 0, 8);
        Card attKick = new Attack("Shin kick", "Kick your opponent in the shin dealing {d} damage", 3);
        Card blessingFire = new Blessing("Blessing of Fire", "Pray upon the gods of fire and recieve {s} stacks of blessing", 3);
        arsonKid.addCard(attFireBall);
        arsonKid.addCard(attArson);
        for (int i = 0; i < 5; i++) {
            arsonKid.addCard(attKick);
        }
        for (int i = 0; i < 2; i++) {
            arsonKid.addCard(blessingFire);
        }

        Monster medusa = new Monster(30, new ArrayList<Card>(), "medusa");
        Card attSnakeBite = new Poison("Snake bite", "Bite your opponent giving them {s} stacks of poison", 6);
        Card attGaze = new Confusion("Confusing gaze", "Look at your opponent with contempt giving them {s} stacks of confusion", 2);
        Modifier echoSnake = new Echo("Ancient snake bow", 2);
        Card medBow = new Equipment("Ancient snake bow", "An ancient bow that summons a phantom snake with each arrow shot", echoSnake);
        for (int i = 0; i < 2; i++) {
            medusa.addCard(attSnakeBite);
            medusa.addCard(attGaze);
        }
        medusa.addCard(medBow);

        Monster tortoise = new Monster(10, new ArrayList<Card>(), "tiny tortoise");
        Card attBite = new Attack("Ankle bite", "Bite the ankles of your opponent dealing {d} damage", 2);
        for (int i = 0; i < 5; i++) {
            tortoise.addCard(attBite);
        }

        Monster bastard = new Monster(50, new ArrayList<Card>(), "ugly bastard");
        Card attBottle = new Attack("Bottle smash", "Smash a bottle of liquor on your opponent dealing {d} damage", 4);
        Card attAlcohol = new Poison("Liquor spit", "Spit a mouthful of liquor at your opponent giving them {s} stacks of poison", 7);
        Card healingAlcohol = new Healing("Industrial alcohol", "Drink a shot of 100% alcohol to restore {h} health", 10);
        Card blessingDrunk = new Blessing("Smash drunk", "Get smash drunk to not feel the pain and recieve {s} stacks of blessing", 5);
        Card attFire = new Fire("Lighter", "Throw a lit lighter at your enemy dealing {d} and giving them {s} stacks of burning", 2, 8);
        Modifier sweatProblems = new Echo("Sweaty Hands", 1);
        Card sweaty = new Equipment("Excessive sweat", "You have exercised too much and spray sweat with each of your attacks", sweatProblems);
        Modifier strong = new Weapon("Strength boost", 2);
        Card eqStrong = new Equipment("Bastard strength", "They cant call you ugly if you beat them with the strength of a bull", strong);
        Modifier fat = new Armour("Layers of fat", 2);
        Card eqFat = new Equipment("Layers of fat", "The layers of fat gained from overeating are protecting you from harm", fat);
        Card attInsult = new Confusion("Vicious mockery", "Insult your enemy giving them {s} stacks of confusion", 3);
        Card inspire = new Inspiration("Tasty snack", "Eat a tasty treat gaining {s} stacks of inspiration", 2);
        Card attHands = new AttackFlurry("Catch those hands", "Slap your opponent {c} times dealing {d} damage each time", 2, 4);
        for (int i = 0; i < 5; i++) {
            bastard.addCard(attBottle);
        }
        for (int i = 0; i < 4; i++) {
            bastard.addCard(attHands);
        }
        for (int i = 0; i < 3; i++) {
            bastard.addCard(attAlcohol);
            bastard.addCard(inspire);
        }
        for (int i = 0; i < 2; i++) {
            bastard.addCard(healingAlcohol);
            bastard.addCard(blessingDrunk);
            bastard.addCard(attFire);
            bastard.addCard(attInsult);
        }
        bastard.addCard(sweaty);
        bastard.addCard(eqStrong);
        bastard.addCard(eqFat);
        
        Monster hellhound = new Monster(30, new ArrayList<Card>(), "hellhound");
        Card attBite2 = new Attack("Bite", "Bite your opponent dealing {d} damage", 4);
        Card attFiretail = new Fire("Fire tail", "Wag your tail summoning a wave of fire at your enemy dealing {d} and giving them {s} stacks of burning", 2, 4);
        Card blessingBurn = new Blessing("Fire cloak", "Cloak yourself in fires of life to recieve {s} stacks of blessing", 3);
        Modifier fireClaw = new Weapon("Flaming claws", 2);
        Card eqClaws = new Equipment("Flaming claws", "Set your claws ablaze to deal extra damage", fireClaw);
        for (int i = 0; i < 4; i++) {
            hellhound.addCard(attBite2);
        }
        for (int i = 0; i < 3; i++) {
            hellhound.addCard(attFiretail);
        }
        for (int i = 0; i < 2; i++) {
            hellhound.addCard(blessingBurn);
        }
        hellhound.addCard(eqClaws);

        PlayerGlobal.init(new Player(10, new ArrayList<Card>()));
        Card attBackhand = new Attack("Backhand slap", "Give your opponent a backhand slap dealing {d} damage", 3);
        for (int i = 0; i < 3; i++) {
            PlayerGlobal.getPlayer().addCard(attBackhand);
        }


        ArrayList<Card> shop1Cards = new ArrayList<>();
        ArrayList<Integer> shop1Prices = new ArrayList<>();
        shop1Cards.add(attBackhand);
        shop1Cards.add(attKick);
        shop1Cards.add(attHands);
        shop1Prices.add(5);
        shop1Prices.add(5);
        shop1Prices.add(7);

        Modifier echoPtsd = new Echo("PTSD trigger", 2);
        Card eqPtsd = new Equipment("PTSD trigger", "Learn about your opponents trauma and exploit it in combat", echoPtsd);
        Card attBang = new Confusion("Flash bang", "Throw a flash bang at your enemy giving them {s} stacks of confusion", 2);
        Card jug = new Healing("Chug Jug", "Chug from the legendary Chug Jug receiving {h} health", 5);

        ArrayList<Card> shop2Cards = new ArrayList<>();
        ArrayList<Integer> shop2Prices = new ArrayList<>();
        shop2Cards.add(eqPtsd);
        shop2Cards.add(attBang);
        shop2Cards.add(inspire);
        shop2Cards.add(jug);
        shop2Prices.add(12);
        shop2Prices.add(9);
        shop2Prices.add(9);
        shop2Prices.add(7);
        
        Modifier plotArmour = new Armour("Plot armour", 3);
        Card eqPlot = new Equipment("Plot armour", "You are the MC! Of course you should have plot armour!", plotArmour);
        Modifier bad = new Weapon("Bad dragon", 2);
        Card eqBad = new Equipment("Bad dragon", "Succumb to your repressed urges and get a toy from bad dragon", bad);
        Card attWhip = new Fire("Fire whip", "Lash at your enemies with a whip of flames dealing {d} damage and giving them {s} stacks of burning", 4, 6);
        Card attBug = new Poison("Bug spray", "If you want someone to stop bugging you, use a bug spray on them and give them {s} stacks of poison", 5);
        Card offering = new Blessing("Offering", "Sacrifice a fish head to your local seagull and recieve {s} stacks of blessing", 4);

        ArrayList<Card> shop3Cards = new ArrayList<>();
        ArrayList<Integer> shop3Prices = new ArrayList<>();
        shop3Cards.add(eqPlot);
        shop3Cards.add(eqBad);
        shop3Cards.add(attBug);
        shop3Cards.add(offering);
        shop3Cards.add(attWhip);
        shop3Prices.add(25);
        shop3Prices.add(15);
        shop3Prices.add(13);
        shop3Prices.add(12);
        shop3Prices.add(14);


        Encounter shop1 = new Shop("Shop", "A place to buy stuff", shop1Cards, shop1Prices);
        Encounter shop2 = new Shop("A better shop", "A place to buy better stuff", shop2Cards, shop2Prices);
        Encounter shop3 = new Shop("The best shop", "A place to buy the best stuff", shop3Cards, shop3Prices);

        Encounter combat1 = new Combat("a very angry tiny tortoise", tortoise, 12);
        Encounter combat2 = new Combat("a local orphan that hates adults and likes to set them on fire", arsonKid, 20);
        Encounter combat3 = new Combat("a hobo that looks like a troll and lives under the bridge", troll, 20);
        Encounter combat4 = new Combat("SHE HAS SNAKES FOR HAIR WHAT THE F*CK!?", medusa, 30);
        Encounter combat5 = new Combat("some street thungs are doing a satanic ritual", hellhound, 30);
        Encounter combat6 = new Combat("a fat and ugly humanoid creature is wobbling towards you, it smells really bad", bastard, 0);

        Encounter gym1 = new Gym("Dilapidated gym", "an old gym that is falling apart", 5);
        Encounter gym2 = new Gym("Medical gym", "a gym ran by a doctor who got his licence revoked, you wonder why", 5);

        Encounter tavern1 = new Tavern("Illegal tavern", "a tavern that was officially closed by hygene control 2 months ago, the owner still runs it", 2);
        Encounter tavern2 = new Tavern("Fancy club", "the local club, they have a scary looking bouncer that is actually a softie with a sweet tooth", 5);

        ArrayList<Encounter> level1Encounters = new ArrayList<>();
        level1Encounters.add(combat1);
        level1Encounters.add(shop1);
        level1Encounters.add(gym1);
        level1Encounters.add(combat2);
        level1Encounters.add(combat3);
        level1Encounters.add(tavern1);
        level1Encounters.add(shop2);
        level1Encounters.add(combat4);
        level1Encounters.add(combat5);
        level1Encounters.add(shop3);
        level1Encounters.add(tavern2);
        level1Encounters.add(gym2);
        level1Encounters.add(combat6);

        Level level1 = new Level(level1Encounters);
        level1.start();

        Reader.ensureClose();
    }
}