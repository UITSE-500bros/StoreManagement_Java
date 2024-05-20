package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controller.MatHangController;
import Models.mathang;
import ReuseClass.DatePicker;

public class importPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTextField tongTienTextField;
	private ArrayList<Object> matHangs;
	private GridBagConstraints gbc1_1;
	private GridBagConstraints gbc1_2;
	private GridBagConstraints gbc1_3;
	private GridBagConstraints gbc1_4;
	private CustomButton addButton;
	private DatePicker datePicker;
	private JTable tableNhapHang;
	private DefaultTableModel model;
	private MatHangController matHangController;

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

		loadData();

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

		Panel panelButtons = new Panel();
		panelButtons.setLayout(new GridBagLayout());
		GridBagConstraints gbcBtns = new GridBagConstraints();
		gbcBtns.gridx = 0;
		gbcBtns.gridy = 0;
		gbcBtns.weightx = 0.15;
		gbcBtns.insets = new Insets(10, 0, 0, 0);
		gbcBtns.anchor = GridBagConstraints.WEST;

		datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));

		panelButtons.add(datePicker, gbcBtns);

		gbcBtns = new GridBagConstraints();
		gbcBtns.gridy = 0;
		gbcBtns.gridx = 1;
		gbcBtns.weightx = 0.15;
		gbcBtns.insets = new Insets(0, 10, 0, 0);
		gbcBtns.anchor = GridBagConstraints.CENTER;
		JButton themMatHangButton = new CustomButton("Thêm mặt hàng");
		themMatHangButton.setPreferredSize(new Dimension(150, 30));
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
				CustomComboBox txtName = new CustomComboBox(matHangs.toArray());
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
				txtDonGia.setEditable(true);
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
						int num = model.getRowCount();
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
		panelButtons.add(themMatHangButton, gbcBtns);

		addButton = new CustomButton("Lập phiếu");
		addButton.setPreferredSize(new Dimension(150, 30));  // Preferred size
		addButton.setMinimumSize(new Dimension(150, 30));    // Minimum size
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/lapPhieuIcon.png");
		addButton.setIcon(lapPhieuIcon);
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setIconTextGap(20);
		addButton.setHorizontalAlignment(JButton.LEFT);
		addButton.setHorizontalTextPosition(JButton.RIGHT);
		addButton.setFont(new Font("Roboto", Font.BOLD, 15));

		gbcBtns = new GridBagConstraints();
		gbcBtns.gridx = 2;
		gbcBtns.gridy = 0;
		gbcBtns.weightx = 0.15;
		gbcBtns.insets = new Insets(0, 10, 0, 0);
		gbcBtns.anchor = GridBagConstraints.EAST;
		panelButtons.add(addButton, gbcBtns);

		gbc1_4 = new GridBagConstraints();
		gbc1_4.gridx = 0;
		gbc1_4.gridy = 1;
		gbc1_4.gridwidth = 2;
		gbc1_4.weightx = 1;
		gbc1_4.fill = GridBagConstraints.BOTH;
		contentPane.add(panelButtons, gbc1_4);

		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("STT");
		model.addColumn("Tên mặt hàng");
		model.addColumn("Đơn vị tính");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá(VND)");
		model.addColumn("Thành tiền");

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
		gbc1_3.fill = GridBagConstraints.HORIZONTAL;
		gbc1_3.anchor = GridBagConstraints.EAST;
		tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setPreferredSize(new Dimension(350, 30));
		tongTienTextField.setMinimumSize(new Dimension(350, 30));
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbc1_3.gridy = 3;
		gbc1_3.gridx = 1;
		gbc1_3.weightx = 0.2;
		gbc1_3.insets = new java.awt.Insets(10, 30, 0, 0);
		contentPane.add(tongTienTextField, gbc1_3);

		this.add(contentPane, gbc);

	}

	public void loadData(){
		matHangController = new MatHangController();
		List<mathang> list = null;
		try {
			list = new MatHangController().showMatHang();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		matHangs = new ArrayList<>();
		for(mathang mh : list) {
			matHangs.add(mh.getTenmh());
		}
	}

}
