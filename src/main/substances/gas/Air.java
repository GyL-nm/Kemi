package main.substances.gas;

import main.substances.SubstanceProperties;

public class Air extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.AIR;

    public Air() {
        properties = PROPERTIES;
    }
}
