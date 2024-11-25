package substances.liquid;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SulfuricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SULFURIC_ACID;

    public SulfuricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( substances.solid.movableSolid.CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
