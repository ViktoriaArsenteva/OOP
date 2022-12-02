package chars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class BaseHero implements BaseInterface, Iterator {
    private int attack;
    private int defense;
    private int[] damage;
    private double health;
    private double maxHealth;
    private int speed;
    private String name;
    protected ArrayList<BaseHero> myParty;
    private Coordinates position;
    protected String status; 

    public BaseHero(int attack, int defense, int[] damage, double health, int speed, String name, ArrayList<BaseHero> myParty, int x, int y) {
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth;
        this.speed = speed;
        this.name = name;
        this.myParty = myParty;
        this.position = new Coordinates(x, y);
        this.status = "stand";
    }
    

    public String getStatus() {
        return status;
    }

    @Override
    public String getInfo() {
        return "name=" + name +
                ", attack=" + attack +
                ", defense=" + defense +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", speed=" + speed;
    }

    //Для тренировки
    private int classFields;
    @Override
    public boolean hasNext() {
        return classFields++ < 8;
    }

    @Override
    public String next() {
        switch (classFields) {
            case 0: return "name=" + name;
            case 1: return ", attack=" + attack;
            case 2: return ", defense=" + defense;
            case 3: return ", damage=" + Arrays.toString(damage);
            case 4: return ", Max HP=" + maxHealth;
            case 5: return ", HP=" + health;
            case 6: return ", speed=" + speed;
            case 7: return ", status=" + status;


        }
        return null;
    }



    public String getName() {
        return name;
    }
    protected boolean equalsClass(BaseHero hero) {
        return this.getName().equals(hero.getName());
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public ArrayList<BaseHero> getMyParty() {
        return myParty;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {}

    public Coordinates getPosition() {
        return position;
    }

    public int[] getDamage() {
        return damage;
    }

    protected void damage(int damage) {
        this.health = health - damage;
        if (this.health <= 0) {
            this.status = "dead";
            this.health = 0;
        }
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }

    protected int damageValue (BaseHero h) {
        int flag = this.getAttack() - h.getDefense();
        int value = 0;
        if (flag == 0) value = ((this.getDamage()[0] + this.getDamage()[1]) / 2);
        if (flag > 0) value = this.getDamage()[1];
        if (flag < 0) value = this.getDamage()[0];
        return value;
    }
}


   