package substances.liquid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{substances.liquid.SodiumSulphate.class, substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{substances.liquid.SodiumSulphate.class, substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.liquid.SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
