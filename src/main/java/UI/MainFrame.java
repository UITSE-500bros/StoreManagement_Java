package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.ThamSoController;
import Repository.ThamSoRepository;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.io.IOException;

import java.awt.Image;


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
	private JButton logoutButton;
	private importPanel importPanel;
	private ExportPanel exportPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightLaf.setup();

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
		setTitle("Store Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		setMinimumSize(new Dimension(1100, 600));
		
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
		
		JMenuItem mntm_MaxStore = new JMenuItem("Số đại lý tối đa mỗi quận");
		mntm_MaxStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeLimit storeLimit = new storeLimit();
				storeLimit.setVisible(true);
				storeLimit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				storeLimit.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_MaxStore);
		
		JMenuItem mntm_StoreType = new JMenuItem("Cài đặt loại đại lý");
		mntm_StoreType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                StoreTypeSetting storeTypeSetting = null;
                try {
                    storeTypeSetting = new StoreTypeSetting();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                storeTypeSetting.setVisible(true);
				storeTypeSetting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				storeTypeSetting.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_StoreType);
		
		JMenuItem mntm_ItemQuantity = new JMenuItem("Thêm mặt hàng mới");
		mntm_ItemQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Items items = null;
                try {
                    items = new Items();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                items.setVisible(true);
				items.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				items.setLocationRelativeTo(null);
				
			}
		});
		MainMenu.add(mntm_ItemQuantity);
		
		JMenuItem mntm_Unit = new JMenuItem("Đơn vị tính");
		mntm_Unit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Unit unit = null;
                try {
                    unit = new Unit();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                unit.setVisible(true);
				unit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				unit.setLocationRelativeTo(null);
			}
		});
		MainMenu.add(mntm_Unit);
		
		JMenuItem mntm_Ratio = new JMenuItem("Tỉ lệ tính đơn vị xuất");
		mntm_Ratio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThamSoController thamSoController = new ThamSoController();
				Ratio ratio = null;
                try {
                     ratio = new Ratio(thamSoController.getTyLeDGX());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
		menuPanel.setPreferredSize(new Dimension(200, 0)); 
		menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
		initMenuPanel(menuPanel);
		menuPanel.setLayout(new GridLayout(15, 1, 15, 0));
		JPanel emptyPanel = new JPanel();
		emptyPanel.setOpaque(false);
		emptyPanel.setPreferredSize(new Dimension(0, 10));
		menuPanel.add(emptyPanel); // Empty panel
		menuPanel.add(storesButton);
		menuPanel.add(stockButton);
		menuPanel.add(reportButton);
		menuPanel.add(importButton);
		menuPanel.add(exportButton);
		menuPanel.add(logoutButton);
		
		CardLayout cardLayout = new CardLayout(0,0);
		containerPanel.setLayout(cardLayout);
		
		

		StoresPanel storesPanel = new StoresPanel();
		storesPanel.setOpaque(false);
		containerPanel.add(storesPanel, "name_240836109219200");

		StockPanel stockPanel = new StockPanel();
		stockPanel.setOpaque(false);
		containerPanel.add(stockPanel, "name_240836138693900");

		// thay new JPanel() bang Panel do ae tao
		reportPanel reportPanel = new reportPanel();

		reportPanel.setOpaque(false);

		containerPanel.add(reportPanel, "name_240836198139600");

		// thay new JPanel() bang Panel do ae tao
		importPanel = new importPanel();
		importPanel.setOpaque(false);
		containerPanel.add(importPanel, "name_240836231205200");

		// thay new JPanel() bang Panel do ae tao
		exportPanel = new ExportPanel();
		exportPanel.setOpaque(false);
		containerPanel.add(exportPanel, "name_240836258641200");
		
		// thay new JPanel() bang Panel do ae tao
		JPanel settingPanel = new JPanel();
		settingPanel.setOpaque(false);
		containerPanel.add(settingPanel, "name_240836285379400");
		
		storesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "name_240836109219200");
				storesPanel.removeAll();
				storesPanel.initComponents();
			}
		});
		
		stockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "name_240836138693900");
				stockPanel.removeAll();
				stockPanel.initComponents();
			}
		});
		
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "name_240836198139600");
				reportPanel.removeAll();
				reportPanel.initComponet();
			}
		});
		
		
		importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(containerPanel, "name_240836231205200");
				importPanel.removeAll();
				importPanel.initComponet();
            }
        });
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "name_240836258641200");
				exportPanel.removeAll();
				exportPanel.initComponent();
			}
		});
		
		storesButton.setSelected(true);
		MenuItemsButton.setCurrentSelected((MenuItemsButton)storesButton);
	}

	private void initMenuPanel(JPanel menuPanel) {
		ImageIcon logo = new ImageIcon("src/main/java/resource/store.png");
		Image scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		
		
		storesButton = new MenuItemsButton("Đại lý", logo);
		logo = new ImageIcon("src/main/java/resource/stock.png");
		scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		stockButton = new MenuItemsButton("Kho", logo);
		
		logo = new ImageIcon("src/main/java/resource/report.png");
		scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		reportButton = new MenuItemsButton("Báo cáo", logo);
		
		logo = new ImageIcon("src/main/java/resource/import.png");
		scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		importButton = new MenuItemsButton("Nhập hàng", logo);
		
		logo = new ImageIcon("src/main/java/resource/export.png");
		scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		exportButton = new MenuItemsButton("Xuất hàng", logo);
		
		logo = new ImageIcon("src/main/java/resource/signout.png");
		scaledLogo = logo.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		logo = new ImageIcon(scaledLogo);
		logoutButton = new MenuItemsButton("Đăng xuất", logo);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Warning",
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    login  loginFrame = new login();
                    loginFrame.setVisible(true);
                    dispose();}
			}
		});
	}

	

	
}
