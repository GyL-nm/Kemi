package substances.solid.movableSolid;

import substances.solid.Solid;

import system.Cell;

import java.util.ArrayList;


public abstract class MovableSolid extends Solid {
    public MovableSolid() { }

    @Override
    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return adjacent.get(2); // below, below left, below right
    }

    //    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//
//    }
}
