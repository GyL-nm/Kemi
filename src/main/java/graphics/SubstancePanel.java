package graphics;

import substances.Substance;
import substances.SubstanceProperties;
import substances.gas.Gas;
import substances.liquid.Liquid;
import substances.solid.movableSolid.MovableSolid;
import substances.solid.staticSolid.StaticSolid;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SubstancePanel extends JPanel {
    public Class<? extends Substance> selected;
    JButton[] substanceButtons;
    Class<? extends Substance>[] substances = Arrays.stream(SubstanceProperties.values()).map(SubstanceProperties::getSubstanceReference).toArray(Class[]::new);

    JPanel gasSection; int gases;
    JPanel liquidSection; int liquids;
    JPanel mSolidSection; int mSolids;
    JPanel sSolidSection; int sSolids;
    JPanel otherSection; int others;

    public SubstancePanel(JFrame parent) {
        gasSection = new JPanel(); liquidSection = new JPanel(); mSolidSection = new JPanel(); sSolidSection = new JPanel(); otherSection = new JPanel();
        this.setFont(parent.getFont());

        substanceButtons = new JButton[SubstanceProperties.values().length];
        for (int i=0; i < substances.length; i++) {
            addButton(i);
        }

        highlightButton(0);
        selected=substances[0];

        gasSection.setLayout(new GridLayout(Math.round((float) gases/2),2));
        liquidSection.setLayout(new GridLayout(Math.round((float) liquids/2),2));
        mSolidSection.setLayout(new GridLayout(Math.round((float) mSolids/2),2));
        sSolidSection.setLayout(new GridLayout(Math.round((float) sSolids/2),2));
        otherSection.setLayout(new GridLayout(Math.round((float) others/2),2));


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Gases"){}); this.add(gasSection);
        this.add(new JLabel("Liquids")); this.add(liquidSection);
        this.add(new JLabel("Solids")); this.add(mSolidSection);
        this.add(new JLabel("Static Solids")); this.add(sSolidSection);
        this.add(new JLabel("Other")); this.add(otherSection);
    }

    void addButton(int i) {
        String label = substances[i].getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2");
        substanceButtons[i] = new JButton(label);

        final int substanceIndex = i;
        substanceButtons[i].addActionListener(e ->
        {
            selected = substances[substanceIndex];
            highlightButton(substanceIndex);
        });

        substanceButtons[i].setFont(this.getFont());
        substanceButtons[i].setForeground(SubstanceProperties.values()[i].baseColour);

        if (Gas.class.isAssignableFrom(substances[i])) {
            gasSection.add(substanceButtons[i]); gases++;
        } else if (Liquid.class.isAssignableFrom(substances[i])) {
            liquidSection.add(substanceButtons[i]); liquids++;
        } else if (MovableSolid.class.isAssignableFrom(substances[i])) {
            mSolidSection.add(substanceButtons[i]); mSolids++;
        } else if (StaticSolid.class.isAssignableFrom(substances[i])) {
            sSolidSection.add(substanceButtons[i]); sSolids++;
        } else {
            otherSection.add(substanceButtons[i]); others++;
        }
    }

    final Color HIGHLIGHT = new Color(255, 255, 255);
    final Color LOWLIGHT = new Color(120, 120, 120);
    void highlightButton(int index) {
        for (JButton substanceButton : substanceButtons) {
            substanceButton.setBackground(LOWLIGHT);
        }

        Color invert = new Color(Color.WHITE.getRGB() - SubstanceProperties.values()[index].baseColour.getRGB());
        substanceButtons[index].setBackground(invert);
    }
}
