package main.substances.liquid;

import main.reactions.*;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperSulphate extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_LIQUID;

    public CopperSulphate() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( main.substances.solid.staticSolid.Cathode.class,
                new Class[]{main.substances.solid.movableSolid.Copper.class, main.substances.solid.staticSolid.Cathode.class},
                -4.3,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( main.substances.solid.staticSolid.Anode.class,
                new Class[]{main.substances.gas.Oxygen.class, main.substances.solid.staticSolid.Anode.class},
                -4.3,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                0.70,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 109.99) }));
    }


}
