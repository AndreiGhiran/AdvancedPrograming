package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingFrame extends JFrame {
    Canvas canvas = new Canvas();
    Toolbar toolbar = new Toolbar();
    ControlPanel controlPanel = new ControlPanel();

    public DrawingFrame() {
        super("Graph Drawing");
        init();
    }

    private void init() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(15000, 1000));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        toolbar.setPreferredSize(new Dimension(1500, 100));
        toolbar.setBackground(Color.GRAY);
        this.add(toolbar, BorderLayout.NORTH);

        canvas.setPreferredSize(new Dimension(1500, 800));
        canvas.setBorder(BorderFactory.createMatteBorder(0, 20, 0, 20, Color.GRAY));
        this.add(canvas);

        controlPanel.setPreferredSize(new Dimension(1500, 100));
        controlPanel.setBackground(Color.GRAY);
        this.add(controlPanel, BorderLayout.SOUTH);

        pack();


        /* Node drawing listener */
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.drawNode(e.getX(), e.getY(), toolbar.getNodeSize(), toolbar.getNodeColor(), toolbar.getNodeType());
                canvas.repaint();
            }
        });

        /* Load button listener */
        controlPanel.load.addActionListener(e -> {
            final JFrame frame = new JFrame("Load from");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String path;

            int retVal = controlPanel.loadChooser.showOpenDialog(frame);
            if(retVal == JFileChooser.APPROVE_OPTION){
                clearCanvas();
                path = controlPanel.loadChooser.getSelectedFile().getAbsolutePath();
                Image img = Toolkit.getDefaultToolkit().getImage(path);
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D aux = bufferedImage.createGraphics();
                Canvas canvas2 = new Canvas(aux);
                this.canvas = canvas2;
            }
        });

        /* Save button listener */
        controlPanel.save.addActionListener(e -> {
            final JFrame frame = new JFrame("Save to");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String path;

            controlPanel.saveChooser.showSaveDialog(frame);
            path = controlPanel.saveChooser.getSelectedFile().getAbsolutePath();
            if(!(path.endsWith(".jpeg")))
                path = path.concat(".jpeg");
            canvas.saveImage(path);
        });

        /* Reset button listener */
        controlPanel.reset.addActionListener(e -> {
            clearCanvas();
        });
    }

    private void clearCanvas() {
        Canvas aux = new Canvas();
        aux.setPreferredSize(new Dimension(1500, 800));
        aux.setBorder(BorderFactory.createMatteBorder(0, 20, 0, 20, Color.GRAY));
        this.remove(canvas);
        canvas = aux;
        this.add(canvas);
    }
}
