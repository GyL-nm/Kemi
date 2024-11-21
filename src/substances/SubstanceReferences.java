package substances;

import java.util.Arrays;
import java.util.HashMap;

public class SubstanceReferences extends HashMap<Class<? extends Substance>, SubstanceProperties> {
    public SubstanceReferences() {
        for (SubstanceProperties substanceEnum : SubstanceProperties.values()) {
            this.put(substanceEnum.getSubstanceReference(), substanceEnum);
        }
    }
}
