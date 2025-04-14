package substances.gas;

import reactions.ConditionType;
import reactions.ReactionCondition;
import substances.Empty;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;

import reactions.Reaction;
import reactions.ReactionType;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class Chlorine extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;
    public Chlorine() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( Hydrogen.class,
                                    new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                                    new Class[]{substances.liquid.HydrochloricAcid.class, substances.liquid.HydrochloricAcid.class},
                                    10.0,
                                    new ReactionCondition[]{}));
    }
}
