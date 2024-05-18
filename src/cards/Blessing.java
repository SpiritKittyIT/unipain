package cards;

import encounters.Combatant;
import statusEffects.Blessed;
import statusEffects.StatusEffect;

public class Blessing extends Card {
    private StatusEffect statusEffect;

    public Blessing(String name, String description, int stacks) {
        super(name, description, CardTarget.SELF);
        this.statusEffect = new Blessed(stacks);
    }

    @Override
    public boolean use(boolean playerAction, Combatant combatant) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        combatant.addStatusEffect(this.statusEffect);
        
        if (playerAction) {
            System.out.println("you have been blessed(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("your opponent has been blessed(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
