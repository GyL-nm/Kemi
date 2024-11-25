package substances.liquid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumHydroxide extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_HYDROXIDE_LIQUID;

    public SodiumHydroxide() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.solid.movableSolid.Copper.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{Water.class, substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
