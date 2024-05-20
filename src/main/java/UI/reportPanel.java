package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Objects;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class reportPanel extends CustomPanel {

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
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;

		panelHeader.setLayout(new GridBagLayout());
		panelHeader.setOpaque(false);
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 0.9;
		gbcHeader.weighty = 1;
		gbcHeader.fill = GridBagConstraints.HORIZONTAL;
		gbcHeader.anchor = GridBagConstraints.WEST;
		JLabel headerLable = new JLabel("Báo cáo");
		headerLable.setBorder(new EmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 44));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);
		
		JPanel panel = new CustomPanel();

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;

		this.add(panel, gbc);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("");
		ImageIcon icon = new ImageIcon("/resource/searchStoreIcon.png");
		btnNewButton.setIcon(new ImageIcon("src/main/java/resource/searchStoreIcon.png"));
		btnNewButton.setPreferredSize(new Dimension(30, 30));


		panel.add(btnNewButton, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(24, 29));
		textField.setPreferredSize(new Dimension(300, 30));
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		

		String[] reportType = {"Báo cáo công nợ", "Báo cáo doanh số"};
		JComboBox comboBox = new JComboBox(reportType);
		comboBox.setPreferredSize(new Dimension(150, 30));

		
		panel.add(comboBox, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		gbc = new GridBagConstraints();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.9;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(scrollPane, gbc);
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = textField.getText().toLowerCase();
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);

				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1)); // 1 is the column index for "Đại lý"
			}
		});


	}
}
