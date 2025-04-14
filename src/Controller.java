import com.formdev.flatlaf.FlatDarculaLaf;
import graphics.FPSCounter;
import graphics.FPSGraphic;
import substances.Empty;
import substances.Substance;
import system.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

public class Controller {
    Timer simTimer;
    Timer uiTimer;

    int penSize;

    Controller(Model model, View view) {
        simTimer = getSimTimer(model, view);
        uiTimer = getUITimer(model, view);

        penSize = 1;
    }

    public static void main(String[] args) {
        Model model = new Model(9);
        model.cellMatrix.setSize(101,101);
        model.cellMatrix.fill(Empty.class);
        model.cellMatrix.fillRandom();

        FlatDarculaLaf.setup();
        View view = new View(model.matrixAsImage(), new Point(27,27),9);

        Controller controller = new Controller(model,view);

        view.startButton.addActionListener(e -> controller.start());
        view.stopButton.addActionListener(e -> controller.stop());

        view.penSlider.addChangeListener(e -> controller.penSize = view.penSlider.getValue());

        view.matrixPanel.addMouseListener(new MouseAdapter() {
            Point lastPoint = new Point(-1,-1);
            @Override
            public void mousePressed(MouseEvent e) {
                view.matrixPanel.setHoveredCell(new Point(e.getX(), e.getY()));
                    Class<? extends Substance> substance = view.substancePanel.selected;
                if (!view.matrixPanel.hoveredCell.equals(lastPoint)) {
                    for (int row=view.matrixPanel.hoveredCell.x-controller.penSize/2; row<view.matrixPanel.hoveredCell.x+1+controller.penSize/2; row++) {
                        for (int col = view.matrixPanel.hoveredCell.y - controller.penSize / 2; col < view.matrixPanel.hoveredCell.y + 1 + controller.penSize / 2; col++) {
                            try {
                                placeCell(model, substance, new Point(row, col), 32.0);
                            } catch (NoSuchMethodException ex) {
                                throw new RuntimeException(ex);
                            } catch (Exception ex) {
                                continue;
                            }
                        }
                    }


                    view.matrixPanel.setImage(model.matrixAsImage());
                    view.matrixPanel.repaint();
                }
                lastPoint = view.matrixPanel.hoveredCell;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                view.matrixPanel.setImage(model.matrixAsImage());
                view.matrixPanel.repaint();
            }
        });

        System.out.println("beyond");

        controller.startAll();
    }

    public static void placeCell(Model model, Class<? extends Substance> substance, Point cell, double temp) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        model.cellMatrix.setCell(new Cell(substance.getConstructor().newInstance(),cell.x,cell.y,temp) );
    }

    public void startAll() {
        simTimer.start(); uiTimer.start();
    }

    public void start() {
        simTimer.start();
    }

    public void stop() {
        simTimer.stop();
    }

    public void stopAll() {
        simTimer.stop(); uiTimer.stop();
    }

    private static Timer getSimTimer(Model model, View viewFrame) {
        double frameRate = (double) 1000/ (double) 10;

        FPSCounter fpsCounter = new FPSCounter();

        Timer timer = new Timer((int) frameRate, e -> {
            model.cellMatrix.stepAll();
            viewFrame.setMatrixImage(model.matrixAsImage());
            viewFrame.repaint();

            fpsCounter.frame();

            viewFrame.fpsComponent.fps = fpsCounter.fps;
            viewFrame.fpsComponent.repaint();
        });
        return timer;
    }

    private static Timer getUITimer(Model model, View viewFrame) {
        double frameRate = (double) 1000/ (double) 60;

        Timer timer = new Timer((int) frameRate, e -> {
            Point hoveredCell = viewFrame.matrixPanel.hoveredCell;

            if (hoveredCell != null && viewFrame.matrixPanel.contains(hoveredCell)) {
                viewFrame.cellInfoLabel.setVisible(true);
                viewFrame.cellInfoLabel.setText(model.cellInfo(model.cellMatrix.getCell(hoveredCell.x, hoveredCell.y)));
            } else {
                viewFrame.cellInfoLabel.setVisible(false);
            }
        });
        return timer;
    }
}
