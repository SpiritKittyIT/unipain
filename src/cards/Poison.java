package cards;

import encounters.Combatant;
import statusEffects.Poisoned;
import statusEffects.StatusEffect;

public class Poison extends Card {
    private StatusEffect statusEffect;

    public Poison(String name, String description, int stacks) {
        super(name, description, CardTarget.OPPONENT);
        this.statusEffect = new Poisoned(stacks);
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
            System.out.println("your opponent has been poisoned(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have been poisoned(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
