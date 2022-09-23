/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import view.SIG_MainFrame;

/**
 *
 * @author Amr
 */
public class InvoiceHeaderTableModel extends AbstractTableModel{
    
    private ArrayList<InvoiceHeader> invoiceHeaders;
    private String[] columnsNames = {"No.", "Date", "Customer", "Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> invoiceHeaders) {
        this.invoiceHeaders = invoiceHeaders;
    }

    
    @Override
    public int getRowCount() {
       return invoiceHeaders.size();
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnsNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        InvoiceHeader header = invoiceHeaders.get(row);
        switch (column) {
            case 0:
                return header.getInvoiceNum();
            case 1:
                return SIG_MainFrame.dateFormat.format(header.getInvoiceDate());
            case 2: 
                return header.getCustomerName();
            case 3:
                return header.getInvoiceTotal();
        }
        return "";
    }
    }
