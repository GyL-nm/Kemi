package main.substances.liquid;

import main.reactions.*;
import main.substances.SubstanceProperties;
import main.substances.solid.movableSolid.CopperOxide;

import java.util.ArrayList;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID_LIQUID;
    public HydrochloricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new ElectrolysisReaction( main.substances.solid.staticSolid.Cathode.class,
                new Class[]{main.substances.gas.Hydrogen.class, main.substances.solid.staticSolid.Cathode.class},
                -3.04,
                new ReactionCondition[]{} ));

        reactions.add(new ElectrolysisReaction( main.substances.solid.staticSolid.Anode.class,
                new Class[]{main.substances.gas.Chlorine.class, main.substances.solid.staticSolid.Anode.class},
                -3.04,
                new ReactionCondition[]{} ));

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                0.77,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));
    }
}
