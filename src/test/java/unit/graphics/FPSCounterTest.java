package unit.graphics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import graphics.FPSCounter;

import java.util.concurrent.TimeUnit;

public class FPSCounterTest {
    private FPSCounter fpsCounter;

    @BeforeEach
    public void setUp() {
        fpsCounter = new FPSCounter();
    }

    @Test
    public void testFrameIncrementsFrames() {
        // Simulate the frame() method being called multiple times
        fpsCounter.frame();
        assertEquals(0, fpsCounter.fps());  // FPS shouldn't have been updated yet
        fpsCounter.frame();
        assertEquals(0, fpsCounter.fps());  // Still should be 0 until 1 second has passed
    }

    @Test
    public void testFpsIsUpdatedAfter1Second() throws InterruptedException {
        // Call frame multiple times to simulate frames being counted
        for (int i = 0; i < 60; i++) {  // Simulate 60 frames
            fpsCounter.frame();
        }

        // Sleep to simulate a 1-second passage of time
        TimeUnit.MILLISECONDS.sleep(1000);

        // After 1 second, the fps should be updated to the number of frames in that second
        assertEquals(60, fpsCounter.fps());
    }

    @Test
    public void testFpsResetsAfter1Second() throws InterruptedException {
        // Simulate frames being counted in the first second
        for (int i = 0; i < 100; i++) {
            fpsCounter.frame();
        }

        // Sleep for 1 second, then check the fps value after reset
        TimeUnit.MILLISECONDS.sleep(1000);

        // Fps should be 100 after 1 second
        assertEquals(100, fpsCounter.fps());

        // Simulate frames in the next second
        for (int i = 0; i < 50; i++) {
            fpsCounter.frame();
        }

        // Sleep for 1 second
        TimeUnit.MILLISECONDS.sleep(1000);

        // After another second, the fps should be 50 (as it reset after 100 frames)
        assertEquals(50, fpsCounter.fps());
    }

    @Test
    public void testFpsDoesNotChangeBefore1Second() throws InterruptedException {
        // Simulate a few frames in less than 1 second
        for (int i = 0; i < 10; i++) {
            fpsCounter.frame();
        }

        // Sleep for less than 1 second, so FPS should not be updated yet
        TimeUnit.MILLISECONDS.sleep(500);

        // FPS should still be 0 as it's less than a second
        assertEquals(0, fpsCounter.fps());
    }
}