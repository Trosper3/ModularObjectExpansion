package Objects;

import Utility.AttackChance;
import Utility.Cost;
import Utility.ID;

import java.util.ArrayList;
import java.util.HashMap;

public class Unit extends Object
{
    private ArrayList<Hardpoint> hardpoints = new ArrayList<>();
    private ArrayList<Armament> armaments = new ArrayList<>();

    protected Unit(String name, int health, int damage, int speed)
    {
        super(name, health, damage, speed);
        super.setID(ID.assignID());
        super.setCost(Cost.assignCost(this));

        Global.units.put(this.getID(), this);
    }

    public void addHardpoint(Hardpoint hardpoint)
    {
        hardpoint.setOwner(this);
        hardpoints.add(hardpoint);

        super.adjustHealth(hardpoint.getHealth());
        super.adjustDamage(hardpoint.getDamage());
        super.adjustSpeed(hardpoint.getSpeed());
    }

    public void removeHardpoint(Hardpoint hardpoint)
    {
        hardpoints.remove(hardpoint);

        super.adjustHealth(-hardpoint.getHealth());
        super.adjustDamage(-hardpoint.getDamage());
        super.adjustSpeed(-hardpoint.getSpeed());
    }

    public Hardpoint getHardpoint(int position)
    {
        return hardpoints.get(position);
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

    public Armament getArmament(int position)
    {
        return armaments.get(position);
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

    public int getArmamentAmount() { return this.armaments.size(); }
    public int getHardpointAmount() { return this.hardpoints.size(); }
}
