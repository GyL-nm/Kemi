package system;

import com.google.gson.Gson;
import serializable.SerializableCellMatrix;
import substances.Empty;
import substances.Substance;
import substances.SubstanceProperties;
import substances.solid.staticSolid.StaticSolid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public enum CellMatrix {
    INSTANCE(50,50);

    public static ArrayList<Cell> flattenMatrix(ArrayList<ArrayList<Cell>> matrix) {
        ArrayList<Cell> flatMatrix = new ArrayList<>();
        for (int row = matrix.size()-1; row >= 0; row--) {
            flatMatrix.addAll(matrix.get(row));
        }

        return flatMatrix;
    }

    public CellMatrix getInstance() {
        return INSTANCE;
    }

    private ArrayList<ArrayList<Cell>> matrix;

    public BitSet steppedBuffer;

    private int x;
    private int y;

    private CellMatrix(int x, int y) {
        this.setSize(x,y);
    }

    public ArrayList<ArrayList<Cell>> getMatrix() { return matrix; }
    public int getY() { return y; }
    public int getX() { return x; }
    public BitSet getSteppedBuffer() { return steppedBuffer; }

    public void deserialize(ArrayList<ArrayList<Cell>> matrix, int x, int y, BitSet steppedBuffer) {
        this.matrix = matrix;
        this.steppedBuffer = steppedBuffer;
        this.x = x;
        this.y = y;
    }

    public int[] getSize() { return new int[]{ this.x,this.y }; }

    public void setSize(int x, int y) {
        setMatrixSize(x,y);
        setXY(x, y);

        steppedBuffer = new BitSet(x*y);
        steppedBuffer.set(0, x*y);
    }

    private void setMatrixSize(int x, int y) {
        try {
            matrix = new ArrayList<>();
            for (int row = 0; row < y; row++) {
                ArrayList<Cell> newRow = new ArrayList<>();
                for (int col = 0; col < x; col++) {
                    newRow.add(new Cell(new Empty(), col, row, 32.0));
                }
                matrix.add(newRow);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    public void setCell(Cell cell) {
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

    public void fill(Class<? extends Substance> fill, double temperature) {
        try {
            for (int row = 0; row < y; row++) {
                for (int col = 0; col < x; col++) {
                    matrix.get(row).set(col, Cell.newCellOfType(fill,col,row,temperature));
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

    public String toJsonFile() {
        SerializableCellMatrix serialized = new SerializableCellMatrix(this);
        try {
            Gson gson = Controller.getGsonBuilder().create();
            return gson.toJson(serialized);
        } catch (Exception e) {
            System.out.println("Couldn't generate json file: " + e.getMessage() + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public static CellMatrix fromJsonFile(CellMatrix cellMatrix, String jsonFile) {
        try {
            Gson gson = Controller.getGsonBuilder().create();
            SerializableCellMatrix serialized = gson.fromJson(jsonFile, SerializableCellMatrix.class);
            return serialized.deserialize(cellMatrix);
        } catch (Exception e) {
            System.out.println("Couldn't load from json file: " + e.getMessage() + Arrays.toString(e.getStackTrace()));
            return null;
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