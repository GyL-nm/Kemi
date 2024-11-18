package substances.gas;

import substances.Substance;
import system.CellMatrix;

public class Air extends Gas {
    int x,y;


    public Air(int x, int y) {
        super(x,y);
        mass = 1200.0; // mass of 1m^3 of air
        heatTransferFactor = 0.026;
    }

    public Air(int x, int y, double temperature) {
        super(x,y, temperature);
        mass = 1200.0; // mass of 1m^3 of air
        heatTransferFactor = 0.1;
    }
}
