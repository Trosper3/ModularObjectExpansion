package Objects;

import Utility.Cost;
import Utility.ID;

public class Armament extends Object
{
    public Armament(String name, int health, int damage, int speed)
    {
        super(name, health, damage, speed);
        super.setID(ID.assignID());
        super.setCost(Cost.assignCost(this));

        Global.armaments.put(this.getID(), this);
    }
}
