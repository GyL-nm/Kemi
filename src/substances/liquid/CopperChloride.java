package substances.liquid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.Empty;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_CHLORIDE_LIQUID;
    public CopperChloride() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{substances.liquid.SodiumChloride.class, substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{substances.liquid.SodiumChloride.class, substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.liquid.SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, substances.liquid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
