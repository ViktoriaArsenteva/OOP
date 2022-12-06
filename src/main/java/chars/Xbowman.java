package chars;

import java.util.ArrayList;

public class Xbowman extends BaseHero {
    private int shoot;
    public Xbowman(ArrayList<BaseHero> myParty, int x, int y, String side) {
        super(6, 3, new int[]{2,3}, 10, 4,  "Xbowman", myParty, x, y, side);
        this.shoot = 16;
    }
    public Xbowman(int attack, int protection, int[] damage, int health, int speed, String name, int shoot, ArrayList<BaseHero> myParty, int x, int y, String side) {
        super(attack, protection, damage, health, speed, name, myParty, x, y, side);
        this.shoot = shoot;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                ", shoot=" + shoot;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {
        if (status.equals("dead")) return;
        for (BaseHero h: myParty) {
            if (h.name.equals("Peasant") && h.status.equals("stand")) {
                shoot++;
                h.status = "used";
                break;
            }
        }
        if (shoot<1) {status = "used"; return;}
        BaseHero target = position.findNearest(enemy);
        double dist = position.distance(target.position);
        int damageValue = (dist < speed ?
                super.damageValue(target) :
                (super.damageValue(target)/2));
        target.damage(damageValue);
        shoot--;

        super.logIt(target, damageValue);
    }
}