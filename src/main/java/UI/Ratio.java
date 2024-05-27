package UI;

import Controller.ThamSoController;

import javax.swing.*;

public class Ratio extends javax.swing.JDialog{
private javax.swing.JButton btnOK;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblNewLabel;
    private javax.swing.JTextField textField;
    private String newRatio;

    public Ratio(String currentRatio) {
        setBounds(100, 100, 300, 150);
        getContentPane().setLayout(new java.awt.BorderLayout());

        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);
        contentPanel.setLayout(new java.awt.FlowLayout());

        lblNewLabel = new javax.swing.JLabel("Tỉ lệ mới:");
        contentPanel.add(lblNewLabel);

        textField = new javax.swing.JTextField(currentRatio);
        contentPanel.add(textField);
        textField.setColumns(10);

        javax.swing.JPanel buttonPane = new javax.swing.JPanel();
        getContentPane().add(buttonPane, java.awt.BorderLayout.SOUTH);
        buttonPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));

        btnOK = new javax.swing.JButton("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                newRatio = textField.getText();
                ThamSoController thamSoController = new ThamSoController();
                thamSoController.updateTyLeDonGiaXuat(Integer.parseInt(newRatio));
                dispose();
            }
        });
        buttonPane.add(btnOK);

        btnCancel = new javax.swing.JButton("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancel);
    }

    public String getNewRatio() {
        return newRatio;
    }
    public static void main(String[] args) {
        try {
            Ratio dialog = new Ratio("1");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

}}
