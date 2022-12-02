package chars;

import java.util.ArrayList;

public class Spearman extends BaseHero {
    public Spearman(ArrayList<BaseHero> myParty, int x, int y) {
        super(4, 5,  new int[]{1,3}, 10, 4,  "Spearman", myParty, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> party) {

    }
}