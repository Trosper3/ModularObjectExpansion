package Objects;

public abstract class Object
{
    private int health, damage, speed;
    private String name;

    protected Object(String name, int health, int damage, int speed)
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
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setSpeed(int speed) { this.speed = speed; }
}
