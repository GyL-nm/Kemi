package unit.graphics;
import java.util.Arrays;

import graphics.FontLoader;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;


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
