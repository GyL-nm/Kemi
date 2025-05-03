package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_CHLORIDE_LIQUID;

    public SodiumChloride() {
        properties = PROPERTIES;

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Hydrogen.class, main.substances.solid.staticSolid.Cathode.class},
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
                0.01,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 100.50) }));
    }
}
