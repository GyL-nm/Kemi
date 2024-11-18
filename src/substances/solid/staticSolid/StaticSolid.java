package substances.solid.staticSolid;

import substances.Substance;
import substances.solid.Solid;
import system.CellMatrix;

import java.util.ArrayList;

public abstract class StaticSolid extends Solid {
    public StaticSolid(int x, int y) { super(x, y); }
    public StaticSolid(int x, int y, double temperature) { super(x, y, temperature); }

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " is static");
    }

//    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//        System.out.println(this + " is static");
//    }
}

