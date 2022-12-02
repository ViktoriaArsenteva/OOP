package chars;

import java.util.ArrayList;

public class Coordinates {
    public int x, y;

    public Coordinates (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isSame(Coordinates pos) {
        return this.x == pos.x && this.y == pos.y;
    }

    public double distance(Coordinates pos) {
        return Math.sqrt(((pos.x - this.x)^2 + (pos.y - this.y^2)));
    }

    public BaseHero findNearest(ArrayList<BaseHero> enemy) {
        double dist = this.distance(enemy.get(0).getPosition());
        int nearestInd = 0;
        for (int i = 1; i < enemy.size(); i++) {
            if (this.distance(enemy.get(i).getPosition()) < dist && !(enemy.get(i).status.equals("dead"))) {
                dist = this.distance(enemy.get(i).getPosition());
                nearestInd = i;
            }
        }
        return enemy.get(nearestInd);
    }
}