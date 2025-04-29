package main.graphics;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    JMenu fileMenu = new JMenu("File");
    JMenuItem loadItem = new JMenuItem("Load");
    JMenuItem saveItem = new JMenuItem("Save");

    JMenu editMenu = new JMenu("Edit");
    JMenuItem ambientSubstanceItem = new JMenuItem("Set Ambient Substance");

    JMenu tutorialMenu = new JMenu("Tutorial");
    JMenuItem[] tutorialItems = new JMenuItem[0];

    public MenuBar() {
        super();
    }
}
