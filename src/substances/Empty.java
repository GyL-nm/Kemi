package substances;

import system.CellMatrix;

public class Empty extends Substance {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.EMPTY;

    public Empty(int x, int y) {
        super(x,y);
        properties = PROPERTIES;
    }
    public Empty(int x, int y, double temperature) {
        super(x,y, temperature);
        properties = PROPERTIES;
    }
}
