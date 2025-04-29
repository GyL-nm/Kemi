package main.substances.solid.movableSolid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.liquid.Water;

import java.util.ArrayList;

public class Ice extends MovableSolid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.ICE;

    public Ice() {
        properties = PROPERTIES;

        this.reactions = new Water().reactions;

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.SUBLIMATION},
                new Class[]{main.substances.gas.Vapour.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.MELTING},
                new Class[]{main.substances.liquid.Water.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 0.0) }));
    }
}
