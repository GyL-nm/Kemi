package substances.solid;

import substances.Substance;

public abstract class Solid extends Substance {
    protected Solid(int x, int y) { super(x, y); }

    public Solid(int x, int y, double temperature) { super(x, y, temperature); }
}
