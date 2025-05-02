package main.substances.liquid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;

import java.util.ArrayList;

public class SodiumChloride extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;

    public SodiumChloride() {
        properties = PROPERTIES;

        this.phases = new ArrayList<>();
        phases.add(new Reaction(this.properties.getSubstanceReference(),
                new ReactionType[]{ReactionType.EVAPORATION},
                new Class[]{this.toMovableSolid(), main.substances.gas.Vapour.class},
                10.0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 100.50) }));
    }

    public static void main(String[] args) {
        SodiumChloride sc = new SodiumChloride();

        System.out.println("Solid: " + sc.toMovableSolid());
        System.out.println("Liquid: " + sc.toLiquid());
        System.out.println("Gas: " + sc.toGas());

    }
}
