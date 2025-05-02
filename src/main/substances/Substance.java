package main.substances;

import main.reactions.Reaction;
import main.substances.gas.Gas;
import main.substances.liquid.Liquid;
import main.substances.solid.movableSolid.MovableSolid;
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

    public Class toMovableSolid() {
        if (this instanceof MovableSolid) return this.getClass();

        return null;
    }

    public Class toLiquid() {
        if (this instanceof Liquid) return this.getClass();

        return null;
    }

    public Class toGas() {
        if (this instanceof Gas) return this.getClass();

        return null;
    }
}
