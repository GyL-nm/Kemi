package serializable;

import system.Cell;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.BitSet;

public class SerializableCellMatrix {
    public ArrayList<ArrayList<SerializableCell>> matrix;
    public BitSet steppedBuffer;
    public int x;
    public int y;

    public SerializableCellMatrix(CellMatrix rawCellMatrix) {
        this.matrix = serializeMatrix(rawCellMatrix);

        this.steppedBuffer = rawCellMatrix.getSteppedBuffer();

        this.x = rawCellMatrix.getX();
        this.y = rawCellMatrix.getY();
    }

    ArrayList<ArrayList<SerializableCell>> serializeMatrix(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Cell>> rawMatrix = cellMatrix.getMatrix();

        ArrayList<ArrayList<SerializableCell>> serializedMatrix = new ArrayList<>();
        for (ArrayList<Cell> row : rawMatrix) {
            ArrayList<SerializableCell> newRow = new ArrayList<>();
            for (Cell cell : row) {
                newRow.add(new SerializableCell(cell));
            }
            serializedMatrix.add(newRow);
        }
        return serializedMatrix;
    }

    public CellMatrix deserialize(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Cell>> rawMatrix = new ArrayList<>();
        for (ArrayList<SerializableCell> row : matrix) {
            ArrayList<Cell> newRow = new ArrayList<>();
            for (SerializableCell serializedCell : row) {
                newRow.add(serializedCell.deserialize());
            }
            rawMatrix.add(newRow);
        }

        cellMatrix.deserialize(rawMatrix,x,y,steppedBuffer);
        return cellMatrix;
    }
}
