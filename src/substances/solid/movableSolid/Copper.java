package substances.solid.movableSolid;

import substances.SubstanceProperties;

public class Copper extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER;

    public Copper(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public Copper(int x, int y, double temperature) {
        super(x, y, temperature);
        properties = PROPERTIES;
    }
}
