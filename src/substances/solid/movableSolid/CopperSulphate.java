package substances.solid.movableSolid;

import substances.SubstanceProperties;

public class CopperSulphate extends MovableSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.COPPER_SULPHATE_SOLID;

    CopperSulphate(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
