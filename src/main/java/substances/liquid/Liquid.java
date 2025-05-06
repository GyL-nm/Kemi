package substances.liquid;

import substances.Empty;
import substances.Substance;
import substances.gas.Gas;
import substances.solid.movableSolid.MovableSolid;
import system.Cell;

import java.util.ArrayList;


public abstract class Liquid extends Substance {
    protected Liquid() { }

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        ArrayList queue = new ArrayList<>();
        queue.add(new int[]{0,1});
        queue.add(new int[]{-1,0});
        queue.add(new int[]{1,0});

        return queue;
    }
}
