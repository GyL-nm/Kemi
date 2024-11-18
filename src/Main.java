import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;
import system.CellMatrix;

public class Main {
    public static void main(String[] args) {
        CellMatrix cellMatrix = CellMatrix.INSTANCE.getInstance();
        cellMatrix.setSize(5,5);

        System.out.println(cellMatrix);

        cellMatrix.fill(Air.class);
        System.out.println(cellMatrix);

        cellMatrix.setCell(new Copper(2,1));
        cellMatrix.setCell(new Copper(2,2));
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);
    }
}
