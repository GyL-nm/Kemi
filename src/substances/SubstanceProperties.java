package substances;

import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.Copper;
import substances.solid.movableSolid.CopperOxide;
import substances.solid.staticSolid.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public enum SubstanceProperties {
    EMPTY(0,0, Empty.class),

    AIR(1200.0, 0.0089,Air.class),
    CHLORINE(1200.0, 0.0089, Chlorine.class),
    HYDROGEN(0.08, 0.18,Hydrogen.class),
    OXYGEN(1.43, 0.0263, Oxygen.class),
    VAPOUR(0.76, 100,Vapour.class),

    WATER(1000, 0.6,Water.class),
    COPPER_CHLORIDE(3390.0, 0.598,CopperChloride.class),
    COPPER_SULPHATE_LIQUID(3600.0, 0.085, substances.liquid.CopperSulphate.class),
    HYDROCHLORIC_ACID(1.64, 0.520, HydrochloricAcid.class),
    SODIUM_CHLORIDE(2170.0, 0.6, SodiumChloride.class),
    SODIUM_HYDROXIDE(2130.0, 0.71, SodiumHydroxide.class),
    SODIUM_SULPHATE(2671.0, 0.131, SodiumSulphate.class),
    SULFURIC_ACID(1826.7, 0.43, SulfuricAcid.class),

    COPPER(8940.0, 398.0, Copper.class),
    COPPER_OXIDE(6000.0, 33.0, CopperOxide.class),
    COPPER_SULPHATE_SOLID(3600.0, 0.085, substances.solid.movableSolid.CopperSulphate.class),

    BEAKER(Double.POSITIVE_INFINITY, 1.075, Beaker.class),
    BUNSEN(Double.POSITIVE_INFINITY, 52.0, Bunsen.class),
    ELECTRODE(Double.POSITIVE_INFINITY, 1000.0, Electrode.class),
    STIRRER(Double.POSITIVE_INFINITY, 1.075, Stirrer.class),
    THERMOMETER(Double.POSITIVE_INFINITY, 1.075, Thermometer.class);

    final public double mass;
    final private Class<? extends Substance> substanceReference;

    final public double heatTransferFactor;

    private SubstanceProperties(double mass, double heatTransferFactor, Class<? extends Substance> substanceReference) {
        this.mass = mass;
        this.heatTransferFactor = heatTransferFactor;

        this.substanceReference = substanceReference;
    }

    public double getHeatTransferFactor() {
        double min = Arrays.stream(values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .min().getAsDouble();

        double max = Arrays.stream(values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .max().getAsDouble();

        double normalised = (min + heatTransferFactor)/ (max-min);

        return normalised*20 > 1 ? 1 : normalised*20;
    }

    public Class<? extends Substance> getSubstanceReference() { return substanceReference; }
}
