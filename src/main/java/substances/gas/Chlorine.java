package substances.gas;

import substances.SubstanceProperties;

import java.util.ArrayList;

public class Chlorine extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.CHLORINE;
    public Chlorine() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
    }
}
