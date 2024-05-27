package UI;

import Controller.DVTController;
import Models.dvt;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.List;

public class Unit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<dvt> units;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unit frame = new Unit();
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
	public Unit() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		DVTController dvtController = new DVTController();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Đơn vị tính");
		units = dvtController.showDVT();
		for (dvt unit : units) {
			model.addRow(new Object[] {model.getRowCount()+1, unit.getTendvt()});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(e -> {
			String unit = JOptionPane.showInputDialog("Nhập đơn vị tính");
			if (unit != null) {
				dvtController.addNewDVT(new dvt(unit));
				model.addRow(new Object[] {model.getRowCount()+1, unit});
			}
		});
		panel.add(btnAdd);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(e -> {
			this.dispose();
		});
		panel.add(btnOk);

	}

}
