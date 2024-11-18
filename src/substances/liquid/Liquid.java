package substances.liquid;

import substances.Substance;
import system.CellMatrix;

public abstract class Liquid extends Substance {
    protected Liquid(int x, int y) { super(x, y); }

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }
}
