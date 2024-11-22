package substances;

import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;

import java.awt.*;
import java.util.Arrays;

public enum SubstanceProperties {
    EMPTY(0, 0, Empty.class, new Color(255, 255, 255, 255)),

    AIR(0.0089, 1200.0, Air.class, new Color(255, 255, 255, 255)),
    CHLORINE(0.0089, 1200.0, Chlorine.class, new Color(255, 255, 255, 255)),
    HYDROGEN(0.18, 0.08, Hydrogen.class, new Color(255, 255, 255, 255)),
    OXYGEN(0.0263, 1.43, Oxygen.class, new Color(255, 255, 255, 255)),
    VAPOUR(100, 0.76, Vapour.class, new Color(255, 255, 255, 255)),

    WATER(0.6, 1000, Water.class, new Color(255, 255, 255, 255)),
    COPPER_CHLORIDE_LIQUID(0.598, 3390.0, substances.liquid.CopperChloride.class, new Color(255, 255, 255, 255)),
    COPPER_SULPHATE_LIQUID(0.085, 3600.0, substances.liquid.CopperSulphate.class, new Color(255, 255, 255, 255)),
    HYDROCHLORIC_ACID_LIQUID(0.520, 1.64, substances.liquid.HydrochloricAcid.class, new Color(255, 255, 255, 255)),
    SODIUM_CHLORIDE_LIQUID(0.6, 2170.0, substances.liquid.SodiumChloride.class, new Color(255, 255, 255, 255)),
    SODIUM_HYDROXIDE_LIQUID(0.71, 2130.0, substances.liquid.SodiumHydroxide.class, new Color(255, 255, 255, 255)),
    SODIUM_SULPHATE_LIQUID(0.131, 2671.0, substances.liquid.SodiumSulphate.class, new Color(255, 255, 255, 255)),
    SULFURIC_ACID(0.43, 1826.7, SulfuricAcid.class, new Color(255, 255, 255, 255)),

    ICE(2.22, 919, Ice.class, new Color(255, 255, 255, 255)),
    COPPER_CHLORIDE_SOLID(0.598, 3390.0, CopperChloride.class, new Color(255, 255, 255, 255)),
    COPPER_SULPHATE_SOLID(0.085, 3600.0, substances.solid.movableSolid.CopperSulphate.class, new Color(255, 255, 255, 255)),
    HYDROCHLORIC_ACID_SOLID(0.520, 1.64, substances.solid.movableSolid.HydrochloricAcid.class, new Color(255, 255, 255, 255)),
    SODIUM_CHLORIDE_SOLID(0.6, 2170.0, substances.solid.movableSolid.SodiumChloride.class, new Color(255, 255, 255, 255)),
    SODIUM_HYDROXIDE_SOLID(0.71, 2130.0, substances.solid.movableSolid.SodiumHydroxide.class, new Color(255, 255, 255, 255)),
    SODIUM_SULPHATE_SOLID(0.131, 2671.0, substances.solid.movableSolid.SodiumSulphate.class, new Color(255, 255, 255, 255)),
    COPPER(398.0, 8940.0, Copper.class, new Color(255, 255, 255, 255)),
    COPPER_OXIDE(33.0, 6000.0, CopperOxide.class, new Color(255, 255, 255, 255)),
    COPPER_HYDROXIDE_SOLID(33.0, 3360.0, CopperHydroxide.class, new Color(255, 255, 255, 255)),

    BEAKER(1.075, Double.POSITIVE_INFINITY, Beaker.class, new Color(255, 255, 255, 255)),
    BUNSEN(52.0, Double.POSITIVE_INFINITY, Bunsen.class, new Color(255, 255, 255, 255)),
    ELECTRODE(1000.0, Double.POSITIVE_INFINITY, Electrode.class, new Color(255, 255, 255, 255)),
    STIRRER(1.075, Double.POSITIVE_INFINITY, Stirrer.class, new Color(255, 255, 255, 255)),
    THERMOMETER(1.075, Double.POSITIVE_INFINITY, Thermometer.class, new Color(255, 255, 255, 255));

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
