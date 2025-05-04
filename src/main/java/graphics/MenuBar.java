package graphics;

import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MenuBar extends JMenuBar {
    public JMenu fileMenu = new JMenu("File");
    public JMenuItem loadItem = new JMenuItem("Load");
    public JMenuItem saveItem = new JMenuItem("Save");

    public JMenu tutorialMenu = new JMenu("Tutorial");
    public HashMap<File,JMenuItem> tutorialFiles;

    public MenuBar() throws URISyntaxException {
        super();

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        tutorialFiles = new LinkedHashMap<>();
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/neutralisation-demo.kemi").toURI()),new JMenuItem("Neutralisation Demo"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/electrolysis-demo.kemi").toURI()),new JMenuItem("Electrolysis Demo"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/synthesis-demo.kemi").toURI()),new JMenuItem("Synthesis Demo"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/beaker.kemi").toURI()),new JMenuItem("Beaker"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/beaker-and-stand[heated].kemi").toURI()),new JMenuItem("Beaker with Stand [Heated]"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/reaction-tank.kemi").toURI()),new JMenuItem("Sealed Reaction Chamber"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/reaction-tank[insulated,heated].kemi").toURI()),new JMenuItem("Sealed Reaction Chamber [Heated]"));
        tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/colour-palette.kemi").toURI()),new JMenuItem("Colour palette"));

        for (JMenuItem item : tutorialFiles.values()) {
            tutorialMenu.add(item);
        }

        add(fileMenu);
        add(tutorialMenu);
    }
}
