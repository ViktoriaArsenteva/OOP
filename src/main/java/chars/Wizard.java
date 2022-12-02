package chars;

import java.util.ArrayList;

public class Wizard extends Monk {

    public Wizard(ArrayList<BaseHero> myParty, int x, int y) {
        super(17, 12, new int[]{-5, -5}, 30, 9, "Warlock", myParty, x, y);
    }

}
