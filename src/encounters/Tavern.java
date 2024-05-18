package encounters;

import java.util.ArrayList;

import cards.Card;
import global.PlayerGlobal;
import global.Reader;

public class Tavern extends Encounter {
    private int defaultPrice;
    private int price;

    public Tavern(String name, String description, int price) {
        super(name, description);
        this.defaultPrice = price;
        this.price = price;
    }

    @Override
    public boolean interact() {
        this.welcomeMessage();

        boolean leave = false;
        while (true) {
            ArrayList<Card> playerCards = PlayerGlobal.getPlayer().getCards();
            String action = Reader.readLine();
            String[] words = action.split(" ");
            if (!(words[0].equals("forget") && words.length == 2) && words.length != 1) {
                System.out.println("that is an invalid action");
                continue;
            }
            switch (words[0]) {
                case "list":
                    for (int i = 0; i < playerCards.size(); i++) {
                        System.out.println(i + " - (" + this.price + "g) "  + playerCards.get(i).getName() + ": " + playerCards.get(i).getDescription());
                    }
                    break;
                case "check":
                    this.checkWallet();
                    break;
                case "forget":
                    this.forgetItem(words[1]);
                    break;
                case "leave":
                    leave = true;
                    break;
            
                default:
                    System.out.println("that is an invalid action");
                    break;
            }
            if (leave) {
                System.out.println("We sincerely hope you had a great experience in our totally licenced tavern");
                break;
            }
        }

        return false;
    }

    private void welcomeMessage() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to our totally licenced tavern!");
        System.out.println("Our drinks may, or may not give you amnesia.");
        System.out.println("The following actions are permitted:");
        System.out.println("list - lists our majestic wares");
        System.out.println("check - check your wallet");
        System.out.println("forget [n] - forget the item numbered as [n]");
        System.out.println("leave - leave our totally licenced tavern");
    }

    private void checkWallet() {
        System.out.println("your wallet has " + PlayerGlobal.getPlayer().getGold() + " gold in it");
        if (this.price < PlayerGlobal.getPlayer().getGold()) {
            return;
        }
        System.out.println("what are you still doing here you poor plebian? your wallet is too small to buy any of our drinks!");
    }

    private void forgetItem(String selectedItem) {
        if (!selectedItem.matches("\\d*")) {
            System.out.println("invalid argument, can you not follow simple instructions?");
            return;
        }

        int index = Integer.parseInt(selectedItem);
        ArrayList<Card> playerCards = PlayerGlobal.getPlayer().getCards();

        if (index >= playerCards.size()) {
            System.out.println("we have no such thing in our inventory");
            return;
        }

        if (PlayerGlobal.getPlayer().getGold() < this.price) {
            System.out.println("your poor plebian wallet is too small");
            return;
        }

        Card toRemove = playerCards.get(index);
        PlayerGlobal.getPlayer().removeCard(toRemove);
        PlayerGlobal.getPlayer().addGold(-this.price);
        System.out.println("you forgot: " + toRemove.getName());
        this.price += this.defaultPrice;
    }    
}
