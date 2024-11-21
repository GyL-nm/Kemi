package substances;

import substances.solid.Solid;
import system.Cell;
import system.CellMatrix;

import java.util.*;

public abstract class Substance {
    public SubstanceProperties properties;

    private java.util.Objects Objects;

    public Substance() {}

    public ArrayList<Cell> getFallCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return CellMatrix.flattenMatrix(adjacent);
    }

//    public abstract void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates);

    @Override
    public String toString() { return this.getClass().getSimpleName(); }
}
