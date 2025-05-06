package reactions;

import substances.Substance;

import java.util.HashMap;
import java.util.*;

public class ReactionMap extends HashMap<ReactionMap.ReactantPair,Reaction> {
    public void put(Class<? extends Substance> a, Class<? extends Substance> b, Reaction reaction) {
        super.put(new ReactantPair(a, b), reaction);
    }

    public Reaction get(Class<? extends Substance> a, Class<? extends Substance> b) {
        return super.get(new ReactantPair(a, b));
    }

    public static class ReactantPair {
        private final Class<? extends Substance> reactantA;
        private final Class<? extends Substance> reactantB;

        public ReactantPair(Class<? extends Substance> a, Class<? extends Substance> b) {
            reactantA = a;
            reactantB = b;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ReactantPair)) return false;
            ReactantPair other = (ReactantPair) obj;
            return (Objects.equals(reactantA, other.reactantA) && Objects.equals(reactantB, other.reactantB)) ||
                    (Objects.equals(reactantA, other.reactantB) && Objects.equals(reactantB, other.reactantA));
        }

        @Override
        public int hashCode() {
            return Objects.hash(reactantA) + Objects.hash(reactantB);
        }
    }
}