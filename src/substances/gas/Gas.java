package substances.gas;

import substances.Substance;
import system.CellMatrix;

public abstract class Gas extends Substance {

    protected Gas(int x, int y) { super(x, y); }

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }
}
