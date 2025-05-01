package main.serializable;

import main.system.Cell;
import main.system.CellMatrix;

import java.util.ArrayList;
import java.util.BitSet;

public class SerializableCellMatrix {
    public ArrayList<ArrayList<Cell>> matrix;
    public BitSet steppedBuffer;
    public int x;
    public int y;

    public SerializableCellMatrix(CellMatrix matrix) {
//        this.matrix = SerializableCell.serializeMatrix(rawMatrix);
        this.matrix = matrix.getMatrix();

        this.steppedBuffer = matrix.getSteppedBuffer();
        this.x = matrix.getX();
        this.y = matrix.getY();
    }

    public CellMatrix toCellMatrix(CellMatrix cellMatrix) {
        cellMatrix.setCellMatrix(this);
        return cellMatrix;
    }
}
