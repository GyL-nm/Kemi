package unit.serializable;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import serializable.SerializableCell;
import substances.liquid.Water;
import system.Cell;

public class SerializableCellTest {
    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(new Water(), 10,20, 25);
    }

    @Test
    void testSerializableCellConstructor() {
        SerializableCell serializableCell = new SerializableCell(cell);

        assertEquals(10, serializableCell.x);
        assertEquals(20, serializableCell.y);
        assertEquals(25, serializableCell.temperature);
        assertEquals("WATER", serializableCell.substanceEnum);
    }

    @Test
    void testDeserialize() {
        SerializableCell serializableCell = new SerializableCell(cell);

        Cell deserializedCell = serializableCell.deserialize();

        assertNotNull(deserializedCell);
        assertEquals(10, deserializedCell.getX());
        assertEquals(20, deserializedCell.getY());
        assertEquals(25, deserializedCell.temperature);
        assertEquals(cell.substance.getClass(), deserializedCell.substance.getClass());
    }
}
