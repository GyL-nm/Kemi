package main.system;

import com.formdev.flatlaf.FlatDarculaLaf;
import main.graphics.FPSGraphic;
import main.graphics.MatrixGraphic;
import main.graphics.MenuBar;
import main.graphics.Splashscreen;
import main.graphics.SubstancePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class View extends JFrame {
    MenuBar menuBar;

    MatrixGraphic matrixPanel;
    FPSGraphic fpsComponent;
    SubstancePanel substancePanel;

    JPanel controls;
    JButton startButton;
    JButton stopButton;
    JButton stepButton;
    JButton clearButton;

    JSlider timescaleSlider;
    JLabel timescaleLabel;

    JSlider penSlider;
    JLabel penLabel;

    JSlider tempSlider;
    JSpinner tempSpinner;

    JLabel cellInfoLabel;

    View(BufferedImage initialImage, Point imagePosition, int cellPixelSize) {
        FlatDarculaLaf.setup();

        try {
            BufferedImage iconImage = ImageIO.read(Splashscreen.class.getResource("/icon_image.png"));
            setIconImage(iconImage);
        } catch (Exception e) {
            System.out.println("Couldn't set icon: " + e.getMessage());
        }
        setVisible(false);
        Splashscreen splashscreen = new Splashscreen();

        matrixPanel = new MatrixGraphic(initialImage, imagePosition.x,imagePosition.y,9);
        fpsComponent = new FPSGraphic(this, 0, Color.black, Color.red);

        this.setTitle("Kemi [ケミ]");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(initialImage.getWidth()+(imagePosition.x*cellPixelSize), initialImage.getHeight()+(imagePosition.y*cellPixelSize)));
        this.setResizable(false);
//        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()));
        this.setFont(new Font("BIZ UDMincho Medium", Font.BOLD, 16));

        cellInfoLabel = new JLabel("");
        cellInfoLabel.setFont(this.getFont().deriveFont(Font.BOLD));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(matrixPanel, BorderLayout.CENTER);
        leftPanel.add(cellInfoLabel, BorderLayout.SOUTH);

        this.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        controls = new JPanel(new BorderLayout());

        JPanel simControls = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stepButton = new JButton("Step");
        simControls.add(startButton);
        simControls.add(stopButton);

        controls.add(simControls, BorderLayout.NORTH);
        controls.add(stepButton, BorderLayout.CENTER);

        JPanel timescaleSliderPanel = new JPanel();
        timescaleSlider = new JSlider(JSlider.HORIZONTAL, 1, 30, 1);
        timescaleLabel = new JLabel("Timescale 1/"+ timescaleSlider.getValue());
        timescaleSliderPanel.add(timescaleSlider);
        timescaleSliderPanel.add(timescaleLabel);
        controls.add(timescaleSliderPanel, BorderLayout.SOUTH);

        JPanel substanceSectionPanel = new JPanel(new BorderLayout());

        JPanel penSliderPanel = new JPanel();
        penSlider = new JSlider(JSlider.HORIZONTAL, 1, 50, 1);
        penLabel = new JLabel("Pen 1");
        penSliderPanel.add(penSlider);
        penSliderPanel.add(penLabel);
        substanceSectionPanel.add(penSliderPanel, BorderLayout.SOUTH);

        tempSpinner = new JSpinner(new SpinnerNumberModel(25, -150, 1500, 1));
        tempSpinner.setBorder(null);
        for (Component comp : tempSpinner.getComponents()) {
            if (comp instanceof JButton) {
                tempSpinner.remove(comp);
            }
        }
        tempSpinner.setPreferredSize(new Dimension(60,20));

        JLabel celsiusLabel = new JLabel("°C");

        JPanel tempSliderPanel = new JPanel();
        tempSlider = new JSlider(JSlider.VERTICAL, -100, 1500, 25);
        tempSlider.setMinorTickSpacing(5);
        tempSlider.setSnapToTicks(true);

        tempSlider.setMajorTickSpacing(100);
        tempSlider.setPaintTicks(true);

        tempSlider.setUI(new BasicSliderUI(tempSlider) {
            @Override
            public void paintTrack(Graphics g) {
            }
        });

        Hashtable<Integer, JLabel> tempSliderLabels = new Hashtable<>();
        tempSliderLabels.put(-100, new JLabel("-100"));
        tempSliderLabels.put(0, new JLabel("0"));
        tempSliderLabels.put(100, new JLabel("100"));
        tempSliderLabels.put(300, new JLabel("Low Bunsen"));
        tempSliderLabels.put(1500, new JLabel("High Bunsen"));
        tempSlider.setPaintLabels(true);
        tempSlider.setLabelTable(tempSliderLabels);


        tempSliderPanel.add(tempSpinner);
        tempSliderPanel.add(celsiusLabel);
        tempSliderPanel.add(tempSlider);
        substanceSectionPanel.add(tempSliderPanel, BorderLayout.WEST);

        substancePanel = new SubstancePanel(this);

        substanceSectionPanel.add(substancePanel, BorderLayout.CENTER);
        substanceSectionPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 20));

        rightPanel.add(substanceSectionPanel, BorderLayout.SOUTH);
        rightPanel.add(controls, BorderLayout.EAST);
        rightPanel.setBorder(new EmptyBorder(20, 0, 20, 20));


        this.add(rightPanel, BorderLayout.EAST);

        this.add(fpsComponent,BorderLayout.SOUTH);


        this.pack();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            System.out.println("Wait skipped: " +e.getMessage());
        }


        this.setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);

        splashscreen.toFront();
        splashscreen.requestFocus();
        splashscreen.enableAutoClose();
    }

    void setMatrixImage(BufferedImage image) {
        matrixPanel.setImage(image);
        matrixPanel.repaint();
    }

    @Override
    public void setFont ( Font font )
    {
        super.setFont(font);
        for ( Component child : this.getComponents() )
        {
            child.setFont(font);
        }
    }

    public static void main(String[] args) {
        Model model = new Model(9);
        model.image = model.matrixAsImage();
        View view = new View(model.image, new Point(27,27),9);
    }
}
