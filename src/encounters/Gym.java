package encounters;

import global.PlayerGlobal;
import global.Reader;

public class Gym extends Encounter {
    private int defaultPrice;
    private int price;
    private int hp;

    public Gym(String name, String description, int price) {
        super(name, description);
        this.defaultPrice = price;
        this.price = price;
        this.hp = 5;
    }

    @Override
    public boolean interact() {
        this.welcomeMessage();

        boolean leave = false;
        while (true) {
            String action = Reader.readLine();
            String[] words = action.split(" ");
            if (words.length != 1) {
                System.out.println("that is an invalid action");
                continue;
            }
            switch (words[0]) {
                case "list":
                    System.out.println("We sell steroids that increase your max hp by "  + this.hp);
                    System.out.println("WThe injection currently costs "  + this.price + " gold");
                    break;
                case "check":
                    this.checkWallet();
                    break;
                case "use":
                    this.useSteroids();
                    break;
                case "leave":
                    leave = true;
                    break;
            
                default:
                    System.out.println("that is an invalid action");
                    break;
            }
            if (leave) {
                System.out.println("We sincerely hope you had a great experience in our absolutely not shady gym");
                break;
            }
        }

        return false;
    }

    private void welcomeMessage() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to our absolutely not shady gym!");
        System.out.println("We may, or may not sell steroids.");
        System.out.println("The following actions are permitted:");
        System.out.println("list - lists our majestic wares");
        System.out.println("check - check your wallet");
        System.out.println("use - buy and use our latest steroid injection");
        System.out.println("leave - leave our absolutely not shady gym");
    }

    private void checkWallet() {
        System.out.println("your wallet has " + PlayerGlobal.getPlayer().getGold() + " gold in it");
        if (this.price < PlayerGlobal.getPlayer().getGold()) {
            return;
        }
        System.out.println("what are you still doing here you poor plebian? your wallet is too small to buy our steroids!");
    }

    private void useSteroids() {
        if (PlayerGlobal.getPlayer().getGold() < this.price) {
            System.out.println("your poor plebian wallet is too small");
            return;
        }

        PlayerGlobal.getPlayer().addMaxHp(this.hp);
        PlayerGlobal.getPlayer().addGold(-this.price);
        System.out.println("you used steroids and now have " + PlayerGlobal.getPlayer().getMaxHp() + " max hp");
        this.price += this.defaultPrice;
    }    
}
