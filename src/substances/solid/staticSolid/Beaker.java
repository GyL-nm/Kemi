package substances.solid.staticSolid;

import substances.SubstanceProperties;
import system.CellMatrix;

public class Beaker extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.BEAKER;

    public Beaker() {
        properties = PROPERTIES;
    }
}
