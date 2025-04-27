package substances;

import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;

import java.awt.*;
import java.util.Arrays;

public enum SubstanceProperties {
    EMPTY(0, 0, Empty.class, new Color(0, 0, 0, 255)),

    AIR(0.089, 1200.0, Air.class, new Color(180, 220, 255, 255)),
    CHLORINE(0.089, 1200.0, Chlorine.class, new Color(220, 255, 180, 255)),
    HYDROGEN(1.8, 0.08, Hydrogen.class, new Color(230, 230, 255, 255)),
    OXYGEN(0.263, 1.43, Oxygen.class, new Color(200, 240, 255, 255)),
    VAPOUR(100, 0.76, Vapour.class, new Color(180, 255, 255, 255)),

    WATER(6, 1000, Water.class, new Color(0, 120, 255, 255)),
    COPPER_CHLORIDE_LIQUID(5.98, 3390.0, substances.liquid.CopperChloride.class, new Color(0, 200, 180, 255)),
    COPPER_SULPHATE_LIQUID(0.85, 3600.0, substances.liquid.CopperSulphate.class, new Color(0, 150, 255, 255)),
    HYDROCHLORIC_ACID_LIQUID(5.20, 1.64, substances.liquid.HydrochloricAcid.class, new Color(160, 255, 180, 255)),
    SODIUM_CHLORIDE_LIQUID(6, 2170.0, substances.liquid.SodiumChloride.class, new Color(180, 220, 255, 255)),
    SODIUM_HYDROXIDE_LIQUID(7.1, 2130.0, substances.liquid.SodiumHydroxide.class, new Color(160, 255, 240, 255)),
    SODIUM_SULPHATE_LIQUID(1.31, 2671.0, substances.liquid.SodiumSulphate.class, new Color(160, 200, 255, 255)),
    SULFURIC_ACID(4.3, 1826.7, SulfuricAcid.class, new Color(240, 255, 180, 255)),

    ICE(22.2, 919, Ice.class, new Color(180, 220, 255, 255)),
    COPPER_CHLORIDE_SOLID(5.98, 3390.0, substances.solid.movableSolid.CopperChloride.class, new Color(0, 170, 160, 255)),
    COPPER_SULPHATE_SOLID(0.85, 3600.0, substances.solid.movableSolid.CopperSulphate.class, new Color(0, 100, 200, 255)),
    HYDROCHLORIC_ACID_SOLID(5.20, 1.64, substances.solid.movableSolid.HydrochloricAcid.class, new Color(130, 230, 160, 255)),
    SODIUM_CHLORIDE_SOLID(6, 2170.0, substances.solid.movableSolid.SodiumChloride.class, new Color(140, 190, 240, 255)),
    SODIUM_HYDROXIDE_SOLID(7.1, 2130.0, substances.solid.movableSolid.SodiumHydroxide.class, new Color(130, 230, 210, 255)),
    SODIUM_SULPHATE_SOLID(1.31, 2671.0, substances.solid.movableSolid.SodiumSulphate.class, new Color(130, 180, 230, 255)),
    COPPER_POWDER(398.0, 8940.0, substances.solid.movableSolid.Copper.class, new Color(210, 100, 40, 255)),
    COPPER_OXIDE(330, 6000.0, CopperOxide.class, new Color(80, 40, 0, 255)),
    COPPER_HYDROXIDE_SOLID(330, 3360.0, CopperHydroxide.class, new Color(0, 180, 180, 255)),

    COPPER_SOLID(398.0, 8940.0, substances.solid.staticSolid.Copper.class, new Color(200, 90, 30, 255)),
    BEAKER(1.075, Double.POSITIVE_INFINITY, Beaker.class, new Color(220, 220, 220, 255)),
    BUNSEN(0, Double.POSITIVE_INFINITY, Bunsen.class, new Color(100, 100, 100, 255)),
    ELECTRODE(0, Double.POSITIVE_INFINITY, Electrode.class, new Color(60, 60, 60, 255)),
    STIRRER(1.075, Double.POSITIVE_INFINITY, Stirrer.class, new Color(180, 180, 180, 255)),
    THERMOMETER(1.075, Double.POSITIVE_INFINITY, Thermometer.class, new Color(200, 200, 255, 255));

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
        double min = Arrays.stream(values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .min().getAsDouble();

        double max = Arrays.stream(values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .max().getAsDouble();

        return (min + heatTransferFactor)/ (max-min);
    }

    public Class<? extends Substance> getSubstanceReference() { return substanceReference; }
}
