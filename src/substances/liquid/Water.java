package substances.liquid;

import reactions.ConditionType;
import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.Empty;
import substances.Substance;
import substances.SubstanceProperties;
import substances.gas.Hydrogen;
import substances.gas.Vapour;
import system.CellMatrix;

import java.util.ArrayList;

public class Water extends Liquid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.WATER;
    public Water() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.solid.movableSolid.CopperChloride.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.CopperChloride.class, substances.liquid.CopperChloride.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.CopperSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.CopperSulphate.class, substances.liquid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.HydrochloricAcid.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.HydrochloricAcid.class, substances.liquid.HydrochloricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumChloride.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.SodiumChloride.class, substances.liquid.SodiumChloride.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.SodiumHydroxide.class, substances.liquid.SodiumHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.SodiumSulphate.class, substances.liquid.SodiumSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.FREEZING},
                new Class[]{substances.solid.movableSolid.Ice.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 0.01) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{substances.gas.Vapour.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
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
