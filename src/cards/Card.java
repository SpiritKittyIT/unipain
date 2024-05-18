package cards;

import encounters.Combatant;

public abstract class Card {
    private String name;
    private String description;
    private CardTarget type;

    public Card(String name, String description, CardTarget type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public abstract boolean use(boolean playerAction, Combatant combatant);

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public CardTarget getTarget() {
        return this.type;
    }
}
