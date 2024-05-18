package cards;

import encounters.Combatant;
import modifiers.ModifierType;

public class AttackFlurry extends Card {
    private int damage;
    private int attackCount;

    public AttackFlurry(String name, String description, int damage, int attackCount) {
        super(name, description, CardTarget.OPPONENT);
        this.damage = damage;
        this.attackCount = attackCount;
    }

    @Override
    public boolean use(boolean playerAction, Combatant user, Combatant target) {
        if (playerAction) {
            System.out.println("you have used " + this.getName());
        } else {
            System.out.println("your opponent has used " + this.getName());
        }

        for (int i = 0; i < this.attackCount; i++) {
            int damageModified = user.applyModifiers(this.damage, target, ModifierType.ATTACK);
            damageModified = target.applyModifiers(damageModified, target, ModifierType.DEFENCE);

            target.dealDamage(damageModified);
        }
        
        if (playerAction) {
            System.out.println("your opponent has " + target.getHp() + " hp left");
        } else {
            System.out.println("you have " + target.getHp() + " hp left");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
            .replaceAll("\\{d}", "" + this.damage)
            .replaceAll("\\{c}", "" + this.attackCount);
    }
}
