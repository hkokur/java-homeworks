/*
Name Surname = Hakkı Kokur
NO = 150120033
*/

import java.util.Calendar;

public class Product {
    private String productName;
    private java.util.Calendar saleDate;
    private double price;

    Product(String productName, java.util.Calendar saleDate, double price){
        setProductName(productName);
        setSaleDate(saleDate);
        setPrice(price);
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductName(){
        return productName;
    }

    public void setSaleDate(java.util.Calendar saleDate){
        this.saleDate = saleDate;
    }

    public java.util.Calendar getSaleDate(){
        return saleDate;
    }

    public String gSaleDate(){
        return "" + saleDate.get(Calendar.DAY_OF_MONTH) + "/" + saleDate.get(Calendar.MONTH) + "/" + saleDate.get(Calendar.YEAR);
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
    
}
