package unit.reactions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import reactions.*;
import substances.Substance;
import substances.liquid.Water;

import java.util.*;

public class ReactionMapTest {
    static class DummySubstanceA extends Substance {}
    static class DummySubstanceB extends Substance {}

    @Test
    void testReactantPairSymmetry() {
        var pair1 = new ReactionMap.ReactantPair(DummySubstanceA.class, DummySubstanceB.class);
        var pair2 = new ReactionMap.ReactantPair(DummySubstanceB.class, DummySubstanceA.class);
        assertEquals(pair1, pair2);
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    void testRegistryAccess() {
        ReactionMap map = new ReactionMap();
        Reaction reaction = new Reaction(
                new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                        new Class[]{Water.class, Water.class},
                        3.0,
                        new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 299.99)});

        map.put(DummySubstanceA.class, DummySubstanceB.class, reaction);

        assertEquals(reaction, map.get(DummySubstanceA.class, DummySubstanceB.class));
        assertEquals(reaction, map.get(DummySubstanceB.class, DummySubstanceA.class));
    }

    @Test
    void testKeyPairNotFound() {
        ReactionMap map = new ReactionMap();
        assertNull(map.get(DummySubstanceA.class, DummySubstanceB.class));
    }
}