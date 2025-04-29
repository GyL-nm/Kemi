package main.substances.gas;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;


import main.substances.liquid.*;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class Oxygen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.OXYGEN;
    public Oxygen() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( Hydrogen.class,
                new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                new Class[]{Water.class, Water.class},
                10.0,
                new ReactionCondition[]{}));
    }
}
