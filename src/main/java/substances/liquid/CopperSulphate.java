package substances.liquid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( substances.solid.staticSolid.Cathode.class,
                new Class[]{substances.solid.movableSolid.Copper.class, substances.solid.staticSolid.Cathode.class},
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
                0.70,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 109.99) }));
    }


}
