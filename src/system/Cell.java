package system;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import java.util.ArrayList;

public class Cell {
    int x;
    int y;

    public double temperature; // room temp = 23

    public Substance substance;

    public Cell(Substance substance, int x, int y, double temperature) {
        this.substance = substance;

        this.x = x; this.y = y;
        this.temperature = temperature;
    }

    public void step(CellMatrix cellMatrix) {
        if ( cellMatrix.getCellSteppedBit(x,y) ) return;
        cellMatrix.flipCellSteppedBit(x,y);

        ArrayList<ArrayList<Cell>> adjacent = getAdjacentCells(cellMatrix);

        fall(cellMatrix, substance.getFallCandidates(adjacent));

        exchangeHeat(cellMatrix,adjacent);
    }

    public ArrayList<ArrayList<Cell>> getAdjacentCells(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Cell>> adjacent = new ArrayList<>();

        for (int row = y-1; row <= y+1; row++) {
            ArrayList<Cell> newRow = new ArrayList<>();
            for (int col = x-1; col <= x+1; col++) {
                newRow.add(cellMatrix.getCell(col, row));
            }
            adjacent.add(newRow);
        }

        return adjacent;
    }

    private void fall(CellMatrix cellMatrix, ArrayList<Cell> fallCandidates) {
        for (Cell belowCell : fallCandidates) {
            if (belowCell == null) continue;
            if ( cellMatrix.getCellSteppedBit(belowCell.x,belowCell.y) ) return;

            if (belowCell.substance instanceof Empty // Gravity and density
                    || belowCell.substance.properties.mass < substance.properties.mass) {
                cellMatrix.swapCells(this,belowCell);

                return;
            }

//            if (    !(substance instanceof Solid)
//                    && belowCell.substance.getClass() == substance.getClass() // Fluids becoming less dense when they heat up
//                    && belowCell.temperature > temperature) {
//
//                cellMatrix.swapCells(this,belowCell);
//
//                return;
//            }
        }
    }

    public ArrayList<Cell> getSettleCandidates(ArrayList<ArrayList<Cell>> adjacent) { return null; }
    protected void settle(CellMatrix cellMatrix, ArrayList<Cell> settleCandidates) {}

    public void exchangeHeat(CellMatrix cellMatrix, ArrayList<ArrayList<Cell>> adjacent) {
        for (ArrayList<Cell> row : adjacent) {
            for (Cell cell : row) {
                if (cell == null) continue;

                double heatExchanged = (cell.temperature - temperature) * cell.substance.properties.heatTransferFactor;
                cell.temperature -= heatExchanged;
                temperature += heatExchanged;
            }
        }
    }

    public Cell setXY(int x, int y) { this.x = x; this.y = y; return this; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        String tempString = Double.toString((double) Math.round(temperature * 100) / 100);

        return out.append(substance)
                .append(" ("+ x + "," + y + ") ")
                .append(tempString +"°C").toString();
    }
}
