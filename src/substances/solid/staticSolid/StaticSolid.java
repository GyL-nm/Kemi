package substances.solid.staticSolid;

import substances.solid.Solid;
import system.CellMatrix;

public abstract class StaticSolid extends Solid {
    public StaticSolid(int x, int y) { super(x, y); }

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " is static");
    }
}
