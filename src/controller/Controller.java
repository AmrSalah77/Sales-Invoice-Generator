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
import java.text.ParseException;
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
    
    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int rowIndex = mainFrame.getInvoicesTable().getSelectedRow();
        if (rowIndex != -1) {
        InvoiceHeader header = mainFrame.getInvoicesHeader().get(rowIndex);
        mainFrame.setLineTableModel(new InvoiceLineTableModel(header.getItems()));
        mainFrame.getInvoiceNumlLabelVal().setText(""+header.getInvoiceNum());
        mainFrame.getDateLabelVal().setText(mainFrame.dateFormat.format(header.getInvoiceDate()));
        mainFrame.getCustomerNameLabelVal().setText(header.getCustomerName());
        mainFrame.getInvoiceTotalLabelVal().setText(""+header.getInvoiceTotal());
         }
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
            case "Create Invoice":
                createInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New item":
                newItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "Save Header":
                saveHeader();
                break;
            case "Cancel Header":
                cancelHeader();
                break;
            case "Save Item":
                saveItem();
                break;
            case "Cancel Item":
                cancelItem();
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
                    Date date = mainFrame.dateFormat.parse(columns[1]);
                    String customerName = columns[2];
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
            try {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(mainFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File invoiceHeaderFile = fileChooser.getSelectedFile();
                //add .csv extension    
                if(!invoiceHeaderFile.getName().endsWith(".csv"))
                    invoiceHeaderFile = new File(invoiceHeaderFile.toString() + ".csv");
                FileWriter headerWriter = new FileWriter(invoiceHeaderFile);
                ArrayList<InvoiceHeader> invoicesHeaders = mainFrame.getInvoicesHeader();
                String headers = "";
                String items = "";

                for (InvoiceHeader header : invoicesHeaders) {
                    headers += header.toString() + "\n";
                    for (InvoiceLine line : header.getItems()) {
                        items += line.toString() + "\n";
                        }
                    }
                
                result = fileChooser.showSaveDialog(this.mainFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File invoiceLineFile = fileChooser.getSelectedFile();
                //add .csv extension    
                if(!invoiceLineFile.getName().endsWith(".csv"))
                    invoiceLineFile = new File(invoiceLineFile.toString() + ".csv");
                FileWriter itemsWriter = new FileWriter(invoiceLineFile);
                //write headers to file
                headerWriter.write(headers);
                headerWriter.close();
                //write items to file
                itemsWriter.write(items);
                itemsWriter.close();
                    }
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this.mainFrame, "File cannot be opened", "File not found", JOptionPane.ERROR_MESSAGE);
            }
        }

    private void createInvoice() {
        headerFrame = new NewInvoiceHeaderDialog(mainFrame, true);  
        headerFrame.setVisible(true);
    }

    private void deleteInvoice() {
        int row = mainFrame.getInvoicesTable().getSelectedRow();
            if (row != -1 ){
                mainFrame.getInvoicesHeader().remove(row);
                mainFrame.getHeaderTableModel().fireTableDataChanged();
                mainFrame.getInvoicesTable().selectAll();
            }
    }

    private void newItem() {
        int row = mainFrame.getInvoicesTable().getSelectedRow();
        if(row != -1){
        lineFrame = new NewInvoiceLineDialog(mainFrame, true);
        lineFrame.setVisible(true);}
    }

    private void deleteItem() {
        int headerRow = mainFrame.getInvoicesTable().getSelectedRow();
        int itemRow = mainFrame.getInvoiceItemsTable().getSelectedRow();
        
        if (headerRow != -1 && itemRow != -1 ){
                InvoiceHeader invoice = mainFrame.getInvoicesHeader().get(headerRow);
                invoice.getItems().remove(itemRow);
                mainFrame.getLineTableModel().fireTableDataChanged();
                mainFrame.getHeaderTableModel().fireTableDataChanged();
            }
        
        mainFrame.getInvoicesTable().addRowSelectionInterval(headerRow, headerRow);
    }

    private void saveHeader() {
        String customerName = headerFrame.getCustomerNameVal().getText();
        int headerNum = mainFrame.getHeaderTableModel().getRowCount() + 1;
        try {
            Date date = mainFrame.dateFormat.parse(headerFrame.getDateVal().getText());
            InvoiceHeader header = new InvoiceHeader(headerNum, date, customerName);
            mainFrame.getInvoicesHeader().add(header);
            mainFrame.getHeaderTableModel().fireTableDataChanged();
            
            headerFrame.setVisible(false);
            headerFrame.dispose();
            headerFrame = null ; 
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(mainFrame, "Date should be 'dd-mm-yyyy'", "Parse Error", JOptionPane.ERROR_MESSAGE);
            }  
    }
    
    private void cancelHeader() {
        headerFrame.setVisible(false);
        headerFrame.dispose();
        headerFrame = null ; 
    }

    private void saveItem() {
        int row = mainFrame.getInvoicesTable().getSelectedRow();
        if(row != -1){
            InvoiceHeader header = mainFrame.getInvoicesHeader().get(row);
            String itemName = lineFrame.getItemNameVal().getText();
            double price = Double.parseDouble(lineFrame.getItemPriceVal().getText());
            int count = Integer.parseInt(lineFrame.getItemCountVal().getText());
            InvoiceLine line = new InvoiceLine(itemName, price, count, header);
            header.getItems().add(line);
            mainFrame.getLineTableModel().fireTableDataChanged();
            mainFrame.getHeaderTableModel().fireTableDataChanged();
        }  

        lineFrame.setVisible(false);
        lineFrame.dispose();
        lineFrame = null ; 
        mainFrame.getInvoicesTable().addRowSelectionInterval(row, row);
    }
    

    private void cancelItem() {
        lineFrame.setVisible(false);
        lineFrame.dispose();
        lineFrame = null ; 
    }
}
