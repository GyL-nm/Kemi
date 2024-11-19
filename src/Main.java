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

        cellMatrix.fill(Water.class);
        System.out.println(cellMatrix);

        cellMatrix.setCell(new Water(4,2, 120));
        System.out.println(cellMatrix);

        long startTime = System.nanoTime();
        for (int i = 0; i<200; i++) {
            cellMatrix.stepAll();
            System.out.println(cellMatrix);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;
        System.out.println(duration);
    }
}
