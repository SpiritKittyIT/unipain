package cards;

import encounters.Combatant;
import statusEffects.Burning;
import statusEffects.StatusEffect;

public class Fire extends Card {
    private int damage;
    private StatusEffect statusEffect;

    public Fire(String name, String description, int damage, int stacks) {
        super(name, description, CardTarget.OPPONENT);
        this.statusEffect = new Burning(stacks);
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
            System.out.println("your opponent has " + combatant.getHp() + " hp left " + " and is now burning(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have " + combatant.getHp() + " hp left " + " and are now burning(" + this.statusEffect.getStacks() + ")");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
            .replaceAll("\\{d}", "" + this.damage)
            .replaceAll("\\{s}", "" + this.statusEffect.getStacks());
    }
}
