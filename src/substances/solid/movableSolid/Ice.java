package substances.solid.movableSolid;

import reactions.ConditionType;
import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;
import substances.liquid.Water;

import java.util.ArrayList;

public class Ice extends MovableSolid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.ICE;

    public Ice() {
        properties = PROPERTIES;

        this.reactions = new Water().reactions;

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.SUBLIMATION},
                new Class[]{substances.gas.Vapour.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.MELTING},
                new Class[]{substances.liquid.Water.class},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 0.0) }));
    }
}
