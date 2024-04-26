package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 2.0, 1.0};
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
		
		JButton loginGoogle = new JButton("Đăng nhập với Google");
		GridBagConstraints gbc_loginGoogle = new GridBagConstraints();
		gbc_loginGoogle.fill = GridBagConstraints.BOTH;
		gbc_loginGoogle.insets = new Insets(0, 0, 5, 5);
		gbc_loginGoogle.gridx = 0;
		gbc_loginGoogle.gridy = 2;
		contentPane.add(loginGoogle, gbc_loginGoogle);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.fill = GridBagConstraints.BOTH;
		gbc_textField_email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_email.gridx = 0;
		gbc_textField_email.gridy = 4;
		contentPane.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_password = new JTextField();
		GridBagConstraints gbc_textField_password = new GridBagConstraints();
		gbc_textField_password.fill = GridBagConstraints.BOTH;
		gbc_textField_password.insets = new Insets(0, 0, 5, 5);
		gbc_textField_password.gridx = 0;
		gbc_textField_password.gridy = 6;
		contentPane.add(textField_password, gbc_textField_password);
		textField_password.setColumns(10);
		
		JPanel password_panel = new JPanel();
		GridBagConstraints gbc_password_panel = new GridBagConstraints();
		gbc_password_panel.insets = new Insets(0, 0, 0, 5);
		gbc_password_panel.fill = GridBagConstraints.BOTH;
		gbc_password_panel.gridx = 0;
		gbc_password_panel.gridy = 7;
		contentPane.add(password_panel, gbc_password_panel);
		password_panel.setLayout(new BorderLayout(0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ghi nhớ mật khẩu");
		password_panel.add(chckbxNewCheckBox, BorderLayout.WEST);
		JButton btn_forgot = new JButton("Quên mật khẩu");
		password_panel.add(btn_forgot, BorderLayout.EAST);
		
		JButton btn_login = new JButton("Đăng nhập");
		GridBagConstraints gbc_btn_login = new GridBagConstraints();
		gbc_btn_login.fill = GridBagConstraints.BOTH;
		gbc_btn_login.insets = new Insets(0, 0, 5, 5);
		gbc_btn_login.gridx = 0;
		gbc_btn_login.gridy = 8;
		contentPane.add(btn_login, gbc_btn_login);
		
		JButton btn_register = new JButton("Chưa đăng ký? Đăng ký ngay");
		GridBagConstraints gbc_btn_register = new GridBagConstraints();
		gbc_btn_register.fill = GridBagConstraints.BOTH;
		gbc_btn_register.insets = new Insets(0, 0, 5, 5);
		gbc_btn_register.gridx = 0;
		gbc_btn_register.gridy = 9;
		contentPane.add(btn_register, gbc_btn_register);
		
		ImageIcon icon = new ImageIcon("src/UI/logo.png");
		icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(login.class.getResource("/resource/login.png")));
		label.setLabelFor(contentPane);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		gbc_label.gridheight = 10;
		contentPane.add(label, gbc_label);
		
	}

}
