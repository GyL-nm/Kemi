package main.substances.solid.staticSolid;

import main.substances.SubstanceProperties;

public class Stirrer extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.STIRRER;

    public Stirrer() {
        properties = PROPERTIES;
    }
}
