package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;

import Repository.ThamSoRepository;
import Controller.DaiLyController;
import Controller.LoaiDaiLyController;
import Controller.QuanController;
import Controller.PhieuThuTienController;
import Controller.ThamSoController;
import Models.daily;
import Models.loaidaily;
import Models.quan;
import Models.phieuthutien;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import ReuseClass.DatePicker;
import UI.CustomTextField;
import UI.CustomComboBox;
import javax.swing.event.*;

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
	private LoaiDaiLyController loaiDaiLyController;
	private QuanController quanController;
	private PhieuThuTienController phieuThuTienController;
	private ThamSoController thamSoController;
	java.util.List<daily> dailyList;
	java.util.List<loaidaily> loaidailyList;
	java.util.List<quan> quanList;
	/**
	 * Create the panel.
	 */
	public StoresPanel() {
		initComponents();
	}
	public void initComponents() {
		daiLyController = new DaiLyController();
		loaiDaiLyController = new LoaiDaiLyController();
		quanController = new QuanController();
		phieuThuTienController = new PhieuThuTienController();
		thamSoController = new ThamSoController();
		loadData();
        String[] labels = {"Tên đại lý", "Loại đại lý", "Số điện thoại", "Địa chỉ", "Quận", "Email"};
        String[] districtItems = new String[quanList.size() + 1];
        String[] categoryItems = new String[loaidailyList.size() + 1];
        districtItems[0] = "Quận";
        categoryItems[0] = "Loại";
		for (int i=0; i<loaidailyList.size(); i++) {
			categoryItems[i+1] = loaidailyList.get(i).getTenloaidl();
		}
		for (int i = 0; i < quanList.size(); i++) {
			districtItems[i + 1] = quanList.get(i).getTenquan();
		}
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
		addButton = new CustomButton("Tiếp nhận đại lý");
		ImageIcon lapPhieuIcon = new ImageIcon("src/main/java/resource/addStore.png");
		Image img = lapPhieuIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		lapPhieuIcon = new ImageIcon(img);
		addButton.setIcon(lapPhieuIcon);
		addButton.setPreferredSize(new Dimension(150, 40));
		addButton.setMinimumSize(new Dimension(150, 40));
		addButton.setFont(new Font("Roboto", Font.BOLD, 12));
		addButton.setForeground(Color.WHITE);
		addButton.setBackground(Color.BLACK);
		addButton.setIconTextGap(15);
		addButton.setHorizontalAlignment(JButton.LEFT);
		addButton.setHorizontalTextPosition(JButton.RIGHT);
		
		
		gbc1_1.gridx = 1;
		gbc1_1.weightx = 1;
		gbc1_1.anchor = GridBagConstraints.WEST;
//		gbc1_1.insets = new Insets(0, 30, 5, 30);
		contentPane.add(addButton, gbc1_1);


		
        
		JButton makeReceiptButton = new CustomButton("Thu tiền");
	 makeReceiptButton.setPreferredSize(new Dimension(150, 40));
	 makeReceiptButton.setMinimumSize(new Dimension(150, 40));
		ImageIcon themMatHang = new ImageIcon("src/main/java/resource/makereceipt.png");
		img = themMatHang.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		themMatHang = new ImageIcon(img);
     makeReceiptButton.setIcon(themMatHang);
	 makeReceiptButton.setFont(new Font("Roboto", Font.BOLD, 12));
	 makeReceiptButton.setForeground(Color.WHITE);
	 makeReceiptButton.setBackground(Color.BLACK);
	 makeReceiptButton.setIconTextGap(30);
		makeReceiptButton.setHorizontalAlignment(JButton.LEFT);
		makeReceiptButton.setHorizontalTextPosition(JButton.RIGHT);
		
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
    	            TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) ((DefaultRowSorter)table.getRowSorter());
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

    	            TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) ((DefaultRowSorter)table.getRowSorter());
        	        sorter.setRowFilter(RowFilter.andFilter(Arrays.asList(
        	            RowFilter.regexFilter(district, 3),
        	            RowFilter.regexFilter(category, 2) 
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
        	            TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) ((DefaultRowSorter)table.getRowSorter());
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
        	        JButton cancelButton = new CustomButton("Hủy bỏ");
        	        JButton confirmButton = new CustomButton("Thêm mới");
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
							daily.setMaquan(quan);
							daily.setTienno(0);
							daily.setMaloaidl(loaidaily);
							daily.setEmail(values[5]);
							try {
								daily callbackDaily = daiLyController.addNewDaiLy(daily, quan, loaidaily);
								if (callbackDaily == null) {
                                    JOptionPane.showMessageDialog(null, "Số lượng đại lý của quận đã đạt tối đa");
                                }
								else {
									JOptionPane.showMessageDialog(null, "Thêm đại lý thành công");
                                    model.addRow(new Object[] { model.getRowCount() + 1, values[0], values[1], values[4], 0 });
                                    dailyList.add(callbackDaily);
                                    ((Window) SwingUtilities.getRoot(popupPanel)).dispose();
								}
							}
                            catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Thêm đại lý thất bại");
                            }
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
        	        JOptionPane.showOptionDialog(null, popupPanel, "Hồ sơ đại lý", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
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
						                ((CustomTextField) inputs[1]).setText(selectedAgent.getDiachi());
						                ((CustomTextField) inputs[2]).setText(selectedAgent.getSdt());
						                ((CustomTextField) inputs[3]).setText(selectedAgent.getEmail());
						                ((CustomTextField) inputs[5]).setPlaceholder("Tối đa " + selectedAgent.getTienno() + " VND");
						            } else {
						                // Clear the other input fields
						                ((CustomTextField) inputs[1]).setText("");
						                ((CustomTextField) inputs[2]).setText("");
						                ((CustomTextField) inputs[3]).setText("");
						                ((CustomTextField) inputs[5]).setPlaceholder("");
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
        	        JButton cancelButton = new CustomButton("Hủy bỏ");
        	        JButton confirmButton = new CustomButton("Thêm mới");
        	        // Add action listeners for the buttons
        	        confirmButton.addActionListener(new ActionListener() {
        	        	            	            @Override
            	            public void actionPerformed(ActionEvent e) {
            	                // Get the values from the text fields and combo boxes
            	                String[] values = new String[labels.length];
            	                for (int i = 0; i < labels.length; i++) {
            	                    if (labels[i].equals("Tên đại lý")) {
            	                        values[i] = (String)((CustomComboBox) inputs[i]).getSelectedItem();
            	                        
            	                    } else if (labels[i].equals("Ngày thu tiền")) {
            	                    	// values[i] = ((CustomTextField) inputs[i]).getText();
            	                    } else {
            	                        values[i] = ((CustomTextField) inputs[i]).getText();
            	                        if (values[i].isEmpty()) {
            	                            JOptionPane.showMessageDialog(null, labels[i] + " không thể trống");
            	                            return;
            	                        }
            	                        if (labels[i].equals("Số tiền thu (VND)")) {
            	                            if (!values[i].matches("\\d+")) { // regex cho sdt
            	                                JOptionPane.showMessageDialog(null, "Số tiền thu không hợp lệ");
            	                                return;
            	                            }
            	                            int money = Integer.parseInt(values[i]);
            	                            daily selectedAgent = dailyList.stream()
            	                                .filter(agent -> agent.getTendaily().equals((String)((CustomComboBox) inputs[0]).getSelectedItem()))
            	                                .findFirst()
            	                                .orElse(null);
            	                            if (selectedAgent != null && money > selectedAgent.getTienno()) {
            	                                JOptionPane.showMessageDialog(null, "Số tiền thu không thể lớn hơn tiền nợ của đại lý");
            	                                return;
            	                            }
            	                        }
            	                    }
            	                }
            	                // use the values array to pass to the database
            	                daily selectedAgent = dailyList.stream()
            	                    .filter(agent -> agent.getTendaily().equals(values[0]))
            	                    .findFirst()
            	                    .orElse(null);
            	                if (selectedAgent != null) {
            	                    selectedAgent.setTienno(selectedAgent.getTienno() - Integer.parseInt(values[5]));

									phieuthutien phieuThuTien = new phieuthutien(Integer.parseInt(values[5]), selectedAgent);
            	                    if(phieuThuTienController.createPhieuThuTien(phieuThuTien).contains("201")) {
            	                    	for (int i = 0; i < model.getRowCount(); i++) {
        									if (model.getValueAt(i, 1).equals(selectedAgent.getTendaily())) {
        										model.setValueAt( selectedAgent.getTienno(), i,4 );
        										break;
        									}
        								}
            	                    	((Window) SwingUtilities.getRoot(popupPanel)).dispose();
            	                    	JOptionPane.showMessageDialog(null, "Lập phiếu thu tiền thành công");
            	                    }
            	                    else {
            	                    	JOptionPane.showMessageDialog(null, "Lập phiếu thu tiền thất bại");
            	                    }
            	                    
            	                }
        	        	   }
        	        });
					cancelButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Hide the popup
							((Window) SwingUtilities.getRoot(popupPanel)).dispose();
						}
					});
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

	public void loadData() {
		try {
			dailyList = daiLyController.showDaiLy();
			loaidailyList = loaiDaiLyController.showLoaiDaiLy();
			quanList = quanController.showQuan();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
