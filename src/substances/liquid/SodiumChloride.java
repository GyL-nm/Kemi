package substances.liquid;

import substances.SubstanceProperties;

public class SodiumChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;

    public SodiumChloride(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public SodiumChloride(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
