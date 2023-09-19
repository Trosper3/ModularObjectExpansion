package Objects;

import Utility.AttackChance;
import Utility.Cost;
import Utility.ID;

import java.util.ArrayList;
import java.util.HashMap;

public class Hardpoint extends Object
{
    private ArrayList<Armament> armaments = new ArrayList<>();

    public Hardpoint(String name, int health)
    {
        super(name, health);
        super.setID(ID.assignID());
        super.setCost(Cost.assignCost(this));

        Global.hardpoints.put(this.getID(), this);
    }

    public void addArmament(Armament armament)
    {
        armament.setOwner(this);
        armaments.add(armament);

        super.adjustHealth(armament.getHealth());
        super.adjustDamage(armament.getDamage());
        super.adjustSpeed(armament.getSpeed());
    }

    public void removeArmament(Armament armament)
    {
        armaments.remove(armament);

        super.adjustHealth(-armament.getHealth());
        super.adjustDamage(-armament.getDamage());
        super.adjustSpeed(-armament.getSpeed());
    }

    public void attack(Object target)
    {
        if (AttackChance.canAttack(this, target))
        {
            target.adjustHealth(-this.getDamage());
            if (target.getHealth() <= 0)
            {
                if(target instanceof Hardpoint)
                {
                    ((Unit) target.getOwner()).removeHardpoint((Hardpoint) target);
                }
                else if(target instanceof Unit)
                {
                    ((Commander) target.getOwner()).removeUnit((Unit) target);
                }
            }
        }
    }

    public Armament getArmament(int position)
    {
        return armaments.get(position);
    }
    public int getArmamentAmount() { return this.armaments.size(); }
}
