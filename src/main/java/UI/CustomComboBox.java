package UI;
import java.awt.*;
import javax.swing.*;
public class CustomComboBox extends JComboBox{
	public CustomComboBox(Object[] items) {
        super(items);
        setPreferredSize(new Dimension(getPreferredSize().width, 40)); // Increase height
        setBorder(BorderFactory.createLineBorder(new Color(72, 71, 71), 1));
        setBackground(Color.WHITE);
    }

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(72, 71, 71));
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
	}
}