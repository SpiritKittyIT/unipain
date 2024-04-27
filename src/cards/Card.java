package cards;

import encounters.Combatant;

public abstract class Card {
    private String name;
    private String description;
    private CardType type;

    public Card(String name, String description, CardType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void use(boolean playerAction, Combatant combatant) {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public CardType getType() {
        return this.type;
    }
}
