package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class reportPanel extends CustomPanel {

	private static final long serialVersionUID = 1L;
	private CustomComboBox comboboxThang;
	private CustomTextField textFieldNam;
	private CustomComboBox comboBox;
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

		JPanel panelSearch = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.insets = new java.awt.Insets(10, 40, 0, 40);
		gbc.fill = GridBagConstraints.BOTH;
		panelSearch.setLayout(new FlowLayout());

		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 30));
		searchField.setMinimumSize(new Dimension(300, 30));
		searchField.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelSearch.add(searchField);

		this.add(panelSearch, gbc);

		JPanel panel = new JPanel();

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.insets = new java.awt.Insets(5, 40, 0, 40);
		gbc.fill = GridBagConstraints.BOTH;

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

		comboboxThang = new CustomComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		comboboxThang.setMinimumSize(new Dimension(50, 30));
		comboboxThang.setPreferredSize(new Dimension(50, 30));
		panel.add(comboboxThang);

		textFieldNam = new CustomTextField(10);
		textFieldNam.setPlaceholder("Năm");
		textFieldNam.setMinimumSize(new Dimension(50, 30));
		textFieldNam.setPreferredSize(new Dimension(50, 30));
		panel.add(textFieldNam);

		String[] reportType = {"Báo cáo công nợ", "Báo cáo doanh số"};
		comboBox = new CustomComboBox(reportType);
		comboBox.setPreferredSize(new Dimension(150, 30));
		panel.add(comboBox);

		CustomButton btnXem = new CustomButton("Thống kê");
		btnXem.setPreferredSize(new Dimension(100, 30));
		btnXem.setFont(new Font("Roboto", Font.PLAIN, 12));
		ImageIcon icon = new ImageIcon("src/main/java/resource/searchStoreIcon.png");
		btnXem.setIcon(icon);
		btnXem.setIconTextGap(20);
		btnXem.setHorizontalAlignment(JButton.LEFT);
		btnXem.setHorizontalTextPosition(JButton.RIGHT);

		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNam.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập năm", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(textFieldNam.getText()) < 0 || Integer.parseInt(textFieldNam.getText()) > LocalDate.now().getYear()){
					JOptionPane.showMessageDialog(null, "Năm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});

		panel.add(btnXem);
		this.add(panel, gbc);

		JScrollPane scrollPane = new JScrollPane();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.9;
		gbc.insets = new java.awt.Insets(0, 40, 20, 40);
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
	}
}
