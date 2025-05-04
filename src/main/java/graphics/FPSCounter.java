package graphics;

public class FPSCounter {
    private int frames = 0;
    private long start;
    private long last;
    private int MAX = 60;

    public FPSCounter() {
        start = System.nanoTime();
    }

    public void start() { start = System.nanoTime(); }

    public void frame() { frames++; }

    public int fps() {
        long now = System.nanoTime();
        long elapsedTime = now - start;

        // Update every second (or SAMPLE_INTERVAL)
        if (elapsedTime - last >= 1000000000L) {
            last = elapsedTime;
            int fps = (int) (frames / (elapsedTime / 1000000000L));
            frames = 0;
            start = now;
            return fps;
        }
        return 0; // No FPS calculated yet
    }
}