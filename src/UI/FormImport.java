package UI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormImport extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FormImport() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JPanel panelHeader = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		panelHeader.setLayout(new GridBagLayout());
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 1;
		gbcHeader.weighty = 1;
		gbcHeader.anchor = GridBagConstraints.WEST;
		JLabel headerLable = new JLabel("Nhập Hàng");
		headerLable.setFont(new Font("Roboto", Font.BOLD, 30));
		panelHeader.add(headerLable, gbcHeader);

		this.add(panelHeader, gbc);

		JPanel panelContent = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.8;
		panelContent.setLayout(new GridBagLayout());
		GridBagConstraints gbcContent = new GridBagConstraints();

		JTextField txtName = new JTextField(15);
		gbcContent.gridx = 0;
		gbcContent.gridy = 0;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.3;
		gbcContent.anchor = GridBagConstraints.WEST;
		panelContent.add(txtName, gbcContent);

		gbcContent = new GridBagConstraints();
		JTextField txtSoLuong = new JTextField(15);
		gbcContent.gridx = 1;
		gbcContent.gridy = 0;
		gbcContent.weightx = 0.5;
		gbcContent.weighty = 0.3;
		gbcContent.anchor = GridBagConstraints.EAST;
		panelContent.add(txtSoLuong, gbcContent);

		this.add(panelContent, gbc);
	}

}
