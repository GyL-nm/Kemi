package main.substances.gas;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class Hydrogen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.HYDROGEN;
    public Hydrogen() {
        properties = PROPERTIES;
    }
}
