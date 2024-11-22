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
                    "[q] quit >>");

            String inputString = input.nextLine();

            if (inputString.equals("q")) break;
            if (inputString.equals("a")) {
                System.out.print("Substance >>");
                String substanceInput = input.nextLine().toUpperCase().replaceAll(" ", "_");

                int x, y;
                double temp;

                while (true) {
                    try {
                        System.out.print("x >>");
                        x = Integer.parseInt(input.nextLine());

                        System.out.print("y >>");
                        y = Integer.parseInt(input.nextLine());

                        System.out.print("temperature >>");
                        temp = Double.parseDouble(input.nextLine());

                        try {
                            cellMatrix.setCell(
                                    new Cell(SubstanceProperties.valueOf(substanceInput)
                                            .getSubstanceReference()
                                            .getConstructor().newInstance(), x,y,temp));

                            break;
                        } catch (InstantiationException | NoSuchMethodException e) {
                            System.out.println("Invalid substance.");
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }

                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("x,y must be int values within range");
                        continue;
                    }


                }
            }

            if (inputString.equals("f")) {
                System.out.print("Substance >>");
                String substanceInput = input.nextLine().toUpperCase().replaceAll(" ", "_");

                while (true) {
                    try {
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
                        System.out.print("Step count >>");
                        stepCount = Integer.parseInt(input.nextLine());

                        System.out.println(cellMatrix);

                        long startTime = System.nanoTime();
                        for (int i = 0; i < stepCount; i++) {
                            cellMatrix.stepAll();
                            System.out.println("Step " + i);
                            System.out.println(cellMatrix);
                        }
                        long endTime = System.nanoTime();

                        long duration = (endTime - startTime) / 1000000;
                        System.out.println(stepCount + " steps in " + duration + "ms");
                        break;

                    } catch (NumberFormatException ignored) {
                        System.out.println("step count must be a positive int value");
                    }


                }
            }
        }
    }
}
