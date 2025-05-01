package main.substances;

import com.google.gson.annotations.SerializedName;
import main.substances.gas.*;
import main.substances.liquid.*;
import main.substances.solid.movableSolid.*;
import main.substances.solid.staticSolid.*;

import java.awt.*;

public enum SubstanceProperties {
    @SerializedName("EMPTY")
    EMPTY(0.0, 0, Empty.class, new Color(0, 0, 0, 255)),

    @SerializedName("AIR")
    AIR(0.0002236, 1200.0, Air.class, new Color(180, 220, 255, 255)),
    @SerializedName("CHLORINE")
    CHLORINE(0.0002236, 1200.0, Chlorine.class, new Color(220, 255, 180, 255)),
    @SerializedName("HYDROGEN")
    HYDROGEN(0.0045226, 0.08, Hydrogen.class, new Color(230, 230, 255, 255)),
    @SerializedName("OXYGEN")
    OXYGEN(0.0006608, 1.43, Oxygen.class, new Color(200, 240, 255, 255)),
    @SerializedName("VAPOUR")
    VAPOUR(0.251256, 0.76, Vapour.class, new Color(180, 255, 255, 255)),

    @SerializedName("WATER")
    WATER(0.015075, 1000, Water.class, new Color(0, 120, 255, 255)),
    @SerializedName("COPPER_CHLORIDE_LIQUID")
    COPPER_CHLORIDE_LIQUID(0.015025, 3390.0, main.substances.liquid.CopperChloride.class, new Color(0, 200, 180, 255)),
    @SerializedName("COPPER_SULPHATE_LIQUID")
    COPPER_SULPHATE_LIQUID(0.0021367, 3600.0, main.substances.liquid.CopperSulphate.class, new Color(0, 150, 255, 255)),
    @SerializedName("HYDROCHLORIC_ACID_LIQUID")
    HYDROCHLORIC_ACID_LIQUID(0.0130653, 1.64, main.substances.liquid.HydrochloricAcid.class, new Color(160, 255, 180, 255)),
    @SerializedName("SODIUM_CHLORIDE_LIQUID")
    SODIUM_CHLORIDE_LIQUID(0.015075, 2170.0, main.substances.liquid.SodiumChloride.class, new Color(180, 220, 255, 255)),
    @SerializedName("SODIUM_HYDROXIDE_LIQUID")
    SODIUM_HYDROXIDE_LIQUID(0.0178342, 2130.0, main.substances.liquid.SodiumHydroxide.class, new Color(160, 255, 240, 255)),
    @SerializedName("SODIUM_SULPHATE_LIQUID")
    SODIUM_SULPHATE_LIQUID(0.0032915, 2671.0, main.substances.liquid.SodiumSulphate.class, new Color(160, 200, 255, 255)),
    @SerializedName("SULFURIC_ACID")
    SULFURIC_ACID(0.010804, 1826.7, SulfuricAcid.class, new Color(240, 255, 180, 255)),

    @SerializedName("ICE")
    ICE(0.0557789, 919, Ice.class, new Color(180, 220, 255, 255)),
    @SerializedName("COPPER_CHLORIDE_SOLID")
    COPPER_CHLORIDE_SOLID(0.015025, 3390.0, main.substances.solid.movableSolid.CopperChloride.class, new Color(0, 170, 160, 255)),
    @SerializedName("COPPER_SULPHATE_SOLID")
    COPPER_SULPHATE_SOLID(0.0021367, 3600.0, main.substances.solid.movableSolid.CopperSulphate.class, new Color(0, 100, 200, 255)),
    @SerializedName("HYDROCHLORIC_ACID_SOLID")
    HYDROCHLORIC_ACID_SOLID(0.0130653, 1.64, main.substances.solid.movableSolid.HydrochloricAcid.class, new Color(130, 230, 160, 255)),
    @SerializedName("SODIUM_CHLORIDE_SOLID")
    SODIUM_CHLORIDE_SOLID(0.015075, 2170.0, main.substances.solid.movableSolid.SodiumChloride.class, new Color(140, 190, 240, 255)),
    @SerializedName("SODIUM_HYDROXIDE_SOLID")
    SODIUM_HYDROXIDE_SOLID(0.0178342, 2130.0, main.substances.solid.movableSolid.SodiumHydroxide.class, new Color(130, 230, 210, 255)),
    @SerializedName("SODIUM_SULPHATE_SOLID")
    SODIUM_SULPHATE_SOLID(0.0032915, 2671.0, main.substances.solid.movableSolid.SodiumSulphate.class, new Color(130, 180, 230, 255)),

    @SerializedName("COPPER_POWDER")
    COPPER_POWDER(1.0, 8940.0, main.substances.solid.movableSolid.Copper.class, new Color(210, 100, 40, 255)),
    @SerializedName("COPPER_OXIDE")
    COPPER_OXIDE(0.82814, 6000.0, CopperOxide.class, new Color(80, 40, 0, 255)),
    @SerializedName("COPPER_HYDROXIDE_SOLID")
    COPPER_HYDROXIDE_SOLID(0.82814, 3360.0, CopperHydroxide.class, new Color(0, 180, 180, 255)),

    @SerializedName("COPPER_SOLID")
    COPPER_SOLID(1.0, 8940.0, main.substances.solid.staticSolid.Copper.class, new Color(200, 90, 30, 255)),
    @SerializedName("BEAKER")
    BEAKER(0.0027015, Double.POSITIVE_INFINITY, Beaker.class, new Color(220, 220, 220, 255)),
    @SerializedName("BUNSEN")
    BUNSEN(1.0, Double.POSITIVE_INFINITY, Bunsen.class, new Color(100, 100, 100, 255)),
    @SerializedName("ELECTRODE")
    ELECTRODE(0.0, Double.POSITIVE_INFINITY, Electrode.class, new Color(60, 60, 60, 255)),
    @SerializedName("STIRRER")
    STIRRER(0.0027015, Double.POSITIVE_INFINITY, Stirrer.class, new Color(180, 180, 180, 255)),
    @SerializedName("THERMOMETER")
    THERMOMETER(0.0027015, Double.POSITIVE_INFINITY, Thermometer.class, new Color(200, 200, 255, 255));


    final public double mass;
    final private double heatTransferFactor;

    final public Color baseColour;

    final transient private Class<? extends Substance> substanceReference;

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
