package main.substances.solid.staticSolid;

import java.awt.*;

public class Cathode extends Electrode {
    public final static Color marker = new Color(120, 255, 255, 255);

    public Cathode() {
        super(ElectrodePolarity.CATHODE);
    }
}
