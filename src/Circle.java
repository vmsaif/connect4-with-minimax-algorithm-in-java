/* -----------------------------------------------------------------------------
    Author: Saif Mahmud
    Date: 2023-02-08 (yyyy-dd-mm)

    Description: This class is creates and draws a circle icon.
*/
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class Circle implements Icon {
    private Color fillColor;
    private Color borderColor;
    private int size;

    public Circle(Color fillColor, Color borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.size = 40;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Anti-alias! 
        
        // Draw the circle
        g2d.setColor(fillColor);
        g2d.fillOval(x, y, size, size);
        
        // Draw the border
        g2d.setColor(borderColor);
        g2d.drawOval(x, y, size, size);
        
        g2d.dispose(); // Clean up
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }
}