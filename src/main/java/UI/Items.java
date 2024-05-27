package UI;

import Controller.MatHangController;
import Models.mathang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

public class Items extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items();
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
	public Items() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		// Tạo một DefaultTableModel
		String[] columnNames = {"STT", "Mặt hàng", "Đơn giá nhập", "Đơn vị tính"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		MatHangController matHangController = new MatHangController();
		List<mathang> mathangList = matHangController.showMatHang();
		for (mathang mathang : mathangList) {
			tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, mathang.getTenmh(), mathang.getDongianhap(), mathang.getDvt().getTendvt()});
		}
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                addItem dialog = null;
                try {
                    dialog = new addItem();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});

		panel.add(btnAdd);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				dispose();
			}
			
		});
		panel.add(btnOk);
		// Trong class Items
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String currentPrice = (String) table.getValueAt(selectedRow, 2);
					EditPriceDialog dialog = new EditPriceDialog(currentPrice);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
					dialog.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							String newPrice = dialog.getNewPrice();
							if (newPrice != null) {
								table.setValueAt(newPrice, selectedRow, 3);
							}
						}
					});
				}
			}
		});
		panel.add(btnEdit);
		
		
	}
	public  static void addItemToTable(String name, String unit, String price) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {model.getRowCount() + 1, name, unit, price});
	}



}
