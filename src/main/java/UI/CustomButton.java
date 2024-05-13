package UI;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private int arcWidth = 20; // Adjust this to control the degree of roundness

    public CustomButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 7));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcWidth);
        g2d.dispose();
        super.paintComponent(g);
    }
}
