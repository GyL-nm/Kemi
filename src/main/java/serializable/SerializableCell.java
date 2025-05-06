package serializable;

import substances.SubstanceProperties;
import system.Cell;

public class SerializableCell {
    public final int x;
    public final int y;
    public final double temperature;
    public final String substanceEnum;

    public SerializableCell(Cell rawCell) {
        this.x = rawCell.getX();
        this.y = rawCell.getY();
        this.temperature = rawCell.temperature;

        this.substanceEnum = rawCell.substance.properties.name();
    }

    public Cell deserialize() {
        SubstanceProperties substanceProperties = SubstanceProperties.valueOf(substanceEnum);
        return Cell.newCellOfType(
                substanceProperties.getSubstanceReference(),
                x,y,
                temperature);
    }
}
