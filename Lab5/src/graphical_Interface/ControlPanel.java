package graphical_Interface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.add(loadBtn);
        this.add(saveBtn);
     
    }
}