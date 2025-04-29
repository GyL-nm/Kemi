package main.substances.gas;

import main.reactions.ReactionCondition;

import main.reactions.Reaction;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class Chlorine extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;
    public Chlorine() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( Hydrogen.class,
                                    new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                                    new Class[]{main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.HydrochloricAcid.class},
                                    10.0,
                                    new ReactionCondition[]{}));
    }
}
