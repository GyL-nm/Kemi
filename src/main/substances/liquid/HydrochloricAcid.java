package main.substances.liquid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.solid.movableSolid.CopperOxide;

import java.util.ArrayList;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID_LIQUID;
    public HydrochloricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.liquid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumSulphate.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.solid.movableSolid.CopperChloride.class, Water.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
