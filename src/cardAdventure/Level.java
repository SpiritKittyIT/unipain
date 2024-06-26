package cardAdventure;
import java.util.ArrayList;
import java.util.List;

import cardAdventure.encounters.Encounter;
import cardAdventure.global.PlayerGlobal;
import cardAdventure.global.Reader;

/**
* Class to represent each level of the game, holds encounters.
*/
public class Level {
    private ArrayList<Encounter> encounters;

    /**
    * Default constructor for Level class members.
    */
    public Level() {
        this.encounters = new ArrayList<>();
    }

    /**
    * Constructor for Card class members.
    * @param encounters ArrayList of encounters that are in the level
    */
    public Level(ArrayList<Encounter> encounters) {
        this.encounters = encounters;
    }

    /**
    * Start the level and let the player go through its encounters.
    */
    public void start() {
        this.welcomeMessage();
        while (PlayerGlobal.getPlayer().getHp() > 0 && !this.encounters.isEmpty()) {
            this.interact();
        }
    }
    
    private void interact() {
        String action = Reader.readLine();
        String[] words = action.split(" ");
        
        if (!((words[0].equals("close") || words[0].equals("enter")) && words.length == 2) && words.length != 1) {
            System.out.println("that is an invalid action");
            return;
        }
        switch (words[0]) {
            case "list":
                int i = 0;
                for (Encounter encounter : this.getInteractable()) {
                    System.out.println(i++ + " - " + encounter.getName() + ": " + encounter.getDescription());
                }
                break;
            case "close":
                this.closeEncounter(words[1]);
                break;
            case "enter":
                this.enterEncounter(words[1]);
                break;
            case "help":
                this.listActions();
                break;
        
            default:
                System.out.println("that is an invalid action");
                break;
        }
    }

    private void welcomeMessage() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the start of a new level!");
        this.listActions();
    }

    private void listActions() {
        System.out.println("The following actions are permitted:");
        System.out.println("list - lists all currently available encounters");
        System.out.println("close [n] - close specified encounter without interaction");
        System.out.println("enter [n] - enter the specified encounter");
        System.out.println("help - list available actions");
    }

    private List<Encounter> getInteractable() {
        return this.encounters.subList(0, this.countInteractable());
    }

    private int countInteractable() {
        return this.encounters.size() > 3 ? 3 : this.encounters.size();
    }

    private int checkEncounter(String selectedEncounter) {
        if (!selectedEncounter.matches("\\d*")) {
            System.out.println("invalid argument, can you not follow simple instructions?");
            return -1;
        }
        int result = Integer.parseInt(selectedEncounter);
        if (result >= this.countInteractable()) {
            System.out.println("there is no such encounter");
            return -1;
        }
        return result;
    }

    private void closeEncounter(String selectedEncounter) {
        int index = this.checkEncounter(selectedEncounter);
        if (index == -1) {
            return;
        }

        this.encounters.remove(index);
    }

    private void enterEncounter(String selectedEncounter) {
        int index = this.checkEncounter(selectedEncounter);
        if (index == -1) {
            return;
        }

        boolean close = this.encounters.get(index).interact();
        if (close) {
            this.encounters.remove(index);
        }
    }
}
