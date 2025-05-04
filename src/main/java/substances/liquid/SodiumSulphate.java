package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_SULPHATE_LIQUID;

    public SodiumSulphate() {
        properties = PROPERTIES;

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.gas.Hydrogen.class, substances.solid.staticSolid.Cathode.class},
                -4.3,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Anode.class,
                new Class[]{substances.gas.Oxygen.class, substances.solid.staticSolid.Anode.class},
                -4.3,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), substances.gas.Vapour.class},
                0.21,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 100.76) }));
    }
}
