package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID_LIQUID;
    public HydrochloricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.gas.Hydrogen.class, substances.solid.staticSolid.Cathode.class},
                -3.04,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Anode.class,
                new Class[]{substances.gas.Chlorine.class, substances.solid.staticSolid.Anode.class},
                -3.04,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), substances.gas.Vapour.class},
                0.77,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
    }
}
