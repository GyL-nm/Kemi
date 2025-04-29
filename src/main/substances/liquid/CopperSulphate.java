package main.substances.liquid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.liquid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.movableSolid.SodiumHydroxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                10.0,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.liquid.SulfuricAcid.class,
                new ReactionType[]{ReactionType.NEUTRALISATION},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                10.0,
                new ReactionCondition[]{} ));
    }
}
