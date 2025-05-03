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
                0.85,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.CopperSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.CopperSulphate.class, main.substances.liquid.CopperSulphate.class},
                0.70,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.HydrochloricAcid.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.HydrochloricAcid.class},
                0.77,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumChloride.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.liquid.SodiumChloride.class},
                -0.01,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumHydroxide.class, main.substances.liquid.SodiumHydroxide.class},
                0.47,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.liquid.SodiumSulphate.class},
                0.21,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Hydrogen.class, main.substances.solid.staticSolid.Cathode.class},
                -3.05,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Anode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Oxygen.class, main.substances.solid.staticSolid.Anode.class},
                -3.05,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.FREEZING},
                new Class[]{this.toMovableSolid()},
                0.08,
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
