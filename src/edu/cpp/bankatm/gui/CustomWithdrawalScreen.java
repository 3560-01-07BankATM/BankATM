/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.bankatm.gui;

import edu.cpp.bankatm.Controller;

/**
 * @author Abdullah K
 */
public class CustomWithdrawalScreen extends javax.swing.JFrame {

    /**
     * Creates new form CustomWithdrawalScreen
     */
    public CustomWithdrawalScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * <p>
     * COMPONENTS OF FORM ARE LOCATED IN initComponents() method
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customWithdrawLabel = new javax.swing.JLabel();
        customWithdrawPanel = new javax.swing.JPanel();
        enterWithdrawalLabel = new javax.swing.JLabel();
        customWithdrawAmountField = new javax.swing.JTextField();
        completeWithdrawalButton = new javax.swing.JButton();
        backToMenuButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customWithdrawLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        customWithdrawLabel.setText("CUSTOM WITHDRAWAL");

        enterWithdrawalLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterWithdrawalLabel.setText("Enter Amount of Withdrawal:");

        javax.swing.GroupLayout customWithdrawPanelLayout = new javax.swing.GroupLayout(customWithdrawPanel);
        customWithdrawPanel.setLayout(customWithdrawPanelLayout);
        customWithdrawPanelLayout.setHorizontalGroup(
                customWithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customWithdrawPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(enterWithdrawalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customWithdrawAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        customWithdrawPanelLayout.setVerticalGroup(
                customWithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customWithdrawPanelLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(customWithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enterWithdrawalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customWithdrawAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        completeWithdrawalButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        completeWithdrawalButton.setText("Complete Withdrawal");
        completeWithdrawalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeWithdrawalButtonActionPerformed(evt);
            }
        });

        backToMenuButton3.setText("main menu");
        backToMenuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(176, 176, 176)
                                                .addComponent(customWithdrawLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(165, 165, 165)
                                                .addComponent(customWithdrawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(309, 309, 309)
                                                .addComponent(completeWithdrawalButton)))
                                .addContainerGap(165, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backToMenuButton3)
                                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(customWithdrawLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customWithdrawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(completeWithdrawalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backToMenuButton3)
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void completeWithdrawalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeWithdrawalButtonActionPerformed
        Controller.withdrawCustom(this);
        //will confirm the withdrawal and subtract dollar ampount from customer account balance (will be fully implemented and show confirmation screen once database is fully complete)
    }//GEN-LAST:event_completeWithdrawalButtonActionPerformed

    private void backToMenuButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButton3ActionPerformed
        Controller.backButton(this);
        
        //new MenuScreen().setVisible(true);  //will return to main menu and dispose of current screen
        //dispose();
    }//GEN-LAST:event_backToMenuButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenuButton3;
    private javax.swing.JButton completeWithdrawalButton;
    private javax.swing.JTextField customWithdrawAmountField;
    private javax.swing.JLabel customWithdrawLabel;
    private javax.swing.JPanel customWithdrawPanel;
    private javax.swing.JLabel enterWithdrawalLabel;

    public int getWithdrawAmount() {
        if (customWithdrawAmountField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(customWithdrawAmountField.getText());
    }
    // End of variables declaration//GEN-END:variables
}
