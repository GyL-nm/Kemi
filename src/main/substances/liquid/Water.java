package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.gas.Vapour;
import main.substances.solid.movableSolid.Ice;

import java.util.ArrayList;

public class Water extends Liquid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.WATER;
    public Water() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.solid.movableSolid.CopperChloride.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.CopperChloride.class, main.substances.liquid.CopperChloride.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.CopperSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.CopperSulphate.class, main.substances.liquid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.HydrochloricAcid.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.HydrochloricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumChloride.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.liquid.SodiumChloride.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumHydroxide.class, main.substances.liquid.SodiumHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.liquid.SodiumSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.FREEZING},
                new Class[]{this.toMovableSolid()},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 0.01) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toGas()},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
    }

    @Override
    public Class toGas() {
        return Vapour.class;
    }

    @Override
    public Class toMovableSolid() {
        return Ice.class;
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
