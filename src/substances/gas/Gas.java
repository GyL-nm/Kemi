package substances.gas;

import substances.Substance;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Gas extends Substance {

    protected Gas(int x, int y) { super(x, y); }

    @Override
    public void step(CellMatrix cellMatrix) {
        System.out.println(this + " steps");
    }

    //    @Override
//    public void diffuse(CellMatrix cellMatrix, ArrayList<ArrayList<Substance>> diffuseCandidates) {
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
