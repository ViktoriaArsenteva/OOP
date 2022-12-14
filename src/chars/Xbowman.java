package chars;

public class Xbowman extends BaseHero {
    private int shoot;
    public Xbowman(int x, int y, String fraction) {
        super(6, 3, new int[]{2,3}, 10, 4,  "Xbowman", x, y, fraction);
        this.shoot = 16;
    }
    public Xbowman(int attack, int protection, int[] damage, int health, int speed,
                   String name, int shoot, int x, int y, String fraction) {
        super(attack, protection, damage, health, speed, name, x, y, fraction);
        this.shoot = shoot;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                ";shoot=" + shoot;
    }

    @Override
    public void step(Team team) {

        for (BaseHero h: team.getByFraction(fraction, true)) {
            if (h.name.equals("Peasant") && h.status.equals("stand")) {
                shoot++;
                h.status = "used";
                break;
            }
        }
        if (shoot<1) {
            status = "used";
            target = null;
            damageValue = 0;
            return;
        }
        target = position.findNearest(team.getByFraction(fraction, false));
        double dist = position.distance(target.position);
        damageValue = (dist < speed ?
                super.damageValue(target) :
                (super.damageValue(target)/2));
        target.damage(damageValue);
        shoot--;
    }
}