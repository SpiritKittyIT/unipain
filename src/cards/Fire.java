package cards;

import encounters.Combatant;
import modifiers.ModifierType;
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
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        int damageModified = user.applyModifiers(this.damage, target, ModifierType.ATTACK);
        damageModified = target.applyModifiers(damageModified, target, ModifierType.DEFENCE);

        target.dealDamage(damageModified);
        target.addStatusEffect(this.statusEffect);
        
        if (playerAction) {
            System.out.println("your opponent has " + target.getHp() + " hp left " + " and is now burning(" + this.statusEffect.getStacks() + ")");
        } else {
            System.out.println("you have " + target.getHp() + " hp left " + " and are now burning(" + this.statusEffect.getStacks() + ")");
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
