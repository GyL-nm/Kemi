package substances.solid.movableSolid;

import reactions.*;
import substances.SubstanceProperties;

import java.util.ArrayList;

public class CopperHydroxide extends MovableSolid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_HYDROXIDE_SOLID;

    public CopperHydroxide() {
        properties = PROPERTIES;

        this.phases = new ArrayList<>();
        phases.add(new PhaseChange(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{substances.solid.movableSolid.CopperOxide.class, substances.gas.Vapour.class},
                0.77,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 184.99) }));
    }
}
