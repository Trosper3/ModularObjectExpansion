package Utility;

import Objects.Object;
public class Cost
{
    public static int assignCost(Object object)
    {;
        int cost = object.getHealth() + object.getDamage() + object.getSpeed();

        return cost;
    }
}
