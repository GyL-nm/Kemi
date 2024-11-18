package substances.liquid;

import substances.Empty;
import substances.Substance;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Liquid extends Substance {
    protected Liquid(int x, int y) { super(x, y); }

    public Liquid(int x, int y, double temperature) { super(x, y, temperature); }

//    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> adjacent) {
//        ArrayList<Substance> priorityOrderedAdjacent = CellMatrix.flattenMatrix(adjacent);
//        Collections.swap(priorityOrderedAdjacent, 0, 1); // Put immediately below first
//
//        for (Substance cell : priorityOrderedAdjacent) {
//            System.out.println(cell);
//            if (cell == null) continue;
//
//            if (isBelow(cell) && cell.mass < mass) {
//                cellMatrix.swapCells(this, cell);
//
//                return;
//            }
//        }
//    }
}
