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
public class DepositScreen extends javax.swing.JFrame {

    /**
     * Creates new form DepositScreen
     */
    public DepositScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        billsPanel = new javax.swing.JPanel();
        oneDollarLabel = new javax.swing.JLabel();
        fiveDollarLabel = new javax.swing.JLabel();
        tenDollarLabel = new javax.swing.JLabel();
        twentyDollarLabel = new javax.swing.JLabel();
        fiftyDollarLabel = new javax.swing.JLabel();
        hundredDollarLabel = new javax.swing.JLabel();
        numOnesField = new javax.swing.JTextField();
        numFivesField = new javax.swing.JTextField();
        numTensField = new javax.swing.JTextField();
        numTwentiesField = new javax.swing.JTextField();
        numFiftiesField = new javax.swing.JTextField();
        numHundredsField = new javax.swing.JTextField();
        depositAmountLabel = new javax.swing.JLabel();
        completeDepositButton = new javax.swing.JButton();
        backToMenuButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oneDollarLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        oneDollarLabel.setText("Number of $1 Bills:");

        fiveDollarLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fiveDollarLabel.setText("Number of $5 Bills:");

        tenDollarLabel.setText("Number of $10 Bills:");

        twentyDollarLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        twentyDollarLabel.setText("Number of $20 Bills:");

        fiftyDollarLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fiftyDollarLabel.setText("Number of $50 Bills:");

        hundredDollarLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hundredDollarLabel.setText("Number of $100 Bills:");

        javax.swing.GroupLayout billsPanelLayout = new javax.swing.GroupLayout(billsPanel);
        billsPanel.setLayout(billsPanelLayout);
        billsPanelLayout.setHorizontalGroup(
                billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(billsPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(billsPanelLayout.createSequentialGroup()
                                                .addComponent(twentyDollarLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numTwentiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fiftyDollarLabel))
                                        .addGroup(billsPanelLayout.createSequentialGroup()
                                                .addComponent(oneDollarLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numOnesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(fiveDollarLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numFivesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numFiftiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(billsPanelLayout.createSequentialGroup()
                                                .addComponent(tenDollarLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numTensField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(billsPanelLayout.createSequentialGroup()
                                                .addComponent(hundredDollarLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numHundredsField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        billsPanelLayout.setVerticalGroup(
                billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(billsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(oneDollarLabel)
                                        .addComponent(fiveDollarLabel)
                                        .addComponent(tenDollarLabel)
                                        .addComponent(numOnesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numFivesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numTensField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addGroup(billsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(twentyDollarLabel)
                                        .addComponent(fiftyDollarLabel)
                                        .addComponent(hundredDollarLabel)
                                        .addComponent(numTwentiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numFiftiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numHundredsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        depositAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        depositAmountLabel.setText("ENTER DEPOSIT AMOUNT");

        completeDepositButton.setText("Complete Deposit");
        completeDepositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeDepositButtonActionPerformed(evt);
            }
        });

        backToMenuButton1.setText("Main Menu");
        backToMenuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(completeDepositButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(123, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(billsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(110, 110, 110))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(depositAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(145, 145, 145))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(backToMenuButton1)
                                                .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(depositAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(billsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(completeDepositButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backToMenuButton1)
                                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void completeDepositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeDepositButtonActionPerformed
        // TODO add your handling code here:
        Controller.deposit(this);
        //will complete the deposit and update bill amounts and account balance (once database is fully implemented)
    }//GEN-LAST:event_completeDepositButtonActionPerformed

    private void backToMenuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButton1ActionPerformed
        // TODO add your handling code here:
        Controller.backButton(this); //will return to the main menu and dispose of current screen
    }//GEN-LAST:event_backToMenuButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenuButton1;
    private javax.swing.JPanel billsPanel;
    private javax.swing.JButton completeDepositButton;
    private javax.swing.JLabel depositAmountLabel;
    private javax.swing.JLabel fiftyDollarLabel;
    private javax.swing.JLabel fiveDollarLabel;
    private javax.swing.JLabel hundredDollarLabel;
    private javax.swing.JTextField numFiftiesField;
    private javax.swing.JTextField numFivesField;
    private javax.swing.JTextField numHundredsField;
    private javax.swing.JTextField numOnesField;
    private javax.swing.JTextField numTensField;
    private javax.swing.JTextField numTwentiesField;
    private javax.swing.JLabel oneDollarLabel;
    private javax.swing.JLabel tenDollarLabel;
    private javax.swing.JLabel twentyDollarLabel;
    // End of variables declaration//GEN-END:variables

    public int getOnes() {
        if (numOnesField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numOnesField.getText());
    }

    public int getFives() {
        if (numFivesField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numFivesField.getText());
    }

    public int getTens() {
        if (numTensField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numTensField.getText());
    }

    public int getTwenties() {
        if (numTwentiesField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numTwentiesField.getText());
    }

    public int getFifties() {
        if (numFiftiesField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numFiftiesField.getText());
    }

    public int getHundreds() {
        if (numHundredsField.getText().equalsIgnoreCase("")) return 0;
        return Integer.parseInt(numHundredsField.getText());
    }
}
