import com.formdev.flatlaf.FlatDarculaLaf;
import graphics.FPSGraphic;
import graphics.MatrixGraphic;
import graphics.Splashscreen;
import graphics.SubstancePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class View extends JFrame {
    MatrixGraphic matrixPanel;
    FPSGraphic fpsComponent;
    SubstancePanel substancePanel;

    JPanel controls;
    JButton startButton;
    JButton stopButton;

    JSlider penSlider;

    JLabel cellInfoLabel;

    View(BufferedImage initialImage, Point imagePosition, int cellPixelSize) {
        FlatDarculaLaf.setup();

        Splashscreen splashscreen = new Splashscreen();

        matrixPanel = new MatrixGraphic(initialImage, imagePosition.x,imagePosition.y,9);
        fpsComponent = new FPSGraphic(this, 0, Color.black, Color.red);

        this.setTitle("Kemi [ケミ]");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(initialImage.getWidth()+(imagePosition.x*cellPixelSize), initialImage.getHeight()+(imagePosition.y*cellPixelSize)));
        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()));
        this.setFont(new Font("BIZ UDMincho Medium", Font.BOLD, 16));

        cellInfoLabel = new JLabel("");
        cellInfoLabel.setFont(this.getFont().deriveFont(Font.BOLD));

        matrixPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point mouse = e.getPoint();

                matrixPanel.setHoveredCell(mouse);
                matrixPanel.repaint();
            }
        });

        matrixPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                matrixPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                cellInfoLabel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                matrixPanel.setCursor(Cursor.getDefaultCursor());

                matrixPanel.hoveredCell = null;
                cellInfoLabel.setVisible(false);
            }
        });


        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(matrixPanel, BorderLayout.CENTER);
        leftPanel.add(cellInfoLabel, BorderLayout.SOUTH);

        this.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        controls = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        controls.add(startButton);
        controls.add(stopButton);

        penSlider = new JSlider(JSlider.HORIZONTAL, 1, 50, 1);
        JLabel penLabel = new JLabel("Pen");
        controls.add(penSlider);
        controls.add(penLabel);

        substancePanel = new SubstancePanel(this);

        rightPanel.add(substancePanel, BorderLayout.SOUTH);
        rightPanel.add(controls, BorderLayout.EAST);



        this.add(rightPanel, BorderLayout.EAST);

        this.add(fpsComponent,BorderLayout.SOUTH);

        this.pack();

        this.setFocusableWindowState(false);
        this.setVisible(true);
        this.setFocusableWindowState(true);

        this.setFont(new Font("BIZ UDMincho Medium", Font.BOLD, 16));
        splashscreen.enableAutoClose();
    }



    void setMatrixImage(BufferedImage image) {
        matrixPanel.setImage(image);
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
