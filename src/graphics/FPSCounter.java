package graphics;

public class FPSCounter {
    private int frames = 0;
    private long lastTime = System.currentTimeMillis();
    public int fps = 0;

    public void frame() {
        frames++;
        long now = System.currentTimeMillis();
        if (now - lastTime >= 1000) {
            fps = frames;
            frames = 0;
            lastTime = now;
        }
    }
}