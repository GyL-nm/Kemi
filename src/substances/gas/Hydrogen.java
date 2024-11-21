package substances.gas;

import substances.SubstanceProperties;

public class Hydrogen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.HYDROGEN;
    public Hydrogen(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public Hydrogen(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
