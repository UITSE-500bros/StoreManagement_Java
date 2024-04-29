package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class importPanel extends JPanel {

	private static final long serialVersionUID = 1L;

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
		headerLable.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 44));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.8;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 }; // 3 columns
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 }; // 5 rows
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE }; // No extra horizontal space
		gbl_contentPane.rowWeights = new double[] { 0.1, 0.1, 0.7, 0.1, Double.MIN_VALUE }; // Weights for rows
		contentPane.setLayout(gbl_contentPane);

		// For components in row 1 and 2, you need to set GridBagConstraints for each
		// component
		GridBagConstraints gbc1 = new GridBagConstraints();

		JLabel pnhLable = new JLabel("Phiếu Nhập Hàng");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 30));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		gbc1 = new GridBagConstraints();
		JButton addButton = new JButton("Add");
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setFont(new Font("Roboto", Font.BOLD, 20));
		gbc1.gridx = 1;
		gbc1.weightx = 0.2;
		gbc1.anchor = GridBagConstraints.EAST;
		contentPane.add(addButton, gbc1);

		gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;
		JTextField maSoPhieuTextField = new JTextField(10);
		maSoPhieuTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		gbc1.weightx = 0.2;
		contentPane.add(maSoPhieuTextField, gbc1);

		gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;

		gbc1.gridx = 1;
		gbc1.weightx = 0.8;
		contentPane.add(datePicker, gbc1);

		JTable tableNhapHang = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Tên mặt hàng");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá(VND)");
		model.addColumn("Thành tiền");
		tableNhapHang.setModel(model);

		tableNhapHang.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableNhapHang.getColumnModel().getColumn(0).setResizable(true);
		tableNhapHang.getColumnModel().getColumn(1).setPreferredWidth(90);
		tableNhapHang.getColumnModel().getColumn(1).setResizable(true);
		tableNhapHang.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableNhapHang.getColumnModel().getColumn(2).setResizable(true);
		tableNhapHang.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableNhapHang.getColumnModel().getColumn(3).setResizable(false);
		tableNhapHang.getColumnModel().getColumn(4).setPreferredWidth(90);
		tableNhapHang.getColumnModel().getColumn(4).setResizable(false);

		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridx = 0;
		gbc1.gridwidth = 2; // Span across 2 columns
		gbc1.gridy = 2;
		gbc1.weightx = 1.0;
		contentPane.add(tableNhapHang, gbc1);

		gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.EAST;
		JTextField tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1.gridy = 3;
		gbc1.gridwidth = 2; // Span across 2 columns
		contentPane.add(tongTienTextField, gbc1);

		this.add(contentPane, gbc);

	}

}
