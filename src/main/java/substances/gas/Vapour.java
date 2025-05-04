package substances.gas;

import reactions.*;
import substances.SubstanceProperties;
import substances.liquid.Water;
import substances.solid.movableSolid.Ice;

import java.util.ArrayList;

public class Vapour extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.VAPOUR;



    public Vapour() {
        properties = PROPERTIES;

//        this.reactions = new Water().reactions;

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(null,
                new ReactionType[]{ReactionType.DEPOSITION},
                new Class[]{this.toMovableSolid()},
                0.4,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 0.01) }));

        phases.add(new PhaseChange(null,
                new ReactionType[]{ReactionType.CONDENSATION},
                new Class[]{this.toLiquid()},
                0.3,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 99.99) }));
    }

    @Override
    public Class toMovableSolid() {
        return Ice.class;
    }

    @Override
    public Class toLiquid() {
        return Water.class;
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
//        if (temperature <= 100.0) {
//            cellMatrix.swapCells(this, new Water(this.x, this.y, temperature));
//        }
//    }
}
