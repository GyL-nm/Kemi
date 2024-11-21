package substances.solid.movableSolid;

import substances.SubstanceProperties;

public class CopperOxide extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_OXIDE;

    CopperOxide(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public CopperOxide(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
