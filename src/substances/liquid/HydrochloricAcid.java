package substances.liquid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;
import substances.solid.movableSolid.CopperOxide;

import java.util.ArrayList;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID_LIQUID;
    public HydrochloricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{substances.solid.movableSolid.SodiumChloride.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.liquid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{substances.solid.movableSolid.CopperChloride.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
