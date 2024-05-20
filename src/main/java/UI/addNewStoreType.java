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
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addNewStoreType extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int totaltype=0;

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
		setBounds(100, 100, 438, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		NumberFormat floatFormat = NumberFormat.getNumberInstance();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{208, 213, 0};
		gbl_contentPane.rowHeights = new int[]{79, 79, 36, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JLabel lblStoreType = new JLabel("Loại cửa hàng");
		GridBagConstraints gbc_lblStoreType = new GridBagConstraints();
		gbc_lblStoreType.anchor = GridBagConstraints.WEST;
		gbc_lblStoreType.fill = GridBagConstraints.VERTICAL;
		gbc_lblStoreType.insets = new Insets(0, 0, 5, 5);
		gbc_lblStoreType.gridx = 0;
		gbc_lblStoreType.gridy = 0;
		contentPane.add(lblStoreType, gbc_lblStoreType);
		JSpinner txtStoreType = new JSpinner(new SpinnerNumberModel(totaltype, totaltype, 100, 1));
		GridBagConstraints gbc_txtStoreType = new GridBagConstraints();
		gbc_txtStoreType.anchor = GridBagConstraints.EAST;
		gbc_txtStoreType.insets = new Insets(0, 0, 5, 0);
		gbc_txtStoreType.gridx = 1;
		gbc_txtStoreType.gridy = 0;
		contentPane.add(txtStoreType, gbc_txtStoreType);
		JLabel lblMaxLoan = new JLabel("Số tiền nợ tối đa");
		GridBagConstraints gbc_lblMaxLoan = new GridBagConstraints();
		gbc_lblMaxLoan.anchor = GridBagConstraints.WEST;
		gbc_lblMaxLoan.fill = GridBagConstraints.VERTICAL;
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
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnSave = new JButton("Lưu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totaltype = (int) txtStoreType.getValue();
				JOptionPane.showMessageDialog(null, "Đã lưu");
				dispose();
			}
		});
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancel);
		
	}

}
