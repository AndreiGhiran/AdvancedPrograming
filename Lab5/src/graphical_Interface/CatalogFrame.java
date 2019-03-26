package graphical_Interface;

import java.awt.*;

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
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setSize(565,350);
    	
        this.form=new GraphForm(this);
        this.list=new CatalogList();
        
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=0;
        this.add(form, c);
        
    	c = new GridBagConstraints();
    	this.list.addGraph("CEVA");
    	c.fill = GridBagConstraints.BOTH;
    	c.gridx=0;
    	c.gridy=1;
    	this.add(list, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=2;
    	
    	this.control=new ControlPanel(this);
    	this.add(control,c);
     //   ...
    }		
   // ...
}