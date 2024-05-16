package UI;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GeneralSetting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralSetting frame = new GeneralSetting();
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
	public GeneralSetting() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{193, 193, 0};
		gbl_contentPane.rowHeights = new int[]{43, 43, 43, 43, 43, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLastName = new JLabel("Họ và tên đệm");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.BOTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 0;
		contentPane.add(lblLastName, gbc_lblLastName);
		JTextField txtFirstName = new JTextField();
		JTextField txtLastName = new JTextField();
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.fill = GridBagConstraints.BOTH;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.gridx = 1;
		gbc_txtLastName.gridy = 0;
		contentPane.add(txtLastName, gbc_txtLastName);
		JLabel lblFirstName = new JLabel("Tên");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.BOTH;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.fill = GridBagConstraints.BOTH;
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstName.gridx = 1;
		gbc_txtFirstName.gridy = 1;
		contentPane.add(txtFirstName, gbc_txtFirstName);
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		contentPane.add(lblEmail, gbc_lblEmail);
		JTextField txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 2;
		contentPane.add(txtEmail, gbc_txtEmail);
		JLabel lblPhone = new JLabel("Số điện thoại");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 3;
		contentPane.add(lblPhone, gbc_lblPhone);
		JTextField txtPhone = new JTextField();
		
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.BOTH;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 3;
		contentPane.add(txtPhone, gbc_txtPhone);
		JButton btnSave = new JButton("Lưu");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 4;
		contentPane.add(btnSave, gbc_btnSave);
		
				btnSave.addActionListener(e -> {
					if(txtLastName.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPhone.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
						return;
					} 
					if (!txtEmail.getText().contains("@")) {
						JOptionPane.showMessageDialog(null, "Email không hợp lệ");
						return;
					}
					if (!txtPhone.getText().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
						return;
					}
			
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				});
		
				JButton btnCancel = new JButton("Hủy");
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.gridx = 1;
				gbc_btnCancel.gridy = 4;
				contentPane.add(btnCancel, gbc_btnCancel);
				btnCancel.addActionListener(e -> {
					txtLastName.setText("");
					txtFirstName.setText("");
					txtEmail.setText("");
					txtPhone.setText("");
					this.dispose();
				});
		setContentPane(contentPane);
	}

}
