package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class Stirrer extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.STIRRER;

    public Stirrer(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public Stirrer(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
