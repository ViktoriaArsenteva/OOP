package chars;

import java.util.ArrayList;

public class Peasant extends BaseHero {

    public Peasant(int x, int y, String fraction) {
        super(1, 1, new int[]{1, 1}, 1, 3, "Peasant", x, y, fraction);
    }

    @Override
    public void step(Team team) {
        if (status.equals("used")) status = "stand";
    }

    
}