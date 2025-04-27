package substances.solid.staticSolid;

import substances.Substance;
import substances.solid.Solid;
import system.CellMatrix;

import java.util.ArrayList;

public abstract class StaticSolid extends Solid {
    public StaticSolid() {}

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        return new ArrayList<>();
    }

//    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//        System.out.println(this + " is static");
//    }
}

