/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLine;
import model.InvoiceLineTableModel;
import view.NewInvoiceHeaderDialog;
import view.NewInvoiceLineDialog;
import view.SIG_MainFrame;

/**
 *
 * @author Amr
 */
public class Controller implements ActionListener, ListSelectionListener{

    private SIG_MainFrame mainFrame;
    private NewInvoiceHeaderDialog headerFrame;
    private NewInvoiceLineDialog lineFrame;
    
    public Controller(SIG_MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public Controller(NewInvoiceHeaderDialog headerFrame) {
        this.headerFrame = headerFrame;
    }
    
    public Controller(NewInvoiceLineDialog lineFrame) {
        this.lineFrame = lineFrame;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int rowIndex = mainFrame.getInvoicesTable().getSelectedRow();
        InvoiceHeader header = mainFrame.getInvoicesHeader().get(rowIndex);
        mainFrame.setLineTableModel(new InvoiceLineTableModel(header.getItems()));
        mainFrame.getInvoiceNumlLabelVal().setText(""+header.getInvoiceNum());
        mainFrame.getDateLabelVal().setText(mainFrame.dateFormat.format(header.getInvoiceDate()));
        mainFrame.getCustomerNameLabelVal().setText(header.getCustomerName());
        mainFrame.getInvoiceTotalLabelVal().setText(""+header.getInvoiceTotal());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Load File":
                LoadFile(null,null);
                break;
            case "Save File":
                SaveFile();
                break;
        }
    }

    public void LoadFile(String Pathheader, String pathLine) {
        File invoiceHeaderFile = null;
        File invoiceLineFile = null;
        
        // if load file called from menu button
        if (Pathheader == null && pathLine == null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(mainFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                invoiceHeaderFile = fileChooser.getSelectedFile();
                result = fileChooser.showOpenDialog(mainFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    invoiceLineFile = fileChooser.getSelectedFile();
                }
            }
            
          //if load file called on start  
        } else {
            invoiceHeaderFile = new File(Pathheader);
            invoiceLineFile = new File(pathLine);
        }

        if (invoiceHeaderFile != null && invoiceLineFile != null) {
            try {
                // read each line of header file
                List<String> invoicesHeaders = Files.lines(Paths.get(invoiceHeaderFile.getAbsolutePath())).collect(Collectors.toList());
                // read each line of line file
                List<String> invoiceLines = Files.lines(Paths.get(invoiceLineFile.getAbsolutePath())).collect(Collectors.toList());
                mainFrame.getInvoicesHeader().clear();
                for (String headerLine : invoicesHeaders) {
                    //split lines to num, date, Name
                    String[] columns = headerLine.split(",");
                    int invoiceNum = Integer.parseInt(columns[0]);
                    String dateString = columns[1];
                    String customerName = columns[2];
                    Date date = mainFrame.dateFormat.parse(dateString);
                    InvoiceHeader header = new InvoiceHeader(invoiceNum, date, customerName);
                    mainFrame.getInvoicesHeader().add(header);
                }
                for (String lineLine : invoiceLines) {
                    //split lines to num, Name, price, count
                    String[] columns = lineLine.split(",");
                    int itemNum = Integer.parseInt(columns[0]);
                    String itemName = columns[1];
                    double itemPrice = Double.parseDouble(columns[2]);
                    int count = Integer.parseInt(columns[3]);
                    InvoiceHeader header = mainFrame.getInvoiceHeader(itemNum);
                    InvoiceLine line = new InvoiceLine(itemName, itemPrice, count, header);
                    header.getItems().add(line);
                }
                mainFrame.setHeaderTableModel(new InvoiceHeaderTableModel(mainFrame.getInvoicesHeader()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void SaveFile() {
           
        }
}
