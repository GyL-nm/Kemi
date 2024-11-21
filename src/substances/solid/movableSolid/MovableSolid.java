package substances.solid.movableSolid;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import system.Cell;
import system.CellMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public abstract class MovableSolid extends Solid {
    public MovableSolid() { }

    @Override
    public ArrayList<Cell> getFallCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        ArrayList<Cell> candidates = adjacent.get(2);
        Collections.swap(candidates, 1, 0);
        candidates.removeIf(cell -> cell.substance instanceof Solid);

        return candidates;
    }

    //    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//
//    }
}
