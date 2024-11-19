package substances.liquid;

import substances.SubstanceProperties;

public class HydrochloricAcid extends Liquid {
    final SubstanceProperties PROPERTIES = SubstanceProperties.HYDROCHLORIC_ACID;
    public HydrochloricAcid(int x, int y) {
        super(x, y);
        properties = PROPERTIES;
    }
}
