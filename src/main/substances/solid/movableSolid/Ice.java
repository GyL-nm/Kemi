package main.substances.solid.movableSolid;

import main.reactions.ConditionType;
import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.gas.Vapour;
import main.substances.liquid.Water;

import java.util.ArrayList;

public class Ice extends MovableSolid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.ICE;

    public Ice() {
        properties = PROPERTIES;

        this.reactions = new Water().reactions;

        this.phases = new ArrayList<>();
        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.SUBLIMATION},
                new Class[]{this.toGas()},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 99.99) }));

        phases.add(new Reaction(null,
                new ReactionType[]{ReactionType.MELTING},
                new Class[]{this.toLiquid()},
                0,
                new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 0.0) }));
    }

    @Override
    public Class toGas() {
        return Vapour.class;
    }

    @Override
    public Class toLiquid() {
        return Water.class;
    }

    public static void main(String[] args) {
        Ice ice = new Ice();

        System.out.println("Gas: " + ice.toGas());
        System.out.println("Liquid: " + ice.toLiquid());
        System.out.println("Solid: " + ice.toMovableSolid());
    }
}
