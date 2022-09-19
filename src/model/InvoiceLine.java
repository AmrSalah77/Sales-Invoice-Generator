/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Amr
 */
public class InvoiceLine {
    private String itemName; 
    private double itemPrice;
    private int itemNum;
    private int count;

    public InvoiceLine(String itemName, double itemPrice, int itemNum, int count) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemNum = itemNum;
        this.count = count;
    }
    
    //caculate each item total price
    public double itemTotal(){
        return itemPrice*count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemNum=" + itemNum + ", count=" + count + '}';
    }
    
    
}
