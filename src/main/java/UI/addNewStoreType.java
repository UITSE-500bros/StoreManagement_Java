package UI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class addNewStoreType extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewStoreType frame = new addNewStoreType();
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
	public addNewStoreType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));

		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		NumberFormat floatFormat = NumberFormat.getNumberInstance();
		JLabel lblStoreType = new JLabel("Loại cửa hàng");
		JFormattedTextField txtStoreType = new JFormattedTextField(intFormat);
		JLabel lblMaxLoan = new JLabel("Số tiền nợ tối đa");
		JFormattedTextField txtMaxLoan = new JFormattedTextField(floatFormat);

	

		contentPane.add(lblStoreType);
		contentPane.add(txtStoreType);
		contentPane.add(lblMaxLoan);
		contentPane.add(txtMaxLoan);
		JButton btnSave = new JButton("Lưu");
		contentPane.add(btnSave);
		JButton btnCancel = new JButton("Hủy");
		contentPane.add(btnCancel);
		
	}

}
