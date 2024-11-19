package substances.solid.staticSolid;

import substances.SubstanceProperties;

public class Thermometer extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.THERMOMETER;

    public Thermometer(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
