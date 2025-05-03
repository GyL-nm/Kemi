package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.solid.movableSolid.CopperOxide;

import java.util.ArrayList;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID_LIQUID;
    public HydrochloricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, Water.class},
                0.61,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                0.61,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.liquid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                0.6,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.solid.movableSolid.CopperChloride.class, Water.class},
                1.65,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Hydrogen.class, main.substances.solid.staticSolid.Cathode.class},
                -3.04,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Anode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Chlorine.class, main.substances.solid.staticSolid.Anode.class},
                -3.04,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new Reaction(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                0.77,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
    }
}
