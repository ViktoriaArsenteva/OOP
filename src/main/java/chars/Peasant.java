package chars;

import java.util.List;

public class Peasant extends Base {


    public Peasant(List<Base> gang, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
