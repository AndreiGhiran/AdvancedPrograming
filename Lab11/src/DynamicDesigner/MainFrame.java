package DynamicDesigner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	ControlPanel controlPanel;
    DesignPanel designPanel;
    
    public MainFrame() {
        super("Swing Designer");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //...//create and add to the frame the controlPanel and designPanel objects		
        pack();
    }
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MainFrame MF = new MainFrame();
        MF.setVisible(true);
		
    }
}
