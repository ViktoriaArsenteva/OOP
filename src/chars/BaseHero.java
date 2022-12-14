package chars;


import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    protected int attack;
    protected int defense;

    protected int[] damage;

    protected int damageValue;
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected String name;

    protected BaseHero target;

    protected Coordinates position;
    protected String status;

    protected String fraction;

    private static int idCount = 0;
    protected int id;

    public BaseHero(int attack, int defense, int[] damage, int health, int speed,
                    String name, int x, int y, String fraction) {
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth;
        this.speed = speed;
        this.name = name;
        this.position = new Coordinates(x, y);
        this.status = "stand";
        this.id = idCount++;
        this.fraction = fraction;
        this.target = this;
        this.damageValue = 0;
    }

    public String getFraction() {
        return fraction;
    }

    public String getStatus() {
        return status;
    }

    public Coordinates getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void step(Team team) {}

    protected void damage(int damage) {
        health = health - damage;
        if (health <= 0) {
            status = "dead";
            health = 0;
        }
        if (health > maxHealth) health = maxHealth;
    }

    protected int damageValue(BaseHero h) {
        int flag = attack - h.defense;
        int value = 0;
        if (flag == 0) value = ((damage[0] + damage[1]) / 2);
        if (flag > 0) value = damage[1];
        if (flag < 0) value = damage[0];
        return value;
    }

    @Override
    public String getInfo() {
        return "fraction=" + fraction +
                ";name=" + name + id +
                ";attack=" + attack +
                ";defense=" + defense +
                ";damage=" + Arrays.toString(damage) +
                ";health=" + health +
                ";speed=" + speed +
                ";status=" + status +
                ";position=" + position.toString();

    }

    public String defaultLog() {
        return String.join(";", fraction, name+id,
                position.toString(), target.name+target.id, target.position.toString(), String.valueOf(damageValue), status);
    }

}