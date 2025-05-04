package substances.solid.staticSolid;

import substances.SubstanceProperties;

import java.awt.*;

public class Anode extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.ANODE;
    public final static Color marker = Color.RED;

    public Anode() {
        properties = PROPERTIES;
    }
}
