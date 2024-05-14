package UI;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

public class FilterComboBox extends JComboBox{
	public FilterComboBox(Object[] items) {
        super(items);
        setOpaque(false); // Make it transparent
        setPreferredSize(new Dimension(getPreferredSize().width, 35)); // Increase height
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add some padding
        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setContentAreaFilled(false);
                return button;
            }

            @Override
            protected ComboPopup createPopup() {
                ComboPopup popup = super.createPopup();
                popup.getList().setBorder(BorderFactory.createEmptyBorder());
                return popup;
            }
        });
	}

    @Override
    protected void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 204)); // Set the background color with 80% opacity
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Fill the background with the rounded corners
        super.paintComponent(g);    }
}