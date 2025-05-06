package unit.graphics;

import graphics.Splashscreen;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SplashscreenTest extends JFrame {
    @Test
    void splashscreen_disposesAfter1500ms() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);

        Splashscreen splashscreen = new Splashscreen();
        splashscreen.setOpacity(1f);
        splashscreen.enableAutoClose();

        splashscreen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                latch.countDown();
            }
        });

        SwingUtilities.invokeLater(() -> {
            JFrame dummy = new JFrame();
            dummy.setSize(100, 100);
            dummy.setLocation(splashscreen.getX() + 800, splashscreen.getY() + 800);
            dummy.setVisible(true);
            dummy.requestFocus();
        });

        boolean disposed = latch.await(2, TimeUnit.SECONDS);

        assertTrue(disposed, "Splashscreen should dispose itself within ~1.5 seconds after losing focus.");
    }
}
