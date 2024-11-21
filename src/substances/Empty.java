package substances;

import system.CellMatrix;

public class Empty extends Substance {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.EMPTY;

    public Empty() {
        properties = PROPERTIES;
    }
}
