package UI;

<<<<<<< HEAD
public class ContainerPanel {
=======
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ContainerPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color1 = Color.decode("#F0E6DF");
    private Color color2 = Color.decode("#C7BEB7");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
>>>>>>> 1f4de5600af9ca5f0c583fbd6bd2b10e28b528ed
}
