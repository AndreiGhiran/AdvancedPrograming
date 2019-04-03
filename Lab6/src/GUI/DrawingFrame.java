package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DrawingFrame extends JFrame {
    Canvas canvas = new Canvas(this);
    Toolbar toolbar = new Toolbar(this);
    ControlPanel controlPanel = new ControlPanel(this);

    public DrawingFrame(){
        super("Graph Drawing");
        init();
    }

    private void init(){
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(15000, 1000));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        toolbar.setPreferredSize(new Dimension(1500, 100));
        toolbar.setBackground(Color.GRAY);
        this.add(toolbar, BorderLayout.NORTH);

        canvas.setPreferredSize(new Dimension(1500, 800));
        canvas.setBorder(BorderFactory.createMatteBorder(0, 20, 0, 20, Color.GRAY));
        this.add(canvas);

        controlPanel.setPreferredSize(new Dimension(1500, 100));
        controlPanel.setBackground(Color.GRAY);
        this.add(controlPanel, BorderLayout.SOUTH);

        pack();
    }
}
