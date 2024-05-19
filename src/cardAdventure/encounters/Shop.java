package cardAdventure.encounters;

import java.util.ArrayList;

import cardAdventure.cards.Card;
import cardAdventure.global.PlayerGlobal;
import cardAdventure.global.Reader;

/**
* Class to represent shops.
* extends Encounter
*/
public class Shop extends Encounter {
    private ArrayList<Card> cards;
    private ArrayList<Integer> prices;

    /**
    * Default constructor for Shop class members.
    * @param name the name of the encounter
    * @param description the encounters describtion
    * @param cards ArrayList of cards that the shop sells
    * @param prices ArrayList of prices of the cards that the shop sells
    */
    public Shop(String name, String description, ArrayList<Card> cards, ArrayList<Integer> prices) {
        super(name, description);
        this.cards = cards;
        this.prices = prices;
    }

    /**
    * Enter the shop.
    * @return boolean, true if the encounter should close after the player leaves
    */
    @Override
    public boolean interact() {
        this.welcomeMessage();

        boolean leave = false;
        while (true) {
            String action = Reader.readLine();
            String[] words = action.split(" ");
            if (!(words[0].equals("buy") && words.length == 2) && words.length != 1) {
                System.out.println("that is an invalid action");
                continue;
            }
            switch (words[0]) {
                case "list":
                    for (int i = 0; i < this.cards.size(); i++) {
                        System.out.println(i + " - (" + this.prices.get(i) + "g) "  + this.cards.get(i).getName() + ": " + this.cards.get(i).getDescription());
                    }
                    break;
                case "check":
                    this.checkWallet();
                    break;
                case "buy":
                    this.buyItem(words[1]);
                    break;
                case "leave":
                    leave = true;
                    break;
            
                default:
                    System.out.println("that is an invalid action");
                    break;
            }
            if (leave) {
                System.out.println("We sincerely hope you had a great experience in our glorious shop");
                break;
            }
        }

        return false;
    }

    private void welcomeMessage() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to our glorious shop, please select from our majestic wares!");
        System.out.println("The following actions are permitted:");
        System.out.println("list - lists our majestic wares");
        System.out.println("check - check your wallet");
        System.out.println("buy [n] - buy the item numbered as [n]");
        System.out.println("leave - leave our glorious shop");
    }

    private void checkWallet() {
        System.out.println("your wallet has " + PlayerGlobal.getPlayer().getGold() + " gold in it");
        for (int price : this.prices) {
            if (price < PlayerGlobal.getPlayer().getGold()) {
                return;
            }
        }
        System.out.println("what are you still doing here you poor plebian? your wallet is too small for this shop");
    }

    private void buyItem(String selectedItem) {
        if (!selectedItem.matches("\\d*")) {
            System.out.println("invalid argument, can you not follow simple instructions?");
            return;
        }
        int index = Integer.parseInt(selectedItem);
        if (index >= this.cards.size()) {
            System.out.println("we have no such thing in our inventory");
            return;
        }

        if (PlayerGlobal.getPlayer().getGold() < this.prices.get(index)) {
            System.out.println("this item is too good for your poor plebian wallet");
            return;
        }

        PlayerGlobal.getPlayer().addCard(this.cards.get(index));
        PlayerGlobal.getPlayer().addGold(-this.prices.get(index));
        System.out.println("you have bought: " + this.cards.get(index).getName());
    }    
}
