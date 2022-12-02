package chars;

import java.util.ArrayList;

public class Robber extends BaseHero {
    public Robber(ArrayList<BaseHero> myParty, int x, int y) {
        super(8, 3, new int[]{2,4}, 10, 6, "Robber", myParty, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> party) {

    }
}