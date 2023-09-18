package Objects;

import java.util.ArrayList;

public class Unit extends Object
{
    private int health, damage, speed;
    private String name;
    private ArrayList<Hardpoint> hardpoints;
    public Unit(String name, int health, int damage, int speed)
    {
        super(name, health, damage, speed);
        Objects.units.add(this);
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getSpeed() { return speed; }

    public void updateStats()
    {
        super.setHealth(this.health);
        super.setDamage(this.damage);
        super.setSpeed(this.speed);
    }

    public void addHardpoint(Hardpoint hardpoint)
    {
        hardpoint.setIndex(hardpoints.size());
        hardpoints.add(hardpoint);

        this.health += hardpoint.getHealth();
        this.damage += hardpoint.getDamage();
        this.speed += hardpoint.getSpeed();
    }

    public void removeHardpoint(Hardpoint hardpoint)
    {
        hardpoints.remove(hardpoint.getIndex());

        this.health -= hardpoint.getHealth();
        this.damage -= hardpoint.getDamage();
        this.speed -= hardpoint.getSpeed();
    }
}
