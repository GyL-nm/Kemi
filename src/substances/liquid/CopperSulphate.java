package substances.liquid;

import substances.SubstanceProperties;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
