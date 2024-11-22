package system;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import java.util.ArrayList;
import java.util.Random;

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
        ArrayList<ArrayList<Cell>> adjacent = getAdjacentCells(cellMatrix);
        exchangeHeat(adjacent);

        fall(cellMatrix, substance.getFallCandidates(adjacent));
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
        Random jitter = new Random();

        for (Cell belowCell : fallCandidates) {
            if (belowCell == null) continue;
            if ( cellMatrix.getCellSteppedBit(belowCell.x,belowCell.y) ) continue;

            if (belowCell.substance instanceof Empty // Gravity and density
                    || belowCell.substance.properties.mass < substance.properties.mass) {
                if (!(belowCell.x == x && belowCell.y == y-1)) {
                    if (jitter.nextInt(6) == 1) {
                        cellMatrix.swapCells(this, belowCell);

                        cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x,y));
                        cellMatrix.steppedBuffer.set( cellMatrix.steppedBitIndex(belowCell.x, belowCell.y) );
                    }
                } else {
                    if (jitter.nextInt(2) == 1) {
                        cellMatrix.swapCells(this, belowCell);

                        cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x, y));
                        cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(belowCell.x, belowCell.y));
                    }
                }



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

    public void exchangeHeat(ArrayList<ArrayList<Cell>> adjacent) {
        double totalHeatExchanged = 0;
        for (ArrayList<Cell> row : adjacent) {
            for (Cell cell : row) {
                if (cell == null || cell.substance == substance) continue;

                double heatExchanged = (cell.temperature - temperature) * cell.substance.properties.getHeatTransferFactor() * substance.properties.getHeatTransferFactor() ;
                cell.temperature -= heatExchanged;

                totalHeatExchanged += heatExchanged;
            }
        }
        temperature += totalHeatExchanged;
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
