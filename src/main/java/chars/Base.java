package chars;

import java.util.Arrays;
import java.util.List;

public abstract class Base implements BaseInterface {
    private int attack;
    private int defence;
    private int shoot;
    private int[] damage;
    protected double health;
	protected int maxHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
	private String status;
    private static int idCounter;
    private int playerID;
    protected List<Base> gang;
    protected Vector2 position;

    public Base(int attack, int defence, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        playerID = idCounter++;
    }

    public Vector2 getPosition() {return position;}
    public int getPlayerID() {
        return playerID;
    }
	
    public double getHealth() {return health;}

    public String getName() {return name;}

    @Override
    public String getInfo() {
        return "attack=" + attack +
                ", protection=" + defence +
                ", shoot=" + shoot +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }

    @Override
    public void step(List<Base> gang) {}
}
