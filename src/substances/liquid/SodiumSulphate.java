package substances.liquid;

import substances.SubstanceProperties;

public class SodiumSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_SULPHATE;

    public SodiumSulphate(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public SodiumSulphate(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
