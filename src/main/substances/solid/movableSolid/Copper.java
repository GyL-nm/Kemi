package main.substances.solid.movableSolid;

import main.reactions.Reaction;
import main.reactions.ReactionCondition;
import main.reactions.ReactionType;
import main.substances.SubstanceProperties;
import main.substances.liquid.Water;

public class Copper extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_POWDER;

    public Copper() {
        properties = PROPERTIES;
    }

    public static void main(String[] args) {
        Copper copper = new Copper();

        System.out.println("Gas: " + copper.toGas());
        System.out.println("Liquid: " + copper.toLiquid());
        System.out.println("Solid: " + copper.toMovableSolid());
    }
}
