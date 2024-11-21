package substances;

import substances.solid.Solid;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Random;

public abstract class Substance {
    public int x;
    public int y;

    public SubstanceProperties properties;

    public double temperature; // room temp = 23

    private java.util.Objects Objects;

    public Substance(int x, int y) { this.setXY(x,y); temperature = 23.0; }
    public Substance(int x, int y, double temperature) { this.setXY(x,y); this.temperature = temperature; }

    public void step(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Substance>> adjacent = new ArrayList<>();

        for (int row = y-1; row <= y+1; row++) {
            ArrayList<Substance> newRow = new ArrayList<>();
            for (int col = x-1; col <= x+1; col++) {
                newRow.add(cellMatrix.getCell(col, row));
            }
            adjacent.add(newRow);
        }

        settle(cellMatrix, getSettleCandidates(adjacent));
        fall(cellMatrix, getFallCandidates(adjacent));

        transferHeat(adjacent,cellMatrix);
    }

    public ArrayList<Substance> getFallCandidates(ArrayList<ArrayList<Substance>> adjacent) { return adjacent.get(2); }

    private void fall(CellMatrix cellMatrix, ArrayList<Substance> fallCandidates) {
        for (Substance belowCell : fallCandidates) {
            if (belowCell == null) continue;

            if (belowCell.getClass() == Empty.class // Gravity and density
            || belowCell.properties.mass < properties.mass) {
                cellMatrix.swapCells(this,belowCell);

                return;
            }

            if (    !(this instanceof Solid)
                    && belowCell.getClass() == this.getClass() // Fluids becoming less dense when they heat up
                    && belowCell.temperature > temperature) {

                cellMatrix.swapCells(this,belowCell);

                return;
            }
        }
    }

    public ArrayList<Substance> getSettleCandidates(ArrayList<ArrayList<Substance>> adjacent) { return null; }
    protected void settle(CellMatrix cellMatrix, ArrayList<Substance> settleCandidates) {}

    public void transferHeat(ArrayList<ArrayList<Substance>> adjacent, CellMatrix cellMatrix) {
        double averageHeat = CellMatrix.flattenMatrix(adjacent).stream()
                                .filter(java.util.Objects::nonNull)
                                .mapToDouble(substance -> substance.temperature)
                                .average().getAsDouble();

        double averageHeatTransfer = CellMatrix.flattenMatrix(adjacent).stream()
                .filter(java.util.Objects::nonNull)
                .mapToDouble(substance -> substance.properties.getHeatTransferFactor())
                .average().getAsDouble();


        this.temperature += averageHeatTransfer*(averageHeat-this.temperature);
    }

//    public abstract void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates);

    public int getX() { return x; }
    public int getY() { return y; }

    public Substance setXY(int x, int y) { this.x = x; this.y = y; return this; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        String tempString = Double.toString((double) Math.round(temperature * 100) / 100);

        return out.append( this.getClass().getSimpleName() )
                .append(" ("+ x + "," + y + ") ")
                .append(tempString +"°C").toString();
    }
}
