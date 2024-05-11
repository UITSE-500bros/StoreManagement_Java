package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ReuseClass.DatePicker;

public class importPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTextField tongTienTextField;
	private GridBagConstraints gbc1_1;
	private GridBagConstraints gbc1_2;
	private GridBagConstraints gbc1_3;
	private GridBagConstraints gbc1_4;
	private JButton addButton;
	private DatePicker datePicker;
	private JTable tableNhapHang;
	private DefaultTableModel model;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		importPanel im = new importPanel();
		frame.getContentPane().add(im);
		frame.setVisible(true);
	}

	/**
	 * @wbp.nonvisual location=-70,284
	 */

	/**
	 * Create the panel.
	 */
	public importPanel() {
		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;

		panelHeader.setLayout(new GridBagLayout());
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 0.9;
		gbcHeader.weighty = 1;
		gbcHeader.fill = GridBagConstraints.BOTH;
		gbcHeader.anchor = GridBagConstraints.WEST;
		JLabel headerLable = new JLabel("Nhập Hàng");
		headerLable.setBorder(new EmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 44));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.8;
		gbc.weightx = 1;
		gbc.insets = new java.awt.Insets(30, 50, 30, 50);
		gbc.fill = GridBagConstraints.BOTH;

		CustomPanel contentPane = new CustomPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 }; // 3 columns
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 }; // 5 rows
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE }; // No extra horizontal space
		gbl_contentPane.rowWeights = new double[] { 0.1, 0.1, 0.7, 0.1, Double.MIN_VALUE }; // Weights for rows
		contentPane.setLayout(gbl_contentPane);

		// For components in row 1 and 2, you need to set GridBagConstraints for each
		// component
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(0, 0, 5, 5);

		JLabel pnhLable = new JLabel("Phiếu Nhập Hàng");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 30));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		gbc1_1 = new GridBagConstraints();
		gbc1_1.gridy = 0;
		addButton = new JButton("Lập phiếu");
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/lapPhieuIcon.png");
		addButton.setIcon(lapPhieuIcon);
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setFont(new Font("Roboto", Font.BOLD, 20));
		addButton.setPreferredSize(new Dimension(150, 40));
		gbc1_1.gridx = 1;
		gbc1_1.weightx = 0.2;
		gbc1_1.anchor = GridBagConstraints.EAST;
		gbc1_1.insets = new Insets(0, 30, 5, 30);
		contentPane.add(addButton, gbc1_1);

		gbc1_4 = new GridBagConstraints();
		gbc1_4.insets = new Insets(0, 0, 5, 5);
		gbc1_4.anchor = GridBagConstraints.WEST;
		datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1_4.gridx = 0;
		gbc1_4.gridy = 1;
		gbc1_4.weightx = 0.1;
		gbc1_4.anchor = GridBagConstraints.WEST;
		contentPane.add(datePicker, gbc1_4);

		JButton themMatHangButton = new JButton("Thêm mặt hàng");
		themMatHangButton.setPreferredSize(new Dimension(150, 40));
		ImageIcon themMatHang = new ImageIcon("src/main/java/resource/themMatHangIcon.png");
		themMatHangButton.setIcon(themMatHang);
		themMatHangButton.setFont(new Font("Roboto", Font.BOLD, 12));
		themMatHangButton.setForeground(Color.WHITE);
		themMatHangButton.setBackground(Color.BLACK);
		themMatHangButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormImport temp = new FormImport();
				temp.setSize(600, 600);
				int response = JOptionPane.showConfirmDialog(null, temp, "Nhập mặt hàng", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					int sum= Integer.parseInt(temp.getTxtSoLuong()) * Integer.parseInt(temp.getTxtDonGia());
					int num = Integer.parseInt(model.getValueAt(model.getRowCount() - 1, 0).toString());
					model.addRow(new Object[] { num + 1, temp.getTxtName(), temp.getTxtDVT(), temp.getTxtSoLuong(),
							temp.getTxtDonGia(), sum});
					String tongTienText = tongTienTextField.getText();
					tongTienText = tongTienText.replace("Tổng tiền: ", "").replace(" VND", "");
					int res = Integer.parseInt(tongTienText) + sum;
					tongTienTextField.setText("Tổng tiền: " + res + " VND");

				} else if (response == JOptionPane.NO_OPTION) {

				}
			}
		});
		gbc1_2 = new GridBagConstraints();
		gbc1_2.gridy = 1;
		gbc1_2.anchor = GridBagConstraints.WEST;
		gbc1_2.gridx = 1;
		gbc1_2.weightx = 0.9;
		gbc1_2.insets = new Insets(0, 0, 5, 100);
		contentPane.add(themMatHangButton, gbc1_2);

		String[] columnNames = { "STT", "Tên mặt hàng", "Đơn vị tính", "Số lượng", "Đơn giá(VND)", "Thành tiền" };
		// Create data
		Object[][] data = { { 1, "Mặt hàng 1", "Chai", 3, 5000, 1000.0 }, { 2, "Mặt hàng 2", "lon", 2, 3000, 6000.0 },
				// Add more rows as needed
		};

		// this mode handles data in table
		model = new DefaultTableModel(data, columnNames);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		tableNhapHang = new JTable(model);
		scrollPane.setViewportView(tableNhapHang);
		tableNhapHang.setRowSelectionAllowed(true);
		((DefaultTableCellRenderer) tableNhapHang.getDefaultRenderer(Object.class)).setOpaque(false);
		tableNhapHang.setFont(new Font("Roboto", Font.PLAIN, 10));
		TableColumnModel columnModel = tableNhapHang.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(1).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.4)); // 40%
		columnModel.getColumn(2).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(3).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.2)); // 20%
		columnModel.getColumn(4).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.2)); // 20%

		gbc1_3 = new GridBagConstraints();
		gbc1_3.gridx = 0;
		gbc1_3.anchor = GridBagConstraints.EAST;
		tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1_3.gridy = 3;
		gbc1_3.gridwidth = 2; // Span across 2 columns
		gbc1_3.insets = new java.awt.Insets(20, 0, 0, 0);
		contentPane.add(tongTienTextField, gbc1_3);

		this.add(contentPane, gbc);

	}

}
