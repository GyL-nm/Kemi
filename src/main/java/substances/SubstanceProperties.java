package substances;

import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;

import java.awt.*;

public enum SubstanceProperties {
    EMPTY(0.0, 0, Empty.class, new Color(0, 0, 0, 255)),

    AIR(0.0002236, 2540.0, Air.class, new Color(180, 220, 255, 255)),
    CHLORINE(0.0002236, 2898.0, Chlorine.class, new Color(220, 255, 180, 255)),
    HYDROGEN(0.0045226, 0.08, Hydrogen.class, new Color(230, 230, 255, 255)),
    OXYGEN(0.0006608, 1.14, Oxygen.class, new Color(161, 228, 253, 255)),
    VAPOUR(0.251256, 0.76, Vapour.class, new Color(223, 255, 255, 255)),

    WATER(0.015075, 1000, Water.class, new Color(0, 120, 255, 255)),
    COPPER_CHLORIDE_LIQUID(0.015025, 3390.0, substances.liquid.CopperChloride.class, new Color(0, 200, 180, 255)),
    COPPER_SULPHATE_LIQUID(0.0021367, 3600.0, substances.liquid.CopperSulphate.class, new Color(0, 150, 255, 255)),
    HYDROCHLORIC_ACID_LIQUID(0.0130653, 1.64, substances.liquid.HydrochloricAcid.class, new Color(160, 255, 180, 255)),
    SODIUM_CHLORIDE_LIQUID(0.015075, 2170.0, substances.liquid.SodiumChloride.class, new Color(112, 173, 237, 255)),
    SODIUM_HYDROXIDE_LIQUID(0.0178342, 2130.0, substances.liquid.SodiumHydroxide.class, new Color(160, 255, 240, 255)),
    SODIUM_SULPHATE_LIQUID(0.0032915, 2671.0, substances.liquid.SodiumSulphate.class, new Color(160, 200, 255, 255)),
    SULFURIC_ACID(0.010804, 1826.7, SulfuricAcid.class, new Color(240, 255, 180, 255)),

    ICE(0.0557789, 919, Ice.class, new Color(180, 220, 255, 255)),
    COPPER_CHLORIDE_SOLID(0.015025, 3390.0, substances.solid.movableSolid.CopperChloride.class, new Color(0, 170, 160, 255)),
    COPPER_SULPHATE_SOLID(0.0021367, 3600.0, substances.solid.movableSolid.CopperSulphate.class, new Color(0, 100, 200, 255)),
    HYDROCHLORIC_ACID_SOLID(0.0130653, 1.64, substances.solid.movableSolid.HydrochloricAcid.class, new Color(130, 230, 160, 255)),
    SODIUM_CHLORIDE_SOLID(0.015075, 2170.0, substances.solid.movableSolid.SodiumChloride.class, new Color(203, 218, 232, 255)),
    SODIUM_HYDROXIDE_SOLID(0.0178342, 2130.0, substances.solid.movableSolid.SodiumHydroxide.class, new Color(130, 230, 210, 255)),
    SODIUM_SULPHATE_SOLID(0.0032915, 2671.0, substances.solid.movableSolid.SodiumSulphate.class, new Color(130, 180, 230, 255)),
    COPPER_POWDER(1.0, 8940.0, substances.solid.movableSolid.Copper.class, new Color(210, 100, 40, 255)),
    COPPER_OXIDE(0.82814, 6000.0, CopperOxide.class, new Color(80, 40, 0, 255)),
    COPPER_HYDROXIDE_SOLID(0.82814, 3360.0, CopperHydroxide.class, new Color(0, 180, 180, 255)),

    COPPER_SOLID(1.0, 8940.0, substances.solid.staticSolid.Copper.class, new Color(200, 90, 30, 255)),
    BEAKER(0.0027015, Double.POSITIVE_INFINITY, Beaker.class, new Color(220, 220, 220, 255)),
    BUNSEN(1.0, Double.POSITIVE_INFINITY, Bunsen.class, new Color(100, 100, 100, 255)),
    ANODE(0.0, Double.POSITIVE_INFINITY, Anode.class, new Color(60, 60, 60, 255)),
    CATHODE(0.0, Double.POSITIVE_INFINITY, Cathode.class, new Color(60, 60, 60, 255)),
    GRAPHITE(0.0, Double.POSITIVE_INFINITY, Graphite.class, new Color(60, 60, 60, 255)),
//    STIRRER(0.0027015, Double.POSITIVE_INFINITY, Stirrer.class, new Color(180, 180, 180, 255)),
//    THERMOMETER(0.0027015, Double.POSITIVE_INFINITY, Thermometer.class, new Color(200, 200, 255, 255))
    ;


    final public double mass;
    final private double heatTransferFactor;

    final public Color baseColour;

    final private Class<? extends Substance> substanceReference;

    private SubstanceProperties(double heatTransferFactor, double mass, Class<? extends Substance> substanceReference, Color baseColour) {
        this.mass = mass;
        this.heatTransferFactor = heatTransferFactor;

        this.baseColour = baseColour;

        this.substanceReference = substanceReference;
    }

    public double getHeatTransferFactor() {
//        double min = Arrays.stream(values())
//                .mapToDouble(prop -> prop.heatTransferFactor)
//                .min().getAsDouble();
//
//        double max = Arrays.stream(values())
//                .mapToDouble(prop -> prop.heatTransferFactor)
//                .max().getAsDouble();
//
//        return (min + heatTransferFactor)/ (max-min);
        return heatTransferFactor;
    }

    public Class<? extends Substance> getSubstanceReference() { return substanceReference; }
}
