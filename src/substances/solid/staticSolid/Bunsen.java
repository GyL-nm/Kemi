package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class Bunsen extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.BUNSEN;

    public Bunsen(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
