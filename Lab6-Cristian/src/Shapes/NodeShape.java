package Shapes;

import java.awt.geom.Ellipse2D;

public class NodeShape extends Ellipse2D.Double {
    private int size;
    private int colorIndex;
    private String type = new String();

    public NodeShape(double x0, double y0, int radius, int colorIndex, String type) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
        size = radius;
        this.colorIndex = colorIndex;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public int getColorIndex() {
        return colorIndex;
    }

    public String getType() {
        return type;
    }
}
