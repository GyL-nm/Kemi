package substances.solid.movableSolid;

import substances.SubstanceProperties;

public class Copper extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_POWDER;

    public Copper() {
        properties = PROPERTIES;
    }
}
