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

    private MatrixGraphic matrixGraphic;
    private BufferedImage testImage;
    private final int cellSize = 10;
    private final int imageWidth = 100;
    private final int imageHeight = 100;
    private final int imageX = 5;
    private final int imageY = 10;

    @BeforeEach
    void setUp() {
        testImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        matrixGraphic = new MatrixGraphic(testImage, imageX, imageY, cellSize);
    }

    @Test
    void testGetCellAtMouse_ValidInsideBounds() {
        // Mouse point over cell (2, 3)
        Point mouse = new Point(imageX + 25, imageY + 35);
        Point expected = new Point(2, 3);
        assertEquals(expected, matrixGraphic.getCellAtMouse(mouse));
    }

    @Test
    void testGetCellAtMouseBeyondBounds() {
        Point outside = new Point(imageX + imageWidth + 10, imageY + imageHeight + 10);
        assertNull(matrixGraphic.getCellAtMouse(outside));
    }

    @Test
    void testGetCellAtMouseBeforeBounds() {
        Point outside = new Point(imageX - 10, imageY - 10);
        assertNull(matrixGraphic.getCellAtMouse(outside));
    }
}
