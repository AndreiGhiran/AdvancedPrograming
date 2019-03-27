package graphical_Interface;

import java.awt.*;

import javax.swing.*;

import graph_catalog.*;

public class CatalogFrame extends JFrame {
    GraphForm form;
    CatalogList list;
    ControlPanel control;
    JLabel path;
    JTextField s_l_PathField;
    
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
    	c.fill = GridBagConstraints.BOTH;
    	c.gridx=0;
    	c.gridy=1;
    	this.add(list, c);
    	
    	this.path = new JLabel ("Sava/Load path");
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=2;
    	this.add(this.path,c);
    	
    	this.s_l_PathField= new JTextField(); 
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=3;
    	this.add(this.s_l_PathField,c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=4;
    	
    	this.control=new ControlPanel(this);
    	this.add(control,c);
     
    }		
  
}