package substances.solid.staticSolid;

import substances.SubstanceProperties;

import java.awt.*;

public class Cathode extends StaticSolid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.CATHODE;
    public final static Color marker = new Color(120, 255, 255, 255);

    public Cathode() {
        properties = PROPERTIES;
    }
}
