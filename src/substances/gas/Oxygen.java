package substances.gas;

import substances.SubstanceProperties;

public class Oxygen extends Gas {
    final SubstanceProperties PROPERTIES = SubstanceProperties.OXYGEN;
    public Oxygen(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
