package substances.gas;

import substances.Substance;
import system.Cell;
import system.CellMatrix;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Gas extends Substance {
    public Gas() {

    }

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        ArrayList queue = new ArrayList<>();

        queue.add(new int[]{-1,0});
        queue.add(new int[]{0,0});
        queue.add(new int[]{1,0});

        queue.add(new int[]{-1,1});
        queue.add(new int[]{0,1});
        queue.add(new int[]{1,1});

        queue.add(new int[]{0,-1});
        queue.add(new int[]{-1,-1});
        queue.add(new int[]{1,-1});

        return queue;
    }

    @Override
    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        Collections.swap(adjacent.get(2), 0, 1);
        return adjacent.get(2);
    }

//    @Override
//    public ArrayList<Substance> getMoveCandidates(ArrayList<ArrayList<Substance>> adjacent) {
//        ArrayList<Substance> candidates = new ArrayList<>();
//        candidates.add(adjacent.get(2).get(1));
//        return candidates;
//    }

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
