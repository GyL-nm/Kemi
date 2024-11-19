package substances;

import system.CellMatrix;

public class Empty extends Substance {
    int x,y;

    final public SubstanceProperties properties = SubstanceProperties.EMPTY;

    public Empty(int x, int y) {
        super(x,y);
    }
}
