package substances.gas;

import reactions.ConditionType;
import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.Substance;
import substances.SubstanceProperties;
import substances.liquid.Water;
import system.CellMatrix;

import java.util.ArrayList;

public class Vapour extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.OXYGEN;



    public Vapour() {
        properties = PROPERTIES;

        this.reactions = new Water().reactions;

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.DEPOSITION},
                new Class[]{substances.solid.movableSolid.Ice.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 0.01) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.CONDENSATION},
                new Class[]{substances.liquid.Water.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 99.99) }));
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
