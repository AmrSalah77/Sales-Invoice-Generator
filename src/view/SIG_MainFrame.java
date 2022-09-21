/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Amr
 */
public class SIG_MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form SIG_MainFrame
     */
    public SIG_MainFrame() {
        initComponents();
        Controller controller = new Controller();
        deleteLineButton.setActionCommand("Cancel");
        deleteLineButton.addActionListener(controller);
        newLineButton.setActionCommand("Save");
        newLineButton.addActionListener(controller);
        createNewInvoiceButton.setActionCommand("Create");
        createNewInvoiceButton.addActionListener(controller);
        deleteInvoiceButton.setActionCommand("Delete");
        deleteInvoiceButton.addActionListener(controller);
        saveFile.setActionCommand("Save File");
        saveFile.addActionListener(controller);
        openFile.setActionCommand("Open File");
        openFile.addActionListener(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createNewInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        newLineButton = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoiceNumlLabel = new javax.swing.JLabel();
        invoiceNumlLabelVal = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        InvoiceTotalLabelVal = new javax.swing.JLabel();
        DateLabelVal = new javax.swing.JLabel();
        CustomerNameLabelVal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceItemsTable = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        createNewInvoiceButton.setText("Create New Invoice");
        createNewInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceButtonActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed(evt);
            }
        });

        newLineButton.setText("New Item");
        newLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLineButtonActionPerformed(evt);
            }
        });

        deleteLineButton.setText("Delete Item");
        deleteLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineButtonActionPerformed(evt);
            }
        });

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        invoicesTable.setToolTipText("");
        jScrollPane1.setViewportView(invoicesTable);

        invoiceNumlLabel.setText("Invoice Number");

        invoiceNumlLabelVal.setText("-");

        invoiceDateLabel.setText("Invoice Date");

        customerNameLabel.setText("Customer Name");

        InvoiceTotalLabel.setText("Invoice Total");

        InvoiceTotalLabelVal.setText("-");

        DateLabelVal.setText("-");

        CustomerNameLabelVal.setText("-");

        invoiceItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(invoiceItemsTable);

        FileMenu.setText("File");

        openFile.setText("Load File");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        FileMenu.add(openFile);

        saveFile.setText("Save File");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        FileMenu.add(saveFile);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceTotalLabel)
                                    .addComponent(invoiceDateLabel)
                                    .addComponent(invoiceNumlLabel)
                                    .addComponent(customerNameLabel))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceNumlLabelVal)
                                    .addComponent(InvoiceTotalLabelVal)
                                    .addComponent(DateLabelVal)
                                    .addComponent(CustomerNameLabelVal)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(createNewInvoiceButton)
                        .addGap(61, 61, 61)
                        .addComponent(deleteInvoiceButton)
                        .addGap(170, 170, 170)
                        .addComponent(newLineButton)
                        .addGap(76, 76, 76)
                        .addComponent(deleteLineButton)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceNumlLabel)
                            .addComponent(invoiceNumlLabelVal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDateLabel)
                            .addComponent(DateLabelVal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerNameLabel)
                            .addComponent(CustomerNameLabelVal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceTotalLabelVal)
                            .addComponent(InvoiceTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createNewInvoiceButton)
                        .addComponent(deleteInvoiceButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteLineButton)
                        .addComponent(newLineButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openFileActionPerformed

    private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceButtonActionPerformed

    private void createNewInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceButtonActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileActionPerformed

    private void deleteLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteLineButtonActionPerformed

    private void newLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newLineButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SIG_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIG_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIG_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIG_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIG_MainFrame().setVisible(true);
            }
        });
    }

    public JMenu getFileMenu() {
        return FileMenu;
    }

    public void setFileMenu(JMenu FileMenu) {
        this.FileMenu = FileMenu;
    }

    public JLabel getInvoiceTotalLabel() {
        return InvoiceTotalLabel;
    }

    public void setInvoiceTotalLabel(JLabel InvoiceTotalLabel) {
        this.InvoiceTotalLabel = InvoiceTotalLabel;
    }

    public JLabel getInvoiceTotalLabelVal() {
        return InvoiceTotalLabelVal;
    }

    public void setInvoiceTotalLabelVal(JLabel InvoiceTotalLabelVal) {
        this.InvoiceTotalLabelVal = InvoiceTotalLabelVal;
    }


    public void setMenuBar(JMenuBar MenuBar) {
        this.MenuBar = MenuBar;
    }

    public JButton getCancelButton() {
        return deleteLineButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.deleteLineButton = cancelButton;
    }

    public JButton getCreateNewInvoiceButton() {
        return createNewInvoiceButton;
    }

    public void setCreateNewInvoiceButton(JButton createNewInvoiceButton) {
        this.createNewInvoiceButton = createNewInvoiceButton;
    }

    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public void setCustomerNameLabel(JLabel customerNameLabel) {
        this.customerNameLabel = customerNameLabel;
    }

    public JLabel getCustomerNameLabelVal() {
        return CustomerNameLabelVal;
    }

    public void setCustomerNameLabelVal(JLabel CustomerNameLabelVal) {
        this.CustomerNameLabelVal = CustomerNameLabelVal;
    }

    public JLabel getDateLabelVal() {
        return DateLabelVal;
    }

    public void setDateLabelVal(JLabel DateLabelVal) {
        this.DateLabelVal = DateLabelVal;
    }

    
   
    public JButton getDeleteInvoiceButton() {
        return deleteInvoiceButton;
    }

    public void setDeleteInvoiceButton(JButton deleteInvoiceButton) {
        this.deleteInvoiceButton = deleteInvoiceButton;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public void setInvoiceDateLabel(JLabel invoiceDateLabel) {
        this.invoiceDateLabel = invoiceDateLabel;
    }

    public JTable getInvoiceItemsTable() {
        return invoiceItemsTable;
    }

    public void setInvoiceItemsTable(JTable invoiceItemsTable) {
        this.invoiceItemsTable = invoiceItemsTable;
    }

    public JLabel getInvoiceNumlLabel() {
        return invoiceNumlLabel;
    }

    public void setInvoiceNumlLabel(JLabel invoiceNumlLabel) {
        this.invoiceNumlLabel = invoiceNumlLabel;
    }

    public JLabel getInvoiceNumlLabelVal() {
        return invoiceNumlLabelVal;
    }

    public void setInvoiceNumlLabelVal(JLabel invoiceNumlLabelVal) {
        this.invoiceNumlLabelVal = invoiceNumlLabelVal;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public void setInvoicesTable(JTable invoicesTable) {
        this.invoicesTable = invoicesTable;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JMenuItem getOpenFile() {
        return openFile;
    }

    public void setOpenFile(JMenuItem openFile) {
        this.openFile = openFile;
    }

    public JButton getSaveButton() {
        return newLineButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.newLineButton = saveButton;
    }

    public JMenuItem getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(JMenuItem saveFile) {
        this.saveFile = saveFile;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerNameLabelVal;
    private javax.swing.JLabel DateLabelVal;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JLabel InvoiceTotalLabelVal;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton createNewInvoiceButton;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JTable invoiceItemsTable;
    private javax.swing.JLabel invoiceNumlLabel;
    private javax.swing.JLabel invoiceNumlLabelVal;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newLineButton;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
}
