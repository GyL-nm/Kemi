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
    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return new ArrayList<>();
    }

    //    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//
//    }
}
