package system;

import com.formdev.flatlaf.FlatDarculaLaf;
import substances.Empty;
import substances.gas.Gas;
import substances.liquid.Liquid;
import substances.solid.Solid;
import substances.solid.staticSolid.Anode;
import substances.solid.staticSolid.Cathode;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Model {
    CellMatrix cellMatrix;
    BufferedImage image;
    int cellPixelSize;

    Model(int cellPixelSize) {
        cellMatrix = CellMatrix.INSTANCE.getInstance();
        cellMatrix.setSize(100, 100);

        this.cellPixelSize = cellPixelSize;
    }

    BufferedImage matrixAsImage() {
        int[] size = cellMatrix.getSize();
        int x = size[1]; int y = size[0];

        int pixelX = y * cellPixelSize;
        int pixelY = x * cellPixelSize;

        image = new BufferedImage(pixelX, pixelY, BufferedImage.TYPE_INT_RGB);

        int[] imageData = new int[x*cellPixelSize * y*cellPixelSize];
        for (int row = 0; row < y; row++) {
            for (int col = 0; col < x; col++) {
                Cell cell = cellMatrix.getCell(row, col);
                Color colour = cell.substance.properties.baseColour;

                for (int dy = 0; dy < cellPixelSize; dy++) {
                    for (int dx = 0; dx < cellPixelSize; dx++) {
                        int scaledRow = row * cellPixelSize + dy;
                        int scaledCol = col * cellPixelSize + dx;
                        int index = scaledCol * pixelX + scaledRow;
                        imageData[index] = colour.getRGB();
                    }
                }

                if (cell.substance instanceof Anode) {
                    for (int dy = 0; dy < (int) (double) cellPixelSize/2.0; dy++) {
                        for (int dx = 0; dx < (int) (double) cellPixelSize/2.0; dx++) {
                            int scaledRow = row * cellPixelSize + dy;
                            int scaledCol = col * cellPixelSize + dx;
                            int index = scaledCol * pixelX + scaledRow;
                            imageData[index] = Anode.marker.getRGB();
                        }
                    }
                }

                if (cell.substance instanceof Cathode) {
                    for (int dy = 0; dy < (int) (double) cellPixelSize/2.0; dy++) {
                        for (int dx = 0; dx < (int) (double) cellPixelSize/2.0; dx++) {
                            int scaledRow = row * cellPixelSize + dy;
                            int scaledCol = col * cellPixelSize + dx;
                            int index = scaledCol * pixelX + scaledRow;
                            imageData[index] = Cathode.marker.getRGB();
                        }
                    }
                }
            }
        }
        image.getRaster().setDataElements(0, 0, pixelX, pixelY, imageData);
        return image;
    }

    String cellInfo(Cell cell) {
        if (cell == null) { return ""; }
        StringBuilder sb = new StringBuilder();

        String substanceType;
        if (cell.substance instanceof Gas) {
            substanceType = "(Gas)";
        } else if (cell.substance instanceof Liquid) {
            substanceType = "(Liquid)";
        } else if (cell.substance instanceof Solid) {
            substanceType = "(Solid)";
        } else {
            substanceType = "(Other)";
        }
        String substanceName = cell.substance.toString().replaceAll("([a-z])([A-Z])", "$1 $2");
        String substanceCoord = "[" + cell.getX() + "," + cell.getY() + "]";
        String substanceTemp = Math.round(cell.temperature * 100) / 100 +"°C";

        return sb.append(substanceCoord).append(substanceName).append(" ").append(substanceType).append(" ").append(substanceTemp).toString();
    }
}
