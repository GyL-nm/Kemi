package substances.solid.movableSolid;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import system.CellMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public abstract class MovableSolid extends Solid {
    public MovableSolid(int x,int y) { super(x,y); }

    @Override
    public ArrayList<Substance> getFallCandidates(ArrayList<ArrayList<Substance>> adjacent) {
        ArrayList<Substance> candidates = adjacent.get(2);
        Collections.swap(candidates, 1, 0);
        candidates.removeIf(sub -> sub instanceof Solid);
        return candidates;
    }

    //    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//
//    }
}
