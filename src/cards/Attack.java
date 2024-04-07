package cards;

public class Attack extends Card {
    private int damage;

    public Attack(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{d}", "" + this.damage);
    }
}
