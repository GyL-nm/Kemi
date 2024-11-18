package substances;

import system.CellMatrix;

public class Empty extends Substance {
    int x,y;

    public Empty(int x, int y) {
        super(x,y);
        mass = 0;
    }
}
