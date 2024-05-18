package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;

import Controller.DaiLyController;
import Models.daily;
import Models.loaidaily;
import Models.quan;

import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import ReuseClass.DatePicker;
import UI.CustomTextField;
import UI.CustomComboBox;
import javax.swing.event.*;
import javax.swing.RowFilter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class StoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc1_1;
	private GridBagConstraints gbc1_2;
	private GridBagConstraints gbc1_3;
	private GridBagConstraints gbc1_4;
	private JButton addButton;
	private DatePicker datePicker;
	private DaiLyController daiLyController;
	java.util.List<daily> dailyList;
	/**
	 * Create the panel.
	 */
	public StoresPanel() {
		daiLyController = new DaiLyController();
		try {
			dailyList = daiLyController.showDaiLy();
		}catch (Exception e){
			e.printStackTrace();
		}
        String[] labels = {"Tên đại lý", "Loại đại lý", "Số điện thoại", "Địa chỉ", "Quận", "Email"};
        String[] districtItems = {"Quận", "1", "2", "3", "Tân Phú", "Bình Tân"};
        String[] categoryItems = {"Loại", "1", "2"};
		String[] sortItems = {"Sắp xếp theo", "Tiền nợ tăng dần", "Tiền nợ giảm dần" };
		setOpaque(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;

		panelHeader.setLayout(new GridBagLayout());
		GridBagConstraints gbcHeader = new GridBagConstraints();
		gbcHeader.gridx = 0;
		gbcHeader.gridy = 0;
		gbcHeader.weightx = 0.9;
		gbcHeader.weighty = 1;
		gbcHeader.fill = GridBagConstraints.BOTH;
		gbcHeader.anchor = GridBagConstraints.WEST;
		JLabel headerLable = new JLabel("Đại lý");
		headerLable.setBorder(new EmptyBorder(0, 20, 0, 0));
		headerLable.setFont(new Font("Roboto", Font.BOLD, 28));
		panelHeader.add(headerLable, gbcHeader);
		this.add(panelHeader, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.8;
		gbc.weightx = 1;
		gbc.insets = new java.awt.Insets(10, 20, 10, 20);
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
		gbc1.insets = new Insets(0, 0, 0, 0);

		JLabel pnhLable = new JLabel("Danh sách các đại lý");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 22));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		gbc1_1 = new GridBagConstraints();
		gbc1_1.gridy = 0;
		addButton = new JButton("Tiếp nhận đại lý");
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/lapPhieuIcon.png");
		addButton.setIcon(lapPhieuIcon);
		addButton.setBorderPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.ORANGE);
		addButton.setFont(new Font("Roboto", Font.BOLD, 20));
		addButton.setPreferredSize(new Dimension(150, 40));
		gbc1_1.gridx = 1;
		gbc1_1.weightx = 1;
		gbc1_1.anchor = GridBagConstraints.WEST;
//		gbc1_1.insets = new Insets(0, 30, 5, 30);
		contentPane.add(addButton, gbc1_1);


		
        
		JButton makeReceiptButton = new JButton("Lập phiếu thu tiền");
	 makeReceiptButton.setPreferredSize(new Dimension(150, 40));
		ImageIcon themMatHang = new ImageIcon("src/main/java/resource/themMatHangIcon.png");
     makeReceiptButton.setIcon(themMatHang);
	 makeReceiptButton.setFont(new Font("Roboto", Font.BOLD, 12));
	 makeReceiptButton.setForeground(Color.WHITE);
	 makeReceiptButton.setBackground(Color.BLACK);
		
		gbc1_2 = new GridBagConstraints();
		gbc1_2.gridy = 0;
		gbc1_2.anchor = GridBagConstraints.EAST;
		gbc1_2.gridx = 1;
		gbc1_2.weightx = 1;
