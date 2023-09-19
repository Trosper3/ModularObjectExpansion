package Objects;

public abstract class Object<T extends Thing> extends Thing
{
    private int health, damage, speed, id, cost;
    private String name;
    private T owner;

    protected Object(String name, int health, int damage, int speed)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    protected Object(String name, int health)
    {
        this.name = name;
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getSpeed() { return speed; }
    public int getID() { return id; }
    public int getCost() { return cost; }
    public T getOwner() { return owner; }
    public void changeName(String name) { this.name = name; }
    public void adjustHealth(int health) { this.health += health; }
    public void adjustDamage(int damage) { this.damage += damage; }
    public void adjustSpeed(int speed) { this.speed += speed; }
    public void setID(int id) { this.id = id; }
    public void setCost(int cost) { this.cost = cost; }
    public void setOwner(T owner) { this.owner = owner; }

}
