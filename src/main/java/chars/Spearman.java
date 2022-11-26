package chars;

import java.util.List;

public class Spearman extends Base {
    public Spearman(List<Base> gang, int x, int y) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false, "Spearman");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
