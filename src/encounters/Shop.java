package encounters;

import java.util.ArrayList;
import java.util.Scanner;

import cards.Card;
import creatures.Player;

public class Shop implements IEncounter {
    private ArrayList<Card> cards;
    private ArrayList<Integer> prices;

    public Shop(ArrayList<Card> cards, ArrayList<Integer> prices) {
        this.cards = cards;
        this.prices = prices;
    }

    @Override
    public void interact(Player player) {
        this.welcomeMessage();

        Scanner sc = new Scanner(System.in);
        boolean leave = false;
        while (true) {
            String action = sc.nextLine();
            String[] words = action.split(" ");
            if (!(words[0].equals("buy") && words.length == 2) && words.length != 1) {
                System.out.println("that is an invalid action");
                continue;
            }
            switch (words[0]) {
                case "list":
                    for (int i = 0; i < this.cards.size(); i++) {
                        System.out.println(i + " - (" + this.prices.get(i) + "g)"  + cards.get(i).getName() + ": " + cards.get(i).getDescription());
                    }
                    break;
                case "check":
                    checkWallet(player);
                    break;
                case "buy":
                    this.buyItem(player, words[1]);
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
        sc.close();
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

    private void checkWallet(Player player) {
        System.out.println("your wallet has " + player.getGold() + " gold in it");
        for (int price : this.prices) {
            if (price < player.getGold()) { return; }
        }
        System.out.println("what are you still doing here you poor plebian? your wallet is too small for this shop");
    }

    private void buyItem(Player player, String selectedItem) {
        int index;
        if (!selectedItem.matches("\\d*") || (index = Integer.parseInt(selectedItem)) >= this.cards.size()) {
            System.out.println("we have no such thing in our inventory");
            return;
        }

        if (player.getGold() < this.prices.get(index)) {
            System.out.println("this item is too good for your poor plebian wallet");
            return;
        }

        player.addCard(this.cards.get(index));
        System.out.println("you have bought: " + this.cards.get(index).getName());
    }
    
}
