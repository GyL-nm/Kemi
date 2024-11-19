package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class Electrode extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.ELECTRODE;

    public Electrode(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
