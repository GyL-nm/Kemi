package substances.gas;

import substances.SubstanceProperties;

public class Oxygen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.OXYGEN;
    public Oxygen(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }

    public Oxygen(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
