package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JScrollPane;

public class reportPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					reportPanel frame = new reportPanel();
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
	public reportPanel() {



		this.setBorder(new EmptyBorder(5, 5, 5, 5));

;
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(reportPanel.class.getResource("/resource/searchStoreIcon 1.png")));
		btnNewButton.setPreferredSize(new Dimension(30, 30));


		panel.add(btnNewButton, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(24, 29));
		textField.setPreferredSize(new Dimension(300, 30));
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(150, 30));
		String[] reportType = {"Báo cáo công nợ", "Báo cáo doanh số"};
		for (String type : reportType) {
			comboBox.addItem(type);
		}

		
		panel.add(comboBox, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "\u0110\u1EA1i l\u00FD", "S\u1ED1 phi\u1EBFu xu\u1EA5t", "T\u1ED5ng gi\u00E1 tr\u1ECB", "T\u1EF7 l\u1EC7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedReportType = (String) comboBox.getSelectedItem();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0); // Xóa tất cả các hàng hiện tại

				if (selectedReportType.equals("Báo cáo công nợ")) {
					model.setColumnIdentifiers(new String[] {"STT", "Đại lý", "Nợ đầu", "Phát sinh", "Nợ cuối"});
					// Thêm dữ liệu cho báo cáo công nợ
				} else if (selectedReportType.equals("Báo cáo doanh số")) {
					model.setColumnIdentifiers(new String[] {"STT", "Đại lý", "Số phiếu xuất", "Tổng trị giá", "Tỷ lệ"});
					// Thêm dữ liệu cho báo cáo hàng tồn
				}
			}
		});


	}
}
