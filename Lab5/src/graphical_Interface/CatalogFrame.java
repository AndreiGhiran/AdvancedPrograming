package graphical_Interface;

import javax.swing.JFrame;

public class CatalogFrame extends JFrame {
    GraphForm form;
    CatalogList list;
    ControlPanel control;       
   	
    public CatalogFrame() {
        super("Visual Graph Manager");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     //   ...
    }		
   // ...
}