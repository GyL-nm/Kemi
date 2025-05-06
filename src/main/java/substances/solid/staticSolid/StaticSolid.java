package substances.solid.staticSolid;

import substances.solid.Solid;

import java.util.ArrayList;

public abstract class StaticSolid extends Solid {
    public StaticSolid() {}

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        return new ArrayList<>();
    }
}

