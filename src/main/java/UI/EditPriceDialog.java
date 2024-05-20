package UI;

// Class mới: EditPriceDialog
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPriceDialog extends JDialog {
    private JTextField textField;
    private String newPrice;

    public EditPriceDialog(String currentPrice) {
        setBounds(100, 100, 300, 150);
        getContentPane().setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new FlowLayout());

        JLabel lblNewLabel = new JLabel("Đơn giá nhập mới:");
        contentPanel.add(lblNewLabel);

        textField = new JTextField(currentPrice);
        contentPanel.add(textField);
        textField.setColumns(10);

        JPanel buttonPane = new JPanel();
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newPrice = textField.getText();
                dispose();
            }
        });
        buttonPane.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }

    public String getNewPrice() {
        return newPrice;
    }
}