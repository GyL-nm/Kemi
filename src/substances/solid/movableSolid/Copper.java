package substances.solid.movableSolid;

public class Copper extends MovableSolid {
    public Copper(int x, int y) {
        super(x, y);
        mass = 8940.0;
        heatTransferFactor = 0.9;
    }

    public Copper(int x, int y, double temperature) {
        super(x, y, temperature);
        mass = 8940.0;
        heatTransferFactor = 0.9;
    }
}
