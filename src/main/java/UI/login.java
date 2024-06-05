package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Controller.UserLoginController;

import java.awt.GridLayout;
import java.awt.Image;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
					FlatIntelliJLaf.setup();
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
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 230, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{453, 453};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
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
		


		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				MainFrame mainFrame = new MainFrame();
//				mainFrame.setVisible(true);
//				dispose();
				boolean flag = true;
				String email = getTextField_email();
				String password = getPasswordField();
				// check if email or password is empty
				if(email.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(	login.this,"Email hoặc mật khẩu không được để trống");
					flag = false;
					return;
				}
				// check if email is valid
				if(!email.contains("@")) {
					JOptionPane.showMessageDialog(	login.this,"Email không hợp lệ");
					flag = false;
					return;
				}
				// check if password is valid
				if(password.length() < 8) {
					JOptionPane.showMessageDialog(	login.this,"Mật khẩu phải có ít nhất 8 ký tự");
					flag = false;
					return;
				}
				if(flag) {
					 // call controller to get user by email
					UserLoginController userLoginController;
					try {
						userLoginController = new UserLoginController(login.this);

						if(userLoginController.getUserByEmail(getTextField_email(),getPasswordField()).equals("Đăng nhập thành công")) {
							MainFrame mainFrame = new MainFrame();
							mainFrame.setVisible(true);
							mainFrame.setLocationRelativeTo(null);
							mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							dispose();
						}
                           
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
                   
			}
		});
		
		
		
		btn_login.setForeground(new Color(255, 255, 255));
		btn_login.setBackground(new Color(16, 21, 64));
		GridBagConstraints gbc_btn_login = new GridBagConstraints();
		gbc_btn_login.fill = GridBagConstraints.BOTH;
		gbc_btn_login.insets = new Insets(0, 0, 5, 5);
		gbc_btn_login.gridx = 0;
		gbc_btn_login.gridy = 8;
		contentPane.add(btn_login, gbc_btn_login);
		


		
		JLabel label = new JLabel();
		label.setLabelFor(contentPane);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		gbc_label.gridheight = 10;
		contentPane.add(label, gbc_label);
		label.setPreferredSize(new java.awt.Dimension(453, 550));
		// Tạo ImageIcon từ đường dẫn của ảnh
		Image scaledImage = new ImageIcon("src/main/java/resource/login.png").getImage().getScaledInstance(453, 550, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		// Đặt ImageIcon cho JLabel
		label.setIcon(new ImageIcon("src/main/java/resource/login.png"));
	}


	public String getTextField_email() {
        return textField_email.getText();
    }

	public String getPasswordField() {
		return new String(passwordField.getPassword());
	}
}
