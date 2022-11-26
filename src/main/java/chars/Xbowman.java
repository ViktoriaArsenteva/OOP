package chars;

import java.util.List;

public class Xbowman extends Base {
    public Xbowman(List<Base> gang, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Xbowman");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
