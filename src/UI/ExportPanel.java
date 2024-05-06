package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ReuseClass.DatePicker;

public class ExportPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ExportPanel() {
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
		JLabel headerLable = new JLabel("XUẤT HÀNG");
		headerLable.setBorder(new EmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 44));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.8;
		gbc.weightx = 1;
		gbc.insets = new java.awt.Insets(30, 40, 40, 30);
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

		JLabel pnhLable = new JLabel("Phiếu Xuất Hàng");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 30));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		gbc1 = new GridBagConstraints();
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setFont(new Font("Roboto", Font.BOLD, 20));
		gbc1.gridx = 1;
		gbc1.weightx = 0.2;
		gbc1.anchor = GridBagConstraints.EAST;
		gbc1.insets = new java.awt.Insets(0, 30, 0, 30);
		contentPane.add(addButton, gbc1);

		gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;
		JTextField maSoPhieuTextField = new JTextField(10);
		maSoPhieuTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		gbc1.weightx = 0.1;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(maSoPhieuTextField, gbc1);

		DatePicker datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;
		gbc1.gridx = 1;
		gbc1.weightx = 0.9;
		gbc1.insets = new java.awt.Insets(0, 0, 0, 100);
		contentPane.add(datePicker, gbc1);

		String[] columnNames = { "STT", "Tên mặt hàng", "Số lượng", "Đơn giá(VND)", "Thành tiền" };
		// Create data
		Object[][] data = { { 1, "Mặt hàng 1", 3, 5000, 1000.0 }, { 2, "Mặt hàng 2", 2, 3000, 6000.0 },
				// Add more rows as needed
		};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable tableNhapHang = new JTable(model);
		((DefaultTableCellRenderer) tableNhapHang.getDefaultRenderer(Object.class)).setOpaque(false);
		tableNhapHang.setFont(new Font("Roboto", Font.PLAIN, 10));
		TableColumnModel columnModel = tableNhapHang.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(1).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.4)); // 40%
		columnModel.getColumn(2).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(3).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.2)); // 20%
		columnModel.getColumn(4).setPreferredWidth((int) (tableNhapHang.getWidth() * 0.2)); // 20%

		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		gbc1.gridwidth = 2; // Span across 2 columns
		gbc1.weightx = 1.0;
		gbc1.insets = new java.awt.Insets(10, 0, 0, 0);
		contentPane.add(tableNhapHang, gbc1);

		// For tienTraTextField
		JPanel panel2Tien = new JPanel();
		panel2Tien.setBackground(new Color(255, 249, 243, 180));
		panel2Tien.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel2Tien.setLayout(new GridBagLayout());
		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridy = 3;
		gbc1.gridx = 0;
		gbc1.gridwidth = 2;

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.WEST;
		JTextField tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbc2.gridx = 0;
		gbc2.weightx = 0.33; // Adjusted weight
		panel2Tien.add(tongTienTextField, gbc2);

		gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.CENTER;
		JTextField tienTraTextField = new JTextField(15);
		tienTraTextField.setEditable(false);
		tienTraTextField.setText("Số tiền trả: 0 VND");
		tienTraTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbc2.gridx = 1;
		gbc2.weightx = 0.33; // Adjusted weight
		panel2Tien.add(tienTraTextField, gbc2);

		// For tienConLaiTextField
		gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.EAST;
		JTextField tienConLaiTextField = new JTextField(15);
		tienConLaiTextField.setEditable(false);
		tienConLaiTextField.setText("Còn lại: 0 VND");
		tienConLaiTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbc2.gridx = 2;
		gbc2.weightx = 0.33;
		panel2Tien.add(tienConLaiTextField, gbc2);

		contentPane.add(panel2Tien, gbc1);

		this.add(contentPane, gbc);

	}

}
