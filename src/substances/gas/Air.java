package substances.gas;

import substances.Substance;
import substances.SubstanceProperties;
import system.CellMatrix;

public class Air extends Gas {
    final SubstanceProperties PROPERTIES = SubstanceProperties.AIR;

    public Air(int x, int y) {
        super(x,y);
        properties = PROPERTIES;
    }

    public Air(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
