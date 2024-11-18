import substances.Empty;
import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;
import system.CellMatrix;

public class Main {
    public static void main(String[] args) {
        CellMatrix cellMatrix = CellMatrix.INSTANCE.getInstance();
        cellMatrix.setSize(10,10);

        System.out.println(cellMatrix);

        cellMatrix.fill(Air.class);
        System.out.println(cellMatrix);

        cellMatrix.setCell(new Copper(4,2, 1000));
        System.out.println(cellMatrix);

        for (int i = 0; i<20; i++) {
            cellMatrix.stepAll();
            System.out.println(cellMatrix);
        }
    }
}
