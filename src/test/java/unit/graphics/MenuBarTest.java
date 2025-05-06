package unit.graphics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

import graphics.MenuBar;

public class MenuBarTest extends JMenuBar {
    private MenuBar menuBar;

    @BeforeEach
    void setUp() throws URISyntaxException {
        menuBar = new MenuBar();
    }

    @Test
    void testFileMenuContainsExpectedItems() {
        assertNotNull(menuBar.fileMenu);
        assertEquals("File", menuBar.fileMenu.getText());
        assertTrue(menuBar.fileMenu.isVisible());
        assertTrue(menuBar.fileMenu.getItemCount() >= 3);

        assertEquals(menuBar.newItem, menuBar.fileMenu.getItem(0));
        assertEquals(menuBar.saveItem, menuBar.fileMenu.getItem(1));
        assertEquals(menuBar.loadItem, menuBar.fileMenu.getItem(2));
    }

    @Test
    void testTutorialMenuContainsExpectedItems() {
        assertNotNull(menuBar.tutorialMenu);
        assertEquals("Tutorial", menuBar.tutorialMenu.getText());

        assertEquals(menuBar.tutorialFiles.size(), menuBar.tutorialMenu.getItemCount());

        for (Map.Entry<File, JMenuItem> entry : menuBar.tutorialFiles.entrySet()) {
            File file = entry.getKey();
            JMenuItem item = entry.getValue();

            assertTrue(file.exists(), "Tutorial file should exist: " + file.getPath());
            assertNotNull(item);
            assertTrue(menuBar.tutorialMenu.isMenuComponent(item));
        }
    }
}
