package encounters;

import creatures.Creature;
import global.PlayerGlobal;
import global.Reader;

public class Combat extends Encounter {
    private Combatant npc;
    private Combatant pc;

    public Combat(String description, Creature enemy) {
        super(enemy.getName(), description);
        this.npc = new Combatant(enemy);
        this.pc = new Combatant(PlayerGlobal.getPlayer());
    }

    @Override
    public boolean interact() {
        System.out.println("----------------------------------------");
        System.out.println("Oh no, " + this.getName() + " wants to fight you. Slap them to death!");
        this.listActions();

        this.pc.onTurnStart();

        while (this.npc.getHp() > 0 && this.pc.getHp() > 0) {
            String action = Reader.readLine();
            String[] words = action.split(" ");
            if (!(words[0].equals("play") && words.length == 2) && words.length != 1) {
                System.out.println("that is an invalid action");
                continue;
            }
            switch (words[0]) {
                case "list":
                    this.pc.listHand();
                    break;
                case "play":
                    this.playCard(words[1]);
                    break;
                case "help":
                    this.listActions();
                    break;
                case "end":
                    this.npc.onTurnStart();
                    if (this.npc.getHp() <= 0) {
                        break;
                    }
                    while (!this.npc.isHandEmpty()) {
                        this.npc.playFromHand(false, 0, this.pc);
                    }
                    if (this.pc.getHp() > 0) {
                        this.pc.onTurnStart();
                    }
                    break;

                default:
                    System.out.println("that is an invalid action");
                    break;
            }
        }

        this.finalise();

        return true;
    }

    private void listActions() {
        System.out.println("The following actions are permitted:");
        System.out.println("list - lists all cards in your hand");
        System.out.println("play [n] - play the specified card from your hand");
        System.out.println("end - end your turn and let your enemy beat you up");
        System.out.println("help - list available actions");
    }
    
    private void playCard(String selectedCard) {
        if (!selectedCard.matches("\\d*")) {
            System.out.println("invalid argument, dumbass");
            return;
        }

        this.pc.playFromHand(true, Integer.parseInt(selectedCard), this.npc);
    }

    private void finalise() {
        if (this.pc.getHp() > 0) {
            System.out.println("so, you are not that useles, huh. after looting your opponent, you find 20 gold");
            PlayerGlobal.getPlayer().addGold(20);
        }
    }
}
