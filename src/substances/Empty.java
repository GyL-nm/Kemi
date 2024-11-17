package substances;

import system.CellMatrix;

public class Empty extends Substance {
    int x,y;

    public Empty(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void step(CellMatrix cellMatrix) {

    }
}
