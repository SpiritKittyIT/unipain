package cards;

public abstract class Equipment extends Card {
    public Equipment(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
