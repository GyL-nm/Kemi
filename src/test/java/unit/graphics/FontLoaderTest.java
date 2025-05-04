package unit.graphics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import graphics.FontLoader;
import java.util.Arrays;
import java.awt.*;


public class FontLoaderTest {
    @Test
    public void testLoadFont() {
        FontLoader.loadFonts();
        Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();

        boolean fontLoaded = Arrays.stream(allFonts)
                .anyMatch(font -> font.getFontName().contains("Rounded Mplus 1c"));
        assertTrue(fontLoaded, "MPLUS Rounded not loaded");

        fontLoaded = Arrays.stream(allFonts)
                .anyMatch(font -> font.getFontName().contains("BIZ UDMincho Medium"));
        assertTrue(fontLoaded, "BIZ UDMincho not loaded");

        fontLoaded = Arrays.stream(allFonts)
                .anyMatch(font -> font.getFontName().contains("Sawarabi Gothic"));
        assertTrue(fontLoaded, "Sawarabi Gothic not loaded");

        fontLoaded = Arrays.stream(allFonts)
                .anyMatch(font -> font.getFontName().contains("Kosugi Maru"));
        assertTrue(fontLoaded, "Kosugi Maru not loaded");
    }

    @Test
    public void testLoadFontsDoesNotThrow() {
        assertDoesNotThrow(FontLoader::loadFonts);
    }
}
