package DynamicDesigner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel{
	
	 private final MainFrame frame;
	    private final JLabel classNameLabel = new JLabel("Class name");
	    private final JTextField classNameField = new JTextField(30);
	    private final JLabel textLabel = new JLabel("Default text");
	    private final JTextField textField = new JTextField(10);
	    private final JButton createButton = new JButton("Add component");
	   
	    public ControlPanel(MainFrame frame) {
	        this.frame = frame;
	        init();
	    }
	    private void init() {
	        add(classNameLabel); add(classNameField); add(textLabel); add(textField); add(createButton);
	        createButton.addActionListener(e -> {
	            JComponent comp;
				try {
					comp = createDynamicComponent(classNameField.getText());
					setComponentText(comp, textField.getText());
		            frame.designPanel.addAtRandomLocation(comp);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        });
	    }
	    private JComponent createDynamicComponent(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		  // ...//implement this method
		   Class clazz = Class.forName(className);
		   JComponent comp = (JComponent) clazz.newInstance();
		   return comp;
	    }
	    private void setComponentText(JComponent comp, String text) {
		   //...//implement this method
	       switch (comp.getClass().getName()){
	    	   case  "javax.swing.JButton":
	    		   ((JButton) comp).setText(text);
	    		   break;
	    	   case  "javax.swing.JLabel":
	    		   ((JLabel) comp).setText(text);
	    		   break;
	    	   default:
	       }
	    }
}
