package substances;

import reactions.Reaction;
import system.Cell;
import system.CellMatrix;

import java.util.*;

public abstract class Substance {
    public SubstanceProperties properties;

    private java.util.Objects Objects;

    public Substance() {}

    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return CellMatrix.flattenMatrix(adjacent);
    }

    public ArrayList<Cell> getReactionCandidates(ArrayList<ArrayList<Cell>> adjacent) { return CellMatrix.flattenMatrix(adjacent); }

    public ArrayList<Reaction> reactions = new ArrayList<>();

//    public abstract void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates);

    @Override
    public String toString() { return this.getClass().getSimpleName(); }
}
