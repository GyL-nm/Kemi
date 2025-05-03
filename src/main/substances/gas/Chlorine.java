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
    }
}
