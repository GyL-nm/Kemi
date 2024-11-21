package reactions;

import substances.Substance;
import substances.SubstanceReferences;

public class ReactantPair {
    final private Substance substanceA;
    final private Substance substanceB;

    public ReactantPair(Substance substanceA, Substance substanceB) {
        SubstanceReferences substanceReferences = new SubstanceReferences();

        if (substanceReferences.get(substanceA.getClass())
                .compareTo( substanceReferences.get(substanceB.getClass()) ) >= 0) {
            this.substanceA = substanceA;
            this.substanceB = substanceB;
        } else {
            this.substanceA = substanceB;
            this.substanceB = substanceA;
        }
    }

    public Substance[] get() { return new Substance[] { substanceA, substanceB }; }
    public Substance getA() { return substanceA; }
    public Substance getB() { return substanceB; }
}
