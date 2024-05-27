package UI;

import Controller.DVTController;
import Controller.MatHangController;
import Models.dvt;
import Models.mathang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.awt.GridLayout;

public class addItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_name;
	private JTextField textField_importPrice;
	private JComboBox cmb_units;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addItem dialog = new addItem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getName() {

		return textField_name.getText();
	}
	public int getImportPrice() {
		try{
		return Integer.parseInt(textField_importPrice.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Đơn giá nhập không hợp lệ");
			return -1;
		}
	}
	public String getUnit() {
		return (String) cmb_units.getSelectedItem();
	}
	
	

	/**
	 * Create the dialog.
	 */

	public addItem() throws IOException {
		setBounds(100, 100, 451, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{213, 213, 0};
		gbl_contentPanel.rowHeights = new int[]{41, 41, 41, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Tên mặt hàng");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField_name = new JTextField();
			GridBagConstraints gbc_textField_name = new GridBagConstraints();
			gbc_textField_name.fill = GridBagConstraints.BOTH;
			gbc_textField_name.insets = new Insets(0, 0, 5, 0);
			gbc_textField_name.gridx = 1;
			gbc_textField_name.gridy = 0;
			contentPanel.add(textField_name, gbc_textField_name);
			textField_name.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Đơn giá nhập");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textField_importPrice = new JTextField();
			GridBagConstraints gbc_textField_importPrice = new GridBagConstraints();
			gbc_textField_importPrice.fill = GridBagConstraints.BOTH;
			gbc_textField_importPrice.insets = new Insets(0, 0, 5, 0);
			gbc_textField_importPrice.gridx = 1;
			gbc_textField_importPrice.gridy = 1;
			contentPanel.add(textField_importPrice, gbc_textField_importPrice);
			textField_importPrice.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Đơn vị tính");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			 cmb_units = new JComboBox();
			DVTController dvtController = new DVTController();
			List<dvt> dvtList = null;
            try {
				dvtList = dvtController.showDVT();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
			for (dvt dvt : dvtList) {
			cmb_units.addItem(dvt.getTendvt());
		}

            GridBagConstraints gbc_cmb_units = new GridBagConstraints();
			gbc_cmb_units.fill = GridBagConstraints.BOTH;
			gbc_cmb_units.gridx = 1;
			gbc_cmb_units.gridy = 2;
			contentPanel.add(cmb_units, gbc_cmb_units);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				//
				okButton.addActionListener(e -> {
					String name = getName();
					String importPrice =String.valueOf(getImportPrice());
					String unit = (String) cmb_units.getSelectedItem();
					if(name.isEmpty()||importPrice.isEmpty()||unit.isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
						return;
					}

					mathang mathang = new mathang();
					mathang.setTenmh(name);
					mathang.setDongianhap(getImportPrice());
					mathang.setDvt(new dvt(unit));


		            // add item to table
					Items.addItemToTable(name, importPrice, unit);
					MatHangController matHangController = new MatHangController();
					if(matHangController.addNewMatHang(mathang).contains("201")){

					}else{

					}

					this.dispose();
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(e -> {
					this.dispose();
				});
				buttonPane.add(cancelButton);
			}
		}
	}


}
