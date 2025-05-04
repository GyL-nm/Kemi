package unit.graphics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import graphics.MatrixGraphic;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MatrixGraphicTest extends JPanel {
    @Test
    public void testGetCellAtMouse() {
        int width = 100, height = 100;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        MatrixGraphic matrixGraphic = new MatrixGraphic(image, 50, 50, 10);

        Point mousePoint = new Point(60, 60);
        Point cell = matrixGraphic.getCellAtMouse(mousePoint);
        assertNotNull(cell);
        assertEquals(1, cell.x);
        assertEquals(1, cell.y);

        mousePoint = new Point(500, 500);
        cell = matrixGraphic.getCellAtMouse(mousePoint);
        assertNull(cell);
    }
}