//		gbc1_2.insets = new Insets(0, 0, 5, 0);
		contentPane.add(makeReceiptButton, gbc1_2);
		
		// Row 2: search bar, and filters
		gbc1_3 = new GridBagConstraints();
		gbc1_3.gridx = 0;
		gbc1_3.gridy = 1;
		gbc1_3.weightx = 1;
		gbc1_3.gridwidth = 2;
		gbc1_3.fill = GridBagConstraints.BOTH;
		gbc1_3.insets = new Insets(0, 0, 5, 0);
		JPanel filterPanel = new JPanel();
		filterPanel.setOpaque(false);
		// a layout that arranges its children in a single row
		filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		SearchTextField searchField = new SearchTextField(20);
		searchField.setPlaceholder("Tìm kiếm");
		filterPanel.add(searchField);
		
		FilterComboBox categoryFilterComboBox = new FilterComboBox(categoryItems);
		filterPanel.add(categoryFilterComboBox);
		
		FilterComboBox districtFilterComboBox = new FilterComboBox(districtItems);
		filterPanel.add(districtFilterComboBox);
		
		FilterComboBox sortFilterComboBox = new FilterComboBox(sortItems);
		filterPanel.add(sortFilterComboBox);
		
		contentPane.add(filterPanel, gbc1_3);
		
		this.add(contentPane, gbc);
		
		// Table
		gbc1_3 = new GridBagConstraints();
		gbc1_3.gridx = 0;
		gbc1_3.gridwidth = 2;
		gbc1_3.gridy = 2;
		gbc1_3.weightx = 1;
		gbc1_3.weighty = 1;
		gbc1_3.fill = GridBagConstraints.BOTH;
		gbc1_3.insets = new Insets(0, 0, 5, 0);
		
		// Create column names
        String[] columnNames = {"STT", "Tên đại lý", "Loại", "Quận", "Tiền nợ (VND)"};

        
       

     // Create table model
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
        // Create data
		for (int i = 0; i < dailyList.size(); i++) {
			daily daily = dailyList.get(i);
			model.addRow(new Object[] { i + 1, daily.getTendaily(), daily.getMaloaidl().getTenloaidl(),
					daily.getMaquan().getTenquan(), daily.getTienno() });
		}

        // Create table
        JTable table = new JTable(model);

        // Set column widths
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
        	((DefaultRowSorter)table.getRowSorter()).setSortable(i, false);
            TableColumn column = table.getColumnModel().getColumn(i);
            int width = 50; // Default width
            switch (i) {
            case 0: width = 50; break; // STT
            case 1: width = 300; break; // Tên đại lý
            case 2: width = 50; break; // Loại
            case 3: width = 50; break; // Quận
            case 4: width = 150; break; // Tiền nợ
        }
        column.setPreferredWidth(width);
    }

        // Make header transparent
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setOpaque(false);
        table.getTableHeader().setOpaque(false);
    table.setShowVerticalLines(false);
    
    // Set font and alignment for table
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    // Create scroll pane (to make the table scrollable)
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);

         contentPane.add(scrollPane, gbc1_3);
    // Add listener for filter components
         searchField.getDocument().addDocumentListener(new DocumentListener() {
        	    public void changedUpdate(DocumentEvent e) {
        	        filter();
        	    }
        	    public void removeUpdate(DocumentEvent e) {
        	        filter();
        	    }
        	    public void insertUpdate(DocumentEvent e) {
        	        filter();
        	    }

        	    public void filter() {
        	        String filterText = searchField.getText();
        	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        	        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterText)); // (?i) enables case insensitive matching
        	        table.setRowSorter(sorter);
        	    }
        	});
         
         ItemListener itemListener = new ItemListener() {
        	    public void itemStateChanged(ItemEvent e) {
        	        if (e.getStateChange() == ItemEvent.SELECTED) {
        	            filter();
        	        }
        	    }

        	    public void filter() {
        	    	String district = (String) districtFilterComboBox.getSelectedItem();
        	        String category = (String) categoryFilterComboBox.getSelectedItem();

        	        // Ignore default values
        	        if (district.equals("Quận")) {
        	            district = "";
        	        }
        	        if (category.equals("Loại")) {
        	            category = "";
        	        }

        	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        	        sorter.setRowFilter(RowFilter.andFilter(Arrays.asList(
        	            RowFilter.regexFilter(district, 3), // 3 is the column index for district
        	            RowFilter.regexFilter(category, 2) // 2 is the column index for category
        	        )));
        	        table.setRowSorter(sorter);
        	    }
        	};
        	districtFilterComboBox.addItemListener(itemListener);
        	categoryFilterComboBox.addItemListener(itemListener);
        	
        	sortFilterComboBox.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent e) {
        	        if (e.getStateChange() == ItemEvent.SELECTED) {
        	            String selected = (String) e.getItem();
        	            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        	            if (selected.equals("Tiền nợ tăng dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING))); // 4 is the column index for debt
        	            } else if (selected.equals("Tiền nợ giảm dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING))); // 4 is the column index for debt
        	            }
        	            table.setRowSorter(sorter);
        	        }
        	    }
        	});
    
    // Add action listener for the "Tiếp nhận đại lý" button     
         addButton.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	        // Create a panel for the popup
        	        JPanel popupPanel = new JPanel(new GridBagLayout());
        	        GridBagConstraints gbc = new GridBagConstraints();
        	        gbc.fill = GridBagConstraints.HORIZONTAL;
        	        gbc.weightx = 1.0;
        	        gbc.weighty = 1.0;
        	        gbc.insets = new Insets(5, 5, 5, 5);

        	        // Add the title
        	        JLabel title = new JLabel("Hồ sơ đại lý");
        	        title.setFont(new Font("Roboto", Font.BOLD, 22));
        	        gbc.gridx = 0;
        	        gbc.gridy = 0;
        	        gbc.gridwidth = 2;
        	        popupPanel.add(title, gbc);

        	        // Add the line separator
        	        gbc.gridy++;
        	        gbc.gridwidth = GridBagConstraints.REMAINDER;
        	        gbc.fill = GridBagConstraints.HORIZONTAL;
        	        JSeparator separator = new JSeparator();
        	        separator.setForeground(Color.BLACK);
        	        popupPanel.add(separator, gbc);
        	        
        	   

        	        // Add the text fields and combo boxes
        	        JComponent[] inputs = new JComponent[labels.length];
        	        for (int i = 0; i < labels.length; i++) {
        	            gbc.gridwidth = 1;
        	            gbc.gridx = i % 2;
        	            gbc.gridy = 2 + 2*(i/2);

        	            JLabel label = new JLabel(labels[i]);
        	            label.setFont(new Font("Roboto", Font.PLAIN, 10));
        	            popupPanel.add(label, gbc);

        	            gbc.gridy++;
        	            if (labels[i].equals("Loại đại lý")) {
        	                // Add a combo box for "Loại đại lý"
        	                inputs[i] = new CustomComboBox(categoryItems);
        	            } else if (labels[i].equals("Quận")) {
        	                // Add a combo box for "Quận"
        	                inputs[i] = new CustomComboBox(districtItems);
        	                } else {
        	                // Add a text field for the other fields
        	                inputs[i] = new CustomTextField(20);
        	            }
        	            popupPanel.add(inputs[i], gbc);
        	        }
        	        // Add the buttons
        	        JButton cancelButton = new JButton("Hủy bỏ");
        	        JButton confirmButton = new JButton("Thêm mới");
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Get the values from the text fields and combo boxes
							String[] values = new String[labels.length];
		
							for (int i = 0; i < labels.length; i++) {
					            if (labels[i].equals("Loại đại lý") || labels[i].equals("Quận")) {
					                values[i] = (String)((CustomComboBox) inputs[i]).getSelectedItem();
					                if (values[i].equals(districtItems[0]) || values[i].equals(categoryItems[0])) { // 
					                    JOptionPane.showMessageDialog(null, "Hãy chọn " + labels[i]);
					                    return;
					                }
					            }
					          
					            else {
					                values[i] = ((CustomTextField) inputs[i]).getText();
					                if (values[i].isEmpty()) {
					                    JOptionPane.showMessageDialog(null, labels[i] + " không thể trống");
					                    return;
					                }
					                if (labels[i].equals("Số điện thoại")) {
					                    if (!values[i].matches("\\d{10}")) { // regex cho sdt
					                        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
					                        return;
					                    }
					                }
									if (labels[i].equals("Email")) {
										if (!values[i].matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
											JOptionPane.showMessageDialog(null, "Email không hợp lệ");
											return;
										}
									}
					            }
					        }					
							// use the values array to pass to the database
							quan quan = new quan();
							quan.setTenquan(values[4]);
							
							loaidaily loaidaily = new loaidaily();
							loaidaily.setTenloaidl(values[1]);
							
							daily daily = new daily();
							daily.setTendaily(values[0]);
							daily.setSdt(values[2]);
							daily.setDiachi(values[3]);
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							daily.setNgaytn(LocalDate.now().format(formatter));
							daily.setMaquan(quan);
							daily.setTienno(0);
							daily.setMaloaidl(loaidaily);
							daily.setEmail(values[5]);
							
							if (daiLyController.addNewDaiLy(daily, quan, loaidaily).contains("200")) {
								JOptionPane.showMessageDialog(null, "Thêm đại lý thành công");
								model.addRow(
										new Object[] { model.getRowCount() + 1, values[0], values[1], values[4], 0 });
							}
							// Add the new row to the table
							
							// Hide the popup
							((Window) SwingUtilities.getRoot(popupPanel)).dispose();
						}
					});
        	        
					cancelButton.addActionListener(new ActionListener() {
						@Override
                        public void actionPerformed(ActionEvent e) {
                            // Hide the popup
                            ((Window) SwingUtilities.getRoot(popupPanel)).dispose();
                        }
					});
					
        	        gbc.gridy++;
        	        gbc.gridwidth = 1;
        	        gbc.gridx = 0;
        	        popupPanel.add(cancelButton, gbc);
        	        gbc.gridx++;
        	        popupPanel.add(confirmButton, gbc);
        	        popupPanel.revalidate();
        	        popupPanel.repaint();
        	        // Show the popup
        	        JOptionPane.showOptionDialog(null, popupPanel, "Thêm đại lý", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        	    }
        	});
         
         makeReceiptButton.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	        // Create a panel for the popup
        	    	String[] storeNames = dailyList.stream().map(daily::getTendaily).toArray(String[]::new);
        	        JPanel popupPanel = new JPanel(new GridBagLayout());
        	        GridBagConstraints gbc = new GridBagConstraints();
        	        gbc.fill = GridBagConstraints.HORIZONTAL;
        	        gbc.weightx = 1.0;
        	        gbc.weighty = 1.0;
        	        gbc.insets = new Insets(5, 5, 5, 5);

        	        // Add the title
        	        JLabel title = new JLabel("Phiếu thu tiền");
        	        title.setFont(new Font("Roboto", Font.BOLD, 22));
        	        gbc.gridx = 0;
        	        gbc.gridy = 0;
        	        gbc.gridwidth = 2;
        	        popupPanel.add(title, gbc);

        	        // Add the line separator
        	        gbc.gridy++;
        	        gbc.gridwidth = GridBagConstraints.REMAINDER;
        	        gbc.fill = GridBagConstraints.HORIZONTAL;
        	        JSeparator separator = new JSeparator();
        	        separator.setForeground(Color.BLACK);
        	        popupPanel.add(separator, gbc);

        	        // Add the text fields and combo boxes
        	        String[] labels = {"Tên đại lý", "Địa chỉ", "Số điện thoại", "Email", "Ngày thu tiền", "Số tiền thu (VND)"};
        	        JComponent[] inputs = new JComponent[labels.length];
        	        ItemListener storeNameItemListener = null;
        	        for (int i = 0; i < labels.length; i++) {
        	            gbc.gridwidth = 1;
        	            gbc.gridx = i % 2;
        	            gbc.gridy = 2 + 2*(i/2);

        	            JLabel label = new JLabel(labels[i]);
        	            label.setFont(new Font("Roboto", Font.PLAIN, 10));
        	            popupPanel.add(label, gbc);

        	            gbc.gridy++;
        	            if (labels[i].equals("Tên đại lý")) {
        	                // Add a combo box for "Tên đại lý"
        	                inputs[i] = new CustomComboBox(storeNames);
        	                AutoCompleteDecorator.decorate((CustomComboBox) inputs[i]);
        	                ((CustomComboBox) inputs[i]).setEditable(true);
							storeNameItemListener = new ItemListener() {
								@Override
								public void itemStateChanged(ItemEvent e) {
									String selectedAgentName = (String) e.getItem();

						            // Fetch the details of the selected agent from the dailyList
						            daily selectedAgent = dailyList.stream()
						                .filter(agent -> agent.getTendaily().equals(selectedAgentName))
						                .findFirst()
						                .orElse(null);

						            if (selectedAgent != null) {
						                // Update the other input fields
						                ((JTextField) inputs[1]).setText(selectedAgent.getDiachi());
						                ((JTextField) inputs[2]).setText(selectedAgent.getSdt());
						                ((JTextField) inputs[3]).setText(selectedAgent.getEmail());
						            } else {
						                // Clear the other input fields
						                ((JTextField) inputs[1]).setText("");
						                ((JTextField) inputs[2]).setText("");
						                ((JTextField) inputs[3]).setText("");
						            }
								}
							};
                                     ((CustomComboBox) inputs[i]).addItemListener(storeNameItemListener);
							
						
						} else if (labels[i].equals("Ngày thu tiền")) {
							// Add a date picker for "Ngày thu tiền"
							datePicker = new DatePicker();
							datePicker.setEditable(false);
							datePicker.setDate(LocalDate.now());
							inputs[i] = datePicker;
						}
        	            else {
        	                // Add a text field for the other fields
        	                inputs[i] = new CustomTextField(20);
        	                ((CustomTextField) inputs[i]).setEditable(false);
							if (labels[i].equals("Số tiền thu (VND)")) {
								((CustomTextField) inputs[i]).setEditable(true);
							}
        	            }
        	            
        	            popupPanel.add(inputs[i], gbc);
        	        }
        	        if(!dailyList.isEmpty()) {
						((CustomComboBox) inputs[0]).setSelectedItem(storeNames[0]);
				        storeNameItemListener.itemStateChanged(new ItemEvent((CustomComboBox) inputs[0], ItemEvent.ITEM_STATE_CHANGED, storeNames[0], ItemEvent.SELECTED));
					}
        	        
        	     // Add the buttons
        	        JButton cancelButton = new JButton("Hủy bỏ");
        	        JButton confirmButton = new JButton("Thêm mới");
        	        // Add action listeners for the buttons
        	        
        	        //
        	        gbc.gridy++;
        	        gbc.gridwidth = 1;
        	        gbc.gridx = 0;
        	        popupPanel.add(cancelButton, gbc);
        	        gbc.gridx++;
        	        popupPanel.add(confirmButton, gbc);
        	        popupPanel.revalidate();
        	        popupPanel.repaint();

        	        // Show the popup
        	        JOptionPane.showOptionDialog(null, popupPanel, "Phiếu thu tiền", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        	    }
        	});
         
	}

}
