package main.substances.solid.staticSolid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.liquid.Water;
import main.substances.solid.movableSolid.CopperOxide;

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
