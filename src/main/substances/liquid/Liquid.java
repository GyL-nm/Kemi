package main.substances.liquid;

import main.substances.Empty;
import main.substances.Substance;
import main.substances.gas.Gas;
import main.substances.solid.movableSolid.MovableSolid;
import main.system.Cell;

import java.util.ArrayList;


public abstract class Liquid extends Substance {
    protected Liquid() { }

    @Override
    public ArrayList<Cell> getMoveCandidates(ArrayList<ArrayList<Cell>> adjacent) {
        ArrayList<Cell> moveCandidates = new ArrayList<>();
        moveCandidates.add(adjacent.get(2).get(1)); // immediate below
        moveCandidates.add(adjacent.get(1).get(0)); // immediate left
        moveCandidates.add(adjacent.get(1).get(2)); // immediate right

        return moveCandidates;
    }

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        ArrayList queue = new ArrayList<>();
        queue.add(new int[]{0,1});
        queue.add(new int[]{-1,0});
        queue.add(new int[]{1,0});

        return queue;
    }

    protected boolean canWander(Cell target) {
        if (target.substance instanceof Empty) { return true; }
        if (    (target.substance instanceof MovableSolid)
                || (target.substance instanceof Gas)
                || (target.substance instanceof Liquid) ) {
            return target.substance.properties.mass < properties.mass;
        }
        return false;
    }

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
