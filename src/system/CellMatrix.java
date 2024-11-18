package system;

import substances.Empty;
import substances.Substance;

import java.awt.*;
import java.util.ArrayList;

public enum CellMatrix {

    INSTANCE(50,50);

    private ArrayList<ArrayList<Substance>> matrix;
    private int x;
    private int y;

    private CellMatrix(int x, int y) {
        this.setSize(x,y);
    }

    public CellMatrix getInstance() {
        return INSTANCE;
    }

    public ArrayList<ArrayList<Substance>> getMatrix() { return matrix; }

    public int[] getSize() { return new int[]{ this.x,this.y }; }

    public void setSize(int x, int y) {
        setMatrixSize(x,y);
        setXY(x, y);
    }

    private void setMatrixSize(int x, int y) {
        matrix = new ArrayList<>();
        for (int row = 0; row < y; row++) {
            ArrayList<Substance> newRow = new ArrayList<>();
            for (int col = 0; col < x; col++) {
                newRow.add(new Empty(col,row));
            }
            matrix.add(newRow);
        }
    }
    private void setXY(int x, int y) { this.x = x; this.y = y; }

    public static ArrayList<Substance> flattenMatrix(ArrayList<ArrayList<Substance>> matrix) {
        ArrayList<Substance> flatMatrix = new ArrayList<>();
        for (int row = matrix.size()-1; row >= 0; row--) {
            flatMatrix.addAll(matrix.get(row));
        }

        return flatMatrix;
    }

    // Left-right, bottom-top traversal of matrix
    private ArrayList<Substance> getFlatMatrix() {
        return flattenMatrix(matrix);
    }

    public Substance getCell(int x, int y) {
        try {
            return matrix.get(y).get(x);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

//    public void setCell(Substance substance, int x, int y) {
//        matrix.get(y).set(x,substance);
//    }

    public void setCell(Substance substance) {
        System.out.println("("+ substance.x +","+ substance.y +") = " +substance);
        matrix.get(substance.y).set(substance.x,substance);
    }

    public void swapCells(Substance substanceA, Substance substanceB) {
        Point coordA = new Point(substanceA.getX(),substanceA.getY());
        Point coordB = new Point(substanceB.getX(),substanceB.getY());

        if (isValidPosition(coordA.x, coordA.y) && isValidPosition(coordB.x, coordB.y) ) {
            substanceA.setXY(coordB.x, coordB.y); setCell(substanceA);

            substanceB.setXY(coordA.x, coordA.y); setCell(substanceB);
        }
    }

    private boolean isValidPosition(int x, int y) {
        try {
            this.matrix.get(y).get(x); return true;
        } catch (IndexOutOfBoundsException e) { return false; }
    }

    public void fill(Class<? extends Substance> fill) {
        try {
            for (int row = 0; row < y; row++) {
                for (int col = 0; col < x; col++) {
                    matrix.get(row).set(col, fill.getConstructor(int.class, int.class).newInstance(col, row) );
                }
            }
        } catch (Exception ignored) {;}
    }

    public void stepAll() {
        for (Substance substance : this.getFlatMatrix()) { System.out.println(substance.x +","+ substance.y); substance.step(this); }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (ArrayList<Substance> rows : this.matrix) {
            for (Substance substance : rows) {
                out.append(substance).append(", ");
            }
            out.append("\n");
        }

        return out.toString();
    }
}