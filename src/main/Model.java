package main;

import com.formdev.flatlaf.FlatDarculaLaf;
import main.substances.Empty;
import main.substances.gas.Gas;
import main.substances.liquid.Liquid;
import main.substances.solid.Solid;
import main.substances.solid.staticSolid.Anode;
import main.substances.solid.staticSolid.Cathode;
import main.substances.solid.staticSolid.Electrode;
import main.system.Cell;
import main.system.CellMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Model {
    CellMatrix cellMatrix;
    BufferedImage image;
    int cellPixelSize;
    Point hoveredCell = null;

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

        image = new BufferedImage(pixelX, pixelY, BufferedImage.TYPE_INT_ARGB);

        int[] imageData = new int[x*cellPixelSize * y*cellPixelSize];
        for (int row = 0; row < y; row++) {
            for (int col = 0; col < x; col++) {
                Cell cell = cellMatrix.getCell(row, col);
                Color colour = cell.substance.properties.baseColour;
                int argb = (colour.getAlpha() << 24) | colour.getRGB();

                for (int dy = 0; dy < cellPixelSize; dy++) {
                    for (int dx = 0; dx < cellPixelSize; dx++) {
                        int scaledRow = row * cellPixelSize + dy;
                        int scaledCol = col * cellPixelSize + dx;
                        int index = scaledCol * pixelX + scaledRow;
                        imageData[index] = argb;
                    }
                }

                if (cell.substance instanceof Anode) {
                    argb = (Anode.marker.getAlpha() << 24) | Anode.marker.getRGB();

                    for (int dy = 0; dy < (int) (double) cellPixelSize/2.0; dy++) {
                        for (int dx = 0; dx < (int) (double) cellPixelSize/2.0; dx++) {
                            int scaledRow = row * cellPixelSize + dy;
                            int scaledCol = col * cellPixelSize + dx;
                            int index = scaledCol * pixelX + scaledRow;
                            imageData[index] = argb;
                        }
                    }
                }

                if (cell.substance instanceof Cathode) {
                    argb = (Cathode.marker.getAlpha() << 24) | Cathode.marker.getRGB();
                    for (int dy = 0; dy < (int) (double) cellPixelSize/2.0; dy++) {
                        for (int dx = 0; dx < (int) (double) cellPixelSize/2.0; dx++) {
                            int scaledRow = row * cellPixelSize + dy;
                            int scaledCol = col * cellPixelSize + dx;
                            int index = scaledCol * pixelX + scaledRow;
                            imageData[index] = argb;
                        }
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(Arrays.stream(imageData).mapToObj(Color::new).toArray(Color[]::new)));
//        System.out.println(imageData.length);
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

    public static void main(String[] args) {
        Model model = new Model(9);
        model.cellMatrix.setSize(101,101);
        model.cellMatrix.fill(Empty.class, 25.0);
//        model.cellMatrix.fillRandom();

        FlatDarculaLaf.setup();
        View view = new View(model.matrixAsImage(), new Point(27,27),9);

        Controller controller = new Controller(model,view);

        view.startButton.addActionListener(e -> controller.start());
        view.stopButton.addActionListener(e -> controller.stop());

        System.out.println("beyond");

        controller.startAll();
    }
}
