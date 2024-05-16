package UI;

import Controller.UserRegisterController;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_email;
	private JTextField textField_lastName;
	private JTextField textField_phoneNumber;
	private JTextField textField_password;
	private JTextField textField_rePassWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public String getTextField_name() {
        return textField_name.getText();
    }

	public String getTextField_email() {
		return textField_email.getText();
	}

	public String getTextField_lastName() {
        return textField_lastName.getText();
    }
	
	public String getTextField_phoneNumber() {
		return textField_phoneNumber.getText();
	}

	public String getTextField_password() {
		return textField_password.getText();
	}

	public String getTextField_rePassWord() {
		return textField_rePassWord.getText();
	}
	
	public register() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(register.class.getResource("/resource/register.png")));
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(241, 235, 229));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{254, 254, 0};
		gbl_panel.rowHeights = new int[]{60, 0, 60, 60, 60, 60, 60, 60, 60, };
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng ký tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quản lý các đại lý của bạn một cách hiệu quả");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Họ và tên đệm");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tên");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_lastName = new JTextField();
		GridBagConstraints gbc_textField_lastName = new GridBagConstraints();
		gbc_textField_lastName.fill = GridBagConstraints.BOTH;
		gbc_textField_lastName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_lastName.gridx = 0;
		gbc_textField_lastName.gridy = 3;
		panel.add(textField_lastName, gbc_textField_lastName);
		textField_lastName.setColumns(10);
		
		textField_name = new JTextField();
		GridBagConstraints gbc_textField_name = new GridBagConstraints();
		gbc_textField_name.fill = GridBagConstraints.BOTH;
		gbc_textField_name.insets = new Insets(0, 0, 5, 0);
		gbc_textField_name.gridx = 1;
		gbc_textField_name.gridy = 3;
		panel.add(textField_name, gbc_textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Số điện thoại");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 4;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.fill = GridBagConstraints.BOTH;
		gbc_textField_email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_email.gridx = 0;
		gbc_textField_email.gridy = 5;
		panel.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		textField_phoneNumber = new JTextField();
		GridBagConstraints gbc_textField_phoneNumber = new GridBagConstraints();
		gbc_textField_phoneNumber.fill = GridBagConstraints.BOTH;
		gbc_textField_phoneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_textField_phoneNumber.gridx = 1;
		gbc_textField_phoneNumber.gridy = 5;
		panel.add(textField_phoneNumber, gbc_textField_phoneNumber);
		textField_phoneNumber.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mật khẩu");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 6;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nhập lại mật khẩu");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 6;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_password = new JTextField();
		GridBagConstraints gbc_textField_password = new GridBagConstraints();
		gbc_textField_password.fill = GridBagConstraints.BOTH;
		gbc_textField_password.insets = new Insets(0, 0, 5, 5);
		gbc_textField_password.gridx = 0;
		gbc_textField_password.gridy = 7;
		panel.add(textField_password, gbc_textField_password);
		textField_password.setColumns(10);
		
		textField_rePassWord = new JTextField();
		GridBagConstraints gbc_textField_rePassWord = new GridBagConstraints();
		gbc_textField_rePassWord.fill = GridBagConstraints.BOTH;
		gbc_textField_rePassWord.insets = new Insets(0, 0, 5, 0);
		gbc_textField_rePassWord.gridx = 1;
		gbc_textField_rePassWord.gridy = 7;
		panel.add(textField_rePassWord, gbc_textField_rePassWord);
		textField_rePassWord.setColumns(10);
				
		JButton btn_register = new JButton("Đăng ký");
		GridBagConstraints gbc_btn_register = new GridBagConstraints();
		gbc_btn_register.fill = GridBagConstraints.BOTH;
		gbc_btn_register.insets = new Insets(0, 0, 5, 5);
		gbc_btn_register.gridx = 0;
		gbc_btn_register.gridy = 8;
		gbc_btn_register.gridwidth = 2;
		panel.add(btn_register, gbc_btn_register);

		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegisterController userRegisterController = new UserRegisterController(register.this);
                try {
                    userRegisterController.registerUser();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }

            }
		});



		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag = true;
				// Check if any field is empty
				if (textField_name.getText().isEmpty() || textField_lastName.getText().isEmpty() ||
						textField_email.getText().isEmpty() || textField_phoneNumber.getText().isEmpty() ||
						textField_password.getText().isEmpty() || textField_rePassWord.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng không để trống bất kỳ trường nào.");
					flag = false;
					return;
				}

				// Check if email contains '@'
				if (!textField_email.getText().contains("@")) {
					JOptionPane.showMessageDialog(null, "Email không hợp lệ. Vui lòng kiểm tra lại.");
					flag = false;
					return;
				}

				// Check if password matches re-entered password
				if (!textField_password.getText().equals(textField_rePassWord.getText())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp. Vui lòng kiểm tra lại.");
					flag = false;
					return;
				}
				if(textField_phoneNumber.getText().length() != 10){
					JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng kiểm tra lại.");
					flag = false;
					return;
				}

				if(textField_password.getText().length()<8){
					JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 8 ký tự.");
					flag = false;
					return;
				}

				if(flag){
					UserRegisterController userRegisterController = new UserRegisterController(register.this);
					try {
						if(userRegisterController.registerUser())
						{
							JOptionPane.showMessageDialog(null, "Đăng ký thành công");
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng ký thất bại");
						}
						
					} catch (MalformedURLException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		});
		
		setLocationRelativeTo(null);
		
	}
}
