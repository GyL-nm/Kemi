package main.system;

import main.substances.Empty;
import main.substances.Substance;
import main.substances.SubstanceProperties;

import java.awt.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

public enum CellMatrix {

    INSTANCE(50,50);
    public CellMatrix getInstance() {
        return INSTANCE;
    }

    public static ArrayList<Cell> flattenMatrix(ArrayList<ArrayList<Cell>> matrix) {
        ArrayList<Cell> flatMatrix = new ArrayList<>();
        for (int row = matrix.size()-1; row >= 0; row--) {
            flatMatrix.addAll(matrix.get(row));
        }

        return flatMatrix;
    }

    private ArrayList<ArrayList<Cell>> matrix;

    public BitSet steppedBuffer;

    private int x;
    private int y;

    private CellMatrix(int x, int y) {
        this.setSize(x,y);
    }

    public int[] getSize() { return new int[]{ this.x,this.y }; }

    public void setSize(int x, int y) {
        setMatrixSize(x,y);
        setXY(x, y);

        steppedBuffer = new BitSet(x*y);
        steppedBuffer.set(0, x*y);
    }

    private void setMatrixSize(int x, int y) {
        matrix = new ArrayList<>();
        for (int row = 0; row < y; row++) {
            ArrayList<Cell> newRow = new ArrayList<>();
            for (int col = 0; col < x; col++) {
                newRow.add(new Cell(new Empty(), col, row, 32.0));
            }
            matrix.add(newRow);
        }
    }
    private void setXY(int x, int y) { this.x = x; this.y = y; }

    // Left-right, bottom-top traversal of matrix
    private ArrayList<Cell> getFlatMatrix() {
        return flattenMatrix(matrix);
    }

    public Cell getCell(int x, int y) {
        try {
            return matrix.get(y).get(x);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public int steppedBitIndex(int x, int y) { return x*y+y; }
    public boolean getCellSteppedBit(int x, int y) { return steppedBuffer.get( steppedBitIndex(x, y) ); }
    public void flipCellSteppedBit(int x, int y) { steppedBuffer.flip( steppedBitIndex(x, y) ); }

    public void flipAllSteppedBits() { steppedBuffer.flip(0,steppedBuffer.length()-1); }

//    public void setCell(Cell cell, int x, int y) {
//        matrix.get(y).set(x,cell);
//    }

    public void setCell(Cell cell) {
//        System.out.println("("+ cell.x +","+ cell.y +") = " +cell);
        matrix.get(cell.y).set(cell.x,cell);
    }

    public void swapCells(Cell cellA, Cell cellB) {
        Point coordA = new Point(cellA.x,cellA.y);
        Point coordB = new Point(cellB.x,cellB.y);

        if (isValidPosition(coordA.x, coordA.y) && isValidPosition(coordB.x, coordB.y) ) {
            cellA.setXY(coordB.x, coordB.y); setCell(cellA);

            cellB.setXY(coordA.x, coordA.y); setCell(cellB);
        }
    }

    private boolean isValidPosition(int x, int y) {
        return matrix.get(y).get(x) != null;
    }

    public void fill(Class<? extends Substance> fill) {
        try {
            for (int row = 0; row < y; row++) {
                for (int col = 0; col < x; col++) {
                    matrix.get(row).set(col, Cell.newCellOfType(fill,col,row,23));
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void fillRandom() {
        try {
            Random rand = new Random();
            SubstanceProperties[] values = SubstanceProperties.values();
            for (int row = 0; row < y; row++) {
                for (int col = 0; col < x; col++) {
                    matrix.get(row).set(col, Cell.newCellOfType(values[rand.nextInt(values.length)].getSubstanceReference(),col,row,23));
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void stepAll() {
        steppedBuffer.clear();
        for (Cell cell : this.getFlatMatrix()) {
            cell.step(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (ArrayList<Cell> rows : this.matrix) {
            for (Cell cell : rows) {
                out.append(cell).append(", ");
            }
            out.append("\n");
        }

        return out.toString();
    }
}