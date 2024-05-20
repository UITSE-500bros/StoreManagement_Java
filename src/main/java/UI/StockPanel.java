package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Controller.DaiLyController;
import Models.daily;
import Models.loaidaily;
import Models.quan;


public class StockPanel extends CustomPanel {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc1_1;
	private GridBagConstraints gbc1_2;
	private GridBagConstraints gbc1_3;
	private GridBagConstraints gbc1_4;

	/**
	 * Create the panel.
	 */
	public StockPanel() {
		
       
		String[] sortItems = {"Sắp xếp theo", "Số lượng tăng dần", "Số lượng giảm dần", "Đơn giá tăng dàn", "Đơn giá giảm dần" };
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
		JLabel headerLable = new JLabel("Tồn Kho");
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

		JLabel pnhLable = new JLabel("Danh sách hàng hóa");
		pnhLable.setFont(new Font("Roboto", Font.BOLD, 22));
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.weightx = 0.8;
		gbc1.anchor = GridBagConstraints.WEST;
		contentPane.add(pnhLable, gbc1);

		


		
        
		
		
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
		searchField.setPlaceholder("Tên mặt hàng");
		filterPanel.add(searchField);
		
		
		
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
        String[] columnNames = {"STT", "Tên mặt hàng", "Số lượng", "Đơn vị tính", "Đơn giá (VND)"};

        
       

     // Create table model
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
        // Create data
		
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
            case 1: width = 300; break; // Tên mặt hàng
            case 2: width = 50; break; // Số lượng
            case 3: width = 50; break; // Đơn vị tính
            case 4: width = 150; break; // Đơn giá
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
         
         
        	
        	
        	sortFilterComboBox.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent e) {
        	        if (e.getStateChange() == ItemEvent.SELECTED) {
        	            String selected = (String) e.getItem();
        	            TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) ((DefaultRowSorter)table.getRowSorter());
        	            if (selected.equals("Số lượng tăng dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING))); // 2 is the column index for quantity
        	            } else if (selected.equals("Số lượng giảm dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.DESCENDING))); // 2 is the column index for quantity
        	            }
        	            else if (selected.equals("Đơn giá tăng dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING))); // 4 is the column index for price
        	            } else if (selected.equals("Đơn giá giảm dần")) {
        	                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING))); // 4 is the column index for price
        	            }
        	            table.setRowSorter(sorter);
        	        }
        	    }
        	});
    
    // Add action listener for the "Tiếp nhận đại lý" button     
         
		
		
		

	}

}
