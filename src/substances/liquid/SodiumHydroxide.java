package substances.liquid;

import substances.SubstanceProperties;

public class SodiumHydroxide extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_HYDROXIDE;

    public SodiumHydroxide(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public SodiumHydroxide(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
