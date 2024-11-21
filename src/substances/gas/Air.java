package substances.gas;

import substances.Substance;
import substances.SubstanceProperties;
import system.CellMatrix;

public class Air extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.AIR;

    public Air() {
        properties = PROPERTIES;
    }
}
