package reactions;

import substances.Substance;
import substances.SubstanceProperties;
import substances.SubstanceReferences;

import java.util.Arrays;
import java.util.Collections;

public class ReactionPair {
    final public SubstanceProperties substanceReferenceA;
    final public SubstanceProperties substanceReferenceB;

    final private SubstanceProperties[] facilitators;

    public ReactionPair(SubstanceProperties substanceReferenceA, SubstanceProperties substanceReferenceB,
                        SubstanceProperties[] facilitators) {

        if (substanceReferenceA.compareTo( substanceReferenceB ) >= 0) {
            this.substanceReferenceA = substanceReferenceA;
            this.substanceReferenceB = substanceReferenceB;
        } else {
            this.substanceReferenceA = substanceReferenceB;
            this.substanceReferenceB = substanceReferenceA;
        }

        this.facilitators = facilitators;
    }

    public SubstanceProperties[] getFacilitators() { return facilitators; }
}
