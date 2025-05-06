package system;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.google.gson.*;
import graphics.FontLoader;
import graphics.MenuBar;
import substances.Empty;
import substances.Substance;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.Objects;

public class Controller {
    Timer simTimer;
    Timer uiTimer;
    int timescale;

    int penSize;
    float cellTemp;

    Controller(Model model, View view) {
        timescale = 1;

        simTimer = getSimTimer(model, view);
        uiTimer = getUITimer(model, view);

        penSize = 1;
        cellTemp = 32f;
    }

    public static void run() {
        Model model = new Model(9);
        model.cellMatrix.setSize(101,101);
        model.cellMatrix.fill(Empty.class, 25.0);

        FlatDarculaLaf.setup();
        FontLoader.loadFonts();
        View view = new View(model.matrixAsImage(), new Point(27,27),9);

        Controller controller = new Controller(model,view);

        try {
            MenuBar menuBar = new MenuBar();

            for (File file : menuBar.tutorialFiles.keySet()) {
                JMenuItem menuItem = menuBar.tutorialFiles.get(file);
                menuItem.addActionListener(e -> {
                    try {
                        String json = new String(Files.readAllBytes(file.toPath()));
                        CellMatrix.fromJsonFile(model.cellMatrix, json);
                        view.setMatrixImage(model.matrixAsImage());

                    } catch (Exception ex) {
                        System.out.println("Couldn't load tutorial file: " + ex.getMessage());
                    }
                });
            }

            menuBar.newItem.addActionListener(e -> {
                System.out.println("New matrix");
                model.cellMatrix.fill(Empty.class, 25.0);
                view.setMatrixImage(model.matrixAsImage());
            });

            menuBar.loadItem.addActionListener(e -> {
                System.out.println("Loading from file");
                loadMatrixFromFile(model, view);
                view.setMatrixImage(model.matrixAsImage());
            });
            menuBar.saveItem.addActionListener(e -> {
                System.out.println("Saving to file");
                saveMatrixToFile(model, view);
                view.setMatrixImage(model.matrixAsImage());
            });

            view.add(menuBar, BorderLayout.NORTH);

        } catch (Exception ex) {
            System.out.println("Couldn't load menubar: " + ex);
        }

        view.startButton.addActionListener(e -> controller.start());
        view.stopButton.addActionListener(e -> controller.stop());
        view.stepButton.addActionListener(e -> {
            controller.stop();
            controller.step(model, view);
        });

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
            if (!view.tempSlider.getValueIsAdjusting()) {
                controller.cellTemp = view.tempSlider.getValue();
                view.tempSpinner.setValue(view.tempSlider.getValue());
            }
        });

        view.tempSpinner.addChangeListener(e -> {
            controller.cellTemp = ((Number) view.tempSpinner.getValue()).floatValue();
            view.tempSlider.setValue((int) view.tempSpinner.getValue());
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
                if (view.matrixPanel.hoveredCell == null) return;

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

        controller.uiTimer.start();
    }

    public static void placeCell(Model model, Class<? extends Substance> substance, Point cell, double temp) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        model.cellMatrix.setCell(new Cell(substance.getConstructor().newInstance(),cell.x,cell.y,temp) );
    }

    public static GsonBuilder getGsonBuilder() {
        return new GsonBuilder()
                .setPrettyPrinting();
    }

    public static File saveMatrixToFile(Model model, View view) {
        try {
            CellMatrix cellMatrix = model.cellMatrix;

            JFileChooser saveDialog = new JFileChooser(System.getProperty("user.home"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Kemi save file", "kemi");
            saveDialog.setFileFilter(filter);

            if (saveDialog.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {

                String fileName = saveDialog.getSelectedFile().getAbsolutePath();
                File file = new File(fileName.endsWith(".kemi") ? fileName : fileName + ".kemi");

                FileWriter fw = new FileWriter(file);
                fw.write(Objects.requireNonNull(cellMatrix.toJsonFile()));
                fw.close();

                return file;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Couldn't save to file: " + e);
            throw new RuntimeException(e);
        }
    }

    public static CellMatrix loadMatrixFromFile(Model model, View view) {
        try {
            JFileChooser loadDialog = new JFileChooser(System.getProperty("user.home"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Kemi save file", "kemi");
            loadDialog.setFileFilter(filter);

            if (loadDialog.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                System.out.println(loadDialog.getSelectedFile());
                String json = new String(Files.readAllBytes(loadDialog.getSelectedFile().toPath()));

                CellMatrix.fromJsonFile(model.cellMatrix, json);
                return model.cellMatrix;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Couldn't load to file: " + e);
            throw new RuntimeException(e);
        }
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
        simTimer = getSimTimer(model, view);
    }

    private void step(Model model, View viewFrame) {
        model.cellMatrix.stepAll();
        viewFrame.setMatrixImage(model.matrixAsImage());
        viewFrame.repaint();
    }

    private Timer getSimTimer(Model model, View viewFrame) {
        double frameRate = (double) (1000*timescale) / (double) 1000;

        Timer timer = new Timer((int) frameRate, e -> {
            step(model, viewFrame);
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
