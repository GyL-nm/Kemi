package main.substances.solid.staticSolid;

import java.awt.*;

public class Anode extends Electrode {
    public final static Color marker = Color.RED;

    public Anode() {
        super(ElectrodePolarity.ANODE);
    }
}
