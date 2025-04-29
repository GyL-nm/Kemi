package main.substances.solid.movableSolid;

import main.substances.solid.Solid;

import main.system.Cell;

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
