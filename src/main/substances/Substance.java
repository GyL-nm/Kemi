package main.substances;

import main.reactions.Reaction;
import main.system.Cell;
import main.system.CellMatrix;

import java.util.*;

public abstract class Substance {
    public SubstanceProperties properties;

    public Substance() {}

    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        return CellMatrix.flattenMatrix(adjacent);
    }

    public ArrayList<int[]> moveCandidateQueue() {
        ArrayList queue = new ArrayList<>();
        queue.add(new int[]{-1,1});
        queue.add(new int[]{0,1});
        queue.add(new int[]{1,1});

        return queue;
    }

    public ArrayList<Cell> getReactionCandidates(ArrayList<ArrayList<Cell>> adjacent) { return CellMatrix.flattenMatrix(adjacent); }

    public ArrayList<Reaction> reactions = new ArrayList<>();
    public ArrayList<Reaction> phases = new ArrayList<>();

//    public abstract void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates);

    @Override
    public String toString() { return this.getClass().getSimpleName(); }
}
