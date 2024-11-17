package substances.solid.movableSolid;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import system.CellMatrix;


public abstract class MovableSolid extends Solid {

    private int x,y;

    public MovableSolid(int x,int y) { this.x = x; this.y = y; }

    public void step(CellMatrix cellMatrix) {
        Substance[] below = new Substance[]{cellMatrix.getCell(x,y+1),
                                            cellMatrix.getCell(x-1,y+1),
                                            cellMatrix.getCell(x+1,y+1)};

        for (Substance belowCell : below) {
            if (belowCell == null) continue;

            if (belowCell instanceof Empty) {
                cellMatrix.setCell(new Empty(x,y));

                this.x = belowCell.x;
                this.y = belowCell.y;
                cellMatrix.setCell(this);

                return;
            }
        }
    }
}
