package substances.solid;

import substances.Substance;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Solid extends Substance {
    protected Solid(int x, int y) { super(x, y); }

    public Solid(int x, int y, double temperature) { super(x, y, temperature); }

    @Override
    public ArrayList<Substance> getFallCandidates(ArrayList<ArrayList<Substance>> adjacent) {
        Collections.swap(adjacent, 0, 1);
        return adjacent.get(2);
    }
}
