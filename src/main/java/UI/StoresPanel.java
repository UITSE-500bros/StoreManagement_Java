package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ReuseClass.DatePicker;
import javax.swing.table.*;
public class StoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc1_1;
	private GridBagConstraints gbc1_2;
	private GridBagConstraints gbc1_3;
	private GridBagConstraints gbc1_4;
	private JButton addButton;
	private DatePicker datePicker;
	/**
	 * Create the panel.
	 */
	public StoresPanel() {
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

		gbc1_4 = new GridBagConstraints();
		gbc1_4.insets = new Insets(0, 0, 5, 5);
		gbc1_4.anchor = GridBagConstraints.WEST;
		datePicker = new DatePicker();
		datePicker.setFont(new Font("Roboto", Font.PLAIN, 20));
		gbc1_4.gridx = 0;
		gbc1_4.gridy = 1;
		gbc1_4.weightx = 0.1;
		gbc1_4.anchor = GridBagConstraints.WEST;
		contentPane.add(datePicker, gbc1_4);

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
        String[] columnNames = {"STT", "Tên đại lý", "Loại", "Quận", "Tiền nợ"};

        // Create data
        Object[][] data = {
            {1, "Đại lý 1", "Loại 1", "Quận 1", 1000.0},
            {2, "Đại lý 2", "Loại 2", "Quận 2", 2000.0},
            // Add more rows as needed
        };

     // Create table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // This causes all cells to be not editable
            }
        };

        // Create table
        JTable table = new JTable(model);

        // Set column widths
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i = 0; i < table.getColumnCount(); i++) {
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
	}

}
