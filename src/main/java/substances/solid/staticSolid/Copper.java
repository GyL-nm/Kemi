package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class Copper extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SOLID;

    public Copper() {
        properties = PROPERTIES;
    }
}
