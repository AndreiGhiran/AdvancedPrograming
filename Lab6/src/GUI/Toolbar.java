package GUI;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Toolbar extends JPanel{
	  
	  private final DrawingFrame frame;
	  
      JLabel node_shape_label = new JLabel("Node Sape");
      JLabel node_color_label = new JLabel("Node Color");
      JLabel node_size_label = new JLabel("Node Size");
      
      String[] sapes = { "circle", "square", "triangle" };
      String[] colors = {"red", "blue", "purple"};
      
      JComboBox<String> node_sape_box = new JComboBox<String>(sapes);
      JComboBox<String> node_color_box = new JComboBox<String>(colors);
      
      JSpinner node_size = new JSpinner(new SpinnerNumberModel(1,1,1000,1));
      
      TitledBorder border = new TitledBorder("Drawing Panel");
      
      public Toolbar(DrawingFrame frame)
      {
    	  this.frame=frame;
    	  this.init();
      }
      
      private void init() 
      {
    	this.setLayout(new FlowLayout());  
    	this.add(this.node_shape_label);
    	this.add(this.node_sape_box);
    	this.add(this.node_color_label);
    	this.add(this.node_color_box);
    	this.add(this.node_size_label);
    	this.add(this.node_size);
    	
    	this.border.setTitleJustification(TitledBorder.LEFT);
    	this.border.setTitlePosition(TitledBorder.TOP);
    	
    	this.setBorder(border);
      }
}
