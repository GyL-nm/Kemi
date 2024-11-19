package substances.gas;

import substances.SubstanceProperties;

public class Hydrogen extends Gas {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROGEN;
    public Hydrogen(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
