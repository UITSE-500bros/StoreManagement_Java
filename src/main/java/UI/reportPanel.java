package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.BaoCaoCongNoController;
import Controller.BaoCaoDoanhSoController;
import Models.baocaocongno;
import Models.ctbcds;
import com.formdev.flatlaf.FlatLightLaf;

public class reportPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private GridBagConstraints gbc;
    private JTextField tongTienTextField;
	private CustomComboBox comboboxThang;
	private CustomTextField textFieldNam;
	private CustomComboBox comboBox;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public reportPanel() {
		initComponet();
	}

	public void initComponet(){
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

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

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.insets = new java.awt.Insets(12, 30, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;

		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		comboboxThang = new CustomComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		comboboxThang.setModel(new DefaultComboBoxModel(new String[] {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"}));
		comboboxThang.setMinimumSize(new Dimension(50, 40));
		comboboxThang.setPreferredSize(new Dimension(100, 40));
		comboboxThang.setBorder(new EmptyBorder(0, 2, 0, 0));
		panel.add(comboboxThang);

		textFieldNam = new CustomTextField(10);
		textFieldNam.setPlaceholder("Năm");
		textFieldNam.setMinimumSize(new Dimension(50, 40));
		textFieldNam.setPreferredSize(new Dimension(50, 40));
		textFieldNam.setBorder(new EmptyBorder(0, 2, 0, 0));
		panel.add(textFieldNam);

		String[] reportType = {"Báo cáo doanh số", "Báo cáo công nợ"};
		comboBox = new CustomComboBox(reportType);
		comboBox.setPreferredSize(new Dimension(150, 40));
		panel.add(comboBox);

		CustomButton btnXem = new CustomButton("Thống kê");
		btnXem.setPreferredSize(new Dimension(130, 40));
		btnXem.setFont(new Font("Roboto", Font.PLAIN, 12));
		ImageIcon icon = new ImageIcon("src/main/java/resource/searchStoreIcon.png");
		btnXem.setIcon(icon);
		btnXem.setIconTextGap(20);
		btnXem.setHorizontalAlignment(JButton.LEFT);
		btnXem.setHorizontalTextPosition(JButton.RIGHT);

		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.getRowCount() > 0){
					return;
				}
				if (textFieldNam.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập năm", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(textFieldNam.getText()) < 0 || Integer.parseInt(textFieldNam.getText()) > LocalDate.now().getYear()){
					JOptionPane.showMessageDialog(null, "Năm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Integer.parseInt(textFieldNam.getText()) == LocalDate.now().getYear() && Integer.parseInt(comboboxThang.getSelectedItem().toString().replace("Tháng ", "")) > LocalDate.now().getMonthValue()){
					JOptionPane.showMessageDialog(null, "Tháng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(comboBox.getSelectedItem().equals("Báo cáo doanh số")){
					List<ctbcds> list = null;
					try {
						list = new BaoCaoDoanhSoController().getBaoCaoDoanhSo(Integer.parseInt(comboboxThang.getSelectedItem().toString().replace("Tháng ", "")), Integer.parseInt(textFieldNam.getText()));
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Không có dữ liệu");
						return;
					}
					int tongTien = 0;
					
					for (ctbcds ct : list){
						model.addRow(new Object[]{model.getRowCount() + 1, ct.getMadaily().getTendaily(), ct.getSophieuxuat(), ct.getTongtrigia(), ct.getTyle()});
						tongTien += ct.getTongtrigia();
					}
					tongTienTextField.setText("Tổng tiền: " + tongTien + " VND");
				}
				else {
					List<baocaocongno> list = null;
					try {
						list = new BaoCaoCongNoController().getBaoCaoCongNo(Integer.parseInt(comboboxThang.getSelectedItem().toString().replace("Tháng ", "")), Integer.parseInt(textFieldNam.getText()));
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Không có dữ liệu");
						return;
					}
					for (baocaocongno bc : list){
						model.addRow(new Object[]{model.getRowCount() + 1, bc.getBaocaocongnoID().getMadaily().getTendaily(), bc.getNoDau(), bc.getPhatSinh(), bc.getNoCuoi()});
					}
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
		gbc.weighty = 0.8;
		gbc.insets = new java.awt.Insets(0, 40, 5, 40);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(scrollPane, gbc);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setOpaque(false);
		table.getTableHeader().setOpaque(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
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
		model = (DefaultTableModel) table.getModel();
	
		scrollPane.setViewportView(table);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedReportType = (String) comboBox.getSelectedItem();
				model.setRowCount(0); // Xóa tất cả các hàng hiện tại

				if (selectedReportType.equals("Báo cáo công nợ")) {
					model.setColumnIdentifiers(new String[] {"STT", "Đại lý", "Nợ đầu", "Phát sinh", "Nợ cuối"});
					// Thêm dữ liệu cho báo cáo công nợ
					if (tongTienTextField != null) {
						model.setRowCount(0);
						remove(tongTienTextField);
						tongTienTextField = null;
						revalidate();
						repaint();
					}
				} else if (selectedReportType.equals("Báo cáo doanh số")) {
					model.setColumnIdentifiers(new String[] {"STT", "Đại lý", "Số phiếu xuất", "Tổng trị giá", "Tỷ lệ"});
					// Thêm dữ liệu cho báo cáo hàng tồn
					if (tongTienTextField == null) {
						model.setRowCount(0);
						addTongTienTextField();
						revalidate();
						repaint();
					}
				}
			}
		});
		addTongTienTextField();
	}
    public void addTongTienTextField(){
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        tongTienTextField = new JTextField(15);
        tongTienTextField.setEditable(false);
        tongTienTextField.setText("Tổng tiền: 0 VND");
        tongTienTextField.setPreferredSize(new Dimension(400, 30));
        tongTienTextField.setMaximumSize(new Dimension(400, 30));
        tongTienTextField.setMinimumSize(new Dimension(400, 30));
        tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
        gbc.gridy = 4;
        gbc.insets = new java.awt.Insets(5, 0, 10, 40);
        this.add(tongTienTextField, gbc);
    }
}
