package UI;

import javax.swing.*;
import java.awt.*;
public class SearchTextField extends JTextField {
    private String placeholder = "";

    public SearchTextField(int columns) {
        super(columns);
        setOpaque(false); // Make it transparent
        setPreferredSize(new Dimension(getPreferredSize().width, 35)); // Increase height
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add some padding
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 204)); // Set the background color with 80% opacity
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50); // Fill the background with the rounded corners
        super.paintComponent(g);

        // Draw placeholder
        if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
            g2.setColor(getDisabledTextColor());
            g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(new Color(72, 71, 71));
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);
    }
}