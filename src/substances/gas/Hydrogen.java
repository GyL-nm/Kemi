package substances.gas;

import reactions.Reaction;
import reactions.ReactionCondition;
import reactions.ReactionType;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class Hydrogen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.HYDROGEN;
    public Hydrogen() {
        properties = PROPERTIES;
    }
}
