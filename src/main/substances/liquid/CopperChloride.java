package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_CHLORIDE_LIQUID;
    public CopperChloride() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                0.22,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.solid.movableSolid.Copper.class, main.substances.solid.staticSolid.Cathode.class},
                -4.4,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Anode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Chlorine.class, main.substances.solid.staticSolid.Anode.class},
                -4.4,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                0.85,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
    }
}
