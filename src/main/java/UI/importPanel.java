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
	private CustomButton addButton;
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
		panelHeader.setOpaque(false);
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 0.9;
		gbcHeader.weighty = 1;
		gbcHeader.fill = GridBagConstraints.HORIZONTAL;
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
		gbc.insets = new java.awt.Insets(20, 40, 20, 40);
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
		gbc1.weightx = 0.2;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		addButton = new CustomButton("Lập phiếu");
		addButton.setPreferredSize(new Dimension(150, 40));  // Preferred size
		addButton.setMinimumSize(new Dimension(150, 40));    // Minimum size
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/lapPhieuIcon.png");
		addButton.setIcon(lapPhieuIcon);
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setIconTextGap(20);
		addButton.setHorizontalAlignment(JButton.LEFT);
		addButton.setHorizontalTextPosition(JButton.RIGHT);
		addButton.setFont(new Font("Roboto", Font.BOLD, 15));

		gbc1_1 = new GridBagConstraints();
		gbc1_1.gridy = 0;
		gbc1_1.gridx = 1;
		gbc1_1.weightx = 1.0;         // Make sure it can expand horizontally
		gbc1_1.weighty = 0.0;         // No extra vertical space
		gbc1_1.anchor = GridBagConstraints.EAST;
		gbc1_1.insets = new Insets(0, 0, 0, 30);
		gbc1_1.fill = GridBagConstraints.CENTER;  // Allow it to fill horizontally

		contentPane.add(addButton, gbc1_1);

		gbc1_4 = new GridBagConstraints();
		gbc1_4.insets = new Insets(0, 0, 0, 200);
		gbc1_4.anchor = GridBagConstraints.WEST;
		datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1_4.gridx = 0;
		gbc1_4.gridy = 1;
		gbc1_4.weightx = 0.2;
		gbc1_4.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(datePicker, gbc1_4);

		JButton themMatHangButton = new CustomButton("Thêm mặt hàng");
		themMatHangButton.setPreferredSize(new Dimension(150, 40));
		ImageIcon themMatHang = new ImageIcon("src/main/java/resource/themMatHangIcon.png");
		themMatHangButton.setIcon(themMatHang);
		themMatHangButton.setFont(new Font("Roboto", Font.BOLD, 12));
		themMatHangButton.setForeground(Color.WHITE);
		themMatHangButton.setBackground(Color.BLACK);
		themMatHangButton.setIconTextGap(15);
		themMatHangButton.setHorizontalAlignment(JButton.LEFT);
		themMatHangButton.setHorizontalTextPosition(JButton.RIGHT);
		themMatHangButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(600, 900);
				GridBagConstraints gbc = new GridBagConstraints();

				JPanel panelContent = new JPanel();
				gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.weightx = 1;
				gbc.weighty = 0.9;
				gbc.fill = GridBagConstraints.BOTH;
				panelContent.setLayout(new GridBagLayout());
				GridBagConstraints gbcContent = new GridBagConstraints();

				JLabel labelName = new JLabel("Tên mặt hàng");
				gbcContent.gridx = 0;
				gbcContent.gridy = 0;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelName.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelName, gbcContent);

				gbcContent = new GridBagConstraints();
				String [] cacMatHang = new String[] {"Cà phê", "Đường", "Hạt nêm", "Mì", "Sữa"};
				CustomComboBox txtName = new CustomComboBox(cacMatHang);
				gbcContent.fill = GridBagConstraints.HORIZONTAL;
				gbcContent.gridx = 0;
				gbcContent.gridy = 1;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 20, 0);
				txtName.setFont(new Font("Roboto", Font.PLAIN, 15));
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtName, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelDVT = new JLabel("Đơn vị tính");
				gbcContent.gridx = 1;
				gbcContent.gridy = 0;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelDVT.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelDVT, gbcContent);

				gbcContent = new GridBagConstraints();
				String[] cacDVT = new String[] {"Gói", "Hộp", "Thùng"};
				CustomComboBox txtDVT = new CustomComboBox(cacDVT);
				gbcContent.gridx = 1;
				gbcContent.gridy = 1;
				gbcContent.fill = GridBagConstraints.HORIZONTAL;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 20, 0);
				txtDVT.setFont(new Font("Roboto", Font.PLAIN, 15));
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtDVT, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelSoLuong = new JLabel("Số lượng");
				gbcContent.gridx = 0;
				gbcContent.gridy = 2;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelSoLuong.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelSoLuong, gbcContent);

				gbcContent = new GridBagConstraints();
				CustomTextField txtSoLuong = new CustomTextField(15);
				txtSoLuong.setEditable(true);
				gbcContent.gridx = 0;
				gbcContent.gridy = 3;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 0, 0);
				txtSoLuong.setFont(new Font("Roboto", Font.PLAIN, 15));
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtSoLuong, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelDonGia = new JLabel("Đơn giá");
				gbcContent.gridx = 1;
				gbcContent.gridy = 2;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelDonGia.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelDonGia, gbcContent);

				gbcContent = new GridBagConstraints();
				CustomTextField txtDonGia = new CustomTextField(15);
				gbcContent.gridx = 1;
				gbcContent.gridy = 3;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 0, 0);
				txtDonGia.setFont(new Font("Roboto", Font.PLAIN, 15));
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtDonGia, gbcContent);

				gbcContent = new GridBagConstraints();
				CustomButton newGoodButton = new CustomButton("Thêm mới");
				CustomButton cancelButton = new CustomButton("Hủy bỏ");
				newGoodButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtName.getSelectedItem() == null || txtDVT.getSelectedItem() == null
								|| txtSoLuong.getText().equals("") || txtDonGia.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(!txtSoLuong.getText().matches("[0-9]+") || !txtDonGia.getText().matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng và đơn giá phải là số nguyên", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						int sum= Integer.parseInt(txtSoLuong.getText()) * Integer.parseInt(txtDonGia.getText());
						int num = Integer.parseInt(model.getValueAt(model.getRowCount() - 1, 0).toString());
						model.addRow(new Object[] { num + 1, txtName.getSelectedItem(), txtDVT.getSelectedItem(),
								txtSoLuong.getText(), txtDonGia.getText(), sum});
						String tongTienText = tongTienTextField.getText();
						tongTienText = tongTienText.replace("Tổng tiền: ", "").replace(" VND", "");
						int res = Integer.parseInt(tongTienText) + sum;
						tongTienTextField.setText("Tổng tiền: " + res + " VND");
						((Window) SwingUtilities.getRoot(panel)).dispose();
					}
				});
				gbcContent.gridx = 0;
				gbcContent.gridy = 4; // Adjust this to the last row
				gbcContent.anchor = GridBagConstraints.CENTER;
				gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
				panelContent.add(newGoodButton, gbcContent);

				gbcContent = new GridBagConstraints();
				gbcContent.gridx = 1;
				gbcContent.gridy = 4; // Adjust this to the last row
				gbcContent.anchor = GridBagConstraints.CENTER;
				gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((Window) SwingUtilities.getRoot(panel)).dispose();
					}
				});
				panelContent.add(cancelButton, gbcContent);

				panel.add(panelContent, gbc);
				JOptionPane.showOptionDialog(null, panel, "Thêm mặt hàng", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
			}
		});
		gbc1_2 = new GridBagConstraints();
		gbc1_2.gridy = 1;
		gbc1_2.anchor = GridBagConstraints.WEST;
		gbc1_2.gridx = 1;
		gbc1_2.weightx = 0.8;
		gbc1_2.insets = new Insets(0, 0, 5, 100);
		contentPane.add(themMatHangButton, gbc1_2);

		String[] columnNames = { "STT", "Tên mặt hàng", "Đơn vị tính", "Số lượng", "Đơn giá(VND)", "Thành tiền" };
		// Create data
		Object[][] data = { { 1, "Mặt hàng 1", "Chai", 3, 5000, 1000.0 }, { 2, "Mặt hàng 2", "lon", 2, 3000, 6000.0 },
				// Add more rows as needed
		};

		// this mode handles data in table
		model = new DefaultTableModel(data, columnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbcHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		tableNhapHang = new JTable(model);
		tableNhapHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer)tableNhapHang.getTableHeader().getDefaultRenderer()).setOpaque(false);
		tableNhapHang.getTableHeader().setOpaque(false);
		tableNhapHang.setShowVerticalLines(false);

		// Set font and alignment for table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableNhapHang.getColumnCount(); i++) {
			tableNhapHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
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
		contentPane.add(scrollPane, gbc_scrollPane);

		gbc1_3 = new GridBagConstraints();
		gbc1_3.gridx = 0;
		gbc1_3.anchor = GridBagConstraints.EAST;
		gbc1_3.fill = GridBagConstraints.HORIZONTAL;
		tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1_3.gridy = 3;
		gbc1_3.gridx = 1;
		gbc1_3.weightx = 0.3;
		gbc1_3.insets = new java.awt.Insets(10, 0, 0, 0);
		contentPane.add(tongTienTextField, gbc1_3);

		this.add(contentPane, gbc);

	}

}
