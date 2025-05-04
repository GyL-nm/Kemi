package reactions;

import substances.gas.Chlorine;
import substances.gas.Hydrogen;
import substances.gas.Oxygen;
import substances.liquid.SulfuricAcid;
import substances.liquid.Water;

public class ReactionReference {
    public static final ReactionMap REACTION_MAP = new ReactionMap();

    static {
        // Hydrogen
            // Chlorine
        REACTION_MAP.put(Hydrogen.class, Chlorine.class,
                new Reaction(new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                        new Class[]{substances.liquid.HydrochloricAcid.class, substances.liquid.HydrochloricAcid.class},
                        1.6,
                        new ReactionCondition[]{})
        );
            // Oxygen
        REACTION_MAP.put(Hydrogen.class, Oxygen.class,
                new Reaction(new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                        new Class[]{Water.class, Water.class},
                        3.0,
                        new ReactionCondition[]{new ReactionCondition(ConditionType.GREATER_THAN, 299.99)})
        );

        // Water
            // Copper Chloride
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.CopperChloride.class,
                new Reaction(new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{substances.liquid.CopperChloride.class, substances.liquid.CopperChloride.class},
                        0.85,
                        new ReactionCondition[]{} )
        );
            // Copper Sulphate
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.CopperSulphate.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{substances.liquid.CopperSulphate.class, substances.liquid.CopperSulphate.class},
                        0.70,
                        new ReactionCondition[]{} )
        );
            // Hydrochloric Acid
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.HydrochloricAcid.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{substances.liquid.HydrochloricAcid.class, substances.liquid.HydrochloricAcid.class},
                        0.77,
                        new ReactionCondition[]{} )
        );
            // Sodium Chloride
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.SodiumChloride.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{substances.liquid.SodiumChloride.class, substances.liquid.SodiumChloride.class},
                        -0.01,
                        new ReactionCondition[]{} )
        );
            // Sodium Hydroxide
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{substances.liquid.SodiumHydroxide.class, substances.liquid.SodiumHydroxide.class},
                0.47,
                new ReactionCondition[]{} )
        );
            // Sodium Sulphate
        REACTION_MAP.put(Water.class, substances.solid.movableSolid.SodiumSulphate.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{substances.liquid.SodiumSulphate.class, substances.liquid.SodiumSulphate.class},
                        0.21,
                        new ReactionCondition[]{} )
        );
            // Copper
//        REACTION_MAP.put(Water.class, substances.solid.staticSolid.Copper.class,
//                new Reaction( new ReactionType[]{ReactionType.OXIDATION},
//                        new Class[]{CopperOxide.class, Water.class},
//                        0.71,
//                        new ReactionCondition[]{} )
//        );


        // Copper Chloride
            // Sodium Hydroxide
        REACTION_MAP.put(substances.liquid.CopperChloride.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumChloride.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(substances.solid.movableSolid.CopperChloride.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumChloride.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(substances.liquid.CopperChloride.class, substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumChloride.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
            // Sulfuric Acid
        REACTION_MAP.put(substances.liquid.CopperChloride.class, substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.solid.movableSolid.CopperChloride.class, substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );

        // Copper Sulphate
            // Sodium Hydroxide
        REACTION_MAP.put(substances.liquid.CopperSulphate.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumSulphate.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.solid.movableSolid.CopperSulphate.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumSulphate.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.liquid.CopperSulphate.class, substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.liquid.SodiumSulphate.class, substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
            // Sulfuric Acid
        REACTION_MAP.put(substances.liquid.CopperSulphate.class, substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.solid.movableSolid.CopperSulphate.class, substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );

        // Hydrochloric Acid
            // Sodium Hydroxide
        REACTION_MAP.put(substances.liquid.HydrochloricAcid.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.solid.movableSolid.HydrochloricAcid.class, substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(substances.liquid.HydrochloricAcid.class, substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
            // Sodium Sulphate
        REACTION_MAP.put(substances.liquid.HydrochloricAcid.class, substances.liquid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(substances.solid.movableSolid.HydrochloricAcid.class, substances.liquid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(substances.liquid.HydrochloricAcid.class, substances.solid.movableSolid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
            // Copper Oxide
        REACTION_MAP.put(substances.liquid.HydrochloricAcid.class, substances.solid.movableSolid.CopperOxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{substances.solid.movableSolid.CopperChloride.class, Water.class},
                        1.65,
                        new ReactionCondition[]{} )
        );

        // Sodium Hydroxide
            // Copper
        REACTION_MAP.put(substances.liquid.SodiumHydroxide.class, substances.solid.movableSolid.Copper.class,
                new Reaction( new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                    new Class[]{Water.class, substances.solid.movableSolid.CopperHydroxide.class},
                    0.6,
                    new ReactionCondition[]{} ));

        // Sulfuric Acid
            // Copper Oxide
        REACTION_MAP.put(substances.liquid.SulfuricAcid.class, substances.solid.movableSolid.CopperOxide.class,
                new Reaction( new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{Water.class, substances.solid.movableSolid.CopperSulphate.class},
                        1.8,
                        new ReactionCondition[]{} ));
    }
}
