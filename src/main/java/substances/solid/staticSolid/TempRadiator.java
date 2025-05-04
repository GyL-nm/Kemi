package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class TempRadiator extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.TEMP_RADIATOR;

    public TempRadiator() {
        properties = PROPERTIES;
    }
}
