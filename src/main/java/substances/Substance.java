package substances;

import reactions.PhaseChange;
import reactions.Reaction;
import substances.gas.Gas;
import substances.liquid.Liquid;
import substances.solid.movableSolid.MovableSolid;
import system.Cell;
import system.CellMatrix;

import java.util.*;

public abstract class Substance {
    public SubstanceProperties properties;

    public Substance() {}

    public ArrayList<int[]> moveCandidateQueue() {
        ArrayList queue = new ArrayList<>();
        queue.add(new int[]{0,1});
        queue.add(new int[]{-1,1});
        queue.add(new int[]{1,1});

        return queue;
    }

    public ArrayList<Reaction> reactions = new ArrayList<>();
    public ArrayList<PhaseChange> phases = new ArrayList<>();

    @Override
    public String toString() { return this.getClass().getSimpleName(); }

    public Class toMovableSolid() {
        if (this instanceof MovableSolid) return this.getClass();

        String substanceName = this.getClass().getSimpleName();
        try {
            return Class.forName("substances.solid.movableSolid." + substanceName);
        } catch (Exception ignored) {
            return null;
        }
    }

    public Class toLiquid() {
        if (this instanceof Liquid) return this.getClass();

        String substanceName = this.getClass().getSimpleName();
        try {
            return Class.forName("substances.liquid." + substanceName);
        } catch (Exception ignored) {
            return null;
        }
    }

    public Class toGas() {
        if (this instanceof Gas) return this.getClass();

        String substanceName = this.getClass().getSimpleName();
        try {
            return Class.forName("substances.gas." + substanceName);
        } catch (Exception ignored) {
            return null;
        }
    }
}
