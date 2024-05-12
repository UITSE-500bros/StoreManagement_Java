package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class FormImport extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> txtName;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JComboBox<String> txtDVT;

	/**
	 * Create the panel.
	 */
	public FormImport() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		panelHeader.setLayout(new GridBagLayout());
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 1;
		gbcHeader.weighty = 1;
		gbcHeader.fill = GridBagConstraints.BOTH;
		gbcHeader.anchor = GridBagConstraints.WEST;
		gbcHeader.insets = new Insets(0, 20, 0, 0);
		JLabel headerLable = new JLabel("Thêm mặt hàng");
		headerLable.setFont(new Font("Roboto", Font.BOLD, 20));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		JPanel panelContent = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.8;
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
		txtName = new JComboBox<String>(cacMatHang);
		gbcContent.fill = GridBagConstraints.HORIZONTAL;
		gbcContent.gridx = 0;
		gbcContent.gridy = 1;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.4;
		gbcContent.insets = new Insets(0, 20, 0, 0);
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
		txtDVT = new JComboBox<String>(cacDVT);
		gbcContent.gridx = 1;
		gbcContent.gridy = 1;
		gbcContent.fill = GridBagConstraints.HORIZONTAL;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.4;
		gbcContent.insets = new Insets(0, 20, 0, 0);
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
		txtSoLuong = new JTextField(15);
		txtSoLuong.setEditable(true);
		gbcContent.gridx = 0;
		gbcContent.gridy = 3;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.4;
		gbcContent.insets = new Insets(0, 20, 0, 0);
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
		txtDonGia = new JTextField(15);
		gbcContent.gridx = 1;
		gbcContent.gridy = 3;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.4;
		gbcContent.insets = new Insets(0, 20, 0, 0);
		txtDonGia.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
		panelContent.add(txtDonGia, gbcContent);

		gbcContent = new GridBagConstraints();
		JButton addButton = new JButton("Thêm mới");
		gbcContent.gridx = 0;
		gbcContent.gridy = 4; // Adjust this to the last row
		gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
		panelContent.add(addButton, gbcContent);

		gbcContent = new GridBagConstraints();
		JButton cancelButton = new JButton("Hủy bỏ");
		gbcContent.gridx = 1;
		gbcContent.gridy = 4; // Adjust this to the last row
		gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
		panelContent.add(cancelButton, gbcContent);

		this.add(panelContent, gbc);
	}

	public String getTxtName() {
		return txtName.getSelectedItem().toString();
	}

	public String getTxtSoLuong() {
		return txtSoLuong.getText();
	}

	public String getTxtDonGia() {
		return txtDonGia.getText();
	}

	public String getTxtDVT() {
		return txtDVT.getSelectedItem().toString();
	}

	public void setTxtName(String name) {
		txtName.setSelectedItem(name);
	}

	public void setTxtSoLuong(String soLuong) {
		txtSoLuong.setText(soLuong);
	}

	public void setTxtDonGia(String donGia) {
		txtDonGia.setText(donGia);
	}

	public void setTxtDVT(String dvt) {
		txtDVT.setSelectedItem(dvt);
	}

}
