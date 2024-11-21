package substances.liquid;

import substances.Empty;
import substances.Substance;
import substances.gas.Gas;
import substances.solid.Solid;
import substances.solid.movableSolid.MovableSolid;
import system.CellMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public abstract class Liquid extends Substance {
    protected Liquid(int x, int y) { super(x, y); }

    public Liquid(int x, int y, double temperature) { super(x, y, temperature); }

    @Override
    public ArrayList<Substance> getFallCandidates(ArrayList<ArrayList<Substance>> adjacent) {
        Collections.swap(adjacent.get(2), 0, 1);
        return adjacent.get(2);
    }

    @Override
    public ArrayList<Substance> getSettleCandidates(ArrayList<ArrayList<Substance>> adjacent) {
        return adjacent.get(1);
    }

    @Override
    protected void settle(CellMatrix cellMatrix, ArrayList<Substance> settleCandidates) { wander(cellMatrix, settleCandidates); }

    protected void wander(CellMatrix cellMatrix, ArrayList<Substance> settleCandidates) {
        Random rand = new Random();
        settleCandidates.removeAll(Collections.singleton(null));
        settleCandidates.removeIf(this::canWander);
        Substance newPosition = settleCandidates.get(rand.nextInt(settleCandidates.size()));
        System.out.println(settleCandidates);

        cellMatrix.swapCells(this,newPosition);
    }

    protected boolean canWander(Substance target) {
        if (target instanceof Empty) { return true; }
        if (    (target instanceof MovableSolid)
                || (target instanceof Gas)
                || (target instanceof Liquid) ) {
            return target.properties.mass < properties.mass;
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
