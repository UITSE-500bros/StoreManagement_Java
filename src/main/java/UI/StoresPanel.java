package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StoresPanel() {
		setOpaque(false);
		GridBagLayout gbl = new GridBagLayout();
		gbl.rowWeights = new double[] { 1.0, 15.0 }; // row 1 will take up 1/8 of the vertical space of row 2
		gbl.columnWeights = new double[] { 1.0, 1.0 }; // column 1 will take up 1/8 of the horizontal space of column 2
		setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;

		JLabel titleLabel = new JLabel("Đại Lý");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		titleLabel.setPreferredSize(new Dimension(180, 20));
		gbc.gridx = 0; // place titleLabel in column 1
		gbc.gridy = 0; // place titleLabel in row 1
		gbc.insets = new Insets(0, 20, 0, 0);
		add(titleLabel, gbc);

		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(Color.RED);
		accountPanel.setPreferredSize(new Dimension(20, 10));
		gbc = new GridBagConstraints();
		gbc.gridx = 1; // place accountPanel in column 2
		gbc.gridy = 0; // place accountPanel in row 1
		add(accountPanel, gbc);

		CustomPanel storesListPanel = new CustomPanel();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0; // place storesListPanel in column 1
		gbc.gridy = 1; // place storesListPanel in row 2
		gbc.gridwidth = 2; // storesListPanel will span both columns
		gbc.insets = new Insets(30, 25, 30, 25);
		add(storesListPanel, gbc);

		GridBagLayout gbl_storesListPanel = new GridBagLayout();
		gbl_storesListPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_storesListPanel.rowWeights = new double[] { 1.0, 1.0, 8.0 };

		storesListPanel.setLayout(gbl_storesListPanel);
		JLabel listTitle = new JLabel("Danh sách các đại lý");
		listTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 20, 0, 0);
		storesListPanel.add(listTitle, gbc);

		JLabel addStoreLabel = new JLabel("Thêm đại lý");
		addStoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 20);
		storesListPanel.add(addStoreLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 8;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 20, 0, 20);

		String[] columnNames = { "Số thứ tự", "Tên đại lý", "Loại", "Quận", "Tiền nợ" };

		// Create data
		Object[][] data = { { 1, "Đại lý 1", "Loại 1", "Quận 1", 1000.0 },
				{ 2, "Đại lý 2", "Loại 2", "Quận 2", 2000.0 },
				// Add more rows as needed
		};

		// Create table model
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		// Create table
		JTable table = new JTable(model);

		table.setOpaque(false);
		((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);

		// Set font and alignment
		table.setFont(new Font("Serif", Font.PLAIN, 20));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Create scroll pane (to make the table scrollable)
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		storesListPanel.add(scrollPane, gbc);
	}

}
