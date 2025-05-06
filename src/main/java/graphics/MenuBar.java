package graphics;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MenuBar extends JMenuBar {
    public JMenu fileMenu = new JMenu("File");
    public JMenuItem newItem = new JMenuItem("New");
    public JMenuItem loadItem = new JMenuItem("Load");
    public JMenuItem saveItem = new JMenuItem("Save");

    public JMenu tutorialMenu = new JMenu("Tutorial");
    public HashMap<String,JMenuItem> tutorialFiles;

    public MenuBar() throws IOException {
        super();

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        tutorialFiles = new LinkedHashMap<>();
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/heat-exchange-demo.kemi")),new JMenuItem("Heat Exchange Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/phase-change-demo.kemi")),new JMenuItem("Phase Change Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/neutralisation-demo.kemi")),new JMenuItem("Neutralisation Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/electrolysis-demo.kemi")),new JMenuItem("Electrolysis Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/synthesis-demo.kemi")),new JMenuItem("Synthesis Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/double-displacement-demo.kemi")),new JMenuItem("Double Displacement Demo"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/beaker.kemi")),new JMenuItem("Beaker"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/beaker-and-stand[heated].kemi")),new JMenuItem("Beaker with Stand [Heated]"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/reaction-tank.kemi")),new JMenuItem("Sealed Reaction Chamber"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/reaction-tank[insulated,heated].kemi")),new JMenuItem("Sealed Reaction Chamber [Heated]"));
        tutorialFiles.put(readInputStream(MenuBar.class.getResourceAsStream("/tutorials/colour-palette.kemi")),new JMenuItem("Colour palette"));

        for (JMenuItem item : tutorialFiles.values()) {
            tutorialMenu.add(item);
        }

        add(fileMenu);
        add(tutorialMenu);
    }

    static String readInputStream(InputStream is) throws IOException {
        return new String(is.readAllBytes());
    }
}
