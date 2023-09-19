package Objects;

import Utility.Cost;
import Utility.ID;
import java.util.HashMap;

public class Hardpoint extends Object
{
    private HashMap<Integer, Armament> armaments = new HashMap<>();

    public Hardpoint(String name, int health, int damage, int speed)
    {
        super(name, health, damage, speed);
        super.setID(ID.assignID());
        super.setCost(Cost.assignCost(this));

        Global.hardpoints.put(this.getID(), this);
    }

    public void addArmament(Armament armament)
    {
        armament.setOwner(this);
        armaments.put(armament.getID(),armament);

        super.adjustHealth(armament.getHealth());
        super.adjustDamage(armament.getDamage());
        super.adjustSpeed(armament.getSpeed());
    }

    public void removeArmament(Armament armament)
    {
        armaments.remove(armament.getID());

        super.adjustHealth(-armament.getHealth());
        super.adjustDamage(-armament.getDamage());
        super.adjustSpeed(-armament.getSpeed());
    }

    public Armament getArmament(int id)
    {
        return armaments.get(id);
    }
    public int getArmamentAmount() { return this.armaments.size(); }
}
