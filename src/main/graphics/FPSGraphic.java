package main.graphics;

import javax.swing.*;
import java.awt.*;

public class FPSGraphic extends JComponent {
    public int fps;
    Color colour;
    Color background;

    public FPSGraphic(JFrame parent, int fps, Color background, Color fontCol) {
        this.fps = fps;
        this.background = background;
        this.colour = fontCol;

        this.setFont(new Font("Arial", Font.BOLD, 12));
        System.out.println(this.getFont().toString());

        try {
            this.setFont(parent.getFont());
            System.out.println(this.getFont());
        } catch (Exception e) {
            this.setFont(new Font("Arial", Font.BOLD, 12));
            System.out.println(this.getFont().toString());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(background);
        g.setColor(colour);
        g.drawString("FPS: " + fps, 5, 15);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 20); // or adjust to your actual text/font size
    }
}
