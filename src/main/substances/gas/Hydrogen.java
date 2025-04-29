package main.substances.gas;

import main.substances.SubstanceProperties;

public class Hydrogen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.HYDROGEN;
    public Hydrogen() {
        properties = PROPERTIES;
    }
}
