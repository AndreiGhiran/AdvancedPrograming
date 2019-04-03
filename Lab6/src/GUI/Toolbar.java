package GUI;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Toolbar extends JPanel{
	  
	  private final DrawingFrame frame;
	  
      JLabel node_color_label = new JLabel("Node Color");
      JLabel node_size_label = new JLabel("Node Size");
      
      
      String[] colors = {"black", "red", "blue", "green"};
      
     
      JComboBox<String> node_color_box = new JComboBox<String>(colors);
      
      JSpinner node_size = new JSpinner(new SpinnerNumberModel(50,10,1000,1));
      
      TitledBorder border = new TitledBorder("Drawing Panel");
      
      public Toolbar(DrawingFrame frame)
      {
    	  this.frame=frame;
    	  this.init();
    	  this.node_color_box.getSelectedIndex();
      }
      
      private void init() 
      {
    	this.setLayout(new FlowLayout());  
    	this.add(this.node_color_label);
    	this.add(this.node_color_box);
    	this.add(this.node_size_label);
    	this.add(this.node_size);
    	
    	this.border.setTitleJustification(TitledBorder.LEFT);
    	this.border.setTitlePosition(TitledBorder.TOP);
    	
    	this.setBorder(border);
      }
}
