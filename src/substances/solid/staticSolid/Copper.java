package substances.solid.staticSolid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;
import substances.liquid.Water;
import substances.solid.movableSolid.CopperOxide;
import substances.solid.movableSolid.MovableSolid;

public class Copper extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SOLID;

    public Copper() {
        properties = PROPERTIES;

        reactions.add(new Reaction( Water.class,
                new ReactionType[]{ReactionType.OXIDATION},
                new Class[]{CopperOxide.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
