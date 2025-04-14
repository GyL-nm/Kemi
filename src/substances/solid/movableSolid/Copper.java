package substances.solid.movableSolid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;
import substances.liquid.Water;

public class Copper extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_POWDER;

    public Copper() {
        properties = PROPERTIES;

        reactions.add(new Reaction( Water.class,
                new ReactionType[]{ReactionType.OXIDATION},
                new Class[]{CopperOxide.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
