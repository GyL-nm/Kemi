package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class SulfuricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.SULFURIC_ACID;

    public SulfuricAcid() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
        reactions.add(new Reaction( main.substances.solid.movableSolid.CopperOxide.class,
                new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                1.8,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Cathode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Hydrogen.class, main.substances.solid.staticSolid.Cathode.class},
                -0.7,
                new ReactionCondition[]{} ));

        reactions.add(new Reaction( main.substances.solid.staticSolid.Anode.class,
                new ReactionType[]{ReactionType.ELECTROLYSIS},
                new Class[]{main.substances.gas.Oxygen.class, main.substances.solid.staticSolid.Anode.class},
                -0.7,
                new ReactionCondition[]{} ));

//        this.phases = new ArrayList<>();
//        phases.add(new Reaction(this.properties.getSubstanceReference(),
//                new ReactionType[]{ReactionType.EVAPORATION},
//                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
//                10.0,
//                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 101.53) }));
    }
}
