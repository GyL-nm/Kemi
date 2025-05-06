package unit.system;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import substances.Empty;
import substances.liquid.Water;
import system.Cell;
import system.CellMatrix;

import java.awt.*;

public class CellMatrixTest {
    CellMatrix matrix;

    @BeforeEach
    public void setUp() {
        matrix = CellMatrix.INSTANCE;
        matrix.setSize(5, 5);
    }

    @Test
    public void testSetSizeInitializesMatrix() {
        assertEquals(5, matrix.getX(), "Width should be set to 5");
        assertEquals(5, matrix.getY(), "Height should be set to 5");

        Cell cell = matrix.getCell(0, 0);
        assertNotNull(cell, "Top-left cell should not be null");
        assertTrue(cell.substance instanceof Empty, "Top-left cell should initially be Empty");
    }

    @Test
    public void testSetAndGetCell() {
        Cell cell = Cell.newCellOfType(Water.class, 2, 2, 42);
        matrix.setCell(cell);
        Cell retrieved = matrix.getCell(2, 2);
        assertEquals(cell, retrieved, "Set cell should match retrieved cell");
    }

    @Test
    public void testSwapCells() {
        Cell a = Cell.newCellOfType(Water.class, 1, 1, 30);
        Cell b = Cell.newCellOfType(Water.class, 2, 2, 60);
        matrix.setCell(a);
        matrix.setCell(b);

        matrix.swapCells(a, b);

        assertEquals(b, matrix.getCell(1, 1), "Cell B should now be at A's original position");
        assertEquals(a, matrix.getCell(2, 2), "Cell A should now be at B's original position");
    }

    @Test
    public void testOutOfBoundsReturnsNull() {
        assertNull(matrix.getCell(-1, 0), "Negative x should return null");
        assertNull(matrix.getCell(0, -1), "Negative y should return null");
        assertNull(matrix.getCell(100, 100), "Too large index should return null");
    }

    @Test
    public void testStepAllDoesNotCrash() {
        assertDoesNotThrow(() -> matrix.stepAll(), "stepAll should run without throwing exceptions");
    }

    @Test
    public void testSerializationRoundTrip() {
        matrix.setCell(Cell.newCellOfType(Water.class, 1, 1, 88));
        String json = matrix.toJsonFile();
        assertNotNull(json, "Serialization should produce non-null JSON");

        CellMatrix deserialized = CellMatrix.fromJsonFile(matrix, json);
        assertNotNull(deserialized, "Deserialization should succeed");

        Cell cell = deserialized.getCell(1, 1);
        assertNotNull(cell, "Deserialized cell should not be null");
        assertEquals(88, cell.temperature, "Temperature should be preserved after deserialization");
    }
}