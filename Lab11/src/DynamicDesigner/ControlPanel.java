package DynamicDesigner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
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
	    private void setComponentText(JComponent comp, String text) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		   //...//implement this method
	    	Method method = comp.getClass().getMethod("setText", String.class); 
	    	method.invoke(comp,text);
	    }
}
