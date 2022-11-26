package chars;

import java.util.List;

public class Monk extends Base {
    public Monk(List<Base> gang, int x, int y) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

}
