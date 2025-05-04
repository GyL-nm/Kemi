package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Splashscreen extends JFrame {
    BufferedImage splash;

    final int WIDTH = 700;
    final int HEIGHT = 400;

    int x; int y;

    public Splashscreen() {
        super("Splashscreen");
        try {
            splash = ImageIO.read(Splashscreen.class.getResourceAsStream("/splashscreen_image_v2.png"));

            setUndecorated(true);
            setResizable(false);
            setAlwaysOnTop(true);
            setType(Window.Type.UTILITY);

            getContentPane().setBackground(new Color(60, 63, 65));
            setPreferredSize(new Dimension(WIDTH, HEIGHT));

            setLayout(new BorderLayout());

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            x = (screenSize.width - WIDTH) / 2;
            y = (screenSize.height - HEIGHT) / 2;
            setLocation(x, y);

            BufferedImage bg1 = new BufferedImage(200, 400, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bg1.createGraphics();

            graphics.setPaint(Color.PINK);
            graphics.fillRect(0, 0, 200, 400);

            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, 150, 400);

            add(new JLabel(new ImageIcon(bg1)), BorderLayout.WEST);

            JPanel textPanel = new JPanel();
            textPanel.setBackground(new Color(60, 63, 65));
            textPanel.setBorder(new EmptyBorder(100, 10, 10, 20));

            JLabel descLabel = new JLabel("<html>A cellular-automata <br/> based chemistry simulator.</html>");
            JLabel creditsLabel = new JLabel(":) Njabu Macfoy 2025");

            descLabel.setFont(new Font("Rounded Mplus 1c", Font.BOLD, 20));
            descLabel.setForeground(Color.WHITE);

            creditsLabel.setFont(new Font("Sawarabi Gothic", Font.PLAIN, 10));
            creditsLabel.setForeground(Color.WHITE);
            creditsLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            textPanel.setLayout(new BorderLayout());
            textPanel.add(descLabel, BorderLayout.NORTH);
            textPanel.add(creditsLabel, BorderLayout.SOUTH);

            add(textPanel, BorderLayout.EAST);

            pack();
            setVisible(true);
        } catch (Exception e) {
            System.out.println("Splashscreen not loaded: " + e.getMessage());
        }
    }

    public int splashX = -100;
    public int splashY = -125;
    public int splashWidth = 600;
    public int splashHeight = 600;
    public void paint(Graphics g) {
        super.paint(g);

        if (splash != null) {
            g.drawImage(splash, splashX, splashY, splashWidth,splashHeight, this);
        }
    }

    private void fadeOutAndDispose() {
        final long startTime = System.currentTimeMillis();
        final long duration = 1500;

        Timer timer = new Timer(16, null);
        timer.addActionListener(e -> {
            long elapsed = System.currentTimeMillis() - startTime;
            float progress = Math.min(1.0f, (float) elapsed / duration);

            float eased = (float) (1 - Math.pow(progress, 2));

            setOpacity(eased);

            if (progress >= 1.0f) {
                timer.stop();
                dispose();
            }
        });
        timer.start();
    }

    public void enableAutoClose() {
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {}

            @Override
            public void windowLostFocus(WindowEvent e) {
                fadeOutAndDispose();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        FontLoader.loadFonts();

        Splashscreen splashscreen = new Splashscreen();
        splashscreen.setVisible(true);
        // splashscreen.enableAutoClose();
    }
}
