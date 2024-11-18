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

        cellMatrix.setCell(new Empty(4,2));
        cellMatrix.setCell(new Empty(4,3));
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);

        cellMatrix.stepAll();
        System.out.println(cellMatrix);
    }
}
