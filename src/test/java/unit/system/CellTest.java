package unit.system;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import reactions.PhaseChange;
import reactions.Reaction;
import substances.Empty;
import substances.Substance;
import substances.gas.Vapour;
import substances.liquid.Water;
import substances.solid.movableSolid.CopperChloride;
import substances.solid.movableSolid.Ice;
import substances.solid.movableSolid.SodiumChloride;
import substances.solid.staticSolid.Copper;
import system.Cell;
import system.CellMatrix;

import java.awt.*;
import java.util.ArrayList;

public class CellTest {
    CellMatrix matrix;
    Cell cell;
    Cell gas;
    Cell liquid;
    Cell staticSolid;
    Cell movableSolid;
    Cell neighbor;

    @BeforeEach
    public void setUp() {
        matrix = CellMatrix.INSTANCE.getInstance();
        matrix.setSize(3,3);

        cell = new Cell(new Empty(), 1,1, 25);
        neighbor = new Cell(new CopperChloride(), 1, 2, 25);

        gas = new Cell(new Vapour(), 1, 1, 25);
        liquid = new Cell(new Water(), 1, 1, 25);
        staticSolid = new Cell(new Copper(), 1, 1, 25);
        movableSolid = new Cell(new Ice(), 1, 1, 25);
    }

    @Test
    public void testHeatExchangeConservation() {
        cell = new Cell(new Water(), 1, 1, 25);
        neighbor = new Cell(new Copper(), 1, 2, 25);
        double initialTotal = cell.temperature + neighbor.temperature;

        ArrayList<ArrayList<Cell>> adjacent = cell.getAdjacentCells(matrix);
        for (ArrayList<Cell> row : adjacent) {
            for (Cell cell : row) {
                cell.exchangeHeat(cell.getAdjacentCells(matrix));
            }
        }

        double finalTotal = cell.temperature + neighbor.temperature;
        assertEquals(initialTotal, finalTotal, 0.1, "Total heat should be conserved");
    }

    @Test
    public void testHeatExchange() {
        cell = new Cell(new Water(), 0, 0, 25);
        neighbor = new Cell(new Copper(), 1, 0, 35);

        matrix.setSize(2,1);
        matrix.setCell(cell);
        matrix.setCell(neighbor);

        double initialTotal = cell.temperature + neighbor.temperature;

        ArrayList<ArrayList<Cell>> adjacent = cell.getAdjacentCells(matrix);
        cell.exchangeHeat(adjacent);

        double conductance = (cell.substance.properties.getHeatTransferFactor()+neighbor.substance.properties.getHeatTransferFactor())/2.0;
        double heatExchanged = (cell.temperature - neighbor.temperature) * conductance;

        double minTemp = Math.min(cell.temperature,cell.temperature);
        double maxTemp = Math.max(cell.temperature,cell.temperature);

        double temperature = Math.max(minTemp, Math.min(maxTemp, 25 - heatExchanged));

        assertEquals(temperature, matrix.getCell(0,0).temperature, 0.1, "Total heat should be conserved");
    }

    @Test
    public void testEmptyHeatExchange() {
        double initialTotal = cell.temperature + neighbor.temperature;

        ArrayList<ArrayList<Cell>> adjacent = cell.getAdjacentCells(matrix);
        cell.exchangeHeat(adjacent);

        double finalTotal = cell.temperature + neighbor.temperature;
        assertEquals(initialTotal, finalTotal, 0.1, "Total heat should be conserved");
    }

    @Test
    public void testRadiatorExchange() {
        double initialTotal = cell.temperature + neighbor.temperature;

        ArrayList<ArrayList<Cell>> adjacent = cell.getAdjacentCells(matrix);
        cell.exchangeHeat(adjacent);

        double finalTotal = cell.temperature + neighbor.temperature;
        assertEquals(initialTotal, finalTotal, 0.1, "Total heat should be conserved");
    }

    @Test
    public void testPhaseChangeOccurs() {
        cell = new Cell(new Water(), 1, 1, 200); // Triggers condition

        matrix.setCell(cell);
        Reaction result = cell.phaseChange(matrix, cell.getAdjacentCells(matrix));
        assertNotNull(result);
        assertEquals(Vapour.class, matrix.getCell(1,1).substance.properties.getSubstanceReference());
    }

    @Test
    public void testReact() {
        cell = new Cell(new Water(), 1, 1, 25);
        neighbor = new Cell(new SodiumChloride(), 1, 2, 25);

        matrix.setCell(cell);
        matrix.setCell(neighbor);

        Reaction reaction = cell.react(matrix, cell.getOrderedAdjacentCells(matrix));
        assertNotNull(reaction);
        assertEquals(substances.liquid.SodiumChloride.class, matrix.getCell(1,1).substance.properties.getSubstanceReference());
    }
}
