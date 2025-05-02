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
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{main.substances.solid.movableSolid.CopperChloride.class, main.substances.gas.Vapour.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.CONDENSATION},
                new Class[]{main.substances.liquid.Water.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.LESSER_THAN, 99.99) }));
    }
}
