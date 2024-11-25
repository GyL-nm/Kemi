import substances.Empty;
import substances.SubstanceProperties;
import substances.gas.*;
import substances.liquid.*;
import substances.solid.movableSolid.*;
import substances.solid.staticSolid.*;
import system.Cell;
import system.CellMatrix;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CellMatrix cellMatrix = CellMatrix.INSTANCE.getInstance();
        cellMatrix.setSize(10, 10);

        while (true) {
            System.out.println(cellMatrix);
            Scanner input = new Scanner(System.in);
            System.out.print("[s] step\n" +
                    "[a] setCell\n" +
                    "[f] fill\n" +
                    "[q] quit >> ");

            String inputString = input.nextLine();

            if (inputString.equals("q")) break;
            if (inputString.equals("a")) {
                int x, y;
                double temp;

                while (true) {
                    try {
                        System.out.print("Substance >> ");
                        String substanceInput = input.nextLine().toUpperCase().replaceAll(" ", "_");
                        SubstanceProperties.valueOf(substanceInput);

                        try {
                            System.out.print("x >> ");
                            x = Integer.parseInt(input.nextLine());

                            System.out.print("y >> ");
                            y = Integer.parseInt(input.nextLine());

                            System.out.print("temperature >> ");
                            temp = Double.parseDouble(input.nextLine());

                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("x,y must be int values within range");
                            continue;
                        }


                        cellMatrix.setCell(
                                new Cell(SubstanceProperties.valueOf(substanceInput)
                                        .getSubstanceReference()
                                        .getConstructor().newInstance(), x,y,temp));

                        break;

                    } catch (InstantiationException | IllegalArgumentException | NoSuchMethodException e) {
                        System.out.println("Invalid substance.");
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (inputString.equals("f")) {


                while (true) {
                    try {
                        System.out.print("Substance >> ");
                        String substanceInput = input.nextLine().toUpperCase().replaceAll(" ", "_");

                        cellMatrix.fill(SubstanceProperties.valueOf(substanceInput).getSubstanceReference());

                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid substance");
                    }
                }
            }

            if (inputString.equals("s")) {
                int stepCount;

                while (true) {
                    try {
                        System.out.print("Step count >> ");
                        stepCount = Integer.parseInt(input.nextLine());

                        if (stepCount <= 0) throw new NumberFormatException();

                        System.out.println("Step 0");
                        System.out.println(cellMatrix);

                        long startTime = System.nanoTime();
                        for (int i = 0; i < stepCount; i++) {
                            cellMatrix.stepAll();
                            System.out.println("Step " + i+1);
                            System.out.println(cellMatrix);
                        }
                        long endTime = System.nanoTime();

                        long duration = (endTime - startTime) / 1000000;
                        System.out.println(stepCount + " steps in " + duration + "ms");
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("step count must be a positive int value");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid substance.");
                    }


                }
            }
        }
    }
}
