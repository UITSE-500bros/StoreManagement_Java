package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout; 
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		GridBagLayout mainGBL = new GridBagLayout();
		
		mainPanel.setLayout(mainGBL);
		JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // menuPanel will span 1 column
        gbc.gridheight = GridBagConstraints.REMAINDER; // menuPanel will span all remaining rows
        gbc.weightx = 0.15; // menuPanel will take up 20% of the available horizontal space
        gbc.weighty = 1; // menuPanel will take up all available vertical space

        mainPanel.add(menuPanel, gbc);
        JPanel containerPanel = new JPanel();
        containerPanel.setBackground(Color.YELLOW);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0.85;
        gbc.weighty = 1;
        mainPanel.add(containerPanel, gbc);
	}
}
