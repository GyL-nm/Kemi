package substances.solid.movableSolid;

import substances.SubstanceProperties;

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
