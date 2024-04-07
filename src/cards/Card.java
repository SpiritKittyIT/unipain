package cards;

public abstract class Card {
    private String name;
    private String description;

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void use() {

    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
