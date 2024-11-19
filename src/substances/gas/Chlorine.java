package substances.gas;

import substances.SubstanceProperties;

public class Chlorine extends Gas {
    final SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;
    public Chlorine(int x, int y) {
        super(x,y);
        properties = PROPERTIES;
    }

    public Chlorine(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
