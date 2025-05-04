package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumHydroxide extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_HYDROXIDE_LIQUID;

    public SodiumHydroxide() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.gas.Hydrogen.class, substances.solid.staticSolid.Cathode.class},
                -4.0,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Anode.class,
                new Class[]{substances.gas.Oxygen.class, substances.solid.staticSolid.Anode.class},
                -4.0,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), substances.gas.Vapour.class},
                0.47,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 102.04) }));
    }
}
