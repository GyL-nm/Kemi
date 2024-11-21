package substances.solid.movableSolid;

import substances.SubstanceProperties;

public class Ice extends MovableSolid {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.ICE;

    public Ice() {
        properties = PROPERTIES;
    }
}
