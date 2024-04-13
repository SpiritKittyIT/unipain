import java.util.ArrayList;
import java.util.List;

import creatures.Player;
import encounters.Encounter;
import global.PlayerGlobal;
import global.Reader;

public class Level {
    private ArrayList<Encounter> encounters;

    public Level() {
        this.encounters = new ArrayList<>();
    }

    public Level(ArrayList<Encounter> encounters) {
        this.encounters = encounters;
    }

    public void start() {
        this.welcomeMessage();
        while (PlayerGlobal.getPlayer().getHp() > 0 && !encounters.isEmpty()) {
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
        int resilt;
        if (!selectedEncounter.matches("\\d*") || (resilt = Integer.parseInt(selectedEncounter)) >= this.countInteractable()) {
            System.out.println("there is no such encounter");
            return -1;
        }
        return resilt;
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
