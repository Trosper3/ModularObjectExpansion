package Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Commander extends Thing
{
    private ArrayList<Unit> fleet = new ArrayList<>();
    private int money;
    public Commander(int initialMoney) { this.money = initialMoney; }

    public void buildUnit(String name, int health, int damage, int speed)
    {
        Unit newUnit = new Unit(name, health, damage, speed);
        newUnit.setOwner(this);
        fleet.add(newUnit);
    }
    public void removeUnit(Unit unit) { fleet.remove(unit); }
    public Unit getUnit(int position) { return fleet.get(position); }
    public void seeFleet() { System.out.println(this.fleet); }
    public int getMoney() { return money; }
    public void adjustMoney(int amount) { this.money += amount; }
    public int getFleetSize() { return fleet.size(); }
}
