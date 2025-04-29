package main.substances.liquid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class SulfuricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SULFURIC_ACID;

    public SulfuricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.solid.movableSolid.CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
