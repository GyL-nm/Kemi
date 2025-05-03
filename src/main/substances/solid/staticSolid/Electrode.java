package main.substances.solid.staticSolid;

import main.substances.SubstanceProperties;

public class Electrode extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.GRAPHITE;

    ElectrodePolarity polarity;

    public Electrode() {
        properties = PROPERTIES;
    }

    public Electrode(ElectrodePolarity polarity) {
        properties = PROPERTIES;
        this.polarity = polarity;
    }
}
