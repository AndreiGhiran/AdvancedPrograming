package GUI;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    private JLabel sizeOfNodeL = new JLabel("Size of the node: ");
    private JSpinner sizeOfNode = new JSpinner(new SpinnerNumberModel(30, 20, 100, 1));
    private JLabel colorOfNodeL = new JLabel("Color of the node: ");
    private String[] nodeColorOptions = {"red", "blue", "black", "gray", "green", "yellow"};
    private JComboBox colorOfNode = new JComboBox(nodeColorOptions);
    private JLabel nodeTypeL = new JLabel("Type: ");
    private String[] nodeTypeOptions = {"Fill", "No fill"};
    private JComboBox nodeType = new JComboBox(nodeTypeOptions);

    public Toolbar() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 50, 3, 30);
        gbc.ipadx = 5;
        gbc.ipady = 5;

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(sizeOfNodeL, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 70;
        add(sizeOfNode, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 5;

        add(colorOfNodeL, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 120;

        add(colorOfNode, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 5;

        add(nodeTypeL, gbc);

        gbc.gridx += 2;
        gbc.ipadx = 70;

        add(nodeType, gbc);
    }

    public int getNodeSize() {
        return (int) this.sizeOfNode.getValue();
    }

    public int getNodeColor() {
        return this.colorOfNode.getSelectedIndex();
    }

    public String getNodeType() {
        return (String) this.nodeType.getSelectedItem();
    }
}
