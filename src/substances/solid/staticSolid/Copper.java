package substances.solid.staticSolid;

import substances.SubstanceProperties;
import substances.solid.movableSolid.MovableSolid;

public class Copper extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SOLID;

    public Copper() {
        properties = PROPERTIES;
    }
}
