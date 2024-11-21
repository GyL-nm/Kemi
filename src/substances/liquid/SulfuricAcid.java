package substances.liquid;

import substances.SubstanceProperties;

public class SulfuricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SULFURIC_ACID;

    public SulfuricAcid(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public SulfuricAcid(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
