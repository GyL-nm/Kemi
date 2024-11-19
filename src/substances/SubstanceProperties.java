package substances;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public enum SubstanceProperties {
    EMPTY(0,0),

    AIR(1200.0, 0.0089),
    CHLORINE(1200.0, 0.0089),
    HYDROGEN(0.08, 0.18),
    OXYGEN(1.43, 0.0263),
    VAPOUR(0.76, 100),

    WATER(1000, 0.6),
    COPPER_CHLORIDE(3390.0, 0.598),
    COPPER_SULPHATE_LIQUID(3600.0, 0.085),
    HYDROCHLORIC_ACID(1.64, 0.520),
    SODIUM_CHLORIDE(2170.0, 0.6),
    SODIUM_HYDROXIDE(2130.0, 0.71),
    SODIUM_SULPHATE(2671.0, 0.131),
    SULFURIC_ACID(1826.7, 0.43),

    COPPER(8940.0, 398.0),
    COPPER_OXIDE(6000.0, 33.0),
    COPPER_SULPHATE_SOLID(3600.0, 0.085),

    BEAKER(Double.POSITIVE_INFINITY, 1.075),
    BUNSEN(Double.POSITIVE_INFINITY, 52.0),
    ELECTRODE(Double.POSITIVE_INFINITY, 1000.0),
    STIRRER(Double.POSITIVE_INFINITY, 1.075),
    THERMOMETER(Double.POSITIVE_INFINITY, 1.075);

    final public double mass;
    final private double heatTransferFactor;

    private SubstanceProperties(double mass, double heatTransferFactor) {
        this.mass = mass;
        this.heatTransferFactor = heatTransferFactor;
    }

    public double getHeatTransferFactor() {
        double max = Arrays.stream(SubstanceProperties.values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .max().getAsDouble();

        double min = Arrays.stream(SubstanceProperties.values())
                .mapToDouble(prop -> prop.heatTransferFactor)
                .min().getAsDouble();

        double normalised = (min+heatTransferFactor)/(max-min);

        return normalised*20 > 1 ? 1 : normalised*20;
    }
}
