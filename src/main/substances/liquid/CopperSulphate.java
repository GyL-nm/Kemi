package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.liquid.SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.solid.movableSolid.Copper.class, main.substances.solid.staticSolid.Cathode.class},
                -4.3,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Anode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Oxygen.class, main.substances.solid.staticSolid.Anode.class},
                -4.3,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                0.70,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 109.99) }));
    }


}
