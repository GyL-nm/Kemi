package unit.serializable;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import serializable.SerializableCell;
import serializable.SerializableCellMatrix;
import substances.liquid.Water;
import system.Cell;
import system.CellMatrix;

public class SerializableCellMatrixTest {
    private CellMatrix cellMatrix;
    private SerializableCellMatrix serializableCellMatrix;

    @BeforeEach
    void setUp() {
        cellMatrix = CellMatrix.INSTANCE.getInstance();
        cellMatrix.setSize(3, 3);
        cellMatrix.fill(Water.class, 25);

        serializableCellMatrix = new SerializableCellMatrix(cellMatrix);
    }

    @Test
    void testSerialization() {
        assertNotNull(serializableCellMatrix.matrix);
        assertEquals(3, serializableCellMatrix.matrix.size());
        assertEquals(3, serializableCellMatrix.matrix.get(0).size());

        SerializableCell firstCell = serializableCellMatrix.matrix.get(0).get(0);
        assertEquals(0, firstCell.x);
        assertEquals(0, firstCell.y);
        assertEquals(25.0, firstCell.temperature);
        assertEquals("WATER", firstCell.substanceEnum);
    }

    @Test
    void testDeserialization() {
        serializableCellMatrix.deserialize(cellMatrix);

        assertNotNull(cellMatrix);
        assertEquals(3, cellMatrix.getX());
        assertEquals(3, cellMatrix.getY());

        Cell deserializedCell = cellMatrix.getCell(0, 0);
        assertEquals(25.0, deserializedCell.temperature);
        assertEquals("Water", deserializedCell.substance.getClass().getSimpleName());
    }
}
