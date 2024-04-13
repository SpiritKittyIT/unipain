package encounters;

public abstract class Encounter {
    private String name;
    private String description;

    public Encounter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract boolean interact();

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
