package UI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
public class CustomTextField extends JTextField{
    private String placeholder;

	public CustomTextField(int columns) {
        super(columns);
        setPreferredSize(new Dimension(getPreferredSize().width, 40)); // Increase height
        setBorder(BorderFactory.createLineBorder(new Color(72, 71, 71), 1));
        setBackground(Color.WHITE);
        //setMargin(new Insets(0, 20, 0, 5)); // Add some padding but not working
        //setFont(new Font("Roboto", Font.PLAIN, 12)); // Change font

    }
	public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }


	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getDisabledTextColor());
        g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(72, 71, 71));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
    }
}