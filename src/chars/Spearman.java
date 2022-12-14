package chars;

import java.util.ArrayList;

public class Spearman extends BaseHero {

    private int fieldSize;
    public Spearman(int x, int y, String fraction, int fieldSize) {
        super(4, 5,  new int[]{1,3}, 10, 4,  "Spearman", x, y, fraction);
        this.fieldSize = fieldSize;
    }

    public Spearman(int attack, int protection, int[] damage, int health, int speed,
                    String name, int x, int y, String fraction, int fieldSize) {
        super(attack, protection, damage, health, speed, name, x, y, fraction);
        this.fieldSize = fieldSize;
    }

    @Override
    public void step(Team team) {

        target = position.findNearest(team.getByFraction(fraction, false));

        if (position.distance(target.position) <= (int) Math.sqrt(2)) {
            damageValue = super.damageValue(target);
            target.damage(damageValue);
            return;
        }
        if (target.position.x < position.x && position.isValid(new Coordinates(--position.x, position.y, fieldSize), team.getAll())) {
            --position.x;
            return;
        }
        if (target.position.x > position.x && position.isValid(new Coordinates(++position.x, position.y, fieldSize), team.getAll())) {
            ++position.x;
            return;
        }
        if (target.position.y < position.y && position.isValid(new Coordinates(position.x, --position.y, fieldSize), team.getAll())) {
            --position.y;
            return;
        }
        if (target.position.y > position.y && position.isValid(new Coordinates(position.x, ++position.y, fieldSize), team.getAll())) {
            ++position.y;
        }
    }

}