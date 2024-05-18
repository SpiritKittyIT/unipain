package cards;

import encounters.Combatant;
import statusEffects.Inspired;
import statusEffects.StatusEffect;

public class Inspiration extends Card {
    private StatusEffect statusEffect;

    public Inspiration(String name, String description, int stacks) {
        super(name, description, CardTarget.SELF);
        this.statusEffect = new Inspired(stacks);
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
            System.out.println("you have been inspired(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("your opponent has been inspired(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
