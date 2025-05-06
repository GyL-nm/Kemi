package substances.gas;

import substances.Substance;
import system.Cell;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Gas extends Substance {
    public Gas() {}

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
}
