package substances.solid;

import substances.Substance;
import system.Cell;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Solid extends Substance {
    protected Solid() {  }

    @Override
    public ArrayList<Cell> getFallCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return CellMatrix.flattenMatrix(adjacent);
    }
}
