package substances.gas;

import substances.Substance;
import system.CellMatrix;

public abstract class Gas extends Substance {

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }
}
