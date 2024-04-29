package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	private int cornerRadius;
    private Color backgroundColor;
    private Color strokeColor;
    private Color shadowColor;
    private int strokeWidth;

    public CustomPanel() {
        setOpaque(false);
        cornerRadius = 30;
        backgroundColor = new Color(255,249,243, 180);
        strokeColor = new Color(192, 192, 192);
        strokeWidth = 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
    	int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        

        // Draws the rounded opaque panel with borders.
        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius); //paint background

        // Draws the stroke
        graphics.setColor(strokeColor);
        graphics.setStroke(new BasicStroke(strokeWidth));
        graphics.drawRoundRect(0, 0, width-1, height-1, cornerRadius, cornerRadius); //paint border

        super.paintComponent(g);
    }
}
