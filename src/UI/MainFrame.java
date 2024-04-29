package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel menuPanel;
	private GridBagConstraints gbc_menuPanel;
	private GridBagConstraints gbc_storesListPanel;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		initComponents();
	}

	private void initComponents() {
		GridBagLayout mainGBL = new GridBagLayout();
		mainPanel.setLayout(mainGBL);
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.BLACK);
		GridBagConstraints gbc;
		gbc_menuPanel = new GridBagConstraints();
		gbc_menuPanel.fill = GridBagConstraints.BOTH;
		gbc_menuPanel.gridx = 0;
		gbc_menuPanel.gridy = 0;
		gbc_menuPanel.gridwidth = 1; // menuPanel will span 1 column
		gbc_menuPanel.gridheight = GridBagConstraints.REMAINDER; // menuPanel will span all remaining rows
		gbc_menuPanel.weightx = 0.15; // menuPanel will take up 15% of the available horizontal space
		gbc_menuPanel.weighty = 1; // menuPanel will take up all available vertical space

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
		mainPanel.add(menuPanel, gbc_menuPanel);
		// menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		initMenuPanel(menuPanel);

		ContainerPanel containerPanel = new ContainerPanel();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.weightx = 0.85;
		gbc.weighty = 1;
		mainPanel.add(containerPanel, gbc);
		containerPanel.setLayout(new CardLayout(0, 0));

		JPanel storesPanel = new JPanel();
		initStoresPanel(storesPanel);
		containerPanel.add(storesPanel);

		JPanel stockPanel = new JPanel();
		initStockPanel(stockPanel);
		containerPanel.add(stockPanel);

		JPanel reportPanel = new JPanel();
		initReportPanel(reportPanel);
		containerPanel.add(reportPanel);

		JPanel importPanel = new JPanel();
		initImportPanel(importPanel);
		containerPanel.add(importPanel);

		JPanel exportPanel = new JPanel();
		initExportPanel(exportPanel);
		containerPanel.add(exportPanel);

		JPanel settingPanel = new JPanel();
		initSettingPanel(settingPanel);
		containerPanel.add(settingPanel);
	}

	private void initMenuPanel(JPanel menuPanel) {
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		JLabel storesLabel = new JLabel("Đại Lý");
		menuPanel.add(storesLabel);

		JLabel stockLabel = new JLabel("Kho");
		menuPanel.add(stockLabel);

		JLabel reportLabel = new JLabel("Báo cáo");
		menuPanel.add(reportLabel);

		JLabel importLabel = new JLabel("Nhập hàng");
		menuPanel.add(importLabel);

		JLabel exportLabel = new JLabel("Xuất hàng");
		menuPanel.add(exportLabel);

		JLabel settingLabel = new JLabel("Cài đặt");
		menuPanel.add(settingLabel);
	}

	private void initStoresPanel(JPanel storesPanel) {
		storesPanel.setOpaque(false);
		GridBagLayout gbl = new GridBagLayout();
		gbl.rowWeights = new double[] { 1.0, 15.0 }; // row 1 will take up 1/8 of the vertical space of row 2
		gbl.columnWeights = new double[] { 1.0, 1.0 }; // column 1 will take up 1/8 of the horizontal space of column 2
		storesPanel.setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;

		JLabel titleLabel = new JLabel("Đại Lý");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		titleLabel.setPreferredSize(new Dimension(180, 20));
		gbc.gridx = 0; // place titleLabel in column 1
		gbc.gridy = 0; // place titleLabel in row 1
		gbc.insets = new Insets(0, 20, 0, 0);
		storesPanel.add(titleLabel, gbc);

		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(Color.RED);
		accountPanel.setPreferredSize(new Dimension(20, 10));
		gbc = new GridBagConstraints();
		gbc.gridx = 1; // place accountPanel in column 2
		gbc.gridy = 0; // place accountPanel in row 1
		storesPanel.add(accountPanel, gbc);

		CustomPanel storesListPanel = new CustomPanel();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0; // place storesListPanel in column 1
		gbc.gridy = 1; // place storesListPanel in row 2
		gbc.gridwidth = 2; // storesListPanel will span both columns
		gbc.insets = new Insets(30, 25, 30, 25);
		storesPanel.add(storesListPanel, gbc);

		GridBagLayout gbl_storesListPanel = new GridBagLayout();
		gbl_storesListPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_storesListPanel.rowWeights = new double[] { 1.0, 1.0, 8.0 };

		storesListPanel.setLayout(gbl_storesListPanel);
		JLabel listTitle = new JLabel("Danh sách các đại lý");
		listTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 20, 0, 0);
		storesListPanel.add(listTitle, gbc);

		JLabel addStoreLabel = new JLabel("Thêm đại lý");
		addStoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 20);
		storesListPanel.add(addStoreLabel, gbc);

		JPanel storeList = new JPanel();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 8;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 20, 0, 20);
		storesListPanel.add(storeList, gbc);

	}

	private void initStockPanel(JPanel stockPanel) {
		stockPanel.setOpaque(false);
	}

	private void initReportPanel(JPanel reportPanel) {
		reportPanel.setOpaque(false);
	}

	private void initImportPanel(JPanel importPanel) {
		importPanel.setOpaque(false);
	}

	private void initExportPanel(JPanel exportPanel) {
		exportPanel.setOpaque(false);
	}

	private void initSettingPanel(JPanel settingPanel) {
		settingPanel.setOpaque(false);
	}
}
