package UI;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StockPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StockPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(StockPanel.class.getResource("/resource/searchStoreIcon.png")));
		btnSearch.setPreferredSize(new Dimension(30, 30));
		panel_1.add(btnSearch);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setPreferredSize(new Dimension(300, 30));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sắp xếp theo số lượng", "Sắp xếp theo đơn giá"}));
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Danh sách hàng hóa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn m\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u01A1n gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Integer.class, Object.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selected = (String)cb.getSelectedItem();

				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);

				if ("Sắp xếp theo số lượng".equals(selected)) {
					// Đặt Comparator cho cột số lượng (giả sử là cột 2)
					sorter.setComparator(2, (o1, o2) -> {
						try {
							int num1 = Integer.parseInt(o1.toString());
							int num2 = Integer.parseInt(o2.toString());
							return Integer.compare(num1, num2);
						} catch (NumberFormatException ex) {
							return 0;
						}
					});
				} else if ("Sắp xếp theo đơn giá".equals(selected)) {
					// Đặt Comparator cho cột đơn giá (giả sử là cột 4)
					sorter.setComparator(4, (o1, o2) -> {
						try {
							double num1 = Double.parseDouble(o1.toString());
							double num2 = Double.parseDouble(o2.toString());
							return Double.compare(num1, num2);
						} catch (NumberFormatException ex) {
							return 0;
						}
					});
				}
				sorter.sort();
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = textField.getText().toLowerCase();
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);

				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1)); // 1 is the column index for "Tên mặt hàng"
			}
		});
		
		
		

	}

}
