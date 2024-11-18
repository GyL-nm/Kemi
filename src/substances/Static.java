package substances;

import system.CellMatrix;

public abstract class Static extends Substance {

    public Static(int x, int y) { super(x,y); };

    @Override
    public void step(CellMatrix cellMatrix) {
        // Does nothing
    }
}
