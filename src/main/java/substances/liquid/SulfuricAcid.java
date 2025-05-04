package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SulfuricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SULFURIC_ACID;

    public SulfuricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.gas.Hydrogen.class, substances.solid.staticSolid.Cathode.class},
                -0.7,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Anode.class,
                new Class[]{substances.gas.Oxygen.class, substances.solid.staticSolid.Anode.class},
                -0.7,
                new ReactionCondition[]{} ));

//        this.phases = new ArrayList<>();
//        phases.add(new Reaction(this.properties.getSubstanceReference(),
//                new ReactionType[]{ReactionType.EVAPORATION},
//                new Class[]{this.toMovableSolid(), substances.gas.Vapour.class},
//                10.0,
//                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 101.53) }));
    }
}
