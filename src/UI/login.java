package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * 
	 * 
	 */
	

	
	public login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 230, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{453, 453, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 2.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Theo dõi các chi nhánh của bạn");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		ImageIcon icon_google = new ImageIcon("src/UI/google.png");
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.fill = GridBagConstraints.BOTH;
		gbc_textField_email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_email.gridx = 0;
		gbc_textField_email.gridy = 3;
		contentPane.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 5;
		contentPane.add(passwordField, gbc_passwordField);
		
		JPanel password_panel = new JPanel();
		password_panel.setBackground(new Color(238, 230, 224));
		GridBagConstraints gbc_password_panel = new GridBagConstraints();
		gbc_password_panel.insets = new Insets(0, 0, 5, 5);
		gbc_password_panel.fill = GridBagConstraints.BOTH;
		gbc_password_panel.gridx = 0;
		gbc_password_panel.gridy = 6;
		contentPane.add(password_panel, gbc_password_panel);
		password_panel.setLayout(new BorderLayout(0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ghi nhớ mật khẩu");
		password_panel.add(chckbxNewCheckBox, BorderLayout.WEST);
		JButton btn_forgot = new JButton("Quên mật khẩu");
		btn_forgot.setBackground(new Color(238, 230, 224));
		password_panel.add(btn_forgot, BorderLayout.EAST);
		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.setForeground(new Color(255, 255, 255));
		btn_login.setBackground(new Color(16, 21, 64));
		GridBagConstraints gbc_btn_login = new GridBagConstraints();
		gbc_btn_login.fill = GridBagConstraints.BOTH;
		gbc_btn_login.insets = new Insets(0, 0, 5, 5);
		gbc_btn_login.gridx = 0;
		gbc_btn_login.gridy = 8;
		contentPane.add(btn_login, gbc_btn_login);
		
		JButton btn_register = new JButton("Chưa đăng ký? Đăng ký ngay");
		GridBagConstraints gbc_btn_register = new GridBagConstraints();
		gbc_btn_register.fill = GridBagConstraints.BOTH;
		gbc_btn_register.insets = new Insets(0, 0, 0, 5);
		gbc_btn_register.gridx = 0;
		gbc_btn_register.gridy = 9;
		contentPane.add(btn_register, gbc_btn_register);
		
		ImageIcon icon_background = new ImageIcon("src/UI/logo.png");
		icon_background.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(login.class.getResource("/resource/login.png")));
		label.setLabelFor(contentPane);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		gbc_label.gridheight = 10;
		contentPane.add(label, gbc_label);
		
		
	}


	public String getTextField_email() {
        return textField_email.getText();
    }

	public String getPasswordField() {
		return passwordField.getPassword().toString();
	}
}
