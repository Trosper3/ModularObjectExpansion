package Objects;

public class Hardpoint
{
    private int health, damage, speed;
    private int index;
    private String name;

    protected Hardpoint(String name, int health, int damage, int speed)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getSpeed() { return speed; }
    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }
}
