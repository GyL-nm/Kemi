package main.substances.liquid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumHydroxide extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_HYDROXIDE_LIQUID;

    public SodiumHydroxide() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.solid.movableSolid.Copper.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
