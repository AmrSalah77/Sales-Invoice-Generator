/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amr
 */
public class InvoiceLineTableModel extends AbstractTableModel{
    private ArrayList<InvoiceLine> items;
    private String[] columnsNames = {"No.", "Item Name", "Item Price", "Count", "Item Total"};

    public InvoiceLineTableModel(ArrayList<InvoiceLine> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
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
        InvoiceLine line = items.get(row);
        switch (column) {
            case 0:
                return ++row;
            case 1:
                return line.getItemName();
            case 2:
                return line.getItemPrice();
            case 3: 
                return line.getCount();
            case 4:
                return line.itemTotal();
        }
        return "";
    }
}
