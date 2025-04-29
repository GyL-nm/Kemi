package main.substances.solid;

import main.substances.Substance;
import main.system.Cell;
import main.system.CellMatrix;

import java.util.ArrayList;

public abstract class Solid extends Substance {
    protected Solid() {  }

    @Override
    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return CellMatrix.flattenMatrix(adjacent);
    }
}
