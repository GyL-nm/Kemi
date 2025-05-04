package substances;

import java.util.ArrayList;

public class Empty extends Substance {
    final private SubstanceProperties PROPERTIES = SubstanceProperties.EMPTY;

    @Override
    public ArrayList<int[]> moveCandidateQueue() {
        return new ArrayList<>();
    }

    public Empty() {
        properties = PROPERTIES;
    }
}
