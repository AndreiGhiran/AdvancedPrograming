package graphical_Interface;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final CatalogFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(CatalogFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
    	System.out.println("ceva");
        this.frame.add(loadBtn);
        this.frame.add(saveBtn);
        this.frame.pack();
    }
}