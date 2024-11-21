package substances.liquid;

import substances.SubstanceProperties;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public CopperSulphate(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
