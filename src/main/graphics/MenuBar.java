package main.graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

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

        tutorialFiles = new HashMap<>();
        // tutorialFiles.put(new File(MenuBar.class.getResource("/tutorials/tutorial1.kemi").toURI()),new JMenuItem("Tutorial 1"));

        for (JMenuItem item : tutorialFiles.values()) {
            tutorialMenu.add(item);
        }

        add(fileMenu);
        add(tutorialMenu);
    }
}
