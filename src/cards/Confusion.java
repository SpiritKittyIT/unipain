package cards;

import encounters.Combatant;
import statusEffects.Confused;
import statusEffects.StatusEffect;

public class Confusion extends Card {
    private StatusEffect statusEffect;

    public Confusion(String name, String description, int stacks) {
        super(name, description, CardTarget.OPPONENT);
        this.statusEffect = new Confused(stacks);
    }

    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        target.addStatusEffect(this.statusEffect);
        
        if (playerAction) {
            System.out.println("your opponent has been confused(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have been confused(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription().replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
