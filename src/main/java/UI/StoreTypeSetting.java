package UI;

import Controller.LoaiDaiLyController;
import Models.loaidaily;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StoreTypeSetting extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StoreTypeSetting dialog = new StoreTypeSetting();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StoreTypeSetting() throws IOException {
		setBounds(100, 100, 320, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{149, 33,  0};
		gbl_contentPanel.rowHeights = new int[]{13, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		// Get all store types
		LoaiDaiLyController loaidailyController = new LoaiDaiLyController();
		List<loaidaily> loaidailyList = loaidailyController.showLoaiDaiLy();

		JLabel lblNewLabel = new JLabel("Loại đại lý");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);


		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for (loaidaily loaidaily : loaidailyList) {
			model.addElement(loaidaily.getTenloaidl());
		}
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(model);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		contentPanel.add(comboBox, gbc_comboBox);

		JLabel lblNewLabel_1 = new JLabel("Tiền nợ tối đa");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, 30)); // Set fixed size for the text field
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		comboBox.addActionListener(e -> {
			String selected = (String) comboBox.getSelectedItem();
			for (loaidaily loaidaily : loaidailyList) {
				if (loaidaily.getTenloaidl().equals(selected)) {
					textField.setText(String.valueOf(loaidaily.getNotoida()));
				}
			}
		});

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setPreferredSize(new Dimension(80, 30)); // Set fixed size for the button
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(80, 30)); // Set fixed size for the button
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		okButton.addActionListener(e -> {
			String selected = (String) comboBox.getSelectedItem();
			for (loaidaily loaidaily : loaidailyList) {
				if (loaidaily.getTenloaidl().equals(selected)) {
					textField.setText(String.valueOf(loaidaily.getNotoida()));
				}
			}

			loaidaily loaidaily = new loaidaily();
			loaidaily.setTenloaidl((String) comboBox.getSelectedItem());
			loaidaily.setNotoida(Integer.parseInt(textField.getText()));

			LoaiDaiLyController loaidailyController1 = new LoaiDaiLyController();
			loaidailyController1.updateLoaiDaiLy(loaidaily);
			JOptionPane.showMessageDialog(null, "Cập nhật thành công");
		});
		cancelButton.addActionListener(e -> {
			dispose();
		});
	}
}
