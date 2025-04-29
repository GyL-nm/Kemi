package main.substances.solid.staticSolid;

import main.substances.SubstanceProperties;

public class Electrode extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.ELECTRODE;

    public Electrode() {
        properties = PROPERTIES;
    }
}
