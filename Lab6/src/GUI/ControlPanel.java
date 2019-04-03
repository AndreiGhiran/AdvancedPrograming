package GUI;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel{
	   
    private final DrawingFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    
    final JFileChooser filechoser = new JFileChooser();

    public ControlPanel(DrawingFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        this.add(this.loadBtn);
        this.add(this.saveBtn);
        this.add(this.resetBtn);
        
        this.loadBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		loadImg();
        	}
        });
        
        this.saveBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		saveImg();
        	}
        });
        
        this.resetBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		resetImg();
        	}
        });
    }
    private void loadImg() {
    	this.filechoser.showOpenDialog(this.frame);
    	filechoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	File path = filechoser.getSelectedFile();
    	System.out.println(path);
    	BufferedImage img;
    	try {
    		img = ImageIO.read(path);
    		this.frame.canvas.image=img;
    	//	this.frame.canvas.graphics = img.createGraphics();
    	//	this.frame.canvas.paintComponent(this.frame.canvas.graphics);
    		this.frame.canvas.repaint();
    	}catch(IOException e) {
    		System.out.println("IO Exception");
    	}
    	
    }
    
    public void saveImg()
    {
    	this.filechoser.showOpenDialog(this.frame);
    	filechoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	File path = filechoser.getSelectedFile();
    	 try {
             if (ImageIO.write(this.frame.canvas.image, "JPEG", path))
             {
                 System.out.println("-- saved");
             }
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
    }
    
    private void resetImg() {
    		Canvas canvas2 = new Canvas(this.frame);
    		canvas2.setPreferredSize(new Dimension(1500, 800));
    	    canvas2.setBorder(BorderFactory.createMatteBorder(0, 20, 0, 20, Color.GRAY));
    	    this.frame.remove(this.frame.canvas);
    	    this.frame.canvas=canvas2;
            this.frame.add(this.frame.canvas,BorderLayout.CENTER);


    }
}
