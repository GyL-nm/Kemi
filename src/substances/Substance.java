package substances;

import system.CellMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Substance {
    public int x;
    public int y;

    public double mass; // mass of 1m^3 in g
    public double temperature; // room temp = 23.0C

    protected Substance(int x, int y) { this.setXY(x,y); temperature = 23.0; }

    public void step(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Substance>> adjacent = new ArrayList<>();

        for (int row = y-1; row <= y+1; row++) {
            ArrayList<Substance> newRow = new ArrayList<>();
            for (int col = x-1; col <= x+1; col++) {
                newRow.add(cellMatrix.getCell(col, row));
            }
            adjacent.add(newRow);
        }
        fall(cellMatrix, getFallCandidates(adjacent));
//        diffuse(cellMatrix, adjacent);
    }

    public ArrayList<Substance> getFallCandidates(ArrayList<ArrayList<Substance>> adjacent) { return adjacent.get(2); }

    private void fall(CellMatrix cellMatrix, ArrayList<Substance> fallCandidates) {
        System.out.println(fallCandidates);
        for (Substance belowCell : fallCandidates) {
            System.out.println(belowCell);
            if (belowCell == null) continue;

            if (belowCell.getClass() == Empty.class
            || belowCell.mass < mass) {
                cellMatrix.swapCells(this,belowCell);

                return;
            }
        }
    }

//    public abstract void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates);

    protected boolean isBelow(Substance compare) { return compare.y > y; }

    public int getX() { return x; }
    public int getY() { return y; }

    public Substance setXY(int x, int y) { this.x = x; this.y = y; return this; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        return out.append( this.getClass().getSimpleName() )
                .append(" ("+ x + "," + y + ") ")
                .append(temperature +"°C").toString();
    }
}
