package UI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		setBounds(100, 100, 450, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		NumberFormat floatFormat = NumberFormat.getNumberInstance();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{213, 213, 0};
		gbl_contentPane.rowHeights = new int[]{84, 84, 84, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JLabel lblStoreType = new JLabel("Loại cửa hàng");
		
			
		
				GridBagConstraints gbc_lblStoreType = new GridBagConstraints();
				gbc_lblStoreType.fill = GridBagConstraints.BOTH;
				gbc_lblStoreType.insets = new Insets(0, 0, 5, 5);
				gbc_lblStoreType.gridx = 0;
				gbc_lblStoreType.gridy = 0;
				contentPane.add(lblStoreType, gbc_lblStoreType);
		JFormattedTextField txtStoreType = new JFormattedTextField(intFormat);
		GridBagConstraints gbc_txtStoreType = new GridBagConstraints();
		gbc_txtStoreType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStoreType.insets = new Insets(0, 0, 5, 0);
		gbc_txtStoreType.gridx = 1;
		gbc_txtStoreType.gridy = 0;
		contentPane.add(txtStoreType, gbc_txtStoreType);
		JLabel lblMaxLoan = new JLabel("Số tiền nợ tối đa");
		GridBagConstraints gbc_lblMaxLoan = new GridBagConstraints();
		gbc_lblMaxLoan.fill = GridBagConstraints.BOTH;
		gbc_lblMaxLoan.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxLoan.gridx = 0;
		gbc_lblMaxLoan.gridy = 1;
		contentPane.add(lblMaxLoan, gbc_lblMaxLoan);
		JFormattedTextField txtMaxLoan = new JFormattedTextField(floatFormat);
		GridBagConstraints gbc_txtMaxLoan = new GridBagConstraints();
		gbc_txtMaxLoan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxLoan.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaxLoan.gridx = 1;
		gbc_txtMaxLoan.gridy = 1;
		contentPane.add(txtMaxLoan, gbc_txtMaxLoan);
		JButton btnSave = new JButton("Lưu");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 2;
		contentPane.add(btnSave, gbc_btnSave);
		JButton btnCancel = new JButton("Hủy");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 2;
		contentPane.add(btnCancel, gbc_btnCancel);
		
	}

}
