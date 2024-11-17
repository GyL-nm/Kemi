package substances.solid.staticSolid;

import substances.solid.Solid;
import system.CellMatrix;

public abstract class StaticSolid extends Solid {
    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }
}
