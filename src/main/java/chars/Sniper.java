package chars;

import java.util.List;

public class Sniper extends Base {
    public Sniper(List<Base> gang, int x, int y) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, false, false, "Sniper");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
