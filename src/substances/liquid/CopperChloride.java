package substances.liquid;

import substances.SubstanceProperties;

public class CopperChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_CHLORIDE;
    public CopperChloride(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
