package main;

import com.formdev.flatlaf.FlatDarculaLaf;
import main.graphics.FPSCounter;
import main.graphics.FontLoader;
import main.substances.Empty;
import main.substances.Substance;
import main.system.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.InvocationTargetException;

public class Controller {
    Timer simTimer;
    Timer uiTimer;
    int timescale;

    int penSize;
    float bunsenTemp;

    Controller(Model model, View view) {
        timescale = 1;

        simTimer = getSimTimer(model, view, timescale);
        uiTimer = getUITimer(model, view);

        penSize = 1;
        bunsenTemp = 32f;
    }

    public static void main(String[] args) {
        Model model = new Model(9);
        model.cellMatrix.setSize(101,101);
        model.cellMatrix.fill(Empty.class);
//        model.cellMatrix.fillRandom();

        FlatDarculaLaf.setup();
        FontLoader.loadFonts();
        View view = new View(model.matrixAsImage(), new Point(27,27),9);

        Controller controller = new Controller(model,view);

        view.startButton.addActionListener(e -> controller.start());
        view.stopButton.addActionListener(e -> controller.stop());

        view.timescaleSlider.addChangeListener(e -> {
            controller.timescale = view.timescaleSlider.getValue();
            view.timescaleLabel.setText("Timescale 1/" + controller.timescale);

            controller.setTimescale(model, view);
        });
        view.penSlider.addChangeListener(e -> {
            controller.penSize = view.penSlider.getValue();
            view.penLabel.setText("Pen " + controller.penSize);
        });
        view.tempSlider.addChangeListener(e -> {
            controller.bunsenTemp = view.tempSlider.getValue();
            view.tempLabel.setText(controller.bunsenTemp + "C");
        });

        view.matrixPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point mouse = e.getPoint();

                view.matrixPanel.penSize = controller.penSize;
                view.matrixPanel.setHoveredCell(mouse);
                view.matrixPanel.repaint();
            }
        });

        view.matrixPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                view.matrixPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                view.cellInfoLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view.matrixPanel.setCursor(Cursor.getDefaultCursor());

                view.matrixPanel.hoveredCell = null;
                view.cellInfoLabel.setVisible(false);
            }
        });

        view.matrixPanel.addMouseListener(new MouseAdapter() {
            Point lastPoint = new Point(-1,-1);
            @Override
            public void mousePressed(MouseEvent e) {
                view.matrixPanel.setHoveredCell(new Point(e.getX(), e.getY()));
                Class<? extends Substance> substance = view.substancePanel.selected;

                for (int col = (view.matrixPanel.hoveredCell.x - controller.penSize / 2);
                     col < view.matrixPanel.hoveredCell.x+(double) controller.penSize/2;
                     col++) {
                    for (int row = (view.matrixPanel.hoveredCell.y - controller.penSize / 2);
                         row < view.matrixPanel.hoveredCell.y+ (double) controller.penSize / 2;
                         row++) {
                        try {
                            double temp = view.tempSlider.getValue();
                            placeCell(model, substance, new Point(col, row), temp);
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

            @Override
            public void mouseReleased(MouseEvent e) {
                view.matrixPanel.setImage(model.matrixAsImage());
                view.matrixPanel.repaint();
            }
        });

        System.out.println("beyond");

        controller.uiTimer.start();
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

    public void setTimescale(Model model, View view) {
        stop();
        simTimer = getSimTimer(model, view, timescale);
    }

    private Timer getSimTimer(Model model, View viewFrame, int timescaleReciprocal) {
        double frameRate = (double) (1000*timescale) / (double) 30;

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

    private Timer getUITimer(Model model, View viewFrame) {
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
