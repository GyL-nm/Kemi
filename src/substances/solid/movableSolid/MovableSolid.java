package substances.solid.movableSolid;

import substances.Empty;
import substances.Substance;
import substances.solid.Solid;

import system.CellMatrix;


public abstract class MovableSolid extends Solid {
    public MovableSolid(int x,int y) { super(x,y); }

    public void step(CellMatrix cellMatrix) {
        Substance[] below = new Substance[]{cellMatrix.getCell(x,y+1),
                                            cellMatrix.getCell(x-1,y+1),
                                            cellMatrix.getCell(x+1,y+1)};

        for (Substance belowCell : below) {
            System.out.println(belowCell);
            if (belowCell == null) continue;

            if (belowCell.getClass() == Empty.class) {
                cellMatrix.swapCells(this,belowCell);

                return;
            }
        }
    }
}
