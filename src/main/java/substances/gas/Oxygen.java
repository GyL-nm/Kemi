package substances.gas;


import substances.SubstanceProperties;

import java.util.ArrayList;

public class Oxygen extends Gas {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.OXYGEN;
    public Oxygen() {
        properties = PROPERTIES;

        this.reactions = new ArrayList<>();
    }
}
