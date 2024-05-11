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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel menuPanel;
	private GridBagConstraints gbc_menuPanel;
	private GridBagConstraints gbc_storesListPanel;
	private JButton storesButton;
	private JButton stockButton;
	private JButton reportButton;
	private JButton importButton;
	private JButton exportButton;
	private JButton settingButton;
	private JButton logoutButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
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
		
		// Create menu bar
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// Create menu
		JMenu MainMenu = new JMenu("Cài đặt");
		menuBar.add(MainMenu);
		// Create menu items
		JMenuItem mntm_userinfo = new JMenuItem("Thông tin cá nhân");
		mntm_userinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralSetting generalSetting = new GeneralSetting();
				generalSetting.setVisible(true);
				generalSetting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				generalSetting.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_userinfo);
		
		JMenuItem mntm_NewStore = new JMenuItem("Thêm loại đại lý mới\r\n");
		mntm_NewStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewStoreType addNewStoreType = new addNewStoreType();
				addNewStoreType.setVisible(true);
				addNewStoreType.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addNewStoreType.setLocationRelativeTo(null);
				
			}
		});
		MainMenu.add(mntm_NewStore);
		
		JMenuItem mntm_MaxStore = new JMenuItem("Số lượng đại lý tối đa");
		mntm_MaxStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxStorelimit maxStorelimit = new maxStorelimit();
				maxStorelimit.setVisible(true);
				maxStorelimit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				maxStorelimit.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_MaxStore);
		
		JMenuItem mntm_StoreType = new JMenuItem("Cài đặt loại đại lý");
		mntm_StoreType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreTypeSetting storeTypeSetting = new StoreTypeSetting();
				storeTypeSetting.setVisible(true);
				storeTypeSetting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				storeTypeSetting.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_StoreType);
		
		JMenuItem mntm_ItemQuantity = new JMenuItem("Số lượng mặt hàng tối đa");
		mntm_ItemQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Items items = new Items();
				items.setVisible(true);
				items.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				items.setLocationRelativeTo(null);
				
			}
		});
		MainMenu.add(mntm_ItemQuantity);
		
		JMenuItem mntm_Unit = new JMenuItem("Đơn vị tính");
		mntm_Unit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Unit unit = new Unit();
				unit.setVisible(true);
				unit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				unit.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_Unit);
		
		JMenuItem mntm_Ratio = new JMenuItem("Tỉ lệ tính đơn vị xuất");
		mntm_Ratio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportRatio ratio = new exportRatio();
				ratio.setVisible(true);
				ratio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ratio.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_Ratio);
		
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		initComponents();
	}

	private void initComponents() {
		GridBagLayout mainGBL = new GridBagLayout();
		mainPanel.setLayout(mainGBL);
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.BLACK);
		GridBagConstraints gbc = null;
		gbc_menuPanel = new GridBagConstraints();
		gbc_menuPanel.fill = GridBagConstraints.BOTH;
		gbc_menuPanel.gridx = 0;
		gbc_menuPanel.gridy = 0;
		gbc_menuPanel.gridwidth = 1; // menuPanel will span 1 column
		gbc_menuPanel.gridheight = GridBagConstraints.REMAINDER; // menuPanel will span all remaining rows
		gbc_menuPanel.weightx = 0.15; // menuPanel will take up 15% of the available horizontal space
		gbc_menuPanel.weighty = 1; // menuPanel will take up all available vertical space

		mainPanel.add(menuPanel, gbc);
		ContainerPanel containerPanel = new ContainerPanel();
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
		menuPanel.setLayout(new GridLayout(15, 1, 0, 0));
		menuPanel.add(storesButton);
		menuPanel.add(stockButton);
		menuPanel.add(reportButton);
		menuPanel.add(importButton);
		menuPanel.add(exportButton);
		menuPanel.add(settingButton);
		menuPanel.add(logoutButton);
		containerPanel.setLayout(new CardLayout(0, 0));

		JPanel storesPanel = new StoresPanel();
		containerPanel.add(storesPanel, "name_240836109219200");

		JPanel stockPanel = new JPanel();
		containerPanel.add(stockPanel, "name_240836138693900");
		
		JLabel lblNewLabel = new JLabel("ton kho");
		stockPanel.add(lblNewLabel);

		JPanel reportPanel = new JPanel();
		containerPanel.add(reportPanel, "name_240836198139600");
		
		JLabel lblNewLabel_1 = new JLabel("report");
		reportPanel.add(lblNewLabel_1);

		JPanel importPanel = new JPanel();
		containerPanel.add(importPanel, "name_240836231205200");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		importPanel.add(lblNewLabel_2);

		JPanel exportPanel = new JPanel();
		containerPanel.add(exportPanel, "name_240836258641200");

		JPanel settingPanel = new JPanel();
		containerPanel.add(settingPanel, "name_240836285379400");
	}

	private void initMenuPanel(JPanel menuPanel) {
		storesButton = new JButton("Đại lý");

		stockButton = new JButton("Kho");
		
		reportButton = new JButton("Báo cáo");
		
		importButton = new JButton("Nhập hàng");
		
		exportButton = new JButton("Xuất hàng");
		
		settingButton = new JButton("Cài đặt");
		
		logoutButton = new JButton("Đăng xuất");
	}

	

	
}
