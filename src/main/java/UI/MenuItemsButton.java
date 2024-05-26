package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuItemsButton extends JButton {
    private Color normalBackground = new Color(0,0,0,0); // Transparent
    private Color normalForeground = Color.WHITE;
    private Color pressedBackground = Color.WHITE;
    private Color pressedForeground = Color.BLACK;
    private boolean selected = false;
    private static MenuItemsButton currentSelected = null; // Track the current selected button

    public MenuItemsButton(String text, Icon icon) {
    	super(text, icon);
        setBorderPainted(false);
        //setFocusPainted(false);
        //setContentAreaFilled(true); // Allow background color change
        setOpaque(true); // Allow background color change
        setForeground(normalForeground);
        setBackground(normalBackground);
        setFont(new Font("Arial", Font.BOLD, 14));
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setIconTextGap(15);
        //setPreferredSize(new Dimension(100, 20));
        //setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //setMargin(new Insets(10, 10, 10, 10));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getCurrentSelected() != null) {
                    getCurrentSelected().setSelected(false); // Deselect the previous button
                }
                setSelected(true);
                setCurrentSelected(MenuItemsButton.this); // Update the current selected button
            }
        });
        }
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setBackground(pressedBackground);
            setForeground(pressedForeground);
        } else {
            setBackground(normalBackground);
            setForeground(normalForeground);
        }
    }

    public boolean isSelected() {
        return selected;
    }
	public static MenuItemsButton getCurrentSelected() {
		return currentSelected;
	}
	public static void setCurrentSelected(MenuItemsButton currentSelected) {
		MenuItemsButton.currentSelected = currentSelected;
	}
}