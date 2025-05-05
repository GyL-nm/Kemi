package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SODIUM_CHLORIDE_LIQUID;

    public SodiumChloride() {
        properties = PROPERTIES;

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.gas.Hydrogen.class, substances.solid.staticSolid.Cathode.class},
                -4.4,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Anode.class,
                new Class[]{substances.gas.Chlorine.class, substances.solid.staticSolid.Anode.class},
                -4.4,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.CRYSTALLISATION},
                new Class[]{this.toMovableSolid(), substances.gas.Vapour.class},
                0.01,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 100.50) }));
    }
}
