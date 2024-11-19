package substances.gas;

import substances.Substance;
import substances.SubstanceProperties;
import substances.liquid.Water;
import system.CellMatrix;

import java.util.ArrayList;

public class Vapour extends Gas {
    public Vapour(int x, int y) {
        super(x, y);
        properties = SubstanceProperties.VAPOUR;
    }

    public Vapour(int x, int y, double temperature) {
        super(x, y, temperature);
        properties = SubstanceProperties.VAPOUR;
    }

    @Override
    public void transferHeat(ArrayList<ArrayList<Substance>> adjacent, CellMatrix cellMatrix) {
        double averageHeat = CellMatrix.flattenMatrix(adjacent).stream()
                .filter(java.util.Objects::nonNull)
                .mapToDouble(substance -> substance.temperature)
                .average().getAsDouble();

        double averageHeatTransfer = CellMatrix.flattenMatrix(adjacent).stream()
                .filter(java.util.Objects::nonNull)
                .mapToDouble(substance -> substance.properties.getHeatTransferFactor())
                .average().getAsDouble();

        temperature += ((averageHeatTransfer*(averageHeat-temperature)));

        if (temperature <= 100.0) {
            cellMatrix.swapCells(this, new Water(this.x, this.y, temperature));
        }
    }
}
