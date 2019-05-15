package DynamicDesigner;

import javax.swing.*;

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
	            JComponent comp = createDynamicComponent(classNameField.getText());
	            setComponentText(comp, textField.getText());
	            frame.designPanel.addAtRandomLocation(comp);
	        });
	    }
	    private JComponent createDynamicComponent(String className) {
		   ...//implement this method
	    }
	    private void setComponentText(JComponent comp, String text) {
		   ...//implement this method
	    }
}
