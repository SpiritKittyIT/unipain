package cardAdventure.encounters;

/**
* Abstract class to represent encounters.
*/
public abstract class Encounter {
    private String name;
    private String description;

    /**
    * Default constructor for Encounter class members.
    * @param name the name of the encounter
    * @param description the encounters describtion
    */
    public Encounter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
    * Enter the encounter.
    * @return boolean, true if the encounter should close after the player leaves
    */
    public abstract boolean interact();

    /**
    * Gets the name of the encounter.
    * @return String, the name of the encounter
    */
    public String getName() {
        return this.name;
    }

    /**
    * Gets the describtion of the encounter.
    * @return String, the describtion of the encounter
    */
    public String getDescription() {
        return this.description;
    }
}
