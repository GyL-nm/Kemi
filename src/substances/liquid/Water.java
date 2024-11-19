package substances.liquid;

import substances.SubstanceProperties;

public class Water extends Liquid {
    public Water(int x, int y) {
        super(x, y);
        properties = SubstanceProperties.WATER;
    }
}
