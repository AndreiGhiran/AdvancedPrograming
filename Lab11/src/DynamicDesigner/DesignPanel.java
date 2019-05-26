package DynamicDesigner;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DesignPanel extends JPanel{
	
	public static final int W = 800, H = 600;
    private final MainFrame frame;
    
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }
    public void addAtRandomLocation(JComponent comp) {
    	Random rand = new Random();
        int x = rand.nextInt(W); //create a random integer between 0 and W-1
        int y = rand.nextInt(H); //create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}
