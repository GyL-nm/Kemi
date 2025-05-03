package main.reactions;

import main.substances.gas.Chlorine;
import main.substances.gas.Hydrogen;
import main.substances.gas.Oxygen;
import main.substances.liquid.SulfuricAcid;
import main.substances.liquid.Water;

public class ReactionReference {
    public static final ReactionMap REACTION_MAP = new ReactionMap();

    static {
        // Hydrogen
            // Chlorine
        REACTION_MAP.put(Hydrogen.class, Chlorine.class,
                new Reaction(new ReactionType[]{ReactionType.REDOX,ReactionType.SYNTHESIS},
                        new Class[]{main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.HydrochloricAcid.class},
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
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.CopperChloride.class,
                new Reaction(new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{main.substances.liquid.CopperChloride.class, main.substances.liquid.CopperChloride.class},
                        0.85,
                        new ReactionCondition[]{} )
        );
            // Copper Sulphate
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.CopperSulphate.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{main.substances.liquid.CopperSulphate.class, main.substances.liquid.CopperSulphate.class},
                        0.70,
                        new ReactionCondition[]{} )
        );
            // Hydrochloric Acid
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.HydrochloricAcid.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.HydrochloricAcid.class},
                        0.77,
                        new ReactionCondition[]{} )
        );
            // Sodium Chloride
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.SodiumChloride.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.liquid.SodiumChloride.class},
                        -0.01,
                        new ReactionCondition[]{} )
        );
            // Sodium Hydroxide
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                new Class[]{main.substances.liquid.SodiumHydroxide.class, main.substances.liquid.SodiumHydroxide.class},
                0.47,
                new ReactionCondition[]{} )
        );
            // Sodium Sulphate
        REACTION_MAP.put(Water.class, main.substances.solid.movableSolid.SodiumSulphate.class,
                new Reaction( new ReactionType[]{ReactionType.DISSOLUTION},
                        new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.liquid.SodiumSulphate.class},
                        0.21,
                        new ReactionCondition[]{} )
        );


        // Copper Chloride
            // Sodium Hydroxide
        REACTION_MAP.put(main.substances.liquid.CopperChloride.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.CopperChloride.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(main.substances.liquid.CopperChloride.class, main.substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumChloride.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{})
        );
            // Sulfuric Acid
        REACTION_MAP.put(main.substances.liquid.CopperChloride.class, main.substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.CopperChloride.class, main.substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );

        // Copper Sulphate
            // Sodium Hydroxide
        REACTION_MAP.put(main.substances.liquid.CopperSulphate.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.CopperSulphate.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.liquid.CopperSulphate.class, main.substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.liquid.SodiumSulphate.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                        0.6,
                        new ReactionCondition[]{} )
        );
            // Sulfuric Acid
        REACTION_MAP.put(main.substances.liquid.CopperSulphate.class, main.substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.CopperSulphate.class, main.substances.liquid.SulfuricAcid.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                        0.22,
                        new ReactionCondition[]{} )
        );

        // Hydrochloric Acid
            // Sodium Hydroxide
        REACTION_MAP.put(main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.HydrochloricAcid.class, main.substances.liquid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
        REACTION_MAP.put(main.substances.liquid.HydrochloricAcid.class, main.substances.solid.movableSolid.SodiumHydroxide.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, Water.class},
                        0.61,
                        new ReactionCondition[]{} )
        );
            // Sodium Sulphate
        REACTION_MAP.put(main.substances.liquid.HydrochloricAcid.class, main.substances.liquid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(main.substances.solid.movableSolid.HydrochloricAcid.class, main.substances.liquid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
        REACTION_MAP.put(main.substances.liquid.HydrochloricAcid.class, main.substances.solid.movableSolid.SodiumSulphate.class,
                new Reaction(new ReactionType[]{ReactionType.NEUTRALISATION},
                        new Class[]{main.substances.solid.movableSolid.SodiumChloride.class, SulfuricAcid.class},
                        0.6,
                        new ReactionCondition[]{})
        );
            // Copper Oxide
        REACTION_MAP.put(main.substances.liquid.HydrochloricAcid.class, main.substances.solid.movableSolid.CopperOxide.class,
                new Reaction(new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{main.substances.solid.movableSolid.CopperChloride.class, Water.class},
                        1.65,
                        new ReactionCondition[]{} )
        );

        // Sodium Hydroxide
            // Copper
        REACTION_MAP.put(main.substances.liquid.SodiumHydroxide.class, main.substances.solid.movableSolid.Copper.class,
                new Reaction( new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                    new Class[]{Water.class, main.substances.solid.movableSolid.CopperHydroxide.class},
                    0.6,
                    new ReactionCondition[]{} ));

        // Sulfuric Acid
            // Copper Oxide
        REACTION_MAP.put(main.substances.liquid.SulfuricAcid.class, main.substances.solid.movableSolid.CopperOxide.class,
                new Reaction( new ReactionType[]{ReactionType.DOUBLE_DISPLACEMENT},
                        new Class[]{Water.class, main.substances.solid.movableSolid.CopperSulphate.class},
                        1.8,
                        new ReactionCondition[]{} ));
    }
}
