package UI;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
		
		JLabel lblLastName = new JLabel("Họ và tên đệm");
		JTextField txtLastName = new JTextField();
		JLabel lblFirstName = new JLabel("Tên");
		JTextField txtFirstName = new JTextField();
		JLabel lblEmail = new JLabel("Email");
		JTextField txtEmail = new JTextField();
		JLabel lblPhone = new JLabel("Số điện thoại");
		JTextField txtPhone = new JTextField();
		JButton btnSave = new JButton("Lưu");
		
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(lblLastName);
		contentPane.add(txtLastName);
		contentPane.add(lblFirstName);
		contentPane.add(txtFirstName);
		contentPane.add(lblEmail);
		contentPane.add(txtEmail);
		contentPane.add(lblPhone);
		contentPane.add(txtPhone);
		contentPane.add(btnSave);
		
		
		
		

		setContentPane(contentPane);
		
		JButton btnCancel = new JButton("Hủy");
		contentPane.add(btnCancel);
	}

}
