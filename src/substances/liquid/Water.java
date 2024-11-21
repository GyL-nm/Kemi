package substances.liquid;

import substances.Substance;
import substances.SubstanceProperties;
import substances.gas.Vapour;
import system.CellMatrix;

import java.util.ArrayList;

public class Water extends Liquid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.WATER;
    public Water() {
        properties = PROPERTIES;
    }

//    @Override
//    public void transferHeat(ArrayList<ArrayList<Substance>> adjacent, CellMatrix cellMatrix) {
//        double averageHeat = CellMatrix.flattenMatrix(adjacent).stream()
//                .filter(java.util.Objects::nonNull)
//                .mapToDouble(substance -> substance.temperature)
//                .average().getAsDouble();
//
//        double averageHeatTransfer = CellMatrix.flattenMatrix(adjacent).stream()
//                .filter(java.util.Objects::nonNull)
//                .mapToDouble(substance -> substance.properties.getHeatTransferFactor())
//                .average().getAsDouble();
//
//        temperature += ((averageHeatTransfer*(averageHeat-temperature)));
//
//        if (temperature > 100.0) {
//            cellMatrix.swapCells(this, new Vapour(this.x, this.y, temperature));
//        }
    }
