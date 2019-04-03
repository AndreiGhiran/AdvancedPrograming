package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class ControlPanel extends JPanel {
    public JButton load = new JButton("Load");
    public JFileChooser loadChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg");

    public JButton save = new JButton("Save");
    public JFileChooser saveChooser = new JFileChooser();
    public JButton reset = new JButton("Reset");

    public ControlPanel(){
        init();
    }

    private void init(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 30, 3, 30);
        gbc.ipadx = 20;
        gbc.ipady = 5;

        gbc.ipadx = 1;
        gbc.ipady = 1;
        add(load, gbc);

        gbc.ipady++;
        add(save, gbc);

        gbc.ipady++;
        add(reset, gbc);

        loadChooser.setMultiSelectionEnabled(false);
        loadChooser.addChoosableFileFilter(filter);
        loadChooser.setAcceptAllFileFilterUsed(false);
    }
}
