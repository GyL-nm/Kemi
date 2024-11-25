package substances.liquid;

import substances.Empty;
import substances.Substance;
import substances.gas.Gas;
import substances.solid.Solid;
import substances.solid.movableSolid.MovableSolid;
import system.Cell;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


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
