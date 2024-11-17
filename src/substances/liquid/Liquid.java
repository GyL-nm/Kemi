package substances.liquid;

import substances.Substance;
import system.CellMatrix;

public abstract class Liquid extends Substance {
    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }
}
