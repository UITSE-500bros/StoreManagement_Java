package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;

import Controller.DVTController;
import Controller.DaiLyController;
import Controller.MatHangController;
import Controller.PhieuXuatHangController;
import Models.*;
import ReuseClass.DatePicker;

public class ExportPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JButton addButton;
	private final DefaultTableModel model;
	private JTextField tienConLaiTextField;
	private CustomTextField tienTraTextField;
	private JTextField tongTienTextField;
	private JTable tableXuatHang;
	private FilterComboBox daiLyCombobox;
	private DatePicker datePicker;
	private Map<String, ArrayList<Integer>> matHangs;
	private Map<String, ArrayList<Integer>>  daiLys;
	private List<daily> list1;
	private List<mathang> list;
	private ArrayList<String> dvMatHangs;


	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExportPanel ex = new ExportPanel();
		frame.getContentPane().add(ex);
		frame.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public ExportPanel() {
		this.setLayout(new GridBagLayout());

		loadData();

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
		gbcHeader.fill = GridBagConstraints.BOTH;
		gbcHeader.anchor = GridBagConstraints.WEST;
		JLabel headerLable = new JLabel("XUẤT HÀNG");
		headerLable.setBorder(new EmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 44));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.8;
		gbc.weightx = 1;
		gbc.insets = new java.awt.Insets(30, 40, 40, 30);
		gbc.fill = GridBagConstraints.BOTH;

		CustomPanel contentPane = new CustomPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 }; // 3 columns
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 }; // 5 rows
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE }; // No extra horizontal space
		gbl_contentPane.rowWeights = new double[] { 0.1, 0.1, 0.7, 0.1, Double.MIN_VALUE }; // Weights for rows
		contentPane.setLayout(gbl_contentPane);

		// For components in row 1 and 2, you need to set GridBagConstraints for each
		// component
		GridBagConstraints gbc1 = new GridBagConstraints();

		JLabel pnhLable = new JLabel("Phiếu Xuất Hàng");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 30));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		gbc1.insets = new Insets(0, 15, 5, 0);
		contentPane.add(pnhLable, gbc1);

		JPanel pnaelHang2 = new JPanel();
		pnaelHang2.setOpaque(false);
		pnaelHang2.setBackground(new Color(255, 249, 243, 180));
		pnaelHang2.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridy = 1;
		gbc1.gridx = 0;
		gbc1.gridwidth = 2;
		gbc1.insets = new Insets(0, 0, 0, 0);

		daiLyCombobox = new FilterComboBox(daiLys.keySet().toArray(new String[0]));
		daiLyCombobox.setPreferredSize(new Dimension(200, 30));
		daiLyCombobox.setFont(new Font("Roboto", Font.PLAIN, 12));
		pnaelHang2.add(daiLyCombobox);

		datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));
		datePicker.setBorder(new EmptyBorder(3, 0, 0, 0));
		datePicker.setPreferredSize(new Dimension(150, 30));
		datePicker.setMinimumSize(new Dimension(150, 30));
		pnaelHang2.add(datePicker);

		CustomButton themMatHangButton = new CustomButton("Thêm mặt hàng");
		themMatHangButton.setPreferredSize(new Dimension(150, 30));
		ImageIcon themMatHang = new ImageIcon("src/main/java/resource/themMatHangIcon.png");
		themMatHangButton.setIcon(themMatHang);
		themMatHangButton.setFont(new Font("Roboto", Font.BOLD, 12));
		themMatHangButton.setForeground(Color.WHITE);
		themMatHangButton.setBackground(Color.BLACK);
		themMatHangButton.setIconTextGap(20);
		themMatHangButton.setHorizontalAlignment(JButton.LEFT);
		themMatHangButton.setHorizontalTextPosition(JButton.RIGHT);
		themMatHangButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(600, 900);
				GridBagConstraints gbc = new GridBagConstraints();

				JPanel panelContent = new JPanel();
				gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.weightx = 1;
				gbc.weighty = 0.9;
				gbc.fill = GridBagConstraints.BOTH;
				panelContent.setLayout(new GridBagLayout());
				GridBagConstraints gbcContent = new GridBagConstraints();

				JLabel labelName = new JLabel("Tên mặt hàng");
				gbcContent.gridx = 0;
				gbcContent.gridy = 0;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelName.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelName, gbcContent);

				CustomTextField txtDonGia = new CustomTextField(15);
				txtDonGia.setFont(new Font("Roboto", Font.PLAIN, 15));
				txtDonGia.setEditable(false);

				CustomTextField txtDVT = new CustomTextField(10);
				txtDVT.setFont(new Font("Roboto", Font.PLAIN, 15));
				txtDVT.setEditable(false);

				gbcContent = new GridBagConstraints();
				CustomComboBox txtName = new CustomComboBox(matHangs.keySet().toArray(new String[0]));
				gbcContent.fill = GridBagConstraints.HORIZONTAL;
				gbcContent.gridx = 0;
				gbcContent.gridy = 1;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 20, 0);
				txtName.setFont(new Font("Roboto", Font.PLAIN, 15));
				txtName.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String selectedName = txtName.getSelectedItem().toString();
						txtDonGia.setText(matHangs.get(selectedName).get(1).toString());
						String dvT = dvMatHangs.get(matHangs.get(selectedName).getLast());
						txtDVT.setText(dvT);
					}
				});
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtName, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelDVT = new JLabel("Đơn vị tính");
				gbcContent.gridx = 1;
				gbcContent.gridy = 0;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelDVT.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelDVT, gbcContent);

				gbcContent = new GridBagConstraints();
				gbcContent.gridx = 1;
				gbcContent.gridy = 1;
				gbcContent.fill = GridBagConstraints.HORIZONTAL;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 20, 0);
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtDVT, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelSoLuong = new JLabel("Số lượng");
				gbcContent.gridx = 0;
				gbcContent.gridy = 2;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelSoLuong.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelSoLuong, gbcContent);

				gbcContent = new GridBagConstraints();
				CustomTextField txtSoLuong = new CustomTextField(15);
				txtSoLuong.setEditable(true);
				gbcContent.gridx = 0;
				gbcContent.gridy = 3;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 0, 0);
				txtSoLuong.setFont(new Font("Roboto", Font.PLAIN, 15));
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtSoLuong, gbcContent);

				gbcContent = new GridBagConstraints();
				JLabel labelDonGia = new JLabel("Đơn giá");
				gbcContent.gridx = 1;
				gbcContent.gridy = 2;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.1;
				gbcContent.insets = new Insets(0, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.LAST_LINE_START;
				labelDonGia.setFont(new Font("Roboto", Font.PLAIN, 12));
				panelContent.add(labelDonGia, gbcContent);

				gbcContent = new GridBagConstraints();
				gbcContent.gridx = 1;
				gbcContent.gridy = 3;
				gbcContent.weightx = 0.5;
				gbcContent.weighty = 0.4;
				gbcContent.insets = new Insets(10, 20, 0, 0);
				gbcContent.anchor = GridBagConstraints.FIRST_LINE_START;
				panelContent.add(txtDonGia, gbcContent);

				gbcContent = new GridBagConstraints();
				CustomButton newGoodButton = new CustomButton("Thêm mới");
				CustomButton cancelButton = new CustomButton("Hủy bỏ");
				newGoodButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtName.getSelectedItem() == null || txtDVT.getText().equals("")
								|| txtSoLuong.getText().equals("") || txtDonGia.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(!txtSoLuong.getText().matches("[0-9]+") || !txtDonGia.getText().matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng và đơn giá phải là số nguyên", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						int soLuong = Integer.parseInt(txtSoLuong.getText());
                        try {
                            if (new PhieuXuatHangController().checkSLT(soLuong, txtName.getSelectedItem().toString())) {
                                JOptionPane.showMessageDialog(null, "Số lượng tồn kho không đủ", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        int sum= Integer.parseInt(txtSoLuong.getText()) * Integer.parseInt(txtDonGia.getText());
						int num = model.getRowCount();
						model.addRow(new Object[] { num + 1, txtName.getSelectedItem(), txtDVT.getText(),
								txtSoLuong.getText(), txtDonGia.getText(), sum});
						String tongTienText = tongTienTextField.getText();
						tongTienText = tongTienText.replace("Tổng tiền: ", "").replace(" VND", "");
						int res = Integer.parseInt(tongTienText) + sum;
						tongTienTextField.setText("Tổng tiền: " + res + " VND");
						if(tienTraTextField.getText().equals("")) {
							tienConLaiTextField.setText("Còn lại: " + res + " VND");
						}
						else {
							int tienTra = Integer.parseInt(tienTraTextField.getText());
							tienConLaiTextField.setText("Còn lại: " + (res - tienTra) + " VND");
						}
						((Window) SwingUtilities.getRoot(panel)).dispose();
					}
				});
				gbcContent.gridx = 0;
				gbcContent.gridy = 4; // Adjust this to the last row
				gbcContent.anchor = GridBagConstraints.CENTER;
				gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
				panelContent.add(newGoodButton, gbcContent);

				gbcContent = new GridBagConstraints();
				gbcContent.gridx = 1;
				gbcContent.gridy = 4; // Adjust this to the last row
				gbcContent.anchor = GridBagConstraints.CENTER;
				gbcContent.insets = new Insets(20, 0, 0, 0); // Add some padding
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((Window) SwingUtilities.getRoot(panel)).dispose();
					}
				});
				panelContent.add(cancelButton, gbcContent);

				panel.add(panelContent, gbc);
				JOptionPane.showOptionDialog(null, panel, "Thêm mặt hàng", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
			}
		});
		pnaelHang2.add(themMatHangButton);

		addButton = new CustomButton("Lập phiếu");
		addButton.setPreferredSize(new Dimension(150, 30));  // Preferred size
		addButton.setMinimumSize(new Dimension(150, 30));    // Minimum size
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/lapPhieuIcon.png");
		addButton.setIcon(lapPhieuIcon);
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setIconTextGap(20);
		addButton.setHorizontalAlignment(JButton.LEFT);
		addButton.setHorizontalTextPosition(JButton.RIGHT);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng thêm mặt hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}


				Date selectedDate = (Date) datePicker.getModel().getValue();
				LocalDate todayLocalDate = LocalDate.now();
				Date todayDate = Date.from(todayLocalDate.atStartOfDay().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant());

				if (selectedDate == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày nhập hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(selectedDate.after(todayDate) && (selectedDate.getDay() != todayDate.getDay() || selectedDate.getMonth() != todayDate.getMonth() || selectedDate.getYear() != todayDate.getYear())){
					JOptionPane.showMessageDialog(null, "Ngày nhập hàng không thể lớn hơn ngày hiện tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}

				java.sql.Date date = new java.sql.Date(selectedDate.getTime());

				if (tienTraTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền trả", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!tienTraTextField.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Số tiền trả phải là số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int tongTien = Integer.parseInt(tongTienTextField.getText().replace("Tổng tiền: ", "").replace(" VND", ""));
				int tienTra = Integer.parseInt(tienTraTextField.getText());

				if (tienTra > tongTien) {
					JOptionPane.showMessageDialog(null, "Số tiền trả không được lớn hơn tổng tiền", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int tienConLai = tongTien - tienTra;

                try {
                    if (new PhieuXuatHangController().checkTienNo(tienConLai, daiLys.get(Objects.requireNonNull(daiLyCombobox.getSelectedItem()).toString()).getFirst())) {
                        JOptionPane.showMessageDialog(null, "Số tiền trả không được lớn hơn số nợ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                PhieuXuatHangController phieuXuatHangController = new PhieuXuatHangController();

				try {
					daily existing = list1.get(daiLys.get(Objects.requireNonNull(daiLyCombobox.getSelectedItem()).toString()).getLast());
					existing.setNgaytn(null);
					phieuxuathang phieuXuatHang = new phieuxuathang(list1.get(daiLys.get(Objects.requireNonNull(daiLyCombobox.getSelectedItem()).toString()).getLast()), tongTien, tienTra, tienConLai);
					phieuXuatHangController.createPhieuXuatHang(phieuXuatHang);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
				ArrayList<ctxh> ctxhs = new ArrayList<>();
				for (int i = 0; i < model.getRowCount(); i++) {
					String tenMatHang = (String) model.getValueAt(i, 1);
					int soLuong = Integer.parseInt((String) model.getValueAt(i, 3));
					int donGia = Integer.parseInt((String) model.getValueAt(i, 4));
					int thanhTien = (int) model.getValueAt(i, 5);

					ctxhs.add(new ctxh(list.get(matHangs.get(tenMatHang).getFirst()), soLuong, donGia, thanhTien));
				}

				String result = phieuXuatHangController.addCTXH(ctxhs);

				if (result.equals("Created successfully!")) {
					tongTienTextField.setText("Tổng tiền: 0 VND");
					tienTraTextField.setText("");
					tienConLaiTextField.setText("Còn lại: 0 VND");
					model.setRowCount(0);
					JOptionPane.showMessageDialog(null, "Lập phiếu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Lập phiếu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		addButton.setFont(new Font("Roboto", Font.BOLD, 12));
		pnaelHang2.add(addButton);

		contentPane.add(pnaelHang2, gbc1);

		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("STT");
		model.addColumn("Tên mặt hàng");
		model.addColumn("Đơn vị tính");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá(VND)");
		model.addColumn("Thành tiền");
		tableXuatHang = new JTable(model);
		tableXuatHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer)tableXuatHang.getTableHeader().getDefaultRenderer()).setOpaque(false);
		tableXuatHang.getTableHeader().setOpaque(false);
		tableXuatHang.setShowVerticalLines(false);

		// Set font and alignment for table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableXuatHang.getColumnCount(); i++) {
			tableXuatHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 15, 0, 15);
		gbcHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		tableXuatHang = new JTable(model);
		tableXuatHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer)tableXuatHang.getTableHeader().getDefaultRenderer()).setOpaque(false);
		tableXuatHang.getTableHeader().setOpaque(false);
		tableXuatHang.setShowVerticalLines(false);

		tableXuatHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (SwingUtilities.isRightMouseButton(mouseEvent)) {
					// Create a pop-up menu
					JPopupMenu popupMenu = new JPopupMenu();
					JMenuItem deleteItem = new JMenuItem("Delete");
					deleteItem.addActionListener(e -> {
						if(row < model.getRowCount()) {
							int deleteMoney = (int)model.getValueAt(row, 5);
							model.removeRow(row);
							int sumMoney = Integer.parseInt(tongTienTextField.getText().replace("Tổng tiền: ", "").replace(" VND", ""));
							tongTienTextField.setText("Tổng tiền: " + (sumMoney - deleteMoney) + " VND");
							if (tienTraTextField.getText().equals("")) {
								tienConLaiTextField.setText("Còn lại: " + (sumMoney - deleteMoney) + " VND");
							} else {
								int tienTra = Integer.parseInt(tienTraTextField.getText());
								tienConLaiTextField.setText("Còn lại: " + (sumMoney - deleteMoney - tienTra) + " VND");
							}
						}
					});
					JMenuItem cancelItem = new JMenuItem("Cancel");
					cancelItem.addActionListener(e -> {
						// Handle cancel action
						System.out.println("Cancelled action on row: " + row);
					});
					popupMenu.add(deleteItem);
					popupMenu.add(cancelItem);
					popupMenu.show(table, mouseEvent.getX(), mouseEvent.getY());
				}
			}
		});

		// Set font and alignment for table
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableXuatHang.getColumnCount(); i++) {
			tableXuatHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		scrollPane.setViewportView(tableXuatHang);
		tableXuatHang.setRowSelectionAllowed(true);
		((DefaultTableCellRenderer) tableXuatHang.getDefaultRenderer(Object.class)).setOpaque(false);
		tableXuatHang.setFont(new Font("Roboto", Font.PLAIN, 10));
		TableColumnModel columnModel = tableXuatHang.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth((int) (tableXuatHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(1).setPreferredWidth((int) (tableXuatHang.getWidth() * 0.4)); // 40%
		columnModel.getColumn(2).setPreferredWidth((int) (tableXuatHang.getWidth() * 0.1)); // 10%
		columnModel.getColumn(3).setPreferredWidth((int) (tableXuatHang.getWidth() * 0.2)); // 20%
		columnModel.getColumn(4).setPreferredWidth((int) (tableXuatHang.getWidth() * 0.2)); // 20%
		scrollPane.setViewportView(tableXuatHang);

		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		gbc1.gridwidth = 2; // Span across 2 columns
		gbc1.weightx = 1.0;
		gbc1.insets = new java.awt.Insets(10, 15, 0, 15);
		contentPane.add(scrollPane, gbc1);

		// For tienTraTextField
		JPanel panel2Tien = new JPanel();
		panel2Tien.setOpaque(false);
		panel2Tien.setBackground(new Color(255, 249, 243, 180));
		panel2Tien.setBorder(new EmptyBorder(0, 15, 0, 15));
		panel2Tien.setLayout(new GridBagLayout());
		gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridy = 3;
		gbc1.gridx = 0;
		gbc1.gridwidth = 2;
		gbc1.insets = new Insets(10, 0, 0, 0);

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.WEST;
		tongTienTextField = new JTextField(15);
		tongTienTextField.setEditable(false);
		tongTienTextField.setText("Tổng tiền: 0 VND");
		tongTienTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		tongTienTextField.setMinimumSize(new Dimension(200, 40));
		tongTienTextField.setPreferredSize(new Dimension(200, 40));
		gbc2.gridx = 0;
		gbc2.weightx = 0.33; // Adjusted weight
		panel2Tien.add(tongTienTextField, gbc2);

		gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.CENTER;
		tienTraTextField = new CustomTextField(15);
		tienTraTextField.setPlaceholder("Số tiền trả");
		tienTraTextField.setEditable(true);
		tienTraTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		tienTraTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				String tienTraText = tienTraTextField.getText();
				if (!tienTraText.matches("[0-9]+")) {
					tienTraTextField.setText("");
					tienConLaiTextField.setText("Còn lại: 0 VND");
					return;
				}
				String tongTienText = tongTienTextField.getText();
				tongTienText = tongTienText.replace("Tổng tiền: ", "").replace(" VND", "");
				int tongTien = Integer.parseInt(tongTienText);
				int tienTra = Integer.parseInt(tienTraText);
				int tienConLai = tongTien - tienTra;
				tienConLaiTextField.setText("Còn lại: " + tienConLai + " VND");
			}
		});
		tienTraTextField.setMinimumSize(new Dimension(200, 40));
		gbc2.gridx = 1;
		gbc2.weightx = 0.33; // Adjusted weight
		panel2Tien.add(tienTraTextField, gbc2);

		// For tienConLaiTextField
		gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.EAST;
		tienConLaiTextField = new JTextField(15);
		tienConLaiTextField.setEditable(false);
		tienConLaiTextField.setText("Còn lại: 0 VND");
		tienConLaiTextField.setMinimumSize(new Dimension(200, 40));
		tienConLaiTextField.setPreferredSize(new Dimension(200, 40));
		tienConLaiTextField.setFont(new Font("Roboto", Font.PLAIN, 15));
		gbc2.gridx = 2;
		gbc2.weightx = 0.33;
		panel2Tien.add(tienConLaiTextField, gbc2);

		contentPane.add(panel2Tien, gbc1);

		this.add(contentPane, gbc);

	}

	public void loadData(){
		list = null;
		list1 = null;
		List<dvt> list2 = new ArrayList<>();
		try {
			list1 = new DaiLyController().showDaiLy();
			list = new MatHangController().showMatHang();
			list2 = new DVTController().showDVT();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		matHangs = new HashMap<>();
		daiLys = new HashMap<>();
		dvMatHangs = new ArrayList<>();
		int  i = 0;
		for (dvt dvt : list2) {
			dvMatHangs.add(dvt.getTendvt());
		}
		for(mathang mh : list) {
			int d = dvMatHangs.indexOf(mh.getDvt().getTendvt());
			matHangs.put(mh.getTenmh(), new ArrayList<>(Arrays.asList(i , mh.getDongianhap(), d)));
			i++;
		}
		i = 0;
		for (daily dl : list1) {
			daiLys.put(dl.getTendaily(), new ArrayList<>(Arrays.asList(dl.getMadaily(), i)));
			i++;
		}
	}

}
